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
function clearNoNum2(obj){
	obj.value = obj.value.replace(/[^\w-_\#\|]/g,"");
}
function clearNoNum3(obj){
	obj.value = obj.value.replace(/[^\#\|]/g,"");
}
function deltr(obj){
	 $(obj).parent().parent().remove();	
}
$(function(){
	$("#addcol").click(function(){
		var str="<tr><td class='td13'><input type='text' name='column_ename' onkeyup='clearNoNum(this)'></td>";
		str+="<td class='td13'><input type='text' name='column_name'></td>";
		str+="<td class='td13'><input type='text' name='column_desc'></td>";
		str+="<td class='td13'><button type='button' class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only' onclick='deltr(this);'><span class='ui-button-text'>删除</span></button></td></tr>";		
		$("#coltab").append(str);
	});
	$("#addindex").click(function(){
		var str="<tr><td class='td13'><select name='index_type'><option value='rowkey'>rowkey</option></select></td>";
		str+="<td class='td13'><input type='text' name='index_column' onkeyup='clearNoNum2(this)'></td>";
		str+="<td class='td13'><input type='text' name='index_separate' maxlength='1' onkeyup='clearNoNum3(this)' size='2'><span>只能输入#或是|</span></td>";
		str+="<td class='td13'><input type='text' name='index_desc'></td>";
		str+="<td class='td13'><button type='button' class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only' onclick='deltr(this);'><span class='ui-button-text'>删除</span></button></td></tr>";
		$("#indextab").append(str);
	});
});
function dosub(type){
	$("#op_type").val(type);
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
<table <table width="100%" style="table-layout:fixed;">
<tr><td style="vertical-align:top;" width="250px">
[@web.block component_name="数据中心" site_id="eap2" params="" action_name="资源左侧菜单" action_id="datacenter.resources.menu" block_name="数据中心" block_id="" component_id="datacenter" /]
</td><td style="vertical-align:top;">
<!-- 栏目标题开始 -->
	<div class="widget-title-normal">
		<div class="child">
			<span class="widget-title-text">
				资源注册
			</span>
		</div>
	</div>
	<div class="widget-content-body">
		<div class="widget-news-content middle_right">
		<form action="${_servlet_url!''}/datacenter.resources.add" id="addform" method="post">
		<input type="hidden" name="op_type" id="op_type" value="">		
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#a4cff2" style="line-height:30px;">
			<tr>
				<td class="td12">资源名称：</td><td class="td13"><input type="text" name="resources_name" id="resources_name"></td>
				<td class="td12">资源表名：</td><td class="td13"><input type="text" name="resources_tablename" id="resources_tablename"></td>
				<td class="td12">资源类型：</td>
				<td class="td13">
					<select id="resources_type" name="resources_type">
						<option value="0">扩展资源</option>
						<option value="1">新资源</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="td12">来源业务系统：</td><td class="td13"><input type="text" name="source_business_systems" id="source_business_systems"></td>
				<td class="td12">资源描述：</td><td class="td13" colspan="3"><input type="text" name="resources_desc" id="resources_desc" size="50"></td>
			</tr>
		</table>
		<table width="100%" border=0>
		<tr>
		<td style="table_content">列信息</td>
		<td align="right"><button type="button" id="addcol">增加行</button></td></tr></table>
		<table width="100%" id="coltab" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#a4cff2" style="line-height:30px;">
			<tr><td class="td11">字段英文名称</td><td class="td11">字段中文名称</td><td class="td11">字段描述</td><td class="td11">操作</td></tr>
			
		</table>
		<table width="100%" border=0>
		<tr>
		<td style="table_content">索引信息</td>
		<td align="right"><button type="button" id="addindex">增加行</button></td></tr></table>
		<table width="100%" id="indextab" border="0" cellpadding="0" cellspacing="1" bgcolor="#a4cff2" style="line-height:30px;">
			<tr><td class="td11">索引类型</td><td class="td11">索引对应字段名称</td><td class="td11">分割符</td><td class="td11">索引描述</td><td class="td11">操作</td></tr>
			
		</table>
		<table width="100%" border=0>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td align="center">
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