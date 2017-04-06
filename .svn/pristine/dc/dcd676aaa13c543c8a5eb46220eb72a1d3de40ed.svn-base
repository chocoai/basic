package com.originsys.safemanage.safecheck.action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;

import com.originsys.eap.util.RequestAction;

import com.originsys.safemanage.domain.TBuildingSurvey;

public class SurveyRecordDetail extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		Map<String,Object> remap=new HashMap<String,Object>();//返回值
		/**根据楼幢编号查询详细信息*/
		String building_id=ra.getParameter("building_id");
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		List<TBuildingSurvey> surveyList=(List<TBuildingSurvey>)sc.queryForList("Safecheck.getSurveyMxList1",building_id);		
		//增加返回对象
		remap.put("surveyList", surveyList);//楼幢普查列表	
		
		return new DataAndView(remap,"block");
	}

}


