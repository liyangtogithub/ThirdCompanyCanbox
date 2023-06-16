package com.landsem.canbox;


public interface Constant {
    
	String LOG_SPLIT = "  ";
	int PROTOCAL_INVALID_VALUE = -1000;
	int INVALID_VALUE = -1;
	int FILE_END = INVALID_VALUE;
	/**����VR����*/
	byte KEYEVENT_VOICE = -1;
	/**�ҵ绰*/
	byte KEYEVENT_HANGUP = -2;
	/**�ӵ绰*/
	byte KEYEVENT_ANSWER = -3;
	/**�ҵ绰����һ��*/
	byte KEYEVENT_HANGUP_NEXT = -4;
	/**�ӵ绰����һ��*/
	byte KEYEVENT_ANSWER_PREV = -5;
	/**Mode����Media��*/
	byte KEYEVENT_MODE = -6;
	/**AUXIN*/
	byte KEYEVENT_AUXIN = -7;
	/**Power��*/
	byte KEYEVENT_POWER = -8;
	/**��ť������*/
	byte KEYEVENT_VOLUME_UP = -9;
	/**��ť������*/
	byte KEYEVENT_VOLUME_DOWN = -10;
	/**tune scan+ ��������������*/
	byte KEYEVENT_SCAN_UP = -11;
	/**tune scan- ��������������*/
	byte KEYEVENT_SCAN_DOWN = -12;
	/**������Ԥ��̨�л�+ */
	byte KEYEVENT_CHANNEL_UP = -13;
	/**������Ԥ��̨�л�-*/
	byte KEYEVENT_CHANNEL_DOWN = -14;
	/**���뵼��*/
	byte KEYEVENT_NAVI = -15;
	/**�ղص�̨*/
	byte KEYEVENT_COLLEC_RADIO = -16;
	/**�ҵ绰����*/
	byte KEYEVENT_HANGUP_MUTE = -17;
	/**�ӵ绰������*/
	byte KEYEVENT_ANSWER_VOICE = -18;
	/**EQ*/
	byte KEYEVENT_EQ = -19;
	/**��������*/
	byte KEYEVENT_BLUE_PHONE = -20;
	/**���ֽ���*/
	byte KEYEVENT_MUSIC = -21;
	/**����ʽ ����ѡ������Ƶ��*/
	byte KEYEVENT_CHANNEL_UP_FAST = -22;
	/**����ʽ ����ѡ������Ƶ��*/
	byte KEYEVENT_CHANNEL_DOWN_FAST = -23;
	/**������ȫ������*/
	byte KEYEVENT_SCAN_ALL = -24;
	/**SET*/
	byte KEYEVENT_SET = -25;
	/**��������*/
	byte KEYEVENT_REAR_VIDEO = -26;
	/**����CD����*/
	byte KEYEVENT_CD = -27;
	
	/** �յ��¶���ʾ��*/
	byte AIR_HIGH                = -100;
	/** �յ��¶���ʾ��*/
	byte AIR_LOW                 = -101;
	/** �յ��¶Ȳ���ʾ*/
	byte AIR_NONE                = -103;
	
	/** �������ݳ����±� */
	byte LENGTH = 2;
	/** �������������±� */
	byte COMID = 3;
	/** ����Э�����������±� */
	byte COMID_XINPU = 1;
	/** ����Э�����ݳ����±� */
	byte LENGTH_XINPU = 2;
	/** �����ֽ������±� */
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
	/** �ֽ������±� */
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
	/** λ�����±� */
	byte BIT0 = 0;
	byte BIT1 = 1;
	byte BIT2 = 2;
	byte BIT3 = 3;
	byte BIT4 = 4;
	byte BIT5 = 5;
	byte BIT6 = 6;
	byte BIT7 = 7;
	
	/** ������been ID*/
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
	
	/**CD �ر�ѭ��*/
	byte CD_RPT_CLOSE                = 0;
	/**CD ����ѭ��*/
	byte CD_RPT_SINGLE               = 1;
	/**CD Ŀ¼ѭ��*/
	byte CD_RPT_FOLD                 = 2;
	/**CD �ر����*/
	byte CD_RDM_CLOSE                = 3;
	/**CD Ŀ¼���*/
	byte CD_RDM_FOLD                 = 4;
	/**CD ȫ�����*/
	byte CD_RDM_ALL                  = 5;
	/**TEXT ���ͣ�������*/
	byte TEXT_NAME_SONG              = 0;
	/**TEXT ���ͣ��ļ�����*/
	byte TEXT_NAME_FOLD              = 1;
	/**TEXT ���ͣ���Ƭ��*/
	byte TEXT_NAME_DISC              = 2;
	/**TEXT ���ͣ�������*/
	byte TEXT_NAME_ART               = 3;
	/**TEXT ״̬�����뷽ʽASCII*/
	byte TEXT_STATE_ASCII            = 0;
	/**TEXT ״̬�����뷽ʽUNICODE���*/
	byte TEXT_STATE_UNICODE_B        = 1;
	/**TEXT ״̬�����뷽ʽUNICODEС��*/
	byte TEXT_STATE_UNICODE_S        = 2;
	/**TEXT ״̬�����뷽ʽUTF8*/
	byte TEXT_STATE_UTF8             = 3;
	
	
	/*** ����*/
	public interface DasAutoComID {
		/** ����������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_BASE_CAR = 0x72;
		/** �յ���Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_AIR_CONDITION = 0x73;
		/** ����汾��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_SOFT_VERSION = (byte) 0xF0;
		/** ��ʻԱ����ϵͳ�趨���� �������ߣ�Э��С� */
		byte COMID_INFO_SYSTEM_SETTING = 0x47;
		/** ����������Ϣ1 �������ߣ�Э��С� */
		byte COMID_INFO_CAR_DEFINITE1 = 0x12;
		/** ����������Ϣ2 �������ߣ�Э��С� */
		byte COMID_INFO_CAR_DEFINITE2 = 0x13;
		/** �״���Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_RADAR = 0x42;
		
		/** ����״̬��Ϣ �������ߣ�DVD������ */
		byte COMID_SEND_MAINFRAME = (byte) 0xD2;
		/** ��ʾ��Ϣ1 �������ߣ�DVD������ */
		byte COMID_SEND_DVD1 = (byte) 0xE2;
		/** ��ʾ��Ϣ2 �������ߣ�DVD������ */
		byte COMID_SEND_DVD2 = (byte) 0xE3;
		/** ��ʻԱ����ϵͳ�趨��Ϣ �������ߣ�DVD������ */
		byte COMID_SEND_SYSTEM_SETTING = 0x4C;
	}
	
