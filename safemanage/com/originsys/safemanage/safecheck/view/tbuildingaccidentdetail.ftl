<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script language="javascript" type="text/javascript">
$(function(){
$("#detailForm :input").attr({disabled:"true"});
});
</script>
<style>
.rightpad{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.leftpad{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
<div class="widget-title-normal">
	<div class="child">
		<span class="widget-title-text">
			楼幢事故详细信息
		</span>
	</div>
</div>
	<table  id="detailForm"  width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<col width="150px"/><col />
		<tr>
			<td class="rightpad">事故标题</td>
			<td class="leftpad">
				<input type="text" name="accident_name" id="accident_name" size="40" value="${block.accident_name!''}"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">事故发生时间</td>
			<td class="leftpad">
				<input type="text" name="accident_date" id="accident_date" size="40" value="${block.accident_date?string("yyyy-MM-dd")}"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">事故类型</td>
			<td class="leftpad">
				<input type="text" name="accident_type" id="accident_type" size="40" value="${block.accident_type!''}"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">事故描述</td>
			<td class="leftpad">
				<textarea name="accident_description" id="accident_description" cols="35" rows="6">${block.accident_description!''}</textarea>
			</td>
		</tr>
		<tr>
			<td class="rightpad">上报人</td>
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
	</table>
