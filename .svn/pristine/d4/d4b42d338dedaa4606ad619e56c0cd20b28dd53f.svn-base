{
"mem_id":"${block.member.mem_id!''}",
"mem_name":"${block.member.mem_name!''}",
"family_name":"${block.member.family_name!''}",
"firstname":"${block.member.firstname!''}",
"mem_sex":"${block.member.mem_sex!''}",
"mem_born":[#if block.member.mem_born?exists]"${block.member.mem_born?date!''}"[#else]""[/#if],
"mem_mail":"${block.member.mem_mail!''}",
"mem_mphone":"${block.member.mem_mphone!''}",
[#assign dpid=""][#assign dpname=""]
[#if block.department?exists]
[#assign dpid=block.department.department_id!'']
[#assign dpname=block.department.department_name!'']
[/#if]
"department_name":"${dpname!''}",
"department_id":"${dpid!''}",
"manage_scope":"${block.safecensor.manage_scope!''}",
"region":"${block.safecensor.region!''}",
"certificate":"${block.safecensor.certificate!''}",
"certificate_number":"${block.safecensor.certificate_number!''}",
"certificate_date":[#if block.safecensor.certificate_date?exists]"${block.safecensor.certificate_date?date}"[#else]""[/#if],
"professional_titles":"${block.safecensor.professional_titles!''}",
"work_years":"${block.safecensor.work_years!''}",
"professional":"${block.safecensor.professional!''}"
}