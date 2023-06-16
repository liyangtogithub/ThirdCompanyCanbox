package com.landsem.canboxui.view;

import com.landsem.canboxui.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;


/**
 * TODO 
 *@author  LuckMerlin,Power by Landsem @ShenZhen
 *@version 0.0.0
 *Create Time:Apr 7, 2017 10:02:20 AM 
 *com.landsem.canboxui.view.WaterTankTempItemView
 */
public class WaterTankTempItemView extends RelativeLayout{
    private  TempWaveView waveView;
    private  ColorTextView mTempCTV,mUnitCTV;
    
	public WaterTankTempItemView(Context context ) {
		this(context, null);
	}	
	public WaterTankTempItemView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	
	public WaterTankTempItemView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		View.inflate(context, R.layout.water_tank_temp_item, this);
		waveView=(TempWaveView) findViewById(R.id.waterTankTempItem_tempWaveView);
		mTempCTV=(ColorTextView) findViewById(R.id.waterTankTempItem_tempValueCTV);
		mUnitCTV = (ColorTextView) findViewById(R.id.waterTankTempItem_unitCTV);
	}
	
	public  boolean setTemp(float  temp){
		mTempCTV.setText(""+ temp);
		if (temp>0) {
			waveView.setProgress(temp/50f);
			mTempCTV.setState(temp<=50);
			return true;
		}
		return false;
	}
	
	public void setUnit(String string) {
		mUnitCTV.setText(string);
	}
}
 