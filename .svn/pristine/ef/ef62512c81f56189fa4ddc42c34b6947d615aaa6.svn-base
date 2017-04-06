{ 
  "total": "${block.page.totalpage}", 
  "page": "${block.page.currentpage}", 
  "records": "${block.page.totalnum}",
  "rows" : [
 [#list block.resultList as result]
 {"cell" :[				
	    [#assign xzqh="${result.disaster_region!''}"]
	    [#if EnumService.getEnum('xzqh')?exists]
	    [#list EnumService.getEnum('xzqh') as enum]
			[#if "${result.disaster_region!''}"=="${enum.enum_value!''}"]
				[#assign xzqh="${enum.enum_name!''}"]
			[/#if]
		[/#list]
	    [/#if]
	    [#assign disaster_type="${result.disaster_type!''}"]
	    [#if EnumService.getEnum('disaster_type')?exists]
	    [#list EnumService.getEnum('disaster_type') as enum]
			[#if "${result.disaster_type!''}"=="${enum.enum_value!''}"]
				[#assign disaster_type="${enum.enum_name!''}"]
			[/#if]
		[/#list]
	    [/#if]
	    [#assign disaster_grade=""]
		[#if "${result.disaster_grade!''}"=="1"][#assign disaster_grade="<div style='heigth:20px;width:70px;background-color:yellow;float:right;'> </div>一般"][/#if]
	    [#if "${result.disaster_grade!''}"=="2"][#assign disaster_grade="<div style='heigth:20px;width:70px;background-color:orange;float:right;'> </div>较大"][/#if]
	    [#if "${result.disaster_grade!''}"=="3"][#assign disaster_grade="<div style='heigth:20px;width:70px;background-color:#CC6600;float:right;'> </div>重大"][/#if]
	    [#if "${result.disaster_grade!''}"=="4"][#assign disaster_grade="<div style='heigth:20px;width:70px;background-color:red;float:right;'> </div>特别重大"][/#if]
		[#assign info_state=""]
	    [#if "${result.info_state!''}"=="0"][#assign info_state="未审核"][/#if]
	    [#if "${result.info_state!''}"=="1"][#assign info_state="审核通过"][/#if]
	    [#if "${result.info_state!''}"=="2"][#assign info_state="审核驳回"][/#if]
	    [#if "${result.info_state!''}"=="3"][#assign info_state="已取消"][/#if]
	    		
				"${result.disaster_id!''}"
				,"<a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safecheck.disasterwarn.detail?disaster_id=${result.disaster_id!''}','','dialogWidth:600px;dialogHeight:400px;center:1;')>${result.disaster_name!''}</a>"
				,"${xzqh!''}"
				,"${disaster_type!''}"
				,"${disaster_grade!''}"
				,[#if result.disaster_date?exists]"${result.disaster_date?date}"[#else]""[/#if]
				,"${info_state!''}"
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}