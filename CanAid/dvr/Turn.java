package com.landsem.dvr;

import android.os.Parcel;
import android.os.Parcelable;

public final class Turn implements Parcelable {
	
	public boolean valid;

	public Direction direction;
	
	public Turn(){};
	
	public Turn(Parcel parcel){
		int ID = parcel.readInt();
		direction = Direction.check(ID);
		boolean[] bools = new boolean[1];
		parcel.readBooleanArray(bools);
		valid = bools[0];
	}

	@Override
	public void writeToParcel(Parcel parcel, int arg1) {
		parcel.writeInt(direction.ID);
		parcel.writeBooleanArray(new boolean[]{valid});
	}
	
	@Override
	public int describeContents() {
	
		return 0;
	}
	
	public static final Creator<Turn> CREATOR = new Parcelable.Creator<Turn>() {

		@Override
		public Turn createFromParcel(Parcel parcel) {
			
			return new Turn(parcel);
		}

		@Override
		public Turn[] newArray(int size) {
			
			return new Turn[size];
		}

	};
	
}
