package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/**
 * 如果某项没有信息，其对应的值默认为0xFF
 * 雷达颜色--- 1：白色 2： 黄色 3： 红色
 */
public class RadarInfo extends BaseInfo {
	
	private static int NO_SINGAL =  0xff;
	private static byte WHITE_COLOR =  1;
	
	/*** 雷达开关 0 关 1开 */
	private boolean radarSwitch;
	//前后雷达距离
	private int backLeftValue=NO_SINGAL;
	private int backMidLeftValue=NO_SINGAL;
	private int backMidRightValue=NO_SINGAL;
	private int backRightValue=NO_SINGAL;
	
	private int frontLeftValue=NO_SINGAL;
	private int frontMidLeftValue=NO_SINGAL;
	private int frontMidRightValue=NO_SINGAL;
	private int frontRightValue=NO_SINGAL;
	
    //前后雷达颜色	
    private byte backLeftColor=WHITE_COLOR;
	private byte backMidLeftColor=WHITE_COLOR;
	private byte backMidRightColor=WHITE_COLOR;
	private byte backRightColor=WHITE_COLOR;
	
	private byte frontLeftColor=WHITE_COLOR;
	private byte frontMidLeftColor=WHITE_COLOR;
	private byte frontMidRightColor=WHITE_COLOR;
	private byte frontRightColor=WHITE_COLOR;
	
	// 左右雷达距离
	private int rightFrontValue = NO_SINGAL;
	private int rightMidFrontValue = NO_SINGAL;
	private int rightMidBackValue = NO_SINGAL;
	private int rightBackValue = NO_SINGAL;
	
	private int leftFrontValue = NO_SINGAL;
	private int leftMidFrontValue = NO_SINGAL;
	private int leftMidBackValue = NO_SINGAL;
	private int leftBackValue = NO_SINGAL;
	
	// 左右雷达颜色
	private byte rightFrontColor = WHITE_COLOR;
	private byte rightMidFrontColor = WHITE_COLOR;
	private byte rightMidBackColor = WHITE_COLOR;
	private byte rightBackColor = WHITE_COLOR;
	
	private byte leftFrontColor = WHITE_COLOR;
	private byte leftMidFrontColor = WHITE_COLOR;
	private byte leftMidBackColor = WHITE_COLOR;
	private byte leftBackColor = WHITE_COLOR;
	
	

	public boolean isRadarSwitch() {
		return radarSwitch;
	}

	public void setRadarSwitch(boolean radarSwitch) {
		this.radarSwitch = radarSwitch;
	}

	public byte getBackLeftColor() {
		return backLeftColor;
	}

	public void setBackLeftColor(byte backLeftColor) {
		this.backLeftColor = backLeftColor;
	}

	public byte getBackMidLeftColor() {
		return backMidLeftColor;
	}

	public void setBackMidLeftColor(byte backMidLeftColor) {
		this.backMidLeftColor = backMidLeftColor;
	}

	public byte getBackMidRightColor() {
		return backMidRightColor;
	}

	public void setBackMidRightColor(byte backMidRightColor) {
		this.backMidRightColor = backMidRightColor;
	}

	public byte getBackRightColor() {
		return backRightColor;
	}

	public void setBackRightColor(byte backRightColor) {
		this.backRightColor = backRightColor;
	}

	public byte getFrontLeftColor() {
		return frontLeftColor;
	}

	public void setFrontLeftColor(byte frontLeftColor) {
		this.frontLeftColor = frontLeftColor;
	}

	public byte getFrontMidLeftColor() {
		return frontMidLeftColor;
	}

	public void setFrontMidLeftColor(byte frontMidLeftColor) {
		this.frontMidLeftColor = frontMidLeftColor;
	}

	public byte getFrontMidRightColor() {
		return frontMidRightColor;
	}

	public void setFrontMidRightColor(byte frontMidRightColor) {
		this.frontMidRightColor = frontMidRightColor;
	}

	public byte getFrontRightColor() {
		return frontRightColor;
	}

	public void setFrontRightColor(byte frontRightColor) {
		this.frontRightColor = frontRightColor;
	}

	public int getRightFrontValue() {
		return rightFrontValue;
	}

	public void setRightFrontValue(int rightFrontValue) {
		this.rightFrontValue = rightFrontValue;
	}

	public int getRightMidFrontValue() {
		return rightMidFrontValue;
	}

	public void setRightMidFrontValue(int rightMidFrontValue) {
		this.rightMidFrontValue = rightMidFrontValue;
	}

