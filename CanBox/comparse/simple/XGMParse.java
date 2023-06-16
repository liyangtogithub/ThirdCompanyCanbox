package com.landsem.canbox.comparse.simple;

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
 *  欣朴协议  ：通用  不用面板
 */
public class XGMParse extends SimpleBaseParse {
	public XGMParse() {
		super((byte) 0xFF, (byte) 0x2e, (byte) 0xA5);
	}
	byte windGrade;
	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		ByteUtil.onPrintByteArray(intackBytes, "XGMParse--data: ");
		byte comID = intackBytes[Constant.COMID_XINPU];
		switch (comID) {
		case Constant.XGMComID.DATA_TYPE_KEY:
			return analyzeSteerKey(intackBytes);
		case Constant.XGMComID.DATA_TYPE_KNOB:
			return analyzePanelKey(intackBytes);
		case Constant.XGMComID.DATA_TYPE_AIR:
			return analyzeAirCondition(intackBytes);
		case Constant.XGMComID.DATA_TYPE_LIGHT:
			return analyzeBackLight(intackBytes);
		case Constant.XGMComID.DATA_TYPE_RADAR_B:
			return analyzeRadarB(intackBytes);
		case Constant.XGMComID.DATA_TYPE_RADAR_F:
			return analyzeRadarF(intackBytes);
		case Constant.XGMComID.DATA_TYPE_DOOR:	
			return analyzeBaseCar(intackBytes);
		case Constant.XGMComID.DATA_TYPE_CORNER:	
			return analyzeCorner(intackBytes);
		case Constant.XGMComID.DATA_TYPE_CAR1:	
			return analyzeCAR1(intackBytes);
		case Constant.XGMComID.DATA_TYPE_CAR2:	
			return analyzeCAR2(intackBytes);
		case Constant.XGMComID.DATA_TYPE_SPEED:	
			return analyzeSpeed(intackBytes);
		}
		return null;
	}
	
	private List<BaseInfo> analyzeSpeed(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 瞬时车速 最高位+最低位
		byte instantHigh = intackBytes[Constant.DATA0_XINPU];
		byte instantLow = intackBytes[Constant.DATA1_XINPU];
		int instantSpeed = ByteUtil.HighLowByteToInt(instantHigh, instantLow)/16;
		mCarLargeInfo.setInstantSpeed(instantSpeed);
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeCAR2(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 发动机转速 最高位+最低位 
		byte high = intackBytes[Constant.DATA0_XINPU];
		byte low = intackBytes[Constant.DATA1_XINPU];
		int data = ByteUtil.HighLowByteToInt(high, low);
		mCarLargeInfo.setRotateSpeed(data);
		// 瞬时油耗 最高位+最低位
		high = intackBytes[Constant.DATA2_XINPU];
		low = intackBytes[Constant.DATA3_XINPU];
		data = ByteUtil.HighLowByteToInt(high, low);
		mCarLargeInfo.setInstantFuel((data / 10f) + "");
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeCAR1(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 电池电压
		byte data1 = intackBytes[Constant.DATA1_XINPU];
		mCarLargeInfo.setVoltage( (ByteUtil.convertByteToInt(data1)/10.0) +"");
		// 车外温度
		byte outdoorTemp = intackBytes[Constant.DATA2_XINPU];
		mAirConditionInfo.setOutdoorTemp(outdoorTemp);
		byte data4 = intackBytes[Constant.DATA4_XINPU];
		byte data5 = intackBytes[Constant.DATA5_XINPU];
		byte data6 = intackBytes[Constant.DATA6_XINPU];
		byte data7 = intackBytes[Constant.DATA7_XINPU];
		int value = ByteUtil.HighMid2LowByteToInt( data4,data5, data6,data7);
		mCarLargeInfo.setMileage(value);
		baseInfolList.add(mCarLargeInfo);
		baseInfolList.add(mAirConditionInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeCorner(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte dataH = intackBytes[Constant.DATA1_XINPU];
		byte dataL =  intackBytes[Constant.DATA0_XINPU];
		
		// 方向盘转角
		short dregress = (short) ((dataH << 8) + (dataL & 0xFF));
		short tempH = (short) (dataH << 8);
		short tempL = (short) (dataL & 0xFF);
		if (tempH>=0) {
			dregress = (short) (tempH + tempL);
			dregress = (short) (dregress/10);
		} else {
			dregress = (short) ~dregress;
			dregress = (short) (dregress + 1);
			dregress = (short) (dregress/10);
			dregress = (short)(-(dregress & 0x07FF));
		}
		int leftCor = PROTOCAL_INVALID_VALUE;
		int rightCor = PROTOCAL_INVALID_VALUE;
		if (dregress>540) dregress = 540;
		if (dregress<-540) dregress = -540;
		if (dregress > 0) {
			leftCor = -dregress;
		} else if (dregress < 0) {
			rightCor = -dregress;
		} else {
			rightCor = leftCor = dregress;
		}
		mCornerInfo.setLeftCorner(leftCor);
		mCornerInfo.setRightCorner(rightCor);
		baseInfolList.add(mCornerInfo);
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
		case 0x01:
			distance = 0;
			break;
		case 0x00:
		case 0x07:
			distance = 255;
			break;
       default:
        	distance = 42*(byte1-1);
			break;
		}
		return distance;
	}
	
	private List<BaseInfo> analyzeBackLight(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data0 = intackBytes[Constant.DATA0_XINPU];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT7);
		mCarBaseInfo.setILL(bit7 == 0 ? true : false);
		baseInfolList.add(mCarBaseInfo);
		return baseInfolList;
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
		byte data1 = intackBytes[Constant.DATA1_XINPU];
		byte bit7Data1 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT7);
		mDoorInfo.setEngineHood(bit7Data1 == 1 ? true : false);
		baseInfolList.add(mDoorInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeAirCondition(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// data0
		byte mAirdata0 = intackBytes[Constant.DATA0_XINPU];
		analyzeAirData0(mAirdata0);
		// data1
		byte mAirdata1 = intackBytes[Constant.DATA1_XINPU];
		analyzeAirData1( mAirdata1);
		// data2 左边空调温度
		byte mAirdata2 = intackBytes[Constant.DATA2_XINPU];
		float frontLeftSeatSetTemp = analyzeAirTemp(mAirdata2);
		mAirConditionInfo.setFrontLeftSeatSetTemp(frontLeftSeatSetTemp);
		// data3 右边空调温度
		byte mAirdata3 = intackBytes[Constant.DATA3_XINPU];
		float frontRightSeatSetTemp = analyzeAirTemp(mAirdata3);
		mAirConditionInfo.setFrontRightSeatSetTemp(frontRightSeatSetTemp);
		
		// data4
		byte mAirdata4 = intackBytes[Constant.DATA4_XINPU];
		analyzeSeatHeatGrade(mAirdata4);
		
		baseInfolList.add(mAirConditionInfo);
		return baseInfolList;
	}
	
	private float analyzeAirTemp(byte mAirdata) {
		float airTemp = ByteUtil.convertByteToInt(mAirdata);
		if (airTemp<=0x1c && airTemp>=0x01) {
			airTemp = (airTemp-1)/2+17;
			return airTemp;
		}
		switch ((int)airTemp) {
		case 0x00:
			airTemp = Constant.AIR_LOW;
			break;
		case 0x1e:
			airTemp = Constant.AIR_HIGH;
			break;
		case 0x1d:
			airTemp = 16;
			break;
		case 0x1f:
			airTemp = 16.5f;
			break;
		case 0x20:
			airTemp = 15;
			break;
		case 0x21:
			airTemp = 15.5f;
			break;
		case 0x22:
			airTemp = 31;
			break;
		}
		return airTemp;
	}

	private void analyzeSeatHeatGrade(byte mAirdata) {
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT7);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT4);
		mAirConditionInfo.setLeftSeatHeatGrade(bit7*8+bit6*4+bit5*2+bit4);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT0);
		mAirConditionInfo.setRightSeatHeatGrade(bit3*8+bit2*4+bit1*2+bit0);
	}

	private void analyzeAirData1(byte mAirdata) {
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setDualSwitch(bit5==1);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT4);
		windGrade = bit4==1 ? 8:windGrade;
		mAirConditionInfo.setLeftWindGrade(windGrade);
		mAirConditionInfo.setRightWindGrade(windGrade);
		mAirConditionInfo.setWindGradeTotal((byte) 8);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT0);
		
		byte windMode = (byte) (bit3*8+bit2*4+bit1*2+bit0);
		initWindMode();
		switch (windMode) {
		// 自动
		case 1:
			mAirConditionInfo.setAutoSwitch1(true);
			break;
		// 前除雾
		case 2:
			mAirConditionInfo.setFrontWindowDemist(true);
			break;
		// 向下
		case 3:
			mAirConditionInfo.setLeftWindBlowFoot(true);
			mAirConditionInfo.setRightWindBlowFoot(true);
			break;
		// 向下 平行
		case 4:
			mAirConditionInfo.setLeftWindBlowFoot(true);
			mAirConditionInfo.setRightWindBlowFoot(true);
			mAirConditionInfo.setLeftWindBlowBody(true);
			mAirConditionInfo.setRightWindBlowBody(true);
			break;
		// 平行
		case 5:
			mAirConditionInfo.setLeftWindBlowBody(true);
			mAirConditionInfo.setRightWindBlowBody(true);
			break;
		// 平行 向上
		case 6:
			mAirConditionInfo.setLeftWindBlowBody(true);
			mAirConditionInfo.setRightWindBlowBody(true);
			mAirConditionInfo.setLeftWindBlowHead(true);
			mAirConditionInfo.setRightWindBlowHead(true);
			break;
		//  向上
		case 7:
			mAirConditionInfo.setLeftWindBlowHead(true);
			mAirConditionInfo.setRightWindBlowHead(true);
			break;
		// 向上 向下
		case 8:
			mAirConditionInfo.setLeftWindBlowHead(true);
			mAirConditionInfo.setRightWindBlowHead(true);
			mAirConditionInfo.setLeftWindBlowFoot(true);
			mAirConditionInfo.setRightWindBlowFoot(true);
			break;
		// 向上 向下 平行
		case 9:
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
		mAirConditionInfo.setAutoSwitch1(false);
		mAirConditionInfo.setFrontWindowDemist(false);
		mAirConditionInfo.setLeftWindBlowBody(false);
		mAirConditionInfo.setRightWindBlowBody(false);
		mAirConditionInfo.setLeftWindBlowWindow(false);
		mAirConditionInfo.setRightWindBlowWindow(false);
		mAirConditionInfo.setLeftWindBlowHead(false);
		mAirConditionInfo.setRightWindBlowHead(false);
		mAirConditionInfo.setLeftWindBlowFoot(false);
		mAirConditionInfo.setRightWindBlowFoot(false);
	}
	
	private void analyzeAirData0(byte mAirdata) {
		// 开关
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT7);
		mAirConditionInfo.setSwitchAir(bit7 == 1 ? true : false);
		// A/C
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setAcEnable(bit6 == 1 ? true : false);
		//内外循环
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setCircleOut(bit5==0 ? true : false);
		//后窗加热
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT4);
		mAirConditionInfo.setBackWindowDemist(bit4 == 1 ? true : false);
		// 风速等级
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT0);
		windGrade = (byte) ( bit2 * 4 + bit1 * 2 + bit0);
	}
	
	private List<BaseInfo> analyzePanelKey(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		// data1 按键状态
		byte data1 = intackBytes[Constant.DATA1_XINPU];
		if (data1 == 1) {
			mKeyFunctionInfo.setKeyDown(true);
		} else if (data1 == 2) {
			mKeyFunctionInfo.setSteeringKeyLongDown(true);
		}
//		mKeyFunctionInfo.setStepValueMax(30);
		byte data0 = intackBytes[Constant.DATA0_XINPU];
		
		if (data0 == (byte) 0x17 || data0 == (byte) 0x18) {
			analyzeKnobFuction(mKeyFunctionInfo, data0, data1);
		} else if (mKeyFunctionInfo.isKeyDown() || mKeyFunctionInfo.isSteeringKeyLongDown()) {
			analyzePanelKeyFuction(mKeyFunctionInfo, data0);
		}
		baseInfolList.add(mKeyFunctionInfo);
		return baseInfolList;
	}
	
	private void analyzePanelKeyFuction(KeyFunctionInfo mKeyFunctionInfo, byte data0) {
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
		case 6:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_BACK);
			break;
		case 7://RADIO
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_COLLEC_RADIO);
			break;	
		case 9:
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
			break;	
		case 0X40:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_AUXIN);
			break;
		case 0X54:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		case 0X50:
		case 0X53:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_HOME);
			break;
		}
	}

	private void analyzeKnobFuction(KeyFunctionInfo mKeyFunctionInfo, byte data0, byte data1) {
		if (data1 != 0) {
			switch (data0) {
			case (byte) 0x17:
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_UP);
				// 步进值
				mKeyFunctionInfo.setStepValue(ByteUtil.convertByteToInt(data1));
				break;
			case (byte) 0x18:
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_DOWN);
				// 步进值
				mKeyFunctionInfo.setStepValue(ByteUtil.convertByteToInt(data1));
				break;
			}
		}
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
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
			break;
		case 4:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);
			break;
		case 5:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		case 6://语音 接电话
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_ANSWER_VOICE);
			break;
		case 7://静音  挂电话
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_HANGUP_MUTE);
			break;	
		}
	}

}
