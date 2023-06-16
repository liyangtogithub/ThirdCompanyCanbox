package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/*** �Ƶ��ǿ�Э��: ��ʻģʽ���˶�ģʽ */
public class DriveModeInfo extends BaseInfo {

	// �˶�ģʽ ���
	/*** �˶�ģʽʹ�� ��� 1:��Ч 0����Ч */
	private boolean EscSystemPermit;
	// �˶�ģʽ ����
	/*** �˶�ģʽʹ�� ��� 0:ASR�ر� 1���Ѽ��� 2��ESC�˶�ģʽ */
	private byte EscSystemSet;
	// ��ʻģʽ ���
	/*** ���� ��� 1:��Ч 0����Ч */
	private boolean comfortPermit;
	/*** ��׼ ��� 1:��Ч 0����Ч */
	private boolean normalPermit;
	/*** �˶� ��� 1:��Ч 0����Ч */
	private boolean sportPermit;
	/*** ���� ��� 1:��Ч 0����Ч */
	private boolean ecoPermit;
	/*** ���Ի� ��� 1:��Ч 0����Ч */
	private boolean indivdualPermit;
	/*** ѩ����� 1:��Ч 0����Ч */
	private boolean snowPermit;
	/*** ԽҰ��� 1:��Ч 0����Ч */
	private boolean crossPermit;
	/*** ԽҰ���Ի� ��� 1:��Ч 0����Ч */
	private boolean crossIndivPermit;
	// ��ʻģʽ ����
	/*** ���� ���� 1:�� 0���� */
	private boolean comfortSet;
	/*** ��׼ ���� 1:�� 0���� */
	private boolean normalSet;
	/*** �˶� ���� 1:�� 0���� */
	private boolean sportSet;
	/*** ���� ���� 1:�� 0���� */
	private boolean ecoSet;
	/*** ���Ի� ���� 1:�� 0���� */
	private boolean indivdualSet;
	/*** ѩ����� ���� 1:�� 0���� */
	private boolean snowSet;
	/*** ԽҰ��� ���� 1:�� 0���� */
	private boolean crossSet;
	/*** ԽҰ���Ի� ���� 1:�� 0���� */
	private boolean crossIndivSet;
	// ���Ի� ����
	/*** DCC ���� 00:comfort 01:normal 10:sport */
	private byte DccSet;
	/*** ��̬����涯 ���� 00:normal 01:sport 10:eco */
	private byte bendLightSet;
	/*** ������ ���� 00:normal 01:sport 10:eco */
	private byte engineSet;
	/*** ACC����ӦѲ�� ���� 00:normal 01:sport 10:eco */
	private byte accAdaptionSet;
	/*** �յ� ���� 1:normal 0:eco */
	private byte airConditionSet;
	/*** ������ת��ϵͳ ���� 1:normal 0:eco */
	private byte steeringSet;
	// ��ʻģʽ2 ����
	/*** ����˵� ���� 1:���� 0���� */
	private boolean inMenuSet2;
	// ��ʻģʽ2 ���Ի� ����
	/*** ��̬����涯 ���� 00:��׼ 01:�˶� 10:���� */
	private byte bendLightSet2;
	/*** ����������װ�� ���� 00:��׼ 01:ԽҰ */
	private byte engineSet2;
	/*** ACC����ӦѲ�� ���� 00:��׼ 01:�˶� 10:���� */
	private byte accAdaptionSet2;
	/*** �յ� ���� 0:���� 1:��׼ */
	private byte airConditionSet2;
	/*** ������ת��ϵͳ ���� 1:��׼ 0:�˶� */
	private byte steeringSet2;
	/*** �������� ���� 0:��׼ 1:ԽҰ */
	private byte fourDriveSet2;
	/*** ���¸���ϵͳ ���� 0:�ر� 1:�� */
	private boolean downAssistSet2;
	/*** �µ��𲽸��� ���� 0:�ر� 1:�� */
	private boolean rampStartSet2;
	/*** ͣ������ ���� 0:�ر� 1:�� */
	private boolean stopAssistSet2;
	
