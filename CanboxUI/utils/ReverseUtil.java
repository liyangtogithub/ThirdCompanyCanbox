package com.landsem.canboxui.utils;

import com.ls.lseasycontrol.LSEasyControlManager;
import com.ls.lspower.LSPowerManager;
import com.ls.lspower.LSPowerManager.ReverseStatus;

import android.content.Context;

public class ReverseUtil {
	 static LSEasyControlManager mLSEasyControlManager = null;
	 static LSPowerManager mLSPowerManager  = null;
	 
	public static void goOrOutRearVideo(Context mContext) {
		if (mLSPowerManager==null) {
			mLSPowerManager = new LSPowerManager(mContext);
		}
		ReverseStatus revStatus = mLSPowerManager.getReverseStatus();
		if (revStatus==ReverseStatus.RevNone) {
			goRearVideo(mContext);
		}else {
			outRearVideo(mContext);
		}
	}
	
	public static void goRearVideo(Context mContext) {
		 if (mLSEasyControlManager==null) {
			 mLSEasyControlManager = new LSEasyControlManager(mContext);
		}
		  mLSEasyControlManager.Start_Reverse();
	}
	
	public static void outRearVideo(Context mContext) {
		if (mLSEasyControlManager==null) {
			 mLSEasyControlManager = new LSEasyControlManager(mContext);
		}
		mLSEasyControlManager.Stop_Reverse();
	}
}
