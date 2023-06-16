package com.landsem.canbox.tools;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import com.landsem.canbox.Constant;
import com.landsem.common.tools.LogManager;


public class ByteUtil implements Constant{
	
	private static final String TAG = ByteUtil.class.getSimpleName();
	
	private static final String FORMAT_HEX = "%02X";
	
	/**
	 * ��4�����ȵ�byte[]ת����int
	 * 
	 * @param b
	 * @return b
	 */
	public static int convertByteToInt(byte[] b) {
		int a = 0;
		for (int i = 0; i < b.length; i++) {
			a += (b[i] & 0xff) << (24 - 8 * i);
		}
		return a;
	}
	
	public static long convertByte8Tolong(byte[] b) {
		long a = 0;
		for (int i = 0; i < b.length; i++) {
			a += (b[i] & 0xff) << (56 - 8 * i);
		}
		return a;
	}

	/**
	 * ��2�����ȵ�byte[]ת����int
	 * @param b
	 * @return
	 */
	public static int convertByte2ToInt(byte[] b) {
		int a = 0;
		if (b[0] == 0) {
			a = convertByteToInt(b[1]);
		} else {
			a = convertByteToInt(b[1])+ convertByteToInt(b[0]) * 256;
		}
		return a;
	}

	/**
	 * ��1���ֽ�ת����8�����ȵĶ���������
	 * byte b = 0x35; // 0011 0101  
        // ��� [0, 0, 1, 1, 0, 1, 0, 1]  
        System.out.println(Arrays.toString(getBooleanArray(b)));  
        // ��� 00110101  
        System.out.println(byteToBit(b)); 
	 */
	public static byte[] convertByteToBitArray(byte b) {
		byte[] array = new byte[8];
		for (int i = 7; i >= 0; i--) {
			array[i] = (byte) (b & 1);
			b = (byte) (b >> 1);
		}
		return array;
	}

