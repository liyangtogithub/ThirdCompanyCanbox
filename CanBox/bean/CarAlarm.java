package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/**
 * 报警 科迪亚克：Vehical warn, start-stop warn, Conv.Consumer warn
 */
public class CarAlarm extends BaseInfo {

	// 通用
	/*** 没油报警1 开 0 关 */
	private boolean noOilWarn;
	/*** 没电报警1 开 0 关 */
	private boolean noElecWarn;
	// 所有大众系列
	/*** 油量过低报警 */
	private boolean lowOilAlarm;
	/*** 电压过低报警 */
	private boolean lowVoltageAlarm;
	/*** 安全带报警 */
	private boolean safetyBeltAlarm;
	/*** 清洗液报警 */
	private boolean cleaningLiquidAlarm;

	// 科迪亚克
	// Vehical warn
	/*** Vehical warn num 最大16 */
	private byte vehicalAlarmNum;
	/*** Vehical warn 1 */
	private byte[] vehicalAlarmArray = new byte[16];

	// start-stop warn
	/*** start-stop warn num 最大7 */
	private byte ssAlarmNum;
	/*** Vehical warn */
	private byte[] ssAlarmArray = new byte[7];

	// Conv.Consumer warn
	/*** Conv.Consumer warn num 最大7 */
	private byte ccAlarmNum;
	/*** Conv.Consumer warn */
	private byte[] ccAlarmArray = new byte[7];

	// PSA  安全带报警
	/*** 驾驶员安全带：1:已系;0:未系 */
	private boolean driverBelt;
	/*** 副驾驶员安全带 1:已系;0:未系 */
	private boolean copilotBelt;
	/*** 后左安全带 1:已系;0:未系 */
	private boolean backLeftBelt;
	/*** 后中安全带 1:已系;0:未系 */
	private boolean backMidBelt;
	/*** 后右安全带 1:已系;0:未系 */
	private boolean backRightBelt;

	// PSA sos
	/*** sos：0:关闭 1:呼叫中 2：已经连接 */
	private byte sosState;
	/*** 告警信息 2个字节 */
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
