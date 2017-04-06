<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	$("#detailForm :input").attr({disabled:"true"});
	$("#returnval").removeAttr("disabled");
	$("#returnval1").removeAttr("disabled");
	$("#outdiv").css("display","block");
	$("#tabs").tabs({cache:false});	
	//审核按钮
	$("#checkInfo").click(function(){
		var id = $("#building_id").val();
		var info_state=$("#info_state").val();
		if("${block.buildingsafe.info_state!''}"=="1"){
			$("#building_check").dialog( "open" );
		}else{
			alert("只能审核状态为未审核的！");
		}
	});	
	
	//审核
	$('#building_check').dialog({
		bgiframe: true,
		autoOpen: false,
		width: 400,
		height:300,
		buttons: {
        	'确定': function() {
        		var flag=window.confirm("审核通过的信息不能再做任何操作，确认提交吗？");
				if(flag){
				var queryString=$("#news_check_form").formSerialize();
				$.post($("#news_check_form").attr("action"),queryString,function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="1"){
						$("#building_check").dialog("close");
						alert("审核完毕!");
						window.close();
					}else{
						$("#building_check").dialog("close");
						alert("出现错误,审核失败!");
					}
				});
				}
			},
			'取消': function() {
				$(this).dialog("close");
			}
		}
	});
});
</script>
<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
.tdpad {padding-left:4px; background-color:#ffffff}
.td_title {text-align:right;padding-right:4px; background-color:#ffffff}
</style>
	<div class="widget-title-normal">
		<div class="child">
			<span class="widget-title-text">
				楼幢安全检查详细
			</span>
		</div>
	</div>
<div id="outdiv" style="display:none">
	<div  id="buttons" style="text-align:right">
		[#if access.canDo(user,'safecheck.building.check')]
			[#if "${block.op!''}"=="check"]
			[#if "${block.buildingsafe.info_state!''}"=="1"]
				<button type="button" id="checkInfo" align="right">审核</button>
			[/#if]
			[/#if]
		[/#if]
		<!--button type="button" onclick="javascript:window.history.go(-1);" >返回</button-->
	</div>
<form action="" id="detailForm" method="post">
<input type="hidden" name="floor_count" value="${block.building.floor_count!''}">
<input type="hidden" name="build_area" value="${block.building.build_area!''}">
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .1em;">
	<div class="ui-widget" id="tabs">
		<ul>
			<li><a href="#tabs-1">基本信息</a></li>
			<li><a href="#tabs-2">地基基础</a></li>
			<li><a href="#tabs-3">场地环境</a></li>
			<li><a href="#tabs-4">健康等级</a></li>
		</ul>				
		<div id="tabs-1">
			<!--基本信息-->
			<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
				<tr>
					<td class="td12">坐落地址：</td>
					<td class="td13" colspan="3"><input type="text" id="building_address" name="building_address" size="80" value="${block.building.building_address!''}"></td>
					<td class="td12">楼幢号：</td>
					<td class="td13"><input type="text" name="building_number" value="${block.building.building_number!''}" size="18"></td>
				</tr>
				<tr>
					<td class="td12"><font color="red">*&nbsp;</font>检查新坐落：</td>
					<td class="td13" colspan="3"><input type="text" id="check_address" name="check_address" size="80" value="${block.building.check_address!''}"></td>
					<td class="td12"><font color="red">*&nbsp;</font>坐落是否一致：</td>
					<td class="td13">
						<input type="radio" name="issame" id="issame1" value="1" [#if "${block.building.is_same!''}"=="1"]checked[/#if] onclick="changeAddress(1)">&nbsp;是
						<input type="radio" name="issame" id="issame2" value="0" [#if "${block.building.is_same!''}"=="0"]checked[/#if] onclick="changeAddress(0)">&nbsp;否
					</td>
				</tr>
				<tr>
					<td class="td12"><font color="red">*&nbsp;</font>所属区域：</td>
					<td class="td13">
					<select id="builiding_region" name="builiding_region">
						<option value="">------请选择------</option>
						[#list EnumService.getEnum('xzqh') as enum]
						<option value="${enum.enum_value!''}" [#if "${block.building.builiding_region!''}"=="${enum.enum_value!''}"]selected[/#if]>${enum.enum_name!''}</option>
						[/#list]
						</select>
					</td>
					<td class="td12">所属街道：</td>
					<td class="td13"><input type="text" id="belong_street" name="belong_street" value="${block.building.belong_street!''}" size="18"></td>
					<td class="td12">所属小区：</td>
					<td class="td13"><input type="text" id="belong_community" name="belong_community" value="${block.building.belong_community!''}" size="18"></td>
				</tr>
				<tr>
					<td class="td12">经营管理单位：</td>
					<td class="td13"><input type="text" id="management_unit" name="management_unit" value="${block.building.management_unit!''}" size="18"></td>
					<td class="td12">建筑面积：</td>
					<td class="td13"><input type="text" id="build_area" name="build_area"  [#if "${block.buildingsafe.build_area!''}"!=""]value="#{block.buildingsafe.build_area!'';m0M2}"[/#if] size="18"></td>
					<td class="td12">建成时间：</td>
					<td class="td13"><input type="text" id="building_date" name="building_date" value="${block.building.building_date!''}" size="18" onClick="WdatePicker({dateFmt:'yyyy'})"></td>
				</tr>
				<tr>
					<td class="td12">户数：</td>
					<td class="td13"><input type="text" id="house_count" name="house_count" value="${block.building.house_count!''}" size="18"></td>
					<td class="td12">地上层数：</td>
					<td class="td13"><input type="text" id="floorup_count" name="floorup_count" value="${block.building.floorup_count!''}" size="18"></td>
					<td class="td12">地下层数：</td>
					<td class="td13"><input type="text" id="floordown_count" name="floordown_count" value="${block.building.floordown_count!''}" size="18"></td>
				</tr>
				<tr>
					<td class="td12">产权年限：</td>
					<td class="td13">
						<select name="build_right">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('build_right') as enum]
							<option value="${enum.enum_value!''}" [#if "${block.building.build_right!''}"=="${enum.enum_value!''}"]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
					<td class="td12">产权性质：</td>
					<td class="td13">
						<select name="right_type">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('right_type') as enum]
							<option value="${enum.enum_value!''}" [#if "${block.building.right_type!''}"=="${enum.enum_value!''}"]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
					<td class="td12">产权单位：</td>
					<td class="td13"><input type="text" id="owner" name="owner" value="${block.building.owner!''}" size="18"></td>
				</tr>
				<tr>
					<td class="td12">高度：</td>
					<td class="td13"><input type="text" id="heigth" name="heigth" value="${block.building.heigth!''}" size="18"></td>
					<td class="td12">檐高：</td>
					<td class="td13"><input type="text" id="depth" name="depth" value="${block.building.depth!''}" size="18"></td>
					<td class="td12">层高：</td>
					<td class="td13"><input type="text" id="floor_height" name="floor_height" value="${block.building.floor_height!''}" size="18"></td>
				</tr>
				<tr>
					<td class="td12">平面：</td>
					<td class="td13">
						<select name="plane_shape">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('plane_shape') as enum]
							<option value="${enum.enum_value!''}" [#if "${block.building.plane_shape!''}"=="${enum.enum_value!''}"]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
					<td class="td12">朝向：</td>
					<td class="td13">
						<select name="exposure">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('exposure') as enum]
							<option value="${enum.enum_value!''}" [#if "${block.building.exposure!''}"=="${enum.enum_value!''}"]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
					<td class="td12">立面：</td>
					<td class="td13">
						<select name="lm_shape">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('lm_shape') as enum]
							<option value="${enum.enum_value!''}" [#if "${block.building.lm_shape!''}"=="${enum.enum_value!''}"]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
				</tr>
				<tr>
					<td class="td12">设计用途：</td>
					<td class="td13">
						<select id="use_desgin" name="use_desgin">
						<option value="">------请选择------</option>
						[#list EnumService.getEnum('sjyt') as enum]
						<option value="${enum.enum_value!''}" [#if "${block.building.use_desgin!''}"=="${enum.enum_value!''}"]selected[/#if]>${enum.enum_name!''}</option>
						[/#list]
						</select>
					</td>
					<td class="td12">房屋产别：</td>
					<td class="td13">
						<select id="real_type" name="real_type">
						<option value="">------请选择------</option>
						[#list EnumService.getEnum('fwcb') as enum]
						<option value="${enum.enum_value!''}" [#if "${block.building.real_type!''}"=="${enum.enum_value!''}"]selected[/#if]>${enum.enum_name!''}</option>
						[/#list]
						</select>
					</td>
					<td class="td12">房屋结构：</td>
					<td class="td13">
						<select id="build_struct" name="build_struct">
							<option value="">------请选择------</option>
							[#if EnumService.getEnum('fwjg')?exists]
						    [#list EnumService.getEnum('fwjg') as enum]
						    <option value="${enum.enum_value!''}" [#if "${block.building.build_struct!''}"=="${enum.enum_value!''}" ]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
							[/#if]
						</select>
					</td>
				</tr>
				<tr>
					<td class="td12">基础类型：</td>
					<td class="td13">
						<select name="base_type">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('base_type') as enum]
							<option value="${enum.enum_value!''}" [#if "${block.building.base_type!''}"=="${enum.enum_value!''}" ]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
					<td class="td12">楼盖类型：</td>
					<td class="td13">
						<select name="upon_type">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('upon_type') as enum]
							<option value="${enum.enum_value!''}" [#if "${block.building.upon_type!''}"=="${enum.enum_value!''}" ]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
					<td class="td12">屋面类型：</td>
					<td class="td13">
						<select name="wm_type">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('wm_type') as enum]
							<option value="${enum.enum_value!''}" [#if "${block.building.wm_type!''}"=="${enum.enum_value!''}" ]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
				</tr>
				<tr>
					<td class="td12">外廊类型：</td>
					<td class="td13">
						<select name="wairang_type">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('wairang') as enum]
							<option value="${enum.enum_value!''}" [#if "${block.building.wairang_type!''}"=="${enum.enum_value!''}" ]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
					<td class="td12">使用功能：</td>
					<td class="td13">
						<select name="usefunction">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('usefunction') as enum]
							<option value="${enum.enum_value!''}" [#if "${block.building.usefunction!''}"=="${enum.enum_value!''}" ]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
					<td class="td12">楼梯数目：</td>
					<td class="td13">
						<select name="lt_number">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('lt_number') as enum]
							<option value="${enum.enum_value!''}" [#if "${block.building.lt_number!''}"=="${enum.enum_value!''}" ]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
				</tr>
				<tr>
					<td class="td12">楼梯类型：</td>
					<td class="td13">
						<select name="lt_type">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('lt_type') as enum]
							<option value="${enum.enum_value!''}" [#if "${block.building.lt_type!''}"=="${enum.enum_value!''}" ]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
					<td class="td12">电梯数目：</td>
					<td class="td13">
						<select name="dt_number">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('dt_number') as enum]
							<option value="${enum.enum_value!''}" [#if "${block.building.dt_number!''}"=="${enum.enum_value!''}" ]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
					<td class="td12">外墙饰面：</td>
					<td class="td13">
						<select name="wairang_type">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('wq_type') as enum]
							<option value="${enum.enum_value!''}" [#if "${block.building.wairang_type!''}"=="${enum.enum_value!''}" ]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
				</tr>	
				<tr>
					<td class="td12">阳台类型：</td>
					<td class="td13">
						<select name="yt_type">
							<option value="">------请选择------</option>
							[#list EnumService.getEnum('wairang') as enum]
							<option value="${enum.enum_value!''}" [#if "${block.building.yt_type!''}"=="${enum.enum_value!''}" ]selected[/#if]>${enum.enum_name!''}</option>
							[/#list]
						</select>
					</td>
					<td class="td12">房屋类别：</td>
					<td class="td13">
						<select name="fw_type">
							<option value="">------请选择------</option>
							<option value="1" [#if "${block.building.fw_type!''}"=="1"]selected="true"[/#if]>个人</option>
							<option value="2" [#if "${block.building.fw_type!''}"=="2"]selected="true"[/#if]>公共建筑</option>
							<option value="3" [#if "${block.building.fw_type!''}"=="3"]selected="true"[/#if]>保障住房</option>
						</select>
					</td>
					<td class="td12">是否冻结片区：</td>
					<td class="td13">
						<select name="frozen_area">
							<option value="">------请选择------</option>
							<option value="1" [#if "${block.building.frozen_area!''}"=="1"]selected="true"[/#if]>是</option>
							<option value="2" [#if "${block.building.frozen_area!''}"=="2"]selected="true"[/#if]>否</option>
						</select>
					</td>
				</tr>	
				<tr>
					<td class="td12">相关附件：</td>
					<td class="td13" colspan="5">
					[#if "${block.buildingsafe.annex!''}"!='']
					<a href='${block.buildingsafe.annex!''}' target="_blank">下载附件</a>[/#if]</td>
				</tr>	
				<tr>
					<td class="td12">相关图片：</td>
					<td class="td13" colspan="5">
					[#if "${block.buildingsafe.annex_pic!''}"!='']
					[#list block.imagelist as image]
					<a href="${image.image_url!''}" target="_blank"><img src="${image.simage_url!''}" style="width:100px;height:100px;border:0;"/></a>
					[/#list]
					[/#if]
					</td>
				</tr>	
				<tr>
					<td class="td13" colspan="2">
					电梯、楼梯备注：<br>
					<textarea cols="40" rows="5" name="dt_tdesc">${block.buildingsafe.dt_tdesc!''}</textarea>
					</td>
					<td class="td13" colspan="2">
					上下部结构形式备注：<br>
					<textarea cols="40" rows="5" name="dere_desc">${block.buildingsafe.dere_desc!''}</textarea>
					</td>
					<td class="td13" colspan="2">
					装饰装修备注：<br>
					<textarea cols="40" rows="5" name="struct_desc">${block.buildingsafe.struct_desc!''}</textarea>
					</td>
				</tr>		
			</table>			
		</div>
		<div id="tabs-2">
			<!--地基基础-->
			<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
				<tr>
					<td class="td12">无异常：</td>
					<td class="td13">
						<input type="radio" name="benormal" value="1" [#if "${block.invmbase.benormal!''}"=="1"]checked[/#if]>否
						<input type="radio" name="benormal" value="2" [#if "${block.invmbase.benormal!''}"=="2"]checked[/#if]>是
					</td>
					<td class="td12">沉降裂缝：</td>
					<td class="td13">
						<input type="radio" name="sedi_crack" value="1" [#if "${block.invmbase.sedi_crack!''}"=="1"]checked[/#if]>否
						<input type="radio" name="sedi_crack" value="2" [#if "${block.invmbase.sedi_crack!''}"=="2"]checked[/#if]>轻微
						<input type="radio" name="sedi_crack" value="3" [#if "${block.invmbase.sedi_crack!''}"=="3"]checked[/#if]>一般
						<input type="radio" name="sedi_crack" value="4" [#if "${block.invmbase.sedi_crack!''}"=="4"]checked[/#if]>严重
					</td>
					<td class="td12">低洼积水：</td>
					<td class="td13">
						<input type="radio" name="low_water" value="1" [#if "${block.invmbase.low_water!''}"=="1"]checked[/#if]>否
						<input type="radio" name="low_water" value="2" [#if "${block.invmbase.low_water!''}"=="2"]checked[/#if]>是
					</td>
				</tr>
				<tr>
					<td class="td12">明显倾斜：</td>
					<td class="td13">
						<input type="radio" name="obv_incline" value="1" [#if "${block.invmbase.obv_incline!''}"=="1"]checked[/#if]>否
						<input type="radio" name="obv_incline" value="2" [#if "${block.invmbase.obv_incline!''}"=="2"]checked[/#if]>是
					</td>
					<td class="td12">其他：</td>
					<td class="td13">
						<input type="radio" name="elseitem" value="1" [#if "${block.invmbase.elseitem!''}"=="1"]checked[/#if]>否
						<input type="radio" name="elseitem" value="2" [#if "${block.invmbase.elseitem!''}"=="2"]checked[/#if]>轻微
						<input type="radio" name="elseitem" value="3" [#if "${block.invmbase.elseitem!''}"=="3"]checked[/#if]>一般
						<input type="radio" name="elseitem" value="4" [#if "${block.invmbase.elseitem!''}"=="4"]checked[/#if]>严重
					</td>
					<td class="td12">&nbsp;</td>
					<td class="td13">&nbsp;</td>
				</tr>
				<tr>
					<td class="td12">子项健康评价：</td>
					<td class="td13" colspan="5">
						<input type="radio" name="b_grading" value="1" [#if "${block.invmbase.b_grading!''}"=="1"]checked[/#if]>A级
						<input type="radio" name="b_grading" value="2" [#if "${block.invmbase.b_grading!''}"=="2"]checked[/#if]>B级
						<input type="radio" name="b_grading" value="3" [#if "${block.invmbase.b_grading!''}"=="3"]checked[/#if]>C级
						<input type="radio" name="b_grading" value="4" [#if "${block.invmbase.b_grading!''}"=="4"]checked[/#if]>D级
					</td>
				</tr>
				<tr>
					<td class="td12">子项安全评价：</td>
					<td class="td13" colspan="5">
						<input type="radio" name="b_secritygrading" value="1" [#if "${block.invmbase.b_secritygrading!''}"=="1"]checked[/#if]>A级
						<input type="radio" name="b_secritygrading" value="2" [#if "${block.invmbase.b_secritygrading!''}"=="2"]checked[/#if]>B级
						<input type="radio" name="b_secritygrading" value="3" [#if "${block.invmbase.b_secritygrading!''}"=="3"]checked[/#if]>C级
						<input type="radio" name="b_secritygrading" value="4" [#if "${block.invmbase.b_secritygrading!''}"=="4"]checked[/#if]>D级
					</td>
				</tr>
				<tr>
					<td class="td12">子项完损等级评价：</td>
					<td class="td13" colspan="5">
						<input type="radio" name="b_peotected_grage" value="1" [#if "${block.invmbase.b_peotected_grage!''}"=="1"]checked[/#if]>完好
						<input type="radio" name="b_peotected_grage" value="2" [#if "${block.invmbase.b_peotected_grage!''}"=="2"]checked[/#if]>基本完好
						<input type="radio" name="b_peotected_grage" value="3" [#if "${block.invmbase.b_peotected_grage!''}"=="3"]checked[/#if]>一般损坏
						<input type="radio" name="b_peotected_grage" value="4" [#if "${block.invmbase.b_peotected_grage!''}"=="4"]checked[/#if]>严重破损
					</td>
				</tr>
				<tr>
					<td class="td13" colspan="6">
					备注：<br>
					<textarea cols="120" rows="5" name="b_tdesc">${block.invmbase.b_tdesc!''}</textarea>
					</td>
				</tr>
			</table>
		</div>
		<div id="tabs-3">
			<!--场地环境-->
			<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
				<tr>
					<td rowspan="2" vertical-align="middle" align="center" class="tdpad">房屋场地</td>
					<td class="td12">平地：</td>
					<td class="td13">
						<input type="radio" name="field_flat" value="1" [#if "${block.invmfield.field_flat!''}"=="1"]checked[/#if]>否
						<input type="radio" name="field_flat" value="2" [#if "${block.invmfield.field_flat!''}"=="2"]checked[/#if]>是
					</td>
					<td class="td12">山地：</td>
					<td class="td13">
						<input type="radio" name="field_hillfoot" value="1" [#if "${block.invmfield.field_hillfoot!''}"=="1"]checked[/#if]>否
						<input type="radio" name="field_hillfoot" value="2" [#if "${block.invmfield.field_hillfoot!''}"=="2"]checked[/#if]>是
					</td>
					<td class="td12">悬崖：</td>
					<td class="td13">
						<input type="radio" name="field_cliff" value="1" [#if "${block.invmfield.field_cliff!''}"=="1"]checked[/#if]>否
						<input type="radio" name="field_cliff" value="2" [#if "${block.invmfield.field_cliff!''}"=="2"]checked[/#if]>是
					</td>
				</tr>
				<tr>
					<td class="td12">水库边：</td>
					<td class="td13">
						<input type="radio" name="field_margin" value="1" [#if "${block.invmfield.field_margin!''}"=="1"]checked[/#if]>否
						<input type="radio" name="field_margin" value="2" [#if "${block.invmfield.field_margin!''}"=="2"]checked[/#if]>是
					</td>
					<td class="td12">低洼地带：</td>
					<td class="td13">
						<input type="radio" name="field_low" value="1" [#if "${block.invmfield.field_low!''}"=="1"]checked[/#if]>否
						<input type="radio" name="field_low" value="2" [#if "${block.invmfield.field_low!''}"=="2"]checked[/#if]>是
					</td>
					<td class="td12">塌陷区：</td>
					<td class="td13">
						<input type="radio" name="field_sink" value="1" [#if "${block.invmfield.field_sink!''}"=="1"]checked[/#if]>否
						<input type="radio" name="field_sink" value="2" [#if "${block.invmfield.field_sink!''}"=="2"]checked[/#if]>是
					</td>
				</tr>
				<tr>
					<td vertical-align="middle" align="center" class="tdpad">堆&nbsp;填&nbsp;区</td>
					<td class="td12">场地土地类型：</td>
					<td class="td13" colspan="5">
						<input type="radio" name="field_earthtype" value="1" [#if "${block.invmfield.field_earthtype!''}"=="1"]checked[/#if]>硬土
						<input type="radio" name="field_earthtype" value="2" [#if "${block.invmfield.field_earthtype!''}"=="2"]checked[/#if]>一般
						<input type="radio" name="field_earthtype" value="3" [#if "${block.invmfield.field_earthtype!''}"=="3"]checked[/#if]>软土
					</td>
				</tr>
				<tr>
					<td rowspan="2" vertical-align="middle" align="center" class="tdpad">相邻施工</td>
					<td class="td12">无异常：</td>
					<td class="td13">
						<input type="radio" name="neighbor_normal" value="1" [#if "${block.invmfield.neighbor_normal!''}"=="1"]checked[/#if]>否
						<input type="radio" name="neighbor_normal" value="2" [#if "${block.invmfield.neighbor_normal!''}"=="2"]checked[/#if]>是
					</td>
					<td class="td12">振动：</td>
					<td class="td13">
						<input type="radio" name="neighbor_shook" value="1" [#if "${block.invmfield.neighbor_shook!''}"=="1"]checked[/#if]>否
						<input type="radio" name="neighbor_shook" value="2" [#if "${block.invmfield.neighbor_shook!''}"=="2"]checked[/#if]>是
					</td>
					<td class="td12">降水：</td>
					<td class="td13">
						<input type="radio" name="neighbor_rain" value="1" [#if "${block.invmfield.neighbor_rain!''}"=="1"]checked[/#if]>否
						<input type="radio" name="neighbor_rain" value="2" [#if "${block.invmfield.neighbor_rain!''}"=="2"]checked[/#if]>是
					</td>
				</tr>
				<tr>
					<td class="td12">土体扰动：</td>
					<td class="td13">
						<input type="radio" name="neighbor_interfere" value="1" [#if "${block.invmfield.neighbor_interfere!''}"=="1"]checked[/#if]>否
						<input type="radio" name="neighbor_interfere" value="2" [#if "${block.invmfield.neighbor_interfere!''}"=="2"]checked[/#if]>是
					</td>
					<td class="td12">&nbsp;</td>
					<td class="td13">&nbsp;</td>
					<td class="td12">&nbsp;</td>
					<td class="td13">&nbsp;</td>
				</tr>
				<tr>
					<td rowspan="2" vertical-align="middle" align="center" class="tdpad">化学侵蚀</td>
					<td class="td12">无异常：</td>
					<td class="td13">
						<input type="radio" name="chemic_normal" value="1" [#if "${block.invmfield.chemic_normal!''}"=="1"]checked[/#if]>否
						<input type="radio" name="chemic_normal" value="2" [#if "${block.invmfield.chemic_normal!''}"=="2"]checked[/#if]>是
					</td>
					<td class="td12">盐酸：</td>
					<td class="td13">
						<input type="radio" name="chemic_hcl" value="1" [#if "${block.invmfield.chemic_hcl!''}"=="1"]checked[/#if]>否
						<input type="radio" name="chemic_hcl" value="2" [#if "${block.invmfield.chemic_hcl!''}"=="2"]checked[/#if]>是
					</td>
					<td class="td12">硫酸：</td>
					<td class="td13">
						<input type="radio" name="chemic_h2so4" value="1" [#if "${block.invmfield.chemic_h2so4!''}"=="1"]checked[/#if]>否
						<input type="radio" name="chemic_h2so4" value="2" [#if "${block.invmfield.chemic_h2so4!''}"=="2"]checked[/#if]>是
					</td>
				</tr>
				<tr>
					<td class="td12">海水：</td>
					<td class="td13">
						<input type="radio" name="chemic_seewater" value="1" [#if "${block.invmfield.chemic_seewater!''}"=="1"]checked[/#if]>否
						<input type="radio" name="chemic_seewater" value="2" [#if "${block.invmfield.chemic_seewater!''}"=="2"]checked[/#if]>是
					</td>
					<td class="td12">其他：</td>
					<td class="td13">
						<input type="radio" name="chemic_else" value="1" [#if "${block.invmfield.chemic_else!''}"=="1"]checked[/#if]>否
						<input type="radio" name="chemic_else" value="2" [#if "${block.invmfield.chemic_else!''}"=="2"]checked[/#if]>是
					</td>
					<td class="td12">&nbsp;</td>
					<td class="td13">&nbsp;</td>
				</tr>
				<tr>
					<td vertical-align="middle" align="center" class="tdpad">健康评级</td>
					<td class="td12">子项健康评级：</td>
					<td class="td13" colspan="5">
						<input type="radio" name="field_grading" value="0" [#if "${block.invmfield.field_grading!''}"=="0"]checked[/#if]>A级
						<input type="radio" name="field_grading" value="1" [#if "${block.invmfield.field_grading!''}"=="1"]checked[/#if]>B级
						<input type="radio" name="field_grading" value="2" [#if "${block.invmfield.field_grading!''}"=="2"]checked[/#if]>C级
					</td>
				</tr>
				<tr>
					<td class="td13" colspan="7">
					备注：<br>
					<textarea cols="120" rows="5" name="field_tdesc">${block.invmfield.field_tdesc!''}</textarea>
					</td>
				</tr>
			</table>
		</div>
		<div id="tabs-4">
			<!--健康等级-->
			<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
				<tr>
					<td class="td12">结构健康等级：</td>
					<td class="td13">
						<input type="radio" name="structure_grade" value="1" [#if "${block.buildingsafe.structure_grade!''}"=="1"]checked[/#if]>A级
						<input type="radio" name="structure_grade" value="2" [#if "${block.buildingsafe.structure_grade!''}"=="2"]checked[/#if]>B级
						<input type="radio" name="structure_grade" value="3" [#if "${block.buildingsafe.structure_grade!''}"=="3"]checked[/#if]>C级
						<input type="radio" name="structure_grade" value="4" [#if "${block.buildingsafe.structure_grade!''}"=="4"]checked[/#if]>D级
					</td>
					<td class="td12">使用健康等级：</td>
					<td class="td13">
						<input type="radio" name="used_grade" value="1" [#if "${block.buildingsafe.used_grade!''}"=="1"]checked[/#if]>A级
						<input type="radio" name="used_grade" value="2" [#if "${block.buildingsafe.used_grade!''}"=="2"]checked[/#if]>B级
						<input type="radio" name="used_grade" value="3" [#if "${block.buildingsafe.used_grade!''}"=="3"]checked[/#if]>C级
						<input type="radio" name="used_grade" value="4" [#if "${block.buildingsafe.used_grade!''}"=="4"]checked[/#if]>D级
					</td>
				</tr>
				<tr>
					<td class="td12">抗震能力：</td>
					<td class="td13">
						<input type="radio" name="kz_grade" value="1" [#if "${block.buildingsafe.kz_grade!''}"=="1"]checked[/#if]>强
						<input type="radio" name="kz_grade" value="2" [#if "${block.buildingsafe.kz_grade!''}"=="2"]checked[/#if]>弱
						<input type="radio" name="kz_grade" value="3" [#if "${block.buildingsafe.kz_grade!''}"=="3"]checked[/#if]>差
					</td>
					<td class="td12">防雷能力：</td>
					<td class="td13">
						<input type="radio" name="fl_grade" value="1" [#if "${block.buildingsafe.fl_grade!''}"=="1"]checked[/#if]>强
						<input type="radio" name="fl_grade" value="2" [#if "${block.buildingsafe.fl_grade!''}"=="2"]checked[/#if]>弱
						<input type="radio" name="fl_grade" value="3" [#if "${block.buildingsafe.fl_grade!''}"=="3"]checked[/#if]>差
					</td>
				</tr>
				<tr>
					<td class="td12">消防能力：</td>
					<td class="td13">
						<input type="radio" name="xf_grade" value="1" [#if "${block.buildingsafe.xf_grade!''}"=="1"]checked[/#if]>强
						<input type="radio" name="xf_grade" value="2" [#if "${block.buildingsafe.xf_grade!''}"=="2"]checked[/#if]>弱
						<input type="radio" name="xf_grade" value="3" [#if "${block.buildingsafe.xf_grade!''}"=="3"]checked[/#if]>差
					</td>
					<td class="td12">其他防灾能力：</td>
					<td class="td13">
						<input type="radio" name="other_grade" value="1" [#if "${block.buildingsafe.other_grade!''}"=="1"]checked[/#if]>强
						<input type="radio" name="other_grade" value="2" [#if "${block.buildingsafe.other_grade!''}"=="2"]checked[/#if]>弱
						<input type="radio" name="other_grade" value="3" [#if "${block.buildingsafe.other_grade!''}"=="3"]checked[/#if]>差
					</td>
				</tr>
				<tr>
					<td class="td12">总健康等级：</td>
					<td class="td13" colspan="3">
						<input type="radio" name="all_grade" value="1" [#if "${block.buildingsafe.all_grade!''}"=="1"]checked[/#if]>I级（健康）
						<input type="radio" name="all_grade" value="2" [#if "${block.buildingsafe.all_grade!''}"=="2"]checked[/#if]>II级（亚健康）
						<input type="radio" name="all_grade" value="3" [#if "${block.buildingsafe.all_grade!''}"=="3"]checked[/#if]>III级（病态）
						<input type="radio" name="all_grade" value="4" [#if "${block.buildingsafe.all_grade!''}"=="4"]checked[/#if]>IV级（病危）
					</td>
				</tr>
				<tr>
					<td class="td12">处理意见：</td>
					<td class="td13" colspan="3">
						<input type="radio" name="clresult" value="1" [#if "${block.buildingsafe.clresult!''}"=="1"]checked[/#if]>正常使用
						<input type="radio" name="clresult" value="2" [#if "${block.buildingsafe.clresult!''}"=="2"]checked[/#if]>常规维护
						<input type="radio" name="clresult" value="3" [#if "${block.buildingsafe.clresult!''}"=="3"]checked[/#if]>适当维修
						<input type="radio" name="clresult" value="4" [#if "${block.buildingsafe.clresult!''}"=="4"]checked[/#if]>采取措施
						<input type="radio" name="clresult" value="5" [#if "${block.buildingsafe.clresult!''}"=="5"]checked[/#if]>停止使用
					</td>
				</tr>
				<tr>
					<td class="td12">房屋安全情况：</td>
					<td class="td13" colspan="3">
						<input type="radio" name="health_savegrade" value="1" [#if "${block.buildingsafe.health_savegrade!''}"=="1"]checked[/#if]>无危险点房屋
						<input type="radio" name="health_savegrade" value="2" [#if "${block.buildingsafe.health_savegrade!''}"=="2"]checked[/#if]>存在危险点房屋
						<input type="radio" name="health_savegrade" value="3" [#if "${block.buildingsafe.health_savegrade!''}"=="3"]checked[/#if]>局部危险房屋
						<input type="radio" name="health_savegrade" value="4" [#if "${block.buildingsafe.health_savegrade!''}"=="4"]checked[/#if]>整幢危险房屋
					</td>
				</tr>
				<tr>
					<td class="td12">完损等级：</td>
					<td class="td13" colspan="3">
						<input type="radio" name="lose_grade" value="1" [#if "${block.buildingsafe.lose_grade!''}"=="1"]checked[/#if]>完好房屋
						<input type="radio" name="lose_grade" value="2" [#if "${block.buildingsafe.lose_grade!''}"=="2"]checked[/#if]>基本完好
						<input type="radio" name="lose_grade" value="3" [#if "${block.buildingsafe.lose_grade!''}"=="3"]checked[/#if]>一般破损
						<input type="radio" name="lose_grade" value="4" [#if "${block.buildingsafe.lose_grade!''}"=="4"]checked[/#if]>严重破损
					</td>
				</tr>
				<tr>
					<td class="td12">调查人：</td>
					<td class="td13"><input type="text" name="check_user" value="${block.buildingsafe.check_user!''}"></td>
					<td class="td12">调查日期：</td>
					<td class="td13"><input type="text" name="check_time" [#if block.buildingsafe.check_time?exists]value="${block.buildingsafe.check_time?date}"[/#if]></td>
				</tr>
				<!-- tr>
					<td class="td12">复核人：</td>
					<td class="td13" colspan="3"><input type="text" name=""></td>
				</tr-->
				<tr>
					<td class="td13" colspan="4">
					备注：<br>
					<textarea cols="120" rows="5" name="health_gradetdesc">${block.buildingsafe.health_gradetdesc!''}</textarea>
					</td>
				</tr>
			</table>
		</div>		
	</div>
</div>	
</form>
</div>
<div id="building_check" title="审核" style="display:none;z-index:99;">
	<form name="building_check_form" id="news_check_form"  action="${_servlet_url!''}/safecheck.building.check" method="post">
		<input type="hidden" name="health_savegrade" value="${block.buildingsafe.health_savegrade!''}">
		<input type="hidden" name="build_area" value="${block.buildingsafe.build_area!''}">
		<input type="hidden" id="building_id" name="building_id" value="${block.building.building_id!''}">
		<input type="hidden" id="info_id" name="info_id" value="${block.buildingsafe.info_id!''}">
		<input type="hidden" name="annex_image" value="${block.buildingsafe.annex_pic!''}">
		<input type="hidden" name="annex_file" value="${block.buildingsafe.annex!''}">
		<table class="ui-widget-content  ui-corner-all"  width="100%">
			<tr><td>请输入审核意见：</td></tr>
			<tr><td width="100%">
			<textarea name="building_check_log" id="building_check_log" cols="40" rows="5"></textarea>
			</td></tr>
			<tr><td>
			<input type="radio" name="building_isOpen" value="8" checked> 审核通过 &nbsp;
			<input type="radio" name="building_isOpen" value="2"> 审核驳回
			</td></tr>
		</table>
	</form> 
</div>