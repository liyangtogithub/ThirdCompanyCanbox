package com.landsem.canbox.comparse.hiworld;

import java.util.ArrayList;
import java.util.List;
import android.view.KeyEvent;
import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.DriveModeInfo;
import com.landsem.canbox.bean.DriverAssistInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.MultiFuncInfo;
import com.landsem.canbox.bean.PeripheralInfo;
import com.landsem.canbox.bean.UnitTimeInfo;
import com.landsem.canbox.tools.ByteUtil;

/**
 *  科迪亚克 模块上行(协议盒->DVD主机)数据的解析处理类
 *
 * @author LiYang,Power by Landsem @ShenZhen
 */
public class KoDiakParse extends HiworldBaseParse2 {
//	CarAlarm mCarAlarm = new CarAlarm();
//	PeripheralInfo mPeripheralInfo = new PeripheralInfo();
//	UnitTimeInfo mUnitTimeInfo = new UnitTimeInfo();
//	DriveModeInfo mDriveModeInfo = new DriveModeInfo();
//	MultiFuncInfo mMultiFuncInfo = new MultiFuncInfo();
//	DriverAssistInfo mDriverAssistInfo = new DriverAssistInfo();

	public KoDiakParse() {
		super((byte) 0xFF, (byte) 0x5A, (byte) 0xA5);
	}

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		String readMsg = ByteUtil.onPrintByteArray(intackBytes,"KoDiakParse--data: ");
//		BaseActivity.sendBroadcastToActivity(readMsg);
		byte comID = intackBytes[Constant.COMID];
		switch (comID) {
		case Constant.KoDiakComID.COMID_INFO_BASE_CAR:
			return analyzeBaseCar(intackBytes);
		case Constant.KoDiakComID.COMID_INFO_DETAILED_CAR:
			return analyzeDetailInfo(intackBytes);
		case Constant.KoDiakComID.COMID_INFO_DETAILED_CAR2:
			return analyzeDetailInfo2(intackBytes);
		case Constant.KoDiakComID.COMID_INFO_STATUS_START:
			return analyzeDetailStatus(intackBytes);
//		case Constant.KoDiakComID.COMID_INFO_STATUS_LONG:
//			return analyzeDetailStatus(intackBytes);
//		case Constant.KoDiakComID.COMID_INFO_STATUS_REFUEL:
//			return analyzeDetailStatus(intackBytes);
		case Constant.KoDiakComID.COMID_INFO_CONVENIENCE:
			return analyzeConvenience(intackBytes);
		case Constant.KoDiakComID.COMID_INFO_DISTINGUISH:
			return analyzeDistinguish(intackBytes);
		case Constant.KoDiakComID.COMID_INFO_MAINTAIN:
			return analyzeMaintain(intackBytes);
		case Constant.KoDiakComID.COMID_INFO_AIR_CONDITION:
			return analyzeAirCondition(intackBytes);
		case Constant.KoDiakComID.COMID_INFO_AIR_SET:
			return analyzeAirSet(intackBytes);
		case Constant.KoDiakComID.COMID_INFO_RADAR_FB:
			return analyzeRadarFB(intackBytes);
		case Constant.KoDiakComID.COMID_INFO_RADAR_LR:
			return analyzeRadarLR(intackBytes);
//		case Constant.KoDiakComID.COMID_INFO_PARKING_MANOEU:
//			return analyzeParkingManoeu(intackBytes);
//		case Constant.KoDiakComID.COMID_INFO_TYRE:
//			return analyzeTyre(intackBytes);
//		case Constant.KoDiakComID.COMID_INFO_SYSTEM_SETTING:
//			return analyzeSystemSetting(intackBytes);
//		case Constant.KoDiakComID.COMID_INFO_LIGHT2:
//			return analyzeLight2(intackBytes);
//		case Constant.KoDiakComID.COMID_INFO_LIGHT1:
//			return analyzeLight1(intackBytes);
//		case Constant.KoDiakComID.COMID_INFO_MIRROR_WIPER:
//			return analyzeMirrorWiper(intackBytes);
		case Constant.KoDiakComID.COMID_INFO_SOFT_VERSION:
			return analyzeSoftVersion(intackBytes);
		case Constant.KoDiakComID.COMID_INFO_DOOR_WINDOW:
			return analyzeDoorWindow(intackBytes);
//		case Constant.KoDiakComID.COMID_INFO_MULTI_FUNCTION:
//			return analyzeMultiFunction(intackBytes);
//		case Constant.KoDiakComID.COMID_INFO_SPORT_MODE:
//			return analyzeSportMode(intackBytes);
//		case Constant.KoDiakComID.COMID_INFO_DRIVE_MODE:
//			return analyzeDriveMode(intackBytes);
//		case Constant.KoDiakComID.COMID_INFO_DRIVE_MODE2:
//			return analyzeDriveMode2(intackBytes);
		case Constant.KoDiakComID.COMID_INFO_UNIT:
			return analyzeUnit(intackBytes);
		case Constant.KoDiakComID.COMID_INFO_TIME_DATE:
//			return analyzeTimeDate(intackBytes);
//		case Constant.KoDiakComID.COMID_INFO_VEHICLE_ALARM:
//			return analyzeVehicleAlarm(intackBytes);
//		case Constant.KoDiakComID.COMID_INFO_START_STOP_ALARM:
//			return analyzeStartStopAlarm(intackBytes);
//		case Constant.KoDiakComID.COMID_INFO_CONV_CONS_ALARM:
//			return analyzeConvConsAlarm(intackBytes);
//		case Constant.KoDiakComID.COMID_INFO_LIGHT:
//			return analyzeLight(intackBytes);
//		case Constant.KoDiakComID.COMID_INFO_CAMERA:
//			return analyzeCamera(intackBytes);
		}
		return null;
	}

//	private List<BaseInfo> analyzeConvConsAlarm(Byte[] intackBytes) {
//		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		byte mdata0 = intackBytes[Constant.DATA0];
//		mCarAlarm.setCcAlarmNum(mdata0);
//		byte[] ccAlarmArray = mCarAlarm.getCcAlarmArray();
//		for (int i = 0; i < mdata0; i++) {
//			ccAlarmArray[i] = intackBytes[i + 1];
//		}
//
//		baseInfolList.add(mCarAlarm);
//		return baseInfolList;
//	}
//
//	private List<BaseInfo> analyzeStartStopAlarm(Byte[] intackBytes) {
//		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		byte mdata0 = intackBytes[Constant.DATA0];
//		mCarAlarm.setSsAlarmNum(mdata0);
//		byte[] ssAlarmArray = mCarAlarm.getSsAlarmArray();
//		for (int i = 0; i < mdata0; i++) {
//			ssAlarmArray[i] = intackBytes[i + 1];
//		}
//
//		baseInfolList.add(mCarAlarm);
//		return baseInfolList;
//	}
//
//	private List<BaseInfo> analyzeVehicleAlarm(Byte[] intackBytes) {
//		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		byte mdata0 = intackBytes[Constant.DATA0];
//		mCarAlarm.setVehicalAlarmNum(mdata0);
//		byte[] VehicalAlarmArray = mCarAlarm.getVehicalAlarmArray();
//		for (int i = 0; i < mdata0; i++) {
//			VehicalAlarmArray[i] = intackBytes[i + 1];
//		}
//
//		baseInfolList.add(mCarAlarm);
//		return baseInfolList;
//	}
//
//	private List<BaseInfo> analyzeTimeDate(Byte[] intackBytes) {
//		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		byte mdata0 = intackBytes[Constant.DATA0];
//		byte timeSourceSet = ByteUtil.onCheckOutBitAtIndex(mdata0,
//				Constant.BIT7);
//		mUnitTimeInfo.setTimeSourceSet(timeSourceSet);
//		byte mdata1 = intackBytes[Constant.DATA1];
//		mUnitTimeInfo.setHourSet(mdata1);
//		byte mdata2 = intackBytes[Constant.DATA2];
//		mUnitTimeInfo.setMinuteSet(mdata2);
//		byte mdata3 = intackBytes[Constant.DATA3];
//		byte autoSummerPermit = ByteUtil.onCheckOutBitAtIndex(mdata3,
//				Constant.BIT7);
//		mUnitTimeInfo.setAutoSummerPermit(autoSummerPermit == 1 ? true : false);
//		byte mdata5 = intackBytes[Constant.DATA5];
//		mUnitTimeInfo.setTimeFormatSet(mdata5);
//		byte mdata6 = intackBytes[Constant.DATA6];
//		mUnitTimeInfo.setYearSet(mdata6);
//		byte mdata7 = intackBytes[Constant.DATA7];
//		mUnitTimeInfo.setMonthSet(mdata7);
//		byte mdata8 = intackBytes[Constant.DATA8];
//		mUnitTimeInfo.setDaySet(mdata8);
//		byte mdata9 = intackBytes[Constant.DATA9];
//		mUnitTimeInfo.setDateFormatSet(mdata9);
//
//		baseInfolList.add(mUnitTimeInfo);
//		return baseInfolList;
//	}

	private List<BaseInfo> analyzeUnit(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		UnitTimeInfo mUnitTimeInfo = new UnitTimeInfo();
//		analyzeUnitTimePermit(intackBytes, mUnitTimeInfo);
		analyzeUnitTimeSet(intackBytes,baseInfolList);
//		baseInfolList.add(mUnitTimeInfo);
		return baseInfolList;
	}

	private void analyzeUnitTimeSet(Byte[] intackBytes, List<BaseInfo> baseInfolList) {
		byte mdata1 = intackBytes[Constant.DATA1];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT7);
		mCarLargeInfo.setDistanceUnit(bit7==1?"km":"mile");
