package com.originsys.safemanage.safecheck.action;

import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONArray;

import org.json.simple.JSONObject;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.common.domain.YcAnnexImage;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-8-15
   描述：一条信息的相关图片列表
   
 */
public class ImageList extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		String info_id=ra.getParameter("info_id");
		String imgs=null;
		if(info_id!=null&&!"".equals(info_id)){
			imgs=(String)sc.queryForObject("Safecheck.getBuildingSafeImgs",info_id);
		}
		String[] images=new String[0];
		String[] ids=new String[0];
		if(imgs!=null&&!"".equals(imgs)){
			imgs=imgs.replace(",", "','");
			imgs="'"+imgs+"'";
//			System.out.println("imgs="+imgs);
			List<YcAnnexImage> imagelist=sc.queryForList("AnnexFile.getAnnexImage",imgs);
			images=new String[imagelist.size()];
			ids=new String[imagelist.size()];
			for(int i=0;i<imagelist.size();i++){
				images[i]=imagelist.get(i).getSimage_url();
				ids[i]=imagelist.get(i).getImage_id();
			}
		}
		JSONArray jsonArray1 = JSONArray.fromObject(images); 
		JSONArray jsonArray2 = JSONArray.fromObject(ids); 
		JSONObject obj = new JSONObject();
		obj.put("images", jsonArray1);
		obj.put("ids", jsonArray2);
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print(obj);
	}

}
