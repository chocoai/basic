{ 
  "total": "${block.page.totalpage}", 
  "page": "${block.page.currentpage}", 
  "records": "${block.page.totalnum}",
  "rows" : [
 [#list block.applist as result]
 {"cell" :[
				"${result.client_id!''}"
				,"${result.client_secret!''}"
				,"${result.app_name!''}"
				,"${result.app_url!''}"
				,[#assign state=""]
				[#if "${result.app_state!''}"=="0"][#assign state="待审核"][/#if]
				[#if "${result.app_state!''}"=="1"][#assign state="审核通过"][/#if]
				[#if "${result.app_state!''}"=="2"][#assign state="审核驳回"][/#if]
				"${state!''}"
				,"<button type='button' onclick=showModalDialog('${_servlet_url!''}/auth.app.detail?client_id=${result.client_id!''}','','dialogWidth:600px;dialogHeight:600px;center:1;')>明&nbsp;&nbsp;细</button>"
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}