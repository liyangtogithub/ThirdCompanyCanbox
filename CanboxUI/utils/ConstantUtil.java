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
	//第一个列表下标
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
	//静音
	public static final String LS_VOICE_ACTION = "android.intent.action.WAKEUP_SWITCH"; 
	//通知蓝牙电话状态
	public static final String ANDROID_INTENT_BT_PHONE = "android.intent.BT_PHONE";
	public static final String HANGUP = "hangup";
	public static final String ANSWER = "answer";
	//大灯
	public static final String HEADLAMP_STATE = "com.ls.headlamp_state";
	public static final String HEADLAMP_ON = "android.intent.HEADLAMP_ON";
	public static final String HEADLAMP_OFF = "android.intent.HEADLAMP_OFF";
	/**全局搜台（弹出界面）*/
	public static final String FM_APS 	="com.ls.fmradio.intent.aps";
	/**向上搜台（弹出界面）*/
	public static final String FM_APS_PRE_SEARCH ="com.ls.fmradio.intent.pre_search";
	/**向下搜台（弹出界面）*/
	public static final String FM_APS_NEXT_SEARCH ="com.ls.fmradio.intent.next_search";
	/**向上调台（弹出界面）*/
	public static final String FM_APS_PRE_PROGRAM ="com.ls.fmradio.intent.pre_program";
	/**向下调台（弹出界面）*/
	public static final String FM_APS_NEXT_PROGRAM ="com.ls.fmradio.intent.next_program";
	/**去到收藏列表（弹出界面）*/
	public static final String FM_APS_CLICK_FAV   ="com.ls.fmradio.intent.click_fav";
	/**1.接电话/语音----有电话进来，就是接电话，没有电话，就进入语音*/
	public static final String CANBUS_ANSWER_ACTIOM  = "com.landsem.action.CANBUS_ANSWER";
	/**2.挂电话/静音----电话接通中，就是挂电话，不是接通中，就是静音*/
	public static final String CANBUS_HANGUP_ACTIOM = "com.landsem.action.CANBUS_HANGUP";
	/**EQ*/
	public static final String EQ_ACTIOM = "com.landsem.intent.action.AUDIO_EQUALIZER";
	/**本地音乐*/
	public static final String MUSIC_ACTIOM = "com.landsem.intent.action.LOCALMUSIC";
	/**蓝牙电话包名*/
	public static final String PHONE_PACKAGENAME ="com.ls.bluetooth.bluetoothphone";
	/**向上微调（弹出界面，带int参微调幅度(key:extra)，无参及默认为一个步长）*/
	public static final String FM_APS_MICRO_PRE_EXTRA ="com.ls.fmradio.intent.micro_pre";
    /**向下微调（弹出界面，带int参微调幅度(key:extra)，无参及默认为一个步长）*/
	public static final String FM_APS_MICRO_NEXT_EXTRA ="com.ls.fmradio.intent.micro_next";
	/**通用设置*/
	public static final String SET_ACTIOM = "com.landsem.actions.START_SETTINGS";

}
