package com.landsem.canboxui.dialog;

import com.landsem.canboxui.R;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MyDialog extends Dialog {
	

	public MyDialog(Context context, View layout) {

		super(context, R.style.dialog);

		setContentView(layout);

		Window window = getWindow();

		WindowManager.LayoutParams params = window.getAttributes();

		params.gravity = Gravity.CENTER;

		window.setAttributes(params);
		//��dialog  show����֮ǰ������´��룬��ʾ��dialog��һ��ϵͳ��dialog
		getWindow().setType((WindowManager.LayoutParams.TYPE_SYSTEM_ALERT));
	}
	
	public void setView(View view){
		super.setContentView(view);
	}

}
