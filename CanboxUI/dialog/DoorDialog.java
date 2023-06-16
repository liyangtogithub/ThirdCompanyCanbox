package com.landsem.canboxui.dialog;

import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canboxui.R;
import com.landsem.canboxui.utils.AirUtil;
import com.landsem.canboxui.utils.ConstantUtil;
import com.landsem.canboxui.utils.DoorUtil;
import com.landsem.canboxui.view.CarView;
import com.landsem.common.tools.LogManager;

import android.content.Context;
import android.os.Handler;
import android.view.View;


public class DoorDialog {
	
	 MyDialog carDoorDialog;
	 CarView carView;
	 Context mContext;
	
	
	
	public DoorDialog(Context context) {
		mContext = context;
		View view = View.inflate(mContext,R.layout.car, null);
		carView=(CarView)view.findViewById(R.id.carView);
		carDoorDialog = new MyDialog(mContext,view);
		carDoorDialog.dismiss();
	}

	public void displayState(DoorInfo mDoorInfo) {
		if ( null!=  carView && mDoorInfo.isValid() ) {
			if (DoorUtil.isAllClosed(mDoorInfo)) {
				LogManager.d(ConstantUtil.TAG,"Door AllClosed");
				carDoorDialog.dismiss();
				return;
			}
			carDoorDialog.show();
			carView.openOrCloseDoor(CarView.LEFT_FRONT_DOOR,mDoorInfo.isDriverDoor());
			carView.openOrCloseDoor(CarView.RIGHT_FRONT_DOOR,mDoorInfo.isPassengerDoor());
			carView.openOrCloseDoor(CarView.LEFT_BEHIND_DOOR,mDoorInfo.isLeftBackDoor());
			carView.openOrCloseDoor(CarView.RIGHT_BEHIND_DOOR,mDoorInfo.isRightBackDoor());
			carView.openOrCloseDoor(CarView.ENGINE_DOOR,mDoorInfo.isEngineHood());
			carView.openOrCloseDoor(CarView.TRUNK_DOOR,mDoorInfo.isBackTrunk());
		}
	}
	
	Handler DoorDismissHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			carDoorDialog.dismiss();
		};
	};

	public void cancle() {
		if ( null!=  carDoorDialog ){
		    carDoorDialog.cancel();
		}
	}
	
}
