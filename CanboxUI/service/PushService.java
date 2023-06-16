package com.landsem.canboxui.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.landsem.canbox.CanBoxApp;
import com.landsem.canboxui.dialog.AlarmNotify;
import com.landsem.canboxui.utils.ConstantUtil;
import com.landsem.canboxui.utils.PushUtil;
import com.landsem.common.tools.LogManager;
import com.landsem.canboxui.aidl.DVDInfo;
import com.landsem.canboxui.aidl.MediaInfo;
import com.landsem.canboxui.aidl.NAVIInfo;
import com.landsem.canboxui.aidl.PhoneInfo;
import com.landsem.canboxui.aidl.PushInfor;
import com.landsem.canboxui.aidl.RadioInfo;

public class PushService extends  Service  {
	
	Context mContext;
	PushClass mPushClass;
//	SettingsContentObserver mSettingsContentObserver;
	
	@Override
	public void onCreate() {
		super.onCreate();
		mContext = this;
		AlarmNotify.notificationMethod(AlarmNotify.NULL_NOTIFY,"",mContext);
		PushUtil.pushStartOrder(CanBoxApp.getMyPID());
		mPushClass = new PushClass();
		/*mSettingsContentObserver = new SettingsContentObserver(this,new Handler());
		getApplicationContext().getContentResolver().registerContentObserver
		(android.provider.Settings.System.CONTENT_URI, true, mSettingsContentObserver );*/
		LogManager.d(ConstantUtil.TAG,"PushService  onCreate");
	}
	
	class PushClass extends PushInfor.Stub{

		@Override
		public void changeSource(String mSource) throws RemoteException {
			PushUtil.sendSourceOrder(CanBoxApp.getMyPID(),mSource);
		}

		@Override
		public void sendDVDInfo(DVDInfo mDVDInfo) throws RemoteException {
			PushUtil.sendDVDInfoOrder(CanBoxApp.getMyPID(),mDVDInfo);
		}

		@Override
		public void sendMediaInfo(MediaInfo mMediaInfo) throws RemoteException {
			PushUtil.sendMediaInfoOrder(CanBoxApp.getMyPID(),mMediaInfo);
		}

		@Override
		public void sendPhoneInfo(PhoneInfo mPhoneInfo) throws RemoteException {
			PushUtil.sendPhoneInfoOrder(CanBoxApp.getMyPID(),mPhoneInfo); 
		}

		@Override
		public void sendRadioInfo(RadioInfo mRadioInfo) throws RemoteException {
			PushUtil.sendRadioInfoOrder(CanBoxApp.getMyPID(),mRadioInfo);
		}
		
		@Override
		public void sendNAVIInfo(NAVIInfo arg0) throws RemoteException {
		}
	}
	
	/*public class SettingsContentObserver extends ContentObserver {
	    int previousVolume;
	    Context context;

	    public SettingsContentObserver(Context c, Handler handler) {
	        super(handler);
	        context=c;
	        AudioManager audio = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
	        previousVolume = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
	    }

	    @Override
	    public boolean deliverSelfNotifications() {
	        return super.deliverSelfNotifications();
	    }

	    @Override
	    public void onChange(boolean selfChange) {
	        super.onChange(selfChange);
	        AudioManager audio = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
	        int currentVolume = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
	        int delta=previousVolume-currentVolume;
	        if(delta!=0){
	            previousVolume=currentVolume;
	            LogManager.d(ConstantUtil.TAG,"PushService  Volume onChange");
	            volumePushHandler.sendEmptyMessageDelayed(currentVolume, 1000);
	        }

	    }
	}
	
	Handler volumePushHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			 PushUtil.sendCurrentVolume((byte) msg.what);
			
			}
	};*/
	
	public void onDestroy() {
		super.onDestroy();
		mPushClass = null;
//		mSettingsContentObserver = null;
//		getApplicationContext().getContentResolver().unregisterContentObserver(mSettingsContentObserver);
	};
	
	@Override
	public IBinder onBind(Intent arg0) {
		return mPushClass;
	}

}
