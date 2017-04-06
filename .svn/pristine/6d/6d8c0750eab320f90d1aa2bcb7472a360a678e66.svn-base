<div class="ui-widget ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;可管理企业列表
	</div>
</div>

<div class="ui-widget ui-widget-content">
	<form id="form1">
		<input type="hidden" name="mem_id" value="${block.mem_id!''}">
		<table id="tab1"  class="ui-widget-content ui-widget-table ui-corner-all" cellspacing="1">
			[#if block.organlist?exists]
			[#list block.organlist as organ]
			<tr class="odd" id="tr_${organ.ORGAN_ID!''}">
				<td>
					<input type="hidden" name="organ_id" value="${organ.ORGAN_ID!''}">${organ.ORGAN_NAME!''}
				</td>
				<td>
					<input type="radio" name="current_organ" value="${organ.ORGAN_ID!''}" [#if "${block.eadmin.current_organ!''}"=="${organ.ORGAN_ID!''}"]checked[/#if]>设为默认
				</td>
				<td><button type="button" onclick="todel('${organ.ORGAN_ID!''}');">删除</button></td>
			</tr>
			[/#list]
			[/#if]
		</table>
	</form>
</div>