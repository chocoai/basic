<script type="text/javascript" language="javascript">
	$(function(){
		//$("#current_time").text(new Date().toLocaleDateString());
		$("#printInfo").click(function(){
			window.location="${_servlet_url!''}/../exportexcel/safecheck.auth.housecounthz";	
		});	
	});
</script>
<style>
body,td,th {
	font-family: "微软雅黑";
	font-size: 12px;
	color: #424242;
	text-align:center;
}
.zi {font-size: 14px;
	 font-weight:bold;}

.baida {
	font-family: "微软雅黑";
	font-size: 16px;
	color: #fff;
	font-weight:bold;
	text-decoration: none;
}
.dahei{
	font-size:15px;
	font-weight:bold;}
.lanxiao {
	font-family: "微软雅黑";
	font-size: 14px;
	color: #0053d7;
	font-weight:bold;
	text-decoration: none;
}
.hongzi{
	font-size: 14px;
	color: #c40532;
	font-weight:bold;
</style>
<div  id="buttons" style="text-align:right">
	<button type="button" style="display:none" id="printInfo" align="right">导出excel</button>
	<!--<button type="button" onclick="javascript:window.history.go(-1);" >返回</button>-->
</div>
<table width="100%" border="1" bordercolor="#c5e2ff"  cellpadding="0" cellspacing="0" style="line-height:30px;text-align:center;border-collapse:collapse;" align="center">
	<tr><td colspan="10" align="center" bgcolor="#519ce8" class="baida">济南市安全鉴定汇总表（幢数）</td></tr>
	<tr><td style="font-weight:bold;">报表单位：</td><td colspan="9" style="text-align:left;padding-left:10px;">济南市房产测绘研究院</td></tr>
	<tr>
		<td rowspan="2" bgcolor="#ecf6ff" align="center" class="dahei">序号</td>
		<td rowspan="2" bgcolor="#ecf6ff" align="center" class="dahei">区县名称</td>
		<td colspan="4" bgcolor="#fbfbfb" class="hongzi">维修加固的房屋数量</td>
		<td colspan="4" bgcolor="#fbfbfb" class="hongzi">停用拆除的房屋数量(包括已翻建的)</td>
	</tr>
	
	<tr>
		<td bgcolor="#f9f9f9">楼栋数（幢）</td>
		<td bgcolor="#f9f9f9">面积（㎡）</td>
		<td bgcolor="#f9f9f9">套（间）数</td>
		<td bgcolor="#f9f9f9">户数</td>
		
		<td bgcolor="#f9f9f9">楼栋数（幢）</td>
		<td bgcolor="#f9f9f9">面积（㎡）</td>
		<td bgcolor="#f9f9f9">套（间）数</td>
		<td bgcolor="#f9f9f9">户数</td>
	</tr>

	[#assign index=1]
	[#list map.relist as relist]
		<tr>
		<td bgcolor="#f9fdff">${index}[#assign index=index+1]</td>
		<td [#if relist_index%2==0] bgcolor="#FFFFFF" [#else] bgcolor="#f9f9f9" [/#if]>${relist.r!''}</td>
		[#list relist.countlist as tj]
			<td [#if relist_index%2==0] bgcolor="#FFFFFF" [#else] bgcolor="#f9f9f9" [/#if]>${tj.c!''}</td>
		[/#list]
		</tr>
	[/#list]
	
</table>
