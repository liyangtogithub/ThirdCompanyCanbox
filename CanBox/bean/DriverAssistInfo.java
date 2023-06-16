package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/**
 * 
 * @author LQPDC 驾驶员辅助系统设定信息
 */
public class DriverAssistInfo extends BaseInfo {

	/*** 路边停车 */
	private boolean stopRoadSide;
	/*** 入库停车 */
	private boolean stopInGarage;
	/*** 雷达静音，使能：倒车无声音 */
	private boolean radarMute;

	/*** 自动激活 许可 1:有效 0：无效 */
	private boolean autoActivatePermit;
	/*** 前部提示音量 许可 1:有效 0：无效 */
	private boolean frontVolumePermit;
	/*** 前部提示音调 许可 1:有效 0：无效 */
	private boolean frontTonePermit;
	/*** 后部提示音量 许可 1:有效 0：无效 */
	private boolean rearVolumePermit;
	/*** 后部提示音调 许可 1:有效 0：无效 */
	private boolean rearTonePermit;
	/*** 驶出车位 许可 1:有效 0：无效 */
	private boolean driveOutPermit;
	/*** 泊车方式 许可 1:有效 0：无效 */
	private boolean parkingModePermit;
	/*** 雷达音量 许可 1:有效 0：无效 */
	private boolean radarVolumePermit;

	/*** 自动激活 设定 1:开 0：关 */
	private boolean autoActivateSet;
	/*** 驶出车位 设定 1:开 0：关 */
	private boolean driveOutSet;
	/*** 前部提示音量 设定 1--9 */
	private byte frontVolumeSet;
	/*** 前部提示音调 设定 1--9 */
	private byte frontToneSet;
	/*** 后部提示音量 设定 1--9 */
	private byte rearVolumeSet;
	/*** 后部提示音调 设定 1--9 */
	private byte rearToneSet;

	/*** 自适应巡航 行驶程序 有效 */
	private boolean drivingProcedurePermit;
	/*** 自适应巡航 上次选择的车距 有效 */
	private boolean lastDistanceSelectPermit;
	/*** 前部辅助系统 激活 有效 */
	private boolean frontActivePermit;
	/*** 前部辅助系统 预警 有效 */
	private boolean frontAdvanceWarnPermit;
	/*** 前部辅助系统 距离报警 有效 */
	private boolean frontDistanceWarnPermit;
	/*** 自适应车道导向 有效 */
	private boolean laneGuidancePermit;
	/*** 交通标志识别 有效 */
	private boolean trafficeSignPermit;
	/*** 疲劳驾驶识别 有效 */
	private boolean driveAlertPermit;
	/*** 盲区监控 有效 */
	private boolean blindAreaPermit;
	/*** 预防式成员保护系统 有效 */
	private boolean proactiveProtectionPermit;
	/*** 车道保持辅助系统 有效 */
	private boolean laneKeepingPermit;

	/*** 自适应巡航 行驶程序 设置 00：经济，01：标准，10：运动 */
	private byte drivingProcedureSet;
	/*** 自适应巡航 上次选择的车距 设置 1:开 0：关 */
	private boolean lastDistanceSelectSet;
	/*** 自适应巡航 车距 设置 0：极小 1：小 2：中等 3：大 4：极大 */
	private byte distanceSet;
	/*** 前部辅助系统 激活 设置 */
	private boolean frontActiveSet;
	/*** 前部辅助系统 预警 设置 */
	private boolean frontAdvanceWarnSet;
	/*** 前部辅助系统 距离报警 设置 */
	private boolean frontDistanceWarnSet;
	/*** 前部辅助系统 预警时间 设置 00：关闭 01：提前 10：适时 11：延后 */
	private byte frontAdvanceWarnTimeSet;
	/*** 自适应车道导向 设置 */
	private boolean laneGuidanceSet;
	/*** 交通标志识别 设置 */
	private boolean trafficeSignSet;
	/*** 疲劳驾驶识别 设置 */
	private boolean driveAlertSet;
	/*** 盲区监控 设置 */
	private boolean blindAreaSet;
	/*** 预防式成员保护系统 设置 */
	private boolean proactiveProtectionSet;
	/*** 车道保持辅助系统 设置 */
	private boolean laneKeepingSet;

	// PSA 泊车 辅助
	/*** 雷达不显示 1:开 0：关 */
	private boolean radarNoShow;
	/*** 警报音量 1-5 1最小 */
	private byte warnVoice;
	/*** 前雷达距离 1：1格 2:2格 */
	private byte radarFDistance;
	/*** 后雷达距离 1：1格 2:2格 */
	private byte radarBDistance;

