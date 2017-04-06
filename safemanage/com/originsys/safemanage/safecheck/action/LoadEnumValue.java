package com.originsys.safemanage.safecheck.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONObject;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.EnumValue;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

public class LoadEnumValue extends BaseAction implements IData {

	@Override
	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		
		String enum_id=ra.getParameter("enum_id");
		String enum_value=ra.getParameter("enum_value");
		String enum_name=ra.getParameter("enum_name");
		
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		
		//定义参数
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("enum_id", enum_id);
		param.put("enum_value", enum_value);//该参数是为MySQL数据库准备的
		param.put("enum_name", enum_name);//该参数是为Oracle数据库准备的
		param.put("_sortname", "enum_value");
		param.put("_sortorder", "asc");
		//查询结果
		List<EnumValue> resultList=(List<EnumValue>)sc.queryForList("Safecheck.loadEnumvalue", param);
		Map resultMap=new HashMap();
		resultMap.put("enumlist", resultList);
		
		response.setContentType("text/html; charset=GBK");
		// 输出json对象
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("result" , resultMap);
		String result = jsonObj.toString();
		// 输出响应
		response.getWriter().println(result);
	}

	
}
