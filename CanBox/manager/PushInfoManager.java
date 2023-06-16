package com.landsem.canbox.manager;

import com.landsem.canbox.AddSelfObserver;
import com.landsem.canbox.HandleBaseInfo;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.AnJiXingInfo;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CDInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CarAlarm;
import com.landsem.canbox.bean.CarLargeInfo;
import com.landsem.canbox.bean.CornerInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.DriveModeInfo;
import com.landsem.canbox.bean.DriverAssistInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.SpeedInfo;
import com.landsem.canbox.bean.MultiFuncInfo;
import com.landsem.canbox.bean.PeripheralInfo;
import com.landsem.canbox.bean.RadarInfo;
import com.landsem.canbox.bean.RoleBean;
import com.landsem.canbox.bean.SetInfo;
import com.landsem.canbox.bean.CSyncInfo;
import com.landsem.canbox.bean.UnitTimeInfo;
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
import com.landsem.canbox.tools.CacheUtils;
import com.landsem.common.tools.LogManager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class PushInfoManager implements HandleBaseInfo, AddSelfObserver {
	
	public BaseObserver mBaseObserver;
	public DoorObserver mDoorObserver;
	public RadarObserver mRadarObserver;
	public CarBaseObserver mCarBaseObserver;
	public CarLargeObserver mCarLargeObserver;
	public CornerObserver mCornerObserver;
	public DriverAssistObserver mDriverAssistObserver;
	public AirConditionObserver mAirConditionObserver;
	public PeripheralObserver mPeripheralObserver;
	public DriveModeObserver mDriveModeObserver;
	public SpeedObserver mSpeedObserver;
	public SetInfoObserver mSetInfoObserver;
	public MultiFuncObserver mMultiFuncObserver;
	public UnitTimeObserver mUnitTimeObserver;
	public SyncInfoObserver mSyncInfoObserver;
	public AnJiXingInfoObserver mAnJiXingInfoObserver;
	public KeyFunctionObserver mKeyFunctionObserver;
	public CDObserver mCDObserver;
	
	private RemotePushHandler mRemotePushHandler;
	
	
	public PushInfoManager(){
		RemotePushRunnable mRemotePushRunnable = new RemotePushRunnable();
		new Thread(mRemotePushRunnable).start();
	}
	

	@Override
	public void onHandleBaseInfo(BaseInfo infoBean) {
		onLocalPushInfo(infoBean);
		doRemotePushInfo(infoBean);
	}

	private void onLocalPushInfo(BaseInfo infoBean) {
		switch (infoBean.getID()) {
		case ID_AIRCONDITION:
			AirConditionInfo mAirConditionInfo = (AirConditionInfo) infoBean;
			CacheUtils.onUpdateAirConditionInfo(mAirConditionInfo);
			if(null!=mAirConditionObserver) mAirConditionObserver.onPushAirConditionInfo(mAirConditionInfo);
			break;
		case ID_CARALARM:
			CarAlarm mCarAlarm = (CarAlarm) infoBean;
			CacheUtils.onUpdateCarAlarm(mCarAlarm);
			if(null!=mCarLargeObserver) mCarLargeObserver.onPushCarAlarm(mCarAlarm);
			break;
		case ID_CARBASE:
			CarBaseInfo mCarBaseInfo = (CarBaseInfo) infoBean;
			CacheUtils.onUpdateCarBaseInfo(mCarBaseInfo);
			if(null!=mCarBaseObserver) mCarBaseObserver.onPushCarBaseInfo(mCarBaseInfo);
			break;
		case ID_CARLARGE:
			CarLargeInfo mCarLargeInfo = (CarLargeInfo) infoBean;
			CacheUtils.onUpdateCarInfo2(mCarLargeInfo);
			if(null!=mCarLargeObserver) mCarLargeObserver.onPushCarLargeInfo(mCarLargeInfo);
			break;
		case ID_CORNER:
			CornerInfo mCornerInfo = (CornerInfo) infoBean;
			CacheUtils.onUpdateCornerInfo(mCornerInfo);
			if(null!=mCornerObserver) mCornerObserver.onPushCornerInfo(mCornerInfo);
			break;
		case ID_DOOR:
			DoorInfo mDoorInfo = (DoorInfo) infoBean;
			CacheUtils.onUpdateDoorInfo(mDoorInfo);
			if(null!=mDoorObserver) mDoorObserver.onPushDoorInfo(mDoorInfo);
			break;
		case ID_DRIVER_ASSIST:
			DriverAssistInfo mAssistInfo = (DriverAssistInfo) infoBean;
			CacheUtils.onUpdateDriverAssistInfo(mAssistInfo);
			if(null!=mDriverAssistObserver) mDriverAssistObserver.onPushDriverAssistInfo(mAssistInfo);
			break;
		case ID_RADAR:
			RadarInfo mRadarInfo = (RadarInfo) infoBean;
			CacheUtils.onUpdateRadarInfo(mRadarInfo);
			if(null!=mRadarObserver) mRadarObserver.onPushRadarInfo(mRadarInfo);
			break;
		case ID_PERIPHERAL:
			PeripheralInfo mPeripheralInfo = (PeripheralInfo) infoBean;
			CacheUtils.onUpdatePeripheralInfo(mPeripheralInfo);
			if(null!=mPeripheralObserver) mPeripheralObserver.onPushPeripheralInfo(mPeripheralInfo);
			break;
		case ID_MULTI_FUNC:
			MultiFuncInfo mMultiFuncInfo = (MultiFuncInfo) infoBean;
			CacheUtils.onUpdateMultiFuncInfo(mMultiFuncInfo);
			if(null!=mMultiFuncObserver) mMultiFuncObserver.onPushMultiFuncInfo(mMultiFuncInfo);
			break;
		case ID_DRIVE_MODE:
			DriveModeInfo mDriveModeInfo = (DriveModeInfo) infoBean;
			CacheUtils.onUpdateDriveModeInfo(mDriveModeInfo);
			if(null!=mDriveModeObserver) mDriveModeObserver.onPushDriveModeInfo(mDriveModeInfo);
			break;
		case ID_UNIT_TIME:
			UnitTimeInfo mUnitTimeInfo = (UnitTimeInfo) infoBean;
			CacheUtils.onUpdateUnitTimeInfo(mUnitTimeInfo);
			if(null!=mUnitTimeObserver) mUnitTimeObserver.onPushUnitTimeInfo(mUnitTimeInfo);
			break;
		case ID_SPEED:
			SpeedInfo mSpeedInfo = (SpeedInfo) infoBean;
			CacheUtils.onUpdateSpeedInfo(mSpeedInfo);
			if(null!=mSpeedObserver) mSpeedObserver.onPushSpeedInfo(mSpeedInfo);
			break;
		case ID_SET:
			SetInfo mSetInfo = (SetInfo) infoBean;
			CacheUtils.onUpdateSetInfo(mSetInfo);
			if(null!=mSetInfoObserver) mSetInfoObserver.onPushSetInfo(mSetInfo);
			break;
		case ID_SYNC:
			CSyncInfo mCSyncInfo = (CSyncInfo) infoBean;
			CacheUtils.onUpdateSyncInfo(mCSyncInfo);
			if(null!=mSyncInfoObserver) mSyncInfoObserver.onPushSyncInfo(mCSyncInfo);
			break;
		case ID_ANJIXING:
			AnJiXingInfo mAnJiXingInfo = (AnJiXingInfo) infoBean;
			CacheUtils.onUpdateAnJiXingInfo(mAnJiXingInfo);
			if(null!=mAnJiXingInfoObserver) mAnJiXingInfoObserver.onPushAnJiXingInfo(mAnJiXingInfo);
			break;
		case ID_KEY_FUCTION:
			KeyFunctionInfo mKeyFunctionInfo = (KeyFunctionInfo) infoBean;
			CacheUtils.onUpdateKeyFunctionInfo(mKeyFunctionInfo);
			if(null!=mKeyFunctionObserver) mKeyFunctionObserver.onPushKeyFunctionInfo(mKeyFunctionInfo);
			break;
		case ID_CD_INFO:
			CDInfo mCDInfo = (CDInfo) infoBean;
			CacheUtils.onUpdateCDInfo(mCDInfo);
			if(null!=mCDObserver) mCDObserver.onPushCDInfo(mCDInfo);
			break;
		default:
			if(null!=mBaseObserver) mBaseObserver.onBaseInofCallback(infoBean);
			break;
		}
	}
	
	private void doRemotePushInfo(BaseInfo infoBean) {
		if(null!=mRemotePushHandler){
			Message msg = mRemotePushHandler.obtainMessage();
			msg.obj = infoBean;
			mRemotePushHandler.sendMessage(msg);
		}
	}
	
	/**
	 * 向其它应用推送Canbox信息（子线程推送）
	 * @author LQPDC
	 */
	private final class RemotePushHandler extends Handler{
		@Override
		public synchronized void handleMessage(Message msg) {
			
			super.handleMessage(msg);
		}
	}
	
	private final class RemotePushRunnable implements Runnable{
		@Override
		public void run() {
			Looper.prepare();
			mRemotePushHandler = new RemotePushHandler();
			Looper.loop();
		}
	}

	@Override
	public void onSetRadarObserver(RadarObserver mObserver, RoleBean mRoleBean) {
		if(null!=mRoleBean){
			this.mRadarObserver = mObserver;
			LogManager.d(mRoleBean.toString());
		}
	}

	@Override
	public void onSetDoorObserver(DoorObserver mObserver, RoleBean mRoleBean) {
		if(null!=mRoleBean){
			this.mDoorObserver = mObserver;
			LogManager.d(mRoleBean.toString());
		}
	}

	@Override
	public void onSetCornerObserver(CornerObserver mObserver, RoleBean mRoleBean) {
		if(null!=mRoleBean){
			this.mCornerObserver = mObserver;
			LogManager.d(mRoleBean.toString());
		}
	}

	@Override
	public void onSetCarBaseObserver(CarBaseObserver mObserver, RoleBean mRoleBean) {
		if(null!=mRoleBean){
			this.mCarBaseObserver = mObserver;
			LogManager.d(mRoleBean.toString());
		}
	}

	@Override
	public void onSetCarLargeObserver(CarLargeObserver mObserver, RoleBean mRoleBean) {
		if(null!=mRoleBean){
			this.mCarLargeObserver = mObserver;
			LogManager.d(mRoleBean.toString());
		}
	}

	@Override
	public void onSetAirConditionObserver(AirConditionObserver mObserver, RoleBean mRoleBean) {
		if(null!=mRoleBean){
			this.mAirConditionObserver = mObserver;
			LogManager.d(mRoleBean.toString());
		}
	}
	
	@Override
	public void onSetDriverAssistObserver(DriverAssistObserver mObserver,
			RoleBean mRoleBean) {
		this.mDriverAssistObserver = mObserver;
	}
	
	@Override
	public void onSetBaseInfoObserver(BaseObserver mObserver, RoleBean mRoleBean) {
		
		this.mBaseObserver = mObserver;
	}
	
	@Override
	public void onSetPeripheralObserver(PeripheralObserver mPeripheralObserver,RoleBean mRoleBean) {
		this.mPeripheralObserver = mPeripheralObserver;
	}

	@Override
	public void onSetDriveModeObserver(DriveModeObserver mDriveModeObserver,
			RoleBean mRoleBean) {
		this.mDriveModeObserver = mDriveModeObserver;
	}

	@Override
	public void onSetSpeedObserver(
			SpeedObserver mSpeedObserver, RoleBean mRoleBean) {
		this.mSpeedObserver = mSpeedObserver;
	}

	@Override
	public void onSetMultiFuncObserver(MultiFuncObserver mMultiFuncObserver,RoleBean mRoleBean) {
		this.mMultiFuncObserver = mMultiFuncObserver;
	}

	@Override
	public void onSetUnitTimeObserver(UnitTimeObserver mUnitTimeObserver,RoleBean mRoleBean) {
		this.mUnitTimeObserver = mUnitTimeObserver;
	}

	@Override
	public void onSetInfoObserver(SetInfoObserver mSetInfoObserver,RoleBean mRoleBean) {
		this.mSetInfoObserver = mSetInfoObserver;
	}

	@Override
	public void onSyncInfoObserver(SyncInfoObserver mSyncInfoObserver,RoleBean mRoleBean) {
		this.mSyncInfoObserver = mSyncInfoObserver;
	}

	@Override
	public void onAnJiXingInfoObserver(AnJiXingInfoObserver mAnJiXingInfoObserver, RoleBean mRoleBean) {
		this.mAnJiXingInfoObserver = mAnJiXingInfoObserver;
	}

	@Override
	public void onKeyFunctionObserver(KeyFunctionObserver mKeyFunctionObserver,RoleBean mRoleBean) {
		this.mKeyFunctionObserver = mKeyFunctionObserver;
	}

	@Override
	public void onCDObserver(CDObserver mCDObserver, RoleBean mRoleBean) {
		this.mCDObserver = mCDObserver;
	}

	
}
