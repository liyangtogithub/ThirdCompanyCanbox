package com.landsem.canbox.comparse.hiworld;

import com.landsem.canbox.Constant;
import com.landsem.canbox.Constant.SimpleDasAutoID;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CarLargeInfo;
import com.landsem.canbox.bean.CornerInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.RadarInfo;
import com.landsem.canbox.comparse.BaseComParse;
import com.landsem.canbox.pack.SimpleBaseComPack;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;
/**
 * HiworldBaseParse1和HiworldBaseParse2的区别是校验方法不同
 * 本类的子类有：福特，本田，现代，科迪亚克，PSA
 */
public abstract class HiworldBaseParse2 extends BaseComParse implements Constant{

	protected final String TAG = this.getClass().getSimpleName();

	protected final byte ON = 1;
	
	protected AirConditionInfo mAirConditionInfo = new AirConditionInfo();
	protected RadarInfo mRadarInfo = new RadarInfo();
	protected CarLargeInfo mCarLargeInfo = new CarLargeInfo();
	protected CarBaseInfo mCarBaseInfo = new CarBaseInfo();
	protected DoorInfo mDoorInfo = new DoorInfo();
	protected CornerInfo mCornerInfo = new CornerInfo();
	
	public HiworldBaseParse2() {
		super();
	}

	public HiworldBaseParse2(byte checkCode, byte comStartByte1, byte comStartByte2) {
		super(checkCode, comStartByte1, comStartByte2);
	}
	
	/**
	 * 校验数据是否正确
	 */
	@Override
	public boolean onCheckBytesValidity(Byte[] orderBytes) {
		boolean resultCode = false;
		if (null != orderBytes && 3 < orderBytes.length) {
			int sum = 0;
			for (int index = 2; index < orderBytes.length - 1; index++) {
				sum += orderBytes[index];
			}
			byte checkSum = (byte) (( (sum-1) & checkCode));
			resultCode = (orderBytes[orderBytes.length - 1]) == checkSum;
			LogManager.d("KoDiakParse  onCheckBytesValidity  check_Sum:  "+ checkSum 
					+ "   check_bit:"+ orderBytes[orderBytes.length - 1]);
		}
		return resultCode;
	}

}
