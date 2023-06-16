package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;
/*** ���������Ϣ �� �ִ������Ϣ���ִ�������Ϣ,������Ϣ */
public class CarBaseInfo extends BaseInfo {

	/*** �ź���Ч��Ϣ���� */
	/*** ���� */
	private boolean bluetooth;
	/*** �״��ź� */
	private boolean radarValidity;
	/*** Կ�� */
	private boolean keyInValidity;
	/*** ���� */
	private boolean PARK;
	/*** ���� */
	private boolean REV;
	/*** �ƹ� */
	private boolean ILL;
	/*** ���� */
	private boolean ACC;

	/*** ���� Km/h */
	private int carSpeed = Constant.PROTOCAL_INVALID_VALUE;
	/*** �ƹ� */
	private int lightValue = Constant.PROTOCAL_INVALID_VALUE;

	// ����
	/*** ���Ͳ���0 */
	private byte carTypePara0;
	/*** ���Ͳ���1 */
	private byte carTypePara1;
	// �ղ�����
	/*** ���� 1 �����ȫ������ͷ 0 ���䲻��ȫ�� */
	private byte carTypeNissan;
	/*** ý��Դ */
	private byte mediaSource;
	// ����
	/*** ��� */
	private boolean ignition;
	// ����
	/** sync�Ƿ����ź� 1 �� 2 �� **/
	private boolean sync;
	/** key_in �Ƿ����ź� 1 �� 2 �� **/
	private boolean keyIn;
	/** ILLֵ **/
	private byte ILLValue;
	
	/*** ������������ */
	private byte speechOrder;
	/*** ����������λ���� */
	private byte speechMSB;
	/*** ����������λ���� */
	private byte speechLSB;
	/*** �������� */
	private byte languageSet;
	/*** ��ʾ��Ϣ  ��λ 0������ 1������ */
	private byte noticeUnit;
	// PSA
	/***��״̬ 1 ���� 2 ����*/
	private boolean screenBlack;
	// ͨ��
	/***������ 1 ��  0 û��*/
	private boolean anJiXing;
	/***�������� 0~100 100����  0����   other:ILLֵ*/
	private byte keyLight;
	/***��ʾ���� 0~100 100����  0����   other:ILLֵ*/
	private byte disLight;
	/*** ���ģʽ */
	private byte ignitionMode;
	/*** ��λ */
	private byte gear;
	/*** Կ���Ƿ���� 1 ���� 0 ������ */
	private boolean keyExist;
	/*** ��ɲ�Ƿ����� */
	private boolean handBrakePulled;
	/*** ��ɲ�Ƿ����� */
	private boolean footBrakePulled;
	// ���
	/*** �����ť���� */
	private byte panelKnobType = 1;
	/*** �����ť��ǰֵ ��Χ0-ff */
	private int panelKnobValue;
	/*** ����ֵ */
	private byte offSet;
	/*** ���ѡ��*/
	private byte panelChoice;
	// ����
	/*** ���� */
	private byte soundValue;
	/*** ����ƽ�� */
	private byte soundLRValue;
	/*** ǰ��ƽ�� */
	private byte soundFBValue;
	/*** ���� */
	private byte soundLowValue;
	/*** ���� */
	private byte soundMidValue;
	/*** ���� */
	private byte soundHigValue;
	/*** ��ʻ������״̬ */
	private boolean soundField;
	/*** BOSE Centerpoint״̬ */
	private boolean bosePoint;
	/*** ������������ */
	private byte linkageVolume;
	/*** �������� */
	private byte surroundVolume;
	/*** ���� 1:���� 2���Ǿ��� */
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
