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
import com.landsem.canbox.pack.HiworldBaseComPack;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;

/**
 * TODO 通用 模块上行(协议盒->DVD主机)数据的解析处理类
 */
public class GmParse extends HiworldBaseParse1 {
	
	DriverAssistInfo mDriverAssistInfo = new DriverAssistInfo();
	PeripheralInfo mPeripheralInfo = new PeripheralInfo();
	int knobvalue = 0;

	public GmParse() {
		super((byte) 0xFF, (byte) 0x5A, (byte) 0xA5);
	}

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		String readMsg = ByteUtil.onPrintByteArray(intackBytes,"GmParse--data: ");
//		BaseActivity.sendBroadcastToActivity(readMsg);
		byte comID = intackBytes[Constant.COMID];
		HiworldBaseComPack.sendACKHiword(comID);
		switch (comID) {
		case Constant.GMComID.COMID_INFO_BASE_CAR:
			return analyzeBaseCar(intackBytes);
		case Constant.GMComID.COMID_INFO_DETAILED_CAR:
			return analyzeDetailedCar(intackBytes);
		case Constant.GMComID.COMID_PANEL_KEY:
			return analyzePanelKey(intackBytes);
		case Constant.GMComID.COMID_PANEL_KNOB:
			return analyzePanelKnob(intackBytes);
//		case Constant.GMComID.COMID_PANEL_CHOICE:
//			return analyzePanelChoice(intackBytes);
		case Constant.GMComID.COMID_INFO_AIR_CONDITION:
			return analyzeAirCondition(intackBytes);
		case Constant.HiworldComID.COMID_INFO_CAR_DEFINITE:
			return analyzeCarDefinite(intackBytes);
		case Constant.GMComID.COMID_INFO_OIL_DISTANCE:
			return analyzeOilDistance(intackBytes);
//		case Constant.GMComID.COMID_INFO_AIR_SET:
//			return analyzeAirSet(intackBytes);
		case Constant.GMComID.COMID_INFO_RADAR:
			return analyzeRadar(intackBytes);
//		case Constant.GMComID.COMID_INFO_MONITOR:
//			return analyzeMonitor(intackBytes);
//		case Constant.GMComID.COMID_INFO_MONITOR2:
//			return analyzeMonitor2(intackBytes);
//		case Constant.GMComID.COMID_INFO_COMFORT:
//			return analyzeComfort(intackBytes);
//		case Constant.GMComID.COMID_INFO_COMFORT2:	
//			return analyzeComfort2(intackBytes);
//		case Constant.GMComID.COMID_INFO_DOOR_LOCK:
//			return analyzeDoorLock(intackBytes);
//		case Constant.GMComID.COMID_INFO_REMOTE:
//			return analyzeRemote(intackBytes);
//		case Constant.GMComID.COMID_INFO_LIGHT:
//			return analyzeLight(intackBytes);
//		case Constant.GMComID.COMID_INFO_METER:
//			return analyzeMeter(intackBytes);
//		case Constant.GMComID.COMID_INFO_SPORT_MODE:
//			return analyzeSportMode(intackBytes);
//		case Constant.GMComID.COMID_INFO_VOICE_REQUEST:
//			return analyzeVoiceRequest(intackBytes);
//		case Constant.GMComID.COMID_INFO_ANJI:
//			return analyzeAnji(intackBytes);
//		case Constant.GMComID.COMID_INFO_ANJI_CALL:
//			return analyzeAnjiCall(intackBytes);
//		case Constant.GMComID.COMID_INFO_ANJI_WARNING:
//			return analyzeAnjiWarning(intackBytes);
//		case Constant.GMComID.COMID_INFO_ANJI_RECEIVE:
//			return analyzeAnjiReceive(intackBytes);
//		case Constant.GMComID.COMID_INFO_BLUE_PASSWORD:
//			return analyzeBluePassword(intackBytes);
//		case Constant.GMComID.COMID_INFO_BLUE_PHONE:
//			return analyzeBluePhone(intackBytes);
//		case Constant.GMComID.COMID_INFO_SOFT_VERSION:
//			return analyzeVertion(intackBytes);
//		case Constant.GMComID.COMID_INFO_TIRE_PRESS:
//			return analyzeTirePress(intackBytes);
//		case Constant.GMComID.COMID_INFO_COMPASS:
//			return analyzeCompass(intackBytes);
		}
		return null;
	}
	
	private List<BaseInfo> analyzeBluePhone(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		AnJiXingInfo mAnJiXingInfo = new AnJiXingInfo();
		int dataLength = intackBytes[Constant.LENGTH];
		byte[] dataBytes = new byte[dataLength];
		for (int i = 0; i < dataLength; i++) {
			dataBytes[i] =  (byte)intackBytes[i+Constant.DATA0];
		}
		String anBlueNameString = ByteUtil.byteToASCII(dataBytes);
		mAnJiXingInfo.setAnBlueName(anBlueNameString);
		baseInfolList.add(mAnJiXingInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeBluePassword(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		AnJiXingInfo mAnJiXingInfo = new AnJiXingInfo();
		int dataLength = intackBytes[Constant.LENGTH];
		byte[] dataBytes = new byte[dataLength];
		for (int i = 0; i < dataLength; i++) {
			dataBytes[i] =  (byte)intackBytes[i+Constant.DATA0];
		}
		String anBlueWordString = ByteUtil.byteToASCII(dataBytes);
		mAnJiXingInfo.setAnBlueWord(anBlueWordString);
		baseInfolList.add(mAnJiXingInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeAnjiReceive(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		AnJiXingInfo mAnJiXingInfo = new AnJiXingInfo();
		int dataLength = intackBytes[Constant.LENGTH];
		byte[] dataBytes = new byte[dataLength];
		for (int i = 0; i < dataLength; i++) {
			dataBytes[i] =  (byte)intackBytes[i+Constant.DATA0];
		}
		String anRecNumString = ByteUtil.byteToASCII(dataBytes);
		mAnJiXingInfo.setAnRecNum(anRecNumString);
		baseInfolList.add(mAnJiXingInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeAnjiWarning(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		AnJiXingInfo mAnJiXingInfo = new AnJiXingInfo();
		byte data0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT7);
		mAnJiXingInfo.setAnWarnEnable(bit7==1);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT6);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT5);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT4);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT2);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT0);
		byte anWarnMode = (byte) (bit2*4+bit1*2+bit0);
		String anWarnModeString = "Disaster";
		switch (anWarnMode) {
		case 0: anWarnModeString = "Disaster";  break;
		case 1: anWarnModeString = "Amber";     break;
		case 2: anWarnModeString = "Traffic";   break;
		case 3: anWarnModeString = "Weather";   break;
		case 4: anWarnModeString = "Generic";   break;
		case 5: anWarnModeString = "Campaign";  break;
		case 6: anWarnModeString = "Reminder";  break;
		}
		mAnJiXingInfo.setAnWarnMode(anWarnModeString);
		baseInfolList.add(mAnJiXingInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeAnjiCall(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		AnJiXingInfo mAnJiXingInfo = new AnJiXingInfo();
		byte data0 = intackBytes[Constant.DATA0];
		mAnJiXingInfo.setAnCallH(ByteUtil.convertByteToInt(data0));
		byte data1 = intackBytes[Constant.DATA1];
		mAnJiXingInfo.setAnCallM(data1);
		byte data2 = intackBytes[Constant.DATA2];
		mAnJiXingInfo.setAnCallS(data2);
		//剩余时间  最高位+最低位
		byte High = intackBytes[Constant.DATA3];
		byte Low = intackBytes[Constant.DATA4];
		int anSurplus = ByteUtil.HighLowByteToInt(High, Low);
		mAnJiXingInfo.setAnSurplus(anSurplus);
		High = intackBytes[Constant.DATA5];
		Low = intackBytes[Constant.DATA6];
		int anValidY = ByteUtil.HighLowByteToInt(High, Low);
		mAnJiXingInfo.setAnValidY(anValidY);
		byte data7 = intackBytes[Constant.DATA7];
		mAnJiXingInfo.setAnValidM(ByteUtil.convertByteToInt(data7));
		byte data8 = intackBytes[Constant.DATA8];
		mAnJiXingInfo.setAnValidD(ByteUtil.convertByteToInt(data8));
		baseInfolList.add(mAnJiXingInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeAnji(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		AnJiXingInfo mAnJiXingInfo = new AnJiXingInfo();
		byte data0 = intackBytes[Constant.DATA0];
		mAnJiXingInfo.setAnState(data0);
		byte data1 = intackBytes[Constant.DATA1];
		mAnJiXingInfo.setAnCallMode(data1);
		byte data2 = intackBytes[Constant.DATA2];
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT0);
		mAnJiXingInfo.setAnCallMute(bit0==1);
		baseInfolList.add(mAnJiXingInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeVoiceRequest(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data0 = intackBytes[Constant.DATA0];
		mPeripheralInfo.setSoundOrder(data0);
		byte data1 = intackBytes[Constant.DATA1];
		mPeripheralInfo.setSoundTimes(data1);
		baseInfolList.add(mPeripheralInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeTirePress(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		analyzeMeter0to10(intackBytes);
		analyzeMeter11(intackBytes);
		analyzeMeter12(intackBytes);
		analyzeMeter13( intackBytes);
		analyzeMeter14(intackBytes);
		baseInfolList.add(mPeripheralInfo);
		return baseInfolList;
	}
	
	private void analyzeMeter11(Byte[] intackBytes) {
		byte data11 = intackBytes[Constant.DATA11];
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data11, Constant.BIT2);
		mPeripheralInfo.setTyerLFWarn(bit2==1);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data11, Constant.BIT1);
		mPeripheralInfo.setTyerLFLow(bit1==1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data11, Constant.BIT0);
		mPeripheralInfo.setTyerLFHigh(bit0==1);
	}
	
	private void analyzeMeter12(Byte[] intackBytes) {
		byte data12 = intackBytes[Constant.DATA12];
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data12, Constant.BIT2);
		mPeripheralInfo.setTyerRFWarn(bit2==1);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data12, Constant.BIT1);
		mPeripheralInfo.setTyerRFLow(bit1==1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data12, Constant.BIT0);
		mPeripheralInfo.setTyerRFHigh(bit0==1);
	}
	
	private void analyzeMeter13(Byte[] intackBytes) {
		byte data13 = intackBytes[Constant.DATA13];
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data13, Constant.BIT2);
		mPeripheralInfo.setTyerLBWarn(bit2==1);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data13, Constant.BIT1);
		mPeripheralInfo.setTyerLBLow(bit1==1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data13, Constant.BIT0);
		mPeripheralInfo.setTyerLBHigh(bit0==1);
	}
	
	private void analyzeMeter14(Byte[] intackBytes) {
		byte data14 = intackBytes[Constant.DATA14];
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data14, Constant.BIT2);
		mPeripheralInfo.setTyerRBWarn(bit2==1);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data14, Constant.BIT1);
		mPeripheralInfo.setTyerRBLow(bit1==1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data14, Constant.BIT0);
		mPeripheralInfo.setTyerRBHigh(bit0==1);
	}

	private void analyzeMeter0to10(Byte[] intackBytes) {
		byte data0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT7);
		mPeripheralInfo.setTyerMonitorPermit(bit7==1);
		// 胎压  最高位+最低位
		byte High = intackBytes[Constant.DATA1];
		byte Low = intackBytes[Constant.DATA2];
		int tyerLFValue = ByteUtil.HighLowByteToInt(High, Low);
		mPeripheralInfo.setTyerLFValue(tyerLFValue);
		High = intackBytes[Constant.DATA3];
		Low = intackBytes[Constant.DATA4];
		int tyerRFValue = ByteUtil.HighLowByteToInt(High, Low);
		mPeripheralInfo.setTyerRFValue(tyerRFValue);
		High = intackBytes[Constant.DATA5];
		Low = intackBytes[Constant.DATA6];
		int tyerLBValue = ByteUtil.HighLowByteToInt(High, Low);
		mPeripheralInfo.setTyerLBValue(tyerLBValue);
		High = intackBytes[Constant.DATA7];
		Low = intackBytes[Constant.DATA8];
		int tyerRBValue = ByteUtil.HighLowByteToInt(High, Low);
		mPeripheralInfo.setTyerRBValue(tyerRBValue);
		High = intackBytes[Constant.DATA9];
		Low = intackBytes[Constant.DATA10];
		int tyerSValue = ByteUtil.HighLowByteToInt(High, Low);
		mPeripheralInfo.setTyerSValue(tyerSValue);
	}

	private List<BaseInfo> analyzeSportMode(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		DriveModeInfo mDriveModeInfo = new DriveModeInfo();
		byte data0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT7);
		mDriveModeInfo.setEngineSportPermit(bit7==1);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT6);
		mDriveModeInfo.setBackLightPermit(bit6==1);
		byte data1 = intackBytes[Constant.DATA1];
		byte bit7Data1 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT7);
		mDriveModeInfo.setEngineSportSet(bit7Data1==1);
		byte bit6Data1 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT6);
		mDriveModeInfo.setBackLightSet(bit6Data1==1);
		baseInfolList.add(mDriveModeInfo);
		return baseInfolList;
	}

	/***角度  */
	private List<BaseInfo> analyzeCompass(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		
		byte data0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT7);
		mPeripheralInfo.setCompassPermit(bit7==1);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT6);
		mPeripheralInfo.setCompassCalib(bit6==1);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT2);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT0);
		mPeripheralInfo.setCompassArea((byte) (bit3*8+bit2*4+bit1*2+bit0));
		byte data1 = intackBytes[Constant.DATA1];
		mPeripheralInfo.setCompassAngle(ByteUtil.convertByteToInt(data1)*1.5f);
		baseInfolList.add(mPeripheralInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeMeter(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		analyzeMeter0( intackBytes);
		analyzeMeter1( intackBytes);
		baseInfolList.add(mPeripheralInfo);
		return baseInfolList;
	}

	private void analyzeMeter1(Byte[] intackBytes) {
		byte data1 = intackBytes[Constant.DATA1];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT7);
		mPeripheralInfo.setMeterEcoSet(bit7==1);;
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT6);
		mPeripheralInfo.setMeterNavSet(bit6==1);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT5);
		mPeripheralInfo.setMeterSpeAllSet(bit5==1);
	}

	private void analyzeMeter0(Byte[] intackBytes) {
		byte data0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT7);
		mPeripheralInfo.setMeterEcoPermit(bit7==1);;
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT6);
		mPeripheralInfo.setMeterNavPermit(bit6==1);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT5);
		mPeripheralInfo.setMeterSpePermit(bit5==1);
	}

	private List<BaseInfo> analyzeLight(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		analyzeLight0( intackBytes);
		analyzeLight1( intackBytes);
		baseInfolList.add(mPeripheralInfo);
		return baseInfolList;
	}

	private void analyzeLight1(Byte[] intackBytes) {
		byte data1 = intackBytes[Constant.DATA1];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT7);
		mPeripheralInfo.setFindLightSet(bit7==1);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT6);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT5);
		mPeripheralInfo.setLightDelaySet((byte) (bit6*2+bit5));
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT4);
		mPeripheralInfo.setTurnLightRSet(bit4==1);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT3);
		mPeripheralInfo.setTurnLightLSet(bit3==1);
	}

	private void analyzeLight0(Byte[] intackBytes) {
		byte data0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT7);
		mPeripheralInfo.setFindLightPermit(bit7==1);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT6);
		mPeripheralInfo.setLightDelayPermit(bit6==1);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT5);
		mPeripheralInfo.setTurnLightPermit(bit5==1);
	}

	private List<BaseInfo> analyzeRemote(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		analyzeRemote0( intackBytes);
		analyzeRemote1(intackBytes);
		analyzeRemote2( intackBytes);
		analyzeRemote3( intackBytes);
		baseInfolList.add(mDriverAssistInfo);
		return baseInfolList;
	}
	
	private void analyzeRemote3(Byte[] intackBytes) {
		byte data3 = intackBytes[Constant.DATA3];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data3, Constant.BIT7);
		mDriverAssistInfo.setNearULSet(bit7);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data3, Constant.BIT6);
		mDriverAssistInfo.setKeyMindSet(bit6==1);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data3, Constant.BIT5);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data3, Constant.BIT4);
		mDriverAssistInfo.setLeaveULSet((byte) (bit5*2+bit4));
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data3, Constant.BIT3);
		mDriverAssistInfo.setRemSlideSet(bit3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data3, Constant.BIT2);
		mDriverAssistInfo.setRemWinSet(bit2==1);
	}
	
	private void analyzeRemote2(Byte[] intackBytes) {
		byte data2 = intackBytes[Constant.DATA2];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT7);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT6);
		mDriverAssistInfo.setRemLockSet((byte) (bit7*2+bit6));
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT5);
		mDriverAssistInfo.setRemULFbSet(bit5==1);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT4);
		mDriverAssistInfo.setRemULSet(bit4);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT3);
		mDriverAssistInfo.setRemULRepSet(bit3==1);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT2);
		mDriverAssistInfo.setRepRemSet(bit2==1);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT1);
		mDriverAssistInfo.setKeyKnownSet(bit1==1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT0);
		mDriverAssistInfo.setRemStartSet(bit0==1);
	}
	
	private void analyzeRemote1(Byte[] intackBytes) {
		byte data1 = intackBytes[Constant.DATA1];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT7);
		mDriverAssistInfo.setLeaveULPermit(bit7==1);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT6);
		mDriverAssistInfo.setKeyMindPermit(bit6==1);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT5);
		mDriverAssistInfo.setRemSlidePermit(bit5==1);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT4);
		mDriverAssistInfo.setRemWinPermit(bit4==1);
	}
	
	private void analyzeRemote0(Byte[] intackBytes) {
		byte data0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT7);
		mDriverAssistInfo.setRemLockPermit(bit7==1);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT6);
		mDriverAssistInfo.setRemULFbPermit(bit6==1);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT5);
		mDriverAssistInfo.setRemULPermit(bit5==1);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT4);
		mDriverAssistInfo.setRemULRepPermit(bit4==1);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT3);
		mDriverAssistInfo.setRepRemPermit(bit3==1);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT2);
		mDriverAssistInfo.setKeyKnownPermit(bit2==1);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT1);
		mDriverAssistInfo.setRemStartPermit(bit1==1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT0);
		mDriverAssistInfo.setNearULPermit(bit0==1);
	}

	private List<BaseInfo> analyzeDoorLock(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		analyzeDoorLock0(intackBytes);
		analyzeDoorLock1(intackBytes);
		baseInfolList.add(mDriverAssistInfo);
		return baseInfolList;
	}

	private void analyzeDoorLock1(Byte[] intackBytes) {
		byte data1 = intackBytes[Constant.DATA1];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT7);
		mDriverAssistInfo.setPrevLockSet(bit7==1);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT6);
		mDriverAssistInfo.setAutoLockSet(bit6==1);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT5);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT4);
		mDriverAssistInfo.setAutoUnLockASet((byte) (bit5*2+bit4));
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT3);
		mDriverAssistInfo.setDelayLockSet(bit3==1);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT0);
		mDriverAssistInfo.setAutoUnLockHSet((byte) (bit1*2+bit0));
	}
	
	private void analyzeDoorLock0(Byte[] intackBytes) {
		byte data0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT7);
		mDriverAssistInfo.setPrevLockPermit(bit7==1);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT6);
		mDriverAssistInfo.setAutoLockPermit(bit6==1);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT5);
		mDriverAssistInfo.setAutoUnLockAPermit(bit5==1);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT4);
		mDriverAssistInfo.setDelayLockPermit(bit4==1);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT3);
		mDriverAssistInfo.setAutoUnLockHPermit(bit3==1);
	}

	private List<BaseInfo> analyzeComfort2(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data0 = intackBytes[Constant.DATA0];
		byte bit7Data0 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT7);
		mDriverAssistInfo.setAutoWiperPermit(bit7Data0==1);
		byte data1 = intackBytes[Constant.DATA1];
		byte bit7Data1 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT7);
		mDriverAssistInfo.setAutoWiperSet(bit7Data1==1);
		baseInfolList.add(mDriverAssistInfo);
		return baseInfolList;
	}
	
	private List<BaseInfo> analyzeComfort(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		analyzeComfort0( intackBytes);
		analyzeComfort1(intackBytes);
		baseInfolList.add(mDriverAssistInfo);
		return baseInfolList;
	}
	
	private void analyzeComfort1(Byte[] intackBytes) {
		byte data1 = intackBytes[Constant.DATA1];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT7);
		mDriverAssistInfo.setStopShiftSet(bit7==1);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT6);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT5);
		mDriverAssistInfo.setLeaveShiftSet((byte) (bit6*2+bit5));
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT4);
		mDriverAssistInfo.setAutotiltSet(bit4==1);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT3);
		mDriverAssistInfo.setAutoFoldSet(bit3==1);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT2);
		mDriverAssistInfo.setPersonSetSet(bit2==1);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT1);
		mDriverAssistInfo.setBackWiperSet(bit1==1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT0);
		mDriverAssistInfo.setLeaveTiltSet(bit0==1);
	}
	
	private void analyzeComfort0(Byte[] intackBytes) {
		byte data0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT7);
		mDriverAssistInfo.setStopShiftPermit(bit7==1);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT6);
		mDriverAssistInfo.setLeaveShiftPermit(bit6==1);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT5);
		mDriverAssistInfo.setAutotiltPermit(bit5==1);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT4);
		mDriverAssistInfo.setAutoFoldPermit(bit4==1);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT3);
		mDriverAssistInfo.setPersonSetPermit(bit3==1);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT2);
		mDriverAssistInfo.setBackWiperPermit(bit2==1);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT1);
		mDriverAssistInfo.setLeaveTiltPermit(bit1==1);
	}

	private List<BaseInfo> analyzeMonitor2(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		analyzeMonitor2Data0(intackBytes);
		analyzeMonitor2Data1( intackBytes);
		baseInfolList.add(mDriverAssistInfo);
		return baseInfolList;
	}
	
	private void analyzeMonitor2Data1(Byte[] intackBytes) {
		byte data1 = intackBytes[Constant.DATA1];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT7);
		mDriverAssistInfo.setCarStateSet(bit7==1);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT6);
		mDriverAssistInfo.setRampAssistSet(bit6);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT5);
		mDriverAssistInfo.setAdapCruiseSet(bit5==1);
	}
	
	private void analyzeMonitor2Data0(Byte[] intackBytes) {
		byte data0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT7);
		mDriverAssistInfo.setCarStatePermit(bit7==1);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT6);
		mDriverAssistInfo.setRampAssistPermit(bit6==1);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT5);
		mDriverAssistInfo.setAdapCruisePermit(bit5==1);
	}

	private List<BaseInfo> analyzeMonitor(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		analyzeMonitorData0(intackBytes);
		analyzeMonitorData1(intackBytes);
		baseInfolList.add(mDriverAssistInfo);
		return baseInfolList;
	}

	private void analyzeMonitorData1(Byte[] intackBytes) {
		byte data1 = intackBytes[Constant.DATA1];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT7);
		mDriverAssistInfo.setParkAssistSet(bit7==1);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT6);
		mDriverAssistInfo.setSideBlindSet(bit6==1);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT5);
		mDriverAssistInfo.setAnticolSet(bit5);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT4);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT3);
		mDriverAssistInfo.setParkTrailerSet((byte) (bit4*2+bit3));
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT2);
		mDriverAssistInfo.setRadar24gSet(bit2==1);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT0);
		mDriverAssistInfo.setAutoAnticolSet((byte) (bit1*2+bit0));
	}
	
	private void analyzeMonitorData0(Byte[] intackBytes) {
		byte data0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT7);
		mDriverAssistInfo.setParkAssistPermit(bit7==1);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT6);
		mDriverAssistInfo.setSideBlindPermit(bit6==1);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT5);
		mDriverAssistInfo.setAnticolPermit(bit5==1);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT4);
		mDriverAssistInfo.setParkTrailerPermit(bit4==1);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT3);
		mDriverAssistInfo.setRadar24gPermit(bit3==1);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT2);
		mDriverAssistInfo.setAutoAnticolPermit(bit2==1);
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
	
	private List<BaseInfo> analyzeRadar(Byte[] intackBytes) {
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
		baseInfolList.add(mRadarInfo);
		return baseInfolList;
	}
	
	private List<BaseInfo> analyzeAirSet(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 许可
		byte mAirdata0 = intackBytes[Constant.DATA0];
		analyzeAirSetData0(mAirdata0);
		byte mAirdata1 = intackBytes[Constant.DATA1];
		analyzeAirSetData1(mAirdata1);
		//设置
		analyzeAirSetData2(intackBytes);
		analyzeAirSetData3(intackBytes);
		analyzeAirSetData4(intackBytes);
		baseInfolList.add(mAirConditionInfo);
		return baseInfolList;
	}
	
	private void analyzeAirSetData4(Byte[] intackBytes) {
		byte mAirdata4 = intackBytes[Constant.DATA4];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata4, Constant.BIT7);
		mAirConditionInfo.setRemoteStartAirSet(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata4, Constant.BIT6);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata4, Constant.BIT5);
		mAirConditionInfo.setAirSensor2Set((byte) (bit6*2+bit5));
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata4, Constant.BIT4);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata4, Constant.BIT3);
		mAirConditionInfo.setRemoteSeatHeat1Set((byte) (bit4*2+bit3));
	}

	private void analyzeAirSetData3(Byte[] intackBytes) {
		byte mAirdata3 = intackBytes[Constant.DATA3];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata3, Constant.BIT7);
		mAirConditionInfo.setSeatWindSet(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata3, Constant.BIT6);
		mAirConditionInfo.setSeatHeatSet(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata3, Constant.BIT5);
		mAirConditionInfo.setRemoteSeatWindSet(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata3, Constant.BIT4);
		mAirConditionInfo.setRemoteSeatHeatSet(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata3, Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata3, Constant.BIT2);
		mAirConditionInfo.setBackTempSet((byte) (bit3*2+bit2));
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mAirdata3, Constant.BIT1);
		mAirConditionInfo.setAutoFrontWindowDemistSet(bit1 == 1 ? true : false);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata3, Constant.BIT0);
		mAirConditionInfo.setAutoBackWindowDemistSet(bit0 == 1 ? true : false);
	}

	private void analyzeAirSetData2(Byte[] intackBytes) {
		byte mAirdata2 = intackBytes[Constant.DATA2];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata2, Constant.BIT7);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata2, Constant.BIT6);
		mAirConditionInfo.setAutoWindQuantitySet((byte) (bit7*2+bit6));
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata2, Constant.BIT5);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata2, Constant.BIT4);
		mAirConditionInfo.setAirModeSet((byte) (bit5*2+bit4));
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata2, Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata2, Constant.BIT2);
		mAirConditionInfo.setAirSensor1Set((byte) (bit3*2+bit2));
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mAirdata2, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata2, Constant.BIT0);
		mAirConditionInfo.setAotoTempSet((byte) (bit1*2+bit0));
	}

	private void analyzeAirSetData1(byte mAirdata1) {
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata1, Constant.BIT7);
		mAirConditionInfo.setBackTempPermit(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata1, Constant.BIT6);
		mAirConditionInfo.setAutoFrontWindowDemistPermit(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata1, Constant.BIT5);
		mAirConditionInfo.setAutoBackWindowDemistPermit(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata1, Constant.BIT4);
		mAirConditionInfo.setRemoteStartAirPermit(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata1, Constant.BIT3);
		mAirConditionInfo.setAirSensor2Permit(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata1, Constant.BIT2);
		mAirConditionInfo.setRemoteSeatHeat1Permit(bit2 == 1 ? true : false);
	}
	
	private void analyzeAirSetData0(byte mAirdata0) {
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata0, Constant.BIT7);
		mAirConditionInfo.setAutoWindQuantityPermit(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata0, Constant.BIT6);
		mAirConditionInfo.setAirModePermit(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata0, Constant.BIT5);
		mAirConditionInfo.setAirSensor1Permit(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata0, Constant.BIT4);
		mAirConditionInfo.setAotoTempPermit(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata0, Constant.BIT3);
		mAirConditionInfo.setSeatWindPermit(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata0, Constant.BIT2);
		mAirConditionInfo.setSeatHeatPermit(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mAirdata0, Constant.BIT1);
		mAirConditionInfo.setRemoteSeatWindPermit(bit1 == 1 ? true : false);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata0, Constant.BIT0);
		mAirConditionInfo.setRemoteSeatHeatPermit(bit0 == 1 ? true : false);
	}

	private List<BaseInfo> analyzeOilDistance(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		
		// 瞬时油耗 最高位+最低位
		byte High = intackBytes[Constant.DATA0];
		byte Low = intackBytes[Constant.DATA1];
		int instantFuel = ByteUtil.HighLowByteToInt(High, Low);
		mCarLargeInfo.setInstantFuel((instantFuel / 10f) + "");
		// 续航
		High = intackBytes[Constant.DATA2];
		Low = intackBytes[Constant.DATA3];
		int enduranceMileage = ByteUtil.HighLowByteToInt(High, Low);
		mCarLargeInfo.setEnduranceMileage(enduranceMileage);
		byte data4 = intackBytes[Constant.DATA4];
		byte data5 = intackBytes[Constant.DATA5];
		byte data6 = intackBytes[Constant.DATA6];
		int value = ByteUtil.HighMidLowByteToInt( data4,data5, data6);
		mCarLargeInfo.setMileage(value / 10);
		// 平均油耗1 最高位+最低位
		High = intackBytes[Constant.DATA7];
		Low = intackBytes[Constant.DATA8];
		float averageFuel1 = ByteUtil.HighLowByteToInt(High, Low) / 10f;
		mCarLargeInfo.setAverageFuel(averageFuel1);
		//小计里程1 最高位+中间位+最低位
		byte high = intackBytes[Constant.DATA9];
		byte mid =  intackBytes[Constant.DATA10];
		byte low =  intackBytes[Constant.DATA11];
		int smallMileage1 = ByteUtil.HighMidLowByteToInt( high,mid, low);
		mCarLargeInfo.setSmallMileage1(smallMileage1);
		// 平均油耗2 最高位+最低位
		High = intackBytes[Constant.DATA12];
		Low = intackBytes[Constant.DATA13];
		float averageFuel2 = ByteUtil.HighLowByteToInt(High, Low) / 10f;
		mCarLargeInfo.setAverageFuel2(averageFuel2);
		// 小计里程2 最高位+中间位+最低位
		high = intackBytes[Constant.DATA14];
		mid = intackBytes[Constant.DATA15];
		low = intackBytes[Constant.DATA16];
		int smallMileage2 = ByteUtil.HighMidLowByteToInt( high,mid, low);
		mCarLargeInfo.setSmallMileage2(smallMileage2);
		// 平均油耗3 最高位+最低位
		High = intackBytes[Constant.DATA17];
		Low = intackBytes[Constant.DATA18];
		float averageFuel3 = ByteUtil.HighLowByteToInt(High, Low) / 10f;
		mCarLargeInfo.setAverageFuel3(averageFuel3);
		// 小计里程3 最高位+中间位+最低位
		high = intackBytes[Constant.DATA19];
		mid = intackBytes[Constant.DATA20];
		low = intackBytes[Constant.DATA21];
		int smallMileage3 = ByteUtil.HighMidLowByteToInt( high,mid, low);
		mCarLargeInfo.setSmallMileage3(smallMileage3);
		//单位
		byte unitData = intackBytes[Constant.DATA22];
		// 里程单位
		byte distanceUnitByte = ByteUtil.onCheckOutBitAtIndex(unitData, Constant.BIT2);
		String distanceUnit = "km";
		if (distanceUnitByte == 0) {
			distanceUnit = "km";
		} else {
			distanceUnit = "mile";
		}
		mCarLargeInfo.setDistanceUnit(distanceUnit);
		// 油耗单位
		byte bit1Data0 = ByteUtil.onCheckOutBitAtIndex(unitData, Constant.BIT1);
		byte bit0Data0 = ByteUtil.onCheckOutBitAtIndex(unitData, Constant.BIT0);
		byte oilUnitByte = (byte) (bit1Data0 * 2 + bit0Data0);
		String oilUnit = "MPG";
		if (oilUnitByte == 1) {
			oilUnit = "km/L";
		} else if (oilUnitByte == 2) {
			oilUnit = "L/100km";
		} else if (oilUnitByte == 3) {
			oilUnit = "L/H";
		}
		mCarLargeInfo.setOilUnit(oilUnit);

		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeCarDefinite(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		
		// 刹车
		byte data0 = intackBytes[Constant.DATA0];
		byte bit1Data0 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT1);
		mCarBaseInfo.setFootBrakePulled(bit1Data0 == 1 ? true : false);
		byte bit0Data0 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT0);
		mCarBaseInfo.setHandBrakePulled(bit0Data0 == 1 ? true : false);
		// 档位 重复了
