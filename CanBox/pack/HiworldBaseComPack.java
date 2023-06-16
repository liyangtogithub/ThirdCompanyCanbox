package com.landsem.canbox.pack;

import com.landsem.canbox.bean.ComBean;
import com.landsem.canbox.manager.SerialManager;
import com.landsem.common.tools.LogManager;

/**
 * HiworldBaseComPack1 ��  HiworldBaseComPack2 ������ֻ��У�鷽����ͬ
 */
public abstract class HiworldBaseComPack implements BytePack {
	/**
	 * ������ɣ�������ʼ֡��һ�����ݳ��ȣ�һ��ComID��һ��У���� 2+1+1+1==5
	 */
	public static final byte ORDER_BASE_LENGTH = 5;
	/**
	 * У����� sum & checkCode;
	 */
	protected byte checkCode = (byte) 0xFF;
	/**
	 * ��ʼ֡1
	 */
	protected byte comStartByte1;
	/**
	 * ��ʼ֡2
	 */
	protected byte comStartByte2;
	/**
	 * ȷ���յ����ݵ�����
	 */
	protected static byte confirmComId = (byte) 0xFF;
	/**
	 * ȷ���յ����ݵ�����ID
	 */
	protected static byte confirmDataArray[] = {(byte) 0x01};

	public HiworldBaseComPack() {
		super();
	}

	public HiworldBaseComPack(byte checkCode, byte comStartByte1, byte comStartByte2) {
		super();
		this.checkCode = checkCode;
		this.comStartByte1 = comStartByte1;
		this.comStartByte2 = comStartByte2;
	}

	@Override
	public byte[] onCreateOrderBytes(byte[] dataBytes, byte comID) {
		byte[] resultBytes = null;
		if (null != dataBytes && dataBytes.length != 0) {
			byte dataLength = (byte) dataBytes.length;
			byte orderByteLength = (byte) (dataLength + ORDER_BASE_LENGTH);
			resultBytes = new byte[orderByteLength];
			resultBytes = initStartBytes(resultBytes, dataLength, comID);
			resultBytes = initOrderBody(resultBytes, dataBytes);
			resultBytes = initCheckCode(resultBytes, dataBytes, comID);
		}
		return resultBytes;
	}

	@Override
	public byte[] initStartBytes(byte[] byteArray, byte dataLength, byte comID) {
		byteArray[0] = comStartByte1;
		byteArray[1] = comStartByte2;
		byteArray[2] = dataLength;
		byteArray[3] = comID;
		return byteArray;
	}

	@Override
	public byte[] initOrderBody(byte[] byteArray, byte[] dataArray) {
		// byteArray ������ʼ֡��һ�����ݳ��ȣ�һ��ComID��
		// ������������ݲ��ִ�byteArray�ĵ�5��byte��ʼ
		for (int dataIndex=0; dataIndex<dataArray.length; dataIndex++) {
			byteArray[dataIndex + ORDER_BASE_LENGTH - 1] = dataArray[dataIndex];
		}
		return byteArray;
	}

	@Override
	public byte[] initCheckCode(byte[] byteArray, byte[] dataBytes, byte comID) {
		byte checkCode = getCheckBytes(dataBytes, comID);
		byteArray[byteArray.length - 1] = checkCode;
		return byteArray;
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
		resultCode = (byte) ((sum & checkCode) - 1);
		return resultCode;
	}
	
	/**
	 * ֪ͨЭ��У�ȷ���յ�����
	 */
	public static void sendACKHiword(byte comID) {
		confirmDataArray[0] = comID;
		SerialManager mSerialManager = SerialManager.getInstance();
		ComBean mComBean = ComBean.createComBean(confirmComId, null,confirmDataArray);
		mSerialManager.onSendCom(mComBean);
	}

}
