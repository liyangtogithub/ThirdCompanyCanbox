package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/*** 科迪亚克协议: 驾驶模式，运动模式 */
public class DriveModeInfo extends BaseInfo {

	// 运动模式 许可
	/*** 运动模式使能 许可 1:有效 0：无效 */
	private boolean EscSystemPermit;
	// 运动模式 设置
	/*** 运动模式使能 许可 0:ASR关闭 1：已激活 2：ESC运动模式 */
	private byte EscSystemSet;
	// 驾驶模式 许可
	/*** 舒适 许可 1:有效 0：无效 */
	private boolean comfortPermit;
	/*** 标准 许可 1:有效 0：无效 */
	private boolean normalPermit;
	/*** 运动 许可 1:有效 0：无效 */
	private boolean sportPermit;
	/*** 经济 许可 1:有效 0：无效 */
	private boolean ecoPermit;
	/*** 个性化 许可 1:有效 0：无效 */
	private boolean indivdualPermit;
	/*** 雪地许可 1:有效 0：无效 */
	private boolean snowPermit;
	/*** 越野许可 1:有效 0：无效 */
	private boolean crossPermit;
	/*** 越野个性化 许可 1:有效 0：无效 */
	private boolean crossIndivPermit;
	// 驾驶模式 设置
	/*** 舒适 设置 1:开 0：关 */
	private boolean comfortSet;
	/*** 标准 设置 1:开 0：关 */
	private boolean normalSet;
	/*** 运动 设置 1:开 0：关 */
	private boolean sportSet;
	/*** 经济 设置 1:开 0：关 */
	private boolean ecoSet;
	/*** 个性化 设置 1:开 0：关 */
	private boolean indivdualSet;
	/*** 雪地许可 设置 1:开 0：关 */
	private boolean snowSet;
	/*** 越野许可 设置 1:开 0：关 */
	private boolean crossSet;
	/*** 越野个性化 设置 1:开 0：关 */
	private boolean crossIndivSet;
	// 个性化 设置
	/*** DCC 设置 00:comfort 01:normal 10:sport */
	private byte DccSet;
	/*** 动态大灯随动 设置 00:normal 01:sport 10:eco */
	private byte bendLightSet;
	/*** 发动机 设置 00:normal 01:sport 10:eco */
	private byte engineSet;
	/*** ACC自适应巡航 设置 00:normal 01:sport 10:eco */
	private byte accAdaptionSet;
	/*** 空调 设置 1:normal 0:eco */
	private byte airConditionSet;
	/*** 方向盘转向系统 设置 1:normal 0:eco */
	private byte steeringSet;
	// 驾驶模式2 设置
	/*** 进入菜单 设置 1:进入 0：无 */
	private boolean inMenuSet2;
	// 驾驶模式2 个性化 设置
	/*** 动态大灯随动 设置 00:标准 01:运动 10:经济 */
	private byte bendLightSet2;
	/*** 发动机驱动装置 设置 00:标准 01:越野 */
	private byte engineSet2;
	/*** ACC自适应巡航 设置 00:标准 01:运动 10:经济 */
	private byte accAdaptionSet2;
	/*** 空调 设置 0:经济 1:标准 */
	private byte airConditionSet2;
	/*** 方向盘转向系统 设置 1:标准 0:运动 */
	private byte steeringSet2;
	/*** 四轮驱动 设置 0:标准 1:越野 */
	private byte fourDriveSet2;
	/*** 下坡辅助系统 设置 0:关闭 1:打开 */
	private boolean downAssistSet2;
	/*** 坡道起步辅助 设置 0:关闭 1:打开 */
	private boolean rampStartSet2;
	/*** 停车辅助 设置 0:关闭 1:打开 */
	private boolean stopAssistSet2;
	
	// PSA运动模式
	/*** 发动机启停 停用功能使能*/
	private boolean engineUsePermit;
	/*** 发动机启停功能 停用设定*/
	private boolean engineUseSet;
	
	// 通用运动模式  许可
	/*** 发动机状态  1有效 0无效*/
	private boolean engineSportPermit;
	/*** 背光设定  1有效 0无效*/
	private boolean backLightPermit;
	// 通用运动模式  设置
	/*** 发动机状态  1运动模式  0正常模式*/
	private boolean engineSportSet;
	/*** 背光设定  1开 0关*/
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
