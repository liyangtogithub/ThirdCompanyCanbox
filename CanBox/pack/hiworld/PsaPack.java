package com.landsem.canbox.pack.hiworld;

import com.landsem.canbox.pack.HiworldBaseComPack;


public class PsaPack extends HiworldBaseComPack  {

	public PsaPack() {
		super((byte) 0xFF, (byte) 0x5A, (byte) 0xA5);
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
