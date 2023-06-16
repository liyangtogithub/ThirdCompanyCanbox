package com.landsem.canbox.comparse.simple;

import java.util.ArrayList;
import java.util.List;

import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CarLargeInfo;
import com.landsem.canbox.bean.CornerInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.pack.simple.DasAuto1Pack;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;

import android.view.KeyEvent;

/**
 * 欣朴软件_迈腾_昊锐_途观_高尔夫6_CC 串口通信协议v2.81.000
 * @author LQPDC
 *
 */
public final class DasAuto1Parse extends SimpleBaseParse {

	public DasAuto1Parse() {
		super((byte) 0xFF, (byte) 0x2e, (byte) 0xA5);
	}

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] byteArray) {
		byte comID = byteArray[COMID_XINPU];
		List<BaseInfo> infoList = new ArrayList<BaseInfo>();
		switch (comID) {
		case SLAVE_HOST_AIR_CONTROL:
			analyzeAirCondition(infoList, byteArray);
			break;
		case SLAVE_HOST_LIGHT_INFO:
			analyzeBackLight(infoList, byteArray);
			break;
		case SLAVE_HOST_SPEED_INFO:
			DasAuto1Pack.getInstance().askCarInfoOrder();
			analyzeSpeedInfo(infoList, byteArray);
			break;
		case SLAVE_HOST_BASE_INFO:
			analyzeDoor(infoList, byteArray);
			break;
		case ComID1.SLAVE_HOST_EPS_INFO:
			analyzeCorner(infoList, byteArray[4], byteArray[3]);
			break;
		case SLAVE_HOST_BACK_RADAR:
			analyzeRadar(infoList, byteArray, true);
			break;
		case SLAVE_HOST_FRONT_RADAR:
			analyzeRadar(infoList, byteArray, false);
			DasAuto1Pack.getInstance().checkEPS();
			break;
		case SLAVE_HOST_WHEEL_KEY:
			analyzeWheelKey(infoList, byteArray[3], byteArray[4]);
			break;
		case SLAVE_HOST_COM_INFO:
			analyzeHostInfo(infoList, byteArray);
			break;
		case SLAVE_HOST_BODY_INFO:
			analyzeBodyInfo(infoList, byteArray);
			break;
		}
		return infoList;
	}
	
	private void analyzeBodyInfo(List<BaseInfo> infoList, Byte[] byteArray) {
		byte orderByte = byteArray[Constant.DATA0_XINPU];
		if (orderByte==0x02) {
			byte high = 0;
			byte mid  = 0;
			byte low = 0;
			int data = 0;
			//发动机转速
			high = byteArray[Constant.DATA1_XINPU];
			low = byteArray[Constant.DATA0_XINPU];
			data = ByteUtil.HighLowByteToInt(high, low);
			mCarLargeInfo.setRotateSpeed(data);
			// 瞬时车速 最高位+最低位
//			high = byteArray[Constant.DATA3_XINPU];
//			low = byteArray[Constant.DATA4_XINPU];
//			data = ByteUtil.HighLowByteToInt(high, low)/100;
//			mCarLargeInfo.setInstantSpeed(data);
			// 电池电压
			high = byteArray[Constant.DATA5_XINPU];
			low = byteArray[Constant.DATA6_XINPU];
			data = ByteUtil.HighLowByteToInt(high, low);
			mCarLargeInfo.setVoltage( (data/100f) +"");
			// 车外温度
			high = byteArray[Constant.DATA7_XINPU];
			low = byteArray[Constant.DATA8_XINPU];
			data = ByteUtil.HighLowByteToInt(high, low);
			mAirConditionInfo.setOutdoorTemp(data / 10.0f);
			//行驶里程
			high = byteArray[Constant.DATA9_XINPU];
			mid = byteArray[Constant.DATA10_XINPU];
			low = byteArray[Constant.DATA11_XINPU];
			data = ByteUtil.HighMidLowByteToInt( high,mid,low );
			mCarLargeInfo.setMileage(data);
			//剩余油量
			data = ByteUtil.convertByteToInt(byteArray[Constant.DATA12_XINPU]);
			mCarLargeInfo.setSurplusOil(data);
		}
		infoList.add(mCarLargeInfo);
	}

	private void analyzeSpeedInfo(List<BaseInfo> infoList, Byte[] intackBytes) {
		// 瞬时车速 最高位+最低位
		byte instantHigh = intackBytes[Constant.DATA1_XINPU];
		byte instantLow = intackBytes[Constant.DATA0_XINPU];
		int instantSpeed = ByteUtil.HighLowByteToInt(instantHigh, instantLow)/16;
		mCarLargeInfo.setInstantSpeed(instantSpeed);
		infoList.add(mCarLargeInfo);
	}

	private void analyzeHostInfo(List<BaseInfo> infoList, Byte[] byteArray) {
		byte value = byteArray[3];
		int tempValue = ByteUtil.convertByteToInt(value);
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		switch (tempValue) {
		case 0xC0:
		case 0xC3:
			mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_MODE);
			break;
		case 0xC2:
			mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_COLLEC_RADIO);
			break;	
		}
		infoList.add(mKeyFunctionInfo);
	}

	private void analyzeWheelKey(List<BaseInfo> infoList, Byte keyCode, Byte keyStatus) {
		if (keyStatus == 0) {
			return;
		}
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		switch (keyCode) {
		case 0:
			mKeyFunctionInfo = null;
			break;
		case 1:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_UP);
			break;
		case 2:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_DOWN);
			break;
		case 3:
			mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_ANSWER_PREV);
			break;
		case 4:
			mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_HANGUP_NEXT);
			break;
		case 5:
			mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_ANSWER);
			break;
		case 6:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
			break;
		case 7:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		case 8:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOICE);
			break;
		default:
			break;
		}
		if (null != mKeyFunctionInfo)
			infoList.add(mKeyFunctionInfo);

	}

	private void analyzeRadar(List<BaseInfo> infoList, Byte[] byteArray, boolean isBack) {
		byte value = byteArray[3];
		int ll = (int) (value * 25.5f);
		value = byteArray[4];
		int ml = (int) (value * 25.5f);
		value = byteArray[5];
		int mr = (int) (value * 25.5f);
		value = byteArray[6];
		int rr = (int) (value * 25.5f);
		if (isBack) {
			mRadarInfo.setBackLeftValue(ll);
			mRadarInfo.setBackMidLeftValue(ml);
			mRadarInfo.setBackMidRightValue(mr);
			mRadarInfo.setBackRightValue(rr);
		} else {
			mRadarInfo.setFrontLeftValue(ll);
			mRadarInfo.setFrontMidLeftValue(ml);
			mRadarInfo.setFrontMidRightValue(mr);
			mRadarInfo.setFrontRightValue(rr);
		}
		infoList.add(mRadarInfo);
	}

	private void analyzeCorner(List<BaseInfo> infoList, byte dataH, byte dataL) {
		// 方向盘转角
		short dregress = (short) ((dataH << 8) + (dataL & 0xFF));
		short tempH = (short) (dataH << 8);
		short tempL = (short) (dataL & 0xFF);
		if (tempH>=0) {
			dregress = (short) (tempH + tempL);
		} else {
			dregress = (short) ~dregress;
			dregress = (short) (dregress + 1);
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
		infoList.add(mCornerInfo);
	}

	private void analyzeBackLight(List<BaseInfo> insfoList, Byte[] intackBytes) {
		// Data0为表示倒车档位灯光
		byte data0 = intackBytes[1];
		mCarBaseInfo.setILL(data0 == 0);
		insfoList.add(mCarBaseInfo);
	}

	private void analyzeDoor(List<BaseInfo> insfoList, Byte[] intackBytes) {
		byte data = intackBytes[4];
		byte value = ByteUtil.onCheckOutBitAtIndex(data, BIT0);
		mDoorInfo.setDriverDoor(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(data, BIT1);
		mDoorInfo.setPassengerDoor(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(data, BIT2);
		mDoorInfo.setLeftBackDoor(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(data, BIT3);
		mDoorInfo.setRightBackDoor(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(data, BIT4);
		mDoorInfo.setBackTrunk(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(data, BIT5);
		mDoorInfo.setEngineHood(value == ON);
		insfoList.add(mDoorInfo);
		data = intackBytes[3];
		value = ByteUtil.onCheckOutBitAtIndex(data, BIT0);
		mCarBaseInfo.setREV(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(data, BIT2);
		mCarBaseInfo.setILL(value == ON);
		insfoList.add(mCarBaseInfo);
		
		// LogManager.d(TAG, "isDriverDoor:"+mDoorInfo.isDriverDoor()+",
		// isPassengerDoor:"+mDoorInfo.isPassengerDoor()
		// +", isLeftBackDoor:"+mDoorInfo.isLeftBackDoor()+",
		// isRightBackDoor:"+mDoorInfo.isRightBackDoor());
	}

	private void analyzeAirCondition(List<BaseInfo> baseInfolList, Byte[] intackBytes) {
		// data0
		analyzeAirData0(intackBytes[3]);
		// data1
		analyzeAirData1(intackBytes[4]);
		// data2
		byte leftTemp = intackBytes[5];
		byte rightTemp = intackBytes[6];
		analyzeAirTemp(leftTemp, rightTemp);
		analyzeSeatTemp(intackBytes[7]);
		baseInfolList.add(mAirConditionInfo);
	}

	private void analyzeSeatTemp(Byte byte1) {
		byte grade = 0;
		byte value = ByteUtil.onCheckOutBitAtIndex(byte1, BIT0);
		grade += value * Math.pow(2, 0);
		value = ByteUtil.onCheckOutBitAtIndex(byte1, BIT1);
		grade += value * Math.pow(2, 1);
		mAirConditionInfo.setRightSeatHeatGrade(grade);
		grade = 0;
		value = ByteUtil.onCheckOutBitAtIndex(byte1, BIT4);
		grade += value * Math.pow(2, 0);
		value = ByteUtil.onCheckOutBitAtIndex(byte1, BIT5);
		grade += value * Math.pow(2, 1);
		mAirConditionInfo.setLeftSeatHeatGrade(grade);
		value = ByteUtil.onCheckOutBitAtIndex(byte1, BIT2);
		mAirConditionInfo.setAcMaxSwitch(value == ON);
	}

	private void analyzeAirTemp(byte lTempValue, byte rTempValue) {
		float temp =0;
		if (lTempValue == 0) {
			temp = Constant.AIR_LOW;
		} else if (lTempValue == 0X1f) {
			temp = Constant.AIR_HIGH;
		} else if (lTempValue>=1 && lTempValue<=0x11) {
			temp = (float) (18 + (lTempValue-1)*0.5);
		}
		mAirConditionInfo.setFrontLeftSeatSetTemp(temp);
		if (rTempValue == 0) {
			temp = Constant.AIR_LOW;
		} else if (rTempValue == 0X1f) {
			temp = Constant.AIR_HIGH;
		} else if (rTempValue>=1 && rTempValue<=0x11) {
			temp = (float) (18 + (rTempValue-1)*0.5);
		}
		mAirConditionInfo.setFrontRightSeatSetTemp(temp);
	}

	private void analyzeAirData1(byte mAirdata) {
		byte grade = 0;
		byte value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT0);
		grade += value;
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT1);
		grade += (value *2);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT2);
		grade += (value * 4);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT3);
		grade += (value * 8);
		mAirConditionInfo.setLeftWindGrade(grade);
		mAirConditionInfo.setRightWindGrade(grade);
		mAirConditionInfo.setWindGradeTotal((byte) 7);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT4);
		mAirConditionInfo.setShowAir(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT5);
		mAirConditionInfo.setLeftWindBlowFoot(value == ON);
		mAirConditionInfo.setRightWindBlowFoot(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT6);
		mAirConditionInfo.setLeftWindBlowBody(value == ON);
		mAirConditionInfo.setRightWindBlowBody(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT7);
		mAirConditionInfo.setLeftWindBlowHead(value == ON);
		mAirConditionInfo.setRightWindBlowHead(value == ON);
	}

	private void analyzeAirData0(byte mAirdata) {
		byte value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT0);
		mAirConditionInfo.setBackWindowDemist(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT1);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT2);
		mAirConditionInfo.setDualSwitch(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT3);
		mAirConditionInfo.setAutoSwitch1(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT4);
		mAirConditionInfo.setAutoSwitch2(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT5);
		mAirConditionInfo.setCircleOut(value != ON);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT6);
		mAirConditionInfo.setAcEnable(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT7);
		mAirConditionInfo.setSwitchAir(value == ON);
	}

}
