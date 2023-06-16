package com.landsem.canbox.comparse.hiworld;

import java.util.ArrayList;
import java.util.List;

import android.view.KeyEvent;

import com.landsem.canbox.Constant;
import com.landsem.canbox.activity.BaseActivity;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.AnJiXingInfo;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CarAlarm;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CarLargeInfo;
import com.landsem.canbox.bean.CornerInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.DriveModeInfo;
import com.landsem.canbox.bean.DriverAssistInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.PeripheralInfo;
import com.landsem.canbox.bean.RadarInfo;
import com.landsem.canbox.comparse.BaseComParse;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;

/**
 * 哈弗COUPE 模块上行(协议盒->DVD主机)数据的解析处理类
 */
public class HarvardCoupeParse extends HiworldBaseParse1 {
	
	int knobvalueOder = 0;
	int knobvalue = 0;

	public HarvardCoupeParse() {
		super((byte) 0xFF, (byte) 0x5A, (byte) 0xA5);
	}

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		ByteUtil.onPrintByteArray(intackBytes,"HarvardCoupeParse--data: ");
//		BaseActivity.sendBroadcastToActivity(readMsg);
		byte comID = intackBytes[Constant.COMID];
		switch (comID) {
		case Constant.HiworldComID.COMID_INFO_BASE_CAR:
			return analyzeBaseCar(intackBytes);
		case Constant.HiworldComID.COMID_INFO_PANEL:
			return analyzePanel(intackBytes);
		case Constant.HiworldComID.COMID_INFO_KNOB:
			return analyzeKnobFuction(intackBytes);
		case Constant.HiworldComID.COMID_INFO_DETAILED_CAR:
			return analyzeDetailedCar(intackBytes);
		case Constant.HiworldComID.COMID_INFO_CAR_DEFINITE:
			return analyzeCarDefinite(intackBytes);
		case Constant.HiworldComID.COMID_INFO_RADAR:
			return analyzeRadar(intackBytes);
		}
		return null;
	}
	
	private List<BaseInfo> analyzeCarDefinite(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 发动机转速 最高位+最低位
		byte speedHigh = intackBytes[Constant.DATA2];
		byte speedLow = intackBytes[Constant.DATA3];
		int rotateSpeed = ByteUtil.HighLowByteToInt(speedHigh, speedLow);
		mCarLargeInfo.setRotateSpeed(rotateSpeed);
		// 瞬时车速 最高位+最低位
		byte instantHigh = intackBytes[Constant.DATA4];
		byte instantLow = intackBytes[Constant.DATA5];
		int instantSpeed = ByteUtil.HighLowByteToInt(instantHigh, instantLow);
		mCarLargeInfo.setInstantSpeed(instantSpeed);
		
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}
	
	private List<BaseInfo> analyzeRadar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 距离
		mRadarInfo.setBackLeftValue(get2Distanse(intackBytes[Constant.DATA0]) );
		mRadarInfo.setBackMidLeftValue(get4Distanse(intackBytes[Constant.DATA1]));
		mRadarInfo.setBackMidRightValue(get4Distanse(intackBytes[Constant.DATA2]));
		mRadarInfo.setBackRightValue(get2Distanse(intackBytes[Constant.DATA3]));
		mRadarInfo.setFrontLeftValue(get2Distanse(intackBytes[Constant.DATA4]));
		mRadarInfo.setFrontMidLeftValue(get3Distanse(intackBytes[Constant.DATA5]));
		mRadarInfo.setFrontMidRightValue(get3Distanse(intackBytes[Constant.DATA6]));
		mRadarInfo.setFrontRightValue(get2Distanse(intackBytes[Constant.DATA7]));
		baseInfolList.add(mRadarInfo);
		return baseInfolList;
	}
	
	private int get2Distanse(Byte byte1) {
		int distance = 255;
		switch (byte1) {
		case 1:
			distance = 0;
			break;
		}
		return distance;
	}
	
	private int get3Distanse(Byte byte1) {
		int distance = 255;
		switch (byte1) {
		case 1:
			distance = 0;
			break;
        case 2:
        	distance = 128;
			break;
		}
		return distance;
	}
	
	private int get4Distanse(Byte byte1) {
		int distance = 255;
		switch (byte1) {
		case 1:
			distance = 0;
			break;
        case 2:
        	distance = 85;
			break;
        case 3:
        	distance = 170;
			break;
		}
		return distance;
	}

	private List<BaseInfo> analyzeDetailedCar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 门状态
		byte data2 = intackBytes[Constant.DATA2];
		analyzeDoorInfo(baseInfolList, data2);
		return baseInfolList;
	}

	private void analyzeDoorInfo(List<BaseInfo> baseInfolList, byte data) {
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT7);
		mDoorInfo.setDriverDoor(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT6);
		mDoorInfo.setPassengerDoor(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT5);
		mDoorInfo.setLeftBackDoor(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT4);
		mDoorInfo.setRightBackDoor(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT3);
		mDoorInfo.setBackTrunk(bit3 == 1 ? true : false);
		baseInfolList.add(mDoorInfo);
	}
	
	private List<BaseInfo> analyzeKnobFuction(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		byte data0 = intackBytes[Constant.DATA0];
		byte data1 = intackBytes[Constant.DATA1];
		knobvalue = data1;
		switch (data0) {
		case  0x01:
			knobvalue = knobvalue-knobvalueOder;
			if (knobvalue>0) {
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_UP);
				// 步进值 默认最大ff
				mKeyFunctionInfo.setStepValue(knobvalue);
			}else if (knobvalue<0) {
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_DOWN);
				// 步进值  默认最大ff
				mKeyFunctionInfo.setStepValue(-knobvalue);
			} 
			knobvalueOder = data1 ; 
			break;
		}
		baseInfolList.add(mKeyFunctionInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzePanel(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		// data1 按键状态
		byte data1 = intackBytes[Constant.DATA1];
		mKeyFunctionInfo.setKeyDown(data1 == 1 ? true : false);
		// data0 方向盘按键 按键抬起时，算一次有效
		byte data0 = intackBytes[Constant.DATA0];
		if (mKeyFunctionInfo.isKeyDown()) {
			analyzePanelKeyFuction(mKeyFunctionInfo, data0);
		}
		baseInfolList.add(mKeyFunctionInfo);
		return baseInfolList;
	}

	
	private void analyzePanelKeyFuction(KeyFunctionInfo mKeyFunctionInfo,byte data0) {
		switch (data0) {
        case 6:
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_BACK);
			break;
		case 9:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
			break;
		case 0x25://NAV
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_NAVI);
			break;
		case 0x40:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		case 0x41://P01
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_COLLEC_RADIO);
			break;
		case 0x42:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_EQ);
			break;
		}
	}

	/** 车身基本信息 */
	private List<BaseInfo> analyzeBaseCar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		// data0 信号有效信息
		
		byte data0 = intackBytes[Constant.DATA0];
		analyzeData0(data0);
		
		// data3 按键状态
		byte data3 = intackBytes[Constant.DATA3];
		mKeyFunctionInfo.setKeyDown(data3 == 1 ? true : false);
		// data2 方向盘按键  按键抬起时，算一次有效
		byte data2 = intackBytes[Constant.DATA2];
		if (mKeyFunctionInfo.isKeyDown()) {
			analyzeKeyFuction(mKeyFunctionInfo,data2);
		}
		// data6 方向盘转角高位
		byte data6 = intackBytes[Constant.DATA6];
		// data7 方向盘转角低位
		byte data7 = intackBytes[Constant.DATA7];
		int leftCor = PROTOCAL_INVALID_VALUE;
		int rightCor = PROTOCAL_INVALID_VALUE;
		if (data6 < 0) {
			leftCor = ByteUtil.HighLowByteToInt(data6,data7) - 65536;
		} else {
			rightCor = ByteUtil.HighLowByteToInt(data6,data7);
		}
		mCornerInfo.setLeftCorner(leftCor);
		mCornerInfo.setRightCorner(rightCor);
		baseInfolList.add(mCarBaseInfo);
		baseInfolList.add(mCornerInfo);
		baseInfolList.add(mKeyFunctionInfo);
		return baseInfolList;
	}

	private void analyzeData0(byte data0) {
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT6);
		mCarBaseInfo.setRadarValidity(bit6 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT3);
		mCarBaseInfo.setPARK(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT2);
		mCarBaseInfo.setREV(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT1);
		mCarBaseInfo.setILL(bit1 == 1 ? true : false);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT0);
		mCarBaseInfo.setACC(bit0 == 1 ? true : false);
	}

	private void analyzeKeyFuction(KeyFunctionInfo mKeyFunctionInfo, byte data2) {
		
		switch (data2) {
		case 1:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_UP);
			break;
        case 2:
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_DOWN);
			break;
        case 5:
        	mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_ANSWER);
			break;
        case 6:
        	mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_HANGUP);
			break;
		case 8:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
			break;
		case 9:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);
			break;
		case 0x0A:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		}
	}

}
