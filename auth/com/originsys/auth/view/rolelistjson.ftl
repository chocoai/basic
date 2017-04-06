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
					"${result.role_name!''}"
				,
					"${result.preposition_role!''}"
				,
					"${result.site_id!''}"
				,
					[#if "${result.ischeck!''}"=="1"]"是"[#else]"否"[/#if]
				,
					"${result.check_url!''}"
				,
					"${result.role_description!''}"
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}