package com.landsem.canbox;

import android.content.Context;
import android.content.Intent;

import com.landsem.canbox.manager.SerialManager;
import com.landsem.canbox.tools.ProtocoChoicelUtils;
import com.landsem.common.app.App;
import com.landsem.common.tools.LogManager;
import com.landsem.common.tools.StringUtils;

public class CanBoxApp extends App {
	
	private static Context instance;
	public  static ProtocolID mPID = null;

	@Override
	public void onCreate() {
		super.onCreate();
		LogManager.d("CanBoxApp  onCreate");
		instance = getApplicationContext();
		SerialManager.getInstance();
		mPID = getProtocolID();
		//弹提示框用的
		startService(new Intent("com.landsem.canboxui.DialogService"));
		//CD
		startService(new Intent("com.landsem.canboxui.CdService"));
		//推小屏
		startService(new Intent("com.landsem.canboxui.PushService"));
	}

	public static Context getMyContext() {
		return instance;
	}
	
	public static ProtocolID getProtocolID() {
		String protocoName = ProtocoChoicelUtils.getProtocoName();
		if (!StringUtils.isBlank(protocoName)) {
			mPID = ProtocolID.valueOf(protocoName);
		}
		return mPID;
	}
	
	public static ProtocolID getMyPID() {
		return mPID;
	}

}
