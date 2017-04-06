package com.originsys.auth.domain;
import java.io.Serializable;

import com.originsys.eap.domain.EapDomain;

public class OrgcomRole  extends EapDomain{
	/**角色id*/
	private String roleid;
	/**站点*/
	private String site_id;
	/**企业类型id*/
	private String organ_type_id;
	/**角色注册id*/
	private String role_register_id;
	/**状态*/
	private String role_organ_type_state;
	//----------------------------------------------------------------
	/**设置角色id的get方法*/
	public String getRoleid() {
		return roleid;
	}
	/**设置角色id的set方法*/
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	/**设置站点的get方法*/
	public String getSite_id() {
		return site_id;
	}
	/**设置站点的set方法*/
	public void setSite_id(String site_id) {
		this.site_id = site_id;
	}
	/**设置企业类型id的get方法*/
	public String getOrgan_type_id() {
		return organ_type_id;
	}
	/**设置企业类型id的set方法*/
	public void setOrgan_type_id(String organ_type_id) {
		this.organ_type_id = organ_type_id;
	}
	/**设置角色注册id的get方法*/
	public String getRole_register_id() {
		return role_register_id;
	}
	/**设置角色注册id的set方法*/
	public void setRole_register_id(String role_register_id) {
		this.role_register_id = role_register_id;
	}
	/**设置状态的get方法*/
	public String getRole_organ_type_state() {
		return role_organ_type_state;
	}
	/**设置状态的set方法*/
	public void setRole_organ_type_state(String role_organ_type_state) {
		this.role_organ_type_state = role_organ_type_state;
	}
}