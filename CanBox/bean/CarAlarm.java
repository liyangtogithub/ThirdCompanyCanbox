package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/**
 * ���� �Ƶ��ǿˣ�Vehical warn, start-stop warn, Conv.Consumer warn
 */
public class CarAlarm extends BaseInfo {

	// ͨ��
	/*** û�ͱ���1 �� 0 �� */
	private boolean noOilWarn;
	/*** û�籨��1 �� 0 �� */
	private boolean noElecWarn;
	// ���д���ϵ��
	/*** �������ͱ��� */
	private boolean lowOilAlarm;
	/*** ��ѹ���ͱ��� */
	private boolean lowVoltageAlarm;
	/*** ��ȫ������ */
	private boolean safetyBeltAlarm;
	/*** ��ϴҺ���� */
	private boolean cleaningLiquidAlarm;

	// �Ƶ��ǿ�
	// Vehical warn
	/*** Vehical warn num ���16 */
	private byte vehicalAlarmNum;
	/*** Vehical warn 1 */
	private byte[] vehicalAlarmArray = new byte[16];

	// start-stop warn
	/*** start-stop warn num ���7 */
	private byte ssAlarmNum;
	/*** Vehical warn */
	private byte[] ssAlarmArray = new byte[7];

	// Conv.Consumer warn
	/*** Conv.Consumer warn num ���7 */
	private byte ccAlarmNum;
	/*** Conv.Consumer warn */
	private byte[] ccAlarmArray = new byte[7];

	// PSA  ��ȫ������
	/*** ��ʻԱ��ȫ����1:��ϵ;0:δϵ */
	private boolean driverBelt;
	/*** ����ʻԱ��ȫ�� 1:��ϵ;0:δϵ */
	private boolean copilotBelt;
	/*** ����ȫ�� 1:��ϵ;0:δϵ */
	private boolean backLeftBelt;
	/*** ���а�ȫ�� 1:��ϵ;0:δϵ */
	private boolean backMidBelt;
	/*** ���Ұ�ȫ�� 1:��ϵ;0:δϵ */
	private boolean backRightBelt;

	// PSA sos
	/*** sos��0:�ر� 1:������ 2���Ѿ����� */
	private byte sosState;
	/*** �澯��Ϣ 2���ֽ� */
	private int warnId;

	public int getWarnId() {
		return warnId;
	}

	public void setWarnId(int warnId) {
		this.warnId = warnId;
	}

	public byte getSosState() {
		return sosState;
	}

	public void setSosState(byte sosState) {
		this.sosState = sosState;
	}

	public boolean isCopilotBelt() {
		return copilotBelt;
	}

	public void setCopilotBelt(boolean copilotBelt) {
		this.copilotBelt = copilotBelt;
	}

	public boolean isBackLeftBelt() {
		return backLeftBelt;
	}

	public void setBackLeftBelt(boolean backLeftBelt) {
		this.backLeftBelt = backLeftBelt;
	}

	public boolean isBackMidBelt() {
		return backMidBelt;
	}

	public void setBackMidBelt(boolean backMidBelt) {
		this.backMidBelt = backMidBelt;
	}

	public boolean isBackRightBelt() {
		return backRightBelt;
	}

	public void setBackRightBelt(boolean backRightBelt) {
		this.backRightBelt = backRightBelt;
	}

	public boolean isDriverBelt() {
		return driverBelt;
	}

	public void setDriverBelt(boolean driverBelt) {
		this.driverBelt = driverBelt;
	}

	public byte getVehicalAlarmNum() {
		return vehicalAlarmNum;
	}

	public void setVehicalAlarmNum(byte vehicalAlarmNum) {
		this.vehicalAlarmNum = vehicalAlarmNum;
	}

	public byte[] getVehicalAlarmArray() {
		return vehicalAlarmArray;
	}

	public void setVehicalAlarmArray(byte[] vehicalAlarmArray) {
		this.vehicalAlarmArray = vehicalAlarmArray;
	}

	public byte getSsAlarmNum() {
		return ssAlarmNum;
	}

	public void setSsAlarmNum(byte ssAlarmNum) {
		this.ssAlarmNum = ssAlarmNum;
	}

	public byte[] getSsAlarmArray() {
		return ssAlarmArray;
	}

	public void setSsAlarmArray(byte[] ssAlarmArray) {
		this.ssAlarmArray = ssAlarmArray;
	}

	public byte getCcAlarmNum() {
		return ccAlarmNum;
	}

	public void setCcAlarmNum(byte ccAlarmNum) {
		this.ccAlarmNum = ccAlarmNum;
	}

	public byte[] getCcAlarmArray() {
		return ccAlarmArray;
	}

	public void setCcAlarmArray(byte[] ccAlarmArray) {
		this.ccAlarmArray = ccAlarmArray;
	}

	public boolean isNoOilWarn() {
		return noOilWarn;
	}

	public void setNoOilWarn(boolean noOilWarn) {
		this.noOilWarn = noOilWarn;
	}

	public boolean isNoElecWarn() {
		return noElecWarn;
	}

	public void setNoElecWarn(boolean noElecWarn) {
		this.noElecWarn = noElecWarn;
	}

	public boolean isLowOilAlarm() {
		return lowOilAlarm;
	}

	public void setLowOilAlarm(boolean lowOilAlarm) {
		this.lowOilAlarm = lowOilAlarm;
	}

	public boolean isLowVoltageAlarm() {
		return lowVoltageAlarm;
	}

	public void setLowVoltageAlarm(boolean lowVoltageAlarm) {
		this.lowVoltageAlarm = lowVoltageAlarm;
	}

	public boolean isSafetyBeltAlarm() {
		return safetyBeltAlarm;
	}

	public void setSafetyBeltAlarm(boolean safetyBeltAlarm) {
		this.safetyBeltAlarm = safetyBeltAlarm;
	}

	public boolean isCleaningLiquidAlarm() {
		return cleaningLiquidAlarm;
	}

	public void setCleaningLiquidAlarm(boolean cleaningLiquidAlarm) {
		this.cleaningLiquidAlarm = cleaningLiquidAlarm;
	}

	public byte getID() {
		return Constant.ID_CARALARM;
	};

}
