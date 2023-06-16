package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/*** ��ʱû�� �Ƶ��ǿ�Э�� : �ָ��������� */
public class SpeedInfo extends BaseInfo {

	// �Ѽ�����ٶ�ֵ������Ϣ
	/*** �Ѽ�����ٶ�ֵ���� 1:�� 0���� */
	private boolean meSpeedPermit;
	/*** �����ٶ�1 1:ѡ�� 0��δѡ�� */
	private boolean meSpeed1In;
	/*** �����ٶ�2 1:ѡ�� 0��δѡ�� */
	private boolean meSpeed2In;
	/*** �����ٶ�3 1:ѡ�� 0��δѡ�� */
	private boolean meSpeed3In;
	/*** �����ٶ�4 1:ѡ�� 0��δѡ�� */
	private boolean meSpeed4In;
	/*** �����ٶ�5 1:ѡ�� 0��δѡ�� */
	private boolean meSpeed5In;
	/*** �����ٶ�6 1:ѡ�� 0��δѡ�� */
	private boolean meSpeed6In;

	/*** �ٶ�1ֵ */
	private int meSpeed1Va;
	/*** �ٶ�2ֵ */
	private int meSpeed2Va;
	/*** �ٶ�3ֵ */
	private int meSpeed3Va;
	/*** �ٶ�4ֵ */
	private int meSpeed4Va;
	/*** �ٶ�5ֵ */
	private int meSpeed5Va;
	/*** �ٶ�6ֵ */
	private int meSpeed6Va;
	// �Ѽ�����ٶ�ֵʹ��
	/*** �Ѽ�����ٶ�ֵʹ�� 1:��Ч 0����Ч */
	private boolean meSpeedEnable;
	/*** ʹ���ٶ�1 1:��Ч 0����Ч */
	private boolean meSpeed1En;
	/*** ʹ���ٶ�2 1:��Ч 0����Ч */
	private boolean meSpeed2En;
	/*** ʹ���ٶ�3 1:��Ч 0����Ч */
	private boolean meSpeed3En;
	/*** ʹ���ٶ�4 1:��Ч 0����Ч */
	private boolean meSpeed4En;
	/*** ʹ���ٶ�5 1:��Ч 0����Ч */
	private boolean meSpeed5En;
	/*** ʹ���ٶ�6 1:��Ч 0����Ч */
	private boolean meSpeed6En;

	// Ѳ���ٶ�ֵ������Ϣ
	/*** �Ѽ�����ٶ�ֵ���� 1:�� 0���� */
	private boolean crSpeedPermit;
	/*** �����ٶ�1 1:ѡ�� 0��δѡ�� */
	private boolean crSpeed1In;
	/*** �����ٶ�2 1:ѡ�� 0��δѡ�� */
	private boolean crSpeed2In;
	/*** �����ٶ�3 1:ѡ�� 0��δѡ�� */
	private boolean crSpeed3In;
	/*** �����ٶ�4 1:ѡ�� 0��δѡ�� */
	private boolean crSpeed4In;
	/*** �����ٶ�5 1:ѡ�� 0��δѡ�� */
	private boolean crSpeed5In;
	/*** �����ٶ�6 1:ѡ�� 0��δѡ�� */
	private boolean crSpeed6In;

	/*** �ٶ�1ֵ */
	private int crSpeed1Va;
	/*** �ٶ�2ֵ */
	private int crSpeed2Va;
	/*** �ٶ�3ֵ */
	private int crSpeed3Va;
	/*** �ٶ�4ֵ */
	private int crSpeed4Va;
	/*** �ٶ�5ֵ */
	private int crSpeed5Va;
	/*** �ٶ�6ֵ */
	private int crSpeed6Va;
	// Ѳ�����ٶ�ֵʹ��
	/*** �Ѽ�����ٶ�ֵʹ�� 1:��Ч 0����Ч */
	private boolean crSpeedEnable;
	/*** ʹ���ٶ�1 1:��Ч 0����Ч */
	private boolean crSpeed1En;
	/*** ʹ���ٶ�2 1:��Ч 0����Ч */
	private boolean crSpeed2En;
	/*** ʹ���ٶ�3 1:��Ч 0����Ч */
	private boolean crSpeed3En;
	/*** ʹ���ٶ�4 1:��Ч 0����Ч */
	private boolean crSpeed4En;
	/*** ʹ���ٶ�5 1:��Ч 0����Ч */
	private boolean crSpeed5En;
	/*** ʹ���ٶ�6 1:��Ч 0����Ч */
	private boolean crSpeed6En;

