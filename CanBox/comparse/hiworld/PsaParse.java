package com.landsem.canbox.comparse.hiworld;

import java.util.ArrayList;
import java.util.List;

import android.view.KeyEvent;

import com.landsem.canbox.Constant;
import com.landsem.canbox.activity.BaseActivity;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CarAlarm;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CarLargeInfo;
import com.landsem.canbox.bean.CornerInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.DriveModeInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.RadarInfo;
import com.landsem.canbox.bean.SetInfo;
import com.landsem.canbox.bean.SpeedInfo;
import com.landsem.canbox.bean.UnitTimeInfo;
import com.landsem.canbox.comparse.BaseComParse;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;

/**
 * TODO PSA雪铁龙     面板暂时不解
 */
public class PsaParse extends HiworldBaseParse2 {

	public PsaParse() {
		super((byte) 0xFF, (byte) 0x5A, (byte) 0xA5);
	}
	CarAlarm mCarAlarm = new CarAlarm();
	int knobvalueOder = 0;
	int knobvalue = 0;

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		String readMsg = ByteUtil.onPrintByteArray(intackBytes, "PSA--data: ");
//		BaseActivity.sendBroadcastToActivity(readMsg);
		byte comID = intackBytes[Constant.COMID];
		switch (comID) {
		case Constant.PSAComID.COMID_INFO_BASE_CAR:
			return analyzeBaseCar(intackBytes);
		case Constant.PSAComID.COMID_INFO_DETAILED_CAR:
			return analyzeDetailInfo(intackBytes);
		case Constant.PSAComID.COMID_INFO_COMPUTER0:
			return analyzeComputer0(intackBytes);
		case Constant.PSAComID.COMID_INFO_COMPUTER1:
			return analyzeComputer1(intackBytes);
//		case Constant.PSAComID.COMID_INFO_COMPUTER2:
//			return analyzeComputer1(intackBytes);
		case Constant.PSAComID.COMID_PANEL_KEY:
			return analyzePanelKey(intackBytes);
		case Constant.PSAComID.COMID_PANEL_KNOB:
			return analyzePanelKnob(intackBytes);
		case Constant.PSAComID.COMID_INFO_AIR_CONDITION:
			return analyzeAirCondition(intackBytes);
		case Constant.PSAComID.COMID_INFO_RADAR:
			return analyzeRadarFB(intackBytes);
//		case Constant.PSAComID.COMID_INFO_ALARM:
//			return analyzeAlarm(intackBytes);
//		case Constant.PSAComID.COMID_INFO_SET_ENABLE1:
//			return analyzeSetEnable1(intackBytes);
//		case Constant.PSAComID.COMID_INFO_SET_ENABLE2:
//			return analyzeSetEnable2(intackBytes);
//		case Constant.PSAComID.COMID_INFO_SET:
//			return analyzeSet(intackBytes);
//		case Constant.PSAComID.COMID_INFO_SET2:
//			return analyzeSet2(intackBytes);
//		case Constant.PSAComID.COMID_INFO_SOFT_VERSION:
//			return analyzeVertion(intackBytes);
//		case Constant.PSAComID.COMID_INFO_SPEED_SET:
//			return analyzeSpeedSet(intackBytes);
//		case Constant.PSAComID.COMID_INFO_CRUISE_SPEED:
//			return analyzeCruiseSpeed(intackBytes);
//		case Constant.PSAComID.COMID_INFO_SOS:
//			return analyzeSOS(intackBytes);
//		case Constant.PSAComID.COMID_INFO_SPORT_MODE:
//			return analyzeSportMode(intackBytes);
//		case Constant.PSAComID.COMID_INFO_LANGUAGE_SET:
//			return analyzeLanguageSet(intackBytes);
		case Constant.PSAComID.COMID_INFO_UNIT:
			return analyzeUnit(intackBytes);
//		case Constant.PSAComID.COMID_INFO_TIME_DATE:
//			return analyzeTimeDate(intackBytes);
		}

