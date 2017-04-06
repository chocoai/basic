{ 
  "total": "${block.page.totalpage}", 
  "page": "${block.page.currentpage}", 
  "records": "${block.page.totalnum}",
  "rows" : [
 [#list block.resultList as result]
 {"cell" :[				
				"${result.building_id!''}"
				,"${result.accident_id!''}"
				,"<a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safecheck.accident.detail?accident_id=${result.accident_id!''}','','dialogWidth:600px;dialogHeight:450px;center:1;')>${result.accident_name!''}</a>"
				,"${result.accident_date?string("yyyy-MM-dd")}"
				,"${result.accident_type!''}"
				,"${result.accident_reporter!''}"
				,"${result.accident_description!''}"
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}