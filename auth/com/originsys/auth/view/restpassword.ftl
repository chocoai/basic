<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/messages_cn.js"></script>
<link type="text/css" rel="stylesheet" href="${_share_file_url!''}/resource/css/custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="${_share_file_url!''}/resource/css/cmxform.css" />
<script type="text/javascript">
$(function(){
	$("#loginForm").validate({
		rules: {
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
			password: {
				required: "请输入密码",
				minlength: "密码至少6位"
			},
			password2: {
				required: "请输入确认密码",
				minlength: "密码至少6位",
				equalTo: "请输入和上面一样的密码",
			}
		}
	});
	jQuery.validator.addMethod("authPass",
	function(value){
		if(value.match(/([0-9])/)&& value.match(/([!,@,#,$,%,^,&,*,?,_,~])/)&& value.match(/([a-zA-Z])/))
			return true;
	},""
);
});
</script>
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>&nbsp;${system.action.action_name}
	</div>
	<form style="margin:0" action="${_servlet_url!''}/auth.passwordreset" method="post" id="loginForm">
	<div  id="buttons" style="text-align:right">
		<button type="submit">保存</button><button type="button"  onClick="history.go(-1)">返回</button>
	</div>
	<div class="ui-widget-content"  style="position: relative;padding: .2em;">
	<table border="0" width="100%" cellspacing=0 class="mainbody_table_detail">
	<input type="hidden" name="mem_id" value="${block.mem_id!''}">
	<col width="100"><col>
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
