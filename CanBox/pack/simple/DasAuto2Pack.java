package com.landsem.canbox.pack.simple;

import com.landsem.canbox.Constant.SimpleDasAutoID.SendComID1;
import com.landsem.canbox.Constant.SimpleDasAutoID.SendComID2;
import com.landsem.canbox.bean.ComBean;
import com.landsem.canbox.manager.SerialManager;
import com.landsem.canbox.pack.SimpleBaseComPack;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.canboxui.aidl.DVDInfo;
import com.landsem.canboxui.aidl.MediaInfo;
import com.landsem.canboxui.aidl.PhoneInfo;
import com.landsem.canboxui.aidl.RadioInfo;
import com.landsem.common.tools.LogManager;


public class DasAuto2Pack extends SimpleBaseComPack   {
	/**
	 *  欣朴软件_大众高尔夫7串口通讯协议V1.27.000
	 */
	public DasAuto2Pack() {
		super((byte) 0xFF, (byte) 0x2e);
	}
	
	static DasAuto2Pack mDasAuto2Pack;
	//static String sourceString = "Disc";
	
	
	protected enum SOURCE_TYPE {
        OFF,Tuner,Disc,TV,NAVI,Phone,iPod,Aux,USB,SD,DVB_T,Phone_A2DP,Other,CDC 
    }
	
	interface MEDIA_TYPE{
		int Tuner		            = 0x01;
		int Simple_Audio 	        = 0x10;
		int Enhanced_Audio 	        = 0x11;
		int iPod 	                = 0x12;
		int File_based_Video		= 0x20;
		int DVD_Video		        = 0x21;
		int Other_Video		        = 0x22;
		int AUX		                = 0x30;
		int Phone	                = 0x40;
	}
	static String mSourceString;
	
	public static DasAuto2Pack getInstance(){
		if (mDasAuto2Pack==null) {
			mDasAuto2Pack = new DasAuto2Pack();
		}
		return mDasAuto2Pack;
	}
	
	/***开始通信*/
	public static void startOrder() {
		sendOrder((byte)SendComID2.SEND_START_ORDER, null, new byte[] {0x01});
	}
	
	/***源改变*/
	public static void sendSource(String sourceString) {
//		sendOrder((byte)SendComID2.SOURCE_INFO, null, new byte[] {
//				(byte) SOURCE_TYPE.valueOf(sourceString).ordinal(),swichMediaType(sourceString)});
		mSourceString = sourceString;
	}
	
	/***收音机
	 * radioType :FM,AM
	 * freq:108MHz,500KHz
	 * */
	public static void sendRadio(RadioInfo mRadioInfo  ) {
		String radioType =  mRadioInfo.mBand;
		int freq =  mRadioInfo.mFreq;
		byte[] radioFreqArray = ByteUtil.IntTo2ByteArray(freq);
		sendOrder((byte)SendComID2.SOURCE_INFO, null, new byte[] {
				(byte) SOURCE_TYPE.valueOf(mSourceString).ordinal(),swichMediaType(mSourceString),
				switchRadioType(radioType),radioFreqArray[1],radioFreqArray[0],0});
	}
	
	/***媒体播放信息*/
	public static void sendMediaInfo(MediaInfo mMediaInfo ) {
		int foldNum = mMediaInfo.mFoldNum;
		int fileNum = mMediaInfo.mFileNum;
		byte minute = (byte) (mMediaInfo.mMillisecond/1000/60);
		byte second = (byte) (mMediaInfo.mMillisecond/1000%60);
		byte[] foldNumArray = ByteUtil.IntTo2ByteArray(foldNum);
		byte[] fileNumArray = ByteUtil.IntTo2ByteArray(fileNum);
		sendOrder((byte)SendComID2.SOURCE_INFO, null, new byte[] {
				(byte) SOURCE_TYPE.valueOf(mSourceString).ordinal(),swichMediaType(mSourceString),
				foldNumArray[1],foldNumArray[0],fileNumArray[1],fileNumArray[0],minute,second});
	}
	
	/***CD播放信息*/
	public static void sendMediaCDInfo(DVDInfo mDvdInfo) {
		 byte mCurSone = (byte) mDvdInfo.mCurSone;
		 byte mTotalSone = (byte)mDvdInfo.mTotalSone;
		 byte minute = (byte) (mDvdInfo.mMillisecond/1000/60);
		 byte second = (byte) (mDvdInfo.mMillisecond/1000%60);
		sendOrder((byte)SendComID2.SOURCE_INFO, null, new byte[] {
				(byte) SOURCE_TYPE.valueOf(mSourceString).ordinal(),swichMediaType(mSourceString),
				mCurSone,mTotalSone,0,0,minute,second});
		
	}
	
	/***声音信息*/
	public static void sendSoundInfo(byte sound) {
		sendOrder((byte)SendComID2.SOUND_INFO, null, sound);
	}
	
	/***电话信息  无效果*/
	public static void sendPhoneInfo(PhoneInfo mPhoneInfo ) {
		int mState = mPhoneInfo.mState;
		String mPnoneNum = mPhoneInfo.mPnoneNum;
		if (mPnoneNum==null) {
			return;
		}
		byte phoneArray[] = new byte[2+mPnoneNum.length()] ;
		phoneArray[0] = 3;
		phoneArray[1] = 1;
		
		byte temp = 0;
		byte phoneArrayBackPart[] = mPnoneNum.getBytes();
		for(int i=0;i<phoneArrayBackPart.length;i++){ 
		    temp=(byte) phoneArrayBackPart[i]; 
		    phoneArray[i+2] = temp;
		}
		sendOrder((byte)SendComID2.PHONE_INFO, null, phoneArray);
		sendOrder((byte)SendComID2.PHONE_STATE, null, new byte[]{1,(byte) mState});
	}
	
	/***源媒体类型* */
	private static byte swichMediaType(String sourceString) {
		byte type = 0;
		switch (sourceString) {
		case "Tuner":
			type = MEDIA_TYPE.Tuner;
			break;
		case "Disc":
			type =  MEDIA_TYPE.DVD_Video;
			break;
		case "NAVI":
			type =  MEDIA_TYPE.Other_Video;
			break;
		case "SD":
		case "USB":
			type =  MEDIA_TYPE.Enhanced_Audio;
			break;
		case "Phone":
			type =  MEDIA_TYPE.Phone;
			break;
		case "Aux":
			type =  MEDIA_TYPE.AUX;
			break;
		}
		return type;
	}

	
	/***收音机类型* */
	private static byte switchRadioType(String radioType) {
		byte type = 0;
		switch (radioType) {
		case "FM":
			type = 0;
			break;
		case "AM":
			type = 0X10;
			break;
		}
		return type;
	}

	public static void sendOrder(byte comID, String sendValue, byte... byteData) {
		SerialManager mSerialManager = SerialManager.getInstance();
		ComBean mComBean = ComBean.createComBean(comID, sendValue, byteData);
		mSerialManager.onSendCom(mComBean);
	}
	
}
