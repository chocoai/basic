<link href="${_share_file_url!''}/resource/css/zcps_logincp.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function doSub(){
	if($("#name_textfield").val()==""){
		alert("请输入用户名！");
		return false;
	}
	if($("#mim_textfield").val()==""){
		alert("请输入密码！");
		return false;
	}
	if($("#yzm_textfield").val()==""){
		alert("请输入验证吗！");
		return false;
	}
	$("#expertform").submit();
}
</script>
<div class="login_wrapper">
<form method="post" action="${_servlet_url!''}/auth.login" id="expertform">
<input type="hidden" name="login_flag" value="1">
<input type="hidden" name="reDirectURL" value="${_server_url!''}/portal/zcps.zcpsBasicInfo_cpList">
  <table width="800" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="479" rowspan="6">&nbsp;</td>
      <td height="243" colspan="3">&nbsp;</td>
    </tr>
    <tr>
      <td height="24" colspan="3">
      	[#assign error=session.getAttribute("error")!'']
		[#if "${error}"!="1"]
		<font color="red">[#if "${error}"=="7"]动态密码不正确[/#if]</font>
		<font color="red">[#if "${error}"=="6"]验证码不正确[/#if]</font>
		<font color="red">[#if "${error}"=="5"]用户未激活，请登录邮箱激活[/#if]</font>
		<font color="red">[#if "${error}"=="4"]基本信息不存在[/#if]</font>
		<font color="red">[#if "${error}"=="3"]密码不正确[/#if]</font>
		<font color="red">[#if "${error}"=="2"]用户不存在[/#if]</font>
		<font color="red">[#if "${error}"=="0"]验证码不正确[/#if]</font>
		[/#if]
      </td>
    </tr>
    <tr>
      <td height="24" colspan="3"><input type="text" name="mem_name" id="name_textfield" /></td>
    </tr>
    <tr>
      <td height="3" colspan="3">&nbsp;</td>
    </tr>
    <tr>
      <td height="22" colspan="3"><input type="password" name="mem_pass" id="mim_textfield" /></td>
    </tr>
    <tr>
      <td width="107" height="40"><input type="text" name="validatecode" id="yzm_textfield" /></td>
      <td width="82"><img src="${_servlet_url!''}/commonservice.login.checkcodeimg" align="absmiddle" border="0" id="ccimg" height="26px" width="76px"></td>
      <td width="132"><a href="">看不清楚，换一张</a></td>
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
      <td align="center"><input type="button" name="button" id="login_button" value="" onclick="doSub();"/></td>
      <td><input type="button" name="button2" id="sign_button" value="" onclick="javascript:window.location='${_servlet_url!''}/auth.rega';"/></td>
    </tr>
  </table>
</form>
</div>