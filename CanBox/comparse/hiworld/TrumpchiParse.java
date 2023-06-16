package com.landsem.canbox.comparse.hiworld;

import java.util.ArrayList;
import java.util.List;

import android.view.KeyEvent;

import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CarLargeInfo;
import com.landsem.canbox.bean.CornerInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.RadarInfo;
import com.landsem.canbox.comparse.BaseComParse;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;

/**
 * 传祺  模拟器的门信息有问题
 */
public class TrumpchiParse extends HiworldBaseParse1 {
	
	int knobvalueOder = 0;
	int knobvalue = 0;

	public TrumpchiParse() {
		super((byte) 0xFF, (byte) 0x5A, (byte) 0xA5);
	}

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		ByteUtil.onPrintByteArray(intackBytes,"Trumpchi--data: ");
		byte comID = intackBytes[Constant.COMID];
		switch (comID) {
		case Constant.HiworldComID.COMID_INFO_BASE_CAR:
			return analyzeBaseCar(intackBytes);
		case Constant.HiworldComID.COMID_INFO_DETAILED_CAR:
			return analyzeDetailedCar(intackBytes);
		case Constant.HiworldComID.COMID_INFO_AIR_CONDITION:
			return analyzeAirCondition(intackBytes);
		case Constant.HiworldComID.COMID_INFO_CAR_DEFINITE:
			return analyzeCarDefinite(intackBytes);
		case Constant.HiworldComID.COMID_INFO_RADAR:
			return analyzeRadar(intackBytes);
		case Constant.HiworldComID.COMID_INFO_PANEL:
			return analyzePanel(intackBytes);
		case Constant.HiworldComID.COMID_INFO_KNOB:
			return analyzeKnobFuction(intackBytes);
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
	
	private List<BaseInfo> analyzeAirCondition(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// data0
		byte mAirdata0 = intackBytes[Constant.DATA0];
		analyzeAirData0(mAirdata0);
		// data1
		byte mAirdata1 = intackBytes[Constant.DATA1];
		analyzeAirData1( mAirdata1);
		// data2
		byte mAirdata2 = intackBytes[Constant.DATA2];
		analyzeAirData2(mAirdata2,mAirdata1);
		// data4
		byte mAirdata4 = intackBytes[Constant.DATA4];
		analyzeAirData4(mAirdata4);
		// data5 前排风速
		byte mAirdata5 = intackBytes[Constant.DATA5];
		mAirConditionInfo.setLeftWindGrade(mAirdata5);
		mAirConditionInfo.setRightWindGrade(mAirdata5);
		mAirConditionInfo.setWindGradeTotal(7);
		// data6 左边座椅温度设数值
		byte mAirdata6 = intackBytes[Constant.DATA6];
		float frontLeftSeatSetTemp = analyzeSeatHeatGrade(mAirdata6);
		mAirConditionInfo.setFrontLeftSeatSetTemp(frontLeftSeatSetTemp);
		// data7 右边座椅温度设数值
		byte mAirdata7 = intackBytes[Constant.DATA7];
		float frontRightSeatSetTemp = analyzeSeatHeatGrade(mAirdata7);
		mAirConditionInfo.setFrontRightSeatSetTemp(frontRightSeatSetTemp);
		baseInfolList.add(mAirConditionInfo);
		return baseInfolList;
	}
	
	private float analyzeSeatHeatGrade(byte mAirdata6) {
		float seatHeatGrade = ByteUtil.convertByteToInt(mAirdata6);
		if (seatHeatGrade == 0xFE) {
			seatHeatGrade = Constant.AIR_LOW;
		} else if (seatHeatGrade == 0xFF) {
			seatHeatGrade = Constant.AIR_HIGH;
		} else {
			seatHeatGrade = seatHeatGrade / 2;
		}
		return seatHeatGrade;
	}
	
	private void analyzeAirData4(byte mAirdata4) {
		initWindMode();
		switch (mAirdata4) {
		// 吹脚
		case 3:
			mAirConditionInfo.setLeftWindBlowFoot(true);
			mAirConditionInfo.setRightWindBlowFoot(true);
			break;
		// 吹身吹脚
		case 5:
			mAirConditionInfo.setLeftWindBlowBody(true);
			mAirConditionInfo.setRightWindBlowBody(true);
			mAirConditionInfo.setLeftWindBlowFoot(true);
			mAirConditionInfo.setRightWindBlowFoot(true);
			break;
		// 吹身
		case 6:
			mAirConditionInfo.setLeftWindBlowBody(true);
			mAirConditionInfo.setRightWindBlowBody(true);
			break;
		// 吹头 
		case 0x0B:
			mAirConditionInfo.setLeftWindBlowHead(true);
			mAirConditionInfo.setRightWindBlowHead(true);
			break;
		// 吹头 吹脚
		case 0x0C:
			mAirConditionInfo.setLeftWindBlowHead(true);
			mAirConditionInfo.setRightWindBlowHead(true);
			mAirConditionInfo.setLeftWindBlowFoot(true);
			mAirConditionInfo.setRightWindBlowFoot(true);
			break;
		// 吹头 吹身
		case 0x0D:
			mAirConditionInfo.setLeftWindBlowHead(true);
			mAirConditionInfo.setRightWindBlowHead(true);
			mAirConditionInfo.setLeftWindBlowBody(true);
			mAirConditionInfo.setRightWindBlowBody(true);
			break;
		// 吹头 吹身 吹脚
		case 0x0E:
			mAirConditionInfo.setLeftWindBlowHead(true);
			mAirConditionInfo.setRightWindBlowHead(true);
			mAirConditionInfo.setLeftWindBlowBody(true);
			mAirConditionInfo.setRightWindBlowBody(true);
			mAirConditionInfo.setLeftWindBlowFoot(true);
			mAirConditionInfo.setRightWindBlowFoot(true);
			break;
		}
	}
	
	private void initWindMode() {
		mAirConditionInfo.setLeftWindBlowHead(false);
		mAirConditionInfo.setLeftWindBlowFoot(false);
		mAirConditionInfo.setRightWindBlowHead(false);
		mAirConditionInfo.setRightWindBlowFoot(false);
		mAirConditionInfo.setLeftWindBlowBody(false);
		mAirConditionInfo.setRightWindBlowBody(false);
	}

	private void analyzeAirData2(byte mAirdata, byte mAirdata1) {
		// 除雾
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setBackWindowDemist(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT4);
		mAirConditionInfo.setFrontWindowDemist(bit4 == 1 ? true : false);
		//右座椅加热等级
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		mAirConditionInfo.setRightSeatHeatGrade(bit3 * 2 + bit2);
		//左座椅加热等级
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT0);
	    mAirConditionInfo.setLeftSeatHeatGrade(bit1 * 2 + bit0);
	}
	
