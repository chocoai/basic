package com.originsys.access.domain;
import java.util.List;

public class Building {
private  String building_id;//幢号内码
private  String surverproject_id;//项目测绘流程内码
private  String unit;//施测单位
private  String surver;//测绘比例
private  String use_desgin;//设计用途
private  String real_type;//房屋产别
private  String tn_area;//总套内建筑面积
private  String ft_area;//总分摊共用面积
private  String build_area;//总建筑面积
private  String noft_area;//总不分摊面积
private  String no_area;//总不计面积
private  String discrepant_area;//面积校核差值
private  String sruver_date;//测绘日期
private  String surver_enddate;//结束日期
private  String building_number;//幢号
private  String build_struct;//结构
private  String graphics_code;//幢编号
private  String graphics_number;//丘地号（丘号）
private  String input_date;//入库时间
private  String floorup_count;//地上层数
private  String floordown_count;//地下层数
private  String city_district;//
private  String building_mapid;//所在楼盘内码	
private  String building_address;//幢坐落
private  String building_date;//建成时间 
private  String  floor_count;//层数 
private  String  house_count;//套数
private  List  arrlist;//查询条件数组
public Building(){
	this.building_id="";
	this.building_mapid="";
	this.surverproject_id="";
	this.unit="";
	this.surver="";
	this.use_desgin="";
	this.real_type="";
	this.tn_area="";
	this.ft_area="";
	this.build_area="";
	this.noft_area="";
	this.no_area="";
	this.discrepant_area="";
	this.sruver_date="";
	this.surver_enddate="";
	this.building_number="";
	this.build_struct="";
	this.graphics_code="";
	this.graphics_number="";
	this.input_date="";
	this.floorup_count="";
	this.floordown_count="";
	this.city_district="";
	this.building_address="";
	this.building_date="";
	this.floor_count="";
	this.house_count="";
	
}
public String getBuilding_id() {
	return building_id;
}
public void setBuilding_id(String building_id) {
	this.building_id = building_id;
}
public String getSurverproject_id() {
	return surverproject_id;
}
public void setSurverproject_id(String surverproject_id) {
	this.surverproject_id = surverproject_id;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
public String getSurver() {
	return surver;
}
public void setSurver(String surver) {
	this.surver = surver;
}
public String getUse_desgin() {
	return use_desgin;
}
public void setUse_desgin(String use_desgin) {
	this.use_desgin = use_desgin;
}
public String getReal_type() {
	return real_type;
}
public void setReal_type(String real_type) {
	this.real_type = real_type;
}
public String getTn_area() {
	return tn_area;
}
public void setTn_area(String tn_area) {
	this.tn_area = tn_area;
}
public String getFt_area() {
	return ft_area;
}
public void setFt_area(String ft_area) {
	this.ft_area = ft_area;
}
public String getBuild_area() {
	return build_area;
}
public void setBuild_area(String build_area) {
	this.build_area = build_area;
}
public String getNoft_area() {
	return noft_area;
}
public void setNoft_area(String noft_area) {
	this.noft_area = noft_area;
}
public String getNo_area() {
	return no_area;
}
public void setNo_area(String no_area) {
	this.no_area = no_area;
}
public String getDiscrepant_area() {
	return discrepant_area;
}
public void setDiscrepant_area(String discrepant_area) {
	this.discrepant_area = discrepant_area;
}
public String getSruver_date() {
	return sruver_date;
}
public void setSruver_date(String sruver_date) {
	this.sruver_date = sruver_date;
}
public String getSurver_enddate() {
	return surver_enddate;
}
public void setSurver_enddate(String surver_enddate) {
	this.surver_enddate = surver_enddate;
}
public String getBuilding_number() {
	return building_number;
}
public void setBuilding_number(String building_number) {
	this.building_number = building_number;
}
public String getBuild_struct() {
	return build_struct;
}
public void setBuild_struct(String build_struct) {
	this.build_struct = build_struct;
}
public String getGraphics_code() {
	return graphics_code;
}
public void setGraphics_code(String graphics_code) {
	this.graphics_code = graphics_code;
}
public String getGraphics_number() {
	return graphics_number;
}
public void setGraphics_number(String graphics_number) {
	this.graphics_number = graphics_number;
}
public String getInput_date() {
	return input_date;
}
public void setInput_date(String input_date) {
	this.input_date = input_date;
}
public String getFloorup_count() {
	return floorup_count;
}
public void setFloorup_count(String floorup_count) {
	this.floorup_count = floorup_count;
}
public String getFloordown_count() {
	return floordown_count;
}
public void setFloordown_count(String floordown_count) {
	this.floordown_count = floordown_count;
}
public String getCity_district() {
	return city_district;
}
public void setCity_district(String city_district) {
	this.city_district = city_district;
}
public String getBuilding_mapid() {
	return building_mapid;
}
public void setBuilding_mapid(String building_mapid) {
	this.building_mapid = building_mapid;
}
public String getBuilding_address() {
	return building_address;
}
public void setBuilding_address(String building_address) {
	this.building_address = building_address;
}
public String getBuilding_date() {
	return building_date;
}
public void setBuilding_date(String building_date) {
	this.building_date = building_date;
}
public String getFloor_count() {
	return floor_count;
}
public void setFloor_count(String floor_count) {
	this.floor_count = floor_count;
}
public String getHouse_count() {
	return house_count;
}
public void setHouse_count(String house_count) {
	this.house_count = house_count;
}
public List getArrlist() {
	return arrlist;
}
public void setArrlist(List arrlist) {
	this.arrlist = arrlist;
}




}
