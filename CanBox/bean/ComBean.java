package com.landsem.canbox.bean;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.landsem.canbox.Constant;
import com.landsem.common.tools.LogManager;
import com.landsem.common.tools.StringUtils;
/**
 * 指令封装
 * @author LQPDC
 *
 */
public class ComBean implements Constant{
	/**
	 * 就否需要加工处理待发送的指令数组
	 */
	public boolean needPackage = true;
	/**
	 * 指令ID
	 */
	public byte comID;
	/**
	 * 数据数组（如果needPackage为true时，其为纯粹的数据数组;
	 * 如果needPackage为false，其为一个完整的指令数组）
	 */
	public byte[] dataBytes;
	/**
	 * 发送流水号（保留）
	 */
	public long roleSerial;
	/**
	 * 发送ID（保留）
	 */
	public String roleID;
	
	/**
	 * 如果字符串和字节数组都有数据，先存字节数组的数据
	 * @param comID 指令ID
	 * @param sendValue 要发送的字符串
	 * @param byteData 要发送的Byte
	 * @return
	 */
	public static ComBean createComBean(byte comID, String sendValue, byte ...byteData) {
		ComBean mComBean = new ComBean();
		mComBean.comID = comID;
		byte[] byteArray = null;
		List<Byte>  byteList = new ArrayList<Byte>();
		if(null!=byteData && 0!=byteData.length){
			byteArray = new byte[byteData.length];
			
			for(int index=0;index<byteData.length;index++){
				byteList.add(byteData[index]);
			}
		}
		if (!StringUtils.isBlank(sendValue)) {
			char[] array = sendValue.toCharArray();
			for (int i = 0; i < array.length; i++) {
				byte ascii = (byte) array[i];
				byteList.add(ascii);
			}
		}
		if(null!=byteList){
			int size = byteList.size();
			byteArray = new byte[byteList.size()];
			for(int index=0;index<size;index++){
				byteArray[index] = byteList.get(index);
			}
		}
		mComBean.dataBytes = byteArray;
		return mComBean;
		
	}
	
}
