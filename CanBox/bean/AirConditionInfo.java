package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

public class AirConditionInfo extends BaseInfo{
	/*** 空调显示*/
	private boolean showAir;//true:开; false:关
	/*** 空调开关 */
	private boolean switchAir = true;
	/***循环模式,外循环*/
	private boolean circleOut ;
	
	private boolean autoSwitch1;
	private boolean autoSwitch2;
	private boolean dualSwitch;
	private boolean acMaxSwitch;
	/*** 后区空调使能*/
	private boolean backAirEnable;
	/*** A/C*/
	private boolean acEnable;
	/*** 自动除雾*/
	private boolean autoWindowDemist;
	/*** 后窗除雾*/
	private boolean backWindowDemist;
	/*** 前窗除雾*/
	private boolean frontWindowDemist;
	/*** 左边座椅加热等级 0：表示关闭 1-3：表示三个等级*/
	private int leftSeatHeatGrade = Constant.PROTOCAL_INVALID_VALUE;
	/*** 右边座椅加热等级* 0：表示关闭* 1-3：表示三个等级*/
	private int rightSeatHeatGrade = Constant.PROTOCAL_INVALID_VALUE;
	/*** 前排左座椅温度设数值*/
	private float frontLeftSeatSetTemp = Constant.PROTOCAL_INVALID_VALUE;
	/*** 前排右座椅温度设数值*/
	private float frontRightSeatSetTemp = Constant.PROTOCAL_INVALID_VALUE;
	/*** 左吹风:吹脚     有些协议不分左右吹风，就判断左边吹风模式就行*/
	private boolean leftWindBlowFoot;
	/** *左吹风:吹身     有些协议不分左右吹风，就判断左边吹风模式就行*/
	private boolean leftWindBlowBody;
	/** *左吹风:吹头*/
	private boolean leftWindBlowHead;
	/*** 左吹风:吹窗     有些协议不分左右吹风，就判断左边吹风模式就行*/
	private boolean leftWindBlowWindow;
	/*** 左风速等级:0:关;1-7:七个等级   有些协议不分左右吹风，就判断左边吹风模式就行 */
	private byte leftWindGrade;
	/*** 风速等级:总数 */
	private float WindGradeTotal =7;
	/*** 右吹风:吹脚     有些协议不分左右吹风，就判断左边吹风模式就行*/
	private boolean rightWindBlowFoot;
	/*** 右吹风:吹身     有些协议不分左右吹风，就判断左边吹风模式就行*/
	private boolean rightWindBlowBody;
	/*** 右吹风:吹头*/
	private boolean rightWindBlowHead;
	/*** 右吹风:吹窗     有些协议不分左右吹风，就判断左边吹风模式就行*/
	private boolean rightWindBlowWindow;
	/*** 右风速等级:0:关;1-7:七个等级   有些协议不分左右吹风，就判断左边吹风模式就行*/
	private byte rightWindGrade;
	/*** 车外温度*/
	private float outdoorTemp = Constant.PROTOCAL_INVALID_VALUE;;
	
	//科迪亚克
	/*** sync*/
	private boolean sync;
	/***后空调锁打开*/
	private boolean rearOpen;
	/***温度单位  1:摄氏度  0：华氏度*/
	private boolean Centigrade;
	/*** 左边座椅通风等级 0：表示关闭 1-3：表示三个等级*/
	private byte leftSeatWindGrade ;
	/*** 右边座椅通风等级* 0：表示关闭* 1-3：表示三个等级*/
	private byte rightSeatWindGrade ;
	/*** 自动风量等级* 0：表示低* 1：表示中 2：高*/
	private byte autoWindGrade ;
	/*** 净化空气*/
	private boolean clearAirEnable ;
	/*** 方向盘加热*/
	private boolean steeringWheelHeat ;
	/*** 座椅方向盘同步*/
	private boolean syncSteeringWheelSeat ;
	/*** 送风模式 0:关 ，1：自动*/
	private boolean autoWindMode ;
	/*** 后排座椅温度设数值*/
	private float backSeatSetTemp = Constant.PROTOCAL_INVALID_VALUE;
	//福特
	private boolean maxHeat;
	/***后排控制面板  1:开  0：关*/
	private boolean backPanel;
	/***后排风速 1--7 */
	private byte backWindGrade;
	/***后排温度 1--9 */
	private byte backTemp;
	//PSA
	/***单一温区  1:开  0：关*/
	private boolean mono;
	/*** 风量等级* 0：表示低* 1：表示中 2：高*/
	private byte windGrade ;
	//通用
	/*** HybridAC  ：HybridAC 开*/
	private boolean HybridAC;
	/*** 通用sync 0：关  1：开   2：没准备好  3：不支持*/
	private byte gmSync;
	/***副驾座椅加热/通风  1通风  0加热*/
	private byte copilotStates;
	/***主驾座椅加热/通风 1通风  0加热*/
	private byte mainStates;
	/***空气质量*/
	private boolean airQualEnable;
	/***后排风速模式  0关 1自动  2吹脚 3吹身吹脚 4吹身 */
	private byte backWindMode;
	/***后排风速信息  0关 1-4手动速度 5自动风速*/
	private byte backWindInfo;
	/***自动内外循环 设定  1:开  0：关*/
	private boolean autocyclicModeSet;
	
