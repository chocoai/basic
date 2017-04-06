<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script language="javascript" type="text/javascript">
$(function(){
	$("#updateInfo").click(function(){
		var str="";
		if($("#accident_name").val()=="")
			str+="请输入事故标题\r";
		if($("#accident_date").val()=="")
			str+="请选择事故发生时间\r";
		if($("#accident_type").val()=="")
			str+="请输入事故类型\r";	
		if($("#accident_description").val()=="")
			str+="请输入事故描述\r";
		if($("#accident_reporter").val()=="")
			str+="请输入上报人\r";	
		if(str!=""){
			alert(str);
			return false;
		}
		var queryString=$("#updateForm").formSerialize();
		$.post($("#updateForm").attr("action"),queryString,
			function(data,textStatus){
				var jdata=jQuery.parseJSON(data);
				if(jdata.success==1){
					alert("事故记录修改成功！");
					window.close();
				}else{
					alert("事故记录修改失败！");
				}
		});
	});
	//日期选择:
	$("#accident_date").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
	
});
</script>
<style>
.rightpad{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.leftpad{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
<div class="widget-title-normal">
	<div class="child">
		<span class="widget-title-text">
			楼幢事故记录修改
		</span>
	</div>
</div>
<form class="cmxform" style="margin:0" action="${_servlet_url!''}/safecheck.accident.update" method="post" id="updateForm">
	<input type="hidden" name="building_id" id="building_id" value="${block.building_id!''}"/>
	<input type="hidden" name="accident_id" id="accident_id" value="${block.accident_id!''}"/>
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<col width="150px"/><col />
		<tr>
			<td class="rightpad"><font color="red">*</font>事故标题</td>
			<td class="leftpad">
				<input type="text" name="accident_name" id="accident_name" size="40" value="${block.accident_name!''}"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad"><font color="red">*</font>事故发生时间</td>
			<td class="leftpad">
				<input type="text" name="accident_date" id="accident_date" size="40" value="${block.accident_date?string("yyyy-MM-dd")}"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad"><font color="red">*</font>事故类型</td>
			<td class="leftpad">
				<input type="text" name="accident_type" id="accident_type" size="40" value="${block.accident_type!''}"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad"><font color="red">*</font>事故描述</td>
			<td class="leftpad">
				<textarea name="accident_description" id="accident_description" cols="35" rows="6">${block.accident_description!''}</textarea>
			</td>
		</tr>
		<tr>
			<td class="rightpad"><font color="red">*</font>上报人</td>
			<td class="leftpad">
				<input type="text" name="accident_reporter" id="accident_reporter" size="40" value="${block.accident_reporter!''}"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">备注</td>
			<td class="leftpad">
				<textarea name="accident_note" id="accident_note" cols="35" rows="6">${block.accident_note!''}</textarea>
			</td>
		</tr>
		<tr>
			<td align="center" style="background-color:#FFFFFF;" colspan="2">
				<button type="button" id="updateInfo">提交</button>&nbsp;
				<button type="button" onClick="window.close();">返回</button>
			</td>
		</tr>
	</table>
</form>