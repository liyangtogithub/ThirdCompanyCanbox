package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/**
 * 
 * @author LQPDC ��ʻԱ����ϵͳ�趨��Ϣ
 */
public class DriverAssistInfo extends BaseInfo {

	/*** ·��ͣ�� */
	private boolean stopRoadSide;
	/*** ���ͣ�� */
	private boolean stopInGarage;
	/*** �״ﾲ����ʹ�ܣ����������� */
	private boolean radarMute;

	/*** �Զ����� ��� 1:��Ч 0����Ч */
	private boolean autoActivatePermit;
	/*** ǰ����ʾ���� ��� 1:��Ч 0����Ч */
	private boolean frontVolumePermit;
	/*** ǰ����ʾ���� ��� 1:��Ч 0����Ч */
	private boolean frontTonePermit;
	/*** ����ʾ���� ��� 1:��Ч 0����Ч */
	private boolean rearVolumePermit;
	/*** ����ʾ���� ��� 1:��Ч 0����Ч */
	private boolean rearTonePermit;
	/*** ʻ����λ ��� 1:��Ч 0����Ч */
	private boolean driveOutPermit;
	/*** ������ʽ ��� 1:��Ч 0����Ч */
	private boolean parkingModePermit;
	/*** �״����� ��� 1:��Ч 0����Ч */
	private boolean radarVolumePermit;

	/*** �Զ����� �趨 1:�� 0���� */
	private boolean autoActivateSet;
	/*** ʻ����λ �趨 1:�� 0���� */
	private boolean driveOutSet;
	/*** ǰ����ʾ���� �趨 1--9 */
	private byte frontVolumeSet;
	/*** ǰ����ʾ���� �趨 1--9 */
	private byte frontToneSet;
	/*** ����ʾ���� �趨 1--9 */
	private byte rearVolumeSet;
	/*** ����ʾ���� �趨 1--9 */
	private byte rearToneSet;

	/*** ����ӦѲ�� ��ʻ���� ��Ч */
	private boolean drivingProcedurePermit;
	/*** ����ӦѲ�� �ϴ�ѡ��ĳ��� ��Ч */
	private boolean lastDistanceSelectPermit;
	/*** ǰ������ϵͳ ���� ��Ч */
	private boolean frontActivePermit;
	/*** ǰ������ϵͳ Ԥ�� ��Ч */
	private boolean frontAdvanceWarnPermit;
	/*** ǰ������ϵͳ ���뱨�� ��Ч */
	private boolean frontDistanceWarnPermit;
	/*** ����Ӧ�������� ��Ч */
	private boolean laneGuidancePermit;
	/*** ��ͨ��־ʶ�� ��Ч */
	private boolean trafficeSignPermit;
	/*** ƣ�ͼ�ʻʶ�� ��Ч */
	private boolean driveAlertPermit;
	/*** ä����� ��Ч */
	private boolean blindAreaPermit;
	/*** Ԥ��ʽ��Ա����ϵͳ ��Ч */
	private boolean proactiveProtectionPermit;
	/*** �������ָ���ϵͳ ��Ч */
	private boolean laneKeepingPermit;

	/*** ����ӦѲ�� ��ʻ���� ���� 00�����ã�01����׼��10���˶� */
	private byte drivingProcedureSet;
	/*** ����ӦѲ�� �ϴ�ѡ��ĳ��� ���� 1:�� 0���� */
	private boolean lastDistanceSelectSet;
	/*** ����ӦѲ�� ���� ���� 0����С 1��С 2���е� 3���� 4������ */
	private byte distanceSet;
	/*** ǰ������ϵͳ ���� ���� */
	private boolean frontActiveSet;
	/*** ǰ������ϵͳ Ԥ�� ���� */
	private boolean frontAdvanceWarnSet;
	/*** ǰ������ϵͳ ���뱨�� ���� */
	private boolean frontDistanceWarnSet;
	/*** ǰ������ϵͳ Ԥ��ʱ�� ���� 00���ر� 01����ǰ 10����ʱ 11���Ӻ� */
	private byte frontAdvanceWarnTimeSet;
	/*** ����Ӧ�������� ���� */
	private boolean laneGuidanceSet;
	/*** ��ͨ��־ʶ�� ���� */
	private boolean trafficeSignSet;
	/*** ƣ�ͼ�ʻʶ�� ���� */
	private boolean driveAlertSet;
	/*** ä����� ���� */
	private boolean blindAreaSet;
	/*** Ԥ��ʽ��Ա����ϵͳ ���� */
	private boolean proactiveProtectionSet;
	/*** �������ָ���ϵͳ ���� */
	private boolean laneKeepingSet;

