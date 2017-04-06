<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/messages_cn.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/swfobject.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="${_share_file_url!''}/resource/css/cmxform.css" />
<script language="javascript" type="text/javascript">			
$(function(){
	$("#mem_born").attr("readonly", "true").datepicker({changeMonth: true,changeYear: true, yearRange: '1900:2010',dateFormat:"yy-mm-dd"});
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
<form class="cmxform" style="margin:0" action="${_servlet_url!''}/auth.doregc" method="post" id="updateForm">
	<input type="hidden" name="mem_id" id="mem_id" value="${result.mem_id!''}">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" style="table-layout:fixed;line-height:30px;">
		<col width="30%"/><col />
		<tr><td colspan="2" align="center" style="background-color:#D9F0FC;"><b>第二步：补充用户信息</b></td></tr>
		<tr>
			<td class="rightpad">姓</td>
			<td class="leftpad">
				<input type="text" name="family_name" id="family_name" value="${result.family_name!''}" size="40"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">名</td>
			<td class="leftpad">
				<input type="text" name="first_name" id="first_name" value="${result.first_name!''}" size="40"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">性别</td>
			<td class="leftpad">
				<select name="mem_sex" id="mem_sex"/>
				[#list EnumService.getEnum('sex') as enum]
				<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
				[/#list]
				</select>
			</td>
		</tr>
		<tr>
			<td class="rightpad">生日</td>
			<td class="leftpad">
				<input type="text" name="mem_born" id="mem_born" [#if result.mem_born?exists]value="${result.mem_born?string('yyyy-MM-dd')}"[#else]value=""[/#if]/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">邮址</td>
			<td class="leftpad">
				<input type="text" name="mem_mail" id="mem_mail" value="${result.mem_mail!''}" size="40"/>
			</td>
		</tr>
		<!-- tr>
			<td class="rightpad">用户信息完整性</td>
			<td class="leftpad"-->
					<input type="hidden" name="mem_integrality" id="mem_integrality" value="${result.mem_integrality!''}" size="40"/>
			<!--/td>
		</tr -->
		<tr>
			<td class="rightpad">手机</td>
			<td class="leftpad">
				<input type="text" name="mem_mphone" id="mem_mphone" value="${result.mem_mphone!''}" size="40"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">居住区域</td>
			<td class="leftpad">
				<input type="hidden" name="mem_region" id="mem_region" value=""/>
				<input type="text" name="mem_region_name" id="mem_region_name" value="" size="40" readonly="true" onclick="addr1();"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">地址</td>
			<td class="leftpad">
				<input type="text" name="mem_addr" id="mem_addr" value="${result.mem_addr!''}" size="40"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">安全认证图片</td>
			<td class="leftpad">
				<input type="text" name="secure_image" id="secure_image" value="${result.secure_image!''}" size="40"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">注册来源网站</td>
			<td class="leftpad">
				<input type="text" name="reg_source" id="reg_source" value="${result.reg_source!''}" size="40"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">头像</td>
			<td class="leftpad">
				<input type="hidden" name="mem_image" id="mem_image" value="${result.mem_image!''}" size="40"/>
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
				<textarea name="note_info" id="note_info" cols="30" rows="4">
				${result.note_info!''}
				</textarea>
			</td>
		</tr>		
		<tr>
			<td colspan="2" align="center" style="background-color:#FFFFFF;">
				<button type="button" id="addInfo">提交</button>
			</td>
		</tr>
	</table>
</form>