//		mUnitTimeInfo.setDistanceSet(bit7);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT6);
		mCarLargeInfo.setSpeedUnit(bit6==1?"km/h":"mph");
//		mUnitTimeInfo.setSpeedSet(bit6);
//		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT5);
//		mUnitTimeInfo.setTempSet(bit5);
//		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT4);
//		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT3);
//		mUnitTimeInfo.setVolumeSet((byte) (bit4 * 2 + bit3));
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT2);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT1);
		// 油耗单位
		byte unitOil = (byte) (bit2 * 2 + bit1);
    	String oilUnit = "L/100km";
		if (unitOil==0) {
			oilUnit = "L/100km";
		}else if (unitOil==1) {
			oilUnit = "km/L";
		}else if (unitOil==2) {
			oilUnit = "mpg(US)";
		}else if (unitOil==3) {
			oilUnit = "mpg(UK)";
		}
		mCarLargeInfo.setOilUnit(oilUnit);
//		byte mdata2 = intackBytes[Constant.DATA2];
//		byte bit7Data2 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT7);
//		byte bit6Data2 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT6);
//		mUnitTimeInfo.setPressureSet((byte) (bit7Data2 * 2 + bit6Data2));
		baseInfolList.add(mCarLargeInfo);

	}

	private void analyzeUnitTimePermit(Byte[] intackBytes,
			UnitTimeInfo mUnitTimeInfo) {
		byte mdata0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT7);
		mUnitTimeInfo.setDistancePermit(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT6);
		mUnitTimeInfo.setSpeedPermit(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT5);
		mUnitTimeInfo.setTempPermit(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT4);
		mUnitTimeInfo.setVolumePermit(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT3);
		mUnitTimeInfo.setConsumPermit(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT2);
		mUnitTimeInfo.setPressurePermit(bit2 == 1 ? true : false);
	}

//	private List<BaseInfo> analyzeDriveMode2(Byte[] intackBytes) {
//		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		byte mdata0 = intackBytes[Constant.DATA0];
//		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT7);
//		mDriveModeInfo.setInMenuSet2(bit7 == 1 ? true : false);
//		byte mdata2 = intackBytes[Constant.DATA2];
//		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT5);
//		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT4);
//		mDriveModeInfo.setBendLightSet2((byte) (bit5 * 2 + bit4));
//		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT3);
//		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT2);
//		mDriveModeInfo.setEngineSet2((byte) (bit3 * 2 + bit2));
//		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT1);
//		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT0);
//		mDriveModeInfo.setAccAdaptionSet2((byte) (bit1 * 2 + bit0));
//
//		byte mdata3 = intackBytes[Constant.DATA3];
//		byte bit7Data3 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT7);
//		mDriveModeInfo.setAirConditionSet2(bit7Data3);
//		byte bit6Data3 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT6);
//		mDriveModeInfo.setSteeringSet2(bit6Data3);
//		byte bit5Data3 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT5);
//		mDriveModeInfo.setFourDriveSet2(bit5Data3);
//
//		byte bit4Data3 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT4);
//		mDriveModeInfo.setDownAssistSet2(bit4Data3 == 1 ? true : false);
//		byte bit3Data3 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT3);
//		mDriveModeInfo.setRampStartSet2(bit3Data3 == 1 ? true : false);
//		byte bit2Data3 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT2);
//		mDriveModeInfo.setStopAssistSet2(bit2Data3 == 1 ? true : false);
//
//		baseInfolList.add(mDriveModeInfo);
//		return baseInfolList;
//	}
//
//	private List<BaseInfo> analyzeDriveMode(Byte[] intackBytes) {
//		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		analyzeDrivePermit(intackBytes, mDriveModeInfo);
//		analyzeDriveSet(intackBytes, mDriveModeInfo);
//		analyzeIndiv(intackBytes, mDriveModeInfo);
//
//		baseInfolList.add(mDriveModeInfo);
//		return baseInfolList;
//	}

	private void analyzeIndiv(Byte[] intackBytes, DriveModeInfo mDriveModeInfo) {
		byte mdata2 = intackBytes[Constant.DATA2];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT7);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT6);
		mDriveModeInfo.setDccSet((byte) (bit7 * 2 + bit6));
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT5);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT4);
		mDriveModeInfo.setBendLightSet((byte) (bit5 * 2 + bit4));
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT2);
		mDriveModeInfo.setEngineSet((byte) (bit3 * 2 + bit2));
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT0);
		mDriveModeInfo.setAccAdaptionSet((byte) (bit1 * 2 + bit0));

		byte mdata3 = intackBytes[Constant.DATA3];
		byte bit7Data3 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT7);
		mDriveModeInfo.setAirConditionSet(bit7Data3);
		byte bit6Data3 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT6);
		mDriveModeInfo.setSteeringSet(bit6Data3);
	}

	private void analyzeDriveSet(Byte[] intackBytes,
			DriveModeInfo mDriveModeInfo) {
		byte mdata1 = intackBytes[Constant.DATA1];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT7);
		mDriveModeInfo.setComfortSet(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT6);
		mDriveModeInfo.setNormalSet(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT5);
		mDriveModeInfo.setSportSet(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT4);
		mDriveModeInfo.setEcoSet(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT3);
		mDriveModeInfo.setIndivdualSet(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT2);
		mDriveModeInfo.setSnowSet(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT1);
		mDriveModeInfo.setCrossSet(bit1 == 1 ? true : false);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT0);
		mDriveModeInfo.setCrossIndivSet(bit0 == 1 ? true : false);

	}

	private void analyzeDrivePermit(Byte[] intackBytes,
			DriveModeInfo mDriveModeInfo) {
		byte mdata0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT7);
		mDriveModeInfo.setComfortPermit(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT6);
		mDriveModeInfo.setNormalPermit(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT5);
		mDriveModeInfo.setSportPermit(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT4);
		mDriveModeInfo.setEcoPermit(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT3);
		mDriveModeInfo.setIndivdualPermit(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT2);
		mDriveModeInfo.setSnowPermit(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT1);
		mDriveModeInfo.setCrossPermit(bit1 == 1 ? true : false);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT0);
		mDriveModeInfo.setCrossIndivPermit(bit0 == 1 ? true : false);
	}

