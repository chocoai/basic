{ 
  "total": "${block.page.totalpage}", 
  "page": "${block.page.currentpage}", 
  "records": "${block.page.totalnum}",
  "rows" : [
 [#list block.resultList as result]
 {"cell" :[
 				[#assign xzqh="${result.region!''}"]
			    [#if EnumService.getEnum('xzqh')?exists]
			    [#list EnumService.getEnum('xzqh') as enum]
					[#if "${result.region!''}"=="${enum.enum_value!''}"]
						[#assign xzqh="${enum.enum_name!''}"]
					[/#if]
				[/#list]
			    [/#if]
	    
					"${result.mem_id!''}"
				,
					"${result.mem_name!''}"
				,
					"${result.fullname!''}"
				,
					[#if "${result.isenable!''}"=="0"]
						"<font color='red'>禁用</font>"
					[#else]
						"正常"
					[/#if]
				,
					"[#if result.register_time?exists]${result.register_time?string("yyyy-MM-dd")}[/#if]"
				,
					"[#if result.last_time?exists]${result.last_time?string("yyyy-MM-dd")}[/#if]"
				,
					"${xzqh!''}"
				
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}