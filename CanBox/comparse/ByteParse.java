package com.landsem.canbox.comparse;

import java.util.List;

import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.BaseInfo;

public interface ByteParse extends Constant {
	
	/**
	 * ����Ӵ��ڶ�ȡ��������
	 * @param byteArray
	 */
	void onReceiveBytes(byte[] byteArray);
	/**
	 * ���ByteArray�Ƿ���һ������ָ��
	 * @param byteArray
	 * @return
	 */
	boolean onCheckBytesValidity(Byte[] orderArray);
	
	/**
	 * �������ByteArray
	 * @param orderBytes 
	 * @param clearCache �Ƿ����Cache
	 */
	void onOrderByteArray(Byte[] orderBytes, boolean clearCache);
	
	/**
	 * ����ָ��Bytes
	 * @param intackBytes ����ָ���Byte����
	 * ����Э�����Щ����õ���صĿյ����״����Ϣ
	 */
	List<BaseInfo> doParseOrderBytes(Byte[] intackBytes);
	
	/**
	 * ͨ��BaseCom��ճ�ָ��
	 * @param mBaseCom
	 */
//	void doPackOrderBytes(BaseBean mBaseCom);
	

}