	// PSA�˶�ģʽ
	/*** ��������ͣ ͣ�ù���ʹ��*/
	private boolean engineUsePermit;
	/*** ��������ͣ���� ͣ���趨*/
	private boolean engineUseSet;
	
	// ͨ���˶�ģʽ  ���
	/*** ������״̬  1��Ч 0��Ч*/
	private boolean engineSportPermit;
	/*** �����趨  1��Ч 0��Ч*/
	private boolean backLightPermit;
	// ͨ���˶�ģʽ  ����
	/*** ������״̬  1�˶�ģʽ  0����ģʽ*/
	private boolean engineSportSet;
	/*** �����趨  1�� 0��*/
	private boolean backLightSet;
	
	public boolean isEngineSportPermit() {
		return engineSportPermit;
	}

	public void setEngineSportPermit(boolean engineSportPermit) {
		this.engineSportPermit = engineSportPermit;
	}

	public boolean isBackLightPermit() {
		return backLightPermit;
	}

	public void setBackLightPermit(boolean backLightPermit) {
		this.backLightPermit = backLightPermit;
	}

	public boolean isEngineSportSet() {
		return engineSportSet;
	}

	public void setEngineSportSet(boolean engineSportSet) {
		this.engineSportSet = engineSportSet;
	}

	public boolean isBackLightSet() {
		return backLightSet;
	}

	public void setBackLightSet(boolean backLightSet) {
		this.backLightSet = backLightSet;
	}

	public boolean isEngineUsePermit() {
		return engineUsePermit;
	}

	public void setEngineUsePermit(boolean engineUsePermit) {
		this.engineUsePermit = engineUsePermit;
	}

	public boolean isEngineUseSet() {
		return engineUseSet;
	}

	public void setEngineUseSet(boolean engineUseSet) {
		this.engineUseSet = engineUseSet;
	}

	public boolean isEscSystemPermit() {
		return EscSystemPermit;
	}

	public void setEscSystemPermit(boolean escSystemPermit) {
		EscSystemPermit = escSystemPermit;
	}

	public boolean isComfortPermit() {
		return comfortPermit;
	}

	public void setComfortPermit(boolean comfortPermit) {
		this.comfortPermit = comfortPermit;
	}

	public boolean isNormalPermit() {
		return normalPermit;
	}

	public void setNormalPermit(boolean normalPermit) {
		this.normalPermit = normalPermit;
	}

	public boolean isSportPermit() {
		return sportPermit;
	}

	public void setSportPermit(boolean sportPermit) {
		this.sportPermit = sportPermit;
	}

	public boolean isEcoPermit() {
		return ecoPermit;
	}

	public void setEcoPermit(boolean ecoPermit) {
		this.ecoPermit = ecoPermit;
	}

	public boolean isIndivdualPermit() {
		return indivdualPermit;
	}

	public void setIndivdualPermit(boolean indivdualPermit) {
		this.indivdualPermit = indivdualPermit;
	}

	public boolean isSnowPermit() {
		return snowPermit;
	}

	public void setSnowPermit(boolean snowPermit) {
		this.snowPermit = snowPermit;
	}

	public boolean isCrossPermit() {
		return crossPermit;
	}

	public void setCrossPermit(boolean crossPermit) {
		this.crossPermit = crossPermit;
	}

	public boolean isCrossIndivPermit() {
		return crossIndivPermit;
	}

	public void setCrossIndivPermit(boolean crossIndivPermit) {
		this.crossIndivPermit = crossIndivPermit;
	}

	public byte getEscSystemSet() {
		return EscSystemSet;
	}

	public void setEscSystemSet(byte escSystemSet) {
		EscSystemSet = escSystemSet;
	}

	public boolean isComfortSet() {
		return comfortSet;
	}

	public void setComfortSet(boolean comfortSet) {
		this.comfortSet = comfortSet;
	}

	public boolean isNormalSet() {
		return normalSet;
	}

	public void setNormalSet(boolean normalSet) {
		this.normalSet = normalSet;
	}

	public boolean isSportSet() {
		return sportSet;
	}

