package com.landsem.canbox;


public interface Constant {
    
	String LOG_SPLIT = "  ";
	int PROTOCAL_INVALID_VALUE = -1000;
	int INVALID_VALUE = -1;
	int FILE_END = INVALID_VALUE;
	/**方控VR语音*/
	byte KEYEVENT_VOICE = -1;
	/**挂电话*/
	byte KEYEVENT_HANGUP = -2;
	/**接电话*/
	byte KEYEVENT_ANSWER = -3;
	/**挂电话和下一曲*/
	byte KEYEVENT_HANGUP_NEXT = -4;
	/**接电话和上一曲*/
	byte KEYEVENT_ANSWER_PREV = -5;
	/**Mode键、Media键*/
	byte KEYEVENT_MODE = -6;
	/**AUXIN*/
	byte KEYEVENT_AUXIN = -7;
	/**Power键*/
	byte KEYEVENT_POWER = -8;
	/**旋钮音量加*/
	byte KEYEVENT_VOLUME_UP = -9;
	/**旋钮音量减*/
	byte KEYEVENT_VOLUME_DOWN = -10;
	/**tune scan+ 收音机向上搜索*/
	byte KEYEVENT_SCAN_UP = -11;
	/**tune scan- 收音机向下搜索*/
	byte KEYEVENT_SCAN_DOWN = -12;
	/**收音机预存台切换+ */
	byte KEYEVENT_CHANNEL_UP = -13;
	/**收音机预存台切换-*/
	byte KEYEVENT_CHANNEL_DOWN = -14;
	/**进入导航*/
	byte KEYEVENT_NAVI = -15;
	/**收藏电台*/
	byte KEYEVENT_COLLEC_RADIO = -16;
	/**挂电话或静音*/
	byte KEYEVENT_HANGUP_MUTE = -17;
	/**接电话或语音*/
	byte KEYEVENT_ANSWER_VOICE = -18;
	/**EQ*/
	byte KEYEVENT_EQ = -19;
	/**蓝牙界面*/
	byte KEYEVENT_BLUE_PHONE = -20;
	/**音乐界面*/
	byte KEYEVENT_MUSIC = -21;
	/**滚轮式 向上选择收音频道*/
	byte KEYEVENT_CHANNEL_UP_FAST = -22;
	/**滚轮式 向下选择收音频道*/
	byte KEYEVENT_CHANNEL_DOWN_FAST = -23;
	/**收音机全局搜索*/
	byte KEYEVENT_SCAN_ALL = -24;
	/**SET*/
	byte KEYEVENT_SET = -25;
	/**倒车后视*/
	byte KEYEVENT_REAR_VIDEO = -26;
	/**进入CD界面*/
	byte KEYEVENT_CD = -27;
	
	/** 空调温度显示高*/
	byte AIR_HIGH                = -100;
	/** 空调温度显示低*/
	byte AIR_LOW                 = -101;
	/** 空调温度不显示*/
	byte AIR_NONE                = -103;
	
	/** 威驰数据长度下标 */
	byte LENGTH = 2;
	/** 威驰数据类型下标 */
	byte COMID = 3;
	/** 欣朴协议数据类型下标 */
	byte COMID_XINPU = 1;
	/** 欣朴协议数据长度下标 */
	byte LENGTH_XINPU = 2;
	/** 宝马字节数据下标 */
	byte DATA0_XINPU = 3;
	byte DATA1_XINPU = 4;
	byte DATA2_XINPU = 5;
	byte DATA3_XINPU = 6;
	byte DATA4_XINPU = 7;
	byte DATA5_XINPU = 8;
	byte DATA6_XINPU = 9;
	byte DATA7_XINPU = 10;
	byte DATA8_XINPU = 11;
	byte DATA9_XINPU = 12;
	byte DATA10_XINPU = 13;
	byte DATA11_XINPU = 14;
	byte DATA12_XINPU = 15;
	byte DATA13_XINPU = 16;
	byte DATA14_XINPU = 17;
	byte DATA15_XINPU = 18;
	byte DATA16_XINPU = 19;
	/** 字节数据下标 */
	byte DATA0 = 4;
	byte DATA1 = 5;
	byte DATA2 = 6;
	byte DATA3 = 7;
	byte DATA4 = 8;
	byte DATA5 = 9;
	byte DATA6 = 10;
	byte DATA7 = 11;
	byte DATA8 = 12;
	byte DATA9 = 13;
	byte DATA10 = 14;
	byte DATA11 = 15;
	byte DATA12 = 16;
	byte DATA13 = 17;
	byte DATA14 = 18;
	byte DATA15 = 19;
	byte DATA16 = 20;
	byte DATA17 = 21;
	byte DATA18 = 22;
	byte DATA19 = 23;
	byte DATA20 = 24;
	byte DATA21 = 25;
	byte DATA22 = 26;
	/** 位数据下标 */
	byte BIT0 = 0;
	byte BIT1 = 1;
	byte BIT2 = 2;
	byte BIT3 = 3;
	byte BIT4 = 4;
	byte BIT5 = 5;
	byte BIT6 = 6;
	byte BIT7 = 7;
	
	/** 解析类been ID*/
	public static final byte ID_NONE = -1;
	public static final byte ID_AIRCONDITION = 0;
	public static final byte ID_CARALARM = 1;
	public static final byte ID_CARBASE = 2;
	public static final byte ID_CARLARGE = 3;
	public static final byte ID_CORNER = 4;
	public static final byte ID_DOOR = 5;
	public static final byte ID_DRIVER_ASSIST= 6;
	public static final byte ID_RADAR = 7;
	public static final byte ID_PERIPHERAL = 8;
	public static final byte ID_MULTI_FUNC = 9;
	public static final byte ID_DRIVE_MODE = 10;
	public static final byte ID_UNIT_TIME = 11;
	public static final byte ID_SPEED = 12;
	public static final byte ID_SET = 13;
	public static final byte ID_SYNC = 14;
	public static final byte ID_ANJIXING = 15;
	public static final byte ID_KEY_FUCTION = 16;
	public static final byte ID_CD_INFO = 17;
	
