package com.originsys.realtygis.domain;

import java.util.Date;

public class MapVersion {
    private long version_number;//地图版本号
    private String version_name;//地图版本名称
    private String auditor;//审核人
    private String publisher;//发布人
    private String status;//状态
    private String _internal_state;//全局状态
    private int    RNUM;//行号
    private int    default_map;//默认地图
    private String message;//备注
    private Date add_date;//地图版本新增时间
    public MapVersion(){
    	this.version_number=0;
    	this.version_name="";
    	this.auditor="";
    	this.publisher="";
    	this.status="";
    	this._internal_state="";
    	this.RNUM=0;
    	this.default_map=0;
    	
    }
	public long getVersion_number() {
		return version_number;
	}
	public void setVersion_number(long version_number) {
		this.version_number = version_number;
	}
	public String getVersion_name() {
		return version_name;
	}
	public void setVersion_name(String version_name) {
		this.version_name = version_name;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String get_internal_state() {
		return _internal_state;
	}
	public void set_internal_state(String _internal_state) {
		this._internal_state = _internal_state;
	}
	public int getRownum() {
		return RNUM;
	}
	public void setRownum(int rNUM) {
		RNUM = rNUM;
	}
	public int getDefault_map() {
		return default_map;
	}
	public void setDefault_map(int default_map) {
		this.default_map = default_map;
	}
	public int getRNUM() {
		return RNUM;
	}
	public void setRNUM(int rNUM) {
		RNUM = rNUM;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}
    
}
