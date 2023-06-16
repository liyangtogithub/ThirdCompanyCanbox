package com.landsem.canboxui.dialog;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.landsem.canbox.bean.CarAlarm;
import com.landsem.canboxui.R;
import com.landsem.canboxui.activity.CarInfoActivity;
import com.landsem.canboxui.utils.ConstantUtil;
import com.landsem.common.tools.LogManager;

public class AlarmNotify {
	static NotificationManager manager ;
	static Context mContext;
	public static final int NULL_NOTIFY = 0;
	
	public static void notifyAlarm(CarAlarm mCarAlarm,Context mCt ) {
		mContext = mCt;
		// 油量过低报警
		if (mCarAlarm.isLowOilAlarm()) {
			notificationMethod(R.drawable.alarm_low_oil,mContext.getString(R.string.alarm_low_oil),mContext);
		}else if (null != manager) {
			manager.cancel(R.drawable.alarm_low_oil);
		}
		//电压过低报警
		if (mCarAlarm.isLowVoltageAlarm()) {
			notificationMethod(R.drawable.alarm_low_voltage,mContext.getString(R.string.alarm_low_voltage),mContext);
		}else if (null != manager) {
			manager.cancel(R.drawable.alarm_low_voltage);
		}
		//安全带报警
		if (mCarAlarm.isSafetyBeltAlarm()) {
			notificationMethod(R.drawable.alarm_safety_belt,mContext.getString(R.string.alarm_safety_belt),mContext);
		}else if (null != manager) {
			manager.cancel(R.drawable.alarm_safety_belt);
		}
		//清洗液报警
		if (mCarAlarm.isCleaningLiquidAlarm()) {
			notificationMethod(R.drawable.alarm_cleaning_liquid,mContext.getString(R.string.alarm_cleaning_liquid),mContext);
		}else if (null != manager) {
			manager.cancel(R.drawable.alarm_cleaning_liquid);
		}
	}
	
	public static void notificationMethod(int drawableId ,String tickerText,Context mCt ) {  
	      manager = (NotificationManager) mCt.getSystemService(Context.NOTIFICATION_SERVICE); 
	      PendingIntent pendingIntent = PendingIntent.getActivity(mCt, 0,  
                  new Intent(mCt, CarInfoActivity.class), 0);  
	      Notification notify1 = new Notification(); 
	      
          notify1.icon = (drawableId==NULL_NOTIFY?NULL_NOTIFY:drawableId);  
          notify1.tickerText = tickerText;  
          notify1.when = System.currentTimeMillis();  
          notify1.setLatestEventInfo(mCt, "",  "", pendingIntent); 
          notify1.number = 1;  
          if (drawableId!=NULL_NOTIFY) {
        	  notify1.defaults=Notification.DEFAULT_SOUND;
		  }
          notify1.flags |= Notification.FLAG_AUTO_CANCEL;   
          manager.notify(drawableId, notify1);
	  }
}