	/**CD 关闭循环*/
	byte CD_RPT_CLOSE                = 0;
	/**CD 单曲循环*/
	byte CD_RPT_SINGLE               = 1;
	/**CD 目录循环*/
	byte CD_RPT_FOLD                 = 2;
	/**CD 关闭随机*/
	byte CD_RDM_CLOSE                = 3;
	/**CD 目录随机*/
	byte CD_RDM_FOLD                 = 4;
	/**CD 全部随机*/
	byte CD_RDM_ALL                  = 5;
	/**TEXT 类型：歌曲名*/
	byte TEXT_NAME_SONG              = 0;
	/**TEXT 类型：文件夹名*/
	byte TEXT_NAME_FOLD              = 1;
	/**TEXT 类型：碟片名*/
	byte TEXT_NAME_DISC              = 2;
	/**TEXT 类型：艺术家*/
	byte TEXT_NAME_ART               = 3;
	/**TEXT 状态：编码方式ASCII*/
	byte TEXT_STATE_ASCII            = 0;
	/**TEXT 状态：编码方式UNICODE大端*/
	byte TEXT_STATE_UNICODE_B        = 1;
	/**TEXT 状态：编码方式UNICODE小端*/
	byte TEXT_STATE_UNICODE_S        = 2;
	/**TEXT 状态：编码方式UTF8*/
	byte TEXT_STATE_UTF8             = 3;
	
	
	/*** 大众*/
	public interface DasAutoComID {
		/** 车辆基体信息 【发送者：协议盒】 */
		byte COMID_INFO_BASE_CAR = 0x72;
		/** 空调信息【发送者：协议盒】 */
		byte COMID_INFO_AIR_CONDITION = 0x73;
		/** 软件版本信息 【发送者：协议盒】 */
		byte COMID_INFO_SOFT_VERSION = (byte) 0xF0;
		/** 驾驶员辅助系统设定命令 【发送者：协议盒】 */
		byte COMID_INFO_SYSTEM_SETTING = 0x47;
		/** 车辆具体信息1 【发送者：协议盒】 */
		byte COMID_INFO_CAR_DEFINITE1 = 0x12;
		/** 车辆具体信息2 【发送者：协议盒】 */
		byte COMID_INFO_CAR_DEFINITE2 = 0x13;
		/** 雷达信息 【发送者：协议盒】 */
		byte COMID_INFO_RADAR = 0x42;
		
		/** 主机状态信息 【发送者：DVD主机】 */
		byte COMID_SEND_MAINFRAME = (byte) 0xD2;
		/** 显示信息1 【发送者：DVD主机】 */
		byte COMID_SEND_DVD1 = (byte) 0xE2;
		/** 显示信息2 【发送者：DVD主机】 */
		byte COMID_SEND_DVD2 = (byte) 0xE3;
		/** 驾驶员辅助系统设定信息 【发送者：DVD主机】 */
		byte COMID_SEND_SYSTEM_SETTING = 0x4C;
	}
	
	/*** 现代*/
	public interface HyunDaiComID {
		/** 车辆基体信息 【发送者：协议盒】 */
		byte COMID_INFO_BASE_CAR = 0x11;
		/** 空调信息【发送者：协议盒】 */
		byte COMID_INFO_AIR_CONDITION = 0x31;
		/** 软件版本信息 【发送者：协议盒】 */
		byte COMID_INFO_SOFT_VERSION = (byte) 0xF0;
		/** 面板按键【发送者：协议盒】 */
		byte COMID_PANEL_KEY = 0x21;
		/** 面板旋钮【发送者：协议盒】 */
		byte COMID_PANEL_KNOB = 0x22;
		/** 功放信息 【发送者：协议盒】 */
		byte COMID_INFO_AMPLIFIER = (byte) 0xA6;
		/** 车型信息 【发送者：协议盒】 */
		byte COMID_INFO_CAR_TYPE = 0x26;
		
		/** 主机状态信息 【发送者：主机】 */
		byte COMID_SEND_MAINFRAME = (byte) 0xD2;
		/** 功放设置信息 【发送者：主机】 */
		byte COMID_SEND_AMPLIFIER_SET = (byte) 0xAD;
		/** 车型设置 【发送者：主机】 */
		byte COMID_SEND_CAR_TYPE_SET = 0x24;
		/** 时间设置 【发送者：主机】 */
		byte COMID_SEND_TIME_SET = (byte) 0xCB;
	}
	
	/*** 日产*/
	public interface NissanComID {
		/** 车辆基体信息 【发送者：协议盒】 */
		byte COMID_INFO_BASE_CAR = 0x72;
		/** 摄像头信息【发送者：协议盒】 */
		byte COMID_INFO_CAMERA = (byte) 0xF2;
		/** 软件版本信息 【发送者：协议盒】 */
		byte COMID_INFO_SOFT_VERSION = (byte) 0xF0;
		/** 媒体源信息 【发送者：协议盒】 */
		byte COMID_INFO_MEDIA_SOURCE = (byte) 0xE0;
		/** 功放信息 【发送者：协议盒】 */
		byte COMID_INFO_AMPLIFIER = (byte) 0xA6;
		/** 前后雷达【发送者：协议盒】 */
		byte COMID_INFO_RADAR_FB = 0x41;
		/** 旋钮按键【发送者：协议盒】 */
		byte COMID_INFO_KNOB = 0x74;
		
		/** AUDIO STATUS 【发送者：主机】 */
		byte COMID_SEND_AUDIO_STATUS = (byte) 0xD2;
		/** 歌曲名称 【发送者：主机】 */
		byte COMID_SEND_SONG_NAME = (byte) 0xD3;
		/** 歌曲名称1 【发送者：主机】 */
		byte COMID_SEND_SONG_NAME1 = (byte) 0xD4;
		/** 校准时间，日期 【发送者：主机】 */
		byte COMID_SEND_ADJUST = (byte) 0xCB;
		/** 摄像头开关 【发送者：主机】 */
		byte COMID_SEND_CAMERA_STATUS = (byte) 0xFD;
		/** 功放设置信息 【发送者：主机】 */
		byte COMID_SEND_AMPLIFIER_SET = (byte) 0xAD;
		/** 语言设置 【发送者：主机】 */
		byte COMID_SEND_LANGUAGE_SET = (byte) 0x9A;
	}
	
	/***丰田*/
	public interface ToyotaComID {
		/** 车辆基体信息 【发送者：协议盒】 */
		byte COMID_INFO_BASE_CAR = 0x11;
		/** 车辆具体信息0 【发送者：协议盒】 */
		byte COMID_INFO_CAR_DEFINITE0 = 0x13;
		/** 车辆具体信息1 【发送者：协议盒】 */
		byte COMID_INFO_CAR_DEFINITE1 = 0x16;
		/** 车辆具体信息2 【发送者：协议盒】 */
		byte COMID_INFO_CAR_DEFINITE2 = 0x17;
		/** 油电混合 【发送者：协议盒】 */
		byte COMID_INFO_OIL_ELEC = 0x1F;
		/** 雷达 【发送者：协议盒】 */
		byte COMID_INFO_RADAR = 0x41;
		/** 设定信息 【发送者：协议盒】 */
		byte COMID_INFO_SET = 0x62;
		/** 功放信息 【发送者：协议盒】 */
		byte COMID_INFO_AMPLIFIER = (byte) 0xA6;
		/** 空调信息【发送者：协议盒】 */
		byte COMID_INFO_AIR_CONDITION = (byte) 0x82;
		/** 软件版本信息 【发送者：协议盒】 */
		byte COMID_INFO_SOFT_VERSION = (byte) 0xF0;
		/** 车型信息 【发送者：协议盒】 */
		byte COMID_INFO_CAR_TYPE = 0x26;
		/** 原车屏状态信息【发送者：协议盒】 */
		byte COMID_INFO_SCREEN_STATUS = (byte) 0xE8;
		
