package com.landsem.canbox.pack;

public interface BytePack {
	/**
	 * @param dataBytes
	 * @param comID
	 * @return
	 */
	byte[] onCreateOrderBytes(byte[] dataBytes, byte comID);
	/**
	 * 
	 * @param byteArray 完整命令数组 （默认由：起始帧1+起始帧2+数据长度+ComID+数据+校验码）
	 * @param dataLength 数据长度
	 * @param comID
	 * @return 命令数组
	 */
	byte[] initStartBytes(byte[] byteArray, byte dataLength, byte comID);
	/**
	 * 
	 * @param byteArray 完整命令数组 （默认由：起始帧1+起始帧2+数据长度+ComID+数据+校验码）
	 * @param dataBytes 数据数组
	 * @return 命令数组
	 */
	byte[] initOrderBody(byte[] byteArray, byte[] dataArray);
	/**
	 * 
	 * @param byteArray 完整命令数组 （默认由：起始帧1+起始帧2+数据长度+ComID+数据+校验码）
	 * @param dataBytes 数据数组
	 * @param comID
	 * @return 命令数组
	 */
	byte[] initCheckCode(byte[] byteArray, byte[] dataBytes, byte comID);
	/**
	 * 
	 * @param dataBytes 数据数组
	 * @param comID 命令ID
	 * @return 返回指令校验码
	 */
	byte getCheckBytes(byte[] dataBytes, byte comID);

}
