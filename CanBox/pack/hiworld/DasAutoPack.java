package com.landsem.canbox.pack.hiworld;

import com.landsem.canbox.Constant;
import com.landsem.canbox.Constant.DasAutoComID;
import com.landsem.canbox.Constant.SimpleDasAutoID.SendComID1;
import com.landsem.canbox.bean.ComBean;
import com.landsem.canbox.manager.SerialManager;
import com.landsem.canbox.pack.HiworldBaseComPack;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.canboxui.aidl.DVDInfo;
import com.landsem.canboxui.aidl.MediaInfo;
import com.landsem.canboxui.aidl.PhoneInfo;
import com.landsem.canboxui.aidl.RadioInfo;

public class DasAutoPack extends HiworldBaseComPack implements DasAutoComID {
	static DasAutoPack mDasAutoPack;
	
	public DasAutoPack() {
		super((byte) 0xFF, (byte) 0xAA, (byte) 0x55);
	}
	
	public static DasAutoPack getInstance(){
		if (mDasAutoPack==null) {
			mDasAutoPack = new DasAutoPack();
		}
		return mDasAutoPack;
	}
	
	protected enum SOURCE_TYPE {
		OFF,FM1,FM2,FM3,AM1,AM2,CD,DVD,TV,NAVI,Phone,iPod,Aux,USB,SD
    }
	
	/**
	 * 主机状态信息：源
	 */
	public static void sendSource(String source,String content ) {
		sendOrder(Constant.DasAutoComID.COMID_SEND_MAINFRAME, changeStringLength(content,12), 
				new byte[] {(byte) SOURCE_TYPE.valueOf(source).ordinal()});
	}
	
	/***收音机
	 * radioType :FM,AM
	 * freq:108MHz,500KHz
	 * */
	public static void sendRadio(RadioInfo mRadioInfo  ) {
		String radioType =  mRadioInfo.mBand;
		float freq =  mRadioInfo.mFreq;
		String freqsString = "";
		if ("FM".equals(radioType)) {
			radioType = "FM1";
			freqsString = (freq/100)+"Mhz";
		}else {
			radioType = "AM1";
			freqsString = (int)freq+"Khz";
		}
		sendSource(radioType, freqsString );
	}
	
	/***媒体播放信息*/
	public static void sendMediaInfo( MediaInfo mMediaInfo ) {
		String source = mMediaInfo.mSource;
		int foldNum = mMediaInfo.mFoldNum;
		int fileNum = mMediaInfo.mFileNum;
		byte minute = (byte) (mMediaInfo.mMillisecond/1000/60);
		byte second = (byte) (mMediaInfo.mMillisecond/1000%60);
		sendSource(source, foldNum+"-"+fileNum+" , "+minute+":"+second );
		
	}
	
	/***CD播放信息*/
	public static void sendMediaCDInfo(DVDInfo mDvdInfo) {
		 byte mCurSone = (byte) mDvdInfo.mCurSone;
		 byte mTotalSone = (byte)mDvdInfo.mTotalSone;
		 byte minute = (byte) (mDvdInfo.mMillisecond/1000/60);
		 byte second = (byte) (mDvdInfo.mMillisecond/1000%60);
		sendSource("CD", mCurSone+"/"+mTotalSone+" , "+minute+":"+second );
	}
	
	
	/***电话信息*/
	public static void sendPhoneInfo(PhoneInfo mPhoneInfo ) {
		int mState = mPhoneInfo.mState;
		String mPnoneNum = mPhoneInfo.mPnoneNum;
		if (mPnoneNum==null) {
			mPnoneNum="-";
		}
		sendSource("Phone", mPnoneNum );
	}

	/**
	 * 将 参数showMSG 字符串长度变为length,用空字符填补
	 */
	private static String changeStringLength(String showMSG ,int length) {
		StringBuffer sb = new StringBuffer();
		sb.append(showMSG);
		int count = length - showMSG.length();
		while (count > 0) {
			sb.append(" ");
			count--;
		}
		if (count<0) {
			return sb.toString().substring(0, length);
		}
		return sb.toString();
	}
	
	public static void sendOrder(byte comID, String sendValue, byte... byteData) {
		SerialManager mSerialManager = SerialManager.getInstance();
		ComBean mComBean = ComBean.createComBean(comID, sendValue, byteData);
		mSerialManager.onSendCom(mComBean);
	}
	
}