	public byte getID() {
		return Constant.ID_SPEED;
	}

	public boolean isCrSpeedPermit() {
		return crSpeedPermit;
	}

	public void setCrSpeedPermit(boolean crSpeedPermit) {
		this.crSpeedPermit = crSpeedPermit;
	}

	public boolean isCrSpeed1In() {
		return crSpeed1In;
	}

	public void setCrSpeed1In(boolean crSpeed1In) {
		this.crSpeed1In = crSpeed1In;
	}

	public boolean isCrSpeed2In() {
		return crSpeed2In;
	}

	public void setCrSpeed2In(boolean crSpeed2In) {
		this.crSpeed2In = crSpeed2In;
	}

	public boolean isCrSpeed3In() {
		return crSpeed3In;
	}

	public void setCrSpeed3In(boolean crSpeed3In) {
		this.crSpeed3In = crSpeed3In;
	}

	public boolean isCrSpeed4In() {
		return crSpeed4In;
	}

	public void setCrSpeed4In(boolean crSpeed4In) {
		this.crSpeed4In = crSpeed4In;
	}

	public boolean isCrSpeed5In() {
		return crSpeed5In;
	}

	public void setCrSpeed5In(boolean crSpeed5In) {
		this.crSpeed5In = crSpeed5In;
	}

	public boolean isCrSpeed6In() {
		return crSpeed6In;
	}

	public void setCrSpeed6In(boolean crSpeed6In) {
		this.crSpeed6In = crSpeed6In;
	}

	public int getCrSpeed1Va() {
		return crSpeed1Va;
	}

	public void setCrSpeed1Va(int crSpeed1Va) {
		this.crSpeed1Va = crSpeed1Va;
	}

	public int getCrSpeed2Va() {
		return crSpeed2Va;
	}

	public void setCrSpeed2Va(int crSpeed2Va) {
		this.crSpeed2Va = crSpeed2Va;
	}

	public int getCrSpeed3Va() {
		return crSpeed3Va;
	}

	public void setCrSpeed3Va(int crSpeed3Va) {
		this.crSpeed3Va = crSpeed3Va;
	}

	public int getCrSpeed4Va() {
		return crSpeed4Va;
	}

	public void setCrSpeed4Va(int crSpeed4Va) {
		this.crSpeed4Va = crSpeed4Va;
	}

	public int getCrSpeed5Va() {
		return crSpeed5Va;
	}

	public void setCrSpeed5Va(int crSpeed5Va) {
		this.crSpeed5Va = crSpeed5Va;
	}

	public int getCrSpeed6Va() {
		return crSpeed6Va;
	}

	public void setCrSpeed6Va(int crSpeed6Va) {
		this.crSpeed6Va = crSpeed6Va;
	}

	public boolean isCrSpeedEnable() {
		return crSpeedEnable;
	}

	public void setCrSpeedEnable(boolean crSpeedEnable) {
		this.crSpeedEnable = crSpeedEnable;
	}

	public boolean isCrSpeed1En() {
		return crSpeed1En;
	}

	public void setCrSpeed1En(boolean crSpeed1En) {
		this.crSpeed1En = crSpeed1En;
	}

	public boolean isCrSpeed2En() {
		return crSpeed2En;
	}

	public void setCrSpeed2En(boolean crSpeed2En) {
		this.crSpeed2En = crSpeed2En;
	}

	public boolean isCrSpeed3En() {
		return crSpeed3En;
	}

	public void setCrSpeed3En(boolean crSpeed3En) {
		this.crSpeed3En = crSpeed3En;
	}

	public boolean isCrSpeed4En() {
		return crSpeed4En;
	}

	public void setCrSpeed4En(boolean crSpeed4En) {
		this.crSpeed4En = crSpeed4En;
	}

	public boolean isCrSpeed5En() {
		return crSpeed5En;
	}

	public void setCrSpeed5En(boolean crSpeed5En) {
		this.crSpeed5En = crSpeed5En;
	}

