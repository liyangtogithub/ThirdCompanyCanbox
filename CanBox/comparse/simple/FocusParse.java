package com.landsem.canbox.comparse.simple;

import java.util.ArrayList;
import java.util.List;

import com.landsem.canbox.Constant;
import com.landsem.canbox.Constant.FocusComID;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CarLargeInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.RadarInfo;
import com.landsem.canbox.pack.simple.FocusPack;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;

import android.view.KeyEvent;
/**
 *  欣朴协议  ：福特福克斯
 */
public final class FocusParse extends SimpleBaseParse implements FocusComID{
	
	
	public FocusParse() {
		super((byte) 0xFF, (byte) 0x2e, (byte) 0xA5);
	}

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		ByteUtil.onPrintByteArray(intackBytes, "FocusParse--data: ");
		byte comID = intackBytes[Constant.COMID_XINPU];
		switch (comID) {
		case COMID_INFO_STEER_KEY:
			return analyzeSteerKey(intackBytes);
		case COMID_INFO_AIR_CONDITION:
			FocusPack.askCarInfoOrder();
			return analyzeAirCondition(intackBytes);
		case COMID_INFO_RADAR_B:
			return analyzeRadarB(intackBytes);
		case COMID_INFO_RADAR_F:
			return analyzeRadarF(intackBytes);
		case COMID_INFO_BASE_CAR:
			return analyzeBaseCar(intackBytes);
		case COMID_INFO_CAR:
			return analyzeCarInfo(intackBytes);
		}
		return null;
	}

	private List<BaseInfo> analyzeCarInfo(Byte[] byteArray) {
		List<BaseInfo> infoList = new ArrayList<BaseInfo>();
		byte orderByte = byteArray[Constant.DATA0_XINPU];
		if (orderByte==0x02) {
			byte high = 0;
			byte low = 0;
			int data = 0;
			byte unitByte = byteArray[Constant.DATA1_XINPU];
			byte speedUnitByte = ByteUtil.onCheckOutBitAtIndex(unitByte, Constant.BIT0);
			String speedUnit = "km/h";
			if (speedUnitByte == 0) {
				speedUnit = "km/h";
			} else {
				speedUnit = "mph";
			}
			mCarLargeInfo.setSpeedUnit(speedUnit);
			// 瞬时车速 最高位+最低位
			high = byteArray[Constant.DATA3_XINPU];
			low = byteArray[Constant.DATA2_XINPU];
			data = ByteUtil.HighLowByteToInt(high, low)/100;
			mCarLargeInfo.setInstantSpeed(data);
			//发动机转速
			high = byteArray[Constant.DATA5_XINPU];
			low = byteArray[Constant.DATA4_XINPU];
			data = ByteUtil.HighLowByteToInt(high, low);
			mCarLargeInfo.setRotateSpeed(data);
		}
		infoList.add(mCarLargeInfo);
		return infoList;
	}

	private List<BaseInfo> analyzeBaseCar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data = intackBytes[Constant.DATA0_XINPU];
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
//		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT3);
//		mDoorInfo.setEngineHood(bit2 == 1 ? true : false);
		byte data1 = intackBytes[Constant.DATA1_XINPU];
		byte bit2Data1 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT2);
		mCarBaseInfo.setILL(bit2Data1 == 1 ? true : false);
		byte bit0Data1 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT0);
		mCarBaseInfo.setREV(bit0Data1 == ON);
		baseInfolList.add(mCarBaseInfo);
		baseInfolList.add(mDoorInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeRadarF(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		mRadarInfo.setFrontLeftValue(getRadarDistanse(intackBytes[Constant.DATA0_XINPU]));
		mRadarInfo.setFrontMidLeftValue(getRadarDistanse(intackBytes[Constant.DATA1_XINPU])); 
		mRadarInfo.setFrontMidRightValue(getRadarDistanse(intackBytes[Constant.DATA2_XINPU]));
		mRadarInfo.setFrontRightValue(getRadarDistanse(intackBytes[Constant.DATA3_XINPU]));
		baseInfolList.add(mRadarInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeRadarB(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		mRadarInfo.setBackLeftValue(getRadarDistanse(intackBytes[Constant.DATA0_XINPU]));
		mRadarInfo.setBackMidLeftValue(getRadarDistanse(intackBytes[Constant.DATA1_XINPU])); 
		mRadarInfo.setBackMidRightValue(getRadarDistanse(intackBytes[Constant.DATA2_XINPU]));
		mRadarInfo.setBackRightValue(getRadarDistanse(intackBytes[Constant.DATA3_XINPU]));
		baseInfolList.add(mRadarInfo);
		return baseInfolList;
	}

	private int getRadarDistanse(Byte byte1) {
		int distance = 255;
		switch (byte1) {
		case 0:
		case 0x1f:
			distance = 255;
			break;
       default:
        	distance = 8*byte1;
			break;
		}
		return distance;
	}

	private List<BaseInfo> analyzeAirCondition(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// data0
		byte mAirdata0 = intackBytes[Constant.DATA0_XINPU];
		analyzeAirData0(mAirdata0);
		// data1
		byte mAirdata1 = intackBytes[Constant.DATA1_XINPU];
		analyzeAirData1( mAirdata1);
		// data2 左边座椅温度设数值
		byte mAirdata2 = intackBytes[Constant.DATA2_XINPU];
		float frontLeftSeatSetTemp = analyzeSeatHeatGrade(mAirdata2);
		mAirConditionInfo.setFrontLeftSeatSetTemp(frontLeftSeatSetTemp);
		// data3 右边座椅温度设数值
		byte mAirdata3 = intackBytes[Constant.DATA3_XINPU];
		float frontRightSeatSetTemp = analyzeSeatHeatGrade(mAirdata3);
		mAirConditionInfo.setFrontRightSeatSetTemp(frontRightSeatSetTemp);
		//data4
		byte mAirdata4 = intackBytes[Constant.DATA4_XINPU];
		// A/C-MAX 
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata4, Constant.BIT2);
		mAirConditionInfo.setAcMaxSwitch(bit2 == 1);
		// 温度单位
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata4, Constant.BIT6);
		mAirConditionInfo.setCentigrade(bit6 == 0);
		// 车外温度
		byte outdoorTemp = intackBytes[Constant.DATA5_XINPU];
		mAirConditionInfo.setOutdoorTemp(outdoorTemp);
		baseInfolList.add(mAirConditionInfo);
		return baseInfolList;
	}
	
	private float analyzeSeatHeatGrade(byte mAirdata) {
		float seatHeatGrade = ByteUtil.convertByteToInt(mAirdata);
		if (seatHeatGrade == 0) {
			seatHeatGrade = Constant.AIR_LOW;
		} else if (seatHeatGrade == 0x7F) {
			seatHeatGrade = Constant.AIR_HIGH;
		} else {
			seatHeatGrade = (float) (seatHeatGrade/2);
		}
		return seatHeatGrade;

	}
	
	private void analyzeAirData1(byte mAirdata) {
		// 前除霜
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT7);
		mAirConditionInfo.setFrontWindowDemist(bit7 == 1 );
		// 吹头
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setLeftWindBlowHead(bit6 == 1);
		mAirConditionInfo.setRightWindBlowHead(bit6 == 1);
		// 吹脚
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setLeftWindBlowFoot(bit5 == 1);
		mAirConditionInfo.setRightWindBlowFoot(bit5 == 1);
		// 风速等级
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT0);
		byte windGrade = (byte) (bit3*8 + bit2*4 + bit1*2 + bit0);
		mAirConditionInfo.setLeftWindGrade(windGrade);
		mAirConditionInfo.setRightWindGrade(windGrade);
		mAirConditionInfo.setWindGradeTotal((byte) 7);
	}
	
	
	
	private void analyzeAirData0(byte mAirdata) {
		// 开关
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT7);
		mAirConditionInfo.setSwitchAir(bit7 == 1 );
		// A/C
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setAcEnable(bit6 == 1 );
		//内外循环
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setCircleOut(bit5==0 );
		// Auto
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		mAirConditionInfo.setAutoSwitch1(bit3 == 1);
		// Dual
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		mAirConditionInfo.setDualSwitch(bit2 == 1 );
		//bit1 MAX bu dong
		//byte bit1 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT1);
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
			//挂电话
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_HANGUP_NEXT);
			break;
		case 4:
			//接电话
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_ANSWER_PREV);
			break;
		case 7:
			//SRC
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		}
	}

}
