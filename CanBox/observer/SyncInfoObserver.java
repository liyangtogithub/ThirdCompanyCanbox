package com.landsem.canbox.observer;

import com.landsem.canbox.bean.CSyncInfo;

public interface SyncInfoObserver {
	
	void onPushSyncInfo(CSyncInfo mSyncInfo);

}
