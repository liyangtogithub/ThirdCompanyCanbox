package com.landsem.canboxui.utils;

import com.landsem.canbox.bean.CarAlarm;

public class CarAlarmUtil {

	public static boolean isCarAlarmChange(CarAlarm mCarAlarm,CarAlarm mCarAlarmOld) {
		
		if (mCarAlarmOld==null || mCarAlarm.isLowOilAlarm()!=mCarAlarmOld.isLowOilAlarm()||
			mCarAlarm.isLowVoltageAlarm()!=mCarAlarmOld.isLowVoltageAlarm()||
			mCarAlarm.isSafetyBeltAlarm()!=mCarAlarmOld.isSafetyBeltAlarm()||
			mCarAlarm.isCleaningLiquidAlarm()!=mCarAlarmOld.isCleaningLiquidAlarm() 
			) {
			return true;
		}
		return false;
	}

}
