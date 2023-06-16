package com.landsem.canbox.comparse.simple;

import java.util.ArrayList;
import java.util.List;

import com.landsem.canbox.Constant;
import com.landsem.canbox.Constant.XPSAComID;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CornerInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;

import android.view.KeyEvent;
/**
 *  欣朴协议  ：psa 面板部分不用解
 */
public final class XPsaParse extends SimpleBaseParse implements XPSAComID{
	
	public XPsaParse() {
		super((byte) 0xFF, (byte) 0x2e, (byte) 0xA5);
	}

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		ByteUtil.onPrintByteArray(intackBytes, "XPsaParse--data: ");
		byte comID = intackBytes[Constant.COMID_XINPU];
		switch (comID) {
		case COMID_INFO_STEER_KEY:
			return analyzeSteerKey(intackBytes);
		case COMID_INFO_RADAR:
			return analyzeRadar(intackBytes);
		case COMID_CAR_STATE:
			return analyzeCarState(intackBytes);	
		case COMID_INFO_AIR_CONDITION:
			return analyzeAirCondition(intackBytes);
		case COMID_INFO_CORNER:
			return analyzeCorner(intackBytes);
		case COMID_INFO_CAR0:
			return analyzeCar0(intackBytes);	
		case COMID_INFO_CAR1:
			return analyzeCar1(intackBytes);
		case COMID_OUT_TEMP:
			return analyzeOutTemp(intackBytes);
		}
		return null;
	}

	private List<BaseInfo> analyzeOutTemp(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 车外温度
		byte dataInt = intackBytes[Constant.DATA0_XINPU];
		if (dataInt<0) {
			dataInt = (byte) (-128-dataInt);
		}
		mAirConditionInfo.setOutdoorTemp(dataInt);
		baseInfolList.add(mAirConditionInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeCar1(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 瞬时车速 最高位+最低位
		byte high = intackBytes[Constant.DATA2_XINPU];
		byte low = intackBytes[Constant.DATA3_XINPU];
		int data = ByteUtil.HighLowByteToInt(high, low);
		mCarLargeInfo.setInstantSpeed(data);
		//行驶里程
		high = intackBytes[Constant.DATA4_XINPU];
		low = intackBytes[Constant.DATA5_XINPU];
		data = ByteUtil.HighLowByteToInt( high,low );
		mCarLargeInfo.setMileage(data);
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeCar0(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// 瞬时油耗 最高位+最低位
		byte high = intackBytes[Constant.DATA0_XINPU];
		byte low = intackBytes[Constant.DATA1_XINPU];
		int data = ByteUtil.HighLowByteToInt(high, low);
		mCarLargeInfo.setInstantFuel((data / 10f) + "");
		// 续航里程 
		high = intackBytes[Constant.DATA2_XINPU];
		low = intackBytes[Constant.DATA3_XINPU];
		data = ByteUtil.HighLowByteToInt(high, low);
		mCarLargeInfo.setEnduranceMileage(data);
		baseInfolList.add(mCarLargeInfo);
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

	private List<BaseInfo> analyzeCarState(Byte[] intackBytes) {
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
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT1);
		mDoorInfo.setEngineHood(bit1 == 1 ? true : false);
		baseInfolList.add(mDoorInfo);
		byte data2 = intackBytes[Constant.DATA2_XINPU];
		byte bit2Data2 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT2);
		mCarBaseInfo.setREV(bit2Data2 == ON);
		byte bit0Data2 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT0);
		mCarBaseInfo.setILL(bit0Data2 == ON);
		baseInfolList.add(mCarBaseInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeRadar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		mRadarInfo.setBackLeftValue(getRadarDistanse(intackBytes[Constant.DATA1_XINPU]));
		mRadarInfo.setBackMidLeftValue(getRadarDistanse(intackBytes[Constant.DATA2_XINPU])); 
		mRadarInfo.setBackMidRightValue(getRadarDistanse(intackBytes[Constant.DATA2_XINPU]));
		mRadarInfo.setBackRightValue(getRadarDistanse(intackBytes[Constant.DATA3_XINPU]));
		mRadarInfo.setFrontLeftValue(getRadarDistanse(intackBytes[Constant.DATA4_XINPU]));
		mRadarInfo.setFrontMidLeftValue(getRadarDistanse(intackBytes[Constant.DATA5_XINPU])); 
		mRadarInfo.setFrontMidRightValue(getRadarDistanse(intackBytes[Constant.DATA5_XINPU]));
		mRadarInfo.setFrontRightValue(getRadarDistanse(intackBytes[Constant.DATA6_XINPU]));
		baseInfolList.add(mRadarInfo);
		return baseInfolList;
	}

	private int getRadarDistanse(Byte byte1) {
		int distance = 255;
		if ( byte1<=5 && byte1>=0 ) {
			distance = byte1*51;
		}
		return distance;
	}

	private List<BaseInfo> analyzeAirCondition(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// data0
		byte mAirdata0 = intackBytes[Constant.DATA0_XINPU];
		analyzeAirData0(mAirdata0);
		// data1
		byte mAirdata1 = intackBytes[Constant.DATA1_XINPU];
		analyzeAirData1( mAirdata1);
		// 座椅温度设数值
		byte mAirdata2 = intackBytes[Constant.DATA2_XINPU];
		float frontLeftSeatSetTemp = analyzeSeatHeatGrade(mAirdata2);
		mAirConditionInfo.setFrontLeftSeatSetTemp(frontLeftSeatSetTemp);
		byte mAirdata3 = intackBytes[Constant.DATA3_XINPU];
		float frontRightSeatSetTemp = analyzeSeatHeatGrade(mAirdata3);
		mAirConditionInfo.setFrontRightSeatSetTemp(frontRightSeatSetTemp);
		//data4
		byte mAirdata4 = intackBytes[Constant.DATA4_XINPU];
		analyzeAirData4( mAirdata4);
		baseInfolList.add(mAirConditionInfo);
		return baseInfolList;
	}
	
	private void analyzeAirData4(byte mAirdata4) {
		// A/C-MAX 
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata4, Constant.BIT3);
		mAirConditionInfo.setAcMaxSwitch(bit3 == 1);
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata4, Constant.BIT7);
		mAirConditionInfo.setFrontWindowDemist(bit7 == 1);
	}

	private float analyzeSeatHeatGrade(byte mAirdata) {
		float seatHeatGrade = ByteUtil.convertByteToInt(mAirdata);
		if (seatHeatGrade == 0x00) {
			seatHeatGrade = Constant.AIR_LOW;
		} else if (seatHeatGrade == 0xff) {
			seatHeatGrade = Constant.AIR_HIGH;
		} else {
			seatHeatGrade = (float) (seatHeatGrade/2);
		}
		return seatHeatGrade;

	}
	
	private void analyzeAirData1(byte mAirdata) {
		// 吹头
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT7);
		mAirConditionInfo.setLeftWindBlowHead(bit7 == 1);
		mAirConditionInfo.setRightWindBlowHead(bit7 == 1);
		// 吹身
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
		byte windGrade = (byte) (bit3*8 + bit2*4 + bit1*2 + bit0);
		mAirConditionInfo.setLeftWindGrade(windGrade);
		mAirConditionInfo.setRightWindGrade(windGrade);
		mAirConditionInfo.setWindGradeTotal((byte) 9);
	}
	
	private void analyzeAirData0(byte mAirdata) {
		// 开关
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT7);
		mAirConditionInfo.setSwitchAir(bit7 == 1 );
		// A/C
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setAcEnable(bit6 == 1 );
		//内外循环
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setCircleOut(bit5==0 );
		// Auto
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		mAirConditionInfo.setAutoSwitch1(bit3 == 1);
		// Dual
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		mAirConditionInfo.setDualSwitch(bit2 == 1 ? true : false);
		//bit0 
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT0);
		mAirConditionInfo.setBackWindowDemist(bit0 == 1 ? true : false);
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
		if (data0 == (byte) 0x81 || data0 == (byte) 0x82 || data0 == 0x17 || data0 == 0x18) {
			analyzeKnobFuction(mKeyFunctionInfo, data0, data1);
		} else if(mKeyFunctionInfo.isKeyDown()||mKeyFunctionInfo.isSteeringKeyLongDown()) {
			analyzeKeyFuction(mKeyFunctionInfo, data0);
		}
		baseInfolList.add(mKeyFunctionInfo);
		return baseInfolList;
	}

	private void analyzeKeyFuction(KeyFunctionInfo mKeyFunctionInfo, byte data0) {
		switch (data0) {
       case 8://esc
       case (byte) 0x9b:
       case (byte) 0xa3:
    	    mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_BACK);
			break;
       case 0x11://mode SRC
       case (byte) 0x9e:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
   	   case 0x12:
   	   case (byte) 0x98:
		    mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);
		    break;
	   case 0x13:
	   case (byte) 0x97:
		    mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
		    break;
	   case 0x14:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_UP);
			break;
	   case 0x15:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_DOWN);
			break;
		case 0x16:
		case (byte) 0xa4:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
			break;
		 case 0x23:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_BLUE_PHONE);
			break;
		case (byte) 0x99:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_COLLEC_RADIO);
			break;
		case (byte) 0xa0://接电话
		case  0x50:
		case  0x30:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_ANSWER);
			break;
		case (byte) 0xa1://音乐
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MUSIC);
			break;
		}
	}
	
	private void analyzeKnobFuction(KeyFunctionInfo mKeyFunctionInfo, byte data0, byte data1) {
//		mKeyFunctionInfo.setStepValueMax(30);
		if (data1 != 0) {
			switch (data0) {
			case (byte) 0x81:
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_UP);
				// 步进值
				mKeyFunctionInfo.setStepValue(ByteUtil.convertByteToInt(data1));
				break;
			case (byte) 0x82:
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_DOWN);
				// 步进值
				mKeyFunctionInfo.setStepValue(ByteUtil.convertByteToInt(data1));
				break;
			case 0x17:
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_CHANNEL_UP_FAST);
				// 步进值
				mKeyFunctionInfo.setStepValue(ByteUtil.convertByteToInt(data1));
				break;
			case 0x18:
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_CHANNEL_DOWN_FAST);
				// 步进值
				mKeyFunctionInfo.setStepValue(ByteUtil.convertByteToInt(data1));
				break;
			}
		}
	}

}
