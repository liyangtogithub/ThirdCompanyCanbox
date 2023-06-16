package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/*** ������Ϣ */
public class SetInfo extends BaseInfo {

	// PSA����������Ϣʹ��1
	/*** �Զ�פ�� ��� 1:��Ч 0����Ч */
	private boolean aotoStopPermit;
	/*** �����״￪�� ��� 1:��Ч 0����Ч */
	private boolean reversRadarPermit;
	/*** ӭ������ ��� 1:��Ч 0����Ч */
	private boolean lightWelcomePermit;
	/*** ��Χ���� ��� 1:��Ч 0����Ч */
	private boolean lightAmbientPermit;
	/*** �����Զ������ ��� 1:��Ч 0����Ч */
	private boolean reversWiperPermit;
	/*** פ������ ��� 1:��Ч 0����Ч */
	private boolean stopAssistPermit;
	/*** �����Զ����� ��� 1:��Ч 0����Ч */
	private boolean doorAutoLockPermit;
	/*** �������� ��� 1:��Ч 0����Ч */
	private boolean doorLockPermit;
	/*** ���Ž��� ��� 1:��Ч 0����Ч */
	private boolean doorUnlockPermit;
	/*** �ռ��г��� ��� 1:��Ч 0����Ч */
	private boolean dayLightPermit;
	/*** ���һؼ������������ʱϨ�� ��� 1:��Ч 0����Ч */
	private boolean homeLightPermit;

	// PSA����������Ϣʹ��2
	/*** ������������������� ��� 1:��Ч 0����Ч */
	private boolean trunkUnlockPermit;
	/*** �涯ת������������ ��� 1:��Ч 0����Ч */
	private boolean followLightPermit;
	/*** ������� ��� 1:��Ч 0����Ч */
	private boolean changeLanePermit;
	/*** ӭ������ ��� 1:��Ч 0����Ч */
	private boolean welcomePermit;
	/*** �������ָ���ϵͳ ��� 1:��Ч 0����Ч **/
	private boolean laneKeepingPermit;
	/*** ƣ�ͼ��ϵͳ ��� 1:��Ч 0����Ч **/
	private boolean tiredTestPermit;
	/*** ������ʾ ��� 1:��Ч 0����Ч **/
	private boolean speedLimitPermit;
	/*** ������ɫ���� ��� 1:��Ч 0����Ч **/
	private boolean themeColorPermit;

	/*** ��Χģʽѡ�� ��� 1:��Ч 0����Ч **/
	private boolean ambientChoicePermit;
	/*** ���Ӿ����� ��� 1:��Ч 0����Ч **/
	private boolean ionPurifyPermit;
	/*** ��ʻģʽ ��� 1:��Ч 0����Ч **/
	private boolean driveModePermit;
	/*** ��޹���� ��� 1:��Ч 0����Ч **/
	private boolean aromathePermit;
	/*** ��Ļ�������� ��� 1:��Ч 0����Ч **/
	private boolean brightnessPermit;

	// PSA����������Ϣ1
	/*** �Զ�פ�� ���� 1:���� 0��ͣ�� */
	private boolean aotoStopSet;
	/*** �����״￪�� ���� 1:���� 0��ͣ�� */
	private boolean reversRadarSet;
	/*** ӭ������ ���� 00:ȡ��  01:15s 10:30s 11:60s*/
	private byte lightWelcomeSet;
	/*** ��Χ���� ���� 1:���� 0��ͣ�� */
	private boolean lightAmbientSet;
	/*** ��Χ����ֵ ���� 0--6 */
	private byte lightAmbientValue;
	
	/*** �����Զ������ ���� 1:���� 0��ͣ�� */
	private boolean reversWiperSet;
	/*** פ������ ���� 1:���� 0��ͣ�� */
	private boolean stopAssistSet;
	/*** �����Զ����� ���� 1:�������ٸ�Ӧ�������Զ������� 0���� */
	private boolean doorAutoLockSet;
	/*** �������� ���� 1:���� 0��ͣ�� */
	private boolean doorLockSet;
	/*** ���Ž��� ���� 1����ʻ�Ž���  0�������Ž��� */
	private byte doorUnlockSet;
	/*** �ռ��г��� ���� 1:���� 0��ͣ�� */
	private boolean dayLightSet;
	/*** ���һؼ������������ʱϨ������   00��ȡ��    01:15��   10:30��   11:60�� */
	private byte homeLightSet;
	
	// PSA����������Ϣ2
	/*** ������������������� ���� 1:���� 0��ͣ�� */
	private boolean trunkUnlockSet;
	/*** �涯ת������������ ���� 1:���� 0��ͣ�� */
	private boolean followLightSet;
	/*** ������� ���� 1:���� 0��ͣ��*/
	private boolean changeLaneSet;
	/*** ӭ������ ���� 1:���� 0��ͣ�� */
	private boolean welcomeSet;
	/*** �������ָ���ϵͳ ���� 1:���� 0��ͣ�� **/
	private boolean laneKeepingSet;
	/*** ƣ�ͼ��ϵͳ  ���� 1:���� 0��ͣ�� **/
	private boolean tiredTestSet;
	/*** ������ʾ  ���� 1:���� 0��ͣ�� **/
	private boolean speedLimitSet;
	/*** ������ɫ����  ���� 1:��   0���� **/
	private byte themeColorSet;
	
	/*** ��Χģʽѡ��  ���� 0:ͣ��ģʽ  1������ģʽ 2������ģʽ**/
	private byte ambientChoiceSet;
	/*** ��ʻģʽ ���� 1:�˶�   0����׼**/
	private byte driveModeSet;
	/*** ���Ӿ����� ���� 0����   1:���  2������ **/
	private byte ionPurifySet;
	/*** ��޹�������� 0:��ľ����  1:����Ƥ��  2�� ���¿���**/
	private byte aromatheSet;
	
	/*** ��޹Ũ������ 0:��  1:�� 2���� 3����**/
	private byte aroConcentraSet;
	/*** ��Ļ��������  0--15 **/
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
