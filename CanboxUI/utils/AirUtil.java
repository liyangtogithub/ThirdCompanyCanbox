package com.landsem.canboxui.utils;

import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canboxui.R;
import com.landsem.common.tools.LogManager;

public class AirUtil {

	/*** 得到左吹风模式的图片ID */
	public static int getLeftWindResId(AirConditionInfo mAirConditionInfo,
			AirConditionInfo mAirConditionInfoOder) {
		int resId = -1;
		if (null == mAirConditionInfoOder) {
			return resId;
		}
		if (mAirConditionInfo.isLeftWindBlowFoot()
				&& (mAirConditionInfo.isLeftWindBlowFoot() != mAirConditionInfoOder
						.isLeftWindBlowFoot())) {
			resId = R.drawable.air_wind_tofoot;
		} else if (mAirConditionInfo.isLeftWindBlowHead()
				&& (mAirConditionInfo.isLeftWindBlowHead() != mAirConditionInfoOder
						.isLeftWindBlowHead())) {
			resId = R.drawable.air_wind_tohead;
		} else if (mAirConditionInfo.isLeftWindBlowWindow()
				&& (mAirConditionInfo.isLeftWindBlowWindow() != mAirConditionInfoOder
						.isLeftWindBlowWindow())) {
			resId = R.drawable.air_wind_towindow;
		} else if (mAirConditionInfo.isLeftWindBlowBody()
				&& (mAirConditionInfo.isLeftWindBlowBody() != mAirConditionInfoOder
						.isLeftWindBlowBody())) {
			resId = R.drawable.air_wind_tobody;
		}
		if (!mAirConditionInfo.isLeftWindBlowFoot()
				&& !mAirConditionInfo.isLeftWindBlowHead()
				&& !mAirConditionInfo.isLeftWindBlowWindow()
				&& !mAirConditionInfo.isLeftWindBlowBody()) {
			resId = R.drawable.air_wind_tono;
		}
		return resId;
	}

	/***
	 * 得到右吹风模式的图片ID
	 * 
	 * @param mOldAirConditionInfo
	 */
	public static int getRightWindResId(AirConditionInfo mAirConditionInfo,
			AirConditionInfo mOldAirConditionInfo) {
		int resId = -1;
		if (null == mOldAirConditionInfo) {
			return resId;
		}
		if (mAirConditionInfo.isRightWindBlowFoot()
				&& (mAirConditionInfo.isRightWindBlowFoot() != mOldAirConditionInfo
						.isRightWindBlowFoot())) {
			resId = R.drawable.air_wind_tofoot;
		} else if (mAirConditionInfo.isRightWindBlowHead()
				&& (mAirConditionInfo.isRightWindBlowHead() != mOldAirConditionInfo
						.isRightWindBlowHead())) {
			resId = R.drawable.air_wind_tohead;
		} else if (mAirConditionInfo.isRightWindBlowWindow()
				&& (mAirConditionInfo.isRightWindBlowWindow() != mOldAirConditionInfo
						.isRightWindBlowWindow())) {
			resId = R.drawable.air_wind_towindow;
		} else if (mAirConditionInfo.isRightWindBlowBody()
				&& (mAirConditionInfo.isRightWindBlowBody() != mOldAirConditionInfo
						.isRightWindBlowBody())) {
			resId = R.drawable.air_wind_tobody;
		}
		if (!mAirConditionInfo.isRightWindBlowFoot()
				&& !mAirConditionInfo.isRightWindBlowHead()
				&& !mAirConditionInfo.isRightWindBlowBody()
				&& !mAirConditionInfo.isRightWindBlowWindow()) {
			resId = R.drawable.air_wind_tono;
		}
		return resId;
	}

