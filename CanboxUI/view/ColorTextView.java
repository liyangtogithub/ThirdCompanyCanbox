package com.landsem.canboxui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * TODO 
 *@author  LuckMerlin,Power by Landsem @ShenZhen
 *@version 0.0.0
 *Create Time:Apr 7, 2017 10:02:20 AM 
 *com.landsem.canboxui.view.ColorTextView
 */
public class ColorTextView extends TextView{
	private  LinearGradient  normalColor,unNormalColor;
	
	private  boolean isNormal=true;
	
	public ColorTextView(Context context ) {
		this(context, null);
	}	
	public ColorTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	public ColorTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		 normalColor = new LinearGradient(0, 0, 0, h,
                 Color.parseColor("#2ee8ff"), Color.parseColor("#127ffc") , Shader.TileMode.CLAMP);
     	 unNormalColor = new LinearGradient(0, 0, 0, h,
                      Color.parseColor("#ffa69e"),Color.parseColor("#ff2100") , Shader.TileMode.CLAMP);
	}
	
	public  void setState(boolean isNormal){
		if (this.isNormal!=isNormal) {
			this.isNormal=isNormal;
			invalidate();
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		getPaint().setShader(isNormal?normalColor:unNormalColor);
		super.onDraw(canvas);
	}
}
 