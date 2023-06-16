package com.landsem.canbox.comparse.simple;

import java.util.ArrayList;
import java.util.List;

import com.landsem.canbox.Constant;
import com.landsem.canbox.Constant.TOYOTID;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CarLargeInfo;
import com.landsem.canbox.bean.CornerInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.pack.simple.Toyot1Pack;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;

import android.view.KeyEvent;
import android.widget.TextView.BufferType;

/**
 * 欣朴软件_丰田系列串口通讯协议V1.22.000
 * @author LQPDC
 *
 */
public final class TOYOT1Parse extends SimpleBaseParse implements TOYOTID{

	public TOYOT1Parse() {
		super((byte) 0xFF, (byte) 0x2e, (byte) 0xA5);
	}
	
	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		byte comID = intackBytes[COMID_XINPU];
		List<BaseInfo> infoList = new ArrayList<BaseInfo>();
		
		switch (comID) {
		case S_H_WHEEL_KEY:
			analyzeWheelKey(infoList, intackBytes[3], intackBytes[4]);
			break;
		case S_H_OIL:
			analyzeOil(infoList, intackBytes);
			break;
		case S_H_AIRC_INFO:
			Toyot1Pack.getInstance().askCarInfoOrder2();
			analyzeAirCondition(infoList, intackBytes);
			break;
		case S_H_BASE_INFO:
			Toyot1Pack.getInstance().askCarInfoOrder1();
			analyzeDoor(infoList, intackBytes);
			break;
		case S_H_BACK_RADAR:
			analyzeRadar(infoList, intackBytes, true);
			break;
		case S_H_FRONT_RADAR:
			analyzeRadar(infoList, intackBytes, false);
			break;
		case S_H_EPS_INFO:
			analyzeCorner(infoList, intackBytes[4], intackBytes[3]);
			break;
		case S_H_CAR_INFO:
			analyzeCarInfo(infoList, intackBytes);
			break;
//		case S_H_SYSTEM_INFO:
//			analyzeSystemInfo(infoList, intackBytes);
//			break;
		default:
			break;
		}
		
		return infoList;
	}
	
	private void analyzeOil(List<BaseInfo> infoList, Byte[] intackBytes) {
		byte High = 0;
		byte Low = 0;
		byte byteUnit = intackBytes[Constant.DATA0_XINPU];
		String oilUnit = "L/100km";
		if (byteUnit==0) {
			oilUnit = "MPG";
		}else if (byteUnit==1) {
			oilUnit = "km/L";
		}else if (byteUnit==2) {
			oilUnit = "L/100km";
		}
		mCarLargeInfo.setOilUnit(oilUnit);
		High = intackBytes[Constant.DATA1_XINPU];
		Low = intackBytes[Constant.DATA2_XINPU];
		float averageFuel = ByteUtil.HighLowByteToInt(High,Low)/10f;
		mCarLargeInfo.setAverageFuel(averageFuel);
		
		infoList.add(mCarLargeInfo);
	}

	private void analyzeCarInfo(List<BaseInfo> infoList, Byte[] byteArray) {
		byte orderByte = byteArray[Constant.DATA0_XINPU];
		if (orderByte==0x02) {
			byte high = 0;
			byte mid  = 0;
			byte low = 0;
			int data = 0;
			//行驶里程
			high = byteArray[Constant.DATA1_XINPU];
			mid = byteArray[Constant.DATA2_XINPU];
			low = byteArray[Constant.DATA3_XINPU];
			data = ByteUtil.HighMidLowByteToInt( high,mid,low );
			mCarLargeInfo.setMileage(data);
			// 续航里程 
			high = byteArray[Constant.DATA4_XINPU];
			low = byteArray[Constant.DATA5_XINPU];
			data = ByteUtil.HighLowByteToInt(high,low);
			mCarLargeInfo.setEnduranceMileage(data);
			// 瞬时车速 最高位+最低位
			high = byteArray[Constant.DATA12_XINPU];
			low = byteArray[Constant.DATA13_XINPU];
			data = ByteUtil.HighLowByteToInt(high, low)/100;
			mCarLargeInfo.setInstantSpeed(data);
		}else if (orderByte==0x03) {
			byte highByte = 0;
			byte lowByte  = 0;
			int dataInt = 0;
			//发动机转速
			highByte = byteArray[Constant.DATA1_XINPU];
			lowByte = byteArray[Constant.DATA2_XINPU];
			dataInt = ByteUtil.HighLowByteToInt(highByte, lowByte);
			mCarLargeInfo.setRotateSpeed(dataInt);
			// 车外温度
			dataInt = byteArray[Constant.DATA7_XINPU];
			mAirConditionInfo.setOutdoorTemp(dataInt);
		}else if (orderByte==0x01) {
			analyzeLight(infoList, byteArray);
		}
		infoList.add(mCarLargeInfo);
		infoList.add(mAirConditionInfo);
	}
	
	private List<BaseInfo> analyzeLight(List<BaseInfo> insfoList, Byte[] intackBytes) {
		//背光，远光
		byte data = intackBytes[Constant.DATA4_XINPU];
		byte status = ByteUtil.onCheckOutBitAtIndex(data, BIT6);
		mCarBaseInfo.setILL(status==ON);
		data = intackBytes[Constant.DATA5_XINPU];
		status = ByteUtil.onCheckOutBitAtIndex(data, BIT7);
		mCarBaseInfo.setREV(status==ON);
		insfoList.add(mCarBaseInfo);
		return insfoList;
	}
	private void analyzeSystemInfo(List<BaseInfo> infoList, Byte[] intackBytes) {
		byte value = intackBytes[3];
		byte status = ByteUtil.onCheckOutBitAtIndex(value, BIT7);
		
	}

	private void analyzeWheelKey(List<BaseInfo> infoList, Byte keyCode, Byte keyStatus) {
		if (keyStatus==0) return;
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		int code = ByteUtil.convertByteToInt(keyCode);
		switch (code) {
		case 0:
			mKeyFunctionInfo = null;
			break;
		case 0x01:
		case 0x81:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_UP);
			break;
		case 0x02:
		case 0x82:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_DOWN);
			break;
		case 0x03:
		case 0x13:
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);
			break;
		case 0x04:
		case 0x14:
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
			break;
		case 0x09://PICKUP
        	mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_ANSWER);
			break;
		case 0x0A://HANGUP
        	mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_HANGUP);
			break;
