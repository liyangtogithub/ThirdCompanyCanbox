package com.landsem.canbox.comparse.raise;

import java.util.ArrayList;
import java.util.List;

import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;

import android.graphics.LightingColorFilter;
import android.view.KeyEvent;
/**
 * 睿志成韩系车型串口通讯协议
 * @author LQPDC
 *
 */
public final class PrettySSParse extends RaiseBaseParse {
	
	static byte start = (byte) 0xFD;
	
	public PrettySSParse() {
		super(start, start, start);
	}

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] byteArray) {

		byte dataType = byteArray[2];
		List<BaseInfo> infoList = new ArrayList<BaseInfo>();
		switch (dataType) {
		case DATA_TYPE_AIRC:
			analyzeAirControl(infoList, byteArray);
			break;
		case DATA_TYPE_DOOR:
			analyzeCarDoor(infoList, byteArray);
			break;
		case DATA_TYPE_KEY:
			analyzeKeyCode(infoList, byteArray);
			break;
		case DATA_TYPE_RADAR:
			analyzeRadar(infoList, byteArray);
			break;
		case DATA_TYPE_BLIGHT:
			analyzeBackLight(infoList, byteArray);
			break;
		case DATA_TYPE_TEMP:
			analyzeTemp(infoList, byteArray);
			break;
		}
		return infoList;
	}

	private void analyzeTemp(List<BaseInfo> infoList, Byte[] byteArray) {
		byte mAirdata0 = byteArray[Constant.DATA0_XINPU];
		if (mAirdata0<0) {
			mAirdata0 = (byte) (-128-mAirdata0);
		}
		mAirConditionInfo.setOutdoorTemp(mAirdata0);
		infoList.add(mAirConditionInfo);
	}

	private void analyzeBackLight(List<BaseInfo> infoList, Byte[] byteArray) {
		// Data0为表示倒车档位灯光
		byte value = byteArray[3];
		mCarBaseInfo.setILL(value == 0x01);
		infoList.add(mCarBaseInfo);
	}

	private void analyzeCarDoor(List<BaseInfo> infoList, Byte[] byteArray) {
		byte value = byteArray[3];
		byte status = ByteUtil.onCheckOutBitAtIndex(value, BIT0);
		mDoorInfo.setDriverDoor(status==ON);
		status = ByteUtil.onCheckOutBitAtIndex(value, BIT1);
		mDoorInfo.setPassengerDoor(status==ON);
		status = ByteUtil.onCheckOutBitAtIndex(value, BIT2);
		mDoorInfo.setLeftBackDoor(status==ON);
		status = ByteUtil.onCheckOutBitAtIndex(value, BIT3);
		mDoorInfo.setRightBackDoor(status==ON);
		status = ByteUtil.onCheckOutBitAtIndex(value, BIT4);
		mDoorInfo.setBackTrunk(status==ON);
		status = ByteUtil.onCheckOutBitAtIndex(value, BIT5);
		mDoorInfo.setEngineHood(status==ON);
		infoList.add(mDoorInfo);
	}

	private void analyzeRadar(List<BaseInfo> infoList, Byte[] byteArray) {
		byte value = byteArray[3];
		int gradeValue = 0;
		byte byteValue = ByteUtil.onCheckOutBitAtIndex(value, BIT7);
		gradeValue += byteValue * 2;
		byteValue = ByteUtil.onCheckOutBitAtIndex(value, BIT6);
		gradeValue += byteValue;
		gradeValue = 255 - gradeValue*80;
		mRadarInfo.setFrontLeftValue(gradeValue);
		gradeValue = 0;
		byteValue = ByteUtil.onCheckOutBitAtIndex(value, BIT5);
		gradeValue += byteValue * 2;
		byteValue = ByteUtil.onCheckOutBitAtIndex(value, BIT4);
		gradeValue += byteValue;
		gradeValue = 255 - gradeValue*80;
		mRadarInfo.setFrontMidLeftValue(gradeValue);
		gradeValue = 0;
		byteValue = ByteUtil.onCheckOutBitAtIndex(value, BIT3);
		gradeValue += byteValue * 2;
		byteValue = ByteUtil.onCheckOutBitAtIndex(value, BIT2);
		gradeValue += byteValue;
		gradeValue = 255 - gradeValue*80;
		mRadarInfo.setFrontMidRightValue(gradeValue);
		gradeValue = 0;
		byteValue = ByteUtil.onCheckOutBitAtIndex(value, BIT1);
		gradeValue += byteValue * 2;
		byteValue = ByteUtil.onCheckOutBitAtIndex(value, BIT0);
		gradeValue += byteValue;
		gradeValue = 255 - gradeValue*80;
		mRadarInfo.setFrontRightValue(gradeValue);
		value = byteArray[4];
		gradeValue = 0;
		byteValue = ByteUtil.onCheckOutBitAtIndex(value, BIT7);
		gradeValue += byteValue * 2;
		byteValue = ByteUtil.onCheckOutBitAtIndex(value, BIT6);
		gradeValue += byteValue;
		gradeValue = 255 - gradeValue*80;
		mRadarInfo.setBackLeftValue(gradeValue);
		gradeValue = 0;
		byteValue = ByteUtil.onCheckOutBitAtIndex(value, BIT5);
		gradeValue += byteValue * 2;
		byteValue = ByteUtil.onCheckOutBitAtIndex(value, BIT4);
		gradeValue += byteValue;
		gradeValue = 255 - gradeValue*80;
		mRadarInfo.setBackMidLeftValue(gradeValue);
		gradeValue = 0;
		byteValue = ByteUtil.onCheckOutBitAtIndex(value, BIT3);
		gradeValue += byteValue * 2;
		byteValue = ByteUtil.onCheckOutBitAtIndex(value, BIT2);
		gradeValue += byteValue;
		gradeValue = 255 - gradeValue*80;
		mRadarInfo.setBackMidRightValue(gradeValue);
		gradeValue = 0;
		byteValue = ByteUtil.onCheckOutBitAtIndex(value, BIT1);
		gradeValue += byteValue * 2;
		byteValue = ByteUtil.onCheckOutBitAtIndex(value, BIT0);
		gradeValue += byteValue;
		gradeValue = 255 - gradeValue*80;
		mRadarInfo.setBackRightValue(gradeValue);
		infoList.add(mRadarInfo);
	}

	private void analyzeKeyCode(List<BaseInfo> infoList, Byte[] byteArray) {
		if (byteArray[4] == 0)
			return;
		int keyCode = ByteUtil.convertByteToInt(byteArray[3]);
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();

		if (keyCode == 0x19 || keyCode == 0x1a) {
			analyzeKnobFuction(mKeyFunctionInfo, (byte) keyCode, byteArray[4]);
		} else {

			switch (keyCode) {
			case 0x10:// Mute
				mKeyFunctionInfo
						.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
				break;
			case 0x11:// Mode
			case 0x1C:// Media
				mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_MODE);
				break;
			// Vol+
			case 0x14:
			case 0x84:
				mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_UP);
				break;
			// Vol-
			case 0x15:
			case 0x85:
				mKeyFunctionInfo
						.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_DOWN);
				break;
			case 0x16:// 接电话
				mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_ANSWER);
				break;
			case 0x17:// 挂电话
				mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_HANGUP);
				break;
			case 0x18:
				mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_POWER);
				break;
			case 0x25:// Enter
				mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_ENTER);
				break;
			case 0x12:
			case 0x1F:
			case 0x26:// tune+
				mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_HANGUP_NEXT);
				break;
			case 0x13:
			case 0x20:
			case 0x27:// tune-
				mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_ANSWER_PREV);
				break;
			case 0x29:// Home
				mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_HOME);
				break;
			case 0x30:// 语音
				mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_VOICE);
				break;
			default:
				mKeyFunctionInfo = null;
				break;
			}
		}
		if (null != mKeyFunctionInfo)
			infoList.add(mKeyFunctionInfo);
	}

	private void analyzeKnobFuction(KeyFunctionInfo mKeyFunctionInfo, byte data0, byte data1) {
		if (data1 != 0) {
			switch (data0) {
			case 0x19:
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_UP);
				// 步进值
				mKeyFunctionInfo.setStepValue(ByteUtil.convertByteToInt(data1));
				break;
			case 0x1a:
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_DOWN);
				// 步进值
				mKeyFunctionInfo.setStepValue(ByteUtil.convertByteToInt(data1));
				break;
			}
		}
	}

	private void analyzeAirControl(List<BaseInfo> infoList, Byte[] byteArray) {
		//驾驶位置温度
		byte value = byteArray[3];
		float seatTemp = 0;
		if (value>=0 && value<=30){
			seatTemp = (float) (17 + value*0.5);
			mAirConditionInfo.setFrontLeftSeatSetTemp(seatTemp);
		}
		seatTemp = 0;
		value = byteArray[4];
		if (value>=0 && value<=30){
			seatTemp = (float) (17 + value*0.5);
			mAirConditionInfo.setFrontRightSeatSetTemp(seatTemp);
		}
		//网速等级0-8
		value = byteArray[5];
		mAirConditionInfo.setLeftWindGrade(value);
		mAirConditionInfo.setRightWindGrade(value);	
		mAirConditionInfo.setWindGradeTotal((byte) 8);
		value = byteArray[6];
		byte status = ByteUtil.onCheckOutBitAtIndex(value, BIT0);
		mAirConditionInfo.setAcEnable(status==ON);
		
		status = ByteUtil.onCheckOutBitAtIndex(value, BIT1);
		mAirConditionInfo.setSync(status==ON);
		mAirConditionInfo.setDualSwitch(status==ON);
		
		status = ByteUtil.onCheckOutBitAtIndex(value, BIT2);
		mAirConditionInfo.setAutoSwitch1(status==ON);
		mAirConditionInfo.setAutoSwitch2(status==ON);
		
		status = ByteUtil.onCheckOutBitAtIndex(value, BIT3);
		mAirConditionInfo.setLeftWindBlowHead(status==ON);
		mAirConditionInfo.setRightWindBlowHead(status==ON);
		mAirConditionInfo.setLeftWindBlowBody(status==ON);
		mAirConditionInfo.setRightWindBlowBody(status==ON);
		
		status = ByteUtil.onCheckOutBitAtIndex(value, BIT4);
		mAirConditionInfo.setLeftWindBlowFoot(status==ON);
		mAirConditionInfo.setRightWindBlowFoot(status==ON)
		;
		status = ByteUtil.onCheckOutBitAtIndex(value, BIT5);
		mAirConditionInfo.setBackWindowDemist(status==ON);
		status = ByteUtil.onCheckOutBitAtIndex(value, BIT6);
		mAirConditionInfo.setFrontWindowDemist(status==ON);
		status = ByteUtil.onCheckOutBitAtIndex(value, BIT7);
		mAirConditionInfo.setCircleOut(status!=ON);

		value = byteArray[1];
		if (value!=0x08) {
			value = byteArray[8];
			mAirConditionInfo.setRearOpen(value!=0);
			mAirConditionInfo.setBackWindGrade(value);
		}
		infoList.add(mAirConditionInfo);
	}
	/**
	 * 校验
	 */
	@Override
	public boolean onCheckBytesValidity(Byte[] byteArray) {
		boolean resultCode = false;
		if (null != byteArray && 3 < byteArray.length) {
			int checkSum = 0;
			for (int index = 1; index < byteArray.length - 2; index++) {
				checkSum +=  ByteUtil.convertByteToInt(byteArray[index]);
			}
			int expectSum = 0;
			byte value = byteArray[byteArray.length - 2];
			expectSum += value << 8;
			value = byteArray[byteArray.length - 1];
			expectSum += ByteUtil.convertByteToInt(value);
			resultCode = expectSum==checkSum;
			LogManager.d(TAG, "checkSum: "+checkSum+", expectSum: "+expectSum+", resultCode; "+resultCode);
		}
		return resultCode;
	}
}
