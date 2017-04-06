package com.originsys.datacenter.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.XAConnection;

import oracle.jdbc.xa.client.OracleXADataSource;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.datacenter.domain.HBuilding;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.OrgContextHolder;

/**
 auth:boy 2014-5-5
   描述：16万图斑数据初始化到hbase中，其实也需要同步到安全管理的业务库中，那个分别执行
 */
public class InitData extends BaseAction implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		/** 设置线程的局部变量 读取属性配置文件*/
		OrgContextHolder.setVendorType("eap2");		
		System.out.println("initdata start..............");
		try{
			SqlMapClient sc=DataSource.getSqlMapInstance();
			HBaseConfiguration config = new HBaseConfiguration(); 
			HBaseAdmin admin = new HBaseAdmin(config);
			String table_name=HBuilding.TABLE_NAME;
			/**判断如果表不存在，则建表*/
			if (!admin.tableExists(table_name)) {
				System.out.println("create table");
				/**定义表结构及创建表*/ 
		        HTableDescriptor tableDescripter = new HTableDescriptor(table_name.getBytes());	 
		        tableDescripter.addFamily(new HColumnDescriptor("info"));	 
		        admin.createTable(tableDescripter);
	        }
			Connection oracleConn = getOracleConn();
			PreparedStatement oraclePstmt1=null;
//			PreparedStatement oraclePstmt2=null;
//			PreparedStatement oraclePstmt3=null;
//			PreparedStatement oraclePstmt4=null;
			String sql1="insert into t_building (building_id) values (?)";
//			String sql2="insert into t_building_safe (building_id) values (?)";
//			String sql3="insert into T_INVM_BASE (building_id) values (?)";
//			String sql4="insert into T_INVM_FIELD (building_id) values (?)";
			oraclePstmt1 = oracleConn.prepareStatement(sql1);
//		    oraclePstmt2 = oracleConn.prepareStatement(sql2);
//		    oraclePstmt3 = oracleConn.prepareStatement(sql3);
//		    oraclePstmt4 = oracleConn.prepareStatement(sql4);
			/**获取表中的总数量，如果数据大于0，则同步，如果大于1000条，则分页查询*/
			int total_num=((Integer)sc.queryForObject("datacenter.getInitNum")).intValue();
			System.out.println("total_num="+total_num);
			if(total_num>0){				
				int page=1;
			    int start=0;
			    int pagenum=2000;
			    int end=2000;
			    int add_num=0;
	 	        int del_num=0;
			    if(total_num>2000){
			    	int x1=total_num%2000;
			    	if(x1>0){
			    		page=(int)total_num/2000+1;
			    	}else
			    		page=(int)total_num/2000;
			    }			    
			    Map<String,Integer> param=new HashMap<String,Integer>();
			    for(int j=1;j<=page;j++){
			    	start=(j-1)*pagenum;
			    	end = j*pagenum;
			    	param.put("_page_start", start);
					param.put("_page_nums", pagenum);//该参数是为MySQL数据库准备的
					param.put("_page_end", end);//该参数是为Oracle数据库准备的
					HTablePool pool = new HTablePool(config, 2000);  
					HTableInterface table = pool.getTable(HBuilding.TABLE_NAME);
					List<HashMap> buildinglist=sc.queryForList("datacenter.getInitList",param);
					if(buildinglist!=null){
						for(int i=0;i<buildinglist.size();i++){
							try{	
								HashMap temp=buildinglist.get(i);
								String smuserid=""+temp.get("SMUSERID");
								/**查询数据库中是否已经初始化过了*/
								int exists_num=(Integer)sc.queryForObject("datacenter.getExists", smuserid);
								if(exists_num>0)
									continue;
								Put put=new Put(Bytes.toBytes(smuserid));
								put.add(HBuilding.COLFAMILY, HBuilding.WS_ZB, Bytes.toBytes("0"+temp.get("SMX")+"0"+temp.get("SMY")));
								put.add(HBuilding.COLFAMILY, HBuilding.BUILDING_MAPID, Bytes.toBytes(smuserid));
								put.add(HBuilding.COLFAMILY, HBuilding.BUILDING_ADDRESS, Bytes.toBytes(""));
								if(temp.get("ADDRESS")!=null)
									if(!"".equals((String)temp.get("ADDRESS")))
										put.add(HBuilding.COLFAMILY, HBuilding.BUILDING_ADDRESS, Bytes.toBytes((String)temp.get("ADDRESS")));
								table.put(put);
								oraclePstmt1.setString(1, smuserid);
								oraclePstmt1.execute();
//								oraclePstmt2.setString(1, smuserid);
//								oraclePstmt2.execute();
//								oraclePstmt3.setString(1, smuserid);
//								oraclePstmt3.execute();
//								oraclePstmt4.setString(1, smuserid);
//								oraclePstmt4.execute();
								add_num++;	
								temp=null;
							}catch(Exception e){
								e.printStackTrace();
								continue;
							}
						}
						table.close();
						pool.close();
					}
					buildinglist=null;
			    }		    
			}
			try{
			if(oracleConn!=null){
				oraclePstmt1.close();
//				oraclePstmt2.close();
//				oraclePstmt3.close();
//				oraclePstmt4.close();
		        oracleConn.close(); 
			}}catch(Exception e1){
				e1.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static Connection getOracleConn() {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@192.168.0.9:1522:orcl";// 设置连接字符串
        String username = "safemanage";//用户名
        String password = "safemanage";//密码
        Connection conn = null; //创建数据库连接对象
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
