package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/**
 * 车辆具体信息
 */
public class CarLargeInfo extends BaseInfo{
	
	/***盒子版本*/
	String boxVertion;
	/*** 瞬时油耗*/
	private String instantFuel ;
	/**** 行驶里程 */
	private float mileage = Constant.PROTOCAL_INVALID_VALUE;
	/*** 剩余油量*/
	private int surplusOil = Constant.PROTOCAL_INVALID_VALUE;
	/***电池 电压*/
	private String voltage;
	/*** 发动机转速*/
	private int rotateSpeed = Constant.PROTOCAL_INVALID_VALUE;
	/****瞬时车速 */
	private int instantSpeed  = Constant.PROTOCAL_INVALID_VALUE;
	/***平均油耗*/
	private float averageFuel = Constant.PROTOCAL_INVALID_VALUE;
	/***续航里程*/
	private int enduranceMileage = Constant.PROTOCAL_INVALID_VALUE;
	/****油耗单位 */
	private String oilUnit = "L/100km";
	/****里程单位*/
	private String distanceUnit = "km" ;
	/****速度单位*/
	private String speedUnit = "km/h" ;

	//科迪亚克：
	/***科迪亚克：  OFF ROAD 使能 */
	private boolean offRoadEnable;
	/***OFF ROAD 按键开 */
	private boolean offRoadKeyOpen;
	/***OFF ROAD 图标开 */
	private boolean offRoadIconOpen;
	// 科迪亚克：
	/*** 油温 */
	private int oilTemp;
	/*** 水温 */
	private int waterTemp = Constant.PROTOCAL_INVALID_VALUE;
	/****行驶时间 */
	private int travelTime ;
	/****平均车速 */
	private int averageSpeed ;
	/****负载油耗刻度最大值 */
	private float oilScaleMax ;
	/****负载油耗进度条百分比 */
	private int oilPercent = Constant.PROTOCAL_INVALID_VALUE;
	/****车辆识别号 */
	private String carNum ;
	/****车况检查天数标志 0x00：无 ，0x01:检查天数， 0x02:过期天数*/
	private String carCheckDaysTitle ;
	/****车况检查距离标志  0x00：无 ，0x01:检查天数， 0x02:过期天数*/
	private String carCheckDistanceTitle ;
	/****机油检查天数标志  0x00：无 ，0x01:检查天数， 0x02:过期天数*/
	private String oilCheckDaysTitle ;
	/****机油检查距离标志  0x00：无 ，0x01:检查天数， 0x02:过期天数*/
	private String oilCheckDistanceTitle ;
	/****车况检查天数*/
	private int carCheckDays ;
	/****车况检查距离*/
	private int carCheckDistance ;
	/****机油检查天数*/
	private int oilCheckDays ;
	/****机油检查距离*/
	private int oilCheckDistance ;
	//丰田
	
	/*** 最佳油耗*/
	private float bestFuel ;
	/*** 当前油耗*/
	private float curTripFuel ;
	/*** trip1油耗*/
	private float trip1Fuel ;
	/*** trip2油耗*/
	private float trip2Fuel ;
	/*** trip3油耗*/
	private float trip3Fuel ;
	/*** trip4油耗*/
	private float trip4Fuel ;
	/*** trip5油耗*/
	private float trip5Fuel ;
	/****trip油耗单位 */
	private String oilUnitTrip = "L/100km";
	/*** 上几分钟油耗*/
	private float lastFuelArray[] = null ;
	/***油电混合车型  0：否  1：是*/
	private boolean oilElectType ;
	/***电池电量 1--8*/
	byte batteryLevel;
	/***马达驱动电池 */
	private boolean motorToBattery;
	/***马达驱动轮子 */
	private boolean motorToWheel;
	/***发动机驱动马达 */
	private boolean engineToMotor;
	/***发动机驱动车轮 */
	private boolean engineToWheel;
	/***电池驱动马达 */
	private boolean batteryToMotor;
	/***车轮驱动马达 */
	private boolean WheelToMotor;
	//通用
	/***节气门位置  范围0~100 */
	private byte throttle;
	/***冷却液温度  */
	private byte coolantTemp;
	/***机油压力 */
	private int oilPress;
	/***大气压力 */
	private int airPress;
	/***小计里程1 */
	private int smallMileage1;
	/***小计里程2 */
	private int smallMileage2;
	/***小计里程3 */
	private int smallMileage3;
	/***平均油耗1*/
	private float averageFuel1;
	/***平均油耗2*/
	private float averageFuel2;
	/***平均油耗3*/
	private float averageFuel3;

