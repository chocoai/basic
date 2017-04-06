package com.originsys.safemanage.domain;
import java.io.Serializable;

public class TBuildingProject implements Serializable{
	/**管理项目编号*/
	private String project_id;
	/**管理项目名称*/
	private String project_name;
	/**管理项目地址*/
	private String project_address;
	/**所属区域*/
	private String city_district;
	/**备注*/
	private String project_desc;
	/**包含楼幢*/
	private String project_buildingids;
	/**责任单位编号*/
	private String unit_id;
	/**信息状态0未审核;1审核通过;2审核驳回*/
	private String review_state;
	/**安全责任单位名称*/
	private String unit_name;
	//----------------------------------------------------------------
	
	/**设置管理项目编号的get方法*/
	public String getProject_id() {
		return project_id;
	}
	public String getUnit_name() {
		return unit_name;
	}
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
	/**设置管理项目编号的set方法*/
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	/**设置管理项目名称的get方法*/
	public String getProject_name() {
		return project_name;
	}
	/**设置管理项目名称的set方法*/
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	/**设置管理项目地址的get方法*/
	public String getProject_address() {
		return project_address;
	}
	/**设置管理项目地址的set方法*/
	public void setProject_address(String project_address) {
		this.project_address = project_address;
	}
	/**设置所属区域的get方法*/
	public String getCity_district() {
		return city_district;
	}
	/**设置所属区域的set方法*/
	public void setCity_district(String city_district) {
		this.city_district = city_district;
	}
	/**设置备注的get方法*/
	public String getProject_desc() {
		return project_desc;
	}
	/**设置备注的set方法*/
	public void setProject_desc(String project_desc) {
		this.project_desc = project_desc;
	}
	/**设置包含楼幢的get方法*/
	public String getProject_buildingids() {
		return project_buildingids;
	}
	/**设置包含楼幢的set方法*/
	public void setProject_buildingids(String project_buildingids) {
		this.project_buildingids = project_buildingids;
	}
	/**设置责任单位编号的get方法*/
	public String getUnit_id() {
		return unit_id;
	}
	/**设置责任单位编号的set方法*/
	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}
	/**设置信息状态0未审核;1审核通过;2审核驳回的get方法*/
	public String getReview_state() {
		return review_state;
	}
	/**设置信息状态0未审核;1审核通过;2审核驳回的set方法*/
	public void setReview_state(String review_state) {
		this.review_state = review_state;
	}
}