{ 
  "total": "${block.page.totalpage}", 
  "page": "${block.page.currentpage}", 
  "records": "${block.page.totalnum}",
  "rows" : [
 [#list block.resultList as result]
 {"cell" :[
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
					"${result.work_years!''}"
				
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}