	// PSA门锁 设置
	/*** 车门自动上锁 设置 1:开（车速感应，车门自动落锁） 0：关 */
	private boolean doorAutoLockSet;
	/*** 智能自动解锁 设置 1:开（仅驾驶员门） 0：所有车门 */
	private boolean doorIntelUnlockSet;
	/*** 驾驶员开门联动解锁 设置 1:开 0：关 */
	private boolean doorLinkUnlockSet;
	/*** 车门自动解锁P档 设置 1:开 0：关 */
	private boolean doorAutoUnlockPSet;
	/*** 车门自动落锁P档 设置 1:开 0：关 */
	private boolean doorAutoLockPSet;
	/*** 空调与AUTO联动 设置 1:开(自动A/C) 0：关 */
	private boolean autoACSet;
	/*** 内外循环切换与AUTO键联动 设置 1:开(有效通风模式) 0：关 */
	private boolean autoLinkCycleSet;

	// PSA 遥控 设定
	/*** 上锁开锁时紧急闪烁灯响应 1:开(锁止/解锁反馈指示灯) 0：关 */
	private boolean feedbackByLight;
	/*** 按钮两次按下解锁 1:开 0：关 */
	private boolean remotePress2;
	/*** 智能车锁和一键启动 1:开(带电子钥匙的进入系统钥匙) 0：关 */
	private boolean intelligentLock;
	/*** 钥匙两次按下解锁 1:开 0：关 */
	private boolean keyPress2;

	// PSA冲撞，监测系统设定
	/*** 车内照明关闭时间 0：无效 1:7.5s 2：15s 3:30s */
	private byte lightOffTime;
	/*** 自动头灯灵敏度设定 0--4等级 */
	private byte headSens;

	// 通用 冲撞/监测系统设定
	// 许可
	/*** 泊车辅助系统设定 许可 */
	private boolean parkAssistPermit;
	/*** 侧盲区报警系统设定 许可 */
	private boolean sideBlindPermit;
	/*** 防撞警报类型设定 许可 */
	private boolean anticolPermit;
	/*** 泊车辅助系统设定 带拖车补偿 许可 */
	private boolean parkTrailerPermit;
	/*** 24G HZ 雷达设定 许可 */
	private boolean radar24gPermit;
	/*** 自动防撞准备 许可 */
	private boolean autoAnticolPermit;
	// 设置
	/*** 泊车辅助系统设定 设置 */
	private boolean parkAssistSet;
	/*** 侧盲区报警系统设定 设置 */
	private boolean sideBlindSet;
	/*** 防撞警报类型设定 设置 0钟鸣报警 1座椅 */
	private byte anticolSet;
	/*** 泊车辅助系统设定 带拖车补偿 设置 0关 1开 2拖车补偿 */
	private byte parkTrailerSet;
	/*** 24G HZ 雷达设定 设置 */
	private boolean radar24gSet;
	/*** 自动防撞准备 设置 0关闭 1报警 2报警和制动 */
	private byte autoAnticolSet;
	// 通用 冲撞/监测系统设定2
	// 许可
	/*** 汽车状态通知 */
	private boolean carStatePermit;
	/*** 坡道起步辅助系统 */
	private boolean rampAssistPermit;
	/*** 自适应巡航启动提醒 */
	private boolean adapCruisePermit;
	// 设置
	/*** 汽车状态通知 */
	private boolean carStateSet;
	/*** 坡道起步辅助系统 0标准 1增强 */
	private byte rampAssistSet;
	/*** 自适应巡航启动提醒 */
	private boolean adapCruiseSet;
	// 通用 舒适性与方便性
	// 许可
	/*** 驾驶员座椅停车移位设定 许可 */
	private boolean stopShiftPermit;
	/*** 转向管柱离车移位设定 许可 */
	private boolean leaveShiftPermit;
	/*** 外后视镜倒车自动倾斜设定 许可 */
	private boolean autotiltPermit;
	/*** 外后视镜自动折叠设定 许可 */
	private boolean autoFoldPermit;
	/*** 驾驶员个性设置设定 许可 */
	private boolean personSetPermit;
	/*** 倒挡自动后窗雨刷设定 许可 */
	private boolean backWiperPermit;
	/*** 转向管柱离车倾斜设定 许可 */
	private boolean leaveTiltPermit;
	// 设置
	/*** 驾驶员座椅停车移位设定 */
	private boolean stopShiftSet;
	/*** 转向管柱离车移位设定 0关 1收缩 2提升 3收缩和提升 */
	private byte leaveShiftSet;
	/*** 外后视镜倒车自动倾斜设定 */
	private boolean autotiltSet;
	/*** 外后视镜自动折叠设定 */
	private boolean autoFoldSet;
	/*** 驾驶员个性设置设定 */
	private boolean personSetSet;
	/*** 倒挡自动后窗雨刷设定 */
	private boolean backWiperSet;
	/*** 转向管柱离车倾斜设定 */
	private boolean leaveTiltSet;
	// 通用 舒适性与方便性2
	// 许可
	/*** 自动雨刮 许可 */
	private boolean autoWiperPermit;
	// 设置
	/*** 自动雨刮 */
	private boolean autoWiperSet;
	// 通用 门锁设定
	/***防止开门自动落锁  许可*/
	private boolean prevLockPermit;
	/***自动落锁   许可*/
	private boolean autoLockPermit;
	/***自动解锁（自动档 ）  许可*/
	private boolean autoUnLockAPermit;
	/***延迟落锁  许可*/
	private boolean delayLockPermit;
	/***自动解锁（手动档 ）   许可*/
	private boolean autoUnLockHPermit;
	/***防止开门自动落锁  */
	private boolean prevLockSet;
	/***自动落锁   */
	private boolean autoLockSet;
	/***自动解锁（自动档 ）  */
	private byte autoUnLockASet;
	/***延迟落锁  */
	private boolean delayLockSet;
	/***自动解锁（手动档 ）   */
	private byte autoUnLockHSet;
	//遥控器 许可
	/***遥控落锁反馈  许可*/
	private boolean remLockPermit;
	/***遥控解锁反馈  许可*/
	private boolean remULFbPermit;
	/***遥控解锁设定 许可*/
	private boolean remULPermit;
	/***远程解锁车门 自动重锁设定 许可*/
	private boolean remULRepPermit;
	/***重锁遥控打开的门 设定  许可*/
	private boolean repRemPermit;
	/***驾驶员钥匙自动识别 设定  许可*/
	private boolean keyKnownPermit;
	/***远程启动设定  许可*/
	private boolean remStartPermit;
	/***智能近车解锁设定  许可*/
	private boolean nearULPermit;
	/***智能离车落锁设定  许可*/
	private boolean leaveULPermit;
	/***钥匙遗忘提醒设定  许可*/
	private boolean keyMindPermit;
	/***遥控滑移门设置    许可*/
	private boolean remSlidePermit;
	/***遥控车窗控制  许可*/
	private boolean remWinPermit;
	//遥控器 设置
	/***遥控落锁反馈   0仅灯光 1灯光与喇叭 2 仅喇叭 3关*/
	private byte remLockSet;
	/***遥控解锁反馈  0关 1灯光闪烁 */
	private boolean remULFbSet;
	/***遥控解锁设定  0仅驾驶员门  1全部*/
	private byte remULSet;
	/***远程解锁车门 自动重锁设定*/
	private boolean remULRepSet;
	/***重锁遥控打开的门 设定*/
	private boolean repRemSet;
	/***驾驶员钥匙自动识别 设定*/
	private boolean keyKnownSet;
	/***远程启动设定*/
	private boolean remStartSet;
	/***智能近车解锁设定   0仅驾驶员门  1全部*/
	private byte nearULSet;
	/***智能离车落锁设定   0关  1开  2喇叭鸣叫启用*/
	private byte leaveULSet;
	/***钥匙遗忘提醒设定*/
	private boolean keyMindSet;
	/***遥控滑移门设置   1 解锁滑移门并打开滑移门  0解锁所有门并打开滑移门*/
	private byte remSlideSet;
	/***遥控车窗控制 */
	private boolean remWinSet;