	private void analyzeAirData1(byte mAirdata) {
		// 循环模式
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT4);
		mAirConditionInfo.setCircleOut(bit4==1);
		// Auto
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		mAirConditionInfo.setAutoSwitch1(bit3 == 1 ? true : false);
	}
	
	private void analyzeAirData0(byte mAirdata) {
		//AC
		byte bit1 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT0);
		byte acValue = (byte)(bit1*2+bit0);
	    mAirConditionInfo.setAcEnable(acValue==1);
		// dual
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		mAirConditionInfo.setDualSwitch(bit2==1);
		// AcMax
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setAcMaxSwitch(bit5==1);
		// 空调开关
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setSwitchAir(bit6 == 1 ? true : false);
	}
	
	private List<BaseInfo> analyzeRadar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 距离
		mRadarInfo.setBackLeftValue(ByteUtil.convertByteToInt(intackBytes[Constant.DATA0]));
		mRadarInfo.setBackMidLeftValue(ByteUtil.convertByteToInt(intackBytes[Constant.DATA1]));
		mRadarInfo.setBackMidRightValue(ByteUtil.convertByteToInt(intackBytes[Constant.DATA2]));
		mRadarInfo.setBackRightValue(ByteUtil.convertByteToInt(intackBytes[Constant.DATA3]));
		baseInfolList.add(mRadarInfo);
		return baseInfolList;
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
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT2);
		mDoorInfo.setEngineHood(bit2 == 1 ? true : false);
		baseInfolList.add(mDoorInfo);
	}
	
	private List<BaseInfo> analyzeKnobFuction(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		byte data0 = intackBytes[Constant.DATA0];
		int data1 = ByteUtil.convertByteToInt(intackBytes[Constant.DATA1]);
		LogManager.d("data1 :  "+data1);
		LogManager.d("knobvalueOder :  "+knobvalueOder);
		switch (data0) {
		case  0x01:
			knobvalue = data1;
			knobvalue = knobvalue-knobvalueOder;
			LogManager.d("knobvalue :  "+knobvalue);
			knobvalueOder = data1 ; 
			if (knobvalue>0) {
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_UP);
				// 步进值 默认最大ff
				mKeyFunctionInfo.setStepValue(knobvalue);
			}else if (knobvalue<0) {
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_DOWN);
				// 步进值  默认最大ff
				mKeyFunctionInfo.setStepValue(-knobvalue);
			} 
			
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
		case 1:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_POWER);
			break;
		case 2:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
			break;
		case 3:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);
			break;
		case 4:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_COLLEC_RADIO);
			break;	
		case 9:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
			break;
		case 0x25://NAV
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_NAVI);
			break;
		case 0x2D:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_BACK);
			break;
		case 0x38:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		case 0x15://APS
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_SCAN_ALL);
			break;
		case 0x16://TUNE SEL
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_EQ);
			break;
		case 0x36://SET
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_SET);
			break;
		case 0x39://SCAN	
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_SCAN_UP);
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
			leftCor = (ByteUtil.HighLowByteToInt(data6,data7) - 65536)/10;
		} else {
			rightCor = ByteUtil.HighLowByteToInt(data6,data7)/10;
		}
		mCornerInfo.setLeftCorner(leftCor);
		mCornerInfo.setRightCorner(rightCor);
		baseInfolList.add(mCarBaseInfo);
		baseInfolList.add(mCornerInfo);
		baseInfolList.add(mKeyFunctionInfo);
		return baseInfolList;
	}

	private void analyzeData0(byte data0) {
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT3);
		mCarBaseInfo.setPARK(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT2);
		mCarBaseInfo.setREV(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT1);
		mCarBaseInfo.setILL(bit1 == 1 ? true : false);
	}

	private void analyzeKeyFuction(KeyFunctionInfo mKeyFunctionInfo, byte data2) {
		
		switch (data2) {
		case 1:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_UP);
			break;
        case 2:
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_DOWN);
			break;
        case 3:
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
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
