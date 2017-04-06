package com.originsys.realtygis.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.realtygis.domain.BuildingStructure;
import com.originsys.realtygis.domain.HouseHeightRange;

public class ALLHouseThemeQuery extends BaseAction implements IGet {
	public DataAndView execute(RequestAction arg0) throws Exception {
		// TODO Auto-generated method stub
		String parmas=arg0.getParameter("programes");
		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
		//HouseHeightRange range=new HouseHeightRange();//定义一个量存储结果
		Map<String, Object> map=new HashMap<String,Object>();
		String sqlacrion=null;
		BuildingStructure bust=new BuildingStructure();
		if("buildarea".equals(parmas)){
			sqlacrion = "Realtygis.househeight";
		}
		if("builddata".equals(parmas)){
			sqlacrion="Realtygis.buildingdatacount";
		}
		if("buildtype".equals(parmas)){
			sqlacrion="Realtygis.buildingtypecount";
		}
        if("buildstructure".equals(parmas)){
        	bust.setSteel("钢");
        	bust.setMixedsteel("钢混");
        	bust.setSteelconcrete("砼");
        	bust.setMixed("混");
        	bust.setBrick("砖");
        	bust.setBrickwood("砖木");
        	bust.setOther("其");     	
        	sqlacrion="Realtygis.buildingstructurecount";
		}
        if("buildnature".equals(parmas)){
        	sqlacrion="Realtygis.buildingnaturecount";
		 }
        if("builduse".equals(parmas)){
        	sqlacrion="Realtygis.buildingusecount";
        }
		List<HouseHeightRange> househeight=(List)sc.queryForList(sqlacrion, bust);
		if(!"buildarea".equals(parmas) && !"builddata".equals(parmas)){
			if("buildtype".equals(parmas)){
				//A test2 = (A) list.get(0)
				HouseHeightRange house0=(HouseHeightRange) househeight.get(0);
				HouseHeightRange house1=(HouseHeightRange) househeight.get(1);
				HouseHeightRange house2=(HouseHeightRange) househeight.get(2);
				HouseHeightRange house3=(HouseHeightRange) househeight.get(3);
				house0.range_name ="平房";
				house1.range_name ="多层";
				house2.range_name ="小高层";
				house3.range_name ="高层";
			}
	        if("buildstructure".equals(parmas)){
	        	HouseHeightRange house0=(HouseHeightRange) househeight.get(0);
				HouseHeightRange house1=(HouseHeightRange) househeight.get(1);
				HouseHeightRange house2=(HouseHeightRange) househeight.get(2);
				HouseHeightRange house3=(HouseHeightRange) househeight.get(3);
				HouseHeightRange house4=(HouseHeightRange) househeight.get(4);
				HouseHeightRange house5=(HouseHeightRange) househeight.get(5);
				HouseHeightRange house6=(HouseHeightRange) househeight.get(6);
				house0.range_name ="钢结构";
				house1.range_name ="钢、钢混结构";
				house2.range_name ="钢砼结构";
				house3.range_name ="混合结构";
				house4.range_name ="砖木结构";
				house5.range_name ="木结构";
				house6.range_name ="其他结构";
			}
	        if("buildnature".equals(parmas)){
	        	HouseHeightRange house0=(HouseHeightRange) househeight.get(0);
				HouseHeightRange house1=(HouseHeightRange) househeight.get(1);
				HouseHeightRange house2=(HouseHeightRange) househeight.get(2);
				HouseHeightRange house3=(HouseHeightRange) househeight.get(3);
				HouseHeightRange house4=(HouseHeightRange) househeight.get(4);
				HouseHeightRange house5=(HouseHeightRange) househeight.get(5);
				HouseHeightRange house6=(HouseHeightRange) househeight.get(6);
				HouseHeightRange house7=(HouseHeightRange) househeight.get(7);
	        	house0.range_name ="国有房产";
				house1.range_name ="集体所有房产";
				house2.range_name ="私有房产";
				house3.range_name ="其他房产";
				house4.range_name ="股份制企业房产";
				house5.range_name ="港、澳、台投资房产";
				house6.range_name ="涉外房产";
				house7.range_name ="联营企业房产";
			 }
	        if("builduse".equals(parmas)){
	        	HouseHeightRange house0=(HouseHeightRange) househeight.get(0);
				HouseHeightRange house1=(HouseHeightRange) househeight.get(1);
				HouseHeightRange house2=(HouseHeightRange) househeight.get(2);
	        	house0.range_name ="住宅";
				house1.range_name ="非住宅";
				house2.range_name ="商业服务";
	        }
		}
		
		map.put("houselist",househeight);
	    map.put("range", bust);
		return new DataAndView(map,"map");
	}
}
