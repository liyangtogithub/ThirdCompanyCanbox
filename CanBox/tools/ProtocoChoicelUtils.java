package com.landsem.canbox.tools;

import com.landsem.canbox.CanBoxApp;
import com.landsem.canbox.ProtocolID;
import com.landsem.common.tools.LogManager;

import android.content.ContentResolver;
import android.provider.Settings;

public class ProtocoChoicelUtils {
	public  static final String CANBOX_PROTOCO_NAME = "canbox_protoco_name"; 
	public  static final String CANBOX_CAR_TYPE_INDEX = "canbox_car_type_index";
	public  static final String CANBOX_CAR_CAN_INDEX = "canbox_car_can_index";
	
	/**
	 *����CANBOXЭ������
	 */
	public static void putProtocoName(ProtocolID protocoName) {
		ContentResolver mContentResolver = CanBoxApp.getMyContext().getContentResolver();
		LogManager.d("putProtocoName  protocoName :"+protocoName);
		Settings.System.putString(mContentResolver, CANBOX_PROTOCO_NAME, protocoName+"");
	} 
	
	
	/**
	 *�õ�CANBOXЭ������
	 */
	public static String getProtocoName() {
		ContentResolver mContentResolver = CanBoxApp.getMyContext().getContentResolver();
		String protocoName = null;
		try {
			protocoName = Settings.System.getString(mContentResolver, CANBOX_PROTOCO_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogManager.d("getProtocoName  protocoName :"+protocoName);
		return protocoName;
	}  
	
	/**
	 *����CANBOX���Ͷ�Ӧ�б���±�
	 */
	public static void putCarTypeIndex(int carTypeIndex) {
		ContentResolver mContentResolver = CanBoxApp.getMyContext().getContentResolver();
		LogManager.d("putCarTypeIndex  carTypeIndex :"+carTypeIndex);
		Settings.System.putInt(mContentResolver, CANBOX_CAR_TYPE_INDEX, carTypeIndex);
	} 
	
	
	/**
	 *�õ�CANBOX���Ͷ�Ӧ�б���±�
	 */
	public static int getCarTypeIndex() {
		ContentResolver mContentResolver = CanBoxApp.getMyContext().getContentResolver();
		int carTypeIndex = 0;
		try {
			carTypeIndex = Settings.System.getInt(mContentResolver, CANBOX_CAR_TYPE_INDEX,0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogManager.d("getCarTypeIndex  carTypeIndex :"+carTypeIndex);
		return carTypeIndex;
	}  
	
	/**
	 *����CANBOX ��Ӧ�б���±�
	 */
	public static void putCarCanIndex(int carCanIndex) {
		ContentResolver mContentResolver = CanBoxApp.getMyContext().getContentResolver();
		LogManager.d("putCarCanIndex  carCanIndex :"+carCanIndex);
		Settings.System.putInt(mContentResolver, CANBOX_CAR_CAN_INDEX, carCanIndex);
	} 
	
	
	/**
	 *�õ�CANBOX ��Ӧ�б���±�
	 */
	public static int getCarCanIndex() {
		ContentResolver mContentResolver = CanBoxApp.getMyContext().getContentResolver();
		int carCanIndex = 0;
		try {
			carCanIndex = Settings.System.getInt(mContentResolver, CANBOX_CAR_CAN_INDEX,0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogManager.d("getCarCanIndex  carCanIndex :"+carCanIndex);
		return carCanIndex;
	}  

}