	public boolean isCrSpeed6En() {
		return crSpeed6En;
	}

	public void setCrSpeed6En(boolean crSpeed6En) {
		this.crSpeed6En = crSpeed6En;
	}

	public boolean isMeSpeedPermit() {
		return meSpeedPermit;
	}

	public void setMeSpeedPermit(boolean meSpeedPermit) {
		this.meSpeedPermit = meSpeedPermit;
	}

	public boolean isMeSpeed1In() {
		return meSpeed1In;
	}

	public void setMeSpeed1In(boolean meSpeed1In) {
		this.meSpeed1In = meSpeed1In;
	}

	public boolean isMeSpeed2In() {
		return meSpeed2In;
	}

	public void setMeSpeed2In(boolean meSpeed2In) {
		this.meSpeed2In = meSpeed2In;
	}

	public boolean isMeSpeed3In() {
		return meSpeed3In;
	}

	public void setMeSpeed3In(boolean meSpeed3In) {
		this.meSpeed3In = meSpeed3In;
	}

	public boolean isMeSpeed4In() {
		return meSpeed4In;
	}

	public void setMeSpeed4In(boolean meSpeed4In) {
		this.meSpeed4In = meSpeed4In;
	}

	public boolean isMeSpeed5In() {
		return meSpeed5In;
	}

	public void setMeSpeed5In(boolean meSpeed5In) {
		this.meSpeed5In = meSpeed5In;
	}

	public boolean isMeSpeed6In() {
		return meSpeed6In;
	}

	public void setMeSpeed6In(boolean meSpeed6In) {
		this.meSpeed6In = meSpeed6In;
	}

	public int getMeSpeed1Va() {
		return meSpeed1Va;
	}

	public void setMeSpeed1Va(int meSpeed1Va) {
		this.meSpeed1Va = meSpeed1Va;
	}

	public int getMeSpeed2Va() {
		return meSpeed2Va;
	}

	public void setMeSpeed2Va(int meSpeed2Va) {
		this.meSpeed2Va = meSpeed2Va;
	}

	public int getMeSpeed3Va() {
		return meSpeed3Va;
	}

	public void setMeSpeed3Va(int meSpeed3Va) {
		this.meSpeed3Va = meSpeed3Va;
	}

	public int getMeSpeed4Va() {
		return meSpeed4Va;
	}

	public void setMeSpeed4Va(int meSpeed4Va) {
		this.meSpeed4Va = meSpeed4Va;
	}

	public int getMeSpeed5Va() {
		return meSpeed5Va;
	}

	public void setMeSpeed5Va(int meSpeed5Va) {
		this.meSpeed5Va = meSpeed5Va;
	}

	public int getMeSpeed6Va() {
		return meSpeed6Va;
	}

	public void setMeSpeed6Va(int meSpeed6Va) {
		this.meSpeed6Va = meSpeed6Va;
	}

	public boolean isMeSpeedEnable() {
		return meSpeedEnable;
	}

	public void setMeSpeedEnable(boolean meSpeedEnable) {
		this.meSpeedEnable = meSpeedEnable;
	}

	public boolean isMeSpeed1En() {
		return meSpeed1En;
	}

	public void setMeSpeed1En(boolean meSpeed1En) {
		this.meSpeed1En = meSpeed1En;
	}

	public boolean isMeSpeed2En() {
		return meSpeed2En;
	}

	public void setMeSpeed2En(boolean meSpeed2En) {
		this.meSpeed2En = meSpeed2En;
	}

	public boolean isMeSpeed3En() {
		return meSpeed3En;
	}

	public void setMeSpeed3En(boolean meSpeed3En) {
		this.meSpeed3En = meSpeed3En;
	}

	public boolean isMeSpeed4En() {
		return meSpeed4En;
	}

	public void setMeSpeed4En(boolean meSpeed4En) {
		this.meSpeed4En = meSpeed4En;
	}

	public boolean isMeSpeed5En() {
		return meSpeed5En;
	}

	public void setMeSpeed5En(boolean meSpeed5En) {
		this.meSpeed5En = meSpeed5En;
	}

	public boolean isMeSpeed6En() {
		return meSpeed6En;
	}

	public void setMeSpeed6En(boolean meSpeed6En) {
		this.meSpeed6En = meSpeed6En;
	};

}
