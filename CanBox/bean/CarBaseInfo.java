package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;
/*** 车身基本信息 ， 现代面板信息，现代声音信息,车型信息 */
public class CarBaseInfo extends BaseInfo {

	/*** 信号有效信息描述 */
	/*** 蓝牙 */
	private boolean bluetooth;
	/*** 雷达信号 */
	private boolean radarValidity;
	/*** 钥匙 */
	private boolean keyInValidity;
	/*** 泊车 */
	private boolean PARK;
	/*** 倒车 */
	private boolean REV;
	/*** 灯光 */
	private boolean ILL;
	/*** 供电 */
	private boolean ACC;

	/*** 车速 Km/h */
	private int carSpeed = Constant.PROTOCAL_INVALID_VALUE;
	/*** 灯光 */
	private int lightValue = Constant.PROTOCAL_INVALID_VALUE;

	// 车型
	/*** 车型参数0 */
	private byte carTypePara0;
	/*** 车型参数1 */
	private byte carTypePara1;
	// 日产车型
	/*** 车型 1 中配带全景摄像头 0 中配不带全景 */
	private byte carTypeNissan;
	/*** 媒体源 */
	private byte mediaSource;
	// 丰田
	/*** 点火 */
	private boolean ignition;
	// 福特
	/** sync是否有信号 1 有 2 无 **/
	private boolean sync;
	/** key_in 是否有信号 1 有 2 无 **/
	private boolean keyIn;
	/** ILL值 **/
	private byte ILLValue;
	
	/*** 智能语音命令 */
	private byte speechOrder;
	/*** 智能语音高位数据 */
	private byte speechMSB;
	/*** 智能语音低位数据 */
	private byte speechLSB;
	/*** 语言设置 */
	private byte languageSet;
	/*** 提示信息  单位 0：华氏 1：摄氏 */
	private byte noticeUnit;
	// PSA
	/***屏状态 1 黑屏 2 亮屏*/
	private boolean screenBlack;
	// 通用
	/***安吉星 1 有  0 没有*/
	private boolean anJiXing;
	/***按键背光 0~100 100：开  0：关   other:ILL值*/
	private byte keyLight;
	/***显示亮度 0~100 100：开  0：关   other:ILL值*/
	private byte disLight;
	/*** 点火模式 */
	private byte ignitionMode;
	/*** 档位 */
	private byte gear;
	/*** 钥匙是否存在 1 存在 0 不存在 */
	private boolean keyExist;
	/*** 手刹是否拉起 */
	private boolean handBrakePulled;
	/*** 脚刹是否拉起 */
	private boolean footBrakePulled;
	// 面板
	/*** 面板旋钮种类 */
	private byte panelKnobType = 1;
	/*** 面板旋钮当前值 范围0-ff */
	private int panelKnobValue;
	/*** 步进值 */
	private byte offSet;
	/*** 面板选择*/
	private byte panelChoice;
	// 功放
	/*** 音量 */
	private byte soundValue;
	/*** 左右平衡 */
	private byte soundLRValue;
	/*** 前后平衡 */
	private byte soundFBValue;
	/*** 低音 */
	private byte soundLowValue;
	/*** 中音 */
	private byte soundMidValue;
	/*** 高音 */
	private byte soundHigValue;
	/*** 驾驶座音场状态 */
	private boolean soundField;
	/*** BOSE Centerpoint状态 */
	private boolean bosePoint;
	/*** 车速联动音量 */
	private byte linkageVolume;
	/*** 环绕音量 */
	private byte surroundVolume;
	/*** 静音 1:静音 2：非静音 */
	private boolean soundMute;

	
	public byte getPanelChoice() {
		return panelChoice;
	}

	public void setPanelChoice(byte panelChoice) {
		this.panelChoice = panelChoice;
	}

	public byte getIgnitionMode() {
		return ignitionMode;
	}

	public void setIgnitionMode(byte ignitionMode) {
		this.ignitionMode = ignitionMode;
	}

	public byte getGear() {
		return gear;
	}

	public void setGear(byte gear) {
		this.gear = gear;
	}

	public boolean isKeyExist() {
		return keyExist;
	}

	public void setKeyExist(boolean keyExist) {
		this.keyExist = keyExist;
	}

	public boolean isHandBrakePulled() {
		return handBrakePulled;
	}

	public void setHandBrakePulled(boolean handBrakePulled) {
		this.handBrakePulled = handBrakePulled;
	}

	public boolean isFootBrakePulled() {
		return footBrakePulled;
	}

	public void setFootBrakePulled(boolean footBrakePulled) {
		this.footBrakePulled = footBrakePulled;
	}
	
	public byte getOffSet() {
		return offSet;
	}

	public void setOffSet(byte offSet) {
		this.offSet = offSet;
	}
	public boolean isSoundField() {
		return soundField;
	}

	public void setSoundField(boolean soundField) {
		this.soundField = soundField;
	}

	public boolean isBosePoint() {
		return bosePoint;
	}

	public void setBosePoint(boolean bosePoint) {
		this.bosePoint = bosePoint;
	}

	public byte getLinkageVolume() {
		return linkageVolume;
	}

	public void setLinkageVolume(byte linkageVolume) {
		this.linkageVolume = linkageVolume;
	}

	public byte getSurroundVolume() {
		return surroundVolume;
	}

	public void setSurroundVolume(byte surroundVolume) {
		this.surroundVolume = surroundVolume;
	}
	public boolean isSoundMute() {
		return soundMute;
	}

	public void setSoundMute(boolean soundMute) {
		this.soundMute = soundMute;
	}
	
