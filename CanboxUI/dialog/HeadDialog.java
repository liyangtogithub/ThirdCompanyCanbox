package com.landsem.canboxui.dialog;

import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canboxui.R;
import com.landsem.canboxui.utils.ConstantUtil;
import com.landsem.common.tools.LogManager;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;


public class HeadDialog {
	
	 MyDialog myDialog;
	 Context mContext;
	 ImageView dialogIV;
	
	public HeadDialog(Context context) {
		mContext = context;
		View view = View.inflate(mContext,R.layout.headlight_dialog, null);
		dialogIV=(ImageView)view.findViewById(R.id.dialogHead_IV);
		myDialog = new MyDialog(mContext,view);
		myDialog.dismiss();
	}

	public void displayState(boolean isILL) {
		updateLightStates(isILL);
		if ( null!=  myDialog ) {
				//showDialogUI(isILL);
		}
	}
	
	/**  
	 * 更新大灯在数据库里的状态值  
	 */  
	private void updateLightStates(boolean isILL) {
		if (isILL) {
			Settings.System.putInt(mContext.getContentResolver(), ConstantUtil.HEADLAMP_STATE,1);
			mContext.sendBroadcast(new Intent(ConstantUtil.HEADLAMP_ON));
		}else {
			Settings.System.putInt(mContext.getContentResolver(), ConstantUtil.HEADLAMP_STATE,0);
			mContext.sendBroadcast(new Intent(ConstantUtil.HEADLAMP_OFF));
		}
	}
	

	private void showDialogUI(boolean isILL) {
		LogManager.d("ILL Dialog.show()");
		HeadDismissHandler.removeMessages(0);
		HeadDismissHandler.sendEmptyMessageDelayed(0, 3000);
		if (isILL) {
			dialogIV.setVisibility(View.VISIBLE);
		}else {
			dialogIV.setVisibility(View.INVISIBLE);
		}
		myDialog.show();
	}
	
	Handler HeadDismissHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			myDialog.dismiss();
		};
	};

	public void cancle() {
		if ( null!=  myDialog ){
		    myDialog.cancel();
		}
	}
	
}
