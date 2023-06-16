package com.landsem.canboxui.utils;

import android.R.integer;
import android.app.ActivityManager;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.AudioSystem;
import android.os.Message;
import android.os.UserHandle;
import android.view.KeyEvent;

import com.landsem.canbox.Constant;
import com.landsem.common.tools.LogManager;
import com.ls.lspower.LSPowerManager;

public class KeyUtil {
	static private Context mContext;
	
	/**  
	 * Send a single key event.  
	 * 
	 */  
public static void sendKeyEvent( Message msg ,Context context) {
		mContext = context;
		int keyCode = (int) msg.obj;
		
		if (keyCode==Constant.PROTOCAL_INVALID_VALUE) {
			return;
		}  
		try {
			keyCode = switchKeyCode(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if ( keyCode!=Constant.PROTOCAL_INVALID_VALUE ) {
			sendOrder(keyCode);
		}  
	}
	/**  
	 *  obtain key value.
	 *  if need not to send order ,then will return -1000.  
	 */  
	private static int switchKeyCode(Message msg ) {
		int keyCode = (int) msg.obj;
		switch (keyCode) {
		case Constant.KEYEVENT_VOICE:
			mContext.sendBroadcast(new Intent(ConstantUtil.LS_VOICE_ACTION));
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_HANGUP:
			phoneBroadcast(ConstantUtil.HANGUP);
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_ANSWER:
			phoneBroadcast(ConstantUtil.ANSWER);
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_HANGUP_NEXT:
			phoneBroadcast(ConstantUtil.HANGUP);
			keyCode = KeyEvent.KEYCODE_MEDIA_NEXT;
			break;
		case Constant.KEYEVENT_ANSWER_PREV:
			phoneBroadcast(ConstantUtil.ANSWER);
			keyCode = KeyEvent.KEYCODE_MEDIA_PREVIOUS;
			break;
		case Constant.KEYEVENT_MODE:
			doModeAction();
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;	
		case Constant.KEYEVENT_AUXIN:
			gotoAUX();
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;	
		case Constant.KEYEVENT_REAR_VIDEO:
			ReverseUtil.goOrOutRearVideo(mContext);
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_POWER:
			controlPowerOnOFF() ;
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_VOLUME_UP:
			setMasterVolume( Constant.KEYEVENT_VOLUME_UP,msg.arg1,msg.arg2);
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_VOLUME_DOWN:
			setMasterVolume( Constant.KEYEVENT_VOLUME_DOWN,msg.arg1,msg.arg2);
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_SCAN_ALL:
			radioBroadcast(ConstantUtil.FM_APS);
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_SCAN_UP:
			radioBroadcast(ConstantUtil.FM_APS_PRE_SEARCH);
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_SCAN_DOWN:
			radioBroadcast(ConstantUtil.FM_APS_NEXT_SEARCH);
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_CHANNEL_UP:
			radioBroadcast(ConstantUtil.FM_APS_PRE_PROGRAM);
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_CHANNEL_DOWN:
			radioBroadcast(ConstantUtil.FM_APS_NEXT_PROGRAM);
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_NAVI:
			gotoNavi();
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_COLLEC_RADIO:
			radioBroadcast(ConstantUtil.FM_APS_CLICK_FAV);
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_HANGUP_MUTE:
			radioBroadcast(ConstantUtil.CANBUS_HANGUP_ACTIOM);
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_ANSWER_VOICE:
			radioBroadcast(ConstantUtil.CANBUS_ANSWER_ACTIOM);
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_EQ:
			gotoEQ();
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_MUSIC:
			gotoOtherActivity(ConstantUtil.MUSIC_ACTIOM);
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
        case Constant.KEYEVENT_BLUE_PHONE:
        	gotoAppFromPackage(ConstantUtil.PHONE_PACKAGENAME);
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
        case Constant.KEYEVENT_CHANNEL_UP_FAST:
        	radioBroadcastWithExtra(ConstantUtil.FM_APS_MICRO_PRE_EXTRA,msg.arg1);
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_CHANNEL_DOWN_FAST:
			radioBroadcastWithExtra(ConstantUtil.FM_APS_MICRO_NEXT_EXTRA,msg.arg1);
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_SET:
			gotoOtherActivity(ConstantUtil.SET_ACTIOM);
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;
		case Constant.KEYEVENT_CD:
			gotoCD();
			keyCode = Constant.PROTOCAL_INVALID_VALUE;
			break;	
		}
		return keyCode;
	}
	
	public static void setMasterVolume(int state,float stepValue,float stepValueMax){
		AudioManager am = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
		int volume = 0;
		int masterMaxVolume = am.getMasterMaxVolume();
		int volumeChange = (int) (stepValue/stepValueMax*masterMaxVolume);
		switch (state) {
		case Constant.KEYEVENT_VOLUME_UP:
			volume  = (int) (am.getMasterVolume()+volumeChange);
			volume = volume>masterMaxVolume?am.getMasterMaxVolume():volume;
			am.setMasterVolume(volume,AudioSystem.STREAM_SYSTEM);
			break;
		case Constant.KEYEVENT_VOLUME_DOWN:
			volume  = (int) (am.getMasterVolume()-volumeChange);
			volume = volume<0?0:volume;
			am.setMasterVolume(volume,AudioSystem.STREAM_SYSTEM);
			break;
		}
		LogManager.d("setMasterVolume VolumeChange "+volumeChange);
		LogManager.d("setMasterVolume volume "+volume);
		LogManager.d("setMasterVolume stepValue "+stepValue);
	}
	
	private static void gotoEQ() {
		gotoOtherActivity(ConstantUtil.EQ_ACTIOM);
	}

	private static void gotoNavi() {
		startActivityForUser("com.landsem.arnavi","com.landsem.arnavi.Layar3DActivity");
	}
	
	private static void gotoAUX() {
		gotoOtherActivity("com.landsem.actions.START_AUX");
	}
	
	private static void gotoCD() {
		gotoOtherActivity("com.landsem.canboxui.activity.SendActivity");
	}
	
	private static void gotoOtherActivity(String action) {
		Intent intent = new Intent(action);
		if (mContext.getPackageManager().resolveActivity(intent,PackageManager.MATCH_DEFAULT_ONLY) != null) {   
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			mContext.startActivity(intent);
		 }
	}

	private static void controlPowerOnOFF() {
		LSPowerManager lspmanager = new LSPowerManager(mContext);
		boolean isPowerOn = lspmanager.queryCurrentPowerModel().ordinal() == 0;
		if (isPowerOn) {
			lspmanager.setBackLightEnable(LSPowerManager.EnableStatus.disenable);
		} else {
			lspmanager.setBackLightEnable(LSPowerManager.EnableStatus.enable);
		}
	}


	private static void doModeAction() {
		ActivityManager am = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
		String name = am.getRunningTasks(1).get(0).topActivity.getPackageName();
		String className = am.getRunningTasks(1).get(0).topActivity.getClassName();

		if (name != null && "com.ls.fmradio".equals(name)) {
			startActivityForUser("com.landsem.media","com.landsem.media.automobile.audio.AudioActivity");
		} else if (name != null&& "com.landsem.media".equals(name)
				&& "com.landsem.media.automobile.audio.AudioActivity".equals(className)) {
			startActivityForUser("com.landsem.media","com.landsem.media.automobile.video.VideoActivity");
		} else if (name != null&& "com.landsem.media".equals(name)
				&& "com.landsem.media.automobile.video.VideoActivity".equals(className)) {
			gotoAppFromPackage("cn.kuwo.kwmusiccar");
			
		} else if (name != null && "cn.kuwo.kwmusiccar".equals(name)) {
			startActivityForUser("com.ls.fmradio","com.ls.fmradio.FMMainActivity");
		} else {
			startActivityForUser("com.ls.fmradio","com.ls.fmradio.FMMainActivity");
		}
	}

	private static void gotoAppFromPackage(String packageName) {
		Intent intent = new Intent();
		intent = mContext.getPackageManager().getLaunchIntentForPackage(packageName);
		mContext.startActivity(intent);
	}
	private static void startActivityForUser(String packageName,String className) {
		 Intent intentCanSet = new Intent(Intent.ACTION_VIEW);
         intentCanSet.setClassName(packageName, className);
		 mContext.startActivityAsUser(intentCanSet, UserHandle.CURRENT_OR_SELF);
	}

	private  static void sendOrder(final int keyCode2) {
		new Thread () {    
	        public void run () {    
	            try {    
	                 Instrumentation inst=new Instrumentation();    
	                 inst.sendKeyDownUpSync(keyCode2); 
//	                 PushUtil.sendMuteForKey(keyCode2, mContext);
	                 LogManager.d(ConstantUtil.TAG,"sendKeyEvent : "+keyCode2); 
	            } catch(Exception e) {    
	            	e.printStackTrace();
	                LogManager.d(ConstantUtil.TAG,"sendKeyEvent Exception "+e);    
	            }    
	        }    
	  
	    }.start();    
	}

	private static void phoneBroadcast(String extraType) {
		Intent intent = new Intent(ConstantUtil.ANDROID_INTENT_BT_PHONE);
		intent.putExtra("type", extraType);
		mContext.sendBroadcast(intent);
	}  
	private static void radioBroadcast(String action) {
		Intent intent = new Intent(action);
		mContext.sendBroadcast(intent);
	}  
	
	private static void radioBroadcastWithExtra(String action,int extra) {
		Intent intent = new Intent(action);
		intent.putExtra("extra", extra);
		mContext.sendBroadcast(intent);
	} 

}
