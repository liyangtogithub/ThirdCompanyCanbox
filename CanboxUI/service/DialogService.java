package com.landsem.canboxui.service;

import com.landsem.canboxui.aidl.OutsideCallBackInterface;
import com.landsem.canboxui.aidl.OutsideInterface;
import com.landsem.canbox.Constant;
import com.landsem.canbox.bean.AirConditionInfo;
import com.landsem.canbox.bean.CarAlarm;
import com.landsem.canbox.bean.CarBaseInfo;
import com.landsem.canbox.bean.CarLargeInfo;
import com.landsem.canbox.bean.CornerInfo;
import com.landsem.canbox.bean.DoorInfo;
import com.landsem.canbox.bean.KeyFunctionInfo;
import com.landsem.canbox.bean.PeripheralInfo;
import com.landsem.canbox.bean.RadarInfo;
import com.landsem.canbox.bean.RoleBean;
import com.landsem.canbox.manager.SerialManager;
import com.landsem.canbox.observer.AirConditionObserver;
import com.landsem.canbox.observer.CarBaseObserver;
import com.landsem.canbox.observer.CarLargeObserver;
import com.landsem.canbox.observer.CornerObserver;
import com.landsem.canbox.observer.DoorObserver;
import com.landsem.canbox.observer.KeyFunctionObserver;
import com.landsem.canbox.observer.PeripheralObserver;
import com.landsem.canbox.observer.RadarObserver;
import com.landsem.canboxui.dialog.AirDialog;
import com.landsem.canboxui.dialog.AlarmNotify;
import com.landsem.canboxui.dialog.AllAirDialog;
import com.landsem.canboxui.dialog.DoorDialog;
import com.landsem.canboxui.dialog.HeadDialog;
import com.landsem.canboxui.utils.AirUtil;
import com.landsem.canboxui.utils.CarAlarmUtil;
import com.landsem.canboxui.utils.CommonUtil;
import com.landsem.canboxui.utils.ConstantUtil;
import com.landsem.canboxui.utils.DoorUtil;
import com.landsem.canboxui.utils.KeyUtil;
import com.landsem.canboxui.utils.ReverseUtil;
import com.landsem.common.tools.LogManager;
import com.landsem.dvr.Direction;
import com.landsem.dvr.Turn;
import com.landsem.dvr.TurnDetect;

import android.app.Service;
import android.app.StatusBarManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.UserHandle;

public class DialogService extends  Service  {

	AirDialog mAirDialog;
	AllAirDialog mAllAirDialog;
	DoorDialog mDoorDialog;
	HeadDialog mHeadDialog;
	Context mContext;
	boolean isILLOpen = false;
	boolean isILLOpenOld = false;
	boolean isILLFirst = true;
	boolean isReverse = false;
	boolean isReverseOld = false;
	boolean isReverseFirst = true;
	boolean isCameraRight = false;
	boolean isCameraRightOld = false;
	DoorInfo mOldDoorInfo;
	CarAlarm mCarAlarmOld;
	AirConditionInfo mOldAirConditionInfo  = null;
	OutsideCallBackClass mOutsideCallBackClass ;
	int leftCornerOld = Constant.PROTOCAL_INVALID_VALUE;
	int rightCornerOld = Constant.PROTOCAL_INVALID_VALUE;
	int leftCorner = Constant.PROTOCAL_INVALID_VALUE;
	int rightCorner = Constant.PROTOCAL_INVALID_VALUE;
	OutsideInterface mOutsideInterface;
	int backLeftValue = Constant.PROTOCAL_INVALID_VALUE;
	int backMidLeftValue = Constant.PROTOCAL_INVALID_VALUE;
	int backMidRightValue = Constant.PROTOCAL_INVALID_VALUE;
	int backRightValue = Constant.PROTOCAL_INVALID_VALUE;
	int frontLeftValue = Constant.PROTOCAL_INVALID_VALUE;
	int frontMidLeftValue = Constant.PROTOCAL_INVALID_VALUE;
	int frontMidRightValue = Constant.PROTOCAL_INVALID_VALUE;
	int frontRightValue = Constant.PROTOCAL_INVALID_VALUE;
	int keyCode = Constant.PROTOCAL_INVALID_VALUE ;
	int stepValue = Constant.PROTOCAL_INVALID_VALUE ;
	int stepValueMax = Constant.PROTOCAL_INVALID_VALUE ;
	int keyDelayTime = 200;
	int BINDID_TURN_DETECT			= 0x07;
	TurnDetect mTurnDetect;
	String carString = "";

