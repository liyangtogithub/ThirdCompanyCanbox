package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/**
 * 通用：安吉星
 */
public class AnJiXingInfo extends BaseInfo{
	//信息
	/*** 安吉星状态  0关闭 1来电中  2去电中  3已经连接  4空闲*/
	private byte anState;
	/*** 安吉星通话类型  0普通通话 1碰撞通话  2紧急通话 3路旁协助 */
	private byte anCallMode;
	/*** 电话静音 1静音  0正常*/
	private boolean anCallMute;
	//通话
	/***通话时间   小时 0-ff*/
	private int anCallH;
	/***通话时间   分钟 0-59*/
	private byte anCallM;
	/***通话时间   秒     0-59*/
	private byte anCallS;
	/***安吉星剩余时间      0-ff*/
	private int anSurplus;
	/***安吉星有效期     年   0-ff*/
	private int anValidY;
	/***安吉星有效期     月   0-ff*/
	private int anValidM;
	/***安吉星有效期     日   0-ff*/
	private int anValidD;
	
	//安吉星警告
	/***警告信息状态  1激活  0关*/
	private boolean anWarnEnable;
	/***警告信息类型  0 Disaster  1 Amber  2 Traffic 3 Weather 4 Generic 5 Campaign 6 Reminder*/
	private String anWarnMode;
	//安吉星接收号码
	/***接收号码  */
	private String anRecNum;
	//蓝牙
	/***蓝牙配对密码*/
	private String anBlueWord;
	/***蓝牙电话名称*/
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
