<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
.rightpad{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.leftpad{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
    <!-- 栏目标题开始 -->
	<div class="widget-title-normal">
		<div class="child">
			<span class="widget-title-text">
				危房通知详细
			</span>
		</div>
	</div>
	<div class="widget-content-body">
		<div class="widget-news-content">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;table-layout:fixed;">
			<tr>
				<td width="100px" class="rightpad">通知标题：</td>
				<td class="leftpad" colspan="3">
				${result.notice_title!''}
				</td>
			</tr>
			<tr>
				<td width="100px" class="rightpad">发送时间：</td>
				<td class="leftpad" colspan="3">
				[#if result.notice_date?exists]${result.notice_date?date}[/#if]
				</td>
			</tr>
			<tr>
				<td width="100px" class="rightpad">发送单位：</td>
				<td class="leftpad">
				${result.sender_department!''}
				</td>
				<td width="100px" class="rightpad">发送人：</td>
				<td class="leftpad">
				${result.sender_mem_id!''}
				</td>
			</tr>
			<tr>
				<td width="100px" class="rightpad">通知内容：</td>
				<td class="leftpad" colspan="3">
					${result.notice_content!''}
				</td>
			</tr>
			<tr>
				<td width="100px" class="rightpad">通知附件：</td>
				<td class="leftpad" colspan="3">
					[#if "${result.notice_file!''}"!=""]<a href="${result.notice_file!''}" target="_blank">点击下载</a>[/#if]
				</td>
			</tr>
		</table>
		</div>
	</div>