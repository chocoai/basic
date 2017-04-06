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

public class CityProjectSurveyJdTj extends BaseAction implements IGet{
	/**
	 * 类说明：全市测绘按季度套数统计
	 * @创建时间：2014年4月23日
	 * @作者：zhanglf
	 */
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {	
		String type=ra.getParameter("type");
		String surverStartDate=ra.getParameter("surverStartDate");//开始年份
		String surverEndDate=ra.getParameter("surverEndDate");//结束年份
		String both=ra.getParameter("both");
		String jd1=ra.getParameter("jd1");//开始年份的季度
		String jd2=ra.getParameter("jd2");//结束年份的季度
//		System.out.println("type:"+type+"--surverStartDate:"+surverStartDate+"--surverEndDate:"+surverEndDate+"--jd1:"+jd1+"---jd2---"+jd2);
		Map map=new HashMap();
		map.put("type",type );	
		
		Map param=new HashMap();

		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
		
		List survertype=(List)sc.queryForList("Realtygis.getCityBuildingSurverType");//获取统计测绘类型
		map.put("survertype",survertype );
		
		//按年查询
		if(null!=surverStartDate&&!"".equals(surverStartDate)&&null!=surverEndDate&&!"".equals(surverEndDate)){
			//组织季度的查询条件第一季度01-03，第二季度04-06，第三季度07-09，第四季度10-12（从开始年份开始季度的第一个月到结束年份的结束季度的最后一个月）
			String month="";
			switch(Integer.parseInt(jd1)){
				case 1:month=surverStartDate+"-01";break;
				case 2:month=surverStartDate+"-04";break;
				case 3:month=surverStartDate+"-07";break;
				case 4:month=surverStartDate+"-10";break;
			}
			String month2="";
			switch(Integer.parseInt(jd2)){
				case 1:month2=surverEndDate+"-03";break;
				case 2:month2=surverEndDate+"-06";break;
				case 3:month2=surverEndDate+"-09";break;
				case 4:month2=surverEndDate+"-12";break;
			}
			
			param.put("surverStartDate",month );
			param.put("surverEndDate",month2 );
			List yearResult=(List)sc.queryForList("Realtygis.getCityProjectSurveyJdtj", param);//从数据库中按季度获取全市的各测绘类型的套数
//			for(int i=0;i<yearResult.size();i++){
//				Map m=(Map) yearResult.get(i);
//				System.out.println("----count----"+m.get("COUNT")+"----SURVERYEAR--"+m.get("SURVERYEAR")+"---SURVERTYPE---"+m.get("SURVERTYPE")+"----jd---"+m.get("SURVERJD"));
//			}
			
			int yearmonthre=0;
			List relist=new ArrayList();//存放最终返回的结果
			for(int i=0;i<survertype.size();i++){
				Map typeMap=new HashMap();
				typeMap.put("SURVERTYPE", survertype.get(i));
				List typeList=new ArrayList();//存放每种类型对应的列表数据
				//判断开始和结束的年份，情况一：同一年，情况二：非同年
				if(surverStartDate.equals(surverEndDate)){//同年
					for(int k=Integer.parseInt(jd1);k<=Integer.parseInt(jd2);k++){
						if(yearmonthre<yearResult.size()){
							Map m=(Map) yearResult.get(yearmonthre);
							BigDecimal bd=(BigDecimal) m.get("SURVERTYPE");
							
							if((bd.intValue())==((Integer)survertype.get(i))&&m.get("SURVERYEAR").equals(surverStartDate)&&m.get("SURVERJD").equals(k+"")){
								if(m.get("COUNT")!=null&&!"".equals(m.get("COUNT"))){
									Map tempMap=new HashMap();
									tempMap.put("YEARJD", surverStartDate+"年 第"+k+"季度");
									tempMap.put("COUNT", m.get("COUNT"));
									typeList.add(tempMap);
								}else{
									Map tempMap=new HashMap();
									tempMap.put("YEARJD", surverStartDate+"年 第"+k+"季度");
									tempMap.put("COUNT", 0);
									typeList.add(tempMap);
								}
								yearmonthre++;
							}else{
								Map tempMap=new HashMap();
								tempMap.put("YEARJD", surverStartDate+"年 第"+k+"季度");
								tempMap.put("COUNT", 0);
								typeList.add(tempMap);
							}
						}else{
							Map tempMap=new HashMap();
							tempMap.put("YEARJD", surverStartDate+"年 第"+k+"季度");
							tempMap.put("COUNT", 0);
							typeList.add(tempMap);
						}
					}
				}else{//非同年
					for(int j=Integer.parseInt(surverStartDate);j<=Integer.parseInt(surverEndDate);j++){
						//循环年。三种情况：1、起始年 2、大于起始年，小于结束年 3、结束年
						if(j==Integer.parseInt(surverStartDate)){//起始年
							for(int k=Integer.parseInt(jd1);k<=4;k++){
								Map m=(Map) yearResult.get(yearmonthre);
								BigDecimal bd=(BigDecimal) m.get("SURVERTYPE");
								
								if((bd.intValue())==((Integer)survertype.get(i))&&m.get("SURVERYEAR").equals(j+"")&&m.get("SURVERJD").equals(k+"")){
									if(m.get("COUNT")!=null&&!"".equals(m.get("COUNT"))){
										Map tempMap=new HashMap();
										tempMap.put("YEARJD", j+"年 第"+k+"季度");
										tempMap.put("COUNT", m.get("COUNT"));
										typeList.add(tempMap);
									}else{
										Map tempMap=new HashMap();
										tempMap.put("YEARJD", j+"年 第"+k+"季度");
										tempMap.put("COUNT", 0);
										typeList.add(tempMap);
									}
									yearmonthre++;
								}else{
									Map tempMap=new HashMap();
									tempMap.put("YEARJD", j+"年 第"+k+"季度");
									tempMap.put("COUNT", 0);
									typeList.add(tempMap);
								}
							}
						}else if(j>Integer.parseInt(surverStartDate)&&j<Integer.parseInt(surverEndDate)){
							for(int k=1;k<=4;k++){
								Map m=(Map) yearResult.get(yearmonthre);
								BigDecimal bd=(BigDecimal) m.get("SURVERTYPE");
								
								if((bd.intValue())==((Integer)survertype.get(i))&&m.get("SURVERYEAR").equals(j+"")&&m.get("SURVERJD").equals(k+"")){
									if(m.get("COUNT")!=null&&!"".equals(m.get("COUNT"))){
										Map tempMap=new HashMap();
										tempMap.put("YEARJD", j+"年 第"+k+"季度");
										tempMap.put("COUNT", m.get("COUNT"));
										typeList.add(tempMap);
									}else{
										Map tempMap=new HashMap();
										tempMap.put("YEARJD", j+"年 第"+k+"季度");
										tempMap.put("COUNT", 0);
										typeList.add(tempMap);
									}
									yearmonthre++;
								}else{
									Map tempMap=new HashMap();
									tempMap.put("YEARJD", j+"年 第"+k+"季度");
									tempMap.put("COUNT", 0);
									typeList.add(tempMap);
								}
							}
						}else{
							for(int k=1;k<=Integer.parseInt(jd2);k++){
								Map m=(Map) yearResult.get(yearmonthre);
								BigDecimal bd=(BigDecimal) m.get("SURVERTYPE");
								
								if((bd.intValue())==((Integer)survertype.get(i))&&m.get("SURVERYEAR").equals(j+"")&&m.get("SURVERJD").equals(k+"")){
									if(m.get("COUNT")!=null&&!"".equals(m.get("COUNT"))){
										Map tempMap=new HashMap();
										tempMap.put("YEARJD", j+"年 第"+k+"季度");
										tempMap.put("COUNT", m.get("COUNT"));
										typeList.add(tempMap);
									}else{
										Map tempMap=new HashMap();
										tempMap.put("YEARJD", j+"年 第"+k+"季度");
										tempMap.put("COUNT", 0);
										typeList.add(tempMap);
									}
									yearmonthre++;
								}else{
									Map tempMap=new HashMap();
									tempMap.put("YEARJD", j+"年 第"+k+"季度");
									tempMap.put("COUNT", 0);
									typeList.add(tempMap);
								}
							}
						}
						
					}

				}
//				System.out.println("----type-----"+typeMap.get("SURVERTYPE"));
//				for(int a=0;a<typeList.size();a++){
//					Map mmm=(Map) typeList.get(a);
//					System.out.println("----count----"+mmm.get("COUNT")+"----yearmonth----"+mmm.get("YEARJD"));
//				}
				
				typeMap.put("TYPELIST", typeList);
				relist.add(typeMap);
			}
			
			map.put("relist", relist);
			
		}	
			
		return new DataAndView<Map>(map, "map");
}
}