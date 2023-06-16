package com.landsem.canbox.comparse.raise;

import java.util.ArrayList;
import java.util.List;

import com.landsem.canbox.Constant;
import com.landsem.canbox.Constant.BaoJunComID;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.CornerInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.comparse.simple.SimpleBaseParse;
import com.landsem.canbox.pack.SimpleBaseComPack;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;

import android.view.KeyEvent;
/**
 *  î£Ö¾³Ï  £º±¦¿¥
 */
public final class BaoJunParse extends RaiseBaseParse implements BaoJunComID{
	
	public BaoJunParse() {
		super((byte) 0xFF, (byte) 0x2e, (byte) 0xA5);
	}

	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		ByteUtil.onPrintByteArray(intackBytes, "BaoJunParse--data: ");
		byte comID = intackBytes[Constant.COMID_XINPU];
		switch (comID) {
		case BaoJunComID.DATA_TYPE_KEY:
			return analyzeSteerKey(intackBytes);
		case DATA_TYPE_RADAR_B:
			return analyzeRadarBack(intackBytes);
		case DATA_TYPE_RADAR_F:
			return analyzeRadarFront(intackBytes);	
		case DATA_TYPE_BASE:
			return analyzeDoor(intackBytes);
		case DATA_TYPE_CORNER:
			return analyzeCorner(intackBytes);
		}
		return null;
	}

	private List<BaseInfo> analyzeCorner(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte dataH = intackBytes[Constant.DATA1_XINPU];
		byte dataL =  intackBytes[Constant.DATA0_XINPU];
		
		// ·½ÏòÅÌ×ª½Ç
		short dregress = (short) ((dataH << 8) + (dataL & 0xFF));
		short tempH = (short) (dataH << 8);
		short tempL = (short) (dataL & 0xFF);
		if (tempH>=0) {
			dregress = (short) (tempH + tempL);
			dregress = (short) (dregress/18);
		} else {
			dregress = (short) ~dregress;
			dregress = (short) (dregress + 1);
			dregress = (short) (dregress/18);
			dregress = (short)(-(dregress & 0x07FF));
		}
		int leftCor = PROTOCAL_INVALID_VALUE;
		int rightCor = PROTOCAL_INVALID_VALUE;
		if (dregress>540) dregress = 540;
		if (dregress<-540) dregress = -540;
		if (dregress > 0) {
			rightCor = dregress;
		} else if (dregress < 0) {
			leftCor = dregress;
		} else {
			rightCor = leftCor = dregress;
		}
		mCornerInfo.setLeftCorner(leftCor);
		mCornerInfo.setRightCorner(rightCor);
		baseInfolList.add(mCornerInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeDoor(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		byte data = intackBytes[Constant.DATA0_XINPU];
		byte bit7 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT7);
		mDoorInfo.setPassengerDoor(bit7 == 1 ? true : false);
		byte bit6 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT6);
		mDoorInfo.setDriverDoor(bit6 == 1 ? true : false);
		byte bit5 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT5);
		mDoorInfo.setRightBackDoor(bit5 == 1 ? true : false);
		byte bit4 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT4);
		mDoorInfo.setLeftBackDoor(bit4 == 1 ? true : false);
		byte bit3 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT3);
		mDoorInfo.setBackTrunk(bit3 == 1 ? true : false);
		byte bit2 = ByteUtil.onCheckOutBitAtIndex(data, Constant.BIT2);
		mDoorInfo.setEngineHood(bit2 == 1 ? true : false);
		baseInfolList.add(mDoorInfo);
		return baseInfolList;
	}

	private List<BaseInfo> analyzeRadarBack(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		mRadarInfo.setBackLeftValue(getRadarDistanse(intackBytes[Constant.DATA0_XINPU]));
		mRadarInfo.setBackMidLeftValue(getRadarDistanse(intackBytes[Constant.DATA1_XINPU])); 
		mRadarInfo.setBackMidRightValue(getRadarDistanse(intackBytes[Constant.DATA2_XINPU]));
		mRadarInfo.setBackRightValue(getRadarDistanse(intackBytes[Constant.DATA3_XINPU]));
		baseInfolList.add(mRadarInfo);
		return baseInfolList;
	}
	
	private List<BaseInfo> analyzeRadarFront(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		mRadarInfo.setFrontLeftValue(getRadarDistanse(intackBytes[Constant.DATA0_XINPU]));
		mRadarInfo.setFrontMidLeftValue(getRadarDistanse(intackBytes[Constant.DATA1_XINPU])); 
		mRadarInfo.setFrontMidRightValue(getRadarDistanse(intackBytes[Constant.DATA2_XINPU]));
		mRadarInfo.setFrontRightValue(getRadarDistanse(intackBytes[Constant.DATA3_XINPU]));
		baseInfolList.add(mRadarInfo);
		return baseInfolList;
	}

	private int getRadarDistanse(Byte byte1) {
		int distance = 255;
		if ( byte1<=4 && byte1>0 ) {
			distance = 85*(byte1-1);
		}
		return distance;
	}

	private List<BaseInfo> analyzeSteerKey(Byte[] intackBytes) {
		List<BaseInfo> baseInfolList = new ArrayList<BaseInfo>();
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		// data1 °´¼ü×´Ì¬
		byte data1 = intackBytes[Constant.DATA1_XINPU];
		if (data1 == 1) {
			mKeyFunctionInfo.setKeyDown(true);
		}else if (data1 ==2) {
			mKeyFunctionInfo.setSteeringKeyLongDown(true);
		}
		byte data0 = intackBytes[Constant.DATA0_XINPU];
		if(mKeyFunctionInfo.isKeyDown()||mKeyFunctionInfo.isSteeringKeyLongDown()) {
			analyzeKeyFuction(mKeyFunctionInfo, data0);
		}
		baseInfolList.add(mKeyFunctionInfo);
		return baseInfolList;
	}

	private void analyzeKeyFuction(KeyFunctionInfo mKeyFunctionInfo, byte data0) {
		switch (data0) {
	   case 0x01:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_UP);
			break;
	   case 0x02:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_DOWN);
			break;
		case 0x06:
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_MUTE);
			break;
		case 0x07:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_MODE);
			break;
		case  0x09:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_ANSWER);
			break;  
		case  0x0a:
			mKeyFunctionInfo.setSteerKeyFuction(Constant.KEYEVENT_HANGUP);
			break;
		case 0x0b:
			    mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
			    break;
		case 0x0c:
			    mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);
			    break;
		}
	}
	
}
