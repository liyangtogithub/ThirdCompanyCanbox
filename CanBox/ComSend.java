package com.landsem.canbox;

import com.landsem.canbox.bean.ComBean;

public interface ComSend extends Protocol {
	/**
	 * ������Э��з���ָ��
	 * @param mComBean
	 */
	void onSendCom(ComBean mComBean);

}
