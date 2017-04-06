package com.originsys.auth.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.OTPToken;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.FilePath;
import com.originsys.eap.util.RequestAction;

import freemarker.template.utility.StringUtil;

/**
 auth:boy 2013-7-31
   描述：上传文件并导入动态口令
 */
public class ImportOtp extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String success="0";
		DiskFileUpload fu = new DiskFileUpload();
		fu.setSizeThreshold(4096);
		fu.setSizeMax(1000 * 1024 * 1024);
		
		/** 取得物理路径 */
		ServletContext context = ra.getSession().getServletContext();
		String rootpath=FilePath.getFilePath();
		File pathfile = new File(rootpath);
		if(!pathfile.exists()){
			pathfile.mkdirs();
		}
		String name = "otptoken.txt";
		List fileItems = fu.parseRequest(ra.getRequest());
		
		Iterator iter = fileItems.iterator();
		long size=0;
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();
			if (!item.isFormField()) {
				size=item.getSize();
				try {
					item.write(new File(rootpath+"/"+name));
				}
				catch ( Exception e ) {
					/**删除文件出错*/
					success="1";
					log().info("上传文件出错:"+e.getMessage());
				}
			}
		}
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//没有重复导入的个数
		int num=0;
		//已经存在的token_id,没有导入的
		String have_otp="";
		try{
			/**读取本地文件*/
			BufferedReader br=new BufferedReader(new FileReader(rootpath+"/"+name));
			String r=br.readLine();
			sc.startTransaction();
			while(r!=null){
				if(!"".equals(r)){
					/**拆分每一行，空格分隔，增加到数据库*/
					String[] str1=StringUtil.split(r,' ');
					if(str1.length==2){
						String token_id=str1[0];
						String authkey=str1[1];
						if(token_id.length()==13&&authkey.length()==50){
							/**查询token_id 是否已经存在*/
							OTPToken token=(OTPToken)sc.queryForObject("Auth.getOTPTokenById", token_id);
							if(token==null){
								token=new OTPToken();
								token.setToken_id(token_id);
								token.setAuthkey(authkey);
								token.setCurrsucc(0);
								token.setCurrdft(0);
								sc.insert("Auth.insertToken", token);
							}else{
								have_otp+=token_id+" ";
								num++;
							}
						}
					}
				}
				r=br.readLine();		 
			}
			sc.commitTransaction();
			/**导入文件成功*/
			success="3";
		}catch(Exception e){
			/**导入文件出错*/
			success="2";
			throw e;
		}finally{
			sc.endTransaction();
		}
		
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\",\"have_otp\":\""+have_otp+"\",\"num\":"+num+"}");
	}

}
