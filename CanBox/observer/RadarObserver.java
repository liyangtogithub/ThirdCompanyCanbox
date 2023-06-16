package com.landsem.canbox.observer;

import com.landsem.canbox.bean.RadarInfo;

public interface RadarObserver {
	
	void onPushRadarInfo(RadarInfo mRadarInfo);

}