	// PSA ���� ����
	/*** �״ﲻ��ʾ 1:�� 0���� */
	private boolean radarNoShow;
	/*** �������� 1-5 1��С */
	private byte warnVoice;
	/*** ǰ�״���� 1��1�� 2:2�� */
	private byte radarFDistance;
	/*** ���״���� 1��1�� 2:2�� */
	private byte radarBDistance;

	// PSA���� ����
	/*** �����Զ����� ���� 1:�������ٸ�Ӧ�������Զ������� 0���� */
	private boolean doorAutoLockSet;
	/*** �����Զ����� ���� 1:��������ʻԱ�ţ� 0�����г��� */
	private boolean doorIntelUnlockSet;
	/*** ��ʻԱ������������ ���� 1:�� 0���� */
	private boolean doorLinkUnlockSet;
	/*** �����Զ�����P�� ���� 1:�� 0���� */
	private boolean doorAutoUnlockPSet;
	/*** �����Զ�����P�� ���� 1:�� 0���� */
	private boolean doorAutoLockPSet;
	/*** �յ���AUTO���� ���� 1:��(�Զ�A/C) 0���� */
	private boolean autoACSet;
	/*** ����ѭ���л���AUTO������ ���� 1:��(��Чͨ��ģʽ) 0���� */
	private boolean autoLinkCycleSet;

	// PSA ң�� �趨
	/*** ��������ʱ������˸����Ӧ 1:��(��ֹ/��������ָʾ��) 0���� */
	private boolean feedbackByLight;
	/*** ��ť���ΰ��½��� 1:�� 0���� */
	private boolean remotePress2;
	/*** ���ܳ�����һ������ 1:��(������Կ�׵Ľ���ϵͳԿ��) 0���� */
	private boolean intelligentLock;
	/*** Կ�����ΰ��½��� 1:�� 0���� */
	private boolean keyPress2;

	// PSA��ײ�����ϵͳ�趨
	/*** ���������ر�ʱ�� 0����Ч 1:7.5s 2��15s 3:30s */
	private byte lightOffTime;
	/*** �Զ�ͷ���������趨 0--4�ȼ� */
	private byte headSens;

