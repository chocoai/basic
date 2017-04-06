package com.originsys.auth.domain;
import java.util.Date;

import com.originsys.eap.domain.EapDomain;

@SuppressWarnings("serial")
public class OrgcomMember  extends EapDomain{
	/**用户id*/
	private String mem_id;
	/**企业id*/
	private String organ_id;
	/**入职时间*/
	private Date join_in_time;
	/**备注*/
	private String note;
	/**状态*/
	private String state;
	/**是否管理员*/
	private String is_manager;
	/**企业名称*/
	private String organ_name;
	/**企业所属行政区*/
	private String organ_region;
	//----------------------------------------------------------------
	
	/**设置用户id的get方法*/
	public String getMem_id() {
		return mem_id;
	}
	public String getOrgan_name() {
		return organ_name;
	}
	public void setOrgan_name(String organ_name) {
		this.organ_name = organ_name;
	}
	/**设置用户id的set方法*/
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	/**设置企业id的get方法*/
	public String getOrgan_id() {
		return organ_id;
	}
	/**设置企业id的set方法*/
	public void setOrgan_id(String organ_id) {
		this.organ_id = organ_id;
	}
	/**设置入职时间的get方法*/
	public Date getJoin_in_time() {
		return join_in_time;
	}
	/**设置入职时间的set方法*/
	public void setJoin_in_time(Date join_in_time) {
		this.join_in_time = join_in_time;
	}
	/**设置备注的get方法*/
	public String getNote() {
		return note;
	}
	/**设置备注的set方法*/
	public void setNote(String note) {
		this.note = note;
	}
	/**设置状态的get方法*/
	public String getState() {
		return state;
	}
	/**设置状态的set方法*/
	public void setState(String state) {
		this.state = state;
	}
	/**设置是否管理员的get方法*/
	public String getIs_manager() {
		return is_manager;
	}
	/**设置是否管理员的set方法*/
	public void setIs_manager(String is_manager) {
		this.is_manager = is_manager;
	}
	public String getOrgan_region() {
		return organ_region;
	}
	public void setOrgan_region(String organ_region) {
		this.organ_region = organ_region;
	}
	
}