	/*** 自动风量模式 许可 1:有效 0：无效 */
	private boolean autoWindQuantityPermit;
	/***前窗自动去雾 许可  1:有效  0：无效*/
	private boolean autoFrontWindowDemistPermit;
	/***前窗自动去雾 设定  1:开  0：关*/
	private boolean autoFrontWindowDemistSet;
	// 许可
	/*** 空调模式设定 许可 1:有效 0：无效 */
	private boolean airModePermit;
	/*** 空气质量传感器1设定 许可 1:有效 0：无效 */
	private boolean airSensor1Permit;
	/*** 自动区域温度设定 许可 1:有效 0：无效 */
	private boolean aotoTempPermit;
	/*** 座椅自动通风设定 许可 1:有效 0：无效 */
	private boolean seatWindPermit;
	/*** 座椅自动加热设定 许可 1:有效 0：无效 */
	private boolean seatHeatPermit;
	/*** 遥控启动座椅自动通风设定 许可 1:有效 0：无效 */
	private boolean remoteSeatWindPermit;
	/*** 遥控启动座椅自动加热设定 许可 1:有效 0：无效 */
	private boolean remoteSeatHeatPermit;

	/*** 后座区域温度设定 许可 1:有效 0：无效 */
	private boolean backTempPermit;
	/*** 后窗自动去雾设定 许可 1:有效 0：无效 */
	private boolean autoBackWindowDemistPermit;
	/*** 遥控启动空调设定 许可 1:有效 0：无效 */
	private boolean remoteStartAirPermit;
	/*** 空气质量传感器2设定 许可 1:有效 0：无效 */
	private boolean airSensor2Permit;
	/*** 远程启动座椅自动加热1 许可 1:有效 0：无效 */
	private boolean remoteSeatHeat1Permit;
	// 设定
	/*** 自动风量模式 0低 1中 2高 */
	private byte autoWindQuantitySet;
	/*** 空调模式设定 0关 1开 2上次设置 */
	private byte airModeSet;
	/*** 空气质量传感器1设定 0低敏感度 1高敏感度 2关 */
	private byte airSensor1Set;
	/*** 自动区域温度设定 0统一设置 1分区设置 2上次设定 */
	private byte aotoTempSet;
	/*** 座椅自动通风设定 1:开 0：关 */
	private boolean seatWindSet;
	/*** 座椅自动加热设定 1:开 0：关 */
	private boolean seatHeatSet;
	/*** 遥控启动座椅自动通风设定 1:开 0：关 */
	private boolean remoteSeatWindSet;
	/*** 遥控启动座椅自动加热设定 1:开 0：关 */
	private boolean remoteSeatHeatSet;

	/*** 后座区域温度设定 0关 1同前区一样 2上次设定 */
	private byte backTempSet;
	/*** 后窗自动去雾设定 1:自动 0：手动 */
	private boolean autoBackWindowDemistSet;
	/*** 遥控启动空调设定 1:自动 0：手动 */
	private boolean remoteStartAirSet;
	/*** 空气质量传感器2设定 0低灵敏度 1高敏感度 2关 */
	private byte airSensor2Set;
	/*** 远程启动座椅自动加热1 0关 1驾驶员和乘客 2驾驶员 */
	private byte remoteSeatHeat1Set;
	//科迪亚克
	/***自动内外循环 许可  1:有效  0：无效*/
	private boolean autocyclicModePermit;
	//本田
	/***状态*/
	private boolean climateDown;
	
