package com.originsys.realtygis.domain;

import oracle.sql.BLOB;


public class BasicSurver {
	private String  building_id;//楼幢编号
	private String  building_mapid;//地理表关联码
	private String  surverbasic_id;//项目编号
	private String  surverbasic_name;//项目名称
	private String  entrust_unit;//委托单位
	private String  linkman_tel;//联系电话
	private String  surverbasic_address;//项目坐落
	private String  city_district;//所属城区
	private String  surverarea_value;//面积
	private  byte[]  basicproduct_file;//测绘报告
	private  byte[] basicsddfile_file;//图形
	private String  surverbasic_desc;//备注
	private String  basicproduct_filename;//测绘报告名称
	/** 基础测绘 测绘报告下载专用   zhanglf  2014年4月3日  start*/
	private byte[]  projectfile_fileblob;//测绘报告
	private String  projectfile_filename;//文件名
	/** 基础测绘 测绘报告下载专用   end*/
	
	public String getBuilding_id() {
		return building_id;
	}
	public void setBuilding_id(String building_id) {
		this.building_id = building_id;
	}
	public String getBuilding_mapid() {
		return building_mapid;
	}
	public void setBuilding_mapid(String building_mapid) {
		this.building_mapid = building_mapid;
	}
	public String getSurverbasic_id() {
		return surverbasic_id;
	}
	public void setSurverbasic_id(String surverbasic_id) {
		this.surverbasic_id = surverbasic_id;
	}
	public String getSurverbasic_name() {
		return surverbasic_name;
	}
	public void setSurverbasic_name(String surverbasic_name) {
		this.surverbasic_name = surverbasic_name;
	}
	public String getEntrust_unit() {
		return entrust_unit;
	}
	public void setEntrust_unit(String entrust_unit) {
		this.entrust_unit = entrust_unit;
	}
	public String getLinkman_tel() {
		return linkman_tel;
	}
	public void setLinkman_tel(String linkman_tel) {
		this.linkman_tel = linkman_tel;
	}
	public String getSurverbasic_address() {
		return surverbasic_address;
	}
	public void setSurverbasic_address(String surverbasic_address) {
		this.surverbasic_address = surverbasic_address;
	}
	public String getCity_district() {
		return city_district;
	}
	public void setCity_district(String city_district) {
		this.city_district = city_district;
	}
	public String getSurverarea_value() {
		return surverarea_value;
	}
	public void setSurverarea_value(String surverarea_value) {
		this.surverarea_value = surverarea_value;
	}
	public  byte[] getBasicproduct_file() {
		return basicproduct_file;
	}
	public void setBasicproduct_file( byte[] basicproduct_file) {
		this.basicproduct_file = basicproduct_file;
	}
	public  byte[] getBasicsddfile_file() {
		return basicsddfile_file;
	}
	public void setBasicsddfile_file( byte[] basicsddfile_file) {
		this.basicsddfile_file = basicsddfile_file;
	}
	public String getSurverbasic_desc() {
		return surverbasic_desc;
	}
	public void setSurverbasic_desc(String surverbasic_desc) {
		this.surverbasic_desc = surverbasic_desc;
	}
	public String getBasicproduct_filename() {
		return basicproduct_filename;
	}
	public void setBasicproduct_filename(String basicproduct_filename) {
		this.basicproduct_filename = basicproduct_filename;
	}
	public byte[] getProjectfile_fileblob() {
		return projectfile_fileblob;
	}
	public void setProjectfile_fileblob(byte[] projectfile_fileblob) {
		this.projectfile_fileblob = projectfile_fileblob;
	}
	public String getProjectfile_filename() {
		return projectfile_filename;
	}
	public void setProjectfile_filename(String projectfile_filename) {
		this.projectfile_filename = projectfile_filename;
	}
	
	

}
