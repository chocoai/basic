package com.originsys.safemanage.domain;

import java.io.Serializable;

import com.originsys.eap.domain.User;

/**
 auth:boy 2014-5-13
   描述：安全管理员属性对象
 */
public class TSafeManager extends User implements Serializable{
	/**用户id*/
	private String mem_id;
	/**所属地区*/
	private String region;
	
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
}
