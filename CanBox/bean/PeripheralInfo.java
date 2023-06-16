package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;
/**
 * 车周边设备信息：灯，后视镜，刮水器，摄像头，左右转向灯，轮胎信息
 */
public class PeripheralInfo extends BaseInfo{
	
	
	public byte getID(){
		return Constant.ID_PERIPHERAL;
	};
	//车内灯光使能位 
	/***环境照明颜色  许可  1:有效  0：无效*/
	private boolean lightColorPermit;
	/***车内氛围照明  许可  1:有效  0：无效*/
	private boolean lightAmbientPermit;
	/***右前室调照明  许可  1:有效  0：无效*/
	private boolean lightAdjustPermit;
	/***环境照明颜色  设置    0：关闭  1:白色  2：橙色 3：蓝色*/
	private byte lightColorSet;
	/***车内氛围照明  设置  0--100*/
	private byte lightAmbientSet;
	/***右前室调照明  设置  0--100*/
	private byte lightAdjustSet;
	//灯光辅助使能位 许可
	/***动态灯光辅助  许可  1:有效  0：无效*/
	private boolean dynamicAssistPermit;
	/***动态大灯随动  许可  1:有效  0：无效*/
	private boolean dynamicBendPermit;
	/***打开时间  许可  1:有效  0：无效*/
	private boolean openTimePermit;
	/***自动行车灯  许可  1:有效  0：无效*/
	private boolean autoLightPermit;
	/***变道转向灯  许可  1:有效  0：无效*/
	private boolean laneChangePermit;
	/***旅行模式  许可  1:有效  0：无效*/
	private boolean travelModePermit;
	/***日间行车灯  许可  1:有效  0：无效*/
	private boolean dayLightPermit;
	//灯光辅助  设置
	/*** 动态灯光辅助  设置 1:开  0：关 */
	private boolean dynamicAssistSet;
	/*** 动态大灯随动  设置 1:开  0：关 */
	private boolean dynamicBendSet;
	/*** 打开时间  设置 1:开  0：关  */
	private byte openTimeSet;
	/*** 自动行车灯  设置 1:开  0：关  */
	private boolean autoLightSet;
	/*** 变道转向灯 设置 1:开  0：关  */
	private boolean laneChangeSet;
	/*** 旅行模式  设置  1:靠右 0：靠左 */
	private byte travelModeSet;
	/*** 日间行车灯 设置 1:开  0：关  */
	private boolean dayLightSet;
	//室内灯光使能位
	/***仪表/开关照明  许可  1:有效  0：无效*/
	private boolean switchLightPermit;
	/***车门环境照明灯  许可  1:有效  0：无效*/
	private boolean doorLightPermit;
	/***脚部空间照明  许可  1:有效  0：无效*/
	private boolean footLightPermit;
	/***回家照明  许可  1:有效  0：无效*/
	private boolean homeLightPermit;
	/***离家照明  许可  1:有效  0：无效*/
	private boolean leaveLightPermit;
	// 室内灯光使能位
	/*** 仪表/开关照明 设置 0--100% */
	private byte switchLightSet;
	/*** 车门环境照明灯 设置 0--100% */
	private byte doorLightSet;
	/*** 脚部空间照明 设置 0--100% */
	private byte footLightSet;
	/*** 回家照明 设置 0--30 */
	private byte homeLightSet;
	/*** 离家照明 设置 0--30 */
	private byte leaveLightSet;
	
	/*** 左转向灯 设置 1:开  0：关  */
	private boolean leftLightSet;
	/*** 右转向灯 设置 1:开  0：关  */
	private boolean rightLightSet;
	
