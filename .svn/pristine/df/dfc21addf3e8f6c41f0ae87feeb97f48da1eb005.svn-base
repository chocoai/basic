<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script language="javascript" type="text/javascript">
$(function(){
	$("#updateInfo").click(function(){
		var str=$("input[name='review_state']:checked").val();
		if(str==""||str==undefined){
			alert("请选择审核状态");
			return false;
		}
		var queryString=$("#updateForm").formSerialize();
		$.post($("#updateForm").attr("action"),queryString,
			function(data,textStatus){
				var jdata=jQuery.parseJSON(data);
				if(jdata.success==1){
					alert("审核成功！");
					if (window.showModalDialog!=null){
						window.close();//firefox不支持			
					}else{
						top.close();//IE和FireFox都支持
					}
				}else{
					alert("审核失败！");
				}
		});
	});
	$("#unit_name").click(function(){
			var str;
		 	var url="${_server_url!''}/portal/safemanage.tBuildingUnitdialog";
			if (window.showModalDialog!=null){
				str=window.showModalDialog(url,"","dialogWidth:700px;dialogHeight:600px;status:no;help:no;scrolling=no;scrollbars=no");
			}else{
				str=window.open(url,"","width=700px,height=600px,menubar=no,toolbar=no,location=no,scrollbars=no,status=no,modal=yes");
		 	}
		 	if(str!=undefined){
		 		$("#unit_name").val(str[1]);
		 		$("#unit_id").val(str[0]);
		 	}
	});
});
</script>
<style>
.rightpad{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.leftpad{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		管理项目修改
	</div>
<form class="cmxform" style="margin:0" action="${_servlet_url!''}/safemanage.tBuildingProjectcheck" method="post" id="updateForm">
	<input type="hidden" name="project_id" id="project_id" value="${block.result.project_id!''}"/>
	<input type="hidden" name="project_buildingids" id="project_buildingids" value="${block.result.project_buildingids!''}"/>
	<table width="100%" border="0" cellpadding="0" cellspacing="1" align="center" style="table-layout:fixed;line-height:30px;">
			<col width="150px"><col />
			<tr>
				<td class="rightpad">项目名称</td>
				<td class="leftpad">
					${block.result.project_name!''}
				</td>
			</tr>
			<tr>
				<td class="rightpad">项目地址</td>
				<td class="leftpad">
					${block.result.project_address!''}
				</td>
			</tr>
			<tr>
				<td class="rightpad">所属区域</td>
				<td class="leftpad">
					[#assign qh=""]
						[#if EnumService.getEnum('xzqh')?exists]
						[#list EnumService.getEnum('xzqh') as enum]
						[#if "${block.result.city_district!''}"=="${enum.enum_value!''}"][#assign qh="${enum.enum_name!''}"][/#if]
						[/#list]
						[/#if]
						${qh!''}
				</td>
			</tr>
			<tr>
				<td class="rightpad">安全责任单位</td>
				<td class="leftpad">
					${block.result.unit_name!''}
				</td>
			</tr>
			<tr>
				<td class="rightpad">备注</td>
				<td class="leftpad">
					${block.result.project_desc!''}
				</td>
			</tr>
			<tr>
				<td class="rightpad">审核</td>
				<td class="leftpad">
					<input type="radio" name="review_state" value="1">审核驳回
					<input type="radio" name="review_state" value="2">审核通过
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
</div>