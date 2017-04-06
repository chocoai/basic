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

public class CityProjectSurveyTj extends BaseAction implements IGet{
	/**
	 * 类说明：全市测绘按年套数统计
	 * @创建时间：2014年4月22日
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
		
		Map param=new HashMap();

		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
		
		List survertype=(List)sc.queryForList("Realtygis.getCityBuildingSurverType");//获取统计测绘类型
		map.put("survertype",survertype );
		
		//按年查询
		if(null!=surverStartDate&&!"".equals(surverStartDate)&&null!=surverEndDate&&!"".equals(surverEndDate)){
			List yearList=new ArrayList();
			for(int k=Integer.parseInt(surverStartDate);k<=Integer.parseInt(surverEndDate);k++){
				yearList.add(k);
			}
			map.put("yearList",yearList );
			
			param.put("surverStartDate",surverStartDate );
			param.put("surverEndDate",surverEndDate );
			List yearResult=(List)sc.queryForList("Realtygis.getCityProjectSurveyYeartj", param);//从数据库中按年获取全市的各测绘类型的套数
//			for(int i=0;i<yearResult.size();i++){
//				Map m=(Map) yearResult.get(i);
//				System.out.println("----count----"+m.get("COUNT")+"----YEAR--"+m.get("YEAR")+"---SURVERTYPE---"+m.get("SURVERTYPE"));
//			}
			
			//循环年份
			List relist=new ArrayList();
			for(int i=0;i<survertype.size();i++){
				Map typeMap=new HashMap();
				typeMap.put("SURVERTYPE", survertype.get(i));
				List typeList=new ArrayList();
				for(int k=Integer.parseInt(surverStartDate);k<=Integer.parseInt(surverEndDate);k++){
					int a=0;
					for(int j=0;j<yearResult.size();j++){
						Map m=(Map) yearResult.get(j);
						BigDecimal bd=(BigDecimal) m.get("SURVERTYPE");
						
						if((bd.intValue())==((Integer)survertype.get(i))&&m.get("YEAR").equals(k+"")){
							if(m.get("COUNT")!=null&&!"".equals(m.get("COUNT"))){
								typeList.add(m);
							}else{
								Map tempMap=new HashMap();
								tempMap.put("YEAR", k);
								tempMap.put("COUNT", 0);
								typeList.add(tempMap);
							}
							break;
						}else{
							a++;
						}
					}
					if(a==yearResult.size()){
						Map tempMap=new HashMap();
						tempMap.put("YEAR", k);
						tempMap.put("COUNT", 0);
						typeList.add(tempMap);
					}
				}
				typeMap.put("TYPELIST", typeList);
				relist.add(typeMap);
			}
			
			map.put("relist", relist);
			
		}
		
		return new DataAndView<Map>(map, "map");
}
}