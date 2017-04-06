<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/swfobject.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/nicEdit.js"></script>
<script language="javascript" type="text/javascript">
$(function(){
	$("#updateInfo").click(function(){
		var queryString=$("#updateForm").formSerialize();
		$.post($("#updateForm").attr("action"),queryString,
			function(data,textStatus){
				var jdata=jQuery.parseJSON(data);
				if(jdata.success==1){
					window.location="${_servlet_url!''}/safecheck.safecensor.list";
				}else{
					alert("操作失败！");
				}
		});
	});
	//日期选择:
	$("#certificate_date").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
});
//当文件上传成功后，将返回id:flash对象的ID，name：新文件名,url:文件绝对路径
function returnvalue(id,name,url){
	//alert(id+"  "+name+"  "+url);
	if(id=="imguploaddiv")
		$("#certificate",$("#addForm")).val(url);
}
function viewpic(fieldid,newfilepath){
	window.open(document.getElementById(fieldid).value);
}
</script>
<style>
.rightpad{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.leftpad{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
<form class="cmxform" style="margin:0" action="${_servlet_url!''}/safecheck.safecensor.update" method="post" id="updateForm">
	<input type="hidden" name="role_id" value="">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<caption>安全检查员增加</caption>
			<tr>
				<td class="rightpad">用户名:</td>
				<td class="leftpad">
				<input type="text"  size="30" id="username" name="username">
				</td>
			</tr>
			<tr>
				<td class="rightpad">姓		名:</td>
				<td class="leftpad">
					姓：<input type="text"  size="8" id="familyname" name="familyname">
					名：<input type="text"  size="8" id="firstname" name="firstname">
				</td>
			</tr>
			<tr>
				<td class="rightpad">性		别:</td>
				<td class="leftpad">
					<input type="radio" name="mem_sex" value="男" checked>男
					<input type="radio" name="mem_sex" value="女">女
				</td>
			</tr>
			<tr>
				<td class="rightpad">出生日期:</td>
				<td class="leftpad">
					<input type="text"  size="30" id="birthday" name="birthday">
				</td>
			</tr>
			<tr>
				<td class="rightpad">手机号:</td>
				<td class="leftpad">
					<input type="text"  size="30" id="mem_mphone" name="mem_mphone">
				</td>
			</tr>
			<tr>
				<td class="rightpad">邮箱:</td>
				<td class="leftpad">
					<input type="text"  size="30" id="mem_mail" name="mem_mail">
				</td>
			</tr>
			<tr>
				<td class="rightpad">所属机构:</td>
				<td class="leftpad">
					<input type="text"  size="30" id="department_name" name="department_name" readonly="true">	
					<input type="hidden"  size="30" id="department_id" name="department_id">	
				</td>
			</tr>
			<tr>
				<td class="rightpad">所属区域:</td>
				<td class="leftpad">
					<input type="text"  size="30" id="region_name" name="region_name" readonly="true">	
					<input type="hidden"  size="30" id="region_id" name="region_id">	
				</td>
			</tr>
			<tr>
				<td class="rightpad" width="25%">管理范围:</td>
				<td class="leftpad">
					<input type="text" name="manage_scope" id="manage_scope" size="40"/>
				</td>
			</tr>
			<tr>
				<td class="rightpad">从业资格证书编号</td>
				<td class="leftpad">
					<input type="text" name="certificate_number" id="certificate_number" size="40"/>
				</td>
			</tr>
			<tr>
				<td class="rightpad">从业资格证书复印件</td>
				<td class="leftpad">
					<input type="hidden" name="certificate" id="certificate" value=""/>
					<div id="imguploaddiv"></div>
					<script language="javascript" type="text/javascript">
						var so = new SWFObject('${_share_file_url!''}/resource/jsp/imgupload.swf', "imgupload", "60", "60", "9", "#FFffff");//imgupload是控件ID,如有多个ID不可重复
						so.addVariable("oldname",$("#certificate").val());//修改时的原文件地址，可以是绝对或相对地址
						so.addVariable("savepath","images/manager/");//上传文件的路径
						so.addVariable("uploadpath","${_server_url!''}/eap/manager.system.upload?session_id=${session.id!''}");//上传请求地址so.addVariable("uploadpath","/eap/manager.system.upload");//上传请求地址
						so.write("imguploaddiv");
					</script>	
				</td>
			</tr>
			<tr>
				<td class="rightpad">证书取得时间</td>
				<td class="leftpad">
					<input type="text" name="certificate_date" id="certificate_date" value=""/>
				</td>
			</tr>
			<tr>
				<td class="rightpad">专业技术职称</td>
				<td class="leftpad">
					<input type="text" name="professional_titles" id="professional_titles" value="" size="40"/>
				</td>
			</tr>
			<tr>
				<td class="rightpad">工作经验年限</td>
				<td class="leftpad">
					<input type="text" name="work_years" id="work_years" value="" size="4"/>
				</td>
			</tr>
			<tr>
				<td class="rightpad">从事专业</td>
				<td class="leftpad">
					<input type="text" name="professional" id="professional" value="" size="40"/>
				</td>
			</tr>
		<tr>
			<td style="background-color:#FFFFFF;"></td>
			<td style="background-color:#FFFFFF;">
				<button type="button" id="updateInfo">提交</button>&nbsp;
				<button type="button" onClick="history.go(-1)">返回</button>
			</td>
		</tr>
	</table>
</form>