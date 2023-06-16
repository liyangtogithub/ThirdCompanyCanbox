package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/**
 * ͨ�ã�������
 */
public class AnJiXingInfo extends BaseInfo{
	//��Ϣ
	/*** ������״̬  0�ر� 1������  2ȥ����  3�Ѿ�����  4����*/
	private byte anState;
	/*** ������ͨ������  0��ͨͨ�� 1��ײͨ��  2����ͨ�� 3·��Э�� */
	private byte anCallMode;
	/*** �绰���� 1����  0����*/
	private boolean anCallMute;
	//ͨ��
	/***ͨ��ʱ��   Сʱ 0-ff*/
	private int anCallH;
	/***ͨ��ʱ��   ���� 0-59*/
	private byte anCallM;
	/***ͨ��ʱ��   ��     0-59*/
	private byte anCallS;
	/***������ʣ��ʱ��      0-ff*/
	private int anSurplus;
	/***��������Ч��     ��   0-ff*/
	private int anValidY;
	/***��������Ч��     ��   0-ff*/
	private int anValidM;
	/***��������Ч��     ��   0-ff*/
	private int anValidD;
	
	//�����Ǿ���
	/***������Ϣ״̬  1����  0��*/
	private boolean anWarnEnable;
	/***������Ϣ����  0 Disaster  1 Amber  2 Traffic 3 Weather 4 Generic 5 Campaign 6 Reminder*/
	private String anWarnMode;
	//�����ǽ��պ���
	/***���պ���  */
	private String anRecNum;
	//����
	/***�����������*/
	private String anBlueWord;
	/***�����绰����*/
	private String anBlueName;
	
	public byte getID(){
		return Constant.ID_ANJIXING;
	}

	public byte getAnState() {
		return anState;
	}

	public void setAnState(byte anState) {
		this.anState = anState;
	}

	public byte getAnCallMode() {
		return anCallMode;
	}

	public void setAnCallMode(byte anCallMode) {
		this.anCallMode = anCallMode;
	}

	public boolean isAnCallMute() {
		return anCallMute;
	}

	public void setAnCallMute(boolean anCallMute) {
		this.anCallMute = anCallMute;
	}

	public int getAnCallH() {
		return anCallH;
	}

	public void setAnCallH(int anCallH) {
		this.anCallH = anCallH;
	}

	public byte getAnCallM() {
		return anCallM;
	}

	public void setAnCallM(byte anCallM) {
		this.anCallM = anCallM;
	}

	public byte getAnCallS() {
		return anCallS;
	}

	public void setAnCallS(byte anCallS) {
		this.anCallS = anCallS;
	}

	public int getAnSurplus() {
		return anSurplus;
	}

	public void setAnSurplus(int anSurplus) {
		this.anSurplus = anSurplus;
	}

	public int getAnValidY() {
		return anValidY;
	}

	public void setAnValidY(int anValidY) {
		this.anValidY = anValidY;
	}

	public int getAnValidM() {
		return anValidM;
	}

	public void setAnValidM(int anValidM) {
		this.anValidM = anValidM;
	}

	public int getAnValidD() {
		return anValidD;
	}

	public void setAnValidD(int anValidD) {
		this.anValidD = anValidD;
	}

	public boolean isAnWarnEnable() {
		return anWarnEnable;
	}

	public void setAnWarnEnable(boolean anWarnEnable) {
		this.anWarnEnable = anWarnEnable;
	}

	public String getAnWarnMode() {
		return anWarnMode;
	}

	public void setAnWarnMode(String anWarnMode) {
		this.anWarnMode = anWarnMode;
	}

	public String getAnRecNum() {
		return anRecNum;
	}

	public void setAnRecNum(String anRecNum) {
		this.anRecNum = anRecNum;
	}

	public String getAnBlueWord() {
		return anBlueWord;
	}

	public void setAnBlueWord(String anBlueWord) {
		this.anBlueWord = anBlueWord;
	}

	public String getAnBlueName() {
		return anBlueName;
	}

	public void setAnBlueName(String anBlueName) {
		this.anBlueName = anBlueName;
	};
	
	
}