		/** 车型设置 【发送者：主机】 */
		byte COMID_SEND_CAR_TYPE = (byte) 0x2D;
		/** 设置 【发送者：主机】 */
		byte COMID_SEND_SET = (byte) 0x6A;
		/** 功放控制【发送者：主机】 */
		byte COMID_SEND_AMPLIFIER = (byte) 0xAD;
		/** DVD主机【发送者：主机】 */
		byte COMID_SEND_DVD = (byte) 0x24;
		/** 摄像头显示切换【发送者：主机】 */
		byte COMID_SEND_CAMERA_CHANGE = (byte) 0xFA;
	}
	
	/*** 科迪亚克*/
	public interface KoDiakComID {
		/** 车辆基体信息 【发送者：协议盒】 */
		byte COMID_INFO_BASE_CAR = 0x11;
		/** 车辆详细信息 【发送者：协议盒】 */
		byte COMID_INFO_DETAILED_CAR = 0x12;
		/** 车辆详细信息2 【发送者：协议盒】 */
		byte COMID_INFO_DETAILED_CAR2 = 0x19;
		/** 车辆细节状态——自启动以后 【发送者：协议盒】 */
		byte COMID_INFO_STATUS_START = 0x13;
		/** 车辆细节状态——长时间 【发送者：协议盒】 */
		byte COMID_INFO_STATUS_LONG = 0x14;
		/** 车辆细节状态——自加油起【发送者：协议盒】 */
		byte COMID_INFO_STATUS_REFUEL = 0x15;
		/** 舒适用电器【发送者：协议盒】 */
		byte COMID_INFO_CONVENIENCE = 0x16;
		/** 车辆识别号【发送者：协议盒】 */
		byte COMID_INFO_DISTINGUISH = 0x1F;
		/** 车辆保养信息【发送者：协议盒】 */
		byte COMID_INFO_MAINTAIN = 0x1E;
		/** 空调信息【发送者：协议盒】 */
		byte COMID_INFO_AIR_CONDITION = 0x31;
		/** 空调信息设定（是否使能）【发送者：协议盒】 */
		byte COMID_INFO_AIR_SET = 0x35;
		/** 前后雷达【发送者：协议盒】 */
		byte COMID_INFO_RADAR_FB = 0x41;
		/** 左右雷达【发送者：协议盒】 */
		byte COMID_INFO_RADAR_LR = 0x42;
		/** 泊车和驶出辅助【发送者：协议盒】 */
		byte COMID_INFO_PARKING_MANOEU = 0x45;
		/** 轮胎设定【发送者：协议盒】 */
		byte COMID_INFO_TYRE = 0x46;
		/** 驾驶员辅助系统设置【发送者：协议盒】 */
		byte COMID_INFO_SYSTEM_SETTING = 0x47;
		/** 灯设定信息2【发送者：协议盒】 */
		byte COMID_INFO_LIGHT2 = 0x67;
		/** 灯设定信息1【发送者：协议盒】 */
		byte COMID_INFO_LIGHT1 = 0x68;
		/** 后视镜和刮水器信息【发送者：协议盒】 */
		byte COMID_INFO_MIRROR_WIPER = 0x69;
		/** 软件版本信息 【发送者：协议盒】 */
		byte COMID_INFO_SOFT_VERSION = (byte) 0xF0;
		/** 门窗开关信息 【发送者：协议盒】 */
		byte COMID_INFO_DOOR_WINDOW = 0x64;
		/** 多功能显示 【发送者：协议盒】 */
		byte COMID_INFO_MULTI_FUNCTION = 0x76;
		/** 运动模式 【发送者：协议盒】 */
		byte COMID_INFO_SPORT_MODE = (byte) 0x85;
		/** 驾驶模式 【发送者：协议盒】 */
		byte COMID_INFO_DRIVE_MODE = (byte) 0x86;
		/** 驾驶模式2 【发送者：协议盒】 */
		byte COMID_INFO_DRIVE_MODE2 = (byte) 0x87;
		/** 设定单位信息【发送者：协议盒】 */
		byte COMID_INFO_UNIT = (byte) 0xC1;
		/** 时间和日期【发送者：协议盒】 */
		byte COMID_INFO_TIME_DATE = (byte) 0xC2;
		/** 警告【发送者：协议盒】 */
		byte COMID_INFO_VEHICLE_ALARM =  0x74;
		/** 警告【发送者：协议盒】 */
		byte COMID_INFO_START_STOP_ALARM =  0x75;
		/** 警告【发送者：协议盒】 */
		byte COMID_INFO_CONV_CONS_ALARM =  0x77;
		/** 灯信息【发送者：协议盒】 */
		byte COMID_INFO_LIGHT = 0x36;
		/** 摄像头信息【发送者：协议盒】 */
		byte COMID_INFO_CAMERA = (byte) 0xE8;
		
		
		/** 请求发送命令 【发送者：主机】 */
		byte COMID_SEND_REQUEST_CMD = 0x0A;
		/** 恢复出厂设置 【发送者：主机】 */
		byte COMID_SEND_RESTORE_FACTORY_SETTINGS = 0x1A;
		/** 空调信息设定（已使能的）【发送者：主机】 */
		byte COMID_SEND_AIR_SET = 0x3A;
		/** 泊车和驶出辅助【发送者：主机】 */
		byte COMID_SEND_PARKING_MANOEU = 0x4A;
		/** 轮胎设定【发送者：主机】 */
		byte COMID_SEND_TYRE = 0x4B;
		/** 驾驶员辅助系统设置【发送者：主机】 */
		byte COMID_SEND_SYSTEM_SETTING = 0x4C;
		/** 灯设定信息【发送者：主机】 */
		byte COMID_SEND_LIGHT = 0x6D;
		/** 后视镜和刮水器信息【发送者：主机】 */
		byte COMID_SEND_MIRROR_WIPER = 0x6E;
		/** 门窗开关信息 【发送者：主机】 */
		byte COMID_SEND_DOOR_WINDOW = 0x6F;
		/** 多功能显示 【发送者：主机】 */
		byte COMID_SEND_MULTI_FUNCTION = 0x7B;
		/** 运动模式 【发送者：主机】 */
		byte COMID_SEND_SPORT_MODE = (byte) 0x8A;
		/** 驾驶模式 【发送者：主机】 */
		byte COMID_SEND_DRIVE_MODE = (byte) 0x8B;
		/** 主机情况1 【发送者：主机】 */
		byte COMID_SEND_DVD_STATUS = (byte) 0x91;
		/** 主机情况2 【发送者：主机】 */
		byte COMID_SEND_DVD_STATUS2 = (byte) 0x92;
		/** 主机情况3 【发送者：主机】 */
		byte COMID_SEND_DVD_STATUS3 = (byte) 0x93;
		/** 主机情况4【发送者：主机】 */
		byte COMID_SEND_DVD_STATUS4 = (byte) 0x94;
		/** 主机情况5  蓝牙电话信息1【发送者：主机】 */
		byte COMID_SEND_DVD_STATUS5 = (byte) 0x95;
		/** 主机情况6  蓝牙电话信息2【发送者：主机】 */
		byte COMID_SEND_DVD_STATUS6 = (byte) 0x96;
		/** 原车图标显示【发送者：主机】 */
		byte COMID_SEND_ICON = (byte) 0xE6;
		/** 设定语言【发送者：主机】 */
		byte COMID_SEND_LANGUAGE = (byte) 0x9A;
		/** 设定单位【发送者：主机】 */
		byte COMID_SEND_UNIT = (byte) 0xCA;
		/** 时间和日期【发送者：主机】 */
		byte COMID_SEND_TIME_DATE = (byte) 0xCB;
		/** 导航信息【发送者：主机】 */
		byte COMID_SEND_NAVIGATION = (byte) 0xE4;
		/** 主机状态,中文【发送者：主机】 */
		byte COMID_SEND_DVD_STATUS_CHINESE = (byte) 0xE5;
		/** 摄像头信息【发送者：主机】 */
		byte COMID_SEND_CAMERA = (byte) 0xF2;
	}
	
