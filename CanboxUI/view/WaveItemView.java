package com.landsem.canboxui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.landsem.canboxui.R;

/**
 * TODO 
 *@author  LuckMerlin,Power by Landsem @ShenZhen
 *@version 0.0.0
 *Create Time:Apr 6, 2017 8:27:58 PM 
 *com.landsem.canboxui.view.OilMassView
 */
public class WaveItemView extends RelativeLayout{
	private  WaveView mWaveWDV;
	private  TextView mTitleTV;
	private  ColorTextView mValueCTV;
	private  String  mTitleValue;
	
	public WaveItemView(Context context ) {
		this(context, null);
	}	
	
	public WaveItemView(Context context, AttributeSet attrs ) {
		this(context, attrs, 0);
	}
	
	public WaveItemView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		TypedArray a=context.obtainStyledAttributes(attrs, R.styleable.CanboxItem, defStyleAttr, 0);
		mTitleValue=a.getString(R.styleable.CanboxItem_canboxItemTitle);
		View.inflate(context, R.layout.wave_item, this);
		mWaveWDV=(WaveView) findViewById(R.id.waveItem_WaveDrawablerView);
		mWaveWDV.setThreshold(a.getFloat(R.styleable.CanboxItem_canboxItemThresholdProgress, 0.2f));
		mTitleTV=(TextView)findViewById(R.id.waveItem_title);
		mValueCTV=(ColorTextView) findViewById(R.id.waveItem_value);
		a.recycle();
		setTitle(mTitleValue);
	}
	
	public  void  setTitle(String  title){
		this.mTitleValue=title;
		mTitleTV.setText(null==mTitleValue?"":mTitleValue);
	}
	
	
	public  void  setProgress(float  progress){
		if (mWaveWDV.setProgress(progress)) {
			mValueCTV.setState(mWaveWDV.isNormalState());
			mValueCTV.setText((int)(progress*100)+"%");
		}
	}
	
	public  void  setSwayable(boolean swayable){
		mWaveWDV.setSwayable(swayable);
	}
	
	public  void  setSwaySpeed(float mSwaySpeed){
		mWaveWDV.setSwaySpeed(mSwaySpeed);
	}
}
 