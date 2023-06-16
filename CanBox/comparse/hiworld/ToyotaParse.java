package com.landsem.canbox.comparse.hiworld;

import java.util.ArrayList;
import java.util.List;
import android.view.KeyEvent;
import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.DriverAssistInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.PeripheralInfo;
import com.landsem.canbox.tools.ByteUtil;
/**
 * TODO 丰田 模块上行(协议盒->DVD主机)数据的解析处理类
 */
public class ToyotaParse extends HiworldBaseParse1  {

	public ToyotaParse() {
		super((byte) 0xFF, (byte) 0x5A, (byte) 0xA5);
	}

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		String readMsg = ByteUtil.onPrintByteArray(intackBytes, "ToyotaParse--data: ");
//		BaseActivity.sendBroadcastToActivity(readMsg);
		byte comID = intackBytes[Constant.COMID];
		switch (comID) {
		case Constant.ToyotaComID.COMID_INFO_BASE_CAR:
			return analyzeBaseCar( intackBytes);
		case Constant.HiworldComID.COMID_INFO_CAR_DEFINITE:
			return analyzeCarDefinite(intackBytes);
		case Constant.ToyotaComID.COMID_INFO_CAR_DEFINITE0:
			return analyzeCarDefinite0(intackBytes);
		case Constant.ToyotaComID.COMID_INFO_CAR_DEFINITE1:
			return analyzeCarDefinite1(intackBytes);
		case Constant.ToyotaComID.COMID_INFO_CAR_DEFINITE2:
			return analyzeCarDefinite2(intackBytes);
//		case Constant.ToyotaComID.COMID_INFO_OIL_ELEC:
//			return analyzeOilElec(intackBytes);
		case Constant.ToyotaComID.COMID_INFO_RADAR:
			return analyzeRadar(intackBytes);	
//		case Constant.ToyotaComID.COMID_INFO_SET:
//			return analyzeSet(intackBytes);
//		case Constant.ToyotaComID.COMID_INFO_AMPLIFIER:
//			return analyzeAmplifier(intackBytes);
		case Constant.ToyotaComID.COMID_INFO_AIR_CONDITION:
			return analyzeAirControl( intackBytes);
//		case Constant.ToyotaComID.COMID_INFO_SOFT_VERSION:
//			return analyzeVertion(intackBytes);
//		case Constant.ToyotaComID.COMID_INFO_CAR_TYPE:
//			return analyzeCarType(intackBytes);
//		case Constant.ToyotaComID.COMID_INFO_SCREEN_STATUS:
//			return analyzeScreenStatus(intackBytes);
		}
		return null;
	}
	
	private List<BaseInfo> analyzeScreenStatus(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		PeripheralInfo mPeripheralInfo = new PeripheralInfo();
		byte data3 =intackBytes[Constant.DATA3];
		mPeripheralInfo.setCameraOn(data3==1?true:false);
		baseInfolList.add(mPeripheralInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeCarType(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data0 =intackBytes[Constant.DATA0];
		mCarBaseInfo.setCarTypePara0(data0);
		byte data1 =intackBytes[Constant.DATA1];
		mCarBaseInfo.setCarTypePara1(data1);
		baseInfolList.add(mCarBaseInfo);
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
		byte bit1 = ByteUtil.onCheckOutBitAtIndex( data6,Constant.BIT1);
		mCarBaseInfo.setLinkageVolume(bit1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex( data6,Constant.BIT0);
		mCarBaseInfo.setSurroundVolume(bit0);
		baseInfolList.add(mCarBaseInfo);
		return baseInfolList;
	}
	
	private List<BaseInfo> analyzeSet(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		DriverAssistInfo msSetInfo = new DriverAssistInfo();
		analyzeParkAssist(intackBytes,msSetInfo);
		analyzeDoorLock(intackBytes,msSetInfo);
		analyzeRemoteControl(intackBytes,msSetInfo);
		analyzeMonitor(intackBytes,msSetInfo);
		baseInfolList.add(msSetInfo);
		return baseInfolList;
	}

	private void analyzeMonitor(Byte[] intackBytes, DriverAssistInfo msSetInfo) {
		byte data3 = intackBytes[Constant.DATA3];
		byte bit4 = ByteUtil.onCheckOutBitAtIndex( data3,Constant.BIT4);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex( data3,Constant.BIT3);
		msSetInfo.setLightOffTime((byte) (bit4*2+bit3));
		byte bit2 = ByteUtil.onCheckOutBitAtIndex( data3,Constant.BIT2);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex( data3,Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex( data3,Constant.BIT0);
		msSetInfo.setHeadSens((byte) (bit2*4+bit1*2+bit0));
	}

	private void analyzeRemoteControl(Byte[] intackBytes, DriverAssistInfo msSetInfo) {
		byte data2 = intackBytes[Constant.DATA2];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex( data2,Constant.BIT7);
		msSetInfo.setFeedbackByLight(bit7==1?true:false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex( data2,Constant.BIT6);
		msSetInfo.setRemotePress2(bit6==1?true:false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex( data2,Constant.BIT5);
		msSetInfo.setIntelligentLock(bit5==1?true:false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex( data2,Constant.BIT4);
		msSetInfo.setKeyPress2(bit4==1?true:false);
	}

	private void analyzeDoorLock(Byte[] intackBytes, DriverAssistInfo msSetInfo) {
		byte data1 = intackBytes[Constant.DATA1];
		byte bit6 = ByteUtil.onCheckOutBitAtIndex( data1,Constant.BIT6);
		msSetInfo.setDoorAutoLockSet(bit6==1?true:false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex( data1,Constant.BIT5);
		msSetInfo.setDoorIntelUnlockSet(bit5==1?true:false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex( data1,Constant.BIT4);
		msSetInfo.setDoorLinkUnlockSet(bit4==1?true:false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex( data1,Constant.BIT3);
		msSetInfo.setDoorAutoUnlockPSet(bit3==1?true:false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex( data1,Constant.BIT2);
		msSetInfo.setDoorAutoLockPSet(bit2==1?true:false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex( data1,Constant.BIT1);
		msSetInfo.setAutoACSet(bit1==1?true:false);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex( data1,Constant.BIT0);
		msSetInfo.setAutoLinkCycleSet(bit0==1?true:false);
	}

	private void analyzeParkAssist(Byte[] intackBytes, DriverAssistInfo msSetInfo) {
		byte data0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT7);
		msSetInfo.setRadarNoShow(bit7==1?true:false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT6);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT5);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT4);
		msSetInfo.setWarnVoice( (byte) (bit6*4+bit5*2+bit4) );
		byte bit3 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT2);
		msSetInfo.setRadarFDistance((byte) (bit3*2+bit2));
		byte bit1 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT0);
		msSetInfo.setRadarBDistance((byte) (bit1*2+bit0));
	}

	private List<BaseInfo> analyzeRadar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		mRadarInfo.setBackLeftValue(get4Distanse(intackBytes[Constant.DATA0]));
		mRadarInfo.setBackMidLeftValue(get4Distanse(intackBytes[Constant.DATA1]));
		mRadarInfo.setBackMidRightValue(get4Distanse(intackBytes[Constant.DATA1]));
		mRadarInfo.setBackRightValue(get4Distanse(intackBytes[Constant.DATA3]));
		mRadarInfo.setFrontLeftValue(get4Distanse(intackBytes[Constant.DATA4]));
		mRadarInfo.setFrontMidLeftValue(get4Distanse(intackBytes[Constant.DATA5]));
		mRadarInfo.setFrontMidRightValue(get4Distanse(intackBytes[Constant.DATA5]));
		mRadarInfo.setFrontRightValue(get4Distanse(intackBytes[Constant.DATA7]));
		mRadarInfo.setRadarSwitch(ByteUtil.convertByteToInt(intackBytes[Constant.DATA10])==1?true:false);
		baseInfolList.add(mRadarInfo);
		return baseInfolList;
	}
	
	private int get4Distanse(Byte byte1) {
		int distance = 255;
		switch (byte1) {
		case 1:
			distance = 0 ;
			break;
        case 2:
        	distance = 64 ;
			break;
        case 3:
        	distance = 128;
			break;
        case 4:
        	distance = 255;
			break;
		}
		return distance;
	}

	private List<BaseInfo> analyzeOilElec(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT7);
		mCarLargeInfo.setOilElectType(bit7==1?true:false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT2);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT0);
		mCarLargeInfo.setBatteryLevel((byte) (bit3*8+bit2*4+bit1*2+bit0));
		byte data1 = intackBytes[Constant.DATA1];
		byte bit0Data1 = ByteUtil.onCheckOutBitAtIndex( data1,Constant.BIT0);
		mCarLargeInfo.setMotorToBattery(bit0Data1==1?true:false);
		byte bit1Data1 = ByteUtil.onCheckOutBitAtIndex( data1,Constant.BIT1);
		mCarLargeInfo.setMotorToWheel(bit1Data1==1?true:false);
		byte bit2Data1 = ByteUtil.onCheckOutBitAtIndex( data1,Constant.BIT2);
		mCarLargeInfo.setEngineToMotor(bit2Data1==1?true:false);
		byte bit3Data1 = ByteUtil.onCheckOutBitAtIndex( data1,Constant.BIT3);
		mCarLargeInfo.setEngineToWheel(bit3Data1==1?true:false);
		byte bit4Data1 = ByteUtil.onCheckOutBitAtIndex( data1,Constant.BIT4);
		mCarLargeInfo.setBatteryToMotor(bit4Data1==1?true:false);
		byte bit5Data1 = ByteUtil.onCheckOutBitAtIndex( data1,Constant.BIT5);
		mCarLargeInfo.setWheelToMotor(bit5Data1==1?true:false);
		
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeVertion(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		int dataLength = intackBytes[Constant.LENGTH];
		byte[] dataBytes = new byte[dataLength];
		for (int i = 0; i < dataLength; i++) {
			dataBytes[i] =  (byte)intackBytes[i+Constant.DATA0];
		}
		String boxVertionString = ByteUtil.byteToASCII(dataBytes);
		mCarLargeInfo.setBoxVertion(boxVertionString);
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeAirControl(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte mAirdata0 = intackBytes[Constant.DATA0];
		// data0 图标
		analyzeIcon0(mAirConditionInfo, mAirdata0);
		// data1 图标
		byte mAirdata1 = intackBytes[Constant.DATA1];
		analyzeIcon1(mAirConditionInfo, mAirdata1);
		// data2 前排左座椅温度设数值
		byte mAirdata2 = intackBytes[Constant.DATA2];
		float frontLeftSeatSetTemp = analyzeSeatHeatGrade(mAirdata2);
		mAirConditionInfo.setFrontLeftSeatSetTemp(frontLeftSeatSetTemp);
		// data3 前排右座椅温度设数值
		byte mAirdata3 = intackBytes[Constant.DATA3];
		float frontRightSeatSetTemp = analyzeSeatHeatGrade( mAirdata3);
		mAirConditionInfo.setFrontRightSeatSetTemp(frontRightSeatSetTemp);
		// data4 左吹风
		byte mAirdata4 = intackBytes[Constant.DATA4];
		analyzeLeftWind(mAirConditionInfo, mAirdata4);
		// data5 右吹风
		analyzeRightWind(mAirConditionInfo, mAirdata4);
		
		baseInfolList.add(mAirConditionInfo);
		return baseInfolList;
	}
	
	private float analyzeSeatHeatGrade(byte mAirdata) {
		float seatHeatGrade = ByteUtil.convertByteToInt(mAirdata);
		if (seatHeatGrade == 0xFE) {
			seatHeatGrade = Constant.AIR_LOW;
		} else if (seatHeatGrade == 0xFF) {
			seatHeatGrade = Constant.AIR_HIGH;
		} else {
			seatHeatGrade = seatHeatGrade/2-40;
		}
		return  seatHeatGrade;
	}

	private void analyzeIcon0(AirConditionInfo mAirConditionInfo, byte mAirdata) {
		// AUTO
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		mAirConditionInfo.setAutoSwitch1(bit3 == 1 ? true : false);
	}

	private void analyzeIcon1(AirConditionInfo mAirConditionInfo, byte mAirdata) {
		// A/C
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setAcEnable(bit6 == 1 ? true : false);
		// 后窗除雾
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setBackWindowDemist(bit5 == 1 ? true : false);
		// 前窗除雾
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT4);
		mAirConditionInfo.setFrontWindowDemist(bit4 == 1 ? true : false);
	}

	private void analyzeRightWind(AirConditionInfo mAirConditionInfo,
			byte mAirdata) {
		byte bit0 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT0);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT1);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT2);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT3);
		mAirConditionInfo.setRightWindGrade( (byte)(bit0+bit1*2+bit2*4+bit3*8) );
		byte bit4 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT4);
		mAirConditionInfo.setRightWindBlowWindow(bit4==1?true:false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT5);
		mAirConditionInfo.setRightWindBlowBody( bit5==1?true:false );
		byte bit6 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT6);
		mAirConditionInfo.setRightWindBlowFoot( bit6==1?true:false );
	}

	private void analyzeLeftWind(AirConditionInfo mAirConditionInfo,byte mAirdata) {
		byte bit0 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT0);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT1);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT2);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT3);
		mAirConditionInfo.setLeftWindGrade( (byte)(bit0+bit1*2+bit2*4+bit3*8) );
		byte bit4 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT4);
		mAirConditionInfo.setLeftWindBlowWindow(bit4==1?true:false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT5);
		mAirConditionInfo.setLeftWindBlowBody( bit5==1?true:false );
		byte bit6 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT6);
		mAirConditionInfo.setLeftWindBlowFoot( bit6==1?true:false );
	}
	
	private List<BaseInfo> analyzeCarDefinite2(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		//上几分钟油耗  最高位+最低位
//		float []lastFuelArray = mCarLargeInfo.getLastFuelArray();
//		byte High = 0;
//		byte Low = 0;
//		for (int i = 0; i < intackBytes.length-1; i++) {
//			if (i%2==0) {
//				High = intackBytes[i];
//			}else {
//				Low = intackBytes[i];
//				int lastFuel = ByteUtil.HighLowByteToInt(High, Low);
//				lastFuelArray[i/2] = (lastFuel/10f);
//			}
//		}
		// 油耗单位
		byte oilUnitByte = intackBytes[intackBytes.length-1];
		String oilUnit = "MPG";
		if (oilUnitByte == 1) {
			oilUnit = "km/L";
		} else if (oilUnitByte == 2) {
			oilUnit = "L/100km";
		}
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeCarDefinite1(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		
		// 瞬时油耗 最高位+最低位
		byte High = intackBytes[Constant.DATA0];
		byte Low = intackBytes[Constant.DATA1];
		int instantFuel = ByteUtil.HighLowByteToInt(High, Low);
		mCarLargeInfo.setCurTripFuel((instantFuel/10f));
		High = intackBytes[Constant.DATA2];
		Low = intackBytes[Constant.DATA3];
		int trip1Fuel = ByteUtil.HighLowByteToInt(High, Low);
		mCarLargeInfo.setTrip1Fuel(trip1Fuel/10f);
		High = intackBytes[Constant.DATA4];
		Low = intackBytes[Constant.DATA5];
		int trip2Fuel = ByteUtil.HighLowByteToInt(High, Low);
		mCarLargeInfo.setTrip2Fuel(trip2Fuel/10f);
		High = intackBytes[Constant.DATA6];
		Low = intackBytes[Constant.DATA7];
		int trip3Fuel = ByteUtil.HighLowByteToInt(High, Low);
		mCarLargeInfo.setTrip3Fuel(trip3Fuel/10f);
		High = intackBytes[Constant.DATA8];
		Low = intackBytes[Constant.DATA9];
		int trip4Fuel = ByteUtil.HighLowByteToInt(High, Low);
		mCarLargeInfo.setTrip4Fuel(trip4Fuel/10f);
		High = intackBytes[Constant.DATA10];
		Low = intackBytes[Constant.DATA11];
		int trip5Fuel = ByteUtil.HighLowByteToInt(High, Low);
		mCarLargeInfo.setTrip5Fuel(trip5Fuel/10f);
		// 油耗单位
		byte oilUnitByte = intackBytes[Constant.DATA12];
		String oilUnit = "MPG";
		if (oilUnitByte==1) {
			oilUnit = "km/L";
		}else if (oilUnitByte==2) {
			oilUnit = "L/100km";
		}
		mCarLargeInfo.setOilUnitTrip(oilUnit);
		
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}
	
	private List<BaseInfo> analyzeCarDefinite0(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 平均油耗  最高位+最低位
		byte hexHigh = 0;
		byte hexLow = 0;
		hexHigh = intackBytes[Constant.DATA0];
		hexLow = intackBytes[Constant.DATA1];
		float averageFuel = ByteUtil.HighLowByteToInt(hexHigh,hexLow)/10f;
		mCarLargeInfo.setAverageFuel(averageFuel);
		// 续航里程  最高位+最低位
		hexHigh = intackBytes[Constant.DATA2];
		hexLow = intackBytes[Constant.DATA3];
		int enduranceMileage = ByteUtil.HighLowByteToInt(hexHigh,hexLow);
		mCarLargeInfo.setEnduranceMileage(enduranceMileage);
		// 最佳油耗  最高位+最低位
		hexHigh = intackBytes[Constant.DATA4];
		hexLow = intackBytes[Constant.DATA5];
		float bestFuel = ByteUtil.HighLowByteToInt(hexHigh,hexLow)/10.0f;
		mCarLargeInfo.setBestFuel(bestFuel);
		// 行驶时间  最高位+最低位
		hexHigh = intackBytes[Constant.DATA6];
		hexLow = intackBytes[Constant.DATA7];
		int travelTime = ByteUtil.HighLowByteToInt(hexHigh,hexLow);
		mCarLargeInfo.setTravelTime(travelTime);
		// 平均车速
		hexHigh = intackBytes[Constant.DATA8];
		hexLow = intackBytes[Constant.DATA9];
		int averageSpeed = ByteUtil.HighLowByteToInt(hexHigh,hexLow);
		mCarLargeInfo.setAverageSpeed(averageSpeed);
		// 油耗单位
		byte oilUnitByte = intackBytes[Constant.DATA10];
		String oilUnit = "MPG";
		if (oilUnitByte==1) {
			oilUnit = "km/L";
		}else if (oilUnitByte==2) {
			oilUnit = "L/100km";
		}
		mCarLargeInfo.setOilUnit(oilUnit);
		// 里程单位
		byte distanceUnitByte = intackBytes[Constant.DATA11];
		String distanceUnit = "km";
		if (distanceUnitByte == 0) {
			distanceUnit = "km";
		} else {
			distanceUnit = "mile";
		}
		mCarLargeInfo.setDistanceUnit(distanceUnit);
		
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
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
	
	/**车身基本信息*/
	private List<BaseInfo> analyzeBaseCar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		//data0 信号有效信息
		byte data0 =intackBytes[Constant.DATA0];
		byte bit0 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT0);
	    mCarBaseInfo.setACC(bit0==1?true:false);
	    byte bit1 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT1);
		mCarBaseInfo.setILL(bit1==1?true:false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT2);
		mCarBaseInfo.setREV(bit2==1?true:false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT3);
		mCarBaseInfo.setPARK(bit3==1?true:false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT5);
		mCarBaseInfo.setRadarValidity(bit5==1?true:false);
		//data2 方向盘按键
		byte data2 =intackBytes[Constant.DATA2];
		analyzeKeyFuction(mKeyFunctionInfo,data2);
		//data3  按键按下
		byte data3 =intackBytes[Constant.DATA3];
		mKeyFunctionInfo.setKeyDown(data3==1?true:false);
		// data4 门状态
		byte data4 = intackBytes[Constant.DATA4];
		analyzeDoorInfo(baseInfolList, data4);
		// data5 点火状态
//		byte data5 = intackBytes[Constant.DATA5];
//		mCarBaseInfo.setIgnition(data5==1?true:false);
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
		baseInfolList.add(mCornerInfo);
		baseInfolList.add(mKeyFunctionInfo);
		baseInfolList.add(mCarBaseInfo);
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
		case 0x0C:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		case 0x10:
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_BACK);
			break;
		}
	}
	
	private void analyzeDoorInfo(List<BaseInfo> baseInfolList, byte mAirdata) {
		byte bit3 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT3);
		mDoorInfo.setBackTrunk( bit3==1?true:false );
		byte bit4 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT4);
		mDoorInfo.setLeftBackDoor(bit4==1?true:false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT5);
		mDoorInfo.setRightBackDoor( bit5==1?true:false );
		byte bit6 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT6);
		mDoorInfo.setDriverDoor( bit6==1?true:false );
		byte bit7 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT7);
		mDoorInfo.setPassengerDoor( bit7==1?true:false );
		baseInfolList.add(mDoorInfo);
	}

}
