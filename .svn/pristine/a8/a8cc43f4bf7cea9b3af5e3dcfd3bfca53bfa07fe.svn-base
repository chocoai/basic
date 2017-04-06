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

public class DistrictBuildingAreaTj extends BaseAction implements IGet{
	/**
	 * 类说明：各区县按年建筑面积统计
	 * @创建时间：2014年4月9日
	 * @作者：zhanglf
	 */
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {	
		String type=ra.getParameter("type");
		String surverStartDate=ra.getParameter("surverStartDate");
		String surverEndDate=ra.getParameter("surverEndDate");
		Map map=new HashMap();
		map.put("type",type );
		map.put("surverStartDate",surverStartDate );
		map.put("surverEndDate",surverEndDate );
		
		Map param=new HashMap();
		param.put("surverStartDate",surverStartDate );
		param.put("surverEndDate",surverEndDate );
		
		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
			
		List survertype=(List)sc.queryForList("Realtygis.getCityBuildingSurverType");//获取测绘类型
		
		List tmpResult=(List)sc.queryForList("Realtygis.getDistrictBuildingAreatj", param);//从数据库中按年获取各区县的面积

		List relist=new ArrayList();
		for(int i=0;i<survertype.size();i++){
			List tmpList=new ArrayList();
			Map tmpMap=new HashMap();
			tmpMap.put("SURVERTYPE", survertype.get(i));
			for(int j=0;j<tmpResult.size();j++){
				Map m=(Map) tmpResult.get(j);
				BigDecimal bd=(BigDecimal) m.get("SURVERTYPE");
				if((bd.intValue())==((Integer)survertype.get(i))){
					tmpList.add(m);
				}
			}
			tmpMap.put("typelist", tmpList);
			relist.add(tmpMap);
		}
		
		map.put("survertype", survertype);		
		map.put("relist", relist);	
		
		
		return new DataAndView<Map>(map, "map");
}
}