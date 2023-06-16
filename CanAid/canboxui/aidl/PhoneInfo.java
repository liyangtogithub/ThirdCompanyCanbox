package com.landsem.canboxui.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public final class PhoneInfo implements Parcelable {
	
	public String mSource = "Phone";
	/***0��״̬  1���ڴ����  2���ڴ��ȥ  3�ѽ�ͨ*/
	public int mState ;
	public String mPnoneNum;

	
	public PhoneInfo(){};
	
	public PhoneInfo(Parcel parcel){
		mSource = parcel.readString();
		mState = parcel.readInt();
		mPnoneNum = parcel.readString();
	}

	@Override
	public void writeToParcel(Parcel parcel, int arg1) {
		parcel.writeString(mSource);
		parcel.writeInt(mState);
		parcel.writeString(mPnoneNum);
	}
	
	@Override
	public int describeContents() {
	
		return 0;
	}
	
	public static final Creator<PhoneInfo> CREATOR = new Parcelable.Creator<PhoneInfo>() {

		@Override
		public PhoneInfo createFromParcel(Parcel parcel) {
			
			return new PhoneInfo(parcel);
		}

		@Override
		public PhoneInfo[] newArray(int size) {
			
			return new PhoneInfo[size];
		}

	};
	
}