	/*** DIALOG 吹风模式的图片ID */
	public static int getDialogLeftWindResId(AirConditionInfo mAirConditionInfo,
			AirConditionInfo mAirConditionInfoOder) {
		int resId = -1;
		if (null == mAirConditionInfoOder) {
			return resId;
		}
		if (mAirConditionInfo.isLeftWindBlowFoot()
				&& (mAirConditionInfo.isLeftWindBlowFoot() != mAirConditionInfoOder
						.isLeftWindBlowFoot())) {
			resId = R.drawable.dialog_air_wind_foot;
		} else if (mAirConditionInfo.isLeftWindBlowHead()
				&& (mAirConditionInfo.isLeftWindBlowHead() != mAirConditionInfoOder
						.isLeftWindBlowHead())) {
			resId = R.drawable.dialog_air_wind_head;
		} else if (mAirConditionInfo.isLeftWindBlowWindow()
				&& (mAirConditionInfo.isLeftWindBlowWindow() != mAirConditionInfoOder
						.isLeftWindBlowWindow())) {
			resId = R.drawable.dialog_air_wind_window;
		} else if (mAirConditionInfo.isLeftWindBlowBody()
				&& (mAirConditionInfo.isLeftWindBlowBody() != mAirConditionInfoOder
						.isLeftWindBlowBody())) {
			resId = R.drawable.dialog_air_wind_body;
		}/*
		 * else if (mAirConditionInfo.isFrontWindowDemist()) { resId =
		 * R.drawable.dialog_air_front_demist_enable; }
		 */
		return resId;
	}

	/*** DIALOG 右吹风模式的图片ID */
	public static int getDialogRightWindResId(
			AirConditionInfo mAirConditionInfo,
			AirConditionInfo mOldAirConditionInfo) {
		int resId = -1;
		if (null == mOldAirConditionInfo) {
			return resId;
		}
		if (mAirConditionInfo.isRightWindBlowFoot()
				&& (mAirConditionInfo.isRightWindBlowFoot() != mOldAirConditionInfo
						.isRightWindBlowFoot())) {
			resId = R.drawable.dialog_air_wind_foot;
		} else if (mAirConditionInfo.isRightWindBlowHead()
				&& (mAirConditionInfo.isRightWindBlowHead() != mOldAirConditionInfo
						.isRightWindBlowHead())) {
			resId = R.drawable.dialog_air_wind_head;
		} else if (mAirConditionInfo.isRightWindBlowBody()
				&& (mAirConditionInfo.isRightWindBlowBody() != mOldAirConditionInfo
						.isRightWindBlowBody())) {
			resId = R.drawable.dialog_air_wind_body;
		} else if (mAirConditionInfo.isRightWindBlowWindow()
				&& (mAirConditionInfo.isRightWindBlowWindow() != mOldAirConditionInfo
						.isRightWindBlowWindow())) {
			resId = R.drawable.dialog_air_wind_window;
		}/*
		 * else if (mAirConditionInfo.isFrontWindowDemist()) { resId =
		 * R.drawable.dialog_air_front_demist_enable; }
		 */
		return resId;
	}

	/*** 得到左加热等级的图片ID */
	public static int getLeftHeatResId(AirConditionInfo mAirConditionInfo) {
		int resId = R.drawable.air_seat_hot0;
		;
		if (null == mAirConditionInfo) {
			return resId;
		}
		if (mAirConditionInfo.getLeftSeatHeatGrade() > 0) {
			resId = R.drawable.air_seat_hot1;
		} else {
			resId = R.drawable.air_seat_hot0;
		}
		return resId;
	}

	/*** Dialog 左加热等级的图片ID */
	public static int getDialogLeftHeatResId(AirConditionInfo mAirConditionInfo) {
		int resId = -1;
		if (null == mAirConditionInfo) {
			return resId;
		}
		if (mAirConditionInfo.getLeftSeatHeatGrade() > 0) {
			resId = R.drawable.dialog_air_seat_hot1;
		} else {
			resId = R.drawable.dialog_air_seat_hot0;
		}
		return resId;
	}

