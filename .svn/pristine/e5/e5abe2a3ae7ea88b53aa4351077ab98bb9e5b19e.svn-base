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

</script>
<!-- 栏目标题开始 -->
	<div class="widget-title-normal">
		<div class="child">
			<span class="widget-title-text">
				资源详细
			</span>
		</div>
	</div>
	<div class="widget-content-body">
		<div class="widget-news-content middle_right">	
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#a4cff2" style="line-height:30px;">
			<tr>
				<td class="td12">资源名称：</td><td class="td13">${block.resource.resources_name!''}</td>
				<td class="td12">资源表名：</td><td class="td13">${block.resource.resources_tablename!""}</td>
				<td class="td12">资源类型：</td>
				<td class="td13">
					[#if "${block.resource.resources_type!''}"=="0"]扩展资源[/#if]
					[#if "${block.resource.resources_type!''}"=="1"]新资源[/#if]
				</td>
			</tr>
			<tr>
				<td class="td12">来源业务系统：</td><td class="td13">${block.resource.source_business_systems!''}</td>
				<td class="td12">资源描述：</td><td class="td13" colspan="3">${block.resource.resources_desc!''}</td>
			</tr>
		</table>
		<table width="100%" border=0 style="line-height:30px;">
		<tr>
		<td style="table_content">列信息</td>
		</tr></table>
		<table width="100%" id="coltab" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#a4cff2" style="line-height:30px;">
			<tr><td class="td11">字段英文名称</td><td class="td11">字段中文名称</td><td class="td11">字段描述</td></tr>
			[#list block.collist as column]
			[#if column_index%2==0]
			<tr>
			<td class="td13">${column.column_ename!''}</td>
			<td class="td13">${column.column_name!''}</td>
			<td class="td13">${column.column_desc!''}</td>
			</tr>
			[#else]
			<tr>
			<td class="td14">${column.column_ename!''}</td>
			<td class="td14">${column.column_name!''}</td>
			<td class="td14">${column.column_desc!''}</td>
			</tr>
			[/#if]
			[/#list]
		</table>
		<table width="100%" border=0 style="line-height:30px;">
		<tr>
		<td style="table_content">索引信息</td>
		</tr></table>
		<table width="100%" id="indextab" border="0" cellpadding="0" cellspacing="1" bgcolor="#a4cff2" style="line-height:30px;">
			<tr><td class="td11">索引类型</td><td class="td11">索引对应字段名称</td><td class="td11">分割符</td><td class="td11">索引描述</td></tr>
			[#list block.indexlist as indexobj]
			[#if indexobj_index%2==0]
			<tr>
			<td class="td13">${indexobj.index_type!''}</td>
			<td class="td13">${indexobj.index_column!''}</td>
			<td class="td13">${indexobj.index_separate!''}</td>
			<td class="td13">${indexobj.index_desc!''}</td>
			</tr>
			[#else]
			<tr>
			<td class="td14">${indexobj.index_type!''}</td>
			<td class="td14">${indexobj.index_column!''}</td>
			<td class="td14">${indexobj.index_separate!''}</td>
			<td class="td14">${indexobj.index_desc!''}</td>
			</tr>
			[/#if]
			[/#list]
			
		</table>
		</div>
	</div>
	<!-- 栏目内容结束 -->
	<div class="widget-bottom">
		<div class="widget-bottom-right"></div>
	</div>