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
 * HiworldBaseParse1��HiworldBaseParse2��������У�鷽����ͬ
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
	 * ����Э����ָ���Ƿ����� �˴�Ĭ��ΪЭ���byte0Ϊ��ʼ֡1��byte1Ϊ��ʼ֡2��byte2Ϊ���ݸ���
	 * �㷨Ϊbyte2��byte[byte.length-2]������0XFF����byte[byte.length-1]�Ƚ�
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
