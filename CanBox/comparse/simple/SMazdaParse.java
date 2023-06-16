package com.landsem.canbox.comparse.simple;

import java.util.ArrayList;
import java.util.List;

import android.view.KeyEvent;

import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CDInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.RadarInfo;
import com.landsem.canbox.comparse.BaseComParse;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;
/**
 *  欣朴协议  ：马自达第三代
 */
public class SMazdaParse extends SimpleBaseParse {
	public SMazdaParse() {
		super((byte) 0xFF, (byte) 0x2e, (byte) 0xA5);
	}
	CDInfo mCDInfo = new CDInfo();

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		ByteUtil.onPrintByteArray(intackBytes, "SMazdaParse--data: ");
		byte comID = intackBytes[Constant.COMID_XINPU];
		switch (comID) {
		case Constant.MazdaSimple.DATA_TYPE_KEY:
			return analyzeSteerKey(intackBytes);
		case Constant.MazdaSimple.DATA_TYPE_BASE:
			return analyzeBaseCar(intackBytes);
		case Constant.MazdaSimple.DATA_CD_STATE:
			return analyzeCdState(intackBytes);
		case Constant.MazdaSimple.DATA_CD_TIME:
			return analyzeCdTime(intackBytes);
		case Constant.MazdaSimple.DATA_CD_CONTENT:
			return analyzeCdContent(intackBytes);
		}
		return null;
	}
	
	private List<BaseInfo> analyzeCdState(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		int data0 = ByteUtil.convertByteToInt(intackBytes[Constant.DATA0_XINPU]);
		mCDInfo.setComIdType(Constant.Mazda.DATA_PLAY_INFO);
		initCdPlaySstate();
		switch (data0) {
		case 0x00:
		case 0x01:
			mCDInfo.setDiscOut(true);
			break;
		case 0x04:
			mCDInfo.setComIdType(Constant.Mazda.DATA_DEVICE_INFO);
			mCDInfo.setCdOk(true);
			break;
		case 0x05:
			mCDInfo.setPlay(true);
			break;
		case 0x06:
			mCDInfo.setPause(true);
			break;
		}
		baseInfolList.add(mCDInfo);
		return baseInfolList;
	}
	
	private void initCdPlaySstate() {
		mCDInfo.setStop(false);
		mCDInfo.setPause(false);
		mCDInfo.setPlay(false);
		mCDInfo.setDiscOut(false);
		mCDInfo.setReading(false);
	}

	private List<BaseInfo> analyzeCdTime(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		mCDInfo.setComIdType(Constant.Mazda.DATA_TXT_INFO);
		// 当前曲目
		byte high = intackBytes[Constant.DATA0_XINPU];
		byte low = intackBytes[Constant.DATA1_XINPU];
		int current = ByteUtil.HighLowByteToInt(high, low);
		mCDInfo.setCurSong(current);
		// 曲目总时间
		byte min = intackBytes[Constant.DATA3_XINPU];
		byte sec = intackBytes[Constant.DATA4_XINPU];
		mCDInfo.setSongAllTime(min*60+sec);
		// 当前曲目时间
		min = intackBytes[Constant.DATA6_XINPU];
		sec = intackBytes[Constant.DATA7_XINPU];
		mCDInfo.setCurSongTime(min*60+sec);
		baseInfolList.add(mCDInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeCdContent(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		mCDInfo.setComIdType(Constant.Mazda.DATA_TXT_INFO);
		analyzeTxtInfoData0(intackBytes,mCDInfo);
		analyzeTxtInfoData1(intackBytes,mCDInfo);
		
		baseInfolList.add(mCDInfo);
		return baseInfolList;
	}
	
	private void analyzeTxtInfoData1(Byte[] intackBytes, CDInfo mCDInfo) {
		byte data1 = intackBytes[Constant.DATA1_XINPU];
		byte codeType = data1;
		if (codeType==1) {
			codeType = Constant.TEXT_STATE_ASCII;
			mCDInfo.setCodeType(codeType);
			analyzeTxtContentInfo(intackBytes,mCDInfo);
		}
	}
	
	private void analyzeTxtContentInfo(Byte[] intackBytes, CDInfo mCDInfo) {
		switch (mCDInfo.getCodeType()) {
		case Constant.TEXT_STATE_ASCII:
			analyzeText(intackBytes,mCDInfo,"gb2312");
			break;
        case Constant.TEXT_STATE_UTF8:
        	analyzeText(intackBytes,mCDInfo,"UTF-8");
			break;
        case Constant.TEXT_STATE_UNICODE_S:
        	analyzeText(intackBytes,mCDInfo,"UTF-16LE");
			break;
        case Constant.TEXT_STATE_UNICODE_B:
        	analyzeText(intackBytes,mCDInfo,"UTF-16BE");
			break;
		}
	}
	
	private void analyzeText(Byte[] intackBytes, CDInfo mCDInfo,String codeModeString) {
		int dataLength = intackBytes[Constant.LENGTH_XINPU]-2;
		int asciiLength = 0;
		byte[] dataBytes = new byte[dataLength];
		for (int i = 0; i < dataLength; i++) {
			dataBytes[i] =  (byte)intackBytes[ i+Constant.DATA2_XINPU];
		}
		String contentString = ByteUtil.byteArrayToChinese(dataBytes,codeModeString);
		mCDInfo.setTextContent(contentString);
	}

	private void analyzeTxtInfoData0(Byte[] intackBytes, CDInfo mCDInfo) {
		byte data0 = intackBytes[Constant.DATA0_XINPU];
		if (data0 == 1) {
			mCDInfo.setTextType(Constant.TEXT_NAME_SONG);
		}else if (data0 == 3) {
			mCDInfo.setTextType(Constant.TEXT_NAME_ART);
		} 
	}

	private List<BaseInfo> analyzeBaseCar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data = intackBytes[Constant.DATA0_XINPU];
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT0);
		//车门无效
		if (bit0!=0) {
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT7);
		mDoorInfo.setPassengerDoor(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT6);
		mDoorInfo.setDriverDoor(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT5);
		mDoorInfo.setRightBackDoor(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT4);
		mDoorInfo.setLeftBackDoor(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT3);
		mDoorInfo.setBackTrunk(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT2);
		mDoorInfo.setEngineHood(bit2 == 1 ? true : false);
		baseInfolList.add(mDoorInfo);
		}
		byte data1 = intackBytes[Constant.DATA1_XINPU];
		byte bit2Data1 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT2);
		mCarBaseInfo.setILL(bit2Data1 == 0 ? true : false);
		byte bit0Data1 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT0);
		mCarBaseInfo.setREV(bit0Data1 == ON);
		baseInfolList.add(mCarBaseInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeSteerKey(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		
		// data1 按键状态 
		byte data1 = intackBytes[Constant.DATA1_XINPU];
		if (data1 == 1) {
			mKeyFunctionInfo.setKeyDown(true);
		}else if (data1 ==2) {
			mKeyFunctionInfo.setSteeringKeyLongDown(true);
		}
		byte data0 = intackBytes[Constant.DATA0_XINPU];
		if (mKeyFunctionInfo.isKeyDown()||mKeyFunctionInfo.isSteeringKeyLongDown()) {
			analyzeKeyFuction(mKeyFunctionInfo, data0);
		}
		baseInfolList.add(mKeyFunctionInfo);
		return baseInfolList;
	}
	
	private void analyzeKeyFuction(KeyFunctionInfo mKeyFunctionInfo, byte data0) {
		switch (data0) {
		case 1:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_UP);
			break;
		case 2:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_DOWN);
			break;
		case 3:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);
			break;
		case 4:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
			break;
		case 6:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
			break;
		case 9:
			mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_ANSWER);
			break;	
		case 0x0a:
			mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_HANGUP);
			break;
		case 0x08:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOICE);
			break;	
		}
	}

}
