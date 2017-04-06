package com.originsys.safemanage.safecheck.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-7-28
   描述：7.	房屋楼层统计图（饼状图）
整个饼状图代表普查总数，统计平房、低层、多层、小高层和高层的数据情况，一般来说1-3层称低层、4-7层为多层、8-12层为小高层、12层以上为高层。
层数是0或是空的为其他
 */
public class SurveyFloorupCountTJ extends BaseAction implements IGet{

	public DataAndView execute(RequestAction arg0) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		List tmpResult=(List)sc.queryForList("Safecheck.getSurveyFloorupCountTj");
		List linkResult=(List)sc.queryForList("Safecheck.getSurveyFloorupMembersTj");
		ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("safecheck");
		String map_url=rb.getString("map_url");
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("datalist",tmpResult);
		remap.put("linkdatalist", linkResult);
		remap.put("map_url", map_url);
		return new DataAndView(remap,"block");
	}

}
