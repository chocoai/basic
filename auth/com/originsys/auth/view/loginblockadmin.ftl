<script type="text/javascript">
function dosub(){
	if($("#organ_id").val()==""){
		alert("请输入单位ID");
		return false;
	}
	if($("#organ_pass").val()==""){
		alert("请输入登录密码");
		return false;
	}
	$("#form1").submit();
}
function dosync(){
	window.showModalDialog("${_server_url!''}/portal/auth.forotpsync","","dialogWidth=450px;dialogHeight=200px");
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
</style>
<!-- div class="${system.skin!''}" width="100%" -->
<div class="widget-title-normal">
	<div class="child">
		<span class="widget-title-text">单位用户登录</span>
	</div>
</div>
<div class="widget-content-body">
	<div class="widget-news-content">
		
		[#assign error=session.getAttribute("orgcom_error")!'']
		[#if "${error}"!="1"]
		<font color="red">[#if "${error}"=="7"]动态密码不正确[/#if]</font>
		<font color="red">[#if "${error}"=="8"]登录密码不正确[/#if]</font>
		<font color="red">[#if "${error}"=="2"]单位用户不存在[/#if]</font>
		<font color="red">[#if "${error}"=="3"]单位用户待认证[/#if]</font>
		[/#if]
		<form method="post" action="${_servlet_url!''}/auth.orgcomlogin" id="form1">
			<input type="hidden" name="reDirectURL" value="${_server_url!''}/portal/">			
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
		    <tr>
		      <td height="30">单 位 ID：</td>
		      <td height="30"><input type="text" name="organ_id" class="txt_sty"/></td>
		    </tr>
		    <tr>
		      <td height="30">登录密码：</td>
		      <td height="30">
		      	<input type="password" name="organ_pass" id="organ_pass" class="txt_sty"/>
							
		      </td>
		    </tr>
		    <tr>
		      <td height="30">动态口令：</td>
		      <td height="30"><label>
		        <input type="password" name="sotp" class="txt_sty" />
		      </label></td>
		    </tr>
		    <tr>
		      <td height="30" colspan="2" style="color:#2c7ca1; text-align:center;">
			  <input type="button" name="Submit2" value="动态令牌同步" class="but_sty2"  onclick="dosync();"/>
			  </td>
		      </tr>
		    <tr>
		      <td height="30" colspan="2" >
			    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		          <tr>
		            <td height="40" align="right" style="padding-right:8px;"><input type="button" name="Submit3" onclick="dosub();" value="登  录" class="but_sty3"/></td>
					<td height="40" ><input type="button" onclick="window.location='${_servlet_url!''}/auth.orgreginfo'" value="单位注册" class="but_sty4"/></td>
		          </tr>
		        </table>	  
				</td>
		      </tr>
		  </table>
		</form>
		
	</div>
</div>
<div class="widget-bottom">
	<div class="widget-bottom-right"></div>
</div>
<!-- /div -->