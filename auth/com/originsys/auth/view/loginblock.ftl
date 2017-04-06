<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript">
jQuery().ready(function(){

	$("#form").validate({
		rules: {
			mem_name:{
				required:true
			},
			mem_pass:{
				required:true
			}
		},
		messages: {
			mem_name:{
				required:"请输入用户名"
			},
			mem_pass:{
				required:"请输入密码"
			}
		}
	});
});
function setCurrOrgan(orgid,orgname){
	$.post("${_servlet_url!''}/auth.setcurorgan?organ_id="+orgid+"&organ_name="+orgname,"",
			function(data,textStatus){
				var jdata=jQuery.parseJSON(data);
				if(jdata.success==1){
					alert("保存成功！");
				}else{
					alert("操作失败！");
				}
		});
}
</script>
<style type="text/css">
	#rtable tr{
		height:25px
	}
	form.cmxform label.error, label.error {
	/* remove the next line when you have trouble in IE6 with labels in list */
	color: red;
	}
.txt_sty{width:140px; height:20px;}
.txt_sty2{width:60px; height:20px;}
.but_sty{ width:136px;}
.but_sty, .but_sty2, .but_sty3, .but_sty4{ height:28px; color:#2c7ca1; font-size:14px; font-weight:900;}
.but_sty2{width:202px;}
.but_sty3{width:91px;}
.but_sty4{width:102px;}
.jr_but_sty{width:180px; height:25px;}
</style>
<!-- div class="${system.skin!''}" width="100%" -->
<div class="widget-title-normal">
	<div class="child">
		<span class="widget-title-text">个人用户登录</span>
	</div>
</div>
<div class="widget-content-body">
	<div class="widget-news-content">
		
		[#assign error=session.getAttribute("error")!'']
		[#if "${error}"!="1"]
		<font color="red">[#if "${error}"=="7"]动态密码不正确[/#if]</font>
		<font color="red">[#if "${error}"=="6"]验证码不正确[/#if]</font>
		<font color="red">[#if "${error}"=="5"]用户未激活，请登录邮箱激活[/#if]</font>
		<font color="red">[#if "${error}"=="4"]基本信息不存在[/#if]</font>
		<font color="red">[#if "${error}"=="3"]密码不正确[/#if]</font>
		<font color="red">[#if "${error}"=="2"]用户不存在[/#if]</font>
		<font color="red">[#if "${error}"=="0"]验证码不正确[/#if]</font>
		<form method="post" action="${_servlet_url!''}/auth.login" id="form">
			<input type="hidden" name="login_flag" value="1">
			[#if "${block.client_id!''}"==""]
			<input type="hidden" name="reDirectURL" value="${_server_url!''}/eap/">
			[#else]
			<input type="hidden" name="client_id" value="${block.client_id!''}">
			[/#if]
			<table width="229px" border="0" cellspacing="0" cellpadding="0" align="center">
		    <tr>
		      <td height="30">用户名：</td>
		      <td height="30"><input type="text" name="mem_name" class="txt_sty" value="${session.getAttribute("empusername")!''}"/></td>
		    </tr>
		    <tr>
		      <td height="30">密&nbsp;码：</td>
		      <td height="30"><label>
		        <input type="password" name="mem_pass" class="txt_sty" value="${session.getAttribute("emppassword")!''}"/>
		      </label></td>
		    </tr>
		    <tr>
		      <td height="30">验证码：</td>
		      <td height="30"><label>
		        <input type="text" name="validatecode" id="validatecode" class="txt_sty2" />&nbsp;
		        <img src="${_servlet_url!''}/commonservice.login.checkcodeimg" align="absmiddle" border="0" id="ccimg" height="20px">
		      </label></td>
		    </tr>
		    <tr>
		      <td height="30" colspan="2" style="color:#2c7ca1; text-align:center;">
		      <a href="${_servlet_url!''}/auth.forfindname">忘记用户名?</a> | <a href="${_servlet_url!''}/auth.passwordforfind1">忘记密码?</a> | <a href="${_servlet_url!''}/auth.reg">注册新用户</a></td>
		      </tr>
		    <tr>
		      <td height="30" colspan="2" align="center">
		        <input type="submit" name="Submit" value="登  录" class="but_sty"/>
			  </td>
		      </tr>
		  </table>
		</form>
		[#else][#--登录成功了--]
		<form>
		 <table width="229px" height="170" border="0" cellspacing="0" cellpadding="0" align="center">
	    <tr>
	      <td height="35" align="center" style="font:14px/35px '微软雅黑';">${user.family_name!''}${user.firstname!''} 你好！</td>
	    </tr>
	    <tr>
	      <td height="33" align="center"><input name="Submit52" type="button" class="jr_but_sty" value="用户信息" onclick="javascript:window.location='${_servlet_url!''}/auth.person.userinfo';" /></td>
	    </tr>
	    <tr>
	      <td height="33" align="center"><input name="Submit5" type="button" class="jr_but_sty" value="退出" onclick="javascript:window.location='${_servlet_url!''}/auth.loginout';" /></td>
	    </tr>
	   </table>
	</form>
		[/#if]
	</div>
</div>
<div class="widget-bottom">
	<div class="widget-bottom-right"></div>
</div>
<!-- /div -->