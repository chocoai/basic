{"root":[
[#list map.list as it] 
{"building_id":"${it.building_id!''}"}
[#if it_has_next],[/#if]
[/#list]
]
}