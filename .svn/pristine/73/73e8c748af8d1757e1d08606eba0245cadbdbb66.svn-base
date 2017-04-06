<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/messages_cn.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/card.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/swfobject.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="${_share_file_url!''}/resource/css/cmxform.css" />
<script language="javascript" type="text/javascript">
$(function(){
	$("#addInfo").click(function(){
		$("#updateForm").submit();
		/**var r = $('#updateForm').form('validate'); 
		if(r){
			$("#addInfo").attr("disabled","true");
		}*/
	});
	$("#updateForm").validate({
		rules: {
			mem_name:{
				required:true,
				isName:true,
				minlength: 6,
				remote:"${_servlet_url!''}/auth.isused"
			},
			validatecode:{
				required:true
			},
			mem_pass: {
				required: true,
				minlength: 6
			},
			mem_pass2: {
				required: true,
				minlength: 6,
				equalTo: "#mem_pass"
			},
			mem_question:{
				required: true
			},
			mem_answer:{
				required: true
			},
			mem_mphone:{
				required:true,
				number:true,
				maxlength:11,
				minlength:11,
				remote:"${_servlet_url!''}/auth.isused"
			},
			mem_mail:{
				required:true,
				email:true,
				remote:"${_servlet_url!''}/auth.isused"
			},
			ID_num:{
				required:true,
				isIdCardNo:true,
				remote:"${_servlet_url!''}/auth.isused"
			},
			family_name:{
				required:true,
				isCName:true
			},
			mem_sex:{
				required:true
			}
		},
		messages: {
			mem_name:{
				required:"请输入用户名",
				isName:"请正确输入用户名",
				minlength: "用户名至少6位",
				remote:"该用户名已注册"
			},
			validatecode:{
				required:"请输入验证码"
			},
			mem_pass: {
				required: "请输入密码",
				minlength: "密码至少是6位"
			},
			mem_pass2: {
				required: "请输入密码",
				minlength: "密码至少是6位",
				equalTo: "请输入和上面相同的密码"
			},
			mem_question:{
				required: "请选择密码问题"
			},
			mem_answer:{
				required: "请输入密码答案"
			},
			mem_mphone:{
				required:"请输入手机",
				number:"请输入11位数字",
				maxlength:"请输入11位数字",
				minlength:"请输入11位数字",
				remote:"该手机号已注册"
			},
			mem_mail:{
				required:"请输入邮箱",
				email:"邮箱格式不正确",
				remote:"该邮箱已注册"
			},
			ID_num:{
				required:"请输入身份证号",
				isIdCardNo:"请正确输入您的身份证号码",
				remote:"该身份证号已注册"
			},
			family_name:{
				required:"请输入姓名",
				isCName:"请输入中文姓名"
			},
			mem_sex:{
				required:"请选择性别"
			}	
		}
	});
	// 身份证号码验证 
	jQuery.validator.addMethod("isIdCardNo", function(value, element) { 
	  return this.optional(element) || idCardNoUtil.checkIdCardNo(value);     
	}, "请正确输入您的身份证号码"); 
	//用户登录名验证，只能是字母或是数字
	jQuery.validator.addMethod("isName", function(value, element) { 
	  var b = /^[0-9a-zA-Z]*$/g;
	  return b.test(value);  
	}, "请正确输入用户名");
	//用户登录名验证，只能是字母或是数字
	jQuery.validator.addMethod("isCName", function(value, element) { 
	  var b=/^[\u4e00-\u9fa5]{0,}$/;
	  return b.test(value);  
	}, "请正确输入姓名"); 
});
function chengeBirthday(){
	var code=$("#ID_num").val();
	if(code=="")
		return false;
	var year =  code.substring(6,10);   
    var month = code.substring(10,12);   
    var day = code.substring(12,14); 
    var born=year+"-"+month+"-"+day;
    if(born!="--")
    	$("#mem_born").val(year+"-"+month+"-"+day); 
}
function addr1(){
	var addr=window.showModalDialog("commonservice.region?pid=086","","dialogWidth=350px;dialogHeight=400px");
	if(addr!=undefined){
		$("#mem_region").val(addr[0]);
		$("#mem_region_name").val(addr[1]);
	}
}
	//当文件上传成功后，将返回id:flash对象的ID，name：新文件名,url:文件绝对路径
	function returnvalue(id,name,url){
		if(id=="imgupload")
			$("#mem_image").val(url);
	}
