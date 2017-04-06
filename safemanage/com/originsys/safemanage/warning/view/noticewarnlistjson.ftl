{ 
  "total": "${block.page.totalpage}", 
  "page": "${block.page.currentpage}", 
  "records": "${block.page.totalnum}",
  "rows" : [
 [#list block.resultList as result]
 {"cell" :[				
	    [#assign xzqh="${result.builiding_region!''}"]
	    [#if EnumService.getEnum('xzqh')?exists]
	    [#list EnumService.getEnum('xzqh') as enum]
			[#if "${result.builiding_region!''}"=="${enum.enum_value!''}"]
				[#assign xzqh="${enum.enum_name!''}"]
			[/#if]
		[/#list]
	    [/#if]
	    [#assign build_right="${result.build_right!''}"]
	    [#if EnumService.getEnum('build_right')?exists]
	    [#list EnumService.getEnum('build_right') as enum]
			[#if "${result.build_right!''}"=="${enum.enum_value!''}"]
				[#assign build_right="${enum.enum_name!''}"]
			[/#if]
		[/#list]
	    [/#if]
	    [#assign over_grade=""]
	    [#if "${result.over_grade!''}"=="1"][#assign over_grade="<div style='heigth:20px;width:70px;background-color:yellow;float:right;'> </div> 临近逾期"][/#if]
	    [#if "${result.over_grade!''}"=="2"][#assign over_grade="<div style='heigth:20px;width:70px;background-color:brown;float:right;'> </div> 已逾期"][/#if]
				
				"${result.building_id!''}"
				,"<a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safecheck.buildingbase.detail?building_id=${result.building_id!''}','','dialogWidth:1000px;dialogHeight:600px;center:1;')>${result.building_address!''}</a>"
				,"${xzqh!''}"
				,"${result.entrust_user!''}"
				,"${result.linkman!''}"
				,"${result.linktel!''}"
				,"${result.jdmember!''}"
				,"${result.jd_department!''}"
				,[#if result.jd_date?exists]
						"${result.jd_date?date}"
					[#else]
						""
					[/#if]
				,[#assign dangerous_level=""]
				[#if "${result.dangerous_level!''}"=="1"][#assign dangerous_level="<div style='heigth:20px;width:70px;background-color:green;float:right;'> </div>A级"][/#if]
			    [#if "${result.dangerous_level!''}"=="2"][#assign dangerous_level="<div style='heigth:20px;width:70px;background-color:yellow;float:right;'> </div>B级"][/#if]
			    [#if "${result.dangerous_level!''}"=="3"][#assign dangerous_level="<div style='heigth:20px;width:70px;background-color:#CC6600;float:right;'> </div>C级"][/#if]
			    [#if "${result.dangerous_level!''}"=="4"][#assign dangerous_level="<div style='heigth:20px;width:70px;background-color:red;float:right;'> </div>D级"][/#if]
				"${dangerous_level!''}"
				,"${over_grade!''}"
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}