//		case 0x05:
//        	mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_ANSWER);
//			break;
//		case 0x06:
//        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
//			break;
		case 0x15:
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_BACK);
			break;
		case 0x07:
		case 0x88:
        	mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_MODE);
			break;
		case 0x87:
        	mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_POWER);
			break;
		case 8:
        	mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOICE);
			break;
		default:
			mKeyFunctionInfo = null;
			break;
		}
		if (null!=mKeyFunctionInfo) infoList.add(mKeyFunctionInfo);
		
	}

	private void analyzeRadar(List<BaseInfo> infoList, Byte[] byteArray, boolean isBack) {
		byte value = byteArray[3];
		int ll =  (int) (value==0 ? 255 : (value-1)*85);
		value = byteArray[4];
		int ml = (int) (value==0 ? 255 : (value-1)*85);
		value = byteArray[5];
		int mr = (int) (value==0 ? 255 : (value-1)*85);
		value = byteArray[6];
		int rr = (int) (value==0 ? 255 : (value-1)*85);
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
		short dregress = (short) (((dataH & 0x07) << 8) + (dataL & 0xFF));
		int leftCor = PROTOCAL_INVALID_VALUE;
		int rightCor = PROTOCAL_INVALID_VALUE;
		if (dregress==0) {
			leftCor = rightCor =0;
		} else {
			byte symbolBit = ByteUtil.onCheckOutBitAtIndex(dataH, BIT3);
			if (symbolBit==ON) {
				dregress = (short) ~dregress;
				dregress = (short) (dregress + 1);
				dregress = (short) (dregress & 0x07FF);
				if (dregress>550) dregress = 550;
				rightCor = dregress;
			} else {
				if (dregress>550) dregress = 550;
				leftCor = -dregress;
			}
		}
		mCornerInfo.setLeftCorner(leftCor);
		mCornerInfo.setRightCorner(rightCor);
		infoList.add(mCornerInfo);
	}
	
	private void analyzeDoor(List<BaseInfo> insfoList, Byte[] byteArray) {
		byte data = byteArray[4];
		byte value = ByteUtil.onCheckOutBitAtIndex(data, BIT7);
		mDoorInfo.setEngineHood(value==ON);
		data = byteArray[3];
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
//		analyzeSeatTemp(intackBytes[8]);
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

	private void analyzeAirTemp(byte lTempValue, byte rTempValue) {
		float temp =0;
		if (lTempValue == 0) {
			temp = Constant.AIR_LOW;
		} else if (lTempValue == 0X1f) {
			temp = Constant.AIR_HIGH;
		} else if (lTempValue>=1 && lTempValue<=0x1d) {
			temp = (float) (18 + (lTempValue-1)*0.5);
		}else {
			temp = getTemp(lTempValue);
		}
		mAirConditionInfo.setFrontLeftSeatSetTemp(temp);
		if (rTempValue == 0) {
			temp = Constant.AIR_LOW;
		} else if (rTempValue == 0X1f) {
			temp = Constant.AIR_HIGH;
		} else if (rTempValue>=1 && rTempValue<=0x1d) {
			temp = (float) (18 + (rTempValue-1)*0.5);
		}else {
			temp = getTemp(rTempValue);
		}
		mAirConditionInfo.setFrontRightSeatSetTemp(temp);
	}
	
	private float getTemp(byte tempValue) {
		float temp =0;
		switch (tempValue) {
		case 0X20:
			temp = 16;
			break;
		case 0X21:
			temp = (float) 16.5;
			break;
		case 0X22:
			temp = 17;
			break;
		case 0X23:
			temp = (float) 17.5;
			break;
		}
		return temp;
	}

	private void analyzeAirData1(byte mAirdata) {
		byte grade = 0;
		//bit0-bit3表示0-7级量指示
		byte value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT0);
		grade += value;
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT1);
		grade += (value << 1);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT2);
		grade += (value << 2);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT3);
		grade += (value << 3);
		LogManager.d(TAG, "Wind grade: "+grade);
		mAirConditionInfo.setLeftWindGrade(grade);
		mAirConditionInfo.setRightWindGrade(grade);
		mAirConditionInfo.setWindGradeTotal((byte) 7);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT4);
		mAirConditionInfo.setShowAir(value==ON);
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
