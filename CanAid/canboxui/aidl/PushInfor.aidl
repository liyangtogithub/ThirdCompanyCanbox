package com.landsem.canboxui.aidl;

import com.landsem.canboxui.aidl.RadioInfo;
import com.landsem.canboxui.aidl.MediaInfo;
import com.landsem.canboxui.aidl.DVDInfo;
import com.landsem.canboxui.aidl.NAVIInfo;
import com.landsem.canboxui.aidl.PhoneInfo;

interface PushInfor {
	/***mSource---发字符串    导航：NAVI; 收音机：Tuner; 本地音乐/视频：USB/SD 电话：Phone; DVD:Disc; Aux:Aux: Other:Other*/
	void changeSource(String mSource);
	void sendRadioInfo(in RadioInfo mRadioInfo);
	void sendPhoneInfo(in PhoneInfo mPhoneInfo);
	void sendMediaInfo(in MediaInfo mMediaInfo);
	void sendDVDInfo(in DVDInfo mDVDInfo);
	void sendNAVIInfo(in NAVIInfo mNAVIInfo);
}
