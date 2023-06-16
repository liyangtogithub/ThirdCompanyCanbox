package com.landsem.canbox.manager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.landsem.canbox.Protocol;
import com.landsem.canbox.ProtocolID;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.comparse.BaseComParse;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.ListUtils;
import com.landsem.common.tools.LogManager;
import com.merlin.lib.serialport.SerialPort;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/**
 * read串口数据
 * @author LQPDC
 *
 */
@SuppressLint("HandlerLeak")
public class SerialReadManager implements Protocol {
	
	private static final String TAG = SerialReadManager.class.getSimpleName();
	
	protected Object handlerLock = new Object();
	
	protected Object readLock = new Object();
	protected Object readLockAnSheng = new Object();

	private ProtocolID PID;
	
	private boolean isContiue;
	private boolean isContiueAnSheng;
	
	private boolean isRunning;
	private boolean isRunningAnSheng;
	
	protected Thread mParseThread;
	
	private InputStream inputStream; 
	private InputStream  inputStreamAnSheng;
	
	private BaseComParse mBaseComParse;
	
	protected ParseHandler mParseHandler;
	
	private PushInfoManager mPushInfoManager;
	
	private SerialReadHandler mSerialReadHandler;
	private SerialReadHandlerAnSheng mSerialReadHandlerAnSheng;
	
	private ByteArrayOutputStream mByteArrayOutputStream;
	private ByteArrayOutputStream mByteArrayOutputStreamAnSheng;
	
	/**
	 * read串口数据，准备好读线程
	 * @author LQPDC
	 *
	 */
	public SerialReadManager(PushInfoManager mPushInfoManager){
		this.mPushInfoManager = mPushInfoManager;
		onInitParseerLooper();
		Runnable mRunnable = new SerialReadRunnable();
		new Thread(mRunnable).start();
		Runnable mRunnableAnSheng = new SerialReadRunnableAnSheng();
		new Thread(mRunnableAnSheng).start();
	}
	
	public void onInjectStream(InputStream inputStream){
		if(isContiue) isContiue = false;
		this.inputStream = inputStream;
		isContiue = null!=inputStream;
		doStartSerialReader();
	}
	public void onInjectStreamAnSheng(InputStream inputStreamAnSheng){
		if(isContiueAnSheng) isContiueAnSheng = false;
		this.inputStreamAnSheng = inputStreamAnSheng;
		isContiueAnSheng = null!=inputStreamAnSheng;
		doStartSerialReaderAnSheng();
	}
	
	/**
	 *实例化读解析器
	 */
	@Override
	public void onCutDataProtocol(ProtocolID nextPID) throws Exception {
		if(PID==nextPID) return;
		@SuppressWarnings("rawtypes")
		String className = nextPID.getParseClassName();
		mBaseComParse = (BaseComParse)(Class.forName(className).newInstance());
		mBaseComParse.setSerialReadManager(this);
		PID = nextPID;
	}
	
	public void doHandleByteArray(List<BaseInfo> infoBeans , boolean isAsync) {
		synchronized (handlerLock) {
			boolean isInvalidHandler = null==mParseHandler;
			if(!isAsync || isInvalidHandler){
				//onParsePushInfo(orderBytes);
			}else{
				Message msg = mParseHandler.obtainMessage();
				msg.obj = infoBeans;
				mParseHandler.sendMessage(msg);
			}
		}
	}
	
