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
	    [#if "${result.health_grade_pc!''}"=="1"][#assign health_grade_pc="<div style='heigth:20px;width:95px;background-color:green;float:right;'> </div>A级"][/#if]
	    [#if "${result.health_grade_pc!''}"=="2"][#assign health_grade_pc="<div style='heigth:20px;width:95px;background-color:yellow;float:right;'> </div>B级"][/#if]
	    [#if "${result.health_grade_pc!''}"=="3"][#assign health_grade_pc="<div style='heigth:20px;width:95px;background-color:#CC6600;float:right;'> </div>C级"][/#if]
	    [#if "${result.health_grade_pc!''}"=="4"][#assign health_grade_pc="<div style='heigth:20px;width:95px;background-color:red;float:right;'> </div>D级"][/#if]
	    [#assign dangerous_type_pc=""]
	    [#if "${result.dangerous_type_pc!''}"=="1"][#assign dangerous_type_pc="整栋"][/#if]
	    [#if "${result.dangerous_type_pc!''}"=="2"][#assign dangerous_type_pc="局部"][/#if]
	    [#assign info_state=""]
	    [#if "${result.info_state!''}"=="0"][#assign info_state="暂存"][#else][#assign info_state="审核通过"][/#if]
				
				"${result.building_id!''}"
				,"<a href='${_servlet_url!''}/safecheck.bctrack.detail?building_id=${result.building_id!''}&info_id=${result.info_id!''}'>${result.building_address!''}</a>"
				,"${xzqh!''}"
				,"${fwcb!''}"
				,"${yt!''}"
				,"${result.building_date!''}"
				,"${jg!''}"
				,"${health_grade_pc!''}"
				,"${dangerous_type_pc!''}"
				,"${info_state!''}"	
				,"${result.info_id!''}"				
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}