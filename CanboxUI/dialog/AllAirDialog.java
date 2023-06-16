package com.landsem.canboxui.dialog;

import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canboxui.R;
import com.landsem.canboxui.utils.AirUtil;
import com.landsem.canboxui.utils.ConstantUtil;
import com.landsem.common.tools.LogManager;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class AllAirDialog {
	
	 MyDialog carAirDialog;
	 Context mContext;
	 private ImageView img_ac, img_auto, img_dual, img_outside, img_inner;
	 private ImageView img_up, img_mid, img_down, img_meter;
	 private ImageView img_chairleft1;
	 private ImageView img_chairight1;
	 private ImageView img_front_demist,img_back_demist,img_flow_window;
	 private TextView txt_templeft, txt_tempright, /*txt_meter,*/txt_air_acmax;
	 private int[] mAirmeterArray = new int[] { R.drawable.airmeter_1,
				R.drawable.airmeter_1, R.drawable.airmeter_2, R.drawable.airmeter_3,
				R.drawable.airmeter_4, R.drawable.airmeter_5, R.drawable.airmeter_6,
				R.drawable.airmeter_7, R.drawable.airmeter_8, R.drawable.airmeter_9, 
				R.drawable.airmeter_10, R.drawable.airmeter_11, R.drawable.airmeter_12, 
				R.drawable.airmeter_13, R.drawable.airmeter_14
			};
	
	public AllAirDialog(Context context) {
		mContext = context;
		View view = View.inflate(mContext,R.layout.all_air_layout, null);
		carAirDialog = new MyDialog(mContext,view);
		carAirDialog.dismiss();
		initView(view);
	}

	private void initView(View view) {
		img_ac = (ImageView) view.findViewById(R.id.airc_ac);
		img_auto = (ImageView) view.findViewById(R.id.airc_auto);
		img_dual = (ImageView) view.findViewById(R.id.airc_dual);
		img_outside = (ImageView) view.findViewById(R.id.airc_outloop);
		img_inner = (ImageView) view.findViewById(R.id.airc_inloop);
		img_up = (ImageView) view.findViewById(R.id.airc_arrowup);
		img_mid = (ImageView) view.findViewById(R.id.airc_arrowmid);
		img_down = (ImageView) view.findViewById(R.id.airc_arrowdown);
		img_meter = (ImageView) view.findViewById(R.id.airmeter);
		img_chairleft1 = (ImageView) view.findViewById(R.id.airc_hotmleft1);
		img_chairight1 = (ImageView) view.findViewById(R.id.airc_hotmright1);
		img_front_demist = (ImageView) view.findViewById(R.id.air_front_demist);
		img_back_demist = (ImageView) view.findViewById(R.id.air_back_demist);
		img_flow_window = (ImageView) view.findViewById(R.id.air_flow_window);
		txt_templeft = (TextView) view.findViewById(R.id.airc_templeft);
		txt_tempright = (TextView) view.findViewById(R.id.airc_tempright);
//		txt_meter = (TextView) view.findViewById(R.id.airc_txtmeter);
		txt_air_acmax= (TextView) view.findViewById(R.id.air_acmax);
	}

	public void displayState(AirConditionInfo mAirConditionInfo) {
		if (mAirConditionInfo==null) {
			return;
		}
		if ( null!=  carAirDialog  && mAirConditionInfo.isSwitchAir() && !mAirConditionInfo.isAutoSwitch1()) {
			showDialogUIAndSaveOldAir(mAirConditionInfo);
		}else {
			carAirDialog.dismiss();
		}
	}

	private void showDialogUIAndSaveOldAir( AirConditionInfo mAirConditionInfo) {
		LogManager.d("carAirDialog.show()");
		AirDialogDismissHandler.removeMessages(0);
		AirDialogDismissHandler.sendEmptyMessageDelayed(0, 5000);
		initViewState(mAirConditionInfo);
		carAirDialog.show();
	}
	
	private void initViewState(AirConditionInfo mAirConditionInfo) {
		img_ac.setImageResource(mAirConditionInfo.isAcEnable()?R.drawable.airc_ac_on:R.drawable.airc_ac_off);
		img_dual.setImageResource(mAirConditionInfo.isDualSwitch()?R.drawable.airc_dual_on:R.drawable.airc_dual_off);
		img_auto.setImageResource(mAirConditionInfo.isAutoSwitch1()?R.drawable.airc_auto_on:R.drawable.airc_auto_off);
		img_outside.setImageResource(mAirConditionInfo.isCircleOut()?R.drawable.outsideloop_on:R.drawable.outsideloop_off);
		img_inner.setImageResource(mAirConditionInfo.isCircleOut()?R.drawable.innerloop_off:R.drawable.innerloop_on);
		img_up.setVisibility(mAirConditionInfo.isLeftWindBlowHead()? View.VISIBLE:View.INVISIBLE);
		img_mid.setVisibility(mAirConditionInfo.isLeftWindBlowBody()? View.VISIBLE:View.INVISIBLE); 
		img_down.setVisibility(mAirConditionInfo.isLeftWindBlowFoot()? View.VISIBLE:View.INVISIBLE);
		img_flow_window.setVisibility(mAirConditionInfo.isLeftWindBlowWindow()? View.VISIBLE:View.INVISIBLE);
		img_front_demist.setVisibility(mAirConditionInfo.isFrontWindowDemist()? View.VISIBLE:View.INVISIBLE);
		img_back_demist.setVisibility(mAirConditionInfo.isBackWindowDemist()? View.VISIBLE:View.INVISIBLE);
		txt_air_acmax.setVisibility(mAirConditionInfo.isAcMaxSwitch()? View.VISIBLE:View.INVISIBLE);
		byte leftWindGrade = mAirConditionInfo.getLeftWindGrade();
		float windGradeTotal = mAirConditionInfo.getWindGradeTotal();
		
		byte windGradeIndex = (byte) ((mAirmeterArray.length-1)/windGradeTotal*leftWindGrade);
		if (windGradeIndex>=0 && windGradeIndex<15) {
			img_meter.setImageResource(mAirmeterArray[windGradeIndex]);
		}
//		txt_meter.setText(mAirConditionInfo.getLeftWindGrade()+"");
		setChairLeft(mAirConditionInfo);
		setChairRight(mAirConditionInfo);
		setTempLeft(mAirConditionInfo);
		setTempRight(mAirConditionInfo);
	}
	
	private void setTempRight(AirConditionInfo mAirConditionInfo) {
		float RightSeatSetTemp = mAirConditionInfo.getFrontRightSeatSetTemp();
		if ( RightSeatSetTemp>0 ) {
			txt_tempright.setText(RightSeatSetTemp+ "");
		}else if ( RightSeatSetTemp==Constant.AIR_HIGH ) {
			txt_tempright.setText(R.string.airTempHigh);
		}else if ( RightSeatSetTemp==Constant.AIR_LOW ) {
			txt_tempright.setText(R.string.airTempLow);
		}
	}

	private void setTempLeft(AirConditionInfo mAirConditionInfo) {
		float LeftSeatSetTemp = mAirConditionInfo.getFrontLeftSeatSetTemp();
		if (LeftSeatSetTemp>0) {
			txt_templeft.setText(LeftSeatSetTemp+ "");
		}else if ( LeftSeatSetTemp==Constant.AIR_HIGH ) {
			txt_templeft.setText(R.string.airTempHigh);
		}else if ( LeftSeatSetTemp==Constant.AIR_LOW ) {
			txt_templeft.setText(R.string.airTempLow);
		}
	}

	private void setChairRight(AirConditionInfo mAirConditionInfo) {
		img_chairight1.setVisibility(View.VISIBLE);
		switch (mAirConditionInfo.getRightSeatHeatGrade()) {
		case 1:
			img_chairight1.setImageResource(R.drawable.hotmright_1);
			break;
		case 2:
			img_chairight1.setImageResource(R.drawable.hotmright_2);
			break;
		case 3:
			img_chairight1.setImageResource(R.drawable.hotmright_3);
			break;

		default:
			img_chairight1.setVisibility(View.INVISIBLE);
			break;
		}

	}
	
	private void setChairLeft(AirConditionInfo mAirConditionInfo) {
		img_chairleft1.setVisibility(View.VISIBLE);
		switch (mAirConditionInfo.getLeftSeatHeatGrade()) {
		case 1:
			img_chairleft1.setImageResource(R.drawable.hotmleft_1);
			break;
		case 2:
			img_chairleft1.setImageResource(R.drawable.hotmleft_2);
			break;
		case 3:
			img_chairleft1.setImageResource(R.drawable.hotmleft_3);
			break;

		default:
			img_chairleft1.setVisibility(View.INVISIBLE);
			break;
		}

	}

	Handler AirDialogDismissHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			carAirDialog.dismiss();
		};
	};

	
	
}