	public boolean isRemLockPermit() {
		return remLockPermit;
	}

	public void setRemLockPermit(boolean remLockPermit) {
		this.remLockPermit = remLockPermit;
	}

	public boolean isRemULFbPermit() {
		return remULFbPermit;
	}

	public void setRemULFbPermit(boolean remULFbPermit) {
		this.remULFbPermit = remULFbPermit;
	}

	public boolean isRemULPermit() {
		return remULPermit;
	}

	public void setRemULPermit(boolean remULPermit) {
		this.remULPermit = remULPermit;
	}

	public boolean isRemULRepPermit() {
		return remULRepPermit;
	}

	public void setRemULRepPermit(boolean remULRepPermit) {
		this.remULRepPermit = remULRepPermit;
	}

	public boolean isRepRemPermit() {
		return repRemPermit;
	}

	public void setRepRemPermit(boolean repRemPermit) {
		this.repRemPermit = repRemPermit;
	}

	public boolean isKeyKnownPermit() {
		return keyKnownPermit;
	}

	public void setKeyKnownPermit(boolean keyKnownPermit) {
		this.keyKnownPermit = keyKnownPermit;
	}

	public boolean isRemStartPermit() {
		return remStartPermit;
	}

	public void setRemStartPermit(boolean remStartPermit) {
		this.remStartPermit = remStartPermit;
	}

	public boolean isNearULPermit() {
		return nearULPermit;
	}

	public void setNearULPermit(boolean nearULPermit) {
		this.nearULPermit = nearULPermit;
	}

	public boolean isLeaveULPermit() {
		return leaveULPermit;
	}

	public void setLeaveULPermit(boolean leaveULPermit) {
		this.leaveULPermit = leaveULPermit;
	}

