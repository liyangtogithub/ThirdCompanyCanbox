package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/*** 设置信息 */
public class SetInfo extends BaseInfo {

	// PSA车辆设置信息使能1
	/*** 自动驻车 许可 1:有效 0：无效 */
	private boolean aotoStopPermit;
	/*** 倒车雷达开关 许可 1:有效 0：无效 */
	private boolean reversRadarPermit;
	/*** 迎宾照明 许可 1:有效 0：无效 */
	private boolean lightWelcomePermit;
	/*** 氛围照明 许可 1:有效 0：无效 */
	private boolean lightAmbientPermit;
	/*** 倒车自动后雨刮 许可 1:有效 0：无效 */
	private boolean reversWiperPermit;
	/*** 驻车辅助 许可 1:有效 0：无效 */
	private boolean stopAssistPermit;
	/*** 车门自动锁定 许可 1:有效 0：无效 */
	private boolean doorAutoLockPermit;
	/*** 车门上锁 许可 1:有效 0：无效 */
	private boolean doorLockPermit;
	/*** 车门解锁 许可 1:有效 0：无效 */
	private boolean doorUnlockPermit;
	/*** 日间行车灯 许可 1:有效 0：无效 */
	private boolean dayLightPermit;
	/*** 伴我回家照明（大灯延时熄灭） 许可 1:有效 0：无效 */
	private boolean homeLightPermit;

	// PSA车辆设置信息使能2
	/*** 仅行李箱解锁设置命令 许可 1:有效 0：无效 */
	private boolean trunkUnlockPermit;
	/*** 随动转向大灯设置命令 许可 1:有效 0：无效 */
	private boolean followLightPermit;
	/*** 变道辅助 许可 1:有效 0：无效 */
	private boolean changeLanePermit;
	/*** 迎宾功能 许可 1:有效 0：无效 */
	private boolean welcomePermit;
	/*** 车道保持辅助系统 许可 1:有效 0：无效 **/
	private boolean laneKeepingPermit;
	/*** 疲劳检测系统 许可 1:有效 0：无效 **/
	private boolean tiredTestPermit;
	/*** 限速提示 许可 1:有效 0：无效 **/
	private boolean speedLimitPermit;
	/*** 主题颜色设置 许可 1:有效 0：无效 **/
	private boolean themeColorPermit;

	/*** 氛围模式选择 许可 1:有效 0：无效 **/
	private boolean ambientChoicePermit;
	/*** 离子净化器 许可 1:有效 0：无效 **/
	private boolean ionPurifyPermit;
	/*** 驾驶模式 许可 1:有效 0：无效 **/
	private boolean driveModePermit;
	/*** 香薰设置 许可 1:有效 0：无效 **/
	private boolean aromathePermit;
	/*** 屏幕亮度设置 许可 1:有效 0：无效 **/
	private boolean brightnessPermit;

	// PSA车辆设置信息1
	/*** 自动驻车 设置 1:启动 0：停用 */
	private boolean aotoStopSet;
	/*** 倒车雷达开关 设置 1:启动 0：停用 */
	private boolean reversRadarSet;
	/*** 迎宾照明 设置 00:取消  01:15s 10:30s 11:60s*/
	private byte lightWelcomeSet;
	/*** 氛围照明 设置 1:启动 0：停用 */
	private boolean lightAmbientSet;
	/*** 氛围照明值 设置 0--6 */
	private byte lightAmbientValue;
	
	/*** 倒车自动后雨刮 设置 1:启动 0：停用 */
	private boolean reversWiperSet;
	/*** 驻车辅助 设置 1:启动 0：停用 */
	private boolean stopAssistSet;
	/*** 车门自动上锁 设置 1:开（车速感应，车门自动落锁） 0：关 */
	private boolean doorAutoLockSet;
	/*** 车门上锁 设置 1:启动 0：停用 */
	private boolean doorLockSet;
	/*** 车门解锁 设置 1：驾驶门解锁  0：所有门解锁 */
	private byte doorUnlockSet;
	/*** 日间行车灯 设置 1:启动 0：停用 */
	private boolean dayLightSet;
	/*** 伴我回家照明（大灯延时熄灭）设置   00：取消    01:15秒   10:30秒   11:60秒 */
	private byte homeLightSet;
	
