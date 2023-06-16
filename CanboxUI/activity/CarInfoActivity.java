package com.landsem.canboxui.activity;

import com.landsem.canbox.activity.BaseActivity;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.CarAlarm;
import com.landsem.canbox.bean.CarLargeInfo;
import com.landsem.canbox.observer.AirConditionObserver;
import com.landsem.canbox.observer.CarLargeObserver;
import com.landsem.canboxui.utils.ConstantUtil;
import com.landsem.canboxui.view.CarInfoView;
import com.landsem.common.tools.LogManager;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

public class CarInfoActivity extends BaseActivity implements AirConditionObserver, 
		 CarLargeObserver {

	String TAG = "OilInfo";
	String showAirString = "";
	String car2String = "";

	Context mContext;
	
	CarInfoView mMainView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		initShowView();
		mMainView.displayCarLargeInfo(null);
	}

	private void initShowView() {
		mMainView = new CarInfoView(this);
	}

	@Override
	public void onPushCarAlarm(CarAlarm mCarAlarm) {
	}
	@Override
	public void onPushCarLargeInfo(CarLargeInfo mCarLargeInfo) {
		// 车辆信息2
		car2String = "剩余油量:" + mCarLargeInfo.getSurplusOil()+"、瞬时油耗"+mCarLargeInfo.getInstantFuel()
				   + "、平均油耗： "+ mCarLargeInfo.getAverageFuel()+"总行驶里程:" + mCarLargeInfo.getMileage()
				   +"续航里程:" + mCarLargeInfo.getEnduranceMileage()+"\r\n"
				   +"、瞬时车速："+ mCarLargeInfo.getInstantSpeed()+"、发动机转速"+mCarLargeInfo.getRotateSpeed()
				   +"、电池电压："+ mCarLargeInfo.getVoltage();
		showMessageObject(mCarLargeInfo, ConstantUtil.MESSAGE_CAR_LARGE);
		LogManager.d(TAG,car2String);
	}
	
	@Override
	public void onPushAirConditionInfo(AirConditionInfo mAirConditionInfo) {
		
		showAirString = "室外温度： " + mAirConditionInfo.getOutdoorTemp();
		LogManager.d(TAG,showAirString);
		showMessageObject(mAirConditionInfo, ConstantUtil.MESSAGE_AIR);
	}

	private void showMessageObject(Object obj, int what) {
		Message msg = updateUIHandler.obtainMessage();
		msg.obj = obj;
		msg.what = what;
		updateUIHandler.sendMessage(msg);
	}
	
	Handler updateUIHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case ConstantUtil.MESSAGE_CAR_LARGE:
				if (null != mMainView) {
					mMainView.displayCarLargeInfo((CarLargeInfo) msg.obj);
				}
				break;
			case ConstantUtil.MESSAGE_AIR:
				if (null != mMainView) {
					mMainView.displayAirInfo((AirConditionInfo) msg.obj);
				}
				break;
			}
		}
	};
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
	}

}