	public float getWindGradeTotal() {
		return WindGradeTotal;
	}
	public void setWindGradeTotal(float windGradeTotal) {
		WindGradeTotal = windGradeTotal;
	}
	public boolean isClimateDown() {
		return climateDown;
	}
	public void setClimateDown(boolean climateDown) {
		this.climateDown = climateDown;
	}
	public boolean isAutocyclicModePermit() {
		return autocyclicModePermit;
	}
	public void setAutocyclicModePermit(boolean autocyclicModePermit) {
		this.autocyclicModePermit = autocyclicModePermit;
	}
	
	public boolean isAutoFrontWindowDemistSet() {
		return autoFrontWindowDemistSet;
	}
	
	public void setAutoFrontWindowDemistSet(boolean autoFrontWindowDemistSet) {
		this.autoFrontWindowDemistSet = autoFrontWindowDemistSet;
	}
	public boolean isAutoFrontWindowDemistPermit() {
		return autoFrontWindowDemistPermit;
	}
	
	public void setAutoFrontWindowDemistPermit(boolean autoFrontWindowDemistPermit) {
		this.autoFrontWindowDemistPermit = autoFrontWindowDemistPermit;
	}
	public boolean isAutoWindQuantityPermit() {
		return autoWindQuantityPermit;
	}

	public void setAutoWindQuantityPermit(boolean autoWindQuantityPermit) {
		this.autoWindQuantityPermit = autoWindQuantityPermit;
	}

	public boolean isAirModePermit() {
		return airModePermit;
	}

	public void setAirModePermit(boolean airModePermit) {
		this.airModePermit = airModePermit;
	}

	public boolean isAirSensor1Permit() {
		return airSensor1Permit;
	}

	public void setAirSensor1Permit(boolean airSensor1Permit) {
		this.airSensor1Permit = airSensor1Permit;
	}

	public boolean isAotoTempPermit() {
		return aotoTempPermit;
	}

	public void setAotoTempPermit(boolean aotoTempPermit) {
		this.aotoTempPermit = aotoTempPermit;
	}

	public boolean isSeatWindPermit() {
		return seatWindPermit;
	}

	public void setSeatWindPermit(boolean seatWindPermit) {
		this.seatWindPermit = seatWindPermit;
	}

	public boolean isSeatHeatPermit() {
		return seatHeatPermit;
	}

	public void setSeatHeatPermit(boolean seatHeatPermit) {
		this.seatHeatPermit = seatHeatPermit;
	}

	public boolean isRemoteSeatWindPermit() {
		return remoteSeatWindPermit;
	}

	public void setRemoteSeatWindPermit(boolean remoteSeatWindPermit) {
		this.remoteSeatWindPermit = remoteSeatWindPermit;
	}

	public boolean isRemoteSeatHeatPermit() {
		return remoteSeatHeatPermit;
	}

	public void setRemoteSeatHeatPermit(boolean remoteSeatHeatPermit) {
		this.remoteSeatHeatPermit = remoteSeatHeatPermit;
	}

	public boolean isBackTempPermit() {
		return backTempPermit;
	}

	public void setBackTempPermit(boolean backTempPermit) {
		this.backTempPermit = backTempPermit;
	}

	public boolean isAutoBackWindowDemistPermit() {
		return autoBackWindowDemistPermit;
	}

	public void setAutoBackWindowDemistPermit(boolean autoBackWindowDemistPermit) {
		this.autoBackWindowDemistPermit = autoBackWindowDemistPermit;
	}

	public boolean isRemoteStartAirPermit() {
		return remoteStartAirPermit;
	}

	public void setRemoteStartAirPermit(boolean remoteStartAirPermit) {
		this.remoteStartAirPermit = remoteStartAirPermit;
	}

	public boolean isAirSensor2Permit() {
		return airSensor2Permit;
	}

	public void setAirSensor2Permit(boolean airSensor2Permit) {
		this.airSensor2Permit = airSensor2Permit;
	}

	public boolean isRemoteSeatHeat1Permit() {
		return remoteSeatHeat1Permit;
	}

	public void setRemoteSeatHeat1Permit(boolean remoteSeatHeat1Permit) {
		this.remoteSeatHeat1Permit = remoteSeatHeat1Permit;
	}

	public byte getAutoWindQuantitySet() {
		return autoWindQuantitySet;
	}

