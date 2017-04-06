package com.originsys.realtygis.domain;

import java.sql.Date;

public class Invmhealthgrade {

	private  Integer invm_prj_id;//内码***
	private  Integer invm_health_grade_id;//健康内码***
	private  Integer structure_grade;//健康结构健康等级@1-A级-B级-C级-D级
	private  Integer used_grade;//健康使用健康等级@1-A级-B级-C级-D级
	private  Integer kz_grade;//健康抗震能力@1-强-弱-差
	private  Integer fl_grade;//健康防雷能力@1-强-弱-差
	private  Integer xf_grade;//健康消防能力@1-强-弱-差
	private  Integer other_grade;//健康其他防灾能力@1-强-弱-差
	private  Integer all_grade;//健康总健康等级@1-Ⅰ级（健康）-Ⅱ级（亚健康）-Ⅲ级（病态）-Ⅳ（病危）
	private  Integer health_savegrade;//健康安全等级@1-A级-B级-C级-D级
	private  Integer clresult;//健康处理意见@1-正常使用-常规维护-适当维修-采取措施-停止使用
	private  String health_gradetdesc;//健康备注
	private  String dcr;//健康调查人
	private  Date dcrq;//健康调查日期
	private  String fhr;//健康复核人
	private  Integer lose_grade;//健康完损等级@1-完好房屋-基本完好-一般破损-严重破损
	public Integer getInvm_prj_id() {
		return invm_prj_id;
	}
	public void setInvm_prj_id(Integer invm_prj_id) {
		this.invm_prj_id = invm_prj_id;
	}
	public Integer getInvm_health_grade_id() {
		return invm_health_grade_id;
	}
	public void setInvm_health_grade_id(Integer invm_health_grade_id) {
		this.invm_health_grade_id = invm_health_grade_id;
	}
	public Integer getStructure_grade() {
		return structure_grade;
	}
	public void setStructure_grade(Integer structure_grade) {
		this.structure_grade = structure_grade;
	}
	public Integer getUsed_grade() {
		return used_grade;
	}
	public void setUsed_grade(Integer used_grade) {
		this.used_grade = used_grade;
	}
	public Integer getKz_grade() {
		return kz_grade;
	}
	public void setKz_grade(Integer kz_grade) {
		this.kz_grade = kz_grade;
	}
	public Integer getFl_grade() {
		return fl_grade;
	}
	public void setFl_grade(Integer fl_grade) {
		this.fl_grade = fl_grade;
	}
	public Integer getXf_grade() {
		return xf_grade;
	}
	public void setXf_grade(Integer xf_grade) {
		this.xf_grade = xf_grade;
	}
	public Integer getOther_grade() {
		return other_grade;
	}
	public void setOther_grade(Integer other_grade) {
		this.other_grade = other_grade;
	}
	public Integer getAll_grade() {
		return all_grade;
	}
	public void setAll_grade(Integer all_grade) {
		this.all_grade = all_grade;
	}
	public Integer getHealth_savegrade() {
		return health_savegrade;
	}
	public void setHealth_savegrade(Integer health_savegrade) {
		this.health_savegrade = health_savegrade;
	}
	public Integer getClresult() {
		return clresult;
	}
	public void setClresult(Integer clresult) {
		this.clresult = clresult;
	}
	public String getHealth_gradetdesc() {
		return health_gradetdesc;
	}
	public void setHealth_gradetdesc(String health_gradetdesc) {
		this.health_gradetdesc = health_gradetdesc;
	}
	public String getDcr() {
		return dcr;
	}
	public void setDcr(String dcr) {
		this.dcr = dcr;
	}
	public Date getDcrq() {
		return dcrq;
	}
	public void setDcrq(Date dcrq) {
		this.dcrq = dcrq;
	}
	public String getFhr() {
		return fhr;
	}
	public void setFhr(String fhr) {
		this.fhr = fhr;
	}
	public Integer getLose_grade() {
		return lose_grade;
	}
	public void setLose_grade(Integer lose_grade) {
		this.lose_grade = lose_grade;
	}
	
	
}
