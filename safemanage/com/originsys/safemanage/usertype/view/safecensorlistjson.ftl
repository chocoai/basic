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
					"[#if result.register_time?exists]${result.register_time?string("yyyy-MM-dd")}[/#if]"
				,
					"[#if result.last_time?exists]${result.last_time?string("yyyy-MM-dd")}[/#if]"
				,"<button onclick='modifyTypeInfo(\"${result.mem_id!''}\")'>检查员信息</button>"
				
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}