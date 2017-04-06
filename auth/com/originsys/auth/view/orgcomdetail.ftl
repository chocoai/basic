<style>
.rightpad{text-align:right;padding-right:7px;background-color:#F2F9FF;}
.leftpad{padding-left:2px;background-color:#FFFFFF;}
</style>
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;单位详细信息
	</div>
<table width="100%" border="0" cellpadding="0" cellspacing="1" style="table-layout:fixed;line-height:30px;">
	<col width="200px"/></col />
	<tr>
		<td class="rightpad">组织id</td>
		<td class="leftpad">${resultMap.result.organ_id!''}</td>
	</tr>
	<tr>
		<td class="rightpad">名称</td>
		<td class="leftpad">${resultMap.result.organ_name!''}</td>
	</tr>
	<tr>
		<td class="rightpad">行政区</td>
		<td class="leftpad">${resultMap.result.organ_region!''}</td>
	</tr>
	<tr>
		<td class="rightpad">地址</td>
		<td class="leftpad">${resultMap.result.organ_address!''}</td>
	</tr>
	<tr>
		<td class="rightpad">联系人</td>
		<td class="leftpad">${resultMap.result.organ_linkman!''}</td>
	</tr>
	<tr>
		<td class="rightpad">电话</td>
		<td class="leftpad">${resultMap.result.organ_phone!''}</td>
	</tr>
	<tr>
		<td class="rightpad">邮码</td>
		<td class="leftpad">${resultMap.result.organ_postcode!''}</td>
	</tr>
	<tr>
		<td class="rightpad">域名｜ip</td>
		<td class="leftpad">${resultMap.result.organ_domainname!''}</td>
	</tr>
	<tr>
		<td class="rightpad">行业</td>
		<td class="leftpad">${resultMap.result.organ_trade!''}</td>
	</tr>
	<tr>
		<td class="rightpad">企业类型</td>
		<td class="leftpad">${resultMap.result.com_type!''}</td>
	</tr>
	<tr>
		<td class="rightpad">组织简介</td>
		<td class="leftpad">${resultMap.result.organ_desc!''}</td>
	</tr>
	<tr>
		<td class="rightpad">组织类型</td>
		<td class="leftpad">${resultMap.result.organ_type!''}</td>
	</tr>
	<tr>
		<td class="rightpad">员工人数</td>
		<td class="leftpad">${resultMap.result.organ_staff_number!''}</td>
	</tr>
	<tr>
		<td class="rightpad">组织机构代码证号</td>
		<td class="leftpad">${resultMap.result.organ_code!''}</td>
	</tr>
	<tr>
		<td class="rightpad">组织证件类型</td>
		<td class="leftpad">${resultMap.result.organ_cred_type!''}</td>
	</tr>
	<tr>
		<td class="rightpad">组织证件号码</td>
		<td class="leftpad">${resultMap.result.organ_cred_code!''}</td>
	</tr>
	<tr>
		<td class="rightpad">认证状态</td>
		<td class="leftpad">[#if "1"=="${resultMap.result.authentication_state!''}"]通过[#else]未通过[/#if]</td>
	</tr>
	<tr>
		<td class="rightpad">第二域名</td>
		<td class="leftpad">${resultMap.result.organ_domainname2!''}</td>
	</tr>
		<tr>
		<td class="rightpad">企业类型</td>
		<td class="leftpad">
		[#list resultMap.typelist as orgcomtype]
		[#if resultMap.orgtype_str?contains(",${orgcomtype.organ_type_id!''} ")]${orgcomtype.organ_type_cname!''}&nbsp;&nbsp;[/#if]
		[/#list]
		</td>
	</tr>
	<tr>
		<td align="center" style="background-color:#FFFFFF;" colspan="2">
			<button type="button" onClick="window.close();">返回</button>
		</td>
	</tr>
</table>
</div>