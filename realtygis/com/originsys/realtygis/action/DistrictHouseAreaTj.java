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

public class DistrictHouseAreaTj extends BaseAction implements IGet{
	/**
	 * 类说明：各区县按年建筑面积统计
	 * @创建时间：2014年4月26日
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

		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
		
		List survertype=(List)sc.queryForList("Realtygis.getCityBuildingSurverType");//获取测绘类型
		map.put("survertype", survertype);	
		//获取所有区县
		List district=(List)sc.queryForList("Realtygis.getDistrict");
		map.put("district",district);
		
		if(null!=surverStartDate&&!"".equals(surverStartDate)&&null!=surverEndDate&&!"".equals(surverEndDate)){
			param.put("surverStartDate",surverStartDate );
			param.put("surverEndDate",surverEndDate );
			
			List tmpResult=(List)sc.queryForList("Realtygis.getDistrictHouseAreatj", param);//从数据库中按年获取各区县的面积
//			for(int i=0;i<tmpResult.size();i++){
//				Map m=(Map) tmpResult.get(i);
//				System.out.println("---area---"+m.get("AREA")+"---type---"+m.get("SURVERTYPE")+"---year---"+m.get("YEAR")+"---district---"+m.get("DISTRICT"));
//			}
			
			int yearre=0;
			List relist=new ArrayList();
			for(int i=0;i<survertype.size();i++){//循环类型
				Map typeMap=new HashMap();
				typeMap.put("SURVERTYPE", survertype.get(i));
				List typeList=new ArrayList();
				for(int k=Integer.parseInt(surverStartDate);k<=Integer.parseInt(surverEndDate);k++){//循环年
					Map districtMap=new HashMap();
					districtMap.put("YEAR", k);
					List districtList=new ArrayList();
					for(int j=0;j<district.size();j++){//循环区县
						if(yearre<tmpResult.size()){
							Map m=(Map) tmpResult.get(yearre);//取查询到的结果
							BigDecimal bd=(BigDecimal) m.get("SURVERTYPE");
							BigDecimal dist=(BigDecimal) m.get("DISTRICT");
							
							if((bd.intValue())==((Integer)survertype.get(i))&&m.get("YEAR").equals(k+"")&&(dist.intValue())==((Integer)district.get(j))){
								if(m.get("AREA")!=null&&!"".equals(m.get("AREA"))){
									Map tempMap=new HashMap();
									tempMap.put("DISTRICT", district.get(j));
									tempMap.put("AREA", m.get("AREA"));
									districtList.add(tempMap);
								}else{
									Map tempMap=new HashMap();
									tempMap.put("DISTRICT", district.get(j));
									tempMap.put("AREA", 0);
									districtList.add(tempMap);
								}
								yearre++;
							}else{
								Map tempMap=new HashMap();
								tempMap.put("DISTRICT", district.get(j));
								tempMap.put("AREA", 0);
								districtList.add(tempMap);
							}
						}else{
							Map tempMap=new HashMap();
							tempMap.put("DISTRICT", district.get(j));
							tempMap.put("AREA", 0);
							districtList.add(tempMap);
						}
						
					}
					districtMap.put("districtList", districtList);
					typeList.add(districtMap);
				}
				typeMap.put("typeList", typeList);
				relist.add(typeMap);
			}
//			for(int a=0;a<relist.size();a++){
//				Map a1=(Map) relist.get(a);
//				System.out.println("---type---"+a1.get("SURVERTYPE"));
//				List a2=(List) a1.get("typeList");
//				for(int b=0;b<a2.size();b++){
//					Map b1=(Map) a2.get(b);
//					System.out.println("---year---"+b1.get("YEAR"));
//					List b2=(List) b1.get("districtList");
//					for(int c=0;c<b2.size();c++){
//						Map c1=(Map) b2.get(c);
//						System.out.println("---areA---"+c1.get("AREA")+"---distric---"+c1.get("DISTRICT"));
//					}
//				}
//			}
			
			map.put("relist", relist);

		}
			
		return new DataAndView<Map>(map, "map");
}
}