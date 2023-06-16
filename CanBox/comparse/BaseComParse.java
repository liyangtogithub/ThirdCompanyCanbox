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
	 * 校验基码 sum & checkCode;
	 */
	protected byte checkCode = (byte) 0xFF;
	/**
	 * 起始帧1
	 */
	protected byte comStartByte1;
	/**
	 * 起始帧2
	 */
	protected byte comStartByte2;
	
	protected SerialReadManager serialReadManager;
	/**
	 * 缓存Bytes
	 */
	protected List<Byte> cacheBytes = new ArrayList<Byte>();
	/**
	 * 缓存Bytes 安盛
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
	 * 处理串口接收得到的Byte数组
	 * 与上一条不完整命令进行拼接
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
	 * 根据协议检测指令是否完整
	 * 此处默认为协议的byte0为起始帧1，byte1为起始帧2。byte2为数据个数
	 * 算法为byte2到byte[byte.length-2]各与上0XFF再与byte[byte.length-1]比较
	 * @param orderBytes
	 * @return
	 */
	@Override
	public boolean onCheckBytesValidity(Byte[] orderBytes) {
		//一定要复写此方法
		boolean resultCode = false;
		return resultCode;
	}
	
	/**
	 * 处理缓存的Bytes
	 * @param orderBytes 需处理的Byte数组
	 * @param clearCache 是否没空 cache
	 */
	@Override
	public void onOrderByteArray(Byte[] orderBytes, boolean clearCache) {
		ByteUtil.onPrintByteArray(orderBytes, "onOrderByteArray orderBytes:");//打印
		boolean comValid = onCheckBytesValidity(orderBytes);
		//清空 1如果校验成功;2多次校验失败，导致数据积累太多;3规定长度小于实际长度
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
		//如果校验成功，或者多次校验失败，导致数据积累太多，都要清空
		if(clearCache || comValid|| (orderBytes.length>50) ) cacheBytesAnSheng.clear();
		if(comValid && null!=serialReadManager){
//			serialReadManager.doHandleByteArray(orderBytes, true);
			List<BaseInfo> infoBeans = doParseOrderBytes(orderBytes);
			serialReadManager.doHandleByteArray(infoBeans, true);
		}
	}
	
}
