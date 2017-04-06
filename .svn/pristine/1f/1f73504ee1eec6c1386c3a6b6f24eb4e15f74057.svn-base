<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<style>
.td11{text-align:center;background-color:#DAEAFE;color:#2a51a4;}
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
.td14{padding-left:12px;background-color:#E1F1FE;color:#4D4D4D;}
.table_content{
	font-size:12px;
	font-weight:no;
	padding-left:12px;
	color:#4d4d4d
}
.middle_right{
	font-family:"微软雅黑";
	font-size:12px;
	font-weight:bolder;
}
</style>
<script language="javascript">
function clearNoNum(obj){
	obj.value = obj.value.replace(/[^\w-_]/g,"");
}
function deltr(obj){
	 $(obj).parent().parent().remove();	
}
$(function(){
	$("#addinputparams").click(function(){
		var str="<tr><td class='td14'><input type='text' name='param_code' onkeyup='clearNoNum(this)'><input type='hidden' name='param_type' value='0'></td>";
		str+="<td class='td14'><select name='is_required'><option value='1'>是</option><option value='0'>否</option></select></td>";
		str+="<td class='td14'><input type='text' name='param_desc'></td>";
		str+="<td class='td14'><select name='field_type'><option value='string'>string</option>";
		str+="<option value='int'>int</option><option value='date'>date</option></select></td>";
		str+="<td class='td14'><button type='button' class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only' onclick='deltr(this);'><span class='ui-button-text'>删除</span></button></td></tr>";
		$("#inputparam").append(str);
	});
	$("#addreturnparams").click(function(){
		var str="<tr><td class='td14'><input type='text' name='param_code' onkeyup='clearNoNum(this)'><input type='hidden' name='param_type' value='1'></td>";
		str+="<td class='td14'><input type='text' name='param_desc'>";
		str+="<input type='hidden' name='is_required' value=''><input type='hidden' name='field_type' value=''></td>";
		str+="<td class='td14'><button type='button' class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only' onclick='deltr(this);'><span class='ui-button-text'>删除</span></button></td></tr>";
		$("#returnparam").append(str);
	});
});
function dosub(type){
	$("#op_type").val(type);
	if($("#service_name").val()==""){
		alert("请输入服务名称！");
		return false;
	}
	var queryString=$("#addform").formSerialize();
	$.post($("#addform").attr("action"),queryString,
		function(data,textStatus){
			var jdata=jQuery.parseJSON(data);
			if(jdata.success=="1"){
				alert("增加成功！");
				window.location.reload();
			}else{
				alert("增加失败！");
		}
	});
}
</script>
[#global web=JspTaglibs["/WEB-INF/eap.tld"]]
<table width="100%" style="table-layout:fixed;">
<tr><td style="vertical-align:top;" width="250px">
[@web.block component_name="数据中心" site_id="eap2" params="" action_name="服务左侧菜单" action_id="datacenter.service.menu" block_name="数据中心" block_id="" component_id="datacenter" /]
</td><td style="vertical-align:top;">
<!-- 栏目标题开始 -->
	<div class="widget-title-normal">
		<div class="child">
			<span class="widget-title-text">
				服务注册
			</span>
		</div>
	</div>
	<div class="widget-content-body">
		<div class="widget-news-content middle_right">
<form action="${_servlet_url!''}/datacenter.service.add" id="addform" method="post">
<input type="hidden" name="op_type" id="op_type" value="">			
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
	<cols width="150"/><cols /><cols width="150"/><cols />
	<tr>
		<td class="td12">服务名称：</td>
		<td class="td13" colspan="3"><input type="text" name="service_name" id="service_name" size="90"></td>
	</tr>
	<tr>
		<td class="td12">服务描述：</td>
		<td class="td13" colspan="3"><textarea name="service_desc" id="service_desc" cols="60" rows="4"></textarea></td>
	</tr>
	<tr>
		<td class="td12" style="vertical-align:top;">输入参数：</td>
		<td class="td13" colspan="3">
			<button type="button" id="addinputparams">增加行</button><br>
			<table width="100%" id="inputparam" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
				<tr><td class="td11">参数名称</td><td class="td11">是否必需</td><td class="td11">参数描述</td><td class="td11">参数类型</td><td class="td11">操作</td></tr>
			</table>
		</td>
	</tr>
	<tr>
		<td class="td12" style="vertical-align:top;">返回字段描述：</td>
		<td class="td13" colspan="3">
			<button type="button" id="addreturnparams">增加行</button><br>
			<table width="100%" id="returnparam" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
				<tr><td class="td11">字段名称</td><td class="td11">字段描述</td><td class="td11">操作</td></tr>
			</table>
		</td>
	</tr>
	<tr>
		<td class="td12">返回内容示例：</td>
		<td class="td13" colspan="3"><textarea name="example_image" id="example_image" cols="60" rows="4"></textarea></td>
	</tr>
	<tr>
		<td class="td12">服务地址：</td>
		<td class="td13" colspan="3"><input type="text" name="request_url" id="request_url" size="90"></td>
	</tr>
	<tr>
		<td class="td12">服务提供者：</td>
		<td class="td13" colspan="3"><input type="text" name="service_provide" id="service_provide" size="90"></td>
	</tr>
	<tr>
		<td class="td12">服务分类：</td>
		<td class="td13">
			<select id="service_type" name="service_type">
			<option value="1">数据资源服务</option>
			<option value="2">云平台服务</option>
			<option value="3">业务数据服务</option>
			<option value="4">逻辑服务</option>
			<option value="5">通用服务</option>
			</select>
		</td>
		<td class="td12">代理服务类型：</td>
		<td class="td13">
			<input type="radio" name="proxy_type" value="http" checked>http服务
			<input type="radio" name="proxy_type" value="webservice">webservice服务
		</td>
	</tr>
	<tr>
		<td class="td12">是否需要用户授权：</td>
		<td class="td13">
			<input type="radio" name="is_authorize" value="0" checked>否
			<input type="radio" name="is_authorize" value="1">是
		</td>
		<td class="td12">服务申请授权方式：</td>
		<td class="td13"><input type="text" name="authorize_mode" id="authorize_mode"></td>
	</tr>
	<tr>
		<td class="td12">服务版本：</td>
		<td class="td13"><input type="text" name="service_version" id="service_version"></td>
		<td class="td12">是否需要审核：</td>
		<td class="td13">
			<input type="radio" name="is_check" value="0" checked>否
			<input type="radio" name="is_check" value="1">是
		</td>
	</tr>
	<tr>
		<td colspan="4" class="td2" align="center">&nbsp;
		</td>
	</tr>
	<tr>
		<td colspan="4" class="td2" align="center">
			<button type="button" onclick="dosub(1);">暂存</button>&nbsp;
			<button type="button" onclick="dosub(2);">提交</button>&nbsp;
			<button type="reset">重置</button>
		</td>
	</tr>
</table>
</form>
		</div>
	</div>
	<!-- 栏目内容结束 -->
	<div class="widget-bottom">
		<div class="widget-bottom-right"></div>
	</div>
</td></tr></table>