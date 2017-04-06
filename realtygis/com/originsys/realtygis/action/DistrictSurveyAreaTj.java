package com.originsys.realtygis.action;

import java.math.BigDecimal;
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
import com.originsys.realtygis.domain.HouseHeightRange;

public class DistrictSurveyAreaTj extends BaseAction implements IGet{
	/**
	 * 类说明：各区县按年基础测绘面积统计
	 * @创建时间：2014年3月24日
	 * @作者：zhanglf
	 */
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {	
		String type=ra.getParameter("type");
		String surverStartDate=ra.getParameter("surverStartDate");
		String surverEndDate=ra.getParameter("surverEndDate");
		Map map=new HashMap();
		map.put("type",type );
		
		Map param=new HashMap();
		List areatj=new ArrayList();
		
		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
		
		//获取所有区县
		List district=(List)sc.queryForList("Realtygis.getAreaDistrict");//从数据库中获取各区县
		map.put("district",district);		
		
		//循环遍历查询的年区间
		for(int i=Integer.parseInt(surverStartDate);i<=Integer.parseInt(surverEndDate);i++){
			param.put("surverbasic_createdate",i+"" );
			List tmpResult=(List)sc.queryForList("Realtygis.getDistrictSurveyAreatj", param);//从数据库中按年获取各区县的基础测绘面积
			Map tempMap=new HashMap();
			tempMap.put("YEAR", i);
			List tempArea=new ArrayList();
			for(int j=0,k=0;j<district.size();j++){
				//组织数据
				if(k<tmpResult.size()){
					Map m=(HashMap) tmpResult.get(k);
					if(m.get("DISTRICT").equals(district.get(j)+"")){
						if(m.get("AREA")!=null&&!"".equals(m.get("AREA"))){
							tempArea.add(m);
						}else{
							Map n=new HashMap();
							n.put("DISTRICT", district.get(j));
							n.put("AREA", 0);
							tempArea.add(n);
						}						
						k++;
					}else{
						Map n=new HashMap();
						n.put("DISTRICT", district.get(j));
						n.put("AREA", 0);
						tempArea.add(n);
					}	
				}else{
					Map n=new HashMap();
					n.put("DISTRICT", district.get(j));
					n.put("AREA", 0);
					tempArea.add(n);
				}
			}
			tempMap.put("AreaList", tempArea);
			areatj.add(tempMap);
		}
		
		map.put("areatj", areatj);		
		
		return new DataAndView<Map>(map, "map");
}
}