package com.originsys.safemanage.domain;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.originsys.eap.domain.EapDomain;
/**突发事件预警信息*/
public class DisasterWarn extends EapDomain{
	/**突发事件id*/
	private String disaster_id;
	/**灾害简称*/
	private String disaster_name;
	/**灾害描述*/
	private String disaster_discription;
	/**行政区划*/
	private String disaster_region;
	/**灾害类型@1-火灾&2-泥石流&3-地震&4-洪水*/
	private String disaster_type;
	/**灾害级别@1-一般&2-较大&3-重大&4-特别重大*/
	private String disaster_grade;
	/**灾害发生时间*/
	private Date disaster_date;
	/**录入时间*/
	private Date add_time;
	/**预警状态@0-未审核&1-审核通过&2-审核驳回&3-已取消*/
	private String info_state;
	/**x坐标*/
	private BigDecimal smx;
	/**y坐标*/
	private BigDecimal smy;
	/**地理关联码*/
	private String smuserid;
	/**审核意见*/
	private String check_log;
	//----------------------------------------------------------------
	
	public String getDisaster_id() {
		return disaster_id;
	}
	public void setDisaster_id(String disaster_id) {
		this.disaster_id = disaster_id;
	}
	public String getDisaster_name() {
		return disaster_name;
	}
	public void setDisaster_name(String disaster_name) {
		this.disaster_name = disaster_name;
	}
	public String getDisaster_discription() {
		return disaster_discription;
	}
	public void setDisaster_discription(String disaster_discription) {
		this.disaster_discription = disaster_discription;
	}
	public String getDisaster_region() {
		return disaster_region;
	}
	public void setDisaster_region(String disaster_region) {
		this.disaster_region = disaster_region;
	}
	public String getDisaster_type() {
		return disaster_type;
	}
	public void setDisaster_type(String disaster_type) {
		this.disaster_type = disaster_type;
	}
	public String getDisaster_grade() {
		return disaster_grade;
	}
	public void setDisaster_grade(String disaster_grade) {
		this.disaster_grade = disaster_grade;
	}
	public Date getDisaster_date() {
		return disaster_date;
	}
	public void setDisaster_date(Date disaster_date) {
		this.disaster_date = disaster_date;
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
	public BigDecimal getSmx() {
		return smx;
	}
	public void setSmx(BigDecimal smx) {
		this.smx = smx;
	}
	public BigDecimal getSmy() {
		return smy;
	}
	public void setSmy(BigDecimal smy) {
		this.smy = smy;
	}
	public String getSmuserid() {
		return smuserid;
	}
	public void setSmuserid(String smuserid) {
		this.smuserid = smuserid;
	}
	public String getCheck_log() {
		return check_log;
	}
	public void setCheck_log(String check_log) {
		this.check_log = check_log;
	}
	
}