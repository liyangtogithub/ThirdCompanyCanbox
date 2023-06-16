package com.landsem.canboxui.utils;

import android.content.Context;
import android.media.AudioManager;
import android.view.KeyEvent;

import com.landsem.canbox.CanBoxApp;
import com.landsem.canbox.Constant;
import com.landsem.canbox.ProtocolID;
import com.landsem.canbox.pack.hiworld.DasAutoPack;
import com.landsem.canbox.pack.hiworld.KoDiakPack;
import com.landsem.canbox.pack.simple.DasAuto1Pack;
import com.landsem.canbox.pack.simple.DasAuto2Pack;
import com.landsem.canbox.pack.simple.FocusPack;
import com.landsem.canbox.pack.simple.Toyot1Pack;
import com.landsem.canboxui.aidl.DVDInfo;
import com.landsem.canboxui.aidl.MediaInfo;
import com.landsem.canboxui.aidl.PhoneInfo;
import com.landsem.canboxui.aidl.RadioInfo;
import com.landsem.canboxui.service.PushService;
import com.landsem.common.tools.LogManager;

public final class PushUtil {
	
	
	public static void pushStartOrder(ProtocolID mPID) {
		if (mPID==null) {
			return;
		}
		LogManager.d(ConstantUtil.TAG,"push -SEND -  startOrder");
		if (mPID.ordinal() == ProtocolID.ID_SIMPLE_DASAUTO1.ordinal()) {
			DasAuto1Pack.getInstance().startOrder();
		}else if (mPID.ordinal() == ProtocolID.ID_SIMPLE_DASAUTO2.ordinal()) {
			DasAuto2Pack.getInstance().startOrder();
		}else if (mPID.ordinal() == ProtocolID.ID_SIMPLE_TOYOT1.ordinal()) {
			Toyot1Pack.getInstance().startOrder();
		}else if (mPID.ordinal() == ProtocolID.ID_FOCUS.ordinal()) {
			FocusPack.getInstance().startOrder();
		}
	}

	public static void sendSourceOrder(ProtocolID mPID, String mSource) {
		if (mPID==null) {
			return;
		}
		LogManager.d(ConstantUtil.TAG,"push -SEND -  sendSourceOrder");
		if (mPID.ordinal() == ProtocolID.ID_SIMPLE_DASAUTO1.ordinal()) {
			DasAuto1Pack.getInstance().sendSource(mSource);
		}
	}

	public static void sendDVDInfoOrder(ProtocolID mPID, DVDInfo mDVDInfo) {
		if (mPID==null) {
			return;
		}
		LogManager.d(ConstantUtil.TAG,"push -SEND -  sendDVDInfoOrder");
		if (mPID.ordinal() == ProtocolID.ID_SIMPLE_DASAUTO1.ordinal()) {
			DasAuto1Pack.getInstance().sendSource(mDVDInfo.mSource);
			DasAuto1Pack.getInstance().sendMediaCDInfo(mDVDInfo);
		}else if (mPID.ordinal() == ProtocolID.ID_SIMPLE_DASAUTO2.ordinal()) {
			DasAuto2Pack.getInstance().sendSource(mDVDInfo.mSource);
			DasAuto2Pack.getInstance().sendMediaCDInfo(mDVDInfo);
		}else if (mPID.ordinal() == ProtocolID.ID_HIWORLD_DASAUTO.ordinal()) {
			DasAutoPack.getInstance().sendMediaCDInfo(mDVDInfo);
		}else if (mPID.ordinal() == ProtocolID.ID_HIWORLD_KODIAK.ordinal()) {
			KoDiakPack.getInstance().sendMediaCDInfo(mDVDInfo);
		}
	}

