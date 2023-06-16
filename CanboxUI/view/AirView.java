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
	// �ײ�˵����־
	TextView airLeftTemp_TV, airACEnable_TV, airEnable_TV, airAUTOEnable_TV,
			airRightTemp_TV;
	// ��ߵ�һ��
	ImageView leftWindMode_IV, leftHotMode_IV, leftWindGrade_IV;
	// �м���
	ImageView frontWindowDemist_IV, backWindowDemist_IV, CyclicMode_IV;
	// �ұ���
	ImageView RightWindMode_IV, rightHotMode_IV, rightWindGrade_IV;
	AirConditionInfo mOldAirConditionInfo  = null;

	/*** */

	public AirView(Activity activity) {
		mActivity = activity;
		setContentView(R.layout.air_layout);
		initView();

	}

	private void initView() {
		// �ײ�˵����־
		airLeftTemp_TV = (TextView) findViewById(R.id.airLeftTemp_TV);
		airACEnable_TV = (TextView) findViewById(R.id.airACEnable_TV);
		airEnable_TV = (TextView) findViewById(R.id.airEnable_TV);
		airAUTOEnable_TV = (TextView) findViewById(R.id.airAUTOEnable_TV);
		airRightTemp_TV = (TextView) findViewById(R.id.airRightTemp_TV);
		// ��ߵ�һ��
		leftWindMode_IV = (ImageView) findViewById(R.id.leftWindMode_IV);
		leftHotMode_IV = (ImageView) findViewById(R.id.leftHotMode_IV);
		leftWindGrade_IV = (ImageView) findViewById(R.id.leftWindGrade_IV);
		// �м���
		frontWindowDemist_IV = (ImageView) findViewById(R.id.frontWindowDemist_IV);
		backWindowDemist_IV = (ImageView) findViewById(R.id.backWindowDemist_IV);
		CyclicMode_IV = (ImageView) findViewById(R.id.CyclicMode_IV);
		// �ұ���
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
		// �Ҵ���ģʽ
	    int	windResId = AirUtil.getRightWindResId(mAirConditionInfo,mOldAirConditionInfo);
	    if (windResId != -1) {
	    	RightWindMode_IV.setBackgroundResource(windResId);
	    }
	    mOldAirConditionInfo = mAirConditionInfo;
		
		// �����μ��ȿ���
	    int	seatHeatResId = AirUtil.getRightSeatHeatResId(mAirConditionInfo);
	    rightHotMode_IV.setBackgroundResource(seatHeatResId);
		
		// �Ҵ���ȼ�
	    int	windGradeResId = AirUtil.getRightWindGradeResId(mAirConditionInfo);
	    rightWindGrade_IV.setBackgroundResource(windGradeResId);
		
	}

	private void initMiddle(AirConditionInfo mAirConditionInfo) {
		// ǰ������
		int	frontDemistResId = AirUtil.getFrontDemistResId(mAirConditionInfo);
		frontWindowDemist_IV.setBackgroundResource(frontDemistResId);
		
		// �󴰳���
		int	backDemistResId = AirUtil.getBackDemistResId(mAirConditionInfo);
		backWindowDemist_IV.setBackgroundResource(backDemistResId);
		
		// ѭ��ģʽ
		int	cyclicModeResId = AirUtil.getCyclicModeResId(mAirConditionInfo);
		CyclicMode_IV.setBackgroundResource(cyclicModeResId);
		
	}

	private void initLeft(AirConditionInfo mAirConditionInfo) {
		// �󴵷�ģʽ
		int	windResId = AirUtil.getLeftWindResId(mAirConditionInfo,mOldAirConditionInfo);
		if (windResId != -1) {
			leftWindMode_IV.setBackgroundResource(windResId);
		}
		
		// �����μ��ȿ���
		int	leftHeatResId = AirUtil.getLeftHeatResId(mAirConditionInfo);
		leftHotMode_IV.setBackgroundResource(leftHeatResId);
		
		// �����
		int	leftWindGradeResId = AirUtil.getLeftWindGradeResId(mAirConditionInfo);
		leftWindGrade_IV.setBackgroundResource(leftWindGradeResId);
		

	}

	private void initBottom(AirConditionInfo mAirConditionInfo) {
		// ���¶�ֵ
		float LeftSeatSetTemp = mAirConditionInfo.getFrontLeftSeatSetTemp();
		if (LeftSeatSetTemp>0) {
			airLeftTemp_TV.setText(LeftSeatSetTemp+ "��");
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
		// �յ�����
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
		// ���¶�ֵ
		float RightSeatSetTemp = mAirConditionInfo.getFrontRightSeatSetTemp();
		if ( RightSeatSetTemp>0 ) {
			airRightTemp_TV.setText(RightSeatSetTemp+ "��");
		}else if ( RightSeatSetTemp==Constant.AIR_HIGH ) {
			airRightTemp_TV.setText(R.string.airTempHigh);
		}else if ( RightSeatSetTemp==Constant.AIR_LOW ) {
			airRightTemp_TV.setText(R.string.airTempLow);
		}
	}
	
}
