package com.originsys.realtygis.domain;

/**
 auth:boy 2014-3-6
   描述：基础测绘和项目测绘关联表
 */
public class RT_prolinkbase {
	/**项目测绘编号*/
	private int surverproject_id;
	/**基础测绘编号*/
	private int surverbasic_id;
	public int getSurverproject_id() {
		return surverproject_id;
	}
	public void setSurverproject_id(int surverproject_id) {
		this.surverproject_id = surverproject_id;
	}
	public int getSurverbasic_id() {
		return surverbasic_id;
	}
	public void setSurverbasic_id(int surverbasic_id) {
		this.surverbasic_id = surverbasic_id;
	}
	
}
