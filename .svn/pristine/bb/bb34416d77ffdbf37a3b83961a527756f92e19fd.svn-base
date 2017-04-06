<script type="text/javascript" language="javascript">
	$(function(){
		//$("#current_time").text(new Date().toLocaleDateString());
		$("#printInfo").click(function(){
			window.location="${_servlet_url!''}/../exportexcel/safecheck.safeauth.dangeroustj";	
		});	
	});
</script>
<style>
.td1{background-color:#1d953f;color:#fff;}
.td2{background-color:#426ab3;color:#fff;}
.td3{background-color:#f15a22;color:#fff;}
.td4{background-color:#aa2116;color:#fff;}
.tdhead {text-align:center;font-size:18px;}
.tpad{text-align:left;padding-left:10px;}
</style>
<div  id="buttons" style="text-align:right">
	<button type="button" id="printInfo" align="right">导出excel</button>
	<!--<button type="button" onclick="javascript:window.history.go(-1);" >返回</button>-->
</div>
<table width="100%" border="1" bordercolor="#000;" cellpadding="0" cellspacing="0" style="border-collapse:collapse;line-height:30px;text-align:center;" align="center">
	<tr><td colspan="10" class="tdhead">济南市房屋安全鉴定检查结果汇总表（幢数）</td></tr>
	<tr><td>报表单位：</td><td colspan="7" class="tpad">济南市房产测绘研究院</td><td>填报日期：</td><td>${map.current_time!''}</td></tr>
	<tr><td rowspan="3">序号</td><td rowspan="3">区县名称</td><td colspan="3">鉴定结果</td><td colspan="3">检查结果</td><td rowspan="2">合计</td><td rowspan="3">备注</td></tr>
	<tr><td class="td2">B级</td><td class="td3">C级</td><td class="td4">D级</td><td class="td2">存在危险点房屋</td><td class="td3">局部危险房屋</td><td class="td4">整幢危险房屋</td></tr>
	<tr><td class="td2">幢数（幢）</td><td class="td3">幢数（幢）</td><td class="td4">幢数（幢）</td><td class="td2">幢数（幢）</td><td class="td3">幢数（幢）</td><td class="td4">幢数（幢）</td><td>幢数（幢）</td></tr>
	[#assign index=1]
	[#list map.relist as relist]
		<tr><td>${index}[#assign index=index+1]</td>
		<td>[#list EnumService.getEnum('xzqh') as enum][#if "${relist.DISTRICT!''}"=="${enum.enum_value!''}"]${enum.enum_name!''}[/#if][/#list]</td>
		[#list relist.districtList as district]
			<td [#if "${district.SAFEGRADE!''}"=="2"]class="td2"[/#if][#if "${district.SAFEGRADE!''}"=="3"]class="td3"[/#if][#if "${district.SAFEGRADE!''}"=="4"]class="td4"[/#if]>${district.COUNT!''}</td>
		[/#list]
		<td>${relist.DISTRICTCOUNT!''}</td><td></td>
		</tr>
	[/#list]
	<tr><td>${index}[#assign index=index+1]</td><td>总计</td>
	[#list map.totallist as total]
		<td [#if "${total.SAFEGRADE!''}"=="2"]class="td2"[/#if][#if "${total.SAFEGRADE!''}"=="3"]class="td3"[/#if][#if "${total.SAFEGRADE!''}"=="4"]class="td4"[/#if]>${total.COUNT!''}</td>
	[/#list]
		<td>${map.totalcount!''}</td><td></td>
	</tr>
</table>
