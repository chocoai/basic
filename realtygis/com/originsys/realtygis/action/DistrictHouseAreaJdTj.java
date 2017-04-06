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

public class DistrictHouseAreaJdTj extends BaseAction implements IGet{
	/**
	 * 类说明：各区县按季度房屋建筑面积统计
	 * @创建时间：2014年4月29日
	 * @作者：zhanglf
	 */
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {	
		String type=ra.getParameter("type");
		String surverStartDate=ra.getParameter("surverStartDate");//开始年份
		String surverEndDate=ra.getParameter("surverEndDate");//结束年份
		String jd1=ra.getParameter("jd1");//开始年份的季度
		String jd2=ra.getParameter("jd2");//结束年份的季度
//		System.out.println("type:"+type+"--surverStartDate:"+surverStartDate+"--surverEndDate:"+surverEndDate+"--jd1:"+jd1+"---jd2---"+jd2);
		Map map=new HashMap();
		map.put("type",type );
		
		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
		
		List survertype=(List)sc.queryForList("Realtygis.getCityBuildingSurverType");//获取统计测绘类型（枚举值为：chtjlx的）
		map.put("survertype",survertype );
		
		//获取所有区县
		List district=(List)sc.queryForList("Realtygis.getDistrict");
		map.put("district",district);		
		Map param=new HashMap();
		
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
			List yearResult=(List)sc.queryForList("Realtygis.getDistrictHouseAreaJdtj", param);//从数据库中按季度获取各区县的各测绘类型的房屋建筑面积
//			for(int i=0;i<yearResult.size();i++){
//				Map m=(Map) yearResult.get(i);
//				System.out.println("----AREA----"+m.get("AREA")+"----SURVERYEAR--"+m.get("SURVERYEAR")+"---SURVERTYPE---"+m.get("SURVERTYPE")+"----jd---"+m.get("SURVERJD")+"---district---"+m.get("DISTRICT"));
//			}
			
			int yearmonthre=0;
			List relist=new ArrayList();//存放最终返回的结果
			for(int i=0;i<survertype.size();i++){
				Map typeMap=new HashMap();
				typeMap.put("SURVERTYPE", survertype.get(i));
				List typeList=new ArrayList();//存放每种类型对应的列表数据
				//判断开始和结束的年份，情况一：同一年，情况二：非同年
				if(surverStartDate.equals(surverEndDate)){//同年
					for(int k=Integer.parseInt(jd1);k<=Integer.parseInt(jd2);k++){//循环季度
						Map jdMap=new HashMap();
						jdMap.put("YEARJD", surverStartDate+"年 第"+k+"季度");
						List jdList=new ArrayList();//存放每季度对应的列表数据
						
						for(int l=0;l<district.size();l++){//循环区县
							if(yearmonthre<yearResult.size()){
								Map m=(Map) yearResult.get(yearmonthre);
								BigDecimal bd=(BigDecimal) m.get("SURVERTYPE");
								BigDecimal dist=(BigDecimal) m.get("DISTRICT");
								
								if((bd.intValue())==((Integer)survertype.get(i))&&m.get("SURVERYEAR").equals(surverStartDate)&&m.get("SURVERJD").equals(k+"")&&(dist.intValue())==((Integer)district.get(l))){
									if(m.get("AREA")!=null&&!"".equals(m.get("AREA"))){
										Map tempMap=new HashMap();
										tempMap.put("DISTRICT", district.get(l));
										tempMap.put("AREA", m.get("AREA"));
										jdList.add(tempMap);
									}else{
										Map tempMap=new HashMap();
										tempMap.put("DISTRICT", district.get(l));
										tempMap.put("AREA", 0);
										jdList.add(tempMap);
									}
									yearmonthre++;
								}else{
									Map tempMap=new HashMap();
									tempMap.put("DISTRICT", district.get(l));
									tempMap.put("AREA", 0);
									jdList.add(tempMap);
								}
							}else{
								Map tempMap=new HashMap();
								tempMap.put("DISTRICT", district.get(l));
								tempMap.put("AREA", 0);
								jdList.add(tempMap);
							}
							
						}
						jdMap.put("JDLIST", jdList);
						typeList.add(jdMap);
					}
					
				}else{//非同年
					for(int j=Integer.parseInt(surverStartDate);j<=Integer.parseInt(surverEndDate);j++){
						
						//循环年。三种情况：1、起始年 2、大于起始年，小于结束年 3、结束年
						if(j==Integer.parseInt(surverStartDate)){//起始年
							for(int k=Integer.parseInt(jd1);k<=4;k++){
								Map jdMap=new HashMap();
								List jdList=new ArrayList();//存放每季度对应的列表数据
								jdMap.put("YEARJD", j+"年 第"+k+"季度");
								
								for(int l=0;l<district.size();l++){//循环区县
									if(yearmonthre<yearResult.size()){
										Map m=(Map) yearResult.get(yearmonthre);
										BigDecimal bd=(BigDecimal) m.get("SURVERTYPE");
										BigDecimal dist=(BigDecimal) m.get("DISTRICT");
										
										if((bd.intValue())==((Integer)survertype.get(i))&&m.get("SURVERYEAR").equals(surverStartDate)&&m.get("SURVERJD").equals(k+"")&&(dist.intValue())==((Integer)district.get(l))){
											if(m.get("AREA")!=null&&!"".equals(m.get("AREA"))){
												Map tempMap=new HashMap();
												tempMap.put("DISTRICT", district.get(l));
												tempMap.put("AREA", m.get("AREA"));
												jdList.add(tempMap);
											}else{
												Map tempMap=new HashMap();
												tempMap.put("DISTRICT", district.get(l));
												tempMap.put("AREA", 0);
												jdList.add(tempMap);
											}
											yearmonthre++;
										}else{
											Map tempMap=new HashMap();
											tempMap.put("DISTRICT", district.get(l));
											tempMap.put("AREA", 0);
											jdList.add(tempMap);
										}
									}else{
										Map tempMap=new HashMap();
										tempMap.put("DISTRICT", district.get(l));
										tempMap.put("AREA", 0);
										jdList.add(tempMap);
									}
									
								}
								jdMap.put("JDLIST", jdList);
								typeList.add(jdMap);
							}
						}else if(j>Integer.parseInt(surverStartDate)&&j<Integer.parseInt(surverEndDate)){
							for(int k=1;k<=4;k++){
								Map jdMap=new HashMap();
								List jdList=new ArrayList();//存放每季度对应的列表数据
								jdMap.put("YEARJD", j+"年 第"+k+"季度");
								for(int l=0;l<district.size();l++){//循环区县
									if(yearmonthre<yearResult.size()){
										Map m=(Map) yearResult.get(yearmonthre);
										BigDecimal bd=(BigDecimal) m.get("SURVERTYPE");
										BigDecimal dist=(BigDecimal) m.get("DISTRICT");
										if((bd.intValue())==((Integer)survertype.get(i))&&m.get("SURVERYEAR").equals(j+"")&&m.get("SURVERJD").equals(k+"")&&(dist.intValue())==((Integer)district.get(l))){
											if(m.get("AREA")!=null&&!"".equals(m.get("AREA"))){
												Map tempMap=new HashMap();
												tempMap.put("DISTRICT", district.get(l));
												tempMap.put("AREA", m.get("AREA"));
												jdList.add(tempMap);
											}else{
												Map tempMap=new HashMap();
												tempMap.put("DISTRICT", district.get(l));
												tempMap.put("AREA", 0);
												jdList.add(tempMap);
											}
											yearmonthre++;
										}else{
											Map tempMap=new HashMap();
											tempMap.put("DISTRICT", district.get(l));
											tempMap.put("AREA", 0);
											jdList.add(tempMap);
										}
									}else{
										Map tempMap=new HashMap();
										tempMap.put("DISTRICT", district.get(l));
										tempMap.put("AREA", 0);
										jdList.add(tempMap);
									}
									
								}
								jdMap.put("JDLIST", jdList);
								typeList.add(jdMap);
							}
						}else{
							for(int k=1;k<=Integer.parseInt(jd2);k++){
								Map jdMap=new HashMap();
								List jdList=new ArrayList();//存放每季度对应的列表数据
								jdMap.put("YEARJD", j+"年 第"+k+"季度");
								for(int l=0;l<district.size();l++){//循环区县
									if(yearmonthre<yearResult.size()){
										Map m=(Map) yearResult.get(yearmonthre);
										BigDecimal bd=(BigDecimal) m.get("SURVERTYPE");
										BigDecimal dist=(BigDecimal) m.get("DISTRICT");
										if((bd.intValue())==((Integer)survertype.get(i))&&m.get("SURVERYEAR").equals(j+"")&&m.get("SURVERJD").equals(k+"")&&(dist.intValue())==((Integer)district.get(l))){
											if(m.get("AREA")!=null&&!"".equals(m.get("AREA"))){
												Map tempMap=new HashMap();
												tempMap.put("DISTRICT", district.get(l));
												tempMap.put("AREA", m.get("AREA"));
												jdList.add(tempMap);
											}else{
												Map tempMap=new HashMap();
												tempMap.put("DISTRICT", district.get(l));
												tempMap.put("AREA", 0);
												jdList.add(tempMap);
											}
											yearmonthre++;
										}else{
											Map tempMap=new HashMap();
											tempMap.put("DISTRICT", district.get(l));
											tempMap.put("AREA", 0);
											jdList.add(tempMap);
										}
									}else{
										Map tempMap=new HashMap();
										tempMap.put("DISTRICT", district.get(l));
										tempMap.put("AREA", 0);
										jdList.add(tempMap);
									}
									
								}
								jdMap.put("JDLIST", jdList);
								typeList.add(jdMap);
							}
							
						}
						
					}

				}
				
				typeMap.put("TYPELIST", typeList);
				relist.add(typeMap);
				
			}
			
//			for(int x=0;x<relist.size();x++){
//				Map xx=(Map) relist.get(x);
//				System.out.println("------survertype---"+xx.get("SURVERTYPE"));
//				List typeList=(List) xx.get("TYPELIST");
//				for(int a=0;a<typeList.size();a++){
//					Map mmm=(Map) typeList.get(a);
//					List jdList=(List) mmm.get("JDLIST");
//					System.out.println("----jd----"+mmm.get("YEARJD"));
//					for(int b=0;b<jdList.size();b++){
//						Map m2=(Map) jdList.get(b);
//						System.out.println("-----AREA---"+m2.get("AREA")+"-----district---"+m2.get("DISTRICT"));
//					}
//				}
//			}
			
			
			map.put("relist", relist);
			
		}	
		
		
		return new DataAndView<Map>(map, "map");
}
}