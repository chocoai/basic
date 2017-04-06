package com.originsys.safemanage.safecheck.action;

import org.apache.log4j.Logger;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.util.CacheUtil;
import com.originsys.eap.util.DataSource;
import com.originsys.safemanage.domain.TSafeCensor;

public class SafeCensorService {
	static class SingletonHolder {
		static SafeCensorService instance = new SafeCensorService();
	}

	public static SafeCensorService getInstance() {
		return SingletonHolder.instance;
	}

	static Logger logger = Logger.getLogger(SafeCensorService.class.getName());

	public TSafeCensor getTSafeCensor(String mem_id) throws Exception {
		TSafeCensor ts = null;
		logger.debug("缓存中有吗？"+(CacheUtil.dataCache().get("tsafecensor"+mem_id) != null));
		if (CacheUtil.dataCache().get("tsafecensor"+mem_id) != null) {
			ts = (TSafeCensor) CacheUtil.dataCache().get("tsafecensor"+mem_id).getValue();
		} else {
			synchronized (this) {
				logger.debug("缓存中有吗？"+(CacheUtil.dataCache().get("tsafecensor"+mem_id) != null));
				if (CacheUtil.dataCache().get("tsafecensor"+mem_id) != null) {
					ts = (TSafeCensor) CacheUtil.dataCache().get("tsafecensor"+mem_id).getValue();
					return ts;
				}
				try {
					logger.debug("获取");
					ts = new TSafeCensor();
					
					SqlMapClient sc = DataSource.getSqlMapInstance();
					logger.debug(mem_id);
					ts = (TSafeCensor)sc.queryForObject("Safecheck.getTSafeCensor",mem_id);
					if(ts==null)
						return null;
				} catch (Exception e) {
					logger.error(e.getMessage());
					throw new Exception("在这里出错了，未能获取到数据");
				}
				if (ts != null) {
					CacheUtil.dataCache().put(
							new net.sf.ehcache.Element("tsafecensor"+mem_id, ts));
				}
			}
		}
		return ts;
	}

	public static void main(String[] args) throws Exception {

	}
}