	@Override
	public void onCreate() {
		super.onCreate();
		LogManager.d(ConstantUtil.TAG,"CanboxUI  DialogService  onCreate");
		mContext = this;
		mAirDialog = new AirDialog(this);
		mAllAirDialog = new AllAirDialog(this);
		mDoorDialog = new DoorDialog(this);
		mHeadDialog = new HeadDialog(this);
		AlarmNotify.notificationMethod(AlarmNotify.NULL_NOTIFY,"",mContext);
		mOutsideCallBackClass = new  OutsideCallBackClass();
		SerialManager.getInstance().onSetAirConditionObserver(mAirConditionObserver, new RoleBean());
		SerialManager.getInstance().onSetDoorObserver(mDoorObserver, new RoleBean());
		SerialManager.getInstance().onSetCarLargeObserver(mCarLargeObserver, new RoleBean());
		SerialManager.getInstance().onSetCarBaseObserver(mCarBaseInfoObserver, new RoleBean());
		SerialManager.getInstance().onSetCornerObserver(mCornerObserver, new RoleBean());
		SerialManager.getInstance().onSetRadarObserver(mRadarObserver, new RoleBean());
		SerialManager.getInstance().onKeyFunctionObserver(mKeyFunctionObserver, new RoleBean());
		SerialManager.getInstance().onSetPeripheralObserver(mPeripheralObserver, new RoleBean());
		bindDvr();
	}
	
	private void bindDvr() {
	    Intent recIntent = new Intent("com.landsem.actions.DVR_CONDUCT");
	    recIntent.putExtra("bindID", BINDID_TURN_DETECT);
	    bindService(recIntent, recConnection, Context.BIND_AUTO_CREATE);
	}
	
	private ServiceConnection recConnection = new ServiceConnection() {
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			LogManager.d("DVR onServiceConnected name: "+name);
			mTurnDetect = TurnDetect.Stub.asInterface(service);
			try {
				service.linkToDeath(mDvrDeathRecipient, 0);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
		}
	};
	
