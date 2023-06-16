package com.landsem.canbox.comparse.raise;

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
import com.landsem.canbox.pack.SimpleBaseComPack;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;
/**
 *  睿志诚协议  ：启辰
 */
public class VenuciaParse extends RaiseBaseParse {
	public VenuciaParse() {
		super((byte) 0xFF, (byte) 0x2e, (byte) 0xA5);
	}

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		ByteUtil.onPrintByteArray(intackBytes, "Venucia--data: ");
		byte comID = intackBytes[Constant.COMID_XINPU];
		switch (comID) {
		case Constant.VenuciaComID.COMID_INFO_STEER_KEY:
			return analyzeSteerKey(intackBytes);
		case Constant.VenuciaComID.COMID_INFO_AIR_CONDITION:
			return analyzeAirCondition(intackBytes);
		}
		return null;
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
		if (mAirdata3<=15 && mAirdata3>=1) {
			mAirConditionInfo.setFrontLeftSeatSetTemp(mAirdata3+16);
		}
		// data4
		byte mAirdata4 = intackBytes[Constant.DATA4_XINPU];
		if (mAirdata4<=15 && mAirdata4>=1) {
			mAirConditionInfo.setFrontRightSeatSetTemp(mAirdata4+16);
		}
		baseInfolList.add(mAirConditionInfo);
		return baseInfolList;
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
		// A/C-MAX
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT7);
		mAirConditionInfo.setAcMaxSwitch(bit7 == 1 ? true : false);
		// A/C
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT6);
		mAirConditionInfo.setAcEnable(bit6 == 1 ? true : false);
		//内外循环
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT4);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT5);
		mAirConditionInfo.setCircleOut((bit5*2+bit4)==0 ? true : false);
		// Dual
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT2);
		mAirConditionInfo.setDualSwitch(bit2 == 1 ? true : false);
		// 后除霜灯指示
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(mAirdata, Constant.BIT1);
		mAirConditionInfo.setBackWindowDemist(bit1 == 1 ? true : false);
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
		if (data0==0x20 || data0==0x21) {
			analyzeKnobFuction(mKeyFunctionInfo, data0, data1);
		}else if (mKeyFunctionInfo.isKeyDown()||mKeyFunctionInfo.isSteeringKeyLongDown()) {
			analyzeKeyFuction(mKeyFunctionInfo, data0);
		}
		
		baseInfolList.add(mKeyFunctionInfo);
		return baseInfolList;
	}
	
	private void analyzeKnobFuction(KeyFunctionInfo mKeyFunctionInfo, byte data0, byte data1) {
		if (data1 != 0) {
			switch (data0) {
			case 0x20:
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_UP);
				// 步进值
				mKeyFunctionInfo.setStepValue(ByteUtil.convertByteToInt(data1));
				break;
			case 0x21:
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_DOWN);
				// 步进值
				mKeyFunctionInfo.setStepValue(ByteUtil.convertByteToInt(data1));
				break;
			}
		}
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
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);
			break;
		case 4:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
			break;
		case 7:
		case 0x25:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		case 8:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOICE);
			break;
		case 0x0a:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_REAR_VIDEO);
			break;
		case 0x12:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_POWER);
			break;
		case 0x22:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_BACK);
			break;
		case 0x23:
		case 0x26:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_HOME);
			break;
		}
	}

}