//	private List<BaseInfo> analyzeSportMode(Byte[] intackBytes) {
//		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		byte mdata0 = intackBytes[Constant.DATA0];
//		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT5);
//		mDriveModeInfo.setEscSystemPermit(bit5 == 1 ? true : false);
//		byte mdata1 = intackBytes[Constant.DATA1];
//		byte bit5Data1 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT5);
//		byte bit6Data1 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT6);
//		mDriveModeInfo.setEscSystemSet((byte) (bit6Data1 * 2 + bit5Data1));
//		baseInfolList.add(mDriveModeInfo);
//		return baseInfolList;
//	}
//
//	private List<BaseInfo> analyzeMultiFunction(Byte[] intackBytes) {
//		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		analyzeMultiPermit(intackBytes, mMultiFuncInfo);
//		analyzeMultiSet(intackBytes, mMultiFuncInfo);
//
//		baseInfolList.add(mMultiFuncInfo);
//		return baseInfolList;
//	}

	private void analyzeMultiSet(Byte[] intackBytes,
			MultiFuncInfo mMultiFuncInfo) {
		byte mdata2 = intackBytes[Constant.DATA2];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT7);
		mMultiFuncInfo.setCurrentConsumSet(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT6);
		mMultiFuncInfo.setAverageConsumSet(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT5);
		mMultiFuncInfo.setConvenConsumSet(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT4);
		mMultiFuncInfo.setEcoTipsSet(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT3);
		mMultiFuncInfo.setTravelTimeSet(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT2);
		mMultiFuncInfo.setTravelDistanceSet(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT1);
		mMultiFuncInfo.setAverageSpeedSet(bit1 == 1 ? true : false);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT0);
		mMultiFuncInfo.setDigitalSpeedSet(bit0 == 1 ? true : false);
		byte mdata3 = intackBytes[Constant.DATA1];
		byte bit7Data1 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT7);
		mMultiFuncInfo.setSpeedWarnSet(bit7Data1 == 1 ? true : false);
		byte bit6Data1 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT6);
		mMultiFuncInfo.setOilTempSet(bit6Data1 == 1 ? true : false);
	}

	private void analyzeMultiPermit(Byte[] intackBytes,
			MultiFuncInfo mMultiFuncInfo) {
		byte mdata0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT7);
		mMultiFuncInfo.setCurrentConsumPermit(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT6);
		mMultiFuncInfo.setAverageConsumPermit(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT5);
		mMultiFuncInfo.setConvenConsumPermit(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT4);
		mMultiFuncInfo.setEcoTipsPermit(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT3);
		mMultiFuncInfo.setTravelTimePermit(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT2);
		mMultiFuncInfo.setTravelDistancePermit(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT1);
		mMultiFuncInfo.setAverageSpeedPermit(bit1 == 1 ? true : false);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT0);
		mMultiFuncInfo.setDigitalSpeedPermit(bit0 == 1 ? true : false);
		byte mdata1 = intackBytes[Constant.DATA1];
		byte bit7Data1 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT7);
		mMultiFuncInfo.setSpeedWarnPermit(bit7Data1 == 1 ? true : false);
		byte bit6Data1 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT6);
		mMultiFuncInfo.setOilTempPermit(bit6Data1 == 1 ? true : false);
	}

	private List<BaseInfo> analyzeDoorWindow(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		analyzeDoorWindowPermit(intackBytes, mDoorInfo);
		analyzeDoorWindowSet(intackBytes, mDoorInfo);

		baseInfolList.add(mDoorInfo);
		return baseInfolList;
	}

	private void analyzeDoorWindowSet(Byte[] intackBytes, DoorInfo mDoorInfo) {
		byte mdata2 = intackBytes[Constant.DATA2];
		byte bit7Data2 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT7);
		byte bit6Data2 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT6);
		byte windowConvenienceSet = (byte) (bit7Data2 * 2 + bit6Data2);
		mDoorInfo.setWindowConvenienceSet(windowConvenienceSet);

		byte mdata3 = intackBytes[Constant.DATA3];
		byte bit7Data3 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT7);
		byte bit6Data3 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT6);
		byte doorUnlockSet = (byte) (bit7Data3 * 2 + bit6Data3);
		mDoorInfo.setDoorUnlockSet(doorUnlockSet);

		byte bit5Data3 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT5);
		mDoorInfo.setDoorAutoLockSet(bit5Data3 == 1 ? true : false);
		byte bit4Data3 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT4);
		mDoorInfo.setSeatKeySet(bit4Data3 == 1 ? true : false);
		byte bit3Data3 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT3);
		mDoorInfo.setInductiveTrunkSet(bit3Data3 == 1 ? true : false);
	}

	private void analyzeDoorWindowPermit(Byte[] intackBytes, DoorInfo mDoorInfo) {
		byte mdata0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT7);
		mDoorInfo.setWindowConveniencePermit(bit7 == 1 ? true : false);
		byte mdata1 = intackBytes[Constant.DATA1];
		byte bit7Data1 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT7);
		mDoorInfo.setDoorUnlockPermit(bit7Data1 == 1 ? true : false);
		byte bit6Data1 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT6);
		mDoorInfo.setDoorAutoLockPermit(bit6Data1 == 1 ? true : false);
		byte bit5Data1 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT5);
		mDoorInfo.setSeatKeyPermit(bit5Data1 == 1 ? true : false);
		byte bit4Data1 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT4);
		mDoorInfo.setInductiveTrunkPermit(bit4Data1 == 1 ? true : false);
	}

