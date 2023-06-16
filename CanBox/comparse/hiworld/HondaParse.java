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

public class HondaParse extends HiworldBaseParse2 {
	public HondaParse() {
		super((byte) 0xFF, (byte) 0x5A, (byte) 0xA5);
	}

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		ByteUtil.onPrintByteArray(intackBytes, "HondaParse--data: ");
		byte comID = intackBytes[Constant.COMID];
		switch (comID) {
		case Constant.IHondaComID.COMID_INFO_BASE_CAR:
			return analyzeBaseCar(intackBytes);
		case Constant.IHondaComID.COMID_INFO_CAR_DEFINITE:
			return analyzeDetailedCar(intackBytes);
		case Constant.IHondaComID.COMID_INFO_CURRENT_OIL_AND_MILES:
			return analyzeCurrentOilAndMiles(intackBytes);
		case Constant.IHondaComID.COMID_INFO_AIR_CONDITION:
			return analyzeAirCondition(intackBytes);
		case Constant.IHondaComID.COMID_INFO_RADAR:
			return analyzeRadarFB(intackBytes);
		}
		return null;
	}
	

	private List<BaseInfo> analyzeCurrentOilAndMiles(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 平均油耗 最高位+最低位
		byte hexHigh = 0;
		byte hexLow = 0;
		hexHigh = intackBytes[Constant.DATA1];
		hexLow = intackBytes[Constant.DATA2];
		float averageFuel = ByteUtil.HighLowByteToInt(hexHigh, hexLow) / 10f;
		mCarLargeInfo.setAverageFuel(averageFuel);
		// 续航里程  最高位+最低位
		hexHigh = intackBytes[Constant.DATA10];
		hexLow = intackBytes[Constant.DATA11];
		int enduranceMileage = ByteUtil.HighLowByteToInt(hexHigh, hexLow);
		mCarLargeInfo.setEnduranceMileage(enduranceMileage);
		// 里程单位
		byte unitByte = intackBytes[Constant.DATA12];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex( unitByte,Constant.BIT7);
		String distanceUnit = "km";
		if (bit7 == 0) {
			distanceUnit = "km";
		} else {
			distanceUnit = "mile";
		}
		mCarLargeInfo.setDistanceUnit(distanceUnit);
		// 油耗单位
		byte bit5 = ByteUtil.onCheckOutBitAtIndex( unitByte,Constant.BIT3);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex( unitByte,Constant.BIT2);
		byte oilUnitByte = (byte) (bit5*2+bit4);
		String oilUnit = "MPG";
		if (oilUnitByte == 1) {
			oilUnit = "km/L";
		} else if (oilUnitByte == 2) {
			oilUnit = "L/100km";
		}
		mCarLargeInfo.setOilUnit(oilUnit);
		
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}


	private List<BaseInfo> analyzeRadarFB(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		mRadarInfo.setBackLeftValue(get4Distanse(intackBytes[Constant.DATA0]));
		mRadarInfo.setBackMidLeftValue(get4Distanse(intackBytes[Constant.DATA1])); 
		mRadarInfo.setBackMidRightValue(get4Distanse(intackBytes[Constant.DATA2]));
		mRadarInfo.setBackRightValue(get4Distanse(intackBytes[Constant.DATA3]));
		mRadarInfo.setFrontLeftValue(get4Distanse(intackBytes[Constant.DATA4]));
		mRadarInfo.setFrontMidLeftValue(get4Distanse(intackBytes[Constant.DATA5]));
		mRadarInfo.setFrontMidRightValue(get4Distanse(intackBytes[Constant.DATA6]));
		mRadarInfo.setFrontRightValue(get4Distanse(intackBytes[Constant.DATA7]));
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

	private List<BaseInfo> analyzeAirCondition(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// data0
		byte mAirdata0 = intackBytes[Constant.DATA0];
		analyzeAirData0(mAirdata0);
		// data1
		byte mAirdata1 = intackBytes[Constant.DATA1];
		analyzeAirData1(mAirdata1);
		// data2
		byte mAirdata2 = intackBytes[Constant.DATA2];
		analyzeAirData2(mAirdata2, mAirdata1);
		byte mAirdata3 = intackBytes[Constant.DATA3];
		mAirConditionInfo.setClimateDown(mAirdata3 == 0 ? true : false);
		// data4
		byte mAirdata4 = intackBytes[Constant.DATA4];
		analyzeAirData4(mAirdata4);
		// data5 前排风速
		byte mAirdata5 = intackBytes[Constant.DATA5];
		mAirConditionInfo.setLeftWindGrade(mAirdata5);
		mAirConditionInfo.setRightWindGrade(mAirdata5);
		
		// data6 左边座椅温度设数值
		byte mAirdata6 = intackBytes[Constant.DATA6];
		float frontLeftSeatSetTemp = analyzeSeatHeatGrade(mAirdata6);
		mAirConditionInfo.setFrontLeftSeatSetTemp(frontLeftSeatSetTemp);
		// data7 右边座椅温度设数值
		byte mAirdata7 = intackBytes[Constant.DATA7];
		float frontRightSeatSetTemp = analyzeSeatHeatGrade(mAirdata7);
		mAirConditionInfo.setFrontRightSeatSetTemp(frontRightSeatSetTemp);
		// 后排
		byte mAirdata8 = intackBytes[Constant.DATA8];
		mAirConditionInfo.setBackWindGrade(mAirdata8);

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
		// 吹窗 吹脚
		case 0x4:
			mAirConditionInfo.setLeftWindBlowWindow(true);
			mAirConditionInfo.setLeftWindBlowFoot(true);
			mAirConditionInfo.setRightWindBlowWindow(true);
			mAirConditionInfo.setRightWindBlowFoot(true);
			break;
		// 吹身吹脚
		case 5:
			mAirConditionInfo.setLeftWindBlowHead(true);
			mAirConditionInfo.setLeftWindBlowFoot(true);
			mAirConditionInfo.setRightWindBlowHead(true);
			mAirConditionInfo.setRightWindBlowFoot(true);
			break;
		// 吹身
		case 6:
			mAirConditionInfo.setLeftWindBlowHead(true);
			mAirConditionInfo.setRightWindBlowHead(true);
			break;
		// 吹窗 吹身
		case 0x7:
			mAirConditionInfo.setLeftWindBlowWindow(true);
			mAirConditionInfo.setLeftWindBlowHead(true);
			mAirConditionInfo.setRightWindBlowWindow(true);
			mAirConditionInfo.setRightWindBlowHead(true);
			break;
		//  吹身 吹脚
		case 0xA:
			mAirConditionInfo.setLeftWindBlowHead(true);
			mAirConditionInfo.setLeftWindBlowFoot(true);
			mAirConditionInfo.setRightWindBlowHead(true);
			mAirConditionInfo.setRightWindBlowFoot(true);
			//mAirConditionInfo.setFrontWindowDemist(true);
			break;
		}
	}

	private void initWindMode() {
		//mAirConditionInfo.setFrontWindowDemist(false);
		mAirConditionInfo.setLeftWindBlowWindow(false);
		mAirConditionInfo.setLeftWindBlowHead(false);
		mAirConditionInfo.setLeftWindBlowFoot(false);
		mAirConditionInfo.setRightWindBlowWindow(false);
		mAirConditionInfo.setRightWindBlowHead(false);
		mAirConditionInfo.setRightWindBlowFoot(false);
	}

	private void analyzeAirData2(byte mAirdata, byte mAirdata1) {
		// 除雾
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setBackWindowDemist(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT4);
		mAirConditionInfo.setFrontWindowDemist(bit4 == 1 ? true : false);

		// 等级 右
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		mAirConditionInfo.setRightSeatHeatGrade(bit3 * 2 + bit2);
		// 等级 左
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT0);
		mAirConditionInfo.setLeftSeatHeatGrade(bit1 * 2 + bit0);
	}

	private void analyzeAirData1(byte mAirdata) {
		// 循环模式
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT4);
		mAirConditionInfo.setCircleOut(bit4 == 0);
	}

	private void analyzeAirData0(byte mAirdata) {
		// AC
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT0);
		mAirConditionInfo.setAcEnable(bit0 == 1 ? true : false);
		// sync
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		mAirConditionInfo.setSync(bit2 == 1 ? true : false);
		// auto
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		mAirConditionInfo.setAutoSwitch1(bit3 == 1 ? true : false);
		// 空调开关
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setSwitchAir(bit6 == 1 ? true : false);
	}

	/** 车身基本信息 */
	private List<BaseInfo> analyzeBaseCar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		// data0 信号有效信息
		byte data0 = intackBytes[Constant.DATA0];
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT3);
		mCarBaseInfo.setPARK(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT2);
		mCarBaseInfo.setREV(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT1);
		mCarBaseInfo.setILL(bit1 == 1 ? true : false);
		// data1 车速
		byte data1 = intackBytes[Constant.DATA1];
		mCarLargeInfo.setInstantSpeed(ByteUtil.convertByteToInt(data1));
		// data3 按键状态
		byte data3 = intackBytes[Constant.DATA3];
		mKeyFunctionInfo.setKeyDown(data3 == 1 ? true : false);
		// data2 方向盘按键 ,算一次有效
		byte data2 = intackBytes[Constant.DATA2];
		if (mKeyFunctionInfo.isKeyDown()) {
			analyzeKeyFuction(mKeyFunctionInfo, data2);
		}
		byte data4 = intackBytes[Constant.DATA4];
		mCarBaseInfo.setKeyLight(data4);
		byte data5 = intackBytes[Constant.DATA5];
		mCarBaseInfo.setDisLight(data5);
		// data6 方向盘转角
		byte data6 = intackBytes[Constant.DATA6];
		// data7 方向盘转角
		int data7 = ByteUtil.convertByteToInt(intackBytes[Constant.DATA7]);
		int leftCor = PROTOCAL_INVALID_VALUE;
		int rightCor = PROTOCAL_INVALID_VALUE;
		// bit7Data6 = 1:左转
		byte bit7Data6 = ByteUtil.onCheckOutBitAtIndex(data6, Constant.BIT7);
		if (bit7Data6 == 1) {
			leftCor = -((data6 & 0x7F) * 256 + data7) / 10;
		} else {
			rightCor = ((data6 & 0x7F) * 256 + data7) / 10;
		}
		leftCor = (leftCor == 0 ? PROTOCAL_INVALID_VALUE : leftCor);
		rightCor = (rightCor == 0 ? PROTOCAL_INVALID_VALUE : rightCor);
		mCornerInfo.setLeftCorner(leftCor);
		mCornerInfo.setRightCorner(rightCor);

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
		case 8:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
			break;
		case 9:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);
			break;
		case 0X0B:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		case 0X0A:
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
			break;
		}
	}

	private List<BaseInfo> analyzeDetailedCar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 门状态
		byte data = intackBytes[Constant.DATA2];
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

		return baseInfolList;
	}

}
