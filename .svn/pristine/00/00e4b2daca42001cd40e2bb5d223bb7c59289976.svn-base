package com.originsys.safemanage.safecheck.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.json.simple.JSONObject;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.common.domain.AnnexFile;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.service.SequenceService;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.FilePath;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;

/**
 * @author boy Email:wangbaoaiboy@163.com
 * @version 1.0 创建时间：2010-5-14
 * 修改：上传文件去掉可执行权限，jdk需要1.6
 * 类说明：附件上传
 */
public class UploadAnnexFile extends BaseAction implements IData{

	/* (non-Javadoc)
	 * @see com.originsys.eap.iservice.IGet#execute(javax.servlet.http.HttpServletRequest, com.originsys.eap.util.RequestAction)
	 */
	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		int maxPostSize = 1000 * 1024 * 1024;
		DiskFileUpload fu = new DiskFileUpload();

		fu.setSizeThreshold(4096);
		fu.setSizeMax(1000 * 1024 * 1024);
		List fileItems = fu.parseRequest(ra.getRequest());
		Iterator iter = fileItems.iterator();
		String savepath=null;
		String originalname = null;
		//栏目号或是新闻编号
		String block_id=null;
		log().debug(fileItems.size());
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();
			if (item.getName()!=null) {
				originalname = item.getName();
				log().debug("---originalname----"+originalname);
			}
			if (item.isFormField()) {
				log().debug(item.getFieldName()+"|"+item.getString()+"|"+item.getString("utf-8"));
				if(item.getFieldName().equals("savepath")){
					savepath=item.getString("utf-8");
				}
				if(item.getFieldName().equals("originalname")){
					originalname=item.getString("utf-8");
				}
				if(item.getFieldName().equals("id")){
					block_id=item.getString("utf-8");
				}
			}
		}

		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		Map m=new HashMap();
		JSONObject obj = new JSONObject();

		//状态码：0成功，1类型受控，2无权限
		String success="0";
		//受控文件类型
		String[] noTypes = new String[] { "jsp", "asp", "asa","php","exe","com","sh","bat"}; 
		String type = null;
		//获取文件类型
		if(originalname!=null){
			type=originalname.substring(originalname.lastIndexOf(".")+1).trim();
		}
		//判断类型是否是受控类型
		log().debug(noTypes+"|"+type);
		Arrays.sort(noTypes);  
        int index = Arrays.binarySearch(noTypes, type.toLowerCase()); 
		if(index ==0 || originalname==null){
			//为受控类型
			success="1";
			m.put("success", success);
			m.put("block_id", block_id);
			m.put("name", originalname);
			obj.putAll(m);
			out.print(obj);
//			out.print("<root success=\""+success+"\" id=\""+block_id+"\" name=\""+originalname+"\"/>");
		}else{
		/** 取得物理路径 */
		ServletContext context = ra.getSession().getServletContext();
		//System.out.println("savepath="+request.getParameter("savepath"));
		//String rootpath = context.getRealPath("/")+request.getParameter("savepath");
		String rootpath=FilePath.getFilePath()+savepath;
		log().debug(rootpath);
		File pathfile = new File(rootpath);
		if(!pathfile.exists()){
			pathfile.mkdirs();
		}
		String name = System.currentTimeMillis()+""+new Random().nextInt()+"."+type;
		iter = fileItems.iterator();
		log().debug(rootpath+"/"+name+"||"+block_id);
		String fullName=rootpath+name;
		long size=0;
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();
			if (!item.isFormField()) {
				size=item.getSize();
				try {
					File nfile=new File(fullName);
					nfile.setExecutable(false);
					item.write(nfile);
				}
				catch ( Exception e ) {
					System.out.println("上传文件出错:"+e.getMessage());
				}
			}
		}
		//linx|AIX下改变用户
		try{
			ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("commonservice");
			String userName=rb.getString("ftp_user");
			if(userName!=null){
				Runtime rt = Runtime.getRuntime(); 
				Process p = rt.exec("chown  "+userName+"  "+fullName);  
				log().debug("修改所有者 "+p.waitFor());  
			}
		}catch(Exception e){
			log().warn("未修改所有者");
		}
		//增加附件数据库记录
		AnnexFile annexfile=new AnnexFile();
		//文件id
		int file_id=SequenceService.getInstance("yc_annex_file").getNextId();
		annexfile.setFile_id(file_id);
		//获取原始文件名
		annexfile.setFile_name(originalname);
		//log().info(request.getParameter("originalname"));
		//获取保存文件名
		annexfile.setFile_save_name(name);
		
		annexfile.setFile_type(type);
		//获取文件大小
		annexfile.setFile_size(size);
		annexfile.setFile_path(savepath);
		String returnfilename="../"+ra.getComId()+"/"+savepath+name;
		if(block_id!=null && !block_id.equals("undefined"))
			annexfile.setBlock_id(Integer.parseInt(block_id));
		SqlMapClient sc=DataSource.getSqlMapInstance();
		sc.insert("AnnexFile.annexFileInsert",annexfile);

		m.put("success", success);
		m.put("block_id", block_id);
		m.put("file_id", file_id);
		m.put("download_url", originalname);
		m.put("save_name", returnfilename);
		obj.putAll(m);
		out.print(obj);
		
//		out.print("<root success=\""+success+"\" id=\""+block_id+"\" file_id=\""+file_id+"\" download_url=\""+originalname+"\" save_name=\""+returnfilename+"\"/>");
		}
	}



}
