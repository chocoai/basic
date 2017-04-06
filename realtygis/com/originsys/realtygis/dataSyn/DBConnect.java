package com.originsys.realtygis.dataSyn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
  
    /** Oracle数据库连接驱动*/
    private final static String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";

    
    /**
     * 获取数据库连接
     * @return
     */
    public Connection getConnection(String url,String username,String pass){
        /** 声明Connection连接对象*/
        Connection conn = null;
        try{
            /** 使用Class.forName()方法自动创建这个驱动程序的实例且自动调用DriverManager来注册它*/
            Class.forName(DB_DRIVER);
            /** 通过DriverManager的getConnection()方法获取数据库连接*/
            conn = DriverManager.getConnection(url,username,pass);
        }catch(ClassNotFoundException e){
        	System.out.println(e.getMessage() +"注册驱动失败");
        	e.printStackTrace();
        } catch(SQLException e){  
        	System.out.println(e.getMessage() + "获取连接字符串错误");  
        	e.printStackTrace();  
        } catch(Exception e){
        	System.out.println(e.getMessage() + "数据库连接错误");  
            e.printStackTrace();
        }
        return conn;
    }
    public Connection getConnection(String url,String driver,String username,String pass){
        /** 声明Connection连接对象*/
        Connection conn = null;
        try{
            /** 使用Class.forName()方法自动创建这个驱动程序的实例且自动调用DriverManager来注册它*/
            Class.forName(driver);
            /** 通过DriverManager的getConnection()方法获取数据库连接*/
            conn = DriverManager.getConnection(url,username,pass);
        }catch(ClassNotFoundException e){
        	System.out.println(e.getMessage() +"注册驱动失败");
        	e.printStackTrace();
        } catch(SQLException e){  
        	System.out.println(e.getMessage() + "获取连接字符串错误");  
        	e.printStackTrace();  
        } catch(Exception e){
        	System.out.println(e.getMessage() + "数据库连接错误");  
            e.printStackTrace();
        }
        return conn;
    }
    
    
    /**
     * 关闭数据库连接
     * 
     * @param connect
     */
    public void closeConnection(Connection conn){
        try{
            if(conn!=null){
                /** 判断当前连接连接对象如果没有被关闭就调用关闭方法*/
                if(!conn.isClosed()){
                    conn.close();
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
