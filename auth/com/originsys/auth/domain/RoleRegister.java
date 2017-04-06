package com.originsys.auth.domain;
import java.io.Serializable;

import com.originsys.eap.domain.EapDomain;

public class RoleRegister extends EapDomain{
	/**角色注册id*/
	private String role_register_id;
	/**角色id*/
	private String role_id;
	/**站点*/
	private String site_id;
	/**角色名*/
	private String role_name;
	/**备注*/
	private String role_description;
	/**需审核*/
	private String ischeck;
	/**前置角色*/
	private String preposition_role;
	/**审核地址*/
	private String check_url;
	//----------------------------------------------------------------
	/**设置角色注册id的get方法*/
	public String getRole_register_id() {
		return role_register_id;
	}
	/**设置角色注册id的set方法*/
	public void setRole_register_id(String role_register_id) {
		this.role_register_id = role_register_id;
	}
	/**设置角色id的get方法*/
	public String getRole_id() {
		return role_id;
	}
	/**设置角色id的set方法*/
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	/**设置站点的get方法*/
	public String getSite_id() {
		return site_id;
	}
	/**设置站点的set方法*/
	public void setSite_id(String site_id) {
		this.site_id = site_id;
	}
	/**设置角色名的get方法*/
	public String getRole_name() {
		return role_name;
	}
	/**设置角色名的set方法*/
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	/**设置备注的get方法*/
	public String getRole_description() {
		return role_description;
	}
	/**设置备注的set方法*/
	public void setRole_description(String role_description) {
		this.role_description = role_description;
	}
	/**设置需审核的get方法*/
	public String getIscheck() {
		return ischeck;
	}
	/**设置需审核的set方法*/
	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}
	/**设置前置角色的get方法*/
	public String getPreposition_role() {
		return preposition_role;
	}
	/**设置前置角色的set方法*/
	public void setPreposition_role(String preposition_role) {
		this.preposition_role = preposition_role;
	}
	/**设置审核地址的get方法*/
	public String getCheck_url() {
		return check_url;
	}
	/**设置审核地址的set方法*/
	public void setCheck_url(String check_url) {
		this.check_url = check_url;
	}
}