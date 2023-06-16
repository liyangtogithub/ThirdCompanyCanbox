package com.landsem.canbox.comparse.simple;

import java.util.ArrayList;
import java.util.List;

import android.view.KeyEvent;

import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CarLargeInfo;
import com.landsem.canbox.bean.CornerInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.PeripheralInfo;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;

/**
 *欣朴软件_本田DA系列串口通讯协议V1.11.003
 */
public class XHondaParse  extends SimpleBaseParse {
	
	public XHondaParse() {
		super((byte) 0xFF, (byte) 0x2e, (byte) 0xA5);
	}
	/***优先右视按钮*/
	boolean isFirstRightLightClose = false;
	PeripheralInfo mPeripheralInfo = new PeripheralInfo();
	
	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		byte comID = intackBytes[COMID_XINPU];
		List<BaseInfo> infoList = new ArrayList<BaseInfo>();
		switch (comID) {
		case SLAVE_HOST_WHEEL_KEY:
			analyzeSteerKey(infoList, intackBytes);
			break;
		case SLAVE_HOST_AIR_CONTROL:
			analyzeAirCondition(infoList, intackBytes);
			break;
		case SLAVE_HOST_BASE_INFO:
			analyzeDoor(infoList, intackBytes);
			break;
		case 0x29://方向盘转角
			analyzeCorner(infoList, intackBytes[4], intackBytes[3]);
			break;
		case 0x22://后雷达
			analyzeRadar(infoList, intackBytes, true);
			break;
		case 0x23://前雷达
			analyzeRadar(infoList, intackBytes, false);
			break;
		case (byte) 0xd1://右视摄像头
			analyzeRightCamera(infoList, intackBytes);
			break;
		case (byte) 0x33://油耗里程
			analyzeOilMileage(infoList, intackBytes);
			break;
		}
		return infoList;
	}
	
	private void analyzeOilMileage(List<BaseInfo> infoList, Byte[] intackBytes) {
		byte high = 0;
		byte low = 0;
		int data = 0;
		high = intackBytes[Constant.DATA2_XINPU];
		low = intackBytes[Constant.DATA3_XINPU];
		float averageFuel = ByteUtil.HighLowByteToInt(high,low)/10f;
		mCarLargeInfo.setAverageFuel(averageFuel);
		// 续航里程 
		high = intackBytes[Constant.DATA11_XINPU];
		low = intackBytes[Constant.DATA12_XINPU];
		data = ByteUtil.HighLowByteToInt(high,low);
		mCarLargeInfo.setEnduranceMileage(data);
		// 里程单位
		byte unitByte = intackBytes[Constant.DATA13_XINPU];
		// 油耗单位
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(unitByte, Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(unitByte, Constant.BIT2);
		byte oilUnitByte = (byte) (bit3 * 2 + bit2);
		String oilUnit = "MPG";
		if (oilUnitByte == 1) {
			oilUnit = "km/L";
		} else if (oilUnitByte == 2) {
			oilUnit = "L/100km";
		}
		mCarLargeInfo.setOilUnit(oilUnit);
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(unitByte, Constant.BIT7);
		String distanceUnit = "km";
		if (bit7 == 0) {
			distanceUnit = "km";
		} else {
			distanceUnit = "mile";
		}
		mCarLargeInfo.setDistanceUnit(distanceUnit);
		infoList.add(mCarLargeInfo);
	}

	private void analyzeRightCamera(List<BaseInfo> infoList,Byte[] intackBytes) {
	
		byte data = intackBytes[Constant.DATA1_XINPU];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT7);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT6);
		if (bit7==1) {
			isFirstRightLightClose = true;
			mPeripheralInfo.setCameraOnRight(true);
		}else {
			if (isFirstRightLightClose) {
				isFirstRightLightClose = false;
				mPeripheralInfo.setCameraOnRight(false);
			}else if (bit6==1) {
				mPeripheralInfo.setCameraOnRight(!mPeripheralInfo.isCameraOnRight());
			}
		}
		infoList.add(mPeripheralInfo);
	}

	private void analyzeRadar(List<BaseInfo> infoList, Byte[] byteArray, boolean isBack) {
		byte value = byteArray[3];
		int ll = getRadarDistanse(value);
		value = byteArray[4];
		int ml = getRadarDistanse(value);
		value = byteArray[5];
		int mr = getRadarDistanse(value);
		value = byteArray[6];
		int rr = getRadarDistanse(value);
		
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
	
	private int getRadarDistanse(Byte byte1) {
		int distance = 255;
		switch (byte1) {
		case 0x01:
			distance = 0;
			break;
		case 0x00:
		case 0x04:
			distance = 255;
			break;
		case 0x02:
			distance = 85;
			break;
		case 0x03:
			distance = 170;
			break;
		}
		return distance;
	}
	
	private void analyzeCorner(List<BaseInfo> infoList, byte dataH, byte dataL) {
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
	
	
	private void analyzeDoor(List<BaseInfo> insfoList, Byte[] intackBytes) {
		byte data = intackBytes[3];
		byte value = ByteUtil.onCheckOutBitAtIndex(data, BIT2);
		mDoorInfo.setEngineHood(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(data, BIT3);
		mDoorInfo.setBackTrunk(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(data, BIT4);
		mDoorInfo.setLeftBackDoor(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(data, BIT5);
		mDoorInfo.setRightBackDoor(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(data, BIT6);
		mDoorInfo.setDriverDoor(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(data, BIT7);
		mDoorInfo.setPassengerDoor(value == ON);
		insfoList.add(mDoorInfo);
		data = intackBytes[4];
		value = ByteUtil.onCheckOutBitAtIndex(data, BIT0);
		mCarBaseInfo.setREV(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(data, BIT1);
		mCarBaseInfo.setHandBrakePulled(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(data, BIT2);
		mCarBaseInfo.setILL(value == ON);
		insfoList.add(mCarBaseInfo);
		// LogManager.d(TAG, "isDriverDoor:"+mDoorInfo.isDriverDoor()+",
		// isPassengerDoor:"+mDoorInfo.isPassengerDoor()
		// +", isLeftBackDoor:"+mDoorInfo.isLeftBackDoor()+",
		// isRightBackDoor:"+mDoorInfo.isRightBackDoor());
	}
	
	private void analyzeSteerKey(List<BaseInfo> insfoList,Byte[] intackBytes) {
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		
		// data1 按键状态 
		byte data1 = intackBytes[Constant.DATA1_XINPU];
		if (data1 == 1) {
			mKeyFunctionInfo.setKeyDown(true);
		}else if (data1 ==2) {
			mKeyFunctionInfo.setSteeringKeyLongDown(true);
		}
		
		int data0 = ByteUtil.convertByteToInt(intackBytes[Constant.DATA0_XINPU]);
		 if (mKeyFunctionInfo.isKeyDown()||mKeyFunctionInfo.isSteeringKeyLongDown()) {
			analyzeKeyFuction(mKeyFunctionInfo, data0,insfoList);
		}
		insfoList.add(mKeyFunctionInfo);
	}
	

	private void analyzeKeyFuction(KeyFunctionInfo mKeyFunctionInfo, int data0, List<BaseInfo> insfoList) {
		switch (data0) {
		case 1:
		case 0x81:
		case 0x20:	
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_UP);
			break;
		case 2:
		case 0x82:
		case 0x21:	
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_DOWN);
			break;
		case 3:
		case 0x22:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);
			break;
		case 4:
		case 0x23:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
			break;
		case 7:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		case 8:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOICE);
			break;
		case 9:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_ANSWER);
			break;
		case 0x0a:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_HANGUP);
			break;
		case 0x17:
		case 0x30:
		case 0x86:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
			break;
			//tune scan+
		case 0x24:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_SCAN_UP);
			break;
			//tune scan-
		case 0x25:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_SCAN_DOWN);
			break;
			//预存台切换+
		case 0x26:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_CHANNEL_UP);
			break;
			//预存台切换-
		case 0x27:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_CHANNEL_DOWN);
			break;
			//右视
		case 0x29:
			steerKeyRightLight(insfoList);
			break;	
			
		}
	}
	
	private void steerKeyRightLight(List<BaseInfo> insfoList) {
		if (!isFirstRightLightClose) {
			mPeripheralInfo.setCameraOnRight(!mPeripheralInfo.isCameraOnRight());
		}
		insfoList.add(mPeripheralInfo);
	}

	private void analyzeAirCondition(List<BaseInfo> baseInfolList, Byte[] intackBytes) {
		// data0
		analyzeAirData0(intackBytes[3]);
		// data1
		analyzeAirData1(intackBytes[4]);
		// data2 左边座椅温度设数值
		byte mAirdata2 = intackBytes[Constant.DATA2_XINPU];
		float frontLeftSeatSetTemp = analyzeSeatHeatGrade(mAirdata2);
		mAirConditionInfo.setFrontLeftSeatSetTemp(frontLeftSeatSetTemp);
		// data3 右边座椅温度设数值
		byte mAirdata3 = intackBytes[Constant.DATA3_XINPU];
		float frontRightSeatSetTemp = analyzeSeatHeatGrade(mAirdata3);
		mAirConditionInfo.setFrontRightSeatSetTemp(frontRightSeatSetTemp);
		//data4
		analyzeAirData4(intackBytes[7]);
		//data5 步距
		//data6 后排设定温度
		mAirConditionInfo.setBackTempSet(intackBytes[9]);
		//data7后排空调状态
		mAirConditionInfo.setBackWindMode(intackBytes[10]);
		//Data8后排空调状态
//		mAirConditionInfo.setBackWindMode(backWindMode);
		baseInfolList.add(mAirConditionInfo);
	}
	
	private float analyzeSeatHeatGrade(byte mAirdata) {
		float seatHeatGrade = ByteUtil.convertByteToInt(mAirdata);
		if (seatHeatGrade == 0) {
			seatHeatGrade = Constant.AIR_LOW;
		} else if (seatHeatGrade == 0xff) {
			seatHeatGrade = Constant.AIR_HIGH;
		} else {
			seatHeatGrade = (float) (seatHeatGrade/2);
		}
		return seatHeatGrade;
	}
	
	private void analyzeAirData4(byte mAirdata){
		byte value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT0);
		mAirConditionInfo.setCentigrade(value == ON);
