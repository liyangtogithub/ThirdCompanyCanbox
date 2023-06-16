package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

public class DoorInfo extends BaseInfo {

	/*** ����Ϣ�Ƿ���Ч��true:��Ч;false:��Ч,���ڿƵ��ǿ�Э��û�д��ֶΣ�ֻ��Ĭ��true */
	private boolean isValid = true;
	/*** ��ʻԱ�ţ�true:��;false:�� */
	private boolean driverDoor;
	/*** ����ţ�true:��;false:�� */
	private boolean leftBackDoor;
	/*** �˿��ǣ�true:��;false:�� */
	private boolean PassengerDoor;
	/*** �Һ��ţ�true:��;false:�� */
	private boolean rightBackDoor;
	/*** ����ǣ�true:��;false:�� */
	private boolean engineHood;
	/*** �����䣺true:��;false:�� */
	private boolean backTrunk;
	// �Ŵ����� ���
	/*** �� ��ݿ��� ��� 1:��Ч 0����Ч */
	private boolean windowConveniencePermit;
	/*** ���Ž��� ��� 1:��Ч 0����Ч */
	private boolean doorUnlockPermit;
	/*** �����Զ����� ��� 1:��Ч 0����Ч */
	private boolean doorAutoLockPermit;
	/*** ����ң��Կ�׼���ƥ�� ��� 1:��Ч 0����Ч */
	private boolean seatKeyPermit;
	/*** ��Ӧʽ������� ��� 1:��Ч 0����Ч */
	private boolean inductiveTrunkPermit;
	// �Ŵ����� ����
	/*** �� ��ݿ��� ���� 00:ȫ������ 01����ʻԱ�೵�� 10���ر� */
	private byte windowConvenienceSet;
	/*** ���Ž��� ���� 00:ȫ������ 01���������� 10�����೵�� */
	private byte doorUnlockSet;
	/*** �����Զ����� ���� 1:�� 0���� */
	private boolean doorAutoLockSet;
	/*** ����ң��Կ�׼���ƥ�� ���� 1:�� 0���� */
	private boolean seatKeySet;
	/*** ��Ӧʽ������� ���� 1:�� 0���� */
	private boolean inductiveTrunkSet;
	//ͨ�� ����
	/*** �Һ�1 �� 0 �� */
	private boolean righBW;
	/*** ���1 �� 0 �� */
	private boolean leftBW;
	/*** ��ǰ��1 �� 0 �� */
	private boolean righFW;
	/*** ��ǰ��1 �� 0 �� */
	private boolean leftFW;
	
	public boolean isRighBW() {
		return righBW;
	}

	public void setRighBW(boolean righBW) {
		this.righBW = righBW;
	}

	public boolean isLeftBW() {
		return leftBW;
	}

	public void setLeftBW(boolean leftBW) {
		this.leftBW = leftBW;
	}

	public boolean isRighFW() {
		return righFW;
	}

	public void setRighFW(boolean righFW) {
		this.righFW = righFW;
	}

	public boolean isLeftFW() {
		return leftFW;
	}

	public void setLeftFW(boolean leftFW) {
		this.leftFW = leftFW;
	}

	public byte getWindowConvenienceSet() {
		return windowConvenienceSet;
	}

	public void setWindowConvenienceSet(byte windowConvenienceSet) {
		this.windowConvenienceSet = windowConvenienceSet;
	}

	public byte getDoorUnlockSet() {
		return doorUnlockSet;
	}

	public void setDoorUnlockSet(byte doorUnlockSet) {
		this.doorUnlockSet = doorUnlockSet;
	}

	public boolean isDoorAutoLockSet() {
		return doorAutoLockSet;
	}

	public void setDoorAutoLockSet(boolean doorAutoLockSet) {
		this.doorAutoLockSet = doorAutoLockSet;
	}

	public boolean isSeatKeySet() {
		return seatKeySet;
	}

	public void setSeatKeySet(boolean seatKeySet) {
		this.seatKeySet = seatKeySet;
	}

	public boolean isInductiveTrunkSet() {
		return inductiveTrunkSet;
	}

	public void setInductiveTrunkSet(boolean inductiveTrunkSet) {
		this.inductiveTrunkSet = inductiveTrunkSet;
	}

	public boolean isWindowConveniencePermit() {
		return windowConveniencePermit;
	}

	public void setWindowConveniencePermit(boolean windowConveniencePermit) {
		this.windowConveniencePermit = windowConveniencePermit;
	}

	public boolean isDoorUnlockPermit() {
		return doorUnlockPermit;
	}

	public void setDoorUnlockPermit(boolean doorUnlockPermit) {
		this.doorUnlockPermit = doorUnlockPermit;
	}

	public boolean isDoorAutoLockPermit() {
		return doorAutoLockPermit;
	}

	public void setDoorAutoLockPermit(boolean doorAutoLockPermit) {
		this.doorAutoLockPermit = doorAutoLockPermit;
	}

	public boolean isSeatKeyPermit() {
		return seatKeyPermit;
	}

	public void setSeatKeyPermit(boolean seatKeyPermit) {
		this.seatKeyPermit = seatKeyPermit;
	}

	public boolean isInductiveTrunkPermit() {
		return inductiveTrunkPermit;
	}

	public void setInductiveTrunkPermit(boolean inductiveTrunkPermit) {
		this.inductiveTrunkPermit = inductiveTrunkPermit;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public boolean isDriverDoor() {
		return driverDoor;
	}

	public void setDriverDoor(boolean driverDoor) {
		this.driverDoor = driverDoor;
	}

	public boolean isLeftBackDoor() {
		return leftBackDoor;
	}

	public void setLeftBackDoor(boolean leftBackDoor) {
		this.leftBackDoor = leftBackDoor;
	}

	public boolean isPassengerDoor() {
		return PassengerDoor;
	}

	public void setPassengerDoor(boolean passengerDoor) {
		PassengerDoor = passengerDoor;
	}

	public boolean isRightBackDoor() {
		return rightBackDoor;
	}

	public void setRightBackDoor(boolean rightBackDoor) {
		this.rightBackDoor = rightBackDoor;
	}

	public boolean isEngineHood() {
		return engineHood;
	}

	public void setEngineHood(boolean engineHood) {
		this.engineHood = engineHood;
	}

	public boolean isBackTrunk() {
		return backTrunk;
	}

	public void setBackTrunk(boolean backTrunk) {
		this.backTrunk = backTrunk;
	}

	public byte getID() {
		return Constant.ID_DOOR;
	};

}
