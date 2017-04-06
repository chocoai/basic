package com.originsys.auth.Service;

import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.Orgcom;
import com.originsys.eap.util.CacheUtil;
import com.originsys.eap.util.DataSource;

/**
 auth:boy 2013-7-14
   描述：企业组织服务类
 */
public class OrgComService {
	static class SingletonHolder {
		static OrgComService instance = new OrgComService();
	}

	public static OrgComService getInstance() {
		return SingletonHolder.instance;
	}

	static Logger logger = Logger.getLogger(OrgComService.class.getName());
	
	/**根据机构代码返回机构对象*/
	public Orgcom getOrgcomByCode(String orgcom_code) throws Exception{
		Orgcom orgcom=null;
		if (CacheUtil.dataCache().get(orgcom_code)!=null){
			orgcom=(Orgcom)CacheUtil.dataCache().get(orgcom_code).getValue();
		}else{
			synchronized (this) {
				if (CacheUtil.dataCache().get(orgcom_code)!=null){
					orgcom=(Orgcom)CacheUtil.dataCache().get(orgcom_code).getValue();
					return orgcom;
				}
				SqlMapClient sc = DataSource.getSqlMapInstance();
				orgcom=(Orgcom)sc.queryForObject("Auth.getOrgcomBycode",orgcom_code);
				if(orgcom!=null)
					CacheUtil.dataCache().put(new Element(orgcom_code,orgcom));
			}
		}
		return orgcom;
	}
	
	/**根据机构代码返回机构id*/
	public String getOrgcomIDByCode(String orgcom_code) throws Exception{
		Orgcom temp=getOrgcomByCode(orgcom_code);
		if(temp==null)
			return "";
		else
			return temp.getOrgan_id();
	}
	
	
	/**根据机构id返回机构对象*/
	public Orgcom getOrgcomByID(String orgcom_id) throws Exception{
		Orgcom orgcom=null;
		if (CacheUtil.dataCache().get("orgcom_"+orgcom_id)!=null){
			orgcom=(Orgcom)CacheUtil.dataCache().get("orgcom_"+orgcom_id).getValue();
		}else{
			synchronized (this) {
				if (CacheUtil.dataCache().get("orgcom_"+orgcom_id)!=null){
					orgcom=(Orgcom)CacheUtil.dataCache().get("orgcom_"+orgcom_id).getValue();
					return orgcom;
				}
				SqlMapClient sc = DataSource.getSqlMapInstance();
				orgcom=(Orgcom)sc.queryForObject("Auth.getOrgcom",orgcom_id);
				if(orgcom!=null)
					CacheUtil.dataCache().put(new Element("orgcom_"+orgcom_id,orgcom));
			}
		}
		return orgcom;
	}
	
	/**根据机构id返回机构名称*/
	public String getOrgcomNameByID(String orgcom_id) throws Exception{
		if(orgcom_id==null||"".equals(orgcom_id))
			return "";
		Orgcom orgcom=getOrgcomByID(orgcom_id);
		if(orgcom==null)
			return "";
		else
			return orgcom.getOrgan_name();
	}
	
}
