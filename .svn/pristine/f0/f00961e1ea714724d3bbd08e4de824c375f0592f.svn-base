package com.originsys.auth.Service;

import java.util.HashMap;
import java.util.List;

import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.OrgcomType;
import com.originsys.auth.domain.RoleRegister;
import com.originsys.eap.util.CacheUtil;
import com.originsys.eap.util.DataSource;


/**
 auth:boy 2013-7-14
   描述：组织类型服务类
 */
public class OrgcomTypeService {
	static class SingletonHolder {
		static OrgcomTypeService instance = new OrgcomTypeService();
	}

	public static OrgcomTypeService getInstance() {
		return SingletonHolder.instance;
	}

	static Logger logger = Logger.getLogger(OrgcomTypeService.class.getName());
	
	/**返回所有的企业类型*/
	public List<OrgcomType> getOrgcomTypeList() throws Exception{
		SqlMapClient sc = DataSource.getSqlMapInstance();
		List<OrgcomType> resultList=(List<OrgcomType>)sc.queryForList("Auth.getOrgcomTypeList", new HashMap());
		return null;
	}
	
	/**根据企业类型id 返回企业id对象,应该放到缓存中*/
	public OrgcomType getOrgComType(String organ_type_id) throws Exception{
		OrgcomType orgcom_type=null;
		if (CacheUtil.dataCache().get(organ_type_id)!=null){
			orgcom_type=(OrgcomType)CacheUtil.dataCache().get(organ_type_id).getValue();
		}else{
			synchronized (this) {
				if (CacheUtil.dataCache().get(organ_type_id)!=null){
					orgcom_type=(OrgcomType)CacheUtil.dataCache().get(organ_type_id).getValue();
					return orgcom_type;
				}
				SqlMapClient sc = DataSource.getSqlMapInstance();
				orgcom_type=(OrgcomType)sc.queryForObject("Auth.getOrgcomType",organ_type_id);
				if(orgcom_type!=null)
					CacheUtil.dataCache().put(new Element(organ_type_id,orgcom_type));
			}
		}
		return orgcom_type;
	}
}