	/*** 得到左吹风等级的图片ID */
	public static int getLeftWindGradeResId(AirConditionInfo mAirConditionInfo) {
		int resId = R.drawable.air_wind_grade0;
		if (null == mAirConditionInfo) {
			return resId;
		}
		switch (mAirConditionInfo.getLeftWindGrade()) {
		case 0:
			resId = R.drawable.air_wind_grade0;
			break;
		case 1:
			resId = R.drawable.air_wind_grade1;
			break;
		case 2:
			resId = R.drawable.air_wind_grade2;
			break;
		case 3:
			resId = R.drawable.air_wind_grade3;
			break;
		case 4:
			resId = R.drawable.air_wind_grade4;
			break;
		case 5:
			resId = R.drawable.air_wind_grade5;
			break;
		}
		if (mAirConditionInfo.getLeftWindGrade() > 5) {
			resId = R.drawable.air_wind_grade5;
		}
		return resId;
	}

	/*** Dialog 左吹风等级的图片ID */
	public static int getDialogLeftWindGradeResId(
			AirConditionInfo mAirConditionInfo) {
		int resId = -1;
		if (null == mAirConditionInfo) {
			return resId;
		}
		switch (mAirConditionInfo.getLeftWindGrade()) {
		case 0:
			resId = R.drawable.dialog_air_wind_grade0;
			break;
		case 1:
			resId = R.drawable.dialog_air_wind_grade1;
			break;
		case 2:
			resId = R.drawable.dialog_air_wind_grade2;
			break;
		case 3:
			resId = R.drawable.dialog_air_wind_grade3;
			break;
		case 4:
			resId = R.drawable.dialog_air_wind_grade4;
			break;
		case 5:
			resId = R.drawable.dialog_air_wind_grade5;
			break;
		}
		if (mAirConditionInfo.getLeftWindGrade() > 5) {
			resId = R.drawable.dialog_air_wind_grade5;
		}
		return resId;
	}

	/*** 得到右加热等级的图片ID */
	public static int getRightSeatHeatResId(AirConditionInfo mAirConditionInfo) {
		int resId = R.drawable.air_seat_hot0;
		if (null == mAirConditionInfo) {
			return resId;
		}
		if (mAirConditionInfo.getRightSeatHeatGrade() > 0) {
			resId = R.drawable.air_seat_hot1;
		} else {
			resId = R.drawable.air_seat_hot0;
		}
		return resId;
	}

	/*** DIALOG 右加热等级的图片ID */
	public static int getDialogRightSeatHeatResId(
			AirConditionInfo mAirConditionInfo) {
		int resId = -1;
		if (null == mAirConditionInfo) {
			return resId;
		}
		if (mAirConditionInfo.getRightSeatHeatGrade() > 0) {
			resId = R.drawable.dialog_air_seat_hot1;
		} else {
			resId = R.drawable.dialog_air_seat_hot0;
		}
		return resId;
	}

	/*** 得到右风等级的图片ID */
	public static int getRightWindGradeResId(AirConditionInfo mAirConditionInfo) {
		int resId = R.drawable.air_wind_grade5;
		if (null == mAirConditionInfo) {
			return resId;
		}
		switch (mAirConditionInfo.getRightWindGrade()) {
		case 0:
			resId = R.drawable.air_wind_grade0;
			break;
		case 1:
			resId = R.drawable.air_wind_grade1;
			break;
		case 2:
			resId = R.drawable.air_wind_grade2;
			break;
		case 3:
			resId = R.drawable.air_wind_grade3;
			break;
		case 4:
			resId = R.drawable.air_wind_grade4;
			break;
		case 5:
			resId = R.drawable.air_wind_grade5;
			break;
		}
		if (mAirConditionInfo.getRightWindGrade() > 5) {
			resId = R.drawable.air_wind_grade5;
		}
		return resId;
	}