	// PSA车辆设置信息2
	/*** 仅行李箱解锁设置命令 设置 1:启动 0：停用 */
	private boolean trunkUnlockSet;
	/*** 随动转向大灯设置命令 设置 1:启动 0：停用 */
	private boolean followLightSet;
	/*** 变道辅助 设置 1:启动 0：停用*/
	private boolean changeLaneSet;
	/*** 迎宾功能 设置 1:启动 0：停用 */
	private boolean welcomeSet;
	/*** 车道保持辅助系统 设置 1:启动 0：停用 **/
	private boolean laneKeepingSet;
	/*** 疲劳检测系统  设置 1:启动 0：停用 **/
	private boolean tiredTestSet;
	/*** 限速提示  设置 1:启动 0：停用 **/
	private boolean speedLimitSet;
	/*** 主题颜色设置  设置 1:棕   0：蓝 **/
	private byte themeColorSet;
	
	/*** 氛围模式选择  设置 0:停用模式  1：舒适模式 2：动感模式**/
	private byte ambientChoiceSet;
	/*** 驾驶模式 设置 1:运动   0：标准**/
	private byte driveModeSet;
	/*** 离子净化器 设置 0：关   1:清洁  2：舒适 **/
	private byte ionPurifySet;
	/*** 香薰类型设置 0:林木清香  1:纯净皮质  2： 清新空气**/
	private byte aromatheSet;
	
	/*** 香薰浓度设置 0:关  1:低 2：中 3：高**/
	private byte aroConcentraSet;
	/*** 屏幕亮度设置  0--15 **/
	private byte brightnessSet;
	
	
	public byte getID() {
		return Constant.ID_SET;
	}

	public boolean isTrunkUnlockSet() {
		return trunkUnlockSet;
	}

	public void setTrunkUnlockSet(boolean trunkUnlockSet) {
		this.trunkUnlockSet = trunkUnlockSet;
	}

	public boolean isFollowLightSet() {
		return followLightSet;
	}

	public void setFollowLightSet(boolean followLightSet) {
		this.followLightSet = followLightSet;
	}

	public boolean isChangeLaneSet() {
		return changeLaneSet;
	}

	public void setChangeLaneSet(boolean changeLaneSet) {
		this.changeLaneSet = changeLaneSet;
	}

	public boolean isWelcomeSet() {
		return welcomeSet;
	}

	public void setWelcomeSet(boolean welcomeSet) {
		this.welcomeSet = welcomeSet;
	}

	public boolean isLaneKeepingSet() {
		return laneKeepingSet;
	}

	public void setLaneKeepingSet(boolean laneKeepingSet) {
		this.laneKeepingSet = laneKeepingSet;
	}

	public boolean isTiredTestSet() {
		return tiredTestSet;
	}

	public void setTiredTestSet(boolean tiredTestSet) {
		this.tiredTestSet = tiredTestSet;
	}

	public boolean isSpeedLimitSet() {
		return speedLimitSet;
	}

	public void setSpeedLimitSet(boolean speedLimitSet) {
		this.speedLimitSet = speedLimitSet;
	}

	public byte getThemeColorSet() {
		return themeColorSet;
	}

	public void setThemeColorSet(byte themeColorSet) {
		this.themeColorSet = themeColorSet;
	}

	public byte getAmbientChoiceSet() {
		return ambientChoiceSet;
	}

	public void setAmbientChoiceSet(byte ambientChoiceSet) {
		this.ambientChoiceSet = ambientChoiceSet;
	}

	public byte getDriveModeSet() {
		return driveModeSet;
	}

	public void setDriveModeSet(byte driveModeSet) {
		this.driveModeSet = driveModeSet;
	}

	public byte getIonPurifySet() {
		return ionPurifySet;
	}

	public void setIonPurifySet(byte ionPurifySet) {
		this.ionPurifySet = ionPurifySet;
	}