	public boolean isKeyMindPermit() {
		return keyMindPermit;
	}

	public void setKeyMindPermit(boolean keyMindPermit) {
		this.keyMindPermit = keyMindPermit;
	}

	public boolean isRemSlidePermit() {
		return remSlidePermit;
	}

	public void setRemSlidePermit(boolean remSlidePermit) {
		this.remSlidePermit = remSlidePermit;
	}

	public boolean isRemWinPermit() {
		return remWinPermit;
	}

	public void setRemWinPermit(boolean remWinPermit) {
		this.remWinPermit = remWinPermit;
	}

	public byte getRemLockSet() {
		return remLockSet;
	}

	public void setRemLockSet(byte remLockSet) {
		this.remLockSet = remLockSet;
	}

	public boolean isRemULFbSet() {
		return remULFbSet;
	}

	public void setRemULFbSet(boolean remULFbSet) {
		this.remULFbSet = remULFbSet;
	}

	public byte getRemULSet() {
		return remULSet;
	}

	public void setRemULSet(byte remULSet) {
		this.remULSet = remULSet;
	}

	public boolean isRemULRepSet() {
		return remULRepSet;
	}

	public void setRemULRepSet(boolean remULRepSet) {
		this.remULRepSet = remULRepSet;
	}

	public boolean isRepRemSet() {
		return repRemSet;
	}

	public void setRepRemSet(boolean repRemSet) {
		this.repRemSet = repRemSet;
	}

	public boolean isKeyKnownSet() {
		return keyKnownSet;
	}

	public void setKeyKnownSet(boolean keyKnownSet) {
		this.keyKnownSet = keyKnownSet;
	}

	public boolean isRemStartSet() {
		return remStartSet;
	}

	public void setRemStartSet(boolean remStartSet) {
		this.remStartSet = remStartSet;
	}

	public byte getNearULSet() {
		return nearULSet;
	}

	public void setNearULSet(byte nearULSet) {
		this.nearULSet = nearULSet;
	}

	public byte getLeaveULSet() {
		return leaveULSet;
	}

	public void setLeaveULSet(byte leaveULSet) {
		this.leaveULSet = leaveULSet;
	}

	public boolean isKeyMindSet() {
		return keyMindSet;
	}

	public void setKeyMindSet(boolean keyMindSet) {
		this.keyMindSet = keyMindSet;
	}

	public byte getRemSlideSet() {
		return remSlideSet;
	}

	public void setRemSlideSet(byte remSlideSet) {
		this.remSlideSet = remSlideSet;
	}

	public boolean isRemWinSet() {
		return remWinSet;
	}

	public void setRemWinSet(boolean remWinSet) {
		this.remWinSet = remWinSet;
	}

	public boolean isPrevLockSet() {
		return prevLockSet;
	}

	public void setPrevLockSet(boolean prevLockSet) {
		this.prevLockSet = prevLockSet;
	}

	public boolean isAutoLockSet() {
		return autoLockSet;
	}

	public void setAutoLockSet(boolean autoLockSet) {
		this.autoLockSet = autoLockSet;
	}

	public byte getAutoUnLockASet() {
		return autoUnLockASet;
	}

	public void setAutoUnLockASet(byte autoUnLockASet) {
		this.autoUnLockASet = autoUnLockASet;
	}

	public boolean isDelayLockSet() {
		return delayLockSet;
	}

	public void setDelayLockSet(boolean delayLockSet) {
		this.delayLockSet = delayLockSet;
	}

	public byte getAutoUnLockHSet() {
		return autoUnLockHSet;
	}

	public void setAutoUnLockHSet(byte autoUnLockHSet) {
		this.autoUnLockHSet = autoUnLockHSet;
	}

	public boolean isPrevLockPermit() {
		return prevLockPermit;
	}

	public void setPrevLockPermit(boolean prevLockPermit) {
		this.prevLockPermit = prevLockPermit;
	}

	public boolean isAutoLockPermit() {
		return autoLockPermit;
	}

	public void setAutoLockPermit(boolean autoLockPermit) {
		this.autoLockPermit = autoLockPermit;
	}

	public boolean isAutoUnLockAPermit() {
		return autoUnLockAPermit;
	}

	public void setAutoUnLockAPermit(boolean autoUnLockAPermit) {
		this.autoUnLockAPermit = autoUnLockAPermit;
	}

	public boolean isDelayLockPermit() {
		return delayLockPermit;
	}

	public void setDelayLockPermit(boolean delayLockPermit) {
		this.delayLockPermit = delayLockPermit;
	}

	public boolean isAutoUnLockHPermit() {
		return autoUnLockHPermit;
	}

	public void setAutoUnLockHPermit(boolean autoUnLockHPermit) {
		this.autoUnLockHPermit = autoUnLockHPermit;
	}

	public boolean isAutoWiperPermit() {
		return autoWiperPermit;
	}

