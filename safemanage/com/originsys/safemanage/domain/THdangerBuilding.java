package com.originsys.safemanage.domain;
import java.io.Serializable;
import java.util.Date;
/**隐患房屋上报对象*/
public class THdangerBuilding implements Serializable{
	/**信息编号*/
	private String info_id;
	/**楼幢坐落*/
	private String building_address;
	/**所属区域*/
	private String building_region;
	/**户数*/
	private Integer house_count;
	/**层数*/
	private Integer floor_count;
	/**隐患说明*/
	private String dangerous_desc;
	/**附件*/
	private String annex_file;
	/**图片*/
	private String annex_image;
	/**联系人*/
	private String link_man;
	/**联系方式*/
	private String link_tel;
	/**录入时间*/
	private Date entry_time;
	/***/
	private String info_state;
	/**受理意见*/
	private String accept_opinion;
	/**受理人中文名称*/
	private String acceptor;
	/**受理时间*/
	private Date accept_date;
	//----------------------------------------------------------------
	/**设置信息编号的get方法*/
	public String getInfo_id() {
		return info_id;
	}
	/**设置信息编号的set方法*/
	public void setInfo_id(String info_id) {
		this.info_id = info_id;
	}
	/**设置楼幢坐落的get方法*/
	public String getBuilding_address() {
		return building_address;
	}
	/**设置楼幢坐落的set方法*/
	public void setBuilding_address(String building_address) {
		this.building_address = building_address;
	}
	/**设置所属区域的get方法*/
	public String getBuilding_region() {
		return building_region;
	}
	/**设置所属区域的set方法*/
	public void setBuilding_region(String building_region) {
		this.building_region = building_region;
	}
	/**设置户数的get方法*/
	public Integer getHouse_count() {
		return house_count;
	}
	/**设置户数的set方法*/
	public void setHouse_count(Integer house_count) {
		this.house_count = house_count;
	}
	/**设置层数的get方法*/
	public Integer getFloor_count() {
		return floor_count;
	}
	/**设置层数的set方法*/
	public void setFloor_count(Integer floor_count) {
		this.floor_count = floor_count;
	}
	/**设置隐患说明的get方法*/
	public String getDangerous_desc() {
		return dangerous_desc;
	}
	/**设置隐患说明的set方法*/
	public void setDangerous_desc(String dangerous_desc) {
		this.dangerous_desc = dangerous_desc;
	}
	/**设置附件的get方法*/
	public String getAnnex_file() {
		return annex_file;
	}
	/**设置附件的set方法*/
	public void setAnnex_file(String annex_file) {
		this.annex_file = annex_file;
	}
	/**设置图片的get方法*/
	public String getAnnex_image() {
		return annex_image;
	}
	/**设置图片的set方法*/
	public void setAnnex_image(String annex_image) {
		this.annex_image = annex_image;
	}
	/**设置联系人的get方法*/
	public String getLink_man() {
		return link_man;
	}
	/**设置联系人的set方法*/
	public void setLink_man(String link_man) {
		this.link_man = link_man;
	}
	/**设置联系方式的get方法*/
	public String getLink_tel() {
		return link_tel;
	}
	/**设置联系方式的set方法*/
	public void setLink_tel(String link_tel) {
		this.link_tel = link_tel;
	}
	/**设置录入时间的get方法*/
	public Date getEntry_time() {
		return entry_time;
	}
	/**设置录入时间的set方法*/
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	/**设置的get方法*/
	public String getInfo_state() {
		return info_state;
	}
	/**设置的set方法*/
	public void setInfo_state(String info_state) {
		this.info_state = info_state;
	}
	/**设置受理意见的get方法*/
	public String getAccept_opinion() {
		return accept_opinion;
	}
	/**设置受理意见的set方法*/
	public void setAccept_opinion(String accept_opinion) {
		this.accept_opinion = accept_opinion;
	}
	/**设置受理人中文名称的get方法*/
	public String getAcceptor() {
		return acceptor;
	}
	/**设置受理人中文名称的set方法*/
	public void setAcceptor(String acceptor) {
		this.acceptor = acceptor;
	}
	/**设置受理时间的get方法*/
	public Date getAccept_date() {
		return accept_date;
	}
	/**设置受理时间的set方法*/
	public void setAccept_date(Date accept_date) {
		this.accept_date = accept_date;
	}
}