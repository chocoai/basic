<!--应用详细-->
<style>
.rightpad{text-align:right;padding-right:7px;background-color:#EAF6FD;}
.leftpad{padding-left:2px;background-color:#F2F9FF;}
</style>
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;应用明细
	</div>	
<form class="cmxform" style="margin:0" action="${_servlet_url!''}/auth.app.insert" method="post" id="updateForm">
	<!--input type="hidden" name="com.eap.token" id="com.eap.token" value="${request.getToken()!''}" /-->
	<table width="100%" border="0" cellpadding="0" cellspacing="1" style="table-layout:fixed;line-height:30px;">
		<tr>
			<td class="rightpad" width="30%">应用名称：</td>
			<td class="leftpad">
				${block.app_name!''}
			</td>
		</tr>
		<tr>
			<td class="rightpad" width="30%">应用KEY：</td>
			<td class="leftpad">
				${block.client_id!''}
			</td>
		</tr>
		<tr>
			<td class="rightpad" width="30%">应用密钥：</td>
			<td class="leftpad">
				${block.client_secret!''}
			</td>
		</tr>
		<tr>
			<td class="rightpad">应用地址：</td>
			<td class="leftpad">
				${block.app_url!''}
			</td>
		</tr>
		<tr>
			<td class="rightpad">授权处理地址：</td>
			<td class="leftpad">
				${block.redirect_uri!''}
			</td>
		</tr>
		<tr>
			<td class="rightpad">应用状态：</td>
			<td class="leftpad">
				[#if "${block.app_state!''}"=="0"]待审核[/#if]
				[#if "${block.app_state!''}"=="1"]审核通过[/#if]
				[#if "${block.app_state!''}"=="2"]审核驳回[/#if]
			</td>
		</tr>
		<tr>
			<td class="rightpad">应用图标：</td>
			<td class="leftpad">
				[#if block.app_icon?exists && "${block.app_icon!''}"!=""]
				<img src="${block.app_icon!''}">
				[/#if]
			</td>
		</tr>
		<tr>
			<td class="rightpad">应用介绍：</td>
			<td class="leftpad">
				${block.app_desc!''}
			</td>
		</tr>
		<tr><td colspan="2">&nbsp;</td></tr>
		<tr>
			<td></td>
			<td style="background-color:#FFFFFF;">
				<button type="button" onclick="window.close();">返回</button>
			</td>
		</tr>
	</table>
</form>