package com.originsys.datacenter.api.action;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import com.originsys.datacenter.domain.HHouse;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.RequestAction;
import com.originsys.realtygis.domain.House;

/**
 auth:boy 2014-3-31
   描述：根据房屋编号获得房屋用途，产别，结构
 */
public class HouseApi2 extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String house_id=ra.getParameter("house_id");
		String building_id=ra.getParameter("building_id");
		HBaseConfiguration config = new HBaseConfiguration();
		HTablePool pool = new HTablePool(config, 1000);  
        HTableInterface table = pool.getTable(HHouse.TABLE_NAME);
        byte[] rowkey=Bytes.add(Bytes.toBytes(building_id),Bytes.toBytes(house_id));
        Get g=new Get(rowkey);
        g.addColumn(HHouse.COLFAMILY, HHouse.BUILDING_ID);
        g.addColumn(HHouse.COLFAMILY, HHouse.HOUSE_ID);
        g.addColumn(HHouse.COLFAMILY, HHouse.DESIGN_YT);
        g.addColumn(HHouse.COLFAMILY, HHouse.FACT_YT);
        g.addColumn(HHouse.COLFAMILY, HHouse.FW_cb);
        g.addColumn(HHouse.COLFAMILY, HHouse.STRUCT);
        House house=new House();
        Result r=table.get(g);
        house=new HHouse().toHouse(r);
        return new DataAndView(house,"block");
	}

}
