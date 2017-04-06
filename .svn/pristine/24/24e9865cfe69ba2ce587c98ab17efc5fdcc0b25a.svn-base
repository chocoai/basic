<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	$("#detailForm :input").attr({disabled:"true"});
	$("#returnval").removeAttr("disabled");
	$("#returnval1").removeAttr("disabled");
});
function dosave(){	
	var flag=window.confirm("审核通过的信息不能再做任何操作，确认提交吗？");
	if(flag){
			var queryString=$("#news_check_form").formSerialize();
				$.post($("#news_check_form").attr("action"),queryString,function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="1"){
						alert("审核完毕!");
						window.close();
					}else{
						alert("出现错误,审核失败!");
						window.close();
					}
				});
	}
}
</script>
<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
<div class="widget-title-normal">
	<div class="child">
		<span class="widget-title-text">
			楼幢普查审核
		</span>
	</div>
</div>
	<!--div  id="buttons" style="text-align:right">
		[#if access.canDo(user,'safecheck.survey.check')]
			[#if "${block.buildingsurvey.info_state!''}"=="1"]
			<button type="button" id="checkInfo" align="right">审核</button>
			[/#if]
		[/#if]
		<button type="button" onclick="javascript:window.history.go(-1);" >返回</button>
	</div-->

<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .1em;">
	<div class="ui-widget" id="tabs">
			<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
				<tbody id="detailForm" method="post">
				<tr>
					<td class="td12">坐落地址：</td>
					<td class="td13" colspan="3"><input type="text" id="building_address" name="building_address" size="80" value="${block.buildingsurvey.building_address!''}"></td>
					<td class="td12"><font color="red">*&nbsp;</font>楼幢编号：</td>
					<td class="td13"><input type="text" name="building_id" value="${block.buildingsurvey.building_id!''}"></td>
				</tr>
				<tr>
					<td class="td12"><font color="red">*&nbsp;</font>普查新坐落：</td>
					<td class="td13" colspan="3"><input type="text" id="building_newaddress" name="building_newaddress" size="80" value="${block.buildingsurvey.building_newaddress!''}"></td>
					<td class="td12"><font color="red">*&nbsp;</font>坐落是否一致：</td>
					<td class="td13">
						<input type="radio" name="issame" id="issame1" value="1" [#if "${block.buildingsurvey.issame!''}"=="1"]checked[/#if] >&nbsp;是
						<input type="radio" name="issame" id="issame2" value="0" [#if "${block.buildingsurvey.issame!''}"=="0"]checked[/#if] >&nbsp;否
					</td>
				</tr>
				<tr>
					<td class="td12">所属区域：</td>
					<td class="td13">
					<select id="building_region" name="building_region">
						<option value="">------请选择------</option>
						[#list EnumService.getEnum('xzqh') as enum]
						<option value="${enum.enum_value!''}" [#if "${block.buildingsurvey.building_region!''}"=="${enum.enum_value!''}"]selected[/#if]>${enum.enum_name!''}</option>
						[/#list]
						</select>
					</td>
					<td class="td12">用途：</td>
					<td class="td13">
						<select id="use_desgin" name="use_desgin">
						<option value="">------请选择------</option>
						[#list EnumService.getEnum('sjyt') as enum]
						<option value="${enum.enum_value!''}" [#if "${block.buildingsurvey.use_desgin!''}"=="${enum.enum_value!''}"]selected[/#if]>${enum.enum_name!''}</option>
						[/#list]
						</select>
					</td>
					<td class="td12">建筑面积：</td>
					<td class="td13"><input type="text" name="build_area" [#if "${block.buildingsurvey.build_area!''}"!=""]value="#{block.buildingsurvey.build_area!'';m0M2}"[/#if] size="18"></td>
				</tr>
				<tr>
					<td class="td12">地上层数：</td>
					<td class="td13"><input type="text" id="floorup_count" name="floorup_count" value="${block.buildingsurvey.floorup_count!''}" size="18"></td>
					<td class="td12">地下层数：</td>
					<td class="td13"><input type="text" id="floordown_count" name="floordown_count" value="${block.buildingsurvey.floordown_count!''}" size="18"></td>
					<td class="td12">套数：</td>
					<td class="td13"><input type="text" id="house_count" name="house_count" value="${block.buildingsurvey.house_count!''}" size="18"></td>
				</tr>
				<tr>
					<td class="td12">建成年份：</td>
					<td class="td13"><input type="text" id="building_date" name="building_date" value="${block.buildingsurvey.building_date!''}" size="18" onClick="WdatePicker({dateFmt:'yyyy'})"></td>
					<td class="td12">房屋所有人（管理单位）：</td>
					<td class="td13"><input type="text" name="building_holder" size="18" value="${block.buildingsurvey.building_holder!''}"></td>
					<td class="td12">房屋管理人姓名：</td>
					<td class="td13"><input type="text" name="building_manager_name" size="18" value="${block.buildingsurvey.building_manager_name!''}"></td>
				</tr>
				<tr>
					<td class="td12">房屋管理人办公电话、手机：</td>
					<td class="td13"><input type="text" id="building_manager_phone" name="building_manager_phone" size="18"  value="${block.buildingsurvey.building_manager_phone!''}"></td>
					<td class="td12">设计和施工材料：</td>
					<td class="td13">
						<select name="building_material" >
							<option value="">------请选择------</option>
							<option value="1" [#if "${block.buildingsurvey.building_material!''}"=="1" ]selected[/#if]>齐全</option>
							<option value="2" [#if "${block.buildingsurvey.building_material!''}"=="2" ]selected[/#if]>基本齐全</option>
							<option value="3" [#if "${block.buildingsurvey.building_material!''}"=="3" ]selected[/#if]>无</option>
						</select>
					</td>
					<td class="td12">管理模式：</td>
					<td class="td13">
						<select name="manage_type">
							<option value="">------请选择------</option>
							<option value="1" [#if "${block.buildingsurvey.manage_type!''}"=="1" ]selected[/#if]>物业管理</option>
							<option value="2" [#if "${block.buildingsurvey.manage_type!''}"=="2" ]selected[/#if]>单位自管</option>
							<option value="3" [#if "${block.buildingsurvey.manage_type!''}"=="3" ]selected[/#if]>无明确管理单位</option>
							<option value="4" [#if "${block.buildingsurvey.manage_type!''}"=="4" ]selected[/#if]>其他</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td12">建设单位：</td>
					<td class="td13">
						<input type="text" id="build_dept" name="build_dept" size="18" value="${block.buildingsurvey.build_dept!''}">
					</td>
					<td class="td12">设计单位：</td>
					<td class="td13">
						<input type="text" id="design_dept" name="design_dept" size="18" value="${block.buildingsurvey.design_dept!''}">
					</td>
					<td class="td12">施工单位：</td>
					<td class="td13">
						<input type="text" id="construct_dept" name="construct_dept" size="18" value="${block.buildingsurvey.construct_dept!''}">
					</td>
				</tr>
				<tr>
					<td class="td12">结构类型：</td>
					<td class="td13">
						<select name="build_struct">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('fwjg') as enum]
							<option value="${enum.enum_value!''}" [#if "${block.buildingsurvey.build_struct!''}"=="${enum.enum_value!''}" ]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
					<td class="td12">楼盖类型：</td>
					<td class="td13">
						<select name="upon_type">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('upon_type') as enum]
							<option value="${enum.enum_value!''}" [#if "${block.buildingsurvey.upon_type!''}"=="${enum.enum_value!''}" ]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
					<td class="td12">屋面类型：</td>
					<td class="td13">
						<select name="wm_type">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('wm_type') as enum]
							<option value="${enum.enum_value!''}" [#if "${block.buildingsurvey.wm_type!''}"=="${enum.enum_value!''}" ]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
				</tr>
				<tr>
					<td class="td12">房屋性质：</td>
					<td class="td13">
						<select name="building_properties">
							<option value="">------请选择------</option>
							<option value="1" [#if "${block.buildingsurvey.building_properties!''}"=="1" ]selected[/#if]>单位自管房</option>
							<option value="2" [#if "${block.buildingsurvey.building_properties!''}"=="2" ]selected[/#if]>直管公房</option>
							<option value="3" [#if "${block.buildingsurvey.building_properties!''}"=="3" ]selected[/#if]>房改住房</option>
							<option value="4" [#if "${block.buildingsurvey.building_properties!''}"=="4" ]selected[/#if]>私房</option>
							<option value="5" [#if "${block.buildingsurvey.building_properties!''}"=="5" ]selected[/#if]>其他</option>
						</select>
					</td>
					<td class="td12"><font color="red">*&nbsp;</font>房屋安全情况：</td>
					<td class="td13" colspan="3">
						<select name="building_safecondition" id="building_safecondition">
							<option value="">------请选择------</option>
							<option value="1" [#if "${block.buildingsurvey.building_safecondition!''}"=="1"]selected[/#if]>无问题房屋</option>
							<!--<option value="2" [#if "${block.buildingsurvey.building_safecondition!''}"=="2"]selected[/#if]>存在危险点房屋</option>
							<option value="3" [#if "${block.buildingsurvey.building_safecondition!''}"=="3"]selected[/#if]>局部危险房屋</option>-->
							<option value="4" [#if "${block.buildingsurvey.building_safecondition!''}"=="4"]selected[/#if]>有问题房屋</option>
						</select>
					</td>
					</tr>
				<tr>
					<td class="td12">负责人：</td>
					<td class="td13"><input type="text" id="manager_name" name="manager_name" size="18"  value="${block.buildingsurvey.manager_name!''}"></td>
					<td class="td12">排查人：</td>
					<td class="td13"><input type="text" id="survey_name" name="survey_name" size="18" value="${block.buildingsurvey.survey_name!''}"></td>
					<td class="td12">排查日期：</td>
					<td class="td13"><input type="text" id="survey_date" name="survey_date" size="18" [#if block.buildingsurvey.survey_date?exists]value="${block.buildingsurvey.survey_date?date}"[/#if]  onClick="WdatePicker()"></td>
				</tr>
				<tr>
					<td class="td12">上传附件：</td>
					<td class="td13">[#if "${block.buildingsurvey.annex!''}"!='']<button onclick="window.location.href='${block.buildingsurvey.annex!''}'" id="returnval1" name="returnval1" style="margin-left:5px;display:inline-block;">
						下载附件</button>[/#if]</td>
					<td class="td12">上传图片：</td>
					<td class="td13" colspan="3">[#if "${block.buildingsurvey.annex_pic!''}"!='']<button onclick="window.open('${block.buildingsurvey.annex_pic!''}','_blank','depended=yes,top='+(window.screen.height-30-500)/2+',left='+(window.screen.width-10-800)/2+',width=800,height=500,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes');" id="returnval" name="returnval" style="margin-left:5px;display:inline-block;">
						查看图片</button>[/#if]</td>
				</tr>
				<tr>
					<td class="td12">现场调查</td>
					<td class="td13" colspan="5">
						主要危险情况（包括地基基础、上部承重结构及使用历史情况）<br/>
						<textarea cols="80" rows="5" name="local_survey">${block.buildingsurvey.local_survey!''}</textarea>
					</td>
				</tr>
				</tbody>
				<form name="building_check_form" id="news_check_form" action="${_servlet_url!''}/safecheck.survey.check" method="post">
					<input type="hidden" name="safelevel" value="${block.buildingsurvey.building_safecondition!''}">
					<input type="hidden" id="building_id" name="building_id" value="${block.buildingsurvey.building_id!''}">
					<input type="hidden" id="survey_date" name="survey_date" [#if block.buildingsurvey.survey_date?exists]value="${block.buildingsurvey.survey_date?string('yyyy-MM-dd')}"[/#if]>		
					<input type="hidden" id="building_address" name="building_address" value="${block.buildingsurvey.building_address!''}">
					<input type="hidden" id="builiding_region" name="builiding_region" value="${block.buildingsurvey.building_region!''}">
					<input type="hidden" name="annex_image" value="${block.buildingsurvey.annex_pic!''}">
					<input type="hidden" name="annex_file" value="${block.buildingsurvey.annex!''}">
					<tr>
						<td class="td12">审核状态：</td>
						<td class="td13">
							<input type="radio" name="building_isOpen" value="8" checked> 审核通过 &nbsp;
							<input type="radio" name="building_isOpen" value="2"> 审核驳回
						</td>
						<td class="td12">审核意见：</td>
						<td class="td13" colspan="3">
							<textarea name="building_check_log" id="building_check_log" cols="50" rows="5">${block.buildingsurvey.check_message!''}</textarea>
						</td>
					</tr>
					<tr>
					<td class="td13" colspan="6" align="center">
						<button type="button" onclick="dosave();">提交</button>
					</td>
					</tr>
				</form> 
		</table>				
	</div>
</div>	