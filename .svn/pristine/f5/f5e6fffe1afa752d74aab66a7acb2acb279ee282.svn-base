<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/messages_cn.js"></script>
<link type="text/css" rel="stylesheet" href="${_share_file_url!''}/resource/css/custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="${_share_file_url!''}/resource/css/cmxform.css" />
<script type="text/javascript">
$(function(){
	$("#loginForm").validate({
		rules: {
			user_mail: {
				required: true
			},
			mem_question: "required",
			mem_answer: "required"
		},
		messages: {
			user_mail: {
				required: "请输入"
			},
			mem_question: "请输入找回密码问题",
			mem_answer: "请输入找回密码答案"
		}
	});
});
</script>
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>&nbsp;${system.action.action_name}
	</div>
	<form style="margin:0" action="${_servlet_url!''}/auth.passwordfind" method="post" id="loginForm">
	<div  id="buttons" style="text-align:right">
		<button type="submit">确定</button><button type="button"  onClick="history.go(-1)">返回</button>
	</div>
	[#assign error=request.getParameter("error")!'']
	<div><font color="red">[#if "${error}"=="have"]请输入正确的信息！[/#if]</font></div>
	<div class="ui-widget-content"  style="position: relative;padding: .2em;">
	<table border="0" width="100%" cellspacing=0 class="mainbody_table_detail">
	<col width="110"><col>
		<tr>
			<td class="detail_attname">用户名:</td>
			<td class="detail_value">
			<input type="text" name="user_mail" id="user_mail">
			<input type="hidden" name="mail_flag" value="0">
			</td>			
		</tr>
		<tr>
		<td  class="detail_attname">找回密码问题</td><td class="detail_value">
		<select name="mem_question" id="mem_question" class="required">
			<option value="">请选择...</option>
			<option value="我的小学名字？">我的小学名字？</option>
			<option value="我妈妈的生日？">我妈妈的生日？</option>
			<option value="我最难忘的日子？">我最难忘的日子？</option>
			<option value="我的手机号码是什么？">我的一个老师的名字？</option>
			<option value="我最喜欢的食物？">我最喜欢的食物？</option>
		</select>
		</td>
	</tr>
		<tr>
			<td class="detail_attname">找回密码答案</td>
			<td class="detail_value">
			<input type="text" name="mem_answer" id="mem_answer" class="required">
			</td>			
		</tr>
	</table>
	</div>
	</form>
</div>	