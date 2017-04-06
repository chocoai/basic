package com.originsys.realtygis.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.realtygis.domain.MapVersion;

/**
 * 类说明：地图版本修改
 * @创建时间：2014-1-8 
 * @作者： 洛佳明
 */
public class MapVersionUpdate extends BaseAction implements IGet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataAndView<MapVersion> execute(RequestAction ra)
			throws Exception {
		SqlMapClient sc = DataSource.getSqlMapInstance();
		MapVersion version =new MapVersion();
		if( "禁用".equals(ra.getParameter("status")) &&  "1001".equals(ra.getParameter("default_map")) ){
		   // System.out.println("默认地图不可禁用");
		}else{
			version.set_internal_state("0");
			version.setVersion_number((Long.parseLong(ra.getParameter("version_number"))));
			version.setVersion_name(((String)ra.getParameter("version_name")));
			version.setAuditor((String)ra.getParameter("auditor"));
			version.setPublisher((String)ra.getParameter("publisher"));
			version.setStatus((String)ra.getParameter("status"));
			version.setDefault_map(Integer.parseInt(ra.getParameter("default_map")));
			version.setMessage(ra.getParameter("message"));
			try{
				sc.startTransaction();
				if("1001".equals(ra.getParameter("default_map"))){
					sc.update("Realtygis.updatedefaultmap");
				}
				sc.update("Realtygis.updatemapversion",version);
				sc.commitTransaction();
				version.set_internal_state("1");
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				sc.endTransaction();
			}
		}
		
		return new DataAndView<MapVersion>(version, "version");

	}

}
