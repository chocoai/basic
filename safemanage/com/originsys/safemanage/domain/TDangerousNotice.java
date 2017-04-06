package com.originsys.safemanage.domain;
import java.io.Serializable;
import java.util.Date;

public class TDangerousNotice implements Serializable{
	/**信息编号*/
	private String info_id;
	/**楼幢编号*/
	private String building_id;
	/**鉴定编号*/
	private String jdinfo_id;
	/**通知时间*/
	private Date notice_date;
	/**通知内容*/
	private String notice_content;
	/**发送人-不记录id了，直接记录姓名的中文吧*/
	private String sender_mem_id;
	/**通知附件*/
	private String notice_file;
	/**通知标题*/
	private String notice_title;
	/**发送单位*/
	private String sender_department;
	//----------------------------------------------------------------
	
	/**设置信息编号的get方法*/
	public String getInfo_id() {
		return info_id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getSender_department() {
		return sender_department;
	}
	public void setSender_department(String sender_department) {
		this.sender_department = sender_department;
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
	/**设置鉴定编号的get方法*/
	public String getJdinfo_id() {
		return jdinfo_id;
	}
	/**设置鉴定编号的set方法*/
	public void setJdinfo_id(String jdinfo_id) {
		this.jdinfo_id = jdinfo_id;
	}
	/**设置通知时间的get方法*/
	public Date getNotice_date() {
		return notice_date;
	}
	/**设置通知时间的set方法*/
	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}
	/**设置通知内容的get方法*/
	public String getNotice_content() {
		return notice_content;
	}
	/**设置通知内容的set方法*/
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	/**设置发送人的get方法*/
	public String getSender_mem_id() {
		return sender_mem_id;
	}
	/**设置发送人的set方法*/
	public void setSender_mem_id(String sender_mem_id) {
		this.sender_mem_id = sender_mem_id;
	}
	/**设置通知附件的get方法*/
	public String getNotice_file() {
		return notice_file;
	}
	/**设置通知附件的set方法*/
	public void setNotice_file(String notice_file) {
		this.notice_file = notice_file;
	}
}