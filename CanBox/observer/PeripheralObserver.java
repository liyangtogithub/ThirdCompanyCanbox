package com.landsem.canbox.observer;

import com.landsem.canbox.bean.PeripheralInfo;

public interface PeripheralObserver {
	
	void onPushPeripheralInfo(PeripheralInfo mLightInfo);

}
