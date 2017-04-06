<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/messages_cn.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="${_share_file_url!''}/resource/css/cmxform.css" />
<script type="text/javascript">
$(function(){
	$("#loginForm").validate({
		rules: {
			old_password: {
				required: true,
				minlength: 6
			},
			password: {
				required: true,
				minlength: 6
			},
			password2: {
				required: true,
				minlength: 6,
				equalTo: "#password"
			}
		},
		messages: {
			old_password: {
				required: "请输入旧密码",
				minlength: "至少输入6位"
			},
			password: {
				required: "请输入密码",
				minlength: "密码至少6位"
			},
			password2: {
				required: "请输入确认密码",
				minlength: "密码至少6位",
				equalTo: "请输入和上面一样的密码"
			}
		},
	    //提交
        submitHandler:function(form){
       		var queryString=$("#loginForm").formSerialize();
			$.post(
				"${_servlet_url!''}/auth.changepass",
				queryString,
				function(data){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="1")
						warn("密码修改成功");
					else
						warn("密码修改失败");
				}
			);
       } 
	});
	 //消息提示框
	$('#msg').dialog({
		title:'提示信息',
		width: 200,
		height:150,
		autoOpen: false,
		modal: true,
		buttons: [
	    {
	        text: "确定",
	        click: function() { $(this).dialog("close"); }
	    }
	]
	});	
	//弹出消息框函数
	function warn(msg){
		$('td',$('#msg')).text(msg);
		$('#msg').dialog("open");
		
	}
	jQuery.validator.addMethod("authPass",
	function(value){
		if(value.match(/([0-9])/)&& value.match(/([!,@,#,$,%,^,&,*,?,_,~])/)&& value.match(/([a-zA-Z])/))
			return true;
	},""
	);
});
</script>
<table style="width:100%" border="0">
<tr><td width="200" valign="top">
[#global web=JspTaglibs["/WEB-INF/eap.tld"]]
[@web.block  site_id="eap2" action_id="auth.personalinfo" component_id="auth"/]
</td><td valign="top">
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;width:99%;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>&nbsp;${system.action.action_name}
	</div>
	<form style="margin:0" action="${_servlet_url!''}/auth.changepassword" method="post" id="loginForm">
	<div  id="buttons" style="text-align:right">
		<button type="submit">保存</button>
	</div>
	<div class="ui-widget-content"  style="position: relative;padding: .2em;">
	<table border="0" width="100%" cellspacing=0 class="mainbody_table_detail">
	<col width="100"><col>
		<tr>
			<td class="detail_attname">旧密码:</td>
			<td class="detail_value">
			<input type="password" name="old_password" id="old_password" class="required">
			</td>			
		</tr>
		<tr>
			<td class="detail_attname">新密码:</td>
			<td class="detail_value">
			<input type="password" name="password" id="password" class="required">
			</td>			
		</tr>
		<tr>
			<td class="detail_attname">确认密码:</td>
			<td class="detail_value">
			<input type="password" name="password2" id="password2" class="required">
			</td>			
		</tr>
	</table>
	</div>
	</form>
</div>	
<!--提示消息框-->
<div id="msg" class="ui-widget-content" style="padding: .2em;display:none">
<table width="100%" border="0" height="100%">
  <tr>
    <td align="center" valign="middle"></td>
  </tr>
</table>
</div>
<td></tr></table>