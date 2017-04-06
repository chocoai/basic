<link href="${_share_file_url!''}/resource/css/zcps_loginorg.css" rel="stylesheet" type="text/css" />
[#assign error=session.getAttribute("orgcom_error")!'']
<script type="text/javascript">
[#if "${error}"=="1"]
	window.location.href="${_server_url!''}/portal/zcps.psblock";
[/#if]
function dosub(){
	if($("#name_textfield").val()==""){
		alert("请输入单位ID");
		return false;
	}
	if($("#mim_textfield").val()==""){
		alert("请输入登录密码");
		return false;
	}
	$("#form1").submit();
}
function dosync(){
	window.showModalDialog("${_server_url!''}/portal/auth.forotpsync","","dialogWidth=450px;dialogHeight=200px");
}
</script>
<div class="login_wrapper">
<form method="post" action="${_servlet_url!''}/auth.orgcomlogin" id="form1">
  <input type="hidden" name="reDirectURL" value="${_server_url!''}/eap/org">
  <table width="800" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="479" rowspan="6">&nbsp;</td>
      <td height="243" colspan="3">&nbsp;</td>
    </tr>
    <tr>
      <td height="24" colspan="3">
      	[#if "${error}"!="1"]
		<font color="red">[#if "${error}"=="7"]动态密码不正确[/#if]</font>
		<font color="red">[#if "${error}"=="8"]登录密码不正确[/#if]</font>
		<font color="red">[#if "${error}"=="2"]单位用户不存在[/#if]</font>
		<font color="red">[#if "${error}"=="3"]单位用户待认证[/#if]</font>
		[/#if]
      </td>
    </tr>
    <tr>
      <td height="24" colspan="3"><input type="text" name="organ_id" id="name_textfield" /></td>
    </tr>
    <tr>
      <td height="3" colspan="3">&nbsp;</td>
    </tr>
    <tr>
      <td height="22" colspan="3"><input type="password" name="organ_pass" id="mim_textfield" /></td>
    </tr>
    <tr>
      <td width="107" height="40"><input type="password" name="sotp" id="yzm_textfield" /></td>
      <td width="20">&nbsp;</td>
      <td width="194"><input type="button" name="dt_button" id="dt_button" value="" onclick="dosync();"/></td>
    </tr>
  </table>
  <table width="800" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="200">&nbsp;</td>
      <td width="298">&nbsp;</td>
      <td width="105">&nbsp;</td>
      <td width="197">&nbsp;</td>
    </tr>
    <tr>
      <td height="43" colspan="2">&nbsp;</td>
      <td align="center"><input type="button" name="button" id="login_button" value="" onclick="dosub();"/></td>
      <td><input type="button" name="button2" id="sign_button" value="" /></td>
    </tr>
  </table>
 </form>
</div>