//		byte data1 = intackBytes[Constant.DATA1];
//		mCarBaseInfo.setGear(data1);
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
		//电池电压
//		byte voltage = intackBytes[Constant.DATA6];
//		String VoltagesString = (ByteUtil.convertByteToInt(voltage)/10.0)+"";
//		mCarLargeInfo.setVoltage(VoltagesString);
		//气门
//		byte throttle = intackBytes[Constant.DATA7];
//		mCarLargeInfo.setThrottle(throttle);
		//剩余油量
		byte surplusOil = intackBytes[Constant.DATA8];
		mCarLargeInfo.setSurplusOil(ByteUtil.convertByteToInt(surplusOil));
		//冷却液温度
//		byte coolant = intackBytes[Constant.DATA9];
//		mCarLargeInfo.setCoolantTemp((byte) (ByteUtil.convertByteToInt(coolant)-40));
		//机油压力
//		byte oilPressHigh = intackBytes[Constant.DATA10];
//		byte oilPressLow = intackBytes[Constant.DATA11];
//		int oilPress = ByteUtil.HighLowByteToInt(oilPressHigh, oilPressLow);
//		mCarLargeInfo.setOilPress(oilPress);
		//大气压力
//		int airPress = ByteUtil.convertByteToInt(intackBytes[Constant.DATA12]);
//		mCarLargeInfo.setAirPress(airPress);
		//剩余油位
