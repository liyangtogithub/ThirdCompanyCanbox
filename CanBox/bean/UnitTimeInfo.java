package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;
/***   ʱ��  ��λ */
public class UnitTimeInfo extends BaseInfo{
	
	//�Ŵ�����  ���
	/***����  ���  1:��Ч  0����Ч*/
	private boolean distancePermit;
	/***�ٶ� ���  1:��Ч  0����Ч*/
	private boolean speedPermit;
	/***�¶�  ���  1:��Ч  0����Ч*/
	private boolean tempPermit;
	/***�ݻ� ���  1:��Ч  0����Ч*/
	private boolean volumePermit;
	/***�ͺ�   ���  1:��Ч  0����Ч*/
	private boolean consumPermit;
	/***��̥ѹ��   ���  1:��Ч  0����Ч*/
	private boolean pressurePermit;
	//  ����
	/***���� ����  1:km  0��m  */
	private byte distanceSet;
	/***�ٶ�  ����  1:km/h  0��m/h*/
	private byte speedSet;
	/***�¶�  ����  1:���϶�  0�����϶�*/
	private byte tempSet;
	/***�ݻ�  ����  00:��  01����������  10��Ӣ������*/
	private byte volumeSet;
	/***�ͺ�  ����  00:l/100km 01��km/l 10��mpg(us) 11��mpg(uk)*/
	private byte consumSet;
	/***��̥ѹ��  ����  00:kPa 01��bar  10��psi*/
	private byte pressureSet;
	//ʱ��
	/***ʱ��Դ  ����   1:�ֶ�  0��gps */
	private byte timeSourceSet;
	/***Сʱ  ����   0-59  0xff:null */
	private byte hourSet;
	/***����  ����   0-59  0xff:null */
	private byte minuteSet;
	/***auto summer time  ���  1:��  0����*/
	private boolean autoSummerPermit;
	/***ʱ���ʽ  ����  1:24h  0��12h  */
	private byte timeFormatSet;
	/***��  ����  20xx�꣬xx��Χ00-99  */
	private byte yearSet;
	/***��  ���� 1-12  */
	private byte monthSet;
	/***��  ���� 1-31  */
	private byte daySet;
	/***���ڸ�ʽ  ���� 1:DD MM YYYY  2:YYYY MM DD 3:MM DD YYYY*/
	private byte dateFormatSet;
	
	
	public byte getID(){
		return Constant.ID_UNIT_TIME;
	}


	public byte getTimeSourceSet() {
		return timeSourceSet;
	}


	public void setTimeSourceSet(byte timeSourceSet) {
		this.timeSourceSet = timeSourceSet;
	}


	public byte getHourSet() {
		return hourSet;
	}


	public void setHourSet(byte hourSet) {
		this.hourSet = hourSet;
	}


	public byte getMinuteSet() {
		return minuteSet;
	}


	public void setMinuteSet(byte minuteSet) {
		this.minuteSet = minuteSet;
	}


	public boolean isAutoSummerPermit() {
		return autoSummerPermit;
	}


	public void setAutoSummerPermit(boolean autoSummerPermit) {
		this.autoSummerPermit = autoSummerPermit;
	}


	public byte getTimeFormatSet() {
		return timeFormatSet;
	}


	public void setTimeFormatSet(byte timeFormatSet) {
		this.timeFormatSet = timeFormatSet;
	}


	public byte getYearSet() {
		return yearSet;
	}


	public void setYearSet(byte yearSet) {
		this.yearSet = yearSet;
	}


	public byte getMonthSet() {
		return monthSet;
	}


	public void setMonthSet(byte monthSet) {
		this.monthSet = monthSet;
	}


	public byte getDaySet() {
		return daySet;
	}


	public void setDaySet(byte daySet) {
		this.daySet = daySet;
	}


	public byte getDateFormatSet() {
		return dateFormatSet;
	}


	public void setDateFormatSet(byte dateFormatSet) {
		this.dateFormatSet = dateFormatSet;
	}


	public boolean isDistancePermit() {
		return distancePermit;
	}


	public void setDistancePermit(boolean distancePermit) {
		this.distancePermit = distancePermit;
	}


	public boolean isSpeedPermit() {
		return speedPermit;
	}


	public void setSpeedPermit(boolean speedPermit) {
		this.speedPermit = speedPermit;
	}


	public boolean isTempPermit() {
		return tempPermit;
	}


	public void setTempPermit(boolean tempPermit) {
		this.tempPermit = tempPermit;
	}


	public boolean isVolumePermit() {
		return volumePermit;
	}


	public void setVolumePermit(boolean volumePermit) {
		this.volumePermit = volumePermit;
	}


	public boolean isConsumPermit() {
		return consumPermit;
	}


	public void setConsumPermit(boolean consumPermit) {
		this.consumPermit = consumPermit;
	}


	public boolean isPressurePermit() {
		return pressurePermit;
	}


	public void setPressurePermit(boolean pressurePermit) {
		this.pressurePermit = pressurePermit;
	}


	public byte getDistanceSet() {
		return distanceSet;
	}


	public void setDistanceSet(byte distanceSet) {
		this.distanceSet = distanceSet;
	}


	public byte getSpeedSet() {
		return speedSet;
	}


	public void setSpeedSet(byte speedSet) {
		this.speedSet = speedSet;
	}


	public byte getTempSet() {
		return tempSet;
	}


	public void setTempSet(byte tempSet) {
		this.tempSet = tempSet;
	}


	public byte getVolumeSet() {
		return volumeSet;
	}


	public void setVolumeSet(byte volumeSet) {
		this.volumeSet = volumeSet;
	}


	public byte getConsumSet() {
		return consumSet;
	}


	public void setConsumSet(byte consumSet) {
		this.consumSet = consumSet;
	}


	public byte getPressureSet() {
		return pressureSet;
	}


	public void setPressureSet(byte pressureSet) {
		this.pressureSet = pressureSet;
	};
	
	

}
