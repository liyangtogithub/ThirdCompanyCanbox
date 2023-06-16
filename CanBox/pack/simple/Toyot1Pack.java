package com.landsem.canbox.pack.simple;

import com.landsem.canbox.Constant.SimpleDasAutoID.SendComID1;
import com.landsem.canbox.bean.ComBean;
import com.landsem.canbox.manager.SerialManager;
import com.landsem.canbox.pack.SimpleBaseComPack;


public class Toyot1Pack extends SimpleBaseComPack   {
	/**
	 * �������_����
	 * (DVD����->Э���)
	 */
	public Toyot1Pack() {
		super((byte) 0xFF, (byte) 0x2e);
	}
	
	static Toyot1Pack mDasAuto1Pack;
	
	public static Toyot1Pack getInstance(){
		if (mDasAuto1Pack==null) {
			mDasAuto1Pack = new Toyot1Pack();
		}
		return mDasAuto1Pack;
	}
	
	/***��ʼ*/
	public static void startOrder() {
		sendOrder((byte)SendComID1.SEND_START_ORDER, null, new byte[] {0x01});
	}
	/***��ѯ������Ϣ*/
	public static void askCarInfoOrder1() {
		sendOrder((byte)SendComID1.REQUEST_CONTROL_INFO, null, new byte[] {0x41,0x02});
	}
	
	/***��ѯ������Ϣ*/
	public static void askCarInfoOrder2() {
		sendOrder((byte)SendComID1.REQUEST_CONTROL_INFO, null, new byte[] {0x41,0x03});
	}

	public static void sendOrder(byte comID, String sendValue, byte... byteData) {
		SerialManager mSerialManager = SerialManager.getInstance();
		ComBean mComBean = ComBean.createComBean(comID, sendValue, byteData);
		mSerialManager.onSendCom(mComBean);
	}
	
}
