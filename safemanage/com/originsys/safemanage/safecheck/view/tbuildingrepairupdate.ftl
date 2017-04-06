<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script language="javascript" type="text/javascript">
$(function(){
	$("#updateInfo").click(function(){
		var str="";
		if($("#repair_content").val()=="")
			str+="请输入维修内容\r";
		if($("#repair_cost").val()=="")
			str+="请输入维修费用\r";
		if($("#repair_organ").val()=="")
			str+="请输入维修单位\r";	
		if($("#repair_manager").val()=="")
			str+="请输入维修负责人\r";
		if($("#complete_date").val()=="")
			str+="请选择完成时间\r";	
		var isPhone=/^13[0-9]{9}$|15[0-9]{9}$|18[0-9]{9}$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/i;
		if($("#manager_tel").val()!="" && !isPhone.test($("#manager_tel").val())){
			str+="请输入正确的负责人电话\r";
		}
		if(str!=""){
			alert(str);
			return false;
		}
		var queryString=$("#updateForm").formSerialize();
		$.post($("#updateForm").attr("action"),queryString,
			function(data,textStatus){
				var jdata=jQuery.parseJSON(data);
				if(jdata.success==1){
					alert("维修记录修改成功！");
					window.close();
				}else{
					alert("维修记录修改失败！");
				}
		});
	});
	//日期选择:
	$("#complete_date").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
});
</script>
<style>
.rightpad{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.leftpad{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
<div class="widget-title-normal">
	<div class="child">
		<span class="widget-title-text">
			楼幢维修记录修改
		</span>
	</div>
</div>
<form class="cmxform" style="margin:0" action="${_servlet_url!''}/safecheck.repair.update" method="post" id="updateForm">
	<input type="hidden" name="building_id" id="building_id" value="${block.building_id!''}"/>
	<input type="hidden" name="repair_id" id="repair_id" value="${block.repair_id!''}"/>
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<col width="150px"/><col />
		<tr>
			<td class="rightpad"><font color="red">*</font>维修内容</td>
			<td class="leftpad">
				<input type="text" name="repair_content" id="repair_content" size="40" value="${block.repair_content!''}"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad"><font color="red">*</font>维修费用</td>
			<td class="leftpad">
				<input type="text" name="repair_cost" id="repair_cost" size="40" value="${block.repair_cost!''}"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad"><font color="red">*</font>维修单位</td>
			<td class="leftpad">
				<input type="text" name="repair_organ" id="repair_organ" size="40" value="${block.repair_organ!''}"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad"><font color="red">*</font>维修负责人</td>
			<td class="leftpad">
				<input type="text" name="repair_manager" id="repair_manager" size="40" value="${block.repair_manager!''}"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">负责人电话</td>
			<td class="leftpad">
				<input type="text" name="manager_tel" id="manager_tel" size="40" value="${block.manager_tel!''}"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad"><font color="red">*</font>完成时间</td>
			<td class="leftpad">
				<input type="text" name="complete_date" id="complete_date" size="40" value="${block.complete_date?string("yyyy-MM-dd")}"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">备注</td>
			<td class="leftpad">
				<textarea name="repair_remarks" id="repair_remarks" cols="35" rows="6">${block.repair_remarks!''}</textarea>
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