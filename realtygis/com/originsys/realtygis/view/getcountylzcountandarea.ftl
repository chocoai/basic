{"root":[
[#list map.list as it] 
{
"code":"${it.code}",
"name":"${it.name!''}",
"count":"${it.count!''}",
"area":"${it.area!''}"
}
[#if it_has_next],[/#if]
[/#list]
]
}