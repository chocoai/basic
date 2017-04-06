package com.originsys.datacenter.api.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Put;

import com.originsys.datacenter.domain.YcDatacenterResources;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-3-10
   描述：根据资源编号，获取资源信息，
   公共的存数据的api
 */
public class CommonApi extends BaseAction implements IGet {

	public DataAndView execute(RequestAction ra) throws Exception{
		int flag=0;
		String resource_id=ra.getParameter("resource_id");
		/**根据资源编号获得表名，字段名，主键rowkey*/
		YcDatacenterResources resource=ResourcesService.getInstance().getResource(resource_id);
		/**判断表是否存在，如果不存在则增加*/
		HBaseConfiguration config = new HBaseConfiguration();
//		config.set("hbase.zookeeper.quorum", "192.168.85.129"); 
		HTablePool pool = new HTablePool(config, 1000);
		HBaseAdmin admin = new HBaseAdmin(config);
		String table_name=resource.getResources_tablename();
		/**判断如果表不存在，则建表*/
		if (!admin.tableExists(table_name)) {
			System.out.println("create table");
			/**定义表结构及创建表*/ 
	        HTableDescriptor tableDescripter = new HTableDescriptor(table_name.getBytes());	 
	        tableDescripter.addFamily(new HColumnDescriptor("info"));	 
	        admin.createTable(tableDescripter);
        }
		/**hbase链接成功*/
		flag=1;
		String rowkey="";
		/**获得rowkey*/
		if(resource.getIndex_separate()!=null&&!"".equals(resource.getIndex_separate())){
			if(resource.getIndex_list()!=null){
				for(int i=0;i<resource.getIndex_list().size();i++){
					if(i==0)
						rowkey=ra.getParameter(resource.getIndex_list().get(i));
					else
						rowkey+=resource.getIndex_separate()+ra.getParameter(resource.getIndex_list().get(i));
				}
			}
		}else{
			if(resource.getIndex_list()!=null){
				if(resource.getIndex_list().size()>0)
					rowkey=ra.getParameter(resource.getIndex_list().get(0));
			}										
		}
		if("".equals(rowkey)){
			flag=2;//rowkey为空
		}else{
			/**循环列，为列赋值*/
			HTableInterface table = pool.getTable(table_name);	
			Put put = new Put(rowkey.getBytes());
			for(int i=0;i<resource.getCols_list().size();i++){			
				put.add("info".getBytes(), resource.getCols_list().get(i).getBytes(),
						ra.getParameter(resource.getCols_list().get(i)).getBytes());
			}			
		    try {
		    	table.put(put);
				table.close();
				flag=8;//增加成功
			} catch (IOException e) {
				flag=3;//增加失败
				throw e;
			}
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("flag", flag);
		return new DataAndView(map,"block");
	}

}
