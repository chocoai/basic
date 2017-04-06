{"root":[
[#list map.list as abc]
  	{"building_id":"${abc.building_id!''}","surverproject_id":"${abc.surverproject_id!''}","unit":"${abc.unit!''}","surver":"${abc.surver!''}","use_desgin":"${abc.use_desgin!''}","real_type":"${abc.real_type!''}","tn_area":"${abc.tn_area!''}","ft_area":"${abc.ft_area!''}","build_area":"${abc.build_area!''}","noft_area":"${abc.noft_area!''}","no_area":"${abc.no_area!''}","discrepant_area":"${abc.discrepant_area!''}","sruver_date":"${abc.sruver_date!''}","surver_enddate":"${abc.surver_enddate!''}","building_number":"${abc.building_number!''}","build_struct":"${abc.build_struct!''}","graphics_code":"${abc.graphics_code!''}","graphics_number":"${abc.graphics_number!''}","input_date":"${abc.input_date!''}","floorup_count":"${abc.floorup_count!''}","floordown_count":"${abc.floordown_count!''}","city_district":"${abc.city_district!''}","building_address":"${abc.building_address!''}","building_date":"${abc.building_date!''}","floor_count":"${abc.floor_count!''}","house_count":"${abc.house_count!''}"	  	
  	}
  	[#if abc_has_next],[/#if]
[/#list]
]
}