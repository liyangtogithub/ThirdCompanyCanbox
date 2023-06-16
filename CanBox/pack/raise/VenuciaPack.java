package com.landsem.canbox.pack.raise;

import com.landsem.canbox.pack.SimpleBaseComPack;

public class VenuciaPack extends SimpleBaseComPack   {
	/**
	 * TODO ����(DVD����->Э���)
	 *@author LiYang,Power by Landsem @ShenZhen
	 */
	public VenuciaPack() {
		super((byte) 0xFF, (byte) 0x2e);
	}
	
	static VenuciaPack mVenuciaPack;
	
	public static VenuciaPack getInstance(){
		if (mVenuciaPack==null) {
			mVenuciaPack = new VenuciaPack();
		}
		return mVenuciaPack;
	}

}