	public void setAutoWiperPermit(boolean autoWiperPermit) {
		this.autoWiperPermit = autoWiperPermit;
	}

	public boolean isAutoWiperSet() {
		return autoWiperSet;
	}

	public void setAutoWiperSet(boolean autoWiperSet) {
		this.autoWiperSet = autoWiperSet;
	}

	public boolean isStopShiftPermit() {
		return stopShiftPermit;
	}

	public void setStopShiftPermit(boolean stopShiftPermit) {
		this.stopShiftPermit = stopShiftPermit;
	}

	public boolean isLeaveShiftPermit() {
		return leaveShiftPermit;
	}

	public void setLeaveShiftPermit(boolean leaveShiftPermit) {
		this.leaveShiftPermit = leaveShiftPermit;
	}

	public boolean isAutotiltPermit() {
		return autotiltPermit;
	}

	public void setAutotiltPermit(boolean autotiltPermit) {
		this.autotiltPermit = autotiltPermit;
	}

	public boolean isAutoFoldPermit() {
		return autoFoldPermit;
	}

	public void setAutoFoldPermit(boolean autoFoldPermit) {
		this.autoFoldPermit = autoFoldPermit;
	}

	public boolean isPersonSetPermit() {
		return personSetPermit;
	}

	public void setPersonSetPermit(boolean personSetPermit) {
		this.personSetPermit = personSetPermit;
	}

	public boolean isBackWiperPermit() {
		return backWiperPermit;
	}

	public void setBackWiperPermit(boolean backWiperPermit) {
		this.backWiperPermit = backWiperPermit;
	}

	public boolean isLeaveTiltPermit() {
		return leaveTiltPermit;
	}

	public void setLeaveTiltPermit(boolean leaveTiltPermit) {
		this.leaveTiltPermit = leaveTiltPermit;
	}

	public boolean isStopShiftSet() {
		return stopShiftSet;
	}

	public void setStopShiftSet(boolean stopShiftSet) {
		this.stopShiftSet = stopShiftSet;
	}

	public byte getLeaveShiftSet() {
		return leaveShiftSet;
	}

	public void setLeaveShiftSet(byte leaveShiftSet) {
		this.leaveShiftSet = leaveShiftSet;
	}

	public boolean isAutotiltSet() {
		return autotiltSet;
	}

	public void setAutotiltSet(boolean autotiltSet) {
		this.autotiltSet = autotiltSet;
	}

	public boolean isAutoFoldSet() {
		return autoFoldSet;
	}

	public void setAutoFoldSet(boolean autoFoldSet) {
		this.autoFoldSet = autoFoldSet;
	}

	public boolean isPersonSetSet() {
		return personSetSet;
	}

	public void setPersonSetSet(boolean personSetSet) {
		this.personSetSet = personSetSet;
	}

	public boolean isBackWiperSet() {
		return backWiperSet;
	}

	public void setBackWiperSet(boolean backWiperSet) {
		this.backWiperSet = backWiperSet;
	}

	public boolean isLeaveTiltSet() {
		return leaveTiltSet;
	}

	public void setLeaveTiltSet(boolean leaveTiltSet) {
		this.leaveTiltSet = leaveTiltSet;
	}

	public boolean isCarStatePermit() {
		return carStatePermit;
	}

	public void setCarStatePermit(boolean carStatePermit) {
		this.carStatePermit = carStatePermit;
	}

	public boolean isRampAssistPermit() {
		return rampAssistPermit;
	}

	public void setRampAssistPermit(boolean rampAssistPermit) {
		this.rampAssistPermit = rampAssistPermit;
	}

	public boolean isAdapCruisePermit() {
		return adapCruisePermit;
	}

	public void setAdapCruisePermit(boolean adapCruisePermit) {
		this.adapCruisePermit = adapCruisePermit;
	}

	public boolean isCarStateSet() {
		return carStateSet;
	}

	public void setCarStateSet(boolean carStateSet) {
		this.carStateSet = carStateSet;
	}

	public byte getRampAssistSet() {
		return rampAssistSet;
	}

	public void setRampAssistSet(byte rampAssistSet) {
		this.rampAssistSet = rampAssistSet;
	}

	public boolean isAdapCruiseSet() {
		return adapCruiseSet;
	}

	public void setAdapCruiseSet(boolean adapCruiseSet) {
		this.adapCruiseSet = adapCruiseSet;
	}

	public boolean isParkAssistPermit() {
		return parkAssistPermit;
	}

	public void setParkAssistPermit(boolean parkAssistPermit) {
		this.parkAssistPermit = parkAssistPermit;
	}

	public boolean isSideBlindPermit() {
		return sideBlindPermit;
	}

	public void setSideBlindPermit(boolean sideBlindPermit) {
		this.sideBlindPermit = sideBlindPermit;
	}

