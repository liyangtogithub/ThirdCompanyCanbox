package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/*** CD接收信息 */
public class CDInfo extends BaseInfo{

	/***CD是否正常 */
	private boolean isCdOk = false;
	/***总曲目数 */
	private int allSongNum = 0;
	/*** 停止/关闭 */
	private boolean isStop = false;
	/*** 暂停 */
	private boolean isPause = false;
	/*** 播放 */
	private boolean isPlay = false;
	/*** 出仓 */
	private boolean isDiscOut = false;
	/*** 读碟 */
	private boolean isReading = false;
	/*** 循环模式 */
	private byte rptMode = Constant.CD_RPT_CLOSE;
	/*** 随机模式 */
	private byte rdmMode = Constant.CD_RDM_CLOSE;
	/*** 当前文件夹 */
	private int curFold = 0;
	/*** 当前曲目 */
	private int curSong = 0;
	/*** 曲目总时间 */
	private int songAllTime = 1;
	/*** 当前曲目时间 */
	private int curSongTime = 0;
	/*** TEXT类型 */
	private int textType = Constant.TEXT_NAME_SONG;
	/*** TEXT状态 */
	private boolean isTextStateOk =false;
	/***编码格式 */
	private int codeType = Constant.TEXT_STATE_ASCII;
	/*** TEXT内容 */
	String textContent = "";
	/***命令类型 */
	private byte comIdType = Constant.Mazda.DATA_DEVICE_INFO;
	
	public byte getID() {
		return Constant.ID_CD_INFO;
	}

	public byte getComIdType() {
		return comIdType;
	}

	public void setComIdType(byte comIdType) {
		this.comIdType = comIdType;
	}

	public boolean isCdOk() {
		return isCdOk;
	}

	public void setCdOk(boolean isCdOk) {
		this.isCdOk = isCdOk;
	}

	public int getAllSongNum() {
		return allSongNum;
	}

	public void setAllSongNum(int allSongNum) {
		this.allSongNum = allSongNum;
	}

	public boolean isStop() {
		return isStop;
	}

	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}

	public boolean isPause() {
		return isPause;
	}

	public void setPause(boolean isPause) {
		this.isPause = isPause;
	}

	public boolean isPlay() {
		return isPlay;
	}

	public void setPlay(boolean isPlay) {
		this.isPlay = isPlay;
	}

	public boolean isDiscOut() {
		return isDiscOut;
	}

	public void setDiscOut(boolean isDiscOut) {
		this.isDiscOut = isDiscOut;
	}

	public boolean isReading() {
		return isReading;
	}

	public void setReading(boolean isReading) {
		this.isReading = isReading;
	}

	public byte getRptMode() {
		return rptMode;
	}

	public void setRptMode(byte rptMode) {
		this.rptMode = rptMode;
	}

	public byte getRdmMode() {
		return rdmMode;
	}

	public void setRdmMode(byte rdmMode) {
		this.rdmMode = rdmMode;
	}

	public int getCurFold() {
		return curFold;
	}

	public void setCurFold(int curFold) {
		this.curFold = curFold;
	}

	public int getCurSong() {
		return curSong;
	}

	public void setCurSong(int curSong) {
		this.curSong = curSong;
	}

	public int getSongAllTime() {
		return songAllTime;
	}

	public void setSongAllTime(int songAllTime) {
		this.songAllTime = songAllTime;
	}

	public int getCurSongTime() {
		return curSongTime;
	}

	public void setCurSongTime(int curSongTime) {
		this.curSongTime = curSongTime;
	}

	public int getTextType() {
		return textType;
	}

	public void setTextType(int textType) {
		this.textType = textType;
	}

	public boolean isTextStateOk() {
		return isTextStateOk;
	}

	public void setTextStateOk(boolean isTextStateOk) {
		this.isTextStateOk = isTextStateOk;
	}

	public int getCodeType() {
		return codeType;
	}

	public void setCodeType(int codeType) {
		this.codeType = codeType;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

}
