package com.landsem.canboxui.utils;

import android.content.ContentResolver;
import android.provider.Settings;

import com.landsem.canbox.CanBoxApp;
import com.landsem.canbox.Constant;
import com.landsem.canbox.Constant.Mazda;
import com.landsem.canbox.Constant.MazdaSimple;
import com.landsem.canbox.ProtocolID;
import com.landsem.canbox.pack.simple.SimpleMazdaPack;
import com.landsem.canbox.pack.xinbas.XinbasMazdaPack;
import com.landsem.canboxui.R;
import com.landsem.common.tools.LogManager;

public final class CdUtil {
	
	public  static final String CD_REPEAD_MODE = "canbus_cd_repead_mode";
	
	public static void reqCdDeviceState(ProtocolID mPID) {
		if (mPID==null) {
			return;
		}
		LogManager.d(ConstantUtil.TAG,"CD -SEND -  reqCdDeviceState");
		if (mPID.ordinal() == ProtocolID.ID_XB_MAZDA.ordinal()) {
			XinbasMazdaPack.getInstance().sendReqInfo(new byte[] {Mazda.DATA_DEVICE_INFO});
		}else if (mPID.ordinal() == ProtocolID.ID_XP_MAZDA.ordinal()) {
			SimpleMazdaPack.getInstance().sendReqInfo(new byte[] {MazdaSimple.DATA_CD_STATE});
		}
	}
	
	public static void reqCdPlayState(ProtocolID mPID) {
		if (mPID==null) {
			return;
		}
		LogManager.d(ConstantUtil.TAG,"CD -SEND -  reqCdPlayState");
		if (mPID.ordinal() == ProtocolID.ID_XB_MAZDA.ordinal()) {
			XinbasMazdaPack.getInstance().sendReqInfo(new byte[] {Mazda.DATA_PLAY_INFO});
		}else if (mPID.ordinal() == ProtocolID.ID_XP_MAZDA.ordinal()) {
			SimpleMazdaPack.getInstance().sendReqInfo(new byte[] {MazdaSimple.DATA_CD_STATE});
		}
	}
	
	public static void reqCdPlayContent(ProtocolID mPID) {
		if (mPID==null) {
			return;
		}
		LogManager.d(ConstantUtil.TAG,"CD -SEND -  reqCdPlayContent");
		if (mPID.ordinal() == ProtocolID.ID_XB_MAZDA.ordinal()) {
			XinbasMazdaPack.getInstance().sendReqInfo(new byte[] {Mazda.DATA_TXT_INFO});
		}else if (mPID.ordinal() == ProtocolID.ID_XP_MAZDA.ordinal()) {
			SimpleMazdaPack.getInstance().sendReqInfo(new byte[] {MazdaSimple.DATA_CD_CONTENT});
		}
	}
	
	public static void startDisc(ProtocolID mPID) {
		if (mPID==null) {
			return;
		}
		LogManager.d(ConstantUtil.TAG,"CD -SEND -  startDisc");
		if (mPID.ordinal() == ProtocolID.ID_XB_MAZDA.ordinal()) {
			XinbasMazdaPack.getInstance().sendCdOrder(new byte[] {0x0e});
		}else if (mPID.ordinal() == ProtocolID.ID_XP_MAZDA.ordinal()) {
			SimpleMazdaPack.getInstance().sendStartOrder(true);
		}
	}

	public static void prevSong(ProtocolID mPID) {
		if (mPID==null) {
			return;
		}
		LogManager.d(ConstantUtil.TAG,"CD -SEND -  prevSong");
		if (mPID.ordinal() == ProtocolID.ID_XB_MAZDA.ordinal()) {
			XinbasMazdaPack.getInstance().sendCdOrder(new byte[] {0x05});
		}else if (mPID.ordinal() == ProtocolID.ID_XP_MAZDA.ordinal()) {
			SimpleMazdaPack.getInstance().sendCdControlOrder(new byte[] {0x04});
		}
		
	}

