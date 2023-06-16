package com.landsem.canbox.comparse.union;

import java.util.ArrayList;
import java.util.List;

import android.view.KeyEvent;

import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CornerInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.RadarInfo;
import com.landsem.canbox.comparse.BaseComParse;
import com.landsem.canbox.comparse.simple.SimpleBaseParse;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;
/**
 *  和驰协议  ：宝马
 */
public class BmwParse extends SimpleBaseParse {
	public BmwParse() {
		super((byte) 0xFF, (byte) 0x2e, (byte) 0xA5);
	}

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		ByteUtil.onPrintByteArray(intackBytes, "BmwParse--data: ");
		byte comID = intackBytes[Constant.COMID_XINPU];
		switch (comID) {
		case Constant.BmwComID.COMID_INFO_BACK_LIGHT:
			return analyzeBackLight(intackBytes);
		case Constant.BmwComID.COMID_INFO_STEER_KEY:
			return analyzeSteerKey(intackBytes);
		case Constant.BmwComID.COMID_INFO_SEAT_HEAT:
			return analyzeSeatHeat(intackBytes);
		case Constant.BmwComID.COMID_INFO_DOOR:
			return analyzeDoor(intackBytes);
		case Constant.BmwComID.COMID_INFO_CORNER:
			return analyzeCorner(intackBytes);
		case Constant.BmwComID.COMID_INFO_RADAR:
			return analyzeRadar(intackBytes);
		case Constant.BmwComID.COMID_INFO_SPEED:
			return analyzeSpeed(intackBytes);
		case Constant.BmwComID.COMID_INFO_CAR:
			return analyzeCar(intackBytes);
		case Constant.BmwComID.COMID_INFO_UNIT:
			return analyzeUnit(intackBytes);	
		}
		return null;
	}

	private List<BaseInfo> analyzeUnit(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte unitByte = intackBytes[Constant.DATA0_XINPU];
		mCarLargeInfo.setDistanceUnit(unitByte==0?"km":"mile");
		byte unitOil = intackBytes[Constant.DATA2_XINPU];
    	String oilUnit = "L/100km";
		if (unitOil==0) {
			oilUnit = "L/100km";
		}else if (unitOil==1) {
			oilUnit = "mpg(US)";
		}else if (unitOil==2) {
			oilUnit = "mpg(UK)";
		}else if (unitOil==3) {
			oilUnit = "km/L";
		}
		mCarLargeInfo.setOilUnit(oilUnit);
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeCar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte high = 0;
		byte low = 0;
		int data = 0;
		// 续航里程
		high = intackBytes[Constant.DATA2_XINPU];
		low = intackBytes[Constant.DATA3_XINPU];
		data = ByteUtil.HighLowByteToInt(high, low);
		mCarLargeInfo.setEnduranceMileage(data);
		//平均油耗
		high = intackBytes[Constant.DATA6_XINPU];
		low = intackBytes[Constant.DATA7_XINPU];
		float averageFuel = ByteUtil.HighLowByteToInt(high,low)/10f;
		mCarLargeInfo.setAverageFuel(averageFuel);
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeSpeed(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte high = 0;
		byte low = 0;
		int data = 0;
		// 瞬时车速 最高位+最低位
		high = intackBytes[Constant.DATA0_XINPU];
		low = intackBytes[Constant.DATA1_XINPU];
		data = ByteUtil.HighLowByteToInt(high, low);
		mCarLargeInfo.setInstantSpeed(data);
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeRadar(Byte[] intackBytes) {
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
		case 0:
			distance = 255;
			break;
		case 10:
			distance = 0;
			break;
       default:
        	distance = 25*(10-byte1);
			break;
		}
		return distance;
	}

	private List<BaseInfo> analyzeCorner(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 方向盘转角
		int data0 = ByteUtil.convertByteToInt(intackBytes[Constant.DATA0_XINPU]);
		int leftCor = PROTOCAL_INVALID_VALUE;
		int rightCor = PROTOCAL_INVALID_VALUE;
		// 左转:0--0x32      右转:0x80--0xb2
		if (data0 <= 0x32  && data0 > 0 ) {
			leftCor = -(data0*11);
		} else if (data0 <= 0xb2 && data0 > 0x80) {
			rightCor = (data0-0x80)*11;
		} 
		mCornerInfo.setLeftCorner(leftCor);
		mCornerInfo.setRightCorner(rightCor);

		baseInfolList.add(mCornerInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeDoor(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data = intackBytes[Constant.DATA0_XINPU];
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
		baseInfolList.add(mDoorInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeSeatHeat(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data0 = intackBytes[Constant.DATA0_XINPU];
		// 左边座椅加热等级
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT7);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT6);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT5);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT4);
		mAirConditionInfo.setLeftSeatHeatGrade(bit7 * 8 + bit6 * 4 + bit5 * 2
				+ bit4);
		// 右边座椅加热等级
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT0);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT1);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT2);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT3);
		mAirConditionInfo.setRightSeatHeatGrade(bit3 * 8 + bit2 * 4 + bit1 * 2
				+ bit0);
		baseInfolList.add(mAirConditionInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeSteerKey(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		// data1 按键状态
		byte data1 = intackBytes[Constant.DATA1_XINPU];
		mKeyFunctionInfo.setKeyDown(data1 == 1 ? true : false);
		// data0 方向盘按键 ,算一次有效
		byte data0 = intackBytes[Constant.DATA0_XINPU];
		if (mKeyFunctionInfo.isKeyDown()) {
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
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		case 5:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);
			break;
		case 6:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
			break;
		case 7:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOICE);
			break;
		}
	}

	private List<BaseInfo> analyzeBackLight(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data0 = intackBytes[Constant.DATA0_XINPU];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data0, Constant.BIT7);
		mCarBaseInfo.setILL(bit7 == 1 ? true : false);
		baseInfolList.add(mCarBaseInfo);
		return baseInfolList;
	}

}
