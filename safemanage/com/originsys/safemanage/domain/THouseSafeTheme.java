package com.originsys.safemanage.domain;

import java.io.Serializable;

public class THouseSafeTheme implements Serializable{
	private String num;
	private String jdinfo_id;
	private String building_id;
	private String building_address;
	private String building_region;
	private String dangerous_level;
	private String jd_date;
	private String check_date;
	private String jd_department_id;
	private String jd_department;
	private String smx;
	private String smy;
	public THouseSafeTheme() {}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getJdinfo_id() {
		return jdinfo_id;
	}
	public void setJdinfo_id(String jdinfo_id) {
		this.jdinfo_id = jdinfo_id;
	}
	public String getBuilding_id() {
		return building_id;
	}
	public void setBuilding_id(String building_id) {
		this.building_id = building_id;
	}
	public String getBuilding_address() {
		return building_address;
	}
	public void setBuilding_address(String building_address) {
		this.building_address = building_address;
	}
	public String getBuilding_region() {
		return building_region;
	}
	public void setBuilding_region(String building_region) {
		this.building_region = building_region;
	}
	public String getDangerous_level() {
		return dangerous_level;
	}
	public void setDangerous_level(String dangerous_level) {
		this.dangerous_level = dangerous_level;
	}
	public String getJd_date() {
		return jd_date;
	}
	public void setJd_date(String jd_date) {
		this.jd_date = jd_date;
	}
	public String getCheck_date() {
		return check_date;
	}
	public void setCheck_date(String check_date) {
		this.check_date = check_date;
	}
	public String getJd_department_id() {
		return jd_department_id;
	}
	public void setJd_department_id(String jd_department_id) {
		this.jd_department_id = jd_department_id;
	}
	public String getJd_department() {
		return jd_department;
	}
	public void setJd_department(String jd_department) {
		this.jd_department = jd_department;
	}
	public String getSmx() {
		return smx;
	}
	public void setSmx(String smx) {
		this.smx = smx;
	}
	public String getSmy() {
		return smy;
	}
	public void setSmy(String smy) {
		this.smy = smy;
	}
	
}
