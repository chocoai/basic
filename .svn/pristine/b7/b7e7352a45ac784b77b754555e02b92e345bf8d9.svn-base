package com.originsys.datacenter.api.action;

import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.datacenter.domain.YcDatacenterResources;
import com.originsys.datacenter.domain.YcDatacenterResourcesColumns;
import com.originsys.datacenter.domain.YcDatacenterResourcesIndex;
import com.originsys.eap.util.CacheUtil;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.UtilString;


/**
 auth:boy 2014-3-10
   描述：资源服务，根据资源编号获得资源对象，放到缓存中
 */
public class ResourcesService {
	static class SingletonHolder {
		static ResourcesService instance = new ResourcesService();
	}
	public static ResourcesService getInstance(){
		return SingletonHolder.instance;
	}
	static Logger logger = Logger.getLogger(ResourcesService.class);
	
	
	public YcDatacenterResources getResource(String resources_id) throws Exception{
		YcDatacenterResources resource;
		if (CacheUtil.dataCache().get(resources_id)!=null){
			resource=(YcDatacenterResources)CacheUtil.dataCache().get(resources_id).getValue();
			return resource;
		}else{
			synchronized (this) {
				if (CacheUtil.dataCache().get(resources_id)!=null){
					resource=(YcDatacenterResources)CacheUtil.dataCache().get(resources_id).getValue();
					return resource;
				}
				SqlMapClient sc = DataSource.getSqlMapInstance();
				resource=(YcDatacenterResources)sc.queryForObject("datacenter.getYcDatacenterResources",resources_id);
				/**资源列对象*/
				List<YcDatacenterResourcesColumns> collist=(List<YcDatacenterResourcesColumns>)sc.queryForList("datacenter.getYcDatacenterResourcesColumnsList", resources_id);
				List<String> col_list=new ArrayList<String>();
				if(collist!=null){
					for(int i=0;i<collist.size();i++){
						col_list.add(collist.get(i).getColumn_ename());
					}
				}
				resource.setCols_list(col_list);
				/**资源rowkey*/
				YcDatacenterResourcesIndex index=(YcDatacenterResourcesIndex) sc.queryForObject("datacenter.getIndex", resources_id);
				String sp=index.getIndex_separate();
				List<String> index_list=new ArrayList<String>();
				if(sp!=null&&!"".equals(sp)){
					String icol=index.getIndex_column();
					if(!"".equals(index.getIndex_column())&&index.getIndex_column()!=null){
						String[] str=UtilString.split(icol,sp);
						for(int i=0;i<str.length;i++){
							index_list.add(str[i]);
						}
					}
				}else{
					index_list.add(index.getIndex_column());
				}
				resource.setIndex_separate(sp);
				resource.setIndex_list(index_list);
				CacheUtil.dataCache().put(new Element(resources_id,resource));
			}
		}		
		return resource;
	}
}