	public void setAutoWindQuantitySet(byte autoWindQuantitySet) {
		this.autoWindQuantitySet = autoWindQuantitySet;
	}

	public byte getAirModeSet() {
		return airModeSet;
	}

	public void setAirModeSet(byte airModeSet) {
		this.airModeSet = airModeSet;
	}

	public byte getAirSensor1Set() {
		return airSensor1Set;
	}

	public void setAirSensor1Set(byte airSensor1Set) {
		this.airSensor1Set = airSensor1Set;
	}

	public byte getAotoTempSet() {
		return aotoTempSet;
	}

	public void setAotoTempSet(byte aotoTempSet) {
		this.aotoTempSet = aotoTempSet;
	}

	public boolean isSeatWindSet() {
		return seatWindSet;
	}

	public void setSeatWindSet(boolean seatWindSet) {
		this.seatWindSet = seatWindSet;
	}

	public boolean isSeatHeatSet() {
		return seatHeatSet;
	}

	public void setSeatHeatSet(boolean seatHeatSet) {
		this.seatHeatSet = seatHeatSet;
	}

	public boolean isRemoteSeatWindSet() {
		return remoteSeatWindSet;
	}

	public void setRemoteSeatWindSet(boolean remoteSeatWindSet) {
		this.remoteSeatWindSet = remoteSeatWindSet;
	}

	public boolean isRemoteSeatHeatSet() {
		return remoteSeatHeatSet;
	}

	public void setRemoteSeatHeatSet(boolean remoteSeatHeatSet) {
		this.remoteSeatHeatSet = remoteSeatHeatSet;
	}

	public byte getBackTempSet() {
		return backTempSet;
	}

	public void setBackTempSet(byte backTempSet) {
		this.backTempSet = backTempSet;
	}

	public boolean isAutoBackWindowDemistSet() {
		return autoBackWindowDemistSet;
	}

	public void setAutoBackWindowDemistSet(boolean autoBackWindowDemistSet) {
		this.autoBackWindowDemistSet = autoBackWindowDemistSet;
	}

	public boolean isRemoteStartAirSet() {
		return remoteStartAirSet;
	}

	public void setRemoteStartAirSet(boolean remoteStartAirSet) {
		this.remoteStartAirSet = remoteStartAirSet;
	}

	public byte getAirSensor2Set() {
		return airSensor2Set;
	}

	public void setAirSensor2Set(byte airSensor2Set) {
		this.airSensor2Set = airSensor2Set;
	}

	public byte getRemoteSeatHeat1Set() {
		return remoteSeatHeat1Set;
	}

	public void setRemoteSeatHeat1Set(byte remoteSeatHeat1Set) {
		this.remoteSeatHeat1Set = remoteSeatHeat1Set;
	}
	
	public byte getID(){
		return Constant.ID_AIRCONDITION;
	};
	
	public boolean isAutoWindowDemist() {
		return autoWindowDemist;
	}

	public void setAutoWindowDemist(boolean autoWindowDemist) {
		this.autoWindowDemist = autoWindowDemist;
	}

	public byte getBackWindMode() {
		return backWindMode;
	}

	public void setBackWindMode(byte backWindMode) {
		this.backWindMode = backWindMode;
	}

	public byte getBackWindInfo() {
		return backWindInfo;
	}

	public void setBackWindInfo(byte backWindInfo) {
		this.backWindInfo = backWindInfo;
	}

	public byte getCopilotStates() {
		return copilotStates;
	}

	public void setCopilotStates(byte copilotStates) {
		this.copilotStates = copilotStates;
	}

	public byte getMainStates() {
		return mainStates;
	}

	public void setMainStates(byte mainStates) {
		this.mainStates = mainStates;
	}

	public boolean isAirQualEnable() {
		return airQualEnable;
	}

	public void setAirQualEnable(boolean airQualEnable) {
		this.airQualEnable = airQualEnable;
	}

	public byte getGmSync() {
		return gmSync;
	}

	public void setGmSync(byte gmSync) {
		this.gmSync = gmSync;
	}

	public boolean isHybridAC() {
		return HybridAC;
	}

	public void setHybridAC(boolean hybridAC) {
		HybridAC = hybridAC;
	}

	public byte getWindGrade() {
		return windGrade;
	}

	public void setWindGrade(byte windGrade) {
		this.windGrade = windGrade;
	}

	public boolean isMono() {
		return mono;
	}

