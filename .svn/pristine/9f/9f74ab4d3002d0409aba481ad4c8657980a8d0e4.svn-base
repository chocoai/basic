{ 
  "total": "${block.page.totalpage}", 
  "page": "${block.page.currentpage}", 
  "records": "${block.page.totalnum}",
  "rows" : [
 [#list block.resultList as result]
 {"cell" :[		
 		[#assign yt="${result.use_desgin!''}"]
	    [#if EnumService.getEnum('sjyt')?exists]
	    [#list EnumService.getEnum('sjyt') as enum]
			[#if "${result.use_desgin!''}"=="${enum.enum_value!''}"]
				[#assign yt="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
		[#assign jg="${result.build_struct!''}"]
	    [#if EnumService.getEnum('fwjg')?exists]
	    [#list EnumService.getEnum('fwjg') as enum]
			[#if "${result.build_struct!''}"=="${enum.enum_value!''}"]
				[#assign jg="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
		[#assign fwcb="${result.real_type!''}"]
	    [#if EnumService.getEnum('fwcb')?exists]
	    [#list EnumService.getEnum('fwcb') as enum]
			[#if "${result.real_type!''}"=="${enum.enum_value!''}"]
				[#assign fwcb="${enum.enum_name!''}"]
			[/#if]
		[/#list]
	    [/#if]
	    [#assign xzqh="${result.builiding_region!''}"]
	    [#if EnumService.getEnum('xzqh')?exists]
	    [#list EnumService.getEnum('xzqh') as enum]
			[#if "${result.builiding_region!''}"=="${enum.enum_value!''}"]
				[#assign xzqh="${enum.enum_name!''}"]
			[/#if]
		[/#list]
	    [/#if]
	    [#assign health_grade_pc=""]
	    [#if "${result.health_grade_pc!''}"=="1"][#assign health_grade_pc="无危险点房屋"][/#if]
	    [#if "${result.health_grade_pc!''}"=="2"][#assign health_grade_pc="存在危险点房屋"][/#if]
	    [#if "${result.health_grade_pc!''}"=="3"][#assign health_grade_pc="局部危险房屋"][/#if]
	    [#if "${result.health_grade_pc!''}"=="4"][#assign health_grade_pc="整幢危险房屋"][/#if]
	    [#assign health_grade_jd=""]
	    [#if "${result.health_grade_jd!''}"=="1"][#assign health_grade_jd="<div style='heigth:20px;width:95px;background-color:green;float:right;'> </div>A级"][/#if]
	    [#if "${result.health_grade_jd!''}"=="2"][#assign health_grade_jd="<div style='heigth:20px;width:95px;background-color:yellow;float:right;'> </div>B级"][/#if]
	    [#if "${result.health_grade_jd!''}"=="3"][#assign health_grade_jd="<div style='heigth:20px;width:95px;background-color:#CC6600;float:right;'> </div>C级"][/#if]
	    [#if "${result.health_grade_jd!''}"=="4"][#assign health_grade_jd="<div style='heigth:20px;width:95px;background-color:red;float:right;'> </div>D级"][/#if]		
				
				"${result.building_id!''}"
				,"<a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safecheck.buildingbase.detail?building_id=${result.building_id!''}','','dialogWidth:1000px;dialogHeight:600px;center:1;')>${result.check_address!''}</a>"
				,"${result.building_address!''}"
				,"${xzqh!''}"
				,"${fwcb!''}"
				,"${yt!''}"
				,"${result.building_date!''}"
				,"${jg!''}"
				,"${health_grade_pc!''}"
				,"${health_grade_jd!''}"	
				,"<a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safecheck.buildingmapidenty?building_mapid=${result.building_id!''}','','dialogWidth:1000px;dialogHeight:600px;center:1;')>定位</a>"		
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}