	/*** �ִ�*/
	public interface HyunDaiComID {
		/** ����������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_BASE_CAR = 0x11;
		/** �յ���Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_AIR_CONDITION = 0x31;
		/** ����汾��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_SOFT_VERSION = (byte) 0xF0;
		/** ��尴���������ߣ�Э��С� */
		byte COMID_PANEL_KEY = 0x21;
		/** �����ť�������ߣ�Э��С� */
		byte COMID_PANEL_KNOB = 0x22;
		/** ������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_AMPLIFIER = (byte) 0xA6;
		/** ������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_CAR_TYPE = 0x26;
		
		/** ����״̬��Ϣ �������ߣ������� */
		byte COMID_SEND_MAINFRAME = (byte) 0xD2;
		/** ����������Ϣ �������ߣ������� */
		byte COMID_SEND_AMPLIFIER_SET = (byte) 0xAD;
		/** �������� �������ߣ������� */
		byte COMID_SEND_CAR_TYPE_SET = 0x24;
		/** ʱ������ �������ߣ������� */
		byte COMID_SEND_TIME_SET = (byte) 0xCB;
	}
	
	/*** �ղ�*/
	public interface NissanComID {
		/** ����������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_BASE_CAR = 0x72;
		/** ����ͷ��Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_CAMERA = (byte) 0xF2;
		/** ����汾��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_SOFT_VERSION = (byte) 0xF0;
		/** ý��Դ��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_MEDIA_SOURCE = (byte) 0xE0;
		/** ������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_AMPLIFIER = (byte) 0xA6;
		/** ǰ���״�����ߣ�Э��С� */
		byte COMID_INFO_RADAR_FB = 0x41;
		/** ��ť�����������ߣ�Э��С� */
		byte COMID_INFO_KNOB = 0x74;
		
		/** AUDIO STATUS �������ߣ������� */
		byte COMID_SEND_AUDIO_STATUS = (byte) 0xD2;
		/** �������� �������ߣ������� */
		byte COMID_SEND_SONG_NAME = (byte) 0xD3;
		/** ��������1 �������ߣ������� */
		byte COMID_SEND_SONG_NAME1 = (byte) 0xD4;
		/** У׼ʱ�䣬���� �������ߣ������� */
		byte COMID_SEND_ADJUST = (byte) 0xCB;
		/** ����ͷ���� �������ߣ������� */
		byte COMID_SEND_CAMERA_STATUS = (byte) 0xFD;
		/** ����������Ϣ �������ߣ������� */
		byte COMID_SEND_AMPLIFIER_SET = (byte) 0xAD;
		/** �������� �������ߣ������� */
		byte COMID_SEND_LANGUAGE_SET = (byte) 0x9A;
	}
	
	/***����*/
	public interface ToyotaComID {
		/** ����������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_BASE_CAR = 0x11;
		/** ����������Ϣ0 �������ߣ�Э��С� */
		byte COMID_INFO_CAR_DEFINITE0 = 0x13;
		/** ����������Ϣ1 �������ߣ�Э��С� */
		byte COMID_INFO_CAR_DEFINITE1 = 0x16;
		/** ����������Ϣ2 �������ߣ�Э��С� */
		byte COMID_INFO_CAR_DEFINITE2 = 0x17;
		/** �͵��� �������ߣ�Э��С� */
		byte COMID_INFO_OIL_ELEC = 0x1F;
		/** �״� �������ߣ�Э��С� */
		byte COMID_INFO_RADAR = 0x41;
		/** �趨��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_SET = 0x62;
		/** ������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_AMPLIFIER = (byte) 0xA6;
		/** �յ���Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_AIR_CONDITION = (byte) 0x82;
		/** ����汾��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_SOFT_VERSION = (byte) 0xF0;
		/** ������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_CAR_TYPE = 0x26;
		/** ԭ����״̬��Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_SCREEN_STATUS = (byte) 0xE8;
		
		/** �������� �������ߣ������� */
		byte COMID_SEND_CAR_TYPE = (byte) 0x2D;
		/** ���� �������ߣ������� */
		byte COMID_SEND_SET = (byte) 0x6A;
		/** ���ſ��ơ������ߣ������� */
		byte COMID_SEND_AMPLIFIER = (byte) 0xAD;
		/** DVD�����������ߣ������� */
		byte COMID_SEND_DVD = (byte) 0x24;
		/** ����ͷ��ʾ�л��������ߣ������� */
		byte COMID_SEND_CAMERA_CHANGE = (byte) 0xFA;
	}
	
