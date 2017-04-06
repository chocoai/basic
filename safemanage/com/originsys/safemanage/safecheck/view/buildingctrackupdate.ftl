<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	//$("#tbody1 :input").attr({disabled:"true"});
	$("#outdiv").css("display","block");
	$("#tabs").tabs({cache:false});	
});
function dosave(op){
	var str="";
	var building_address=$("#building_address").val();
	if(null==$("#building_address").val() || $("#building_address").val()==''){
		str+="坐落地址不能为空\n\r";
	}
	var building_date=$("#building_date").val();
	if(building_date!=""){
		var ed=new Date().getFullYear();
		if(building_date>ed){
			str+="建成时间不能大于当前日期\n\r";
		}
	}
	var regu="^(0|[1-9][0-9]*)$";//验证零和非零开头的数字
	var re = new RegExp(regu); 
	if($("#house_count").val()!='' && !(re.test($("#house_count").val()))){ 
		str+="户数填写不正确\n\r";
	} 
	if($("#floorup_count").val()!='' && !(re.test($("#floorup_count").val()))){ 
		str+="地上层数填写不正确\n\r";
	} 
	if($("#floordown_count").val()!='' && !(re.test($("#floordown_count").val()))){ 
		str+="地下层数填写不正确\n\r";
	} 
	var check_time=$("#check_time").val();
	if(check_time!=""){
		var ed=new Date();
		re = /-/g;
		var sd=new Date(Date.parse(check_time.replace(re, "/")));
		if(sd>ed){
			str+="调查日期不能大于当前日期\n\r";
		}
	}
	if(str!=''){
		alert(str);
	}else{
		var queryString=$("#addForm").formSerialize();
		$.post($("#addForm").attr("action")+"?op="+op,queryString,
			function(data,textStatus){
			var jdata=jQuery.parseJSON(data);
			if(jdata.success==0){
				if(op=="zc")
					alert("暂存失败！");
				else
					alert("提交失败！");
			}else{
				if(op=="zc")
					alert("暂存成功！");
				else
					alert("提交成功！");
			}
		});
	}
}
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
				隐患楼幢跟踪修改
			</span>
		</div>
	</div>
