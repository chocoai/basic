package com.originsys.safemanage.safecheck.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuilding;
import com.originsys.safemanage.domain.TBuildingSafe;
import com.originsys.safemanage.domain.TInvmBase;
import com.originsys.safemanage.domain.TInvmField;

/**
 auth:zhanglf 2014-6-10
   描述：楼幢普查结果修改，修改基本信息表，修改楼幢普查结果表，地基基础表，现场调查场地环境
 */
public class BuildingSafeUpdate extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		/**楼幢编号*/
		String building_id="";
		if(ra.getParameter("building_id")!=null && !"".equals(ra.getParameter("building_id"))){
			building_id=ra.getParameter("building_id");
		}
		StringBuffer opcontent=new StringBuffer();
		opcontent.append("楼幢编号："+building_id+";楼幢坐落："+ra.getParameter("building_address")+";");
		/**楼幢基本信息*/
		TBuilding tBuilding=new TBuilding();
		tBuilding.setBuilding_id(building_id);//Integer:楼幢编号图斑编号sm_id
		tBuilding.setBuilding_address(ra.getParameter("building_address"));//String:楼幢坐落
		tBuilding.setBuiliding_region(ra.getParameter("builiding_region"));//String:所属区域
		if(ra.getParameter("building_number")!=null && !"".equals(ra.getParameter("building_number"))){
			tBuilding.setBuilding_number(Integer.parseInt(ra.getParameter("building_number")));//Integer:楼幢号
		}
		if(ra.getParameter("floor_count")!=null && !"".equals(ra.getParameter("floor_count"))){
			tBuilding.setFloor_count(Integer.parseInt(ra.getParameter("floor_count")));//Integer:层数
		}
		if(ra.getParameter("house_count")!=null && !"".equals(ra.getParameter("house_count"))){
			tBuilding.setHouse_count(Integer.parseInt(ra.getParameter("house_count")));//Integer:户数
			opcontent.append("房屋套数："+ra.getParameter("house_count")+";");
		}
		if(ra.getParameter("floorup_count")!=null && !"".equals(ra.getParameter("floorup_count"))){
			tBuilding.setFloorup_count(Integer.parseInt(ra.getParameter("floorup_count")));//Integer:地上层数
			opcontent.append("地上层数："+ra.getParameter("floorup_count")+";");
		}
		if(ra.getParameter("floordown_count")!=null && !"".equals(ra.getParameter("floordown_count"))){
			tBuilding.setFloordown_count(Integer.parseInt(ra.getParameter("floordown_count")));//Integer:地下层数
			opcontent.append("地下层数："+ra.getParameter("floordown_count")+";");
		}
		tBuilding.setReal_type(ra.getParameter("real_type"));//String:房屋产别
		tBuilding.setUse_desgin(ra.getParameter("use_desgin"));//String:设计用途
		if(ra.getParameter("building_date")!=null && !"".equals(ra.getParameter("building_date"))){
			tBuilding.setBuilding_date(Integer.parseInt(ra.getParameter("building_date")));//Integer:建成时间
			opcontent.append("建成时间："+ra.getParameter("building_date")+";");
		}
		tBuilding.setBuild_struct(ra.getParameter("build_struct"));//String:房屋与结构
		if(ra.getParameter("building_mapid")!=null && !"".equals(ra.getParameter("building_mapid"))){
			tBuilding.setBuilding_mapid(Integer.parseInt(ra.getParameter("building_mapid")));//Integer:所在楼盘内码初始化进来
		}
		tBuilding.setDangerous_type_pc("1");//String:危房类型-普查 整栋危楼1 局部危楼2
