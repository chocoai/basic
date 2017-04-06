package com.originsys.safemanage.safecheck.action;

import org.apache.log4j.Logger;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.util.CacheUtil;
import com.originsys.eap.util.DataSource;
import com.originsys.safemanage.domain.TSafeManager;

public class SafeManagerService {
	static class SingletonHolder {
		static SafeManagerService instance = new SafeManagerService();
	}

	public static SafeManagerService getInstance() {
		return SingletonHolder.instance;
	}

	static Logger logger = Logger.getLogger(SafeManagerService.class.getName());

	public TSafeManager getTSafeManager(String mem_id) throws Exception {
		TSafeManager ts = null;
		logger.debug("缓存中有吗？"+(CacheUtil.dataCache().get("tsafemanager"+mem_id) != null));
		if (CacheUtil.dataCache().get("tsafemanager") != null) {
			ts = (TSafeManager) CacheUtil.dataCache().get("tsafemanager"+mem_id).getValue();
		} else {
			synchronized (this) {
				logger.debug("缓存中有吗？"+(CacheUtil.dataCache().get("tsafemanager"+mem_id) != null));
				if (CacheUtil.dataCache().get("tsafemanager"+mem_id) != null) {
					ts = (TSafeManager) CacheUtil.dataCache().get("tsafemanager"+mem_id).getValue();
					return ts;
				}
				try {
					logger.debug("获取");
					ts = new TSafeManager();
					
					SqlMapClient sc = DataSource.getSqlMapInstance();
					logger.debug(mem_id);
					ts = (TSafeManager)sc.queryForObject("Safecheck.getTSafeManager",mem_id);
					if(ts==null)
						return null;
				} catch (Exception e) {
					logger.error(e.getMessage());
					throw new Exception("在这里出错了，未能获取到数据");
				}
				if (ts != null) {
					CacheUtil.dataCache().put(
							new net.sf.ehcache.Element("tsafemanager"+mem_id, ts));
				}
			}
		}
		return ts;
	}

	public static void main(String[] args) throws Exception {

	}
}
