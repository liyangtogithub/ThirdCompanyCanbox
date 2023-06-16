package com.landsem.canboxui.utils;

import android.app.StatusBarManager;
import android.content.Context;

public class CommonUtil {
	/**
	 *´ò¶ÏÆÁ±£
	 */
	public static void stopScreenProtect(Context mContext) {
		StatusBarManager sb = new StatusBarManager(mContext);
		sb.notifySystemUiTurnOnScreen();
	}


}