	/*** �Ƶ��ǿ�*/
	public interface KoDiakComID {
		/** ����������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_BASE_CAR = 0x11;
		/** ������ϸ��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_DETAILED_CAR = 0x12;
		/** ������ϸ��Ϣ2 �������ߣ�Э��С� */
		byte COMID_INFO_DETAILED_CAR2 = 0x19;
		/** ����ϸ��״̬�����������Ժ� �������ߣ�Э��С� */
		byte COMID_INFO_STATUS_START = 0x13;
		/** ����ϸ��״̬������ʱ�� �������ߣ�Э��С� */
		byte COMID_INFO_STATUS_LONG = 0x14;
		/** ����ϸ��״̬�����Լ����𡾷����ߣ�Э��С� */
		byte COMID_INFO_STATUS_REFUEL = 0x15;
		/** �����õ����������ߣ�Э��С� */
		byte COMID_INFO_CONVENIENCE = 0x16;
		/** ����ʶ��š������ߣ�Э��С� */
		byte COMID_INFO_DISTINGUISH = 0x1F;
		/** ����������Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_MAINTAIN = 0x1E;
		/** �յ���Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_AIR_CONDITION = 0x31;
		/** �յ���Ϣ�趨���Ƿ�ʹ�ܣ��������ߣ�Э��С� */
		byte COMID_INFO_AIR_SET = 0x35;
		/** ǰ���״�����ߣ�Э��С� */
		byte COMID_INFO_RADAR_FB = 0x41;
		/** �����״�����ߣ�Э��С� */
		byte COMID_INFO_RADAR_LR = 0x42;
		/** ������ʻ�������������ߣ�Э��С� */
		byte COMID_INFO_PARKING_MANOEU = 0x45;
		/** ��̥�趨�������ߣ�Э��С� */
		byte COMID_INFO_TYRE = 0x46;
		/** ��ʻԱ����ϵͳ���á������ߣ�Э��С� */
		byte COMID_INFO_SYSTEM_SETTING = 0x47;
		/** ���趨��Ϣ2�������ߣ�Э��С� */
		byte COMID_INFO_LIGHT2 = 0x67;
		/** ���趨��Ϣ1�������ߣ�Э��С� */
		byte COMID_INFO_LIGHT1 = 0x68;
		/** ���Ӿ��͹�ˮ����Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_MIRROR_WIPER = 0x69;
		/** ����汾��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_SOFT_VERSION = (byte) 0xF0;
		/** �Ŵ�������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_DOOR_WINDOW = 0x64;
		/** �๦����ʾ �������ߣ�Э��С� */
		byte COMID_INFO_MULTI_FUNCTION = 0x76;
		/** �˶�ģʽ �������ߣ�Э��С� */
		byte COMID_INFO_SPORT_MODE = (byte) 0x85;
		/** ��ʻģʽ �������ߣ�Э��С� */
		byte COMID_INFO_DRIVE_MODE = (byte) 0x86;
		/** ��ʻģʽ2 �������ߣ�Э��С� */
		byte COMID_INFO_DRIVE_MODE2 = (byte) 0x87;
		/** �趨��λ��Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_UNIT = (byte) 0xC1;
		/** ʱ������ڡ������ߣ�Э��С� */
		byte COMID_INFO_TIME_DATE = (byte) 0xC2;
		/** ���桾�����ߣ�Э��С� */
		byte COMID_INFO_VEHICLE_ALARM =  0x74;
		/** ���桾�����ߣ�Э��С� */
		byte COMID_INFO_START_STOP_ALARM =  0x75;
		/** ���桾�����ߣ�Э��С� */
		byte COMID_INFO_CONV_CONS_ALARM =  0x77;
		/** ����Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_LIGHT = 0x36;
		/** ����ͷ��Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_CAMERA = (byte) 0xE8;
		
		
		/** ���������� �������ߣ������� */
		byte COMID_SEND_REQUEST_CMD = 0x0A;
		/** �ָ��������� �������ߣ������� */
		byte COMID_SEND_RESTORE_FACTORY_SETTINGS = 0x1A;
		/** �յ���Ϣ�趨����ʹ�ܵģ��������ߣ������� */
		byte COMID_SEND_AIR_SET = 0x3A;
		/** ������ʻ�������������ߣ������� */
		byte COMID_SEND_PARKING_MANOEU = 0x4A;
		/** ��̥�趨�������ߣ������� */
		byte COMID_SEND_TYRE = 0x4B;
		/** ��ʻԱ����ϵͳ���á������ߣ������� */
		byte COMID_SEND_SYSTEM_SETTING = 0x4C;
		/** ���趨��Ϣ�������ߣ������� */
		byte COMID_SEND_LIGHT = 0x6D;
		/** ���Ӿ��͹�ˮ����Ϣ�������ߣ������� */
		byte COMID_SEND_MIRROR_WIPER = 0x6E;
		/** �Ŵ�������Ϣ �������ߣ������� */
		byte COMID_SEND_DOOR_WINDOW = 0x6F;
		/** �๦����ʾ �������ߣ������� */
		byte COMID_SEND_MULTI_FUNCTION = 0x7B;
		/** �˶�ģʽ �������ߣ������� */
		byte COMID_SEND_SPORT_MODE = (byte) 0x8A;
		/** ��ʻģʽ �������ߣ������� */
		byte COMID_SEND_DRIVE_MODE = (byte) 0x8B;
		/** �������1 �������ߣ������� */
		byte COMID_SEND_DVD_STATUS = (byte) 0x91;
		/** �������2 �������ߣ������� */
		byte COMID_SEND_DVD_STATUS2 = (byte) 0x92;
		/** �������3 �������ߣ������� */
		byte COMID_SEND_DVD_STATUS3 = (byte) 0x93;
		/** �������4�������ߣ������� */
		byte COMID_SEND_DVD_STATUS4 = (byte) 0x94;
		/** �������5  �����绰��Ϣ1�������ߣ������� */
		byte COMID_SEND_DVD_STATUS5 = (byte) 0x95;
		/** �������6  �����绰��Ϣ2�������ߣ������� */
		byte COMID_SEND_DVD_STATUS6 = (byte) 0x96;
		/** ԭ��ͼ����ʾ�������ߣ������� */
		byte COMID_SEND_ICON = (byte) 0xE6;
		/** �趨���ԡ������ߣ������� */
		byte COMID_SEND_LANGUAGE = (byte) 0x9A;
		/** �趨��λ�������ߣ������� */
		byte COMID_SEND_UNIT = (byte) 0xCA;
		/** ʱ������ڡ������ߣ������� */
		byte COMID_SEND_TIME_DATE = (byte) 0xCB;
		/** ������Ϣ�������ߣ������� */
		byte COMID_SEND_NAVIGATION = (byte) 0xE4;
		/** ����״̬,���ġ������ߣ������� */
		byte COMID_SEND_DVD_STATUS_CHINESE = (byte) 0xE5;
		/** ����ͷ��Ϣ�������ߣ������� */
		byte COMID_SEND_CAMERA = (byte) 0xF2;
	}
	
