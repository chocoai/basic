<style>
.tdhead {text-align:center;font-size:18px;}
.tpad{text-align:left;padding-left:10px;}
</style>
<table width="100%" border="1" cellpadding="0" cellspacing="1" style="line-height:30px;text-align:center;" align="center">
<tr><td colspan="12" class="tdhead">2014年济南市老楼危楼安全排查明细表</td></tr>
<tr><td>报表单位：</td><td colspan="11" class="tpad">济南市房产测绘</td></tr>
<tr><td>项目名称：</td><td colspan="10" class="tpad">2014年济南市老楼危楼安全排查</td><td>${block.current_time!''}</td></tr>
<tr><td>序号</td><td>普查新坐落</td><td>建筑面积</td><td>建设年份</td><td>房屋所有人</td><td>建设单位</td>
<td>设计单位</td><td>施工单位</td><td>结构类型</td><td>房屋性质</td><td>有无问题</td><td>备注</td></tr>
[#assign index=1]
[#list block.resultList as survey]
	<tr><td>${index}[#assign index=index+1]</td>
	<td>${survey.building_newaddress!''}</td><td>${survey.build_area!''}</td><td>${survey.building_date!''}</td>
	<td>${survey.building_holder!''}</td><td>${survey.build_dept!''}</td><td>${survey.design_dept!''}</td>
	<td>${survey.construct_dept!''}</td>
	[#assign jg="${survey.build_struct!''}"]
	    [#if EnumService.getEnum('fwjg')?exists]
	    [#list EnumService.getEnum('fwjg') as enum]
			[#if "${survey.build_struct!''}"=="${enum.enum_value!''}"]
				[#assign jg="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
	<td>${jg!''}</td>
	[#assign building_properties=""]
    [#if "${survey.building_properties!''}"=="1"][#assign building_properties="单位自管房"][/#if]
    [#if "${survey.building_properties!''}"=="2"][#assign building_properties="直管公房"][/#if]
    [#if "${survey.building_properties!''}"=="3"][#assign building_properties="房改住房"][/#if]
    [#if "${survey.building_properties!''}"=="4"][#assign building_properties="私房"][/#if]
    [#if "${survey.building_properties!''}"=="5"][#assign building_properties="其他"][/#if]
	<td>${building_properties!''}</td>
	[#assign building_safecondition=""]
    [#if "${survey.building_safecondition!''}"=="1"][#assign building_safecondition="无"][/#if]
    [#if "${survey.building_safecondition!''}"=="4"][#assign building_safecondition="有"][/#if]
	<td>${building_safecondition!''}</td><td></td></tr>
[/#list]
</table>