//	private List<BaseInfo> analyzeCamera(Byte[] intackBytes) {
//		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		
//		byte mdata1 = intackBytes[Constant.DATA1];
//		mPeripheralInfo.setCameraMode(mdata1);
//
//		baseInfolList.add(mPeripheralInfo);
//		return baseInfolList;
//	}

	private List<BaseInfo> analyzeSoftVersion(Byte[] intackBytes) {
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

//	private List<BaseInfo> analyzeMirrorWiper(Byte[] intackBytes) {
//		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		// 许可
//		byte mdata0 = intackBytes[Constant.DATA0];
//		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT7);
//		mPeripheralInfo.setSynchroAdjustPermit(bit7 == 1 ? true : false);
//		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT6);
//		mPeripheralInfo.setLowerReversPermit(bit6 == 1 ? true : false);
//		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT5);
//		mPeripheralInfo.setFoldParkedPermit(bit5 == 1 ? true : false);
//		byte mdata1 = intackBytes[Constant.DATA1];
//		byte bit7Data1 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT7);
//		mPeripheralInfo.setWipingRainPermit(bit7Data1 == 1 ? true : false);
//		byte bit6Data1 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT6);
//		mPeripheralInfo
//				.setRearWipingReversPermit(bit6Data1 == 1 ? true : false);
//		// 设置
//		byte mdata2 = intackBytes[Constant.DATA2];
//		byte bit7Data2 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT7);
//		mPeripheralInfo.setSynchroAdjustSet(bit7Data2 == 1 ? true : false);
//		byte bit6Data2 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT6);
//		mPeripheralInfo.setLowerReversSet(bit6Data2 == 1 ? true : false);
//		byte bit5Data2 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT5);
//		mPeripheralInfo.setFoldParkedSet(bit5Data2 == 1 ? true : false);
//		byte mdata3 = intackBytes[Constant.DATA3];
//		byte bit7Data3 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT7);
//		mPeripheralInfo.setWipingRainSet(bit7Data3 == 1 ? true : false);
//		byte bit6Data3 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT6);
//		mPeripheralInfo.setRearWipingReversSet(bit6Data3 == 1 ? true : false);
//
//		baseInfolList.add(mPeripheralInfo);
//		return baseInfolList;
//	}
//
//	private List<BaseInfo> analyzeLight(Byte[] intackBytes) {
//		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		byte mdata1 = intackBytes[Constant.DATA1];
//		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT1);
//		mPeripheralInfo.setLeftLightSet(bit1 == 1 ? true : false);
//		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT0);
//		mPeripheralInfo.setRightLightSet(bit0 == 1 ? true : false);
//
//		baseInfolList.add(mPeripheralInfo);
//		return baseInfolList;
//	}
//
//	private List<BaseInfo> analyzeLight1(Byte[] intackBytes) {
//		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		analyzeAssist(intackBytes, mPeripheralInfo);
//		analyzeInterior(intackBytes, mPeripheralInfo);
//		analyzeAssistSet(intackBytes, mPeripheralInfo);
//		analyzeInteriorSet(intackBytes, mPeripheralInfo);
//
//		baseInfolList.add(mPeripheralInfo);
//		return baseInfolList;
//	}

	private void analyzeInteriorSet(Byte[] intackBytes,
			PeripheralInfo mPeripheralInfo) {
		byte mdata4 = intackBytes[Constant.DATA4];
		mPeripheralInfo.setSwitchLightSet(mdata4);
		byte mdata5 = intackBytes[Constant.DATA5];
		mPeripheralInfo.setDoorLightSet(mdata5);
		byte mdata6 = intackBytes[Constant.DATA6];
		mPeripheralInfo.setFootLightSet(mdata6);
		byte mdata7 = intackBytes[Constant.DATA7];
		mPeripheralInfo.setHomeLightSet(mdata7);
		byte mdata8 = intackBytes[Constant.DATA8];
		mPeripheralInfo.setLeaveLightSet(mdata8);
	}

	private void analyzeAssistSet(Byte[] intackBytes,
			PeripheralInfo mPeripheralInfo) {
		byte mdata3 = intackBytes[Constant.DATA3];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT7);
		mPeripheralInfo.setDynamicAssistSet(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT6);
		mPeripheralInfo.setDynamicBendSet(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT5);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT4);
		mPeripheralInfo.setOpenTimeSet((byte) (bit5 * 2 + bit4));
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT3);
		mPeripheralInfo.setAutoLightSet(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT2);
		mPeripheralInfo.setLaneChangeSet(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT1);
		mPeripheralInfo.setTravelModeSet(bit1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT0);
		mPeripheralInfo.setDayLightSet(bit0 == 1 ? true : false);
	}

	private void analyzeInterior(Byte[] intackBytes,
			PeripheralInfo mPeripheralInfo) {
		byte mdata1 = intackBytes[Constant.DATA1];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT7);
		mPeripheralInfo.setSwitchLightPermit(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT6);
		mPeripheralInfo.setDoorLightPermit(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT5);
		mPeripheralInfo.setFootLightPermit(bit5 == 1 ? true : false);
		byte mdata2 = intackBytes[Constant.DATA2];
		byte bit7Data2 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT7);
		mPeripheralInfo.setHomeLightPermit(bit7Data2 == 1 ? true : false);
		byte bit6Data2 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT6);
		mPeripheralInfo.setLeaveLightPermit(bit6Data2 == 1 ? true : false);
	}

	private void analyzeAssist(Byte[] intackBytes,
			PeripheralInfo mPeripheralInfo) {
		byte mdata0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT7);
		mPeripheralInfo.setDynamicAssistPermit(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT6);
		mPeripheralInfo.setDynamicBendPermit(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT5);
		mPeripheralInfo.setOpenTimePermit(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT4);
		mPeripheralInfo.setAutoLightPermit(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT3);
		mPeripheralInfo.setLaneChangePermit(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT2);
		mPeripheralInfo.setTravelModePermit(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT1);
		mPeripheralInfo.setDayLightPermit(bit1 == 1 ? true : false);
	}

