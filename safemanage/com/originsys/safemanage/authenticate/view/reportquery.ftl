<script type="text/javascript" language="javascript">
function cha(){
	$("#dic_form").submit();
}
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
<div class="widget-title-normal">
	<div class="child">
		<span class="widget-title-text">
			安全鉴定查询
		</span>
	</div>
</div>
<div style="min-height:380px;border:1px solid #dbdbdb;">
<form name="dic_form" id="dic_form" action="${_servlet_url!''}/safeauth.report.query" method="post">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="margin-top:10px;margin-bottom:10px;">
	<tr>
	<td align="center">楼幢地址: <input type="text" name="building_address" id="building_address" size="50"/>
		<button type="button" onclick="cha();" style="margin-left:20px;">查询</button></td>
	</tr>
	<tr><td align="center" style="color:red;">温馨提示：请输入完整的楼幢地址进行查询</td><td></td></tr>
	</table>
</form>
[#assign num=block.resultList?size]
[#if num>0]
<table width="100%" border="1"  bordercolor="#c5e2ff" cellpadding="0" cellspacing="0" style="border-collapse:collapse;line-height:30px;text-align:center;" align="center">
	<tr bgcolor="#ecf6ff" align="center" class="dahei"><td>序号</td><td>楼幢地址</td><td>所属区域</td><td>鉴定单位</td><td>鉴定人</td><td>鉴定时间</td><td>安全等级</td><td>&nbsp;</td></tr>
	[#list block.resultList as result]
		<tr>
		<td>${result_index+1}</td>
		<td>${result.building_address!''}</td>
		<td>[#assign qh=""]
			[#list EnumService.getEnum('xzqh') as enum]
			[#if "${result.building_region!''}"=="${enum.enum_value!''}"][#assign qh="${enum.enum_name!''}"][#break][/#if]
			[/#list]${qh!''}</td>
		<td>${result.jd_department!''}</td>
		<td>${result.jdmember!''}</td>
		<td>[#if result.jd_date?exists]${result.jd_date?date}[#else] [/#if]</td>
		<td>[#assign dangerous_level=""]
			[#if "${result.dangerous_level!''}"=="1"][#assign dangerous_level="<div style='heigth:20px;width:70px;background-color:green;float:right;'> </div>A级"][/#if]
		    [#if "${result.dangerous_level!''}"=="2"][#assign dangerous_level="<div style='heigth:20px;width:70px;background-color:yellow;float:right;'> </div>B级"][/#if]
		    [#if "${result.dangerous_level!''}"=="3"][#assign dangerous_level="<div style='heigth:20px;width:70px;background-color:#CC6600;float:right;'> </div>C级"][/#if]
		    [#if "${result.dangerous_level!''}"=="4"][#assign dangerous_level="<div style='heigth:20px;width:70px;background-color:red;float:right;'> </div>D级"][/#if]
			${dangerous_level!''}</td>
		<td>[#if "${result.jd_report!''}"!=""]<a href="${result.jd_report!''}">下载报告</a>[#else]暂无报告[/#if]</td>
		</tr>
	[/#list]
</table>
[/#if]
</div>
