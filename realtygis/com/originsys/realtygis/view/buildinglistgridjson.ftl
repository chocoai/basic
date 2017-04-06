{
  "total": "${map.page.totalpage}", 
  "page": "${map.page.currentpage}", 
  "records": "${map.page.totalnum}",
"rows" :[
[#list map.list as it] 		
{"cell" :["${it.building_id!''}","${it.building_mapid!''}","${it.building_address!''}","${it.building_number!''}","${it.houseCount!''}","<font color='green'>${it.properCount!''}</font>","${it.building_date!''}","${it.floor_count!''}","地图定位","楼盘表","分层分户图"]}	
[#if it_has_next],[/#if]
[/#list]
]
}