	/*** DIALOG 右风等级的图片ID */
	public static int getDialogRightWindGradeResId(
			AirConditionInfo mAirConditionInfo) {
		int resId = -1;
		if (null == mAirConditionInfo) {
			return resId;
		}
		switch (mAirConditionInfo.getRightWindGrade()) {
		case 0:
			resId = R.drawable.dialog_air_wind_grade0;
			break;
		case 1:
			resId = R.drawable.dialog_air_wind_grade1;
			break;
		case 2:
			resId = R.drawable.dialog_air_wind_grade2;
			break;
		case 3:
			resId = R.drawable.dialog_air_wind_grade3;
			break;
		case 4:
			resId = R.drawable.dialog_air_wind_grade4;
			break;
		case 5:
			resId = R.drawable.dialog_air_wind_grade5;
			break;
		}
		if (mAirConditionInfo.getRightWindGrade() > 5) {
			resId = R.drawable.dialog_air_wind_grade5;
		}
		return resId;
	}

	/*** 得到前窗除雾的图片ID */
	public static int getFrontDemistResId(AirConditionInfo mAirConditionInfo) {
		int resId = R.drawable.air_front_demist_disable;
		if (null == mAirConditionInfo) {
			return resId;
		}
		if (mAirConditionInfo.isFrontWindowDemist()) {
			resId = R.drawable.air_front_demist_enable;
		} else {
			resId = R.drawable.air_front_demist_disable;
		}
		return resId;
	}

	/*** DIALOG 前窗除雾的图片ID */
	public static int getDialogFrontDemistResId(
			AirConditionInfo mAirConditionInfo) {
		int resId = -1;
		if (null == mAirConditionInfo) {
			return resId;
		}
		if (mAirConditionInfo.isFrontWindowDemist()) {
			resId = R.drawable.dialog_air_front_demist_enable;
		} else {
			resId = R.drawable.dialog_air_front_demist_disable;
		}
		return resId;
	}

	/*** 得到后窗除雾的图片ID */
	public static int getBackDemistResId(AirConditionInfo mAirConditionInfo) {
		int resId = R.drawable.air_back_demist_disable;
		if (null == mAirConditionInfo) {
			return resId;
		}
		if (mAirConditionInfo.isBackWindowDemist()) {
			resId = R.drawable.air_back_demist_enable;
		} else {
			resId = R.drawable.air_back_demist_disable;
		}
		return resId;
	}

	/*** DIALOG 后窗除雾的图片ID */
	public static int getDialogBackDemistResId(
			AirConditionInfo mAirConditionInfo) {
		int resId = -1;
		if (null == mAirConditionInfo) {
			return resId;
		}
		if (mAirConditionInfo.isBackWindowDemist()) {
			resId = R.drawable.dialog_air_back_demist_enable;
		} else {
			resId = R.drawable.dialog_air_back_demist_disable;
		}
		return resId;
	}

	/*** 界面循环模式的图片ID */
	public static int getCyclicModeResId(AirConditionInfo mAirConditionInfo) {
		int resId = R.drawable.air_cyclic_mode_outside;
		if (null == mAirConditionInfo) {
			return resId;
		}
		if (mAirConditionInfo.isCircleOut()) {
			resId = R.drawable.air_cyclic_mode_outside;
		} else {
			resId = R.drawable.air_cyclic_mode_in;
		}
		return resId;
	}

	/*** DIALOG 循环模式的图片ID */
	public static int getDialogCyclicModeResId(
			AirConditionInfo mAirConditionInfo) {
		int resId = -1;
		if (null == mAirConditionInfo) {
			return resId;
		}
		if (mAirConditionInfo.isCircleOut()) {
			resId = R.drawable.dialog_air_cyclic_mode_outside;
		} else {
			resId = R.drawable.dialog_air_cyclic_mode_inside;
		}
		return resId;
	}

	public static boolean isAirConditionChanged(AirConditionInfo mAirConditionInfo,
			AirConditionInfo mOldAirConditionInfo) {
		//只有开关两个状态的检测
		if (isSwitchChanged(mAirConditionInfo,mOldAirConditionInfo)) {
			return true;
		}
		// 对比 吹风模式
		if (isWindBlowChanged(mAirConditionInfo,mOldAirConditionInfo)) {
			return true;
		}
		// 检查加热等级
		if (isHeatChanged(mAirConditionInfo,mOldAirConditionInfo)) {
			return true;
		}
		// 检查吹风等级
		if (isWindGradeChanged(mAirConditionInfo,mOldAirConditionInfo)) {
			return true;
		}
		// 左右座椅设定温度
		if (isSeatSetTempChanged(mAirConditionInfo,mOldAirConditionInfo)) {
			return true;
		}
		return false;
	}

