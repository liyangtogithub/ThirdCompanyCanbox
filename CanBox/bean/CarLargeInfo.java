package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/**
 * ����������Ϣ
 */
public class CarLargeInfo extends BaseInfo{
	
	/***���Ӱ汾*/
	String boxVertion;
	/*** ˲ʱ�ͺ�*/
	private String instantFuel ;
	/**** ��ʻ��� */
	private float mileage = Constant.PROTOCAL_INVALID_VALUE;
	/*** ʣ������*/
	private int surplusOil = Constant.PROTOCAL_INVALID_VALUE;
	/***��� ��ѹ*/
	private String voltage;
	/*** ������ת��*/
	private int rotateSpeed = Constant.PROTOCAL_INVALID_VALUE;
	/****˲ʱ���� */
	private int instantSpeed  = Constant.PROTOCAL_INVALID_VALUE;
	/***ƽ���ͺ�*/
	private float averageFuel = Constant.PROTOCAL_INVALID_VALUE;
	/***�������*/
	private int enduranceMileage = Constant.PROTOCAL_INVALID_VALUE;
	/****�ͺĵ�λ */
	private String oilUnit = "L/100km";
	/****��̵�λ*/
	private String distanceUnit = "km" ;
	/****�ٶȵ�λ*/
	private String speedUnit = "km/h" ;

	//�Ƶ��ǿˣ�
	/***�Ƶ��ǿˣ�  OFF ROAD ʹ�� */
	private boolean offRoadEnable;
	/***OFF ROAD ������ */
	private boolean offRoadKeyOpen;
	/***OFF ROAD ͼ�꿪 */
	private boolean offRoadIconOpen;
	// �Ƶ��ǿˣ�
	/*** ���� */
	private int oilTemp;
	/*** ˮ�� */
	private int waterTemp = Constant.PROTOCAL_INVALID_VALUE;
	/****��ʻʱ�� */
	private int travelTime ;
	/****ƽ������ */
	private int averageSpeed ;
	/****�����ͺĿ̶����ֵ */
	private float oilScaleMax ;
	/****�����ͺĽ������ٷֱ� */
	private int oilPercent = Constant.PROTOCAL_INVALID_VALUE;
	/****����ʶ��� */
	private String carNum ;
	/****�������������־ 0x00���� ��0x01:��������� 0x02:��������*/
	private String carCheckDaysTitle ;
	/****�����������־  0x00���� ��0x01:��������� 0x02:��������*/
	private String carCheckDistanceTitle ;
	/****���ͼ��������־  0x00���� ��0x01:��������� 0x02:��������*/
	private String oilCheckDaysTitle ;
	/****���ͼ������־  0x00���� ��0x01:��������� 0x02:��������*/
	private String oilCheckDistanceTitle ;
	/****�����������*/
	private int carCheckDays ;
	/****����������*/
	private int carCheckDistance ;
	/****���ͼ������*/
	private int oilCheckDays ;
	/****���ͼ�����*/
	private int oilCheckDistance ;
	//����
	
	/*** ����ͺ�*/
	private float bestFuel ;
	/*** ��ǰ�ͺ�*/
	private float curTripFuel ;
	/*** trip1�ͺ�*/
	private float trip1Fuel ;
	/*** trip2�ͺ�*/
	private float trip2Fuel ;
	/*** trip3�ͺ�*/
	private float trip3Fuel ;
	/*** trip4�ͺ�*/
	private float trip4Fuel ;
	/*** trip5�ͺ�*/
	private float trip5Fuel ;
	/****trip�ͺĵ�λ */
	private String oilUnitTrip = "L/100km";
	/*** �ϼ������ͺ�*/
	private float lastFuelArray[] = null ;
	/***�͵��ϳ���  0����  1����*/
	private boolean oilElectType ;
	/***��ص��� 1--8*/
	byte batteryLevel;
	/***���������� */
	private boolean motorToBattery;
	/***����������� */
	private boolean motorToWheel;
	/***������������� */
	private boolean engineToMotor;
	/***�������������� */
	private boolean engineToWheel;
	/***���������� */
	private boolean batteryToMotor;
	/***����������� */
	private boolean WheelToMotor;
	//ͨ��
	/***������λ��  ��Χ0~100 */
	private byte throttle;
	/***��ȴҺ�¶�  */
	private byte coolantTemp;
	/***����ѹ�� */
	private int oilPress;
	/***����ѹ�� */
	private int airPress;
	/***С�����1 */
	private int smallMileage1;
	/***С�����2 */
	private int smallMileage2;
	/***С�����3 */
	private int smallMileage3;
	/***ƽ���ͺ�1*/
	private float averageFuel1;
	/***ƽ���ͺ�2*/
	private float averageFuel2;
	/***ƽ���ͺ�3*/
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
