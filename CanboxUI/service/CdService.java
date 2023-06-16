package com.landsem.canboxui.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.LSCarAudioAuxManager;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;

import com.landsem.canbox.CanBoxApp;
import com.landsem.canbox.Constant;
import com.landsem.canbox.ProtocolID;
import com.landsem.canbox.bean.CDInfo;
import com.landsem.canbox.bean.RadarInfo;
import com.landsem.canbox.bean.RoleBean;
import com.landsem.canbox.manager.SerialManager;
import com.landsem.canbox.observer.CDObserver;
import com.landsem.canbox.tools.ProtocoChoicelUtils;
import com.landsem.canboxui.aidl.DVDInfo;
import com.landsem.canboxui.aidl.MediaInfo;
import com.landsem.canboxui.aidl.PhoneInfo;
import com.landsem.canboxui.aidl.PushInfor;
import com.landsem.canboxui.aidl.RadioInfo;
import com.landsem.canboxui.dialog.AlarmNotify;
import com.landsem.canboxui.myinterface.CdInterface;
import com.landsem.canboxui.myinterface.CdInterfaceCallback;
import com.landsem.canboxui.utils.CdUtil;
import com.landsem.canboxui.utils.ConstantUtil;
import com.landsem.common.tools.LogManager;
import com.landsem.common.tools.StringUtils;
import com.landsem.dvr.TurnDetect;

public class CdService extends  Service  {
	
	private static final String SCREEN_OFF = "android.intent.SCREEN_OFF";
	private static final String SCREEN_ON = "android.intent.SCREEN_ON";
	private LSCarAudioAuxManager mAudioAuxManager;
	AudioManager mAudioManager= null;
	Context mContext;
	CdInterfaceCallback mCdUICallback;
	/***休眠前CD是否在播放*/
	private boolean isPlayBefore = false;
	boolean isPlay = false;
	boolean isPause = false;
	/*** CD是否正常 */
	private boolean isCdOk = false;
	/***命令类型 */
	private byte comIdType = Constant.Mazda.DATA_DEVICE_INFO;
	byte repeat = Constant.CD_RPT_CLOSE;
	private boolean eStatus;
	CdControl mCdControl = null;
	private SystemSleep mSystemSleep;
	private CDHandlerLisener cdHandlerLisener;
	private Handler handler;
	PushInfor mPushInfor;
	CDInfo mCDInfo;

	
	@Override
	public void onCreate() {
		super.onCreate();
		mContext = this;
		cdHandlerLisener = new CDHandlerLisener();
		handler = new Handler(cdHandlerLisener);
		SerialManager.getInstance().onCDObserver(cdHandlerLisener, new RoleBean());
		mAudioAuxManager = new LSCarAudioAuxManager(mContext);
		mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
		mCdControl = new CdControl();
		mSystemSleep = new SystemSleep();
		mSystemSleep.registSleepReceiver(mContext);
		AlarmNotify.notificationMethod(AlarmNotify.NULL_NOTIFY,"",mContext);
		bindPushService();
		LogManager.d(ConstantUtil.TAG,"CdService  onCreate");
	}
	
	private void bindPushService() {
		Intent intent = new Intent(mContext, PushService.class);
		bindService(intent, PushConnection, Context.BIND_AUTO_CREATE);
	}
	