	/*** 福特*/
	public interface FordComID {
		/** 车辆基体信息 【发送者：协议盒】 */
		byte COMID_INFO_BASE_CAR = 0x11;
		/** 车辆详细信息 【发送者：协议盒】 */
		byte COMID_INFO_DETAILED_CAR = 0x12;
		/** 空调信息【发送者：协议盒】 */
		byte COMID_INFO_AIR_CONDITION = 0x31;
		/** 前后雷达【发送者：协议盒】 */
		byte COMID_INFO_RADAR_FB = 0x41;
		/** 左右雷达【发送者：协议盒】 */
		byte COMID_INFO_RADAR_LR = 0x42;
		/** 软件版本信息 【发送者：协议盒】 */
		byte COMID_INFO_SOFT_VERSION = (byte) 0xF0;
		/** SYNC显示信息 【发送者：协议盒】 */
		byte COMID_INFO_SYNC_DISPLAY = (byte) 0xD0;
		/** SYNC播放信息 【发送者：协议盒】 */
		byte COMID_INFO_SYNC_PLAY = (byte) 0xD2;
		/** SYNC状态信息 【发送者：协议盒】 */
		byte COMID_INFO_SYNC_STATE = (byte) 0xD3;
		/** 智能语音信息 【发送者：协议盒】 */
		byte COMID_INFO_INTELLIGENT_SPEECH = (byte) 0xE0;
		/** 语言设置信息 【发送者：协议盒】 */
		byte COMID_INFO_LANGUAGE_SET = (byte) 0x94;
		/** 提示设置信息【发送者：主机】 */
		byte COMID_INFO_PROMPT_SET = (byte) 0x68;
		/** 原车视频信息【发送者：主机】 */
		byte COMID_INFO_VIDEO_SET = (byte) 0xE8;
		/** 油耗、里程信息【发送者：主机】 */
		byte COMID_INFO_OIL_DISTANCE =  0x34;
		/** 车辆识别号【发送者：主机】 */
		byte COMID_INFO_DISTINGUISH =  0x38;
		/** 面板按键【发送者：主机】 */
		byte COMID_INFO_PANEL_KEY =  0x21;
		/** 面板旋钮【发送者：主机】 */
		byte COMID_INFO_PANEL_KNOB=  0x22;
		
		
		/** SYNC按键命令【发送者：主机】 */
		byte COMID_SEND_SYNC_KEY = (byte) 0xDA;
		/** SYNC信息重发请求【发送者：主机】 */
		byte COMID_SEND_SYNC_REPEAT = (byte) 0xDC;
		/** 主机工作模式【发送者：主机】 */
		byte COMID_SEND_DVD_MODE = (byte) 0x91;
		/** 语言设置命令【发送者：主机】 */
		byte COMID_SEND_LANGUAGE_SET = (byte) 0x9A;
		/** 提示设置命令【发送者：主机】 */
		byte COMID_SEND_PROMPT_SET = (byte) 0x6D;
		/** 原车视频设置【发送者：主机】 */
		byte COMID_SEND_VIDEO_SET = (byte) 0xF2;
		/** 请求命令重复【发送者：主机】 */
		byte COMID_SEND_REPEAT = (byte) 0x6A;
	}
	
	/***PSA系列 雪铁龙*/
	public interface PSAComID {
		/** 车辆基体信息 【发送者：协议盒】 */
		byte COMID_INFO_BASE_CAR = 0x11;
		/** 车辆详细信息 【发送者：协议盒】 */
		byte COMID_INFO_DETAILED_CAR = 0x12;
		/** 行车电脑信息0【发送者：协议盒】 */
		byte COMID_INFO_COMPUTER0 = 0x13;
		/** 行车电脑信息1 【发送者：协议盒】 */
		byte COMID_INFO_COMPUTER1 = 0x14;
		/** 行车电脑信息2 【发送者：协议盒】 */
		byte COMID_INFO_COMPUTER2 = 0x15;
		/** 面板按键【发送者：协议盒】 */
		byte COMID_PANEL_KEY = 0x21;
		/** 面板旋钮【发送者：协议盒】 */
		byte COMID_PANEL_KNOB = 0x22;
		/** 空调信息【发送者：协议盒】 */
		byte COMID_INFO_AIR_CONDITION = 0x31;
		/** 雷达 【发送者：协议盒】 */
		byte COMID_INFO_RADAR = 0x41;
		/** 告警信息【发送者：协议盒】 */
		byte COMID_INFO_ALARM = 0x42;
		/** 车辆设置信息使能1【发送者：协议盒】 */
		byte COMID_INFO_SET_ENABLE1 = 0x71;
		/** 车辆设置信息使能2【发送者：协议盒】 */
		byte COMID_INFO_SET_ENABLE2 = 0x72;
		/** 车辆设置信息【发送者：协议盒】 */
		byte COMID_INFO_SET = 0x76;
		/** 车辆设置信息2【发送者：协议盒】 */
		byte COMID_INFO_SET2 = 0x79;
		/** 软件版本信息 【发送者：协议盒】 */
		byte COMID_INFO_SOFT_VERSION = (byte) 0xF0;
		/** 已记忆速度值设置信息 【发送者：协议盒】 */
		byte COMID_INFO_SPEED_SET = (byte) 0x81;
		/** 巡航速度设置信息 【发送者：协议盒】 */
		byte COMID_INFO_CRUISE_SPEED = (byte) 0x82;
		/** sos信息 【发送者：协议盒】 */
		byte COMID_INFO_SOS = (byte) 0x83;
		/** 运动模式 【发送者：协议盒】 */
		byte COMID_INFO_SPORT_MODE = (byte) 0x85;
		/** 语言设置信息 【发送者：协议盒】 */
		byte COMID_INFO_LANGUAGE_SET = (byte) 0x94;
		/** 设定单位信息【发送者：协议盒】 */
		byte COMID_INFO_UNIT = (byte) 0xC1;
		/** 时间和日期【发送者：协议盒】 */
		byte COMID_INFO_TIME_DATE = (byte) 0xC2;
		
		
		/** 行车信息设定命令【发送者：主机】 */
		byte COMID_SEND_INFO_SET = (byte) 0x1B;
		/** 车型设置 【发送者：主机】 */
		byte COMID_SEND_CAR_TYPE_SET = 0x24;
		/** 空调信息【发送者：主机】 */
		byte COMID_SEND_AIR_CONTROL = 0x3B;
		/** 车辆设置命令【发送者：主机】 */
		byte COMID_SEND_SET = 0x7B;
		/** 车辆设置命令【发送者：主机】 */
		byte COMID_SEND_SET2 = 0x7D;
		/** 已记忆速度值设置命令 【发送者：主机】 */
		byte COMID_SEND_SPEED_SET = (byte) 0x8A;
		/** 巡航速度设置命令 【发送者：主机】 */
		byte COMID_SEND_CRUISE_SPEED = (byte) 0x8B;
		/** 运动模式 【发送者：主机】 */
		byte COMID_SEND_SPORT_MODE = (byte) 0x8C;
		/** 语言设置请求命令 【发送者：主机】 */
		byte COMID_SEND_LANGUAGE_SET = (byte) 0x9A;
		/** 设定单位信息【发送者：主机】 */
		byte COMID_SEND_UNIT = (byte) 0xCA;
		/** 时间和日期【发送者：主机】 */
		byte COMID_SEND_TIME_DATE = (byte) 0xCB;
		/** 模拟面板按键【发送者：主机】 */
		byte COMID_SEND_PANEL_KEY = (byte) 0x21;
		/** 主机显示状态【发送者：主机】 */
		byte COMID_SEND_DISPLAY_STATE = (byte) 0xA1;
		/** 收音机信息【发送者：主机】 */
		byte COMID_SEND_RADIO = (byte) 0xA2;
		/** 收音机预存台信息【发送者：主机】 */
		byte COMID_SEND_RADIO_RESERVATION = (byte) 0xA3;
		/** CD/CDC信息【发送者：主机】 */
		byte COMID_SEND_CD = (byte) 0xA4;
	}
	
