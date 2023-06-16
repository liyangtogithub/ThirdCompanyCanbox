package com.landsem.canbox.comparse.raise;

import java.util.ArrayList;
import java.util.List;

import com.landsem.canbox.Constant;
import com.landsem.canbox.Constant.GeelyComID;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CornerInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.comparse.simple.SimpleBaseParse;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;

import android.view.KeyEvent;
/**
 *  睿志诚  ：吉利
 */
public final class GeelyParse extends RaiseBaseParse implements GeelyComID{
	
	public GeelyParse() {
		super((byte) 0xFF, (byte) 0x2e, (byte) 0xA5);
	}

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		ByteUtil.onPrintByteArray(intackBytes, "GeelyParse--data: ");
		byte comID = intackBytes[Constant.COMID_XINPU];
		switch (comID) {
		case GeelyComID.DATA_TYPE_KEY:
			return analyzeSteerKey(intackBytes);
		case DATA_TYPE_AIR:
			return analyzeAirCondition(intackBytes);
		case DATA_TYPE_BASE:
			return analyzeBase(intackBytes);	
		}
		return null;
	}
	
	private List<BaseInfo> analyzeBase(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte mAirdata1 = intackBytes[Constant.DATA1_XINPU];
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata1, Constant.BIT2);
		mCarBaseInfo.setILL(bit2 == ON);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(mAirdata1, Constant.BIT0);
		mCarBaseInfo.setREV(bit0 == ON);
		baseInfolList.add(mCarBaseInfo);
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
		// data2风速等级
		byte mAirdata2 = intackBytes[Constant.DATA2_XINPU];
		mAirConditionInfo.setLeftWindGrade((byte) (mAirdata2));
		mAirConditionInfo.setRightWindGrade((byte) (mAirdata2));
		mAirConditionInfo.setWindGradeTotal((byte) 7);
		// data3
		byte mAirdata3 = intackBytes[Constant.DATA3_XINPU];
		mAirConditionInfo.setFrontLeftSeatSetTemp(analyzeSeatHeatGrade(mAirdata3));
		// data4
		byte mAirdata4 = intackBytes[Constant.DATA4_XINPU];
		mAirConditionInfo.setFrontRightSeatSetTemp(analyzeSeatHeatGrade(mAirdata4));
		//data5
		byte mAirdata5 = intackBytes[Constant.DATA5_XINPU];
		analyzeAirData5( mAirdata5);
		baseInfolList.add(mAirConditionInfo);
		return baseInfolList;
	}
	
	private void analyzeAirData5(byte mAirdata) {
		// 前除雾
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT7);
		mAirConditionInfo.setFrontWindowDemist(bit7 == 1 ? true : false);
		// 后除雾
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setBackWindowDemist(bit6 == 1 ? true : false);
		// AC MAX
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		mAirConditionInfo.setAcMaxSwitch(bit3 == 1 ? true : false);
	}

	private float analyzeSeatHeatGrade(byte mAirdata) {
		float seatHeatGrade = ByteUtil.convertByteToInt(mAirdata);
		if (seatHeatGrade == 0x00) {
			seatHeatGrade = Constant.AIR_LOW;
		} else if (seatHeatGrade == 0x1f) {
			seatHeatGrade = Constant.AIR_HIGH;
		} else {
			seatHeatGrade = (float) (seatHeatGrade+17);
		}
		return seatHeatGrade;

	}
	
	
	private void analyzeAirData1(byte mAirdata) {
		initWindMode();
		switch (mAirdata) {
		case 0:
			break;
		// 吹头
		case 1:
			mAirConditionInfo.setLeftWindBlowHead(true);
			mAirConditionInfo.setRightWindBlowHead(true);
			break;
		// 吹头 吹脚
		case 2:
			mAirConditionInfo.setLeftWindBlowHead(true);
			mAirConditionInfo.setRightWindBlowHead(true);
			mAirConditionInfo.setLeftWindBlowFoot(true);
			mAirConditionInfo.setRightWindBlowFoot(true);
			break;
		// 吹脚
		case 3:
			mAirConditionInfo.setLeftWindBlowFoot(true);
			mAirConditionInfo.setRightWindBlowFoot(true);
			break;
		// 吹脚前除霜
		case 4:
			mAirConditionInfo.setLeftWindBlowFoot(true);
			mAirConditionInfo.setRightWindBlowFoot(true);
			mAirConditionInfo.setFrontWindowDemist(true);
			break;
		// 前除霜 
		case 5:
			mAirConditionInfo.setFrontWindowDemist(true);
			break;
		
		}
	}
	
	private void initWindMode() {
		mAirConditionInfo.setFrontWindowDemist(false);
		mAirConditionInfo.setLeftWindBlowWindow(false);
		mAirConditionInfo.setLeftWindBlowHead(false);
		mAirConditionInfo.setLeftWindBlowFoot(false);
		mAirConditionInfo.setRightWindBlowWindow(false);
		mAirConditionInfo.setRightWindBlowHead(false);
		mAirConditionInfo.setRightWindBlowFoot(false);
	}
	
	private void analyzeAirData0(byte mAirdata) {
		// 空调开关
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT7);
		mAirConditionInfo.setSwitchAir(bit7 == 1 ? true : false);
		// A/C
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setAcEnable(bit6 == 1 ? true : false);
		//内外循环
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setCircleOut(bit5 ==0 ? true : false);
		// AUTO
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT3);
		mAirConditionInfo.setAutoSwitch1(bit3 == 1 ? true : false);
		// Dual
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		mAirConditionInfo.setDualSwitch(bit2 == 1 ? true : false);
		
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
		if(mKeyFunctionInfo.isKeyDown()||mKeyFunctionInfo.isSteeringKeyLongDown()) {
			analyzeKeyFuction(mKeyFunctionInfo, data0);
		}
		baseInfolList.add(mKeyFunctionInfo);
		return baseInfolList;
	}

	private void analyzeKeyFuction(KeyFunctionInfo mKeyFunctionInfo, byte data0) {
		switch (data0) {
	   case 0x01:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_UP);
			break;
	   case 0x02:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_DOWN);
			break;
	   case 3:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);
			break;
		case 4:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
			break;	
		case 5:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_ANSWER);
			break;  
		case 0x06:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
			break;
		case 0x07:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		}
	}
	
	

}
