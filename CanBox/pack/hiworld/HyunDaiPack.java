package com.landsem.canbox.pack.hiworld;

import com.landsem.canbox.pack.HiworldBaseComPack;


public class HyunDaiPack extends HiworldBaseComPack   {

	public HyunDaiPack() {
		super((byte) 0xFF, (byte) 0xAA, (byte) 0x55);
	}
	
	@Override
	public byte getCheckBytes(byte[] dataBytes, byte comID) {
		byte resultCode = -1;
		int sum = comID;
		if (null != dataBytes) {
			sum += dataBytes.length;
			for (int index=0; index<dataBytes.length; index++) {
				sum += dataBytes[index];
			}
		}
		resultCode = (byte) ((sum-1) & checkCode);
		return resultCode;
	}

	
	
}
