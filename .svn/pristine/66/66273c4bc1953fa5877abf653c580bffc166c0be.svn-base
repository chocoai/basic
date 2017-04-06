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

public class DistrictSurveyUsedesignTj extends BaseAction implements IGet{
	/**
	 * 类说明：各区县历年测绘按设计用途测绘套数统计
	 * @创建时间：2014年3月23日
	 * @作者：zhanglf
	 */
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {	
		String type=ra.getParameter("type");
		String surverStartDate=ra.getParameter("surverStartDate");
		String surverEndDate=ra.getParameter("surverEndDate");
		Map map=new HashMap();
		map.put("type",type );
		
		List resultlist = new ArrayList();
		
		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
		//获取设计类型列表
		List usedesign=(List)sc.queryForList("Realtygis.getUseDesign");
		map.put("usedesign",usedesign);	
		//获取所有区县
		List district=(List)sc.queryForList("Realtygis.getDistrict");
		map.put("district",district);	
		
		Map param=new HashMap();
		
		//循环设计类型列表
		for(int i=0;i<usedesign.size();i++){
//			System.out.println("====usedesign-----"+usedesign.get(i));
			if(usedesign.get(i)!=null&&!"".equals(usedesign.get(i))){
				Map tmp=new HashMap();
				tmp.put("USEDESIGN", usedesign.get(i)+"");
				param.put("usedesign", usedesign.get(i));
				List yearlist=new ArrayList();
				
				//循环遍历查询的年区间
				for(int j=Integer.parseInt(surverStartDate);j<=Integer.parseInt(surverEndDate);j++){
					param.put("surverDate",j+"" );
					List templist=(List)sc.queryForList("Realtygis.getDistrictSurveyUsedesigntj", param);//从数据库中查询该年该类型的套数
//					System.out.println("---listcount=="+templist.size());
					Map yearMap = new HashMap();
					yearMap.put("YEAR", j);
					List relist = new ArrayList();
					//组织数据
					for(int m=0,n=0;m<district.size();m++){
						if(n<templist.size()){
							Map tpmap=(HashMap) templist.get(n);
							BigDecimal bd=(BigDecimal) tpmap.get("DISTRICT");
							
							if((bd.intValue())==((Integer)district.get(m))){
								if(tpmap.get("COUNT")!=null&&!"".equals(tpmap.get("COUNT"))){
//									System.out.println("--m---"+district.get(m)+"---year---"+j+"---count---"+tpmap.get("COUNT"));
									relist.add(tpmap);
								}else{
									Map tempMap=new HashMap();
									tempMap.put("DISTRICT", district.get(m));
									tempMap.put("COUNT", 0);
									relist.add(tempMap);
								}
								n++;
							}else{
								Map tempMap=new HashMap();
								tempMap.put("DISTRICT", district.get(m));
								tempMap.put("COUNT", 0);
								relist.add(tempMap);
							}
						}else{
							Map tempMap=new HashMap();
							tempMap.put("DISTRICT", district.get(m));
							tempMap.put("COUNT", 0);
							relist.add(tempMap);
						}
					}
					yearMap.put("districtlist", relist);
					yearlist.add(yearMap);
				}
				tmp.put("yearlist",yearlist);
				resultlist.add(tmp);
			}
		}
		
		map.put("resultlist", resultlist);
//		for(int i=0;i<resultlist.size();i++){
//			Map m1=(Map) resultlist.get(i);
//			System.out.println("----USEDESIGN----"+m1.get("USEDESIGN"));
//			List l1=(List) m1.get("yearlist");
//			for(int j=0;j<l1.size();j++){
//				Map m2=(Map) l1.get(j);
//				System.out.println("======year-----"+m2.get("YEAR"));
//				List l2=(List) m2.get("districtlist");
//				for(int k=0;k<l2.size();k++){
//					Map m3=(Map) l2.get(k);
//					System.out.println("-----district----"+m3.get("DISTRICT")+"-----count----"+m3.get("COUNT"));
//				}
//			}
//				
//		}
		

		return new DataAndView<Map>(map, "map");
}
}