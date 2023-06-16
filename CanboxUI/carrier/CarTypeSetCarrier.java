
package com.landsem.canboxui.carrier;

import java.util.ArrayList;
import java.util.List;

import com.landsem.canbox.CanBoxApp;
import com.landsem.canbox.ProtocolID;
import com.landsem.canbox.manager.SerialManager;
import com.landsem.canbox.tools.ProtocoChoicelUtils;
import com.landsem.canboxui.R;
import com.landsem.canboxui.adapter.CarTypeAdapter;
import com.landsem.canboxui.utils.ConstantUtil;
import com.landsem.canboxui.utils.PushUtil;
import com.landsem.common.tools.LogManager;
import com.landsem.common.tools.StringUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class CarTypeSetCarrier  extends BaseCarrier implements OnItemClickListener{
	
	Context mContext;
	private ListView carTitleListView;
	private ListView carChoiceListView;
	private ListView carCanListView;
	private CarTypeAdapter mCarTitleAdapter;
	private CarTypeAdapter mCarChoiceAdapter;
	private CarTypeAdapter mCarCanAdapter;
	TextView cartitleTextView , carChoiceTextView , carCanTextView;  
	int carTitlePosition = 0;
	int carChoicePosition = 0;
	int carCanPosition = 0;
	
	/*** ��ϵ����һ���б� */
	private List<String> carTitleList = new ArrayList<String>();
	/*** ����ѡ�񣨵ڶ����б� */
	private List<String> carChoiceList = new ArrayList<String>();
	/*** Э��У��������б� */
	private List<String> carCanList = new ArrayList<String>();
	/*** ����ѡ�񣨵ڶ����б����õ��ĸ��������� */
	int carTitleChildArray[] = null;
	
	public CarTypeSetCarrier(Context context,LayoutInflater inflater, int resource) {
		super(inflater, resource);
		mContext = context;
		initViews(contentView);
		initListener();
		initViewsState();
	}

	@Override
	protected void initViews(View convertView) {
		carTitleListView = (ListView) convertView.findViewById(R.id.car_title_list);
		carChoiceListView = (ListView) convertView.findViewById(R.id.car_choice_list);
		carCanListView = (ListView) convertView.findViewById(R.id.car_can_list);
		cartitleTextView = (TextView) convertView.findViewById(R.id.tv_car_title);
		carChoiceTextView = (TextView) convertView.findViewById(R.id.tv_car_choice);
		carCanTextView = (TextView) convertView.findViewById(R.id.tv_car_can);
	}
	
	@Override
	protected void initListener() {
		carTitleListView.setOnItemClickListener(this);
		carChoiceListView.setOnItemClickListener(this);
		carCanListView.setOnItemClickListener(this);
	}
	
	@Override
	protected void initViewsState() {
		mCarTitleAdapter = new CarTypeAdapter(mContext, carTitleList);
		mCarChoiceAdapter = new CarTypeAdapter(mContext, carChoiceList);
		mCarCanAdapter = new CarTypeAdapter(mContext,carCanList);
		carTitleListView.setAdapter(mCarTitleAdapter);
		carChoiceListView.setAdapter(mCarChoiceAdapter);
		carCanListView.setAdapter(mCarCanAdapter);
        String protocoName = ProtocoChoicelUtils.getProtocoName();
		if ( !StringUtils.isBlank(protocoName) ) {
			ProtocolID mPID = ProtocolID.valueOf(protocoName);
			carTitlePosition = switchcarTitlePosition(mPID);
			carChoicePosition = ProtocoChoicelUtils.getCarTypeIndex();
			carCanPosition = ProtocoChoicelUtils.getCarCanIndex();
		}else {
			carTitlePosition = 0;
			carChoicePosition = 6;//Ĭ��ͨ�ã�������
		}
		//1
		initCarTitleData();
		mCarTitleAdapter.setCurrentPosition(carTitlePosition);
		//2
		initCarTitleChildArray();
		initCarChoiceData(carTitlePosition);
		mCarChoiceAdapter.setCurrentPosition(carChoicePosition);
		//3
		initCarCanData();
		mCarCanAdapter.setCurrentPosition(carCanPosition);
		initTextView(carTitlePosition,carChoicePosition,carCanPosition);
	}
	

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long arg3) {
		if (parent.getId() == carTitleListView.getId()) {
			if(mCarTitleAdapter.isLocationValid(position)){
				carTitlePosition = position;
				carChoicePosition = CarTypeAdapter.INVALID_CURRENT_POSITION;
				updateCarTitleList(position);
				mCarChoiceAdapter.setCurrentPosition(CarTypeAdapter.INVALID_CURRENT_POSITION);
				initCarChoiceData(position);
				mCarCanAdapter.setCurrentPosition(CarTypeAdapter.INVALID_CURRENT_POSITION);
				initCarCanData();
				initTextView(position, CarTypeAdapter.INVALID_CURRENT_POSITION, CarTypeAdapter.INVALID_CURRENT_POSITION);
			}
		}
		if (parent.getId() == carChoiceListView.getId()) {
			if(mCarChoiceAdapter.isLocationValid(position)){
				carChoicePosition = position;
				updateCarChoiceList(position);
				initTextView(CarTypeAdapter.INVALID_CURRENT_POSITION, position, CarTypeAdapter.INVALID_CURRENT_POSITION);
				mCarCanAdapter.setCurrentPosition(CarTypeAdapter.INVALID_CURRENT_POSITION);
				initCarCanData();
			}
		}
		if (parent.getId() == carCanListView.getId()) {
			if(mCarCanAdapter.isLocationValid(position)){
			   carCanPosition  = position;
			   updateCarCanList(position);
			   carCanTextView.setText(carCanList.get(position));
			   changeProtocol();
			}
		}
	}
	
	private void updateCarCanList(int position) {
		mCarCanAdapter.setCurrentPosition( position);
		mCarCanAdapter.notifyDataSetChanged();
	}

	private void updateCarChoiceList(int position) {
		mCarChoiceAdapter.setCurrentPosition( position);
		mCarChoiceAdapter.notifyDataSetChanged();
	}

	private void updateCarTitleList(int position) {
		mCarTitleAdapter.setCurrentPosition(position);
		mCarTitleAdapter.notifyDataSetChanged();
	}

	private void initTextView(int titleIndex, int choiceIndex, int canIndex) {
		if (titleIndex!=CarTypeAdapter.INVALID_CURRENT_POSITION) {
			cartitleTextView.setText(carTitleList.get(titleIndex)); 
		}
		if (choiceIndex!=CarTypeAdapter.INVALID_CURRENT_POSITION) {
			carChoiceTextView.setText(carChoiceList.get(choiceIndex)); 
		}else {
			carChoiceTextView.setText(""); 
		}
		if (canIndex!=CarTypeAdapter.INVALID_CURRENT_POSITION) {
			carCanTextView.setText(carCanList.get(canIndex));
		}else {
			carCanTextView.setText(""); 
		}
	}
	
	/***��ʼ����һ���б����� */
	private void initCarTitleData() {
		String carTitleValueArray[] = mContext.getResources().getStringArray(R.array.carTitleValueArray);
		for (int i = 0; i < carTitleValueArray.length; i++) {
			carTitleList.add(carTitleValueArray[i]);
		}
		mCarTitleAdapter.setList(carTitleList);
	}
	
	/***��ʼ���ڶ����б����� */
	private void initCarChoiceData(int carChoiceIndex) {
		String carTitleValueArray[] = mContext.getResources().getStringArray(carTitleChildArray[carChoiceIndex]);		
		carChoiceList.clear();
		for (int i = 0; i < carTitleValueArray.length; i++) {
	    	carChoiceList.add(carTitleValueArray[i]);
	    }
	    mCarChoiceAdapter.setList(carChoiceList);
	}
	
	/***����Э��ID,�ж����ڵ�һ���б��ϵ��Ⱥ�˳�򣬲��ǵڼ�λ */
	private int switchcarTitlePosition(ProtocolID mPID) {
		
		switch (mPID.ordinal()) {
		case 22://����ͨ��
		case 0:carTitlePosition = ConstantUtil.CAR_TITLE_GM;break;//ͨ��
		case 1:
		case 14://���� ����
		case 15://���� �߶���7
		case 8:carTitlePosition = ConstantUtil.CAR_TITLE_DASAUTO_KODIAK;break;//���ڡ��Ƶ��ǿ˵ȵ�
		case 19://����  ����
		case 31://����  ���� �Ե�	
		case 2:carTitlePosition = ConstantUtil.CAR_TITLE_TOYOTA;break;//���� ����
		case 25://����  PSA
		case 3:carTitlePosition = ConstantUtil.CAR_TITLE_PSA;break;//ѩ����
		case 11://����˹   ����
		case 12://���       ����
		case 13://�ɵ�ŷ   �ΰ�˹
		case 4:carTitlePosition = ConstantUtil.CAR_TITLE_FORD;break;//��������
		case 20://����  ����
		case 5:carTitlePosition = ConstantUtil.CAR_TITLE_HONDA;break;//����
		case 16://��ϵ   ����
		case 6:carTitlePosition = ConstantUtil.CAR_TITLE_HYUNDAI;break;//�ִ�
		case 18://����  �ղ�
		case 7:carTitlePosition = ConstantUtil.CAR_TITLE_NISSAN;break;//�ղ�
		case 9:carTitlePosition = ConstantUtil.CAR_TITLE_BMW;break;//����
		case 10:carTitlePosition = ConstantUtil.CAR_TITLE_VENUCIA;break;//����	
		case 17:carTitlePosition = ConstantUtil.CAR_TITLE_KIA;break;//����
		case 28://���� ���Դ�
		case 30://���� ���Դ�
		case 21:carTitlePosition = ConstantUtil.CAR_TITLE_MAZDA;break;//�ΰ�˹ ���Դ�
		case 24:
		case 23:carTitlePosition = ConstantUtil.CAR_TITLE_HARVARD;break;//���� ����
		case 26:carTitlePosition = ConstantUtil.CAR_TITLE_TRUMPCHI;break;//���� ����
		case 27:carTitlePosition = ConstantUtil.CAR_TITLE_BAOJUN;break;//���� ����
		case 29:carTitlePosition = ConstantUtil.CAR_TITLE_GEELY;break;//�־�� ���� 
		
		}
		return carTitlePosition;
	}
	
	/***�����һ���б�󣬵ڶ����б�Ҫ���ص����� */
	private void initCarTitleChildArray() {
		carTitleChildArray = new int[]{R.array.gmArray,R.array.dasautoArray,R.array.toyotaArray,
				R.array.psaArray,R.array.fordArray,R.array.hondaArray,R.array.hyundaiArray,
				R.array.nissanArray,R.array.bmwArray,R.array.venuciaArray,R.array.kiaArray,
				R.array.mazdaArray,R.array.harvardArray,R.array.trumpchiArray,R.array.baojunArray,
				R.array.geelyArray};
	}
	
	/***��ʼ���������б����� */
	private void initCarCanData() {
		String carCanValueArray[] =   switchCarCanListArray(); 
		carCanList.clear();
		
		for (int i = 0; i < carCanValueArray.length; i++) {
			carCanList.add(carCanValueArray[i]);
		}
		mCarCanAdapter.setList(carCanList);
	}
	
	/***����ǰ�����б��Position�����������б���ʾ�ĸ��������� */
	private String[] switchCarCanListArray() {
		String carCanValueArray[] = {};
		switch (carTitlePosition) {
		case ConstantUtil.CAR_TITLE_GM:
			if (carChoicePosition!=1) {
				carCanValueArray = mContext.getResources().getStringArray(R.array.canWeiRuiXinAnArray);
			}
			break;
		case ConstantUtil.CAR_TITLE_DASAUTO_KODIAK:
			if (carChoicePosition>0 && carChoicePosition<=5) {
			    carCanValueArray = mContext.getResources().getStringArray(R.array.canWeiRuiXinAnArray);
			}else if (carChoicePosition <=7) {//0,6,7
				carCanValueArray = mContext.getResources().getStringArray(R.array.canWeiArray);
			}else {
				carCanValueArray = mContext.getResources().getStringArray(R.array.canRuiXinAnArray);
			} 
			break;
		case ConstantUtil.CAR_TITLE_TOYOTA:
			if (carChoicePosition==1 || carChoicePosition==9) {
			    carCanValueArray = mContext.getResources().getStringArray(R.array.canRuiXinAnArray);
			}else if (carChoicePosition==4 || carChoicePosition==5|| carChoicePosition==6) {
				carCanValueArray = mContext.getResources().getStringArray(R.array.canWeiRuiXinAnArray);
			}else {
				carCanValueArray = mContext.getResources().getStringArray(R.array.canWeiArray);
			} 
			break;
		case ConstantUtil.CAR_TITLE_PSA:
			if (carChoicePosition <= 3) {
				if (carChoicePosition != 2) {
					carCanValueArray = mContext.getResources().getStringArray(R.array.canWeiArray);
				}
			}else if (carChoicePosition<=5) {
				carCanValueArray = mContext.getResources().getStringArray(R.array.canWeiRuiXinAnArray);
			}else {
				carCanValueArray = mContext.getResources().getStringArray(R.array.canRuiXinAnArray);
			}
			break;
		case ConstantUtil.CAR_TITLE_FORD:
			if (carChoicePosition!=6 && carChoicePosition!=7) {
				if (carChoicePosition==1) {
					carCanValueArray = mContext.getResources().getStringArray(R.array.canWeiXbsRuiXinAnArray);
				}else {
					carCanValueArray = mContext.getResources().getStringArray(R.array.canWeiRuiXinAnArray);
				}
			}else if (carChoicePosition==7) {
				carCanValueArray = mContext.getResources().getStringArray(R.array.canRuiXinAnArray);
			}
			break;
		case ConstantUtil.CAR_TITLE_HONDA:
			if (carChoicePosition<=1 ) {
				carCanValueArray = mContext.getResources().getStringArray(R.array.canRuiXinAnArray);
			}else if (carChoicePosition<=5) {
				carCanValueArray = mContext.getResources().getStringArray(R.array.canWeiRuiXinAnArray);
			}else if (carChoicePosition>=8) {
				carCanValueArray = mContext.getResources().getStringArray(R.array.canWeiArray);
			}
			break;
		case ConstantUtil.CAR_TITLE_HYUNDAI:
			if (carChoicePosition <= 3) {
				carCanValueArray = mContext.getResources().getStringArray(R.array.canWeiArray);
			}else {
				carCanValueArray = mContext.getResources().getStringArray(R.array.canWeiRuiXinAnArray);
			}
			break;
		case ConstantUtil.CAR_TITLE_NISSAN:
				carCanValueArray = mContext.getResources().getStringArray(R.array.canWeiRuiXinAnArray);
		    break;
		case ConstantUtil.CAR_TITLE_BMW:
		    carCanValueArray = mContext.getResources().getStringArray(R.array.canHeArray);
	    break;
		case ConstantUtil.CAR_TITLE_VENUCIA:
		    carCanValueArray = mContext.getResources().getStringArray(R.array.canRuiXinAnArray);
	    break;
		case ConstantUtil.CAR_TITLE_KIA:
		    carCanValueArray = mContext.getResources().getStringArray(R.array.canRuiXinAnArray);
	    break;
		case ConstantUtil.CAR_TITLE_MAZDA:
			carCanValueArray = mContext.getResources().getStringArray(R.array.canWeiXbsRuiXinAnArray);
	    break;
		case ConstantUtil.CAR_TITLE_HARVARD:
		    carCanValueArray = mContext.getResources().getStringArray(R.array.canWeiArray);
	    break;
		case ConstantUtil.CAR_TITLE_TRUMPCHI:
		    carCanValueArray = mContext.getResources().getStringArray(R.array.canWeiArray);
	    break;
		case ConstantUtil.CAR_TITLE_BAOJUN:
		    carCanValueArray = mContext.getResources().getStringArray(R.array.canRuiXinAnArray);
	    break;
		case ConstantUtil.CAR_TITLE_GEELY:
		    carCanValueArray = mContext.getResources().getStringArray(R.array.canRuiXinAnArray);
	    break;
		}
		return carCanValueArray;
	}
	/***���������б��ѡ�� �л�Э�� */
	private void changeProtocol() {
		switch (carTitlePosition) {
		case ConstantUtil.CAR_TITLE_GM:
			switchGMProtocol();
			break;
		case ConstantUtil.CAR_TITLE_DASAUTO_KODIAK:
			switchDasautoProtocol();
			break;
		case  ConstantUtil.CAR_TITLE_TOYOTA:
			switchToyotaProtocol();
			break;
		case ConstantUtil.CAR_TITLE_PSA:
			switchPSAProtocol();
			break;
		case ConstantUtil.CAR_TITLE_FORD:
			switchFordProtocol();
			break;
		case ConstantUtil.CAR_TITLE_HONDA:
			switchHondaProtocol();
			break;
		case ConstantUtil.CAR_TITLE_HYUNDAI:
			switchHyundaiProtocol();
			break;
		case ConstantUtil.CAR_TITLE_NISSAN:
			switchNissanProtocol();
		break;
		case ConstantUtil.CAR_TITLE_BMW:
			changeProtoco(ProtocolID.ID_BMW);
		break;
		case ConstantUtil.CAR_TITLE_VENUCIA:
			changeProtoco(ProtocolID.ID_VENUCIA);
			break;
		case ConstantUtil.CAR_TITLE_KIA:
			changeProtoco(ProtocolID.ID_PRETTYSS1);
	    break;
		case ConstantUtil.CAR_TITLE_MAZDA:
			switchMazdaProtocol();
	    break;
		case ConstantUtil.CAR_TITLE_HARVARD:
			switchHarvardProtocol();
	    break;
		case ConstantUtil.CAR_TITLE_TRUMPCHI:
			changeProtoco(ProtocolID.ID_HIWORLD_TRUMPCHI);
	    break;
		case ConstantUtil.CAR_TITLE_BAOJUN:
			changeProtoco(ProtocolID.ID_BAOJUN);
	    break;
		case ConstantUtil.CAR_TITLE_GEELY:
			changeProtoco(ProtocolID.ID_RZ_GEELY);
	    break;
		}
		CanBoxApp.getProtocolID();
	}

	private void switchMazdaProtocol() {
		if (carCanPosition == 0) {
			changeProtoco(ProtocolID.ID_HIWORLD_MAZDA);
		}else if (carCanPosition == 1) {
			changeProtoco(ProtocolID.ID_XB_MAZDA);
		}else {
			changeProtoco(ProtocolID.ID_XP_MAZDA);
		}
	}

	private void switchPSAProtocol() {
		if (carChoicePosition <= 3) {
			if (carChoicePosition != 2) {
				changeProtoco(ProtocolID.ID_HIWORLD_PSA);
			}
		}else if (carChoicePosition<=5) {
			if (carCanPosition == 0) {
				changeProtoco(ProtocolID.ID_HIWORLD_PSA);
			}else {
				changeProtoco(ProtocolID.ID_XP_PSA);
			}
		}else {
			changeProtoco(ProtocolID.ID_XP_PSA);
		}
	}

	private void switchHarvardProtocol() {
		if (carChoicePosition==0) {
			changeProtoco(ProtocolID.ID_HIWORLD_HARVARDH6);
		}else if (carChoicePosition==1) {
			changeProtoco(ProtocolID.ID_HIWORLD_HARVARD_COUPE);
		}
	}

	private void switchGMProtocol() {
		if (carChoicePosition!=1) {
			if (carCanPosition == 0) {
				changeProtoco(ProtocolID.ID_HIWORLD_GM);
			}else {
				changeProtoco(ProtocolID.ID_XP_GM);
			}
		}
	}

	private void switchHondaProtocol() {
		if (carChoicePosition<=1 ) {
			changeProtoco(ProtocolID.ID_XP_HONDA);
		}else if (carChoicePosition<=5) {
			if (carCanPosition==0) {
				changeProtoco(ProtocolID.ID_HIWORLD_HONDA);
			}else {
				changeProtoco(ProtocolID.ID_XP_HONDA);
			}
		}else if (carChoicePosition>=8) {
			changeProtoco(ProtocolID.ID_HIWORLD_HONDA);
		}
	}

	private void switchNissanProtocol() {
		if (carCanPosition == 0) {
			changeProtoco(ProtocolID.ID_HIWORLD_NISSAN);
		} else {
			changeProtoco(ProtocolID.ID_XPXTL);
		}
	}

	private void switchToyotaProtocol() {
		if (carChoicePosition==1 || carChoicePosition==9) {
			changeProtoco(ProtocolID.ID_SIMPLE_TOYOT1);
		}else if (carChoicePosition==4 || carChoicePosition==5|| carChoicePosition==6) {
			if (carCanPosition == 0) {
				changeProtoco(ProtocolID.ID_HIWORLD_TOYOTA);
			} else {
				changeProtoco(ProtocolID.ID_SIMPLE_TOYOT1);
			}
		}else if (carChoicePosition == 7) {
			changeProtoco(ProtocolID.ID_HIWORLD_PRADO);
		}else {
			changeProtoco(ProtocolID.ID_HIWORLD_TOYOTA);
		} 
	}

	private void switchHyundaiProtocol() {
		if (carChoicePosition <= 3) {
			changeProtoco(ProtocolID.ID_HIWORLD_HYUNDAI);
		}else {
			if (carCanPosition==0) {
				changeProtoco(ProtocolID.ID_HIWORLD_HYUNDAI);
			}else {
				changeProtoco(ProtocolID.ID_PRETTYSS);
			}
		}
	}

	private void switchDasautoProtocol() {
		// 1,2,3,4,5
		if (carChoicePosition > 0 && carChoicePosition <= 5) {
			if (carChoicePosition == 2 || carChoicePosition == 5) {
				if (carCanPosition == 0) {
					changeProtoco(ProtocolID.ID_HIWORLD_KODIAK);
				} else {
					changeProtoco(ProtocolID.ID_SIMPLE_DASAUTO2);
				}
			} else if (carChoicePosition == 4) {
				if (carCanPosition == 0) {
					changeProtoco(ProtocolID.ID_HIWORLD_DASAUTO);
				} else {
					changeProtoco(ProtocolID.ID_SIMPLE_DASAUTO2);
				}
			} else if (carChoicePosition == 1 || carChoicePosition == 3) {
				if (carCanPosition == 0) {
					changeProtoco(ProtocolID.ID_HIWORLD_DASAUTO);
				} else {
					changeProtoco(ProtocolID.ID_SIMPLE_DASAUTO1);
				}
			}
		} else if (carChoicePosition <= 7) {// 0,6,7
			changeProtoco(ProtocolID.ID_HIWORLD_DASAUTO);
		} else if (carChoicePosition <= 16){// >7
			changeProtoco(ProtocolID.ID_SIMPLE_DASAUTO1);
		}else {
			changeProtoco(ProtocolID.ID_SIMPLE_DASAUTO2);
		}
	}

	private void switchFordProtocol() {
		if (carChoicePosition!=6 && carChoicePosition!=7 && carCanPosition==0) {
			changeProtoco(ProtocolID.ID_HIWORLD_FORD);
		}else if (carChoicePosition==1) {
			if (carCanPosition==1) {
				changeProtoco(ProtocolID.ID_MONDEO);
			}else {
				changeProtoco(ProtocolID.ID_EDGE);
			}
		}else if (carChoicePosition==5 || carChoicePosition==7) {
			changeProtoco(ProtocolID.ID_EDGE);
		}else {
			changeProtoco(ProtocolID.ID_FOCUS);
		}
	}



	private void changeProtoco(ProtocolID id) {
		SerialManager.getInstance().onCutDataProtocol(id);
		ProtocoChoicelUtils.putProtocoName(id);
		ProtocoChoicelUtils.putCarTypeIndex(carChoicePosition);
		ProtocoChoicelUtils.putCarCanIndex(carCanPosition);
		PushUtil.pushStartOrder(CanBoxApp.getProtocolID());
	}



	@Override
	public void onClick(View arg0) {
	}
	
}