	public String getSpeedUnit() {
		return speedUnit;
	}
	public void setSpeedUnit(String speedUnit) {
		this.speedUnit = speedUnit;
	}
	public float getCurTripFuel() {
		return curTripFuel;
	}
	public void setCurTripFuel(float curTripFuel) {
		this.curTripFuel = curTripFuel;
	}
	public String getOilUnitTrip() {
		return oilUnitTrip;
	}
	public void setOilUnitTrip(String oilUnitTrip) {
		this.oilUnitTrip = oilUnitTrip;
	}
	public int getRotateSpeed() {
		return rotateSpeed;
	}
	public void setRotateSpeed(int rotateSpeed) {
		this.rotateSpeed = rotateSpeed;
	}
	public int getOilTemp() {
		return oilTemp;
	}
	public void setOilTemp(int oilTemp) {
		this.oilTemp = oilTemp;
	}

	public int getWaterTemp() {
		return waterTemp;
	}

	public void setWaterTemp(int waterTemp) {
		this.waterTemp = waterTemp;
	}
	public float getAverageFuel3() {
		return averageFuel3;
	}

	public void setAverageFuel3(float averageFuel3) {
		this.averageFuel3 = averageFuel3;
	}

	public float getAverageFuel1() {
		return averageFuel1;
	}

	public void setAverageFuel1(float averageFuel1) {
		this.averageFuel1 = averageFuel1;
	}

	public float getAverageFuel2() {
		return averageFuel2;
	}

	public void setAverageFuel2(float averageFuel2) {
		this.averageFuel2 = averageFuel2;
	}

	public int getSmallMileage1() {
		return smallMileage1;
	}

	public void setSmallMileage1(int smallMileage1) {
		this.smallMileage1 = smallMileage1;
	}

	public int getSmallMileage2() {
		return smallMileage2;
	}

	public void setSmallMileage2(int smallMileage2) {
		this.smallMileage2 = smallMileage2;
	}

	public int getSmallMileage3() {
		return smallMileage3;
	}

	public void setSmallMileage3(int smallMileage3) {
		this.smallMileage3 = smallMileage3;
	}

	public int getAirPress() {
		return airPress;
	}

	public void setAirPress(int airPress) {
		this.airPress = airPress;
	}

	public int getOilPress() {
		return oilPress;
	}

	public void setOilPress(int oilPress) {
		this.oilPress = oilPress;
	}

	public byte getCoolantTemp() {
		return coolantTemp;
	}

	public void setCoolantTemp(byte coolantTemp) {
		this.coolantTemp = coolantTemp;
	}
	public byte getThrottle() {
		return throttle;
	}

	public void setThrottle(byte throttle) {
		this.throttle = throttle;
	}
	public boolean isOilElectType() {
		return oilElectType;
	}
	public void setOilElectType(boolean oilElectType) {
		this.oilElectType = oilElectType;
	}

	public byte getBatteryLevel() {
		return batteryLevel;
	}

	public void setBatteryLevel(byte batteryLevel) {
		this.batteryLevel = batteryLevel;
	}

	public boolean isMotorToBattery() {
		return motorToBattery;
	}

	public void setMotorToBattery(boolean motorToBattery) {
		this.motorToBattery = motorToBattery;
	}

	public boolean isMotorToWheel() {
		return motorToWheel;
	}

	public void setMotorToWheel(boolean motorToWheel) {
		this.motorToWheel = motorToWheel;
	}

	public boolean isEngineToMotor() {
		return engineToMotor;
	}

	public void setEngineToMotor(boolean engineToMotor) {
		this.engineToMotor = engineToMotor;
	}

	public boolean isEngineToWheel() {
		return engineToWheel;
	}

	public void setEngineToWheel(boolean engineToWheel) {
		this.engineToWheel = engineToWheel;
	}

	public boolean isBatteryToMotor() {
		return batteryToMotor;
	}

	public void setBatteryToMotor(boolean batteryToMotor) {
		this.batteryToMotor = batteryToMotor;
	}

	public boolean isWheelToMotor() {
		return WheelToMotor;
	}

	public void setWheelToMotor(boolean wheelToMotor) {
		WheelToMotor = wheelToMotor;
	}

	public float[] getLastFuelArray() {
		return lastFuelArray;
	}

	public void setLastFuelArray(float[] lastFuelArray) {
		this.lastFuelArray = lastFuelArray;
	}

	public float getTrip1Fuel() {
		return trip1Fuel;
	}

	public void setTrip1Fuel(float trip1Fuel) {
		this.trip1Fuel = trip1Fuel;
	}

	public float getTrip2Fuel() {
		return trip2Fuel;
	}

	public void setTrip2Fuel(float trip2Fuel) {
		this.trip2Fuel = trip2Fuel;
	}

	public float getTrip3Fuel() {
		return trip3Fuel;
	}

	public void setTrip3Fuel(float trip3Fuel) {
		this.trip3Fuel = trip3Fuel;
	}

	public float getTrip4Fuel() {
		return trip4Fuel;
	}

	public void setTrip4Fuel(float trip4Fuel) {
		this.trip4Fuel = trip4Fuel;
	}

	public float getTrip5Fuel() {
		return trip5Fuel;
	}

