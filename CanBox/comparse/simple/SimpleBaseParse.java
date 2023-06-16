package com.landsem.canbox.comparse.simple;

import com.landsem.canbox.Constant;
import com.landsem.canbox.Constant.SimpleDasAutoID;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CarLargeInfo;
import com.landsem.canbox.bean.CornerInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.RadarInfo;
import com.landsem.canbox.comparse.BaseComParse;
import com.landsem.canbox.pack.SimpleBaseComPack;
import com.landsem.canbox.tools.ByteUtil;

public abstract class SimpleBaseParse extends BaseComParse implements Constant, SimpleDasAutoID{

	protected final String TAG = this.getClass().getSimpleName();

	protected final byte ON = 1;
	
	protected AirConditionInfo mAirConditionInfo = new AirConditionInfo();
	protected RadarInfo mRadarInfo = new RadarInfo();
	protected CarLargeInfo mCarLargeInfo = new CarLargeInfo();
	public CarBaseInfo mCarBaseInfo = new CarBaseInfo();
	public DoorInfo mDoorInfo = new DoorInfo();
	public CornerInfo mCornerInfo = new CornerInfo();
	
	public SimpleBaseParse() {
		super();
	}

	public SimpleBaseParse(byte checkCode, byte comStartByte1, byte comStartByte2) {
		super(checkCode, comStartByte1, comStartByte2);
	}
	/**
	 * ะฃั้
	 */
	@Override
	public boolean onCheckBytesValidity(Byte[] orderBytes) {
		boolean resultCode = false;
		if (null != orderBytes && 3 < orderBytes.length) {
			int sum = 0;
			for (int index = 1; index < orderBytes.length - 1; index++) {
				sum += orderBytes[index];
			}
			byte checkSum = (byte) (sum ^ checkCode);
			resultCode = (orderBytes[orderBytes.length - 1]) == checkSum;
		}
		if (resultCode) {
			SimpleBaseComPack.sendACK(); 
		}
		return resultCode;
	}

}
