package com.originsys.auth.domain;
import java.io.Serializable;

import com.originsys.eap.domain.EapDomain;

public class OrgcomType extends EapDomain{
	/**企业类型id*/
	private String organ_type_id;
	/**企业类型名*/
	private String organ_type_name;
	/**站点id*/
	private String site_id;
	/**企业类型名称*/
	private String organ_type_cname;
	/**企业类型状态*/
	private String organ_type_state;
	//----------------------------------------------------------------
	
	/**设置企业类型id的get方法*/
	public String getOrgan_type_id() {
		return organ_type_id;
	}
	public String getOrgan_type_state() {
		return organ_type_state;
	}
	public void setOrgan_type_state(String organ_type_state) {
		this.organ_type_state = organ_type_state;
	}
	/**设置企业类型id的set方法*/
	public void setOrgan_type_id(String organ_type_id) {
		this.organ_type_id = organ_type_id;
	}
	/**设置企业类型名的get方法*/
	public String getOrgan_type_name() {
		return organ_type_name;
	}
	/**设置企业类型名的set方法*/
	public void setOrgan_type_name(String organ_type_name) {
		this.organ_type_name = organ_type_name;
	}
	/**设置站点id的get方法*/
	public String getSite_id() {
		return site_id;
	}
	/**设置站点id的set方法*/
	public void setSite_id(String site_id) {
		this.site_id = site_id;
	}
	/**设置企业类型名称的get方法*/
	public String getOrgan_type_cname() {
		return organ_type_cname;
	}
	/**设置企业类型名称的set方法*/
	public void setOrgan_type_cname(String organ_type_cname) {
		this.organ_type_cname = organ_type_cname;
	}
}