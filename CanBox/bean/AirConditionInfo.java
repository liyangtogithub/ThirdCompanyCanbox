package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

public class AirConditionInfo extends BaseInfo{
	/*** �յ���ʾ*/
	private boolean showAir;//true:��; false:��
	/*** �յ����� */
	private boolean switchAir = true;
	/***ѭ��ģʽ,��ѭ��*/
	private boolean circleOut ;
	
	private boolean autoSwitch1;
	private boolean autoSwitch2;
	private boolean dualSwitch;
	private boolean acMaxSwitch;
	/*** �����յ�ʹ��*/
	private boolean backAirEnable;
	/*** A/C*/
	private boolean acEnable;
	/*** �Զ�����*/
	private boolean autoWindowDemist;
	/*** �󴰳���*/
	private boolean backWindowDemist;
	/*** ǰ������*/
	private boolean frontWindowDemist;
	/*** ������μ��ȵȼ� 0����ʾ�ر� 1-3����ʾ�����ȼ�*/
	private int leftSeatHeatGrade = Constant.PROTOCAL_INVALID_VALUE;
	/*** �ұ����μ��ȵȼ�* 0����ʾ�ر�* 1-3����ʾ�����ȼ�*/
	private int rightSeatHeatGrade = Constant.PROTOCAL_INVALID_VALUE;
	/*** ǰ���������¶�����ֵ*/
	private float frontLeftSeatSetTemp = Constant.PROTOCAL_INVALID_VALUE;
	/*** ǰ���������¶�����ֵ*/
	private float frontRightSeatSetTemp = Constant.PROTOCAL_INVALID_VALUE;
	/*** �󴵷�:����     ��ЩЭ�鲻�����Ҵ��磬���ж���ߴ���ģʽ����*/
	private boolean leftWindBlowFoot;
	/** *�󴵷�:����     ��ЩЭ�鲻�����Ҵ��磬���ж���ߴ���ģʽ����*/
	private boolean leftWindBlowBody;
	/** *�󴵷�:��ͷ*/
	private boolean leftWindBlowHead;
	/*** �󴵷�:����     ��ЩЭ�鲻�����Ҵ��磬���ж���ߴ���ģʽ����*/
	private boolean leftWindBlowWindow;
	/*** ����ٵȼ�:0:��;1-7:�߸��ȼ�   ��ЩЭ�鲻�����Ҵ��磬���ж���ߴ���ģʽ���� */
	private byte leftWindGrade;
	/*** ���ٵȼ�:���� */
	private float WindGradeTotal =7;
	/*** �Ҵ���:����     ��ЩЭ�鲻�����Ҵ��磬���ж���ߴ���ģʽ����*/
	private boolean rightWindBlowFoot;
	/*** �Ҵ���:����     ��ЩЭ�鲻�����Ҵ��磬���ж���ߴ���ģʽ����*/
	private boolean rightWindBlowBody;
	/*** �Ҵ���:��ͷ*/
	private boolean rightWindBlowHead;
	/*** �Ҵ���:����     ��ЩЭ�鲻�����Ҵ��磬���ж���ߴ���ģʽ����*/
	private boolean rightWindBlowWindow;
	/*** �ҷ��ٵȼ�:0:��;1-7:�߸��ȼ�   ��ЩЭ�鲻�����Ҵ��磬���ж���ߴ���ģʽ����*/
	private byte rightWindGrade;
	/*** �����¶�*/
	private float outdoorTemp = Constant.PROTOCAL_INVALID_VALUE;;
	
	//�Ƶ��ǿ�
	/*** sync*/
	private boolean sync;
	/***��յ�����*/
	private boolean rearOpen;
	/***�¶ȵ�λ  1:���϶�  0�����϶�*/
	private boolean Centigrade;
	/*** �������ͨ��ȼ� 0����ʾ�ر� 1-3����ʾ�����ȼ�*/
	private byte leftSeatWindGrade ;
	/*** �ұ�����ͨ��ȼ�* 0����ʾ�ر�* 1-3����ʾ�����ȼ�*/
	private byte rightSeatWindGrade ;
	/*** �Զ������ȼ�* 0����ʾ��* 1����ʾ�� 2����*/
	private byte autoWindGrade ;
	/*** ��������*/
	private boolean clearAirEnable ;
	/*** �����̼���*/
	private boolean steeringWheelHeat ;
	/*** ���η�����ͬ��*/
	private boolean syncSteeringWheelSeat ;
	/*** �ͷ�ģʽ 0:�� ��1���Զ�*/
	private boolean autoWindMode ;
	/*** ���������¶�����ֵ*/
	private float backSeatSetTemp = Constant.PROTOCAL_INVALID_VALUE;
	//����
	private boolean maxHeat;
	/***���ſ������  1:��  0����*/
	private boolean backPanel;
	/***���ŷ��� 1--7 */
	private byte backWindGrade;
	/***�����¶� 1--9 */
	private byte backTemp;
	//PSA
	/***��һ����  1:��  0����*/
	private boolean mono;
	/*** �����ȼ�* 0����ʾ��* 1����ʾ�� 2����*/
	private byte windGrade ;
	//ͨ��
	/*** HybridAC  ��HybridAC ��*/
	private boolean HybridAC;
	/*** ͨ��sync 0����  1����   2��û׼����  3����֧��*/
	private byte gmSync;
	/***�������μ���/ͨ��  1ͨ��  0����*/
	private byte copilotStates;
	/***�������μ���/ͨ�� 1ͨ��  0����*/
	private byte mainStates;
	/***��������*/
	private boolean airQualEnable;
	/***���ŷ���ģʽ  0�� 1�Զ�  2���� 3������ 4���� */
	private byte backWindMode;
	/***���ŷ�����Ϣ  0�� 1-4�ֶ��ٶ� 5�Զ�����*/
	private byte backWindInfo;
	/***�Զ�����ѭ�� �趨  1:��  0����*/
	private boolean autocyclicModeSet;
	