	/*** ����*/
	public interface FordComID {
		/** ����������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_BASE_CAR = 0x11;
		/** ������ϸ��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_DETAILED_CAR = 0x12;
		/** �յ���Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_AIR_CONDITION = 0x31;
		/** ǰ���״�����ߣ�Э��С� */
		byte COMID_INFO_RADAR_FB = 0x41;
		/** �����״�����ߣ�Э��С� */
		byte COMID_INFO_RADAR_LR = 0x42;
		/** ����汾��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_SOFT_VERSION = (byte) 0xF0;
		/** SYNC��ʾ��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_SYNC_DISPLAY = (byte) 0xD0;
		/** SYNC������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_SYNC_PLAY = (byte) 0xD2;
		/** SYNC״̬��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_SYNC_STATE = (byte) 0xD3;
		/** ����������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_INTELLIGENT_SPEECH = (byte) 0xE0;
		/** ����������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_LANGUAGE_SET = (byte) 0x94;
		/** ��ʾ������Ϣ�������ߣ������� */
		byte COMID_INFO_PROMPT_SET = (byte) 0x68;
		/** ԭ����Ƶ��Ϣ�������ߣ������� */
		byte COMID_INFO_VIDEO_SET = (byte) 0xE8;
		/** �ͺġ������Ϣ�������ߣ������� */
		byte COMID_INFO_OIL_DISTANCE =  0x34;
		/** ����ʶ��š������ߣ������� */
		byte COMID_INFO_DISTINGUISH =  0x38;
		/** ��尴���������ߣ������� */
		byte COMID_INFO_PANEL_KEY =  0x21;
		/** �����ť�������ߣ������� */
		byte COMID_INFO_PANEL_KNOB=  0x22;
		
		
		/** SYNC������������ߣ������� */
		byte COMID_SEND_SYNC_KEY = (byte) 0xDA;
		/** SYNC��Ϣ�ط����󡾷����ߣ������� */
		byte COMID_SEND_SYNC_REPEAT = (byte) 0xDC;
		/** ��������ģʽ�������ߣ������� */
		byte COMID_SEND_DVD_MODE = (byte) 0x91;
		/** ����������������ߣ������� */
		byte COMID_SEND_LANGUAGE_SET = (byte) 0x9A;
		/** ��ʾ������������ߣ������� */
		byte COMID_SEND_PROMPT_SET = (byte) 0x6D;
		/** ԭ����Ƶ���á������ߣ������� */
		byte COMID_SEND_VIDEO_SET = (byte) 0xF2;
		/** ���������ظ��������ߣ������� */
		byte COMID_SEND_REPEAT = (byte) 0x6A;
	}
	
	/***PSAϵ�� ѩ����*/
	public interface PSAComID {
		/** ����������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_BASE_CAR = 0x11;
		/** ������ϸ��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_DETAILED_CAR = 0x12;
		/** �г�������Ϣ0�������ߣ�Э��С� */
		byte COMID_INFO_COMPUTER0 = 0x13;
		/** �г�������Ϣ1 �������ߣ�Э��С� */
		byte COMID_INFO_COMPUTER1 = 0x14;
		/** �г�������Ϣ2 �������ߣ�Э��С� */
		byte COMID_INFO_COMPUTER2 = 0x15;
		/** ��尴���������ߣ�Э��С� */
		byte COMID_PANEL_KEY = 0x21;
		/** �����ť�������ߣ�Э��С� */
		byte COMID_PANEL_KNOB = 0x22;
		/** �յ���Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_AIR_CONDITION = 0x31;
		/** �״� �������ߣ�Э��С� */
		byte COMID_INFO_RADAR = 0x41;
		/** �澯��Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_ALARM = 0x42;
		/** ����������Ϣʹ��1�������ߣ�Э��С� */
		byte COMID_INFO_SET_ENABLE1 = 0x71;
		/** ����������Ϣʹ��2�������ߣ�Э��С� */
		byte COMID_INFO_SET_ENABLE2 = 0x72;
		/** ����������Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_SET = 0x76;
		/** ����������Ϣ2�������ߣ�Э��С� */
		byte COMID_INFO_SET2 = 0x79;
		/** ����汾��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_SOFT_VERSION = (byte) 0xF0;
		/** �Ѽ����ٶ�ֵ������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_SPEED_SET = (byte) 0x81;
		/** Ѳ���ٶ�������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_CRUISE_SPEED = (byte) 0x82;
		/** sos��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_SOS = (byte) 0x83;
		/** �˶�ģʽ �������ߣ�Э��С� */
		byte COMID_INFO_SPORT_MODE = (byte) 0x85;
		/** ����������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_LANGUAGE_SET = (byte) 0x94;
		/** �趨��λ��Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_UNIT = (byte) 0xC1;
		/** ʱ������ڡ������ߣ�Э��С� */
		byte COMID_INFO_TIME_DATE = (byte) 0xC2;
		
		
		/** �г���Ϣ�趨��������ߣ������� */
		byte COMID_SEND_INFO_SET = (byte) 0x1B;
		/** �������� �������ߣ������� */
		byte COMID_SEND_CAR_TYPE_SET = 0x24;
		/** �յ���Ϣ�������ߣ������� */
		byte COMID_SEND_AIR_CONTROL = 0x3B;
		/** ����������������ߣ������� */
		byte COMID_SEND_SET = 0x7B;
		/** ����������������ߣ������� */
		byte COMID_SEND_SET2 = 0x7D;
		/** �Ѽ����ٶ�ֵ�������� �������ߣ������� */
		byte COMID_SEND_SPEED_SET = (byte) 0x8A;
		/** Ѳ���ٶ��������� �������ߣ������� */
		byte COMID_SEND_CRUISE_SPEED = (byte) 0x8B;
		/** �˶�ģʽ �������ߣ������� */
		byte COMID_SEND_SPORT_MODE = (byte) 0x8C;
		/** ���������������� �������ߣ������� */
		byte COMID_SEND_LANGUAGE_SET = (byte) 0x9A;
		/** �趨��λ��Ϣ�������ߣ������� */
		byte COMID_SEND_UNIT = (byte) 0xCA;
		/** ʱ������ڡ������ߣ������� */
		byte COMID_SEND_TIME_DATE = (byte) 0xCB;
		/** ģ����尴���������ߣ������� */
		byte COMID_SEND_PANEL_KEY = (byte) 0x21;
		/** ������ʾ״̬�������ߣ������� */
		byte COMID_SEND_DISPLAY_STATE = (byte) 0xA1;
		/** ��������Ϣ�������ߣ������� */
		byte COMID_SEND_RADIO = (byte) 0xA2;
		/** ������Ԥ��̨��Ϣ�������ߣ������� */
		byte COMID_SEND_RADIO_RESERVATION = (byte) 0xA3;
		/** CD/CDC��Ϣ�������ߣ������� */
		byte COMID_SEND_CD = (byte) 0xA4;
	}
	
