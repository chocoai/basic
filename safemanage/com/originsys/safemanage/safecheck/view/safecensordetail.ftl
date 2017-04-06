<!--安全检查员详细页-->
[#assign result=block.safecensor]
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a6cef2">
	<caption class="td1">查看安全检查员用户类型属性表</caption>
	<tr>
		<td>用户id</td>
		<td>${result.mem_id!''}</td>
	</tr>
	<tr>
		<td>管理范围</td>
		<td>${result.manage_scope!''}</td>
	</tr>
	<tr>
		<td>从业资格证书编号</td>
		<td>${result.certificate_number!''}</td>
	</tr>
	<tr>
		<td>证书取得时间</td>
		[#if result.certificate_date?exists]
			<td>${result.certificate_date?date}</td>
		[#else]
			<td>无数据</td>
		[/#if]
	</tr>
	<tr>
		<td>从业资格证书复印件</td>
		<td>${result.certificate!''}</td>
	</tr>
	<tr>
		<td>专业技术职称</td>
		<td>${result.professional_titles!''}</td>
	</tr>
	<tr>
		<td>工作经验年限</td>
		<td>${result.work_years!''}</td>
	</tr>
	<tr>
		<td>从事专业</td>
		<td>${result.professional!''}</td>
	</tr>
</table>