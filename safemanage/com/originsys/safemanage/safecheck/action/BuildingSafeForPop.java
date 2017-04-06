package com.originsys.safemanage.safecheck.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:zhanglf 2014-6-9
   描述：获取地区，普查健康等级，鉴定健康等级传给列表页面
 */
public class BuildingSafeForPop  extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		Map<String,Object> remap=new HashMap<String,Object>();
		
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//获取当前登录用户的mem_id
		String mem_id=ra.getUser().getMem_id();
		//获取当前登录用户管理的区域
		List<String> regionList=(List<String>)sc.queryForList("Safecheck.getBuildingSafeManageRegion", mem_id);
		if(regionList.size()>0){
			remap.put("builiding_region", regionList.get(0));
		}else{
			remap.put("builiding_region", ra.getParameter("builiding_region"));
		}
		
		remap.put("pcgrade", ra.getParameter("pcgrade"));
		remap.put("jdgrade", ra.getParameter("jdgrade"));
		return new DataAndView(remap,"block");
	}

}
