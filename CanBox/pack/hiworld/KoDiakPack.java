package com.landsem.canbox.pack.hiworld;

import java.lang.reflect.Array;

import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.ComBean;
import com.landsem.canbox.manager.SerialManager;
import com.landsem.canbox.pack.HiworldBaseComPack;
import com.landsem.canbox.pack.hiworld.DasAutoPack.SOURCE_TYPE;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.canboxui.aidl.DVDInfo;
import com.landsem.canboxui.aidl.MediaInfo;
import com.landsem.canboxui.aidl.PhoneInfo;
import com.landsem.canboxui.aidl.RadioInfo;
import com.landsem.common.tools.LogManager;


public class KoDiakPack extends HiworldBaseComPack   {
	/**
	 * TODO 科迪亚克 发送(DVD主机->协议盒)
	 *@author LiYang,Power by Landsem @ShenZhen
	 */
	public KoDiakPack() {
		super((byte) 0xFF, (byte) 0x5A, (byte) 0xA5);
	}
	
	static KoDiakPack mKoDiakPack;
	@Override
	public byte getCheckBytes(byte[] dataBytes, byte comID) {
		byte resultCode = -1;
		int sum = comID;
		if (null != dataBytes) {
			sum += dataBytes.length;
			for (int index=0; index<dataBytes.length; index++) {
				sum += dataBytes[index];
			}
		}
		resultCode = (byte) ((sum- 1)& checkCode );
		return resultCode;
	}
	
	public static KoDiakPack getInstance(){
		if (mKoDiakPack==null) {
			mKoDiakPack = new KoDiakPack();
		}
		return mKoDiakPack;
	}
	
	/**
	 * 主机状态信息：源
	 */
	public static void sendSource(String source,String content ) {
		byte[] sendArray = new byte[26] ;
		byte[] dataArray =ByteUtil.StringToByteArray(source+","+content);
		System.arraycopy(dataArray, 0, sendArray, 2, dataArray.length);
		sendOrder(Constant.KoDiakComID.COMID_SEND_DVD_STATUS, null, sendArray);
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
			freqsString = (freq/100)+"Mhz";
		}else {
			freqsString = (int)freq+"Khz";
		}
		sendSource(radioType, freqsString );
	}
	
	/***媒体播放信息*/
	public static void sendMediaInfo(MediaInfo mMediaInfo ) {
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

	public static void sendOrder(byte comID, String sendValue, byte... byteData) {
		SerialManager mSerialManager = SerialManager.getInstance();
		ComBean mComBean = ComBean.createComBean(comID, sendValue, byteData);
		mSerialManager.onSendCom(mComBean);
	}
	
}
