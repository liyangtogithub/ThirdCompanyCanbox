package com.landsem.canbox;

import com.landsem.canbox.bean.RoleBean;
import com.landsem.canbox.observer.AirConditionObserver;
import com.landsem.canbox.observer.AnJiXingInfoObserver;
import com.landsem.canbox.observer.BaseObserver;
import com.landsem.canbox.observer.CDObserver;
import com.landsem.canbox.observer.CarBaseObserver;
import com.landsem.canbox.observer.CarLargeObserver;
import com.landsem.canbox.observer.CornerObserver;
import com.landsem.canbox.observer.DoorObserver;
import com.landsem.canbox.observer.DriveModeObserver;
import com.landsem.canbox.observer.DriverAssistObserver;
import com.landsem.canbox.observer.KeyFunctionObserver;
import com.landsem.canbox.observer.SpeedObserver;
import com.landsem.canbox.observer.MultiFuncObserver;
import com.landsem.canbox.observer.PeripheralObserver;
import com.landsem.canbox.observer.RadarObserver;
import com.landsem.canbox.observer.SetInfoObserver;
import com.landsem.canbox.observer.SyncInfoObserver;
import com.landsem.canbox.observer.UnitTimeObserver;

public interface AddSelfObserver {
	
	void onSetRadarObserver(RadarObserver mObserver, RoleBean mRoleBean);
	void onSetDoorObserver(DoorObserver mObserver, RoleBean mRoleBean);
	void onSetCornerObserver(CornerObserver mObserver, RoleBean mRoleBean);
	void onSetCarBaseObserver(CarBaseObserver mObserver, RoleBean mRoleBean);
	void onSetCarLargeObserver(CarLargeObserver mObserver, RoleBean mRoleBean);
	void onSetAirConditionObserver(AirConditionObserver mObserver, RoleBean mRoleBean);
	void onSetDriverAssistObserver(DriverAssistObserver mObserver, RoleBean mRoleBean);
	void onSetBaseInfoObserver(BaseObserver mObserver, RoleBean mRoleBean);
	void onSetPeripheralObserver(PeripheralObserver mPeripheralObserver, RoleBean mRoleBean);
	void onSetDriveModeObserver(DriveModeObserver mDriveModeObserver, RoleBean mRoleBean);
	void onSetSpeedObserver(SpeedObserver mSpeedObserver, RoleBean mRoleBean);
	void onSetMultiFuncObserver(MultiFuncObserver mMultiFuncObserver, RoleBean mRoleBean);
	void onSetUnitTimeObserver(UnitTimeObserver mUnitTimeObserver, RoleBean mRoleBean);
	void onSetInfoObserver(SetInfoObserver mSetInfoObserver, RoleBean mRoleBean);
	void onSyncInfoObserver(SyncInfoObserver mSyncInfoObserver, RoleBean mRoleBean);
	void onAnJiXingInfoObserver(AnJiXingInfoObserver mAnJiXingInfoObserver, RoleBean mRoleBean);
	void onKeyFunctionObserver(KeyFunctionObserver mKeyFunctionObserver, RoleBean mRoleBean);
	void onCDObserver(CDObserver mCDObserver, RoleBean mRoleBean);
}
