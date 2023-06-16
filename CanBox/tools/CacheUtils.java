package com.landsem.canbox.tools;

import java.util.ArrayList;
import java.util.List;

import com.landsem.canbox.activity.BaseActivity;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.AnJiXingInfo;
import com.landsem.canbox.bean.CDInfo;
import com.landsem.canbox.bean.CSyncInfo;
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
import com.landsem.canbox.bean.SetInfo;
import com.landsem.canbox.bean.UnitTimeInfo;
import com.landsem.canbox.observer.AirConditionObserver;
import com.landsem.canbox.observer.AnJiXingInfoObserver;
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
import com.landsem.common.tools.ListUtils;

public class CacheUtils {
	
	public static List<BaseActivity> activitys = new ArrayList<BaseActivity>();
	
	
	public static void onAddCache(BaseActivity activity){
		
		activitys.add(activity);
	}
	
	public static void onRemoveCache(BaseActivity activity){
		
		activitys.remove(activity);
	}
	
	public static void onUpdateAirConditionInfo(AirConditionInfo mAirConditionInfo) {
		if(!ListUtils.isEmpty(activitys)){
			for(BaseActivity activity:activitys){
				if(activity instanceof AirConditionObserver){
					((AirConditionObserver) activity).onPushAirConditionInfo(mAirConditionInfo);
				}
			}
		}
	}
	
	public static void onUpdateCarBaseInfo(CarBaseInfo mCarBaseInfo) {
		if(!ListUtils.isEmpty(activitys)){
			for(BaseActivity activity:activitys){
				if(activity instanceof CarBaseObserver){
					((CarBaseObserver) activity).onPushCarBaseInfo(mCarBaseInfo);
				}
			}
		}
	}
	
	public static void onUpdateCarAlarm(CarAlarm mCarAlarm) {
		if(!ListUtils.isEmpty(activitys)){
			for(BaseActivity activity:activitys){
				if(activity instanceof CarLargeObserver){
					((CarLargeObserver) activity).onPushCarAlarm(mCarAlarm);
				}
			}
		}
	}
	
	public static void onUpdateCarInfo2(CarLargeInfo mCarInfo2) {
		if(!ListUtils.isEmpty(activitys)){
			for(BaseActivity activity:activitys){
				if(activity instanceof CarLargeObserver){
					((CarLargeObserver) activity).onPushCarLargeInfo(mCarInfo2);
				}
			}
		}
	}
	
	public static void onUpdateCornerInfo(CornerInfo mCornerInfo) {
		if(!ListUtils.isEmpty(activitys)){
			for(BaseActivity activity:activitys){
				if(activity instanceof CornerObserver){
					((CornerObserver) activity).onPushCornerInfo(mCornerInfo);
				}
			}
		}
	}
	
	public static void onUpdateDoorInfo(DoorInfo mDoorInfo) {
		if(!ListUtils.isEmpty(activitys)){
			for(BaseActivity activity:activitys){
				if(activity instanceof DoorObserver){
					((DoorObserver) activity).onPushDoorInfo(mDoorInfo);
				}
			}
		}
	}
	
	public static void onUpdateRadarInfo(RadarInfo mRadarInfo) {
		if(!ListUtils.isEmpty(activitys)){
			for(BaseActivity activity:activitys){
				if(activity instanceof RadarObserver){
					((RadarObserver) activity).onPushRadarInfo(mRadarInfo);
				}
			}
		}
	}

	public static void onUpdateDriverAssistInfo(DriverAssistInfo mDriverAssistInfo) {
		if(!ListUtils.isEmpty(activitys)){
			for(BaseActivity activity:activitys){
				if(activity instanceof DriverAssistObserver){
					((DriverAssistObserver) activity).onPushDriverAssistInfo(mDriverAssistInfo);
				}
			}
		}
	}
	
	public static void onUpdatePeripheralInfo(PeripheralInfo mPeripheralInfo) {
		if(!ListUtils.isEmpty(activitys)){
			for(BaseActivity activity:activitys){
				if(activity instanceof PeripheralObserver){
					((PeripheralObserver) activity).onPushPeripheralInfo(mPeripheralInfo);
				}
			}
		}
	}
	
	public static void onUpdateDriveModeInfo(DriveModeInfo mDriveModeInfo) {
		if(!ListUtils.isEmpty(activitys)){
			for(BaseActivity activity:activitys){
				if(activity instanceof DriveModeObserver){
					((DriveModeObserver) activity).onPushDriveModeInfo(mDriveModeInfo);
				}
			}
		}
	}
	
	public static void onUpdateSpeedInfo(SpeedInfo mSpeedInfo) {
		if(!ListUtils.isEmpty(activitys)){
			for(BaseActivity activity:activitys){
				if(activity instanceof SpeedObserver){
					((SpeedObserver) activity).onPushSpeedInfo(mSpeedInfo);
				}
			}
		}
	}
	
	public static void onUpdateSetInfo(SetInfo mSetInfo) {
		if(!ListUtils.isEmpty(activitys)){
			for(BaseActivity activity:activitys){
				if(activity instanceof SetInfoObserver){
					((SetInfoObserver) activity).onPushSetInfo(mSetInfo);
				}
			}
		}
	}
	
	public static void onUpdateMultiFuncInfo(MultiFuncInfo mMultiFuncInfo) {
		if(!ListUtils.isEmpty(activitys)){
			for(BaseActivity activity:activitys){
				if(activity instanceof MultiFuncObserver){
					((MultiFuncObserver) activity).onPushMultiFuncInfo(mMultiFuncInfo);
				}
			}
		}
	}
	
	public static void onUpdateUnitTimeInfo(UnitTimeInfo mUnitTimeInfo) {
		if(!ListUtils.isEmpty(activitys)){
			for(BaseActivity activity:activitys){
				if(activity instanceof UnitTimeObserver){
					((UnitTimeObserver) activity).onPushUnitTimeInfo(mUnitTimeInfo);
				}
			}
		}
	}

	public static void onUpdateSyncInfo(CSyncInfo mCSyncInfo) {
		if(!ListUtils.isEmpty(activitys)){
			for(BaseActivity activity:activitys){
				if(activity instanceof SyncInfoObserver){
					((SyncInfoObserver) activity).onPushSyncInfo(mCSyncInfo);
				}
			}
		}
	}

	public static void onUpdateAnJiXingInfo(AnJiXingInfo mAnJiXingInfo) {
		if(!ListUtils.isEmpty(activitys)){
			for(BaseActivity activity:activitys){
				if(activity instanceof AnJiXingInfoObserver){
					((AnJiXingInfoObserver) activity).onPushAnJiXingInfo(mAnJiXingInfo);
				}
			}
		}
	}
	
	public static void onUpdateKeyFunctionInfo(KeyFunctionInfo mKeyFunctionInfo) {
		if(!ListUtils.isEmpty(activitys)){
			for(BaseActivity activity:activitys){
				if(activity instanceof KeyFunctionObserver){
					((KeyFunctionObserver) activity).onPushKeyFunctionInfo(mKeyFunctionInfo);
				}
			}
		}
	}

	public static void onUpdateCDInfo(CDInfo mCDInfo) {
		if(!ListUtils.isEmpty(activitys)){
			for(BaseActivity activity:activitys){
				if(activity instanceof CDObserver){
					((CDObserver) activity).onPushCDInfo(mCDInfo);
				}
			}
		}
	}

}
