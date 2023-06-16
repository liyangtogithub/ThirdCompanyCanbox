package com.landsem.canboxui.view;

import java.util.ArrayList;
import java.util.List;

import com.landsem.canboxui.R;
import com.landsem.common.tools.LogManager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;


/**
 * TODO 
 *@author  LuckMerlin,Power by Landsem @ShenZhen
 *@version 0.0.0
 *Create Time:Apr 7, 2017 10:02:20 AM 
 *
 */
public class TempWaveView extends View{
	private  Drawable bg;
	private  Drawable full;
    private  float mProgress;
    private  RectF mRectF=new RectF();
    private  int initH = 0;
//	//test
//	private  Paint testPaint;
	
	public TempWaveView(Context context ) {
		this(context, null);
	}	
	public TempWaveView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	public TempWaveView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		Resources res=getResources();
		bg=res.getDrawable(R.drawable.thermometer_bg);
		full=res.getDrawable(R.drawable.thermometer_full);
		refreshBounds();
		//test
//		testPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
//		testPaint.setStyle(Style.STROKE);
//		testPaint.setColor(Color.RED);
//		testPaint.setTextSize(14);
	}
	  
	
	private  void  refreshBounds(){
		if (null!=bg) {
			bg.setBounds(0, 0, bg.getIntrinsicWidth(), bg.getIntrinsicHeight());
		}
		if (null!=full) {
			full.setBounds(0, 0, full.getIntrinsicWidth(), full.getIntrinsicHeight());
		}
	}
	
     @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    	 int  perferWidth=0,perferHeight=0;
    	 if (null!=bg) {
			perferWidth=bg.getIntrinsicWidth();
			perferHeight=bg.getIntrinsicHeight();
			bg.setBounds(0, 0, perferWidth, perferHeight);
		}
    	 setMeasuredDimension(resolveSize(perferWidth, widthMeasureSpec), resolveSize(perferHeight, heightMeasureSpec));
     }
     
      @Override
    	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    		super.onSizeChanged(w, h, oldw, oldh);
    		initH = h;
    		mRectF.set(w*0.32f, h*0.15f, w*0.68f,h*0.7f);
    }
     public  boolean  setProgress(float  progress){
    	  if (progress>=0) {
    		  mProgress=progress;
    		  postInvalidate();
    		  return true;
		  }
    	 return false;
     }
     
    public void setThreshold(float mThreshold) {
//		this.mThreshold = mThreshold;
//		postInvalidate();
	}
     @Override
    protected void onDraw(Canvas canvas) {
    	super.onDraw(canvas);
    	//test
//    	if (null!=testPaint) {
//    		canvas.drawRect(mRectF, testPaint);
//		}
    	//  
    	canvas.save();
    	mRectF.top= initH*0.15f;
    	mRectF.set(mRectF.left,mRectF.bottom-mRectF.height()*mProgress, mRectF.right, mRectF.bottom);
    	canvas.clipRect(mRectF, Op.REPLACE);
    	if (null!=full) {
    		canvas.translate(0, -5);//make  y shift
    		full.draw(canvas);
		}
    	canvas.restore();
    	if (null!=bg) {
    		bg.draw(canvas);
		}
    }
}
 