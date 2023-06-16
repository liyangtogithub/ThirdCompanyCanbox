package com.landsem.canbox.comparse.hiworld;

import java.util.ArrayList;
import java.util.List;
import android.view.KeyEvent;
import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CarAlarm;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.DriverAssistInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.RadarInfo;
import com.landsem.canbox.tools.ByteUtil;
/**
 * TODO 大众 模块上行(协议盒->DVD主机)数据的解析处理类
 * 
 *@author LiYang,Power by Landsem @ShenZhen
 *Create Time:Mar 20, 2017 3:11:18 PM 
 *
 */
public class DasAutoParse extends HiworldBaseParse1  {
	
	public DasAutoParse() {
		super((byte) 0xFF, (byte) 0xAA, (byte) 0x55);
	}
	DriverAssistInfo mDriverAssistInfo = new DriverAssistInfo();

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		String readMsg = ByteUtil.onPrintByteArray(intackBytes, "DasAutoParse--data: ");
//		BaseActivity.sendBroadcastToActivity(readMsg);
		byte comID = intackBytes[Constant.COMID];
	//	byte length = intackBytes[Constant.DasAutoComID.LENGTH];
		switch (comID) {
		case Constant.DasAutoComID.COMID_INFO_BASE_CAR:
			return analyzeBaseCar( intackBytes);
		case Constant.DasAutoComID.COMID_INFO_AIR_CONDITION:
			return analyzeAirControl( intackBytes);
//		case Constant.DasAutoComID.COMID_INFO_SOFT_VERSION:
//			return analyzeVertion(intackBytes);
//		case Constant.DasAutoComID.COMID_INFO_SYSTEM_SETTING:
//			return analyzeSystemSetting(intackBytes);
		case Constant.DasAutoComID.COMID_INFO_CAR_DEFINITE1:
			return analyzeCarDefinite1(intackBytes);
		case Constant.DasAutoComID.COMID_INFO_CAR_DEFINITE2:
			return analyzeCarDefinite2(intackBytes);
//		case Constant.DasAutoComID.COMID_INFO_RADAR:
//			return analyzeRadar(intackBytes);
		}
		
