package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/**
 *方向盘按键功能,因为是动作，不是状态，单次有效，不得不单拿出来
 */
public class KeyFunctionInfo extends BaseInfo{
	
	/*** 方向盘按键功能 */
	private int steerKeyFuction = Constant.PROTOCAL_INVALID_VALUE;
	/*** 方向盘是否按下 */
	private boolean steeringKeyDown = false;
	/*** 方向盘是否长按 */
	private boolean steeringKeyLongDown = false;
	/***旋钮步进值*/
	private int stepValue = Constant.PROTOCAL_INVALID_VALUE;
	/***旋钮步进最大值*/
	private int stepValueMax = 30;
	
	public int getStepValueMax() {
		return stepValueMax;
	}

	public void setStepValueMax(int stepValueMax) {
		this.stepValueMax = stepValueMax;
	}

	public int getStepValue() {
		return stepValue;
	}

	public void setStepValue(int stepValue) {
		this.stepValue = stepValue;
	}

	public boolean isSteeringKeyLongDown() {
		return steeringKeyLongDown;
	}

	public void setSteeringKeyLongDown(boolean steeringKeyLongDown) {
		this.steeringKeyLongDown = steeringKeyLongDown;
	}

	public boolean isKeyDown() {
		return steeringKeyDown;
	}

	public void setKeyDown(boolean steeringKeyDown) {
		this.steeringKeyDown = steeringKeyDown;
	}
	
	public int getSteerKeyFuction() {
		return steerKeyFuction;
	}

	public void setSteerKeyFuction(int steerKeyFuction) {
		this.steerKeyFuction = steerKeyFuction;
	}

	public byte getID(){
		return Constant.ID_KEY_FUCTION ;
	};
}
