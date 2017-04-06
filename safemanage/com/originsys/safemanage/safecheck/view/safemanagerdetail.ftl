<!--安全管理员详细页-->
[#assign result=block.safemanager]
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a6cef2">
	<caption class="td1">查看安全管理员用户类型属性表</caption>
	<tr>
		<td>用户id</td>
		<td>${result.mem_id!''}</td>
	</tr>
	<tr>
		<td>管理范围</td>
		<td>[#list EnumService.getEnum('xzqh') as enum]
				[#if "${result.region!''}"=="${enum.enum_value!''}"]${enum.enum_name!''}[/#if]
			[/#list]
		</td>
	</tr>
</table>