{"root":[
[#list map.list as it] 
{"version_number":"${it.version_number!''}","default_map":"${it.default_map!''}","version_name":"${it.version_name!''}","status":"${it.status!''}","rownum":"${it.rownum!''}"}
[#if it_has_next],[/#if]
[/#list]
]
}
