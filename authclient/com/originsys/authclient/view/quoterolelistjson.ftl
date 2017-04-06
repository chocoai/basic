{ 
  "total": "${role.page.totalpage}", 
  "page": "${role.page.currentpage}", 
  "records": "${role.page.totalnum}",
  "rows" : [
 [#list role.rolelist as role]
 {"cell" :["${role.role_id!''}", "${role.role_name!''}","${role.role_description!''}"]}[#if role_has_next],[/#if]
 [/#list]
  ]
}