	public static void nextSong(ProtocolID mPID) {
		if (mPID==null) {
			return;
		}
		LogManager.d(ConstantUtil.TAG,"CD -SEND -SEND -SEND  nextSong");
		if (mPID.ordinal() == ProtocolID.ID_XB_MAZDA.ordinal()) {
			XinbasMazdaPack.getInstance().sendCdOrder(new byte[] {0x04});
		}else if (mPID.ordinal() == ProtocolID.ID_XP_MAZDA.ordinal()) {
			SimpleMazdaPack.getInstance().sendCdControlOrder(new byte[] {0x03});
		}
	}

	public static void playSong(ProtocolID mPID) {
		if (mPID==null) {
			return;
		}
		LogManager.d(ConstantUtil.TAG,"CD -SEND -SEND -  playSong");
		if (mPID.ordinal() == ProtocolID.ID_XB_MAZDA.ordinal()) {
			XinbasMazdaPack.getInstance().sendCdOrder(new byte[] {0x00});
		}else if (mPID.ordinal() == ProtocolID.ID_XP_MAZDA.ordinal()) {
			SimpleMazdaPack.getInstance().sendCdControlOrder(new byte[] {(byte) 0xF0});
		}
	}

	public static void pauseSong(ProtocolID mPID) {
		if (mPID==null) {
			return;
		}
		LogManager.d(ConstantUtil.TAG,"CD -SEND -SEND -  pauseSong");
		if (mPID.ordinal() == ProtocolID.ID_XB_MAZDA.ordinal()) {
			XinbasMazdaPack.getInstance().sendCdOrder(new byte[] {0x01});
		}else if (mPID.ordinal() == ProtocolID.ID_XP_MAZDA.ordinal()) {
			SimpleMazdaPack.getInstance().sendCdControlOrder(new byte[] {0x01});
		}
	}
	
	public static void repeatMode(ProtocolID mPID,byte curRepeatMode ) {
		if (mPID==null) {
			return ;
		}
		LogManager.d(ConstantUtil.TAG,"CD -SEND -SEND -  repeatMode");
		if (mPID.ordinal() == ProtocolID.ID_XB_MAZDA.ordinal()) {
		   XinbasMazdaPack.getInstance().sendCdOrder(new byte[] {sendXbsRepeatMode(curRepeatMode)});
		}else if (mPID.ordinal() == ProtocolID.ID_XP_MAZDA.ordinal()) {
			SimpleMazdaPack.getInstance().sendCdControlOrder(new byte[] {sendSimpleRepeatMode(curRepeatMode)});
		}
	}
	
	private static byte sendSimpleRepeatMode(byte curRepeatMode) {
		switch (curRepeatMode) {
		case Constant.CD_RPT_SINGLE:
			curRepeatMode = 0x07;
			break;
		case Constant.CD_RPT_CLOSE:
			curRepeatMode = 0x08;
			break;
		case Constant.CD_RDM_ALL:
			curRepeatMode = 0x09;
			break;
		case Constant.CD_RDM_CLOSE:
			curRepeatMode = 0x0A;
			break;
		default:
			curRepeatMode = 0x07;
		    break;
		}
		return curRepeatMode;
	}
	
	private static byte sendXbsRepeatMode(byte curRepeatMode) {
		switch (curRepeatMode) {
		case Constant.CD_RPT_SINGLE:
			curRepeatMode = 0x06;
			break;
		case Constant.CD_RPT_FOLD:
			curRepeatMode = 0x07;
			break;
		case Constant.CD_RPT_CLOSE:
			curRepeatMode = 0x08;
			break;
		case Constant.CD_RDM_FOLD:
			curRepeatMode = 0x09;
			break;
		case Constant.CD_RDM_ALL:
			curRepeatMode = 0x0A;
			break;
		case Constant.CD_RDM_CLOSE:
			curRepeatMode = 0x0B;
			break;
		default:
			curRepeatMode = 0x06;
		    break;
		}
		return curRepeatMode;
	}

