package com.landsem.canbox.observer;

import com.landsem.canbox.bean.CarAlarm;
import com.landsem.canbox.bean.CarLargeInfo;

public interface CarLargeObserver {
	
	void onPushCarAlarm(CarAlarm mCarAlarm);
	void onPushCarLargeInfo(CarLargeInfo mCarLargeInfo);
}