	public static void sendMediaInfoOrder(ProtocolID mPID, MediaInfo mMediaInfo) {
		if (mPID==null) {
			return;
		}
		LogManager.d(ConstantUtil.TAG,"push -SEND -  sendMediaInfoOrder");
		if (mPID.ordinal() == ProtocolID.ID_SIMPLE_DASAUTO1.ordinal()) {
			DasAuto1Pack.getInstance().sendSource(mMediaInfo.mSource);
			DasAuto1Pack.getInstance().sendMediaInfo(mMediaInfo);
		}else if (mPID.ordinal() == ProtocolID.ID_SIMPLE_DASAUTO2.ordinal()) {
			DasAuto2Pack.getInstance().sendSource(mMediaInfo.mSource);
			DasAuto2Pack.getInstance().sendMediaInfo(mMediaInfo);
		}else if (mPID.ordinal() == ProtocolID.ID_HIWORLD_DASAUTO.ordinal()) {
			DasAutoPack.getInstance().sendMediaInfo(mMediaInfo);
		}else if (mPID.ordinal() == ProtocolID.ID_HIWORLD_KODIAK.ordinal()) {
			KoDiakPack.getInstance().sendMediaInfo(mMediaInfo);
		}
	}

	public static void sendRadioInfoOrder(ProtocolID mPID, RadioInfo mRadioInfo) {
		if (mPID==null) {
			return;
		}
		LogManager.d(ConstantUtil.TAG,"push -SEND -  sendRadioInfoOrder");
		if (mPID.ordinal() == ProtocolID.ID_SIMPLE_DASAUTO1.ordinal()) {
			DasAuto1Pack.getInstance().sendSource(mRadioInfo.mSource);
			DasAuto1Pack.getInstance().sendRadio(mRadioInfo);
		}else if (mPID.ordinal() == ProtocolID.ID_SIMPLE_DASAUTO2.ordinal()) {
			DasAuto2Pack.getInstance().sendSource(mRadioInfo.mSource);
			DasAuto2Pack.getInstance().sendRadio(mRadioInfo);
		}else if (mPID.ordinal() == ProtocolID.ID_HIWORLD_DASAUTO.ordinal()) {
			DasAutoPack.getInstance().sendRadio(mRadioInfo);
		}else if (mPID.ordinal() == ProtocolID.ID_HIWORLD_KODIAK.ordinal()) {
			KoDiakPack.getInstance().sendRadio(mRadioInfo);
		}
	}

	public static void sendPhoneInfoOrder(ProtocolID mPID, PhoneInfo mPhoneInfo) {
		if (mPID==null) {
			return;
		}
		LogManager.d(ConstantUtil.TAG,"push -SEND -  sendPhoneInfoOrder");
		if (mPID.ordinal() == ProtocolID.ID_SIMPLE_DASAUTO1.ordinal()) {
			DasAuto1Pack.getInstance().sendSource(mPhoneInfo.mSource);
			DasAuto1Pack.getInstance().sendPhoneInfo(mPhoneInfo);
		}else if (mPID.ordinal() == ProtocolID.ID_SIMPLE_DASAUTO2.ordinal()) {
			DasAuto2Pack.getInstance().sendSource(mPhoneInfo.mSource);
			DasAuto2Pack.getInstance().sendPhoneInfo(mPhoneInfo);
		}else if (mPID.ordinal() == ProtocolID.ID_HIWORLD_DASAUTO.ordinal()) {
			DasAutoPack.getInstance().sendPhoneInfo(mPhoneInfo);
		}else if (mPID.ordinal() == ProtocolID.ID_HIWORLD_KODIAK.ordinal()) {
			KoDiakPack.getInstance().sendPhoneInfo(mPhoneInfo);
		}
	}

	public static void sendCurrentVolume(byte CurrentVolume) {
		if (CanBoxApp.getMyPID()==null) {
			return;
		}
	   /*case Constant.KEYEVENT_VOLUME_UP:
	     case Constant.KEYEVENT_VOLUME_DOWN:
	     case KeyEvent.KEYCODE_VOLUME_UP:
	     case KeyEvent.KEYCODE_VOLUME_DOWN:
	     case KeyEvent.KEYCODE_VOLUME_MUTE:*/
		LogManager.d(ConstantUtil.TAG,"push -SEND -  sendCurrentVolume");
		if (CanBoxApp.getMyPID().ordinal() == ProtocolID.ID_SIMPLE_DASAUTO1.ordinal()) {
			DasAuto1Pack.getInstance().sendSoundInfo(CurrentVolume);
		}else if (CanBoxApp.getMyPID().ordinal() == ProtocolID.ID_SIMPLE_DASAUTO2.ordinal()) {
			DasAuto2Pack.getInstance().sendSoundInfo(CurrentVolume);
		}
	}
	
}