	public void setTrip5Fuel(float trip5Fuel) {
		this.trip5Fuel = trip5Fuel;
	}

	public float getBestFuel() {
		return bestFuel;
	}

	public void setBestFuel(float bestFuel) {
		this.bestFuel = bestFuel;
	}

	public int getInstantSpeed() {
		return instantSpeed;
	}

	public void setInstantSpeed(int instantSpeed) {
		this.instantSpeed = instantSpeed;
	}

	public float getOilScaleMax() {
		return oilScaleMax;
	}

	public void setOilScaleMax(float oilScaleMax) {
		this.oilScaleMax = oilScaleMax;
	}

	public int getOilPercent() {
		return oilPercent;
	}

	public void setOilPercent(int oilPercent) {
		this.oilPercent = oilPercent;
	}

	public String getOilUnit() {
		return oilUnit;
	}

	public void setOilUnit(String oilUnit) {
		this.oilUnit = oilUnit;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getDistanceUnit() {
		return distanceUnit;
	}

	public void setDistanceUnit(String distanceUnit) {
		this.distanceUnit = distanceUnit;
	}

	public String getCarCheckDaysTitle() {
		return carCheckDaysTitle;
	}

	public void setCarCheckDaysTitle(String carCheckDaysTitle) {
		this.carCheckDaysTitle = carCheckDaysTitle;
	}

	public String getCarCheckDistanceTitle() {
		return carCheckDistanceTitle;
	}

	public void setCarCheckDistanceTitle(String carCheckDistanceTitle) {
		this.carCheckDistanceTitle = carCheckDistanceTitle;
	}

	public String getOilCheckDaysTitle() {
		return oilCheckDaysTitle;
	}

	public void setOilCheckDaysTitle(String oilCheckDaysTitle) {
		this.oilCheckDaysTitle = oilCheckDaysTitle;
	}

	public String getOilCheckDistanceTitle() {
		return oilCheckDistanceTitle;
	}

	public void setOilCheckDistanceTitle(String oilCheckDistanceTitle) {
		this.oilCheckDistanceTitle = oilCheckDistanceTitle;
	}

	public int getCarCheckDays() {
		return carCheckDays;
	}

	public void setCarCheckDays(int carCheckDays) {
		this.carCheckDays = carCheckDays;
	}

	public int getCarCheckDistance() {
		return carCheckDistance;
	}

	public void setCarCheckDistance(int carCheckDistance) {
		this.carCheckDistance = carCheckDistance;
	}

	public int getOilCheckDays() {
		return oilCheckDays;
	}

	public void setOilCheckDays(int oilCheckDays) {
		this.oilCheckDays = oilCheckDays;
	}

	public int getOilCheckDistance() {
		return oilCheckDistance;
	}

	public void setOilCheckDistance(int oilCheckDistance) {
		this.oilCheckDistance = oilCheckDistance;
	}

	public float getAverageFuel() {
		return averageFuel;
	}

	public void setAverageFuel(float averageFuel) {
		this.averageFuel = averageFuel;
	}

	public int getEnduranceMileage() {
		return enduranceMileage;
	}

	public void setEnduranceMileage(int enduranceMileage) {
		this.enduranceMileage = enduranceMileage;
	}

	public int getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(int travelTime) {
		this.travelTime = travelTime;
	}

	public int getAverageSpeed() {
		return averageSpeed;
	}

	public void setAverageSpeed(int averageSpeed) {
		this.averageSpeed = averageSpeed;
	}

	public boolean isOffRoadEnable() {
		return offRoadEnable;
	}

	public void setOffRoadEnable(boolean offRoadEnable) {
		this.offRoadEnable = offRoadEnable;
	}

	public boolean isOffRoadKeyOpen() {
		return offRoadKeyOpen;
	}

	public void setOffRoadKeyOpen(boolean offRoadKeyOpen) {
		this.offRoadKeyOpen = offRoadKeyOpen;
	}

	public boolean isOffRoadIconOpen() {
		return offRoadIconOpen;
	}

	public void setOffRoadIconOpen(boolean offRoadIconOpen) {
		this.offRoadIconOpen = offRoadIconOpen;
	}

	public String getInstantFuel() {
		return instantFuel;
	}

	public void setInstantFuel(String instantFuel) {
		this.instantFuel = instantFuel;
	}

	public String getBoxVertion() {
		return boxVertion;
	}

	public void setBoxVertion(String boxVertion) {
		this.boxVertion = boxVertion;
	}
	
	public float getMileage() {
		return mileage;
	}

	public void setMileage(float mileage) {
		this.mileage = mileage;
	}

	public int getSurplusOil() {
		return surplusOil;
	}

	public void setSurplusOil(int surplusOil) {
		this.surplusOil = surplusOil;
	}

	public String getVoltage() {
		return voltage;
	}

	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}
	
	public byte getID(){
		return Constant.ID_CARLARGE;
	};

}
