package com.landsem.canbox.bean;

import com.landsem.canbox.Constant;

/*** 暂时没用 科迪亚克协议 : 恢复出厂设置 */
public class SpeedInfo extends BaseInfo {

	// 已记忆的速度值设置信息
	/*** 已记忆的速度值启用 1:开 0：关 */
	private boolean meSpeedPermit;
	/*** 启用速度1 1:选中 0：未选中 */
	private boolean meSpeed1In;
	/*** 启用速度2 1:选中 0：未选中 */
	private boolean meSpeed2In;
	/*** 启用速度3 1:选中 0：未选中 */
	private boolean meSpeed3In;
	/*** 启用速度4 1:选中 0：未选中 */
	private boolean meSpeed4In;
	/*** 启用速度5 1:选中 0：未选中 */
	private boolean meSpeed5In;
	/*** 启用速度6 1:选中 0：未选中 */
	private boolean meSpeed6In;

	/*** 速度1值 */
	private int meSpeed1Va;
	/*** 速度2值 */
	private int meSpeed2Va;
	/*** 速度3值 */
	private int meSpeed3Va;
	/*** 速度4值 */
	private int meSpeed4Va;
	/*** 速度5值 */
	private int meSpeed5Va;
	/*** 速度6值 */
	private int meSpeed6Va;
	// 已记忆的速度值使能
	/*** 已记忆的速度值使能 1:有效 0：无效 */
	private boolean meSpeedEnable;
	/*** 使能速度1 1:有效 0：无效 */
	private boolean meSpeed1En;
	/*** 使能速度2 1:有效 0：无效 */
	private boolean meSpeed2En;
	/*** 使能速度3 1:有效 0：无效 */
	private boolean meSpeed3En;
	/*** 使能速度4 1:有效 0：无效 */
	private boolean meSpeed4En;
	/*** 使能速度5 1:有效 0：无效 */
	private boolean meSpeed5En;
	/*** 使能速度6 1:有效 0：无效 */
	private boolean meSpeed6En;

	// 巡航速度值设置信息
	/*** 已记忆的速度值启用 1:开 0：关 */
	private boolean crSpeedPermit;
	/*** 启用速度1 1:选中 0：未选中 */
	private boolean crSpeed1In;
	/*** 启用速度2 1:选中 0：未选中 */
	private boolean crSpeed2In;
	/*** 启用速度3 1:选中 0：未选中 */
	private boolean crSpeed3In;
	/*** 启用速度4 1:选中 0：未选中 */
	private boolean crSpeed4In;
	/*** 启用速度5 1:选中 0：未选中 */
	private boolean crSpeed5In;
	/*** 启用速度6 1:选中 0：未选中 */
	private boolean crSpeed6In;

	/*** 速度1值 */
	private int crSpeed1Va;
	/*** 速度2值 */
	private int crSpeed2Va;
	/*** 速度3值 */
	private int crSpeed3Va;
	/*** 速度4值 */
	private int crSpeed4Va;
	/*** 速度5值 */
	private int crSpeed5Va;
	/*** 速度6值 */
	private int crSpeed6Va;
	// 巡航的速度值使能
	/*** 已记忆的速度值使能 1:有效 0：无效 */
	private boolean crSpeedEnable;
	/*** 使能速度1 1:有效 0：无效 */
	private boolean crSpeed1En;
	/*** 使能速度2 1:有效 0：无效 */
	private boolean crSpeed2En;
	/*** 使能速度3 1:有效 0：无效 */
	private boolean crSpeed3En;
	/*** 使能速度4 1:有效 0：无效 */
	private boolean crSpeed4En;
	/*** 使能速度5 1:有效 0：无效 */
	private boolean crSpeed5En;
	/*** 使能速度6 1:有效 0：无效 */
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
