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
"certificate":"${block.safeassessors.certificate!''}",
"certificate_number":"${block.safeassessors.certificate_number!''}",
"certificate_date":[#if block.safeassessors.certificate_date?exists]"${block.safeassessors.certificate_date?date}"[#else]""[/#if],
"professional_titles":"${block.safeassessors.professional_titles!''}",
"work_years":"${block.safeassessors.work_years!''}",
"professional":"${block.safeassessors.professional!''}",
"signature":"${block.safeassessors.signature!''}"
}