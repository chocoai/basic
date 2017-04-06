package com.originsys.datacenter.api.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import com.originsys.datacenter.domain.HBuildingSafe;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-5-8
   描述：楼幢安全普查，检查，鉴定的结果记录
 */
public class BuildingSafeApi extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		int flag=0;
		/**判断表是否存在，如果不存在则增加*/
		HBaseConfiguration config = new HBaseConfiguration();
		HTablePool pool = new HTablePool(config, 1000);
		HBaseAdmin admin = new HBaseAdmin(config);
		String table_name=HBuildingSafe.TABLE_NAME;		
		/**hbase链接成功*/
		HTableInterface table = pool.getTable(table_name);	
		Date now=new Date();
		Put put = new Put(Bytes.add(Bytes.toBytes(ra.getParameter("building_id")),Bytes.toBytes(now.getTime())));
		if(ra.getParameter("op")!=null)
			put.add(HBuildingSafe.COLFAMILY, HBuildingSafe.OP, Bytes.toBytes(ra.getParameter("op")));
		if(ra.getParameter("opdate")!=null)
			put.add(HBuildingSafe.COLFAMILY, HBuildingSafe.OPDATE, Bytes.toBytes(ra.getParameter("opdate")));
		if(ra.getParameter("opresult")!=null)
			put.add(HBuildingSafe.COLFAMILY, HBuildingSafe.OPRESULT, Bytes.toBytes(ra.getParameter("opresult")));
		if(ra.getParameter("optype")!=null)
			put.add(HBuildingSafe.COLFAMILY, HBuildingSafe.OPTYPE, Bytes.toBytes(ra.getParameter("optype")));
		if(ra.getParameter("annex_image")!=null)
			put.add(HBuildingSafe.COLFAMILY, HBuildingSafe.ANNEX_IMAGE, Bytes.toBytes(ra.getParameter("annex_image")));
		if(ra.getParameter("annex_file")!=null)
			put.add(HBuildingSafe.COLFAMILY, HBuildingSafe.ANNEX_FILE, Bytes.toBytes(ra.getParameter("annex_file")));
		try {
	    	table.put(put);
			table.close();
			flag=1;//增加成功
		} catch (IOException e) {
			flag=0;//增加失败
			throw e;
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("flag", flag);
		return new DataAndView(map,"block");
	}

}
