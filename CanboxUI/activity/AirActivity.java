package com.landsem.canboxui.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.landsem.canbox.activity.BaseActivity;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.observer.AirConditionObserver;
import com.landsem.canboxui.utils.ConstantUtil;
import com.landsem.canboxui.view.AirView;
import com.landsem.common.tools.LogManager;

public class AirActivity  extends BaseActivity implements AirConditionObserver{
	
	Context mContext;
	AirView mAirView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		initShowView();
	}
	
	private void initShowView() {
		mAirView = new AirView(this);
	}
	
	Handler updateUIHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case ConstantUtil.MESSAGE_AIR:
				if (null != mAirView) {
					mAirView.displayAirState((AirConditionInfo) msg.obj);
				}
				break;
			}
		}
	};
	

	@Override
	public void onPushAirConditionInfo(AirConditionInfo mAirConditionInfo) {
		String showAirString = "";
		showAirString = "空调显示 " + mAirConditionInfo.isShowAir() + " 、空调开 "
				+ mAirConditionInfo.isSwitchAir() + "、外循环模式 ："
				+ mAirConditionInfo.isCircleOut() + "、Auto "
				+ mAirConditionInfo.isAutoSwitch1() + "、  A/C "
				+ mAirConditionInfo.isAcEnable() + "、后窗除雾 "
				+ mAirConditionInfo.isBackWindowDemist() + "、  前窗除雾 "
				+ mAirConditionInfo.isFrontWindowDemist() + "、右边座椅加热等级 "
				+ mAirConditionInfo.getRightSeatHeatGrade() + "、  左边座椅加热等级 "+ 
				mAirConditionInfo.getLeftSeatHeatGrade()  ;
				LogManager.d(showAirString);
				
				showAirString = "左温度值 "
				+ mAirConditionInfo.getFrontLeftSeatSetTemp() + "、  右温度值 "
				+ mAirConditionInfo.getFrontRightSeatSetTemp() 
				+ "、左吹风:吹脚 " + mAirConditionInfo.isLeftWindBlowFoot()
				+ " 、左吹风:吹身  " + mAirConditionInfo.isLeftWindBlowBody()
				+ "、左吹风:吹窗 " + mAirConditionInfo.isLeftWindBlowWindow()
				+ " 、左风速等级  " + mAirConditionInfo.getLeftWindGrade()  
				+ "、右吹风:吹脚 " + mAirConditionInfo.isRightWindBlowFoot()
				+ " 、右吹风:吹身 " + mAirConditionInfo.isRightWindBlowBody()
				+ "、右吹风:吹窗 " + mAirConditionInfo.isRightWindBlowWindow()
				+ " 、右风速等级  " + mAirConditionInfo.getRightWindGrade() 
				;
		LogManager.d(showAirString);
		showMessageObject(mAirConditionInfo, ConstantUtil.MESSAGE_AIR);
	}
	
	private void showMessageObject(Object obj, int what) {
		Message msg = updateUIHandler.obtainMessage();
		msg.obj = obj;
		msg.what = what;
		updateUIHandler.sendMessage(msg);
	}

}
