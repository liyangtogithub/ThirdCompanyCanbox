package com.landsem.canbox;

import com.landsem.canbox.bean.ComBean;

public interface ComSend extends Protocol {
	/**
	 * 机器向协议盒发送指令
	 * @param mComBean
	 */
	void onSendCom(ComBean mComBean);

}