	/***ͨ��*/
	public interface GMComID {
		/** ����������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_BASE_CAR = 0x11;
		/** ������ϸ��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_DETAILED_CAR = 0x12;
		/** ��尴���������ߣ�Э��С� */
		byte COMID_PANEL_KEY = 0x21;
		/** �����ť�������ߣ�Э��С� */
		byte COMID_PANEL_KNOB = 0x22;
		/** �������ѡ��״̬�������ߣ�Э��С� */
		byte COMID_PANEL_CHOICE = 0x23;
		/** �յ���Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_AIR_CONDITION = 0x31;
		/** �ͺġ������Ϣ�������ߣ������� */
		byte COMID_INFO_OIL_DISTANCE =  0x34;
		/** �յ���Ϣ�趨�������ߣ�Э��С� */
		byte COMID_INFO_AIR_SET = 0x35;
		/** �״� �������ߣ�Э��С� */
		byte COMID_INFO_RADAR = 0x41;
		/** ��ײ/���ϵͳ�趨��Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_MONITOR = 0x45;
		/** �������뷽�����趨��Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_COMFORT = 0x55;
		/** �����趨��Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_DOOR_LOCK = 0x65;
		/** ң���趨��Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_REMOTE = 0x66;
		/** �����趨��Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_LIGHT = 0x67;
		/** �Ǳ���ʾ�趨��Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_METER = 0x75;
		/** �˶�ģʽ �������ߣ�Э��С� */
		byte COMID_INFO_SPORT_MODE = (byte) 0x85;
		/** ������������ �������ߣ�Э��С� */
		byte COMID_INFO_VOICE_REQUEST = (byte) 0x90;
		/** ��������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_ANJI = (byte) 0xB1;
		/** ������ͨ����Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_ANJI_CALL = (byte) 0xB2;
		/** �����Ǿ�����Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_ANJI_WARNING = (byte) 0xB3;
		/** �����ǽ��պ��롾�����ߣ�Э��С� */
		byte COMID_INFO_ANJI_RECEIVE = (byte) 0xB4;
		/** ����������롾�����ߣ�Э��С� */
		byte COMID_INFO_BLUE_PASSWORD = (byte) 0xC2;
		/** �����绰���ơ������ߣ�Э��С� */
		byte COMID_INFO_BLUE_PHONE = (byte) 0xC3;
		/** ����汾��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_SOFT_VERSION = (byte) 0xF0;
		/** ��ײ/���ϵͳ�趨��Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_MONITOR2 = 0x46;
		/** �������뷽�����趨��Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_COMFORT2 = 0x56;
		/** ̥ѹ�����Ϣ�������ߣ������� */
		byte COMID_INFO_TIRE_PRESS = (byte) 0x68;
		/** ָ������Ϣ�������ߣ������� */
		byte COMID_INFO_COMPASS = (byte) 0x69;
		
		
		/** �������ѡ��״̬�������ߣ������� */
		byte COMID_SEND_PANEL_CHOICE = 0x2A;
		/** �յ���Ϣ�趨��������ߣ������� */
		byte COMID_SEND_AIR_SET = 0x3A;
		/** ��ײ/���ϵͳ�趨��Ϣ�������ߣ������� */
		byte COMID_SEND_MONITOR = 0x4A;
		/** �������뷽�����趨��Ϣ�������ߣ������� */
		byte COMID_SEND_COMFORT = 0x5A;
		/** ���������ظ��������ߣ������� */
		byte COMID_SEND_ORDER_REPEAT = 0x60;
		/** �����趨��������ߣ������� */
		byte COMID_SEND_DOOR_LOCK = 0x6A;
		/** ң���趨��������ߣ������� */
		byte COMID_SEND_REMOTE = 0x6B;
		/** �����趨��������ߣ������� */
		byte COMID_SEND_LIGHT = 0x6C;
		/** �Ǳ���ʾ�趨��������ߣ������� */
		byte COMID_SEND_METER = 0x7A;
		/** �˶�ģʽ �������ߣ������� */
		byte COMID_SEND_SPORT_MODE = (byte) 0x8A;
		/** ����״̬�������ߣ������� */
		byte COMID_SEND_DVD_STATUS = (byte) 0x91;
		/** �������� �������ߣ������� */
		byte COMID_SEND_LANGUAGE_SET = (byte) 0x9A;
		/** ��������������ߣ������� */
		byte COMID_SEND_ANJI_ORDER = (byte) 0xBA;
		/** �����Ǵ�����롾�����ߣ������� */
		byte COMID_SEND_ANJI_SEND = (byte) 0xBB;
		/** ����������������ߣ������� */
		byte COMID_INFO_BLUE_KEY = (byte) 0xCA;
		/** �յ�������������ߣ������� */
		byte COMID_SEND_AIR_CONTROL = 0x3B;
	}
	
	/***����ͨ�õ�ID*/
	public interface HiworldComID {
		/** ����������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_BASE_CAR = 0x11;
		/** �����Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_PANEL = 0x21;
		/** ��ť��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_KNOB = 0x22;
		/** ������ϸ��Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_DETAILED_CAR = 0x12;
		/** �յ���Ϣ�������ߣ�Э��С� */
		byte COMID_INFO_AIR_CONDITION = 0x31;
		/** ����������Ϣ �������ߣ�Э��С� */
		byte COMID_INFO_CAR_DEFINITE = 0x32;
		/** �״� �������ߣ�Э��С� */
		byte COMID_INFO_RADAR = 0x41;
	}
	
