package com.landsem.canbox.pack.simple;

import java.util.List;

import android.R.integer;

import com.landsem.canbox.Constant.Mazda;
import com.landsem.canbox.Constant.MazdaSimple;
import com.landsem.canbox.Constant.SimpleDasAutoID.SendComID1;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.ComBean;
import com.landsem.canbox.comparse.simple.SimpleBaseParse;
import com.landsem.canbox.manager.SerialManager;
import com.landsem.canbox.pack.HiworldBaseComPack;
import com.landsem.canbox.pack.SimpleBaseComPack;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;


public class SimpleMazdaPack extends SimpleBaseComPack   {
	/**
	 * 欣朴
	 * (DVD主机->协议盒)
	 */
	public SimpleMazdaPack() {
		super((byte) 0xFF, (byte) 0x2e);
	}
	
	static SimpleMazdaPack mSimpleMazdaPack;
	
	public static SimpleMazdaPack getInstance(){
		if (mSimpleMazdaPack==null) {
			mSimpleMazdaPack = new SimpleMazdaPack();
		}
		return mSimpleMazdaPack;
	}
	
	/***建立通信*/
	public static void sendStartOrder(boolean isStart) {
		byte order = (byte) (isStart?1:0);
		sendOrder((byte)MazdaSimple.SEND_START_ORDER, null, new byte[] {order});
	}
	
	/***控制播放信息*/
	public static void sendCdControlOrder(byte... byteData) {
		sendOrder((byte)MazdaSimple.SEND_CONTROL_ORDER, null, byteData);
	}
	
	/***向can请求信息*/
	public static void sendReqInfo(byte... byteData) {
		sendOrder((byte)MazdaSimple.SEND_REQUEST_ORDER, null, byteData);
	}

	public static void sendOrder(byte comID, String sendValue, byte... byteData) {
		SerialManager mSerialManager = SerialManager.getInstance();
		ComBean mComBean = ComBean.createComBean(comID, sendValue, byteData);
		mSerialManager.onSendCom(mComBean);
	}
	
	

	
}
