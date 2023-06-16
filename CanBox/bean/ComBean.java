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
 * ָ���װ
 * @author LQPDC
 *
 */
public class ComBean implements Constant{
	/**
	 * �ͷ���Ҫ�ӹ���������͵�ָ������
	 */
	public boolean needPackage = true;
	/**
	 * ָ��ID
	 */
	public byte comID;
	/**
	 * �������飨���needPackageΪtrueʱ����Ϊ�������������;
	 * ���needPackageΪfalse����Ϊһ��������ָ�����飩
	 */
	public byte[] dataBytes;
	/**
	 * ������ˮ�ţ�������
	 */
	public long roleSerial;
	/**
	 * ����ID��������
	 */
	public String roleID;
	
	/**
	 * ����ַ������ֽ����鶼�����ݣ��ȴ��ֽ����������
	 * @param comID ָ��ID
	 * @param sendValue Ҫ���͵��ַ���
	 * @param byteData Ҫ���͵�Byte
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
