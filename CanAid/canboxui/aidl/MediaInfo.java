package com.landsem.canboxui.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public final class MediaInfo implements Parcelable {
	public String mSource = "USB";
	public int mFoldNum;
	public int mFileNum;
	public long mMillisecond;
	public  static final String USB_SOURCE = "USB";
	public  static final String SD_SOURCE = "SD";
	
	public MediaInfo(){};
	
	public MediaInfo(Parcel parcel){
		mSource = parcel.readString();
		mFoldNum = parcel.readInt()+1;
		mFileNum = parcel.readInt()+1;
		mMillisecond = parcel.readLong();
	}

	@Override
	public void writeToParcel(Parcel parcel, int arg1) {
		parcel.writeString(mSource);
		parcel.writeInt(mFoldNum);
		parcel.writeInt(mFileNum);
		parcel.writeLong(mMillisecond);
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	public static final Creator<MediaInfo> CREATOR = new Parcelable.Creator<MediaInfo>() {

		@Override
		public MediaInfo createFromParcel(Parcel parcel) {
			
			return new MediaInfo(parcel);
		}

		@Override
		public MediaInfo[] newArray(int size) {
			
			return new MediaInfo[size];
		}

	};
	
}
