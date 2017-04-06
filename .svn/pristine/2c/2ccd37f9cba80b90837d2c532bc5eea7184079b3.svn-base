<div class="ui-widget ui-corner-all" style="position: relative;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;安全鉴定员用户类型属性表
	</div>
</div>
[#assign result=block.safeassessors]
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a6cef2" style="table-layout:fixed;line-height:30px;">
	<tr>
		<td class="td1" width="150px">从业资格证书编号</td>
		<td class="td2">${result.certificate_number!''}</td>
	</tr>
	<tr>
		<td class="td1">证书取得时间</td>
		[#if result.certificate_date?exists]
			<td class="td2">${result.certificate_date?date}</td>
		[#else]
			<td class="td2">无数据</td>
		[/#if]
	</tr>
	<tr>
		<td class="td1">从业资格证书复印件</td>
		<td class="td2">[#if "${result.certificate!''}"!=""]<a href="${_servlet_url!''}/${result.certificate!''}" target="_blank">查看证书复印件</a>[/#if]</td>
	</tr>
	<tr>
		<td class="td1">专业技术职称</td>
		<td class="td2">${result.professional_titles!''}</td>
	</tr>
	<tr>
		<td class="td1">工作经验年限</td>
		<td class="td2">${result.work_years!''}</td>
	</tr>
	<tr>
		<td class="td1">从事专业</td>
		<td class="td2">${result.professional!''}</td>
	</tr>
	<tr>
		<td class="td1">手写签名</td>
		<td class="td2">[#if "${result.signature!''}"!=""]<img src="${result.signature!''}">[/#if]</td>
	</tr>
	<tr>
		<td class="td1"></td>
		<td class="td2"><button type="button" onclick="window.close();">返回</button></td>
	</tr>
</table>