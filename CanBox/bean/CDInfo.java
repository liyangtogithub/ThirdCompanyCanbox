package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/*** CD������Ϣ */
public class CDInfo extends BaseInfo{

	/***CD�Ƿ����� */
	private boolean isCdOk = false;
	/***����Ŀ�� */
	private int allSongNum = 0;
	/*** ֹͣ/�ر� */
	private boolean isStop = false;
	/*** ��ͣ */
	private boolean isPause = false;
	/*** ���� */
	private boolean isPlay = false;
	/*** ���� */
	private boolean isDiscOut = false;
	/*** ���� */
	private boolean isReading = false;
	/*** ѭ��ģʽ */
	private byte rptMode = Constant.CD_RPT_CLOSE;
	/*** ���ģʽ */
	private byte rdmMode = Constant.CD_RDM_CLOSE;
	/*** ��ǰ�ļ��� */
	private int curFold = 0;
	/*** ��ǰ��Ŀ */
	private int curSong = 0;
	/*** ��Ŀ��ʱ�� */
	private int songAllTime = 1;
	/*** ��ǰ��Ŀʱ�� */
	private int curSongTime = 0;
	/*** TEXT���� */
	private int textType = Constant.TEXT_NAME_SONG;
	/*** TEXT״̬ */
	private boolean isTextStateOk =false;
	/***�����ʽ */
	private int codeType = Constant.TEXT_STATE_ASCII;
	/*** TEXT���� */
	String textContent = "";
	/***�������� */
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
