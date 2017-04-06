package com.originsys.safemanage.authenticate.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;
/**
 * 查询房屋鉴定安全等级数据
 */
public class HouseSafeTheme extends BaseAction implements IGet{

	public DataAndView execute(RequestAction arg0) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		List tmpResult=(List)sc.queryForList("Safecheck.getHouseSafeThemeData");
		Map<String,Object> remap=new HashMap<String,Object>();
		//读取属性文件 
		ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("safecheck");
		String map_url=rb.getString("map_url");
		remap.put("map_url", map_url);
		remap.put("datalist",tmpResult);
		return new DataAndView(remap,"block");
		
	}

}
