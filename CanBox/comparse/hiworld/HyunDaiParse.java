package com.landsem.canbox.comparse.hiworld;

import java.util.ArrayList;
import java.util.List;

import android.view.KeyEvent;

import com.landsem.canbox.Constant;
import com.landsem.canbox.activity.BaseActivity;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CarLargeInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.comparse.BaseComParse;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;
/**
 * TODO 现代&起亚 模块上行(协议盒->DVD主机)数据的解析处理类
 *@author LiYang,Power by Landsem @ShenZhen
 */
public class HyunDaiParse extends HiworldBaseParse2  {

	public HyunDaiParse() {
		super((byte) 0xFF, (byte) 0x5A, (byte) 0xA5);
	}
	
	int knobvalueOder = 0;
	int knobvalue = 0;

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		String readMsg = ByteUtil.onPrintByteArray(intackBytes, "HyunDaiParse--data: ");
//		BaseActivity.sendBroadcastToActivity(readMsg);
		byte comID = intackBytes[Constant.COMID];
		switch (comID) {
		case Constant.HyunDaiComID.COMID_INFO_BASE_CAR:
			return analyzeBaseCar( intackBytes);
		case Constant.HyunDaiComID.COMID_INFO_AIR_CONDITION:
			return analyzeAirControl( intackBytes);
//		case Constant.HyunDaiComID.COMID_INFO_SOFT_VERSION:
//			return analyzeVertion(intackBytes);
		case Constant.HyunDaiComID.COMID_PANEL_KEY:
			return analyzePanelKey(intackBytes);
		case Constant.HyunDaiComID.COMID_PANEL_KNOB:
			return analyzePanelKnob(intackBytes);
//		case Constant.HyunDaiComID.COMID_INFO_AMPLIFIER:
//			return analyzeAmplifier(intackBytes);
//		case Constant.HyunDaiComID.COMID_INFO_CAR_TYPE:
//			return analyzeCarType(intackBytes);
		}
		
