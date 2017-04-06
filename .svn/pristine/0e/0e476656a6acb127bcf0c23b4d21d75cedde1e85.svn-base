{ 
  "total": "${userlist.page.totalpage}", 
  "page": "${userlist.page.currentpage}", 
  "records": "${userlist.page.totalnum}",
  "rows" : [
 [#list userlist.userlist as user]
 {"cell" :["${user.mem_id!''}", "${user.family_name!''}${user.firstname!''}", "${user.mem_name!''}",
 [#if user.register_time?exists]"${user.register_time?string("yyyy-MM-dd")}"[#else]""[/#if],
 [#if user.last_time?exists]"${user.last_time?string("yyyy-MM-dd")}"[#else]""[/#if],
 [#if "${user._internal_state!''}"=="0"]"待审核"[#elseif "${user._internal_state!''}"=="1"]"正常"[#elseif "${user._internal_state!''}"=="2"]"驳回"[#else]"禁用"[/#if]
 ]}[#if user_has_next],[/#if]
 [/#list]
  ]
}