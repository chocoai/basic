<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/ajaxfileupload.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	$("#outdiv").css("display","block");
});
function dosave(op){
	var str="";
	var disaster_name=$("#disaster_name").val();
	if(null==$("#disaster_name").val() || $("#disaster_name").val()==''){
		str+="灾害简称不能为空\n\r";
	}
	if(null==$("#disaster_region").val() || $("#disaster_region").val()==''){
		str+="所属区域不能为空\n\r";
	}
	if(null==$("#disaster_date").val() || $("#disaster_date").val()==''){
		str+="灾害发生时间不能为空\n\r";
	}
	var disaster_date=$("#disaster_date").val();
	if(disaster_date!=""){
		var ed=new Date();
		re = /-/g;
		var sd=new Date(Date.parse(disaster_date.replace(re, "/")));
		if(sd>ed){
			str+="灾害发生时间不能大于当前日期\n\r";
		}
	}
	if(null==$("#disaster_type").val() || $("#disaster_type").val()==''){
		str+="灾害类型不能为空\n\r";
	}
	if(null==$("#disaster_grade").val() || $("#disaster_grade").val()==''){
		str+="灾害级别不能为空\n\r";
	}
	
	if(str!=''){
		alert(str);
	}else{
		var queryString=$("#addForm").formSerialize();
		$.post($("#addForm").attr("action"),queryString,
			function(data,textStatus){
			var jdata=jQuery.parseJSON(data);
			if(jdata.success==0){
					alert("提交失败！");
					window.close();
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
.tdpad {padding-left:4px; background-color:#ffffff}
.td_title {text-align:right;padding-right:4px; background-color:#ffffff}
</style>
<div class="widget-title-normal">
	<div class="child">
		<span class="widget-title-text">
			突发事件修改
		</span>
	</div>
</div>
<div id="outdiv" style="display:none">
<form action="${_servlet_url!''}/safecheck.disasterwarn.update" id="addForm" method="post">
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .1em;">
	<div class="ui-widget" id="tabs">
		<input type="hidden" name="disaster_id" id="disaster_id" value="${block.dWarn.disaster_id!''}">
		<input type="hidden" name="info_state" id="info_state" value="${block.dWarn.info_state!''}">
		<input type="hidden" name="smuserid" id="smuserid" value="${block.dWarn.sbid!''}">
		<input type="hidden" name="smx" id="smx" value="${block.dWarn.smx!''}">
		<input type="hidden" name="smy" id="smy" value="${block.dWarn.smy!''}">
			<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
				<tr>
					<td class="td12"><font color="red">*&nbsp;</font>灾害简称：</td>
					<td class="td13"><input type="text" id="disaster_name" name="disaster_name" size="60" value="${block.dWarn.disaster_name!''}"></td>
				</tr>
				<tr>
					<td class="td12"><font color="red">*&nbsp;</font>所属区域：</td>
					<td class="td13">
					<select id="disaster_region" name="disaster_region">
						<option value="">------请选择------</option>
						[#list EnumService.getEnum('xzqh') as enum]
						<option value="${enum.enum_value!''}" [#if "${block.dWarn.disaster_region!''}"=="${enum.enum_value!''}"]selected[/#if]>${enum.enum_name!''}</option>
						[/#list]
						</select>
					</td>
				</tr>
				<tr>
					<td class="td12"><font color="red">*&nbsp;</font>灾害发生时间:</td>
					<td class="td13">
						<input type="text" size="17" name="disaster_date" id="disaster_date" onClick="WdatePicker()"   [#if block.dWarn.disaster_date?exists]value="${block.dWarn.disaster_date?string('yyyy-MM-dd')}"[/#if] />
					</td>
				</tr>
				<tr>
					<td class="td12"><font color="red">*&nbsp;</font>灾害类型:</td>
					<td class="td13">
						<select id="disaster_type" name="disaster_type">
						<option value="">------请选择------</option>
						[#list EnumService.getEnum('disaster_type') as enum]
						<option value="${enum.enum_value!''}" [#if "${block.dWarn.disaster_type!''}"=="${enum.enum_value!''}"]selected[/#if]>${enum.enum_name!''}</option>
						[/#list]
						</select>
					</td>
				</tr>
				<tr>
					<td class="td12"><font color="red">*&nbsp;</font>灾害级别:</td>
					<td class="td13">
						<select name="disaster_grade" id="disaster_grade">
						<option value="">------请选择------</option>
						<option value="1" [#if "${block.dWarn.disaster_grade!''}"=="1"]selected[/#if]>一般</option>
						<option value="2" [#if "${block.dWarn.disaster_grade!''}"=="2"]selected[/#if]>较大</option>
						<option value="3" [#if "${block.dWarn.disaster_grade!''}"=="3"]selected[/#if]>重大</option>
						<option value="4" [#if "${block.dWarn.disaster_grade!''}"=="4"]selected[/#if]>特别重大</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td12">灾害描述</td>
					<td class="td13">
						<textarea cols="60" rows="5" name="disaster_discription">${block.dWarn.disaster_discription!''}</textarea>
					</td>
				</tr>
				<tr>
					<td class="td12"></td>
					<td class="td13">
						<button type="reset">重置</button>
						<button type="button" onclick="dosave();" style="margin-left:20px;">提交</button>
					</td>
				</tr>
			</table>		
	</div>
</div>	
</form>
</div>