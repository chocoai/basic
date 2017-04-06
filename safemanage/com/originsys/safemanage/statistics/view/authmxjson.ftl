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
	    [#assign health_grade_jd=""]
	    [#if "${result.health_grade_jd!''}"=="1"][#assign health_grade_jd="<div style='heigth:20px;width:70px;background-color:green;float:right;'> </div>A级"][/#if]
	    [#if "${result.health_grade_jd!''}"=="2"][#assign health_grade_jd="<div style='heigth:20px;width:70px;background-color:yellow;float:right;'> </div>B级"][/#if]
	    [#if "${result.health_grade_jd!''}"=="3"][#assign health_grade_jd="<div style='heigth:20px;width:70px;background-color:#CC6600;float:right;'> </div>C级"][/#if]
	    [#if "${result.health_grade_jd!''}"=="4"][#assign health_grade_jd="<div style='heigth:20px;width:70px;background-color:red;float:right;'> </div>D级"][/#if]

				"${result.building_id!''}"
				,"${result.building_address!''}"
				,"${xzqh!''}"
				,"${fwcb!''}"
				,"${yt!''}"
				,"${result.building_date!''}"
				,"${jg!''}"
				,"${health_grade_jd!''}"
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}