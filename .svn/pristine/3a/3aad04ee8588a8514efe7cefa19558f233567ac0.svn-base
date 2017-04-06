package com.originsys.datacenter.api.action;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import com.originsys.datacenter.domain.Building;
import com.originsys.datacenter.domain.HBuilding;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-3-31
   描述：根据楼幢编号获得测绘面积信息
 */
public class BuildingApi1 extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String building_id=ra.getParameter("building_id");
		if(building_id!=null&&!"".equals(building_id)){
			HBaseConfiguration config = new HBaseConfiguration();
			HTablePool pool = new HTablePool(config, 1000);  
	        HTableInterface table = pool.getTable(HBuilding.TABLE_NAME);
			Get g=new Get(Bytes.toBytes(building_id));
			g.addColumn(HBuilding.COLFAMILY, HBuilding.TN_AREA);
			g.addColumn(HBuilding.COLFAMILY, HBuilding.FT_AREA);
			g.addColumn(HBuilding.COLFAMILY, HBuilding.BUILD_AREA);
			g.addColumn(HBuilding.COLFAMILY, HBuilding.NOFT_AREA);
			g.addColumn(HBuilding.COLFAMILY, HBuilding.NO_AREA);
			g.addColumn(HBuilding.COLFAMILY, HBuilding.DISCREPANT_AREA);			
			Result r=table.get(g);
			Building building=new HBuilding().toBuilding(r);
			return new DataAndView(building,"block");
		}else
			return new DataAndView(null,"block");
	}

}
