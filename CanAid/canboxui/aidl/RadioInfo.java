package com.landsem.canboxui.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public final class RadioInfo implements Parcelable {
	
	public String mSource ="Tuner";
	public String mBand="FM";
	public int mFreq;
	public  static final String FM_BAND = "FM";
	public  static final String AM_BAND = "AM";
	
	public RadioInfo(){};
	
	public RadioInfo(Parcel parcel){
		mSource = parcel.readString();
		mBand = parcel.readString();
		mFreq = parcel.readInt();
	}

	@Override
	public void writeToParcel(Parcel parcel, int arg1) {
		parcel.writeString(mSource);
		parcel.writeString(mBand);
		parcel.writeInt(mFreq);
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	public static final Creator<RadioInfo> CREATOR = new Parcelable.Creator<RadioInfo>() {

		@Override
		public RadioInfo createFromParcel(Parcel parcel) {
			
			return new RadioInfo(parcel);
		}

		@Override
		public RadioInfo[] newArray(int size) {
			
			return new RadioInfo[size];
		}

	};
	
}
