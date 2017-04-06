package com.originsys.safemanage.domain;
import java.io.Serializable;
import java.util.Date;

public class TDangerousLog implements Serializable{
	/**信息编号*/
	private String info_id;
	/**楼幢编号*/
	private String building_id;
	/**处置内容*/
	private String op_content;
	/**处置日期*/
	private Date op_date;
	/**楼幢状态*/
	private String building_state;
	//----------------------------------------------------------------
	/**设置信息编号的get方法*/
	public String getInfo_id() {
		return info_id;
	}
	/**设置信息编号的set方法*/
	public void setInfo_id(String info_id) {
		this.info_id = info_id;
	}
	/**设置楼幢编号的get方法*/
	public String getBuilding_id() {
		return building_id;
	}
	/**设置楼幢编号的set方法*/
	public void setBuilding_id(String building_id) {
		this.building_id = building_id;
	}
	/**设置处置内容的get方法*/
	public String getOp_content() {
		return op_content;
	}
	/**设置处置内容的set方法*/
	public void setOp_content(String op_content) {
		this.op_content = op_content;
	}
	/**设置处置日期的get方法*/
	public Date getOp_date() {
		return op_date;
	}
	/**设置处置日期的set方法*/
	public void setOp_date(Date op_date) {
		this.op_date = op_date;
	}
	/**设置楼幢状态的get方法*/
	public String getBuilding_state() {
		return building_state;
	}
	/**设置楼幢状态的set方法*/
	public void setBuilding_state(String building_state) {
		this.building_state = building_state;
	}
}