	// ͨ�� ��ײ/���ϵͳ�趨
	// ���
	/*** ��������ϵͳ�趨 ��� */
	private boolean parkAssistPermit;
	/*** ��ä������ϵͳ�趨 ��� */
	private boolean sideBlindPermit;
	/*** ��ײ���������趨 ��� */
	private boolean anticolPermit;
	/*** ��������ϵͳ�趨 ���ϳ����� ��� */
	private boolean parkTrailerPermit;
	/*** 24G HZ �״��趨 ��� */
	private boolean radar24gPermit;
	/*** �Զ���ײ׼�� ��� */
	private boolean autoAnticolPermit;
	// ����
	/*** ��������ϵͳ�趨 ���� */
	private boolean parkAssistSet;
	/*** ��ä������ϵͳ�趨 ���� */
	private boolean sideBlindSet;
	/*** ��ײ���������趨 ���� 0�������� 1���� */
	private byte anticolSet;
	/*** ��������ϵͳ�趨 ���ϳ����� ���� 0�� 1�� 2�ϳ����� */
	private byte parkTrailerSet;
	/*** 24G HZ �״��趨 ���� */
	private boolean radar24gSet;
	/*** �Զ���ײ׼�� ���� 0�ر� 1���� 2�������ƶ� */
	private byte autoAnticolSet;
	// ͨ�� ��ײ/���ϵͳ�趨2
	// ���
	/*** ����״̬֪ͨ */
	private boolean carStatePermit;
	/*** �µ��𲽸���ϵͳ */
	private boolean rampAssistPermit;
	/*** ����ӦѲ���������� */
	private boolean adapCruisePermit;
	// ����
	/*** ����״̬֪ͨ */
	private boolean carStateSet;
	/*** �µ��𲽸���ϵͳ 0��׼ 1��ǿ */
	private byte rampAssistSet;
	/*** ����ӦѲ���������� */
	private boolean adapCruiseSet;
	// ͨ�� �������뷽����
	// ���
	/*** ��ʻԱ����ͣ����λ�趨 ��� */
	private boolean stopShiftPermit;
	/*** ת������복��λ�趨 ��� */
	private boolean leaveShiftPermit;
	/*** ����Ӿ������Զ���б�趨 ��� */
	private boolean autotiltPermit;
	/*** ����Ӿ��Զ��۵��趨 ��� */
	private boolean autoFoldPermit;
	/*** ��ʻԱ���������趨 ��� */
	private boolean personSetPermit;
	/*** �����Զ�����ˢ�趨 ��� */
	private boolean backWiperPermit;
	/*** ת������복��б�趨 ��� */
	private boolean leaveTiltPermit;
	// ����
	/*** ��ʻԱ����ͣ����λ�趨 */
	private boolean stopShiftSet;
	/*** ת������복��λ�趨 0�� 1���� 2���� 3���������� */
	private byte leaveShiftSet;
	/*** ����Ӿ������Զ���б�趨 */
	private boolean autotiltSet;
	/*** ����Ӿ��Զ��۵��趨 */
	private boolean autoFoldSet;
	/*** ��ʻԱ���������趨 */
	private boolean personSetSet;
	/*** �����Զ�����ˢ�趨 */
	private boolean backWiperSet;
	/*** ת������복��б�趨 */
	private boolean leaveTiltSet;
	// ͨ�� �������뷽����2
	// ���
	/*** �Զ���� ��� */
	private boolean autoWiperPermit;
	// ����
	/*** �Զ���� */
	private boolean autoWiperSet;
	// ͨ�� �����趨
	/***��ֹ�����Զ�����  ���*/
	private boolean prevLockPermit;
	/***�Զ�����   ���*/
	private boolean autoLockPermit;
	/***�Զ��������Զ��� ��  ���*/
	private boolean autoUnLockAPermit;
	/***�ӳ�����  ���*/
	private boolean delayLockPermit;
	/***�Զ��������ֶ��� ��   ���*/
	private boolean autoUnLockHPermit;
	/***��ֹ�����Զ�����  */
	private boolean prevLockSet;
	/***�Զ�����   */
	private boolean autoLockSet;
	/***�Զ��������Զ��� ��  */
	private byte autoUnLockASet;
	/***�ӳ�����  */
	private boolean delayLockSet;
	/***�Զ��������ֶ��� ��   */
	private byte autoUnLockHSet;
	//ң���� ���
	/***ң����������  ���*/
	private boolean remLockPermit;
	/***ң�ؽ�������  ���*/
	private boolean remULFbPermit;
	/***ң�ؽ����趨 ���*/
	private boolean remULPermit;
	/***Զ�̽������� �Զ������趨 ���*/
	private boolean remULRepPermit;
	/***����ң�ش򿪵��� �趨  ���*/
	private boolean repRemPermit;
	/***��ʻԱԿ���Զ�ʶ�� �趨  ���*/
	private boolean keyKnownPermit;
	/***Զ�������趨  ���*/
	private boolean remStartPermit;
	/***���ܽ��������趨  ���*/
	private boolean nearULPermit;
	/***�����복�����趨  ���*/
	private boolean leaveULPermit;
	/***Կ�����������趨  ���*/
	private boolean keyMindPermit;
	/***ң�ػ���������    ���*/
	private boolean remSlidePermit;
	/***ң�س�������  ���*/
	private boolean remWinPermit;
	//ң���� ����
	/***ң����������   0���ƹ� 1�ƹ������� 2 ������ 3��*/
	private byte remLockSet;
	/***ң�ؽ�������  0�� 1�ƹ���˸ */
	private boolean remULFbSet;
	/***ң�ؽ����趨  0����ʻԱ��  1ȫ��*/
	private byte remULSet;
	/***Զ�̽������� �Զ������趨*/
	private boolean remULRepSet;
	/***����ң�ش򿪵��� �趨*/
	private boolean repRemSet;
	/***��ʻԱԿ���Զ�ʶ�� �趨*/
	private boolean keyKnownSet;
	/***Զ�������趨*/
	private boolean remStartSet;
	/***���ܽ��������趨   0����ʻԱ��  1ȫ��*/
	private byte nearULSet;
	/***�����복�����趨   0��  1��  2������������*/
	private byte leaveULSet;
	/***Կ�����������趨*/
	private boolean keyMindSet;
	/***ң�ػ���������   1 ���������Ų��򿪻�����  0���������Ų��򿪻�����*/
	private byte remSlideSet;
	/***ң�س������� */
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
