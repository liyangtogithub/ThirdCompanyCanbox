package com.landsem.canboxui.myinterface;

import android.app.Service;

public interface CdInterface {
	public void registUICallback (CdInterfaceCallback mCdInterfaceCallback);

	Service getService();
}
