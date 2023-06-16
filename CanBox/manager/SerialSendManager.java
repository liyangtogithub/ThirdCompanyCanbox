package com.landsem.canbox.manager;

import java.io.IOException;
import java.io.OutputStream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.landsem.canbox.ComSend;
import com.landsem.canbox.ProtocolID;
import com.landsem.canbox.activity.BaseActivity;
import com.landsem.canbox.bean.ComBean;
import com.landsem.canbox.pack.BytePack;
import com.landsem.canbox.pack.HiworldBaseComPack;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;
/**
 * 向协议盒发送指令
 * @author LQPDC
 *
 */
public class SerialSendManager implements ComSend{
	
	private boolean isContiue;
	
	private ProtocolID PID;
	
	private OutputStream outputStream;
	
	private BytePack mBaseComPack;
	
	private SerialSendHandler mSerialSendHandler;
	
	
	public void onInjectStream(OutputStream outputStream){
		if(isContiue) isContiue = false;
		this.outputStream = outputStream;
		isContiue = null!=this.outputStream;
		SerialSendRunnable mSerialSendRunnable = new SerialSendRunnable();
		new Thread(mSerialSendRunnable).start();
	}
	/**
	 *实例化 写 解析器
	 */
	@Override
	public void onCutDataProtocol(ProtocolID nextPID) throws Exception {
		if(PID==nextPID) return;
		@SuppressWarnings("rawtypes")
		String className = nextPID.getPackClassName();
		mBaseComPack = (BytePack)(Class.forName(className).newInstance());
		PID = nextPID;
	
	}

	@Override
	public void onSendCom(ComBean mComBean) {
		byte[] byteArray = null;
		if(null!=mComBean){
			if(mComBean.needPackage){
				if(null!=mBaseComPack) byteArray = mBaseComPack.onCreateOrderBytes(mComBean.dataBytes, mComBean.comID);
			}else{
				byteArray = mComBean.dataBytes;
			}
		}
		if(null!=byteArray && null!=mSerialSendHandler){
			Message msg = mSerialSendHandler.obtainMessage();
			msg.obj = byteArray;
			mSerialSendHandler.sendMessage(msg);
		}
	}
	
	private void onSendCanboxCom(byte[] byteArray){
		if(null!=outputStream && null!=byteArray){
			try {
				ByteUtil.onPrintByteArray(byteArray, "onSendCanboxCom");
				outputStream.write(byteArray);
				outputStream.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	


	@SuppressLint("HandlerLeak")
	private final class SerialSendHandler extends Handler{
		@Override
		public synchronized void handleMessage(Message msg) {
			if(null!=msg.obj && msg.obj instanceof byte[]){
				byte[] byteArray = (byte[]) msg.obj;
				onSendCanboxCom(byteArray);
			}
			super.handleMessage(msg);
		}
	}
	
	/**
	 *发送串口数据子线程
	 */
	private final class SerialSendRunnable implements Runnable{
		@Override
		public void run() {
			Looper.prepare();
			mSerialSendHandler = new SerialSendHandler();
			Looper.loop();
		}
	}

}
