package com.landsem.canboxui.utils;

public class ConstantUtil {
	
	public static final String TAG = "CanboxUI";
	
    public static final int MESSAGE_CARBASE_KEY = 50;
    public static final int MESSAGE_CARBASE_LIGHT = 51;
    public static final int MESSAGE_CARBASE_REVERSE = 52;
    public static final int MESSAGE_AIR = 1;
	public static final int MESSAGE_DRIVER = 2;
	public static final int MESSAGE_VERTION = 3;
	public static final int MESSAGE_CAR_ALARM = 4;
	public static final int MESSAGE_CAR_LARGE = 5;
	public static final int MESSAGE_SHOWRADAR = 6;
	public static final int MESSAGE_DOOR = 7;
	public static final int MESSAGE_PERIPHERAL = 8;
	public static final int MESSAGE_MULTI_FUNC = 9;
	public static final int MESSAGE_DRIVE_MODE = 10;
	public static final int MESSAGE_UNIT_TIME = 11;
	public static final int MESSAGE_SPEED = 12;
	public static final int MESSAGE_SET = 13;
	public static final int MESSAGE_SYNC = 14;
	public static final int MESSAGE_ANJIXING = 15;
	public static final int MESSAGE_ALL_AIR = 16;
	//��һ���б��±�
	 public static final byte CAR_TITLE_GM = 0; 
	 public static final byte CAR_TITLE_DASAUTO_KODIAK = 1;
	 public static final byte CAR_TITLE_TOYOTA = 2;
	 public static final byte CAR_TITLE_PSA = 3;
	 public static final byte CAR_TITLE_FORD = 4;
	 public static final byte CAR_TITLE_HONDA = 5;
	 public static final byte CAR_TITLE_HYUNDAI = 6;
	 public static final byte CAR_TITLE_NISSAN = 7;
	 public static final byte CAR_TITLE_BMW = 8;
	 public static final byte CAR_TITLE_VENUCIA = 9;
	 public static final byte CAR_TITLE_KIA = 10;
	 public static final byte CAR_TITLE_MAZDA = 11;
	 public static final byte CAR_TITLE_HARVARD = 12;
	 public static final byte CAR_TITLE_TRUMPCHI = 13;
	 public static final byte CAR_TITLE_BAOJUN = 14;
	 public static final byte CAR_TITLE_GEELY = 15;
	//����
	public static final String LS_VOICE_ACTION = "android.intent.action.WAKEUP_SWITCH"; 
	//֪ͨ�����绰״̬
	public static final String ANDROID_INTENT_BT_PHONE = "android.intent.BT_PHONE";
	public static final String HANGUP = "hangup";
	public static final String ANSWER = "answer";
	//���
	public static final String HEADLAMP_STATE = "com.ls.headlamp_state";
	public static final String HEADLAMP_ON = "android.intent.HEADLAMP_ON";
	public static final String HEADLAMP_OFF = "android.intent.HEADLAMP_OFF";
	/**ȫ����̨���������棩*/
	public static final String FM_APS 	="com.ls.fmradio.intent.aps";
	/**������̨���������棩*/
	public static final String FM_APS_PRE_SEARCH ="com.ls.fmradio.intent.pre_search";
	/**������̨���������棩*/
	public static final String FM_APS_NEXT_SEARCH ="com.ls.fmradio.intent.next_search";
	/**���ϵ�̨���������棩*/
	public static final String FM_APS_PRE_PROGRAM ="com.ls.fmradio.intent.pre_program";
	/**���µ�̨���������棩*/
	public static final String FM_APS_NEXT_PROGRAM ="com.ls.fmradio.intent.next_program";
	/**ȥ���ղ��б��������棩*/
	public static final String FM_APS_CLICK_FAV   ="com.ls.fmradio.intent.click_fav";
	/**1.�ӵ绰/����----�е绰���������ǽӵ绰��û�е绰���ͽ�������*/
	public static final String CANBUS_ANSWER_ACTIOM  = "com.landsem.action.CANBUS_ANSWER";
	/**2.�ҵ绰/����----�绰��ͨ�У����ǹҵ绰�����ǽ�ͨ�У����Ǿ���*/
	public static final String CANBUS_HANGUP_ACTIOM = "com.landsem.action.CANBUS_HANGUP";
	/**EQ*/
	public static final String EQ_ACTIOM = "com.landsem.intent.action.AUDIO_EQUALIZER";
	/**��������*/
	public static final String MUSIC_ACTIOM = "com.landsem.intent.action.LOCALMUSIC";
	/**�����绰����*/
	public static final String PHONE_PACKAGENAME ="com.ls.bluetooth.bluetoothphone";
	/**����΢�����������棬��int��΢������(key:extra)���޲μ�Ĭ��Ϊһ��������*/
	public static final String FM_APS_MICRO_PRE_EXTRA ="com.ls.fmradio.intent.micro_pre";
    /**����΢�����������棬��int��΢������(key:extra)���޲μ�Ĭ��Ϊһ��������*/
	public static final String FM_APS_MICRO_NEXT_EXTRA ="com.ls.fmradio.intent.micro_next";
	/**ͨ������*/
	public static final String SET_ACTIOM = "com.landsem.actions.START_SETTINGS";

}
