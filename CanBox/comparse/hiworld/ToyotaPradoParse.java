package com.landsem.canbox.comparse.hiworld;

import java.util.ArrayList;
import java.util.List;

import android.view.KeyEvent;

import com.landsem.canbox.Constant;
import com.landsem.canbox.Constant.ToyotaComID;
import com.landsem.canbox.activity.BaseActivity;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CarAlarm;
import com.landsem.canbox.bean.CarLargeInfo;
import com.landsem.canbox.bean.CornerInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.DriverAssistInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.PeripheralInfo;
import com.landsem.canbox.bean.RadarInfo;
import com.landsem.canbox.bean.SetInfo;
import com.landsem.canbox.comparse.BaseComParse;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;
/**
 * TODO 丰田霸道 模块上行(协议盒->DVD主机)数据的解析处理类
 */
public class ToyotaPradoParse extends HiworldBaseParse1  {

	public ToyotaPradoParse() {
		super((byte) 0xFF, (byte) 0x5A, (byte) 0xA5);
	}

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		ByteUtil.onPrintByteArray(intackBytes, "PradoParse--data: ");
		byte comID = intackBytes[Constant.COMID];
		switch (comID) {
		case Constant.ToyotaComID.COMID_INFO_BASE_CAR:
			return analyzeBaseCar( intackBytes);
		case Constant.HiworldComID.COMID_INFO_CAR_DEFINITE:
			return analyzeCarDefinite(intackBytes);
		case Constant.ToyotaComID.COMID_INFO_CAR_DEFINITE0:
			return analyzeCarDefinite0(intackBytes);
		case Constant.ToyotaComID.COMID_INFO_CAR_DEFINITE2:
			return analyzeCarDefinite2(intackBytes);
		case Constant.ToyotaComID.COMID_INFO_RADAR:
			return analyzeRadar(intackBytes);	
		}
		return null;
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

	private List<BaseInfo> analyzeCarDefinite2(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		//上几分钟油耗  最高位+最低位
//		float []lastFuelArray = mCarLargeInfo.getLastFuelArray();
//		float lastFuelArrayTemp[] = new float[intackBytes.length/2] ;
//		byte High = 0;
//		byte Low = 0;
//		for (int i = 0; i < intackBytes.length-1; i++) {
//			if (i%2==0) {
//				High = intackBytes[i];
//			}else {
//				Low = intackBytes[i];
//				int lastFuel = ByteUtil.HighLowByteToInt(High, Low);
//				lastFuelArrayTemp[i/2] = (lastFuel/10f);
//			}
//		}
//		lastFuelArray = lastFuelArrayTemp;
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
		//data3  按键按下
		byte data3 =intackBytes[Constant.DATA3];
		mKeyFunctionInfo.setKeyDown(data3==1?true:false);
		//data2 方向盘按键
		if (mKeyFunctionInfo.isKeyDown()) {
			byte data2 =intackBytes[Constant.DATA2];
			analyzeKeyFuction(mKeyFunctionInfo,data2);
		}
		// data4 门状态
		byte data4 = intackBytes[Constant.DATA4];
		analyzeDoorInfo(baseInfolList, data4);
		// data5 点火状态
		byte data5 = intackBytes[Constant.DATA5];
		mCarBaseInfo.setIgnition(data5==1?true:false);
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
