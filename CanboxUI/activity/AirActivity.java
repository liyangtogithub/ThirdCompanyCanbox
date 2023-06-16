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
		showAirString = "�յ���ʾ " + mAirConditionInfo.isShowAir() + " ���յ��� "
				+ mAirConditionInfo.isSwitchAir() + "����ѭ��ģʽ ��"
				+ mAirConditionInfo.isCircleOut() + "��Auto "
				+ mAirConditionInfo.isAutoSwitch1() + "��  A/C "
				+ mAirConditionInfo.isAcEnable() + "���󴰳��� "
				+ mAirConditionInfo.isBackWindowDemist() + "��  ǰ������ "
				+ mAirConditionInfo.isFrontWindowDemist() + "���ұ����μ��ȵȼ� "
				+ mAirConditionInfo.getRightSeatHeatGrade() + "��  ������μ��ȵȼ� "+ 
				mAirConditionInfo.getLeftSeatHeatGrade()  ;
				LogManager.d(showAirString);
				
				showAirString = "���¶�ֵ "
				+ mAirConditionInfo.getFrontLeftSeatSetTemp() + "��  ���¶�ֵ "
				+ mAirConditionInfo.getFrontRightSeatSetTemp() 
				+ "���󴵷�:���� " + mAirConditionInfo.isLeftWindBlowFoot()
				+ " ���󴵷�:����  " + mAirConditionInfo.isLeftWindBlowBody()
				+ "���󴵷�:���� " + mAirConditionInfo.isLeftWindBlowWindow()
				+ " ������ٵȼ�  " + mAirConditionInfo.getLeftWindGrade()  
				+ "���Ҵ���:���� " + mAirConditionInfo.isRightWindBlowFoot()
				+ " ���Ҵ���:���� " + mAirConditionInfo.isRightWindBlowBody()
				+ "���Ҵ���:���� " + mAirConditionInfo.isRightWindBlowWindow()
				+ " ���ҷ��ٵȼ�  " + mAirConditionInfo.getRightWindGrade() 
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
