package com.landsem.canbox.comparse.hiworld;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.view.KeyEvent;

import com.landsem.canbox.Constant;
import com.landsem.canbox.activity.BaseActivity;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CSyncInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CarLargeInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.PeripheralInfo;
import com.landsem.canbox.bean.RadarInfo;
import com.landsem.canbox.comparse.BaseComParse;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;

/**
 * 福特 模块上行(协议盒->DVD主机)数据的解析处理类
 */
public class FordParse extends HiworldBaseParse2 {

	public FordParse() {
		super((byte) 0xFF, (byte) 0x5A, (byte) 0xA5);
	}
	int knobvalue = 0;
	PeripheralInfo mPeripheralInfo = new PeripheralInfo();
	CSyncInfo mCSyncInfo = new CSyncInfo();

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		String readMsg = ByteUtil.onPrintByteArray(intackBytes,"FordParse--data: ");
//		BaseActivity.sendBroadcastToActivity(readMsg);
		byte comID = intackBytes[Constant.COMID];
		switch (comID) {
		case Constant.FordComID.COMID_INFO_BASE_CAR:
			return analyzeBaseCar(intackBytes);
		case Constant.FordComID.COMID_INFO_DETAILED_CAR:
			return analyzeDetailedCar(intackBytes);
		case Constant.FordComID.COMID_INFO_AIR_CONDITION:
			return analyzeAirCondition(intackBytes);
		case Constant.FordComID.COMID_INFO_RADAR_FB:
			return analyzeRadarFB(intackBytes);
		case Constant.FordComID.COMID_INFO_RADAR_LR:
			return analyzeRadarLR(intackBytes);
//		case Constant.FordComID.COMID_INFO_SOFT_VERSION:
//			return analyzeSoftVersion(intackBytes);
//		case Constant.FordComID.COMID_INFO_SYNC_DISPLAY:
//			return analyzeSyncDisplay(intackBytes);
//		case Constant.FordComID.COMID_INFO_SYNC_PLAY:
//			return analyzeSyncPlay(intackBytes);
//		case Constant.FordComID.COMID_INFO_SYNC_STATE:
//			return analyzeSyncState(intackBytes);
//		case Constant.FordComID.COMID_INFO_INTELLIGENT_SPEECH:
//			return analyzeIntelligentSpeech(intackBytes);
//		case Constant.FordComID.COMID_INFO_LANGUAGE_SET:
//			return analyzeLanguageSet(intackBytes);
//		case Constant.FordComID.COMID_INFO_PROMPT_SET:
//			return analyzePromptSet(intackBytes);
//		case Constant.FordComID.COMID_INFO_VIDEO_SET:
//			return analyzeVideoSet(intackBytes);
		case Constant.FordComID.COMID_INFO_OIL_DISTANCE:
			return analyzeOilDistance(intackBytes);
//		case Constant.FordComID.COMID_INFO_DISTINGUISH:
//			return analyzeDistinguish(intackBytes);
		case Constant.HiworldComID.COMID_INFO_CAR_DEFINITE:
			return analyzeCarDefinite(intackBytes);
		case Constant.FordComID.COMID_INFO_PANEL_KEY:
			return analyzePanelKey(intackBytes);
		case Constant.FordComID.COMID_INFO_PANEL_KNOB:
			return analyzePanelKnob(intackBytes);
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

	private List<BaseInfo> analyzeOilDistance(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data4 = intackBytes[Constant.DATA4];
		byte data5 = intackBytes[Constant.DATA5];
		byte data6 = intackBytes[Constant.DATA6];
		int value = ByteUtil.HighMidLowByteToInt( data4,data5,data6 );
		mCarLargeInfo.setMileage(value / 10);
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeVideoSet(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data2 = intackBytes[Constant.DATA2];
		mPeripheralInfo.setCameraDelayed(data2 == 1 ? true : false);
		baseInfolList.add(mPeripheralInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzePromptSet(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data1 = intackBytes[Constant.DATA1];
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT4);
		mCarBaseInfo.setNoticeUnit(bit4);
		baseInfolList.add(mCarBaseInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeLanguageSet(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data0 = intackBytes[Constant.DATA0];
		mCarBaseInfo.setLanguageSet(data0);
		baseInfolList.add(mCarBaseInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeIntelligentSpeech(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data0 = intackBytes[Constant.DATA0];
		mCarBaseInfo.setSpeechOrder(data0);
		byte data1 = intackBytes[Constant.DATA1];
		mCarBaseInfo.setSpeechMSB(data1);
		byte data2 = intackBytes[Constant.DATA2];
		mCarBaseInfo.setSpeechLSB(data2);

		baseInfolList.add(mCarBaseInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeSyncState(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data0 = intackBytes[Constant.DATA0];
		mCSyncInfo.setSoundMode(data0);
		byte data1 = intackBytes[Constant.DATA1];
		mCSyncInfo.setDisplayMode(data1);
		byte data2 = intackBytes[Constant.DATA2];
		mCSyncInfo.setBlueToothOpen(data2 == 1 ? true : false);

		baseInfolList.add(mCSyncInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeSyncPlay(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data0 = intackBytes[Constant.DATA0];
		mCSyncInfo.setPlayScreenNum(data0);
		// 播放时间 最高位+最低位
		byte high = intackBytes[Constant.DATA3];
		byte low = intackBytes[Constant.DATA2];
		String highString = ByteUtil.parseByteToHexString(high, null);
		String lowString = ByteUtil.parseByteToHexString(low, null);
		int playTime = ByteUtil.HighLowByteToInt(high,low);
		mCSyncInfo.setPlayTime(playTime);
		baseInfolList.add(mCSyncInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeSyncDisplay(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data0 = intackBytes[Constant.DATA0];
		mCSyncInfo.setScreenNum(data0);
		byte data1 = intackBytes[Constant.DATA1];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT7);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT6);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT5);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT4);
		mCSyncInfo.setRowNum((byte) (bit7 * 8 + bit6 * 4 + bit5 * 2 + bit4));
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT2);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT0);
		mCSyncInfo.setGroupNum((byte) (bit3 * 8 + bit2 * 4 + bit1 * 2 + bit0));
		analyzeSyncDisplayUnicode(intackBytes, mCSyncInfo);

		baseInfolList.add(mCSyncInfo);
		return baseInfolList;
	}

	private void analyzeSyncDisplayUnicode(Byte[] intackBytes,
			CSyncInfo mCSyncInfo) {
		// TODO 还没解完，可能有问题
		// 屏图标
		byte low = intackBytes[Constant.DATA2];
		byte high = intackBytes[Constant.DATA3];
		mCSyncInfo.setScreenIcon1(getIconString(low, high));
		low = intackBytes[Constant.DATA4];
		high = intackBytes[Constant.DATA5];
		mCSyncInfo.setScreenIcon3(getIconString(low, high));
		low = intackBytes[Constant.DATA6];
		high = intackBytes[Constant.DATA7];
		mCSyncInfo.setScreenIcon5(getIconString(low, high));
		// 行图标
		low = intackBytes[Constant.DATA8];
		high = intackBytes[Constant.DATA9];
		mCSyncInfo.setRow11(getIconString(low, high));
		low = intackBytes[Constant.DATA10];
		high = intackBytes[Constant.DATA11];
		mCSyncInfo.setRow21(getIconString(low, high));
		low = intackBytes[Constant.DATA12];
		high = intackBytes[Constant.DATA13];
		mCSyncInfo.setRow31(getIconString(low, high));
		low = intackBytes[Constant.DATA14];
		high = intackBytes[Constant.DATA15];
		mCSyncInfo.setRow41(getIconString(low, high));
		low = intackBytes[Constant.DATA16];
		high = intackBytes[Constant.DATA17];
		mCSyncInfo.setRow51(getIconString(low, high));

	}

	private String getIconString(byte low, byte high) {
		String highString = ByteUtil.parseByteToHexString(high, null);
		String lowString = ByteUtil.parseByteToHexString(low, null);
		return unicode2string(highString + lowString);
	}

	public static String unicode2string(String s) {
		List<String> list = new ArrayList<String>();
		String zz = "[0-9,a-z,A-Z]{4}";
		String groupString = "";
		// 正则表达式用法参考API
		Pattern pattern = Pattern.compile(zz);
		Matcher m = pattern.matcher(s);
		while (m.find()) {
			groupString = m.group();
			list.add(groupString);
		}
		for (int i = 0, j = 0; i < list.size(); i++) {
			String st = list.get(i).substring(j, j + 4);
			// 将得到的数值按照16进制解析为十进制整数，再強转为字符
			char ch = (char) Integer.parseInt(st, 16);
			// 用得到的字符替换编码表达式
			s = s.replace(list.get(i), String.valueOf(ch));
		}
		return s;
	}

	private List<BaseInfo> analyzeRadarLR(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 距离
		mRadarInfo.setRightFrontValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA0])*36);
		mRadarInfo.setRightMidFrontValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA1])*36);
		mRadarInfo.setRightMidBackValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA2])*36);
		mRadarInfo.setRightBackValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA3])*36);
		mRadarInfo.setLeftFrontValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA4])*36);
		mRadarInfo.setLeftMidFrontValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA5])*36);
		mRadarInfo.setLeftMidBackValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA6])*36);
		mRadarInfo.setLeftBackValue(ByteUtil
				.convertByteToInt(intackBytes[Constant.DATA7])*36);
		baseInfolList.add(mRadarInfo);
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
		// data4
		byte mAirdata4 = intackBytes[Constant.DATA4];
		analyzeAirData4(mAirConditionInfo, mAirdata4);
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
		// 后排空调
		byte mAirdata8 = intackBytes[Constant.DATA8];
		analyzeAirData8(mAirConditionInfo, mAirdata8);
		// 后排风速
		byte mAirdata9 = intackBytes[Constant.DATA9];
		mAirConditionInfo.setBackWindGrade(mAirdata9);
		// 后排空气温度
		byte mAirdata10 = intackBytes[Constant.DATA10];
		mAirConditionInfo.setBackTemp(mAirdata10);

		baseInfolList.add(mAirConditionInfo);
		return baseInfolList;
	}

	private void analyzeAirData8(AirConditionInfo mAirConditionInfo,
			byte mAirdata) {
		// 后排面板
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT7);
		mAirConditionInfo.setBackPanel(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setBackAirEnable(bit6 == 1 ? true : false);
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
			mAirConditionInfo.setLeftWindBlowBody(true);
			mAirConditionInfo.setLeftWindBlowFoot(true);
			mAirConditionInfo.setRightWindBlowHead(true);
			mAirConditionInfo.setRightWindBlowFoot(true);
			break;
		// 吹身
		case 6:
			mAirConditionInfo.setLeftWindBlowBody(true);
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
			mAirConditionInfo.setLeftWindBlowBody(true);
			mAirConditionInfo.setRightWindBlowWindow(true);
			mAirConditionInfo.setRightWindBlowHead(true);
			break;
		// 吹窗 吹身 吹脚
		case 0xE:
			mAirConditionInfo.setLeftWindBlowWindow(true);
			mAirConditionInfo.setLeftWindBlowBody(true);
			mAirConditionInfo.setLeftWindBlowFoot(true);
			mAirConditionInfo.setRightWindBlowWindow(true);
			mAirConditionInfo.setRightWindBlowHead(true);
			mAirConditionInfo.setRightWindBlowFoot(true);
			break;
		}

	}

	private void analyzeAirData2(AirConditionInfo mAirConditionInfo,
			byte mAirdata) {
		// 除雾
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setBackWindowDemist(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT4);
		mAirConditionInfo.setFrontWindowDemist(bit4 == 1 ? true : false);
		// 右边座椅加热等级
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		mAirConditionInfo.setRightSeatHeatGrade((bit3 * 2 + bit2));
		// 左边座椅加热等级
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT0);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT1);
		mAirConditionInfo.setLeftSeatHeatGrade((bit1 * 2 + bit0));
	}

	private void analyzeAirData1(AirConditionInfo mAirConditionInfo,
			byte mAirdata) {
		// 后空调锁打开
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT7);
		mAirConditionInfo.setMaxHeat(bit7 == 1 ? true : false);
		// AC Max
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setAcMaxSwitch(bit6 == 1 ? true : false);
		// 循环模式
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT4);
		mAirConditionInfo.setCircleOut(bit4==1);
		// AUTO
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		mAirConditionInfo.setAutoSwitch1(bit3 == 1 ? true : false);
		// AC
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT0);
		mAirConditionInfo.setAcEnable(bit0 == 1 ? true : false);
	}

	private void analyzeAirData0(AirConditionInfo mAirConditionInfo,
			byte mAirdata) {
		// 空调开关
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setSwitchAir(bit6 == 1 ? true : false);
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
			case 2:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_SCAN_DOWN);break;
			case 3:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_SCAN_UP);break;
			case 5:mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);break;
			case 0X1F:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_AUXIN);break;
			case 0X24:
			case 0X2C:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);break;
			case 0X28:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_BLUE_PHONE);break;	
			case 0X2D:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_COLLEC_RADIO);break;