	private ServiceConnection PushConnection = new ServiceConnection() {
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			LogManager.d(ConstantUtil.TAG,"Push onServiceConnected name: " + name);
			mPushInfor = PushInfor.Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			LogManager.d(ConstantUtil.TAG,"Push onServiceDisconnected name: " + name);
			mPushInfor = null;
		}
	};

	@Override
	public IBinder onBind(Intent arg0) {
		return mCdControl;
	}
	
	public void startPrepareCD() {
		sendPrepareCD();
		initCdState();
	}
	
	public void sendPrepareCD() {
		CdUtil.startDisc(CanBoxApp.getMyPID());
	}
	
	public void reqCdPlayState() {
		CdUtil.reqCdPlayState(CanBoxApp.getMyPID());
	}
	
	public void sendPlayAndPushOrder() {
		if (getAudioFocus()) {
			eStatus = true;
			CdUtil.playSong(CanBoxApp.getMyPID());
			sendPushOrder();
		}
	}
	
	private void sendPushOrder() {
		if (mCDInfo == null||mPushInfor == null) {
			return;
		}
		DVDInfo mDVDInfo = new DVDInfo();
		mDVDInfo.mSource = "Disc";
		mDVDInfo.mCurSone = mCDInfo.getCurSong();
		mDVDInfo.mTotalSone = mCDInfo.getAllSongNum();
		mDVDInfo.mMillisecond = mCDInfo.getSongAllTime()*1000;
		try {
			mPushInfor.sendDVDInfo(mDVDInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		RadioInfo mRadioInfo = new RadioInfo();
//		mRadioInfo.mBand = "FM";
//		mRadioInfo.mFreq = 38400;
//		PhoneInfo mPhoneInfo = new PhoneInfo();
//		mPhoneInfo.mPnoneNum = "15915454371";
//		MediaInfo mMediaInfo  = new MediaInfo();
//		mMediaInfo.mSource = "USB";
//		mMediaInfo.mFileNum= 3;
//		mMediaInfo.mFoldNum = 2;
//		mMediaInfo.mMillisecond = 104000;
//		
//		try {
//			mPushInfor.sendMediaInfo(mMediaInfo);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public void sendPauseOrder() {
		eStatus = false;
		CdUtil.pauseSong(CanBoxApp.getMyPID());
	}
	
	public void setRepeatMode() {
		CdUtil.repeatMode(CanBoxApp.getMyPID(), repeat);
	}
	
	public void reqCdPlayContent() {
		CdUtil.reqCdPlayContent(CanBoxApp.getMyPID());
	}

	public void initCdState() {
		if (!isCdOk) {
			if (!isPlay) {
				reqCdDeviceState();
			}
		} else {
			if (!isPlay) {
				sendPlayAndPushOrder();
			}
		}
	}
	
	private void reqCdDeviceState() {
		eStatus = true;
		CdUtil.reqCdDeviceState(CanBoxApp.getMyPID());
	}
	
	public byte switchRepeatMode() {
		repeat = CdUtil.switchRepeatMode(CanBoxApp.getMyPID(),repeat);
		return repeat;
	}
	
	public void sendCutSong(boolean isNext) {
		if (isNext) {
			CdUtil.nextSong(CanBoxApp.getMyPID());
		} else {
			CdUtil.prevSong(CanBoxApp.getMyPID());
		}
	}

	public byte getCDRepeadMode() {
		return CdUtil.getCDRepeadMode();
	}
	
	public  void cutAudio(boolean eStatus) {
		LogManager.d(ConstantUtil.TAG, "CD - cutAudio：  eStatus: "+eStatus/*+"  cAuxAudio: "+cAuxAudio*/);
//		if (/*cAuxAudio ^*/ eStatus) {
			if (eStatus) {
				mAudioAuxManager.start();
				LogManager.d(ConstantUtil.TAG, "CD - mAudioAuxManager.start() ");
//				cAuxAudio = true;
			} else {
				LogManager.d(ConstantUtil.TAG, "CD - mAudioAuxManager.stop() ");
				mAudioAuxManager.stop();
//				cAuxAudio = false;
			}
//		}
	}

	private void showMessageObject(Object obj, int what) {
		Message msg = handler.obtainMessage();
		msg.obj = obj;
		msg.what = what;
		handler.sendMessage(msg);
	}
	
	private  void notifyCdPlayState(CDInfo mCDInfo) {
		this.mCDInfo = mCDInfo;
		isPlay = mCDInfo.isPlay();
		isPause = mCDInfo.isPause();
		LogManager.d(ConstantUtil.TAG, "CD - isPlay:" + isPlay+ " --isPause:" + isPause + " --eStatus:"+eStatus);
		if (isPlay ^ eStatus) {
			if (isCdOk && !isPlay) {
				setRepeatMode();
				sendPlayAndPushOrder();
			}
			return;
		}
		if (isPlay) {
			cutAudio(true);
			//reqCdPlayContent();
		} else {
			cutAudio(false);
			abandonFocus();
		}
	}
	
	private void notifyCdState(CDInfo mCDInfo) {
		this.mCDInfo = mCDInfo;
		isCdOk = mCDInfo.isCdOk();
		LogManager.d(ConstantUtil.TAG, "CD - isCdOk:" + isCdOk );
		if (isCdOk) {
			reqCdPlayState();
		}
	}
	
	/** 获取声音焦点 */
	private boolean isAudioFocus;
	
	private boolean getAudioFocus() {
		LogManager.d(ConstantUtil.TAG, "CD 11111- getAudioFocus： "+isAudioFocus);
		if(!isAudioFocus && null!=mAudioManager){
			isAudioFocus = AudioManager.AUDIOFOCUS_REQUEST_GRANTED == mAudioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
		}
		LogManager.d(ConstantUtil.TAG, "CD 22222- getAudioFocus： "+isAudioFocus);
		return isAudioFocus;
	}
	/** 放弃声音焦点 */
	private boolean abandonFocus() {
		boolean abandonSuccess = false;
		LogManager.d(ConstantUtil.TAG, "CD 11111- abandonFocus： "+isAudioFocus);
		if(isAudioFocus && null!=mAudioManager) {        
			abandonSuccess = AudioManager.AUDIOFOCUS_REQUEST_GRANTED==mAudioManager.abandonAudioFocus(afChangeListener);    
			isAudioFocus = !abandonSuccess;
		}
		LogManager.d(ConstantUtil.TAG, "CD 22222- abandonFocus： "+isAudioFocus);
	    return isAudioFocus;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		LogManager.d(ConstantUtil.TAG,"CdService  onDestroy()");
	}

	public void playOrPause() {
		if (isPlay) {
			sendPauseOrder();
		} else {
			sendPlayAndPushOrder();
		}
	}
	
	private OnAudioFocusChangeListener afChangeListener = new OnAudioFocusChangeListener() {
		@Override
		public void onAudioFocusChange(int focusChange) {
			switch (focusChange) {
			case AudioManager.AUDIOFOCUS_GAIN:
				break;
			case AudioManager.AUDIOFOCUS_LOSS:
				LogManager.d(ConstantUtil.TAG, "CD - AUDIOFOCUS_LOSS");
				if (isAudioFocus) isAudioFocus = false;
				sendPauseOrder();
				break;
			case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
				break;
			case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
				break;
			}
		}
	};
	
	
	private final class CDHandlerLisener implements Handler.Callback, CDObserver {

		@Override
		public void onPushCDInfo(CDInfo mCDInfo) {
			showMessageObject(mCDInfo, 0);
		}

		@Override
		public boolean handleMessage(Message msg) {
			CDInfo mCDInfo = (CDInfo) msg.obj;
			comIdType = mCDInfo.getComIdType();
			LogManager.d(ConstantUtil.TAG, "CD - comIdType:"+ comIdType);
			switch (comIdType) {
			case Constant.Mazda.DATA_DEVICE_INFO:
				notifyCdState(mCDInfo);
				break;
            case Constant.Mazda.DATA_PLAY_INFO:
            	notifyCdPlayState(mCDInfo);
            	if (null != mCdUICallback) {
	            	mCdUICallback.updateCdPlayState(mCDInfo);
	            	mCdUICallback.updateCdProgressInfo(mCDInfo);
            	}
				break;
            case Constant.Mazda.DATA_TXT_INFO:
            	if (null != mCdUICallback) {
            		mCdUICallback.updateCdSongInfo(mCDInfo);
            		mCdUICallback.updateCdProgressInfo(mCDInfo);
            	}
				break;
			}
			return false;
		}
		
	}
	
	public class SystemSleep extends BroadcastReceiver {

		private boolean isRegist;

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			LogManager.d(ConstantUtil.TAG, "action: " + action);
			switch (action) {
			case SCREEN_ON:
				if (isPlayBefore) {
					isPlayBefore = false;
					sendPlayAndPushOrder();
				}
				break;
			case SCREEN_OFF:
				isPlayBefore=isPlay;
				sendPauseOrder();
				break;
			}
		}

		public void registSleepReceiver(Context context) {
			if (null != context && !isRegist) {
				isRegist = true;
				IntentFilter filter = new IntentFilter();
				filter.addAction(SCREEN_ON);
				filter.addAction(SCREEN_OFF);
				filter.setPriority(2147483647);
				context.registerReceiver(SystemSleep.this, filter);
			}
		}

		public void unregistSleepReceiver(Context context) {
			if (null != context && isRegist) {
				context.unregisterReceiver(SystemSleep.this);
			}
		}
	}
	
	private class CdControl extends Binder implements CdInterface {
		@Override
		public void registUICallback(CdInterfaceCallback mCdInterfaceCallback) {
			 mCdUICallback = mCdInterfaceCallback;//gengxin UI yong de 
		}
		
		@Override
		public Service getService() {
			return CdService.this;
		}
	}

}
