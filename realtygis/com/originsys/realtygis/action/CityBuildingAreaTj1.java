package com.originsys.realtygis.action;

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

public class CityBuildingAreaTj1 extends BaseAction implements IGet{
	/**
	 * 类说明：全市历年完成的房屋建筑面积的统计(演示用)
	 * @创建时间：2014年4月8日
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
		param.put("surverStartDate",surverStartDate );
		param.put("surverEndDate",surverEndDate );
		
		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
				
		List surverarea=(List)sc.queryForList("Realtygis.getCityBuildingAreatj1", param);//从数据库中按年按测绘类型获取全市的测绘面积
		
		List surverareatj=new ArrayList();
		for(int i=Integer.parseInt(surverStartDate),j=0;i<=Integer.parseInt(surverEndDate);i++){
			if(j<surverarea.size()){
				Map m=(HashMap) surverarea.get(j);
				if(m.get("YEAR").equals(i+"")){
					if(m.get("AREA")!=null&&!"".equals(m.get("AREA"))){
						surverareatj.add(m);
					}else{
						Map tempMap=new HashMap();
						tempMap.put("YEAR", i);
						tempMap.put("AREA", 0);
						surverareatj.add(tempMap);
					}
					j++;
				}else{
					Map tempMap=new HashMap();
					tempMap.put("YEAR", i);
					tempMap.put("AREA", 0);
					surverareatj.add(tempMap);
				}
			}else{
				Map tempMap=new HashMap();
				tempMap.put("YEAR", i);
				tempMap.put("AREA", 0);
				surverareatj.add(tempMap);
			}
		}
		
		map.put("surverareatj", surverareatj);	
		
		
		
		return new DataAndView<Map>(map, "map");
}
}