	public byte getPanelKnobType() {
		return panelKnobType;
	}

	public void setPanelKnobType(byte panelKnobType) {
		this.panelKnobType = panelKnobType;
	}

	public int getPanelKnobValue() {
		return panelKnobValue;
	}

	public void setPanelKnobValue(int panelKnobValue) {
		this.panelKnobValue = panelKnobValue;
	}

	public byte getSoundValue() {
		return soundValue;
	}

	public void setSoundValue(byte soundValue) {
		this.soundValue = soundValue;
	}

	public byte getSoundLRValue() {
		return soundLRValue;
	}

	public void setSoundLRValue(byte soundLRValue) {
		this.soundLRValue = soundLRValue;
	}

	public byte getSoundFBValue() {
		return soundFBValue;
	}

	public void setSoundFBValue(byte soundFBValue) {
		this.soundFBValue = soundFBValue;
	}

	public byte getSoundLowValue() {
		return soundLowValue;
	}

	public void setSoundLowValue(byte soundLowValue) {
		this.soundLowValue = soundLowValue;
	}

	public byte getSoundMidValue() {
		return soundMidValue;
	}

	public void setSoundMidValue(byte soundMidValue) {
		this.soundMidValue = soundMidValue;
	}

	public byte getSoundHigValue() {
		return soundHigValue;
	}

	public void setSoundHigValue(byte soundHigValue) {
		this.soundHigValue = soundHigValue;
	}
	
	public byte getID() {
		return Constant.ID_CARBASE;
	};

	public byte getKeyLight() {
		return keyLight;
	}

	public void setKeyLight(byte keyLight) {
		this.keyLight = keyLight;
	}

	public byte getDisLight() {
		return disLight;
	}

	public void setDisLight(byte disLight) {
		this.disLight = disLight;
	}

	public boolean isAnJiXing() {
		return anJiXing;
	}

	public void setAnJiXing(boolean anJiXing) {
		this.anJiXing = anJiXing;
	}

	public boolean isScreenBlack() {
		return screenBlack;
	}

	public void setScreenBlack(boolean screenBlack) {
		this.screenBlack = screenBlack;
	}

	public byte getNoticeUnit() {
		return noticeUnit;
	}

	public void setNoticeUnit(byte noticeUnit) {
		this.noticeUnit = noticeUnit;
	}

	public byte getLanguageSet() {
		return languageSet;
	}

	public void setLanguageSet(byte languageSet) {
		this.languageSet = languageSet;
	}

	public byte getSpeechOrder() {
		return speechOrder;
	}

	public void setSpeechOrder(byte speechOrder) {
		this.speechOrder = speechOrder;
	}

	public byte getSpeechMSB() {
		return speechMSB;
	}

	public void setSpeechMSB(byte speechMSB) {
		this.speechMSB = speechMSB;
	}

	public byte getSpeechLSB() {
		return speechLSB;
	}

	public void setSpeechLSB(byte speechLSB) {
		this.speechLSB = speechLSB;
	}

	

	public byte getILLValue() {
		return ILLValue;
	}

	public void setILLValue(byte iLLValue) {
		ILLValue = iLLValue;
	}

	public boolean isKeyIn() {
		return keyIn;
	}

	public void setKeyIn(boolean keyIn) {
		this.keyIn = keyIn;
	}

	public boolean isSync() {
		return sync;
	}

	public void setSync(boolean sync) {
		this.sync = sync;
	}

	public boolean isIgnition() {
		return ignition;
	}

	public void setIgnition(boolean ignition) {
		this.ignition = ignition;
	}

	public byte getMediaSource() {
		return mediaSource;
	}

	public void setMediaSource(byte mediaSource) {
		this.mediaSource = mediaSource;
	}

	public byte getCarTypeNissan() {
		return carTypeNissan;
	}

	public void setCarTypeNissan(byte carTypeNissan) {
		this.carTypeNissan = carTypeNissan;
	}

	public byte getCarTypePara0() {
		return carTypePara0;
	}

	public void setCarTypePara0(byte carTypePara0) {
		this.carTypePara0 = carTypePara0;
	}

	public byte getCarTypePara1() {
		return carTypePara1;
	}

	public void setCarTypePara1(byte carTypePara1) {
		this.carTypePara1 = carTypePara1;
	}

	public boolean isBluetooth() {
		return bluetooth;
	}

	public void setBluetooth(boolean bluetooth) {
		this.bluetooth = bluetooth;
	}

	public boolean isRadarValidity() {
		return radarValidity;
	}

	public void setRadarValidity(boolean radarValidity) {
		this.radarValidity = radarValidity;
	}

	public boolean isKeyInValidity() {
		return keyInValidity;
	}

	public void setKeyInValidity(boolean keyInValidity) {
		this.keyInValidity = keyInValidity;
	}

	public boolean isPARK() {
		return PARK;
	}

	public void setPARK(boolean pARK) {
		PARK = pARK;
	}

	public boolean isREV() {
		return REV;
	}

	public void setREV(boolean rEV) {
		REV = rEV;
	}

	public boolean isILL() {
		return ILL;
	}

	public void setILL(boolean iLL) {
		ILL = iLL;
	}

	public boolean isACC() {
		return ACC;
	}

	public void setACC(boolean aCC) {
		ACC = aCC;
	}

	public int getCarSpeed() {
		return carSpeed;
	}

	public void setCarSpeed(int carSpeed) {
		this.carSpeed = carSpeed;
	}

	public int getLightValue() {
		return lightValue;
	}

	public void setLightValue(int lightValue) {
		this.lightValue = lightValue;
	}

}
