package com.originsys.safemanage.domain;
import java.io.Serializable;
import java.util.Date;
/**楼幢检查跟踪表*/
public class TBuildingCtrack implements Serializable{
	/**信息编号每次检查一条记录*/
	private String info_id;
	/**楼幢编号-图斑编号*/
	private String building_id;
	/**所属地区*/
	private String building_region;
	/**电梯、楼梯备注*/
	private String dt_tdesc;
	/**装饰装修备注*/
	private String struct_desc;
	/**基本信息备注*/
	private String bz_desc;
	/**上下部结构形式备注*/
	private String dere_desc;
	/**检查时间*/
	private Date check_time;
	/**检查人姓名可能多个*/
	private String check_user;
	/**信息填写人*/
	private String check_userid;
	/***/
	private String info_state;
	/**审核人员id*/
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
	/**使用功能@1-住宅&2-综合楼&3-办公&4-商业&5-学校用房&6-医院用房&7-工业用房&8-其它*/
	private String usefunction;
	/**外墙饰面@1-玻璃&2-石材&3-面砖&4-马赛克&5-砂浆&6-涂料&7-清水墙&8-其它*/
	private String wq_type;
	//----------------------------------------------------------------
	public String getBuilding_region() {
		return building_region;
	}
	public void setBuilding_region(String building_region) {
		this.building_region = building_region;
	}
	/**设置信息编号每次检查一条记录的get方法*/
	public String getInfo_id() {
		return info_id;
	}
	/**设置信息编号每次检查一条记录的set方法*/
	public void setInfo_id(String info_id) {
		this.info_id = info_id;
	}
	/**设置楼幢编号-图斑编号的get方法*/
	public String getBuilding_id() {
		return building_id;
	}
	/**设置楼幢编号-图斑编号的set方法*/
	public void setBuilding_id(String building_id) {
		this.building_id = building_id;
	}
	/**设置电梯、楼梯备注的get方法*/
	public String getDt_tdesc() {
		return dt_tdesc;
	}
	/**设置电梯、楼梯备注的set方法*/
	public void setDt_tdesc(String dt_tdesc) {
		this.dt_tdesc = dt_tdesc;
	}
	/**设置装饰装修备注的get方法*/
	public String getStruct_desc() {
		return struct_desc;
	}
	/**设置装饰装修备注的set方法*/
	public void setStruct_desc(String struct_desc) {
		this.struct_desc = struct_desc;
	}
	/**设置基本信息备注的get方法*/
	public String getBz_desc() {
		return bz_desc;
	}
	/**设置基本信息备注的set方法*/
	public void setBz_desc(String bz_desc) {
		this.bz_desc = bz_desc;
	}
	/**设置上下部结构形式备注的get方法*/
	public String getDere_desc() {
		return dere_desc;
	}
	/**设置上下部结构形式备注的set方法*/
	public void setDere_desc(String dere_desc) {
		this.dere_desc = dere_desc;
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
	/**设置信息填写人的get方法*/
	public String getCheck_userid() {
		return check_userid;
	}
	/**设置信息填写人的set方法*/
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
	/**设置审核人员id的get方法*/
	public String getVerify_userid() {
		return verify_userid;
	}
	/**设置审核人员id的set方法*/
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
	/**设置使用功能@1-住宅&2-综合楼&3-办公&4-商业&5-学校用房&6-医院用房&7-工业用房&8-其它的get方法*/
	public String getUsefunction() {
		return usefunction;
	}
	/**设置使用功能@1-住宅&2-综合楼&3-办公&4-商业&5-学校用房&6-医院用房&7-工业用房&8-其它的set方法*/
	public void setUsefunction(String usefunction) {
		this.usefunction = usefunction;
	}
	/**设置外墙饰面@1-玻璃&2-石材&3-面砖&4-马赛克&5-砂浆&6-涂料&7-清水墙&8-其它的get方法*/
	public String getWq_type() {
		return wq_type;
	}
	/**设置外墙饰面@1-玻璃&2-石材&3-面砖&4-马赛克&5-砂浆&6-涂料&7-清水墙&8-其它的set方法*/
	public void setWq_type(String wq_type) {
		this.wq_type = wq_type;
	}
}