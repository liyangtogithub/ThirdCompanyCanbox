package com.landsem.canboxui.dialog;

import java.util.logging.LogRecord;

import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.CarAlarm;
import com.landsem.canboxui.R;
import com.landsem.canboxui.utils.AirUtil;
import com.landsem.canboxui.utils.ConstantUtil;
import com.landsem.common.tools.LogManager;

import android.R.integer;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class AirDialog {
	
	 MyDialog carAirDialog;
	 ImageView dialogIV;
//	 TextView dialog_TV;
	 Context mContext;
	 AirConditionInfo mOldAirConditionInfo  = null;
	
	public AirDialog(Context context) {
		mContext = context;
		View view = View.inflate(mContext,R.layout.air_dialog, null);
		dialogIV=(ImageView)view.findViewById(R.id.dialogAir_IV);
//		dialog_TV=(TextView)view.findViewById(R.id.dialogAir_TV);
		carAirDialog = new MyDialog(mContext,view);
		carAirDialog.dismiss();
	}

	public void displayState(AirConditionInfo mAirConditionInfo) {
		if (mOldAirConditionInfo==null) {
			mOldAirConditionInfo = (AirConditionInfo)mAirConditionInfo.clone() ;
			return;
		}
		if ( null!=  carAirDialog  && mAirConditionInfo.isSwitchAir() ) {
			
			// �Ա� �󴵷�ģʽ
			int	leftWindResId = AirUtil.getDialogLeftWindResId(mAirConditionInfo,mOldAirConditionInfo);
			if (  leftWindResId != -1 ) {
				showDialogUIAndSaveOldAir(leftWindResId,R.string.airLeftWindMode,mAirConditionInfo);
				return;
			}
			
			// �Ա� �Ҵ���ģʽ
			int rightWindResId = AirUtil.getDialogRightWindResId(mAirConditionInfo,mOldAirConditionInfo);
			if (rightWindResId != -1) {
				showDialogUIAndSaveOldAir(rightWindResId,R.string.airRightWindMode,mAirConditionInfo);
				return;
			}
			
			// �Ա� ����ȵȼ�
			int leftHeatResId = AirUtil.getDialogLeftHeatResId(mAirConditionInfo);
			int mOldLeftHeatResId = AirUtil.getDialogLeftHeatResId(mOldAirConditionInfo);
			if (leftHeatResId != mOldLeftHeatResId) {
				showDialogUIAndSaveOldAir(leftHeatResId,R.string.airLeftSeatHot,mAirConditionInfo);
				return;
			}
			
			// �Ա� �󴵷�ȼ�
			int leftWindGradeResId = AirUtil.getDialogLeftWindGradeResId(mAirConditionInfo);
			int mOldLeftWindGradeResId = AirUtil.getDialogLeftWindGradeResId(mOldAirConditionInfo);
			if (leftWindGradeResId != mOldLeftWindGradeResId) {
				showDialogUIAndSaveOldAir(leftWindGradeResId,R.string.airLeftWindGrade,mAirConditionInfo);
				return;
			}
			
			// �Ա�ǰ������
			int frontDemistResId = AirUtil.getDialogFrontDemistResId(mAirConditionInfo);
			int mOldFrontDemistResId = AirUtil.getDialogFrontDemistResId(mOldAirConditionInfo);
			if (frontDemistResId != mOldFrontDemistResId) {
				showDialogUIAndSaveOldAir(frontDemistResId,R.string.airFrontWindowDemist,mAirConditionInfo);
				return;
			}
			
			// �ԱȺ󴰳���
			int backDemistResId = AirUtil.getDialogBackDemistResId(mAirConditionInfo);
			int mOldBackDemistResId = AirUtil.getDialogBackDemistResId(mOldAirConditionInfo);
			if (backDemistResId != mOldBackDemistResId) {
				showDialogUIAndSaveOldAir(backDemistResId,R.string.airBackWindowDemist,mAirConditionInfo);
				return;
			}
			// �Ա�ѭ��ģʽ
			int cyclicModeResId = AirUtil.getDialogCyclicModeResId(mAirConditionInfo);
			int mOldCyclicModeResId = AirUtil.getDialogCyclicModeResId(mOldAirConditionInfo);
			if (cyclicModeResId != mOldCyclicModeResId) {
				showDialogUIAndSaveOldAir(cyclicModeResId,R.string.airCyclicMode,mAirConditionInfo);
				return;
			}			
			
			// �Ա� �Ҽ��ȵȼ�
			int rightHeatResId = AirUtil.getDialogRightSeatHeatResId(mAirConditionInfo);
			int mOldRightHeatResId = AirUtil.getDialogRightSeatHeatResId(mOldAirConditionInfo);
			if (rightHeatResId != mOldRightHeatResId) {
				showDialogUIAndSaveOldAir(rightHeatResId,R.string.airRightSeatHot,mAirConditionInfo);
				return;
			}
			
			// �Ա� �Ҵ���ȼ�
			int rightWindGradeResId = AirUtil.getDialogRightWindGradeResId(mAirConditionInfo);
			int mOldRightWindGradeResId = AirUtil.getDialogRightWindGradeResId(mOldAirConditionInfo);
			if (rightWindGradeResId != mOldRightWindGradeResId) {
				showDialogUIAndSaveOldAir(rightWindGradeResId,R.string.airRightWindGrade,mAirConditionInfo);
				return;
			}
		}else {
			carAirDialog.dismiss();
		}
		mOldAirConditionInfo = (AirConditionInfo)mAirConditionInfo.clone() ;
	}

	private void showDialogUIAndSaveOldAir(int mIVResId, int mTVResId, AirConditionInfo mAirConditionInfo) {
		LogManager.d("carAirDialog.show()");
		AirDialogDismissHandler.removeMessages(0);
		AirDialogDismissHandler.sendEmptyMessageDelayed(0, 3000);
		carAirDialog.show();
		dialogIV.setBackgroundResource(mIVResId);
//		dialog_TV.setText(mTVResId);
		mOldAirConditionInfo = (AirConditionInfo)mAirConditionInfo.clone() ;
	}
	
	Handler AirDialogDismissHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			carAirDialog.dismiss();
		};
	};

	public void cancle() {
		if ( null!=  carAirDialog ){
		    carAirDialog.cancel();
		}
	}
	
}
