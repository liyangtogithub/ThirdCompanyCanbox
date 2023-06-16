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
	
	/*** 剩余油量*/
	InstantOilItemView instantOil ;
	/*** 即时油耗*/
	InstantOilItemView surplusOil;
	/*** 平均油耗*/
	InstantOilItemView averageOil;
	/*** 里程表*/
	MilesItemView miv;
	/*** 瞬时车速*/
	InstantOilItemView instantSpeedItemView;
	/*** 发动机速度*/
	InstantOilItemView engineSpeed;
	/*** 电池状态*/
	InstantOilItemView batteryState;
	/***外界温度*/
	WaterTankTempItemView waterTankTemp;
	/*** 剩余油量*/
	int mSurplusOil = Constant.PROTOCAL_INVALID_VALUE;
	/*** 瞬时油耗*/
	private String instantFuel ;
	/***平均油耗*/
	private float averageFuel = Constant.PROTOCAL_INVALID_VALUE;
	/**** 行驶里程 */
	private float mileage = Constant.PROTOCAL_INVALID_VALUE;
	/***续航里程*/
	private int enduranceMileage = Constant.PROTOCAL_INVALID_VALUE;
	/****瞬时车速 */
	private int instantSpeed  = Constant.PROTOCAL_INVALID_VALUE;
	/*** 发动机转速*/
	private int rotateSpeed = Constant.PROTOCAL_INVALID_VALUE;
	/***电池 电压*/
	private String voltage;
	/*** 车外温度*/
	private float outdoorTemp = Constant.PROTOCAL_INVALID_VALUE;
	/****油耗单位 */
	private String oilUnit = "L/100km";
	/****里程单位*/
	private String distanceUnit = "km" ;
	/****速度单位*/
	private String speedUnit = "km/h" ;
	
	
	public CarInfoView(Activity activity) {
		mActivity = activity;
		setContentView(R.layout.activity_main);
		surplusOil = (InstantOilItemView) findViewById(R.id.oilStateWIV);// 油量状态
		instantOil = (InstantOilItemView) findViewById(R.id.instantOilItemView);// 即时油耗
	    averageOil = (InstantOilItemView) findViewById(R.id.averageOilItemView);// 平均油耗
	    miv = (MilesItemView) findViewById(R.id.milesItemView);// 里程表
	    instantSpeedItemView = (InstantOilItemView) findViewById(R.id.instantSpeedItemView);// 瞬时车速
		batteryState = (InstantOilItemView) findViewById(R.id.batteryStateWIV);// 电池电压
		engineSpeed = (InstantOilItemView) findViewById(R.id.engineSpeedItemView);// 发动机速度
		waterTankTemp = (WaterTankTempItemView) findViewById(R.id.waterTankTempItemView);// 室外温度
		
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
			waterTankTemp.setUnit("°C");
		}
	}

}
