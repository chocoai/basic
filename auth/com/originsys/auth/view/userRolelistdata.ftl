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
				,
					[#if "${result.ischeck!''}"=="1"]"是"[#else]"否"[/#if]
				,
					"${result.preposition_role!''}"
				,
					"${result.check_url!''}"
				
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}