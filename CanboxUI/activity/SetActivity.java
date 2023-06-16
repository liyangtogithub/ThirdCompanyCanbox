package com.landsem.canboxui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.landsem.canbox.activity.BaseActivity;
import com.landsem.canboxui.R;
import com.landsem.canboxui.fragment.CarSetFragment;
import com.landsem.canboxui.utils.ConstantUtil;
import com.landsem.common.tools.LogManager;

public class SetActivity  extends BaseActivity {
	
	Context mContext;
	private View generalFragment;
	private UiHandler mUiHandler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		setContentView(R.layout.overall_layout);
		initHandler();
		initView();
		mUiHandler.sendEmptyMessage(0);
	}
	
	private void initHandler() {
		if (null == mUiHandler)
			mUiHandler = new UiHandler();
	}

	
	private void initView() {
		generalFragment = findViewById(R.id.general_fragment);
	}
	
	private final class UiHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			showDefaultFragment();
		}
	}
	
	private void showDefaultFragment() {
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		Fragment fragment  = new CarSetFragment();
		transaction.add(R.id.general_fragment, fragment);
		transaction.commit();
		transaction.show(fragment);
	}


}
