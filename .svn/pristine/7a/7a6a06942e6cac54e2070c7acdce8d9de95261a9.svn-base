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
	    [#assign health_grade_pc=""]
	    [#if "${result.health_grade_pc!''}"=="1"][#assign health_grade_pc="无危险点房屋"][/#if]
	    [#if "${result.health_grade_pc!''}"=="2"][#assign health_grade_pc="存在危险点房屋"][/#if]
	    [#if "${result.health_grade_pc!''}"=="3"][#assign health_grade_pc="局部危险房屋"][/#if]
	    [#if "${result.health_grade_pc!''}"=="4"][#assign health_grade_pc="整幢危险房屋"][/#if]
	    [#assign warn_grade=""]
	    [#if "${result.warn_grade!''}"=="1"][#assign warn_grade="<div style='heigth:20px;width:70px;background-color:yellow;float:right;'> </div> 临近超限"][/#if]
	    [#if "${result.warn_grade!''}"=="2"][#assign warn_grade="<div style='heigth:20px;width:70px;background-color:#CC6600;float:right;'> </div> 轻度超限"][/#if]
	    [#if "${result.warn_grade!''}"=="3"][#assign warn_grade="<div style='heigth:20px;width:70px;background-color:red;float:right;'> </div> 严重超限"][/#if]
				
				"${result.building_id!''}"
				,"<a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safecheck.buildingbase.detail?building_id=${result.building_id!''}','','dialogWidth:1000px;dialogHeight:600px;center:1;')>${result.check_address!''}</a>"
				,"${result.building_address!''}"
				,"${xzqh!''}"
				,"${result.building_date!''}"
				,"${build_right!''}"
				,"${health_grade_pc!''}"
				,"${warn_grade!''}"
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}