	private IBinder.DeathRecipient mDvrDeathRecipient = new IBinder.DeathRecipient(){
		@Override
		public void binderDied() {
			if (mTurnDetect == null) {
				return;
			}
			LogManager.d("DVR onService Died: ");
			mTurnDetect.asBinder().unlinkToDeath(mDvrDeathRecipient, 0);
			mTurnDetect = null;
			bindDvr();
		}
		
	};

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		LogManager.d(ConstantUtil.TAG,"DialogService  onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}
	
	AirConditionObserver mAirConditionObserver = new AirConditionObserver() {
		@Override
		public void onPushAirConditionInfo(AirConditionInfo mAirConditionInfo) {
			// 空调
			carString = "后窗除雾 " + mAirConditionInfo.isBackWindowDemist()
					+"、  前窗除雾 "+ mAirConditionInfo.isFrontWindowDemist()
					+"\r\n"+"、左吹风:吹脚 " + mAirConditionInfo.isLeftWindBlowFoot()
					+"、左吹风:吹头  " + mAirConditionInfo.isLeftWindBlowHead()
					+"、左吹风:吹窗 " + mAirConditionInfo.isLeftWindBlowWindow()
					+"、左吹风:吹身  " + mAirConditionInfo.isLeftWindBlowBody()
				    +"\r\n"+"、右吹风:吹脚 " + mAirConditionInfo.isRightWindBlowFoot()
				    +"、右吹风:吹头 " + mAirConditionInfo.isRightWindBlowHead()
				    +"、右吹风:吹窗 " + mAirConditionInfo.isRightWindBlowWindow()
				    +"、右吹风:吹身 " + mAirConditionInfo.isRightWindBlowBody()
				    +"\r\n"+"、左温度 " + mAirConditionInfo.getFrontLeftSeatSetTemp()
				    +"、右温度 " + mAirConditionInfo.getFrontRightSeatSetTemp()
				    +"\r\n"+"、风量等级 " + mAirConditionInfo.getLeftWindGrade()
				    + "、外循环模式 ："+ mAirConditionInfo.isCircleOut() 
				    + "、Auto "+ mAirConditionInfo.isAutoSwitch1() 
				    + "、  A/C "+ mAirConditionInfo.isAcEnable() 
					+"\r\n"+ "、右边座椅加热等级 "+ mAirConditionInfo.getRightSeatHeatGrade() 
				    + "、  左边座椅加热等级 "+ mAirConditionInfo.getLeftSeatHeatGrade() 
					+"左温度值 "+ mAirConditionInfo.getFrontLeftSeatSetTemp() 
					+ "、  右温度值 "+ mAirConditionInfo.getFrontRightSeatSetTemp() 
					+"\r\n"+ " 、右风速等级  " + mAirConditionInfo.getRightWindGrade()
					+ " 、左风速等级  " + mAirConditionInfo.getLeftWindGrade() 
				    ;
			LogManager.d(ConstantUtil.TAG, carString);
			if (isAirInfoChanged(mAirConditionInfo)) {
				CommonUtil.stopScreenProtect(mContext);
				showMessageObject(mAirConditionInfo, ConstantUtil.MESSAGE_ALL_AIR);
			}
			//showMessageObject(mAirConditionInfo, ConstantUtil.MESSAGE_AIR);单独弹空调信息的
		}

		private boolean isAirInfoChanged(AirConditionInfo mAirConditionInfo) {
			if (mOldAirConditionInfo==null) {
				mOldAirConditionInfo = (AirConditionInfo)mAirConditionInfo.clone() ;
				return false;
			}
			if (AirUtil.isAirConditionChanged(mAirConditionInfo,mOldAirConditionInfo)) {
				mOldAirConditionInfo = (AirConditionInfo)mAirConditionInfo.clone() ;
				return true;
			}
			return false;
		}
	};
	
	DoorObserver mDoorObserver = new DoorObserver() {
		@Override
		public void onPushDoorInfo(DoorInfo mDoorInfo) {
			// 门
			carString = "引擎盖"+ mDoorInfo.isEngineHood() 
					+ "  驾驶员门 "+ mDoorInfo.isDriverDoor()+ "  左后门 "+ mDoorInfo.isLeftBackDoor()
					+ "  乘客门 "+ mDoorInfo.isPassengerDoor()+ "  右后门 "+ mDoorInfo.isRightBackDoor()
					+ "  行李箱 "+ mDoorInfo.isBackTrunk() ;
			LogManager.d(ConstantUtil.TAG,carString);
			if (DoorUtil.isDoorChange(mDoorInfo,mOldDoorInfo)) {
				mOldDoorInfo = (DoorInfo)mDoorInfo.clone() ;
				CommonUtil.stopScreenProtect(mContext);
				showMessageObject(mDoorInfo,  ConstantUtil.MESSAGE_DOOR);
			}
		}
	};
	
	CarLargeObserver mCarLargeObserver = new CarLargeObserver() {
		
		@Override
		public void onPushCarLargeInfo(CarLargeInfo mCarLargeInfo) {
		}
		
		@Override
		public void onPushCarAlarm(CarAlarm mCarAlarm) {
			carString = "低油警告："+ mCarAlarm.isLowOilAlarm() 
					+ " 低电压警告："+ mCarAlarm.isLowVoltageAlarm()+ "  安全带警告： "+ mCarAlarm.isSafetyBeltAlarm()
					+ " 清洗液警告："+ mCarAlarm.isCleaningLiquidAlarm() ;
			LogManager.d(ConstantUtil.TAG,carString);
			if (CarAlarmUtil.isCarAlarmChange(mCarAlarm,mCarAlarmOld)) {
				mCarAlarmOld = (CarAlarm)mCarAlarm.clone() ;
				CommonUtil.stopScreenProtect(mContext);
				showMessageObject(mCarAlarm, ConstantUtil.MESSAGE_CAR_ALARM);
			}
			
		}
	};
	
	CarBaseObserver mCarBaseInfoObserver = new CarBaseObserver() {
		@Override
		public void onPushCarBaseInfo(CarBaseInfo mCarBaseInfo) {
			// 车辆基本信息
			isILLOpen = mCarBaseInfo.isILL();
			isReverse = mCarBaseInfo.isREV();
			carString = "大灯:"+ isILLOpen+"、倒车： "+isReverse;
			LogManager.d(ConstantUtil.TAG,carString);
			if (isILLOpen!=isILLOpenOld||isILLFirst) {
				isILLFirst = false;
				isILLOpenOld = isILLOpen;
				CommonUtil.stopScreenProtect(mContext);
				showMessageObject(isILLOpen, ConstantUtil.MESSAGE_CARBASE_LIGHT);
			}
			if (isReverse!=isReverseOld||isReverseFirst) {
				isReverseFirst = false;
				isReverseOld = isReverse;
				CommonUtil.stopScreenProtect(mContext);
				showMessageObject(isReverse, ConstantUtil.MESSAGE_CARBASE_REVERSE);
			}
		}
	};
	
	CornerObserver mCornerObserver = new CornerObserver(){
		@Override
		public void onPushCornerInfo(CornerInfo mCornerInfo) {
			leftCorner = mCornerInfo.getLeftCorner();
			rightCorner = mCornerInfo.getRightCorner();
			LogManager.d(ConstantUtil.TAG,"leftCorner  : "+leftCorner+"  rightCorner: "+rightCorner); 
			try {
				if (null != mOutsideInterface) {
					if (leftCorner != Constant.PROTOCAL_INVALID_VALUE) {
						mOutsideInterface.sendConner(true, leftCorner);
					}else if (rightCorner != Constant.PROTOCAL_INVALID_VALUE) {
						mOutsideInterface.sendConner(false, rightCorner);
					}
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	};
	
	RadarObserver mRadarObserver = new RadarObserver(){

		@Override
		public void onPushRadarInfo(RadarInfo mRadarInfo) {
			
			backLeftValue = mRadarInfo.getBackLeftValue();
			backMidLeftValue = mRadarInfo.getBackMidLeftValue();
			backMidRightValue = mRadarInfo.getBackMidRightValue();
			backRightValue = mRadarInfo.getBackRightValue();
			
			frontLeftValue = mRadarInfo.getFrontLeftValue();
			frontMidLeftValue = mRadarInfo.getFrontMidLeftValue();
			frontMidRightValue = mRadarInfo.getFrontMidRightValue();
			frontRightValue = mRadarInfo.getFrontRightValue();
			LogManager.d(ConstantUtil.TAG,"  frontLeftValue: "+frontLeftValue+"  frontMidLeftValue: "+frontMidLeftValue+
					"  frontMidRightValue: "+frontMidRightValue+"  frontRightValue: "+frontRightValue+"  backLeftValue: "+backLeftValue+"  backMidLeftValue： "
			+backMidLeftValue+"  backMidRightValue ："+backMidRightValue+"  backRightValue: "+backRightValue
			);
			try {
				if (null != mOutsideInterface) {
					mOutsideInterface.sendRadar( frontLeftValue, frontMidLeftValue, frontMidRightValue, 
							frontRightValue,backLeftValue, backMidLeftValue, backMidRightValue, backRightValue
							);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
		}
	};
	
	KeyFunctionObserver mKeyFunctionObserver = new KeyFunctionObserver() {
	    //键值
		@Override
		public void onPushKeyFunctionInfo(KeyFunctionInfo mKeyFunctionInfo) {
			keyCode = mKeyFunctionInfo.getSteerKeyFuction();
			stepValue = mKeyFunctionInfo.getStepValue();
			stepValueMax = mKeyFunctionInfo.getStepValueMax();
			carString = "  键值:" +keyCode+"  步进值:"+stepValue+"  步进最大值:"+stepValueMax;
			LogManager.d(ConstantUtil.TAG,carString);
			if (keyCode!=Constant.PROTOCAL_INVALID_VALUE ) {
				if (keyCode==Constant.KEYEVENT_VOLUME_UP || keyCode==Constant.KEYEVENT_VOLUME_DOWN) {
					keyDelayTime = 0 ;
				}else {
					keyDelayTime = mKeyFunctionInfo.isSteeringKeyLongDown()? 60:200;
				}
				CommonUtil.stopScreenProtect(mContext);
				showKeyMessageObject(keyCode, stepValue, stepValueMax, ConstantUtil.MESSAGE_CARBASE_KEY);
			}
		}

		private void showKeyMessageObject(int keyCode, int stepValue,int stepValueMax, int messageCarbaseKey) {
			dialogHandler.removeMessages(messageCarbaseKey);
			Message msg = dialogHandler.obtainMessage();
			msg.obj = keyCode;
			msg.arg1 = stepValue;
			msg.arg2 = stepValueMax;
			msg.what = messageCarbaseKey;
			dialogHandler.sendMessageDelayed(msg, keyDelayTime);
		}
	};
	
	PeripheralObserver mPeripheralObserver = new PeripheralObserver() {
		
		@Override
		public void onPushPeripheralInfo(PeripheralInfo mPeripheralInfo) {
			isCameraRight = mPeripheralInfo.isCameraOnRight();
			LogManager.d(ConstantUtil.TAG,"isCameraRight "+isCameraRight);
			if (mTurnDetect!=null && isCameraRight != isCameraRightOld) {
				isCameraRightOld= isCameraRight;
				if (isCameraRight) {
					turnRightValid(true);
				}else {
					turnRightValid(false);
				}
			}
		}

		private void turnRightValid(boolean isValid) {
			Turn mTurn = new Turn();
			mTurn.direction = Direction.RIGHT;
			mTurn.valid = isValid;
			try {
				mTurnDetect.turnChanged(mTurn);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	};
	
	private void showMessageObject(Object obj, int what) {
		Message msg = dialogHandler.obtainMessage();
		msg.obj = obj;
		msg.what = what;
		dialogHandler.sendMessage(msg);
	}
	
	Handler dialogHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case ConstantUtil.MESSAGE_CARBASE_KEY:
				KeyUtil.sendKeyEvent(msg,DialogService.this);
				break;
			case ConstantUtil.MESSAGE_CARBASE_LIGHT:
				if (null != mHeadDialog) {
					mHeadDialog.displayState( (boolean) msg.obj);
				}
				break;
			case ConstantUtil.MESSAGE_CARBASE_REVERSE:
				if ((boolean) msg.obj) {
					ReverseUtil.goRearVideo(mContext);
				}else {
					ReverseUtil.outRearVideo(mContext);
				}
				break;	
			case ConstantUtil.MESSAGE_DOOR:
				if (null != mDoorDialog) {
					mDoorDialog.displayState((DoorInfo) msg.obj);
				}
				break;
			case ConstantUtil.MESSAGE_CAR_ALARM:
				AlarmNotify.notifyAlarm((CarAlarm) msg.obj, mContext);
				break;
			case ConstantUtil.MESSAGE_AIR:
				if (null != mAirDialog) {
					mAirDialog.displayState((AirConditionInfo) msg.obj);
				}
				break;
			case ConstantUtil.MESSAGE_ALL_AIR:
			   if (null != mAllAirDialog) {
				   mAllAirDialog.displayState((AirConditionInfo) msg.obj);
			    }
			   break;
			}
		}
	};
	
	
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		LogManager.d(ConstantUtil.TAG,"DialogService  onDestroy()");
	}

	@Override
	public IBinder onBind(Intent intent) {
		LogManager.d(ConstantUtil.TAG,"onBind IBinder :" +mOutsideCallBackClass);
		return mOutsideCallBackClass;
	}
	
	class OutsideCallBackClass extends OutsideCallBackInterface.Stub{

		@Override
		public void registOutsideInterface(OutsideInterface mInterface)throws RemoteException {
			mOutsideInterface = mInterface;
			LogManager.d(ConstantUtil.TAG,"registOutsideInterface mOutsideInterface : "+mOutsideInterface);
		}
	}
	
	

}
