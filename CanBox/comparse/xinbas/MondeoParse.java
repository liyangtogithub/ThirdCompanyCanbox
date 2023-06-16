package com.landsem.canbox.comparse.xinbas;

import java.util.ArrayList;
import java.util.List;

import com.landsem.canbox.Constant;
import com.landsem.canbox.Constant.MondeoComID;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.RadarInfo;
import com.landsem.canbox.comparse.BaseComParse;
import com.landsem.canbox.comparse.simple.SimpleBaseParse;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;

import android.view.KeyEvent;
/**
 *  鑫巴斯协议  ：2013蒙迪欧
 */
public final class MondeoParse extends SimpleBaseParse implements MondeoComID{
	
	public MondeoParse() {
		super((byte) 0xFF, (byte) 0x2e, (byte) 0xA5);
	}

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		ByteUtil.onPrintByteArray(intackBytes, "MondeoParse--data: ");
		byte comID = intackBytes[Constant.COMID_XINPU];
		switch (comID) {
		case COMID_INFO_STEER_KEY:
			return analyzeSteerKey(intackBytes);
		case COMID_INFO_AIR_CONDITION:
			return analyzeAirCondition(intackBytes);
		case COMID_INFO_RADAR_B:
			return analyzeRadarB(intackBytes);
		case COMID_INFO_DOOR:
			return analyzeDoor(intackBytes);
		case COMID_INFO_TEMP:
			return analyzeTemp(intackBytes);
		}
		return null;
	}

	private List<BaseInfo> analyzeTemp(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 车外温度
		byte mAirdata0 = intackBytes[Constant.DATA0_XINPU];
		mAirConditionInfo.setOutdoorTemp(mAirdata0);
		baseInfolList.add(mAirConditionInfo);
		return baseInfolList;
	}


	private List<BaseInfo> analyzeDoor(Byte[] intackBytes) {
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
		baseInfolList.add(mDoorInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeRadarB(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		mRadarInfo.setBackLeftValue(getRadar3Distanse(intackBytes[Constant.DATA0_XINPU]));
		mRadarInfo.setBackMidLeftValue(getRadar11Distanse(intackBytes[Constant.DATA1_XINPU])); 
		mRadarInfo.setBackMidRightValue(getRadar11Distanse(intackBytes[Constant.DATA2_XINPU]));
		mRadarInfo.setBackRightValue(getRadar3Distanse(intackBytes[Constant.DATA3_XINPU]));
		baseInfolList.add(mRadarInfo);
		return baseInfolList;
	}

	private int getRadar3Distanse(Byte byte1) {
		int distance = 255;
		switch (byte1) {
		case 0x1:
			distance = 0;
			break;
		case 0x2:
			distance = 125;
			break;
		case 0x3:
			distance = 255;
			break;
		}
		return distance;
	}
	
	private int getRadar11Distanse(Byte byte1) {
		int distance = 255;
		switch (byte1) {
		case 0x1:
			distance = 0;
			break;
		case 0x11:
		case 0x0:
			distance = 255;
			break;
		default:
			distance = 23*byte1;
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
		baseInfolList.add(mAirConditionInfo);
		return baseInfolList;

	}
	

	private float analyzeSeatHeatGrade(byte mAirdata) {
		float seatHeatGrade = ByteUtil.convertByteToInt(mAirdata);
		if (seatHeatGrade == 0) {
			seatHeatGrade = Constant.AIR_LOW;
		} else if (seatHeatGrade == 0xff) {
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
		// data2风速等级
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
		mAirConditionInfo.setDualSwitch(bit2 == 1 ? true : false);
		//bit0 
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT0);
		mAirConditionInfo.setBackWindowDemist(bit0 == 1 ? true : false);
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
			//mode SRC
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		case 0x13:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
			break;
		}
	}

}
