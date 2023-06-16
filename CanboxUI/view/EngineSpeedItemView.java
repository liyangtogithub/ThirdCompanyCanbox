package com.landsem.canboxui.view;

import com.landsem.canboxui.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;



/**
 * TODO 
 *@author  LuckMerlin,Power by Landsem @ShenZhen
 *@version 0.0.0
 *Create Time:Apr 7, 2017 10:02:20 AM 
 *
 */
public class EngineSpeedItemView extends RelativeLayout{
	private  ColorTextView mSpeedCTV;  
	private  ImageView mIcon;
	public EngineSpeedItemView(Context context ) {
		this(context, null);
	}	
	
	public EngineSpeedItemView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	
	public EngineSpeedItemView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		View.inflate(context, R.layout.engine_speed_item, this);
		mIcon=(ImageView) findViewById(R.id.engineSpeedItem_iconIV);
		mSpeedCTV=(ColorTextView)findViewById(R.id.engineSpeedItem_speedValueCIV);
		mIcon.setImageResource(R.drawable.car_engine_speed);
	}
     
	
	public boolean setEngineSpeed(int engineSpeed) {
		if (engineSpeed>=0) {
			mSpeedCTV.setText(Integer.toString(engineSpeed)+"r/min");
			return true;
		}
		return false;
	}
}
 