	public byte getAromatheSet() {
		return aromatheSet;
	}

	public void setAromatheSet(byte aromatheSet) {
		this.aromatheSet = aromatheSet;
	}

	public byte getAroConcentraSet() {
		return aroConcentraSet;
	}

	public void setAroConcentraSet(byte aroConcentraSet) {
		this.aroConcentraSet = aroConcentraSet;
	}

	public byte getBrightnessSet() {
		return brightnessSet;
	}

	public void setBrightnessSet(byte brightnessSet) {
		this.brightnessSet = brightnessSet;
	}

	public boolean isAotoStopSet() {
		return aotoStopSet;
	}

	public void setAotoStopSet(boolean aotoStopSet) {
		this.aotoStopSet = aotoStopSet;
	}

	public boolean isReversRadarSet() {
		return reversRadarSet;
	}

	public void setReversRadarSet(boolean reversRadarSet) {
		this.reversRadarSet = reversRadarSet;
	}

	public byte getLightWelcomeSet() {
		return lightWelcomeSet;
	}

	public void setLightWelcomeSet(byte lightWelcomeSet) {
		this.lightWelcomeSet = lightWelcomeSet;
	}

	public boolean isLightAmbientSet() {
		return lightAmbientSet;
	}

	public void setLightAmbientSet(boolean lightAmbientSet) {
		this.lightAmbientSet = lightAmbientSet;
	}

	public byte getLightAmbientValue() {
		return lightAmbientValue;
	}

	public void setLightAmbientValue(byte lightAmbientValue) {
		this.lightAmbientValue = lightAmbientValue;
	}

	public boolean isReversWiperSet() {
		return reversWiperSet;
	}

	public void setReversWiperSet(boolean reversWiperSet) {
		this.reversWiperSet = reversWiperSet;
	}

	public boolean isStopAssistSet() {
		return stopAssistSet;
	}

	public void setStopAssistSet(boolean stopAssistSet) {
		this.stopAssistSet = stopAssistSet;
	}
	
	public boolean isDoorAutoLockSet() {
		return doorAutoLockSet;
	}

	public void setDoorAutoLockSet(boolean doorAutoLockSet) {
		this.doorAutoLockSet = doorAutoLockSet;
	}
	public boolean isDoorLockSet() {
		return doorLockSet;
	}

	public void setDoorLockSet(boolean doorLockSet) {
		this.doorLockSet = doorLockSet;
	}

	public byte getDoorUnlockSet() {
		return doorUnlockSet;
	}

	public void setDoorUnlockSet(byte doorUnlockSet) {
		this.doorUnlockSet = doorUnlockSet;
	}

	public boolean isDayLightSet() {
		return dayLightSet;
	}

	public void setDayLightSet(boolean dayLightSet) {
		this.dayLightSet = dayLightSet;
	}

	public byte getHomeLightSet() {
		return homeLightSet;
	}

	public void setHomeLightSet(byte homeLightSet) {
		this.homeLightSet = homeLightSet;
	}

	public boolean isTrunkUnlockPermit() {
		return trunkUnlockPermit;
	}

	public void setTrunkUnlockPermit(boolean trunkUnlockPermit) {
		this.trunkUnlockPermit = trunkUnlockPermit;
	}

	public boolean isFollowLightPermit() {
		return followLightPermit;
	}

	public void setFollowLightPermit(boolean followLightPermit) {
		this.followLightPermit = followLightPermit;
	}

	public boolean isChangeLanePermit() {
		return changeLanePermit;
	}

	public void setChangeLanePermit(boolean changeLanePermit) {
		this.changeLanePermit = changeLanePermit;
	}

	public boolean isWelcomePermit() {
		return welcomePermit;
	}

	public void setWelcomePermit(boolean welcomePermit) {
		this.welcomePermit = welcomePermit;
	}

	public boolean isLaneKeepingPermit() {
		return laneKeepingPermit;
	}

	public void setLaneKeepingPermit(boolean laneKeepingPermit) {
		this.laneKeepingPermit = laneKeepingPermit;
	}

