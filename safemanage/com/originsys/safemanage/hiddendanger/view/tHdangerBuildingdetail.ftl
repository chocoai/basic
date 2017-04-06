<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/swfobject.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/ui.upload.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	//附件上传
	$("#annex_file").upload({
		width:150,
		type:"doc",
		savepath:"files/survey/",
		completed:function(event, json){
 			$("#annex_file").val(json.download_url);
		}
	});
	//图片上传
	$("#annex_image").upload({
		width:150,
		height:80,
		type:"image"
	});
});
function dosave(){
	if($("#accept_opinion").text()==''){
		alert("请输入受理意见!");
		return false;
	}else{
		var queryString=$("#addForm").formSerialize();
		$.post($("#addForm").attr("action"),queryString,
			function(data,textStatus){
			var jdata=jQuery.parseJSON(data);
			if(jdata.success=="0"){
				alert("提交失败！");
			}else{
				alert("提交成功！");
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
				隐患房屋上报详细
			</span>
		</div>
	</div>
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a6cef2" style="table-layout:fixed;line-height:30px;">
			<tr>
				<td class="td12">楼幢坐落</td>
				<td class="td13" colspan="3">${result.building_address!''}</td>
			</tr>
			<tr>
				<td class="td12">所属区域</td>
				<td class="td13">[#assign qh=""]
				[#list EnumService.getEnum('xzqh') as enum]
				[#if "${result.building_region!''}"=="${enum.enum_value!''}"][#assign qh="${enum.enum_name!''}"][#break][/#if]
				[/#list]${qh!''}
				</td>
				<td class="td12">录入时间</td>
				<td class="td13">[#if result.entry_time?exists]${result.entry_time?string('yyyy-MM-dd')}[/#if]</td>
			</tr>
			<tr>
				<td class="td12">户&nbsp;&nbsp;&nbsp;&nbsp;数</td>
				<td class="td13">${result.house_count!''}</td>
				<td class="td12">层&nbsp;&nbsp;&nbsp;&nbsp;数</td>
				<td class="td13">${result.floor_count!''}</td>
			</tr>
			<tr>
				<td class="td12">联&nbsp;系&nbsp;人</td>
				<td class="td13">${result.link_man!''}</td>
				<td class="td12">联系方式</td>
				<td class="td13">${result.link_tel!''}</td>
			</tr>
			<tr>
				<td class="td12">附&nbsp;&nbsp;&nbsp;&nbsp;件</td>
				<td class="td13"><input type="text" name="annex_file" id="annex_file" value="${result.annex_file!''}"></td>
				<td class="td12">图&nbsp;&nbsp;&nbsp;&nbsp;片</td>
				<td class="td13"><input type="text" name="annex_image" id="annex_image" value="${result.annex_image!''}"></td>
			</tr>
			<tr>
				<td class="td12">隐患说明</td>
				<td class="td13" colspan="3">${result.dangerous_desc!''}</td>
			</tr>
			[#if "${result.info_state!''}"=="1"]
			<tr>
				<td class="td12">受理意见</td>
				<td class="td13" colspan="3">
				${result.accept_opinion!''}</td>
			</tr>
			<tr>
				<td class="td12">受&nbsp;理&nbsp;人</td>
				<td class="td13">${result.acceptor!''}</td>
				<td class="td12">受理时间</td>
				<td class="td13">
				[#if result.accept_date?exists]${result.accept_date?string('yyyy-MM-dd')}[/#if]
				</td>
			</tr>
			[#else]
			<form action="${_servlet_url!''}/safecheck.tHdangerBuildingupdate" id="addForm" method="post">
			<tr>
				<td class="td12">受理意见</td>
				<td class="td13" colspan="3">
				<input type="hidden" name="info_id" value="${result.info_id!''}">
				<textarea name="accept_opinion" id="accept_opinion" cols="40" rows="4"></textarea></td>
			</tr>
			<tr>
				<td class="td13" colspan="4" align="center"><button type="button" onclick="dosave();">提&nbsp;&nbsp;&nbsp;&nbsp;交</button></td>
			</tr>
			</form>
			[/#if]
	</table>