		return null;
	}
	
	private List<BaseInfo> analyzeTimeDate(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		UnitTimeInfo mUnitTimeInfo = new UnitTimeInfo();
		byte mdata0 = intackBytes[Constant.DATA0];
		mUnitTimeInfo.setYearSet(mdata0);
		byte mdata1 = intackBytes[Constant.DATA1];
		mUnitTimeInfo.setMonthSet(mdata1);
		byte mdata2 = intackBytes[Constant.DATA2];
		mUnitTimeInfo.setDaySet(mdata2);
		byte mdata3 = intackBytes[Constant.DATA3];
		mUnitTimeInfo.setHourSet(mdata3);
		byte mdata4 = intackBytes[Constant.DATA4];
		mUnitTimeInfo.setMinuteSet(mdata4);
		byte mdata5 = intackBytes[Constant.DATA5];
		mUnitTimeInfo.setTimeFormatSet(mdata5);
		baseInfolList.add(mUnitTimeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeUnit(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		UnitTimeInfo mUnitTimeInfo = new UnitTimeInfo();
//		//单位是否有效
//		byte mData0 = intackBytes[Constant.DATA0];
//		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT5);
//		mUnitTimeInfo.setTempPermit(bit5 == 1 ? true : false);
//		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT3);
//		mUnitTimeInfo.setConsumPermit(bit3 == 1 ? true : false);
//		//单位设置
		byte mData1 = intackBytes[Constant.DATA1];
//		byte bit5Data1 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT5);
//		mUnitTimeInfo.setTempSet(bit5Data1);
		byte bit2Data1 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT2);
		byte bit1Data1 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT1);
		// 油耗单位
		byte unitOil = (byte) (bit2Data1 * 2 + bit1Data1);
		String oilUnit = "L/100km";
		if (unitOil==0) {
			oilUnit = "L/100km";
		}else if (unitOil==1) {
			oilUnit = "km/L";
		}else if (unitOil==2) {
			oilUnit = "mpg(US)";
		}
		mCarLargeInfo.setOilUnit(oilUnit);
		baseInfolList.add(mCarLargeInfo);
//		baseInfolList.add(mUnitTimeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeLanguageSet(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte mData0 = intackBytes[Constant.DATA0];
		mCarBaseInfo.setLanguageSet(mData0);
		baseInfolList.add(mCarBaseInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeSportMode(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		DriveModeInfo mDriveModeInfo = new DriveModeInfo();
		byte mData0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT7);
		mDriveModeInfo.setEngineUsePermit(bit7 == 1 ? true : false);
		byte mData1 = intackBytes[Constant.DATA1];
		byte bit7Data1 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT7);
		mDriveModeInfo.setEngineUseSet(bit7Data1 == 1 ? true : false);
		baseInfolList.add(mDriveModeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeSOS(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte mData0 = intackBytes[Constant.DATA0];
		mCarAlarm.setSosState(mData0);
		baseInfolList.add(mCarAlarm);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeCruiseSpeed(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		SpeedInfo mSpeedInfo = new SpeedInfo();
		analyzeCruiseSpeedData0(intackBytes,mSpeedInfo);
		analyzeCruiseSpeedValue(intackBytes,mSpeedInfo);
		analyzeCruiseSpeedValueEnable(intackBytes,mSpeedInfo);
		baseInfolList.add(mSpeedInfo);
		return baseInfolList;
	}
	
	private void analyzeCruiseSpeedValueEnable(Byte[] intackBytes,SpeedInfo mSpeedInfo) {
		byte mData9 = intackBytes[Constant.DATA9];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mData9, Constant.BIT7);
		mSpeedInfo.setCrSpeedEnable(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mData9, Constant.BIT6);
		mSpeedInfo.setCrSpeed1En(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mData9, Constant.BIT5);
		mSpeedInfo.setCrSpeed2En(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mData9, Constant.BIT4);
		mSpeedInfo.setCrSpeed3En(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mData9, Constant.BIT3);
		mSpeedInfo.setCrSpeed4En(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mData9, Constant.BIT2);
		mSpeedInfo.setCrSpeed5En(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mData9, Constant.BIT1);
		mSpeedInfo.setCrSpeed6En(bit1 == 1 ? true : false);
	}

	private void analyzeCruiseSpeedValue(Byte[] intackBytes, SpeedInfo mSpeedInfo) {
		byte mData1 = intackBytes[Constant.DATA1];
		mSpeedInfo.setCrSpeed1Va(ByteUtil.convertByteToInt(mData1));
		byte mData2 = intackBytes[Constant.DATA2];
		mSpeedInfo.setCrSpeed2Va(ByteUtil.convertByteToInt(mData2));
		byte mData3 = intackBytes[Constant.DATA3];
		mSpeedInfo.setCrSpeed3Va(ByteUtil.convertByteToInt(mData3));
		byte mData4 = intackBytes[Constant.DATA4];
		mSpeedInfo.setCrSpeed4Va(ByteUtil.convertByteToInt(mData4));
		byte mData5 = intackBytes[Constant.DATA5];
		mSpeedInfo.setCrSpeed5Va(ByteUtil.convertByteToInt(mData5));
		byte mData6 = intackBytes[Constant.DATA6];
		mSpeedInfo.setCrSpeed6Va(ByteUtil.convertByteToInt(mData6));
	}

	private void analyzeCruiseSpeedData0(Byte[] intackBytes, SpeedInfo mSpeedInfo) {
		byte mData0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT7);
		mSpeedInfo.setCrSpeedPermit(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT6);
		mSpeedInfo.setCrSpeed1In(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT5);
		mSpeedInfo.setCrSpeed2In(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT4);
		mSpeedInfo.setCrSpeed3In(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT3);
		mSpeedInfo.setCrSpeed4In(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT2);
		mSpeedInfo.setCrSpeed5In(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT1);
		mSpeedInfo.setCrSpeed6In(bit1 == 1 ? true : false);
	}

	private List<BaseInfo> analyzeSpeedSet(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		SpeedInfo mSpeedInfo = new SpeedInfo();
		analyzeSpeedSetData0(intackBytes,mSpeedInfo);
		analyzeSpeedSetValue(intackBytes,mSpeedInfo);
		analyzeSpeedSetValueEnable(intackBytes,mSpeedInfo);
		baseInfolList.add(mSpeedInfo);
		return baseInfolList;
	}
	
	private void analyzeSpeedSetValueEnable(Byte[] intackBytes,SpeedInfo mSpeedInfo) {
		byte mData9 = intackBytes[Constant.DATA9];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mData9, Constant.BIT7);
		mSpeedInfo.setMeSpeedEnable(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mData9, Constant.BIT6);
		mSpeedInfo.setMeSpeed1En(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mData9, Constant.BIT5);
		mSpeedInfo.setMeSpeed2En(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mData9, Constant.BIT4);
		mSpeedInfo.setMeSpeed3En(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mData9, Constant.BIT3);
		mSpeedInfo.setMeSpeed4En(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mData9, Constant.BIT2);
		mSpeedInfo.setMeSpeed5En(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mData9, Constant.BIT1);
		mSpeedInfo.setMeSpeed6En(bit1 == 1 ? true : false);
	}

	private void analyzeSpeedSetValue(Byte[] intackBytes, SpeedInfo mSpeedInfo) {
		byte mData1 = intackBytes[Constant.DATA1];
		mSpeedInfo.setMeSpeed1Va(ByteUtil.convertByteToInt(mData1));
		byte mData2 = intackBytes[Constant.DATA2];
		mSpeedInfo.setMeSpeed2Va(ByteUtil.convertByteToInt(mData2));
		byte mData3 = intackBytes[Constant.DATA3];
		mSpeedInfo.setMeSpeed3Va(ByteUtil.convertByteToInt(mData3));
		byte mData4 = intackBytes[Constant.DATA4];
		mSpeedInfo.setMeSpeed4Va(ByteUtil.convertByteToInt(mData4));
		byte mData5 = intackBytes[Constant.DATA5];
		mSpeedInfo.setMeSpeed5Va(ByteUtil.convertByteToInt(mData5));
		byte mData6 = intackBytes[Constant.DATA6];
		mSpeedInfo.setMeSpeed6Va(ByteUtil.convertByteToInt(mData6));
	}

	private void analyzeSpeedSetData0(Byte[] intackBytes, SpeedInfo mSpeedInfo) {
		byte mData0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT7);
		mSpeedInfo.setMeSpeedPermit(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT6);
		mSpeedInfo.setMeSpeed1In(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT5);
		mSpeedInfo.setMeSpeed2In(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT4);
		mSpeedInfo.setMeSpeed3In(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT3);
		mSpeedInfo.setMeSpeed4In(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT2);
		mSpeedInfo.setMeSpeed5In(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT1);
		mSpeedInfo.setMeSpeed6In(bit1 == 1 ? true : false);
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
	private List<BaseInfo> analyzeSet2(Byte[] intackBytes) {
		SetInfo mSetInfo = new SetInfo();
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		analyzeSet2Data0(intackBytes,mSetInfo);
		analyzeSet2Data1(intackBytes,mSetInfo);
		analyzeSet2Data2(intackBytes,mSetInfo);
		baseInfolList.add(mSetInfo);
		return baseInfolList;
	}

	private void analyzeSet2Data2(Byte[] intackBytes, SetInfo mSetInfo) {
		byte mData2 = intackBytes[Constant.DATA2];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mData2, Constant.BIT7);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mData2, Constant.BIT6);
		mSetInfo.setAroConcentraSet((byte) (bit7*2+bit6));
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mData2, Constant.BIT5);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mData2, Constant.BIT4);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mData2, Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mData2, Constant.BIT2);
		mSetInfo.setIonPurifySet((byte) (bit5*8 +bit4*4 +bit3*2 +bit2) );
	}

	private void analyzeSet2Data1(Byte[] intackBytes, SetInfo mSetInfo) {
		byte mData1 = intackBytes[Constant.DATA1];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT7);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT6);
		mSetInfo.setAmbientChoiceSet((byte) (bit7*2+bit6));
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT5);
		mSetInfo.setDriveModeSet(bit5);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT4);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT3);
		mSetInfo.setIonPurifySet((byte) (bit4*2+bit3) );
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT2);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT1);
		mSetInfo.setAromatheSet((byte) (bit2*2+bit1));
	}

	private void analyzeSet2Data0(Byte[] intackBytes, SetInfo mSetInfo) {
		byte mData0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT7);
		mSetInfo.setTrunkUnlockSet(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT6);
		mSetInfo.setFollowLightSet(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT5);
		mSetInfo.setChangeLaneSet(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT4);
		mSetInfo.setWelcomeSet(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT3);
		mSetInfo.setLaneKeepingSet(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT2);
		mSetInfo.setTiredTestSet(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT1);
		mSetInfo.setSpeedLimitSet(bit1 == 1 ? true : false);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT0);
		mSetInfo.setThemeColorSet(bit0);
	}

	private List<BaseInfo> analyzeSet(Byte[] intackBytes) {
		SetInfo mSetInfo = new SetInfo();
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		analyzeSetData0(intackBytes,mSetInfo);
		analyzeSetData1(intackBytes,mSetInfo);
		baseInfolList.add(mSetInfo);
		return baseInfolList;
	}

	private void analyzeSetData1(Byte[] intackBytes, SetInfo mSetInfo) {
		byte mData1 = intackBytes[Constant.DATA1];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT7);
		mSetInfo.setReversWiperSet(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT6);
		mSetInfo.setStopAssistSet(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT5);
		mSetInfo.setDoorAutoLockSet(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT4);
		mSetInfo.setDoorLockSet(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT3);
		mSetInfo.setDoorUnlockSet(bit3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT2);
		mSetInfo.setDayLightSet(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT0);
		mSetInfo.setHomeLightSet((byte) (bit1*2+bit0));
	}

	private void analyzeSetData0(Byte[] intackBytes, SetInfo mSetInfo) {
		byte mData0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT7);
		mSetInfo.setAotoStopSet(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT6);
		mSetInfo.setReversRadarSet(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT5);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT4);
		mSetInfo.setLightWelcomeSet((byte) (bit5*2+bit4));
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT3);
		mSetInfo.setLightAmbientSet(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT2);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT0);
		mSetInfo.setLightAmbientValue((byte) (bit2*4 +bit1*2+bit0));
	}

	private List<BaseInfo> analyzeSetEnable2(Byte[] intackBytes) {
		SetInfo mSetInfo = new SetInfo();
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		analyzeSetEnable2Data0(intackBytes,mSetInfo);
		analyzeSetEnable2Data1(intackBytes,mSetInfo);
		baseInfolList.add(mSetInfo);
		return baseInfolList;
	}

	private void analyzeSetEnable2Data1(Byte[] intackBytes, SetInfo mSetInfo) {
		byte mData1 = intackBytes[Constant.DATA1];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT7);
		mSetInfo.setAmbientChoicePermit(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT6);
		mSetInfo.setIonPurifyPermit(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT5);
		mSetInfo.setDriveModePermit(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT4);
		mSetInfo.setAromathePermit(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT3);
		mSetInfo.setBrightnessPermit(bit3 == 1 ? true : false);
	}

	private void analyzeSetEnable2Data0(Byte[] intackBytes, SetInfo mSetInfo) {
		byte mData0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT7);
		mSetInfo.setTrunkUnlockPermit(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT6);
		mSetInfo.setFollowLightPermit(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT5);
		mSetInfo.setChangeLanePermit(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT4);
		mSetInfo.setWelcomePermit(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT3);
		mSetInfo.setLaneKeepingPermit(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT2);
		mSetInfo.setTiredTestPermit(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT1);
		mSetInfo.setSpeedLimitPermit(bit1 == 1 ? true : false);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT0);
		mSetInfo.setThemeColorPermit(bit0 == 1 ? true : false);
	}

	private List<BaseInfo> analyzeSetEnable1(Byte[] intackBytes) {
		SetInfo mSetInfo = new SetInfo();
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		analyzeSet1Data0(intackBytes,mSetInfo);
		analyzeSet1Data1(intackBytes,mSetInfo);
		baseInfolList.add(mSetInfo);
		return baseInfolList;
	}

	private void analyzeSet1Data1(Byte[] intackBytes, SetInfo mSetInfo) {
		byte mData1 = intackBytes[Constant.DATA1];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT7);
		mSetInfo.setReversWiperPermit(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT6);
		mSetInfo.setStopAssistPermit(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT5);
		mSetInfo.setDoorAutoLockPermit(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT4);
		mSetInfo.setDoorLockPermit(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT3);
		mSetInfo.setDoorUnlockPermit(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT2);
		mSetInfo.setDayLightPermit(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mData1, Constant.BIT1);
		mSetInfo.setHomeLightPermit(bit1 == 1 ? true : false);
	}

	private void analyzeSet1Data0(Byte[] intackBytes, SetInfo mSetInfo) {
		byte mData0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT7);
		mSetInfo.setAotoStopPermit(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT6);
		mSetInfo.setReversRadarPermit(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT5);
		mSetInfo.setLightWelcomePermit(bit5 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mData0, Constant.BIT3);
		mSetInfo.setLightAmbientPermit(bit3 == 1 ? true : false);
	}
	
	private List<BaseInfo> analyzeAlarm(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 告警 最高位+最低位
		byte High = intackBytes[Constant.DATA0];
		byte Low = intackBytes[Constant.DATA1];
		int alarmValue = ByteUtil.HighLowByteToInt(High,Low);
		mCarAlarm.setWarnId(alarmValue);
		baseInfolList.add(mCarAlarm);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeRadarFB(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 距离
		mRadarInfo.setBackLeftValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA0])*36);
		mRadarInfo.setBackMidLeftValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA1])*36);
		mRadarInfo.setBackMidRightValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA2])*36);
		mRadarInfo.setBackRightValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA3])*36);
		mRadarInfo.setFrontLeftValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA4])*36);
		mRadarInfo.setFrontMidLeftValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA5])*36);
		mRadarInfo.setFrontMidRightValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA6])*36);
		mRadarInfo.setFrontRightValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA7])*36);
		baseInfolList.add(mRadarInfo);
		return baseInfolList;
	}
	
	private List<BaseInfo> analyzeAirCondition(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// data0
		byte mAirdata0 = intackBytes[Constant.DATA0];
		analyzeAirData0(mAirConditionInfo, mAirdata0);
		// data1
		byte mAirdata1 = intackBytes[Constant.DATA1];
		analyzeAirData1(mAirConditionInfo, mAirdata1);
		// data2
		byte mAirdata2 = intackBytes[Constant.DATA2];
		analyzeAirData2(mAirConditionInfo, mAirdata2);
		// data3
		byte mAirdata3 = intackBytes[Constant.DATA3];
		analyzeAirData3(mAirConditionInfo, mAirdata3);
		// data4
		byte mAirdata4 = intackBytes[Constant.DATA4];
		analyzeAirData4(mAirConditionInfo, mAirdata4);
		// data5 风速等级
		byte mAirdata5 = intackBytes[Constant.DATA5];
		mAirConditionInfo.setLeftWindGrade(mAirdata5);
		mAirConditionInfo.setRightWindGrade(mAirdata5);
		mAirConditionInfo.setWindGradeTotal((byte) 8);
		// data6 左边座椅温度设数值
		byte mAirdata6 = intackBytes[Constant.DATA6];
		float frontLeftSeatSetTemp = analyzeSeatHeatGrade(mAirdata6);
		mAirConditionInfo.setFrontLeftSeatSetTemp(frontLeftSeatSetTemp);
		// data7 右边座椅温度设数值
		byte mAirdata7 = intackBytes[Constant.DATA7];
		float frontRightSeatSetTemp = analyzeSeatHeatGrade(mAirdata7);
		mAirConditionInfo.setFrontRightSeatSetTemp(frontRightSeatSetTemp);
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
	
	private void analyzeAirData4(AirConditionInfo mAirConditionInfo,
			byte mAirdata4) {
		switch (mAirdata4) {
		// 无
		case 0:
			mAirConditionInfo.setAutoWindMode(false);
			break;
		// 前窗除雾
		case 2: mAirConditionInfo.setFrontWindowDemist(true); 
		break;
		// 吹脚
		case 3: mAirConditionInfo.setLeftWindBlowFoot(true);  
		        mAirConditionInfo.setRightWindBlowFoot(true);
		break;
		// 吹身吹脚
		case 5: mAirConditionInfo.setLeftWindBlowBody(true); 
		        mAirConditionInfo.setLeftWindBlowFoot(true);  
		        mAirConditionInfo.setRightWindBlowHead(true);
				mAirConditionInfo.setRightWindBlowFoot(true);
		break;
		// 吹身
		case 6: mAirConditionInfo.setLeftWindBlowBody(true); 
		        mAirConditionInfo.setRightWindBlowHead(true);
		break;
		// 吹窗 
		case 0xB:mAirConditionInfo.setLeftWindBlowWindow(true);
		         mAirConditionInfo.setRightWindBlowWindow(true);
		break;
		// 吹窗 吹脚
		case 0xC:mAirConditionInfo.setLeftWindBlowWindow(true);
		         mAirConditionInfo.setLeftWindBlowFoot(true);
		         mAirConditionInfo.setRightWindBlowWindow(true);
				 mAirConditionInfo.setRightWindBlowFoot(true);
		break;
		// 吹窗 吹身
		case 0xD:mAirConditionInfo.setLeftWindBlowWindow(true);
		         mAirConditionInfo.setLeftWindBlowBody(true);  
		         mAirConditionInfo.setRightWindBlowWindow(true);
				 mAirConditionInfo.setRightWindBlowHead(true);
		         break;
		// 吹窗 吹身 吹脚
		case 0xE:mAirConditionInfo.setLeftWindBlowWindow(true);
                 mAirConditionInfo.setLeftWindBlowBody(true);
                 mAirConditionInfo.setLeftWindBlowFoot(true);  
                 mAirConditionInfo.setRightWindBlowWindow(true);
     			 mAirConditionInfo.setRightWindBlowHead(true);
     			 mAirConditionInfo.setRightWindBlowFoot(true);
                 break;
		}
	}
	
	private void analyzeAirData3(AirConditionInfo mAirConditionInfo,byte mAirdata) {
		// 风量等级
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT0);
		mAirConditionInfo.setWindGrade((byte) (bit1 * 2 + bit0));
	}
	
	private void analyzeAirData2(AirConditionInfo mAirConditionInfo,byte mAirdata) {
		// 除雾
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setBackWindowDemist(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT4);
		mAirConditionInfo.setFrontWindowDemist(bit4 == 1 ? true : false);
	}
	
	private void analyzeAirData1(AirConditionInfo mAirConditionInfo,byte mAirdata) {
		// 循环模式
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT4);
		mAirConditionInfo.setCircleOut(bit4==0);
		// AQS自动内外
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		mAirConditionInfo.setAutocyclicModeSet(bit3 == 1 ? true : false);
	}
	
	private void analyzeAirData0(AirConditionInfo mAirConditionInfo,byte mAirdata) {
		// A/C
		byte bit1 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT0);
		mAirConditionInfo.setAcEnable( (bit1+bit0)==1?true:false );
		// mono
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		mAirConditionInfo.setMono(bit2 == 1 ? true : false);
		// AUTO
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		mAirConditionInfo.setAutoSwitch1(bit3 == 1 ? true : false);
		// A/C-MAX
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setAcMaxSwitch(bit5 == 1 ? true : false);
		// 空调开关
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setSwitchAir(bit6 == 1 ? true : false);
	}
	
	private List<BaseInfo> analyzePanelKnob(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		byte data0 =intackBytes[Constant.DATA0];
		byte data1 =intackBytes[Constant.DATA1];
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
	
	/**面板按键 */
	private List<BaseInfo> analyzePanelKey(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		byte data0 = intackBytes[Constant.DATA0];
		byte data1 = intackBytes[Constant.DATA1];
		if (data1 == 1) {
			switch (data0) {
			case 0X32:
			case 1:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_POWER);break;
			case 6:mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_BACK);break;
			case 0X2E:
			case 0X2F:
			case 0X16:
			case 7:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_COLLEC_RADIO);break;
			case 0X31:
			case 0X2A:
			case 0X2C:
			case 8:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);break;
			case 9:mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);break;
			case 0X1A:
			case 0X17:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_SCAN_DOWN);break;
			case 0X19:
			case 0X18:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_SCAN_UP);break;
			case 0X2B:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_BLUE_PHONE);break;	
			case 0X2D:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MUSIC);break;
			case 0X33:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_NAVI);break;
			case 0X40:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOICE);break;
			}
		}
		baseInfolList.add(mKeyFunctionInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeComputer1(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 平均油耗 最高位+最低位
		byte High = 0;
		byte Low = 0;
		High = intackBytes[Constant.DATA0];
		Low = intackBytes[Constant.DATA1];
		float averageFuel = ByteUtil.HighLowByteToInt(High, Low) / 10f;
		mCarLargeInfo.setAverageFuel(averageFuel);
		// 平均速度
		int averageSpeed = ByteUtil.convertByteToInt(intackBytes[Constant.DATA3]);
		mCarLargeInfo.setAverageSpeed(averageSpeed);
		// 累积里程 最高位+最低位
		High = intackBytes[Constant.DATA4];
		Low = intackBytes[Constant.DATA5];
		int mileage = ByteUtil.HighLowByteToInt(High, Low);
		mCarLargeInfo.setMileage(mileage);
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeComputer0(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 瞬时油耗 最高位+最低位
		byte High = intackBytes[Constant.DATA0];
		byte Low = intackBytes[Constant.DATA1];
		int instantFuel = ByteUtil.HighLowByteToInt(High, Low);
		mCarLargeInfo.setInstantFuel((instantFuel / 10f) + "");
		High = intackBytes[Constant.DATA2];
		Low = intackBytes[Constant.DATA3];
		int enduranceMileage = ByteUtil.HighLowByteToInt(High, Low);
		mCarLargeInfo.setEnduranceMileage(enduranceMileage);
		baseInfolList.add(mCarLargeInfo);
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
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT4);
		mCarBaseInfo.setKeyInValidity(bit4 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT5);
		mCarBaseInfo.setRadarValidity(bit5 == 1 ? true : false);
		// data2 方向盘按键
		byte data2 = intackBytes[Constant.DATA2];
		analyzeKeyFuction(mKeyFunctionInfo,data2);
		// data3 按键按下
		byte data3 = intackBytes[Constant.DATA3];
		mKeyFunctionInfo.setKeyDown(data3 == 1 ? true : false);
		// data3 灯光
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
		// data8 bit7 屏状态
		byte data8 = intackBytes[Constant.DATA8];
		byte bit7Data8 = ByteUtil.onCheckOutBitAtIndex(data8, Constant.BIT7);
		mCarBaseInfo.setScreenBlack(bit7Data8 == 1 ? true : false);

		baseInfolList.add(mCarBaseInfo);
		baseInfolList.add(mCornerInfo);
		baseInfolList.add(mKeyFunctionInfo);
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
        case 5:
        	mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_ANSWER);
			break;
		case 8:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);
			break;
		case 9:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
			break;
		case 0x0A:
		case 0x10:
			 mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_BACK);
			break;
		case 0x0B:
			 mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		case 0x11:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_CHANNEL_UP_FAST);
			mKeyFunctionInfo.setStepValue(1);
			break;
		case 0x12:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_CHANNEL_DOWN_FAST);
			mKeyFunctionInfo.setStepValue(1);
			break;
		case 0x40:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_BLUE_PHONE);
			break;
		}
	}

	private List<BaseInfo> analyzeDetailInfo(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// data2 门状态
		byte mDoorByte = intackBytes[Constant.DATA2];
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mDoorByte, Constant.BIT2);
		mCarAlarm.setDriverBelt(bit2 == 1 ? true : false);
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
		// data7 安全带报警