	/*** 摄像头模式  01：广角视图  02：标准视图  03：俯视视图  09：延边视图 */
	private byte cameraMode;
	/*** 摄像头开关  1 开  2 关 */
	private boolean cameraOn;
	/*** 摄像头延时  1 开  0 关 */
	private boolean cameraDelayed;
	/*** 右摄像头开关*/
	private boolean cameraOnRight;
	// 后视镜，刮水器 许可
	/***同步调节  许可  1:有效  0：无效*/
	private boolean synchroAdjustPermit;
	/***倒车时后视镜下转  许可  1:有效  0：无效*/
	private boolean lowerReversPermit;
	/***停车时后视镜内折  许可  1:有效  0：无效*/
	private boolean foldParkedPermit;
	/***雨天自动刮水  许可  1:有效  0：无效*/
	private boolean wipingRainPermit;
	/***倒车时后窗玻璃刮水  许可  1:有效  0：无效*/
	private boolean rearWipingReversPermit;
	// 后视镜，刮水器 设置
	/***同步调节  设置  1:开  0：关*/
	private boolean synchroAdjustSet;
	/***倒车时后视镜下转  设置   1:开  0：关*/
	private boolean lowerReversSet;
	/***停车时后视镜内折  设置   1:开  0：关*/
	private boolean foldParkedSet;
	/***雨天自动刮水  设置   1:开  0：关*/
	private boolean wipingRainSet;
	/***倒车时后窗玻璃刮水  设置   1:开  0：关*/
	private boolean rearWipingReversSet;
	// 轮胎
	/***轮胎压力监控显示 许可  1:有效  0：无效*/
	private boolean tyerMonitorShowPermit;
	/***冬季轮胎车速报警 许可  1:有效  0：无效*/
	private boolean tyerSpeedWarningPermit;
	/***冬季轮胎车速报警 设定   1:开  0：关*/
	private boolean tyerSpeedWarningSet;
	/***轮胎车速报警值   */
	private int tyerSpeedValue;
	//通用 照明  许可
	/***寻车灯功能设定 许可  1:有效  0：无效*/
	private boolean findLightPermit;
	/***落锁大灯延时设定 许可  1:有效  0：无效*/
	private boolean lightDelayPermit;
	/***转向灯 许可  1:有效  0：无效*/
	private boolean turnLightPermit;
	//通用 照明  设定
	/***寻车灯功能设定  1:开 0：关*/
	private boolean findLightSet;
	/***落锁大灯延时设定    0:关 1:30s 2:60s 3:120s*/
	private byte lightDelaySet;
	/***右转向灯  1:开 0：关*/
	private boolean turnLightRSet;
	/***左转向灯  1:开 0：关*/
	private boolean turnLightLSet;
	//通用 胎压
	/***胎压监测  1:有效  0：无效*/
	private boolean tyerMonitorPermit;
	/***左前胎压值*/
	private int tyerLFValue;
	/***右前胎压值*/
	private int tyerRFValue;
	/***左后胎压值*/
	private int tyerLBValue;
	/***右后胎压值*/
	private int tyerRBValue;
	/***备胎胎压值*/
	private int tyerSValue;
	
	/***左前胎检查胎压提示*/
	private boolean tyerLFWarn;
	/***左前胎胎压低报警*/
	private boolean tyerLFLow;
	/***左前胎胎压高报警*/
	private boolean tyerLFHigh;
	/***右前胎检查胎压提示*/
	private boolean tyerRFWarn;
	/***右前胎胎压低报警*/
	private boolean tyerRFLow;
	/***右前胎胎压高报警*/
	private boolean tyerRFHigh;
	/***左后胎检查胎压提示*/
	private boolean tyerLBWarn;
	/***左后胎胎压低报警*/
	private boolean tyerLBLow;
	/***左后胎胎压高报警*/
	private boolean tyerLBHigh;
	/***右后胎检查胎压提示*/
	private boolean tyerRBWarn;
	/***右后胎胎压低报警*/
	private boolean tyerRBLow;
	/***右后胎胎压高报警*/
	private boolean tyerRBHigh;
	//通用  指南针
	/***指南针有效 */
	private boolean compassPermit;
	/***校准 */
	private boolean compassCalib;
	/***区域 1--15 */
	private byte compassArea;
	/***角度  */
	private float compassAngle;
	//通用  仪表许可
	/***混合动力ECO指示 */
	private boolean meterEcoPermit;
	/***仪表导航信息 */
	private boolean meterNavPermit;
	/***速度范围提示 */
	private boolean meterSpePermit;
	//通用  仪表设置
    /***混合动力ECO指示 1开 0关 */
	private boolean meterEcoSet;
	/***仪表导航信息  1开 0关 */
	private boolean meterNavSet;
	/***速度范围提示  1全部 0局部 */
	private boolean meterSpeAllSet;
	//通用  发声请求命令
	/***命令 */
	private byte soundOrder;
	/***次数 */
	private byte soundTimes;
	
