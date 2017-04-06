<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
.tdpad {padding-left:4px; background-color:#ffffff}
.td_title {text-align:right;padding-right:4px; background-color:#ffffff}
</style>

<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<col width="10%"><col width="40%"><col width="10%"><col width="40%">
			[#list map.list as item]
			<tr>
				<td class="td12">左边界</td><td class="td13">${item.smsdriw!''}</td>
				<td class="td12">上边界</td><td class="td13">${item.smsdrin!''}</td>
			</tr>
			<tr>
				<td class="td12">右边界</td><td class="td13">${item.smsdrie!''}</td>
				<td class="td12">下边界</td><td class="td13">${item.smsdris!''}</td>
			</tr>
			<tr>
				<td class="td12">面积</td><td class="td13">${item.smarea!''} 平方米</td>
				<td class="td12"></td><td class="td13"></td>
			</tr>
			
		 [#if item_has_next][/#if]
				[/#list]	
		</table>