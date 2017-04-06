package com.originsys.safemanage.domain;
import java.io.Serializable;
import java.util.Date;

public class TAppraisalTask implements Serializable{
	/**鉴定任务编号主键*/
	private String jdtask_id;
	/**楼幢编号*/
	private String building_id;
	/**楼幢地址*/
	private String building_address;
	/**新楼幢地址*/
	private String building_newaddress;
	/**所属区域*/
	private String building_region;
	/**经营管理单位*/
	private String management_unit;
	/**产权单位*/
	private String owner;
	/**建成时间*/
	private Integer building_date;
	/**数据来源*/
	private String data_origin;
	/**安全状况@1-a级&2-b级&3-c级&4-d级*/
	private String safe_grade;
	/**经办人/委托人*/
	private String agent;
	/**新增时间*/
	private Date add_time;
	/**信息状态0暂存1待审核2审核驳回8审核通过 9是已受理的，不再显示*/
	private String info_state;
	
	//----------------------------------------------------------------
	
	public String getJdtask_id() {
		return jdtask_id;
	}
	public void setJdtask_id(String jdtask_id) {
		this.jdtask_id = jdtask_id;
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
	public String getBuilding_newaddress() {
		return building_newaddress;
	}
	public void setBuilding_newaddress(String building_newaddress) {
		this.building_newaddress = building_newaddress;
	}
	public String getBuilding_region() {
		return building_region;
	}
	public void setBuilding_region(String building_region) {
		this.building_region = building_region;
	}
	public String getManagement_unit() {
		return management_unit;
	}
	public void setManagement_unit(String management_unit) {
		this.management_unit = management_unit;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public Integer getBuilding_date() {
		return building_date;
	}
	public void setBuilding_date(Integer building_date) {
		this.building_date = building_date;
	}
	public String getData_origin() {
		return data_origin;
	}
	public void setData_origin(String data_origin) {
		this.data_origin = data_origin;
	}
	public String getSafe_grade() {
		return safe_grade;
	}
	public void setSafe_grade(String safe_grade) {
		this.safe_grade = safe_grade;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public String getInfo_state() {
		return info_state;
	}
	public void setInfo_state(String info_state) {
		this.info_state = info_state;
	}
	
}