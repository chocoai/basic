{
  "total": "${map.page.totalpage}", 
  "page": "${map.page.currentpage}", 
  "records": "${map.page.totalnum}",
"rows" :[

[#list map.list as it] 	
  [#if EnumService.getEnum('default_map')?exists]
    [#list EnumService.getEnum('default_map') as enum]
    [#if "${it.default_map!''}"=="${enum.enum_value!''}"]
{"cell" :["${it.version_number!''}","${it.version_name!''}","${it.auditor!''}","${it.publisher!''}",
          "${it.status!''}","${enum.enum_name!''}"
          ,[#if it.add_date?exists]"${it.add_date?string("yyyy-MM-dd")}"[#else]" "[/#if]
          ,"<div style='cursor:pointer'>预览</div>"]}
    [/#if]
	 [/#list]
  [/#if]
[#if it_has_next],[/#if]
  	
[/#list]

]
}


