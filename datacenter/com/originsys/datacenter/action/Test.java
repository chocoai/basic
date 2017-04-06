package com.originsys.datacenter.action;

import java.io.IOException;
import java.util.List;

import org.apache.commons.beanutils.DynaBean;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Row;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.util.Bytes;
//import org.apache.hadoop.hbase.io.BatchUpdate;
//import org.apache.hadoop.hbase.io.RowResult;
//import org.apache.hadoop.hbase.io.Cell;
import org.apache.hadoop.hbase.util.Writables;
import org.apache.hadoop.io.IntWritable;

import com.originsys.datacenter.domain.HBuilding;
import com.originsys.datacenter.domain.HHouse;
import com.originsys.datacenter.domain.HRT_prolinkbase;
import com.originsys.datacenter.domain.RegionUtil;
import com.originsys.realtygis.domain.House;

/**
 auth:boy 2014-2-25
   描述：

1：hbase使用坐标来定位表中的数据，行健是第一个坐标，下一个是列簇。再下一个坐标是列限定符。3个坐标确定了单元cell的位置。
hbase中数据作为值（value)存储在单元里。表中确定一个单元的坐标是：[rowkey,column family,column_qualifier]
2：Hbase 中修改数据使用的方式与存储新数据一样：创建普陀对象，在正确的坐标上给出数据，提交到表。
3:HFile是hbase使用的底层存储格式。HFile对应于列簇，一个列簇可以有多个Hfile，但一个hfile不能存储多个列簇的数据。
4:hbase中修改数据使用的方式与存储新数据一样：创建put对象，在正确的坐标上给出数据，提交到表。
 */
