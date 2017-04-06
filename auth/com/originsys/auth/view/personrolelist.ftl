<table style="width:100%" border="0">
<tr><td width="200" valign="top">
[#global web=JspTaglibs["/WEB-INF/eap.tld"]]
[@web.block  site_id="eap2" action_id="auth.personalinfo" component_id="auth"/]
</td><td valign="top">
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;我的角色
	</div>
	<table width="100%" border="0" cellpadding="0" cellspacing="1" style="line-height:30px;table-layout:fixed;">
		<tr class="odd">
			<td align="center" width="100px">角色编号</td>
			<td align="center" width="150px">角色名称</td>
			<td align="center">角色描述</td>
		</tr>
		[#list block.rolelist as result]
		[#if result_index%2==1]
		<tr class="odd">
		[#else]
		<tr>
		[/#if]
			<td>${result.role_id!''}</td>
			<td>${result.role_name!''}</td>
			<td>${result.role_description!''}</td>
		</tr>
		[/#list]
	</table>
</div>
</td></tr></table>