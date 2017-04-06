<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/messages_cn.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="${_share_file_url!''}/resource/css/cmxform.css" />
<script language="javascript" type="text/javascript">
$(function(){
	$("#addInfo").click(function(){
		$("#updateForm").submit();
	});
	$("#updateForm").validate({
		rules: {
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
				remote:"${_servlet_url!''}/auth.isused2"
			}
		},
		messages: {
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
			}
		}
	});
});
</script>
<style>
.rightpad{text-align:right;padding-right:7px;background-color:#F2F9FF;}
.leftpad{padding-left:2px;background-color:#FFFFFF;}
</style>
<form class="cmxform" style="margin:0" action="${_servlet_url!''}/auth.doregb" method="post" id="updateForm">
	<input type="hidden" name="mem_id" id="mem_id" value="${block!''}">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" style="table-layout:fixed;line-height:30px;">
		<col width="20%"/><col />
		<tr><td colspan="2" align="center" style="background-color:#D9F0FC;"><b>第二步：验证用户信息</b></td></tr>
			<tr>
					<td class="rightpad">手机</td>
					<td class="leftpad">
						<input type="text" name="mem_mphone" id="mem_mphone" value="" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">邮箱</td>
					<td class="leftpad">
						<input type="text" name="mem_mail" id="mem_mail" value="" size="40"/>
					</td>
			</tr>			
		<tr>
			<td colspan="2" align="center" style="background-color:#FFFFFF;">
				<button type="button" id="addInfo">提交</button>&nbsp;
				<button type="button" onClick="history.go(-1)">返回</button>
			</td>
		</tr>
	</table>
</form>