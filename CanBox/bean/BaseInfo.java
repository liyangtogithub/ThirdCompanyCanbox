package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class BaseInfo implements Parcelable , Cloneable{
	

	@Override
	public Object clone(){
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

	}
	
	public byte getID(){
		return Constant.ID_NONE;
	};
	
	
}