	public boolean isCameraOnRight() {
		return cameraOnRight;
	}
	public void setCameraOnRight(boolean cameraOnRight) {
		this.cameraOnRight = cameraOnRight;
	}
	public byte getSoundOrder() {
		return soundOrder;
	}
	public void setSoundOrder(byte soundOrder) {
		this.soundOrder = soundOrder;
	}
	public byte getSoundTimes() {
		return soundTimes;
	}
	public void setSoundTimes(byte soundTimes) {
		this.soundTimes = soundTimes;
	}
	public boolean isMeterEcoPermit() {
		return meterEcoPermit;
	}
	public void setMeterEcoPermit(boolean meterEcoPermit) {
		this.meterEcoPermit = meterEcoPermit;
	}
	public boolean isMeterNavPermit() {
		return meterNavPermit;
	}
	public void setMeterNavPermit(boolean meterNavPermit) {
		this.meterNavPermit = meterNavPermit;
	}
	public boolean isMeterSpePermit() {
		return meterSpePermit;
	}
	public void setMeterSpePermit(boolean meterSpePermit) {
		this.meterSpePermit = meterSpePermit;
	}
	public boolean isMeterEcoSet() {
		return meterEcoSet;
	}
	public void setMeterEcoSet(boolean meterEcoSet) {
		this.meterEcoSet = meterEcoSet;
	}
	public boolean isMeterNavSet() {
		return meterNavSet;
	}
	public void setMeterNavSet(boolean meterNavSet) {
		this.meterNavSet = meterNavSet;
	}
	public boolean isMeterSpeAllSet() {
		return meterSpeAllSet;
	}
	public void setMeterSpeAllSet(boolean meterSpeAllSet) {
		this.meterSpeAllSet = meterSpeAllSet;
	}
	public boolean isCompassPermit() {
		return compassPermit;
	}
	public void setCompassPermit(boolean compassPermit) {
		this.compassPermit = compassPermit;
	}
	public boolean isCompassCalib() {
		return compassCalib;
	}
	public void setCompassCalib(boolean compassCalib) {
		this.compassCalib = compassCalib;
	}
	public byte getCompassArea() {
		return compassArea;
	}
	public void setCompassArea(byte compassArea) {
		this.compassArea = compassArea;
	}
	public float getCompassAngle() {
		return compassAngle;
	}
	public void setCompassAngle(float d) {
		this.compassAngle = d;
	}
	public boolean isTyerMonitorPermit() {
		return tyerMonitorPermit;
	}
	public void setTyerMonitorPermit(boolean tyerMonitorPermit) {
		this.tyerMonitorPermit = tyerMonitorPermit;
	}
	public int getTyerLFValue() {
		return tyerLFValue;
	}
	public void setTyerLFValue(int tyerLFValue) {
		this.tyerLFValue = tyerLFValue;
	}
	public int getTyerLBValue() {
		return tyerLBValue;
	}
	public void setTyerLBValue(int tyerLBValue) {
		this.tyerLBValue = tyerLBValue;
	}
	public int getTyerRFValue() {
		return tyerRFValue;
	}
	public void setTyerRFValue(int tyerRFValue) {
		this.tyerRFValue = tyerRFValue;
	}
	public int getTyerRBValue() {
		return tyerRBValue;
	}
	public void setTyerRBValue(int tyerRBValue) {
		this.tyerRBValue = tyerRBValue;
	}
	public int getTyerSValue() {
		return tyerSValue;
	}
	public void setTyerSValue(int tyerSValue) {
		this.tyerSValue = tyerSValue;
	}
	public boolean isTyerLFWarn() {
		return tyerLFWarn;
	}
	public void setTyerLFWarn(boolean tyerLFWarn) {
		this.tyerLFWarn = tyerLFWarn;
	}
	public boolean isTyerLFLow() {
		return tyerLFLow;
	}
	public void setTyerLFLow(boolean tyerLFLow) {
		this.tyerLFLow = tyerLFLow;
	}
	public boolean isTyerLFHigh() {
		return tyerLFHigh;
	}
	public void setTyerLFHigh(boolean tyerLFHigh) {
		this.tyerLFHigh = tyerLFHigh;
	}
	public boolean isTyerRFWarn() {
		return tyerRFWarn;
	}
	public void setTyerRFWarn(boolean tyerRFWarn) {
		this.tyerRFWarn = tyerRFWarn;
	}
	public boolean isTyerRFLow() {
		return tyerRFLow;
	}
	public void setTyerRFLow(boolean tyerRFLow) {
		this.tyerRFLow = tyerRFLow;
	}
	public boolean isTyerRFHigh() {
		return tyerRFHigh;
	}
	public void setTyerRFHigh(boolean tyerRFHigh) {
		this.tyerRFHigh = tyerRFHigh;
	}
	public boolean isTyerLBWarn() {
		return tyerLBWarn;
	}
	public void setTyerLBWarn(boolean tyerLBWarn) {
		this.tyerLBWarn = tyerLBWarn;
	}
	public boolean isTyerLBLow() {
		return tyerLBLow;
	}
	public void setTyerLBLow(boolean tyerLBLow) {
		this.tyerLBLow = tyerLBLow;
	}
	public boolean isTyerLBHigh() {
		return tyerLBHigh;
	}
	public void setTyerLBHigh(boolean tyerLBHigh) {
		this.tyerLBHigh = tyerLBHigh;
	}
	public boolean isTyerRBWarn() {
		return tyerRBWarn;
	}
	public void setTyerRBWarn(boolean tyerRBWarn) {
		this.tyerRBWarn = tyerRBWarn;
	}
	public boolean isTyerRBLow() {
		return tyerRBLow;
	}
	public void setTyerRBLow(boolean tyerRBLow) {
		this.tyerRBLow = tyerRBLow;
	}
	public boolean isTyerRBHigh() {
		return tyerRBHigh;
	}
	public void setTyerRBHigh(boolean tyerRBHigh) {
		this.tyerRBHigh = tyerRBHigh;
	}
	public boolean isFindLightPermit() {
		return findLightPermit;
	}
	public void setFindLightPermit(boolean findLightPermit) {
		this.findLightPermit = findLightPermit;
	}
	public boolean isLightDelayPermit() {
		return lightDelayPermit;
	}
	public void setLightDelayPermit(boolean lightDelayPermit) {
		this.lightDelayPermit = lightDelayPermit;
	}
	public boolean isTurnLightPermit() {
		return turnLightPermit;
	}
	public void setTurnLightPermit(boolean turnLightPermit) {
		this.turnLightPermit = turnLightPermit;
	}
	public boolean isFindLightSet() {
		return findLightSet;
	}
	public void setFindLightSet(boolean findLightSet) {
		this.findLightSet = findLightSet;
	}
	public byte getLightDelaySet() {
		return lightDelaySet;
	}
	public void setLightDelaySet(byte lightDelaySet) {
		this.lightDelaySet = lightDelaySet;
	}
	public boolean isTurnLightRSet() {
		return turnLightRSet;
	}
	public void setTurnLightRSet(boolean turnLightRSet) {
		this.turnLightRSet = turnLightRSet;
	}
	public boolean isTurnLightLSet() {
		return turnLightLSet;
	}
	public void setTurnLightLSet(boolean turnLightLSet) {
		this.turnLightLSet = turnLightLSet;
	}
	public boolean isCameraDelayed() {
		return cameraDelayed;
	}
	public void setCameraDelayed(boolean cameraDelayed) {
		this.cameraDelayed = cameraDelayed;
	}
	public boolean isCameraOn() {
		return cameraOn;
	}
	public void setCameraOn(boolean cameraOn) {
		this.cameraOn = cameraOn;
	}
	public boolean isTyerMonitorShowPermit() {
		return tyerMonitorShowPermit;
	}
	public void setTyerMonitorShowPermit(boolean tyerMonitorShowPermit) {
		this.tyerMonitorShowPermit = tyerMonitorShowPermit;
	}
	public boolean isTyerSpeedWarningPermit() {
		return tyerSpeedWarningPermit;
	}
	public void setTyerSpeedWarningPermit(boolean tyerSpeedWarningPermit) {
		this.tyerSpeedWarningPermit = tyerSpeedWarningPermit;
	}
	public boolean isTyerSpeedWarningSet() {
		return tyerSpeedWarningSet;
	}
	public void setTyerSpeedWarningSet(boolean tyerSpeedWarningSet) {
		this.tyerSpeedWarningSet = tyerSpeedWarningSet;
	}
	public int getTyerSpeedValue() {
		return tyerSpeedValue;
	}
	public void setTyerSpeedValue(int tyerSpeedValue) {
		this.tyerSpeedValue = tyerSpeedValue;
	}
	public boolean isSynchroAdjustPermit() {
		return synchroAdjustPermit;
	}
	public void setSynchroAdjustPermit(boolean synchroAdjustPermit) {
		this.synchroAdjustPermit = synchroAdjustPermit;
	}
	public boolean isLowerReversPermit() {
		return lowerReversPermit;
	}
	public void setLowerReversPermit(boolean lowerReversPermit) {
		this.lowerReversPermit = lowerReversPermit;
	}
	public boolean isFoldParkedPermit() {
		return foldParkedPermit;
	}
	public void setFoldParkedPermit(boolean foldParkedPermit) {
		this.foldParkedPermit = foldParkedPermit;
	}
	public boolean isWipingRainPermit() {
		return wipingRainPermit;
	}
	public void setWipingRainPermit(boolean wipingRainPermit) {
		this.wipingRainPermit = wipingRainPermit;
	}
	public boolean isRearWipingReversPermit() {
		return rearWipingReversPermit;
	}
	public void setRearWipingReversPermit(boolean rearWipingReversPermit) {
		this.rearWipingReversPermit = rearWipingReversPermit;
	}
	public boolean isSynchroAdjustSet() {
		return synchroAdjustSet;
	}
	public void setSynchroAdjustSet(boolean synchroAdjustSet) {
		this.synchroAdjustSet = synchroAdjustSet;
	}
	public boolean isLowerReversSet() {
		return lowerReversSet;
	}
	public void setLowerReversSet(boolean lowerReversSet) {
		this.lowerReversSet = lowerReversSet;
	}
	public boolean isFoldParkedSet() {
		return foldParkedSet;
	}
	public void setFoldParkedSet(boolean foldParkedSet) {
		this.foldParkedSet = foldParkedSet;
	}
	public boolean isWipingRainSet() {
		return wipingRainSet;
	}
	public void setWipingRainSet(boolean wipingRainSet) {
		this.wipingRainSet = wipingRainSet;
	}
	public boolean isRearWipingReversSet() {
		return rearWipingReversSet;
	}
	public void setRearWipingReversSet(boolean rearWipingReversSet) {
		this.rearWipingReversSet = rearWipingReversSet;
	}
	public byte getCameraMode() {
		return cameraMode;
	}
	public void setCameraMode(byte cameraMode) {
		this.cameraMode = cameraMode;
	}
	public boolean isLeftLightSet() {
		return leftLightSet;
	}
	public void setLeftLightSet(boolean leftLightSet) {
		this.leftLightSet = leftLightSet;
	}
	public boolean isRightLightSet() {
		return rightLightSet;
	}
	public void setRightLightSet(boolean rightLightSet) {
		this.rightLightSet = rightLightSet;
	}
	public byte getSwitchLightSet() {
		return switchLightSet;
	}
	public void setSwitchLightSet(byte switchLightSet) {
		this.switchLightSet = switchLightSet;
	}
	public byte getDoorLightSet() {
		return doorLightSet;
	}
	public void setDoorLightSet(byte doorLightSet) {
		this.doorLightSet = doorLightSet;
	}
	public byte getFootLightSet() {
		return footLightSet;
	}
	public void setFootLightSet(byte footLightSet) {
		this.footLightSet = footLightSet;
	}
	public byte getHomeLightSet() {
		return homeLightSet;
	}
	public void setHomeLightSet(byte homeLightSet) {
		this.homeLightSet = homeLightSet;
	}
	public byte getLeaveLightSet() {
		return leaveLightSet;
	}
	public void setLeaveLightSet(byte leaveLightSet) {
		this.leaveLightSet = leaveLightSet;
	}
	public boolean isDynamicAssistSet() {
		return dynamicAssistSet;
	}
	public void setDynamicAssistSet(boolean dynamicAssistSet) {
		this.dynamicAssistSet = dynamicAssistSet;
	}
	public boolean isDynamicBendSet() {
		return dynamicBendSet;
	}
	public void setDynamicBendSet(boolean dynamicBendSet) {
		this.dynamicBendSet = dynamicBendSet;
	}
	public byte getOpenTimeSet() {
		return openTimeSet;
	}
	public void setOpenTimeSet(byte openTimeSet) {
		this.openTimeSet = openTimeSet;
	}
	public boolean isAutoLightSet() {
		return autoLightSet;
	}
	public void setAutoLightSet(boolean autoLightSet) {
		this.autoLightSet = autoLightSet;
	}
	public boolean isLaneChangeSet() {
		return laneChangeSet;
	}
	public void setLaneChangeSet(boolean laneChangeSet) {
		this.laneChangeSet = laneChangeSet;
	}
	public byte getTravelModeSet() {
		return travelModeSet;
	}
	public void setTravelModeSet(byte travelModeSet) {
		this.travelModeSet = travelModeSet;
	}
	public boolean isDayLightSet() {
		return dayLightSet;
	}
	public void setDayLightSet(boolean dayLightSet) {
		this.dayLightSet = dayLightSet;
	}
	public boolean isSwitchLightPermit() {
		return switchLightPermit;
	}
	public void setSwitchLightPermit(boolean switchLightPermit) {
		this.switchLightPermit = switchLightPermit;
	}
	public boolean isDoorLightPermit() {
		return doorLightPermit;
	}
	public void setDoorLightPermit(boolean doorLightPermit) {
		this.doorLightPermit = doorLightPermit;
	}
	public boolean isFootLightPermit() {
		return footLightPermit;
	}
	public void setFootLightPermit(boolean footLightPermit) {
		this.footLightPermit = footLightPermit;
	}
	public boolean isHomeLightPermit() {
		return homeLightPermit;
	}
	public void setHomeLightPermit(boolean homeLightPermit) {
		this.homeLightPermit = homeLightPermit;
	}
	public boolean isLeaveLightPermit() {
		return leaveLightPermit;
	}
	public void setLeaveLightPermit(boolean leaveLightPermit) {
		this.leaveLightPermit = leaveLightPermit;
	}
	public boolean isDynamicAssistPermit() {
		return dynamicAssistPermit;
	}
	public void setDynamicAssistPermit(boolean dynamicAssistPermit) {
		this.dynamicAssistPermit = dynamicAssistPermit;
	}
	public boolean isDynamicBendPermit() {
		return dynamicBendPermit;
	}
	public void setDynamicBendPermit(boolean dynamicBendPermit) {
		this.dynamicBendPermit = dynamicBendPermit;
	}
	public boolean isOpenTimePermit() {
		return openTimePermit;
	}
	public void setOpenTimePermit(boolean openTimePermit) {
		this.openTimePermit = openTimePermit;
	}
	public boolean isAutoLightPermit() {
		return autoLightPermit;
	}
	public void setAutoLightPermit(boolean autoLightPermit) {
		this.autoLightPermit = autoLightPermit;
	}
	public boolean isLaneChangePermit() {
		return laneChangePermit;
	}
	public void setLaneChangePermit(boolean laneChangePermit) {
		this.laneChangePermit = laneChangePermit;
	}
	public boolean isTravelModePermit() {
		return travelModePermit;
	}
	public void setTravelModePermit(boolean travelModePermit) {
		this.travelModePermit = travelModePermit;
	}
	public boolean isDayLightPermit() {
		return dayLightPermit;
	}
	public void setDayLightPermit(boolean dayLightPermit) {
		this.dayLightPermit = dayLightPermit;
	}
	public boolean isLightColorPermit() {
		return lightColorPermit;
	}
	public void setLightColorPermit(boolean lightColorPermit) {
		this.lightColorPermit = lightColorPermit;
	}
	public boolean isLightAmbientPermit() {
		return lightAmbientPermit;
	}
	public void setLightAmbientPermit(boolean lightAmbientPermit) {
		this.lightAmbientPermit = lightAmbientPermit;
	}
	public boolean isLightAdjustPermit() {
		return lightAdjustPermit;
	}
	public void setLightAdjustPermit(boolean lightAdjustPermit) {
		this.lightAdjustPermit = lightAdjustPermit;
	}
	public byte getLightColorSet() {
		return lightColorSet;
	}
	public void setLightColorSet(byte lightColorSet) {
		this.lightColorSet = lightColorSet;
	}
	public byte getLightAmbientSet() {
		return lightAmbientSet;
	}
	public void setLightAmbientSet(byte lightAmbientSet) {
		this.lightAmbientSet = lightAmbientSet;
	}
	public byte getLightAdjustSet() {
		return lightAdjustSet;
	}
	public void setLightAdjustSet(byte lightAdjustSet) {
		this.lightAdjustSet = lightAdjustSet;
	}
	 
}
