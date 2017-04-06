{ 
  "total": "${block.page.totalpage}", 
  "page": "${block.page.currentpage}", 
  "records": "${block.page.totalnum}",
  "rows" : [
 [#list block.resultList as result]
 {"cell" :[
				"${result.jdtask_id!''}"
				,"${result.building_id!''}"
				,"${result.building_newaddress!''}"
				,"${result.building_address!''}"
				,[#assign qh=""]
				[#list EnumService.getEnum('xzqh') as enum]
				[#if "${result.building_region!''}"=="${enum.enum_value!''}"][#assign qh="${enum.enum_name!''}"][#break][/#if]
				[/#list]
				"${qh!''}"
				,"${result.building_date!''}"
				,"${result.management_unit!''}"
				,"${result.owner!''}"
				,"${result.agent!''}"
				,"${result.data_origin!''}"
				,[#assign safe_grade=""]
				[#if "${result.safe_grade!''}"=="1"][#assign safe_grade="<div style='heigth:20px;width:70px;background-color:green;float:right;'> </div>A级"][/#if]
			    [#if "${result.safe_grade!''}"=="2"][#assign safe_grade="<div style='heigth:20px;width:70px;background-color:yellow;float:right;'> </div>B级"][/#if]
			    [#if "${result.safe_grade!''}"=="3"][#assign safe_grade="<div style='heigth:20px;width:70px;background-color:#CC6600;float:right;'> </div>C级"][/#if]
			    [#if "${result.safe_grade!''}"=="4"][#assign safe_grade="<div style='heigth:20px;width:70px;background-color:red;float:right;'> </div>D级"][/#if]
				"${safe_grade!''}"
				,[#if result.add_time?exists]
						"${result.add_time?date}"
					[#else]
						""
					[/#if]
				,"<a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safecheck.buildingmapidenty?building_mapid=${result.building_id!''}','','dialogWidth:1000px;dialogHeight:600px;center:1;')>定位</a>"			
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}