//		value = ByteUtil.onCheckOutBitAtIndex(byte7, BIT1);
//		value = ByteUtil.onCheckOutBitAtIndex(byte7, BIT2);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT6);
		mAirConditionInfo.setClimateDown(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT7);
		mAirConditionInfo.setFrontWindowDemist(value == ON);
//		analyzeSeatTemp(intackBytes[7]);
	}

	private void analyzeAirData0(byte mAirdata) {
		byte value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT0);
		mAirConditionInfo.setRearOpen(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT2);
		mAirConditionInfo.setDualSwitch(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT3);
		mAirConditionInfo.setAutoSwitch1(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT4);
		mAirConditionInfo.setSync(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT5);
		mAirConditionInfo.setCircleOut(value == 0);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT6);
		mAirConditionInfo.setAcEnable(value == ON);
		value = ByteUtil.onCheckOutBitAtIndex(mAirdata, BIT7);
		mAirConditionInfo.setSwitchAir(value == ON);
	}
	
	private void analyzeAirData1(byte mAirdata) {
		// 向上
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT7);
		mAirConditionInfo.setLeftWindBlowHead(bit7 == 1);
		mAirConditionInfo.setRightWindBlowHead(bit7 == 1);
		// 平行
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setLeftWindBlowBody(bit6 == 1);
		mAirConditionInfo.setRightWindBlowBody(bit6 == 1);
		// 吹脚
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setLeftWindBlowFoot(bit5 == 1);
		mAirConditionInfo.setRightWindBlowFoot(bit5 == 1);
		// data2风速等级
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT0);
		byte windGrade = (byte) (bit3 * 8 + bit2 * 4 + bit1 * 2 + bit0);
		mAirConditionInfo.setLeftWindGrade(windGrade);
		mAirConditionInfo.setRightWindGrade(windGrade);
		mAirConditionInfo.setWindGradeTotal((byte) 7);
	}
	
	
}
 