//		int oilPercent = ByteUtil.convertByteToInt(intackBytes[Constant.DATA13]);
//		mCarLargeInfo.setOilPercent(oilPercent);
		
		baseInfolList.add(mCarLargeInfo);
		baseInfolList.add(mCarBaseInfo);
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
		mAirConditionInfo.setWindGradeTotal(18);
		if (mAirdata5==0x13) {
			mAirConditionInfo.setAutoSwitch1(true);
		}
		// data6 左边座椅温度设数值
		byte mAirdata6 = intackBytes[Constant.DATA6];
		float frontLeftSeatSetTemp = analyzeSeatHeatGrade(mAirdata6);
		mAirConditionInfo.setFrontLeftSeatSetTemp(frontLeftSeatSetTemp);
		// data7 右边座椅温度设数值
		byte mAirdata7 = intackBytes[Constant.DATA7];
		float frontRightSeatSetTemp = analyzeSeatHeatGrade(mAirdata7);
		mAirConditionInfo.setFrontRightSeatSetTemp(frontRightSeatSetTemp);
		//后排
		byte mAirdata8 = intackBytes[Constant.DATA8];
		mAirConditionInfo.setBackWindMode(mAirdata8);
		byte mAirdata9 = intackBytes[Constant.DATA9];
		mAirConditionInfo.setBackWindInfo(mAirdata9);
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
		mAirConditionInfo.setLeftWindBlowWindow(false);
		mAirConditionInfo.setLeftWindBlowHead(false);
		mAirConditionInfo.setLeftWindBlowFoot(false);
		mAirConditionInfo.setRightWindBlowWindow(false);
		mAirConditionInfo.setRightWindBlowHead(false);
		mAirConditionInfo.setRightWindBlowFoot(false);
	}

	private void analyzeAirData2(byte mAirdata, byte mAirdata1) {
		// 除雾
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setAutoWindowDemist(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setBackWindowDemist(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT4);
		mAirConditionInfo.setFrontWindowDemist(bit4 == 1 ? true : false);
		
		byte bit7Airdata1 = ByteUtil.onCheckOutBitAtIndex(mAirdata1, Constant.BIT7);
		byte bit6Airdata1 = ByteUtil.onCheckOutBitAtIndex(mAirdata1, Constant.BIT6);
		// 等级 右
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		if (bit7Airdata1==1) {
			mAirConditionInfo.setRightSeatWindGrade((byte) (bit3*2+bit2));
		}else {
			mAirConditionInfo.setRightSeatHeatGrade(bit3*2+bit2);
		}
		// 等级 左
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT0);
		if (bit6Airdata1==1) {
			mAirConditionInfo.setLeftSeatWindGrade((byte) (bit1*2+bit0));
		}else {
			mAirConditionInfo.setLeftSeatHeatGrade(bit1*2+bit0);
		}
	}
	
	private void analyzeAirData1(byte mAirdata) {
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT7);
		mAirConditionInfo.setCopilotStates(bit7);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setMainStates(bit6);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setAirQualEnable(bit5 == 1 ? true : false);
		// 循环模式
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT4);
		mAirConditionInfo.setCircleOut(bit4==0);
		// 自动内外循环
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		mAirConditionInfo.setAutocyclicModeSet(bit3 == 1 ? true : false);
	}
	
	private void analyzeAirData0(byte mAirdata) {
		// HybridAC
		byte bit1 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT0);
		byte acValue = (byte)(bit1*2+bit0);
		if (acValue==0) {
			mAirConditionInfo.setAcEnable(false);
		}else if (acValue==1) {
			mAirConditionInfo.setAcEnable(true);
		}else if(acValue==2){
			mAirConditionInfo.setHybridAC(true);
		}
		// sync
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		mAirConditionInfo.setGmSync((byte) (bit3*2+bit2));
		// 空调开关
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setSwitchAir(bit6 == 1 ? true : false);
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT7);
		mAirConditionInfo.setShowAir(bit7 == 1 ? true : false);
	}

	private List<BaseInfo> analyzePanelChoice(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data0 = intackBytes[Constant.DATA0];
		mCarBaseInfo.setPanelChoice(data0);
		baseInfolList.add(mCarBaseInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzePanelKnob(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		byte data0 =intackBytes[Constant.DATA0];
		knobvalue =intackBytes[Constant.DATA1];
		switch (data0) {
		case  0x01:
			if (knobvalue>0) {
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_UP);
				mKeyFunctionInfo.setStepValue(knobvalue);
			}else if (knobvalue<0) {
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_DOWN);
				mKeyFunctionInfo.setStepValue(-knobvalue);
			} 
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
			case 1:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_POWER);break;
			case 2:mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);break;
			case 3:mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);break;
			case 6:mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_BACK);break;
			case 7:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_COLLEC_RADIO);break;
			case 0X1F:
			case 8:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_AUXIN);break;
			case 9:mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);break;
			case 0X25:
			case 0X20:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_NAVI);break;
			case 0X2C:
			case 0X24:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);break;
			case 0X28:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_BLUE_PHONE);break;	
			case 0X2B:
			case 0X2D:mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_HOME);break;
			}
		}
		baseInfolList.add(mKeyFunctionInfo);
		return baseInfolList;
	}

	
	private List<BaseInfo> analyzeDetailedCar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data0 = intackBytes[Constant.DATA0];
		mCarBaseInfo.setIgnitionMode(data0);
		byte data1 = intackBytes[Constant.DATA1];
		mCarBaseInfo.setGear(data1);
		// 门状态
		byte data2 = intackBytes[Constant.DATA2];
		analyzeDoorInfo(baseInfolList, data2);
		//瞬时油耗