	/*** �Զ�����ģʽ ��� 1:��Ч 0����Ч */
	private boolean autoWindQuantityPermit;
	/***ǰ���Զ�ȥ�� ���  1:��Ч  0����Ч*/
	private boolean autoFrontWindowDemistPermit;
	/***ǰ���Զ�ȥ�� �趨  1:��  0����*/
	private boolean autoFrontWindowDemistSet;
	// ���
	/*** �յ�ģʽ�趨 ��� 1:��Ч 0����Ч */
	private boolean airModePermit;
	/*** ��������������1�趨 ��� 1:��Ч 0����Ч */
	private boolean airSensor1Permit;
	/*** �Զ������¶��趨 ��� 1:��Ч 0����Ч */
	private boolean aotoTempPermit;
	/*** �����Զ�ͨ���趨 ��� 1:��Ч 0����Ч */
	private boolean seatWindPermit;
	/*** �����Զ������趨 ��� 1:��Ч 0����Ч */
	private boolean seatHeatPermit;
	/*** ң�����������Զ�ͨ���趨 ��� 1:��Ч 0����Ч */
	private boolean remoteSeatWindPermit;
	/*** ң�����������Զ������趨 ��� 1:��Ч 0����Ч */
	private boolean remoteSeatHeatPermit;

	/*** ���������¶��趨 ��� 1:��Ч 0����Ч */
	private boolean backTempPermit;
	/*** ���Զ�ȥ���趨 ��� 1:��Ч 0����Ч */
	private boolean autoBackWindowDemistPermit;
	/*** ң�������յ��趨 ��� 1:��Ч 0����Ч */
	private boolean remoteStartAirPermit;
	/*** ��������������2�趨 ��� 1:��Ч 0����Ч */
	private boolean airSensor2Permit;
	/*** Զ�����������Զ�����1 ��� 1:��Ч 0����Ч */
	private boolean remoteSeatHeat1Permit;
	// �趨
	/*** �Զ�����ģʽ 0�� 1�� 2�� */
	private byte autoWindQuantitySet;
	/*** �յ�ģʽ�趨 0�� 1�� 2�ϴ����� */
	private byte airModeSet;
	/*** ��������������1�趨 0�����ж� 1�����ж� 2�� */
	private byte airSensor1Set;
	/*** �Զ������¶��趨 0ͳһ���� 1�������� 2�ϴ��趨 */
	private byte aotoTempSet;
	/*** �����Զ�ͨ���趨 1:�� 0���� */
	private boolean seatWindSet;
	/*** �����Զ������趨 1:�� 0���� */
	private boolean seatHeatSet;
	/*** ң�����������Զ�ͨ���趨 1:�� 0���� */
	private boolean remoteSeatWindSet;
	/*** ң�����������Զ������趨 1:�� 0���� */
	private boolean remoteSeatHeatSet;

	/*** ���������¶��趨 0�� 1ͬǰ��һ�� 2�ϴ��趨 */
	private byte backTempSet;
	/*** ���Զ�ȥ���趨 1:�Զ� 0���ֶ� */
	private boolean autoBackWindowDemistSet;
	/*** ң�������յ��趨 1:�Զ� 0���ֶ� */
	private boolean remoteStartAirSet;
	/*** ��������������2�趨 0�������� 1�����ж� 2�� */
	private byte airSensor2Set;
	/*** Զ�����������Զ�����1 0�� 1��ʻԱ�ͳ˿� 2��ʻԱ */
	private byte remoteSeatHeat1Set;
	//�Ƶ��ǿ�
	/***�Զ�����ѭ�� ���  1:��Ч  0����Ч*/
	private boolean autocyclicModePermit;
	//����
	/***״̬*/
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
