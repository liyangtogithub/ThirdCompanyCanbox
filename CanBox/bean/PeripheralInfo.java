package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;
/**
 * ���ܱ��豸��Ϣ���ƣ����Ӿ�����ˮ��������ͷ������ת��ƣ���̥��Ϣ
 */
public class PeripheralInfo extends BaseInfo{
	
	
	public byte getID(){
		return Constant.ID_PERIPHERAL;
	};
	//���ڵƹ�ʹ��λ 
	/***����������ɫ  ���  1:��Ч  0����Ч*/
	private boolean lightColorPermit;
	/***���ڷ�Χ����  ���  1:��Ч  0����Ч*/
	private boolean lightAmbientPermit;
	/***��ǰ�ҵ�����  ���  1:��Ч  0����Ч*/
	private boolean lightAdjustPermit;
	/***����������ɫ  ����    0���ر�  1:��ɫ  2����ɫ 3����ɫ*/
	private byte lightColorSet;
	/***���ڷ�Χ����  ����  0--100*/
	private byte lightAmbientSet;
	/***��ǰ�ҵ�����  ����  0--100*/
	private byte lightAdjustSet;
	//�ƹ⸨��ʹ��λ ���
	/***��̬�ƹ⸨��  ���  1:��Ч  0����Ч*/
	private boolean dynamicAssistPermit;
	/***��̬����涯  ���  1:��Ч  0����Ч*/
	private boolean dynamicBendPermit;
	/***��ʱ��  ���  1:��Ч  0����Ч*/
	private boolean openTimePermit;
	/***�Զ��г���  ���  1:��Ч  0����Ч*/
	private boolean autoLightPermit;
	/***���ת���  ���  1:��Ч  0����Ч*/
	private boolean laneChangePermit;
	/***����ģʽ  ���  1:��Ч  0����Ч*/
	private boolean travelModePermit;
	/***�ռ��г���  ���  1:��Ч  0����Ч*/
	private boolean dayLightPermit;
	//�ƹ⸨��  ����
	/*** ��̬�ƹ⸨��  ���� 1:��  0���� */
	private boolean dynamicAssistSet;
	/*** ��̬����涯  ���� 1:��  0���� */
	private boolean dynamicBendSet;
	/*** ��ʱ��  ���� 1:��  0����  */
	private byte openTimeSet;
	/*** �Զ��г���  ���� 1:��  0����  */
	private boolean autoLightSet;
	/*** ���ת��� ���� 1:��  0����  */
	private boolean laneChangeSet;
	/*** ����ģʽ  ����  1:���� 0������ */
	private byte travelModeSet;
	/*** �ռ��г��� ���� 1:��  0����  */
	private boolean dayLightSet;
	//���ڵƹ�ʹ��λ
	/***�Ǳ�/��������  ���  1:��Ч  0����Ч*/
	private boolean switchLightPermit;
	/***���Ż���������  ���  1:��Ч  0����Ч*/
	private boolean doorLightPermit;
	/***�Ų��ռ�����  ���  1:��Ч  0����Ч*/
	private boolean footLightPermit;
	/***�ؼ�����  ���  1:��Ч  0����Ч*/
	private boolean homeLightPermit;
	/***�������  ���  1:��Ч  0����Ч*/
	private boolean leaveLightPermit;
	// ���ڵƹ�ʹ��λ
	/*** �Ǳ�/�������� ���� 0--100% */
	private byte switchLightSet;
	/*** ���Ż��������� ���� 0--100% */
	private byte doorLightSet;
	/*** �Ų��ռ����� ���� 0--100% */
	private byte footLightSet;
	/*** �ؼ����� ���� 0--30 */
	private byte homeLightSet;
	/*** ������� ���� 0--30 */
	private byte leaveLightSet;
	
	/*** ��ת��� ���� 1:��  0����  */
	private boolean leftLightSet;
	/*** ��ת��� ���� 1:��  0����  */
	private boolean rightLightSet;
	
