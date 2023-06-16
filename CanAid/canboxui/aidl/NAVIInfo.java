package com.landsem.canboxui.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public final class NAVIInfo implements Parcelable {
	public String mSource = "NAVI";
	public int mState; 

	
	public NAVIInfo(){};
	
	public NAVIInfo(Parcel parcel){
		mSource = parcel.readString();
		mState = parcel.readInt();
	}

	@Override
	public void writeToParcel(Parcel parcel, int arg1) {
		parcel.writeString(mSource);
		parcel.writeInt(mState);
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	public static final Creator<NAVIInfo> CREATOR = new Parcelable.Creator<NAVIInfo>() {

		@Override
		public NAVIInfo createFromParcel(Parcel parcel) {
			
			return new NAVIInfo(parcel);
		}

		@Override
		public NAVIInfo[] newArray(int size) {
			
			return new NAVIInfo[size];
		}

	};
	
}
