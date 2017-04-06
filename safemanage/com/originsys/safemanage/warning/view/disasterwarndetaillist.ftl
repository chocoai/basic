<style>
.tdhead {text-align:center;font-size:18px;}
.tpad{text-align:left;padding-left:10px;}
</style>
<table width="100%" border="1" cellpadding="0" cellspacing="1" style="line-height:30px;text-align:center;" align="center">
<tr><td colspan="7" class="tdhead">突发事件明细表</td></tr>
<tr><td>导出时间：</td><td colspan="6" class="tpad">${block.current_time!''}</td></tr>
<tr><td>序号</td><td>灾害简称</td><td>所属区域</td><td>灾害类型</td><td>灾害级别</td><td>灾害发生时间</td><td>灾害描述</td></tr>
[#assign index=1]
 [#list block.resultList as result]
 	[#assign xzqh="${result.disaster_region!''}"]
	    [#if EnumService.getEnum('xzqh')?exists]
	    [#list EnumService.getEnum('xzqh') as enum]
			[#if "${result.disaster_region!''}"=="${enum.enum_value!''}"]
				[#assign xzqh="${enum.enum_name!''}"]
			[/#if]
		[/#list]
	    [/#if]
	    [#assign disaster_type="${result.disaster_type!''}"]
	    [#if EnumService.getEnum('disaster_type')?exists]
	    [#list EnumService.getEnum('disaster_type') as enum]
			[#if "${result.disaster_type!''}"=="${enum.enum_value!''}"]
				[#assign disaster_type="${enum.enum_name!''}"]
			[/#if]
		[/#list]
	    [/#if]
	    [#assign disaster_grade=""]
		[#if "${result.disaster_grade!''}"=="1"][#assign disaster_grade="<div style='heigth:20px;width:70px;background-color:yellow;float:right;'> </div>一般"][/#if]
	    [#if "${result.disaster_grade!''}"=="2"][#assign disaster_grade="<div style='heigth:20px;width:70px;background-color:orange;float:right;'> </div>较大"][/#if]
	    [#if "${result.disaster_grade!''}"=="3"][#assign disaster_grade="<div style='heigth:20px;width:70px;background-color:#CC6600;float:right;'> </div>重大"][/#if]
	    [#if "${result.disaster_grade!''}"=="4"][#assign disaster_grade="<div style='heigth:20px;width:70px;background-color:red;float:right;'> </div>特别重大"][/#if]
	<tr><td>${index}[#assign index=index+1]</td>
	<td>${result.disaster_name!''}</td>
	<td>${xzqh!''}</td>
	<td>${disaster_type!''}</td>
	<td>${disaster_grade!''}</td>
	<td>[#if result.disaster_date?exists]${result.disaster_date?date}[#else] [/#if]</td>
	<td>${result.disaster_discription!''}</td></tr>
[/#list]
</table>