[#list map.list as abc]
  	{"building_id":"${abc.building_id!''}","building_address":"${abc.building_address!''}"	  	
  	}
  	[#if abc_has_next],[/#if]
[/#list]