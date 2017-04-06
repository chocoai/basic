


package com.originsys.realtygis.action;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
//import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.sql.DataSource;


import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.RequestAction;
import com.originsys.realtygis.domain.BasicSurver;
import com.originsys.eap.util.DataSource;

import oracle.sql.BLOB;

//JAVA 操作blob数据然后生成word文件
public class DocDownLoad extends BaseAction implements IData{

 /** 
  * 下载doc文档类
  * 2014-3-4
  * 洛佳明
 * @return 
  *
  */
// public void GetBlobData() {
//  super();
// }
	
 //定义获取数据库连接私有方法
// private static Connection getOracleConn() {
//     String driver = "oracle.jdbc.driver.OracleDriver";
//     String url = "jdbc:oracle:thin:@192.168.0.12:1521:orcl";// 设置连接字符串
//     String username = "fcchsys";//用户名
//     String password = "fcchsys";//密码
//     Connection conn = null; //创建数据库连接对象
//     try {
//         Class.forName(driver);
//         conn = DriverManager.getConnection(url, username, password);
//         System.out.println("connect oracle success!");
//     }
//     catch (ClassNotFoundException e) {
//         e.printStackTrace();
//     }
//     catch (SQLException e) {
//         e.printStackTrace();
//     }
//     return conn;
// }
 /**
  * Destruction of the servlet. <br>
  */
// public void destroy() {
//  super.destroy(); // Just puts "destroy" string in log
//  // Put your code here
// }

// public void doGet(HttpServletRequest request, HttpServletResponse response)
//   throws ServletException, IOException {
//  this.doPost(request, response);
//
// }
 
	 public void execute(RequestAction request, HttpServletResponse response) throws Exception {
 // String tablename=request.getParameter("BUILDING_BASICSURVER");
		 try{
  String building_id=request.getParameter("building_id");
  BasicSurver bs = new BasicSurver();
 // if(!"".equals(building_id)){
	  bs.setBuilding_id(building_id);
	  
 // }
  System.out.println("####");
  SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
  List<BasicSurver>  surverreport = (List)sc.queryForList("Realtygis.buildingbasicproduct",bs);
  System.out.println("@@@@");
  byte[] blob=new byte[1024];
//   blob= surverreport.get(0).getBasicproduct_file();
   blob= surverreport.get(0).getProjectfile_fileblob();
//    String filename = surverreport.get(0).getBasicproduct_filename();
   String filename = surverreport.get(0).getProjectfile_filename();
    String contenttype="application/msword; charset=gbk";
    filename=new String(filename.getBytes("GBK"),"ISO8859_1");
    response.setContentType(contenttype);     
    response.setHeader("Content-Disposition", "attachment;filename="+filename);
   // PrintWriter out = response.getWriter();  
   // File f = new File("D:\\"+filename);  		
  //  FileOutputStream fos = new FileOutputStream(f);
    OutputStream  fo=response.getOutputStream();
   //int len=blob.length; 
   // byte[] b=new byte[1024];
  // while(len!=-1){
      //  fos.write(blob);
    fo.write(blob);
       
      //  out.print(b);
  //    }
       // fos.close();
    fo.close();
//     Connection conn=null;
//     Statement stem=null;
//     ResultSet rs=null;
		 }
		 catch(Exception e){
			 e.printStackTrace();
		    }
		    finally{}


 }
		 
		 
		 
//    try{
//    	 
//    //for update 锁定数据行
//  String sql="select basicproduct_file,basicproduct_filename from BUILDING_BASICSURVER where building_id ='"+building_id+"'";
//  String type="doc";
// // String filename="";
//  //conn=getOracleConn();
// // stem=conn.createStatement();
//
//   //  rs=stem.executeQuery(sql);
//    // while(rs.next()){
//           //读取blob对象
////      BLOB blob=(oracle.sql.BLOB)rs.getBlob("basicproduct_file");
//   //   filename=rs.getString("basicproduct_filename");
//   //   String contenttype="";
//      if("doc".equalsIgnoreCase(type)){
//      contenttype="application/msword; charset=gbk";
//      }
//      
//      filename=new String(filename.getBytes("GBK"),"iso-8859-1");
//                  response.setContentType(contenttype);     
//                  response.setHeader("Content-Disposition", "attachment;filename="+filename);
//        
//                  File f = new File("D:\\temp.doc");  		
//                  FileOutputStream fos = new FileOutputStream(f);
//                  InputStream input=blob.getBinaryStream(); 
//         OutputStream  fo=response.getOutputStream();
//
//          byte[] b=new byte[1024];
//          
//          int len=0;
//          
//          while((len=input.read(b))!=-1){
//           fo.write(b, 0, len);
//           fos.write(b);
//           out.print(b);
//          }
//      
//   //   fo.close();
//      input.close();
////      rs.close();
////      stem.close();
////      conn.commit();
//            
//  //   }     
//     
//   }
//    catch(Exception e){
//    }
//    finally{try{conn.close();}catch(Exception e){}}
//
//
// }

// public void init() throws ServletException {
//  // Put your code here
// }
 
//	public void InputDoc() {
//		Test temp = new Test();
//		ResultSet rset = temp.getResultSet();
//		try {
//			while (rset.next()) {
//				oracle.sql.BLOB blob = (oracle.sql.BLOB) rset.getBlob("TXN_TRADE");
//				File f = new File("C:\\temp.doc");
//				FileOutputStream fos = new FileOutputStream(f);
//				InputStream is = blob.getBinaryStream();// 读出数据后转换为二进制流
//				byte[] data = new byte[1024];
//				while (is.read(data) != -1) {
//					fos.write(data);
//				}
//				fos.close();
//				is.close();
//			}
//			con.commit(); // 正式提交
//			rset.close();
//		} catch (Exception e) {
//		}
//	}
	
}