	public static byte switchRepeatMode(ProtocolID mPID,byte curRepeatMode) {
		if (mPID==null) {
			return Constant.CD_RPT_SINGLE;
		}
		if (mPID.ordinal() == ProtocolID.ID_XB_MAZDA.ordinal()) {
			curRepeatMode = switchXbsRepeatMode( curRepeatMode);
		}else if (mPID.ordinal() == ProtocolID.ID_XP_MAZDA.ordinal()) {
			curRepeatMode = switchSimpleRepeatMode( curRepeatMode);
		}
		return curRepeatMode;
	}

	private static byte switchSimpleRepeatMode(byte curRepeatMode) {
		switch (curRepeatMode) {
		case Constant.CD_RPT_SINGLE:
			curRepeatMode = Constant.CD_RPT_CLOSE;
			break;
		case Constant.CD_RPT_CLOSE:
			curRepeatMode = Constant.CD_RDM_ALL;
			break;
		case Constant.CD_RDM_ALL:
			curRepeatMode = Constant.CD_RDM_CLOSE;
			break;
		case Constant.CD_RDM_CLOSE:
			curRepeatMode = Constant.CD_RPT_SINGLE;
			break;
			default:
			curRepeatMode = Constant.CD_RPT_CLOSE;
		    break;
		}
		return curRepeatMode;
	}

	private static byte switchXbsRepeatMode(byte curRepeatMode) {
		switch (curRepeatMode) {
		case Constant.CD_RPT_SINGLE:
			curRepeatMode = Constant.CD_RPT_FOLD;
			break;
		case Constant.CD_RPT_FOLD:
			curRepeatMode = Constant.CD_RPT_CLOSE;
			break;
		case Constant.CD_RPT_CLOSE:
			curRepeatMode = Constant.CD_RDM_FOLD;
			break;
		case Constant.CD_RDM_FOLD:
			curRepeatMode = Constant.CD_RDM_ALL;
			break;
		case Constant.CD_RDM_ALL:
			curRepeatMode = Constant.CD_RDM_CLOSE;
			break;
		case Constant.CD_RDM_CLOSE:
			curRepeatMode = Constant.CD_RPT_SINGLE;
			break;
		default:
			curRepeatMode = Constant.CD_RPT_CLOSE;
		    break;
		}
		return curRepeatMode;
	}
	
	/**
	 *存入CANBOX协议名称
	 */
	public static void putCDRepeadMode(byte repeadMode) {
		ContentResolver mContentResolver = CanBoxApp.getMyContext().getContentResolver();
		LogManager.d(ConstantUtil.TAG,"putCDRepeadMode  repeadMode :"+repeadMode);
		Settings.System.putInt(mContentResolver, CD_REPEAD_MODE, repeadMode);
	} 
	
	/**
	 *得到CANBOX协议名称
	 */
	public static byte getCDRepeadMode() {
		ContentResolver mContentResolver = CanBoxApp.getMyContext().getContentResolver();
		byte repeadMode = Constant.CD_RPT_CLOSE;
		try {
			repeadMode = (byte) Settings.System.getInt(mContentResolver, CD_REPEAD_MODE);
		} catch (Exception e) {
			repeadMode = Constant.CD_RPT_CLOSE;
			e.printStackTrace();
		}
		LogManager.d(ConstantUtil.TAG,"getCDRepeadMode  repeadMode :"+repeadMode);
		return repeadMode;
	}

	public static String formatTime(float songTime) {
		String timeString = "";
		int minute = (int) (songTime/60);
		int second = (int) (songTime%60);
		timeString = minute+":"+second;
		if (second<10) {
			timeString = minute+":0"+second;
		}
		return timeString;
	}  

}