//			case 0X3A:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_CD);break;此车型暂未实现CD功能
			case 0X3B:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MUSIC);break;
			case 0X3C:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_CHANNEL_UP);break;
			case 0X3D:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_CHANNEL_DOWN);break;	
			case 0X3E:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_SCAN_ALL);break;
			case 0X3F:mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_HOME);break;
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

		baseInfolList.add(mCarBaseInfo);
		return baseInfolList;
	}

	private void analyzeDoorInfo(List<BaseInfo> baseInfolList, byte data) {
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT0);
		mDoorInfo.setValid(bit0 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT3);
		mDoorInfo.setBackTrunk(bit3 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT4);
		mDoorInfo.setRightBackDoor(bit4 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT5);
		mDoorInfo.setLeftBackDoor(bit5 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT6);
		mDoorInfo.setPassengerDoor(bit6 == 1 ? true : false);
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT7);
		mDoorInfo.setDriverDoor(bit7 == 1 ? true : false);
		baseInfolList.add(mDoorInfo);
	}

	/** 车身基本信息 */
	private List<BaseInfo> analyzeBaseCar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		
		// data0 信号有效信息
		byte data0 = intackBytes[Constant.DATA0];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT7);
		mCarBaseInfo.setSync(bit7 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT4);
		mCarBaseInfo.setKeyIn(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT3);
		mCarBaseInfo.setPARK(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT2);
		mCarBaseInfo.setREV(bit2 == 1 ? true : false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT1);
		mCarBaseInfo.setILL(bit1 == 1 ? true : false);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT0);
		mCarBaseInfo.setACC(bit0 == 1 ? true : false);
		// data1 车速 和瞬时车速重复
//		byte data1 = intackBytes[Constant.DATA1];
//		mCarBaseInfo.setCarSpeed(ByteUtil.convertByteToInt(data1));
		// data3 按键按下
		byte data3 = intackBytes[Constant.DATA3];
		mKeyFunctionInfo.setKeyDown(data3 == 1 ? true : false);
		// data2 方向盘按键
		byte data2 = intackBytes[Constant.DATA2];
		if (mKeyFunctionInfo.isKeyDown()) {
			analyzeKeyFuction(mKeyFunctionInfo,data2);
		}
		// ILL值
		byte data5 = intackBytes[Constant.DATA5];
		mCarBaseInfo.setILLValue(data5);
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
        case 3:
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
			break;
        case 4:
        	mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOICE);
			break;
        case 5://挂电话、下一曲
        	mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_HANGUP_NEXT);
			break;
        case 6://接电话、上一曲
        	mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_ANSWER_PREV);
			break;
		}
	}

	/**
	 * 校验
	 * 
	 * @return
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
			LogManager.d("FordParse  onCheckBytesValidity  check_Sum:  "
					+ checkSum + "   check_bit:"
					+ orderBytes[orderBytes.length - 1]);
		}
		return resultCode;
	}

}
