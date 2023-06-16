package com.landsem.canbox.bean;


import com.landsem.canbox.Constant;
/***�Ƶ��ǿ�Э��: �๦����ʾ */
public class MultiFuncInfo extends BaseInfo{
	
	//�๦����ʾ  ���
	/***��ǰ���� ���  1:��Ч  0����Ч*/
	private boolean currentConsumPermit;
	/***ƽ������  ���  1:��Ч  0����Ч*/
	private boolean averageConsumPermit;
	/***�����õ�������   ���  1:��Ч  0����Ч*/
	private boolean convenConsumPermit;
	/***����������ʾ  ���  1:��Ч  0����Ч*/
	private boolean ecoTipsPermit;
	/***��ʻʱ��  ���  1:��Ч  0����Ч*/
	private boolean travelTimePermit;
	/***��ʻ���  ���  1:��Ч  0����Ч*/
	private boolean travelDistancePermit;
	/***ƽ������  ���  1:��Ч  0����Ч*/
	private boolean averageSpeedPermit;
	/***����ʽ������ʾ  ���  1:��Ч  0����Ч*/
	private boolean digitalSpeedPermit;
	/***���ٱ���  ���  1:��Ч  0����Ч*/
	private boolean speedWarnPermit;
	/***�����¶�  ���  1:��Ч  0����Ч*/
	private boolean oilTempPermit;
	
	//�๦����ʾ  ����
	/***��ǰ���� ����  1:��  0����*/
	private boolean currentConsumSet;
	/***ƽ������  ����   1:��  0����*/
	private boolean averageConsumSet;
	/***�����õ�������    ����  1:��  0����*/
	private boolean convenConsumSet;
	/***����������ʾ   ����  1:��  0����*/
	private boolean ecoTipsSet;
	/***��ʻʱ��   ����  1:��  0����*/
	private boolean travelTimeSet;
	/***��ʻ���   ����  1:��  0����*/
	private boolean travelDistanceSet;
	/***ƽ������   ����  1:��  0����*/
	private boolean averageSpeedSet;
	/***����ʽ������ʾ   ����  1:��  0����*/
	private boolean digitalSpeedSet;
	/***���ٱ���   ����  1:��  0����*/
	private boolean speedWarnSet;
	/***�����¶�  ����  1:��  0����*/
	private boolean oilTempSet;
	
	public byte getID(){
		return Constant.ID_MULTI_FUNC;
	}

	public boolean isCurrentConsumPermit() {
		return currentConsumPermit;
	}

	public void setCurrentConsumPermit(boolean currentConsumPermit) {
		this.currentConsumPermit = currentConsumPermit;
	}

	public boolean isAverageConsumPermit() {
		return averageConsumPermit;
	}

	public void setAverageConsumPermit(boolean averageConsumPermit) {
		this.averageConsumPermit = averageConsumPermit;
	}

	public boolean isConvenConsumPermit() {
		return convenConsumPermit;
	}

	public void setConvenConsumPermit(boolean convenConsumPermit) {
		this.convenConsumPermit = convenConsumPermit;
	}

	public boolean isEcoTipsPermit() {
		return ecoTipsPermit;
	}

	public void setEcoTipsPermit(boolean ecoTipsPermit) {
		this.ecoTipsPermit = ecoTipsPermit;
	}

	public boolean isTravelTimePermit() {
		return travelTimePermit;
	}

	public void setTravelTimePermit(boolean travelTimePermit) {
		this.travelTimePermit = travelTimePermit;
	}

	public boolean isTravelDistancePermit() {
		return travelDistancePermit;
	}

	public void setTravelDistancePermit(boolean travelDistancePermit) {
		this.travelDistancePermit = travelDistancePermit;
	}

	public boolean isAverageSpeedPermit() {
		return averageSpeedPermit;
	}

	public void setAverageSpeedPermit(boolean averageSpeedPermit) {
		this.averageSpeedPermit = averageSpeedPermit;
	}

	public boolean isDigitalSpeedPermit() {
		return digitalSpeedPermit;
	}

	public void setDigitalSpeedPermit(boolean digitalSpeedPermit) {
		this.digitalSpeedPermit = digitalSpeedPermit;
	}

	public boolean isSpeedWarnPermit() {
		return speedWarnPermit;
	}

	public void setSpeedWarnPermit(boolean speedWarnPermit) {
		this.speedWarnPermit = speedWarnPermit;
	}

	public boolean isOilTempPermit() {
		return oilTempPermit;
	}

	public void setOilTempPermit(boolean oilTempPermit) {
		this.oilTempPermit = oilTempPermit;
	}

	public boolean isCurrentConsumSet() {
		return currentConsumSet;
	}

	public void setCurrentConsumSet(boolean currentConsumSet) {
		this.currentConsumSet = currentConsumSet;
	}

	public boolean isAverageConsumSet() {
		return averageConsumSet;
	}

	public void setAverageConsumSet(boolean averageConsumSet) {
		this.averageConsumSet = averageConsumSet;
	}

	public boolean isConvenConsumSet() {
		return convenConsumSet;
	}

	public void setConvenConsumSet(boolean convenConsumSet) {
		this.convenConsumSet = convenConsumSet;
	}

	public boolean isEcoTipsSet() {
		return ecoTipsSet;
	}

	public void setEcoTipsSet(boolean ecoTipsSet) {
		this.ecoTipsSet = ecoTipsSet;
	}

	public boolean isTravelTimeSet() {
		return travelTimeSet;
	}

	public void setTravelTimeSet(boolean travelTimeSet) {
		this.travelTimeSet = travelTimeSet;
	}

	public boolean isTravelDistanceSet() {
		return travelDistanceSet;
	}

	public void setTravelDistanceSet(boolean travelDistanceSet) {
		this.travelDistanceSet = travelDistanceSet;
	}

	public boolean isAverageSpeedSet() {
		return averageSpeedSet;
	}

	public void setAverageSpeedSet(boolean averageSpeedSet) {
		this.averageSpeedSet = averageSpeedSet;
	}

	public boolean isDigitalSpeedSet() {
		return digitalSpeedSet;
	}

	public void setDigitalSpeedSet(boolean digitalSpeedSet) {
		this.digitalSpeedSet = digitalSpeedSet;
	}

	public boolean isSpeedWarnSet() {
		return speedWarnSet;
	}

	public void setSpeedWarnSet(boolean speedWarnSet) {
		this.speedWarnSet = speedWarnSet;
	}

	public boolean isOilTempSet() {
		return oilTempSet;
	}

	public void setOilTempSet(boolean oilTempSet) {
		this.oilTempSet = oilTempSet;
	};

	
}