	public int getRightMidBackValue() {
		return rightMidBackValue;
	}

	public void setRightMidBackValue(int rightMidBackValue) {
		this.rightMidBackValue = rightMidBackValue;
	}

	public int getRightBackValue() {
		return rightBackValue;
	}

	public void setRightBackValue(int rightBackValue) {
		this.rightBackValue = rightBackValue;
	}

	public int getLeftFrontValue() {
		return leftFrontValue;
	}

	public void setLeftFrontValue(int leftFrontValue) {
		this.leftFrontValue = leftFrontValue;
	}

	public int getLeftMidFrontValue() {
		return leftMidFrontValue;
	}

	public void setLeftMidFrontValue(int leftMidFrontValue) {
		this.leftMidFrontValue = leftMidFrontValue;
	}

	public int getLeftMidBackValue() {
		return leftMidBackValue;
	}

	public void setLeftMidBackValue(int leftMidBackValue) {
		this.leftMidBackValue = leftMidBackValue;
	}

	public int getLeftBackValue() {
		return leftBackValue;
	}

	public void setLeftBackValue(int leftBackValue) {
		this.leftBackValue = leftBackValue;
	}

	public byte getRightFrontColor() {
		return rightFrontColor;
	}

	public void setRightFrontColor(byte rightFrontColor) {
		this.rightFrontColor = rightFrontColor;
	}

	public byte getRightMidFrontColor() {
		return rightMidFrontColor;
	}

	public void setRightMidFrontColor(byte rightMidFrontColor) {
		this.rightMidFrontColor = rightMidFrontColor;
	}

	public byte getRightMidBackColor() {
		return rightMidBackColor;
	}

	public void setRightMidBackColor(byte rightMidBackColor) {
		this.rightMidBackColor = rightMidBackColor;
	}

	public byte getRightBackColor() {
		return rightBackColor;
	}

	public void setRightBackColor(byte rightBackColor) {
		this.rightBackColor = rightBackColor;
	}

	public byte getLeftFrontColor() {
		return leftFrontColor;
	}

	public void setLeftFrontColor(byte leftFrontColor) {
		this.leftFrontColor = leftFrontColor;
	}

	public byte getLeftMidFrontColor() {
		return leftMidFrontColor;
	}

	public void setLeftMidFrontColor(byte leftMidFrontColor) {
		this.leftMidFrontColor = leftMidFrontColor;
	}

	public byte getLeftMidBackColor() {
		return leftMidBackColor;
	}

	public void setLeftMidBackColor(byte leftMidBackColor) {
		this.leftMidBackColor = leftMidBackColor;
	}

	public byte getLeftBackColor() {
		return leftBackColor;
	}

	public void setLeftBackColor(byte leftBackColor) {
		this.leftBackColor = leftBackColor;
	}

	public int getBackLeftValue() {
		return backLeftValue;
	}

	public void setBackLeftValue(int backLeftValue) {
		this.backLeftValue = backLeftValue;
	}

	public int getBackMidLeftValue() {
		return backMidLeftValue;
	}

	public void setBackMidLeftValue(int backMidLeftValue) {
		this.backMidLeftValue = backMidLeftValue;
	}

	public int getBackMidRightValue() {
		return backMidRightValue;
	}

	public void setBackMidRightValue(int backMidRightValue) {
		this.backMidRightValue = backMidRightValue;
	}

	public int getBackRightValue() {
		return backRightValue;
	}

	public void setBackRightValue(int backRightValue) {
		this.backRightValue = backRightValue;
	}

	public int getFrontLeftValue() {
		return frontLeftValue;
	}

	public void setFrontLeftValue(int frontLeftValue) {
		this.frontLeftValue = frontLeftValue;
	}

	public int getFrontMidLeftValue() {
		return frontMidLeftValue;
	}

	public void setFrontMidLeftValue(int frontMidLeftValue) {
		this.frontMidLeftValue = frontMidLeftValue;
	}

	public int getFrontMidRightValue() {
		return frontMidRightValue;
	}

	public void setFrontMidRightValue(int frontMidRightValue) {
		this.frontMidRightValue = frontMidRightValue;
	}

	public int getFrontRightValue() {
		return frontRightValue;
	}

	public void setFrontRightValue(int frontRightValue) {
		this.frontRightValue = frontRightValue;
	}
	
	public byte getID(){
		return Constant.ID_RADAR;
	};
}
