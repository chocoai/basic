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
	var str="";
	if(null==$("#building_address").val() || $("#building_address").val()==''){
		str+="坐落地址不能为空\n\r";
	}
	if(null==$("#building_region").val() || $("#building_region").val()==''){
		str+="所属区域不能为空\n\r";
	}
	var regu="^(0|[1-9][0-9]*)$";//验证零和非零开头的数字
	var re = new RegExp(regu); 
	if($("#house_count").val()!='' && !(re.test($("#house_count").val()))){ 
		str+="户数填写不正确\n\r";
	} 
	if($("#floor_count").val()!='' && !(re.test($("#floor_count").val()))){ 
		str+="地上层数填写不正确\n\r";
	}
	if(null==$("#link_man").val() || $("#link_man").val()==''){
		str+="联系人不能为空\n\r";
	}
	if(null==$("#link_tel").val() || $("#link_tel").val()==''){
		str+="联系方式不能为空\n\r";
	}
	if(null==$("#dangerous_desc").text() || $("#dangerous_desc").text()==''){
		str+="隐患说明不能为空\n\r";
	}
	if(str!=''){
		alert(str);
	}else{
		var queryString=$("#addForm").formSerialize();
		$.post($("#addForm").attr("action"),queryString,
			function(data,textStatus){
			var jdata=jQuery.parseJSON(data);
			if(jdata.success=="0"){
				alert("提交失败！");
			}else{
				alert("提交成功！");
			}
		});
	}
}
</script>
 <style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
 	<!-- 栏目标题开始 -->
	<div class="widget-title-normal">
		<div class="child">
			<span class="widget-title-text">
				隐患房屋上报
			</span>
		</div>
	</div>
	<!-- 栏目标题结束 -->
	<!-- 栏目内容开始 -->
	<div class="widget-content-body">
		<div class="widget-news-content">
		<form action="${_servlet_url!''}/safecheck.tHdangerBuildingadd" id="addForm" method="post">
			<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
			<tr>
				<td class="td12" width="25%"><font color="red">*&nbsp;</font>楼幢坐落：</td>
				<td class="td13"><input type="text" name="building_address" id="building_address" size="60"></td>
			</tr>
			<tr>
				<td class="td12"><font color="red">*&nbsp;</font>所属区域：</td>
				<td class="td13">
				<select id="building_region" name="building_region">
				<option value="">------请选择------</option>
				[#list EnumService.getEnum('xzqh') as enum]
				<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
				[/#list]
				</select>
				</td>
			</tr>
			<tr>
				<td class="td12">户&nbsp;&nbsp;&nbsp;&nbsp;数：</td>
				<td class="td13"><input type="text" name="house_count" id="house_count"></td>
			</tr>
			<tr>
				<td class="td12">层&nbsp;&nbsp;&nbsp;&nbsp;数：</td>
				<td class="td13"><input type="text" name="floor_count" id="floor_count"></td>
			</tr>
			<tr>
				<td class="td12"><font color="red">*&nbsp;</font>联&nbsp;系&nbsp;人：</td>
				<td class="td13"><input type="text" name="link_man" id="link_man"></td>
			</tr>
			<tr>
				<td class="td12"><font color="red">*&nbsp;</font>联系方式：</td>
				<td class="td13"><input type="text" name="link_tel" id="link_tel"></td>
			</tr>
			<tr>
				<td class="td12">相关附件：</td>
				<td class="td13"><input type="text" name="annex_file" id="annex_file"></td>
			</tr>
			<tr>
				<td class="td12">相关图片：</td>
				<td class="td13"><input type="text" name="annex_image" id="annex_image"></td>
			</tr>
			<tr>
				<td class="td12"><font color="red">*&nbsp;</font>隐患说明：</td>
				<td class="td13">
				<textarea id="dangerous_desc" name="dangerous_desc" cols="50" rows="6"></textarea>
				</td>
			</tr>
			<tr>
				<td class="td12">&nbsp;</td>
				<td class="td13"><button type="button" onclick="dosave();">提&nbsp;&nbsp;&nbsp;&nbsp;交</button></td>
			</tr>
			</table>
		</form>
		</div>
	</div>
	<!-- 栏目内容结束 -->
	<div class="widget-bottom">
		<div class="widget-bottom-right"></div>
	</div>