{ 
  "total": "${role.page.totalpage}", 
  "page": "${role.page.currentpage}", 
  "records": "${role.page.totalnum}",
  "rows" : [
 [#list role.rolelist as role]
 {"cell" :["${role.role_id!''}", "${role.role_name!''}","${role.site_id!''}",[#assign issys=role.isrequest!""/][#if issys=="1"]"是"[#else]"否"[/#if],"${issys}",
 [#if "${role.ischeck!''}"="1"]"是"[#else]"否"[/#if],"${role.ischeck!''}","${role.pre_role_name!''}","${role.user_type!''}","${role.list_action!''}",
 "${role.organ_type_id!''}",
 [#if "${role._internal_state!''}"=="1"]
				    [#assign xx="<div id=buttons style=text-align:right>"]
				    	[#if access.canDo(user,'manager.role.modify')]			
						[#assign xx=xx+"<button type=button  onclick=doupdate('${role.role_id}')>修改</button>"][/#if]
						[#if access.canDo(user,'manager.role.delete')]
						[#assign xx=xx+"<button type=button onclick=javascript:doDel('${role.role_id}')>删除</button>"][/#if]
						
					[#assign xx=xx+"</div>"]
					"${xx}"
				[#else]""
			     [/#if]
 ]
 }[#if role_has_next],[/#if]
 [/#list]
  ]
}