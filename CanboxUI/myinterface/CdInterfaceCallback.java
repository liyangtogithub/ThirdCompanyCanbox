package com.landsem.canboxui.myinterface;

import com.landsem.canbox.bean.CDInfo;

public interface CdInterfaceCallback {

	void updateCdPlayState(CDInfo mCDInfo);

	void updateCdProgressInfo(CDInfo mCDInfo);

	void updateCdSongInfo(CDInfo mCDInfo);

}
