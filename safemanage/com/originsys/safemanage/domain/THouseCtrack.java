package com.originsys.safemanage.domain;
import java.io.Serializable;
import java.util.Date;

public class THouseCtrack implements Serializable{
	/**信息编号每次检查一条记录*/
	private String info_id;
	/**房屋编号*/
	private String house_id;
	/**楼幢编号*/
	private Integer building_id;
	/**检查时间*/
	private Date check_time;
	/**检查人姓名可能多个*/
	private String check_user;
	/**检查人员id*/
	private String check_userid;
	/***/
	private String info_state;
	/**审核人id*/
	private String verify_userid;
	/**审核时间*/
	private Date verify_time;
	/**审核意见*/
	private String verify_comment;
	/**健康结构健康等级@1-a级&2-b级&3-c级&4-d级*/
	private String structure_grade;
	/**健康使用健康等级@1-a级&2-b级&3-c级&4-d级*/
	private String used_grade;
	/**健康抗震能力@1-强&2-弱&3-差*/
	private String kz_grade;
	/**健康防雷能力@1-强&2-弱&3-差*/
	private String fl_grade;
	/**健康消防能力@1-强&2-弱&3-差*/
	private String xf_grade;
	/**健康其他防灾能力@1-强&2-弱&3-差*/
	private String other_grade;
	/**健康总健康等级@1-ⅰ级（健康）&2-ⅱ级（亚健康）&3-ⅲ级（病态）&4-ⅳ（病危）*/
	private String all_grade;
	/**健康安全等级@1-a级&2-b级&3-c级&4-d级*/
	private String health_savegrade;
	/**健康处理意见@1-正常使用&2-常规维护&3-适当维修&4-采取措施&5-停止使用*/
	private String clresult;
	/**健康备注*/
	private String health_gradetdesc;
	/**健康完损等级@1-完好房屋&2-基本完好&3-一般破损&4-严重破损*/
	private String lose_grade;
	//----------------------------------------------------------------
	/**设置信息编号每次检查一条记录的get方法*/
	public String getInfo_id() {
		return info_id;
	}
	/**设置信息编号每次检查一条记录的set方法*/
	public void setInfo_id(String info_id) {
		this.info_id = info_id;
	}
	/**设置房屋编号的get方法*/
	public String getHouse_id() {
		return house_id;
	}
	/**设置房屋编号的set方法*/
	public void setHouse_id(String house_id) {
		this.house_id = house_id;
	}
	/**设置楼幢编号的get方法*/
	public Integer getBuilding_id() {
		return building_id;
	}
	/**设置楼幢编号的set方法*/
	public void setBuilding_id(Integer building_id) {
		this.building_id = building_id;
	}
	/**设置检查时间的get方法*/
	public Date getCheck_time() {
		return check_time;
	}
	/**设置检查时间的set方法*/
	public void setCheck_time(Date check_time) {
		this.check_time = check_time;
	}
	/**设置检查人姓名可能多个的get方法*/
	public String getCheck_user() {
		return check_user;
	}
	/**设置检查人姓名可能多个的set方法*/
	public void setCheck_user(String check_user) {
		this.check_user = check_user;
	}
	/**设置检查人员id的get方法*/
	public String getCheck_userid() {
		return check_userid;
	}
	/**设置检查人员id的set方法*/
	public void setCheck_userid(String check_userid) {
		this.check_userid = check_userid;
	}
	/**设置的get方法*/
	public String getInfo_state() {
		return info_state;
	}
	/**设置的set方法*/
	public void setInfo_state(String info_state) {
		this.info_state = info_state;
	}
	/**设置审核人id的get方法*/
	public String getVerify_userid() {
		return verify_userid;
	}
	/**设置审核人id的set方法*/
	public void setVerify_userid(String verify_userid) {
		this.verify_userid = verify_userid;
	}
	/**设置审核时间的get方法*/
	public Date getVerify_time() {
		return verify_time;
	}
	/**设置审核时间的set方法*/
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
	/**设置审核意见的get方法*/
	public String getVerify_comment() {
		return verify_comment;
	}
	/**设置审核意见的set方法*/
	public void setVerify_comment(String verify_comment) {
		this.verify_comment = verify_comment;
	}
	/**设置健康结构健康等级@1-a级&2-b级&3-c级&4-d级的get方法*/
	public String getStructure_grade() {
		return structure_grade;
	}
	/**设置健康结构健康等级@1-a级&2-b级&3-c级&4-d级的set方法*/
	public void setStructure_grade(String structure_grade) {
		this.structure_grade = structure_grade;
	}
	/**设置健康使用健康等级@1-a级&2-b级&3-c级&4-d级的get方法*/
	public String getUsed_grade() {
		return used_grade;
	}
	/**设置健康使用健康等级@1-a级&2-b级&3-c级&4-d级的set方法*/
	public void setUsed_grade(String used_grade) {
		this.used_grade = used_grade;
	}
	/**设置健康抗震能力@1-强&2-弱&3-差的get方法*/
	public String getKz_grade() {
		return kz_grade;
	}
	/**设置健康抗震能力@1-强&2-弱&3-差的set方法*/
	public void setKz_grade(String kz_grade) {
		this.kz_grade = kz_grade;
	}
	/**设置健康防雷能力@1-强&2-弱&3-差的get方法*/
	public String getFl_grade() {
		return fl_grade;
	}
	/**设置健康防雷能力@1-强&2-弱&3-差的set方法*/
	public void setFl_grade(String fl_grade) {
		this.fl_grade = fl_grade;
	}
	/**设置健康消防能力@1-强&2-弱&3-差的get方法*/
	public String getXf_grade() {
		return xf_grade;
	}
	/**设置健康消防能力@1-强&2-弱&3-差的set方法*/
	public void setXf_grade(String xf_grade) {
		this.xf_grade = xf_grade;
	}
	/**设置健康其他防灾能力@1-强&2-弱&3-差的get方法*/
	public String getOther_grade() {
		return other_grade;
	}
	/**设置健康其他防灾能力@1-强&2-弱&3-差的set方法*/
	public void setOther_grade(String other_grade) {
		this.other_grade = other_grade;
	}
	/**设置健康总健康等级@1-ⅰ级（健康）&2-ⅱ级（亚健康）&3-ⅲ级（病态）&4-ⅳ（病危）的get方法*/
	public String getAll_grade() {
		return all_grade;
	}
	/**设置健康总健康等级@1-ⅰ级（健康）&2-ⅱ级（亚健康）&3-ⅲ级（病态）&4-ⅳ（病危）的set方法*/
	public void setAll_grade(String all_grade) {
		this.all_grade = all_grade;
	}
	/**设置健康安全等级@1-a级&2-b级&3-c级&4-d级的get方法*/
	public String getHealth_savegrade() {
		return health_savegrade;
	}
	/**设置健康安全等级@1-a级&2-b级&3-c级&4-d级的set方法*/
	public void setHealth_savegrade(String health_savegrade) {
		this.health_savegrade = health_savegrade;
	}
	/**设置健康处理意见@1-正常使用&2-常规维护&3-适当维修&4-采取措施&5-停止使用的get方法*/
	public String getClresult() {
		return clresult;
	}
	/**设置健康处理意见@1-正常使用&2-常规维护&3-适当维修&4-采取措施&5-停止使用的set方法*/
	public void setClresult(String clresult) {
		this.clresult = clresult;
	}
	/**设置健康备注的get方法*/
	public String getHealth_gradetdesc() {
		return health_gradetdesc;
	}
	/**设置健康备注的set方法*/
	public void setHealth_gradetdesc(String health_gradetdesc) {
		this.health_gradetdesc = health_gradetdesc;
	}
	/**设置健康完损等级@1-完好房屋&2-基本完好&3-一般破损&4-严重破损的get方法*/
	public String getLose_grade() {
		return lose_grade;
	}
	/**设置健康完损等级@1-完好房屋&2-基本完好&3-一般破损&4-严重破损的set方法*/
	public void setLose_grade(String lose_grade) {
		this.lose_grade = lose_grade;
	}
}