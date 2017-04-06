<script type="text/javascript" language="javascript">
$(function(){
	$("#detailForm :input").attr({disabled:"true"});
	$("#outdiv").css("display","block");
	$("#tabs").tabs({cache:false});	
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
				隐患楼幢跟踪详细
			</span>
		</div>
	</div>
<div id="outdiv" style="display:none">
	<div  id="buttons" style="text-align:right">
		<button type="button" onclick="javascript:window.history.go(-1);" >返回</button>
	</div>
<form action="${_servlet_url!''}/safecheck.bctrack.insertsave" id="addForm" method="post">
<input type="hidden" name="building_id" value="${block.building.building_id!''}">
<input type="hidden" name="floor_count" value="${block.building.floor_count!''}">
<input type="hidden" name="build_area" value="${block.building.build_area!''}">
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .1em;">
	<div class="ui-widget" id="tabs">
		<ul>
			<li><a href="#tabs-1">基本信息</a></li>
			<li><a href="#tabs-4">健康等级</a></li>
		</ul>				
		<div id="tabs-1">
			<!--基本信息-->
			<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
				<tbody id="tbody1">
				<tr>
					<td class="td12">坐落地址：</td>
					<td class="td13" colspan="3"><input type="text" id="building_address" name="building_address" size="80" value="${block.building.building_address!''}"></td>
					<td class="td12">楼幢号：</td>
					<td class="td13"><input type="text" name="building_num" value="${block.building.building_number!''}" size="18"></td>
					
				</tr>
				<tr>
					<td class="td12">普查期次：</td>
					<td class="td13">
						
					</td>
					<td class="td12">所属区域：</td>
					<td class="td13">
					<select id="builiding_region" name="builiding_region">
						<option value="">------请选择------</option>
						[#list EnumService.getEnum('xzqh') as enum]
						<option value="${enum.enum_value!''}" [#if "${block.building.builiding_region!''}"=="${enum.enum_value!''}"]selected[/#if]>${enum.enum_name!''}</option>
						[/#list]
						</select>
					</td>
					<td class="td12">建成时间：</td>
					<td class="td13"><input type="text" name="building_date" value="${block.building.building_date!''}" size="18"></td>
					
				</tr>
				<tr>
					<td class="td12">户数：</td>
					<td class="td13"><input type="text" name="house_count" value="${block.building.house_count!''}" size="18"></td>
					<td class="td12">地上层数：</td>
					<td class="td13"><input type="text" name="floorup_count" value="${block.building.floorup_count!''}" size="18"></td>
					<td class="td12">地下层数：</td>
					<td class="td13"><input type="text" name="floordown_count" value="${block.building.floordown_count!''}" size="18"></td>
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
					<td class="td12">房屋类别：</td>
					<td class="td13">
						<select name="">
							<option value="">------请选择------</option>
							<option value="1">个人</option>
							<option value="2">公共建筑</option>
							<option value="3">保障住房</option>
						</select>
					</td>
					<td class="td12">房屋：</td>
					<td class="td13" colspan="3">
					</td>
				</tr>
				</tbody>
				<tr>
					<td class="td13" colspan="2">
					电梯、楼梯备注：<br>
					<textarea cols="40" rows="5" name="dt_tdesc"></textarea>
					</td>
					<td class="td13" colspan="2">
					上下部结构形式备注：<br>
					<textarea cols="40" rows="5" name="dere_desc"></textarea>
					</td>
					<td class="td13" colspan="2">
					装饰装修备注：<br>
					<textarea cols="40" rows="5" name="struct_desc"></textarea>
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
						<input type="radio" name="structure_grade" value="1">A级
						<input type="radio" name="structure_grade" value="2">B级
						<input type="radio" name="structure_grade" value="3">C级
						<input type="radio" name="structure_grade" value="4">D级
					</td>
					<td class="td12">使用健康等级：</td>
					<td class="td13">
						<input type="radio" name="used_grade" value="1">A级
						<input type="radio" name="used_grade" value="2">B级
						<input type="radio" name="used_grade" value="3">C级
						<input type="radio" name="used_grade" value="4">D级
					</td>
				</tr>
				<tr>
					<td class="td12">抗震能力：</td>
					<td class="td13">
						<input type="radio" name="kz_grade" value="1">强
						<input type="radio" name="kz_grade" value="2">弱
						<input type="radio" name="kz_grade" value="3" checked>差
					</td>
					<td class="td12">防雷能力：</td>
					<td class="td13">
						<input type="radio" name="fl_grade" value="1">强
						<input type="radio" name="fl_grade" value="2">弱
						<input type="radio" name="fl_grade" value="3" checked>差
					</td>
				</tr>
				<tr>
					<td class="td12">消防能力：</td>
					<td class="td13">
						<input type="radio" name="xf_grade" value="1">强
						<input type="radio" name="xf_grade" value="2">弱
						<input type="radio" name="xf_grade" value="3" checked>差
					</td>
					<td class="td12">其他防灾能力：</td>
					<td class="td13">
						<input type="radio" name="other_grade" value="1">强
						<input type="radio" name="other_grade" value="2">弱
						<input type="radio" name="other_grade" value="3" checked>差
					</td>
				</tr>
				<tr>
					<td class="td12">总健康等级：</td>
					<td class="td13" colspan="3">
						<input type="radio" name="all_grade" value="1">I级（健康）
						<input type="radio" name="all_grade" value="2">II级（亚健康）
						<input type="radio" name="all_grade" value="3">III级（病态）
						<input type="radio" name="all_grade" value="4">IV级（病危）
					</td>
				</tr>
				<tr>
					<td class="td12">处理意见：</td>
					<td class="td13" colspan="3">
						<input type="radio" name="clresult" value="1">正常使用
						<input type="radio" name="clresult" value="2">常规维护
						<input type="radio" name="clresult" value="3" checked>适当维修
						<input type="radio" name="clresult" value="4">采取措施
						<input type="radio" name="clresult" value="5">停止使用
					</td>
				</tr>
				<tr>
					<td class="td12">安全等级：</td>
					<td class="td13" colspan="3">
						<input type="radio" name="health_savegrade" value="1">A级
						<input type="radio" name="health_savegrade" value="2">B级
						<input type="radio" name="health_savegrade" value="3">C级
						<input type="radio" name="health_savegrade" value="4">D级
					</td>
				</tr>
				<tr>
					<td class="td12">完损等级：</td>
					<td class="td13" colspan="3">
						<input type="radio" name="lose_grade" value="1">完好房屋
						<input type="radio" name="lose_grade" value="2">基本完好
						<input type="radio" name="lose_grade" value="3" checked>一般破损
						<input type="radio" name="lose_grade" value="4">严重破损
					</td>
				</tr>
				<tr>
					<td class="td12">调查人：</td>
					<td class="td13"><input type="text" name="check_user"></td>
					<td class="td12">调查日期：</td>
					<td class="td13"><input type="text" name="check_time"></td>
				</tr>
				<tr>
					<td class="td13" colspan="4">
					备注：<br>
					<textarea cols="120" rows="5" name="health_gradetdesc"></textarea>
					</td>
				</tr>
			</table>
		</div>		
	</div>
</div>	
</form>
</div>