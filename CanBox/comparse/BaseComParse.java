package com.landsem.canbox.comparse;

import java.util.ArrayList;
import java.util.List;

import com.landsem.canbox.CanBoxApp;
import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.manager.SerialReadManager;
import com.landsem.canbox.pack.SimpleBaseComPack;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.canbox.tools.ProtocoChoicelUtils;
import com.landsem.common.tools.ListUtils;
import com.landsem.common.tools.LogManager;

import android.annotation.SuppressLint;

@SuppressLint("HandlerLeak")
public abstract class BaseComParse implements ByteParse{
	/**
	 * У����� sum & checkCode;
	 */
	protected byte checkCode = (byte) 0xFF;
	/**
	 * ��ʼ֡1
	 */
	protected byte comStartByte1;
	/**
	 * ��ʼ֡2
	 */
	protected byte comStartByte2;
	
	protected SerialReadManager serialReadManager;
	/**
	 * ����Bytes
	 */
	protected List<Byte> cacheBytes = new ArrayList<Byte>();
	/**
	 * ����Bytes ��ʢ
	 */
	protected List<Byte> cacheBytesAnSheng = new ArrayList<Byte>();
	
	public BaseComParse() {
		super();
	}

	public BaseComParse(byte checkCode, byte comStartByte1, byte comStartByte2) {
		super();
		this.checkCode = checkCode;
		this.comStartByte1 = comStartByte1;
		this.comStartByte2 = comStartByte2;
	}
	
	public void setSerialReadManager(SerialReadManager serialReadManager) {
		this.serialReadManager = serialReadManager;
	}

	/**
	 * �����ڽ��յõ���Byte����
	 * ����һ���������������ƴ��
	 * @param byteArray
	 */
	@Override
	public void onReceiveBytes(byte[] byteArray) {
		if(null!=byteArray && 0!=byteArray.length){
			if(!ListUtils.isEmpty(cacheBytes)){
				byte startByte1 = cacheBytes.get(0);
				if(comStartByte1!=startByte1) cacheBytes.clear();
			}
			for(int index=0;index<byteArray.length;index++){
				byte byteValue = byteArray[index];
				if(byteValue==comStartByte1){
					int nextIndex = index + 1;
					if(nextIndex<byteArray.length){
						byte nextValue = byteArray[nextIndex];
						if(nextValue==comStartByte2){
							LogManager.d("data head ok");
							onHandleCacheBytes();
						}
					}else{
						onHandleCacheBytes();
					}
				}
				cacheBytes.add(byteValue);
			}
			onHandleCacheBytes();
		}
	}
	public void onReceiveBytesAnSheng(byte[] byteArray) {
		if(null!=byteArray && 0!=byteArray.length){
			if(!ListUtils.isEmpty(cacheBytesAnSheng)){
				byte startByte1 = cacheBytesAnSheng.get(0);
				if(comStartByte1!=startByte1) cacheBytesAnSheng.clear();
			}
			for(int index=0;index<byteArray.length;index++){
				byte byteValue = byteArray[index];
				if(byteValue==comStartByte1){
					int nextIndex = index + 1;
					if(nextIndex<byteArray.length){
						byte nextValue = byteArray[nextIndex];
						if(nextValue==comStartByte2){
							LogManager.d("an sheng data head ok");
							onHandleCacheBytesAnSheng();
						}
					}else{
						onHandleCacheBytesAnSheng();
					}
				}
				cacheBytesAnSheng.add(byteValue);
			}
			onHandleCacheBytesAnSheng();
		}
	}

	private void onHandleCacheBytes() {
		Byte[] orderArray = null;
		if(!ListUtils.isEmpty(cacheBytes)){
			orderArray = new Byte[cacheBytes.size()];
			orderArray = cacheBytes.toArray(orderArray);
			onOrderByteArray(orderArray, false);
		}
	}
	private void onHandleCacheBytesAnSheng() {
		Byte[] orderArray = null;
		if(!ListUtils.isEmpty(cacheBytesAnSheng)){
			orderArray = new Byte[cacheBytesAnSheng.size()];
			orderArray = cacheBytesAnSheng.toArray(orderArray);
			onOrderByteArrayAnSheng(orderArray, false);
		}
	}
	
	/**
	 * ����Э����ָ���Ƿ�����
	 * �˴�Ĭ��ΪЭ���byte0Ϊ��ʼ֡1��byte1Ϊ��ʼ֡2��byte2Ϊ���ݸ���
	 * �㷨Ϊbyte2��byte[byte.length-2]������0XFF����byte[byte.length-1]�Ƚ�
	 * @param orderBytes
	 * @return
	 */
	@Override
	public boolean onCheckBytesValidity(Byte[] orderBytes) {
		//һ��Ҫ��д�˷���
		boolean resultCode = false;
		return resultCode;
	}
	
	/**
	 * �������Bytes
	 * @param orderBytes �账���Byte����
	 * @param clearCache �Ƿ�û�� cache
	 */
	@Override
	public void onOrderByteArray(Byte[] orderBytes, boolean clearCache) {
		ByteUtil.onPrintByteArray(orderBytes, "onOrderByteArray orderBytes:");//��ӡ
		boolean comValid = onCheckBytesValidity(orderBytes);
		//��� 1���У��ɹ�;2���У��ʧ�ܣ��������ݻ���̫��;3�涨����С��ʵ�ʳ���
		if(clearCache || comValid|| (orderBytes.length>50)){ 
			cacheBytes.clear();
		}else if (orderBytes.length>Constant.LENGTH_XINPU && (orderBytes[Constant.LENGTH_XINPU]<(cacheBytes.size()-5)) ) {
				LogManager.d("LENGTH ERROR");
				cacheBytes.clear();
		} 
		if(comValid && null!=serialReadManager){
//			serialReadManager.doHandleByteArray(orderBytes, true);
			List<BaseInfo> infoBeans = doParseOrderBytes(orderBytes);
			serialReadManager.doHandleByteArray(infoBeans, true);
		}
		
	}
	public void onOrderByteArrayAnSheng(Byte[] orderBytes, boolean clearCache) {
		boolean comValid = onCheckBytesValidity(orderBytes);
		//���У��ɹ������߶��У��ʧ�ܣ��������ݻ���̫�࣬��Ҫ���
		if(clearCache || comValid|| (orderBytes.length>50) ) cacheBytesAnSheng.clear();
		if(comValid && null!=serialReadManager){
//			serialReadManager.doHandleByteArray(orderBytes, true);
			List<BaseInfo> infoBeans = doParseOrderBytes(orderBytes);
			serialReadManager.doHandleByteArray(infoBeans, true);
		}
	}
	
}