		return null;
	}
	
	private List<BaseInfo> analyzeCarDefinite2(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		//行驶里程最高位+中间位+最低位
		byte high = intackBytes[Constant.DATA0];
		byte mid =  intackBytes[Constant.DATA1];
		byte low =  intackBytes[Constant.DATA2];
		int mileage = ByteUtil.HighMidLowByteToInt( high,mid,low );
		mCarLargeInfo.setMileage(mileage);
		//发动机转速 最高位+最低位
		byte speedHigh = intackBytes[Constant.DATA8];
		byte speedLow =  intackBytes[Constant.DATA9];
		int rotateSpeed = ByteUtil.HighLowByteToInt( speedHigh,speedLow );
		mCarLargeInfo.setRotateSpeed(rotateSpeed);
		
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeCarDefinite1(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		CarAlarm mCarAlarm = new CarAlarm();
		//瞬时油耗
		byte pointFront = intackBytes[Constant.DATA3];
		byte pointBack = intackBytes[Constant.DATA4];
		if (pointFront<0||pointFront>99) {
			pointFront = 99;
		}
		if (pointBack<0||pointBack>99) {
			pointBack = 99;
		}
		String instantFuel = ByteUtil.convertByteToInt(pointFront)+"."+ByteUtil.convertByteToInt(pointBack);
		mCarLargeInfo.setInstantFuel(instantFuel);
		//清洗液报警
//		byte alarmBytes = intackBytes[Constant.DATA6];
//		byte bit4 = ByteUtil.onCheckOutBitAtIndex( alarmBytes,Constant.BIT4);
//		mCarAlarm.setCleaningLiquidAlarm(bit4==1?true:false);
//		//安全带报警
//		byte bit5 = ByteUtil.onCheckOutBitAtIndex( alarmBytes,Constant.BIT5);
//		mCarAlarm.setSafetyBeltAlarm(bit5==1?true:false);
//		//电池电压过低报警
//		byte bit6 = ByteUtil.onCheckOutBitAtIndex( alarmBytes,Constant.BIT6);
//		mCarAlarm.setLowVoltageAlarm(bit6==1?true:false);
//		//油量过低报警
//		byte bit7 = ByteUtil.onCheckOutBitAtIndex( alarmBytes,Constant.BIT7);
//		mCarAlarm.setLowOilAlarm(bit7==1?true:false);
		//剩余油量
		byte surplusOilBytes = intackBytes[Constant.DATA7];
		mCarLargeInfo.setSurplusOil(ByteUtil.convertByteToInt(surplusOilBytes));
		//电池电压前半部分+后半部分
		byte VoltageFront = intackBytes[Constant.DATA8];
		byte VoltageBack = intackBytes[Constant.DATA9];
		if (VoltageFront<0||VoltageFront>99) {
			VoltageFront = 99;
		}
		if (VoltageBack<0||VoltageBack>99) {
			VoltageBack = 99;
		}
		String VoltagesString = ByteUtil.convertByteToInt(VoltageFront)+"."+ByteUtil.convertByteToInt(VoltageBack);
		mCarLargeInfo.setVoltage(VoltagesString);
		baseInfolList.add(mCarLargeInfo);
//		baseInfolList.add(mCarAlarm);
		return baseInfolList;
	}

//	private List<BaseInfo> analyzeRadar(Byte[] intackBytes) {
//		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
//		mRadarInfo.setRightFrontValue(ByteUtil.convertByteToInt(intackBytes[Constant.DATA0]));
//		mRadarInfo.setRightMidFrontValue(ByteUtil.convertByteToInt(intackBytes[Constant.DATA1]));
//		mRadarInfo.setRightMidBackValue(ByteUtil.convertByteToInt(intackBytes[Constant.DATA2]));
//		mRadarInfo.setRightBackValue(ByteUtil.convertByteToInt(intackBytes[Constant.DATA3]));
//		mRadarInfo.setLeftFrontValue(ByteUtil.convertByteToInt(intackBytes[Constant.DATA4]));
//		mRadarInfo.setLeftMidFrontValue(ByteUtil.convertByteToInt(intackBytes[Constant.DATA5]));
//		mRadarInfo.setLeftMidBackValue(ByteUtil.convertByteToInt(intackBytes[Constant.DATA6])); 
//		mRadarInfo.setLeftBackValue(ByteUtil.convertByteToInt(intackBytes[Constant.DATA7]));
//		baseInfolList.add(mRadarInfo);
//		return baseInfolList;
//	}

	private List<BaseInfo> analyzeSystemSetting(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte systemSettingBytes = intackBytes[Constant.DATA13];
		byte bit5 = ByteUtil.onCheckOutBitAtIndex( systemSettingBytes,Constant.BIT5);
		mDriverAssistInfo.setRadarMute(bit5==1?true:false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex( systemSettingBytes,Constant.BIT6);
		mDriverAssistInfo.setStopInGarage(bit6==1?true:false);
		byte bit7 = ByteUtil.onCheckOutBitAtIndex( systemSettingBytes,Constant.BIT7);
		mDriverAssistInfo.setStopRoadSide(bit7==1?true:false);
		baseInfolList.add(mDriverAssistInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeVertion(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		int dataLength = intackBytes[Constant.LENGTH];
		byte[] dataBytes = new byte[dataLength];
		for (int i = 0; i < dataLength; i++) {
			dataBytes[i] =  (byte)intackBytes[i+Constant.DATA0];
		}
		String boxVertionString = ByteUtil.byteToASCII(dataBytes);
		mCarLargeInfo.setBoxVertion(boxVertionString);
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
		byte bit4 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT4);
		mCarBaseInfo.setKeyInValidity(bit4==1?true:false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT5);
		mCarBaseInfo.setRadarValidity(bit5==1?true:false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex( data0,Constant.BIT6);
		mCarBaseInfo.setBluetooth(bit6==1?true:false);
		//data1 车速
		byte data1 =intackBytes[Constant.DATA1];
		mCarLargeInfo.setInstantSpeed( ByteUtil.convertByteToInt(data1));
		//data2 方向盘按键
		byte data2 =intackBytes[Constant.DATA2];
		analyzeKeyFuction(mKeyFunctionInfo,data2);
		//data3  灯光
		byte data3 =intackBytes[Constant.DATA3];
		mCarBaseInfo.setLightValue(data3);
		//data4  方向盘左转转角
		byte data4 =intackBytes[Constant.DATA4];
		int leftCor = ByteUtil.convertByteToInt(data4)*2;
		if (leftCor==0) {
			leftCor = PROTOCAL_INVALID_VALUE;
		}
		mCornerInfo.setLeftCorner((leftCor>0)?(-leftCor):leftCor);
		//data5  方向盘右转转角
		byte data5 =intackBytes[Constant.DATA5];
		int rightCor = ByteUtil.convertByteToInt(data5)*2;
		if (rightCor==0) {
			rightCor = PROTOCAL_INVALID_VALUE;
		}
		mCornerInfo.setRightCorner(rightCor);
		//data6  后左雷达
		byte data6 = intackBytes[Constant.DATA6];
		mRadarInfo.setBackLeftValue(ByteUtil.convertByteToInt(data6));
		// data7 后中左雷达
		byte data7 = intackBytes[Constant.DATA7];
		mRadarInfo.setBackMidLeftValue(ByteUtil.convertByteToInt(data7));
		// data8 后中右雷达
		byte data8 = intackBytes[Constant.DATA8];
		mRadarInfo.setBackMidRightValue(ByteUtil.convertByteToInt(data8));
		// data9 后右雷达
		byte data9 = intackBytes[Constant.DATA9];
		mRadarInfo.setBackRightValue(ByteUtil.convertByteToInt(data9));
		// data10 前左雷达
		byte data10 = intackBytes[Constant.DATA10];
		mRadarInfo.setFrontLeftValue(ByteUtil.convertByteToInt(data10));
		// data11 前中左雷达
		byte data11 = intackBytes[Constant.DATA11];
		mRadarInfo.setFrontMidLeftValue(ByteUtil.convertByteToInt(data11));
		// data12 前中右雷达
		byte data12 = intackBytes[Constant.DATA12];
		mRadarInfo.setFrontMidRightValue(ByteUtil.convertByteToInt(data12));
		// data13 前右雷达
		byte data13 = intackBytes[Constant.DATA13];
		mRadarInfo.setFrontRightValue(ByteUtil.convertByteToInt(data13));

		baseInfolList.add(mCarBaseInfo);
		baseInfolList.add(mCornerInfo);
		baseInfolList.add(mRadarInfo);
		baseInfolList.add(mKeyFunctionInfo);
		baseInfolList.add(mCarLargeInfo);
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
		case 10:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		default:
			break;
		}
	}
	
	private List<BaseInfo> analyzeAirControl(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte mAirdata0 = intackBytes[Constant.DATA0];
		// data0 图标
		analyzeIcon0(mAirConditionInfo, mAirdata0);
		// data1 图标
		byte mAirdata1 = intackBytes[Constant.DATA1];
		analyzeIcon1(mAirConditionInfo, mAirdata1);
		// data2 前排左座椅温度设数值
		byte mAirdata2 = intackBytes[Constant.DATA2];
		if (mAirdata2 == 0) {
			mAirdata2 = Constant.AIR_NONE;
		} else if (mAirdata2 == 1) {
			mAirdata2 = Constant.AIR_LOW;
		} else if (mAirdata2 == -1) {
			mAirdata2 = Constant.AIR_HIGH;
		}
		mAirConditionInfo.setFrontLeftSeatSetTemp(mAirdata2);
		// data3 前排右座椅温度设数值
		byte mAirdata3 = intackBytes[Constant.DATA3];
		if (mAirdata3 == 0) {
			mAirdata3 = Constant.AIR_NONE;
		} else if (mAirdata3 == 1) {
			mAirdata3 = Constant.AIR_LOW;
		} else if (mAirdata3 == -1) {
			mAirdata3 = Constant.AIR_HIGH;
		}
		mAirConditionInfo.setFrontRightSeatSetTemp(mAirdata3);
		// data4 左吹风
		byte mAirdata4 = intackBytes[Constant.DATA4];
		analyzeLeftWind(mAirConditionInfo, mAirdata4);
		// data5 右吹风
		byte mAirdata5 = intackBytes[Constant.DATA5];
		analyzeRightWind(mAirConditionInfo, mAirdata5);
		// data6 车外温度
		byte mAirdata6 = intackBytes[Constant.DATA6];
		mAirConditionInfo.setOutdoorTemp((ByteUtil.convertByteToInt(mAirdata6) *0.5f - 40));
		// data7 门状态
		byte mAirdata7 = intackBytes[Constant.DATA7];
		analyzeDoorInfo(baseInfolList, mAirdata7);
		baseInfolList.add(mAirConditionInfo);
		return baseInfolList;
	}


	private void analyzeIcon0(AirConditionInfo mAirConditionInfo, byte mAirdata) {
			//AUTO2
			byte bit0 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT0);
			mAirConditionInfo.setAutoSwitch2(bit0==1?true:false);
			// A/C-MAX
			byte bit1 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT1);
			mAirConditionInfo.setAcMaxSwitch(bit1==1?true:false);
			// DUAL
			byte bit2 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT2);
			mAirConditionInfo.setDualSwitch(bit2==1?true:false);
			//AUTO
			byte bit3 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT3);
			mAirConditionInfo.setAutoSwitch1(bit3==1?true:false);
			//循环模式
			byte bit4 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT4);
			byte bit5 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT5);
			mAirConditionInfo.setCircleOut( (bit4+bit5*2)==0 );
			//空调开关
			byte bit6 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT6);
			mAirConditionInfo.setSwitchAir(bit6==1?true:false);
			//空调显示
			byte bit7 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT7);
			mAirConditionInfo.setShowAir(bit7==1?true:false);
	}

	private void analyzeIcon1(AirConditionInfo mAirConditionInfo,byte mAirdata) {
			//左边座椅加热等级
			byte bit0 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT0);
			byte bit1 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT1);
			mAirConditionInfo.setLeftSeatHeatGrade( (bit1*2+bit0) );
			// 右边座椅加热等级
			byte bit2 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT2);
			byte bit3 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT3);
			mAirConditionInfo.setRightSeatHeatGrade( (bit3*2+bit2) );
			//前窗除雾
			byte bit4 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT4);
			mAirConditionInfo.setFrontWindowDemist(bit4==1?true:false);
			//后窗除雾
			byte bit5 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT5);
			mAirConditionInfo.setBackWindowDemist(bit5==1?true:false);
			//  A/C
			byte bit6 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT6);
			mAirConditionInfo.setAcEnable(bit6==1?true:false);
			// 后区空调使能
			byte bit7 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT7);
			mAirConditionInfo.setBackAirEnable(bit7==1?true:false);
	}

	private void analyzeDoorInfo(List<BaseInfo> baseInfolList, byte mAirdata) {
		byte bit0 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT0);
		mDoorInfo.setValid(bit0==1?true:false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT2);
		mDoorInfo.setEngineHood(bit2==1?true:false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT3);
		mDoorInfo.setBackTrunk( bit3==1?true:false );
		byte bit4 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT4);
		mDoorInfo.setRightBackDoor(bit4==1?true:false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT5);
		mDoorInfo.setLeftBackDoor( bit5==1?true:false );
		byte bit6 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT6);
		mDoorInfo.setDriverDoor( bit6==1?true:false );
		byte bit7 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT7);
		mDoorInfo.setPassengerDoor( bit7==1?true:false );
		baseInfolList.add(mDoorInfo);
	}

	private void analyzeRightWind(AirConditionInfo mAirConditionInfo,
			byte mAirdata) {
		byte bit0 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT0);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT1);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT2);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT3);
		mAirConditionInfo.setRightWindGrade( (byte)(bit0+bit1*2+bit2*4+bit3*8) );
		byte bit4 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT4);
		mAirConditionInfo.setRightWindBlowWindow(bit4==1?true:false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT5);
		mAirConditionInfo.setRightWindBlowBody( bit5==1?true:false );
		byte bit6 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT6);
		mAirConditionInfo.setRightWindBlowFoot( bit6==1?true:false );
	}

	private void analyzeLeftWind(AirConditionInfo mAirConditionInfo,byte mAirdata) {
		byte bit0 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT0);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT1);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT2);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT3);
		mAirConditionInfo.setLeftWindGrade( (byte)(bit0+bit1*2+bit2*4+bit3*8) );
		byte bit4 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT4);
		mAirConditionInfo.setLeftWindBlowWindow(bit4==1?true:false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT5);
		mAirConditionInfo.setLeftWindBlowBody( bit5==1?true:false );
		byte bit6 = ByteUtil.onCheckOutBitAtIndex( mAirdata,Constant.BIT6);
		mAirConditionInfo.setLeftWindBlowFoot( bit6==1?true:false );
	}

}