//	private List<BaseInfo> analyzeLight2(Byte[] intackBytes) {
//		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		byte mdata0 = intackBytes[Constant.DATA0];
//		// 车内灯光使能位 许可
//		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT7);
//		mPeripheralInfo.setLightColorPermit(bit7 == 1 ? true : false);
//		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT6);
//		mPeripheralInfo.setLightAmbientPermit(bit6 == 1 ? true : false);
//		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT5);
//		mPeripheralInfo.setLightAdjustPermit(bit5 == 1 ? true : false);
//		// 车内灯光使能位 设置
//		byte mdata2 = intackBytes[Constant.DATA2];
//		mPeripheralInfo.setLightColorSet(mdata2);
//		byte mdata3 = intackBytes[Constant.DATA3];
//		mPeripheralInfo.setLightAmbientSet(mdata3);
//		byte mdata4 = intackBytes[Constant.DATA4];
//		mPeripheralInfo.setLightAdjustSet(mdata4);
//
//		baseInfolList.add(mPeripheralInfo);
//		return baseInfolList;
//	}
//
//	private List<BaseInfo> analyzeSystemSetting(Byte[] intackBytes) {
//		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		// 自适应巡航 有效性解析
//		analyzePermit(intackBytes, mDriverAssistInfo);
//		// 自适应巡航 设置内容解析
//		analyzeSet(intackBytes, mDriverAssistInfo);
//
//		baseInfolList.add(mDriverAssistInfo);
//		return baseInfolList;
//	}

	private void analyzeSet(Byte[] intackBytes,
			DriverAssistInfo mDriverAssistInfo) {
		// 自适应巡航 行驶程序 设置
		byte mdata7 = intackBytes[Constant.DATA7];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mdata7, Constant.BIT7);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mdata7, Constant.BIT6);
		byte bitDriving = (byte) (bit7 * 2 + bit6);
		mDriverAssistInfo.setDrivingProcedureSet(bitDriving);
		// 自适应巡航 上次选择的车距 设置
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mdata7, Constant.BIT5);
		mDriverAssistInfo.setLastDistanceSelectSet(bit5 == 1 ? true : false);
		// 自适应巡航 车距 设置
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mdata7, Constant.BIT0);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mdata7, Constant.BIT1);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mdata7, Constant.BIT2);
		byte bitDistance = (byte) (bit2 * 4 + bit1 * 2 + bit0);
		mDriverAssistInfo.setDistanceSet(bitDistance);
		// 前部辅助系统 激活 设置
		byte mdata8 = intackBytes[Constant.DATA8];
		byte bit7Data8 = ByteUtil.onCheckOutBitAtIndex(mdata8, Constant.BIT7);
		mDriverAssistInfo.setFrontActiveSet(bit7Data8 == 1 ? true : false);
		// 前部辅助系统 预警 设置
		byte bit6Data8 = ByteUtil.onCheckOutBitAtIndex(mdata8, Constant.BIT6);
		mDriverAssistInfo.setFrontAdvanceWarnSet(bit6Data8 == 1 ? true : false);
		// 前部辅助系统 距离报警 设置
		byte bit5Data8 = ByteUtil.onCheckOutBitAtIndex(mdata8, Constant.BIT5);
		mDriverAssistInfo
				.setFrontDistanceWarnSet(bit5Data8 == 1 ? true : false);
		// 前部辅助系统 预警时间 设置 00：关闭 01：提前 10：适时 11：延后
		byte bit4Data8 = ByteUtil.onCheckOutBitAtIndex(mdata8, Constant.BIT4);
		byte bit3Data8 = ByteUtil.onCheckOutBitAtIndex(mdata8, Constant.BIT3);
		mDriverAssistInfo
				.setFrontAdvanceWarnTimeSet((byte) (bit4Data8 * 2 + bit3Data8));
		// 自适应车道导向 设置
		byte mdata9 = intackBytes[Constant.DATA9];
		byte bit7Data9 = ByteUtil.onCheckOutBitAtIndex(mdata9, Constant.BIT7);
		mDriverAssistInfo.setLaneGuidanceSet(bit7Data9 == 1 ? true : false);
		// 交通标志识别 设置
		byte mdata10 = intackBytes[Constant.DATA10];
		byte bit7Data10 = ByteUtil.onCheckOutBitAtIndex(mdata10, Constant.BIT7);
		mDriverAssistInfo.setTrafficeSignSet(bit7Data10 == 1 ? true : false);
		// 疲劳驾驶识别 设置
		byte mdata11 = intackBytes[Constant.DATA11];
		byte bit7Data11 = ByteUtil.onCheckOutBitAtIndex(mdata11, Constant.BIT7);
		mDriverAssistInfo.setDriveAlertSet(bit7Data11 == 1 ? true : false);
		// 盲区监控 设置
		byte bit3Data11 = ByteUtil.onCheckOutBitAtIndex(mdata11, Constant.BIT3);
		mDriverAssistInfo.setBlindAreaSet(bit3Data11 == 1 ? true : false);
		// 预防式成员保护系统 设置
		byte mdata12 = intackBytes[Constant.DATA12];
		byte bit7Data12 = ByteUtil.onCheckOutBitAtIndex(mdata12, Constant.BIT7);
		mDriverAssistInfo.setProactiveProtectionSet(bit7Data12 == 1 ? true
				: false);
		// 车道保持辅助系统 设置
		byte mdata13 = intackBytes[Constant.DATA13];
		byte bit7Data13 = ByteUtil.onCheckOutBitAtIndex(mdata13, Constant.BIT7);
		mDriverAssistInfo.setLaneKeepingSet(bit7Data13 == 1 ? true : false);
	}

	private void analyzePermit(Byte[] intackBytes,DriverAssistInfo mDriverAssistInfo) {
		byte mdata0 = intackBytes[Constant.DATA0];
		// 自适应巡航 行驶程序 有效
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT7);
		mDriverAssistInfo.setDrivingProcedurePermit(bit7 == 1 ? true : false);
		// 自适应巡航 上次选择的车距 有效
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT6);
		mDriverAssistInfo.setLastDistanceSelectPermit(bit6 == 1 ? true : false);
		// 前部辅助系统 激活 有效
		byte mdata1 = intackBytes[Constant.DATA1];
		byte bit7Data1 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT7);
		mDriverAssistInfo.setFrontActivePermit(bit7Data1 == 1 ? true : false);
		// 前部辅助系统 预警 有效
		byte bit6Data1 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT6);
		mDriverAssistInfo.setFrontAdvanceWarnPermit(bit6Data1 == 1 ? true
				: false);
		// 前部辅助系统 距离报警 有效
		byte bit5Data1 = ByteUtil.onCheckOutBitAtIndex(mdata1, Constant.BIT5);
		mDriverAssistInfo.setFrontDistanceWarnPermit(bit5Data1 == 1 ? true
				: false);
		// 自适应车道导向 有效
		byte mdata2 = intackBytes[Constant.DATA2];
		byte bit7Data2 = ByteUtil.onCheckOutBitAtIndex(mdata2, Constant.BIT7);
		mDriverAssistInfo.setLaneGuidancePermit(bit7Data2 == 1 ? true : false);
		// 交通标志识别 有效
		byte mdata3 = intackBytes[Constant.DATA3];
		byte bit7Data3 = ByteUtil.onCheckOutBitAtIndex(mdata3, Constant.BIT7);
		mDriverAssistInfo.setTrafficeSignPermit(bit7Data3 == 1 ? true : false);
		// 疲劳驾驶识别 有效
		byte mdata4 = intackBytes[Constant.DATA4];
		byte bit7Data4 = ByteUtil.onCheckOutBitAtIndex(mdata4, Constant.BIT7);
		mDriverAssistInfo.setDriveAlertPermit(bit7Data4 == 1 ? true : false);
		// 盲区监控 有效
		byte bit3Data4 = ByteUtil.onCheckOutBitAtIndex(mdata4, Constant.BIT3);
		mDriverAssistInfo.setBlindAreaPermit(bit3Data4 == 1 ? true : false);
		// 预防式成员保护系统 有效
		byte mdata5 = intackBytes[Constant.DATA5];
		byte bit7Data5 = ByteUtil.onCheckOutBitAtIndex(mdata5, Constant.BIT7);
		mDriverAssistInfo.setProactiveProtectionPermit(bit7Data5 == 1 ? true
				: false);
		// 车道保持辅助系统 有效
		byte mdata6 = intackBytes[Constant.DATA6];
		byte bit7Data6 = ByteUtil.onCheckOutBitAtIndex(mdata6, Constant.BIT7);
		mDriverAssistInfo.setLaneKeepingPermit(bit7Data6 == 1 ? true : false);
	}

