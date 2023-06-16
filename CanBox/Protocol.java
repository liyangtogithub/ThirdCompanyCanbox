package com.landsem.canbox;

public interface Protocol extends Constant{
	
	/**
	 * 
	 * @param PID 协议ID
	 * 每协议对应一个不同的协议ID
	 * 应用增加一套新的CanBox协议时，要实现自己的协议解析器,实现CanBox发送命令的拼接打包器，
	 * 还得添加一个协议ID
	 * @throws Exception 
	 */
	void onCutDataProtocol(ProtocolID PID) throws Exception;

}
