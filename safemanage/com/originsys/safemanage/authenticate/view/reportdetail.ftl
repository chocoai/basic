[#macro reportdetail result]
<script type="text/javascript" language="javascript">
$(function(){
	$("#addForm :input").attr({disabled:"true"});
});
</script>
<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
	
	<form action="" id="addForm" method="post">
	<input type="hidden" name="jdinfo_id" value="${result.jdinfo_id!''}">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<tr>
			<td class="td12">鉴定地址：</td>
			<td class="td13" colspan="3">${result.building_address!''}</td>
			<td class="td12">所属区域：</td>
			<td class="td13">
				[#assign qh=""]
				[#list EnumService.getEnum('xzqh') as enum]
				[#if "${result.building_region!''}"=="${enum.enum_value!''}"][#assign qh="${enum.enum_name!''}"][#break][/#if]
				[/#list]
				${qh!''}
			</td>
		</tr>
		<tr>
			<td class="td12">委托人（单位）：</td>
			<td class="td13">${result.entrust_user!''}</td>
			<td class="td12">联系人：</td>
			<td class="td13">${result.linkman!''}</td>
			<td class="td12">联系电话：</td>
			<td class="td13">${result.linktel!''}</td>			
		</tr>
		<tr>
			<td class="td12">鉴定单位：</td>
			<td class="td13">${result.jd_department!''}</td>	
			<td class="td12">鉴定人：</td>
			<td class="td13">${result.jdmember!''}</td>
			<td class="td12">鉴定时间：</td>
			<td class="td13">[#if result.jd_date?exists]${result.jd_date?string('yyyy-MM-dd')}[/#if]</td>
		</tr>
		<tr>
			<td class="td12">房屋危险等级：</td>
			<td class="td13">
				<input type="radio" name="dangerous_level" value="1" [#if "${result.dangerous_level!''}"=="1"]checked[/#if]>A级
				<input type="radio" name="dangerous_level" value="2" [#if "${result.dangerous_level!''}"=="2"]checked[/#if]>B级
				<input type="radio" name="dangerous_level" value="3" [#if "${result.dangerous_level!''}"=="3"]checked[/#if]>C级
				<input type="radio" name="dangerous_level" value="4" [#if "${result.dangerous_level!''}"=="4"]checked[/#if]>D级
			</td>
			<td class="td12">房屋结构老化程度：</td>
			<td class="td13">
				<input type="radio" name="struct_aging" value="1" [#if "${result.struct_aging!''}"=="1"]checked[/#if]>强
				<input type="radio" name="struct_aging" value="2" [#if "${result.struct_aging!''}"=="2"]checked[/#if]>弱
				<input type="radio" name="struct_aging" value="3" [#if "${result.struct_aging!''}"=="3"]checked[/#if]>差
			</td>
			<td class="td12">是否有改造：</td>
			<td class="td13">
				<input type="radio" name="is_transform" value="1" [#if "${result.is_transform!''}"=="1"]checked[/#if]>是
				<input type="radio" name="is_transform" value="2" [#if "${result.is_transform!''}"=="2"]checked[/#if]>否
			</td>			
		</tr>
		<tr>
			<td class="td12">设施老化程度：</td>
			<td class="td13">
				<input type="radio" name="facility_aging" value="1" [#if "${result.facility_aging!''}"=="1"]checked[/#if]>强
				<input type="radio" name="facility_aging" value="2" [#if "${result.facility_aging!''}"=="2"]checked[/#if]>弱
				<input type="radio" name="facility_aging" value="3" [#if "${result.facility_aging!''}"=="3"]checked[/#if]>差
			</td>
			<td class="td12">抗震结构是否完善：</td>
			<td class="td13">
				<input type="radio" name="is_kzperfect" value="1" [#if "${result.is_kzperfect!''}"=="1"]checked[/#if]>强
				<input type="radio" name="is_kzperfect" value="2" [#if "${result.is_kzperfect!''}"=="2"]checked[/#if]>弱
				<input type="radio" name="is_kzperfect" value="3" [#if "${result.is_kzperfect!''}"=="3"]checked[/#if]>差
			</td>
			<td class="td12">拆改结构是否严重：</td>
			<td class="td13">
				<input type="radio" name="is_transform_seriousness" value="1" [#if "${result.is_transform_seriousness!''}"=="1"]checked[/#if]>强
				<input type="radio" name="is_transform_seriousness" value="2" [#if "${result.is_transform_seriousness!''}"=="2"]checked[/#if]>弱
				<input type="radio" name="is_transform_seriousness" value="3" [#if "${result.is_transform_seriousness!''}"=="3"]checked[/#if]>差
			</td>			
		</tr>
		<tr>
			<td class="td12">鉴定报告附件：</td>
			<td class="td13">
			[#if "${result.jd_report!''}"!=""]<a href="${result.jd_report!''}" target="download">报告下载</a>[/#if]
			</td>
			<td class="td12">鉴定相关图片：</td>
			<td class="td13" colspan="3">
			[#if "${result.jd_image!''}"!=""]<a href="${result.jd_image!''}" target="_blank">查看图片</a>[/#if]
			</td>
		</tr>
		<tr>
			<td class="td12">房屋概况：</td>
			<td class="td13" colspan="5">
			${result.jz_overview!''}
			</td>
		</tr>
		<tr>
			<td class="td12">鉴定结论：</td>
			<td class="td13" colspan="5">
			${result.identify_conclusion!''}
			</td>
		</tr>
		<!-- tr>
			<td class="td12">鉴定内容：</td>
			<td class="td13" colspan="5">
			<textarea cols="100" rows="5" name="identify_content"></textarea>
			</td>
		</tr-->		
	</table>
</form>
<iframe id="download" name="download" height="0px" width="0px"></iframe>
[/#macro]
