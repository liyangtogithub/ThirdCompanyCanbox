package com.landsem.canboxui.view;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Debug;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;
  
import com.landsem.canboxui.R;

/**
 * TODO 
 *@author  LuckMerlin,Power by Landsem @ShenZhen
 *@version 0.0.0
 *Create Time:Apr 6, 2017 3:32:51 PM 
 *
 */
public class WaveView extends View  {
    private int mViewWidth;  
    private int mViewHeight;  
    private float mWaveHeight;  
    private float mWaveWidth;  
    private float mLeftSide;  
    private float mMoveLen;  
    private float mSwaySpeed =10.7f;  
    private final  List<Point> mPoints=new ArrayList<>();  
    private  Path mSwayPath;  
    private  Drawable mBgFrame ;
    private  float mThreshold=0.2f;
    private  boolean mSwayable=true;
	private  Paint mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
	private  LinearGradient  normalColor,unNormalColor;
    private  PaintFlagsDrawFilter  mDrawFilter = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG);     
    private  float mProgress;
    private int  mShifht;
    public WaveView(Context context) {
		this(context,null);
	}
	
	public WaveView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	
	public WaveView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mSwayPath = new Path();   
		mPaint.setDither(false);  
	    Resources res=getResources();
	    mBgFrame=res.getDrawable(R.drawable.wave_bg_frame);
	    setBounds();
	}  
	
	
	protected void setBounds(){
		int perferWidth=0,perferHeight=0;
		if (null!=mBgFrame) {
			perferWidth=mBgFrame.getIntrinsicWidth();
			perferHeight=mBgFrame.getIntrinsicHeight();
			mShifht=(int) (perferWidth*0.13f);
			mBgFrame.setBounds(0, 0, perferWidth, perferHeight);
		     mRect.set(mShifht,mShifht, perferWidth-mShifht, perferHeight-mShifht);
		}
	}
	
	@SuppressLint("DrawAllocation")
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		Drawable bg=mBgFrame;
		setMeasuredDimension(resolveSize(null==bg?0:bg.getIntrinsicWidth(), widthMeasureSpec), 
				resolveSize(null==bg?0:bg.getIntrinsicHeight(), heightMeasureSpec));
		refreshMeasure();
	}
	
	public  boolean isNormalState(){
		return mProgress>mThreshold;
	}
	
    public boolean setThreshold(float lowThreshold) {
    	if (lowThreshold>0) {
    		this.mThreshold = lowThreshold;
    		postInvalidate();
    		return true;
		}
    	return false;
	}
  
	protected void  refreshMeasure(){
		  mViewHeight = getMeasuredHeight();  
          mViewWidth = getMeasuredWidth();  
     	 normalColor=new LinearGradient(0, 0, 0, mViewHeight,
				 new int []{Color.parseColor("#DDF8FF"), Color.parseColor("#0553D5")}
		 , new float[]{0.1f,0.6f}, Shader.TileMode.MIRROR);
     	unNormalColor=new LinearGradient(0, 0, 0, mViewHeight,
				 new int []{Color.parseColor("#F9BCB8"), Color.parseColor("#D60606")}
		 , new float[]{0.1f,0.6f}, Shader.TileMode.MIRROR);
    	  mPoints.clear();
          mWaveHeight = mViewWidth / 9f;  
          mWaveWidth = mViewWidth * 1.2f;  
          mLeftSide = -mWaveWidth;     
          int n = (int) Math.round(mViewWidth / mWaveWidth + 0.5);  
          float baseY=getHeight()*(1-mProgress);
          for (int i = 0; i < (4 * n + 5); i++) {  
              float x = i * mWaveWidth / 4 - mWaveWidth;  
              float y = 0;
              switch (i % 4) {  
	            case 0:  
	            case 2:  
	            	y=baseY;
	                break;  
	            case 1:  
	            	y=baseY + mWaveHeight;  
	                break;  
	            case 3:  
	            	y=baseY - mWaveHeight;  
	                break;  
	            }  
              mPoints.add(new Point(x, y));  
          }
          reset();
	}
	
	 
	public Rect getBackgroundRect() {
		return null==mBgFrame?null:mBgFrame.getBounds();
	}
	
	
	public  boolean setProgress(float  progress){
		    if (progress>=0&&progress<=1) {
		    	mProgress=progress;
		    	refreshMeasure();
		    	postInvalidate();
				return true;
			}
		return false;
	}
	
	public float getProgress() {
		return mProgress;
	}
	
	public void setSwayable(boolean mSwayable) {
		this.mSwayable = mSwayable;
		postInvalidate();
	}
	
	public boolean isSwayable() {
		return mSwayable;
	}
	
	public  void setSwaySpeed(float mSwaySpeed) {
		this.mSwaySpeed = mSwaySpeed;
	}
	
	public float getSwaySpeed() {
		return mSwaySpeed;
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
     	 setProgress(mProgress);
	}
	
	private  Rect mRect=new Rect();
	@SuppressLint("NewApi")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (null!=mBgFrame) {
			mBgFrame.draw(canvas);
			if (mProgress==0) {
				return;
			}
		List<Point> points=mPoints;
		int count=null==points?0:points.size();
		if (count>0) {
			mSwayPath.reset();  
			  int i = 0;  
		      Point point1=points.get(0),point2;
		      mSwayPath.moveTo(point1.x,point1.y);
		      int  end=count-2;
		      for (; i <end; i += 2){     
		    	  point1=points.get(i+1);
		    	  point2=points.get(i+2);
		    	  mSwayPath.quadTo(point1.x,point1.y,point2.x, point2.y);   
		        }  
		        mSwayPath.lineTo(points.get(i).x, mViewHeight);  
		        mSwayPath.lineTo(mLeftSide, mViewHeight);
		        mSwayPath.close(); 
		        canvas.save();
		        mPaint.setShader(mProgress<mThreshold?unNormalColor:normalColor );
		        canvas.setDrawFilter(mDrawFilter);
		        canvas.clipRect(mRect, Op.REPLACE);
		        canvas.translate(0,-mShifht);
		        canvas.drawPath(mSwayPath, mPaint);
		        canvas.restore();
		      if (mSwayable) {
			    	mMoveLen += mSwaySpeed;  
			        mLeftSide += mSwaySpeed;  
			        for (int j = 0; j <count; j++)  {  
			        	point1=points.get(j);
			        	point1.x+= mSwaySpeed;  
			        }  
			       if (mMoveLen >= mWaveWidth) {  
			        	reset();
			      }
			     postInvalidateDelayed(50);
	       }}
		}
	}

	protected  void reset(){
		   mMoveLen = 0;  
           mLeftSide = -mWaveWidth;
           List<Point> points=mPoints;
           int  count=null==points?0:points.size();
           for (int j = 0; j < count; j++) {  
        	   points.get(j).x=j * mWaveWidth / 4 - mWaveWidth;
           } 
	 }
	
	public static  class Point{
		private  float x,y;
		public  Point(float x,float y){
			this.x=x;
			this.y=y;
		}
	}
}
 