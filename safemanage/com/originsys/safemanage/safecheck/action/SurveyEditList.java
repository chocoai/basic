package com.originsys.safemanage.safecheck.action;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuildingSurvey;
import com.originsys.safemanage.domain.TSafeCensor;

/**
 auth:zhanglf 2014-5-27
   描述:楼幢普查列表（检查员）
 */
public class SurveyEditList extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String building_address=ra.getParameter("building_address");
		String use_desgin=ra.getParameter("use_desgin");
	//	String building_date=ra.getParameter("building_date");
		String build_struct=ra.getParameter("build_struct");
		String manage_type=ra.getParameter("manage_type");
		String building_properties=ra.getParameter("building_properties");
		String building_safecondition=ra.getParameter("building_safecondition");
		String info_state=ra.getParameter("info_state");
		String last_editor=ra.getParameter("last_editor");
		String survey_date=ra.getParameter("survey_date");
		String survey_type=ra.getParameter("survey_type");
		/**组织查询条件对象*/
		TBuildingSurvey tBuildingSurvey=new TBuildingSurvey();
		if(null!=building_address&&!"".equals(building_address)){
			tBuildingSurvey.setBuilding_address(building_address);
		}
		if(null!=use_desgin&&!"".equals(use_desgin)){
			tBuildingSurvey.setUse_desgin(use_desgin);
		}
//		if(null!=building_date&&!"".equals(building_date)){
//			tBuildingSurvey.setBuilding_date(Integer.parseInt(building_date));
//		}
		if(null!=build_struct&&!"".equals(build_struct)){
			tBuildingSurvey.setBuild_struct(build_struct);
		}
		if(null!=manage_type&&!"".equals(manage_type)){
			tBuildingSurvey.setManage_type(manage_type);
		}
		if(null!=building_properties&&!"".equals(building_properties)){
			tBuildingSurvey.setBuilding_properties(building_properties);
		}
		if(null!=building_safecondition&&!"".equals(building_safecondition)){
			tBuildingSurvey.setBuilding_safecondition(building_safecondition);
		}
		if(null!=info_state&&!"".equals(info_state)){
			tBuildingSurvey.setInfo_state(info_state);
		}
		if(null!=last_editor&&!"".equals(last_editor)){
			tBuildingSurvey.setLast_editor(last_editor);
		}
		if(null!=survey_date&&!"".equals(survey_date)){
			tBuildingSurvey.setSurvey_date(sdf.parse(survey_date));
		}
		if(null!=survey_type&&!"".equals(survey_type)){
			tBuildingSurvey.setSurvey_type(survey_type);
		}
		//获取当前登录用户的mem_id
		String mem_id=ra.getUser().getMem_id();
		
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		
//		List roles=(List)sc.queryForList("Safecheck.getRoles", mem_id);
		List roles=ra.getUser().getRoleList();
		for(int i=0;i<roles.size();i++){
			this.log().debug("角色"+(i+1)+":"+roles.get(i));
			if("surveychecker".equals(roles.get(i))||"safepc".equals(roles.get(i))){//检查员
				tBuildingSurvey.setReport_userid(mem_id);
				break;
			}else if("surveymanager".equals(roles.get(i))){//管理员
				break;
			}else if("surveyregionmanager".equals(roles.get(i))){//区县管理员
				//获取当前登录用户管理的区域
				String region=(String)sc.queryForObject("Safecheck.getBuildingSafeManageRegion", mem_id);
				if(region!=null&&!"".equals(region)){
					tBuildingSurvey.setBuilding_region(region);//该用户有管理的区域
				}
				break;
			}
		}
		
		//获得起始条数
		int start=0;
		//获得每页显示的条数
		int pageNum=10;
		if(ra.getParameter("rows")!=null){
			pageNum=Integer.parseInt(ra.getParameter("rows"));
		}
		else{
			pageNum=10;
		}
		pageNum=(pageNum==0)?10:pageNum;
		//获取总条数
		int totalnum=(Integer)sc.queryForObject("Safecheck.getSurveyEditListCount", tBuildingSurvey);
		//获得总页数
		int totalpage=totalnum%pageNum==0?totalnum/pageNum:(totalnum/pageNum+1);		
		//获得当前页
		String currentPage=ra.getParameter("page");
		int currentNum=1;
		if(currentPage!=null && !"".equals(currentPage)){
			currentNum=Integer.parseInt(currentPage);
		}
		//重新设置起始条数
		start=(currentNum-1)*pageNum;
		int end = currentNum*pageNum;
		//排序字段+排序方式
		String sortname=ra.getParameter("sidx");
		if(sortname==null||"".equals(sortname)){
					sortname="building_id";
		}
		String sortorder= ra.getParameter("sord");
		if(sortorder==null||"".equals(sortorder)){
			sortorder="asc";
		}
		//定义参数
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("_page_start", start);
		param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
		param.put("_page_end", end);//该参数是为Oracle数据库准备的
		param.put("_sortname", sortname);
		param.put("_sortorder", sortorder);
		param.put("tBuildingSurvey", tBuildingSurvey);	  
		//查询结果
		List<TBuildingSurvey> resultList=(List<TBuildingSurvey>)sc.queryForList("Safecheck.getSurveyEditList", param);
		Page page=new Page(totalpage,currentNum,totalnum);
		Map resultMap=new HashMap();
		resultMap.put("page", page);
		resultMap.put("resultList", resultList);
		return new DataAndView(resultMap,"block");
	}

}
