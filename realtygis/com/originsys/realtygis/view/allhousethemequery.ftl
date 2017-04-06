{"root":[
[#list map.houselist as house]
{"range_name":"${house.range_name}","range_value":"${house.range_value}"}
[#if house_has_next],[/#if]
[/#list]
]
}