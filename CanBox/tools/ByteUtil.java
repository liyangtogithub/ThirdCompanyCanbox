package com.landsem.canbox.tools;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import com.landsem.canbox.Constant;
import com.landsem.common.tools.LogManager;


public class ByteUtil implements Constant{
	
	private static final String TAG = ByteUtil.class.getSimpleName();
	
	private static final String FORMAT_HEX = "%02X";
	
	/**
	 * 把4个长度的byte[]转换成int
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
	 * 把2个长度的byte[]转换成int
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
	 * 将1个字节转换成8个长度的二进制数组
	 * byte b = 0x35; // 0011 0101  
        // 输出 [0, 0, 1, 1, 0, 1, 0, 1]  
        System.out.println(Arrays.toString(getBooleanArray(b)));  
        // 输出 00110101  
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
	 * 把byte转为8个长度的二进制字符串
	 */
	public static String convertByteToBitString(byte b) {
		return "" + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
				+ (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
				+ (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
				+ (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
	}

	/**
	 * 将long转换成8个字节的byte数组
	 * 
	 */
	public static byte[] longToByteArray(long number) {
		long temp = number; 
        byte[] longByteArray = new byte[8]; 
        for (int i = longByteArray.length-1; i >=0; i--) { 
            longByteArray[i] = new Long(temp & 0xff).byteValue();// 将最低位保存在最低位 
            temp = temp >> 8; // 向右移8位 
        } 
        return longByteArray; 
	}
	

	/**
	 * 将int转换成4个字节的byte数组
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
	 * 将int转换2个字节的byte数组
	 * 例如：0x0102转换为：byte[0] = 1,byte[1] = 2
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
	 * 将byte转化为int
	 * 
	 */
	public static int convertByteToInt(byte byteValue) {
		
		return byteValue & 0xff;
	}
	

	/**
	 * 将byte转化成16进制的字符串,添加16进制的格式，避免02变成2
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
	 * 将byte转化为16进制的字符串
	 * 
	 */
	public static String parseByteToHexString(byte byteValue) {
		return Integer.toHexString(convertByteToInt(byteValue));
	}

	/**
	 * 将16进制的字符串转化为int
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
	 * 16进制表示的字符串转换为字节数组
	 *
	 * @param s
	 *            16进制表示的字符串
	 * @return byte[] 字节数组
	 */
	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] b = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			// 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个字节
			b[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
					.digit(s.charAt(i + 1), 16));
		}
		return b;
	}

	/**
	 * byte[]数组转换为16进制的字符串
	 *
	 * @param bytes
	 *            要转换的字节数组
	 * @return 转换后的结果
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
	 * 当字段是String类型时， 解析后的字符串= 字符串长度（word）+ 字符串
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
	 * 将byte转化成16进制的字符串,添加16进制的格式，避免02变成2
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
	 * @param index 取byte的第index位（取值0-7）
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
	 * @字节数组转成ASCII
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
	 * 字节数组转中文字符串
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
	
	/***字符串转utf-8字节数组*/
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
