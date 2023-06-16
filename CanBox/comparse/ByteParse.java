package com.landsem.canbox.comparse;

import java.util.List;

import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.BaseInfo;

public interface ByteParse extends Constant {
	
	/**
	 * 处理从串口读取到的数据
	 * @param byteArray
	 */
	void onReceiveBytes(byte[] byteArray);
	/**
	 * 检测ByteArray是否是一条完整指令
	 * @param byteArray
	 * @return
	 */
	boolean onCheckBytesValidity(Byte[] orderArray);
	
	/**
	 * 处理缓存的ByteArray
	 * @param orderBytes 
	 * @param clearCache 是否清空Cache
	 */
	void onOrderByteArray(Byte[] orderBytes, boolean clearCache);
	
	/**
	 * 解析指令Bytes
	 * @param intackBytes 完整指令的Byte数组
	 * 根据协议解析些数组得到相关的空调、雷达等信息
	 */
	List<BaseInfo> doParseOrderBytes(Byte[] intackBytes);
	
	/**
	 * 通过BaseCom封闭成指令
	 * @param mBaseCom
	 */
//	void doPackOrderBytes(BaseBean mBaseCom);
	

}
