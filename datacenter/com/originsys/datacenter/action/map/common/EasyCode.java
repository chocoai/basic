package com.originsys.datacenter.action.map.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.supermap.data.Datasource;
import com.supermap.data.DatasourceConnectionInfo;
import com.supermap.data.EngineType;
import com.supermap.data.Workspace;

/**
 * 公共代码管理类， 提供常用静态变量、获取数据库连接、获取系统当前时间、本地化日志文件输出等属性/方法。
 * 
 * @author Administrator
 */
public class EasyCode {
	public final static String WORKSPACE_ADDRESS = "E:/gisfiles/iserver7.0.2/FMAP1.smwu";
	public final static String WORKSPACE_ADDRESS_FCFH = "E:/gisfiles/iserver7.0.2/FCFHMAP.smwu";
	public final static String DATASETNAME_HOUSE = "ST_RIDRGN";//基础房屋数据集名称
	public final static String DATASETNAME_HOUSE_P = "ST_RIDRGN_P";//基础房屋内点数据集名称
	public final static String DATASETNAME_SAFE_HOUSE="ST_RIDRGN_safecheck";//安全房屋数据集名称
	public final static String DATASETNAME_SAFE_HOUSE_P="ST_RIDRGN_SAFE_P";//安全房屋内点数据集名称
	public final static String ORACLE_CONNECTION_URL = "jdbc:oracle:thin:@192.168.0.9:1522:orcl";
	public final static String ORACLE_CONNECTION_USER = "fcchsys";
	public final static String ORACLE_CONNECTION_PASS = "fcchsys";
	public final static String DATASOURCE_CONNECTION_ORCL = "ORCL";
	public final static String DATASOURCE_CONNECTION_ORCL_USER = "fcch2000";
	public final static String DATASOURCE_CONNECTION_ORCL_PASS = "fcch2000";
	public final static String DATASOURCE_CONNECTION_FCCH = "ORCL_fcch";
	public final static String DATASOURCE_CONNECTION_FCCH_USER = "fcch";
	public final static String DATASOURCE_CONNECTION_FCCH_PASS = "fcch";
	public final static String DATASOURCE_CONNECTION_6 = "6";
	public final static String DATASOURCE_CONNECTION_6_USER = "fcch";
	public final static String DATASOURCE_CONNECTION_6_PASS = "fcch";
	public final static String SQLFILTER_FOR_HOUSE=" smsdriw>75016";//基础房屋数据同步条件
	public final static String SQLFILTER_FOR_SAFEHOUSE=" smsdriw>75016 and smuserid>";//安全检查房屋数据同步条件
	public final static String[] SQLFILTER_SAFEHOUSE={" max(smuserid) as smuserid"," smuserid<90000000 "};//安全检查房屋历史数据查询条件
	
	/**
	 * 获取数据同步目标数据源
	 * @param ws  工作空间对象
	 * @return  数据源对象
	 */
	public static Datasource getTargetSource(Workspace ws){
		Datasource target=null;
		DatasourceConnectionInfo targetInfo = new DatasourceConnectionInfo();		
		targetInfo.setEngineType(EngineType.ORACLEPLUS);
		targetInfo.setServer(EasyCode.DATASOURCE_CONNECTION_ORCL);
		targetInfo.setDatabase("");
		targetInfo.setUser(EasyCode.DATASOURCE_CONNECTION_ORCL_USER);
		targetInfo.setPassword(EasyCode.DATASOURCE_CONNECTION_ORCL_PASS);
		targetInfo.setAlias(EasyCode.DATASOURCE_CONNECTION_ORCL);
		target = ws.getDatasources().open(targetInfo);
		return target;
	}
	/**
	 * 获取数据同步源数据源
	 * @param ws 工作空间对象
	 * @return  数据源对象
	 */
    public static Datasource getSourceSource(Workspace ws){ 
    	Datasource source=null;
    	DatasourceConnectionInfo sourceInfo = new DatasourceConnectionInfo();
		sourceInfo.setEngineType(EngineType.ORACLEPLUS);
		sourceInfo.setServer(EasyCode.DATASOURCE_CONNECTION_6);
		sourceInfo.setDatabase("");
		sourceInfo.setUser(EasyCode.DATASOURCE_CONNECTION_6_USER);
		sourceInfo.setPassword(EasyCode.DATASOURCE_CONNECTION_6_PASS);			
		sourceInfo.setAlias(EasyCode.DATASOURCE_CONNECTION_6);			
		source = ws.getDatasources().open(sourceInfo);	
		return source;
    }
	/**
	 * 获取Oralce用户连接
	 * 
	 * @return
	 */
	public static Connection getOracleConn() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = ORACLE_CONNECTION_URL;// 设置连接字符串
		String username = ORACLE_CONNECTION_USER;// 用户名
		String password = ORACLE_CONNECTION_PASS;// 密码
		Connection conn = null; // 创建数据库连接对象
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 获取系统当前时间
	 * 
	 * @return
	 */
	public static String getCurrTime() {
		Date logdate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String logdatestr = sdf.format(logdate);
		return logdatestr;
	}

	/**
	 * 将调试语句写入本地化日志文件
	 */
	public static void writeLocalLog(String logbuf) throws Exception {
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
		/** 输出日志文件 */
		File f = new File("C:\\地图版本\\logs\\MapPublishJobLog_"
				+ simpledateformat.format(new Date()) + ".txt");
		if (f.exists()) {
		} else {
			f.createNewFile();
		}
		BufferedWriter output = new BufferedWriter(new FileWriter(f));
		output.write(logbuf.toString());
		output.flush();
		output.close();
	}
}
