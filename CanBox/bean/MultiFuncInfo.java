package com.landsem.canbox.bean;


import com.landsem.canbox.Constant;
/***科迪亚克协议: 多功能显示 */
public class MultiFuncInfo extends BaseInfo{
	
	//多功能显示  许可
	/***当前消耗 许可  1:有效  0：无效*/
	private boolean currentConsumPermit;
	/***平均消耗  许可  1:有效  0：无效*/
	private boolean averageConsumPermit;
	/***舒适用电器消耗   许可  1:有效  0：无效*/
	private boolean convenConsumPermit;
	/***经济运行提示  许可  1:有效  0：无效*/
	private boolean ecoTipsPermit;
	/***行驶时间  许可  1:有效  0：无效*/
	private boolean travelTimePermit;
	/***行驶里程  许可  1:有效  0：无效*/
	private boolean travelDistancePermit;
	/***平均车速  许可  1:有效  0：无效*/
	private boolean averageSpeedPermit;
	/***数字式车速显示  许可  1:有效  0：无效*/
	private boolean digitalSpeedPermit;
	/***车速报警  许可  1:有效  0：无效*/
	private boolean speedWarnPermit;
	/***机油温度  许可  1:有效  0：无效*/
	private boolean oilTempPermit;
	
	//多功能显示  设置
	/***当前消耗 设置  1:开  0：关*/
	private boolean currentConsumSet;
	/***平均消耗  设置   1:开  0：关*/
	private boolean averageConsumSet;
	/***舒适用电器消耗    设置  1:开  0：关*/
	private boolean convenConsumSet;
	/***经济运行提示   设置  1:开  0：关*/
	private boolean ecoTipsSet;
	/***行驶时间   设置  1:开  0：关*/
	private boolean travelTimeSet;
	/***行驶里程   设置  1:开  0：关*/
	private boolean travelDistanceSet;
	/***平均车速   设置  1:开  0：关*/
	private boolean averageSpeedSet;
	/***数字式车速显示   设置  1:开  0：关*/
	private boolean digitalSpeedSet;
	/***车速报警   设置  1:开  0：关*/
	private boolean speedWarnSet;
	/***机油温度  设置  1:开  0：关*/
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
