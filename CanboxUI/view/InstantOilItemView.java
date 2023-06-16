package com.landsem.canboxui.view;

import com.landsem.canboxui.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * TODO 
 *@author  LuckMerlin,Power by Landsem @ShenZhen
 *@version 0.0.0
 *Create Time:Apr 7, 2017 10:02:20 AM 
 *
 */
public class InstantOilItemView extends RelativeLayout{
	private  ImageView mIconIV;
	private  ColorTextView mInstantOilCTV,mUnitOilCTV;
	TextView title_oilCTV;
	
	public InstantOilItemView(Context context ) {
		this(context, null);
	}	
	public InstantOilItemView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	
	public InstantOilItemView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		View.inflate(context, R.layout.instant_oli_item, this);
		title_oilCTV=(TextView) findViewById(R.id.title_oilCTV);
		mIconIV=(ImageView) findViewById(R.id.instantOilItem_iconIV);
		mInstantOilCTV=(ColorTextView) findViewById(R.id.instantOilItem_oilCTV);
		mUnitOilCTV=(ColorTextView) findViewById(R.id.unit_oilCTV);
//		mIconIV.setImageResource(R.drawable.instant_oil);
	}
	
	public  void  setContent(String  content){
			mInstantOilCTV.setText(content);
	}
	
	public  void  setTitle(String  title){
		title_oilCTV.setText(title);
    }
	
	public  void  setUnit(String  unit){
		mUnitOilCTV.setText(unit);
    }
	public  void  setImage(int  drawable){
		mIconIV.setImageResource(drawable);
    }
	
}
 