	/*** ���� COMID*/
	public  interface IHondaComID {
			/** ���������Ϣ �������ߣ�Э��С� */
			int COMID_INFO_BASE_CAR = 0x11;
			/** ���������Ϣ �������ߣ�Э��С� */
			int COMID_INFO_CAR_DEFINITE = 0x12;
			/** ��ǰ�ͺġ������Ϣ �������ߣ�Э��С� */
			int COMID_INFO_CURRENT_OIL_AND_MILES = 0x16;
			/** ��ǰ�ͺġ������Ϣ �������ߣ�Э��С� */
			int COMID_INFO_HISTORY_OIL_AND_MILES = 0x17;
			/** �յ���Ϣ �������ߣ�Э��С� */
			int COMID_INFO_AIR_CONDITION = 0x31;
			/** �״���Ϣ �������ߣ�Э��С� */
			int COMID_INFO_RADAR = 0x41;
			/** ԭ�������� �������ߣ����������� */
			int COMID_ORDER_ORIGINAL_VEHICLE_SCREEN_SETTING = 0xF2;
			/** ԭ����״̬��Ϣ �������ߣ�Э��С� */
			int COMID_INFO_ORIGINAL_VEHICLE_SCREEN = 0xE8;
			/** NVAI����״̬ �������ߣ����������� */
			int COMID_INFO_ORIGINAL_VEHICLE_STATE = 0xE1;
			/** ʱ���趨 �������ߣ����������� */
			int COMID_ORDER_TIME_SETTING = 0xB5;
			/** �趨���� �������ߣ����������� */
			int COMID_ORDER_SETTING = 0x6A;
			/** ���ƿյ�����CMD �������ߣ����������� */
			int COMID_ORDER_CONTROL_CONDITIONER_KEY = 0x3D;
			/** �ƹ��趨״̬ �������ߣ�Э��С� */
			int COMID_STATE_LIGHTS_SETTING = 0x67;
			/** �ƹ��趨���� �������ߣ����������� */
			int COMID_ORDER_LIGHTS_SETTING = 0x6c;
			/** ң���趨״̬ �������ߣ�Э��С� */
			int COMID_STATE_REMOTE_CONTROL_SETTING = 0x66;
			/** ң���趨���� �������ߣ����������� */
			int COMID_ORDER_REMOTE_CONTROL_SETTING = 0x6b;
			/** �����趨״̬ �������ߣ�Э��С� */
			int COMID_STATE_DOOR_AND_LOCK_SETTING = 0x65;
			/** �����趨��������ߣ����������� */
			int COMID_ORDER_DOOR_AND_LOCK_SETTING = 0x6D;
			/** ��ʻ����ϵͳ�趨״̬�������ߣ�Э��С� */
			int COMID_STATE_DRIVE_ASSIST_SYSTEM_SETTING = 0x68;
			/** ��ʻ����ϵͳ�趨��������ߣ����������� */
			int COMID_ORDER_DRIVE_ASSIST_SYSTEM_SETTING = 0x6E;
			/** �趨��ʾ������״̬�������ߣ�Э��С� */
			int COMID_STATE_SCREEN_SETTING = 0x69;
			/** �趨��ʾ��������������ߣ����������� */
			int COMID_ORDER_SCREEN_SETTING = 0x6F;
			/** ������Դ�������Ǳ��������ߣ�Э��С� */
			int COMID_INFO_REQUEST_CHANGE_SOURCE = 0xE0;
			/** ��������Ϣ �������ߣ����������� */
			int COMID_INFO_MUSIC_NAME = 0xE4;
			/** Types�趨���� �������ߣ����������� */
			int COMID_ORDER_TYPES_SETTING = 0x4B;
			/** �綯β���趨״̬ �������ߣ�Э��С� */
			int COMID_STATE_ELECTRIC_TRUNK_DOOR_SETTING = 0x75;
			/** �綯β���趨���� �������ߣ����������� */
			int COMID_ORDER_ELECTRIC_TRUNK_DOOR_SETTING = 0x7A;
			/** ԭ������״̬ �������ߣ�Э��С� */
			int COMID_STATE_ORIGINAL_VEHICLE_AMPLIFIER = 0xA6;
			/** ԭ���������� �������ߣ����������� */
			int COMID_ORDER_ORIGINAL_VEHICLE_AMPLIFIER_SETTING = 0xAD;
			/** �������� �������ߣ����������� */
			int COMID_ORDER_LANGUAGE_SETTING = 0x9A;
			/** ����汾�������ߣ�Э��С� */
			int COMID_INFO_SOFTWARE_VERSION = 0xF0;
}
	
	/***���� ���Դ� COMID*/
	public  interface HdMazdaComID {
			/** �����̰��� �������ߣ�Э��С� */
			int COMID_INFO_STEER_KEY = 0x11;
   }
	
	/***���� COMID*/
	public  interface BmwComID {
			/** ������� �������ߣ�Э��С� */
			int COMID_INFO_BACK_LIGHT = 0x14;
			/** �����̰��� �������ߣ�Э��С� */
			int COMID_INFO_STEER_KEY = 0x06;
			/** ���μ��ȡ������ߣ�Э��С� */
			int COMID_INFO_SEAT_HEAT = 0x07;
			/** ����Ϣ �������ߣ�Э��С� */
			int COMID_INFO_DOOR = 0x08;
			/** ������ת�ǡ������ߣ�Э��С� */
			int COMID_INFO_CORNER = 0x24;
			/** �״���Ϣ �������ߣ�Э��С� */
			int COMID_INFO_RADAR = 0x1c;
			/** ������Ϣ �������ߣ�Э��С� */
			int COMID_INFO_SPEED = 0x16;
			/** ����Ϣ �������ߣ�Э��С� */
			int COMID_INFO_CAR = 0x03;
			/** ��λ��Ϣ �������ߣ�Э��С� */
			int COMID_INFO_UNIT = 0x04;
   }
	
	/***���� COMID*/
	public  interface VenuciaComID {
			/** �����̰��� �������ߣ�Э��С� */
			int COMID_INFO_STEER_KEY = 0x20;
			/** �յ��������ߣ�Э��С� */
			int COMID_INFO_AIR_CONDITION = 0x21;
   }
	
	/***����˹COMID*/
	public  interface FocusComID {
			/** �����̰��� �������ߣ�Э��С� */
			int COMID_INFO_STEER_KEY = 0x20;
			/** �յ��������ߣ�Э��С� */
			int COMID_INFO_AIR_CONDITION = 0x21;
			/** ǰ���״�����ߣ�Э��С� */
			byte COMID_INFO_RADAR_B = 0x22;
			/** ǰ���״�����ߣ�Э��С� */
			byte COMID_INFO_RADAR_F = 0x23;
			/** ������Ϣ�������ߣ�Э��С� */
			int COMID_INFO_BASE_CAR = 0x24;
			/** ������Ϣ�������ߣ�Э��С� */
			int COMID_INFO_CAR = 0x29;
   }
	
