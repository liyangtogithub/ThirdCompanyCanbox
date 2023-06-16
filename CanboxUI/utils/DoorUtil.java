package com.landsem.canboxui.utils;

import com.landsem.canbox.bean.DoorInfo;

public class DoorUtil {
    
	

	public static boolean isDoorChange(DoorInfo mDoorInfo, DoorInfo mOldDoorInfo) {
		if (null == mOldDoorInfo) {
			return true;
		}
		if (mDoorInfo.isDriverDoor()!=mOldDoorInfo.isDriverDoor()) {
			return true;
		}else if (mDoorInfo.isPassengerDoor()!=mOldDoorInfo.isPassengerDoor()) {
			return true;
		}else if (mDoorInfo.isLeftBackDoor()!=mOldDoorInfo.isLeftBackDoor()) {
			return true;
		}else if (mDoorInfo.isRightBackDoor()!=mOldDoorInfo.isRightBackDoor()) {
			return true;
		}else if (mDoorInfo.isEngineHood()!=mOldDoorInfo.isEngineHood()) {
			return true;
		}else if (mDoorInfo.isBackTrunk()!=mOldDoorInfo.isBackTrunk()) {
			return true;
		}
		return false;
	}

	public static boolean isAllClosed(DoorInfo mDoorInfo) {
		if (!mDoorInfo.isDriverDoor() && !mDoorInfo.isPassengerDoor() && !mDoorInfo.isLeftBackDoor()
				&& !mDoorInfo.isRightBackDoor() && !mDoorInfo.isEngineHood() && !mDoorInfo.isBackTrunk()) {
			return true;
		}
		return false;
	}

	
}
