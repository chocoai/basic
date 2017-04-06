{
  "total": "${map.page.totalpage}", 
  "page": "${map.page.currentpage}", 
  "records": "${map.page.totalnum}",
"rows" :[
[#list map.list as it] 		
{"cell" :["${it.house_id!''}","${it.fw_address!''}","${it.jz_area!''}","${it.ft_area!''}","${it.yt_area!''}","${it.sy_area!''}","${it.yc_area!''}","${it.birth_date!''}","${it.door_type!''}","${it.lay_num!''}",""]}	
[#if it_has_next],[/#if]
[/#list]
]
}