public class Test {
	public static void abc() throws Exception{
		 
		try {
			HBaseConfiguration config = new HBaseConfiguration();
//			/**hbase客户端应用需要有一份Hbase配置信息来访问hbase-zookeeper quorum地址。你可以手工设定这个配置如下*/
			config.set("hbase.zookeeper.quorum", "192.168.85.129"); 
			/**HBASE配置信息可以通过两种方式获取，一种是java客户端从类路径里的hbase-site.xml文件里获取配置信息，
			 * 令一种是通过在连接中显式设定配置信息来获取。如果你没有指定配置信息，就像示例代码里那样，客户端就会默认配置信息，
			 * 把localhost作为zookeeper quorum的地址。单机模式中，指的就是你用来验证本书内容的机器，这正是你需要配置的信息。*/
//			HBaseAdmin admin = new HBaseAdmin(config);
//			if (admin.tableExists("t_projectsddfile")) {
//				System.out.println("drop table");
//				admin.disableTable("scores");
//				admin.deleteTable("scores");
//	        }
//			System.out.println("create table");
//			/**定义表结构及创建表*/ 
//	        HTableDescriptor tableDescripter = new HTableDescriptor("t_projectsddfile".getBytes());	 
//	        tableDescripter.addFamily(new HColumnDescriptor("info"));	 
//	        admin.createTable(tableDescripter);	 	 
//	        System.out.println("add Tom's data");	
//	        /**插入数据*/
//	        HTablePool pool = new HTablePool(config, 1000);  
//	        HTableInterface table1 = pool.getTable("t_projectsddfile");  
//	        byte[] rowkey=Bytes.add("304665".getBytes(),"335781".getBytes());
//	        Put put = new Put(rowkey);// 一个PUT代表一行数据，再NEW一个PUT表示第二行数据,每行一个唯一的ROWKEY，此处rowkey为put构造方法中传入的值  
//	        put.add(ProjectSddFile.COLFAMILY, ProjectSddFile.PROJECTSDDFILE_FILE, "123".getBytes());
//	        put.add(ProjectSddFile.COLFAMILY, ProjectSddFile.PROJECTSDDFILE_CREATEDATE, "2012/7/27 15:49:38".getBytes());
//	        put.add(ProjectSddFile.COLFAMILY, ProjectSddFile.PROJECTSDDFILE_UPLOADDATE, "2012/7/27 15:49:38".getBytes());
//	        put.add(ProjectSddFile.COLFAMILY, ProjectSddFile.PROJECTSDDFILE_DESC, "历下区旅游路21442号长安欣苑".getBytes());
//	        table1.put(put); 
//	        byte[] rowkey1=Bytes.add("304664".getBytes(),"335781".getBytes());
//	        Put put1 = new Put(rowkey1);// 一个PUT代表一行数据，再NEW一个PUT表示第二行数据,每行一个唯一的ROWKEY，此处rowkey为put构造方法中传入的值  
//	        put1.add(ProjectSddFile.COLFAMILY, ProjectSddFile.PROJECTSDDFILE_FILE, "1234".getBytes());
//	        put1.add(ProjectSddFile.COLFAMILY, ProjectSddFile.PROJECTSDDFILE_CREATEDATE, "2012/7/27 15:49:38".getBytes());
//	        put1.add(ProjectSddFile.COLFAMILY, ProjectSddFile.PROJECTSDDFILE_UPLOADDATE, "2012/7/27 15:49:38".getBytes());
//	        put1.add(ProjectSddFile.COLFAMILY, ProjectSddFile.PROJECTSDDFILE_DESC, "历下区旅游路21442号长安欣苑4".getBytes());
//	        table1.put(put1);
//	        
////	        Put put2=new Put(byte[] Row);
//	        System.out.println("end insert data ......");  
//	        table1.close();
//	        /**删除数据
//	         * 从hbase中删除数据和存储数据的工作方式类似。基于一个行健创建一个Delete命令。*/
//	        Delete d=new Delete(Bytes.toBytes("tom"));
//	        table1.delete(d);
//	        System.out.println("tom data delete");
//	        /**查询数据*/
//	        Get g=new Get(Bytes.toBytes("Lucy"));
//	        g.addFamily("grade".getBytes());
//	        g.addColumn(Bytes.toBytes("course"), Bytes.toBytes("math"));
//	        g.addColumn(Bytes.toBytes("course"), Bytes.toBytes("art"));
//	        Result r=table1.get(g);
//	        byte[] b=r.getValue("course".getBytes(), "math".getBytes());
//	        String math=Bytes.toString(b);
//	        System.out.println("lucy的math成绩是："+math);
//	        byte[] b1=r.getValue("course".getBytes(), "art".getBytes());
//	        String art=Bytes.toString(b1);
//	        System.out.println("lucy的art成绩是："+art);
//	        
//	        /**扫描全表*/
//	        Scan s=new Scan();
//	        s.setMaxVersions();
//	        ResultScanner ss=table1.getScanner(s);
//	        for(Result res:ss){
//	        	System.out.println(new String(res.getRow()));
//	        	for(KeyValue kv:res.raw()){
//	        		System.out.println(new String(kv.getValue()));
//	        	}
//	        }
//	        
////	        Scan s2=new Scan();Scan(table1,"Lucy","row2");
	        System.out.println("123");
//	        /**根据key的前缀查找*/
//	        Scan s=new Scan();
//	        //查找前缀，以什么开头的
////	        s.setFilter(new PrefixFilter("304664".getBytes()));
//	        //正则表达式，以什么结束的
//	        s.setFilter(new RowFilter(CompareOp.EQUAL,new RegexStringComparator(".*335781$")));
//	        s.setMaxVersions();
//	        ResultScanner ss=table1.getScanner(s);
//	        for(Result res:ss){
//	        	System.out.println(new String(res.getRow()));
//	        	for(KeyValue kv:res.raw()){
//	        		System.out.println(new String(kv.getValue()));
//	        	}
//	        }
//	        inputDataRT();
//	        System.out.println("456");
	        
	        String coprocessClassName = "org.apache.hadoop.hbase.coprocessor.AggregateImplementation";
	        HBaseAdmin admin = new HBaseAdmin(config);
	        admin.disableTable(HHouse.TABLE_NAME);
	        HTableDescriptor htd = admin.getTableDescriptor(Bytes.toBytes("house"));
	        htd.addCoprocessor(coprocessClassName);
	        admin.modifyTable(Bytes.toBytes("house"), htd); 
	        admin.enableTable(HHouse.TABLE_NAME);
//	        List<DynaBean> rows = new HbaseQueryImpl().select("select fw_address from house limit 3 offset 2");
//	        System.out.println(rows.size());
	        
		} catch (MasterNotRunningException e) {
			e.printStackTrace();
		} catch (ZooKeeperConnectionException e) {
			e.printStackTrace();
		}
		 
	}
	
