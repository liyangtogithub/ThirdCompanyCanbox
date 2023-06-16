package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;
/***   时间  单位 */
public class UnitTimeInfo extends BaseInfo{
	
	//门窗开关  许可
	/***距离  许可  1:有效  0：无效*/
	private boolean distancePermit;
	/***速度 许可  1:有效  0：无效*/
	private boolean speedPermit;
	/***温度  许可  1:有效  0：无效*/
	private boolean tempPermit;
	/***容积 许可  1:有效  0：无效*/
	private boolean volumePermit;
	/***油耗   许可  1:有效  0：无效*/
	private boolean consumPermit;
	/***轮胎压力   许可  1:有效  0：无效*/
	private boolean pressurePermit;
	//  设置
	/***距离 设置  1:km  0：m  */
	private byte distanceSet;
	/***速度  设置  1:km/h  0：m/h*/
	private byte speedSet;
	/***温度  设置  1:摄氏度  0：华氏度*/
	private byte tempSet;
	/***容积  设置  00:升  01：美国加仑  10：英国加仑*/
	private byte volumeSet;
	/***油耗  设置  00:l/100km 01：km/l 10：mpg(us) 11：mpg(uk)*/
	private byte consumSet;
	/***轮胎压力  设置  00:kPa 01：bar  10：psi*/
	private byte pressureSet;
	//时间
	/***时间源  设置   1:手动  0：gps */
	private byte timeSourceSet;
	/***小时  设置   0-59  0xff:null */
	private byte hourSet;
	/***分钟  设置   0-59  0xff:null */
	private byte minuteSet;
	/***auto summer time  许可  1:开  0：关*/
	private boolean autoSummerPermit;
	/***时间格式  设置  1:24h  0：12h  */
	private byte timeFormatSet;
	/***年  设置  20xx年，xx范围00-99  */
	private byte yearSet;
	/***月  设置 1-12  */
	private byte monthSet;
	/***日  设置 1-31  */
	private byte daySet;
	/***日期格式  设置 1:DD MM YYYY  2:YYYY MM DD 3:MM DD YYYY*/
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