//		analyzeBeltAlarm(intackBytes);

		baseInfolList.add(mDoorInfo);
		return baseInfolList;
	}

	private void analyzeBeltAlarm(Byte[] intackBytes) {
		byte mBeltByte = intackBytes[Constant.DATA7];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mBeltByte, Constant.BIT7);
		mCarAlarm.setCopilotBelt(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mBeltByte, Constant.BIT6);
		mCarAlarm.setBackLeftBelt(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mBeltByte, Constant.BIT5);
		mCarAlarm.setBackMidBelt(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mBeltByte, Constant.BIT4);
		mCarAlarm.setBackRightBelt(bit4 == 1 ? true : false);
	}

	/**
	 * 校验
	 */
	@Override
	public boolean onCheckBytesValidity(Byte[] orderBytes) {
		boolean resultCode = false;
		if (null != orderBytes && 3 < orderBytes.length) {
			int sum = 0;
			for (int index = 2; index < orderBytes.length - 1; index++) {
				sum += orderBytes[index];
			}
			byte checkSum = (byte) (( (sum-1) & checkCode));
			resultCode = (orderBytes[orderBytes.length - 1]) == checkSum;
			LogManager.d("PSAParse  onCheckBytesValidity  check_Sum:  "
					+ checkSum + "   check_bit:"
					+ orderBytes[orderBytes.length - 1]);
		}
		return resultCode;
	}

}
