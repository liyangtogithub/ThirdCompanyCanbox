package com.landsem.canboxui.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public final class DVDInfo implements Parcelable {
	public String mSource = "Disc";
	public int mCurSone;
	public int mTotalSone;
	public long mMillisecond;
	public  static final String CD_SOURCE = "Disc";
	public DVDInfo(){};
	
	public DVDInfo(Parcel parcel){
		mSource = parcel.readString();
		mCurSone = parcel.readInt();
		mTotalSone = parcel.readInt();
		mMillisecond = parcel.readLong();
	}

	@Override
	public void writeToParcel(Parcel parcel, int arg1) {
		parcel.writeString(mSource);
		parcel.writeInt(mCurSone);
		parcel.writeInt(mTotalSone);
		parcel.writeLong(mMillisecond);
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	public static final Creator<DVDInfo> CREATOR = new Parcelable.Creator<DVDInfo>() {

		@Override
		public DVDInfo createFromParcel(Parcel parcel) {
			
			return new DVDInfo(parcel);
		}

		@Override
		public DVDInfo[] newArray(int size) {
			
			return new DVDInfo[size];
		}

	};
	
}