	/***�ɵ�ŷCOMID*/
	public  interface MondeoComID {
			/** �����̰��� �������ߣ�Э��С� */
			int COMID_INFO_STEER_KEY = 0x01;
			/** �յ��������ߣ�Э��С� */
			int COMID_INFO_AIR_CONDITION = 0x02;
			/** ǰ���״�����ߣ�Э��С� */
			byte COMID_INFO_RADAR_B = 0x04;
			/** ����Ϣ �������ߣ�Э��С� */
			int COMID_INFO_DOOR = 0x0b;
			/** ���¶���Ϣ �������ߣ�Э��С� */
			int COMID_INFO_TEMP = 0x11;
   }
	
	/***���COMID*/
	public  interface EdgeComID {
			/** �����̰��� �������ߣ�Э��С� */
			int COMID_INFO_STEER_KEY = 0x20;
			/** �յ��������ߣ�Э��С� */
			int COMID_INFO_AIR_CONDITION = 0x29;
			/** ���״�����ߣ�Э��С� */
			byte COMID_INFO_RADAR_B = 0x22;
			/** ǰ�״�����ߣ�Э��С� */
			byte COMID_INFO_RADAR_F = 0x23;
			/** ������Ϣ�������ߣ�Э��С� */
			int COMID_INFO_BASE_CAR = 0x24;
			
   }
	/***����PSA COMID*/
	public  interface XPSAComID {
			/** �����̰��� �������ߣ�Э��С� */
			int COMID_INFO_STEER_KEY = 0x20;
			/** �յ��������ߣ�Э��С� */
			int COMID_INFO_AIR_CONDITION = 0x21;
			/** �״�����ߣ�Э��С� */
			byte COMID_INFO_RADAR = 0x32;
			/** ת�ǡ������ߣ�Э��С� */
			byte COMID_INFO_CORNER = 0x29;
			/** �г���Ϣ0 */
			byte COMID_INFO_CAR0 = 0x33;
			/** �г���Ϣ1  */
			byte COMID_INFO_CAR1 = 0x34;
			/** �ⲿ�¶�  */
			byte COMID_OUT_TEMP  = 0x36;
			/** ����״̬  */
			byte COMID_CAR_STATE  = 0x38;
   }
	
	/**0x90 ��ʾ�����ô������ѯ*/
	public interface SimpleDasAutoID {
		/**����������Ϣ */
		int SLAVE_HOST_COM_INFO 		= 0x10;
		/**������Ϣ 0X90 */
		int SLAVE_HOST_LIGHT_INFO 		= 0x14;
		/**�ٶ���Ϣ 0X90 */
		int SLAVE_HOST_SPEED_INFO 		= 0x16;
		/**�����̰��� 0X90 */
		int SLAVE_HOST_WHEEL_KEY 		= 0x20;
		/**�յ���Ϣ 0X90 */
		int SLAVE_HOST_AIR_CONTROL 		= 0x21;
		/**���״���Ϣ 0X90 */
		int SLAVE_HOST_BACK_RADAR 		= 0x22;
		/**ǰ�״���Ϣ 0X90 */
		int SLAVE_HOST_FRONT_RADAR 		= 0x23;
//		/**�汾��Ϣ 0X90 */
//		int SLAVE_HOST_VERSION_INFO 	= 0x30;
		/**������Ϣ 0X90 */
		int SLAVE_HOST_BASE_INFO 		= 0x24;
		/**�״�״̬��Ϣ 0X90 */
		int SLAVE_HOST_RADAR_STATUS 	= 0x25;
//		/**����״̬  0X90 */
//		int SLAVE_HOST_AV_STATUS 		= 0x27;
//		/**����״̬  0X90 */
//		int SLAVE_HOST_BLUE_STATUS 		= 0x28;
//		/**ý���״̬  0X90 */
//		int SLAVE_HOST_MEDIABOX_STATUS 	= 0x29;
		/**������ָ��*/
		int SLAVE_HOST_WHEEL_ORDER		= 0x2F;
		/**���״���Ϣ 0X90 */
		int SLAVE_HOST_LEFT_RADAR 		= 0x32;
		/**���״���Ϣ 0X90 */
		int SLAVE_HOST_RIGHT_RADAR 		= 0x33;
		/**������Ϣ*/
		int SLAVE_HOST_BODY_INFO		= 0x41;
		/**��ʻ��Ϣ*/
		int SLAVE_DRIVE_INFO		    = 0x50;
		
		public interface ComID1 {
			/**������ת��  0X90 */
			int SLAVE_HOST_EPS_INFO 		= 0x26;
		}
		
		public interface ComID2 {
			/**������ת��  */
			int SLAVE_HOST_EPS2_INFO 		= 0x29;
		}
		
		public interface SendComID1 {
			/**����ͨ��*/
			byte SEND_START_ORDER			= (byte) 0x81;
			/**��������� ��Ϣ */
			int REQUEST_CONTROL_INFO 		= 0X90;
			/**Source*/
			int SOURCE_INFO 		        = 0XC0;
			/**������*/
			int RADIO_INFO 		            = 0XC2;
			/**ý�岥����Ϣ*/
			int MEDIA_INFO 		            = 0XC3;
			/**������ʾ����*/
			int SOUND_INFO 		            = 0XC4;
			/**�绰״̬*/
			int PHONE_INFO 		            = 0XC5;
			/**���ſ���*/
			int POWER_AMPLI 		        = 0XA0;
			/**ý��п���*/
			int MEDIA_BOX  		            = 0XA1;
		}
		public interface SendComID2 {
			/**����ͨ��*/
			byte SEND_START_ORDER			= (byte) 0x81;
			/**Source*/
			int SOURCE_INFO 		        = 0XC0;
			/**ý�岥��״̬*/
			int MEDIA_STATE 		        = 0XC1;
			/**ý���ı���Ϣ��һ��*/
			int MEDIA_LINE_1 		        = 0X70;
			/**ý���ı���Ϣ�ڶ���*/
			int MEDIA_LINE_2 		        = 0X71;
			/**ý���ı���Ϣ������*/
			int MEDIA_LINE_3 		        = 0X72;
			/**������ʾ����*/
			int SOUND_INFO 		            = 0XC4;
			/**�绰״̬*/
			int PHONE_STATE 		        = 0XC5;
			/**�绰��Ϣ*/
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
		/**������尴��*/
		byte DATA_TYPE_KEY				= 0x02;
		/**�յ���Ϣ*/
		byte DATA_TYPE_AIRC				= 0x03;
		/**�״���Ϣ*/
		byte DATA_TYPE_RADAR			= 0x04;
		/**������Ϣ*/
		byte DATA_TYPE_DOOR				= 0x05;
		/**�����¶���Ϣ*/
		byte DATA_TYPE_TEMP				= 0x01;
		byte DATA_TYPE_BLIGHT			= 0x07;
		
		
		
	}
	
