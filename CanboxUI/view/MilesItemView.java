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
public class MilesItemView extends RelativeLayout{
	private  ImageView mIconIV;
	private  ColorTextView mMilesCTV,mDrivableMilesCTV;
	
	public MilesItemView(Context context ) {
		this(context, null);
	}	
	public MilesItemView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	
	public MilesItemView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		View.inflate(context, R.layout.miles_item, this);
		mIconIV=(ImageView) findViewById(R.id.milesItem_iconIV);
		mMilesCTV=(ColorTextView) findViewById(R.id.milesItem_milesCTV);
		mDrivableMilesCTV=(ColorTextView) findViewById(R.id.milesItem_drivableMilesCTV);
	}
	
	public  boolean  setMiles(float  miles,String unit ){
		if (miles>=0) {
			mMilesCTV.setText(Float.toString(miles)+unit);
			return true;
		}
		return false;
	}
	
	public  boolean setDrivableMiles(int  driveableMiles,String unit){
		 if (driveableMiles>=0) {
			 mDrivableMilesCTV.setText(Integer.toString(driveableMiles)+unit);
			 mDrivableMilesCTV.setState(driveableMiles>50);
			 mIconIV.setImageResource(driveableMiles>50?R.drawable.miles_normal:R.drawable.miles_low);
		 return true;
		}
	return false;
	}
}
 