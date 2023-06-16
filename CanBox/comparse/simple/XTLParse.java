package com.landsem.canbox.comparse.simple;

import java.util.ArrayList;
import java.util.List;

import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.BaseInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.tools.ByteUtil;
import com.landsem.common.tools.LogManager;

import android.view.KeyEvent;

/**
 * 欣朴软件_日产2013新天秤串口通信协议V1.09.001
 * @author LQPDC
 *
 */
public final class XTLParse extends SimpleBaseParse {


	private static final String TAG = XTLParse.class.getSimpleName();
	
	public XTLParse() {
		super((byte) 0xFF, (byte) 0x2e, (byte) 0xA5);
	}
	
	@Override
	public List<BaseInfo> doParseOrderBytes(Byte[] intackBytes) {
		byte comID = intackBytes[COMID_XINPU];
		List<BaseInfo> infoList = new ArrayList<BaseInfo>();
		switch (comID) {
		case SLAVE_HOST_WHEEL_KEY:
			analyzeWheelKey(infoList, intackBytes[3], intackBytes[4]);
			break;
		default:
			break;
		}
		return infoList;
	}
	
	private void analyzeWheelKey(List<BaseInfo> infoList, Byte keyCode, Byte keyStatus) {
		if (keyStatus==0) {
			return;
		}
		KeyFunctionInfo mKeyFunctionInfo = new KeyFunctionInfo();
		if (keyStatus ==2) {
			mKeyFunctionInfo.setSteeringKeyLongDown(true);
	    }
		int code = ByteUtil.convertByteToInt(keyCode);
		switch (code) {
		case 0x00://没有按键弹起
			mKeyFunctionInfo = null;
			break;
		case 0x01://音量加
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_UP);
			break;
		case 0x02://音量减
			mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_VOLUME_DOWN);
			break;
		case 0x03://UP
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
			break;
		case 0x04://DOWN
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_MEDIA_NEXT);
			break;
		case 0x07://SRC
        	mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_MODE);
			break;
		case 0x09://接听电话
        	mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_ANSWER);
			break;
		case 0x0A://挂断电话
        	mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_HANGUP);
			break;
		case 0x15://Return
        	mKeyFunctionInfo.setSteerKeyFuction(KeyEvent.KEYCODE_BACK);
			break;
		case 0x87://Power
        	mKeyFunctionInfo.setSteerKeyFuction(KEYEVENT_POWER);
			break;
		default:
			break;
		}
		if (null!=mKeyFunctionInfo) infoList.add(mKeyFunctionInfo);
		
	}

}
