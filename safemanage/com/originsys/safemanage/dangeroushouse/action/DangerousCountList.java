package com.originsys.safemanage.dangeroushouse.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-6-17
   描述：危房统计查询
 */
public class DangerousCountList extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		/**需要汇总的分类*/
		List<String> list=new ArrayList<String>();
		list.add("sjyt");//设计用途
		list.add("fwjg");//房屋结构
		list.add("fwcb");//房屋产别
		SqlMapClient sc=DataSource.getSqlMapInstance();
		/**查询汇总条件*/
		Map<String,String> term=new HashMap<String,String>();
		if(ra.getParameter("region_id")!=null&&!"".equals(ra.getParameter("region_id"))){
			term.put("building_region", ra.getParameter("region_id"));
		}
		term.put("ctype", ra.getParameter("ctype"));
		/**返回的Map*/
		Map<String,Object> remap=new HashMap<String,Object>();
		/**循环需要汇总的大类*/
		for(String dfl:list){
			term.put("enum_id", dfl);
			List<HashMap> temp=sc.queryForList("safeauth.getDangerousCountList", term);
			remap.put(dfl, temp);
		}
		remap.put("term", term);
		return new DataAndView(remap,"block");
	}

}