	/***通用*/
	public interface GMComID {
		/** 车辆基体信息 【发送者：协议盒】 */
		byte COMID_INFO_BASE_CAR = 0x11;
		/** 车辆详细信息 【发送者：协议盒】 */
		byte COMID_INFO_DETAILED_CAR = 0x12;
		/** 面板按键【发送者：协议盒】 */
		byte COMID_PANEL_KEY = 0x21;
		/** 面板旋钮【发送者：协议盒】 */
		byte COMID_PANEL_KNOB = 0x22;
		/** 车型面板选择状态【发送者：协议盒】 */
		byte COMID_PANEL_CHOICE = 0x23;
		/** 空调信息【发送者：协议盒】 */
		byte COMID_INFO_AIR_CONDITION = 0x31;
		/** 油耗、里程信息【发送者：主机】 */
		byte COMID_INFO_OIL_DISTANCE =  0x34;
		/** 空调信息设定【发送者：协议盒】 */
		byte COMID_INFO_AIR_SET = 0x35;
		/** 雷达 【发送者：协议盒】 */
		byte COMID_INFO_RADAR = 0x41;
		/** 冲撞/监测系统设定信息【发送者：协议盒】 */
		byte COMID_INFO_MONITOR = 0x45;
		/** 舒适性与方便性设定信息【发送者：协议盒】 */
		byte COMID_INFO_COMFORT = 0x55;
		/** 门锁设定信息【发送者：协议盒】 */
		byte COMID_INFO_DOOR_LOCK = 0x65;
		/** 遥控设定信息【发送者：协议盒】 */
		byte COMID_INFO_REMOTE = 0x66;
		/** 照明设定信息【发送者：协议盒】 */
		byte COMID_INFO_LIGHT = 0x67;
		/** 仪表显示设定信息【发送者：协议盒】 */
		byte COMID_INFO_METER = 0x75;
		/** 运动模式 【发送者：协议盒】 */
		byte COMID_INFO_SPORT_MODE = (byte) 0x85;
		/** 发声请求命令 【发送者：协议盒】 */
		byte COMID_INFO_VOICE_REQUEST = (byte) 0x90;
		/** 安吉星信息 【发送者：协议盒】 */
		byte COMID_INFO_ANJI = (byte) 0xB1;
		/** 安吉星通话信息 【发送者：协议盒】 */
		byte COMID_INFO_ANJI_CALL = (byte) 0xB2;
		/** 安吉星警告信息 【发送者：协议盒】 */
		byte COMID_INFO_ANJI_WARNING = (byte) 0xB3;
		/** 安吉星接收号码【发送者：协议盒】 */
		byte COMID_INFO_ANJI_RECEIVE = (byte) 0xB4;
		/** 蓝牙配对密码【发送者：协议盒】 */
		byte COMID_INFO_BLUE_PASSWORD = (byte) 0xC2;
		/** 蓝牙电话名称【发送者：协议盒】 */
		byte COMID_INFO_BLUE_PHONE = (byte) 0xC3;
		/** 软件版本信息 【发送者：协议盒】 */
		byte COMID_INFO_SOFT_VERSION = (byte) 0xF0;
		/** 冲撞/监测系统设定信息【发送者：协议盒】 */
		byte COMID_INFO_MONITOR2 = 0x46;
		/** 舒适性与方便性设定信息【发送者：协议盒】 */
		byte COMID_INFO_COMFORT2 = 0x56;
		/** 胎压监测信息【发送者：主机】 */
		byte COMID_INFO_TIRE_PRESS = (byte) 0x68;
		/** 指南针信息【发送者：主机】 */
		byte COMID_INFO_COMPASS = (byte) 0x69;
		
		
		/** 车型面板选择状态【发送者：主机】 */
		byte COMID_SEND_PANEL_CHOICE = 0x2A;
		/** 空调信息设定命令【发送者：主机】 */
		byte COMID_SEND_AIR_SET = 0x3A;
		/** 冲撞/监测系统设定信息【发送者：主机】 */
		byte COMID_SEND_MONITOR = 0x4A;
		/** 舒适性与方便性设定信息【发送者：主机】 */
		byte COMID_SEND_COMFORT = 0x5A;
		/** 请求命令重复【发送者：主机】 */
		byte COMID_SEND_ORDER_REPEAT = 0x60;
		/** 门锁设定命令【发送者：主机】 */
		byte COMID_SEND_DOOR_LOCK = 0x6A;
		/** 遥控设定命令【发送者：主机】 */
		byte COMID_SEND_REMOTE = 0x6B;
		/** 照明设定命令【发送者：主机】 */
		byte COMID_SEND_LIGHT = 0x6C;
		/** 仪表显示设定命令【发送者：主机】 */
		byte COMID_SEND_METER = 0x7A;
		/** 运动模式 【发送者：主机】 */
		byte COMID_SEND_SPORT_MODE = (byte) 0x8A;
		/** 主机状态【发送者：主机】 */
		byte COMID_SEND_DVD_STATUS = (byte) 0x91;
		/** 语言设置 【发送者：主机】 */
		byte COMID_SEND_LANGUAGE_SET = (byte) 0x9A;
		/** 安吉星命令【发送者：主机】 */
		byte COMID_SEND_ANJI_ORDER = (byte) 0xBA;
		/** 安吉星打出号码【发送者：主机】 */
		byte COMID_SEND_ANJI_SEND = (byte) 0xBB;
		/** 蓝牙按键命令【发送者：主机】 */
		byte COMID_INFO_BLUE_KEY = (byte) 0xCA;
		/** 空调控制命令【发送者：主机】 */
		byte COMID_SEND_AIR_CONTROL = 0x3B;
	}
	
