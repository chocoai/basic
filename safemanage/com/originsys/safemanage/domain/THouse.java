package com.originsys.safemanage.domain;
import java.io.Serializable;

public class THouse implements Serializable{
	/**房屋编号*/
	private String house_id;
	/**楼幢编号*/
	private Integer building_id;
	/**房屋坐落*/
	private String fw_address;
	/**所属区域*/
	private String builiding_region;
	/**所属层数*/
	private Integer lay_num;
	/**房屋开始层*/
	private Integer floor_start;
	/**房屋结束层*/
	private Integer floor_end;
	/**单元号*/
	private String unit_number;
	/**单元别名*/
	private String unit_alias;
	/**房号*/
	private String room_number;
	/**房屋别名*/
	private String room_alias;
	/**结构*/
	private String struct;
	/**建筑面积*/
	private Float jz_area;
	/**套内建筑面积*/
	private Float tnjz_area;
	/**实际用途*/
	private String fact_yt;
	/**建成时间*/
	private Integer birth_date;
	/**房屋产别*/
	private String fw_cb;
	/**房屋地号*/
	private String fw_dh;
	/**房屋权号*/
	private String right_num;
	/**户室类型*/
	private String door_type;
	/**所在楼盘内码*/
	private Integer building_mapid;
	/**健康等级-普查@1-a级&2-b级&3-c级&4-d级*/
	private String health_grade_pc;
	/**健康等级-鉴定@1-a级&2-b级&3-c级&4-d级*/
	private String health_grade_jd;
	/***/
	private String is_die;
	//----------------------------------------------------------------
	/**设置房屋编号的get方法*/
	public String getHouse_id() {
		return house_id;
	}
	/**设置房屋编号的set方法*/
	public void setHouse_id(String house_id) {
		this.house_id = house_id;
	}
	/**设置楼幢编号的get方法*/
	public Integer getBuilding_id() {
		return building_id;
	}
	/**设置楼幢编号的set方法*/
	public void setBuilding_id(Integer building_id) {
		this.building_id = building_id;
	}
	/**设置房屋坐落的get方法*/
	public String getFw_address() {
		return fw_address;
	}
	/**设置房屋坐落的set方法*/
	public void setFw_address(String fw_address) {
		this.fw_address = fw_address;
	}
	/**设置所属区域的get方法*/
	public String getBuiliding_region() {
		return builiding_region;
	}
	/**设置所属区域的set方法*/
	public void setBuiliding_region(String builiding_region) {
		this.builiding_region = builiding_region;
	}
	/**设置所属层数的get方法*/
	public Integer getLay_num() {
		return lay_num;
	}
	/**设置所属层数的set方法*/
	public void setLay_num(Integer lay_num) {
		this.lay_num = lay_num;
	}
	/**设置房屋开始层的get方法*/
	public Integer getFloor_start() {
		return floor_start;
	}
	/**设置房屋开始层的set方法*/
	public void setFloor_start(Integer floor_start) {
		this.floor_start = floor_start;
	}
	/**设置房屋结束层的get方法*/
	public Integer getFloor_end() {
		return floor_end;
	}
	/**设置房屋结束层的set方法*/
	public void setFloor_end(Integer floor_end) {
		this.floor_end = floor_end;
	}
	/**设置单元号的get方法*/
	public String getUnit_number() {
		return unit_number;
	}
	/**设置单元号的set方法*/
	public void setUnit_number(String unit_number) {
		this.unit_number = unit_number;
	}
	/**设置单元别名的get方法*/
	public String getUnit_alias() {
		return unit_alias;
	}
	/**设置单元别名的set方法*/
	public void setUnit_alias(String unit_alias) {
		this.unit_alias = unit_alias;
	}
	/**设置房号的get方法*/
	public String getRoom_number() {
		return room_number;
	}
	/**设置房号的set方法*/
	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}
	/**设置房屋别名的get方法*/
	public String getRoom_alias() {
		return room_alias;
	}
	/**设置房屋别名的set方法*/
	public void setRoom_alias(String room_alias) {
		this.room_alias = room_alias;
	}
	/**设置结构的get方法*/
	public String getStruct() {
		return struct;
	}
	/**设置结构的set方法*/
	public void setStruct(String struct) {
		this.struct = struct;
	}
	/**设置建筑面积的get方法*/
	public Float getJz_area() {
		return jz_area;
	}
	/**设置建筑面积的set方法*/
	public void setJz_area(Float jz_area) {
		this.jz_area = jz_area;
	}
	/**设置套内建筑面积的get方法*/
	public Float getTnjz_area() {
		return tnjz_area;
	}
	/**设置套内建筑面积的set方法*/
	public void setTnjz_area(Float tnjz_area) {
		this.tnjz_area = tnjz_area;
	}
	/**设置实际用途的get方法*/
	public String getFact_yt() {
		return fact_yt;
	}
	/**设置实际用途的set方法*/
	public void setFact_yt(String fact_yt) {
		this.fact_yt = fact_yt;
	}
	/**设置建成时间的get方法*/
	public Integer getBirth_date() {
		return birth_date;
	}
	/**设置建成时间的set方法*/
	public void setBirth_date(Integer birth_date) {
		this.birth_date = birth_date;
	}
	/**设置房屋产别的get方法*/
	public String getFw_cb() {
		return fw_cb;
	}
	/**设置房屋产别的set方法*/
	public void setFw_cb(String fw_cb) {
		this.fw_cb = fw_cb;
	}
	/**设置房屋地号的get方法*/
	public String getFw_dh() {
		return fw_dh;
	}
	/**设置房屋地号的set方法*/
	public void setFw_dh(String fw_dh) {
		this.fw_dh = fw_dh;
	}
	/**设置房屋权号的get方法*/
	public String getRight_num() {
		return right_num;
	}
	/**设置房屋权号的set方法*/
	public void setRight_num(String right_num) {
		this.right_num = right_num;
	}
	/**设置户室类型的get方法*/
	public String getDoor_type() {
		return door_type;
	}
	/**设置户室类型的set方法*/
	public void setDoor_type(String door_type) {
		this.door_type = door_type;
	}
	/**设置所在楼盘内码的get方法*/
	public Integer getBuilding_mapid() {
		return building_mapid;
	}
	/**设置所在楼盘内码的set方法*/
	public void setBuilding_mapid(Integer building_mapid) {
		this.building_mapid = building_mapid;
	}
	/**设置健康等级-普查@1-a级&2-b级&3-c级&4-d级的get方法*/
	public String getHealth_grade_pc() {
		return health_grade_pc;
	}
	/**设置健康等级-普查@1-a级&2-b级&3-c级&4-d级的set方法*/
	public void setHealth_grade_pc(String health_grade_pc) {
		this.health_grade_pc = health_grade_pc;
	}
	/**设置健康等级-鉴定@1-a级&2-b级&3-c级&4-d级的get方法*/
	public String getHealth_grade_jd() {
		return health_grade_jd;
	}
	/**设置健康等级-鉴定@1-a级&2-b级&3-c级&4-d级的set方法*/
	public void setHealth_grade_jd(String health_grade_jd) {
		this.health_grade_jd = health_grade_jd;
	}
	/**设置的get方法*/
	public String getIs_die() {
		return is_die;
	}
	/**设置的set方法*/
	public void setIs_die(String is_die) {
		this.is_die = is_die;
	}
}