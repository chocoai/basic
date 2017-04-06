<table border="0" width="600px" align="center" style="margin-top:100px;line-height:30px;background-color:#D6DBDD;">
<tr><td colspan="2">&nbsp;</td></tr>
<tr><td width="40px"></td><td>${user.family_name!''}${user.first_name!''}，你好：</td></tr>
<tr><td></td><td><b>应用授权</b></td></tr>
<tr><td></td>
	<td>
		<span style="vertical-align:middle;">
		<img src="${block.app.app_icon!''}"></span>
		&nbsp;&nbsp;${block.app.app_name!''}
	</td>
</tr>
<tr><td></td><td>将允许<font color="red">${block.app.app_name!''}</font>进行以下操作：</td></tr>
<tr><td></td><td><span style="padding-left:40px;"><input type="checkbox" checked>获取用户基本信息<span></td></tr>
<tr><td></td><td><span style="padding-left:40px;"><input type="checkbox" checked>获取用户企业信息<span></td></tr>
<tr><td></td><td><span style="padding-left:40px;"><input type="checkbox" checked>获取用户角色信息<span></td></tr>
<tr><td colspan="2" align="right"><button type="button" onclick="window.location.href='/portal/auth.authorize?client_id=${block.client_id!''}&client_secret=${block.client_secret!''}'">授权</button>
&nbsp;<button type="button" onclick="window.location.href='/eap/';">取消</button></td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
</table>