package com.originsys.realtygis.dataSyn;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class WeatherThread extends Thread {
	private static String name;
	private static String POST_URL;
	private static PreparedStatement pst;
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	public WeatherThread(String name,String url,PreparedStatement pst) {
		super();
		this.name = name;
		this.POST_URL = url;
		this.pst = pst;
	}
	
	public void run(){
		try {
			readContentFromPost();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readContentFromPost() throws IOException {
        // Post请求的url，与get不同的是不需要带参数
        URL postUrl = new URL(POST_URL);
        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        // Output to the connection. Default is
        // false, set to true because post
        // method must write something to the
        // connection
        // 设置是否向connection输出，因为这个是post请求，参数要放在
        // http正文内，因此需要设为true
        connection.setDoOutput(true);
        // Read from the connection. Default is true.
        connection.setDoInput(true);
        // Set the post method. Default is GET
        connection.setRequestMethod("POST");
        // Post cannot use caches
        // Post 请求不能使用缓存
        connection.setUseCaches(false);
        // This method takes effects to
        // every instances of this class.
        // URLConnection.setFollowRedirects是static函数，作用于所有的URLConnection对象。
        // connection.setFollowRedirects(true);

        // This methods only
        // takes effacts to this
        // instance.
        // URLConnection.setInstanceFollowRedirects是成员函数，仅作用于当前函数
        connection.setInstanceFollowRedirects(true);
        // Set the content type to urlencoded,
        // because we will write
        // some URL-encoded content to the
        // connection. Settings above must be set before connect!
        // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
        // 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
        // 进行编码
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
        // 要注意的是connection.getOutputStream会隐含的进行connect。
        connection.connect();
        
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        // The URL-encoded contend
        // 正文，正文内容其实跟get的URL中'?'后的参数字符串一致
        String content = "firstname=" + URLEncoder.encode("一个大肥人", "gbk");
        // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写道流里面
        out.writeBytes(content); 

        out.flush();
        out.close(); // flush and close
        
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                connection.getInputStream(), "gbk"));
        String line;
        
        String result="";
        boolean f = false;
        while ((line = reader.readLine()) != null) {
        	if(line.indexOf("<!-- 历史天气 -->")>-1){
        		f=false;
        	}
        	if(f){
        		//if(line.indexOf("input")>-1) continue;
        		//if(line.indexOf("img")>-1) continue;
        		//System.out.println(line);
        		result += line ;     	}
        	if(line.indexOf("<!-- 天气预报 -->")>-1){
        		f=true;
        	}
        }
		dualWithResult(result);
        reader.close();
        connection.disconnect();
    }

	private void dualWithResult(String result) {
		String todayWeather = result.substring(result.indexOf("今天天气</h3>"),result.indexOf("</ul>"));
		
		
		String time = todayWeather.substring(todayWeather.indexOf("<li"),todayWeather.indexOf("</li>"));
		time = time.substring(time.indexOf(">")+1,time.length());
		
		String temp = todayWeather.substring(todayWeather.indexOf("<font"),todayWeather.lastIndexOf("</li>",todayWeather.indexOf("cDRed")));

		String tempH = temp.substring(temp.indexOf(">")+1,temp.indexOf("</font>"));
		String tempL =temp.substring(temp.lastIndexOf(">",temp.lastIndexOf("</font>"))+1,temp.lastIndexOf("</font>"));
		
		String w = todayWeather.substring(todayWeather.lastIndexOf("<li",todayWeather.indexOf("cDRed")),todayWeather.length());
		//String weather = todayWeather.substring(todayWeather.lastIndexOf("<li",todayWeather.indexOf("cDRed")),todayWeather.indexOf("cDRed")+50);
		String weather = w.substring(w.indexOf("<li"),w.indexOf("</li>"));
		weather = weather.substring(weather.indexOf(">")+1,weather.length());
		
		String wind = todayWeather.substring(todayWeather.lastIndexOf("<li"),todayWeather.lastIndexOf("</li>"));
		wind = wind.substring(wind.indexOf(">")+1,wind.length());
		
//		System.out.println(name+" :  "+POST_URL);
//		System.out.println(time);
//		System.out.println(tempH);
//		System.out.println(tempL);
//		System.out.println(weather);
//		System.out.println(wind);
		//log.info(name+" 气象数据获取成功 "+" --"+POST_URL);
		try {
			if(weather==null || weather.equals(""))
				weather="-";
			pst.setString(1,weather);//天气状况
			//天气图片。如果是 “多云转晴”这样的天气，则 img_path_1赋值duoyun； img_path_2赋值qing
			String imgPath1="";
			String imgPath2="";
			if(weather != null && !weather.equals("")){
				String path = "weather/";
				String imgType = ".gif";
				if(weather.contains("转")){
					String weather1 = weather.substring(0,weather.indexOf("转"));
					String weather2 = weather.substring(weather.indexOf("转")+1,weather.length());
					imgPath1 = path + weatherImg(weather1)+imgType;
					imgPath2 = path + weatherImg(weather2)+imgType;
				}else if(weather.contains("~")){
					String weather1 = weather.substring(0,weather.indexOf("~"));
					String weather2 = weather.substring(weather.indexOf("~")+1,weather.length());
					imgPath1 = path + weatherImg(weather1)+imgType;
					imgPath2 = path + weatherImg(weather2)+imgType;
				}else if(weather.contains("/")){
					String weather1 = weather.substring(0,weather.indexOf("/"));
					String weather2 = weather.substring(weather.indexOf("/")+1,weather.length());
					imgPath1 = path + weatherImg(weather1)+imgType;
					imgPath2 = path + weatherImg(weather2)+imgType;
				}else if(weather.contains("-")){
					String weather1 = weather.substring(0,weather.indexOf("-"));
					String weather2 = weather.substring(weather.indexOf("-")+1,weather.length());
					imgPath1 = path + weatherImg(weather1)+imgType;
					imgPath2 = path + weatherImg(weather2)+imgType;
				}else{
					imgPath1 = path + weatherImg(weather)+imgType;
				}
			}
			
			pst.setString(2,imgPath1);
			pst.setString(3,imgPath2);
			//温度。19℃~7℃
			pst.setString(4,tempH+"~"+tempL);
			pst.setString(5,tempH);
			pst.setString(6,tempL);
			//风
			pst.setString(7,wind);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//获取当前温度
		String rettemp = result.substring(result.indexOf("rettemp")+17,result.indexOf("&deg;"))+"℃";
		//System.out.println("rettemp:"+rettemp);
		//相对湿度
		String tempstr = result.substring(result.indexOf("相对湿度"),result.length());
		String humidity = tempstr.substring(0,tempstr.indexOf("</span>"));
		//System.out.println("humty:"+humidity);
		//风向风力
		tempstr = result.substring(result.indexOf("retwind"),result.length());
		String windnow = tempstr.substring(tempstr.indexOf("<strong>")+8,tempstr.indexOf("</span>"));
		String windnum = windnow.substring(0,windnow.indexOf("</strong>"));
		String windDir =  windnow.substring(windnow.indexOf("<span>")+6,windnow.length());
		//System.out.println("windnum:"+windnum+"  windDir:"+windDir);
		//未来几天天气信息
		tempstr = result.substring(result.indexOf("everytqshow"),result.length());
		
		for(int i=0;i<tempstr.length();i++){
			
		}
		int count = tempstr.indexOf("<div");
		int flag = 0;
		boolean end = false;
		while (count < tempstr.length() && flag < 6) {
			String str = tempstr.substring(count,tempstr.length());
			String day = str.substring(0,str.indexOf("</div>")+6);
			count += day.length();
			
			//System.out.println(day);
			//System.out.println(flag);
			
			String windC = day.substring(day.lastIndexOf(">",day.lastIndexOf("</li>"))+1,day.lastIndexOf("</li>"));
			//System.out.println(windC);
			String weatherC = day.substring(day.lastIndexOf(">",day.lastIndexOf("</li>",day.lastIndexOf(">",day.lastIndexOf("</li>"))))+1,day.lastIndexOf("</li>",day.lastIndexOf(">",day.lastIndexOf("</li>"))));
			//System.out.println(weatherC);
			
			String th = day.substring(day.lastIndexOf(">",day.lastIndexOf("</font>"))+1,day.lastIndexOf("</font>"));
			//System.out.println(th);
			
			String tl = day.substring(day.lastIndexOf(">",day.lastIndexOf("</font>",day.lastIndexOf(">",day.lastIndexOf("</font>"))))+1,day.lastIndexOf("</font>",day.lastIndexOf(">",day.lastIndexOf("</font>"))));
			//System.out.println(tl);
			
			String weakday = day.substring(day.indexOf("<p>")+3,day.indexOf("</p>"));
			String h3 = day.substring(day.indexOf("<h3>")+4,day.indexOf("</h3>"));
			if(weakday.indexOf("</font>") >-1)
				weakday = weakday.substring(weakday.indexOf(">")+1,weakday.indexOf("</font>"));
			if(h3.indexOf("</font>") >-1)	
				h3 = h3.substring(0,h3.indexOf("<"))+h3.substring(h3.lastIndexOf(">",h3.indexOf("</font>"))+1,h3.indexOf("</font>"))+h3.substring(h3.indexOf("</font>")+7,h3.length());	
			
			//System.out.println(weakday);
			//System.out.println(h3);
			if(weatherC==null || weatherC.equals(""))
				weatherC="-";
			List<String> listImg = dualWithWeather(weatherC);
			try {
				pst.setString(8,rettemp);
				pst.setString(9,windDir+""+windnum);
				pst.setString(10,humidity);
				if(flag == 1){
					pst.setString(11,weatherC);
					pst.setString(12,windC);
					pst.setString(13,th);
					pst.setString(14,tl);
					pst.setString(19,listImg.get(0));
					pst.setString(20,listImg.get(1));
				}else if(flag == 2){
					pst.setString(15,weatherC);
					pst.setString(16,windC);
					pst.setString(17,th);
					pst.setString(18,tl);
					pst.setString(21,listImg.get(0));
					pst.setString(22,listImg.get(1));
					end=true;
				}
				//区县编码
				String contyCode = getCountyCode(name);
				pst.setString(23,contyCode);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			flag += 1;
			if(end){
				try {
					pst.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				end = false;
			}
		}
		log.info(name+" 气象数据入库成功 ");
		
	}
    
	public String weatherImg(String w){
    	String img = "";
    	if(w.indexOf("阴")>-1){
    		img = "yin";
    	}
    	if(w.indexOf("晴")>-1){
    		img = "qing";
    	}
    	if(w.indexOf("雨")>-1){
    		img = "yu";
    	}
    	if(w.indexOf("雪")>-1){
    		img = "xue";
    	}
    	if(w.indexOf("雨夹雪")>-1){
    		img = "yujiaxue";
    	}
    	if(w.indexOf("多云")>-1){
    		img = "duoyun";
    	}
    	if(w.indexOf("雾")>-1){
    		img = "wu";
    	}
		return img;	
    }
	
	private String getCountyCode(String name) {
		String countycode="370100";
		if(name.equals("jinan")){
			countycode="370100";
		}else if(name.equals("lixiaqu")){
			countycode="370102";
		}else if(name.equals("lichengqu")){
			countycode="370112";
		}else if(name.equals("shizhongqu")){
			countycode="370103";
		}else if(name.equals("tianqiaoqu")){
			countycode="370105";
		}else if(name.equals("huaiyinqu")){
			countycode="370104";
		}else if(name.equals("changqing")){
			countycode="370113";
		}else if(name.equals("jiyang")){
			countycode="370125";
		}else if(name.equals("shanghe")){
			countycode="370126";
		}else if(name.equals("pingyin")){
			countycode="370124";
		}else if(name.equals("zhangqiu")){
			countycode="370181";
		}
		return countycode;
	}
	
	public List<String> dualWithWeather(String weather){
		List<String> list = new ArrayList<String>();
 		//天气图片。如果是 “多云转晴”这样的天气，则 img_path_1赋值duoyun； img_path_2赋值qing
		String imgPath1="";
		String imgPath2="";
		if(weather != null && !weather.equals("")){
			String path = "weather/";
			String imgType = ".gif";
			if(weather.contains("转")){
				String weather1 = weather.substring(0,weather.indexOf("转"));
				String weather2 = weather.substring(weather.indexOf("转")+1,weather.length());
				imgPath1 = path + weatherImg(weather1)+imgType;
				imgPath2 = path + weatherImg(weather2)+imgType;
			}else if(weather.contains("~")){
				String weather1 = weather.substring(0,weather.indexOf("~"));
				String weather2 = weather.substring(weather.indexOf("~")+1,weather.length());
				imgPath1 = path + weatherImg(weather1)+imgType;
				imgPath2 = path + weatherImg(weather2)+imgType;
			}else if(weather.contains("/")){
				String weather1 = weather.substring(0,weather.indexOf("/"));
				String weather2 = weather.substring(weather.indexOf("/")+1,weather.length());
				imgPath1 = path + weatherImg(weather1)+imgType;
				imgPath2 = path + weatherImg(weather2)+imgType;
			}else if(weather.contains("-")){
				String weather1 = weather.substring(0,weather.indexOf("-"));
				String weather2 = weather.substring(weather.indexOf("-")+1,weather.length());
				imgPath1 = path + weatherImg(weather1)+imgType;
				imgPath2 = path + weatherImg(weather2)+imgType;
			}else{
				imgPath1 = path + weatherImg(weather)+imgType;
			}
		}
		list.add(imgPath1);
		list.add(imgPath2);
		return list;
	}
}
