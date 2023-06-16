package com.landsem.canbox.pack;

import com.landsem.canbox.bean.ComBean;
import com.landsem.canbox.manager.SerialManager;
import com.landsem.common.tools.LogManager;

/**
 * ���ӷ���
 */
public abstract class SimpleBaseComPack implements BytePack {
	/**
	 * ������ɣ�������ʼ֡��һ�����ݳ��ȣ�һ��ComID��һ��У���� 2+1+1+1==5
	 */
	public static final byte ORDER_BASE_LENGTH = 4;
	/**
	 * У����� sum & checkCode;
	 */
	protected byte checkCode = (byte) 0xFF;
	/**
	 * ȷ���յ����ݵ�����
	 */
	protected static byte[] confirmArray = {(byte) 0xFF};
	/**
	 * ��ʼ֡1
	 */
	protected byte comStartByte1;

	public SimpleBaseComPack() {
		super();
	}

	public SimpleBaseComPack(byte checkCode, byte comStartByte1) {
		super();
		this.checkCode = checkCode;
		this.comStartByte1 = comStartByte1;
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
		byteArray[1] = comID;
		byteArray[2] = dataLength;
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
		resultCode = (byte) (sum ^ checkCode);
		return resultCode;
	}
	
	/**
	 * ֪ͨЭ��У�ȷ���յ�����
	 */
	public static void sendACK() {
		SerialManager mSerialManager = SerialManager.getInstance();
		ComBean mComBean = ComBean.createComBean((byte) 1, null, confirmArray);
		mComBean.needPackage = false;
		mSerialManager.onSendCom(mComBean);
	}

}