		return null;
	}
	
	private List<BaseInfo> analyzeCarType(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data0 =intackBytes[Constant.DATA0];
		mCarBaseInfo.setCarTypePara0(data0);
		byte data1 =intackBytes[Constant.DATA1];
		mCarBaseInfo.setCarTypePara1(data1);
		baseInfolList.add(mCarBaseInfo);
		return baseInfolList;
	}
	
	private List<BaseInfo> analyzeAmplifier(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data0 =intackBytes[Constant.DATA0];
		mCarBaseInfo.setSoundValue(data0);
		byte data1 =intackBytes[Constant.DATA1];
		mCarBaseInfo.setSoundLRValue(data1);
		byte data2 =intackBytes[Constant.DATA2];
		mCarBaseInfo.setSoundFBValue(data2);
		byte data3 =intackBytes[Constant.DATA3];
		mCarBaseInfo.setSoundLowValue(data3);
		byte data4 =intackBytes[Constant.DATA4];
		mCarBaseInfo.setSoundMidValue(data4);
		byte data5 =intackBytes[Constant.DATA5];
		mCarBaseInfo.setSoundHigValue(data5);
		byte data6 =intackBytes[Constant.DATA6];
		mCarBaseInfo.setSoundMute(data6==1?true:false);
		baseInfolList.add(mCarBaseInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzePanelKnob(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		byte data0 =intackBytes[Constant.DATA0];
		byte data1 =intackBytes[Constant.DATA1];
		knobvalue = data1;
		switch (data0) {
		case  0x01:
			knobvalue = knobvalue-knobvalueOder;
			if (knobvalue>0) {
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_UP);
				mKeyFunctionInfo.setStepValue(knobvalue);
			}else if (knobvalue<0) {
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_DOWN);
				mKeyFunctionInfo.setStepValue(-knobvalue);
			} 
			knobvalueOder = data1 ; 
			break;
		}
		baseInfolList.add(mKeyFunctionInfo);
		return baseInfolList;
	}

	/**面板按键 */
	private List<BaseInfo> analyzePanelKey(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		byte data0 = intackBytes[Constant.DATA0];
		byte data1 = intackBytes[Constant.DATA1];
		if (data1 == 1) {
			switch (data0) {
			case 1:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_POWER);break;
			case 2:mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);break;
			case 3:mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);break;
			case 0X24:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);break;
			case 0X28:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_BLUE_PHONE);break;	
			case 0X2F:
			case 0X2B:mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_HOME);break;
			case 0X37:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_SCAN_ALL);break;
			case 0X4B:
			case 0X47:
			case 0X48:mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_COLLEC_RADIO);break;
			}
		}
		baseInfolList.add(mKeyFunctionInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeVertion(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		int dataLength = intackBytes[Constant.LENGTH];
		byte[] dataBytes = new byte[dataLength];
		//System.arraycopy(intackBytes,Constant.DasAutoComID.DATA0, dataBytes, 0, dataLength);
		for (int i = 0; i < dataLength; i++) {
			dataBytes[i] =  (byte)intackBytes[i+Constant.DATA0];
		}
		String boxVertionString = ByteUtil.byteToASCII(dataBytes);
		CarLargeInfo mCarVertion = new CarLargeInfo();
		mCarVertion.setBoxVertion(boxVertionString);
		baseInfolList.add(mCarVertion);
		return baseInfolList;
	}

	/**车身基本信息*/
	private List<BaseInfo> analyzeBaseCar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		//data0 信号有效信息
		byte data0 =intackBytes[Constant.DATA0];
		byte bit3 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT3);
		mCarBaseInfo.setPARK(bit3==1?true:false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT2);
		mCarBaseInfo.setREV(bit2==1?true:false);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT1);
		mCarBaseInfo.setILL(bit1==1?true:false);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT0);
	    mCarBaseInfo.setACC(bit0==1?true:false);
			
		//data2 方向盘按键
		byte data2 =intackBytes[Constant.DATA2];
		analyzeKeyFuction(mKeyFunctionInfo,data2);
		//data3  按键按下
		byte data3 =intackBytes[Constant.DATA3];
		mKeyFunctionInfo.setKeyDown(data3==1?true:false);
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
        case 3:
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
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
		case 0x0a:
		case 0x0b:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		}
	}
	
	private List<BaseInfo> analyzeAirControl(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();

		byte mAirdata0 = intackBytes[Constant.DATA0];
		// data0 
		analyzeData0(mAirConditionInfo, mAirdata0);
		//前窗除雾 
		byte mAirdata1 = intackBytes[Constant.DATA2];
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(mAirdata1,Constant.BIT4);
		mAirConditionInfo.setFrontWindowDemist(bit4==1?true:false);
		// data4 送风模式
		byte mAirdata4 = intackBytes[Constant.DATA4];
		analyzeWindMode(mAirConditionInfo, mAirdata4);
		// data5 风速
		byte mAirdata5 = intackBytes[Constant.DATA5];
		mAirConditionInfo.setLeftWindGrade(mAirdata5);
		mAirConditionInfo.setRightWindGrade(mAirdata5);
		mAirConditionInfo.setWindGradeTotal(8);
		// data6 左边座椅温度设数值 
		byte mAirdata6 = intackBytes[Constant.DATA6];
		float frontLeftSeatSetTemp = analyzeSeatHeatGrade(mAirdata6);
		mAirConditionInfo.setFrontLeftSeatSetTemp(frontLeftSeatSetTemp);
		// data7 右边座椅温度设数值
		byte mAirdata7 = intackBytes[Constant.DATA7];
		float frontRightSeatSetTemp = analyzeSeatHeatGrade( mAirdata7);
		mAirConditionInfo.setFrontRightSeatSetTemp(frontRightSeatSetTemp);
		// data6 车外温度
		byte mAirdata11 = intackBytes[Constant.DATA11];
		mAirConditionInfo.setOutdoorTemp((ByteUtil.convertByteToInt(mAirdata11) / 2.0f - 40));
		
		baseInfolList.add(mAirConditionInfo);
		return baseInfolList;
	}
	
	private float analyzeSeatHeatGrade(byte mAirdata6) {
		float seatHeatGrade = ByteUtil.convertByteToInt(mAirdata6);
		if (seatHeatGrade == 0xFE) {
			seatHeatGrade = Constant.AIR_LOW;
		} else if (seatHeatGrade == 0xFF) {
			seatHeatGrade = Constant.AIR_HIGH;
		} else {
			seatHeatGrade = seatHeatGrade/2;
		}
		return  seatHeatGrade;
		
	}


	private void analyzeWindMode(AirConditionInfo mAirConditionInfo,byte mAirdata4) {
		switch (mAirdata4) {
		// 送风模式 0:关 ，1：自动
		case 0: mAirConditionInfo.setAutoWindMode(false); break;
		case 1: mAirConditionInfo.setAutoWindMode(true); break;
		// 前窗除雾11
		case 2: mAirConditionInfo.setFrontWindowDemist(true); break;
		// 吹脚
		case 3: mAirConditionInfo.setLeftWindBlowFoot(true);  
		        mAirConditionInfo.setRightWindBlowFoot(true);
		break;
		// 吹身吹脚
		case 5: mAirConditionInfo.setLeftWindBlowBody(true); 
		        mAirConditionInfo.setLeftWindBlowFoot(true);  
		        mAirConditionInfo.setRightWindBlowHead(true);
				mAirConditionInfo.setRightWindBlowFoot(true);
		break;
		// 吹身
		case 6: mAirConditionInfo.setLeftWindBlowBody(true); 
		        mAirConditionInfo.setRightWindBlowHead(true);
		break;
		// 吹窗 
		case 0xB:mAirConditionInfo.setLeftWindBlowWindow(true);
		         mAirConditionInfo.setRightWindBlowWindow(true);
		break;
		// 吹窗 吹脚
		case 0xC:mAirConditionInfo.setLeftWindBlowWindow(true);
		         mAirConditionInfo.setLeftWindBlowFoot(true);
		         mAirConditionInfo.setRightWindBlowWindow(true);
				 mAirConditionInfo.setRightWindBlowFoot(true);
		break;
		// 吹窗 吹身
		case 0xD:mAirConditionInfo.setLeftWindBlowWindow(true);
		         mAirConditionInfo.setLeftWindBlowBody(true);  
		         mAirConditionInfo.setRightWindBlowWindow(true);
				 mAirConditionInfo.setRightWindBlowHead(true);
		         break;
		// 吹窗 吹身 吹脚
		case 0xE:mAirConditionInfo.setLeftWindBlowWindow(true);
                 mAirConditionInfo.setLeftWindBlowBody(true);
                 mAirConditionInfo.setLeftWindBlowFoot(true);  
                 mAirConditionInfo.setRightWindBlowWindow(true);
     			 mAirConditionInfo.setRightWindBlowHead(true);
     			 mAirConditionInfo.setRightWindBlowFoot(true);
                 break;
		}
	}

	private void analyzeData0(AirConditionInfo mAirConditionInfo, byte mAirdata) {
		//空调显示
		byte bit7 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT7);
		mAirConditionInfo.setShowAir(bit7==1?true:false);
		//空调开关
		byte bit6 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT6);
		mAirConditionInfo.setSwitchAir(bit6==1?true:false);
		//AUTO
		byte bit3 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT3);
		mAirConditionInfo.setAutoSwitch1(bit3==1?true:false);
		// SYNC
		byte bit2 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT2);
		mAirConditionInfo.setSync(bit2==1?true:false);
		// A/C
		byte bit1 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT0);
		mAirConditionInfo.setAcEnable( (bit1+bit0)==1?true:false );
			
	}
}