	private void doStartSerialReader(){
		if(null!=mSerialReadHandler && isContiue){
			Message msg = mSerialReadHandler.obtainMessage();
			mSerialReadHandler.sendMessage(msg);
		}
	}
	private void doStartSerialReaderAnSheng(){
		if(null!=mSerialReadHandlerAnSheng && isContiueAnSheng){
			Message msg = mSerialReadHandlerAnSheng.obtainMessage();
			mSerialReadHandlerAnSheng.sendMessage(msg);
		}
	}
	private void onSerialRead(){
		synchronized (readLock) {
			if(isRunning) return;
			while (isContiue && null!=inputStream) {
				try {
					isRunning = true;
					byte[] buffer = new byte[1024];
					int length = FILE_END;
					if(null!=inputStream) length = inputStream.read(buffer);
					LogManager.d(" onSerialRead() length  "+length);
					if (FILE_END==length) break;
					mByteArrayOutputStream = new ByteArrayOutputStream();
					mByteArrayOutputStream.write(buffer, 0, length);
					byte[] byteArray = mByteArrayOutputStream.toByteArray();
	//				String gpsValue = new String(byteArray);
	//				LogManager.d(TAG, "gpsValue  :"+gpsValue);
					ByteUtil.onPrintByteArray(byteArray, "onSerialRead byteArray:");//打印
					if(null!=mBaseComParse) mBaseComParse.onReceiveBytes(byteArray);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			isRunning = false;
		}
	}
	private void onSerialReadAnSheng(){
		synchronized (readLockAnSheng) {
			if(isRunningAnSheng) return;
			while (isContiueAnSheng && null!=inputStreamAnSheng) {
				try {
					isRunningAnSheng = true;
					byte[] buffer = new byte[1024];
					int length = FILE_END;
					if(null!=inputStreamAnSheng) length = inputStreamAnSheng.read(buffer);
					LogManager.d(" onSerialReadAnSheng() length  "+length);
					if (FILE_END==length) break;
					mByteArrayOutputStreamAnSheng = new ByteArrayOutputStream();
					mByteArrayOutputStreamAnSheng.write(buffer, 0, length);
					byte[] byteArray = mByteArrayOutputStreamAnSheng.toByteArray();
	//				String gpsValue = new String(byteArray);
	//				LogManager.d(TAG, "gpsValue  :"+gpsValue);
					if(null!=mBaseComParse) mBaseComParse.onReceiveBytesAnSheng(byteArray);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			isRunningAnSheng = false;
		}
	}
	
//	private void onFreeParseerLooper() {
//		synchronized (handlerLock) {
//			if(null!=mParseThread){
//				mParseThread.stop();
//				if(null!=mParseHandler) mParseHandler = null;
//				mParseThread = null;
//			}
//		}
//	}
	/**
	 *非Activity的布局，获得协议盒数据，与 com.landsem.canbox.manager.
	 *SerialManager.onSetRadarObserver(RadarObserver mObserver, RoleBean mRoleBean)以下的方法，相对应
	 */
	private void onInitParseerLooper() {
		synchronized (handlerLock) {
			ParseRunnable mParseRunnable = new ParseRunnable();
			mParseThread = new Thread(mParseRunnable);
			mParseThread.start();
		}
	}
	
	public void onParsePushInfo(List<BaseInfo> infoBeans){
	//	List<BaseInfo> infoBeans = mBaseComParse.doParseOrderBytes(orderBytes);
		if(null!=infoBeans && !ListUtils.isEmpty(infoBeans)){
			for(BaseInfo infoBean:infoBeans){
				if(null!=infoBean && null!=mPushInfoManager){
					mPushInfoManager.onHandleBaseInfo(infoBean);
				}
			}
		}
	}
	
	
	private final class SerialReadHandler extends Handler{
		@Override
		public synchronized void handleMessage(Message msg) {
				onSerialRead();
			super.handleMessage(msg);
		}
	}
	private final class SerialReadHandlerAnSheng extends Handler{
		@Override
		public synchronized void handleMessage(Message msg) {
				onSerialReadAnSheng();
			super.handleMessage(msg);
		}
	}
	
	//读取串口数据子线程
	private final class SerialReadRunnable implements Runnable{
		@Override
		public void run() {
			Looper.prepare();
			mSerialReadHandler = new SerialReadHandler();
			doStartSerialReader();
			Looper.loop();
		}
	}
	private final class SerialReadRunnableAnSheng implements Runnable{
		@Override
		public void run() {
			Looper.prepare();
			mSerialReadHandlerAnSheng = new SerialReadHandlerAnSheng();
			doStartSerialReaderAnSheng();
			Looper.loop();
		}
	}
	
	private final class ParseHandler extends Handler{
		
		@Override
		public synchronized void handleMessage(Message msg) {
			try {
				Object obj = msg.obj;
				if(null!=obj){
					List<BaseInfo> infoBeans  = (List<BaseInfo>) obj;
					onParsePushInfo(infoBeans);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			super.handleMessage(msg);
		}
		
	}
	
	private final class ParseRunnable implements Runnable{
		
		@Override
		public void run() {
			Looper.prepare();
			mParseHandler = new ParseHandler();
			Looper.loop();
		}
		
	}


}
