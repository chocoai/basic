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

public class DistrictBuildingAreaTj1 extends BaseAction implements IGet{
	/**
	 * 类说明：各区县按年实测绘建筑面积统计
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
		map.put("surverStartDate",surverStartDate );
		map.put("surverEndDate",surverEndDate );
		
		Map param=new HashMap();
		param.put("surverStartDate",surverStartDate );
		param.put("surverEndDate",surverEndDate );
		
		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
		
//		//获取所有区县
//		List district=(List)sc.queryForList("Realtygis.getAreaDistrict");//从数据库中获取各区县
//		map.put("district",district);		
		
		List tmpResult=(List)sc.queryForList("Realtygis.getDistrictBuildingAreatj1", param);//从数据库中按年获取各区县的面积
//		List tempArea=new ArrayList();
//		for(int j=0,k=0;j<district.size();j++){
//			//组织数据
//			if(k<tmpResult.size()){
//				Map m=(HashMap) tmpResult.get(k);
//				if(m.get("DISTRICT").equals(district.get(j)+"")){
//					if(m.get("AREA")!=null&&!"".equals(m.get("AREA"))){
//						tempArea.add(m);
//					}else{
//						Map n=new HashMap();
//						n.put("DISTRICT", district.get(j));
//						n.put("AREA", 0);
//						tempArea.add(n);
//					}						
//					k++;
//				}else{
//					Map n=new HashMap();
//					n.put("DISTRICT", district.get(j));
//					n.put("AREA", 0);
//					tempArea.add(n);
//				}	
//			}else{
//				Map n=new HashMap();
//				n.put("DISTRICT", district.get(j));
//				n.put("AREA", 0);
//				tempArea.add(n);
//			}
//		}
//		
//		
//		map.put("areatj", tempArea);		
		map.put("areatj", tmpResult);	
		
		return new DataAndView<Map>(map, "map");
}
}