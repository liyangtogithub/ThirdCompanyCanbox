package com.landsem.canbox.pack;

public interface BytePack {
	/**
	 * @param dataBytes
	 * @param comID
	 * @return
	 */
	byte[] onCreateOrderBytes(byte[] dataBytes, byte comID);
	/**
	 * 
	 * @param byteArray ������������ ��Ĭ���ɣ���ʼ֡1+��ʼ֡2+���ݳ���+ComID+����+У���룩
	 * @param dataLength ���ݳ���
	 * @param comID
	 * @return ��������
	 */
	byte[] initStartBytes(byte[] byteArray, byte dataLength, byte comID);
	/**
	 * 
	 * @param byteArray ������������ ��Ĭ���ɣ���ʼ֡1+��ʼ֡2+���ݳ���+ComID+����+У���룩
	 * @param dataBytes ��������
	 * @return ��������
	 */
	byte[] initOrderBody(byte[] byteArray, byte[] dataArray);
	/**
	 * 
	 * @param byteArray ������������ ��Ĭ���ɣ���ʼ֡1+��ʼ֡2+���ݳ���+ComID+����+У���룩
	 * @param dataBytes ��������
	 * @param comID
	 * @return ��������
	 */
	byte[] initCheckCode(byte[] byteArray, byte[] dataBytes, byte comID);
	/**
	 * 
	 * @param dataBytes ��������
	 * @param comID ����ID
	 * @return ����ָ��У����
	 */
	byte getCheckBytes(byte[] dataBytes, byte comID);

}
