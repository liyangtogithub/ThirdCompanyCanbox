package com.landsem.canbox;

public interface Protocol extends Constant{
	
	/**
	 * 
	 * @param PID Э��ID
	 * ÿЭ���Ӧһ����ͬ��Э��ID
	 * Ӧ������һ���µ�CanBoxЭ��ʱ��Ҫʵ���Լ���Э�������,ʵ��CanBox���������ƴ�Ӵ������
	 * �������һ��Э��ID
	 * @throws Exception 
	 */
	void onCutDataProtocol(ProtocolID PID) throws Exception;

}
