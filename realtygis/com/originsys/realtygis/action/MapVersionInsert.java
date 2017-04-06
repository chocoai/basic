package com.originsys.realtygis.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.PostDataAndView;
import com.originsys.eap.domain.SwitchType;
import com.originsys.eap.iservice.IPost;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.realtygis.domain.MapVersion;

/**
 * 类说明：新增地图版本类
 * @创建时间：2014-1-9 
 * @作者： 洛佳明
 */
@SuppressWarnings("serial")
public class MapVersionInsert extends BaseAction implements IPost{
	
	public PostDataAndView<MapVersion> execute(RequestAction ra)
			throws Exception {
		SqlMapClient sc = DataSource.getSqlMapInstance();
		SwitchType st =SwitchType.REDIRECT;
		MapVersion version = new MapVersion();
		version.setVersion_number((Long.parseLong(ra.getParameter("version_number"))));
		
		if(!"".equals(ra.getParameter("version_name"))||ra.getParameter("version_name")!=null){
			String version_name = new String(ra.getParameter("version_name").getBytes("ISO8859_1"),"utf-8");
			version.setVersion_name(version_name);
		}
		if(!"".equals(ra.getParameter("auditor"))||ra.getParameter("auditor")!=null){
			String auditor = new String(ra.getParameter("auditor").getBytes("ISO8859_1"),"utf-8");
			version.setAuditor(auditor);
		}
		if(!"".equals(ra.getParameter("publisher"))||ra.getParameter("publisher")!=null){
			String publisher = new String(ra.getParameter("publisher").getBytes("ISO8859_1"),"utf-8");
			version.setPublisher(publisher);
		}
		if(!"".equals(ra.getParameter("status"))||ra.getParameter("status")!=null){
			String tmp = new String(ra.getParameter("status").getBytes("ISO8859_1"),"utf-8");
			version.setStatus(tmp);
		}
		try{
			sc.startTransaction();
			sc.insert("Realtygis.insertMapVersion", version);
			sc.commitTransaction();
		}catch (Exception e) {
			this.log().info("insertMapVersion插入错误："+e);
		}finally{
			sc.endTransaction();
		}
		
		return new PostDataAndView(null,null,"realtygis.mapversiongrid",st);
	}

}
