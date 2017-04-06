<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script type="text/javascript" language="javascript">
function dosave(op){
	var str="";
	if(null==$("#building_address").val() || $("#building_address").val()==''){
		str+="鉴定地址不能为空\n\r";
	}
	if(null==$("#building_region").val() || $("#building_region").val()==''){
		str+="所属区域不能为空\n\r";
	}	
	if(str!=''){
		alert(str);
	}else{	
		var queryString=$("#addForm").formSerialize();
		$.post($("#addForm").attr("action")+"?op="+op,queryString,
			function(data,textStatus){
			var jdata=jQuery.parseJSON(data);
			if(jdata.success==0){
				if(op=="zc")
					alert("暂存失败！");
				else
					alert("提交失败！");
			}else{
				if(op=="zc")
					alert("暂存成功！");
				else
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
.file-box input{ vertical-align:middle; margin:0; padding:0}
.file-box{ position:relative;width:440px;WHITE-SPACE:nowrap;}
.file-box .txt{ height:22px; border:1px solid #cdcdcd; width:195px;}
.file-box .btn{ background-color:#FFF; border:1px solid #CDCDCD;height:24px; width:60px;}
.file-box .file{ position:absolute; top:3px; right:180px; height:24px; filter:alpha(opacity:0);opacity: 0;width:260px }
</style>
<div class="widget-title-normal">
	<div class="child">
		<span class="widget-title-text">
			鉴定报告增加
		</span>
	</div>
</div>
<form action="${_servlet_url!''}/safeauth.report.insert" id="addForm" method="post">
	<input type="hidden" name="building_id" value="${block.sbid!''}">
	<div  id="buttons" style="text-align:right">
		<button type="reset">重置</button>
		<button type="button" onclick="dosave('zc');">暂存</button>
		<!--button type="button" onclick="dosave('tj');">提交</button-->
	</div>
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<tr>
			<td class="td12"><font color="red">*&nbsp;</font>鉴定地址：</td>
			<td class="td13" colspan="3"><input type="text" name="building_address" id="building_address" size="60" value="${block.building_address!''}"></td>
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
	</table>
</form>
