package com.originsys.datacenter.api.action;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import com.originsys.datacenter.domain.HBuilding;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.RequestAction;
import com.originsys.datacenter.domain.Building;

/**
 auth:boy 2014-3-6
   描述：楼幢的api，根据building_id 获得楼幢的基本信息，
   楼幢的扩展信息不在这里面返回，如果需要的话需要重新提供api
 */
public class BuildingApi extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String building_id=ra.getParameter("building_id");
		if(building_id!=null&&!"".equals(building_id)){
			HBaseConfiguration config = new HBaseConfiguration();
//			config.set("hbase.zookeeper.quorum", "192.168.85.129"); 
			HTablePool pool = new HTablePool(config, 1000);  
	        HTableInterface table = pool.getTable(HBuilding.TABLE_NAME);
			Get g=new Get(Bytes.toBytes(building_id));
			Result r=table.get(g);
			Building building=new HBuilding().toBuilding(r);
			return new DataAndView(building,"block");
		}else
			return new DataAndView(null,"block");
	}

}
