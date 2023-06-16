package com.landsem.canbox.comparse.hiworld;

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
import com.landsem.common.tools.LogManager;
/**
 * HiworldBaseParse1和HiworldBaseParse2的区别是校验方法不同
 */
public abstract class HiworldBaseParse1 extends BaseComParse implements Constant{

	protected final String TAG = this.getClass().getSimpleName();

	protected final byte ON = 1;
	
	protected AirConditionInfo mAirConditionInfo = new AirConditionInfo();
	protected RadarInfo mRadarInfo = new RadarInfo();
	protected CarLargeInfo mCarLargeInfo = new CarLargeInfo();
	CarBaseInfo mCarBaseInfo = new CarBaseInfo();
	public DoorInfo mDoorInfo = new DoorInfo();
	CornerInfo mCornerInfo = new CornerInfo();
	
	public HiworldBaseParse1() {
		super();
	}

	public HiworldBaseParse1(byte checkCode, byte comStartByte1, byte comStartByte2) {
		super(checkCode, comStartByte1, comStartByte2);
	}
	
	/**
	 * 根据协议检测指令是否完整 此处默认为协议的byte0为起始帧1，byte1为起始帧2。byte2为数据个数
	 * 算法为byte2到byte[byte.length-2]各与上0XFF再与byte[byte.length-1]比较
	 * @param orderBytes
	 * @return
	 */
	@Override
	public boolean onCheckBytesValidity(Byte[] orderBytes) {
		boolean resultCode = false;
		if (null != orderBytes && 3 < orderBytes.length) {
			int sum = 0;
			for (int index = 2; index < orderBytes.length - 1; index++) {
				sum += orderBytes[index];
			}
			byte checkSum = (byte) ((sum & checkCode) - 1);
			resultCode = (orderBytes[orderBytes.length - 1]) == checkSum;
			LogManager.d("HiworldBaseParse  onCheckBytesValidity  check_Sum:  "
					+ checkSum+"   check_bit:"+ orderBytes[orderBytes.length - 1]);
		}
		return resultCode;
	}

}
