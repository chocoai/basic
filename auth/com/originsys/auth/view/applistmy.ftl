<!--我的应用列表-->
<table style="width:100%" border="0">
<tr><td width="200" valign="top">
[#global web=JspTaglibs["/WEB-INF/eap.tld"]]
[@web.block  site_id="eap2" action_id="auth.personalinfo" component_id="auth"/]
</td><td valign="top">
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;我的应用
	</div>
	<table width="100%" border="0" cellpadding="0" cellspacing="1" style="line-height:30px;table-layout:fixed;">
		<tr class="odd">
			<td align="center">应用名称</td>
			<td align="center">应用KEY</td>
			<td align="center">应用密钥</td>
			<td align="center" width="100">应用状态</td>
			<td align="center" width="100">详细</td>
		</tr>
		[#list block.applist as result]
		[#if result_index%2==1]
		<tr class="odd">
		[#else]
		<tr>
		[/#if]
			<td>${result.app_name!''}</td>
			<td>${result.client_id!''}</td>
			<td>${result.client_secret!''}</td>
			<td align="center">[#if "${result.app_state!''}"=="0"]待审核[/#if]
				[#if "${result.app_state!''}"=="1"]审核通过[/#if]
				[#if "${result.app_state!''}"=="2"]审核驳回[/#if]
			</td>
			<td align="center">
			<a href='javascript:void(0);' onclick=showModalDialog('${_server_url!''}/portal/auth.app.detail?client_id=${result.client_id!''}','','dialogWidth:600px;dialogHeight:600px;center:1;')>
			<font color="red">明细</font></a></td>
		</tr>
		[/#list]
	</table>
</div>
</td></tr></table>