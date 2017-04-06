package com.originsys.realtygis.action;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.realtygis.domain.ProjectSurver;

/**
 auth:boy 2014-3-20
   描述：项目测绘文件下载
 */
public class DocDownLoadProject extends BaseAction implements IData {

	public void execute(RequestAction request, HttpServletResponse response)
			throws Exception {
		OutputStream  fo=null;
		try{ 
			String building_id=request.getParameter("building_id");
			SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
			ProjectSurver  project = (ProjectSurver)sc.queryForObject("Realtygis.getProjectDoc",building_id);
			 byte[] blob=new byte[1024];
			 blob= project.getProjectfile_fileblob();
			 String filename = project.getProjectfile_filename();
			 if(filename==null||"".equals(filename))
				 filename="无测绘文件.txt";
			 String contenttype="application/msword; charset=gbk";
			 filename=new String(filename.getBytes("GBK"),"ISO8859_1");
			 response.setContentType(contenttype);     
			 response.setHeader("Content-Disposition", "attachment;filename="+filename);
			 fo=response.getOutputStream();
			 if(blob!=null)
				 fo.write(blob);
			 else
				 fo.write("空文件".getBytes());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fo!=null)
				fo.close();
		}
	}

}
