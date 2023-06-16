package com.landsem.canbox.pack.xinbas;

import com.landsem.canbox.Constant.Mazda;
import com.landsem.canbox.bean.ComBean;
import com.landsem.canbox.manager.SerialManager;
import com.landsem.canbox.pack.SimpleBaseComPack;


public class XinbasMazdaPack extends SimpleBaseComPack   {
	/**
	 * 鑫巴斯马3&昂克赛拉&CX-4&阿特兹串口通讯协议V1.1.3
	 * (DVD主机->协议盒)
	 */
	public XinbasMazdaPack() {
		super((byte) 0xFF, (byte) 0x2e);
	}
	
	static XinbasMazdaPack mDasAuto1Pack;
	
	public static XinbasMazdaPack getInstance(){
		if (mDasAuto1Pack==null) {
			mDasAuto1Pack = new XinbasMazdaPack();
		}
		return mDasAuto1Pack;
	}
	
	/***媒体播放信息*/
	public static void sendCdOrder(byte... byteData) {
		sendOrder((byte)Mazda.SEND_CD_ORDER, null, byteData);
	}
	
	/***向can请求信息*/
	public static void sendReqInfo(byte... byteData) {
		sendOrder((byte)Mazda.SEND_REQUEST_ORDER, null, byteData);
	}

	public static void sendOrder(byte comID, String sendValue, byte... byteData) {
		SerialManager mSerialManager = SerialManager.getInstance();
		ComBean mComBean = ComBean.createComBean(comID, sendValue, byteData);
		mSerialManager.onSendCom(mComBean);
	}
	
	

	
}
