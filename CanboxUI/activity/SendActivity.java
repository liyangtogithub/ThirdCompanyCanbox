package com.landsem.canboxui.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.landsem.canbox.Constant;
import com.landsem.canbox.activity.BaseActivity;
import com.landsem.canbox.bean.CDInfo;
import com.landsem.canbox.pack.simple.DasAuto1Pack;
import com.landsem.canboxui.R;
import com.landsem.canboxui.myinterface.CdInterface;
import com.landsem.canboxui.myinterface.CdInterfaceCallback;
import com.landsem.canboxui.service.CdService;
import com.landsem.canboxui.utils.CdUtil;
import com.landsem.canboxui.utils.ConstantUtil;
import com.landsem.canboxui.utils.PushUtil;
import com.landsem.common.tools.LogManager;

public class SendActivity extends BaseActivity implements OnClickListener {

	Context mContext;
	TextView reqCornerView, cdModeView, cdSongName, cdDiscName, cdArtist,
			cdSongNum, cdCurTime, cdAllTime;
	ImageView playPauseView, cdTurnRoundView;
	SeekBar cdSeekBar;
	/*** 第一次请求cd状态 */
	/*** TEXT类型 */
	private int textType = Constant.TEXT_NAME_SONG;
	/*** 当前文件夹 */
	private int curFold = 0;
	/*** 当前曲目 */
	private int curSong = 0;
	/*** TEXT内容 */
	String textContent = "";
	/*** 曲目总时间 */
	private float songAllTime = 1;
	/*** 当前曲目时间 */
	private float curSongTime = 0;
	String modeString = "";
	String discNameString = "";
	String artistString = "";
	String timeString;
	CdInterface mCdInterface;
	byte repeat = 0x06;
	private CdService cdService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		setContentView(R.layout.activity_send);
		initString();
		initView();
		bindCdService();
		LogManager.d(ConstantUtil.TAG, "CdActivity - onCreate ");
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (cdService != null) {
			cdService.initCdState();
		}
	}

	private void initRepeatView() {
		if (cdService != null) {
		    repeat = cdService.getCDRepeadMode();
		}
		updateRepeatUI();
	}

	private void initString() {
		modeString = getString(R.string.cdModeTv);
		discNameString = getString(R.string.cdDiscName);
		artistString = getString(R.string.cdArtist);
	}

	private void initView() {
		((ImageView) findViewById(R.id.cd_balance)).setOnClickListener(this);
		((ImageView) findViewById(R.id.cd_pop)).setOnClickListener(this);
		((ImageView) findViewById(R.id.cd_prev)).setOnClickListener(this);
		((ImageView) findViewById(R.id.cd_next)).setOnClickListener(this);
		((ImageView) findViewById(R.id.cd_loop)).setOnClickListener(this);
		cdTurnRoundView = ((ImageView) findViewById(R.id.cd_round));
		playPauseView = ((ImageView) findViewById(R.id.cd_play_pause));
		playPauseView.setOnClickListener(this);
		cdModeView = (TextView) findViewById(R.id.cd_mode);
		cdSongName = (TextView) findViewById(R.id.cd_song_name);
		cdSongNum = (TextView) findViewById(R.id.cd_song_num);
		cdDiscName = (TextView) findViewById(R.id.cd_disc_name);
		cdArtist = (TextView) findViewById(R.id.cd_artist);
		cdSeekBar = (SeekBar) findViewById(R.id.cd_seekBar);
		cdCurTime = (TextView) findViewById(R.id.cd_curTime);
		cdAllTime = (TextView) findViewById(R.id.cd_allTime);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.cd_balance:
			gotoEQ();
			break;
		case R.id.cd_pop:
			cdService.sendPrepareCD();
			break;
		case R.id.cd_prev:
			cdService.sendCutSong(false);
			break;
		case R.id.cd_next:
			cdService.sendCutSong(true);
			break;
		case R.id.cd_play_pause:
			cdService.playOrPause();
			break;
		case R.id.cd_loop:
			repeat = cdService.switchRepeatMode();
			cdService.setRepeatMode();
			updateRepeatUI();
			rememberRepeatMode();
			break;
//		 DasAuto1Pack.getInstance().startOrder();
//		 DasAuto1Pack.getInstance().checkEPS();
//		 DasAuto1Pack.getInstance().sendSource("SD");
//		 DasAuto1Pack.getInstance().sendRadio("AM",1000);
//		 DasAuto1Pack.getInstance().sendMediaInfo(new byte[] {0x00,2,1,0,1,1});
//		 DasAuto1Pack.getInstance().sendSoundInfo((byte) 127);
//		 DasAuto1Pack.getInstance().sendPhoneInfo(ByteUtil.hexStringToByteArray("0115915454371f"));
//		 DasAuto1Pack.getInstance().sendPowerAmplifier(new byte[] {0,5});
//		 XinbasMazdaPack.getInstance().sendCdOrder(new byte[] {2});
		}
	}

	private void rememberRepeatMode() {
		CdUtil.putCDRepeadMode(repeat);
	}

	// 临时的，将来是接收CD发过来的信息，更新的
	private void updateRepeatUI() {
		switch (repeat) {
		case Constant.CD_RPT_SINGLE:
			cdModeView.setText(modeString + getString(R.string.cdRptSingle));
			break;
		case Constant.CD_RPT_FOLD:
			cdModeView.setText(modeString + getString(R.string.cdRptFold));
			break;
		case Constant.CD_RPT_CLOSE:
			cdModeView.setText(modeString + getString(R.string.cdRptClose));
			break;
		case Constant.CD_RDM_FOLD:
			cdModeView.setText(modeString + getString(R.string.cdRdmFold));
			break;
		case Constant.CD_RDM_ALL:
			cdModeView.setText(modeString + getString(R.string.cdRdmAll));
			break;
		case Constant.CD_RDM_CLOSE:
			cdModeView.setText(modeString + getString(R.string.cdRdmClose));
			break;
		}
	}

	private void gotoEQ() {
		Intent intent = new Intent(ConstantUtil.EQ_ACTIOM);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
	}

	private void bindCdService() {
		Intent intent = new Intent(mContext, CdService.class);
		bindService(intent, CdConnection, Context.BIND_AUTO_CREATE);
	}

	private void updateUIProgressInfo(CDInfo mCDInfo) {
		songAllTime = mCDInfo.getSongAllTime();
		curSongTime = mCDInfo.getCurSongTime();
		// LogManager.d(ConstantUtil.TAG, "CD - songAllTime:" + songAllTime);
		// LogManager.d(ConstantUtil.TAG, "CD - curSongTime:" + curSongTime);
		if (songAllTime != 0) {
			cdSeekBar.setProgress((int) (curSongTime / songAllTime * 100));
		}
		timeString = CdUtil.formatTime(curSongTime);
		cdCurTime.setText(timeString);
		timeString = CdUtil.formatTime(songAllTime);
		cdAllTime.setText(timeString);
	}

	private void updateUISongInfo(CDInfo mCDInfo) {
		textType = mCDInfo.getTextType();
		textContent = mCDInfo.getTextContent();
		curFold = mCDInfo.getCurFold();
		curSong = mCDInfo.getCurSong();
		cdSongNum.setText(curFold + "." + curSong + ".");
		// LogManager.d(ConstantUtil.TAG, "CD - textType:" + textType);
		// LogManager.d(ConstantUtil.TAG, "CD - textContent:" + textContent);
		switch (textType) {
		case Constant.TEXT_NAME_SONG:
			cdSongName.setText(textContent);
			break;
		case Constant.TEXT_NAME_DISC:
			cdDiscName.setText(discNameString + textContent);
			break;
		case Constant.TEXT_NAME_ART:
			cdArtist.setText(artistString + textContent);
			break;
		}
	}

	private void updateUIPlayState(CDInfo mCDInfo) {
		boolean isPlay = mCDInfo.isPlay();
		LogManager.d(ConstantUtil.TAG, "CD -  update  isPlaying:" + isPlay);
		if (isPlay) {
			playPauseView.setImageResource(R.drawable.cd_selector_pause);
		} else {
			playPauseView.setImageResource(R.drawable.cd_selector_play);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		LogManager.d(ConstantUtil.TAG, "CdActivity - onDestroy ");
		if (null != mCdInterface) mCdInterface.registUICallback(null);
		unbindService(CdConnection);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
		case KeyEvent.KEYCODE_MEDIA_NEXT:
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
			cdService.sendCutSong(false);
			return true;
		case KeyEvent.KEYCODE_MEDIA_NEXT:
			cdService.sendCutSong(true);
			return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	
	private ServiceConnection CdConnection = new ServiceConnection() {
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			LogManager.d("Cd onServiceConnected name: " + name);
			mCdInterface = (CdInterface) service;
			cdService = (CdService) mCdInterface.getService();
			mCdInterface.registUICallback(mUICallback);
			cdService.startPrepareCD();
			initRepeatView();
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			LogManager.d("Cd onServiceDisconnected name: " + name);
			cdService = null;
			mCdInterface = null;
		}
	};

	/*** update UI Callback */
	CdInterfaceCallback mUICallback = new CdInterfaceCallback() {
		
		@Override
		public void updateCdPlayState(CDInfo mCDInfo) {
			updateUIPlayState(mCDInfo);
		}
		
		@Override
		public void updateCdProgressInfo(CDInfo mCDInfo) {
			updateUIProgressInfo(mCDInfo);
		}
		
		@Override
		public void updateCdSongInfo(CDInfo mCDInfo) {
			updateUISongInfo(mCDInfo);
		}
	};
	
}
