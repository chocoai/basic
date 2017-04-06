package com.originsys.realtygis.dataSyn;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.originsys.eap.action.BaseAction;

public class WeatherDataSyn extends BaseAction implements Job {
	public static Map<String,String> urls;
	public static Map<String,String> urlsCW;//CW:China Weather  http://www.weather.com.cn/

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//System.out.println("weather data synchronize start..............");
		log().info("weather data synchronize start..............");
		getChinaWeatherData();
		getTianqiData();
		log().info("weather data synchronize end..............");
		//System.out.println("weather data synchronize end..............");
	}
	
	public static void main(String[] args) {
		
		getChinaWeatherData();
		getTianqiData();
		//System.exit(0);
		
		//jsonDemo();
	}

	private static void jsonDemo() {
		String str = "{\"od\":{\"od0\":\"20141114140000\",\"od1\":\"济南\",\"od2\":[{\"od21\":\"14\",\"od22\":\"13\",\"od23\":\"32\",\"od24\":\"东北风\",\"od25\":\"2\",\"od26\":\"0\",\"od27\":\"24\"},{\"od21\":\"13\",\"od22\":\"13\",\"od23\":\"49\",\"od24\":\"东北风\",\"od25\":\"1\",\"od26\":\"0\",\"od27\":\"27\"},{\"od21\":\"12\",\"od22\":\"13\",\"od23\":\"24\",\"od24\":\"东北风\",\"od25\":\"2\",\"od26\":\"0\",\"od27\":\"27\"},{\"od21\":\"11\",\"od22\":\"12\",\"od23\":\"338\",\"od24\":\"北风\",\"od25\":\"2\",\"od26\":\"0\",\"od27\":\"31\"},{\"od21\":\"10\",\"od22\":\"10\",\"od23\":\"311\",\"od24\":\"西北风\",\"od25\":\"1\",\"od26\":\"0\",\"od27\":\"34\"},{\"od21\":\"09\",\"od22\":\"8\",\"od23\":\"153\",\"od24\":\"东南风\",\"od25\":\"1\",\"od26\":\"0\",\"od27\":\"38\"},{\"od21\":\"08\",\"od22\":\"4\",\"od23\":\"148\",\"od24\":\"东南风\",\"od25\":\"1\",\"od26\":\"0\",\"od27\":\"47\"},{\"od21\":\"07\",\"od22\":\"3\",\"od23\":\"134\",\"od24\":\"东南风\",\"od25\":\"2\",\"od26\":\"0\",\"od27\":\"55\"},{\"od21\":\"06\",\"od22\":\"3\",\"od23\":\"144\",\"od24\":\"东南风\",\"od25\":\"2\",\"od26\":\"0\",\"od27\":\"51\"},{\"od21\":\"05\",\"od22\":\"3\",\"od23\":\"121\",\"od24\":\"东南风\",\"od25\":\"2\",\"od26\":\"0\",\"od27\":\"50\"},{\"od21\":\"04\",\"od22\":\"3\",\"od23\":\"119\",\"od24\":\"东南风\",\"od25\":\"2\",\"od26\":\"0\",\"od27\":\"47\"},{\"od21\":\"03\",\"od22\":\"3\",\"od23\":\"117\",\"od24\":\"东南风\",\"od25\":\"2\",\"od26\":\"0\",\"od27\":\"45\"},{\"od21\":\"02\",\"od22\":\"4\",\"od23\":\"122\",\"od24\":\"东南风\",\"od25\":\"2\",\"od26\":\"0\",\"od27\":\"42\"},{\"od21\":\"01\",\"od22\":\"5\",\"od23\":\"113\",\"od24\":\"东南风\",\"od25\":\"2\",\"od26\":\"0\",\"od27\":\"37\"},{\"od21\":\"00\",\"od22\":\"5\",\"od23\":\"144\",\"od24\":\"东南风\",\"od25\":\"1\",\"od26\":\"0\",\"od27\":\"34\"},{\"od21\":\"23\",\"od22\":\"6\",\"od23\":\"130\",\"od24\":\"东南风\",\"od25\":\"1\",\"od26\":\"0\",\"od27\":\"31\"},{\"od21\":\"22\",\"od22\":\"6\",\"od23\":\"133\",\"od24\":\"东南风\",\"od25\":\"1\",\"od26\":\"0\",\"od27\":\"29\"},{\"od21\":\"21\",\"od22\":\"5\",\"od23\":\"143\",\"od24\":\"东南风\",\"od25\":\"1\",\"od26\":\"0\",\"od27\":\"31\"},{\"od21\":\"20\",\"od22\":\"4\",\"od23\":\"131\",\"od24\":\"东南风\",\"od25\":\"1\",\"od26\":\"0\",\"od27\":\"33\"},{\"od21\":\"19\",\"od22\":\"5\",\"od23\":\"118\",\"od24\":\"东南风\",\"od25\":\"2\",\"od26\":\"0\",\"od27\":\"31\"},{\"od21\":\"18\",\"od22\":\"7\",\"od23\":\"149\",\"od24\":\"东南风\",\"od25\":\"1\",\"od26\":\"0\",\"od27\":\"25\"},{\"od21\":\"17\",\"od22\":\"9\",\"od23\":\"282\",\"od24\":\"西风\",\"od25\":\"2\",\"od26\":\"0\",\"od27\":\"21\"},{\"od21\":\"16\",\"od22\":\"10\",\"od23\":\"268\",\"od24\":\"西风\",\"od25\":\"3\",\"od26\":\"0\",\"od27\":\"17\"},{\"od21\":\"15\",\"od22\":\"11\",\"od23\":\"287\",\"od24\":\"西风\",\"od25\":\"3\",\"od26\":\"0\",\"od27\":\"16\"},{\"od21\":\"14\",\"od22\":\"11\",\"od23\":\"229\",\"od24\":\"西南风\",\"od25\":\"2\",\"od26\":\"0\",\"od27\":\"15\"}]}}";
		JSONObject jsonobject = JSONObject.fromObject(str);
		
		String od = jsonobject.getString("od");
		System.out.println(od);
		JSONObject odObj = JSONObject.fromObject(od);
		String od0 = odObj.getString("od0");
		System.out.println("od0 "+od0);
		String od1 = odObj.getString("od1");
		System.out.println("od0 "+od1);
		//获取一个json数组
	   JSONArray array = odObj.getJSONArray("od2");
	   //将json数组 转换成 List<PassPortForLendsEntity>泛型
	   List<String> list = new ArrayList<String>();
	   for (int i = 0; i < array.size(); i++) {   
            JSONObject object = (JSONObject)array.get(i);  
            System.out.println(object);
        }
	   
	   System.out.println("&quot;OK&quot;");
	   
	  
	}

	private static void getTianqiData() {
		urls = new HashMap<String,String>();
		urls.put("jinan","http://jinan.tianqi.com/");
		urls.put("lixiaqu","http://jinan.tianqi.com/lixiaqu/");
		urls.put("lichengqu","http://jinan.tianqi.com/");//无历城区天气数据
		urls.put("shizhongqu","http://jinan.tianqi.com/");//http://jinan.tianqi.com/shizhongqu/  市中区气象数据不正确
		urls.put("tianqiaoqu","http://jinan.tianqi.com/tianqiaoqu/");
		urls.put("huaiyinqu","http://jinan.tianqi.com/huaiyinqu/");
		urls.put("changqing","http://jinan.tianqi.com/changqing/");
		
		urls.put("jiyang","http://jinan.tianqi.com/jiyang/");
		urls.put("shanghe","http://jinan.tianqi.com/shanghe/");
		urls.put("pingyin","http://jinan.tianqi.com/pingyin/");
		urls.put("zhangqiu","http://jinan.tianqi.com/zhangqiu/");
		
		String sql = "update weather_p t set t.weather=?,t.img_path_1=?,t.img_path_2=?," +
				"t.temperature=?,t.temperature_h=?,t.temperature_l=?,t.wind_cont=?,t.updatetime=(select sysdate from dual)," +
				"rettemp=?,retwind=?,humidity=?,weather48=?,wind_cont48=?,temph48=?,templ48=?,weawther72=?,wind_cont72=?,temph72=?,templ72=?,img48_1=?,img48_2=?,img72_1=?,img72_2=? " +
				"where t.code=?";
		DBConnect db = new DBConnect();
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = db.getConnection("jdbc:oracle:thin:@172.22.14.36:1521:orcl","fcch","fcch");
			pst = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Iterator<String> iter = urls.keySet().iterator();
		while (iter.hasNext()) {
		    String key = iter.next();
		    String value = urls.get(key);
		    WeatherThread th = new WeatherThread(key,value,pst);
		    th.run();
		}
		db.closeConnection(conn);
		
	}

	private static void getChinaWeatherData() {
		urlsCW = new HashMap<String,String>();
		urlsCW.put("jinan","http://www.weather.com.cn/weather/101120101.shtml#1d");
		urlsCW.put("changqing","http://www.weather.com.cn/weather/101120102.shtml#1d");
		urlsCW.put("shanghe","http://www.weather.com.cn/weather/101120103.shtml#1d");
		urlsCW.put("zhangqiu","http://www.weather.com.cn/weather/101120104.shtml#1d");
		urlsCW.put("pingyin","http://www.weather.com.cn/weather/101120105.shtml#1d");
		urlsCW.put("jiyang","http://www.weather.com.cn/weather/101120106.shtml#1d");
		
		String sql = "update weather_p t set " +
				"t.T_REPORTTIME=?,t.T_TEMPERATURE=?,t.T_HUMIDITY=?,t.T_WIND=?,t.T_AQI=?,t.T_PRECIPITATION=?," +
				"t.T_DATEWEAK=?,t.T12_DAYNIGHT=?,t.T12_WEA=?,t.T12_TEMP=?,t.T12_WIND=?,t.T12_SUNTIME=?," +
				"t.T24_DAYNIGHT=?,t.T24_WEA=?,t.T24_TEMP=?,t.T24_WIND=?,t.T24_SUNTIME=?," +
				
				"t.M_DATEWEAK=?,t.MD_DAYNIGHT=?,t.MD_WEA=?,t.MD_TEMP=?,t.MD_WIND=?,t.MD_SUNTIME=?," +
				"t.MN_DAYNIGHT=?,t.MN_WEA=?,t.MN_TEMP=?,t.MN_WIND=?,t.MN_SUNTIME=?," +
				
				"t.H_DATEWEAK=?,t.HD_DAYNIGHT=?,t.HD_WEA=?,t.HD_TEMP=?,t.HD_WIND=?,t.HD_SUNTIME=?," +
				"t.HN_DAYNIGHT=?,t.HN_WEA=?,t.HN_TEMP=?,t.HN_WIND=?,t.HN_SUNTIME=?" +
				"where t.code=?";
		DBConnect db = new DBConnect();
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = db.getConnection("jdbc:oracle:thin:@172.22.14.36:1521:orcl","fcch","fcch");
			pst = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Iterator<String> iter = urlsCW.keySet().iterator();
		while (iter.hasNext()) {
		    String key = iter.next();
		    String value = urlsCW.get(key);
		    ChinaWeatherThread th = new ChinaWeatherThread(key,value,pst);
		    th.run();
		}
		db.closeConnection(conn);
		
	} 

}