//		byte pointFront = intackBytes[Constant.DATA3];
//		byte pointBack = intackBytes[Constant.DATA4];
//		if (pointFront<0||pointFront>99) {
//			pointFront = 99;
//		}
//		if (pointBack<0||pointBack>99) {
//			pointBack = 99;
//		}
//		String instantFuel = pointFront+"."+pointBack;
//		mCarLargeInfo.setInstantFuel(instantFuel);
		// 钥匙是否存在
		byte data5 = intackBytes[Constant.DATA5];
		mCarBaseInfo.setKeyExist(data5 == 1 ? true : false);
//		analyzeDetailedCarData6(intackBytes);
		// 电池电压
		byte data7 = intackBytes[Constant.DATA7];
		mCarLargeInfo.setVoltage( (ByteUtil.convertByteToInt(data7)/10.0) +"");
		// 手刹拉起
		byte data8 = intackBytes[Constant.DATA8];
		mCarBaseInfo.setHandBrakePulled(data8 == 1 ? true : false);
		baseInfolList.add(mCarLargeInfo);
		baseInfolList.add(mCarBaseInfo);
		return baseInfolList;
	}

	private void analyzeDetailedCarData6(Byte[] intackBytes) {
		CarAlarm mCarAlarm = new CarAlarm();
		byte data6 = intackBytes[Constant.DATA6];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data6, Constant.BIT7);
		mCarAlarm.setNoOilWarn(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data6, Constant.BIT6);
		mCarAlarm.setNoElecWarn(bit6 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data6, Constant.BIT3);
		mDoorInfo.setRighBW(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data6, Constant.BIT2);
		mDoorInfo.setLeftBW(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data6, Constant.BIT1);
		mDoorInfo.setRighFW(bit1 == 1 ? true : false);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data6, Constant.BIT0);
		mDoorInfo.setLeftFW(bit0 == 1 ? true : false);
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
	
	/** 车身基本信息 */
	private List<BaseInfo> analyzeBaseCar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		// data0 信号有效信息
		byte data0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT7);
		mCarBaseInfo.setAnJiXing(bit7 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT4);
		mCarBaseInfo.setKeyInValidity(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT3);
		mCarBaseInfo.setPARK(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT2);
		mCarBaseInfo.setREV(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT1);
		mCarBaseInfo.setILL(bit1 == 1 ? true : false);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT0);
		mCarBaseInfo.setACC(bit0 == 1 ? true : false);
		// data1 车速  和瞬时车速重复
