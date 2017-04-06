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
/**
 * 类说明：地图版本列表预修改
 * @创建时间：2014-1-8 
 * @作者： 洛佳明
 */
public class MapVersionForUpdate extends BaseAction implements IGet {
	
	private static final long serialVersionUID = 1L;

	public DataAndView<Map<String, MapVersion>> execute(RequestAction ra)
			throws Exception {
		SqlMapClient sc = DataSource.getSqlMapInstance();
		Map<String, MapVersion> map = new HashMap<String, MapVersion>();
		MapVersion version =new MapVersion();
		version =(MapVersion)sc.queryForObject("Realtygis.mapversionselect", Long.parseLong(ra.getParameter("version_number")));
		map.put("version", version);
		return new DataAndView<Map<String, MapVersion>>(map,"map");
	}

}
