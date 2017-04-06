package com.originsys.safemanage.domain;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class TAppraisalReport implements Serializable{
	/**鉴定信息编号主键*/
	private String jdinfo_id;
	/**楼幢编号*/
	private String building_id;
	/**楼幢地址*/
	private String building_address;
	/**所属区域*/
	private String building_region;
	/**委托人或单位*/
	private String entrust_user;
	/**联系人*/
	private String linkman;
	/**联系电话*/
	private String linktel;
	/**房屋概况*/
	private String jz_overview;
	/**鉴定结论*/
	private String identify_conclusion;
	/**危险等级@1-a级&2-b级&3-c级&4-d级*/
	private String dangerous_level;
	/**鉴定内容*/
	private String identify_content;
	/**房屋结构老化程度@1-强&2-弱&3-差*/
	private String struct_aging;
	/**是否有改造@1-是&2-否*/
	private String is_transform;
	/**设施老化程度@1-强&2-弱&3-差*/
	private String facility_aging;
	/**抗震结构是否完善@1-强&2-弱&3-差*/
	private String is_kzperfect;
	/**拆改结构是否严重@1-强&2-弱&3-差*/
	private String is_transform_seriousness;
	/**鉴定时间*/
	private Date jd_date;
	/**鉴定时间条件1*/
	private Date jd_date1;
	/**鉴定时间条件2*/
	private Date jd_date2;
	/**鉴定单位*/
	private String jd_department_id;
	/**鉴定单位中文名称*/
	private String jd_department;
	/**鉴定人*/
	private String jdmember;
	/**鉴定报告*/
	private String jd_report;
	/**相关图片*/
	private String jd_image;
	/**鉴定信息状态0暂存1待审核2审核驳回8审核通过*/
	private String info_state;
	/**录入人*/
	private String entry_mem_id;
	/**录入时间*/
	private Date entry_date;
	/**鉴定结果*/
	private String jd_result;
	/**审核人*/
	private String checker_memid;
	/**审核时间*/
	private Date check_date;
	/**审核意见*/
	private String check_opinion;
	/**是否已发送危房通知书 1已发送 0未发送*/
	private String notice_state;
	/**危房通知逾期等级*/
	private String over_grade;
	/**通知发送时间*/
	private Date notice_date;
	
	
	/**开始时间*/
	private Date s_date;
	/**结束时间*/
	private Date e_date;
	//----------------------------------------------------------------
	
	/**设置鉴定信息编号主键的get方法*/
	public String getJdinfo_id() {
		return jdinfo_id;
	}
	public String getJd_department() {
		return jd_department;
	}
	public void setJd_department(String jd_department) {
		this.jd_department = jd_department;
	}
	public String getNotice_state() {
		return notice_state;
	}
	public void setNotice_state(String notice_state) {
		this.notice_state = notice_state;
	}
	/**设置鉴定信息编号主键的set方法*/
	public void setJdinfo_id(String jdinfo_id) {
		this.jdinfo_id = jdinfo_id;
	}
	/**设置楼幢编号的get方法*/
	public String getBuilding_id() {
		return building_id;
	}
	/**设置楼幢编号的set方法*/
	public void setBuilding_id(String building_id) {
		this.building_id = building_id;
	}
	/**设置楼幢地址的get方法*/
	public String getBuilding_address() {
		return building_address;
	}
	/**设置楼幢地址的set方法*/
	public void setBuilding_address(String building_address) {
		this.building_address = building_address;
	}
	/**设置所属区域的get方法*/
	public String getBuilding_region() {
		return building_region;
	}
	/**设置所属区域的set方法*/
	public void setBuilding_region(String building_region) {
		this.building_region = building_region;
	}
	/**设置委托人或单位的get方法*/
	public String getEntrust_user() {
		return entrust_user;
	}
	/**设置委托人或单位的set方法*/
	public void setEntrust_user(String entrust_user) {
		this.entrust_user = entrust_user;
	}
	/**设置联系人的get方法*/
	public String getLinkman() {
		return linkman;
	}
	/**设置联系人的set方法*/
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	/**设置联系电话的get方法*/
	public String getLinktel() {
		return linktel;
	}
	/**设置联系电话的set方法*/
	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}
	/**设置房屋概况的get方法*/
	public String getJz_overview() {
		return jz_overview;
	}
	/**设置房屋概况的set方法*/
	public void setJz_overview(String jz_overview) {
		this.jz_overview = jz_overview;
	}
	/**设置鉴定结论的get方法*/
	public String getIdentify_conclusion() {
		return identify_conclusion;
	}
	/**设置鉴定结论的set方法*/
	public void setIdentify_conclusion(String identify_conclusion) {
		this.identify_conclusion = identify_conclusion;
	}
	/**设置危险等级@1-a级&2-b级&3-c级&4-d级的get方法*/
	public String getDangerous_level() {
		return dangerous_level;
	}
	/**设置危险等级@1-a级&2-b级&3-c级&4-d级的set方法*/
	public void setDangerous_level(String dangerous_level) {
		this.dangerous_level = dangerous_level;
	}
	/**设置鉴定内容的get方法*/
	public String getIdentify_content() {
		return identify_content;
	}
	/**设置鉴定内容的set方法*/
	public void setIdentify_content(String identify_content) {
		this.identify_content = identify_content;
	}
	/**设置房屋结构老化程度@1-强&2-弱&3-差的get方法*/
	public String getStruct_aging() {
		return struct_aging;
	}
	/**设置房屋结构老化程度@1-强&2-弱&3-差的set方法*/
	public void setStruct_aging(String struct_aging) {
		this.struct_aging = struct_aging;
	}
	/**设置是否有改造@1-是&2-否的get方法*/
	public String getIs_transform() {
		return is_transform;
	}
	/**设置是否有改造@1-是&2-否的set方法*/
	public void setIs_transform(String is_transform) {
		this.is_transform = is_transform;
	}
	/**设置设施老化程度@1-强&2-弱&3-差的get方法*/
	public String getFacility_aging() {
		return facility_aging;
	}
	/**设置设施老化程度@1-强&2-弱&3-差的set方法*/
	public void setFacility_aging(String facility_aging) {
		this.facility_aging = facility_aging;
	}
	/**设置抗震结构是否完善@1-强&2-弱&3-差的get方法*/
	public String getIs_kzperfect() {
		return is_kzperfect;
	}
	/**设置抗震结构是否完善@1-强&2-弱&3-差的set方法*/
	public void setIs_kzperfect(String is_kzperfect) {
		this.is_kzperfect = is_kzperfect;
	}
	/**设置拆改结构是否严重@1-强&2-弱&3-差的get方法*/
	public String getIs_transform_seriousness() {
		return is_transform_seriousness;
	}
	/**设置拆改结构是否严重@1-强&2-弱&3-差的set方法*/
	public void setIs_transform_seriousness(String is_transform_seriousness) {
		this.is_transform_seriousness = is_transform_seriousness;
	}
	/**设置鉴定时间的get方法*/
	public Date getJd_date() {
		return jd_date;
	}
	/**设置鉴定时间的set方法*/
	public void setJd_date(Date jd_date) {
		this.jd_date = jd_date;
	}
	
	public Date getJd_date1() {
		return jd_date1;
	}
	public void setJd_date1(Date jd_date1) {
		this.jd_date1 = jd_date1;
	}
	public Date getJd_date2() {
		return jd_date2;
	}
	public void setJd_date2(Date jd_date2) {
		this.jd_date2 = jd_date2;
	}
	
	/**设置鉴定单位的get方法*/
	public String getJd_department_id() {
		return jd_department_id;
	}
	/**设置鉴定单位的set方法*/
	public void setJd_department_id(String jd_department_id) {
		this.jd_department_id = jd_department_id;
	}
	/**设置鉴定人的get方法*/
	public String getJdmember() {
		return jdmember;
	}
	/**设置鉴定人的set方法*/
	public void setJdmember(String jdmember) {
		this.jdmember = jdmember;
	}
	/**设置鉴定报告的get方法*/
	public String getJd_report() {
		return jd_report;
	}
	/**设置鉴定报告的set方法*/
	public void setJd_report(String jd_report) {
		this.jd_report = jd_report;
	}
	/**设置相关图片的get方法*/
	public String getJd_image() {
		return jd_image;
	}
	/**设置相关图片的set方法*/
	public void setJd_image(String jd_image) {
		this.jd_image = jd_image;
	}
	/**设置鉴定信息状态0暂存1待审核2审核驳回8审核通过的get方法*/
	public String getInfo_state() {
		return info_state;
	}
	/**设置鉴定信息状态0暂存1待审核2审核驳回8审核通过的set方法*/
	public void setInfo_state(String info_state) {
		this.info_state = info_state;
	}
	/**设置录入人的get方法*/
	public String getEntry_mem_id() {
		return entry_mem_id;
	}
	/**设置录入人的set方法*/
	public void setEntry_mem_id(String entry_mem_id) {
		this.entry_mem_id = entry_mem_id;
	}
	/**设置录入时间的get方法*/
	public Date getEntry_date() {
		return entry_date;
	}
	/**设置录入时间的set方法*/
	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}
	/**设置鉴定结果的get方法*/
	public String getJd_result() {
		return jd_result;
	}
	/**设置鉴定结果的set方法*/
	public void setJd_result(String jd_result) {
		this.jd_result = jd_result;
	}
	/**设置审核人的get方法*/
	public String getChecker_memid() {
		return checker_memid;
	}
	/**设置审核人的set方法*/
	public void setChecker_memid(String checker_memid) {
		this.checker_memid = checker_memid;
	}
	/**设置审核时间的get方法*/
	public Date getCheck_date() {
		return check_date;
	}
	/**设置审核时间的set方法*/
	public void setCheck_date(Date check_date) {
		this.check_date = check_date;
	}
	/**设置审核意见的get方法*/
	public String getCheck_opinion() {
		return check_opinion;
	}
	/**设置审核意见的set方法*/
	public void setCheck_opinion(String check_opinion) {
		this.check_opinion = check_opinion;
	}
	public String getOver_grade() {
		return over_grade;
	}
	public void setOver_grade(String over_grade) {
		this.over_grade = over_grade;
	}
	public Date getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}
	public Date getS_date() {
		return s_date;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	public Date getE_date() {
		return e_date;
	}
	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}
	
}