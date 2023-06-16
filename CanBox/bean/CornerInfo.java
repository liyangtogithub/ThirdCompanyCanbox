package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/**
 * 
 * @author LQPDC
 * ·½Ïò×ª½Ç
 */
public class CornerInfo extends BaseInfo{
	
	public static int NO_SINGAL = 0xff;
	
	private int leftCorner = Constant.PROTOCAL_INVALID_VALUE ;
	
	private int rightCorner= Constant.PROTOCAL_INVALID_VALUE;

	public int getLeftCorner() {
		return leftCorner;
	}
	public void setLeftCorner(int leftCorner) {
		this.leftCorner = leftCorner;
	}

	public int getRightCorner() {
		return rightCorner;
	}

	public void setRightCorner(int rightCorner) {
		this.rightCorner = rightCorner;
	}

	public byte getID(){
		return Constant.ID_CORNER;
	};
}
