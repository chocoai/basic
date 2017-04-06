package com.originsys.realtygis.domain;

import java.sql.Date;
import java.util.List;

public class Building {
private  String building_id;//幢号内码
private  String surverproject_id;//项目测绘流程内码
private  String unit;//施测单位
private  String surver;//测绘比例
private  Integer    use_desgin;//设计用途
private  Integer    real_type;//房屋产别
private  Double tn_area;//总套内建筑面积
private  Double tn_areamin;//最小总套内建筑面积
private  Double tn_areamax;//最大总套内建筑面积
private  Double ft_area;//总分摊共用面积
private  Double ft_areamin;//最小总分摊共用面积
private  Double ft_areamax;//最大总分摊共用面积
private  Double build_area;//总建筑面积
private  Double build_areamin;//最小总建筑面积
private  Double build_areamax;//最大总建筑面积
private  String noft_area;//总不分摊面积
private  String no_area;//总不计面积
private  String discrepant_area;//面积校核差值
private  Date sruver_date;//测绘日期
private  Date surver_enddate;//结束日期
private  Date   surver_enddatemin;//最早测绘结束日期
private  Date   surver_enddatemax;//最晚测绘结束日期
private  String building_number;//幢号
private  Integer    build_struct;//结构
private  String graphics_code;//幢编号
private  String graphics_number;//丘地号（丘号）
private  Date input_date;//入库时间
private  Date input_datemin;//最早入库时间
private  Date input_datemax;//最晚入库时间
private  String floorup_count;//地上层数
private  String floordown_count;//地下层数
private  Integer    city_district;//行政区划
private  String building_mapid;//所在楼盘内码	
private  String building_address;//幢坐落
private  Double building_date;//建成时间 
private  Double building_datestart;//最早建成时间
private  Double building_dateend;//最晚建成时间
private  Integer  floor_count;//层数 
private  Integer floor_countmin;//最小层数
private  Integer floor_countmax;//最大层数
private  String  house_count;//套数
private  Integer    surver_type;//测绘类型
private  String entrust_unit;//委托单位
private  List  arrlist;//查询条件数组
private  String cx;//朝向
private  String dissent_state;//异议状态
private  String dtlx;//电梯类型
private  String dtsm;//电梯数目
private  String freeze_state;//冻结状态
private  String general_state;//普通状态
private  String guarantee_state;//住房保障
private  String jzjg;//建筑结构
private  String lg;//楼高
private  String ltlx;//楼梯类型
private  String ltsm;//楼梯数目
private  String mapping_state;//已测绘状态
private  String ownership_state;//所有权状态
private  String pgp_state;//平改坡
private  String pledge_state;//他项权状态
private  String sealup_state;//查封状态
private  Date updatedate;//修改日期
private String synch_type;//同步类型（新增：‘00’；修改：‘01’；删除：‘02’）
private int sid;//唯一编号

public Building(){
	this.building_id="";
	this.building_mapid="";
	this.surverproject_id="";
	this.unit="";
	this.surver="";
	this.use_desgin=0;
	this.real_type=0;
	this.tn_area=0.0;
	this.ft_area=0.0;
	this.build_area=0.0;
	this.noft_area="";
	this.no_area="";
	this.discrepant_area="";
	this.sruver_date=null;
	this.surver_enddate=null;
	this.building_number="";
	this.build_struct=0;
	this.graphics_code="";
	this.graphics_number="";
	//this.input_date="";
	this.floorup_count="";
	this.floordown_count="";
	this.city_district=0;
	this.building_address="";
	//this.building_date=0;
	//this.floor_count=null;
	this.house_count="";
	this.cx="";
	this.dissent_state="";
	this.dtlx="";
	this.dtsm="";
	this.freeze_state="";
	this.general_state="";
	this.guarantee_state="";
	this.jzjg="";
	this.lg="";
	this.ltlx="";
	this.ltsm="";
	this.mapping_state="";
	this.ownership_state="";
	this.pgp_state="";
	this.pledge_state="";
	this.sealup_state="";
	this.updatedate=null;
	this.input_date=null;
	this.input_datemax=null;
	this.input_datemin=null;
	this.sruver_date=null;
	this.surver_enddate=null;
	
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
public Integer getUse_desgin() {
	return use_desgin;
}
public void setUse_desgin(Integer use_desgin) {
	this.use_desgin = use_desgin;
}
public Integer getReal_type() {
	return real_type;
}
public void setReal_type(Integer real_type) {
	this.real_type = real_type;
}
public Double getTn_area() {
	return tn_area;
}
public void setTn_area(Double tn_area) {
	this.tn_area = tn_area;
}
public Double getFt_area() {
	return ft_area;
}
public void setFt_area(Double ft_area) {
	this.ft_area = ft_area;
}
public Double getBuild_area() {
	return build_area;
}
public void setBuild_area(Double build_area) {
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
public Date getSruver_date() {
	return sruver_date;
}
public void setSruver_date(Date sruver_date) {
	this.sruver_date = sruver_date;
}
public Date getSurver_enddate() {
	return surver_enddate;
}
public void setSurver_enddate(Date surver_enddate) {
	this.surver_enddate = surver_enddate;
}
public String getBuilding_number() {
	return building_number;
}
public void setBuilding_number(String building_number) {
	this.building_number = building_number;
}
public Integer getBuild_struct() {
	return build_struct;
}
public void setBuild_struct(Integer build_struct) {
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
public Date getInput_date() {
	return input_date;
}
public void setInput_date(Date input_date) {
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
public Integer getCity_district() {
	return city_district;
}
public void setCity_district(Integer city_district) {
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
public Double getBuilding_date() {
	return building_date;
}
public void setBuilding_date(Double building_date) {
	this.building_date = building_date;
}
public Integer getFloor_count() {
	return floor_count;
}
public void setFloor_count(Integer floor_count) {
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
public String getCx() {
	return cx;
}
public void setCx(String cx) {
	this.cx = cx;
}
public String getDissent_state() {
	return dissent_state;
}
public void setDissent_state(String dissent_state) {
	this.dissent_state = dissent_state;
}
public String getDtlx() {
	return dtlx;
}
public void setDtlx(String dtlx) {
	this.dtlx = dtlx;
}
public String getDtsm() {
	return dtsm;
}
public void setDtsm(String dtsm) {
	this.dtsm = dtsm;
}
public String getFreeze_state() {
	return freeze_state;
}
public void setFreeze_state(String freeze_state) {
	this.freeze_state = freeze_state;
}
public String getGeneral_state() {
	return general_state;
}
public void setGeneral_state(String general_state) {
	this.general_state = general_state;
}
public String getGuarantee_state() {
	return guarantee_state;
}
public void setGuarantee_state(String guarantee_state) {
	this.guarantee_state = guarantee_state;
}
public String getJzjg() {
	return jzjg;
}
public void setJzjg(String jzjg) {
	this.jzjg = jzjg;
}
public String getLg() {
	return lg;
}
public void setLg(String lg) {
	this.lg = lg;
}
public String getLtlx() {
	return ltlx;
}
public void setLtlx(String ltlx) {
	this.ltlx = ltlx;
}
public String getLtsm() {
	return ltsm;
}
public void setLtsm(String ltsm) {
	this.ltsm = ltsm;
}
public String getMapping_state() {
	return mapping_state;
}
public void setMapping_state(String mapping_state) {
	this.mapping_state = mapping_state;
}
public String getOwnership_state() {
	return ownership_state;
}
public void setOwnership_state(String ownership_state) {
	this.ownership_state = ownership_state;
}
public String getPgp_state() {
	return pgp_state;
}
public void setPgp_state(String pgp_state) {
	this.pgp_state = pgp_state;
}
public String getPledge_state() {
	return pledge_state;
}
public void setPledge_state(String pledge_state) {
	this.pledge_state = pledge_state;
}
public String getSealup_state() {
	return sealup_state;
}
public void setSealup_state(String sealup_state) {
	this.sealup_state = sealup_state;
}
public Date getUpdatedate() {
	return updatedate;
}
public void setUpdatedate(Date updatedate) {
	this.updatedate = updatedate;
}
public Double getBuilding_datestart() {
	return building_datestart;
}
public void setBuilding_datestart(Double building_datestart) {
	this.building_datestart = building_datestart;
}
public Double getBuilding_dateend() {
	return building_dateend;
}
public void setBuilding_dateend(Double building_dateend) {
	this.building_dateend = building_dateend;
}
public Integer getSurver_type() {
	return surver_type;
}
public void setSurver_type(Integer surver_type) {
	this.surver_type = surver_type;
}
public String getEntrust_unit() {
	return entrust_unit;
}
public void setEntrust_unit(String entrust_unit) {
	this.entrust_unit = entrust_unit;
}
public Double getTn_areamin() {
	return tn_areamin;
}
public void setTn_areamin(Double tn_areamin) {
	this.tn_areamin = tn_areamin;
}
public Double getTn_areamax() {
	return tn_areamax;
}
public void setTn_areamax(Double tn_areamax) {
	this.tn_areamax = tn_areamax;
}
public Double getFt_areamin() {
	return ft_areamin;
}
public void setFt_areamin(Double ft_areamin) {
	this.ft_areamin = ft_areamin;
}
public Double getFt_areamax() {
	return ft_areamax;
}
public void setFt_areamax(Double ft_areamax) {
	this.ft_areamax = ft_areamax;
}
public Double getBuild_areamin() {
	return build_areamin;
}
public void setBuild_areamin(Double build_areamin) {
	this.build_areamin = build_areamin;
}
public Double getBuild_areamax() {
	return build_areamax;
}
public void setBuild_areamax(Double build_areamax) {
	this.build_areamax = build_areamax;
}
public Integer getFloor_countmin() {
	return floor_countmin;
}
public void setFloor_countmin(Integer floor_countmin) {
	this.floor_countmin = floor_countmin;
}
public Integer getFloor_countmax() {
	return floor_countmax;
}
public void setFloor_countmax(Integer floor_countmax) {
	this.floor_countmax = floor_countmax;
}
public Date getInput_datemin() {
	return input_datemin;
}
public void setInput_datemin(Date input_datemin) {
	this.input_datemin = input_datemin;
}
public Date getInput_datemax() {
	return input_datemax;
}
public void setInput_datemax(Date input_datemax) {
	this.input_datemax = input_datemax;
}
public Date getSurver_enddatemin() {
	return surver_enddatemin;
}
public void setSurver_enddatemin(Date surver_enddatemin) {
	this.surver_enddatemin = surver_enddatemin;
}
public Date getSurver_enddatemax() {
	return surver_enddatemax;
}
public void setSurver_enddatemax(Date surver_enddatemax) {
	this.surver_enddatemax = surver_enddatemax;
}
public String getSynch_type() {
	return synch_type;
}
public void setSynch_type(String synch_type) {
	this.synch_type = synch_type;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}




}