//		tBuilding.setHealth_grade_jd(ra.getParameter("health_grade_jd"));//String:健康等级-鉴定@1-a级&2-b级&3-c级&4-d级
//		tBuilding.setDangerous_type_jd(ra.getParameter("dangerous_type_jd"));//String:危房类型-鉴定 整栋危楼1 局部危楼2
		tBuilding.setIs_die("1");
		tBuilding.setBuilding_mapid(Integer.parseInt(building_id));//String:地图定位内码
		tBuilding.setFw_type(ra.getParameter("fw_type"));//String:房屋类别1个人 2公共建筑 3保障住房
		tBuilding.setUsefunction(ra.getParameter("usefunction"));//String:使用功能@1-住宅&2-综合楼&3-办公&4-商业&5-学校用房&6-医院用房&7-工业用房&8-其它
		tBuilding.setBase_type(ra.getParameter("base_type"));//String:基础类型@1-毛石&2-砖&3-混凝土&4-钢筋混凝土&5-其它
		tBuilding.setUpon_type(ra.getParameter("upon_type"));//String:楼盖类型@1-现浇板&2-预制板&3-现浇、预制板混用&4-木楼板&5-其它
		tBuilding.setWm_type(ra.getParameter("wm_type"));//String:屋面类型@1-预制板平屋面&2-现浇板平屋面&3-现浇板坡屋面&4-有檩系坡屋面&5-其它
		tBuilding.setWairang_type(ra.getParameter("wairang_type"));//String:外廊类型@1-未设置&2-梁式&3-板式&4-落地
		tBuilding.setLt_number(ra.getParameter("lt_number"));//String:楼梯数目@1-一个&2-二个&3-三个&4-多个
		tBuilding.setLt_type(ra.getParameter("lt_type"));//String:楼梯类型@1-木&2-混凝土&3-钢&4-其它
		tBuilding.setDt_number(ra.getParameter("dt_number"));//String:电梯数目@1-一个&2-二个&3-三个&4-多个
		tBuilding.setWq_type(ra.getParameter("wq_type"));//String:外墙饰面@1-玻璃&2-石材&3-面砖&4-马赛克&5-砂浆&6-涂料&7-清水墙&8-其它
		
		tBuilding.setBuild_right(ra.getParameter("build_right"));//产权年限@1-50年&2-70年&3-其它
		opcontent.append("产权年限："+ra.getParameter("build_right")+";");
		tBuilding.setRight_type(ra.getParameter("right_type"));//产权性质@1-直管公房&2-自管房&3-私房&4-其它
		opcontent.append("产权性质："+ra.getParameter("right_type")+";");
		tBuilding.setOwner(ra.getParameter("owner"));//产权单位
		if(ra.getParameter("heigth")!=null && !"".equals(ra.getParameter("heigth"))){
			tBuilding.setHeigth(Float.parseFloat(ra.getParameter("heigth")));//高度m
		}
		if(ra.getParameter("depth")!=null && !"".equals(ra.getParameter("depth"))){
			tBuilding.setDepth(Float.parseFloat(ra.getParameter("depth")));//檐高m
		}
		tBuilding.setPlane_shape(ra.getParameter("plane_shape"));//平面@1-规则&2-不规则
		tBuilding.setExposure(ra.getParameter("exposure"));//朝向@1-东西&2-南北&3-其它
		tBuilding.setLm_shape(ra.getParameter("lm_shape"));//立面@1-规则&2-不规则
		tBuilding.setManagement_unit(ra.getParameter("management_unit"));//经营管理单位
		if(ra.getParameter("floor_height")!=null && !"".equals(ra.getParameter("floor_height"))){
			tBuilding.setFloor_height(Float.parseFloat(ra.getParameter("floor_height")));//层高
		}
		tBuilding.setFrozen_area(ra.getParameter("frozen_area"));//是否冻结片区@1-是&2-否
		tBuilding.setBelong_community(ra.getParameter("belong_community"));//所属街道
		tBuilding.setBelong_street(ra.getParameter("belong_street"));//所属小区
		tBuilding.setYt_type(ra.getParameter("yt_type"));//String:阳台类型@1-未设置&2-梁式&3-板式&4-落地
		tBuilding.setCheck_address(ra.getParameter("check_address"));//检查新地址
		tBuilding.setIs_same(ra.getParameter("issame"));//是否一致@0-否&1-是
		
		/**楼幢普查结果信息*/
		TBuildingSafe tBuildingSafe=new TBuildingSafe();
		tBuildingSafe.setInfo_id(ra.getParameter("info_id"));
		tBuildingSafe.setBuilding_id(building_id);//Integer:楼幢编号-图斑编号
		tBuildingSafe.setDt_tdesc(ra.getParameter("dt_tdesc"));//String:电梯、楼梯备注
		tBuildingSafe.setStruct_desc(ra.getParameter("struct_desc"));//String:装饰装修备注
		tBuildingSafe.setBz_desc(ra.getParameter("bz_desc"));//String:基本信息备注
		tBuildingSafe.setDere_desc(ra.getParameter("dere_desc"));//String:上下部结构形式备注
		if(ra.getParameter("check_time")!=null && !"".equals(ra.getParameter("check_time"))){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			tBuildingSafe.setCheck_time(sdf.parse(ra.getParameter("check_time")));//Date:检查时间
			opcontent.append("检查时间："+ra.getParameter("check_time")+";");
		}
		tBuildingSafe.setCheck_user(ra.getParameter("check_user"));//String:检查人姓名可能多个
		opcontent.append("检查人姓名："+ra.getParameter("check_user")+";");
		tBuildingSafe.setCheck_userid(ra.getUser().getMem_id());//String:信息填写人
		if("zc".equals(ra.getParameter("op")))
			tBuildingSafe.setInfo_state("0");//String:暂存 0   未审核1    审核驳回2     审核通过8
		else{
			tBuildingSafe.setInfo_state("1");//String:暂存 0   未审核1    审核驳回2     审核通过8
		}
		tBuildingSafe.setStructure_grade(ra.getParameter("structure_grade"));//String:健康结构健康等级@1-a级&2-b级&3-c级&4-d级
		tBuildingSafe.setUsed_grade(ra.getParameter("used_grade"));//String:健康使用健康等级@1-a级&2-b级&3-c级&4-d级
		tBuildingSafe.setKz_grade(ra.getParameter("kz_grade"));//String:健康抗震能力@1-强&2-弱&3-差
		tBuildingSafe.setFl_grade(ra.getParameter("fl_grade"));//String:健康防雷能力@1-强&2-弱&3-差
		tBuildingSafe.setXf_grade(ra.getParameter("xf_grade"));//String:健康消防能力@1-强&2-弱&3-差
		tBuildingSafe.setOther_grade(ra.getParameter("other_grade"));//String:健康其他防灾能力@1-强&2-弱&3-差
		tBuildingSafe.setAll_grade(ra.getParameter("all_grade"));//String:健康总健康等级@1-ⅰ级（健康）&2-ⅱ级（亚健康）&3-ⅲ级（病态）&4-ⅳ（病危）
		tBuildingSafe.setHealth_savegrade(ra.getParameter("health_savegrade"));//String:健康安全等级@1-a级&2-b级&3-c级&4-d级
		opcontent.append("健康安全等级："+ra.getParameter("health_savegrade")+";");
		tBuildingSafe.setClresult(ra.getParameter("clresult"));//String:健康处理意见@1-正常使用&2-常规维护&3-适当维修&4-采取措施&5-停止使用
		tBuildingSafe.setHealth_gradetdesc(ra.getParameter("health_gradetdesc"));//String:健康备注
		tBuildingSafe.setLose_grade(ra.getParameter("lose_grade"));//String:健康完损等级@1-完好房屋&2-基本完好&3-一般破损&4-严重破损
		tBuildingSafe.setCheck_type("1");//String:检查类型@1普查2检查
		if(ra.getParameter("pc_num")!=null && !"".equals(ra.getParameter("pc_num"))){
				tBuildingSafe.setPc_num(Integer.parseInt(ra.getParameter("pc_num")));//Integer:普查次数第几次普查
		}
		tBuildingSafe.setUsefunction(ra.getParameter("usefunction"));//String:使用功能@1-住宅&2-综合楼&3-办公&4-商业&5-学校用房&6-医院用房&7-工业用房&8-其它
		tBuildingSafe.setWq_type(ra.getParameter("wq_type"));//String:外墙饰面@1-玻璃&2-石材&3-面砖&4-马赛克&5-砂浆&6-涂料&7-清水墙&8-其它
		tBuildingSafe.setAnnex(ra.getParameter("annex"));//相关附件
		tBuildingSafe.setAnnex_pic(ra.getParameter("annex_pic"));//相关图片
		if(ra.getParameter("build_area")!=null && !"".equals(ra.getParameter("build_area"))){
			tBuildingSafe.setBuild_area(Float.parseFloat(ra.getParameter("build_area")));//Float:建筑面积
		}
		tBuildingSafe.setBuilding_region(ra.getParameter("builiding_region"));
		
		/**地基基础*/
		TInvmBase tInvmBase=new TInvmBase();
		tInvmBase.setInfo_id(ra.getParameter("info_id"));
		tInvmBase.setBuilding_id(building_id);//Integer:楼幢编号-图斑编号
		tInvmBase.setBenormal(ra.getParameter("benormal"));//String:地基无异常@1-否&2-是
		tInvmBase.setSedi_crack(ra.getParameter("sedi_crack"));//String:地基沉降裂缝@1-否&2-轻微&3-一般&4-严重
		tInvmBase.setObv_incline(ra.getParameter("obv_incline"));//String:地基明显倾斜@1-否&2-是
		tInvmBase.setLow_water(ra.getParameter("low_water"));//String:地基低洼积水@1-否&2-是
		tInvmBase.setElseitem(ra.getParameter("elseitem"));//String:地基其他@1-否&2-轻微&3-一般&4-严重
		tInvmBase.setB_grading(ra.getParameter("b_grading"));//String:地基子项健康评级@1-a级&2-b级&3-c级&4-d级
		tInvmBase.setB_secritygrading(ra.getParameter("b_secritygrading"));//String:地基子项安全评级@1-a级&2-b级&3-c级&4-d级
		tInvmBase.setB_tdesc(ra.getParameter("b_tdesc"));//String:地基备注
		tInvmBase.setB_peotected_grage(ra.getParameter("b_peotected_grage"));//String:地基子项完损等级评级@1-完好&2-基本完好&3-一般损坏&4-严重损坏
		
		/**现场调查场地环境*/
		TInvmField tInvmField=new TInvmField();
		tInvmField.setInfo_id(ra.getParameter("info_id"));
		tInvmField.setBuilding_id(building_id);//Integer:楼幢编号
		tInvmField.setField_flat(ra.getParameter("field_flat"));//String:场地环境房屋场地平地@1-否&2-是
		tInvmField.setField_hillfoot(ra.getParameter("field_hillfoot"));//String:场地环境房屋场地山脚@1-否&2-是
		tInvmField.setField_cliff(ra.getParameter("field_cliff"));//String:场地环境房屋场地悬崖@1-否&2-是
		tInvmField.setField_margin(ra.getParameter("field_margin"));//String:场地环境房屋场地水库边@1-否&2-是
		tInvmField.setField_low(ra.getParameter("field_low"));//String:场地环境房屋场地低洼地带@1-否&2-是
		tInvmField.setField_sink(ra.getParameter("field_sink"));//String:场地环境房屋场地塌陷区@1-否&2-是
		tInvmField.setField_earthtype(ra.getParameter("field_earthtype"));//String:场地环境场地土类型@1-硬土&2-一般土&3-软土
		tInvmField.setNeighbor_normal(ra.getParameter("neighbor_normal"));//String:场地环境相邻施工无异常@1-否&2-是
		tInvmField.setNeighbor_shook(ra.getParameter("neighbor_shook"));//String:场地环境相邻施工振动@1-否&2-是
		tInvmField.setNeighbor_rain(ra.getParameter("neighbor_rain"));//String:场地环境相邻施工降水@1-否&2-是
		tInvmField.setNeighbor_interfere(ra.getParameter("neighbor_interfere"));//String:场地环境相邻施工土体扰动@1-否&2-是
		tInvmField.setChemic_normal(ra.getParameter("chemic_normal"));//String:场地环境化学侵蚀无异常@1-否&2-是
		tInvmField.setChemic_hcl(ra.getParameter("chemic_hcl"));//String:场地环境化学侵蚀盐酸@1-否&2-是
		tInvmField.setChemic_h2so4(ra.getParameter("chemic_h2so4"));//String:场地环境化学侵蚀硫酸@1-否&2-是
		tInvmField.setChemic_seewater(ra.getParameter("chemic_seewater"));//String:场地环境化学侵蚀海水@1-否&2-是
		tInvmField.setChemic_else(ra.getParameter("chemic_else"));//String:场地环境化学侵蚀其他@1-否&2-是
		tInvmField.setField_grading(ra.getParameter("field_grading"));//String:场地环境子项健康评级:0a,1b,2c***
		tInvmField.setField_tdesc(ra.getParameter("field_tdesc"));//String:场地环境备注		
		
		int success=0;
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try{
			sc.startTransaction();
			sc.update("Safecheck.updateTBuilding",tBuilding);
			sc.update("Safecheck.updateTBuildingSafe",tBuildingSafe);
			sc.update("Safecheck.updateTInvmBase",tInvmBase);
			sc.update("Safecheck.updateTInvmField",tInvmField);
			//修改日志
			ra.operate.setOperateModule("修改检查信息：楼幢编号"+building_id);
			ra.operate.setOperateContent(opcontent.toString());
			ra.operate.setOperateType("修改");
			sc.commitTransaction();			
			success=1;
		}catch (Exception e) {
			success=0;
			throw e;
		}finally{
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}

}
