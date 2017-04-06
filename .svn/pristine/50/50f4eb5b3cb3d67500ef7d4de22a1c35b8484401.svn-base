{ 
  "total": "${block.page.totalpage}", 
  "page": "${block.page.currentpage}", 
  "records": "${block.page.totalnum}",
  "rows" : [
 [#list block.resultList as result]
 {"cell" :[
					"${result.role_register_id!''}"
				,
					"${result.role_id!''}"
				,
					"${result.site_id!''}"
				,
					"${result.role_name!''}"
				,
					"${result.role_description!''}"
				,[#if "${result._internal_state}"==""]""[#else]"<button onclick='modifyTypeInfo(\"${result._internal_state!''}\")'>修改属性</button>"[/#if]
				
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}