	/***威驰通用的ID*/
	public interface HiworldComID {
		/** 车辆基体信息 【发送者：协议盒】 */
		byte COMID_INFO_BASE_CAR = 0x11;
		/** 面板信息 【发送者：协议盒】 */
		byte COMID_INFO_PANEL = 0x21;
		/** 旋钮信息 【发送者：协议盒】 */
		byte COMID_INFO_KNOB = 0x22;
		/** 车辆详细信息 【发送者：协议盒】 */
		byte COMID_INFO_DETAILED_CAR = 0x12;
		/** 空调信息【发送者：协议盒】 */
		byte COMID_INFO_AIR_CONDITION = 0x31;
		/** 车辆具体信息 【发送者：协议盒】 */
		byte COMID_INFO_CAR_DEFINITE = 0x32;
		/** 雷达 【发送者：协议盒】 */
		byte COMID_INFO_RADAR = 0x41;
	}
	
	/*** 本田 COMID*/
	public  interface IHondaComID {
			/** 车身基体信息 【发送者：协议盒】 */
			int COMID_INFO_BASE_CAR = 0x11;
			/** 车身具体信息 【发送者：协议盒】 */
			int COMID_INFO_CAR_DEFINITE = 0x12;
			/** 当前油耗、里程信息 【发送者：协议盒】 */
			int COMID_INFO_CURRENT_OIL_AND_MILES = 0x16;
			/** 当前油耗、里程信息 【发送者：协议盒】 */
			int COMID_INFO_HISTORY_OIL_AND_MILES = 0x17;
			/** 空调信息 【发送者：协议盒】 */
			int COMID_INFO_AIR_CONDITION = 0x31;
			/** 雷达信息 【发送者：协议盒】 */
			int COMID_INFO_RADAR = 0x41;
			/** 原车屏设置 【发送者：导航主机】 */
			int COMID_ORDER_ORIGINAL_VEHICLE_SCREEN_SETTING = 0xF2;
			/** 原车屏状态信息 【发送者：协议盒】 */
			int COMID_INFO_ORIGINAL_VEHICLE_SCREEN = 0xE8;
			/** NVAI主机状态 【发送者：导航主机】 */
			int COMID_INFO_ORIGINAL_VEHICLE_STATE = 0xE1;
			/** 时间设定 【发送者：导航主机】 */
			int COMID_ORDER_TIME_SETTING = 0xB5;
			/** 设定命令 【发送者：导航主机】 */
			int COMID_ORDER_SETTING = 0x6A;
			/** 控制空调按键CMD 【发送者：导航主机】 */
			int COMID_ORDER_CONTROL_CONDITIONER_KEY = 0x3D;
			/** 灯光设定状态 【发送者：协议盒】 */
			int COMID_STATE_LIGHTS_SETTING = 0x67;
			/** 灯光设定命令 【发送者：导航主机】 */
			int COMID_ORDER_LIGHTS_SETTING = 0x6c;
			/** 遥控设定状态 【发送者：协议盒】 */
			int COMID_STATE_REMOTE_CONTROL_SETTING = 0x66;
			/** 遥控设定命令 【发送者：导航主机】 */
			int COMID_ORDER_REMOTE_CONTROL_SETTING = 0x6b;
			/** 门锁设定状态 【发送者：协议盒】 */
			int COMID_STATE_DOOR_AND_LOCK_SETTING = 0x65;
			/** 门锁设定命令【发送者：导航主机】 */
			int COMID_ORDER_DOOR_AND_LOCK_SETTING = 0x6D;
			/** 驾驶辅助系统设定状态【发送者：协议盒】 */
			int COMID_STATE_DRIVE_ASSIST_SYSTEM_SETTING = 0x68;
			/** 驾驶辅助系统设定命令【发送者：导航主机】 */
			int COMID_ORDER_DRIVE_ASSIST_SYSTEM_SETTING = 0x6E;
			/** 设定显示屏设置状态【发送者：协议盒】 */
			int COMID_STATE_SCREEN_SETTING = 0x69;
			/** 设定显示屏设置命令【发送者：导航主机】 */
			int COMID_ORDER_SCREEN_SETTING = 0x6F;
			/** 请求切源（操作仪表）【发送者：协议盒】 */
			int COMID_INFO_REQUEST_CHANGE_SOURCE = 0xE0;
			/** 歌曲名信息 【发送者：导航主机】 */
			int COMID_INFO_MUSIC_NAME = 0xE4;
			/** Types设定命令 【发送者：导航主机】 */
			int COMID_ORDER_TYPES_SETTING = 0x4B;
			/** 电动尾门设定状态 【发送者：协议盒】 */
			int COMID_STATE_ELECTRIC_TRUNK_DOOR_SETTING = 0x75;
			/** 电动尾门设定设置 【发送者：导航主机】 */
			int COMID_ORDER_ELECTRIC_TRUNK_DOOR_SETTING = 0x7A;
			/** 原车功放状态 【发送者：协议盒】 */
			int COMID_STATE_ORIGINAL_VEHICLE_AMPLIFIER = 0xA6;
			/** 原车功放设置 【发送者：导航主机】 */
			int COMID_ORDER_ORIGINAL_VEHICLE_AMPLIFIER_SETTING = 0xAD;
			/** 语言设置 【发送者：导航主机】 */
			int COMID_ORDER_LANGUAGE_SETTING = 0x9A;
			/** 软件版本【发送者：协议盒】 */
			int COMID_INFO_SOFTWARE_VERSION = 0xF0;
}
	
	/***威驰 马自达 COMID*/
	public  interface HdMazdaComID {
			/** 方向盘按键 【发送者：协议盒】 */
			int COMID_INFO_STEER_KEY = 0x11;
   }
	
	/***宝马 COMID*/
	public  interface BmwComID {
			/** 背光调节 【发送者：协议盒】 */
			int COMID_INFO_BACK_LIGHT = 0x14;
			/** 方向盘按键 【发送者：协议盒】 */
			int COMID_INFO_STEER_KEY = 0x06;
			/** 座椅加热【发送者：协议盒】 */
			int COMID_INFO_SEAT_HEAT = 0x07;
			/** 门信息 【发送者：协议盒】 */
			int COMID_INFO_DOOR = 0x08;
			/** 方向盘转角【发送者：协议盒】 */
			int COMID_INFO_CORNER = 0x24;
			/** 雷达信息 【发送者：协议盒】 */
			int COMID_INFO_RADAR = 0x1c;
			/** 车速信息 【发送者：协议盒】 */
			int COMID_INFO_SPEED = 0x16;
			/** 车信息 【发送者：协议盒】 */
			int COMID_INFO_CAR = 0x03;
			/** 单位信息 【发送者：协议盒】 */
			int COMID_INFO_UNIT = 0x04;
   }
	