	public boolean isTiredTestPermit() {
		return tiredTestPermit;
	}

	public void setTiredTestPermit(boolean tiredTestPermit) {
		this.tiredTestPermit = tiredTestPermit;
	}

	public boolean isSpeedLimitPermit() {
		return speedLimitPermit;
	}

	public void setSpeedLimitPermit(boolean speedLimitPermit) {
		this.speedLimitPermit = speedLimitPermit;
	}

	public boolean isThemeColorPermit() {
		return themeColorPermit;
	}

	public void setThemeColorPermit(boolean themeColorPermit) {
		this.themeColorPermit = themeColorPermit;
	}

	public boolean isAmbientChoicePermit() {
		return ambientChoicePermit;
	}

	public void setAmbientChoicePermit(boolean ambientChoicePermit) {
		this.ambientChoicePermit = ambientChoicePermit;
	}

	public boolean isIonPurifyPermit() {
		return ionPurifyPermit;
	}

	public void setIonPurifyPermit(boolean ionPurifyPermit) {
		this.ionPurifyPermit = ionPurifyPermit;
	}

	public boolean isDriveModePermit() {
		return driveModePermit;
	}

	public void setDriveModePermit(boolean driveModePermit) {
		this.driveModePermit = driveModePermit;
	}

	public boolean isAromathePermit() {
		return aromathePermit;
	}

	public void setAromathePermit(boolean aromathePermit) {
		this.aromathePermit = aromathePermit;
	}

	public boolean isBrightnessPermit() {
		return brightnessPermit;
	}

	public void setBrightnessPermit(boolean brightnessPermit) {
		this.brightnessPermit = brightnessPermit;
	}

	public boolean isAotoStopPermit() {
		return aotoStopPermit;
	}

	public void setAotoStopPermit(boolean aotoStopPermit) {
		this.aotoStopPermit = aotoStopPermit;
	}

	public boolean isReversRadarPermit() {
		return reversRadarPermit;
	}

	public void setReversRadarPermit(boolean reversRadarPermit) {
		this.reversRadarPermit = reversRadarPermit;
	}

	public boolean isLightWelcomePermit() {
		return lightWelcomePermit;
	}

	public void setLightWelcomePermit(boolean lightWelcomePermit) {
		this.lightWelcomePermit = lightWelcomePermit;
	}

	public boolean isLightAmbientPermit() {
		return lightAmbientPermit;
	}

	public void setLightAmbientPermit(boolean lightAmbientPermit) {
		this.lightAmbientPermit = lightAmbientPermit;
	}

	public boolean isReversWiperPermit() {
		return reversWiperPermit;
	}

	public void setReversWiperPermit(boolean reversWiperPermit) {
		this.reversWiperPermit = reversWiperPermit;
	}

	public boolean isStopAssistPermit() {
		return stopAssistPermit;
	}

	public void setStopAssistPermit(boolean stopAssistPermit) {
		this.stopAssistPermit = stopAssistPermit;
	}

	public boolean isDoorAutoLockPermit() {
		return doorAutoLockPermit;
	}
	            
	public void setDoorAutoLockPermit(boolean doorAutoLockPermit) {
		this.doorAutoLockPermit = doorAutoLockPermit;
	}

	public boolean isDoorLockPermit() {
		return doorLockPermit;
	}

	public void setDoorLockPermit(boolean doorLockPermit) {
		this.doorLockPermit = doorLockPermit;
	}

	public boolean isDoorUnlockPermit() {
		return doorUnlockPermit;
	}

	public void setDoorUnlockPermit(boolean doorUnlockPermit) {
		this.doorUnlockPermit = doorUnlockPermit;
	}

	public boolean isDayLightPermit() {
		return dayLightPermit;
	}

	public void setDayLightPermit(boolean dayLightPermit) {
		this.dayLightPermit = dayLightPermit;
	}

	public boolean isHomeLightPermit() {
		return homeLightPermit;
	}

	public void setHomeLightPermit(boolean homeLightPermit) {
		this.homeLightPermit = homeLightPermit;
	}
}
