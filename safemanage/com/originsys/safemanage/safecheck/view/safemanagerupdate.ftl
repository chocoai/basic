<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/swfobject.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/nicEdit.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript">
$(function(){
	$("#updateInfo").click(function(){
		var message="";
		var familyname=$("#familyname",$("#updateForm")).val();
		if(familyname==""||familyname.length>30){
			message+="姓必须输入且长度小于30个字符\n\r";
		}
		var firstname=$("#firstname",$("#updateForm")).val();
		if(firstname==""||firstname.length>30){
			message+="名必须输入且长度小于30个字符\n\r";
		}
		//验证手机号
		var isPhone=/^13[0-9]{9}$|15[0-9]{9}$|18[0-9]{9}$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/i;
		if($("#mem_mphone",$("#updateForm")).val()!=''&&!isPhone.test($("#mem_mphone",$("#updateForm")).val())){
			message+="手机号格式不正确\n\r";
		}
		var startTime=$("#birthday",$("#updateForm")).val();
		if(startTime!=""){
			var ed=new Date();
			re = /-/g;
			var sd=new Date(Date.parse(startTime.replace(re, "/")));
			if(sd>ed){
				message+="出生日期不能大于当前日期\n\r";
			}
		}
		var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if($("#mem_mail",$("#updateForm")).val()!=''&&!reg.test($("#mem_mail",$("#updateForm")).val())){
			message+="邮箱格式不正确\n\r";
		}
		if($("#region",$("#updateForm")).val()=="")
			message+="管理区域不能为空"+"\n\r";
		if(message!=""){
			alert(message);
			return false;
		}
		var queryString=$("#updateForm").formSerialize();
		$.post($("#updateForm").attr("action"),queryString,
			function(data,textStatus){
				var jdata=jQuery.parseJSON(data);
				if(jdata.success==1){
					//window.location="${_servlet_url!''}/safecheck.safemanager.list";
					window.location="${_servlet_url!''}/manager.user.list";
				}else{
					alert("操作失败！");
				}
		});
	});
});
function returnvalue(id,name,url){
		if(id=="imgupload"){
			$("#mod_join_pic").val(url);
		}
}
function viewpic(fieldid,newfilepath){
	window.open(document.getElementById(fieldid).value);
}
</script>
<style>
.rightpad{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.leftpad{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
[#if block.safemanager?exists]
[#assign result=block.safemanager]
[#assign mem=block.member]
<form class="cmxform" style="margin:0" action="${_servlet_url!''}/safecheck.safemanager.update1" method="post" id="updateForm">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<caption>更新安全管理员用户类型属性表</caption>
			<tr>
				<input type="hidden" name="mem_id" id="mem_id" value="${result.mem_id!''}"/>
			</tr>
			<tr><td class="rightpad">用户名:</td>
			<td class="leftpad"><input class="text ui-widget-content ui-corner-all" type="text"  size="30" id="username" name="username" value="${mem.mem_name!''}" readonly>
			</td></tr>
			<tr><td class="rightpad">姓		名:</td>
			<td class="leftpad">
				姓：<input class="text ui-widget-content ui-corner-all" type="text"  size="8" id="familyname" name="familyname" value="${mem.family_name!''}">
				名：<input class="text ui-widget-content ui-corner-all" type="text"  size="8" id="firstname" name="firstname" value="${mem.firstname!''}">
			</td>
			</tr>
			<tr><td class="rightpad">性		别:</td>
			<td class="leftpad"><input type="radio" name="mem_sex" value="男" [#if "${mem.mem_sex!''}"=="男"]checked[/#if]>男
			<input type="radio" name="mem_sex" value="女" [#if "${mem.mem_sex!''}"=="女"]checked[/#if]>女
			</td></tr>
			<tr><td class="rightpad">出生日期:</td>
			<td class="leftpad"><input class="text ui-widget-content ui-corner-all" type="text"  size="30" id="birthday" name="birthday" [#if mem.mem_born?exists]value="${mem.mem_born?string("yyyy-MM-dd")}"[/#if] onClick="WdatePicker()" />
			</td></tr>
			<tr><td class="rightpad">手机号:</td>
			<td class="leftpad"><input class="text ui-widget-content ui-corner-all" type="text"  size="30" id="mem_mphone" name="mem_mphone" value="${mem.mem_mphone!''}">
			</td></tr>
			<tr><td class="rightpad">邮箱:</td>
			<td class="leftpad"><input class="text ui-widget-content ui-corner-all" type="text"  size="30" id="mem_mail" name="mem_mail" value="${mem.mem_mail!''}">
			</td></tr>
			<tr>
					<td class="rightpad" width="25%">管理范围:</td>
					<td class="leftpad">
						<select id="region" name="region">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('xzqh') as enum]
							<option value="${enum.enum_value!''}" [#if "${result.region!''}" == "${enum.enum_value!''}"]selected="true"[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
			</tr>
			<tr>
				<td style="background-color:#FFFFFF;"></td>
				<td style="background-color:#FFFFFF;">
					<button type="button" id="updateInfo">提交</button>&nbsp;
					<button type="button" onClick="window.close()">返回</button>
				</td>
		</tr>
	</table>
</form>
[/#if]