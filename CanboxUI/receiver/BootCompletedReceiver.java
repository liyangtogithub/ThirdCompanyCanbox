package com.landsem.canboxui.receiver;

import com.landsem.common.tools.LogManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootCompletedReceiver extends BroadcastReceiver  {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		LogManager.d( "onReceiver: "+action);
	}

}