	private static boolean isSeatSetTempChanged(AirConditionInfo mAirConditionInfo,
			AirConditionInfo mOldAirConditionInfo) {
		if (mAirConditionInfo.getFrontLeftSeatSetTemp() != mOldAirConditionInfo.getFrontLeftSeatSetTemp()
				||mAirConditionInfo.getFrontRightSeatSetTemp() != mOldAirConditionInfo.getFrontRightSeatSetTemp()) {
			return true;
		}
		return false;
	}

	private static boolean isWindGradeChanged(AirConditionInfo mAirConditionInfo,
			AirConditionInfo mOldAirConditionInfo) {
		if (mAirConditionInfo.getLeftWindGrade() != mOldAirConditionInfo.getLeftWindGrade()
				||mAirConditionInfo.getRightWindGrade() != mOldAirConditionInfo.getRightWindGrade()) {
			return true;
		}
		return false;
	}

	private static boolean isHeatChanged(AirConditionInfo mAirConditionInfo,
			AirConditionInfo mOldAirConditionInfo) {
		if (mAirConditionInfo.getLeftSeatHeatGrade() != mOldAirConditionInfo.getLeftSeatHeatGrade()
				||mAirConditionInfo.getRightSeatHeatGrade() != mOldAirConditionInfo.getRightSeatHeatGrade()) {
			return true;
		}
		return false;
	}
	
	private static boolean isWindBlowChanged(AirConditionInfo mAirConditionInfo,
			AirConditionInfo mOldAirConditionInfo) {
		if ( mAirConditionInfo.isLeftWindBlowFoot() != mOldAirConditionInfo.isLeftWindBlowFoot()
			 ||mAirConditionInfo.isLeftWindBlowHead() != mOldAirConditionInfo.isLeftWindBlowHead()
			 ||mAirConditionInfo.isLeftWindBlowWindow() != mOldAirConditionInfo.isLeftWindBlowWindow()
			 ||mAirConditionInfo.isLeftWindBlowBody() != mOldAirConditionInfo.isLeftWindBlowBody()
			 ||mAirConditionInfo.isRightWindBlowFoot() != mOldAirConditionInfo.isRightWindBlowFoot()
			 ||mAirConditionInfo.isRightWindBlowHead() != mOldAirConditionInfo.isRightWindBlowHead()
			 ||mAirConditionInfo.isRightWindBlowWindow() != mOldAirConditionInfo.isRightWindBlowWindow()
			 ||mAirConditionInfo.isRightWindBlowBody() != mOldAirConditionInfo.isRightWindBlowBody()) {
			return true;
		}
		
		return false;
	}

	private static boolean isSwitchChanged(AirConditionInfo mAirConditionInfo, AirConditionInfo mOldAirConditionInfo) {
		if (mAirConditionInfo.isAcEnable() != mOldAirConditionInfo.isAcEnable()
				||mAirConditionInfo.isDualSwitch() != mOldAirConditionInfo.isDualSwitch()
				||mAirConditionInfo.isAutoSwitch1() != mOldAirConditionInfo.isAutoSwitch1()
				||mAirConditionInfo.isCircleOut() != mOldAirConditionInfo.isCircleOut()
				||mAirConditionInfo.isFrontWindowDemist() != mOldAirConditionInfo.isFrontWindowDemist()
				||mAirConditionInfo.isBackWindowDemist() != mOldAirConditionInfo.isBackWindowDemist()
				||mAirConditionInfo.isAcMaxSwitch() != mOldAirConditionInfo.isAcMaxSwitch()) {
			return true;
		}
		return false;
	}
}