	/**
	 * ��byteתΪ8�����ȵĶ������ַ���
	 */
	public static String convertByteToBitString(byte b) {
		return "" + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
				+ (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
				+ (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
				+ (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
	}

	/**
	 * ��longת����8���ֽڵ�byte����
	 * 
	 */
	public static byte[] longToByteArray(long number) {
		long temp = number; 
        byte[] longByteArray = new byte[8]; 
        for (int i = longByteArray.length-1; i >=0; i--) { 
            longByteArray[i] = new Long(temp & 0xff).byteValue();// �����λ���������λ 
            temp = temp >> 8; // ������8λ 
        } 
        return longByteArray; 
	}
	

	/**
	 * ��intת����4���ֽڵ�byte����
	 * 
	 */
	public static byte[] IntTo4ByteArray(int value) {
		byte[] byteArray = new byte[4];
		for (int i = byteArray.length - 1; i >= 0; i--) {
			byteArray[i] = (byte) (value & 0xFF);
			value = value >> 8;
		}
		return byteArray;

	}
	/**
	 * ��intת��2���ֽڵ�byte����
	 * ���磺0x0102ת��Ϊ��byte[0] = 1,byte[1] = 2
	 */
	public static byte[] IntTo2ByteArray(int value) {
		byte[] byteArray = new byte[2];
		for (int i = byteArray.length - 1; i >= 0; i--) {
			byteArray[i] = (byte) (value & 0xFF);
			value = value >> 8;
		}
		return byteArray;

	}

	/**
	 * ��byteת��Ϊint
	 * 
	 */
	public static int convertByteToInt(byte byteValue) {
		
		return byteValue & 0xff;
	}
	

	/**
	 * ��byteת����16���Ƶ��ַ���,���16���Ƶĸ�ʽ������02���2
	 */
	public static String parseByteToHexString(byte byteData, String format) {
		try {
			return String.format(null == format ? FORMAT_HEX : format, byteData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��byteת��Ϊ16���Ƶ��ַ���
	 * 
	 */
	public static String parseByteToHexString(byte byteValue) {
		return Integer.toHexString(convertByteToInt(byteValue));
	}

	/**
	 * ��16���Ƶ��ַ���ת��Ϊint
	 * 
	 */
	public static int parseHexStringToInt(String hexString) {
		int result = -1;
		int length = 0;
		if (null != hexString
				&& null != (hexString = hexString.trim().replace(" ", ""))
				&& null != (hexString = hexString.toUpperCase(Locale.CHINA))
				&& (length = hexString.length()) > 0) {
			for (int i = length; i > 0; i--) {
				char c = hexString.charAt(i - 1);
				int algorism = 0;
				if (c >= '0' && c <= '9') {
					algorism = c - '0';
				} else {
					algorism = c - 55;
				}
				result += Math.pow(16, length - i) * algorism;
			}
			result = result + 1;
		}
		return result;
	}


	/**
	/**
	 * 16���Ʊ�ʾ���ַ���ת��Ϊ�ֽ�����
	 *
	 * @param s
	 *            16���Ʊ�ʾ���ַ���
	 * @return byte[] �ֽ�����
	 */
	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] b = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			// ��λһ�飬��ʾһ���ֽ�,��������ʾ��16�����ַ�������ԭ��һ���ֽ�
			b[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
					.digit(s.charAt(i + 1), 16));
		}
		return b;
	}

	/**
	 * byte[]����ת��Ϊ16���Ƶ��ַ���
	 *
	 * @param bytes
	 *            Ҫת�����ֽ�����
	 * @return ת����Ľ��
	 */
	public static String byteArrayToHexString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(0xFF & bytes[i]);
			if (hex.length() == 1) {
				sb.append('0');
			}
			sb.append(hex);
		}
		return sb.toString();
	}
	
	/**
	 * ���ֶ���String����ʱ�� ��������ַ���= �ַ������ȣ�word��+ �ַ���
	 * @param length
	 * @param string
	 * @return
	 */
//	public static String jointRealString(int length, String string){
//		
//		return byteToString(IntTo2ByteArray(length)) + string;
//	}
//	
//	public static String byteToString(byte[] messageBody){
//		String value = "";
//		for (int i = 0; i < messageBody.length; i++) {
//			value += parseByteToHexString(messageBody[i], FORMAT_HEX);
//		}
//		return value;
//	}
	
	public static String byteToString(byte[] byteArray, String doorplate){
		StringBuffer buffer = new StringBuffer("");
		for (int index = 0; index < byteArray.length; index++) {
			buffer.append(parseByteToHexString(byteArray[index], FORMAT_HEX));
		}
		String value = buffer.toString();
		return value;
	}
	
	public static String onPrintByteArray(byte[] byteArray, String doorplate){
		StringBuffer buffer = new StringBuffer("");
		for (int index = 0; index < byteArray.length; index++) {
			buffer.append(onByteToHexString(byteArray[index], FORMAT_HEX));
		}
		String value = buffer.toString();
		LogManager.d(TAG, doorplate+LOG_SPLIT+value);
		return value;
	}
	
	public static String onPrintByteArray(Byte[] byteArray, String doorplate){
		StringBuffer buffer = new StringBuffer("");
		for (int index = 0; index < byteArray.length; index++) {
			buffer.append(onByteToHexString(byteArray[index], FORMAT_HEX));
		}
		String value = buffer.toString();
		LogManager.d(TAG, doorplate+LOG_SPLIT+value);
		return value;
	}
	
	/**
	 * ��byteת����16���Ƶ��ַ���,���16���Ƶĸ�ʽ������02���2
	 */
	public static String onByteToHexString(byte byteData, String format) {
		try {
			return String.format(null==format ? FORMAT_HEX : format, byteData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @param sourceByte
	 * @param index ȡbyte�ĵ�indexλ��ȡֵ0-7��
	 * @return
	 */
	public static byte onCheckOutBitAtIndex(byte sourceByte, int index){
		if(index<0 || index>7){
			throw new RuntimeException("index is invalid : "+index);
		}
		byte source = sourceByte;
		source = (byte) (source >> index);
		source = (byte) (source & 0x01);
		return source;
	}
	
	/**
	 * 
	 * @�ֽ�����ת��ASCII
	 * @return ASCII
	 */
	public static String byteToASCII(byte[] sourceByte){
		String asciiStr="";
		try {
			 asciiStr = new String(sourceByte, "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return asciiStr;
	}
	
	/**
	 * �ֽ�����ת�����ַ���
	 */
	public static String byteArrayToChinese(byte[] sourceByte,String codeModeString){
		String asciiStr="";
		try {
			 asciiStr = new String(sourceByte, codeModeString);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return asciiStr;
	}
	
	public static int HighLowByteToInt(byte high, byte low) {
		String highString = ByteUtil.parseByteToHexString(high,null);
		String lowString = ByteUtil.parseByteToHexString(low,null);
		int value = ByteUtil.parseHexStringToInt( (highString+lowString) );
		return value;
	}
	
	public static int HighMidLowByteToInt(byte high, byte mid, byte low) {
		String highString = ByteUtil.parseByteToHexString(high,null);
		String midString = ByteUtil.parseByteToHexString(mid,null);
		String lowString = ByteUtil.parseByteToHexString(low,null);
		int value = ByteUtil.parseHexStringToInt( (highString+midString+lowString) );
		return value;
	}
	
	public static int HighMid2LowByteToInt(byte high, byte mid2,byte mid1, byte low) {
		String highString = ByteUtil.parseByteToHexString(high,null);
		String mid2String = ByteUtil.parseByteToHexString(mid2,null);
		String mid1String = ByteUtil.parseByteToHexString(mid1,null);
		String lowString = ByteUtil.parseByteToHexString(low,null);
		int value = ByteUtil.parseHexStringToInt( (highString+mid2String+mid1String+lowString) );
		return value;
	}
	
	/***�ַ���תutf-8�ֽ�����*/
	public static byte[] StringToByteArray(String string) {
		byte[] bytes = null;
		try {
			 bytes = string.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
		return bytes;
	}

}