<div id="outdiv" style="display:none">
<form action="${_servlet_url!''}/safecheck.bctrack.updatesave" id="addForm" method="post">
<input type="hidden" name="building_id" value="${block.building.building_id!''}">
<input type="hidden" name="floor_count" value="${block.building.floor_count!''}">
<input type="hidden" name="build_area" value="${block.building.build_area!''}">
	<div  id="buttons" style="text-align:right">
		<button type="reset">重置</button>
		<button type="button" onclick="dosave('zc');">暂存</button>
		<button type="button" onclick="dosave('tj');">提交</button>
		<button type="button">取消</button>
		<button type="button" onclick="javascript:window.history.go(-1);" >返回</button>
	</div>
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
					<textarea cols="40" rows="5" name="dt_tdesc">${block.buildingctrack.dt_tdesc!''}</textarea>
					</td>
					<td class="td13" colspan="2">
					上下部结构形式备注：<br>
					<textarea cols="40" rows="5" name="dere_desc">${block.buildingctrack.dere_desc!''}</textarea>
					</td>
					<td class="td13" colspan="2">
					装饰装修备注：<br>
					<textarea cols="40" rows="5" name="struct_desc">${block.buildingctrack.struct_desc!''}</textarea>
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
						<input type="radio" name="structure_grade" value="1" [#if "${block.buildingctrack.structure_grade!''}"=="1"]checked[/#if]>A级
						<input type="radio" name="structure_grade" value="2" [#if "${block.buildingctrack.structure_grade!''}"=="2"]checked[/#if]>B级
						<input type="radio" name="structure_grade" value="3" [#if "${block.buildingctrack.structure_grade!''}"=="3"]checked[/#if]>C级
						<input type="radio" name="structure_grade" value="4" [#if "${block.buildingctrack.structure_grade!''}"=="4"]checked[/#if]>D级
					</td>
					<td class="td12">使用健康等级：</td>
					<td class="td13">
						<input type="radio" name="used_grade" value="1" [#if "${block.buildingctrack.used_grade!''}"=="1"]checked[/#if]>A级
						<input type="radio" name="used_grade" value="2" [#if "${block.buildingctrack.used_grade!''}"=="2"]checked[/#if]>B级
						<input type="radio" name="used_grade" value="3" [#if "${block.buildingctrack.used_grade!''}"=="3"]checked[/#if]>C级
						<input type="radio" name="used_grade" value="4" [#if "${block.buildingctrack.used_grade!''}"=="4"]checked[/#if]>D级
					</td>
				</tr>
				<tr>
					<td class="td12">抗震能力：</td>
					<td class="td13">
						<input type="radio" name="kz_grade" value="1" [#if "${block.buildingctrack.kz_grade!''}"=="1"]checked[/#if]>强
						<input type="radio" name="kz_grade" value="2" [#if "${block.buildingctrack.kz_grade!''}"=="2"]checked[/#if]>弱
						<input type="radio" name="kz_grade" value="3" [#if "${block.buildingctrack.kz_grade!''}"=="3"]checked[/#if]>差
					</td>
					<td class="td12">防雷能力：</td>
					<td class="td13">
						<input type="radio" name="fl_grade" value="1" [#if "${block.buildingctrack.fl_grade!''}"=="1"]checked[/#if]>强
						<input type="radio" name="fl_grade" value="2" [#if "${block.buildingctrack.fl_grade!''}"=="2"]checked[/#if]>弱
						<input type="radio" name="fl_grade" value="3" [#if "${block.buildingctrack.fl_grade!''}"=="3"]checked[/#if]>差
					</td>
				</tr>
				<tr>
					<td class="td12">消防能力：</td>
					<td class="td13">
						<input type="radio" name="xf_grade" value="1" [#if "${block.buildingctrack.xf_grade!''}"=="1"]checked[/#if]>强
						<input type="radio" name="xf_grade" value="2" [#if "${block.buildingctrack.xf_grade!''}"=="2"]checked[/#if]>弱
						<input type="radio" name="xf_grade" value="3" [#if "${block.buildingctrack.xf_grade!''}"=="3"]checked[/#if]>差
					</td>
					<td class="td12">其他防灾能力：</td>
					<td class="td13">
						<input type="radio" name="other_grade" value="1" [#if "${block.buildingctrack.other_grade!''}"=="1"]checked[/#if]>强
						<input type="radio" name="other_grade" value="2" [#if "${block.buildingctrack.other_grade!''}"=="2"]checked[/#if]>弱
						<input type="radio" name="other_grade" value="3" [#if "${block.buildingctrack.other_grade!''}"=="3"]checked[/#if]>差
					</td>
				</tr>
				<tr>
					<td class="td12">总健康等级：</td>
					<td class="td13" colspan="3">
						<input type="radio" name="all_grade" value="1" [#if "${block.buildingctrack.all_grade!''}"=="1"]checked[/#if]>I级（健康）
						<input type="radio" name="all_grade" value="2" [#if "${block.buildingctrack.all_grade!''}"=="2"]checked[/#if]>II级（亚健康）
						<input type="radio" name="all_grade" value="3" [#if "${block.buildingctrack.all_grade!''}"=="3"]checked[/#if]>III级（病态）
						<input type="radio" name="all_grade" value="4" [#if "${block.buildingctrack.all_grade!''}"=="4"]checked[/#if]>IV级（病危）
					</td>
				</tr>
				<tr>
					<td class="td12">处理意见：</td>
					<td class="td13" colspan="3">
						<input type="radio" name="clresult" value="1" [#if "${block.buildingctrack.clresult!''}"=="1"]checked[/#if]>正常使用
						<input type="radio" name="clresult" value="2" [#if "${block.buildingctrack.clresult!''}"=="2"]checked[/#if]>常规维护
						<input type="radio" name="clresult" value="3" [#if "${block.buildingctrack.clresult!''}"=="3"]checked[/#if]>适当维修
						<input type="radio" name="clresult" value="4" [#if "${block.buildingctrack.clresult!''}"=="4"]checked[/#if]>采取措施
						<input type="radio" name="clresult" value="5" [#if "${block.buildingctrack.clresult!''}"=="5"]checked[/#if]>停止使用
					</td>
				</tr>
				<tr>
					<td class="td12">安全等级：</td>
					<td class="td13" colspan="3">
						<input type="radio" name="health_savegrade" value="1" [#if "${block.buildingctrack.health_savegrade!''}"=="1"]checked[/#if]>A级
						<input type="radio" name="health_savegrade" value="2" [#if "${block.buildingctrack.health_savegrade!''}"=="2"]checked[/#if]>B级
						<input type="radio" name="health_savegrade" value="3" [#if "${block.buildingctrack.health_savegrade!''}"=="3"]checked[/#if]>C级
						<input type="radio" name="health_savegrade" value="4" [#if "${block.buildingctrack.health_savegrade!''}"=="4"]checked[/#if]>D级
					</td>
				</tr>
				<tr>
					<td class="td12">完损等级：</td>
					<td class="td13" colspan="3">
						<input type="radio" name="lose_grade" value="1" [#if "${block.buildingctrack.lose_grade!''}"=="1"]checked[/#if]>完好房屋
						<input type="radio" name="lose_grade" value="2" [#if "${block.buildingctrack.lose_grade!''}"=="2"]checked[/#if]>基本完好
						<input type="radio" name="lose_grade" value="3" [#if "${block.buildingctrack.lose_grade!''}"=="3"]checked[/#if]>一般破损
						<input type="radio" name="lose_grade" value="4" [#if "${block.buildingctrack.lose_grade!''}"=="4"]checked[/#if]>严重破损
					</td>
				</tr>
				<tr>
					<td class="td12">调查人：</td>
					<td class="td13"><input type="text" name="check_user" value="${block.buildingctrack.check_user!''}"></td>
					<td class="td12">调查日期：</td>
					<td class="td13"><input type="text" id="check_time" name="check_time" [#if block.buildingctrack.check_time?exists]value="${block.buildingctrack.check_time?date}"[/#if]  onClick="WdatePicker()"></td>
				</tr>
				<!-- tr>
					<td class="td12">复核人：</td>
					<td class="td13" colspan="3"><input type="text" name=""></td>
				</tr-->
				<tr>
					<td class="td13" colspan="4">
					备注：<br>
					<textarea cols="120" rows="5" name="health_gradetdesc">${block.buildingctrack.health_gradetdesc!''}</textarea>
					</td>
				</tr>
			</table>
		</div>		
	</div>
</div>	
</form>
</div>