	public void setMono(boolean mono) {
		this.mono = mono;
	}

	public boolean isBackPanel() {
		return backPanel;
	}

	public void setBackPanel(boolean backPanel) {
		this.backPanel = backPanel;
	}

	public byte getBackWindGrade() {
		return backWindGrade;
	}

	public void setBackWindGrade(byte backWindGrade) {
		this.backWindGrade = backWindGrade;
	}

	public byte getBackTemp() {
		return backTemp;
	}

	public void setBackTemp(byte backTemp) {
		this.backTemp = backTemp;
	}

	public boolean isMaxHeat() {
		return maxHeat;
	}

	public void setMaxHeat(boolean maxHeat) {
		this.maxHeat = maxHeat;
	}

	public boolean isAutocyclicModeSet() {
		return autocyclicModeSet;
	}
	public void setAutocyclicModeSet(boolean autocyclicModeSet) {
		this.autocyclicModeSet = autocyclicModeSet;
	}
	public boolean isSync() {
		return sync;
	}
	public void setSync(boolean sync) {
		this.sync = sync;
	}
	public boolean isRearOpen() {
		return rearOpen;
	}
	public void setRearOpen(boolean rearOpen) {
		this.rearOpen = rearOpen;
	}
	public boolean isCentigrade() {
		return Centigrade;
	}
	public void setCentigrade(boolean Centigrade) {
		this.Centigrade = Centigrade;
	}
	public byte getLeftSeatWindGrade() {
		return leftSeatWindGrade;
	}
	public void setLeftSeatWindGrade(byte leftSeatWindGrade) {
		this.leftSeatWindGrade = leftSeatWindGrade;
	}
	public byte getRightSeatWindGrade() {
		return rightSeatWindGrade;
	}
	public void setRightSeatWindGrade(byte rightSeatWindGrade) {
		this.rightSeatWindGrade = rightSeatWindGrade;
	}
	public byte getAutoWindGrade() {
		return autoWindGrade;
	}
	public void setAutoWindGrade(byte autoWindGrade) {
		this.autoWindGrade = autoWindGrade;
	}
	public boolean isClearAirEnable() {
		return clearAirEnable;
	}
	public void setClearAirEnable(boolean clearAirEnable) {
		this.clearAirEnable = clearAirEnable;
	}
	public boolean isSteeringWheelHeat() {
		return steeringWheelHeat;
	}
	public void setSteeringWheelHeat(boolean steeringWheelHeat) {
		this.steeringWheelHeat = steeringWheelHeat;
	}
	public boolean isSyncSteeringWheelSeat() {
		return syncSteeringWheelSeat;
	}
	public void setSyncSteeringWheelSeat(boolean syncSteeringWheelSeat) {
		this.syncSteeringWheelSeat = syncSteeringWheelSeat;
	}
	public boolean getAutoWindMode() {
		return autoWindMode;
	}
	public void setAutoWindMode(boolean windMode) {
		this.autoWindMode = windMode;
	}
	public float getBackSeatSetTemp() {
		return backSeatSetTemp;
	}
	public void setBackSeatSetTemp(float backSeatSetTemp) {
		this.backSeatSetTemp = backSeatSetTemp;
	}
	public boolean isShowAir() {
		return showAir;
	}
	public void setShowAir(boolean showAir) {
		this.showAir = showAir;
	}
	public boolean isSwitchAir() {
		return switchAir;
	}
	public void setSwitchAir(boolean switchAir) {
		this.switchAir = switchAir;
	}
	
	public boolean isCircleOut() {
		return circleOut;
	}

	public void setCircleOut(boolean circleOut) {
		this.circleOut = circleOut;
	}

