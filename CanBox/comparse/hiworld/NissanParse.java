package com.landsem.canbox.comparse.hiworld;

import java.util.ArrayList;
import java.util.List;

import android.view.KeyEvent;

import com.landsem.canbox.Constant;
import com.landsem.canbox.activity.BaseActivity;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CarLargeInfo;
import com.landsem.canbox.bean.CornerInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.PeripheralInfo;
import com.landsem.canbox.bean.RadarInfo;
import com.landsem.canbox.comparse.BaseComParse;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;

/**
 * TODO 日产 模块上行(协议盒->DVD主机)数据的解析处理类
 */
public class NissanParse extends HiworldBaseParse1  {

	public NissanParse() {
		super((byte) 0xFF, (byte) 0xAA, (byte) 0x55);
	}
	int knobvalueOder = 0;
	int knobvalue = 0;

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		String readMsg = ByteUtil.onPrintByteArray(intackBytes,
				"NissanParse--data: ");
//		BaseActivity.sendBroadcastToActivity(readMsg);
		byte comID = intackBytes[Constant.COMID];
		switch (comID) {
		case Constant.NissanComID.COMID_INFO_BASE_CAR:
			return analyzeBaseCar(intackBytes);
//		case Constant.NissanComID.COMID_INFO_CAMERA:
//			return analyzeCamera(intackBytes);
//		case Constant.NissanComID.COMID_INFO_SOFT_VERSION:
//			return analyzeVertion(intackBytes);
//		case Constant.NissanComID.COMID_INFO_MEDIA_SOURCE:
//			 return analyzeMediaSource(intackBytes);
//		case Constant.NissanComID.COMID_INFO_AMPLIFIER:
//			return analyzeAmplifier(intackBytes);
		case Constant.NissanComID.COMID_INFO_RADAR_FB:
			return analyzeRadarFB(intackBytes);
		case Constant.NissanComID.COMID_INFO_KNOB:
			return analyzePanelKnob(intackBytes);
		}

