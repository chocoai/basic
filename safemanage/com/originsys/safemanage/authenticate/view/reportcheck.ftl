<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/swfobject.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/ui.upload.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	$("#addForm :input").attr({disabled:"true"});
});
function dosave(){	
	var flag=window.confirm("审核通过的信息不能再做任何操作，确认提交吗？");
	if(flag){
		var queryString=$("#addForm1").formSerialize();
		$.post($("#addForm1").attr("action"),queryString,
			function(data,textStatus){
			var jdata=jQuery.parseJSON(data);
			if(jdata.success==0){
				alert("出现错误,审核失败！");
			}else{
				alert("审核完毕！");
				window.close();
			}
		});
	}
}
</script>
<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
<div class="widget-title-normal">
	<div class="child">
		<span class="widget-title-text">
			鉴定报告审核
		</span>
	</div>
</div>	
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<tr>
		<td class="td13">
		鉴定报告信息
		</td>
		</tr>
	</table>
	[#import "reportdetail.ftl" as reportdetail /]
	[@reportdetail.reportdetail result=result /]		
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<form action="${_servlet_url!''}/safeauth.report.check" id="addForm1" method="post">
			<input type="hidden" name="jdinfo_id" value="${result.jdinfo_id!''}">
			<input type="hidden" name="building_id" value="${result.building_id!''}">
			<input type="hidden" name="building_address" value="${result.building_address!''}">
			<input type="hidden" name="building_region" value="${result.building_region!''}">
			<input type="hidden" name="dangerous_level" value="${result.dangerous_level!''}">
			<input type="hidden" name="jd_department" value="${result.jd_department!''}">
			<input type="hidden" name="annex_image" value="${result.jd_image!''}">
		<input type="hidden" name="annex_file" value="${result.jd_report!''}">
			<input type="hidden" name="jd_date" [#if result.jd_date?exists]value="${result.jd_date?string('yyyy-MM-dd')}"[/#if]>
			<tr>
				<td class="td13" colspan="6">
					审核信息
				</td>
			</tr>
			<tr>
				<td class="td12">审核操作：</td>
				<td class="td13">
					<input type="radio" name="info_state" value="8">审核通过
					<input type="radio" name="info_state" value="2">审核驳回
				</td>
				<td class="td12">审核意见：</td>
				<td class="td13" colspan="3"><textarea cols="50" rows="3" name="check_opinion"></textarea></td>
							
			</tr>
			<tr>
				<td class="td13" colspan="6" align="center">
					<button type="button" onclick="dosave();">提交</button>
					<!-- button type="button" onclick="javascript:window.history.go(-1);" >返回</button-->
				</td>
			</tr>
		</form>
	</table>	
	
