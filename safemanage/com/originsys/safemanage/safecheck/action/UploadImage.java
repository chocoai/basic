package com.originsys.safemanage.safecheck.action;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.json.simple.JSONObject;

import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.service.AccessService;
import com.originsys.eap.util.FilePath;
import com.originsys.eap.util.RequestAction;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @author boy Email:wangbaoaiboy@163.com
 * @version 1.0 创建时间：2010-5-14 类说明：图片上传 页面参数有：保存路径、名称 TODO 应保存为多个版本，文件名自动加不同前缀
 */
public class UploadImage extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		log().debug("开始上传");
		int maxPostSize = 1000 * 1024 * 1024 * 50;
		DiskFileUpload fu = new DiskFileUpload();
		fu.setSizeThreshold(4096);
		fu.setRepositoryPath("/temp");
		fu.setSizeMax(1000 * 1024 * 1024 * 50);
		fu.setSizeThreshold(1024 * 1024 * 50);

		Enumeration headerNames = ra.getRequest().getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			log().debug(
					"name:" + headerName + "="
							+ ra.getRequest().getHeader(headerName));
		}

		String success = "0";
		String urlPath = ra.getParameter("urlPath");
		String block_id = null;
		String savepath = null;
		String originalname = null;
		List fileItems = null;
		Iterator iter = null;
		try {
			fileItems = fu.parseRequest(ra.getRequest());
		} catch (Exception e) {
			log().error("e", e);
		} finally {
			log().debug("空?" + fileItems);
		}
		iter = fileItems.iterator();
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();
			if (item.getName()!=null) {
				originalname = item.getName();
				log().debug("---originalname----"+originalname);
			}
			if (item.isFormField()) {
				log().debug(
						item.getFieldName() + "|" + item.getString() + "|"
								+ item.getString("utf-8"));
				if (item.getFieldName().equals("savepath")) {
					savepath = item.getString("utf-8");
				}
				if (item.getFieldName().equals("originalname")) {
					originalname = item.getString("utf-8");
				}
				if (item.getFieldName().equals("id")) {
					block_id = item.getString("utf-8");
				}
			}
		}

		String type = null;
		// 获取文件类型
		if (originalname != null) {
			type = originalname.substring(originalname.lastIndexOf(".") + 1)
					.trim();
		}
		log().debug(urlPath);
		if (AccessService.getInstance().canDo(ra.getUser(), urlPath)) {
			// success="2";
		}
		/** 取得文件保存路径,用户资源的根路径+企业ID+参数中的子目录名 */
		String rootpath = FilePath.getFilePath() + savepath;
		log().debug("rootpath==============>" + rootpath);
		File pathfile = new File(rootpath);
		if (!pathfile.exists()) {
			pathfile.mkdirs();
		}
		String name = System.currentTimeMillis() + "" + new Random().nextInt();
		log().debug("rootpath+name==============>" + rootpath + name);
		log().debug("路径有了" + ra.getRequest().getHeader("Referer"));
		long size = 0;

		log().debug("是空吗：" + iter);
		log().debug(ra.getRequest());
		log().debug(fu);

		iter = fileItems.iterator();
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();
			if (!item.isFormField()) {
				if (isImage(item.get())) {
					size = item.getSize();
					log().debug("size:" + size);
					try {
						item.write(new File(rootpath + name + "." + type));
					} catch (Exception e) {
						log().error("error:" + e);
					}
					// 生成缩放图，且返回缩放图的地址
					String zname = "small_"+name + ".";
					log().info("................zname=" + zname);
					String scaleType=ra.getParameter("scaleType");
					if(!"height".equals(scaleType))
						scaleType="width";
					writeHighQuality(zoomImage(rootpath + name + "." + type,scaleType),rootpath+zname,type);
					String returnfilename = "../" + ra.getComId() + "/" + savepath + name
							+ "." + type;
					String small_pic = "../" + ra.getComId() + "/" + savepath + name
							+ "_small." + type;
					log().debug(returnfilename);
					Map map=new HashMap();
					map.put("returnfilename", returnfilename);
					map.put("success", success);
					JSONObject obj = new JSONObject();
					obj.putAll(map);
					response.setContentType("text/plain");
					PrintWriter out=response.getWriter();
					out.print(obj);
//					out.print("<root success=\"" + success + "\" id=\"" + block_id
//							+ "\" small_pic=\"" + small_pic + "\" download_url=\""
//							+ originalname + "\" save_name=\"" + returnfilename + "\"/>");
				}
			}
		}
		
	}

	

	/**
	 * 
	 * @param imageContent
	 * @return 一般都是两种方式进行校验：一个是后缀，另一个是用 contentType
	 */
	public boolean isImage(byte[] imageContent) {
		if (imageContent == null || imageContent.length == 0) {
			return false;
		}
		Image img = null;
		InputStream is = null;
		try {
			is = new ByteArrayInputStream(imageContent);
			img = ImageIO.read(is);
			if (img == null || img.getWidth(null) <= 0
					|| img.getHeight(null) <= 0) {
				log().error("请上传正确的图片格式！");
				return false;
			}
			return true;
		} catch (Exception e) {
			log().error("error: " + e);
			return false;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					log().error("error:" + e);
				}
			}
		}
	}

	
	 /**
     * @param im            原始图像
     * @param resizeTimes   倍数,比如0.5就是缩小一半,0.98等等double类型
     * @return              返回处理后的图像
	 * @throws IOException 
     */
    public BufferedImage zoomImage(String sFile,String scaleType) throws IOException {
    	File fi = new File(sFile); // 大图文件
    	int nw=-1;
		int nh=-1;
    	BufferedImage im = ImageIO.read(fi);
        /*原始图像的宽度和高度*/
        int width = im.getWidth();
        int height = im.getHeight();
        boolean originalShape=true;
    	if (scaleType.equals("width")) {
			if(!originalShape&&width<275)
				return null;
		}
		else{
			if(!originalShape&&height<275)
				return null;
		}
		if (scaleType.equals("width")) {
			log().info("zoom by width:275");
			nw = 275;
			nh = (nw * height) / width;	//根据比例计算出缩小后高度
		} else if (scaleType.equals("height")) {
			log().info("zoom by height:275");
			nh = 275;
			nw = (nh * width) / height ;	//根据比例计算出缩小后高度
		} 
		/*调整后的图片的宽度和高度*/
		int toWidth = 0,toHeight=0;
		if (originalShape && nw > width && nh > height) {
			toWidth = (int) (Float.parseFloat(String.valueOf(width)) * 1f);
        	toHeight = (int) (Float.parseFloat(String.valueOf(height)) * 1f);
		}else{
			toWidth = (int) (Float.parseFloat(String.valueOf(width)) * 0.5f);
        	toHeight = (int) (Float.parseFloat(String.valueOf(height)) * 0.5f);
		}
		
        
        /*新生成结果图片*/
        BufferedImage result = new BufferedImage(toWidth, toHeight, BufferedImage.TYPE_INT_RGB);

        result.getGraphics().drawImage(im.getScaledInstance(toWidth, toHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);
        return result;
    }
    
    public boolean writeHighQuality(BufferedImage im, String fileFullPath,String type) {
        try {
            /*输出到文件流*/
            FileOutputStream newimage = new FileOutputStream(fileFullPath+type);           
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(im);
            /* 压缩质量 */
            jep.setQuality(1f, true);
            encoder.encode(im, jep);
           /*近JPEG编码*/
            newimage.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static void main(String[] args) throws IOException {
		UploadImage up = new UploadImage();
		float times = 0.5f; 
	    /*这个参数是要转化成的倍数,如果是1就是转化成1倍*/
	    File fi = new File("C:\\Users\\BGD\\Desktop\\5.jpg"); // 大图文件
	    BufferedImage bis = ImageIO.read(fi);
//	    up.writeHighQuality(up.zoomImage("e:\\gif.gif",times),System.currentTimeMillis() + "" + new Random().nextInt()+"_small","gif");
	}

}