</script>

<style>
.rightpad{text-align:right;padding-right:7px;background-color:#F2F9FF;}
.leftpad{padding-left:2px;background-color:#FFFFFF;}
</style>
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;用户注册
	</div>	
<form class="cmxform" style="margin:0" action="${_servlet_url!''}/auth.dorega" method="post" id="updateForm">
	<!--input type="hidden" name="com.eap.token" id="com.eap.token" value="${request.getToken()!''}" /-->
	<table width="100%" border="0" cellpadding="0" cellspacing="1" style="table-layout:fixed;line-height:30px;">
		<col width="30%"/><col />
			<tr><td colspan="2" align="center" style="background-color:#D9F0FC;"><b>第一步：填写账户信息</b></td></tr>
			<tr>
					<td class="rightpad"><font color="red">*</font>用户名</td>
					<td class="leftpad">
						<input type="text" name="mem_name" id="mem_name" value=""  style="width:200px"/>
						<font color="grey">用户名为系统登录用户名,请使用字符、数字等有效字符</font>
					</td>
			</tr>
			<tr>
				<td class="rightpad"><font color="red">*</font>姓名</td>
				<td class="leftpad">
					<input type="text" name="family_name" id="family_name" value="" style="width:200px"/>
					<input type="hidden" name="first_name" id="first_name" value=""/>
				</td>
			</tr>
			<tr>
				<td class="rightpad"><font color="red">*</font>性别</td>
				<td class="leftpad">
					<select name="mem_sex" id="mem_sex"/>
					<option value="">请选择</option>
					[#list EnumService.getEnum('sex') as enum]
					<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
					[/#list]
					</select>
				</td>
			</tr>
			<tr>
					<td class="rightpad"><font color="red">*</font>登录密码</td>
					<td class="leftpad">
						<input type="password" name="mem_pass" id="mem_pass" value="" style="width:200px"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad"><font color="red">*</font>确认密码</td>
					<td class="leftpad">
						<input type="password" name="mem_pass2" id="mem_pass2" value=""  style="width:200px"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad"><font color="red">*</font>身份证号</td>
					<td class="leftpad">
						<input type="text" name="ID_num" id="ID_num" value="" style="width:200px" onblur="chengeBirthday();"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad"><font color="red">*</font>手机</td>
					<td class="leftpad">
						<input type="text" name="mem_mphone" id="mem_mphone" value="" style="width:200px"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad"><font color="red">*</font>邮箱</td>
					<td class="leftpad">
						<input type="text" name="mem_mail" id="mem_mail" value="" style="width:200px"/>
						<font color="grey">请输入正确的可使用的邮箱</font>
					</td>
			</tr>
			<tr>
					<td class="rightpad"><font color="red">*</font>密码问题</td>
					<td class="leftpad">
						<select name="mem_question" id="mem_question" style="width:200px">
							<option value="">请选择...</option>
							<option value="我的小学名字？">我的小学名字？</option>
							<option value="我妈妈的生日？">我妈妈的生日？</option>
							<option value="我最难忘的日子？">我最难忘的日子？</option>
							<option value="我的一个老师的名字？">我的一个老师的名字？</option>
							<option value="我最喜欢的食物？">我最喜欢的食物？</option>
						</select>
					</td>
			</tr>
			<tr>
					<td class="rightpad"><font color="red">*</font>密码答案</td>
					<td class="leftpad">
						<input type="text" name="mem_answer" id="mem_answer" value="" style="width:200px"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad"><font color="red">*</font>验证码</td>
					<td class="leftpad">
						<input type="text" name="validatecode" id="validatecode" style="width:110px"/>
						<img src="${_servlet_url!''}/commonservice.login.checkcodeimg" align="absmiddle" border="1" id="ccimg" height="20px"><a href="javascript:void(0)" id="changeimg">看不清换一个</a>
					</td>
			</tr><br>
		<tr><td colspan="2" align="center" style="background-color:#D9F0FC;"><b>第二步：补充用户信息</b></td></tr>
		
		<!--tr>
			<td class="rightpad"><font color="red">*</font>名</td>
			<td class="leftpad">
				<input type="text" name="first_name" id="first_name" value="" size="40"/>
			</td>
		</tr-->
		
		<tr>
			<td class="rightpad">生日</td>
			<td class="leftpad">
				<input type="text" name="mem_born" id="mem_born" value="" readonly="true"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">区域属地</td>
			<td class="leftpad">
				<input type="hidden" name="mem_region" id="mem_region" value=""/>
				<input type="text" name="mem_region_name" id="mem_region_name" value="" size="40" readonly="true" onclick="addr1();"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">地址</td>
			<td class="leftpad">
				<input type="text" name="mem_addr" id="mem_addr" value="" size="40"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">安全认证图片</td>
			<td class="leftpad">
				<input type="text" name="secure_image" id="secure_image" value="" size="40"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">注册来源网站</td>
			<td class="leftpad">
				<input type="text" name="reg_source" id="reg_source" value="" size="40"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">头像</td>
			<td class="leftpad">
				<input type="hidden" name="mem_image" id="mem_image" value="" size="40"/>
				<div id="imguploaddiv"></div>
				<script language="javascript" type="text/javascript">
					var so = new SWFObject('${_share_file_url!''}/resource/jsp/imgupload.swf', "imgupload", "60", "60", "9", "#FFffff");//imgupload是控件ID,如有多个ID不可重复
					so.addVariable("oldname",$("#mem_image").val());//修改时的原文件地址，可以是绝对或相对地址
					so.addVariable("savepath","images/manager/");//上传文件的路径
					so.addVariable("uploadpath","${_server_url!''}/eap/manager.system.upload?session_id=${session.id!''}");//上传请求地址so.addVariable("uploadpath","/eap/manager.system.upload");//上传请求地址
					so.write("imguploaddiv");
				</script>
			</td>
		</tr>
		<tr>
			<td class="rightpad">备注信息</td>
			<td class="leftpad">
				<textarea name="note_info" id="note_info" cols="30" rows="4"></textarea>
			</td>
		</tr>	
		<!-- tr><td colspan="2" align="center" style="background-color:#D9F0FC;"><b>服务协议</b></td></tr>
		<tr>
			<td colspan="2">
			我已经阅读并同意以下的 服务条款 和 隐私权政策。我对帐户的使用及和对帐户信息的披露将接受以下服务条款的约束并遵守中华人民共和国法律。<br>
			<iframe src="${_share_file_url!''}/resource/service.html" style="width:100%;height:200px;" scroll="yes"></iframe></td>
		</tr -->
		<tr><td colspan="2">&nbsp;</td></tr>
		<tr>
			<td colspan="2" align="center" style="background-color:#FFFFFF;">
				<button type="button" id="addInfo">提交</button>
			</td>
		</tr>
	</table>
</form>
</div>
<script language="javascript" type="text/javascript">
	[#if session.getAttribute("reg_error")?exists]
	[#assign error="${session.getAttribute('reg_error')!''}"]
		[#if "${error}"=="0"]alert("验证码错误！");[/#if]
		[#if "${error}"=="2"]alert("此用户名已注册!");[/#if]
		[#if session.getAttribute("userRegister")?exists&&session.getAttribute("userInfo")?exists]
			[#assign userreg=session.getAttribute("userRegister")]
			[#assign userinfo=session.getAttribute("userInfo")]
			$("#mem_name").val("${userreg.mem_name!''}");
			$("#ID_num").val("${userinfo.ID_num!''}");
			$("#mem_mphone").val("${userinfo.mem_mphone!''}");
			$("#mem_mail").val("${userinfo.mem_mail!''}");
			$("#first_name").val("${userinfo.first_name!''}");
			$("#mem_region").val("${userinfo.mem_region!''}");
			$("#mem_addr").val("${userinfo.mem_addr!''}");
			$("#note_info").val("${userinfo.note_info!''}");
			$("#mem_answer").val("${userreg.mem_answer!''}");
			$("#family_name").val("${userinfo.family_name!''}");
			
		[/#if]
	[/#if]
</script>