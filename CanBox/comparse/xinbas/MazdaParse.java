package com.landsem.canbox.comparse.xinbas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import android.view.KeyEvent;

import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CDInfo;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CornerInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.RadarInfo;
import com.landsem.canbox.comparse.BaseComParse;
import com.landsem.canbox.comparse.simple.SimpleBaseParse;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;
/**
 *  鑫巴斯协议  ：马自达
 */
public class MazdaParse extends SimpleBaseParse {
	public MazdaParse() {
		super((byte) 0xFF, (byte) 0x2e, (byte) 0xA5);
	}

	CDInfo mCDInfo = new CDInfo();
	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		ByteUtil.onPrintByteArray(intackBytes, "MazdaParse--data: ");
		byte comID = intackBytes[Constant.COMID_XINPU];
		switch (comID) {
		case Constant.Mazda.DATA_TYPE_KEY:
			return analyzeSteerKey(intackBytes);
		case Constant.Mazda.DATA_TYPE_DOOR:
			return analyzeBaseCar(intackBytes);
		case Constant.Mazda.DATA_TYPE_RADAR:
			return analyzeRadar(intackBytes);
		case Constant.Mazda.DATA_TYPE_CORNER:
			return analyzeCorner(intackBytes);	
		case Constant.Mazda.DATA_TYPE_BLIGHT:
			return analyzeBackLight(intackBytes);
		case Constant.Mazda.DATA_DEVICE_INFO:
			return analyzeDeviceInfo(intackBytes);
		case Constant.Mazda.DATA_PLAY_INFO:
			return analyzePlayInfo(intackBytes);
		case Constant.Mazda.DATA_TXT_INFO:
			return analyzeTxtInfo(intackBytes);
		case Constant.Mazda.DATA_OIL_INFO:
			return analyzeOilInfo(intackBytes);
		}
		return null;
	}
	
	private List<BaseInfo> analyzeOilInfo(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte high = intackBytes[Constant.DATA14_XINPU];
		byte low = intackBytes[Constant.DATA15_XINPU];
		float averageFuel = ByteUtil.HighLowByteToInt(high,low)/10;
		mCarLargeInfo.setAverageFuel(averageFuel);
		baseInfolList.add(mCarLargeInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeCorner(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		// data1 方向盘转角高位
		byte data1 = intackBytes[Constant.DATA1_XINPU];
		// data7 方向盘转角低位
		byte data0 = intackBytes[Constant.DATA0_XINPU];
		String corHighString = ByteUtil.parseByteToHexString(data1, null);
		String corLowString = ByteUtil.parseByteToHexString(data0, null);
		int leftCor = PROTOCAL_INVALID_VALUE;
		int rightCor = PROTOCAL_INVALID_VALUE;
		if (data1 < 0) {
			leftCor = ByteUtil.HighLowByteToInt(data1,data0) - 65536;
			leftCor = leftCor/8;
		} else {
			rightCor = ByteUtil.HighLowByteToInt(data1,data0);
			rightCor = rightCor/8;
		}
		mCornerInfo.setLeftCorner(leftCor);
		mCornerInfo.setRightCorner(rightCor);
		baseInfolList.add(mCornerInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeDeviceInfo(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		mCDInfo.setComIdType(Constant.Mazda.DATA_DEVICE_INFO);
		int data0 = ByteUtil.convertByteToInt(intackBytes[Constant.DATA0_XINPU]);
		if (data0==0x80) {
			mCDInfo.setCdOk(true);
		}else {
			mCDInfo.setCdOk(false);
		}
		//总曲目
		byte high = intackBytes[Constant.DATA3_XINPU];
		byte low =  intackBytes[Constant.DATA4_XINPU];
		int allSongNum = ByteUtil.HighLowByteToInt(high,low);
		mCDInfo.setAllSongNum(allSongNum);
		baseInfolList.add(mCDInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeTxtInfo(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		mCDInfo.setComIdType(Constant.Mazda.DATA_TXT_INFO);
		analyzeTxtInfoData0(intackBytes,mCDInfo);
		analyzeTxtInfoData1(intackBytes,mCDInfo);
		
		baseInfolList.add(mCDInfo);
		return baseInfolList;
	}

	private void analyzeTxtInfoData1(Byte[] intackBytes, CDInfo mCDInfo) {
		byte data1 = intackBytes[Constant.DATA1_XINPU];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT7);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT6);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT5);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT4);
		byte codeType = (byte) (bit7*8+bit6*4+bit5*2+bit4);
		if (codeType==1) {
			codeType = Constant.TEXT_STATE_UNICODE_B;
		}else if (codeType==2) {
			codeType = Constant.TEXT_STATE_UNICODE_S;
		}else if (codeType==3) {
			codeType = Constant.TEXT_STATE_UTF8;
		}else {
			codeType = Constant.TEXT_STATE_ASCII;
		}
		mCDInfo.setCodeType(codeType);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT2);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data1, Constant.BIT0);
		byte textState = (byte) (bit3*8+bit2*4+bit1*2+bit0);
		if (textState==1) {
		   mCDInfo.setTextStateOk(true);
		   analyzeTxtContentInfo(intackBytes,mCDInfo);
		}else {
			 mCDInfo.setTextStateOk(false);
		}
	}
	
	private void analyzeTxtContentInfo(Byte[] intackBytes, CDInfo mCDInfo) {
		switch (mCDInfo.getCodeType()) {
		case Constant.TEXT_STATE_ASCII:
			analyzeText(intackBytes,mCDInfo,"gb2312");
			break;
        case Constant.TEXT_STATE_UTF8:
        	analyzeText(intackBytes,mCDInfo,"UTF-8");
			break;
        case Constant.TEXT_STATE_UNICODE_S:
        	analyzeText(intackBytes,mCDInfo,"UTF-16LE");
			break;
        case Constant.TEXT_STATE_UNICODE_B:
        	analyzeText(intackBytes,mCDInfo,"UTF-16BE");
			break;
		}
	}

	private void analyzeText(Byte[] intackBytes, CDInfo mCDInfo,String codeModeString) {
		int dataLength = intackBytes[Constant.LENGTH_XINPU]-2;
		int asciiLength = 0;
		byte[] dataBytes = new byte[dataLength];
		for (int i = 0; i < dataLength; i++) {
			if ((byte)intackBytes[ i+Constant.DATA2_XINPU] == 0) {
				asciiLength = i;
				break;
			}
			dataBytes[i] =  (byte)intackBytes[ i+Constant.DATA2_XINPU];
		}
		byte[] asciiBytes =  new byte[asciiLength];
		System.arraycopy(dataBytes, 0, asciiBytes, 0, asciiLength);
		String contentString = ByteUtil.byteArrayToChinese(asciiBytes,codeModeString);
		mCDInfo.setTextContent(contentString);
	}

	private void analyzeTxtInfoData0(Byte[] intackBytes, CDInfo mCDInfo) {
		byte data0 = intackBytes[Constant.DATA0_XINPU];
		if (data0 == 0) {
			mCDInfo.setTextType(Constant.TEXT_NAME_SONG);
		}else if (data0 == 1) {
			mCDInfo.setTextType(Constant.TEXT_NAME_FOLD);
		}else if (data0 == 2) {
			mCDInfo.setTextType(Constant.TEXT_NAME_DISC);
		}else if (data0 == 3) {
			mCDInfo.setTextType(Constant.TEXT_NAME_ART);
		} 
	}

	private List<BaseInfo> analyzePlayInfo(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		mCDInfo.setComIdType(Constant.Mazda.DATA_PLAY_INFO);
		analyzePlayData1(intackBytes,mCDInfo);
		analyzePlayData2(intackBytes,mCDInfo);
		//当前文件夹
		byte high = intackBytes[Constant.DATA3_XINPU];
		byte low =  intackBytes[Constant.DATA4_XINPU];
		int current = ByteUtil.HighLowByteToInt(high,low);
		mCDInfo.setCurFold(current);
		//当前曲目
		high = intackBytes[Constant.DATA5_XINPU];
		low =  intackBytes[Constant.DATA6_XINPU];
		current = ByteUtil.HighLowByteToInt(high,low);
		mCDInfo.setCurSong(current);
		//曲目总时间
		high = intackBytes[Constant.DATA7_XINPU];
		low =  intackBytes[Constant.DATA8_XINPU];
		current = ByteUtil.HighLowByteToInt(high,low);
		mCDInfo.setSongAllTime(current);
		//当前曲目时间
		high = intackBytes[Constant.DATA9_XINPU];
		low =  intackBytes[Constant.DATA10_XINPU];
		current = ByteUtil.HighLowByteToInt(high,low);
		mCDInfo.setCurSongTime(current);
		baseInfolList.add(mCDInfo);
		return baseInfolList;
	}

	private void analyzePlayData1(Byte[] intackBytes, CDInfo mCDInfo) {
		byte data1 = intackBytes[Constant.DATA1_XINPU];
		initCdPlaySstate();
		switch (data1) {
		case 0:
			mCDInfo.setStop(true);
			break;
		case 1:
			mCDInfo.setPause(true);
			break;
		case 2:
			mCDInfo.setPlay(true);
			break;
		case 3:
			mCDInfo.setDiscOut(true);
			break;
		case 4:
			mCDInfo.setReading(true);
			break;
		}
	}

	private void initCdPlaySstate() {
		mCDInfo.setStop(false);
		mCDInfo.setPause(false);
		mCDInfo.setPlay(false);
		mCDInfo.setDiscOut(false);
		mCDInfo.setReading(false);
	}

	private void analyzePlayData2(Byte[] intackBytes, CDInfo mCDInfo) {
		byte data2 = intackBytes[Constant.DATA2_XINPU];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT7);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT6);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT5);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT4);
		byte rpt = (byte) (bit7*8+bit6*4+bit5*2+bit4);
		mCDInfo.setRptMode(rpt);
		
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT3);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT2);
		byte bit1 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT1);
		byte bit0 = ByteUtil.onCheckOutBitAtIndex(data2, Constant.BIT0);
		byte rdm = (byte) (bit3*8+bit2*4+bit1*2+bit0);
		mCDInfo.setRdmMode(rdm);
	}

	private List<BaseInfo> analyzeBackLight(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data0 = intackBytes[Constant.DATA0_XINPU];
		mCarBaseInfo.setILL(data0 == 0 ? true : false);
		baseInfolList.add(mCarBaseInfo);
		return baseInfolList;
	}

	
	private List<BaseInfo> analyzeRadar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		mRadarInfo.setFrontLeftValue(getRadarDistanse(intackBytes[Constant.DATA1_XINPU]));
		mRadarInfo.setFrontMidLeftValue(getRadarDistanse(intackBytes[Constant.DATA2_XINPU])); 
		mRadarInfo.setFrontMidRightValue(getRadarDistanse(intackBytes[Constant.DATA2_XINPU]));
		mRadarInfo.setFrontRightValue(getRadarDistanse(intackBytes[Constant.DATA3_XINPU]));
		mRadarInfo.setBackLeftValue(getRadarDistanse(intackBytes[Constant.DATA4_XINPU]));
		mRadarInfo.setBackMidLeftValue(getRadarDistanse(intackBytes[Constant.DATA5_XINPU])); 
		mRadarInfo.setBackMidRightValue(getRadarDistanse(intackBytes[Constant.DATA5_XINPU]));
		mRadarInfo.setBackRightValue(getRadarDistanse(intackBytes[Constant.DATA6_XINPU]));
		baseInfolList.add(mRadarInfo);
		return baseInfolList;
	}

	private int getRadarDistanse(Byte byte1) {
		int distance = 255;
		switch (byte1) {
		case 0x1:
			distance = 0;
			break;
		case 0x2:
			distance = 85;
			break;
		case 0x3:
			distance = 170;
			break;
		case 0x4:
			distance = 255;
			break;
		}
		return distance;
	}
	
	private List<BaseInfo> analyzeBaseCar(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data = intackBytes[Constant.DATA0_XINPU];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT7);
		mDoorInfo.setDriverDoor(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT6);
		mDoorInfo.setPassengerDoor(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT5);
		mDoorInfo.setLeftBackDoor(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT4);
		mDoorInfo.setRightBackDoor(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT3);
		mDoorInfo.setBackTrunk(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT2);
		mDoorInfo.setEngineHood(bit2 == 1 ? true : false);
		baseInfolList.add(mDoorInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeSteerKey(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		
		// data1 按键状态 
		byte data1 = intackBytes[Constant.DATA1_XINPU];
		if (data1 == 1) {
			mKeyFunctionInfo.setKeyDown(true);
		}else if (data1 ==2) {
			mKeyFunctionInfo.setSteeringKeyLongDown(true);
		}
//		mKeyFunctionInfo.setStepValueMax(30);
		byte data0 = intackBytes[Constant.DATA0_XINPU];
		if (data0==(byte)0xf0 || data0==(byte)0xf1) {
			analyzeKnobFuction(mKeyFunctionInfo, data0, data1);
		}else if (mKeyFunctionInfo.isKeyDown()||mKeyFunctionInfo.isSteeringKeyLongDown()) {
			analyzeKeyFuction(mKeyFunctionInfo, data0);
		}
		
		baseInfolList.add(mKeyFunctionInfo);
		return baseInfolList;
	}
	
	private void analyzeKnobFuction(KeyFunctionInfo mKeyFunctionInfo, byte data0, byte data1) {
		if (data1 != 0) {
			switch (data0) {
			case (byte) 0xf0:
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_UP);
				// 步进值
				mKeyFunctionInfo.setStepValue(ByteUtil.convertByteToInt(data1));
				break;
			case (byte) 0xf1:
				mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOLUME_DOWN);
				// 步进值
				mKeyFunctionInfo.setStepValue(ByteUtil.convertByteToInt(data1));
				break;
			}
		}
	}

	private void analyzeKeyFuction(KeyFunctionInfo mKeyFunctionInfo, byte data0) {
		switch (data0) {
		case 1:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_UP);
			break;
		case 2:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_DOWN);
			break;
		case 3:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);
			break;
		case 4:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
			break;
		case 8:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
			break;
		case 9:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_VOICE);
			break;	
		case 0x0a:// 接电话
			mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_ANSWER);
			break;
		case 0x0b:// 挂电话
			mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_HANGUP);
			break;	
		case 0x20:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		case 0x21:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_HOME);
			break;
		case 0x22:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_NAVI);
			break;
		case 0x23:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_COLLEC_RADIO);
			break;
		case 0x29:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_POWER);
			break;
		case 0x2a:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_BACK);
			break;
			
		}
	}

	/**
	 * 校验
	 */
	@Override
	public boolean onCheckBytesValidity(Byte[] orderBytes) {
		boolean resultCode = false;
		if (null != orderBytes && 3 < orderBytes.length) {
			int sum = 0;
			for (int index = 1; index < orderBytes.length - 1; index++) {
				sum += orderBytes[index];
			}
			byte checkSum = (byte) (sum ^ checkCode);
			resultCode = (orderBytes[orderBytes.length - 1]) == checkSum;
			LogManager.d("MazdaParse  onCheckBytesValidity  check_Sum:  "
					+ checkSum + "   check_bit:"
					+ orderBytes[orderBytes.length - 1]);
		}
		return resultCode;
	}

}