	/*** ����ͷģʽ  01�������ͼ  02����׼��ͼ  03��������ͼ  09���ӱ���ͼ */
	private byte cameraMode;
	/*** ����ͷ����  1 ��  2 �� */
	private boolean cameraOn;
	/*** ����ͷ��ʱ  1 ��  0 �� */
	private boolean cameraDelayed;
	/*** ������ͷ����*/
	private boolean cameraOnRight;
	// ���Ӿ�����ˮ�� ���
	/***ͬ������  ���  1:��Ч  0����Ч*/
	private boolean synchroAdjustPermit;
	/***����ʱ���Ӿ���ת  ���  1:��Ч  0����Ч*/
	private boolean lowerReversPermit;
	/***ͣ��ʱ���Ӿ�����  ���  1:��Ч  0����Ч*/
	private boolean foldParkedPermit;
	/***�����Զ���ˮ  ���  1:��Ч  0����Ч*/
	private boolean wipingRainPermit;
	/***����ʱ�󴰲�����ˮ  ���  1:��Ч  0����Ч*/
	private boolean rearWipingReversPermit;
	// ���Ӿ�����ˮ�� ����
	/***ͬ������  ����  1:��  0����*/
	private boolean synchroAdjustSet;
	/***����ʱ���Ӿ���ת  ����   1:��  0����*/
	private boolean lowerReversSet;
	/***ͣ��ʱ���Ӿ�����  ����   1:��  0����*/
	private boolean foldParkedSet;
	/***�����Զ���ˮ  ����   1:��  0����*/
	private boolean wipingRainSet;
	/***����ʱ�󴰲�����ˮ  ����   1:��  0����*/
	private boolean rearWipingReversSet;
	// ��̥
	/***��̥ѹ�������ʾ ���  1:��Ч  0����Ч*/
	private boolean tyerMonitorShowPermit;
	/***������̥���ٱ��� ���  1:��Ч  0����Ч*/
	private boolean tyerSpeedWarningPermit;
	/***������̥���ٱ��� �趨   1:��  0����*/
	private boolean tyerSpeedWarningSet;
	/***��̥���ٱ���ֵ   */
	private int tyerSpeedValue;
	//ͨ�� ����  ���
	/***Ѱ���ƹ����趨 ���  1:��Ч  0����Ч*/
	private boolean findLightPermit;
	/***���������ʱ�趨 ���  1:��Ч  0����Ч*/
	private boolean lightDelayPermit;
	/***ת��� ���  1:��Ч  0����Ч*/
	private boolean turnLightPermit;
	//ͨ�� ����  �趨
	/***Ѱ���ƹ����趨  1:�� 0����*/
	private boolean findLightSet;
	/***���������ʱ�趨    0:�� 1:30s 2:60s 3:120s*/
	private byte lightDelaySet;
	/***��ת���  1:�� 0����*/
	private boolean turnLightRSet;
	/***��ת���  1:�� 0����*/
	private boolean turnLightLSet;
	//ͨ�� ̥ѹ
	/***̥ѹ���  1:��Ч  0����Ч*/
	private boolean tyerMonitorPermit;
	/***��ǰ̥ѹֵ*/
	private int tyerLFValue;
	/***��ǰ̥ѹֵ*/
	private int tyerRFValue;
	/***���̥ѹֵ*/
	private int tyerLBValue;
	/***�Һ�̥ѹֵ*/
	private int tyerRBValue;
	/***��̥̥ѹֵ*/
	private int tyerSValue;
	
	/***��ǰ̥���̥ѹ��ʾ*/
	private boolean tyerLFWarn;
	/***��ǰ̥̥ѹ�ͱ���*/
	private boolean tyerLFLow;
	/***��ǰ̥̥ѹ�߱���*/
	private boolean tyerLFHigh;
	/***��ǰ̥���̥ѹ��ʾ*/
	private boolean tyerRFWarn;
	/***��ǰ̥̥ѹ�ͱ���*/
	private boolean tyerRFLow;
	/***��ǰ̥̥ѹ�߱���*/
	private boolean tyerRFHigh;
	/***���̥���̥ѹ��ʾ*/
	private boolean tyerLBWarn;
	/***���̥̥ѹ�ͱ���*/
	private boolean tyerLBLow;
	/***���̥̥ѹ�߱���*/
	private boolean tyerLBHigh;
	/***�Һ�̥���̥ѹ��ʾ*/
	private boolean tyerRBWarn;
	/***�Һ�̥̥ѹ�ͱ���*/
	private boolean tyerRBLow;
	/***�Һ�̥̥ѹ�߱���*/
	private boolean tyerRBHigh;
	//ͨ��  ָ����
	/***ָ������Ч */
	private boolean compassPermit;
	/***У׼ */
	private boolean compassCalib;
	/***���� 1--15 */
	private byte compassArea;
	/***�Ƕ�  */
	private float compassAngle;
	//ͨ��  �Ǳ����
	/***��϶���ECOָʾ */
	private boolean meterEcoPermit;
	/***�Ǳ�����Ϣ */
	private boolean meterNavPermit;
	/***�ٶȷ�Χ��ʾ */
	private boolean meterSpePermit;
	//ͨ��  �Ǳ�����
    /***��϶���ECOָʾ 1�� 0�� */
	private boolean meterEcoSet;
	/***�Ǳ�����Ϣ  1�� 0�� */
	private boolean meterNavSet;
	/***�ٶȷ�Χ��ʾ  1ȫ�� 0�ֲ� */
	private boolean meterSpeAllSet;
	//ͨ��  ������������
	/***���� */
	private byte soundOrder;
	/***���� */
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
