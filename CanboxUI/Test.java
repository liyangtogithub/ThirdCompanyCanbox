package com.landsem.canboxui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.landsem.canboxui.view.CarView;
import com.landsem.canboxui.view.EngineSpeedItemView;
import com.landsem.canboxui.view.InstantOilItemView;
import com.landsem.canboxui.view.MilesItemView;
import com.landsem.canboxui.view.WaterTankTempItemView;
import com.landsem.canboxui.view.WaveItemView;

/**
 * TODO 
 *@author  LuckMerlin,Power by Landsem @ShenZhen
 *@version 0.0.0
 *Create Time:Apr 9, 2017 2:30:07 PM 
 *
 */
public class Test {
	  private  Handler testhandler=new Handler();
	   private  Activity activity;
	  public  Test(Activity activity){
		  this.activity=activity;
			testhandler.post(testRunnable);
	  }
		private  int  test;
		private  Runnable testRunnable=new Runnable() {
			@Override
			public void run() {
				test=test+1;
				if(test<=10){
					TestOtherCanbusUi();
				}else {
					TestCarUi();
				}
				test=test>20?0:test;
				testhandler.postDelayed(testRunnable, 100);
			}
		};
		
		private  void  TestCarUi(){
			setContentView(R.layout.car);
			CarView carView=(CarView)findViewById(R.id.carView);
			carView.openDoor((int) (Math.random()*7));
			appendText();
		}
		
		private View findViewById(int id) {
			
			return activity.findViewById(id);
		}

		private void setContentView(int id) {
			activity.setContentView(id);			
		}

		private  void  TestOtherCanbusUi(){
			
			setContentView(R.layout.activity_main);
			MilesItemView miv=(MilesItemView) findViewById(R.id.milesItemView);//里程表
//			WaveItemView cleaningFluidState=(WaveItemView)findViewById(R.id.cleaningFluidStateWIV);//清洗液状态
//			WaveItemView engineOilState=(WaveItemView)findViewById(R.id.engineOilStateWIV);//机油状态
			WaveItemView oilState=(WaveItemView)findViewById(R.id.oilStateWIV);//油量状态
			WaveItemView batteryState=(WaveItemView) findViewById(R.id.batteryStateWIV);//电池状态
	 		InstantOilItemView instantOil=(InstantOilItemView)findViewById(R.id.instantOilItemView);//即时油耗
	 		WaterTankTempItemView waterTankTemp=(WaterTankTempItemView) findViewById(R.id.waterTankTempItemView);//谁想温度
			EngineSpeedItemView engineSpeed=(EngineSpeedItemView) findViewById(R.id.engineSpeedItemView);//发送机速度
	 		//set test  data
//			miv.setMiles((int) (Math.random()*200000));
//			miv.setDrivableMiles((int) (Math.random()*100));
//			instantOil.setInstantOil((int) (Math.random()*10));
			waterTankTemp.setTemp((float) (Math.random()*150));
			engineSpeed.setEngineSpeed((int) (Math.random()*999999));
//			cleaningFluidState.setProgress((float) Math.random());//0<=progress<=1
//			engineOilState.setProgress((float)Math.random());//0<=progress<=1
			oilState.setProgress((float)Math.random());//0<=progress<=1
			batteryState.setProgress((float)Math.random());//0<=progress<=1
			appendText();
		}
		
	  private void  appendText(){
			TextView textView=new TextView(activity);
			textView.setTextColor(Color.GREEN);
			textView.setText("测试UI的数据");
			textView.setTextSize(50);
			activity.addContentView(textView, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	  }
}
 