package com.originsys.safemanage.statistics.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.realtygis.domain.HouseHeightRange;
import com.originsys.safemanage.domain.TWFZZ;

public class WFZZHz extends BaseAction implements IGet{
	
	List list1;
	List list2;
	/**
	 * 类说明：危房整治汇总
	 * @创建时间：2014年6月11日
	 * @作者：zhanglf
	 */
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {	
		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
		//一个房屋既存在于维修加固，也存在于停用拆除。
		//select distinct building_id,t.builiding_region,t.wfzz_type from t_wfzz t;
		//select building_id,t.builiding_region,id from t_wfzz t group by building_id,t.builiding_region,id;
		//不管是一个房屋是否属于哪种类型，只按一次算
		//select * from (select s.*,rownum rn from t_wfzz s ) x where x.rn in (select min(rownum) from t_wfzz group by building_id,builiding_region) order by create_time desc;
		/**
		List<TWFZZ> l1 = sc.queryForList("Safecheck.getwfzz");//获取危房整治中需要汇总的数据
		//归类整理
		list1 = new ArrayList<Map<String,List<String>>>();
		list2 = new ArrayList<Map<String,List<String>>>();
		if(l1!=null && l1.size()>0){
			for (int i = 0; i < l1.size(); i++) {
				TWFZZ twfzz = l1.get(i);
				String type= twfzz.getWfzz_type();
				if(type.equals("1")){
					dualWithRegion(twfzz,list1);
				}else if(type.equals("2")){
					dualWithRegion(twfzz,list2);
				}
			}
		}
		Map map=new HashMap();
		List relist = new ArrayList();
		Map map2 = new HashMap();
		List l2 = new ArrayList();
		//整理后查询分类数据
		if(list1!=null && list1.size()>0){
			for(int k=0;k<list1.size();k++){
				Map map1 =(Map) list1.get(k);
				Iterator it = map1.entrySet().iterator();
				while (it.hasNext()) {
					Entry en = (Entry) it.next();
					String key = (String) en.getKey();
					List<String> bids = (List<String>) map1.get(key);
					String bidStr="";
					for(String s:bids){
						bidStr+=s+",";
					}
					bidStr = bidStr.substring(0, bidStr.lastIndexOf(","));
					l2 = sc.queryForList("Safecheck.getwfzzTJ",bidStr);
					
					Iterator i = map2.entrySet().iterator();
					boolean b = false;
					while (it.hasNext()) {
						Entry entry = (Entry) i.next();
						String key1 = (String) entry.getKey();
						if(key.equals(key1)){
							List l = (List) map1.get(key);
							l.addAll(l2);
							b=true;
						}
					}
					if(!b){
						map2.put(key, l2);
					}
					
				}
			}
		}
		
		
		*/
		Map map=new HashMap();
		List relist = new ArrayList();
		Map map2 = new HashMap();
		map2.put("r", "历下区");
		List list = new ArrayList();
		for(int j=0;j<8;j++){
			Map m = new HashMap();
			m.put("c", (j+1)+"");
			list.add(m);
		}
		map2.put("countlist", list);
		relist.add(map2);
		String current_time=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		map.put("current_time", current_time);
		map.put("relist", relist);
		//map.put("totallist", countlist);
		//map.put("totalcount", totalcount);
		
		return new DataAndView<Map>(map, "map");
}
	private void dualWithRegion(TWFZZ twfzz,List list){
		String r = twfzz.getBuiliding_region();
		if (list!=null && list.size()>0) {
			for (int i = 0; i < list.size(); i++) {
				Map map = (Map) list.get(i);
				Iterator<Entry<String, List<String>>> it = map.entrySet().iterator();
				boolean b = false;
				while (it.hasNext()) {
					Entry<String,List<String>> entry = it.next();
					String key = entry.getKey();
					if(r.equals(key)){
						List l = (List) map.get(key);
						l.add(twfzz.getBuilding_id());
						b=true;
					}
				}
				if(!b){
					Map m = new HashMap();
					List<String> l = new ArrayList<String>();
					l.add(twfzz.getBuilding_id());
					m.put(r, l);
					list.add(m);
				}
			}
		}else {
			Map map = new HashMap();
			List<String> l = new ArrayList<String>();
			l.add(twfzz.getBuilding_id());
			map.put(r, l);
			list.add(map);
		}
	}
}