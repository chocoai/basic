<style>
.tdhead {text-align:center;font-size:18px;}
.tpad{text-align:left;padding-left:10px;}
</style>
<table width="100%" border="1" cellpadding="0" cellspacing="1" style="line-height:30px;text-align:center;" align="center">
<tr><td colspan="12" class="tdhead">济南市安全鉴定明细表</td></tr>
<tr><td>报表单位：</td><td colspan="8" class="tpad">济南市房产测绘</td></tr>
<tr><td>项目名称：</td><td colspan="7" class="tpad">济南市安全鉴定</td><td>${block.current_time!''}</td></tr>
<tr><td>序号</td><td>房屋坐落</td><td>所属区域</td><td>房屋产别</td><td>设计用途</td><td>建成时间</td>
<td>房屋结构</td><td>安全等级</td><td>备注</td></tr>
[#assign index=1]
[#list block.resultList as result]
	[#assign yt="${result.use_desgin!''}"]
	    [#if EnumService.getEnum('sjyt')?exists]
	    [#list EnumService.getEnum('sjyt') as enum]
			[#if "${result.use_desgin!''}"=="${enum.enum_value!''}"]
				[#assign yt="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
		[#assign jg="${result.build_struct!''}"]
	    [#if EnumService.getEnum('fwjg')?exists]
	    [#list EnumService.getEnum('fwjg') as enum]
			[#if "${result.build_struct!''}"=="${enum.enum_value!''}"]
				[#assign jg="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
		[#assign fwcb="${result.real_type!''}"]
	    [#if EnumService.getEnum('fwcb')?exists]
	    [#list EnumService.getEnum('fwcb') as enum]
			[#if "${result.real_type!''}"=="${enum.enum_value!''}"]
				[#assign fwcb="${enum.enum_name!''}"]
			[/#if]
		[/#list]
	    [/#if]
	    [#assign xzqh="${result.builiding_region!''}"]
	    [#if EnumService.getEnum('xzqh')?exists]
	    [#list EnumService.getEnum('xzqh') as enum]
			[#if "${result.builiding_region!''}"=="${enum.enum_value!''}"]
				[#assign xzqh="${enum.enum_name!''}"]
			[/#if]
		[/#list]
	    [/#if]
	    [#assign health_grade_jd=""]
	    [#if "${result.health_grade_jd!''}"=="1"][#assign health_grade_jd="A级"][/#if]
	    [#if "${result.health_grade_jd!''}"=="2"][#assign health_grade_jd="B级"][/#if]
	    [#if "${result.health_grade_jd!''}"=="3"][#assign health_grade_jd="C级"][/#if]
	    [#if "${result.health_grade_jd!''}"=="4"][#assign health_grade_jd="D级"][/#if]
	    
	<tr><td>${index}[#assign index=index+1]</td>
	<td>${result.building_address!''}</td><td>${xzqh!''}</td><td>${fwcb!''}</td>
	<td>${yt!''}</td><td>${result.building_date!''}</td><td>${jg!''}</td>
	<td>${health_grade_jd!''}</td>
	<td></td></tr>
[/#list]
</table>