	public interface Mazda {
		/**������尴��*/
		byte DATA_TYPE_KEY				= 0x01;
		/**������Ϣ*/
		byte DATA_TYPE_DOOR		        = 0x02;
		/**ת����Ϣ*/
		byte DATA_TYPE_CORNER			= 0x07;
		/**�״���Ϣ*/
		byte DATA_TYPE_RADAR			= 0x08;
		/**������Ϣ*/
		byte DATA_TYPE_BLIGHT			= 0x0a;
		/**ԭ�������豸��Ϣ*/
		byte DATA_DEVICE_INFO			= 0x04;
		/**ԭ��ý�岥����Ϣ*/
		byte DATA_PLAY_INFO			    = 0x05;
		/**ԭ��ý��TXT��Ϣ*/
		byte DATA_TXT_INFO			    = 0x06;
		/**�ͺ�*/
		byte DATA_OIL_INFO			    = 0x0B;
		
		/**����CD����*/
		byte SEND_CD_ORDER			    = (byte) 0x82;
		/**������Ϣ����*/
		byte SEND_REQUEST_ORDER			= (byte) 0x83;
	}
	
	public interface MazdaSimple {
		/**������尴��*/
		byte DATA_TYPE_KEY				= 0x20;
		/**������Ϣ*/
		byte DATA_TYPE_BASE		        = 0x24;
		/**CD״̬*/
		byte DATA_CD_STATE		        = 0x25;
		/**CD����ʱ����Ϣ*/
		byte DATA_CD_TIME		        = 0x26;
		/**CD������Ŀ��Ϣ*/
		byte DATA_CD_CONTENT		    = 0x27;
		
		/**����ͨ��*/
		byte SEND_START_ORDER			= (byte) 0x81;
		/**������Ϣ����*/
		byte SEND_REQUEST_ORDER			= (byte) 0x90;
		/**��������*/
		byte SEND_CONTROL_ORDER			= (byte) 0xC7;
		
	}
	
	/***ͨ�� ����*/
	public interface XGMComID {
		/**���ذ���*/
		byte DATA_TYPE_KEY				= 0x01;
		/**��尴��*/
		byte DATA_TYPE_KNOB		        = 0x02;
		/**�յ�*/
		byte DATA_TYPE_AIR		        = 0x03;
		/**��*/
		byte DATA_TYPE_LIGHT		    = 0x04;
		/**����*/
		byte DATA_TYPE_SPEED		    = 0x0B;
		/**���״���Ϣ*/
		byte DATA_TYPE_RADAR_B			= 0x22;
		/**ǰ�״���Ϣ*/
		byte DATA_TYPE_RADAR_F			= 0x23;
		/**��*/
		byte DATA_TYPE_DOOR			    = 0x24;
		/**ת��*/
		byte DATA_TYPE_CORNER			= 0x26;
		/**������Ϣ1*/
		byte DATA_TYPE_CAR1			    = 0x31;
		/**������Ϣ2*/
		byte DATA_TYPE_CAR2			    = 0x32;
	}
	
	/**0x90 ��ʾ�����ô������ѯ*/
	public interface RaiseComID {
		/**����������Ϣ */
		int SLAVE_HOST_COM_INFO 		= 0x10;
		/**������Ϣ 0X90 */
		int SLAVE_HOST_LIGHT_INFO 		= 0x14;
		/**�ٶ���Ϣ 0X90 */
		int SLAVE_HOST_SPEED_INFO 		= 0x16;
		/**�����̰��� 0X90 */
		int SLAVE_HOST_WHEEL_KEY 		= 0x20;
		/**�յ���Ϣ 0X90 */
		int SLAVE_HOST_AIR_CONTROL 		= 0x21;
		/**���״���Ϣ 0X90 */
		int SLAVE_HOST_BACK_RADAR 		= 0x22;
		/**ǰ�״���Ϣ 0X90 */
		int SLAVE_HOST_FRONT_RADAR 		= 0x23;
		/**�汾��Ϣ 0X90 */
		int SLAVE_HOST_VERSION_INFO 	= 0x30;
		/**������Ϣ 0X90 */
		int SLAVE_HOST_BASE_INFO 		= 0x24;
		/**�״�״̬��Ϣ 0X90 */
		int SLAVE_HOST_RADAR_STATUS 	= 0x25;
		/**����״̬  0X90 */
		int SLAVE_HOST_AV_STATUS 		= 0x27;
		/**����״̬  0X90 */
		int SLAVE_HOST_BLUE_STATUS 		= 0x28;
		/**ý���״̬  0X90 */
		int SLAVE_HOST_MEDIABOX_STATUS 	= 0x29;
		/**������ת��  0X90 */
		int SLAVE_HOST_EPS_INFO 		= 0x26;
		/**������Ϣ*/
		int SLAVE_HOST_BODY_INFO		= 0x41;
	}
	/**����*/
	public interface BaoJunComID {
		/**������尴��*/
		byte DATA_TYPE_KEY				= 0x21;
		/**���״���Ϣ*/
		byte DATA_TYPE_RADAR_B			= 0x26;
		/**ǰ�״���Ϣ*/
		byte DATA_TYPE_RADAR_F			= 0x27;
		/**������Ϣ*/
		byte DATA_TYPE_BASE		        = 0x28;
		/**ת��*/
		byte DATA_TYPE_CORNER			= 0x30;
	}
	/**����*/
	public interface GeelyComID {
		/**����*/
		byte DATA_BACK_LIGHT			= 0x14;
		/**������尴��*/
		byte DATA_TYPE_KEY				= 0x20;
		/**�յ�*/
		byte DATA_TYPE_AIR			    = 0x21;
		/**����*/
		byte DATA_TYPE_BASE		        = 0x24;
	}
	
	
}
