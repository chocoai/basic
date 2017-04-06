<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script language="javascript" type="text/javascript">
$(function(){
	$("#updateInfo").click(function(){
		var message="";
		if($("#region",$("#updateForm")).val()=="")
			message+="管理区域不能为空"+"\n\r";
		if(message!=""){
			alert(message);
			return false;
		}
		var queryString=$("#updateForm").formSerialize();
		$.post($("#updateForm").attr("action"),queryString,
			function(data,textStatus){
				var jdata=jQuery.parseJSON(data);
				if(jdata.success==1){
					alert("保存成功！");
					window.close();
				}else{
					alert("操作失败！");
				}
		});
	});
});

</script>
<style>
.rightpad{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.leftpad{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
[#assign result=block.safemanager]
<div class="ui-widget ui-corner-all" style="position: relative;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;更新安全管理员用户类型属性表
	</div>
</div>
<form class="cmxform" style="margin:0" action="${_servlet_url!''}/safemanage.safemanager.update1" method="post" id="updateForm">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<input type="hidden" name="mem_id" id="mem_id" value="${result.mem_id!''}"/>
			<tr>
					<td class="rightpad" width="25%">管理范围:</td>
					<td class="leftpad">
						<select id="region" name="region">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('xzqh') as enum]
							<option value="${enum.enum_value!''}" [#if "${result.region!''}" == "${enum.enum_value!''}"]selected="true"[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
			</tr>
			<tr>
				<td style="background-color:#FFFFFF;"></td>
				<td style="background-color:#FFFFFF;">
					<button type="button" id="updateInfo">提交</button>&nbsp;
					<button type="button" onClick="window.history.go(-1);">返回</button>
				</td>
		</tr>
	</table>
</form>