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
			楼幢维修记录详细信息
		</span>
	</div>
</div>
<form class="cmxform" style="margin:0" action="${_servlet_url!''}/safecheck.repair.update" method="post" id="updateForm">
	<input type="hidden" name="building_id" id="building_id" value="${block.building_id!''}"/>
	<input type="hidden" name="repair_id" id="repair_id" value="${block.repair_id!''}"/>
	<table id="detailForm" width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<col width="150px"/><col />
		<tr>
			<td class="rightpad">维修内容</td>
			<td class="leftpad">
				<input type="text" name="repair_content" id="repair_content" size="40" value="${block.repair_content!''}"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">维修费用</td>
			<td class="leftpad">
				<input type="text" name="repair_cost" id="repair_cost" size="40" value="${block.repair_cost!''}"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">维修单位</td>
			<td class="leftpad">
				<input type="text" name="repair_organ" id="repair_organ" size="40" value="${block.repair_organ!''}"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">维修负责人</td>
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
			<td class="rightpad">完成时间</td>
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
	</table>
</form>