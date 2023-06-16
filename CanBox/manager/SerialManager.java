package com.landsem.canbox.manager;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.landsem.canbox.AddSelfObserver;
import com.landsem.canbox.ComSend;
import com.landsem.canbox.ProtocolID;
import com.landsem.canbox.bean.ComBean;
import com.landsem.canbox.bean.RoleBean;
import com.landsem.canbox.observer.AirConditionObserver;
import com.landsem.canbox.observer.AnJiXingInfoObserver;
import com.landsem.canbox.observer.BaseObserver;
import com.landsem.canbox.observer.CDObserver;
import com.landsem.canbox.observer.CarBaseObserver;
import com.landsem.canbox.observer.CarLargeObserver;
import com.landsem.canbox.observer.CornerObserver;
import com.landsem.canbox.observer.DoorObserver;
import com.landsem.canbox.observer.DriveModeObserver;
import com.landsem.canbox.observer.DriverAssistObserver;
import com.landsem.canbox.observer.KeyFunctionObserver;
import com.landsem.canbox.observer.SpeedObserver;
import com.landsem.canbox.observer.MultiFuncObserver;
import com.landsem.canbox.observer.PeripheralObserver;
import com.landsem.canbox.observer.RadarObserver;
import com.landsem.canbox.observer.SetInfoObserver;
import com.landsem.canbox.observer.SyncInfoObserver;
import com.landsem.canbox.observer.UnitTimeObserver;
import com.landsem.canbox.tools.ProtocoChoicelUtils;
import com.landsem.common.tools.LogManager;
import com.landsem.common.tools.StringUtils;
import com.merlin.lib.serialport.SerialPort;

public class SerialManager implements ComSend, AddSelfObserver {

	private static SerialManager instance;

	private ProtocolID mPID = ProtocolID.ID_SIMPLE_TOYOT1;

	private FileDescriptor mFileDescriptor;
	private FileDescriptor mFileDescriptorAnSheng;

	private PushInfoManager mPushInfoManager;

	private SerialPort serialPort;
	private SerialPort serialPortAnSheng;
	
	private SerialReadManager mSerialReadManager;

	private SerialSendManager mSerialSendManager;

