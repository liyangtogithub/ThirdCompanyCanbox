package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

public class DoorInfo extends BaseInfo {

	/*** 门信息是否有效：true:有效;false:无效,由于科迪亚克协议没有此字段，只能默认true */
	private boolean isValid = true;
	/*** 驾驶员门：true:开;false:关 */
	private boolean driverDoor;
	/*** 左后门：true:开;false:关 */
	private boolean leftBackDoor;
	/*** 乘客们：true:开;false:关 */
	private boolean PassengerDoor;
	/*** 右后门：true:开;false:关 */
	private boolean rightBackDoor;
	/*** 引擎盖：true:开;false:关 */
	private boolean engineHood;
	/*** 行李箱：true:开;false:关 */
	private boolean backTrunk;
	// 门窗开关 许可
	/*** 窗 便捷开启 许可 1:有效 0：无效 */
	private boolean windowConveniencePermit;
	/*** 车门解锁 许可 1:有效 0：无效 */
	private boolean doorUnlockPermit;
	/*** 车门自动上锁 许可 1:有效 0：无效 */
	private boolean doorAutoLockPermit;
	/*** 座椅遥控钥匙记忆匹配 许可 1:有效 0：无效 */
	private boolean seatKeyPermit;
	/*** 感应式行李箱盖 许可 1:有效 0：无效 */
	private boolean inductiveTrunkPermit;
	// 门窗开关 设置
	/*** 窗 便捷开启 设置 00:全部车窗 01：驾驶员侧车窗 10：关闭 */
	private byte windowConvenienceSet;
	/*** 车门解锁 设置 00:全部车门 01：单个车门 10：单侧车门 */
	private byte doorUnlockSet;
	/*** 车门自动上锁 设置 1:开 0：关 */
	private boolean doorAutoLockSet;
	/*** 座椅遥控钥匙记忆匹配 设置 1:开 0：关 */
	private boolean seatKeySet;
	/*** 感应式行李箱盖 设置 1:开 0：关 */
	private boolean inductiveTrunkSet;
	//通用 窗户
	/*** 右后窗1 开 0 关 */
	private boolean righBW;
	/*** 左后窗1 开 0 关 */
	private boolean leftBW;
	/*** 右前窗1 开 0 关 */
	private boolean righFW;
	/*** 左前窗1 开 0 关 */
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
