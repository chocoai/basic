package com.originsys.safemanage.safecheck.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.EnumValue;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.service.EnumService;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-7-28
   描述：8.	结构类型统计图（柱状图）
按照结构类型标准字段“钢混结构、砖混结构、砖木结构、钢结构、其它”来进行统计，展示各区县各结构类型的普查数量。
 */
public class SurveyBuildStructTJ   extends BaseAction implements IGet{

	public DataAndView execute(RequestAction arg0) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		/**获取所属区县的枚举列表*/
		List<EnumValue> regionlist=EnumService.getInstance().getEnum("xzqh");
		/**获取权属状况的枚举列表*/
		List<EnumValue> qslist1=EnumService.getInstance().getEnum("fwjg");
		List<EnumValue> qslist=new ArrayList<EnumValue>();
		/**钢砼 混合 木 这三个枚举的去掉*/
		for(EnumValue enumvalue:qslist1){
			if("钢砼".equals(enumvalue.getEnum_name())||
					"混合".equals(enumvalue.getEnum_name())||
					"木".equals(enumvalue.getEnum_name())){
				
			}else{
				qslist.add(enumvalue);
			}
		}
		
		/**定义返回对象List*/
		List relist=new ArrayList();	
		/**循环每个权属状况，一种权属状况是一个dataset，没有的补零*/
		for(int i=0;i<qslist.size();i++){
			String qsid=qslist.get(i).getEnum_value();
			List temp=new ArrayList();
			/**一种权属状况各个区县的统计结果*/
			List tmpResult=(List)sc.queryForList("Safecheck.getSurveyBuildStructTj",qsid);			
			for(int j=0;j<regionlist.size();j++){
				String regionid=regionlist.get(j).getEnum_value();
				Object count=0;
				for(int x=0;x<tmpResult.size();x++){
					Map m=(Map) tmpResult.get(x);
					if(regionid.equals((String)m.get("REGION"))){
						count=m.get("COUNT");
						break;
					}	
					m=null;
				}
				Map<String,Object> tempmap1=new HashMap<String,Object>();
				tempmap1.put("regionid",regionid);
				tempmap1.put("count",count);
				temp.add(tempmap1);
				tempmap1=null;
			}
			Map<String,Object> tempmap=new HashMap<String,Object>();
			tempmap.put("qsid", qsid);
			tempmap.put("qsdata",temp);
			relist.add(tempmap);		
		}
		List tmpIDsResult=(List)sc.queryForList("Safecheck.getSurveyBuildStructMembersTj");
		ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("safecheck");
		String map_url=rb.getString("map_url");
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("regionlist", regionlist);
		remap.put("qslist", qslist);
		remap.put("relist", relist);
		remap.put("reIDslist", tmpIDsResult);
		remap.put("map_url",map_url);
		return new DataAndView(remap,"block");
	}

}