	public static SerialManager getInstance() {
		if (null == instance) {
			synchronized (SerialManager.class) {
				if (null == instance) {
					instance = new SerialManager();
				}
			}
		}
		return instance;
	}
	/**
	 *准备好和底层通信的线程，若串口一打开并且输入输出流已获取到，线程就开始读串口操作
	 */
	private SerialManager() {
		mPushInfoManager = new PushInfoManager();
		mSerialReadManager = new SerialReadManager(mPushInfoManager);
		mSerialSendManager = new SerialSendManager();
		onCutDataProtocol(checkOutPID());
	}
	/**
	 *切换协议盒时，使用
	 */
	@Override
	public void onCutDataProtocol(ProtocolID PID) {
		if (null == PID)
			return;
		try {
			LogManager.d("serialPort "+serialPort);
			if (null != serialPort) {
				serialPort.onCloseSerialPort();
			}
			onInitStream(null, null);
			onInitStreamAnSheng(null);
			//打开底层串口
			onOpenSerialPort(PID);
			onOpenSerialPortAnSheng(PID);
			//准备app的读写器
			if (null != mSerialReadManager)
				mSerialReadManager.onCutDataProtocol(PID);
			if (null != mSerialSendManager)
				mSerialSendManager.onCutDataProtocol(PID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void onInitStream(InputStream inputStream, OutputStream outputStream) {
		if(null != mSerialReadManager) mSerialReadManager.onInjectStream(inputStream);
		if(null != mSerialSendManager) mSerialSendManager.onInjectStream(outputStream);
	}
	private void onInitStreamAnSheng(InputStream inputStreamAnSheng) {
		if(null != mSerialReadManager) mSerialReadManager.onInjectStreamAnSheng(inputStreamAnSheng);
	}
	/**
	 *向协议盒发送数据的方法
	 */
	@Override
	public void onSendCom(ComBean mComBean) {
		if (null != mSerialSendManager)
			mSerialSendManager.onSendCom(mComBean);
	}
	/**
	 *获取协议类型
	 */
	private ProtocolID checkOutPID() {
		//协议名称
		String protocoName = ProtocoChoicelUtils.getProtocoName();
		if ( !StringUtils.isBlank(protocoName) ) {
			mPID = ProtocolID.valueOf(protocoName);
		}
		return mPID;
	}
	/**
	 * 和SerialManager()方法 相对应
	 *打开底层串口，获取输入、输出流；若和底层通信的线程准备好，口操作
	 */
	private boolean onOpenSerialPort(ProtocolID PID) {
		if (null != PID && !StringUtils.isBlank(SerialPort.serialPortDevice)) {
			File file = new File(SerialPort.serialPortDevice);
			/* Check access permission */
			onChmodFile(file);
			serialPort = new SerialPort();
			mFileDescriptor = serialPort.onOpenSerialPort(SerialPort.serialPortDevice,PID.getBaudRate());
			if (null != mFileDescriptor) {
				InputStream inputStream = new FileInputStream(mFileDescriptor);
				OutputStream outputStream = new FileOutputStream(mFileDescriptor);
//				mSerialReadManager.onInjectStream(inputStream);
//				mSerialSendManager.onInjectStream(outputStream);
				onInitStream(inputStream, outputStream);
				return true;
			}
		}
		return false;
	}
	
	private boolean onOpenSerialPortAnSheng(ProtocolID PID) {
		if (null != PID && !StringUtils.isBlank(SerialPort.serialPortDeviceAnSheng)) {
			File file = new File(SerialPort.serialPortDeviceAnSheng);
			/* Check access permission */
			onChmodFile(file);
			serialPortAnSheng = new SerialPort();
			mFileDescriptorAnSheng = serialPortAnSheng.onOpenSerialPort(SerialPort.serialPortDeviceAnSheng,PID.getBaudRate());
			if ( null != mFileDescriptorAnSheng) {
				InputStream inputStreamAnSheng = new FileInputStream(mFileDescriptorAnSheng);
				onInitStreamAnSheng(inputStreamAnSheng);
				return true;
			}
		}
		return false;
	}

	private void onChmodFile(File file) {
		if (!file.canRead() || !file.canWrite()) {
			try {
				/* Missing read/write permission, trying to chmod the file */
				Process su = Runtime.getRuntime().exec("/system/bin/su");
				String cmd = "chmod 666 " + file.getAbsolutePath() + "\n"
						+ "exit\n";
				su.getOutputStream().write(cmd.getBytes());
				if ((su.waitFor() != 0) || !file.canRead() || !file.canWrite()) {
					throw new SecurityException();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 *非Activity的布局，注册下面的监听，获得协议盒数据
	 */
	@Override
	public void onSetRadarObserver(RadarObserver mObserver, RoleBean mRoleBean) {

		if (null != mPushInfoManager)
			mPushInfoManager.onSetRadarObserver(mObserver, mRoleBean);
	}

	@Override
	public void onSetDoorObserver(DoorObserver mObserver, RoleBean mRoleBean) {

		if (null != mPushInfoManager)
			mPushInfoManager.onSetDoorObserver(mObserver, mRoleBean);
	}

	@Override
	public void onSetCornerObserver(CornerObserver mObserver, RoleBean mRoleBean) {
		if (null != mPushInfoManager)
			mPushInfoManager.onSetCornerObserver(mObserver, mRoleBean);
	}

	@Override
	public void onSetCarBaseObserver(CarBaseObserver mObserver,
			RoleBean mRoleBean) {
		if (null != mPushInfoManager)
			mPushInfoManager.onSetCarBaseObserver(mObserver, mRoleBean);
	}

	@Override
	public void onSetCarLargeObserver(CarLargeObserver mObserver,
			RoleBean mRoleBean) {
		if (null != mPushInfoManager)
			mPushInfoManager.onSetCarLargeObserver(mObserver, mRoleBean);
	}

	@Override
	public void onSetAirConditionObserver(AirConditionObserver mObserver,
			RoleBean mRoleBean) {
		if (null != mPushInfoManager)
			mPushInfoManager.onSetAirConditionObserver(mObserver, mRoleBean);
	}

	@Override
	public void onSetDriverAssistObserver(DriverAssistObserver mObserver,
			RoleBean mRoleBean) {
		if (null != mPushInfoManager)
			mPushInfoManager.onSetDriverAssistObserver(mObserver, mRoleBean);
	}
	
	@Override
	public void onSetBaseInfoObserver(BaseObserver mObserver, RoleBean mRoleBean) {
		if (null != mPushInfoManager)
			mPushInfoManager.onSetBaseInfoObserver(mObserver, mRoleBean);
	}
	@Override
	public void onSetPeripheralObserver(PeripheralObserver mPeripheralObserver,
			RoleBean mRoleBean) {
		if (null != mPushInfoManager)
			mPushInfoManager.onSetPeripheralObserver(mPeripheralObserver, mRoleBean);
	}
	@Override
	public void onSetDriveModeObserver(DriveModeObserver mDriveModeObserver,RoleBean mRoleBean) {
		if (null != mPushInfoManager)
			mPushInfoManager.onSetDriveModeObserver(mDriveModeObserver, mRoleBean);
	}
	@Override
	public void onSetSpeedObserver(SpeedObserver mSpeedObserver, RoleBean mRoleBean) {
		if (null != mPushInfoManager)
			mPushInfoManager.onSetSpeedObserver(mSpeedObserver, mRoleBean);
	}
	@Override
	public void onSetMultiFuncObserver(MultiFuncObserver mMultiFuncObserver,RoleBean mRoleBean) {
		if (null != mPushInfoManager)
			mPushInfoManager.onSetMultiFuncObserver(mMultiFuncObserver, mRoleBean);
	}
	@Override
	public void onSetUnitTimeObserver(UnitTimeObserver mUnitTimeObserver,RoleBean mRoleBean) {
		if (null != mPushInfoManager)
			mPushInfoManager.onSetUnitTimeObserver(mUnitTimeObserver, mRoleBean);		
	}
	@Override
	public void onSetInfoObserver(SetInfoObserver mSetInfoObserver,RoleBean mRoleBean) {
		if (null != mPushInfoManager)
			mPushInfoManager.onSetInfoObserver(mSetInfoObserver, mRoleBean);	
	}
	@Override
	public void onSyncInfoObserver(SyncInfoObserver mSyncInfoObserver,RoleBean mRoleBean) {
		if (null != mPushInfoManager)
			mPushInfoManager.onSyncInfoObserver(mSyncInfoObserver, mRoleBean);
	}
	@Override
	public void onAnJiXingInfoObserver(AnJiXingInfoObserver mAnJiXingInfoObserver, RoleBean mRoleBean) {
		if (null != mPushInfoManager)
			mPushInfoManager.onAnJiXingInfoObserver(mAnJiXingInfoObserver, mRoleBean);
	}
	@Override
	public void onKeyFunctionObserver(KeyFunctionObserver mKeyFunctionObserver,RoleBean mRoleBean) {
		if (null != mPushInfoManager)
			mPushInfoManager.onKeyFunctionObserver(mKeyFunctionObserver, mRoleBean);
	}
	@Override
	public void onCDObserver(CDObserver mCDObserver, RoleBean mRoleBean) {
		if (null != mPushInfoManager)
			mPushInfoManager.onCDObserver(mCDObserver, mRoleBean);
	}
	

}
