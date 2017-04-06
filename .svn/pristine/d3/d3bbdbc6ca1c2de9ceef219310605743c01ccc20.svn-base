<!--安全管理员详细页-->
<div class="ui-widget ui-corner-all" style="position: relative;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;安全管理员用户类型属性表
	</div>
</div>
[#assign result=block.safemanager]
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a6cef2" style="table-layout:fixed;line-height:30px;">
	<tr>
		<td class="td1" width="150px">管理范围</td>
		<td class="td2">[#list EnumService.getEnum('xzqh') as enum]
				[#if "${result.region!''}"=="${enum.enum_value!''}"]${enum.enum_name!''}[/#if]
			[/#list]
		</td>
	</tr>
	<tr>
		<td class="td1"></td>
		<td class="td2"><button type="button" onclick="window.close();">返回</button></td>
	</tr>
</table>