		return null;
	}
	private List<BaseInfo> analyzePanelKnob(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		byte data0 =intackBytes[Constant.DATA0];
		byte data1 =intackBytes[Constant.DATA1];
		knobvalue = data1;
		switch (data0) {
		case  0x03:
		case  0x04:
			knobvalue = knobvalue-knobvalueOder;
			if (knobvalue>0) {
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_UP);
				mKeyFunctionInfo.setStepValue(knobvalue);
			}else if (knobvalue<0) {
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_DOWN);
				mKeyFunctionInfo.setStepValue(-knobvalue);
			} 
			knobvalueOder = data1 ; 
			break;
		}
		baseInfolList.add(mKeyFunctionInfo);
		return baseInfolList;
	}
	
	private List<BaseInfo> analyzeRadarFB(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		mRadarInfo.setBackLeftValue(get3Distanse(intackBytes[Constant.DATA0]));
		mRadarInfo.setBackMidLeftValue(get4Distanse(intackBytes[Constant.DATA1])); 
		mRadarInfo.setBackMidRightValue(get4Distanse(intackBytes[Constant.DATA2]));
		mRadarInfo.setBackRightValue(get3Distanse(intackBytes[Constant.DATA3]));
		mRadarInfo.setFrontLeftValue(get3Distanse(intackBytes[Constant.DATA4]));
		mRadarInfo.setFrontMidLeftValue(get4Distanse(intackBytes[Constant.DATA5]));
		mRadarInfo.setFrontMidRightValue(get4Distanse(intackBytes[Constant.DATA6]));
		mRadarInfo.setFrontRightValue(get3Distanse(intackBytes[Constant.DATA7]));
		baseInfolList.add(mRadarInfo);
		return baseInfolList;
	}
	
	private int get4Distanse(Byte byte1) {
		int distance = 255;
		switch (byte1) {
		case 1:
			distance = 255;
			break;
        case 2:
        	distance = 128;
			break;
        case 3:
        	distance = 64;
			break;
        case 4:
        	distance = 0;
			break;
		}
		return distance;
	}
	private int get3Distanse(Byte byte1) {
		int distance = 255;
		switch (byte1) {
		case 1:
			distance = 255;
			break;
        case 2:
        	distance = 128;
			break;
        case 3:
        	distance = 0;
			break;
		}
		return distance;
	}
	private List<BaseInfo> analyzeMediaSource(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte mdata0 = intackBytes[Constant.DATA0];
		mCarBaseInfo.setMediaSource(mdata0);
		baseInfolList.add(mCarBaseInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeCamera(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		PeripheralInfo mPeripheralInfo = new PeripheralInfo();
		byte mdata0 = intackBytes[Constant.DATA0];
		mPeripheralInfo.setCameraOn( mdata0==1?true:false );
		
		baseInfolList.add(mPeripheralInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeAmplifier(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data0 = intackBytes[Constant.DATA0];
		mCarBaseInfo.setSoundValue(data0);
		byte data1 = intackBytes[Constant.DATA1];
		mCarBaseInfo.setSoundLRValue(data1);
		byte data2 = intackBytes[Constant.DATA2];
		mCarBaseInfo.setSoundFBValue(data2);
		byte data3 = intackBytes[Constant.DATA3];
		mCarBaseInfo.setSoundLowValue(data3);
		byte data4 = intackBytes[Constant.DATA4];
		mCarBaseInfo.setSoundMidValue(data4);
		byte data5 = intackBytes[Constant.DATA5];
		mCarBaseInfo.setSoundHigValue(data5);
		byte data6 = intackBytes[Constant.DATA6];
		byte bit4 = ByteUtil.onCheckOutBitAtIndex( data6,Constant.BIT4);
		mCarBaseInfo.setSoundField(bit4==1?true:false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex( data6,Constant.BIT3);
		mCarBaseInfo.setBosePoint(bit3==1?true:false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex( data6,Constant.BIT2);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex( data6,Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex( data6,Constant.BIT0);
		mCarBaseInfo.setLinkageVolume((byte) (bit2*4+bit1*2+bit0));
		byte data7 = intackBytes[Constant.DATA7];
		mCarBaseInfo.setSurroundVolume(data7);
		
		baseInfolList.add(mCarBaseInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeVertion(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		int dataLength = intackBytes[Constant.LENGTH];
		byte[] dataBytes = new byte[dataLength];
		for (int i = 0; i < dataLength; i++) {
			dataBytes[i] = (byte) intackBytes[i + Constant.DATA0];
		}
		String boxVertionString = ByteUtil.byteToASCII(dataBytes);
		mCarLargeInfo.setBoxVertion(boxVertionString);
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	/** 车身基本信息 */
	private List<BaseInfo> analyzeBaseCar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		// data0 信号有效信息
		byte data0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT7);
		mCarBaseInfo.setCarTypeNissan(bit7);
		// data2 车速
		byte data1 = intackBytes[Constant.DATA1];
		mCarLargeInfo.setInstantSpeed(ByteUtil.convertByteToInt(data1));
		// data3 按键按下
		byte data3 = intackBytes[Constant.DATA3];
		mKeyFunctionInfo.setKeyDown(data3 == 1 ? true : false);
		// data2 方向盘按键
		if (!mKeyFunctionInfo.isKeyDown()) {
			byte data2 = intackBytes[Constant.DATA2];
			analyzeKeyFuction(mKeyFunctionInfo,data2);
		}
		// data4 方向盘转角高位
		byte data4 = intackBytes[Constant.DATA4];
		// data5 方向盘转角低位
		byte data5 = intackBytes[Constant.DATA5];
		int leftCor = PROTOCAL_INVALID_VALUE;
		int rightCor = PROTOCAL_INVALID_VALUE;
		if (data4 < 0) {
			leftCor = ByteUtil.HighLowByteToInt(data4,data5) - 65536;
		} else {
			rightCor = ByteUtil.HighLowByteToInt(data4,data5);
		}
		mCornerInfo.setLeftCorner(leftCor);
		mCornerInfo.setRightCorner(rightCor);
		// data8 发动机转速  
		int data8 = ByteUtil.convertByteToInt(intackBytes[Constant.DATA8]);
		// data9发动机转速
		int data9 = ByteUtil.convertByteToInt(intackBytes[Constant.DATA9]);
		mCarLargeInfo.setRotateSpeed(data8*256+data9);  
		
		baseInfolList.add(mCarBaseInfo);
		baseInfolList.add(mCornerInfo);
		baseInfolList.add(mKeyFunctionInfo);
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}
	
private void analyzeKeyFuction(KeyFunctionInfo mKeyFunctionInfo, byte data2) {
		
		switch (data2) {
		case 1:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_UP);
			break;
        case 2:
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_DOWN);
			break;
        case 4:
        	mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOICE);
			break;
        case 5:
        	mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_ANSWER);
			break;
        case 6:
        	mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_HANGUP);
			break;
        case 0X0A:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
        case 0x10:
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_BACK);
			break;
		}
	}

	/**
	 * 校验数据是否正确
	 */
	@Override
	public boolean onCheckBytesValidity(Byte[] orderBytes) {
		boolean resultCode = false;
		if (null != orderBytes && 3 < orderBytes.length) {
			int sum = 0;
			for (int index = 2; index < orderBytes.length - 1; index++) {
				sum += orderBytes[index];
			}
			byte checkSum = (byte) ((sum & checkCode) - 1);
			resultCode = (orderBytes[orderBytes.length - 1]) == checkSum;
			LogManager.d("NissanParse  onCheckBytesValidity  check_Sum:  "
					+ checkSum + "   check_bit:"
					+ orderBytes[orderBytes.length - 1]);
		}
		return resultCode;
	}

}