	public boolean isAnticolPermit() {
		return anticolPermit;
	}

	public void setAnticolPermit(boolean anticolPermit) {
		this.anticolPermit = anticolPermit;
	}

	public boolean isParkTrailerPermit() {
		return parkTrailerPermit;
	}

	public void setParkTrailerPermit(boolean parkTrailerPermit) {
		this.parkTrailerPermit = parkTrailerPermit;
	}

	public boolean isRadar24gPermit() {
		return radar24gPermit;
	}

	public void setRadar24gPermit(boolean radar24gPermit) {
		this.radar24gPermit = radar24gPermit;
	}

	public boolean isAutoAnticolPermit() {
		return autoAnticolPermit;
	}

	public void setAutoAnticolPermit(boolean autoAnticolPermit) {
		this.autoAnticolPermit = autoAnticolPermit;
	}

	public boolean isParkAssistSet() {
		return parkAssistSet;
	}

	public void setParkAssistSet(boolean parkAssistSet) {
		this.parkAssistSet = parkAssistSet;
	}

	public boolean isSideBlindSet() {
		return sideBlindSet;
	}

	public void setSideBlindSet(boolean sideBlindSet) {
		this.sideBlindSet = sideBlindSet;
	}

	public byte getAnticolSet() {
		return anticolSet;
	}

	public void setAnticolSet(byte anticolSet) {
		this.anticolSet = anticolSet;
	}

	public byte getParkTrailerSet() {
		return parkTrailerSet;
	}

	public void setParkTrailerSet(byte parkTrailerSet) {
		this.parkTrailerSet = parkTrailerSet;
	}

	public boolean isRadar24gSet() {
		return radar24gSet;
	}

	public void setRadar24gSet(boolean radar24gSet) {
		this.radar24gSet = radar24gSet;
	}

	public byte getAutoAnticolSet() {
		return autoAnticolSet;
	}

	public void setAutoAnticolSet(byte autoAnticolSet) {
		this.autoAnticolSet = autoAnticolSet;
	}

	public boolean isDrivingProcedurePermit() {
		return drivingProcedurePermit;
	}

	public void setDrivingProcedurePermit(boolean drivingProcedurePermit) {
		this.drivingProcedurePermit = drivingProcedurePermit;
	}

	public boolean isLastDistanceSelectPermit() {
		return lastDistanceSelectPermit;
	}

	public void setLastDistanceSelectPermit(boolean lastDistanceSelectPermit) {
		this.lastDistanceSelectPermit = lastDistanceSelectPermit;
	}

	public boolean isFrontActivePermit() {
		return frontActivePermit;
	}

	public void setFrontActivePermit(boolean frontActivePermit) {
		this.frontActivePermit = frontActivePermit;
	}

	public boolean isFrontAdvanceWarnPermit() {
		return frontAdvanceWarnPermit;
	}

	public void setFrontAdvanceWarnPermit(boolean frontAdvanceWarnPermit) {
		this.frontAdvanceWarnPermit = frontAdvanceWarnPermit;
	}

	public boolean isFrontDistanceWarnPermit() {
		return frontDistanceWarnPermit;
	}

	public void setFrontDistanceWarnPermit(boolean frontDistanceWarnPermit) {
		this.frontDistanceWarnPermit = frontDistanceWarnPermit;
	}

	public boolean isLaneGuidancePermit() {
		return laneGuidancePermit;
	}

	public void setLaneGuidancePermit(boolean laneGuidancePermit) {
		this.laneGuidancePermit = laneGuidancePermit;
	}

	public boolean isTrafficeSignPermit() {
		return trafficeSignPermit;
	}

	public void setTrafficeSignPermit(boolean trafficeSignPermit) {
		this.trafficeSignPermit = trafficeSignPermit;
	}

	public boolean isDriveAlertPermit() {
		return driveAlertPermit;
	}

	public void setDriveAlertPermit(boolean driveAlertPermit) {
		this.driveAlertPermit = driveAlertPermit;
	}

	public boolean isBlindAreaPermit() {
		return blindAreaPermit;
	}

	public void setBlindAreaPermit(boolean blindAreaPermit) {
		this.blindAreaPermit = blindAreaPermit;
	}

	public boolean isProactiveProtectionPermit() {
		return proactiveProtectionPermit;
	}

	public void setProactiveProtectionPermit(boolean proactiveProtectionPermit) {
		this.proactiveProtectionPermit = proactiveProtectionPermit;
	}

	public boolean isLaneKeepingPermit() {
		return laneKeepingPermit;
	}

	public void setLaneKeepingPermit(boolean laneKeepingPermit) {
		this.laneKeepingPermit = laneKeepingPermit;
	}

	public byte getDrivingProcedureSet() {
		return drivingProcedureSet;
	}

	public void setDrivingProcedureSet(byte drivingProcedureSet) {
		this.drivingProcedureSet = drivingProcedureSet;
	}

