{
  "total": "${map.page.totalpage}", 
  "page": "${map.page.currentpage}", 
  "records": "${map.page.totalnum}",
"rows" :[
[#list map.list as it] 		
{"cell" :["${it.building_id!''}","${it.building_mapid!''}","${it.building_address!''}","${it.building_number!''}","${it.building_date!''}","${it.floor_count!''}","<div style='cursor:pointer'>地图定位</div>","<div style='cursor:pointer'>楼盘表</div>","<div style='cursor:pointer'>分层分户图</div>"]}	
[#if it_has_next],[/#if]
[/#list]
]
}