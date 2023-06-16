package com.landsem.canboxui.view;

import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.CarLargeInfo;
import com.landsem.canboxui.R;
import com.landsem.common.tools.LogManager;
import com.landsem.common.tools.StringUtils;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

public class CarInfoView {

	private Activity mActivity;
	
	/*** ʣ������*/
	InstantOilItemView instantOil ;
	/*** ��ʱ�ͺ�*/
	InstantOilItemView surplusOil;
	/*** ƽ���ͺ�*/
	InstantOilItemView averageOil;
	/*** ��̱�*/
	MilesItemView miv;
	/*** ˲ʱ����*/
	InstantOilItemView instantSpeedItemView;
	/*** �������ٶ�*/
	InstantOilItemView engineSpeed;
	/*** ���״̬*/
	InstantOilItemView batteryState;
	/***����¶�*/
	WaterTankTempItemView waterTankTemp;
	/*** ʣ������*/
	int mSurplusOil = Constant.PROTOCAL_INVALID_VALUE;
	/*** ˲ʱ�ͺ�*/
	private String instantFuel ;
	/***ƽ���ͺ�*/
	private float averageFuel = Constant.PROTOCAL_INVALID_VALUE;
	/**** ��ʻ��� */
	private float mileage = Constant.PROTOCAL_INVALID_VALUE;
	/***�������*/
	private int enduranceMileage = Constant.PROTOCAL_INVALID_VALUE;
	/****˲ʱ���� */
	private int instantSpeed  = Constant.PROTOCAL_INVALID_VALUE;
	/*** ������ת��*/
	private int rotateSpeed = Constant.PROTOCAL_INVALID_VALUE;
	/***��� ��ѹ*/
	private String voltage;
	/*** �����¶�*/
	private float outdoorTemp = Constant.PROTOCAL_INVALID_VALUE;
	/****�ͺĵ�λ */
	private String oilUnit = "L/100km";
	/****��̵�λ*/
	private String distanceUnit = "km" ;
	/****�ٶȵ�λ*/
	private String speedUnit = "km/h" ;
	
	
	public CarInfoView(Activity activity) {
		mActivity = activity;
		setContentView(R.layout.activity_main);
		surplusOil = (InstantOilItemView) findViewById(R.id.oilStateWIV);// ����״̬
		instantOil = (InstantOilItemView) findViewById(R.id.instantOilItemView);// ��ʱ�ͺ�
	    averageOil = (InstantOilItemView) findViewById(R.id.averageOilItemView);// ƽ���ͺ�
	    miv = (MilesItemView) findViewById(R.id.milesItemView);// ��̱�
	    instantSpeedItemView = (InstantOilItemView) findViewById(R.id.instantSpeedItemView);// ˲ʱ����
		batteryState = (InstantOilItemView) findViewById(R.id.batteryStateWIV);// ��ص�ѹ
		engineSpeed = (InstantOilItemView) findViewById(R.id.engineSpeedItemView);// �������ٶ�
		waterTankTemp = (WaterTankTempItemView) findViewById(R.id.waterTankTempItemView);// �����¶�
		
		initTitle();
		initImage();
		
	}

	private void initImage() {
		surplusOil.setImage(R.drawable.car_remain_oil);
		instantOil.setImage(R.drawable.car_instant_oil);
		averageOil.setImage(R.drawable.car_avg_oil);
		instantSpeedItemView.setImage(R.drawable.car_instant_speed);
		engineSpeed.setImage(R.drawable.car_engine_speed);
		batteryState.setImage(R.drawable.car_battery);
	}

	private void initTitle() {
		 surplusOil.setTitle(mActivity.getString(R.string.oliSurplus));
		 instantOil.setTitle(mActivity.getString(R.string.instantOil));
		 averageOil.setTitle(mActivity.getString(R.string.averageOil));
		 instantSpeedItemView.setTitle(mActivity.getString(R.string.instantSpeed));
		 engineSpeed.setTitle(mActivity.getString(R.string.engineSpeed));
		 batteryState.setTitle(mActivity.getString(R.string.batteryNum));
	}

	private View findViewById(int id) {
		return mActivity.findViewById(id);
	}

	private void setContentView(int id) {
		mActivity.setContentView(id);
	}

	public void displayCarLargeInfo(CarLargeInfo mCarLargeInfo) {
		if (null == mCarLargeInfo) {
			return;
		}
		initInfo(mCarLargeInfo);
		initUnit(mCarLargeInfo);
		
		if (Constant.PROTOCAL_INVALID_VALUE != mSurplusOil) {
			surplusOil.setContent(mSurplusOil+""); 
			surplusOil.setUnit("L");
		}
		if ( !StringUtils.isBlank(instantFuel) ) {
			instantOil.setContent(instantFuel);
			instantOil.setUnit(oilUnit);
		}
		if (Constant.PROTOCAL_INVALID_VALUE != averageFuel) {	
			averageOil.setContent(averageFuel+"");
			averageOil.setUnit(oilUnit);
		}
		if (Constant.PROTOCAL_INVALID_VALUE != mileage) {
			miv.setMiles(mileage ,distanceUnit);
		}
		if (Constant.PROTOCAL_INVALID_VALUE != enduranceMileage) {
			miv.setDrivableMiles(enduranceMileage,distanceUnit);  
		}
		if (Constant.PROTOCAL_INVALID_VALUE != instantSpeed) {
		   instantSpeedItemView.setContent(instantSpeed+"");
		   instantSpeedItemView.setUnit(speedUnit);
		}	
		if (Constant.PROTOCAL_INVALID_VALUE != rotateSpeed) {
			engineSpeed.setContent(rotateSpeed+"");
			engineSpeed.setUnit("R/min");
		}
		if ( !StringUtils.isBlank(voltage) ) {
			batteryState.setContent(voltage);
			batteryState.setUnit("V");
		}
	}

	private void initUnit(CarLargeInfo mCarLargeInfo) {
		oilUnit = mCarLargeInfo.getOilUnit();
		distanceUnit = mCarLargeInfo.getDistanceUnit();
		speedUnit = mCarLargeInfo.getSpeedUnit();
	}

	private void initInfo(CarLargeInfo mCarLargeInfo) {
		mSurplusOil = mCarLargeInfo.getSurplusOil();
		instantFuel = mCarLargeInfo.getInstantFuel();
		averageFuel = mCarLargeInfo.getAverageFuel();
		mileage     = mCarLargeInfo.getMileage();
		enduranceMileage = mCarLargeInfo.getEnduranceMileage();
		instantSpeed = mCarLargeInfo.getInstantSpeed();
		rotateSpeed = mCarLargeInfo.getRotateSpeed();
		voltage = mCarLargeInfo.getVoltage();
	}

	public void displayAirInfo(AirConditionInfo mAirConditionInfo) {
		outdoorTemp = mAirConditionInfo.getOutdoorTemp();
		if (Constant.PROTOCAL_INVALID_VALUE != outdoorTemp) {
			waterTankTemp.setTemp(outdoorTemp);  
			waterTankTemp.setUnit("��C");
		}
	}

}
