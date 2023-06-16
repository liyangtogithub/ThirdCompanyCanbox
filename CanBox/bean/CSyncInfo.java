package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/*** SYNC */
public class CSyncInfo extends BaseInfo {

	// 显示信息
	/*** 屏号 */
	private byte screenNum;
	/*** 行号 */
	private byte rowNum;
	/*** 组号 */
	private byte groupNum;
	/*** 屏图标1 */
	private String screenIcon1;
	/*** 屏图标2 */
	private String screenIcon2;
	/*** 屏图标3 */
	private String screenIcon3;
	/*** 屏图标4 */
	private String screenIcon4;
	/*** 屏图标5 */
	private String screenIcon5;
	/*** 屏图标6 */
	private String screenIcon6;
	/*** 第一行图标1 */
	private String row11;
	/*** 第一行图标2 */
	private String row12;
	/*** 第二行图标1 */
	private String row21;
	/*** 第二行图标2 */
	private String row22;
	/*** 第三行图标1 */
	private String row31;
	/*** 第三行图标2 */
	private String row32;
	/*** 第四行图标1 */
	private String row41;
	/*** 第四行图标2 */
	private String row42;
	/*** 第五行图标1 */
	private String row51;
	/*** 第五行图标2 */
	private String row52;
	// 播放信息
	/*** 屏号 */
	private byte playScreenNum;
	/*** 播放时间 */
	private int playTime;
	// 状态
	/*** 音源模式 */
	private byte soundMode;
	/*** 显示模式 */
	private byte displayMode;
	/*** 蓝牙状态 */
	private boolean blueToothOpen;

	public byte getID() {
		return Constant.ID_SYNC;
	}

	public byte getScreenNum() {
		return screenNum;
	}

	public void setScreenNum(byte screenNum) {
		this.screenNum = screenNum;
	}

	public byte getRowNum() {
		return rowNum;
	}

	public void setRowNum(byte rowNum) {
		this.rowNum = rowNum;
	}

	public byte getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(byte groupNum) {
		this.groupNum = groupNum;
	}

	public String getScreenIcon1() {
		return screenIcon1;
	}

	public void setScreenIcon1(String screenIcon1) {
		this.screenIcon1 = screenIcon1;
	}

	public String getScreenIcon2() {
		return screenIcon2;
	}

	public void setScreenIcon2(String screenIcon2) {
		this.screenIcon2 = screenIcon2;
	}

	public String getScreenIcon3() {
		return screenIcon3;
	}

	public void setScreenIcon3(String screenIcon3) {
		this.screenIcon3 = screenIcon3;
	}

	public String getScreenIcon4() {
		return screenIcon4;
	}

	public void setScreenIcon4(String screenIcon4) {
		this.screenIcon4 = screenIcon4;
	}

	public String getScreenIcon5() {
		return screenIcon5;
	}

	public void setScreenIcon5(String screenIcon5) {
		this.screenIcon5 = screenIcon5;
	}

	public String getScreenIcon6() {
		return screenIcon6;
	}

	public void setScreenIcon6(String screenIcon6) {
		this.screenIcon6 = screenIcon6;
	}

	public String getRow11() {
		return row11;
	}

	public void setRow11(String row11) {
		this.row11 = row11;
	}

	public String getRow12() {
		return row12;
	}

	public void setRow12(String row12) {
		this.row12 = row12;
	}

	public String getRow21() {
		return row21;
	}

	public void setRow21(String row21) {
		this.row21 = row21;
	}

	public String getRow22() {
		return row22;
	}

	public void setRow22(String row22) {
		this.row22 = row22;
	}

	public String getRow31() {
		return row31;
	}

	public void setRow31(String row31) {
		this.row31 = row31;
	}

	public String getRow32() {
		return row32;
	}

	public void setRow32(String row32) {
		this.row32 = row32;
	}

	public String getRow41() {
		return row41;
	}

	public void setRow41(String row41) {
		this.row41 = row41;
	}

	public String getRow42() {
		return row42;
	}

	public void setRow42(String row42) {
		this.row42 = row42;
	}

	public String getRow51() {
		return row51;
	}

	public void setRow51(String row51) {
		this.row51 = row51;
	}

	public String getRow52() {
		return row52;
	}

	public void setRow52(String row52) {
		this.row52 = row52;
	}

	public byte getPlayScreenNum() {
		return playScreenNum;
	}

	public void setPlayScreenNum(byte playScreenNum) {
		this.playScreenNum = playScreenNum;
	}

	public int getPlayTime() {
		return playTime;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}

	public byte getSoundMode() {
		return soundMode;
	}

	public void setSoundMode(byte soundMode) {
		this.soundMode = soundMode;
	}

	public byte getDisplayMode() {
		return displayMode;
	}

	public void setDisplayMode(byte displayMode) {
		this.displayMode = displayMode;
	}

	public boolean isBlueToothOpen() {
		return blueToothOpen;
	}

	public void setBlueToothOpen(boolean blueToothOpen) {
		this.blueToothOpen = blueToothOpen;
	}
}
