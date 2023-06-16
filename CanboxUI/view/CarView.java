package com.landsem.canboxui.view;

import com.landsem.canboxui.R;

import android.R.bool;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * TODO 
 *@author  LuckMerlin,Power by Landsem @ShenZhen
 *@version 0.0.0
 *Create Time:Apr 9, 2017 1:11:36 PM 
 *
 */
public class CarView extends FrameLayout{
	
	public  static final int LEFT_FRONT_DOOR=0x00; //左前门
	public  static final int RIGHT_FRONT_DOOR=0x01; //右前门
	public  static final int LEFT_BEHIND_DOOR=0x03; //左后门
	public  static final int RIGHT_BEHIND_DOOR=0x04; //右后门
	public  static final int ENGINE_DOOR=0x05; //引擎盖
	public  static final int TRUNK_DOOR=0x06; //后备箱
	//public  static final int HEAD_LIGHT=0x07; //大灯
	
	private static final int[] VALID_DOORS=new int[]{LEFT_FRONT_DOOR,RIGHT_FRONT_DOOR,LEFT_BEHIND_DOOR,RIGHT_BEHIND_DOOR,ENGINE_DOOR,TRUNK_DOOR};
	
	private final  SparseArray<View> mDoors=new SparseArray<View>();
	
	public CarView(Context context) {
		this(context, null);
	}
	public CarView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	public CarView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	
	private void init() {
		 ImageView view=new ImageView(getContext());
		 view.setImageResource(R.drawable.car);
		 addView(view);  
		 addDoor(LEFT_FRONT_DOOR, R.drawable.door_left_front);
		 addDoor(RIGHT_FRONT_DOOR, R.drawable.door_right_front);
		 addDoor(LEFT_BEHIND_DOOR, R.drawable.door_left_behind);
		 addDoor(RIGHT_BEHIND_DOOR, R.drawable.door_right_behind);
		 addDoor(ENGINE_DOOR, R.drawable.door_engine);
		 addDoor(TRUNK_DOOR, R.drawable.door_trunk);
	}
	
	public boolean addDoor(int door,int icon){
		 if (isDoorValid(door)&&!isDoorExist(door)) {
			 try {
				 ImageView view=new ImageView(getContext());
				 view.setImageResource(icon);
				 view.setVisibility(GONE);//default gone
				 mDoors.append(door, view);
				 addView(view);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
//	public  boolean isHeadLightON(){
//		if (null!=mDoors) {
//			View  v=mDoors.get(HEAD_LIGHT);
//			return null!=v&&v.getVisibility()==VISIBLE;
//		}
//		return false;
//	}
	public  boolean isDoorExist(int door){
		return null!=mDoors&&0<=mDoors.indexOfKey(door) ;
	}
	public  int  getOpendCount(){
		int  count=null==mDoors?0:mDoors.size();
		int  result = 0;
		for (int i = 0; i <count; i++) {
			result=result+(mDoors.get(mDoors.keyAt(i)).getVisibility()==VISIBLE?1:0);
		}
		return  result;
	}
	
	public  int  getDoorCount(){
		return null==mDoors?0:mDoors.size();
	}
	public  boolean isAllDoorClosed(){
		return 0==getOpendCount();
	}
	
	public  boolean isDoorOpened(int  door){
		return isDoorOpendOrClose(door, true);
	}
	
	public  boolean isDoorClosed(int  door){
		return isDoorOpendOrClose(door, false);
	}
	
	private  boolean isDoorOpendOrClose(int  door,boolean isOpened){
		if (isDoorValid(door)&&null!=mDoors) {
			View  v=mDoors.get(door);
			return isOpened?v.getVisibility()==VISIBLE:v.getVisibility()!=VISIBLE;
		}
		return false;
	}
	
	public  boolean openDoor(int door){
		return openOrCloseDoor(door,true);
	}
	public  boolean closeDoor(int door){
		return openOrCloseDoor(door,false);
	}
	
	public  boolean openOrCloseDoor(int door,boolean open){
		if (isDoorValid(door)&&null!=mDoors) {
			View  v=mDoors.get(door);
			if (null!=v) {
				if (open&&v.getVisibility()!=VISIBLE) {
					v.setVisibility(VISIBLE);	return true;
				}else if(!open&&v.getVisibility()==VISIBLE) {
					v.setVisibility(GONE);	return true;
				}
			}
		}
		return false;
	}
	
	public  static boolean isDoorValid(int  door){
		int  count=null==VALID_DOORS?0:VALID_DOORS.length;
		for (int i = 0; i < count; i++) {
			if(door==VALID_DOORS[i]){
				return true;
			}
		}
		return false;
	}
}
 