	public boolean isLastDistanceSelectSet() {
		return lastDistanceSelectSet;
	}

	public void setLastDistanceSelectSet(boolean lastDistanceSelectSet) {
		this.lastDistanceSelectSet = lastDistanceSelectSet;
	}

	public byte getDistanceSet() {
		return distanceSet;
	}

	public void setDistanceSet(byte distanceSet) {
		this.distanceSet = distanceSet;
	}

	public boolean isFrontActiveSet() {
		return frontActiveSet;
	}

	public void setFrontActiveSet(boolean frontActiveSet) {
		this.frontActiveSet = frontActiveSet;
	}

	public boolean isFrontAdvanceWarnSet() {
		return frontAdvanceWarnSet;
	}

	public void setFrontAdvanceWarnSet(boolean frontAdvanceWarnSet) {
		this.frontAdvanceWarnSet = frontAdvanceWarnSet;
	}

	public boolean isFrontDistanceWarnSet() {
		return frontDistanceWarnSet;
	}

	public void setFrontDistanceWarnSet(boolean frontDistanceWarnSet) {
		this.frontDistanceWarnSet = frontDistanceWarnSet;
	}

	public byte getFrontAdvanceWarnTimeSet() {
		return frontAdvanceWarnTimeSet;
	}

	public void setFrontAdvanceWarnTimeSet(byte frontAdvanceWarnTimeSet) {
		this.frontAdvanceWarnTimeSet = frontAdvanceWarnTimeSet;
	}

	public boolean isLaneGuidanceSet() {
		return laneGuidanceSet;
	}

	public void setLaneGuidanceSet(boolean laneGuidanceSet) {
		this.laneGuidanceSet = laneGuidanceSet;
	}

	public boolean isTrafficeSignSet() {
		return trafficeSignSet;
	}

	public void setTrafficeSignSet(boolean trafficeSignSet) {
		this.trafficeSignSet = trafficeSignSet;
	}

	public boolean isDriveAlertSet() {
		return driveAlertSet;
	}

	public void setDriveAlertSet(boolean driveAlertSet) {
		this.driveAlertSet = driveAlertSet;
	}

	public boolean isBlindAreaSet() {
		return blindAreaSet;
	}

	public void setBlindAreaSet(boolean blindAreaSet) {
		this.blindAreaSet = blindAreaSet;
	}

	public boolean isProactiveProtectionSet() {
		return proactiveProtectionSet;
	}

	public void setProactiveProtectionSet(boolean proactiveProtectionSet) {
		this.proactiveProtectionSet = proactiveProtectionSet;
	}

	public boolean isLaneKeepingSet() {
		return laneKeepingSet;
	}

	public void setLaneKeepingSet(boolean laneKeepingSet) {
		this.laneKeepingSet = laneKeepingSet;
	}

	public boolean isAutoActivatePermit() {
		return autoActivatePermit;
	}

	public void setAutoActivatePermit(boolean autoActivatePermit) {
		this.autoActivatePermit = autoActivatePermit;
	}

	public boolean isFrontVolumePermit() {
		return frontVolumePermit;
	}

	public void setFrontVolumePermit(boolean frontVolumePermit) {
		this.frontVolumePermit = frontVolumePermit;
	}

	public boolean isFrontTonePermit() {
		return frontTonePermit;
	}

	public void setFrontTonePermit(boolean frontTonePermit) {
		this.frontTonePermit = frontTonePermit;
	}

	public boolean isRearVolumePermit() {
		return rearVolumePermit;
	}

	public void setRearVolumePermit(boolean rearVolumePermit) {
		this.rearVolumePermit = rearVolumePermit;
	}

	public boolean isRearTonePermit() {
		return rearTonePermit;
	}

	public void setRearTonePermit(boolean rearTonePermit) {
		this.rearTonePermit = rearTonePermit;
	}

	public boolean isDriveOutPermit() {
		return driveOutPermit;
	}

	public void setDriveOutPermit(boolean driveOutPermit) {
		this.driveOutPermit = driveOutPermit;
	}

	public boolean isParkingModePermit() {
		return parkingModePermit;
	}

	public void setParkingModePermit(boolean parkingModePermit) {
		this.parkingModePermit = parkingModePermit;
	}

	public boolean isRadarVolumePermit() {
		return radarVolumePermit;
	}

	public void setRadarVolumePermit(boolean radarVolumePermit) {
		this.radarVolumePermit = radarVolumePermit;
	}

	public boolean isAutoActivateSet() {
		return autoActivateSet;
	}

	public void setAutoActivateSet(boolean autoActivateSet) {
		this.autoActivateSet = autoActivateSet;
	}

	public boolean isDriveOutSet() {
		return driveOutSet;
	}

	public void setDriveOutSet(boolean driveOutSet) {
		this.driveOutSet = driveOutSet;
	}

