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

public class CitySurveyUsedesignTj extends BaseAction implements IGet{
	/**
	 * 类说明：全市历年测绘按设计用途测绘套数统计
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
		
		Map param=new HashMap();
		param.put("surverStartDate",surverStartDate );
		param.put("surverEndDate",surverEndDate );
		
		//循环设计类型列表，根据设计类型，按年获取房屋套数
		for(int i=0;i<usedesign.size();i++){
//			System.out.println("====usedesign-----"+usedesign.get(i));
			if(usedesign.get(i)!=null&&!"".equals(usedesign.get(i))){
				Map tmp=new HashMap();
				tmp.put("USEDESIGN", usedesign.get(i)+"");
				param.put("usedesign", usedesign.get(i));
				List relist = new ArrayList();
				List templist=(List)sc.queryForList("Realtygis.getCitySurveyUsedesigntj", param);//从数据库中按年查询该类型的套数
//				System.out.println("---listcount=="+templist.size());
				//循环遍历查询的年区间
				for(int j=Integer.parseInt(surverStartDate),m=0;j<=Integer.parseInt(surverEndDate);j++){
					//组织数据
					if(m<templist.size()){
						Map tpmap=(HashMap) templist.get(m);
						if(tpmap.get("YEAR").equals(j+"")){
							if(tpmap.get("COUNT")!=null&&!"".equals(tpmap.get("COUNT"))){
//								System.out.println("--m---"+m+"---year---"+tpmap.get("YEAR")+"---count---"+tpmap.get("COUNT"));
								relist.add(tpmap);
							}else{
								Map tempMap=new HashMap();
								tempMap.put("YEAR", j);
								tempMap.put("COUNT", 0);
								relist.add(tempMap);
							}
							m++;
						}else{
							Map tempMap=new HashMap();
							tempMap.put("YEAR", j);
							tempMap.put("COUNT", 0);
							relist.add(tempMap);
						}
					}else{
						Map tempMap=new HashMap();
						tempMap.put("YEAR", j);
						tempMap.put("COUNT", 0);
						relist.add(tempMap);
					}
				}
				tmp.put("usedesignlist", relist);
				resultlist.add(tmp);
			}
			
		}
		map.put("resultlist", resultlist);
		
//		for(int i=0;i<resultlist.size();i++){
//			Map m=(Map) resultlist.get(i);
//			System.out.println("----usedesign---"+m.get("USEDESIGN"));
//			List l=(List) m.get("usedesignlist");
//			for(int j=0;j<l.size();j++){
//				Map n=(Map) l.get(j);
//				System.out.println("----year==="+n.get("YEAR")+"----count----"+n.get("COUNT"));
//			}
//		}

		return new DataAndView<Map>(map, "map");
}
}