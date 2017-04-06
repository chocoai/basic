<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/messages_cn.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="${_share_file_url!''}/resource/css/cmxform.css" />
<script language="javascript" type="text/javascript">
$(function(){
	//日期选择:
	$("#mem_born").attr("readonly", "true").datepicker({changeMonth: true,changeYear: true, yearRange: '-100:-18',dateFormat:"yy-mm-dd"});
	$("#updateForm").validate({
		rules: {
			mem_question:{
				required: true
			},
			mem_answer:{
				required: true
			}
		},
		messages: {
			mem_question:{
				required: "请选择密码问题"
			},
			mem_answer:{
				required: "请输入密码答案"
			}
		},
		submitHandler:function(form){
			var queryString=$("#updateForm").formSerialize();
			$.post($("#updateForm").attr("action"),queryString,
				function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success==1){
						alert("修改成功");
					}else{
						alert("修改失败！");
					}
			});
		}
	});
});	
</script>
<style>
.rightpad{text-align:right;padding-right:7px;background-color:#F2F9FF;}
.leftpad{padding-left:2px;background-color:#FFFFFF;}
</style>
<table style="width:100%" border="0">
<tr><td width="200" valign="top">
[#global web=JspTaglibs["/WEB-INF/eap.tld"]]
[@web.block  site_id="eap2" action_id="auth.personalinfo" component_id="auth"/]
</td><td valign="top">
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;密码安全
	</div>
	<form class="cmxform" style="margin:0" action="${_servlet_url!''}/auth.person.passsecuritysave" method="post" id="updateForm">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" style="table-layout:fixed;line-height:30px;">
			<col width="150px"/><col />
			<tr>
				<input type="hidden" name="mem_id" id="mem_id" value="${result.mem_id!''}"/>
			</tr>
			<tr>
				<td class="rightpad"><font color="red">*</font>密码问题</td>
				<td class="leftpad">
					<select name="mem_question" id="mem_question" style="width:200px">
						<option value="" [#if "${result.mem_question!''}"==""]selected[/#if]>请选择...</option>
						<option value="我的小学名字？" [#if "${result.mem_question!''}"=="我的小学名字？"]selected[/#if]>我的小学名字？</option>
						<option value="我妈妈的生日？" [#if "${result.mem_question!''}"=="我妈妈的生日？"]selected[/#if]>我妈妈的生日？</option>
						<option value="我最难忘的日子？" [#if "${result.mem_question!''}"=="我最难忘的日子？"]selected[/#if]>我最难忘的日子？</option>
						<option value="我的一个老师的名字？" [#if "${result.mem_question!''}"=="我的一个老师的名字？"]selected[/#if]>我的一个老师的名字？</option>
						<option value="我最喜欢的食物？" [#if "${result.mem_question!''}"=="我最喜欢的食物？"]selected[/#if]>我最喜欢的食物？</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="rightpad"><font color="red">*</font>密码答案</td>
				<td class="leftpad">
					<input type="text" name="mem_answer" id="mem_answer" value="${result.mem_answer!''}" style="width:200px"/>
				</td>
			</tr>	
			<tr>
				<td align="center" style="background-color:#FFFFFF;" colspan="2">
					<button type="submit">保存</button>&nbsp;
					<button type="button" onClick="history.go(-1)">返回</button>
				</td>
			</tr>
		</table>
	</form>
</div>		
</td></tr></table>