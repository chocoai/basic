package com.originsys.auth.domain;
import java.io.Serializable;

import com.originsys.eap.domain.EapDomain;

public class UserRole  extends EapDomain{
	/**角色id*/
	private String roleid;
	/**站点*/
	private String site_id;
	/**用户id*/
	private String mem_id;
	/**用户状态*/
	private String mem_state;
	/**该角色所属的企业*/
	private String com_id;
	/**角色注册id*/
	private String role_register_id;
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
	/**设置用户id的get方法*/
	public String getMem_id() {
		return mem_id;
	}
	/**设置用户id的set方法*/
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	/**设置用户状态的get方法*/
	public String getMem_state() {
		return mem_state;
	}
	/**设置用户状态的set方法*/
	public void setMem_state(String mem_state) {
		this.mem_state = mem_state;
	}
	/**设置该角色所属的企业的get方法*/
	public String getCom_id() {
		return com_id;
	}
	/**设置该角色所属的企业的set方法*/
	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}
	/**设置角色注册id的get方法*/
	public String getRole_register_id() {
		return role_register_id;
	}
	/**设置角色注册id的set方法*/
	public void setRole_register_id(String role_register_id) {
		this.role_register_id = role_register_id;
	}
}