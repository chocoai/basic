package com.originsys.safemanage.domain;
import java.io.Serializable;

public class TInvmEnclosur implements Serializable{
	/**房子编号*/
	private String house_id;
	/**围护分隔墙体无异常@1-否&2-是*/
	private String div_normal;
	/**围护分隔墙体明显变形@1-是&2-否*/
	private String div_obv_deform;
	/**围护分隔墙体裂缝@1-否&2-轻微&3-一般&4-严重*/
	private String div_crack;
	/**围护分隔墙体风化粉化@1-否&2-轻微&3-一般&4-严重*/
	private String div_decency;
	/**围护分隔墙体空鼓脱开@1-否&2-轻微&3-一般&4-严重*/
	private String div_decor_sep;
	/**围护分隔墙体渗漏@1-否&2-轻微&3-一般&4-严重*/
	private String div_leakage;
	/**围护门窗无异常@1-否&2-是*/
	private String wndr_normal;
	/**围护门窗明显变形@1-是&2-否*/
	private String wndr_obv_deform;
	/**围护门窗老化破损@1-否&2-轻微&3-一般&4-严重*/
	private String wndr_aging;
	/**围护外挂物无异常@1-否&2-是*/
	private String hang_normal;
	/**围护外挂物明显变形@1-是&2-否*/
	private String hang_obv_deform;
	/**围护外挂物老化破损@1-否&2-轻微&3-一般&4-严重*/
	private String hang_aging;
	/**围护附属构件无异常@1-否&2-是*/
	private String app_noraml;
	/**围护附属构件明显变形@1-是&2-否*/
	private String app_obv_defrom;
	/**围护附属构件老化破损@1-否&2-轻微&3-一般&4-严重*/
	private String app_aging;
	/**围护屋面防水无异常@1-否&2-是*/
	private String wall_normal;
	/**围护屋面防水渗漏@1-否&2-轻微&3-一般&4-严重*/
	private String wall_leakage;
	/**围护吊顶无异常@1-否&2-是*/
	private String suspend_normal;
	/**围护吊顶老化破损@1-否&2-轻微&3-一般&4-严重*/
	private String suspend_aging;
	/**围护其他防护设施无异常@1-否&2-是*/
	private String otherprotect_normal;
	/**围护其他防护设施老化破损@1-否&2-轻微&3-一般&4-严重*/
	private String otherprotect_aging;
	/**围护子项健康评级@1-a级&2-b级&3-c级&4-d级*/
	private String enclosur_grading;
	/**围护子项安全等级@1-a级&2-b级&3-c级&4-d级*/
	private String enclosur_healthgrading;
	/**围护备注*/
	private String enclosur_tdesc;
	//----------------------------------------------------------------
	/**设置房子编号的get方法*/
	public String getHouse_id() {
		return house_id;
	}
	/**设置房子编号的set方法*/
	public void setHouse_id(String house_id) {
		this.house_id = house_id;
	}
	/**设置围护分隔墙体无异常@1-否&2-是的get方法*/
	public String getDiv_normal() {
		return div_normal;
	}
	/**设置围护分隔墙体无异常@1-否&2-是的set方法*/
	public void setDiv_normal(String div_normal) {
		this.div_normal = div_normal;
	}
	/**设置围护分隔墙体明显变形@1-是&2-否的get方法*/
	public String getDiv_obv_deform() {
		return div_obv_deform;
	}
	/**设置围护分隔墙体明显变形@1-是&2-否的set方法*/
	public void setDiv_obv_deform(String div_obv_deform) {
		this.div_obv_deform = div_obv_deform;
	}
	/**设置围护分隔墙体裂缝@1-否&2-轻微&3-一般&4-严重的get方法*/
	public String getDiv_crack() {
		return div_crack;
	}
	/**设置围护分隔墙体裂缝@1-否&2-轻微&3-一般&4-严重的set方法*/
	public void setDiv_crack(String div_crack) {
		this.div_crack = div_crack;
	}
	/**设置围护分隔墙体风化粉化@1-否&2-轻微&3-一般&4-严重的get方法*/
	public String getDiv_decency() {
		return div_decency;
	}
	/**设置围护分隔墙体风化粉化@1-否&2-轻微&3-一般&4-严重的set方法*/
	public void setDiv_decency(String div_decency) {
		this.div_decency = div_decency;
	}
	/**设置围护分隔墙体空鼓脱开@1-否&2-轻微&3-一般&4-严重的get方法*/
	public String getDiv_decor_sep() {
		return div_decor_sep;
	}
	/**设置围护分隔墙体空鼓脱开@1-否&2-轻微&3-一般&4-严重的set方法*/
	public void setDiv_decor_sep(String div_decor_sep) {
		this.div_decor_sep = div_decor_sep;
	}
	/**设置围护分隔墙体渗漏@1-否&2-轻微&3-一般&4-严重的get方法*/
	public String getDiv_leakage() {
		return div_leakage;
	}
	/**设置围护分隔墙体渗漏@1-否&2-轻微&3-一般&4-严重的set方法*/
	public void setDiv_leakage(String div_leakage) {
		this.div_leakage = div_leakage;
	}
	/**设置围护门窗无异常@1-否&2-是的get方法*/
	public String getWndr_normal() {
		return wndr_normal;
	}
	/**设置围护门窗无异常@1-否&2-是的set方法*/
	public void setWndr_normal(String wndr_normal) {
		this.wndr_normal = wndr_normal;
	}
	/**设置围护门窗明显变形@1-是&2-否的get方法*/
	public String getWndr_obv_deform() {
		return wndr_obv_deform;
	}
	/**设置围护门窗明显变形@1-是&2-否的set方法*/
	public void setWndr_obv_deform(String wndr_obv_deform) {
		this.wndr_obv_deform = wndr_obv_deform;
	}
	/**设置围护门窗老化破损@1-否&2-轻微&3-一般&4-严重的get方法*/
	public String getWndr_aging() {
		return wndr_aging;
	}
	/**设置围护门窗老化破损@1-否&2-轻微&3-一般&4-严重的set方法*/
	public void setWndr_aging(String wndr_aging) {
		this.wndr_aging = wndr_aging;
	}
	/**设置围护外挂物无异常@1-否&2-是的get方法*/
	public String getHang_normal() {
		return hang_normal;
	}
	/**设置围护外挂物无异常@1-否&2-是的set方法*/
	public void setHang_normal(String hang_normal) {
		this.hang_normal = hang_normal;
	}
	/**设置围护外挂物明显变形@1-是&2-否的get方法*/
	public String getHang_obv_deform() {
		return hang_obv_deform;
	}
	/**设置围护外挂物明显变形@1-是&2-否的set方法*/
	public void setHang_obv_deform(String hang_obv_deform) {
		this.hang_obv_deform = hang_obv_deform;
	}
	/**设置围护外挂物老化破损@1-否&2-轻微&3-一般&4-严重的get方法*/
	public String getHang_aging() {
		return hang_aging;
	}
	/**设置围护外挂物老化破损@1-否&2-轻微&3-一般&4-严重的set方法*/
	public void setHang_aging(String hang_aging) {
		this.hang_aging = hang_aging;
	}
	/**设置围护附属构件无异常@1-否&2-是的get方法*/
	public String getApp_noraml() {
		return app_noraml;
	}
	/**设置围护附属构件无异常@1-否&2-是的set方法*/
	public void setApp_noraml(String app_noraml) {
		this.app_noraml = app_noraml;
	}
	/**设置围护附属构件明显变形@1-是&2-否的get方法*/
	public String getApp_obv_defrom() {
		return app_obv_defrom;
	}
	/**设置围护附属构件明显变形@1-是&2-否的set方法*/
	public void setApp_obv_defrom(String app_obv_defrom) {
		this.app_obv_defrom = app_obv_defrom;
	}
	/**设置围护附属构件老化破损@1-否&2-轻微&3-一般&4-严重的get方法*/
	public String getApp_aging() {
		return app_aging;
	}
	/**设置围护附属构件老化破损@1-否&2-轻微&3-一般&4-严重的set方法*/
	public void setApp_aging(String app_aging) {
		this.app_aging = app_aging;
	}
	/**设置围护屋面防水无异常@1-否&2-是的get方法*/
	public String getWall_normal() {
		return wall_normal;
	}
	/**设置围护屋面防水无异常@1-否&2-是的set方法*/
	public void setWall_normal(String wall_normal) {
		this.wall_normal = wall_normal;
	}
	/**设置围护屋面防水渗漏@1-否&2-轻微&3-一般&4-严重的get方法*/
	public String getWall_leakage() {
		return wall_leakage;
	}
	/**设置围护屋面防水渗漏@1-否&2-轻微&3-一般&4-严重的set方法*/
	public void setWall_leakage(String wall_leakage) {
		this.wall_leakage = wall_leakage;
	}
	/**设置围护吊顶无异常@1-否&2-是的get方法*/
	public String getSuspend_normal() {
		return suspend_normal;
	}
	/**设置围护吊顶无异常@1-否&2-是的set方法*/
	public void setSuspend_normal(String suspend_normal) {
		this.suspend_normal = suspend_normal;
	}
	/**设置围护吊顶老化破损@1-否&2-轻微&3-一般&4-严重的get方法*/
	public String getSuspend_aging() {
		return suspend_aging;
	}
	/**设置围护吊顶老化破损@1-否&2-轻微&3-一般&4-严重的set方法*/
	public void setSuspend_aging(String suspend_aging) {
		this.suspend_aging = suspend_aging;
	}
	/**设置围护其他防护设施无异常@1-否&2-是的get方法*/
	public String getOtherprotect_normal() {
		return otherprotect_normal;
	}
	/**设置围护其他防护设施无异常@1-否&2-是的set方法*/
	public void setOtherprotect_normal(String otherprotect_normal) {
		this.otherprotect_normal = otherprotect_normal;
	}
	/**设置围护其他防护设施老化破损@1-否&2-轻微&3-一般&4-严重的get方法*/
	public String getOtherprotect_aging() {
		return otherprotect_aging;
	}
	/**设置围护其他防护设施老化破损@1-否&2-轻微&3-一般&4-严重的set方法*/
	public void setOtherprotect_aging(String otherprotect_aging) {
		this.otherprotect_aging = otherprotect_aging;
	}
	/**设置围护子项健康评级@1-a级&2-b级&3-c级&4-d级的get方法*/
	public String getEnclosur_grading() {
		return enclosur_grading;
	}
	/**设置围护子项健康评级@1-a级&2-b级&3-c级&4-d级的set方法*/
	public void setEnclosur_grading(String enclosur_grading) {
		this.enclosur_grading = enclosur_grading;
	}
	/**设置围护子项安全等级@1-a级&2-b级&3-c级&4-d级的get方法*/
	public String getEnclosur_healthgrading() {
		return enclosur_healthgrading;
	}
	/**设置围护子项安全等级@1-a级&2-b级&3-c级&4-d级的set方法*/
	public void setEnclosur_healthgrading(String enclosur_healthgrading) {
		this.enclosur_healthgrading = enclosur_healthgrading;
	}
	/**设置围护备注的get方法*/
	public String getEnclosur_tdesc() {
		return enclosur_tdesc;
	}
	/**设置围护备注的set方法*/
	public void setEnclosur_tdesc(String enclosur_tdesc) {
		this.enclosur_tdesc = enclosur_tdesc;
	}
}