	/***启辰 COMID*/
	public  interface VenuciaComID {
			/** 方向盘按键 【发送者：协议盒】 */
			int COMID_INFO_STEER_KEY = 0x20;
			/** 空调【发送者：协议盒】 */
			int COMID_INFO_AIR_CONDITION = 0x21;
   }
	
	/***福克斯COMID*/
	public  interface FocusComID {
			/** 方向盘按键 【发送者：协议盒】 */
			int COMID_INFO_STEER_KEY = 0x20;
			/** 空调【发送者：协议盒】 */
			int COMID_INFO_AIR_CONDITION = 0x21;
			/** 前后雷达【发送者：协议盒】 */
			byte COMID_INFO_RADAR_B = 0x22;
			/** 前后雷达【发送者：协议盒】 */
			byte COMID_INFO_RADAR_F = 0x23;
			/** 基本信息【发送者：协议盒】 */
			int COMID_INFO_BASE_CAR = 0x24;
			/** 车辆信息【发送者：协议盒】 */
			int COMID_INFO_CAR = 0x29;
   }
	
	/***蒙迪欧COMID*/
	public  interface MondeoComID {
			/** 方向盘按键 【发送者：协议盒】 */
			int COMID_INFO_STEER_KEY = 0x01;
			/** 空调【发送者：协议盒】 */
			int COMID_INFO_AIR_CONDITION = 0x02;
			/** 前后雷达【发送者：协议盒】 */
			byte COMID_INFO_RADAR_B = 0x04;
			/** 门信息 【发送者：协议盒】 */
			int COMID_INFO_DOOR = 0x0b;
			/** 外温度信息 【发送者：协议盒】 */
			int COMID_INFO_TEMP = 0x11;
   }
	
	/***锐界COMID*/
	public  interface EdgeComID {
			/** 方向盘按键 【发送者：协议盒】 */
			int COMID_INFO_STEER_KEY = 0x20;
			/** 空调【发送者：协议盒】 */
			int COMID_INFO_AIR_CONDITION = 0x29;
			/** 后雷达【发送者：协议盒】 */
			byte COMID_INFO_RADAR_B = 0x22;
			/** 前雷达【发送者：协议盒】 */
			byte COMID_INFO_RADAR_F = 0x23;
			/** 基本信息【发送者：协议盒】 */
			int COMID_INFO_BASE_CAR = 0x24;
			
   }
	/***欣朴PSA COMID*/
	public  interface XPSAComID {
			/** 方向盘按键 【发送者：协议盒】 */
			int COMID_INFO_STEER_KEY = 0x20;
			/** 空调【发送者：协议盒】 */
			int COMID_INFO_AIR_CONDITION = 0x21;
			/** 雷达【发送者：协议盒】 */
			byte COMID_INFO_RADAR = 0x32;
			/** 转角【发送者：协议盒】 */
			byte COMID_INFO_CORNER = 0x29;
			/** 行车信息0 */
			byte COMID_INFO_CAR0 = 0x33;
			/** 行车信息1  */
			byte COMID_INFO_CAR1 = 0x34;
			/** 外部温度  */
			byte COMID_OUT_TEMP  = 0x36;
			/** 汽车状态  */
			byte COMID_CAR_STATE  = 0x38;
   }
	
	/**0x90 表示可以用此命令查询*/
	public interface SimpleDasAutoID {
		/**请求主机信息 */
		int SLAVE_HOST_COM_INFO 		= 0x10;
		/**背光信息 0X90 */
		int SLAVE_HOST_LIGHT_INFO 		= 0x14;
		/**速度信息 0X90 */
		int SLAVE_HOST_SPEED_INFO 		= 0x16;
		/**方向盘按键 0X90 */
		int SLAVE_HOST_WHEEL_KEY 		= 0x20;
		/**空调信息 0X90 */
		int SLAVE_HOST_AIR_CONTROL 		= 0x21;
		/**后雷达信息 0X90 */
		int SLAVE_HOST_BACK_RADAR 		= 0x22;
		/**前雷达信息 0X90 */
		int SLAVE_HOST_FRONT_RADAR 		= 0x23;
//		/**版本信息 0X90 */
//		int SLAVE_HOST_VERSION_INFO 	= 0x30;
		/**基本信息 0X90 */
		int SLAVE_HOST_BASE_INFO 		= 0x24;
		/**雷达状态信息 0X90 */
		int SLAVE_HOST_RADAR_STATUS 	= 0x25;
//		/**功放状态  0X90 */
//		int SLAVE_HOST_AV_STATUS 		= 0x27;
//		/**蓝牙状态  0X90 */
//		int SLAVE_HOST_BLUE_STATUS 		= 0x28;
//		/**媒体盒状态  0X90 */
//		int SLAVE_HOST_MEDIABOX_STATUS 	= 0x29;
		/**方向盘指令*/
		int SLAVE_HOST_WHEEL_ORDER		= 0x2F;
		/**左雷达信息 0X90 */
		int SLAVE_HOST_LEFT_RADAR 		= 0x32;
		/**右雷达信息 0X90 */
		int SLAVE_HOST_RIGHT_RADAR 		= 0x33;
		/**车身信息*/
		int SLAVE_HOST_BODY_INFO		= 0x41;
		/**驾驶信息*/
		int SLAVE_DRIVE_INFO		    = 0x50;
		
		public interface ComID1 {
			/**方向盘转角  0X90 */
			int SLAVE_HOST_EPS_INFO 		= 0x26;
		}
		
		public interface ComID2 {
			/**方向盘转角  */
			int SLAVE_HOST_EPS2_INFO 		= 0x29;
		}
		
		public interface SendComID1 {
			/**建立通信*/
			byte SEND_START_ORDER			= (byte) 0x81;
			/**请求控制器 信息 */
			int REQUEST_CONTROL_INFO 		= 0X90;
			/**Source*/
			int SOURCE_INFO 		        = 0XC0;
			/**收音机*/
			int RADIO_INFO 		            = 0XC2;
			/**媒体播放信息*/
			int MEDIA_INFO 		            = 0XC3;
			/**音量显示控制*/
			int SOUND_INFO 		            = 0XC4;
			/**电话状态*/
			int PHONE_INFO 		            = 0XC5;
			/**功放控制*/
			int POWER_AMPLI 		        = 0XA0;
			/**媒体盒控制*/
			int MEDIA_BOX  		            = 0XA1;
		}
		public interface SendComID2 {
			/**建立通信*/
			byte SEND_START_ORDER			= (byte) 0x81;
			/**Source*/
			int SOURCE_INFO 		        = 0XC0;
			/**媒体播放状态*/
			int MEDIA_STATE 		        = 0XC1;
			/**媒体文本信息第一行*/
			int MEDIA_LINE_1 		        = 0X70;
			/**媒体文本信息第二行*/
			int MEDIA_LINE_2 		        = 0X71;
			/**媒体文本信息第三行*/
			int MEDIA_LINE_3 		        = 0X72;
			/**音量显示控制*/
			int SOUND_INFO 		            = 0XC4;
			/**电话状态*/
			int PHONE_STATE 		        = 0XC5;
			/**电话信息*/
			int PHONE_INFO 		            = 0XCA;
		}
		
	}
	