	public boolean isAutoSwitch1() {
		return autoSwitch1;
	}
	public void setAutoSwitch1(boolean autoSwitch1) {
		this.autoSwitch1 = autoSwitch1;
	}
	public boolean isAutoSwitch2() {
		return autoSwitch2;
	}
	public void setAutoSwitch2(boolean autoSwitch2) {
		this.autoSwitch2 = autoSwitch2;
	}
	public boolean isDualSwitch() {
		return dualSwitch;
	}
	public void setDualSwitch(boolean dualSwitch) {
		this.dualSwitch = dualSwitch;
	}
	public boolean isAcMaxSwitch() {
		return acMaxSwitch;
	}
	public void setAcMaxSwitch(boolean acMaxSwitch) {
		this.acMaxSwitch = acMaxSwitch;
	}
	public boolean isBackAirEnable() {
		return backAirEnable;
	}
	public void setBackAirEnable(boolean backAirEnable) {
		this.backAirEnable = backAirEnable;
	}
	public boolean isAcEnable() {
		return acEnable;
	}
	public void setAcEnable(boolean acEnable) {
		this.acEnable = acEnable;
	}
	public boolean isBackWindowDemist() {
		return backWindowDemist;
	}
	public void setBackWindowDemist(boolean backWindowDemist) {
		this.backWindowDemist = backWindowDemist;
	}
	public boolean isFrontWindowDemist() {
		return frontWindowDemist;
	}
	public void setFrontWindowDemist(boolean frontWindowDemist) {
		this.frontWindowDemist = frontWindowDemist;
	}
	public int getLeftSeatHeatGrade() {
		return leftSeatHeatGrade;
	}
	public void setLeftSeatHeatGrade(int leftSeatHeatGrade) {
		this.leftSeatHeatGrade = leftSeatHeatGrade;
	}
	public int getRightSeatHeatGrade() {
		return rightSeatHeatGrade;
	}
	public void setRightSeatHeatGrade(int rightSeatHeatGrade) {
		this.rightSeatHeatGrade = rightSeatHeatGrade;
	}
	public float getFrontLeftSeatSetTemp() {
		return frontLeftSeatSetTemp;
	}
	public void setFrontLeftSeatSetTemp(float frontLeftSeatSetTemp) {
		this.frontLeftSeatSetTemp = frontLeftSeatSetTemp;
	}
	public float getFrontRightSeatSetTemp() {
		return frontRightSeatSetTemp;
	}
	public void setFrontRightSeatSetTemp(float frontRightSeatSetTemp) {
		this.frontRightSeatSetTemp = frontRightSeatSetTemp;
	}
	public boolean isLeftWindBlowFoot() {
		return leftWindBlowFoot;
	}
	public void setLeftWindBlowFoot(boolean leftWindBlowFoot) {
		this.leftWindBlowFoot = leftWindBlowFoot;
	}
	public boolean isLeftWindBlowBody() {
		return leftWindBlowBody;
	}
	public void setLeftWindBlowBody(boolean leftWindBlowBody) {
		this.leftWindBlowBody = leftWindBlowBody;
	}
	
	public boolean isLeftWindBlowHead() {
		return leftWindBlowHead;
	}

	public void setLeftWindBlowHead(boolean leftWindBlowHead) {
		this.leftWindBlowHead = leftWindBlowHead;
	}

	public boolean isLeftWindBlowWindow() {
		return leftWindBlowWindow;
	}
	public void setLeftWindBlowWindow(boolean leftWindBlowWindow) {
		this.leftWindBlowWindow = leftWindBlowWindow;
	}
	public byte getLeftWindGrade() {
		return leftWindGrade;
	}
	public void setLeftWindGrade(byte leftWindGrade) {
		this.leftWindGrade = leftWindGrade;
	}
	public boolean isRightWindBlowFoot() {
		return rightWindBlowFoot;
	}
	public void setRightWindBlowFoot(boolean rightWindBlowFoot) {
		this.rightWindBlowFoot = rightWindBlowFoot;
	}
	public boolean isRightWindBlowBody() {
		return rightWindBlowBody;
	}
	public void setRightWindBlowBody(boolean rightWindBlowBody) {
		this.rightWindBlowBody = rightWindBlowBody;
	}
	
	public boolean isRightWindBlowHead() {
		return rightWindBlowHead;
	}

	public void setRightWindBlowHead(boolean rightWindBlowHead) {
		this.rightWindBlowHead = rightWindBlowHead;
	}

	public boolean isRightWindBlowWindow() {
		return rightWindBlowWindow;
	}
	public void setRightWindBlowWindow(boolean rightWindBlowWindow) {
		this.rightWindBlowWindow = rightWindBlowWindow;
	}
	public byte getRightWindGrade() {
		return rightWindGrade;
	}
	public void setRightWindGrade(byte rightWindGrade) {
		this.rightWindGrade = rightWindGrade;
	}
	public float getOutdoorTemp() {
		return outdoorTemp;
	}
	public void setOutdoorTemp(float outdoorTemp) {
		this.outdoorTemp = outdoorTemp;
	}
	
}