	public  static void inputDataRT() throws Exception{
		HBaseConfiguration config = new HBaseConfiguration();
		config.set("hbase.zookeeper.quorum", "192.168.85.129"); 
		HTablePool pool = new HTablePool(config, 1000);  
	    HTableInterface table = pool.getTable(HRT_prolinkbase.TABLE_NAME);
	    Put put = new Put("100001".getBytes());
	    put.add(HRT_prolinkbase.COLFAMILY, HRT_prolinkbase.SURVERPROJECT_ID, "100001".getBytes());
	    put.add(HRT_prolinkbase.COLFAMILY, HRT_prolinkbase.SURVERBASIC_ID, "200001".getBytes()); 
	    table.put(put);
	    Put put2 = new Put("100002".getBytes());
	    put2.add(HRT_prolinkbase.COLFAMILY, HRT_prolinkbase.SURVERPROJECT_ID, "100002".getBytes());
	    put2.add(HRT_prolinkbase.COLFAMILY, HRT_prolinkbase.SURVERBASIC_ID, "200002".getBytes()); 
	    table.put(put2);
	    table.close();
	}
	public  static void inputBuildingData() throws Exception{
		HBaseConfiguration config = new HBaseConfiguration();
		config.set("hbase.zookeeper.quorum", "192.168.85.129"); 
		HTablePool pool = new HTablePool(config, 1000);  
	    HTableInterface table = pool.getTable(HBuilding.TABLE_NAME);
	    Put put = new Put("140001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.SURVERPROJECT_ID, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.UNIT, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.SURVER, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.USE_DESGIN, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.REAL_TYPE, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.TN_AREA, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.FT_AREA, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.BUILD_AREA, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.NOFT_AREA, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.NO_AREA, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.DISCREPANT_AREA, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.SRUVER_DATE, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.SURVER_ENDDATE, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.BUILDING_NUMBER, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.BUILD_STRUCT, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.GRAPHICS_CODE, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.GRAPHICS_NUMBER, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.INPUT_DATE, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.FLOORUP_COUNT, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.FLOORDOWN_COUNT, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.CITY_DISTRICT, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.BUILDING_MAPID, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.BUILDING_ADDRESS, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.BUILDING_DATE, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.FLOOR_COUNT, "100001".getBytes());
	    put.add(HBuilding.COLFAMILY, HBuilding.HOUSE_COUNT, "100001".getBytes());
	    table.put(put);
	    Put put2 = new Put("140002".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.SURVERPROJECT_ID, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.UNIT, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.SURVER, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.USE_DESGIN, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.REAL_TYPE, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.TN_AREA, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.FT_AREA, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.BUILD_AREA, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.NOFT_AREA, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.NO_AREA, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.DISCREPANT_AREA, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.SRUVER_DATE, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.SURVER_ENDDATE, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.BUILDING_NUMBER, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.BUILD_STRUCT, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.GRAPHICS_CODE, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.GRAPHICS_NUMBER, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.INPUT_DATE, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.FLOORUP_COUNT, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.FLOORDOWN_COUNT, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.CITY_DISTRICT, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.BUILDING_MAPID, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.BUILDING_ADDRESS, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.BUILDING_DATE, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.FLOOR_COUNT, "100001".getBytes());
	    put2.add(HBuilding.COLFAMILY, HBuilding.HOUSE_COUNT, "100001".getBytes());
	    table.put(put2);
	    table.close();
	}
	
	
	public static void main(String[] args){
//		System.out.print(RegionUtil.toBZRegioncode("330101"));
		String region_id="330102";
		String building_mapid="648051";
		String zh="10";
		String fq="3-901-1-3";
		String newregion_id=RegionUtil.toBZRegioncode("330102");
		String newfq=fq.replaceAll("-", "");
		int n1=newfq.length();
		int n2=8-n1;
		StringBuffer sb=new StringBuffer();
		if(n2>0){
			for(int i=0;i<n2;i++){
				sb.append("0");
			}
		}
		sb.append(newfq);
		String fq1=sb.toString();
		int m1=zh.length();
		int m2=4-m1;
		StringBuffer sb1=new StringBuffer();
		if(m2>0){
			if(n2>0){
				for(int i=0;i<n2;i++){
					sb1.append("0");
				}
			}
		}
		sb1.append(zh);
		String zh1=sb1.toString();
		String sbuliding_id=newregion_id+fq1+zh1;
		System.out.println("region_id="+region_id+"....fq="+fq+"....zh="+zh);
		System.out.println("sbuliding_id="+sbuliding_id);	
		java.util.Date now=new java.util.Date();
		System.out.println(now.getTime());
	}
}