	public interface TOYOTID {
		
		byte S_H_WHEEL_KEY					= 0x20;
		
		byte S_H_OIL					    = 0x23;
		
		byte S_H_BASE_INFO					= 0x24;
		
		byte S_H_AIRC_INFO					= 0x28;
		
		byte S_H_BACK_RADAR					= 0x1E;
		
		byte S_H_FRONT_RADAR				= 0x1D;
		
		byte S_H_EPS_INFO					= 0x29;
		
		byte S_H_SYSTEM_INFO				= 0x32;
		
		byte S_H_CAR_INFO				    = 0x41;
	}
	
	public interface Raise {
		/**方控面板按键*/
		byte DATA_TYPE_KEY				= 0x02;
		/**空调信息*/
		byte DATA_TYPE_AIRC				= 0x03;
		/**雷达信息*/
		byte DATA_TYPE_RADAR			= 0x04;
		/**车门信息*/
		byte DATA_TYPE_DOOR				= 0x05;
		/**车外温度信息*/
		byte DATA_TYPE_TEMP				= 0x01;
		byte DATA_TYPE_BLIGHT			= 0x07;
		
		
		
	}
	
	public interface Mazda {
		/**方控面板按键*/
		byte DATA_TYPE_KEY				= 0x01;
		/**车门信息*/
		byte DATA_TYPE_DOOR		        = 0x02;
		/**转角信息*/
		byte DATA_TYPE_CORNER			= 0x07;
		/**雷达信息*/
		byte DATA_TYPE_RADAR			= 0x08;
		/**背光信息*/
		byte DATA_TYPE_BLIGHT			= 0x0a;
		/**原车音响设备信息*/
		byte DATA_DEVICE_INFO			= 0x04;
		/**原车媒体播放信息*/
		byte DATA_PLAY_INFO			    = 0x05;
		/**原车媒体TXT信息*/
		byte DATA_TXT_INFO			    = 0x06;
		/**油耗*/
		byte DATA_OIL_INFO			    = 0x0B;
		
		/**发送CD命令*/
		byte SEND_CD_ORDER			    = (byte) 0x82;
		/**主机信息请求*/
		byte SEND_REQUEST_ORDER			= (byte) 0x83;
	}
	
	public interface MazdaSimple {
		/**方控面板按键*/
		byte DATA_TYPE_KEY				= 0x20;
		/**基本信息*/
		byte DATA_TYPE_BASE		        = 0x24;
		/**CD状态*/
		byte DATA_CD_STATE		        = 0x25;
		/**CD播放时间信息*/
		byte DATA_CD_TIME		        = 0x26;
		/**CD播放曲目信息*/
		byte DATA_CD_CONTENT		    = 0x27;
		
		/**建立通信*/
		byte SEND_START_ORDER			= (byte) 0x81;
		/**主机信息请求*/
		byte SEND_REQUEST_ORDER			= (byte) 0x90;
		/**控制命令*/
		byte SEND_CONTROL_ORDER			= (byte) 0xC7;
		
	}
	
	/***通用 欣朴*/
	public interface XGMComID {
		/**方控按键*/
		byte DATA_TYPE_KEY				= 0x01;
		/**面板按键*/
		byte DATA_TYPE_KNOB		        = 0x02;
		/**空调*/
		byte DATA_TYPE_AIR		        = 0x03;
		/**灯*/
		byte DATA_TYPE_LIGHT		    = 0x04;
		/**车速*/
		byte DATA_TYPE_SPEED		    = 0x0B;
		/**后雷达信息*/
		byte DATA_TYPE_RADAR_B			= 0x22;
		/**前雷达信息*/
		byte DATA_TYPE_RADAR_F			= 0x23;
		/**门*/
		byte DATA_TYPE_DOOR			    = 0x24;
		/**转角*/
		byte DATA_TYPE_CORNER			= 0x26;
		/**车辆信息1*/
		byte DATA_TYPE_CAR1			    = 0x31;
		/**车辆信息2*/
		byte DATA_TYPE_CAR2			    = 0x32;
	}
	
	/**0x90 表示可以用此命令查询*/
	public interface RaiseComID {
		/**请求主机信息 */
		int SLAVE_HOST_COM_INFO 		= 0x10;
		/**背光信息 0X90 */
		int SLAVE_HOST_LIGHT_INFO 		= 0x14;
		/**速度信息 0X90 */
		int SLAVE_HOST_SPEED_INFO 		= 0x16;
		/**方向盘按键 0X90 */
		int SLAVE_HOST_WHEEL_KEY 		= 0x20;
		/**空调信息 0X90 */
		int SLAVE_HOST_AIR_CONTROL 		= 0x21;
		/**后雷达信息 0X90 */
		int SLAVE_HOST_BACK_RADAR 		= 0x22;
		/**前雷达信息 0X90 */
		int SLAVE_HOST_FRONT_RADAR 		= 0x23;
		/**版本信息 0X90 */
		int SLAVE_HOST_VERSION_INFO 	= 0x30;
		/**基本信息 0X90 */
		int SLAVE_HOST_BASE_INFO 		= 0x24;
		/**雷达状态信息 0X90 */
		int SLAVE_HOST_RADAR_STATUS 	= 0x25;
		/**功放状态  0X90 */
		int SLAVE_HOST_AV_STATUS 		= 0x27;
		/**蓝牙状态  0X90 */
		int SLAVE_HOST_BLUE_STATUS 		= 0x28;
		/**媒体盒状态  0X90 */
		int SLAVE_HOST_MEDIABOX_STATUS 	= 0x29;
		/**方向盘转角  0X90 */
		int SLAVE_HOST_EPS_INFO 		= 0x26;
		/**车身信息*/
		int SLAVE_HOST_BODY_INFO		= 0x41;
	}
	/**宝骏*/
	public interface BaoJunComID {
		/**方控面板按键*/
		byte DATA_TYPE_KEY				= 0x21;
		/**后雷达信息*/
		byte DATA_TYPE_RADAR_B			= 0x26;
		/**前雷达信息*/
		byte DATA_TYPE_RADAR_F			= 0x27;
		/**基本信息*/
		byte DATA_TYPE_BASE		        = 0x28;
		/**转角*/
		byte DATA_TYPE_CORNER			= 0x30;
	}
	/**吉利*/
	public interface GeelyComID {
		/**背光*/
		byte DATA_BACK_LIGHT			= 0x14;
		/**方控面板按键*/
		byte DATA_TYPE_KEY				= 0x20;
		/**空调*/
		byte DATA_TYPE_AIR			    = 0x21;
		/**基本*/
		byte DATA_TYPE_BASE		        = 0x24;
	}
	
	
}
