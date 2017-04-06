package com.originsys.realtygis.action;

import java.util.HashMap;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.realtygis.domain.MapVersion;

public class VersionIdCheck extends BaseAction implements IGet{
	/**
	 * 类说明：查询id是否已存在
	 * @创建时间：2014-1-16
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map map=new HashMap();
		MapVersion version =new MapVersion();
		version.setVersion_number((Long.parseLong(ra.getParameter("version_number"))));
		int idnum=(Integer)sc.queryForObject("Realtygis.selectIdCount", version);
		map.put("idnum", idnum);
		return new DataAndView<Map>(map, "map");
	}
}