	public void setSportSet(boolean sportSet) {
		this.sportSet = sportSet;
	}

	public boolean isEcoSet() {
		return ecoSet;
	}

	public void setEcoSet(boolean ecoSet) {
		this.ecoSet = ecoSet;
	}

	public boolean isIndivdualSet() {
		return indivdualSet;
	}

	public void setIndivdualSet(boolean indivdualSet) {
		this.indivdualSet = indivdualSet;
	}

	public boolean isSnowSet() {
		return snowSet;
	}

	public void setSnowSet(boolean snowSet) {
		this.snowSet = snowSet;
	}

	public boolean isCrossSet() {
		return crossSet;
	}

	public void setCrossSet(boolean crossSet) {
		this.crossSet = crossSet;
	}

	public boolean isCrossIndivSet() {
		return crossIndivSet;
	}

	public void setCrossIndivSet(boolean crossIndivSet) {
		this.crossIndivSet = crossIndivSet;
	}

	public byte getDccSet() {
		return DccSet;
	}

	public void setDccSet(byte dccSet) {
		DccSet = dccSet;
	}

	public byte getBendLightSet() {
		return bendLightSet;
	}

	public void setBendLightSet(byte bendLightSet) {
		this.bendLightSet = bendLightSet;
	}

	public byte getEngineSet() {
		return engineSet;
	}

	public void setEngineSet(byte engineSet) {
		this.engineSet = engineSet;
	}

	public byte getAccAdaptionSet() {
		return accAdaptionSet;
	}

	public void setAccAdaptionSet(byte accAdaptionSet) {
		this.accAdaptionSet = accAdaptionSet;
	}

	public byte getAirConditionSet() {
		return airConditionSet;
	}

	public void setAirConditionSet(byte airConditionSet) {
		this.airConditionSet = airConditionSet;
	}

	public byte getSteeringSet() {
		return steeringSet;
	}

	public void setSteeringSet(byte steeringSet) {
		this.steeringSet = steeringSet;
	}

	public boolean isInMenuSet2() {
		return inMenuSet2;
	}

	public void setInMenuSet2(boolean inMenuSet2) {
		this.inMenuSet2 = inMenuSet2;
	}

	public byte getBendLightSet2() {
		return bendLightSet2;
	}

	public void setBendLightSet2(byte bendLightSet2) {
		this.bendLightSet2 = bendLightSet2;
	}

	public byte getEngineSet2() {
		return engineSet2;
	}

	public void setEngineSet2(byte engineSet2) {
		this.engineSet2 = engineSet2;
	}

	public byte getAccAdaptionSet2() {
		return accAdaptionSet2;
	}

	public void setAccAdaptionSet2(byte accAdaptionSet2) {
		this.accAdaptionSet2 = accAdaptionSet2;
	}

	public byte getAirConditionSet2() {
		return airConditionSet2;
	}

	public void setAirConditionSet2(byte airConditionSet2) {
		this.airConditionSet2 = airConditionSet2;
	}

	public byte getSteeringSet2() {
		return steeringSet2;
	}

	public void setSteeringSet2(byte steeringSet2) {
		this.steeringSet2 = steeringSet2;
	}

	public byte getFourDriveSet2() {
		return fourDriveSet2;
	}

	public void setFourDriveSet2(byte fourDriveSet2) {
		this.fourDriveSet2 = fourDriveSet2;
	}

	public boolean isDownAssistSet2() {
		return downAssistSet2;
	}

	public void setDownAssistSet2(boolean downAssistSet2) {
		this.downAssistSet2 = downAssistSet2;
	}

	public boolean isRampStartSet2() {
		return rampStartSet2;
	}

	public void setRampStartSet2(boolean rampStartSet2) {
		this.rampStartSet2 = rampStartSet2;
	}

	public boolean isStopAssistSet2() {
		return stopAssistSet2;
	}

	public void setStopAssistSet2(boolean stopAssistSet2) {
		this.stopAssistSet2 = stopAssistSet2;
	}

	public byte getID() {
		return Constant.ID_DRIVE_MODE;
	};

}
