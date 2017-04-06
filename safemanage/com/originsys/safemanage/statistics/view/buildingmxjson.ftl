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

				"${result.building_id!''}"
				,"${result.check_address!''}"
				,"${result.building_address!''}"
				,"${xzqh!''}"
				,"${fwcb!''}"
				,"${yt!''}"
				,"${result.building_date!''}"
				,"${jg!''}"
				,"${health_grade_pc!''}"
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}