//	private List<BaseInfo> analyzeTyre(Byte[] intackBytes) {
//		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		byte mdata0 = intackBytes[Constant.DATA0];
//		// 轮胎压力监控显示 许可
//		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT7);
//		mPeripheralInfo.setTyerMonitorShowPermit(bit7 == 1 ? true : false);
//		// 冬季轮胎车速报警 许可
//		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT6);
//		mPeripheralInfo.setTyerSpeedWarningPermit(bit6 == 1 ? true : false);
//		// 冬季轮胎车速报警 设定
//		byte mAirdata1 = intackBytes[Constant.DATA1];
//		byte bit7Data1 = ByteUtil
//				.onCheckOutBitAtIndex(mAirdata1, Constant.BIT7);
//		mPeripheralInfo.setTyerSpeedWarningSet(bit7Data1 == 1 ? true : false);
//		// 轮胎车速报警值
//		byte mAirdata2 = intackBytes[Constant.DATA2];
//		mPeripheralInfo.setTyerSpeedValue(mAirdata2 * 10);
//
//		baseInfolList.add(mPeripheralInfo);
//		return baseInfolList;
//	}
//
//	private List<BaseInfo> analyzeParkingManoeu(Byte[] intackBytes) {
//		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		byte mdata0 = intackBytes[Constant.DATA0];
//		// 自动激活 许可
//		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT7);
//		mDriverAssistInfo.setAutoActivatePermit(bit7 == 1 ? true : false);
//		// 前部提示音量 许可
//		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT6);
//		mDriverAssistInfo.setFrontVolumePermit(bit6 == 1 ? true : false);
//		// 前部提示音调 许可
//		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT5);
//		mDriverAssistInfo.setFrontTonePermit(bit5 == 1 ? true : false);
//		// 后部提示音量 许可
//		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT4);
//		mDriverAssistInfo.setRearVolumePermit(bit4 == 1 ? true : false);
//		// 后部提示音调 许可
//		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT3);
//		mDriverAssistInfo.setRearTonePermit(bit3 == 1 ? true : false);
//		// 驶出车位 许可
//		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT2);
//		mDriverAssistInfo.setDriveOutPermit(bit2 == 1 ? true : false);
//		// 泊车方式 许可
//		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT1);
//		mDriverAssistInfo.setParkingModePermit(bit1 == 1 ? true : false);
//		// 雷达音量 许可
//		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mdata0, Constant.BIT0);
//		mDriverAssistInfo.setRadarVolumePermit(bit0 == 1 ? true : false);
//
//		byte mAirdata1 = intackBytes[Constant.DATA1];
//		// 自动激活 设定
//		byte bit7Data1 = ByteUtil
//				.onCheckOutBitAtIndex(mAirdata1, Constant.BIT7);
//		mDriverAssistInfo.setAutoActivateSet(bit7Data1 == 1 ? true : false);
//		// 驶出车位 设定
//		byte bit6Data1 = ByteUtil
//				.onCheckOutBitAtIndex(mAirdata1, Constant.BIT6);
//		mDriverAssistInfo.setDriveOutSet(bit6Data1 == 1 ? true : false);
//		// 前部提示音量
//		byte mAirdata2 = intackBytes[Constant.DATA2];
//		mDriverAssistInfo.setFrontVolumeSet(mAirdata2);
//		// 前部提示音调
//		byte mAirdata3 = intackBytes[Constant.DATA3];
//		mDriverAssistInfo.setFrontToneSet(mAirdata3);
//		// 后部提示音量
//		byte mAirdata4 = intackBytes[Constant.DATA4];
//		mDriverAssistInfo.setRearVolumeSet(mAirdata4);
//		// 后部提示音调
//		byte mAirdata5 = intackBytes[Constant.DATA5];
//		mDriverAssistInfo.setRearToneSet(mAirdata5);
//		// 泊车方式 设定
//		byte mAirdata6 = intackBytes[Constant.DATA6];
//		byte bit7Data6 = ByteUtil
//				.onCheckOutBitAtIndex(mAirdata6, Constant.BIT7);
//		byte bit6Data6 = ByteUtil
//				.onCheckOutBitAtIndex(mAirdata6, Constant.BIT6);
//		byte stopMode = (byte) (bit7Data6 * 2 + bit6Data6);
//		mDriverAssistInfo.setStopInGarage(stopMode == 1 ? true : false);
//		mDriverAssistInfo.setStopRoadSide(stopMode == 2 ? true : false);
//		// 雷达音量设定
//		byte bit5Data6 = ByteUtil
//				.onCheckOutBitAtIndex(mAirdata6, Constant.BIT5);
//		mDriverAssistInfo.setRadarMute(bit5Data6 == 0 ? true : false);
//
//		baseInfolList.add(mDriverAssistInfo);
//		return baseInfolList;
//	}

	private List<BaseInfo> analyzeRadarLR(Byte[] intackBytes) {
		
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 距离
		mRadarInfo.setRightFrontValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA0]));
		mRadarInfo.setRightMidFrontValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA1]));
		mRadarInfo.setRightMidBackValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA2]));
		mRadarInfo.setRightBackValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA3]));
		mRadarInfo.setLeftFrontValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA4]));
		mRadarInfo.setLeftMidFrontValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA5]));
		mRadarInfo.setLeftMidBackValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA6]));
		mRadarInfo.setLeftBackValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA7]));
		// 颜色
		mRadarInfo.setRightFrontColor(intackBytes[Constant.DATA8]);
		mRadarInfo.setRightMidFrontColor(intackBytes[Constant.DATA9]);
		mRadarInfo.setRightMidBackColor(intackBytes[Constant.DATA10]);
		mRadarInfo.setRightBackColor(intackBytes[Constant.DATA11]);
		mRadarInfo.setLeftFrontColor(intackBytes[Constant.DATA12]);
		mRadarInfo.setLeftMidFrontColor(intackBytes[Constant.DATA13]);
		mRadarInfo.setLeftMidBackColor(intackBytes[Constant.DATA14]);
		mRadarInfo.setLeftBackColor(intackBytes[Constant.DATA15]);
		baseInfolList.add(mRadarInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeRadarFB(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 距离
		mRadarInfo.setBackLeftValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA0]));
		mRadarInfo.setBackMidLeftValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA1]));
		mRadarInfo.setBackMidRightValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA2]));
		mRadarInfo.setBackRightValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA3]));
		mRadarInfo.setFrontLeftValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA4]));
		mRadarInfo.setFrontMidLeftValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA5]));
		mRadarInfo.setFrontMidRightValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA6]));
		mRadarInfo.setFrontRightValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA7]));
		// 颜色
		mRadarInfo.setBackLeftColor(intackBytes[Constant.DATA8]);
		mRadarInfo.setBackMidLeftColor(intackBytes[Constant.DATA9]);
		mRadarInfo.setBackMidRightColor(intackBytes[Constant.DATA10]);
		mRadarInfo.setBackRightColor(intackBytes[Constant.DATA11]);
		mRadarInfo.setFrontLeftColor(intackBytes[Constant.DATA12]);
		mRadarInfo.setFrontMidLeftColor(intackBytes[Constant.DATA13]);
		mRadarInfo.setFrontMidRightColor(intackBytes[Constant.DATA14]);
		mRadarInfo.setFrontRightColor(intackBytes[Constant.DATA15]);
		baseInfolList.add(mRadarInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeAirSet(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// data0 自动风量模式 许可
		byte mAirdata0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata0, Constant.BIT7);
		mAirConditionInfo.setAutoWindQuantityPermit(bit7 == 1 ? true : false);
		// data1 前窗自动去雾 许可
		byte mAirdata1 = intackBytes[Constant.DATA1];
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata1, Constant.BIT6);
		mAirConditionInfo.setAutoFrontWindowDemistPermit(bit6 == 1 ? true
				: false);
		// 自动内外循环 许可
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata1, Constant.BIT3);
		mAirConditionInfo.setAutocyclicModePermit(bit3 == 1 ? true : false);
		// data2 自动风量等级
		byte mAirdata2 = intackBytes[Constant.DATA2];
		byte data2Bit7 = ByteUtil
				.onCheckOutBitAtIndex(mAirdata2, Constant.BIT7);
		byte data2Bit6 = ByteUtil
				.onCheckOutBitAtIndex(mAirdata2, Constant.BIT6);
		mAirConditionInfo.setAutoWindGrade((byte) (data2Bit7 * 2 + data2Bit6));
		// data3 前窗自动去雾 设定
		byte mAirdata3 = intackBytes[Constant.DATA3];
		byte data3Bit1 = ByteUtil
				.onCheckOutBitAtIndex(mAirdata3, Constant.BIT1);
		mAirConditionInfo.setAutoFrontWindowDemistSet(data3Bit1 == 1 ? true
				: false);
		// data4 自动内外循环 设定
		byte mAirdata4 = intackBytes[Constant.DATA4];
		byte data4Bit4 = ByteUtil
				.onCheckOutBitAtIndex(mAirdata4, Constant.BIT4);
		mAirConditionInfo.setAutocyclicModeSet(data4Bit4 == 1 ? true : false);

		baseInfolList.add(mAirConditionInfo);
		return baseInfolList;
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
		analyzeAirData2(mAirdata2);
		// data3
		byte mAirdata3 = intackBytes[Constant.DATA3];
		analyzeAirData3(mAirdata3);
		// data4
		byte mAirdata4 = intackBytes[Constant.DATA4];
		analyzeAirData4(mAirdata4);
		// data5 风速等级
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
		// data9 后排座椅温度设数值
		byte mAirdata10 = intackBytes[Constant.DATA10];
		float backSeatSetTemp = analyzeSeatHeatGrade(mAirdata10);
		mAirConditionInfo.setBackSeatSetTemp(backSeatSetTemp);
		// 车外温度
		byte mAirdata11 = intackBytes[Constant.DATA11];
		float outdoorTemp = ByteUtil.convertByteToInt(mAirdata11) / 2.0f - 40;
		mAirConditionInfo.setOutdoorTemp(outdoorTemp);

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
		// 送风模式 0:关 ，1：自动
		case 0:
			mAirConditionInfo.setAutoWindMode(false);
			break;
		case 1:
			mAirConditionInfo.setAutoWindMode(true);
			break;
		// 前窗除雾
		case 2:
			mAirConditionInfo.setFrontWindowDemist(true);
			break;
		// 吹脚
		case 3:
			mAirConditionInfo.setLeftWindBlowFoot(true);
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
		// 吹窗
		case 0xB:
			mAirConditionInfo.setLeftWindBlowWindow(true);
			mAirConditionInfo.setRightWindBlowWindow(true);
			break;
		// 吹窗 吹脚
		case 0xC:
			mAirConditionInfo.setLeftWindBlowWindow(true);
			mAirConditionInfo.setLeftWindBlowFoot(true);
			mAirConditionInfo.setRightWindBlowWindow(true);
			mAirConditionInfo.setRightWindBlowFoot(true);
			break;
		// 吹窗 吹身
		case 0xD:
			mAirConditionInfo.setLeftWindBlowWindow(true);
			mAirConditionInfo.setLeftWindBlowHead(true);
			mAirConditionInfo.setRightWindBlowWindow(true);
			mAirConditionInfo.setRightWindBlowHead(true);
			break;
		// 吹窗 吹身 吹脚
		case 0xE:
			mAirConditionInfo.setLeftWindBlowWindow(true);
			mAirConditionInfo.setLeftWindBlowHead(true);
			mAirConditionInfo.setLeftWindBlowFoot(true);
			mAirConditionInfo.setRightWindBlowWindow(true);
			mAirConditionInfo.setRightWindBlowHead(true);
			mAirConditionInfo.setRightWindBlowFoot(true);
			break;
		}
	}
	
	private void initWindMode() {
		mAirConditionInfo.setFrontWindowDemist(false);
		mAirConditionInfo.setLeftWindBlowWindow(false);
		mAirConditionInfo.setLeftWindBlowHead(false);
		mAirConditionInfo.setLeftWindBlowFoot(false);
		mAirConditionInfo.setRightWindBlowWindow(false);
		mAirConditionInfo.setRightWindBlowHead(false);
		mAirConditionInfo.setRightWindBlowFoot(false);
	}

	private void analyzeAirData3(byte mAirdata) {
		// 自动风量等级
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT7);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setAutoWindGrade((byte) (bit7 * 2 + bit6));
		// 净化空气
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setClearAirEnable(bit5 == 1 ? true : false);
		// 方向盘加热
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT4);
		mAirConditionInfo.setSteeringWheelHeat(bit4 == 1 ? true : false);
		// 座椅方向盘同步
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		mAirConditionInfo.setSyncSteeringWheelSeat(bit3 == 1 ? true : false);

	}

	private void analyzeAirData2(byte mAirdata) {
		// 右边座椅通风等级
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT7);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setRightSeatWindGrade((byte) (bit7 * 2 + bit6));
		// 左边座椅通风等级
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT4);
		mAirConditionInfo.setLeftSeatWindGrade((byte) (bit5 * 2 + bit4));
		// 右边座椅加热等级
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		mAirConditionInfo.setRightSeatHeatGrade((bit3 * 2 + bit2));
		// 左边座椅加热等级
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT0);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT1);
		mAirConditionInfo.setLeftSeatHeatGrade((bit1 * 2 + bit0));
	}

	private void analyzeAirData1(byte mAirdata) {
		// 后空调锁打开
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT7);
		mAirConditionInfo.setRearOpen(bit7 == 1 ? true : false);
		// AC
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setAcEnable(bit6 == 1 ? true : false);
		// 温度单位
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setCentigrade(bit5 == 1 ? true : false);
		// 循环模式
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT4);
		mAirConditionInfo.setCircleOut(bit4==0);
	}

	private void analyzeAirData0(byte mAirdata) {
		// sync
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		mAirConditionInfo.setSync(bit2 == 1 ? true : false);
		// AUTO
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		mAirConditionInfo.setAutoSwitch1(bit3 == 1 ? true : false);
		// A/C-MAX
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setAcMaxSwitch(bit5 == 1 ? true : false);
		// 空调开关
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setSwitchAir(bit6 == 1 ? true : false);
		// 空调显示
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT7);
		mAirConditionInfo.setShowAir(bit7 == 1 ? true : false);
	}

	private List<BaseInfo> analyzeMaintain(Byte[] intackBytes) {

		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 里程单位 重复
//		byte distanceUnitByte = intackBytes[Constant.DATA0];
//		String distanceUnit = "km";
//		if (distanceUnitByte == 0) {
//			distanceUnit = "km";
//		} else {
//			distanceUnit = "mile";
//		}
//		mCarLargeInfo.setDistanceUnit(distanceUnit);
		// 车况检查天数标志
		byte titleByte = intackBytes[Constant.DATA1];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(titleByte, Constant.BIT7);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(titleByte, Constant.BIT6);
		mCarLargeInfo.setCarCheckDaysTitle((bit7 * 2 + bit6) + "");
		// 车况检查距离标志
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(titleByte, Constant.BIT5);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(titleByte, Constant.BIT4);
		mCarLargeInfo.setCarCheckDistanceTitle((bit5 * 2 + bit4) + "");
		// 机油检查天数标志
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(titleByte, Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(titleByte, Constant.BIT2);
		mCarLargeInfo.setOilCheckDaysTitle((bit3 * 2 + bit2) + "");
		// 机油检查距离标志
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(titleByte, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(titleByte, Constant.BIT0);
		mCarLargeInfo.setOilCheckDistanceTitle((bit1 * 2 + bit0) + "");
		// 车况检查天数
		byte hexHigh = 0;
		byte hexLow = 0;
		hexHigh = intackBytes[Constant.DATA2];
		hexLow = intackBytes[Constant.DATA3];
		int carCheckDays = ByteUtil.HighLowByteToInt(hexHigh, hexLow);
		mCarLargeInfo.setCarCheckDays(carCheckDays);
		// 车况检查距离
		hexHigh = intackBytes[Constant.DATA4];
		hexLow = intackBytes[Constant.DATA5];
		int carCheckDistance = ByteUtil.HighLowByteToInt(hexHigh, hexLow);
		mCarLargeInfo.setCarCheckDistance(carCheckDistance);
		// 机油更换天数
		hexHigh = intackBytes[Constant.DATA6];
		hexLow = intackBytes[Constant.DATA7];
		int oilCheckDays = ByteUtil.HighLowByteToInt(hexHigh, hexLow);
		mCarLargeInfo.setOilCheckDays(oilCheckDays);
		// 机油更换距离
		hexHigh = intackBytes[Constant.DATA8];
		hexLow = intackBytes[Constant.DATA9];
		int oilCheckDistance = ByteUtil.HighLowByteToInt(hexHigh, hexLow);
		mCarLargeInfo.setOilCheckDistance(oilCheckDistance);

		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeDistinguish(Byte[] intackBytes) {
		// 车辆识别号
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		int dataLength = intackBytes[Constant.LENGTH];
		byte[] dataBytes = new byte[dataLength];
		for (int i = 0; i < dataLength; i++) {
			dataBytes[i] = (byte) intackBytes[i + Constant.DATA0];
		}
		String carNum = ByteUtil.byteToASCII(dataBytes);
		mCarLargeInfo.setCarNum(carNum);
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeConvenience(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 负载油耗刻度最大值
		byte oilScaleMaxByte = intackBytes[Constant.DATA0];
		float oilScaleMax = 0.25f;
		switch (oilScaleMaxByte) {
		case 0:
			oilScaleMax = 0.25f;
			break;
		case 1:
			oilScaleMax = 0.375f;
			break;
		case 2:
			oilScaleMax = 0.5f;
			break;
		case 3:
			oilScaleMax = 1;
			break;
		case 4:
			oilScaleMax = 1.5f;
			break;
		case 5:
			oilScaleMax = 2;
			break;
		}
		mCarLargeInfo.setOilScaleMax(oilScaleMax);
		// 油耗进度条百分比
		byte oilPercent = intackBytes[Constant.DATA1];
		mCarLargeInfo.setOilPercent(oilPercent);
		// 油耗单位  重复
//		byte oilUnitByte = intackBytes[Constant.DATA9];
//		String oilUnit = "l/h";
//		if (oilUnitByte == 0) {
//			oilUnit = "L/H";
//		} else {
//			oilUnit = "Gal/H";
//		}
//		mCarLargeInfo.setOilUnit(oilUnit);

		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeDetailStatus(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 平均油耗 最高位+最低位
		byte hexHigh = 0;
		byte hexLow = 0;
		hexHigh = intackBytes[Constant.DATA0];
		hexLow = intackBytes[Constant.DATA1];
		float averageFuel = ByteUtil.HighLowByteToInt(hexHigh, hexLow) / 10f;
		mCarLargeInfo.setAverageFuel(averageFuel);
		// 续航里程 最高位+最低位
		hexHigh = intackBytes[Constant.DATA2];
		hexLow = intackBytes[Constant.DATA3];
		int enduranceMileage = ByteUtil.HighLowByteToInt(hexHigh, hexLow);
		mCarLargeInfo.setEnduranceMileage(enduranceMileage);
		// 行驶里程 最高位+最低位
		hexHigh = intackBytes[Constant.DATA4];
		hexLow = intackBytes[Constant.DATA5];
		int mileage = ByteUtil.HighLowByteToInt(hexHigh, hexLow) / 10;
		mCarLargeInfo.setMileage(mileage);
		// 行驶时间 最高位+最低位
		hexHigh = intackBytes[Constant.DATA6];
		hexLow = intackBytes[Constant.DATA7];
		int travelTime = ByteUtil.HighLowByteToInt(hexHigh, hexLow);
		mCarLargeInfo.setTravelTime(travelTime);
		// 平均车速
		int averageSpeed = ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA8]);
		mCarLargeInfo.setAverageSpeed(averageSpeed);

		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeDetailInfo2(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 油温
		byte oilTemp = intackBytes[Constant.DATA6];
		mCarLargeInfo.setOilTemp(ByteUtil.convertByteToInt(oilTemp) - 40);
		// 水温
		byte waterTemp = intackBytes[Constant.DATA7];
		mCarLargeInfo.setWaterTemp(ByteUtil.convertByteToInt(waterTemp) - 40);
		// 发动机转速 最高位+最低位
		byte speedHigh = intackBytes[Constant.DATA8];
		byte speedLow = intackBytes[Constant.DATA9];
		int rotateSpeed = ByteUtil.HighLowByteToInt(speedHigh,speedLow);
		mCarLargeInfo.setRotateSpeed(rotateSpeed);

		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeDetailInfo(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		
		
		// data2 门状态
		byte mDoorByte = intackBytes[Constant.DATA2];
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mDoorByte, Constant.BIT2);
		mDoorInfo.setEngineHood(bit2 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mDoorByte, Constant.BIT3);
		mDoorInfo.setBackTrunk(bit3 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mDoorByte, Constant.BIT4);
		mDoorInfo.setRightBackDoor(bit4 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mDoorByte, Constant.BIT5);
		mDoorInfo.setLeftBackDoor(bit5 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mDoorByte, Constant.BIT6);
		mDoorInfo.setPassengerDoor(bit6 == 1 ? true : false);
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mDoorByte, Constant.BIT7);
		mDoorInfo.setDriverDoor(bit7 == 1 ? true : false);

		// 瞬时油耗
		byte pointFront = intackBytes[Constant.DATA3];
		byte pointBack = intackBytes[Constant.DATA4];
		if (pointFront<0||pointFront>99) {
			pointFront = 99;
		}
		if (pointBack<0||pointBack>99) {
			pointBack = 99;
		}
		String instantFuel = ByteUtil.convertByteToInt(pointFront) + "."
				+ ByteUtil.convertByteToInt(pointBack);
		mCarLargeInfo.setInstantFuel(instantFuel);
//		// 越野图片
//		byte mOffRoadByte = intackBytes[Constant.DATA5];
//		byte mOffRoadBit5 = ByteUtil.onCheckOutBitAtIndex(mOffRoadByte,
//				Constant.BIT5);
//		mCarLargeInfo.setOffRoadIconOpen(mOffRoadBit5 == 1 ? true : false);
//		// 越野按键
//		byte mOffRoadBit6 = ByteUtil.onCheckOutBitAtIndex(mOffRoadByte,
//				Constant.BIT6);
//		mCarLargeInfo.setOffRoadKeyOpen(mOffRoadBit6 == 1 ? true : false);
//		// 越野使能
//		byte mOffRoadBit7 = ByteUtil.onCheckOutBitAtIndex(mOffRoadByte,
//				Constant.BIT7);
//		mCarLargeInfo.setOffRoadEnable(mOffRoadBit7 == 1 ? true : false);
//
//		// 清洗液报警
//		byte mAlarmByte = intackBytes[Constant.DATA6];
//		byte mAlarmBit4 = ByteUtil.onCheckOutBitAtIndex(mAlarmByte,
//				Constant.BIT4);
//		mCarAlarm.setCleaningLiquidAlarm(mAlarmBit4 == 1 ? true : false);
//		// 安全带报警
//		byte mAlarmBit5 = ByteUtil.onCheckOutBitAtIndex(mAlarmByte,
//				Constant.BIT5);
//		mCarAlarm.setSafetyBeltAlarm(mAlarmBit5 == 1 ? true : false);
//		// 油量过低报警
//		byte mAlarmBit6 = ByteUtil.onCheckOutBitAtIndex(mAlarmByte,
//				Constant.BIT6);
//		mCarAlarm.setLowOilAlarm(mAlarmBit6 == 1 ? true : false);
//		
//		// 电池电压过低报警
//		byte mAlarmBit7 = ByteUtil.onCheckOutBitAtIndex(mAlarmByte,
//				Constant.BIT7);
//		mCarAlarm.setLowVoltageAlarm(mAlarmBit7 == 1 ? true : false);

		// 剩余油量
		byte surplusOilBytes = intackBytes[Constant.DATA7];
		mCarLargeInfo.setSurplusOil(ByteUtil.convertByteToInt(surplusOilBytes));
		// 电池电压前半部分+后半部分
		byte VoltageFront = intackBytes[Constant.DATA8];
		byte VoltageBack = intackBytes[Constant.DATA9];
		if (VoltageFront<0||VoltageFront>99) {
			VoltageFront = 99;
		}
		if (VoltageBack<0||VoltageBack>99) {
			VoltageBack = 99;
		}
		String VoltagesString = ByteUtil.convertByteToInt(VoltageFront) + "."
				+ ByteUtil.convertByteToInt(VoltageBack);
		mCarLargeInfo.setVoltage(VoltagesString);

		baseInfolList.add(mDoorInfo);
		baseInfolList.add(mCarLargeInfo);
//		baseInfolList.add(mCarAlarm);
		return baseInfolList;
	}

	/** 车身基本信息 */
	private List<BaseInfo> analyzeBaseCar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		 KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		// data0 信号有效信息
		byte data0 = intackBytes[Constant.DATA0];
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT0);
		mCarBaseInfo.setACC(bit0 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT1);
		mCarBaseInfo.setILL(bit1 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT2);
		mCarBaseInfo.setREV(bit2 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT3);
		mCarBaseInfo.setPARK(bit3 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT5);
		mCarBaseInfo.setRadarValidity(bit5 == 1 ? true : false);

		// data1 车速
		byte data1 = intackBytes[Constant.DATA1];
		mCarLargeInfo.setInstantSpeed(ByteUtil.convertByteToInt(data1));
		// 按键按下或释放
		byte data3 = intackBytes[Constant.DATA3];
		mKeyFunctionInfo.setKeyDown(data3 == 1 ? true : false);
		// data2 方向盘按键  按键抬起时，算一次有效
		if (!mKeyFunctionInfo.isKeyDown()) {
			byte data2 = intackBytes[Constant.DATA2];
			analyzeKeyFuction(mKeyFunctionInfo,data2);
		}
		// 显示亮度
		byte data5 = intackBytes[Constant.DATA5];
		mCarBaseInfo.setLightValue(data5);
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
        case 3:
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
			break;
        case 4:
        	mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOICE);
			break;
        case 5://接挂电话都是5
        	mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_ANSWER);
			break;
		case 8:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);
			break;
		case 9:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
			break;
		case 0x0A:
			 mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_BACK);
			break;
		case 0x0B:
		case 0x0C:
			 mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
			
		}
	}

}
