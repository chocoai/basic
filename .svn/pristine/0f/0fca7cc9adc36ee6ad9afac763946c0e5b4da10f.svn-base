package com.originsys.safemanage.safecheck.action;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONObject;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuilding;
import com.originsys.safemanage.domain.TBuildingSurvey;

public class submitPuchaForAndroid extends BaseAction implements IData {

	@Override
	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String state = "";
		//String username = ra.getParameter("mem_name");
		//String password = ra.getParameter("mem_pass");
		//记录操作日志
		ra.operate.setOperateModule("Android客户端提交普查信息");
		//ra.operate.setOperateContent("用户:"+username+"登录");
		
		String address = ra.getParameter("address");
		String smuserid = ra.getParameter("smuserid");
		String newaddress = ra.getParameter("newaddress");
		String county = ra.getParameter("county");	
		String fuzeren = ra.getParameter("fuzeren");
		String paicharen = ra.getParameter("paicharen");	
		String imgpath = ra.getParameter("imgpath");
		String datetime = ra.getParameter("datetime");	
		String issame = ra.getParameter("issame");	
		
		String build_area = ra.getParameter("build_area");	
		String set_num = ra.getParameter("set_num");
		String floor_num_a = ra.getParameter("floor_num_a");	
		String floor_num_b = ra.getParameter("floor_num_b");	
		
		/**楼幢基本信息*/
		TBuilding tBuilding=new TBuilding();
		tBuilding.setBuilding_id(smuserid);//Integer:楼幢编号图斑编号sm_id
		//tBuilding.setHealth_grade_pc(ra.getParameter("building_safecondition"));//String:健康等级-普查@1-a级&2-b级&3-c级&4-d级
		//tBuilding.setDangerous_type_pc(ra.getParameter("building_safecondition"));//String:危房类型-普查 无危险点房屋1 存在危险点2 局部危险3 整幢危险4
		
		/**楼幢普查结果信息*/
		TBuildingSurvey tBuildingSurvey=new TBuildingSurvey();
		tBuildingSurvey.setBuilding_id(smuserid);
		tBuildingSurvey.setBuilding_address(address);
		if(issame.equals("1")){
			tBuildingSurvey.setBuilding_newaddress(newaddress);
			tBuildingSurvey.setIssame("0");//是否一致@0-否&1-是
		}else{
			tBuildingSurvey.setBuilding_newaddress(address);
			tBuildingSurvey.setIssame("1");//是否一致@0-否&1-是
		}
		tBuildingSurvey.setBuilding_region(county);
		tBuildingSurvey.setManager_name(fuzeren);
		tBuildingSurvey.setSurvey_name(paicharen);
		tBuildingSurvey.setFloorup_count(Integer.parseInt(floor_num_a));
		tBuildingSurvey.setFloordown_count(Integer.parseInt(floor_num_b));
		tBuildingSurvey.setBuild_area(Float.parseFloat(build_area));
		tBuildingSurvey.setHouse_count(Integer.parseInt(set_num));
		
		if(datetime!=null && !"".equals(datetime)){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			tBuildingSurvey.setSurvey_date(sdf.parse(datetime));//排查时间
		}
		if("zc".equals(ra.getParameter("op")))
			tBuildingSurvey.setInfo_state("0");//String:暂存 0   未审核1    审核驳回2     审核通过8 
		else{
			tBuildingSurvey.setInfo_state("1");//String:暂存 0   未审核1    审核驳回2     审核通过8 
		}
		
		
		SqlMapClient sc = DataSource.getSqlMapInstance();
		try {
			sc.startTransaction();
			//sc.update("Safecheck.updateTBuilding",tBuilding);
			int num = (Integer)sc.queryForObject("Safecheck.getSurveyCount", smuserid);
			if(num>0){//存在，执行update
				sc.update("Safecheck.updateTBuildingSurvey",tBuildingSurvey);
				//修改日志
				ra.operate.setOperateModule("修改普查信息：楼幢编号"+smuserid+" 座落："+address);
				//ra.operate.setOperateContent(opcontent.toString());
				ra.operate.setOperateType("修改");
			}else{//不存在，执行insert
				tBuildingSurvey.setReport_userid(ra.getUser().getMem_id());//String:信息填写人
				System.out.println("mem_name: "+ra.getUser().getMem_name()+" memid:"+ra.getUser().getMem_id());
				sc.insert("Safecheck.addTBuildingSurvey", tBuildingSurvey);
				//修改日志
				ra.operate.setOperateModule("增加普查信息：楼幢编号"+smuserid+" 座落："+address);
				//ra.operate.setOperateContent(opcontent.toString());
				ra.operate.setOperateType("增加");
			}
			
			sc.commitTransaction();
			state="SUCC";
		} catch (Exception e) {
			state="FAIL";
		}finally{
			sc.endTransaction();
		}
		
		response.setContentType("text/html; charset=GBK");
		
		// 输出json对象
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("result" , state);
		String result = jsonObj.toString();
		//输出json数组
//		ArrayList list = new ArrayList<List>();
//		JSONArray jArray = JSONArray.fromObject(list);
//		jArray.toString();
//		String result = jArray.toString();
		
		// 输出响应
		response.getWriter().println(result);
	}

}
