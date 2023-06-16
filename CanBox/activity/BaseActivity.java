package com.landsem.canbox.activity;

import com.landsem.canbox.CanBoxApp;
import com.landsem.canbox.ProtocolID;
import com.landsem.canbox.R;
import com.landsem.canbox.manager.SerialManager;
import com.landsem.canbox.tools.CacheUtils;
import com.landsem.canbox.tools.ProtocoChoicelUtils;
import com.landsem.common.tools.LogManager;
import com.landsem.common.tools.StringUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public abstract class BaseActivity extends Activity {

//	public static final String BROADCAST_RECEIVE_SEND_MSG = "com.landsem.canbox.data";
//	public static final String BROADCAST_RECEIVE_SEND_ACTION = "com.landsem.canbox.data.action";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		CacheUtils.onAddCache(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		CacheUtils.onRemoveCache(this);
	}

	/**
	 * 应用可以注册此广播接收器，接收调试数据
	 */
//	public static void sendBroadcastToActivity(String sendMsg) {
//		Intent intent = new Intent();
//		intent.setAction(BROADCAST_RECEIVE_SEND_ACTION);
//		intent.putExtra(BROADCAST_RECEIVE_SEND_MSG, sendMsg);
//		CanBoxApp.getMyContext().sendBroadcast(intent);
//	}
	/**
	 * 选择CanBox协议使用，选择界面放在showCarChoiceView布局下方
	 */
	public void showCanChoicePopupWindow(final TextView showCarChoiceView) {
		
		final String[] resIdsChoice = getResources().getStringArray(
				R.array.arrayCanboxChoice);
		final ProtocolID[] protocolChoice = ProtocolID.values();
		LayoutInflater inflater = LayoutInflater.from(this);
		View view = inflater.inflate(R.layout.popup_check, null);
		ListAdapter mAdapter = new ArrayAdapter<String>(
				getApplicationContext(),
				android.R.layout.simple_expandable_list_item_1, resIdsChoice);
		ListView mListView = (ListView) view.findViewById(R.id.popup_listview);
		mListView.setAdapter(mAdapter);
		final PopupWindow mPopupWindow = new PopupWindow(view,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		mPopupWindow.setFocusable(true);
		mPopupWindow.setOutsideTouchable(true);
		mPopupWindow.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.abc_ab_solid_light_holo));
		mPopupWindow.showAsDropDown(showCarChoiceView, 0, 0);
		mPopupWindow.update();
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (mPopupWindow.isShowing()) {
					showCarChoiceView.setText(resIdsChoice[position]);
					SerialManager.getInstance().onCutDataProtocol(protocolChoice[position]);
					ProtocoChoicelUtils.putProtocoName(protocolChoice[position]);
					mPopupWindow.dismiss();
				}
			}
		});
	}

	// protected void onUpdateAirConditionInfo(AirConditionInfo
	// mAirConditionInfo) {
	//
	// }
	//
	// protected void onUpdateCarBaseInfo(CarBaseInfo mCarBaseInfo) {
	//
	// }
	//
	// protected void onUpdateLargeInfo(CarLargeInfo mCarLargeInfo) {
	//
	// }
	//
	// protected void onUpdateCornerInfo(CornerInfo mCornerInfo) {
	//
	// }
	//
	// protected void onUpdateDoorInfo(DoorInfo mDoorInfo) {
	//
	// }
	//

}
