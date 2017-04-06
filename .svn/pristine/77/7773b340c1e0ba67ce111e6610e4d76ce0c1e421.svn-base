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

public class DistrictProjectSurveyTj extends BaseAction implements IGet{
	/**
	 * 类说明：各区县按年预实测套数统计
	 * @创建时间：2014年3月20日
	 * @作者：zhanglf
	 */
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {	
		String type=ra.getParameter("type");
		String surverStartDate=ra.getParameter("surverStartDate");
		String surverEndDate=ra.getParameter("surverEndDate");
		String both=ra.getParameter("both");
//		System.out.println("type:"+type+"--surverStartDate:"+surverStartDate+"--surverEndDate:"+surverEndDate+"--both:"+both);
		Map map=new HashMap();
		map.put("type",type );
		
		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
		
		List survertype=(List)sc.queryForList("Realtygis.getCityBuildingSurverType");//获取统计测绘类型
		map.put("survertype",survertype );
		
		//获取所有区县
		List district=(List)sc.queryForList("Realtygis.getDistrict");
		map.put("district",district);		
		Map param=new HashMap();
		
		//按年查询
		if(null!=surverStartDate&&!"".equals(surverStartDate)&&null!=surverEndDate&&!"".equals(surverEndDate)){
			List yearList=new ArrayList();
			for(int k=Integer.parseInt(surverStartDate);k<=Integer.parseInt(surverEndDate);k++){
				yearList.add(k);
			}
			map.put("yearList",yearList );
			
			param.put("surverStartDate",surverStartDate );
			param.put("surverEndDate",surverEndDate );
			List yearResult=(List)sc.queryForList("Realtygis.getDistrictProjectSurveytj", param);//从数据库中按年获取各区县的各测绘类型的房屋套数
//			for(int i=0;i<yearResult.size();i++){
//				Map m=(Map) yearResult.get(i);
//				System.out.println("----count----"+m.get("COUNT")+"----YEAR--"+m.get("SURVERYEAR")+"---SURVERTYPE---"+m.get("SURVERTYPE")+"=---district--"+m.get("DISTRICT"));
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
						if(yearre<yearResult.size()){
							Map m=(Map) yearResult.get(yearre);
							BigDecimal bd=(BigDecimal) m.get("SURVERTYPE");
							BigDecimal dist=(BigDecimal) m.get("DISTRICT");
							
							if((bd.intValue())==((Integer)survertype.get(i))&&m.get("SURVERYEAR").equals(k+"")&&(dist.intValue())==((Integer)district.get(j))){
								if(m.get("COUNT")!=null&&!"".equals(m.get("COUNT"))){
									Map tempMap=new HashMap();
									tempMap.put("DISTRICT", district.get(j));
									tempMap.put("COUNT", m.get("COUNT"));
									districtList.add(tempMap);
								}else{
									Map tempMap=new HashMap();
									tempMap.put("DISTRICT", district.get(j));
									tempMap.put("COUNT", 0);
									districtList.add(tempMap);
								}
								yearre++;
							}else{
								Map tempMap=new HashMap();
								tempMap.put("DISTRICT", district.get(j));
								tempMap.put("COUNT", 0);
								districtList.add(tempMap);
							}
						}else{
							Map tempMap=new HashMap();
							tempMap.put("DISTRICT", district.get(j));
							tempMap.put("COUNT", 0);
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
//						System.out.println("---count---"+c1.get("COUNT")+"---distric---"+c1.get("DISTRICT"));
//					}
//				}
//			}
			
			map.put("relist", relist);
		}
		
		
		return new DataAndView<Map>(map, "map");
}
}