//		byte data1 = intackBytes[Constant.DATA1];
//		mCarBaseInfo.setCarSpeed(ByteUtil.convertByteToInt(data1));
		// data3 按键状态
		byte data3 = intackBytes[Constant.DATA3];
		mKeyFunctionInfo.setKeyDown(data3 == 1 ? true : false);
		// data2 方向盘按键  按键抬起时，算一次有效
		byte data2 = intackBytes[Constant.DATA2];
		if (mKeyFunctionInfo.isKeyDown()) {
			analyzeKeyFuction(mKeyFunctionInfo,data2);
		}
		byte data4 = intackBytes[Constant.DATA4];
		mCarBaseInfo.setKeyLight(data4);
		byte data5 = intackBytes[Constant.DATA5];
		mCarBaseInfo.setDisLight(data5);
		// data6 方向盘转角高位
		byte data6 = intackBytes[Constant.DATA6];
		// data7 方向盘转角低位
		byte data7 = intackBytes[Constant.DATA7];
		String corHighString = ByteUtil.parseByteToHexString(data6, null);
		String corLowString = ByteUtil.parseByteToHexString(data7, null);
		int leftCor = PROTOCAL_INVALID_VALUE;
		int rightCor = PROTOCAL_INVALID_VALUE;
		if (data6 < 0) {
			leftCor = ByteUtil.HighLowByteToInt(data6,data7) - 65536;
		} else {
			rightCor = ByteUtil.HighLowByteToInt(data6,data7);
		}
		mCornerInfo.setLeftCorner(leftCor);
		mCornerInfo.setRightCorner(rightCor);
		// 发动机转速 最高位+最低位
//		byte speedHigh = intackBytes[Constant.DATA8];
//		byte speedLow = intackBytes[Constant.DATA9];
//		int rotateSpeed = parseByteToHexToInt(speedHigh, speedLow);
//		mCarLargeInfo.setRotateSpeed(rotateSpeed);
		baseInfolList.add(mCarLargeInfo);
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
        case 6:
        	mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_HANGUP);
			break;
		case 8:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
			break;
		case 9:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);
			break;
		case 10:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		}
	}

}