	public byte getFrontVolumeSet() {
		return frontVolumeSet;
	}

	public void setFrontVolumeSet(byte frontVolumeSet) {
		this.frontVolumeSet = frontVolumeSet;
	}

	public byte getFrontToneSet() {
		return frontToneSet;
	}

	public void setFrontToneSet(byte frontToneSet) {
		this.frontToneSet = frontToneSet;
	}

	public byte getRearVolumeSet() {
		return rearVolumeSet;
	}

	public void setRearVolumeSet(byte rearVolumeSet) {
		this.rearVolumeSet = rearVolumeSet;
	}

	public byte getRearToneSet() {
		return rearToneSet;
	}

	public void setRearToneSet(byte rearToneSet) {
		this.rearToneSet = rearToneSet;
	}

	public boolean isStopRoadSide() {
		return stopRoadSide;
	}

	public void setStopRoadSide(boolean stopRoadSide) {
		this.stopRoadSide = stopRoadSide;
	}

	public boolean isStopInGarage() {
		return stopInGarage;
	}

	public void setStopInGarage(boolean stopInGarage) {
		this.stopInGarage = stopInGarage;
	}

	public boolean isRadarMute() {
		return radarMute;
	}

	public void setRadarMute(boolean radarMute) {
		this.radarMute = radarMute;
	}
	
	public boolean isRadarNoShow() {
		return radarNoShow;
	}

	public void setRadarNoShow(boolean radarNoShow) {
		this.radarNoShow = radarNoShow;
	}

	public byte getWarnVoice() {
		return warnVoice;
	}

	public void setWarnVoice(byte warnVoice) {
		this.warnVoice = warnVoice;
	}

	public byte getRadarFDistance() {
		return radarFDistance;
	}

	public void setRadarFDistance(byte radarFDistance) {
		this.radarFDistance = radarFDistance;
	}

	public byte getRadarBDistance() {
		return radarBDistance;
	}

	public void setRadarBDistance(byte radarBDistance) {
		this.radarBDistance = radarBDistance;
	}

	public boolean isDoorAutoLockSet() {
		return doorAutoLockSet;
	}

	public void setDoorAutoLockSet(boolean doorAutoLockSet) {
		this.doorAutoLockSet = doorAutoLockSet;
	}

	public boolean isDoorIntelUnlockSet() {
		return doorIntelUnlockSet;
	}

	public void setDoorIntelUnlockSet(boolean doorIntelUnlockSet) {
		this.doorIntelUnlockSet = doorIntelUnlockSet;
	}

	public boolean isDoorLinkUnlockSet() {
		return doorLinkUnlockSet;
	}

	public void setDoorLinkUnlockSet(boolean doorLinkUnlockSet) {
		this.doorLinkUnlockSet = doorLinkUnlockSet;
	}

	public boolean isDoorAutoUnlockPSet() {
		return doorAutoUnlockPSet;
	}

	public void setDoorAutoUnlockPSet(boolean doorAutoUnlockPSet) {
		this.doorAutoUnlockPSet = doorAutoUnlockPSet;
	}

	public boolean isDoorAutoLockPSet() {
		return doorAutoLockPSet;
	}

	public void setDoorAutoLockPSet(boolean doorAutoLockPSet) {
		this.doorAutoLockPSet = doorAutoLockPSet;
	}

	public boolean isAutoACSet() {
		return autoACSet;
	}

	public void setAutoACSet(boolean autoACSet) {
		this.autoACSet = autoACSet;
	}

	public boolean isAutoLinkCycleSet() {
		return autoLinkCycleSet;
	}

	public void setAutoLinkCycleSet(boolean autoLinkCycleSet) {
		this.autoLinkCycleSet = autoLinkCycleSet;
	}

	public boolean isFeedbackByLight() {
		return feedbackByLight;
	}

	public void setFeedbackByLight(boolean feedbackByLight) {
		this.feedbackByLight = feedbackByLight;
	}

	public boolean isRemotePress2() {
		return remotePress2;
	}

	public void setRemotePress2(boolean remotePress2) {
		this.remotePress2 = remotePress2;
	}

	public boolean isIntelligentLock() {
		return intelligentLock;
	}

	public void setIntelligentLock(boolean intelligentLock) {
		this.intelligentLock = intelligentLock;
	}

	public boolean isKeyPress2() {
		return keyPress2;
	}

	public void setKeyPress2(boolean keyPress2) {
		this.keyPress2 = keyPress2;
	}

	public byte getLightOffTime() {
		return lightOffTime;
	}

	public void setLightOffTime(byte lightOffTime) {
		this.lightOffTime = lightOffTime;
	}

	public byte getHeadSens() {
		return headSens;
	}

	public void setHeadSens(byte headSens) {
		this.headSens = headSens;
	};

	public byte getID() {
		return Constant.ID_DRIVER_ASSIST;
	};
}
