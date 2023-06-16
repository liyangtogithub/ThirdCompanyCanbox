package com.landsem.canboxui.view;


import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canboxui.R;
import com.landsem.canboxui.utils.AirUtil;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AirView {

	private Activity mActivity;
	// 底部说明标志
	TextView airLeftTemp_TV, airACEnable_TV, airEnable_TV, airAUTOEnable_TV,
			airRightTemp_TV;
	// 左边第一列
	ImageView leftWindMode_IV, leftHotMode_IV, leftWindGrade_IV;
	// 中间列
	ImageView frontWindowDemist_IV, backWindowDemist_IV, CyclicMode_IV;
	// 右边列
	ImageView RightWindMode_IV, rightHotMode_IV, rightWindGrade_IV;
	AirConditionInfo mOldAirConditionInfo  = null;

	/*** */

	public AirView(Activity activity) {
		mActivity = activity;
		setContentView(R.layout.air_layout);
		initView();

	}

	private void initView() {
		// 底部说明标志
		airLeftTemp_TV = (TextView) findViewById(R.id.airLeftTemp_TV);
		airACEnable_TV = (TextView) findViewById(R.id.airACEnable_TV);
		airEnable_TV = (TextView) findViewById(R.id.airEnable_TV);
		airAUTOEnable_TV = (TextView) findViewById(R.id.airAUTOEnable_TV);
		airRightTemp_TV = (TextView) findViewById(R.id.airRightTemp_TV);
		// 左边第一列
		leftWindMode_IV = (ImageView) findViewById(R.id.leftWindMode_IV);
		leftHotMode_IV = (ImageView) findViewById(R.id.leftHotMode_IV);
		leftWindGrade_IV = (ImageView) findViewById(R.id.leftWindGrade_IV);
		// 中间列
		frontWindowDemist_IV = (ImageView) findViewById(R.id.frontWindowDemist_IV);
		backWindowDemist_IV = (ImageView) findViewById(R.id.backWindowDemist_IV);
		CyclicMode_IV = (ImageView) findViewById(R.id.CyclicMode_IV);
		// 右边列
		RightWindMode_IV = (ImageView) findViewById(R.id.RightWindMode_IV);
		rightHotMode_IV = (ImageView) findViewById(R.id.rightHotMode_IV);
		rightWindGrade_IV = (ImageView) findViewById(R.id.rightWindGrade_IV);
	}

	private View findViewById(int id) {
		return mActivity.findViewById(id);
	}

	private void setContentView(int id) {
		mActivity.setContentView(id);
	}

	public void displayAirState(AirConditionInfo mAirConditionInfo) {
		initBottom(mAirConditionInfo);
		initLeft(mAirConditionInfo);
		initMiddle(mAirConditionInfo);
		initRight(mAirConditionInfo);
	}

	private void initRight(AirConditionInfo mAirConditionInfo) {
		// 右吹风模式
	    int	windResId = AirUtil.getRightWindResId(mAirConditionInfo,mOldAirConditionInfo);
	    if (windResId != -1) {
	    	RightWindMode_IV.setBackgroundResource(windResId);
	    }
	    mOldAirConditionInfo = mAirConditionInfo;
		
		// 右座椅加热开关
	    int	seatHeatResId = AirUtil.getRightSeatHeatResId(mAirConditionInfo);
	    rightHotMode_IV.setBackgroundResource(seatHeatResId);
		
		// 右吹风等级
	    int	windGradeResId = AirUtil.getRightWindGradeResId(mAirConditionInfo);
	    rightWindGrade_IV.setBackgroundResource(windGradeResId);
		
	}

	private void initMiddle(AirConditionInfo mAirConditionInfo) {
		// 前窗除雾
		int	frontDemistResId = AirUtil.getFrontDemistResId(mAirConditionInfo);
		frontWindowDemist_IV.setBackgroundResource(frontDemistResId);
		
		// 后窗除雾
		int	backDemistResId = AirUtil.getBackDemistResId(mAirConditionInfo);
		backWindowDemist_IV.setBackgroundResource(backDemistResId);
		
		// 循环模式
		int	cyclicModeResId = AirUtil.getCyclicModeResId(mAirConditionInfo);
		CyclicMode_IV.setBackgroundResource(cyclicModeResId);
		
	}

	private void initLeft(AirConditionInfo mAirConditionInfo) {
		// 左吹风模式
		int	windResId = AirUtil.getLeftWindResId(mAirConditionInfo,mOldAirConditionInfo);
		if (windResId != -1) {
			leftWindMode_IV.setBackgroundResource(windResId);
		}
		
		// 左座椅加热开关
		int	leftHeatResId = AirUtil.getLeftHeatResId(mAirConditionInfo);
		leftHotMode_IV.setBackgroundResource(leftHeatResId);
		
		// 左风速
		int	leftWindGradeResId = AirUtil.getLeftWindGradeResId(mAirConditionInfo);
		leftWindGrade_IV.setBackgroundResource(leftWindGradeResId);
		

	}

	private void initBottom(AirConditionInfo mAirConditionInfo) {
		// 左温度值
		float LeftSeatSetTemp = mAirConditionInfo.getFrontLeftSeatSetTemp();
		if (LeftSeatSetTemp>0) {
			airLeftTemp_TV.setText(LeftSeatSetTemp+ "℃");
		}else if ( LeftSeatSetTemp==Constant.AIR_HIGH ) {
			airLeftTemp_TV.setText(R.string.airTempHigh);
		}else if ( LeftSeatSetTemp==Constant.AIR_LOW ) {
			airLeftTemp_TV.setText(R.string.airTempLow);
		}
		// A/C
		if (mAirConditionInfo.isAcEnable()) {
			airACEnable_TV.setText(R.string.airACEnable);
		}else {
			airACEnable_TV.setText(R.string.airACDisable);
		}
		// 空调开关
		if (mAirConditionInfo.isSwitchAir()) {
			airEnable_TV.setText(R.string.enable);
		}else {
			airEnable_TV.setText(R.string.disable);
		}
		// Auto
		if (mAirConditionInfo.isAutoSwitch1()) {
			airAUTOEnable_TV.setText(R.string.airAUTOEnable);
		}else {
			airAUTOEnable_TV.setText(R.string.airAUTODisable);
		}
		// 右温度值
		float RightSeatSetTemp = mAirConditionInfo.getFrontRightSeatSetTemp();
		if ( RightSeatSetTemp>0 ) {
			airRightTemp_TV.setText(RightSeatSetTemp+ "℃");
		}else if ( RightSeatSetTemp==Constant.AIR_HIGH ) {
			airRightTemp_TV.setText(R.string.airTempHigh);
		}else if ( RightSeatSetTemp==Constant.AIR_LOW ) {
			airRightTemp_TV.setText(R.string.airTempLow);
		}
	}
	
}
