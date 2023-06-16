package com.landsem.canbox.pack.simple;

import com.landsem.canbox.Constant.SimpleDasAutoID.SendComID1;
import com.landsem.canbox.bean.ComBean;
import com.landsem.canbox.manager.SerialManager;
import com.landsem.canbox.pack.SimpleBaseComPack;


public class FocusPack extends SimpleBaseComPack   {
	/**
	 * �������_����˹
	 * (DVD����->Э���)
	 */
	public FocusPack() {
		super((byte) 0xFF, (byte) 0x2e);
	}
	
	static FocusPack mDasAuto1Pack;
	
	public static FocusPack getInstance(){
		if (mDasAuto1Pack==null) {
			mDasAuto1Pack = new FocusPack();
		}
		return mDasAuto1Pack;
	}
	
	/***��ʼ*/
	public static void startOrder() {
		sendOrder((byte)SendComID1.SEND_START_ORDER, null, new byte[] {0x01});
	}
	/***��ѯ������Ϣ*/
	public static void askCarInfoOrder() {
		sendOrder((byte)SendComID1.REQUEST_CONTROL_INFO, null, new byte[] {0x29,0x02});
	}

	public static void sendOrder(byte comID, String sendValue, byte... byteData) {
		SerialManager mSerialManager = SerialManager.getInstance();
		ComBean mComBean = ComBean.createComBean(comID, sendValue, byteData);
		mSerialManager.onSendCom(mComBean);
	}
	
}
