package com.landsem.canbox.comparse.simple;

import java.util.ArrayList;
import java.util.List;

import com.landsem.canbox.Constant;
import com.landsem.canbox.Constant.SimpleDasAutoID;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CarLargeInfo;
import com.landsem.canbox.bean.CornerInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.RadarInfo;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;

import android.view.KeyEvent;

/**
 * 欣朴软件_大众高尔夫7串口通讯协议V1.27.000
 * @author LQPDC
 * MQB
 */
public final class DasAuto2Parse extends SimpleBaseParse {

	public DasAuto2Parse() {
		super((byte) 0xFF, (byte) 0x2e, (byte) 0xA5);
	}
	
	
	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		byte comID = intackBytes[COMID_XINPU];
		List<BaseInfo> infoList = new ArrayList<BaseInfo>();
		switch (comID) {
		case SLAVE_HOST_AIR_CONTROL:
			analyzeAirCondition(infoList, intackBytes);
			break;
		case SLAVE_HOST_BASE_INFO:
			analyzeDoor(infoList, intackBytes);
			break;
		case ComID2.SLAVE_HOST_EPS2_INFO:
			analyzeCorner(infoList, intackBytes[4], intackBytes[3]);
			break;
		case SLAVE_HOST_BACK_RADAR:
			analyzeRadar(infoList, intackBytes, true);
			break;
		case SLAVE_HOST_FRONT_RADAR:
			analyzeRadar(infoList, intackBytes, false);
			break;
		case SLAVE_HOST_WHEEL_KEY:
			analyzeWheelKey(infoList, intackBytes[3], intackBytes[4]);
			break;
		case SLAVE_HOST_SPEED_INFO:
			analyzeSpeedInfo(infoList, intackBytes);
			break;
		case SLAVE_HOST_WHEEL_ORDER:
			analyzeWheelOrder(infoList, intackBytes);
			break;
		case SLAVE_DRIVE_INFO:
			analyzeDriveInfo(infoList, intackBytes);
			break;
		}
		return infoList;
	}
	
	private void analyzeDriveInfo(List<BaseInfo> infoList, Byte[] intackBytes) {
		byte orderByte = intackBytes[Constant.DATA0_XINPU];
		byte unitByte = intackBytes[Constant.DATA1_XINPU];
		byte High = 0;
		byte Low = 0;
		switch (orderByte) {
		//续航距离
		case 0x10:
			mCarLargeInfo.setDistanceUnit(unitByte==0?"km":"mile");
			High = intackBytes[Constant.DATA3_XINPU];
			Low = intackBytes[Constant.DATA2_XINPU];
			int enduranceMileage = ByteUtil.HighLowByteToInt(High, Low);
			mCarLargeInfo.setEnduranceMileage(enduranceMileage);
			break;
		//总里程
        case 0x22:
        	mCarLargeInfo.setDistanceUnit(unitByte==0?"km":"mile");
        	byte low =   intackBytes[DATA2_XINPU];
    		byte mid1 =  intackBytes[DATA3_XINPU];
    		byte mid2 =  intackBytes[DATA4_XINPU];
    		byte high =  intackBytes[DATA5_XINPU];
    		int mileage = ByteUtil.HighMid2LowByteToInt( high,mid2,mid1,low )/10;
    		mCarLargeInfo.setMileage(mileage);
			break;
		//平均油耗
        case 0x30:
    		initOilUnit(unitByte);
    		High = intackBytes[Constant.DATA3_XINPU];
    		Low = intackBytes[Constant.DATA2_XINPU];
    		float averageFuel = ByteUtil.HighLowByteToInt(High,Low)/10f;
    		mCarLargeInfo.setAverageFuel(averageFuel);
			break;
		//瞬时油耗
        case 0x61:
        	initOilUnit(unitByte);
        	High = intackBytes[Constant.DATA3_XINPU];
    		Low = intackBytes[Constant.DATA2_XINPU];
    		float instantFuel = ByteUtil.HighLowByteToInt(High,Low)/10f;
    		mCarLargeInfo.setInstantFuel(instantFuel+ "");
			break;
		}
		infoList.add(mCarLargeInfo);
	}

	private void initOilUnit(byte unitByte) {
		byte byte0 = ByteUtil.onCheckOutBitAtIndex(unitByte,Constant.BIT0);
    	byte byte1 = ByteUtil.onCheckOutBitAtIndex(unitByte,Constant.BIT1);
    	byte byteUnit = (byte) (byte0+byte1*2);
    	String oilUnit = "L/100km";
		if (byteUnit==0) {
			oilUnit = "L/100km";
		}else if (byteUnit==1) {
			oilUnit = "km/L";
		}else if (byteUnit==2) {
			oilUnit = "mpg(UK)";
		}else if (byteUnit==3) {
			oilUnit = "mpg(US)";
		}
		mCarLargeInfo.setOilUnit(oilUnit);
	}


	private void analyzeSpeedInfo(List<BaseInfo> infoList, Byte[] intackBytes) {
		// 瞬时车速 最高位+最低位
		byte instantHigh = intackBytes[Constant.DATA1_XINPU];
		byte instantLow = intackBytes[Constant.DATA0_XINPU];
		int instantSpeed = ByteUtil.HighLowByteToInt(instantHigh, instantLow)/16;
		mCarLargeInfo.setInstantSpeed(instantSpeed);
		// 速度单位
		byte unitData = intackBytes[Constant.DATA2_XINPU];
		byte speedUnitByte = ByteUtil.onCheckOutBitAtIndex(unitData,Constant.BIT0);
		String speedUnit = "km/h";
		if (speedUnitByte == 0) {
			speedUnit = "km/h";
		} else {
			speedUnit = "mph";
		}
		mCarLargeInfo.setSpeedUnit(speedUnit);
		infoList.add(mCarLargeInfo);
	}

	private void analyzeWheelOrder(List<BaseInfo> infoList, Byte[] intackBytes) {
		
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		byte keyCode = intackBytes[3];
		switch (keyCode) {
		case 0x02:
        	mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_HANGUP_NEXT);
			break;
		case 0x01:
        	mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_ANSWER_PREV);
			break;
		case 0x11:
        	mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_ANSWER);
			break;
		case 0x12:
        	mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_HANGUP);
			break;
		case 0x16:
		case 0x17:
        	mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_VOICE);
			break;
		default:
			mKeyFunctionInfo = null;
			break;
		}
		if (null!=mKeyFunctionInfo) infoList.add(mKeyFunctionInfo);
		
	
	}

	private void analyzeWheelKey(List<BaseInfo> infoList, Byte keyCode, Byte keyStatus) {
		if (keyStatus==0) {
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
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);
			break;
		case 4:
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
			break;
		case 5:
        	mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_ANSWER);
			break;
		case 6:
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
			break;
		case 7:
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_SEARCH);
			break;
		case 8:
        	mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOICE);
			break;
		default:
			break;
		}
		if (null!=mKeyFunctionInfo) infoList.add(mKeyFunctionInfo);
		
	}

	private void analyzeRadar(List<BaseInfo> infoList, Byte[] byteArray, boolean isBack) {
		byte value = 0;
		float baseValue = 0;
		int ll = 0;
		int ml = 0;
		int mr = 0;
		int rr = 0;
		if (isBack) {
			value = byteArray[3];
			baseValue = ByteUtil.convertByteToInt(value);
			ll = (int) (baseValue*4.25f);
			value = byteArray[4];
			baseValue = ByteUtil.convertByteToInt(value);
			ml = (int) (baseValue*1.55f);
			value = byteArray[5];
			baseValue = ByteUtil.convertByteToInt(value);
			mr = (int) (baseValue*1.55f);
			value = byteArray[6];
			baseValue = ByteUtil.convertByteToInt(value);
			rr = (int) (baseValue*4.25f);
		} else {
			value = byteArray[3];
			baseValue = ByteUtil.convertByteToInt(value);
			ll = (int) (baseValue*4.25f);
			value = byteArray[4];
			baseValue = ByteUtil.convertByteToInt(value);
			ml = (int) (baseValue*2.13f);
			value = byteArray[5];
			baseValue = ByteUtil.convertByteToInt(value);
			mr = (int) (baseValue*2.13f);
			value = byteArray[6];
			baseValue = ByteUtil.convertByteToInt(value);
			rr = (int) (baseValue*4.25f);
		}

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
			rightCor = dregress;
		} else if (dregress < 0) {
			leftCor = dregress;
		} else {
			rightCor = leftCor = dregress;
		}
		mCornerInfo.setLeftCorner(leftCor);
		mCornerInfo.setRightCorner(rightCor);
		infoList.add(mCornerInfo);
	}
	
	private void analyzeDoor(List<BaseInfo> insfoList, Byte[] byteArray) {
		byte data = byteArray[3];
		byte value = ByteUtil.onCheckOutBitAtIndex(data, BIT0);
		if (ON==value) {
			value = ByteUtil.onCheckOutBitAtIndex(data, BIT2);
			mDoorInfo.setEngineHood(value==ON);
			value = ByteUtil.onCheckOutBitAtIndex(data, BIT3);
			mDoorInfo.setBackTrunk(value==ON);
			value = ByteUtil.onCheckOutBitAtIndex(data, BIT4);
			mDoorInfo.setLeftBackDoor(value==ON);
			value = ByteUtil.onCheckOutBitAtIndex(data, BIT5);
			mDoorInfo.setRightBackDoor(value==ON);
			value = ByteUtil.onCheckOutBitAtIndex(data, BIT6);
			mDoorInfo.setDriverDoor(value==ON);
			value = ByteUtil.onCheckOutBitAtIndex(data, BIT7);
			mDoorInfo.setPassengerDoor(value==ON);
			insfoList.add(mDoorInfo);
		}
		data = byteArray[4];
		value = ByteUtil.onCheckOutBitAtIndex(data, BIT0);
		mCarBaseInfo.setREV(value==ON);
		value = ByteUtil.onCheckOutBitAtIndex(data, BIT2);
		mCarBaseInfo.setILL(value==ON);
		insfoList.add(mCarBaseInfo);
//		LogManager.d(TAG, "isDriverDoor:"+mDoorInfo.isDriverDoor()+", isPassengerDoor:"+mDoorInfo.isPassengerDoor()
//		+", isLeftBackDoor:"+mDoorInfo.isLeftBackDoor()+", isRightBackDoor:"+mDoorInfo.isRightBackDoor());
	}
	
	private List<BaseInfo> analyzeAirCondition(List<BaseInfo> baseInfolList, Byte[] intackBytes) {
		// data0
		analyzeAirData0(intackBytes[3]);
		// data1
		analyzeAirData1(intackBytes[4]);
		// data2
		byte leftTemp = intackBytes[5];
		byte rightTemp = intackBytes[6];
		analyzeAirTemp(leftTemp, rightTemp);
		analyzeData4(intackBytes[7]);
		analyzeSeatTemp(intackBytes[8]);
		baseInfolList.add(mAirConditionInfo);
		return baseInfolList;
	}
	
	private void analyzeData4(Byte byte1) {	
		byte value = ByteUtil.onCheckOutBitAtIndex(byte1, BIT6);
		mAirConditionInfo.setBackWindowDemist(value==ON);
		value = ByteUtil.onCheckOutBitAtIndex(byte1, BIT7);
		mAirConditionInfo.setFrontWindowDemist(value==ON);
		value = ByteUtil.onCheckOutBitAtIndex(byte1, BIT3);
		mAirConditionInfo.setAcMaxSwitch(value==ON);	
	}

	private void analyzeSeatTemp(Byte byte1) {
		byte grade = 0;
		byte value = ByteUtil.onCheckOutBitAtIndex(byte1, BIT0);
		grade += value;
		value = ByteUtil.onCheckOutBitAtIndex(byte1, BIT1);
		grade += (value << 1);
		value = ByteUtil.onCheckOutBitAtIndex(byte1, BIT2);
		grade += (value << 2);
		mAirConditionInfo.setRightSeatHeatGrade(grade);
		LogManager.d(TAG, "right seat heat "+grade);
		grade = 0;
		value = ByteUtil.onCheckOutBitAtIndex(byte1, BIT4);
		grade += value;
		value = ByteUtil.onCheckOutBitAtIndex(byte1, BIT5);
		grade += (value << 1);
		value = ByteUtil.onCheckOutBitAtIndex(byte1, BIT6);
		grade += (value << 2);
		mAirConditionInfo.setLeftSeatHeatGrade(grade);
		LogManager.d(TAG, "left seat heat "+grade);
	}

	private void analyzeAirTemp(byte lTempValue, byte rTempValue) {
		float temp =0;
		if (lTempValue == 0) {
			temp = Constant.AIR_LOW;
		} else if (lTempValue == 0X1f) {
			temp = Constant.AIR_HIGH;
		} else if (lTempValue>=1 && lTempValue<=0x1C) {
			temp = (float) (16 + (lTempValue-1)*0.5);
		}
		mAirConditionInfo.setFrontLeftSeatSetTemp(temp);
		if (rTempValue == 0) {
			temp = Constant.AIR_LOW;
		} else if (rTempValue == 0X1f) {
			temp = Constant.AIR_HIGH;
		} else if (rTempValue>=1 && rTempValue<=0x1C) {
			temp = (float) (16 + (rTempValue-1)*0.5);
		}
		mAirConditionInfo.setFrontRightSeatSetTemp(temp);
	}
	
	private void analyzeAirData1(byte mAirdata) {
		byte grade = 0;
		//bit0-bit3表示0-7级量指示
		byte value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT0);
		grade += value * Math.pow(2, BIT0);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT1);
		grade += value * Math.pow(2, BIT1);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT2);
		grade += value * Math.pow(2, BIT2);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT3);
		grade += value * Math.pow(2, BIT3);
		LogManager.d(TAG, "Wind grade: "+grade);
		mAirConditionInfo.setLeftWindGrade(grade);
		mAirConditionInfo.setRightWindGrade(grade);
		mAirConditionInfo.setWindGradeTotal((byte) 7);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT4);
		//向下吹风开关
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT5);
		mAirConditionInfo.setLeftWindBlowFoot(value==ON);
		mAirConditionInfo.setRightWindBlowFoot(value==ON);
		//平行吹风开关
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT6);
		mAirConditionInfo.setLeftWindBlowBody(value==ON);
		mAirConditionInfo.setRightWindBlowBody(value==ON);
		//向上吹风开关
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT7);
		mAirConditionInfo.setLeftWindBlowHead(value==ON);
		mAirConditionInfo.setRightWindBlowHead(value==ON);
	}
	
	private void analyzeAirData0(byte byteData) {
		//REAR开关
		byte value = ByteUtil.onCheckOutBitAtIndex(byteData, BIT0);
		mAirConditionInfo.setRearOpen(value==ON);
		value = ByteUtil.onCheckOutBitAtIndex(byteData, BIT1);
		//DAUL开关
		value = ByteUtil.onCheckOutBitAtIndex(byteData, BIT2);
		mAirConditionInfo.setDualSwitch(value==ON);
		//AUTO开关
		value = ByteUtil.onCheckOutBitAtIndex(byteData, BIT3);
		mAirConditionInfo.setAutoSwitch1(value==ON);
		value = ByteUtil.onCheckOutBitAtIndex(byteData, BIT4);
		mAirConditionInfo.setAutoSwitch2(value==ON);
		//内外循环
		value = ByteUtil.onCheckOutBitAtIndex(byteData, BIT5);
		mAirConditionInfo.setCircleOut(value!=ON);
		//A/C制冷开关
		value = ByteUtil.onCheckOutBitAtIndex(byteData, BIT6);
		mAirConditionInfo.setAcEnable(value==ON);;
		//空调状态开关
		value = ByteUtil.onCheckOutBitAtIndex(byteData, BIT7);
		mAirConditionInfo.setSwitchAir(value==ON);
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


}
