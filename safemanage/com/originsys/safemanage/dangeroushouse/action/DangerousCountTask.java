package com.originsys.safemanage.dangeroushouse.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.EnumValue;
import com.originsys.eap.service.EnumService;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.OrgContextHolder;

/**
 auth:boy 2014-6-17
   描述：危房统计准备汇总的定时任务
 */
public class DangerousCountTask extends BaseAction implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
//		System.out.println("start..........");
		/** 设置线程的局部变量 读取属性配置文件*/
		OrgContextHolder.setVendorType("eap2");		
		/**需要汇总的分类*/
		List<String> list=new ArrayList<String>();
		list.add("sjyt");//设计用途
		list.add("fwjg");//房屋结构
		list.add("fwcb");//房屋产别
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try{
			sc.startTransaction();
			/**清空汇总表t_dangerous_count中的记录=====*/
			sc.delete("safeauth.deleteDangerousCount");
			/**查询汇总条件*/
			Map<String,String> term=new HashMap<String,String>();
			/**地区的枚举列表*/
			List<EnumValue> xzqh=EnumService.getInstance().getEnum("xzqh");
			/**循环需要汇总的大类*/
			for(String dfl:list){
				term.put("enum_id", dfl);
				/**获取每个大类中的枚举小类*/
				List<EnumValue> enumlist=EnumService.getInstance().getEnum(dfl);
				/**循环枚举小类*/
				for(EnumValue temp:enumlist){
					/**获取每个小的分类*/
					String enumvalue=temp.getEnum_value();
					term.put("enum_value", enumvalue);
					/**循环地区的枚举值，每个小的分类，每个地区的分别汇总*/
					for(EnumValue qhenum:xzqh){
						String region=qhenum.getEnum_value();
						term.put("building_region", region);
						sc.insert("safeauth.addDangerouseCount",term);
						sc.insert("safeauth.addDangerouseCountjc",term);						
					}
				}
			}
			sc.commitTransaction();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				sc.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//		System.out.println("end..........");
	}

}
