package com.landsem.canboxui.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.landsem.canboxui.R;
import com.landsem.canboxui.carrier.CarLightsCarrier;
import com.landsem.canboxui.carrier.CarLockCarrier;
import com.landsem.canboxui.carrier.CarOtherSettingCarrier;
import com.landsem.canboxui.carrier.CarTypeSetCarrier;
import com.landsem.canboxui.carrier.RadarCarrier;
import com.landsem.canboxui.view.MenuTextView;
import com.landsem.common.tools.LogManager;
import com.landsem.common.tools.StringUtils;
import com.lqpdc.commonlib.view.ActionProcessButton;

@SuppressWarnings("serial")
public class CarSetFragment extends BaseFragment {
	Context mContext;
	private CarTypeSetCarrier mCarTypeSetCarrier;
	private CarLightsCarrier lightsCarrier;
	private CarLockCarrier lockCarrier;
	private RadarCarrier radarCarrier;
	private CarOtherSettingCarrier otherCarrier;

	private TextView carLights_option,carLock_Option,radar_option,other_option,carTypes_option;
	View currenView = null;

	public CarSetFragment() {
		super();
		injectResource(R.layout.car_set_layout);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = getActivity();
	}
	
	@Override
	public void initViews(View converView) {
		contentLayout = (LinearLayout) converView.findViewById(R.id.carSettings_content);
		carTypes_option = (TextView) converView.findViewById(R.id.carTypes_option);
		carLights_option = (TextView) converView.findViewById(R.id.carLights_option);
		carLock_Option = (TextView) converView.findViewById(R.id.carLock_Option);
		radar_option = (TextView) converView.findViewById(R.id.radar_option);
		other_option = (TextView) converView.findViewById(R.id.other_option);
		currenView = carTypes_option;
		initGravity();
	}

	private void initGravity() {
		int gravity = Gravity.CENTER;
		carLights_option.setGravity(gravity);
		carLock_Option.setGravity(gravity);
		radar_option.setGravity(gravity);
		other_option.setGravity(gravity);
		carTypes_option.setGravity(gravity);
	}

	@Override
	public void initListener() {
		carLights_option.setOnClickListener(this);
		carLock_Option.setOnClickListener(this);
		radar_option.setOnClickListener(this);
		other_option.setOnClickListener(this);
		carTypes_option.setOnClickListener(this);
		onClick(carTypes_option);
		initUI();
	}
	
	private void initUI() {
		if(null!=contentLayout){
			contentLayout.removeAllViews();
		    createCarTypeCarrier();
		    contentLayout.addView(mCarTypeSetCarrier.contentView);
		}
	}

	@Override
	public void onClick(View view) {
		currenView = view;
		if (null != view && view instanceof MenuTextView&& doChangeEnabled((TextView) view))
			;
			switch (view.getId()) {
			case R.id.carTypes_option:
					if(null!=contentLayout) contentLayout.removeAllViews();
					createCarTypeCarrier();
					contentLayout.addView(mCarTypeSetCarrier.contentView);
				break;
			case R.id.carLights_option:
					if(null!=contentLayout) contentLayout.removeAllViews();
					createCarLightsCarrier();
					contentLayout.addView(lightsCarrier.contentView);
				break;
			case R.id.carLock_Option:
					if(null!=contentLayout) contentLayout.removeAllViews();
					createCarLockCarrier();
					contentLayout.addView(lockCarrier.contentView);
				break;
			case R.id.radar_option:
					if(null!=contentLayout) contentLayout.removeAllViews();
					createRadarCarrier();
					contentLayout.addView(radarCarrier.contentView);
				break;
			case R.id.other_option:
					if(null!=contentLayout) contentLayout.removeAllViews();
					createOtherCarrier();
					contentLayout.addView(otherCarrier.contentView);
				break;
			}
	}
	
	private void createCarTypeCarrier() {
		if (null == mCarTypeSetCarrier)
			mCarTypeSetCarrier = new CarTypeSetCarrier(mContext, inflater,R.layout.car_type_carrier);
	}
	
	private void createCarLightsCarrier() {
		if (null == lightsCarrier)
			lightsCarrier = new CarLightsCarrier(mContext, inflater,R.layout.carlight_carrier_layout);
	}
	
	private void createCarLockCarrier() {
		if (null == lockCarrier)
			lockCarrier = new CarLockCarrier(mContext, inflater,R.layout.carlock_carrier_layout);
	}
	
	private void createRadarCarrier() {
		if (null == radarCarrier)
			radarCarrier = new RadarCarrier(mContext, inflater,R.layout.radar_carrier_layout);
	}

	private void createOtherCarrier() {
		if (null == otherCarrier)
			otherCarrier = new CarOtherSettingCarrier(mContext, inflater,R.layout.carothersetting_carrier_layout);
	}

	@Override
	public void doOnResume() {
	}

	@Override
	public void doOnPause() {
	}
	
}
