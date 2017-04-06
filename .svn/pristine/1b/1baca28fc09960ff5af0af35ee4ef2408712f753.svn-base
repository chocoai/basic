{ 
  "total": "${block.page.totalpage}", 
  "page": "${block.page.currentpage}", 
  "records": "${block.page.totalnum}",
  "rows" : [
 [#list block.resultList as result]
 {"cell" :[				
				"${result.building_id!''}"
				,"${result.repair_id!''}"
				,"<a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safecheck.repair.detail?repair_id=${result.repair_id!''}','','dialogWidth:600px;dialogHeight:400px;center:1;')>${result.repair_content!''}</a>"
				,"${result.repair_cost!''}"
				,"${result.repair_organ!''}"
				,"${result.repair_manager!''}"
				,"${result.manager_tel!''}"
				,"${result.complete_date?string("yyyy-MM-dd")}"
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}