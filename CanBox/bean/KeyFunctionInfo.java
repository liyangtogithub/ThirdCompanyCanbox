package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/**
 *�����̰�������,��Ϊ�Ƕ���������״̬��������Ч�����ò����ó���
 */
public class KeyFunctionInfo extends BaseInfo{
	
	/*** �����̰������� */
	private int steerKeyFuction = Constant.PROTOCAL_INVALID_VALUE;
	/*** �������Ƿ��� */
	private boolean steeringKeyDown = false;
	/*** �������Ƿ񳤰� */
	private boolean steeringKeyLongDown = false;
	/***��ť����ֵ*/
	private int stepValue = Constant.PROTOCAL_INVALID_VALUE;
	/***��ť�������ֵ*/
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
