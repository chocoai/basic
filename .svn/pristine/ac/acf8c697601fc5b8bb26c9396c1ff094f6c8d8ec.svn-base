<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script language="javascript" type="text/javascript">
$(function(){
	$("#updateInfo").click(function(){
		var str="";
		if($("#zzlx").val()=="")
			str+="请选择整治类型\r";
		
		if(str!=""){
			alert(str);
			return false;
		}
		var queryString=$("#updateForm").formSerialize();
		$.post($("#updateForm").attr("action"),queryString,
			function(data,textStatus){
				var jdata=jQuery.parseJSON(data);
				if(jdata.success==1){
					alert("维修记录保存成功！");
					window.close();
				}else{
					alert("维修记录保存失败！");
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
			危房整治记录
		</span>
	</div>
</div>
<form class="cmxform" style="margin:0" action="${_servlet_url!''}/safecheck.wfzz.add" method="post" id="updateForm">
	<input type="hidden" name="building_id" id="building_id" value="${block.building_id!''}"/>
	<input type="hidden" name="builiding_region" id="builiding_region" value="${block.builiding_region!''}"/>
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<col width="150px"/><col />
		
		<tr>
			<td class="rightpad">整治类型：</td>
			<td class="leftpad">
				<select id="zzlx" name="zzlx">
				<option value="">------请选择------</option>
				[#list EnumService.getEnum('wfzz_type') as enum]
				<option value="${enum.enum_value!''}" [#if "${block.zzlx!''}"=="${enum.enum_value!''}"]selected[/#if]>${enum.enum_name!''}</option>
				[/#list]
				</select>
			</td>
		</tr>
		
		<tr>
			<td class="rightpad">整治内容</td>
			<td class="leftpad">
				<textarea name="zznr" id="zznr" cols="35" rows="6"></textarea>
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