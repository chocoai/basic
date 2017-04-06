<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/eap.dialog.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	//$("#detailForm :input").attr({disabled:"true"});
	$("#outdiv").css("display","block");
	$("#tabs").tabs({cache:false});	
	
	$('#dialog').dialog({
		autoOpen: false,
		width: 770,
		height:510,
		buttons: {
			"取消": function() {
				$('#dialog').dialog("close");
			}, 
			"保存": function() { 
				$("#annex_pic").val($("#imgs").val());			
				$('#dialog').dialog("close");
			}
		}
	});
	$("#annex_pic_btn").click(function(){
		$('#dialog').dialog("open");
	});
});
function dosave(op){
	var queryString=$("#addForm").formSerialize();
	var str="";
	var building_address=$("#building_address").val();
	//if(null==$("#building_address").val() || $("#building_address").val()==''){
	//	str+="坐落地址不能为空\n\r";
	//}
	if(null==$("#check_address").val() || $("#check_address").val()==''){
		str+="检查新坐落不能为空\n\r";
	}
	var issame=document.getElementsByName("issame");
	var issame1="";
	for(i=0;i<issame.length;i++){
		if(issame[i].checked==true){
			issame1=issame[i].value;
		}
	}
	if(issame1==''){
		str+="请选择坐落是否一致\n\r";
	}
	if(null==$("#builiding_region").val() || $("#builiding_region").val()==''){
		str+="所属区域不能为空\n\r";
	}
	var building_date=$("#building_date").val();
	if(building_date!=""){
		var ed=new Date().getFullYear();
		if(building_date>ed){
			str+="建成时间不能大于当前日期\n\r";
		}
	}
	var isarea=/^\d+(\.\d+)?$/;
	var build_area=$("#build_area").val();
	if(build_area!="" && !isarea.test(build_area)){
		str+="建筑面积填写不正确\n\r";
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
	var heigth=$("#heigth").val();
	if(heigth!="" && !isarea.test(heigth)){
		str+="高度填写不正确\n\r";
	}
	var depth=$("#depth").val();
	if(depth!="" && !isarea.test(depth)){
		str+="檐高填写不正确\n\r";
	}
	var floor_height=$("#floor_height").val();
	if(floor_height!="" && !isarea.test(floor_height)){
		str+="层高填写不正确\n\r";
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
	if(op=="tj"){
		if($("[name=health_savegrade]:checked").val()==undefined){
			str+="房屋安全情况不能为空\n\r";
		}
		if(null==$("#check_user").val() || $("#check_user").val()==''){
			str+="调查人不能为空\n\r";
		}
		if(null==check_time || check_time==''){
			str+="调查日期不能为空\n\r";
		}
	}
	if(str!=''){
		alert(str);
	}else{
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
				window.close();
			}
		});
	}
}

function fileUpload()
	{
		if($("#fileToUpload1").val()==''||$("#fileToUpload1").val()==null){
			alert("请先选择要上传的文件！");
			return false;
		}else{
			$.ajaxFileUpload
		(
			{
				url:'${_server_url!''}/eap/safecheck.uploadfile',
				secureuri:false,
				fileElementId:'fileToUpload1',
				dataType: 'json',
				data:{savepath:'files/survey/'},
				success: function (data, status)
				{
					if(data.success=='0'){
						alert("上传成功！");
						$("#annex").val("/eap/commonservice.download?file_id="+data.file_id);
						$("#annex1").val("/eap/commonservice.download?file_id="+data.file_id);
						//$("#annex").val(data.save_name);
						//$("#returnval1").attr("href",data.save_name);
						//$("#returnval1").text("点击下载");
						$("#returnval1").attr("style","display:inline-block");
					}else if(data.success=='1'){
						alert("请检查上传文件的类型！");
					}else{
						alert("没有上传权限！");
					}
				},
				error: function (data, status, e)
				{
					alert(e);
				}
			}
		)
		
		return false;
			
		}
		
	}
function fileDownload(){
	window.location.href=$("#annex").val();
}
function changeAddress(flag){
	if(flag=='1'){
		$("#check_address").val($("#building_address").val());
	}else{
		$("#check_address").val("");
	}
}
</script>
<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
.tdpad {padding-left:4px; background-color:#ffffff}
.td_title {text-align:right;padding-right:4px; background-color:#ffffff}
.file-box input{ vertical-align:middle; margin:0; padding:0}
.file-box{ position:relative;width:440px;WHITE-SPACE:nowrap;}
.file-box .txt{ height:22px; border:1px solid #cdcdcd; width:195px;}
.file-box .btn{ background-color:#FFF; border:1px solid #CDCDCD;height:24px; width:60px;}
.file-box .file{ position:absolute; top:3px; right:180px; height:24px; filter:alpha(opacity:0);opacity: 0;width:260px }
</style>
	<div class="widget-title-normal">
		<div class="child">
			<span class="widget-title-text">
				楼幢安全检查修改
			</span>
		</div>
	</div>
<div id="outdiv" style="display:none">
<form action="${_servlet_url!''}/safecheck.building.save" id="addForm" method="post">
<input type="hidden" name="building_id" value="${block.building.building_id!''}">
<input type="hidden" id="info_id" name="info_id" value="${block.buildingsafe.info_id!''}">
<input type="hidden" name="floor_count" value="${block.building.floor_count!''}">
	<div  id="buttons" style="text-align:right">
		<button type="reset">重置</button>
		<button type="button" onclick="dosave('zc');">暂存</button>
		<button type="button" onclick="dosave('tj');">提交</button>
		<!--button type="button" onclick="javascript:window.history.go(-1);" >返回</button-->
	</div>
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
					<td class="td12">上传附件：</td>
					<td class="td13" colspan="3">
					<div class="file-box">
						<input type="hidden" id="annex" name="annex" class='txt' value="${block.buildingsafe.annex!''}">
						<input type="text" id="annex1" name="annex1" class='txt' value="${block.buildingsafe.annex!''}">
						<input type='button' class="btn" value='浏览...' />
						<input type="file" id="fileToUpload1" size="28" name="fileToUpload1" class="file" onchange="document.getElementById('annex1').value=this.value" >
						<input type='button' onclick="return fileUpload();" class="btn" value='点击上传' />
						<input type='button' onclick="fileDownload()" id="returnval1" name="returnval1"  class="btn"  style="margin-left:5px;[#if "${block.buildingsafe.annex!''}"!='']display:inline-block[#else]display:none[/#if];" value="下载附件"/>
					</div>
					</td>
					<td class="td12">上传图片：</td>
					<td class="td13">
						<input type="hidden" id="annex_pic" name="annex_pic" class='txt'  value="${block.buildingsafe.annex_pic!''}" size="100" readonly="true">
						<button type="button" id="annex_pic_btn">查看图片</button>
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
					<td class="td12"><font color="red">*&nbsp;</font>房屋安全情况：</td>
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
					<td class="td12"><font color="red">*&nbsp;</font>调查人：</td>
					<td class="td13"><input type="text" id="check_user" name="check_user" value="${block.buildingsafe.check_user!''}"></td>
					<td class="td12"><font color="red">*&nbsp;</font>调查日期：</td>
					<td class="td13"><input type="text" id="check_time" name="check_time" [#if block.buildingsafe.check_time?exists]value="${block.buildingsafe.check_time?string('yyyy-MM-dd')}"[/#if] onClick="WdatePicker()"></td>
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
			<!-- table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
				<tr>
					<td class="td12">审核意见：</td>
					<td class="td13"><textarea cols="60" rows="3"></textarea></td>
					<td class="td12">审核操作：</td>
					<td class="td13">
						<input type="radio" name="lose_grade" value="1">审核通过
						<input type="radio" name="lose_grade" value="2">审核驳回
					</td>
					<td class="td13">
						<button type="button">提交</button>
						<button type="button">返回</button>
					</td>
				</tr>
			</table-->
</div>
<div id="dialog" title="上传图片">
<!--iframe frameborder="0" src="${_server_url!''}/portal/safecheck.multi.uploadimage" name="dialogContent" id="dialogContent" style="width:550px;height:600px"></iframe-->
<script src="${_share_file_url!''}/resource/js/jquery.uploadfile.form.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.uploadfile.js" type="text/javascript"></script>
<link href="${_share_file_url!''}/resource/css/uploadfile.css" rel="stylesheet" type="text/css" / >
<script language="javascript">
var uploadObj;
$(document).ready(function()
{
	var uploadObj=$("#but1").uploadFile({
		url:"${_server_url!''}/portal/commonservice.multi.uploadimage",
		formData:{savepath:'safecheck/', id: '',urlPath:''},//存放文件的路径及其他上传需要的参数
		multiple:true,
		returnType: 'json',
		allowedTypes: "jpg,png,gif",//接受的文件类型
		acceptFiles: "image/",//接受的文件类型
		autoSubmit: true,//是否自动提交
		fileName:"myfile[]",//上传域的名字
		shwCancel: false,
        showAbort: false,
        showDone: false,
        showDelete: true,
        statusBarWidth: 200,
        dragdropWidth: 60,//上传按钮的宽度
        showPreview: true,//是否显示预览图片
        previewHeight: "80",//预览图片的宽度
        previewWidth: "150",
        uploadFolder:"",//文件路径，我们系统中用空就可以
        uploadButtonClass:"ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only",//上传按钮的样式
		onSuccess:function(files,data,xhr,pd)
		{
			//files: list of files
			//data: response from server
			//xhr : jquer xhr object
			if(typeof(data.image_id) != 'undefined')
			{
				//alert("上传成功！"+data.image_id+"...simage_url="+data.simage_url);
				pd.statusbar.hide();
				pd.del.click();
				var str=$("#imgs").val();
				if(str=="")
					str=data.image_id;
				else
					str=str+","+data.image_id;
				$("#imgs").val(str);
				uploadObj.createProgress(data.simage_url);
			}
		},
		deleteCallback: function(data,pd)
		{
			for(var i=0;i<data.length;i++)
			{
			 	$.post("${_server_url!''}/portal/commonservice.anneximage.delete",
				 	{"simageurl":data[i]},
				    function(resp, textStatus, jqXHR)
				    {
						var jdata=jQuery.parseJSON(resp);  
						var str=$("#imgs").val();
						if(str==jdata.image_id)
							str="";
						else{
							str=str.replace(jdata.image_id+",","");
							str=str.replace(","+jdata.image_id,"");
						}
						$("#imgs").val(str);
						alert("删除成功");
				    });
			 }		
			pd.statusbar.hide(); //You choice to hide/not.
		
		},
		onLoad:function(obj)
	    {
	        $.ajax({
	            cache: false,
	            url: "${_server_url!''}/portal/safecheck.image.list?info_id=${block.buildingsafe.info_id!''}",
	            dataType: "json",
	            success: function(data) 
	            {
	            	var str="";
	            	for(var i=0;i<data.images.length;i++)
	                {	
	                	obj.createProgress(data.images[i]);
	                	if(i==0)
	                		str=data.ids[i];
	                	else
	                		str=str+","+data.ids[i];
	                }
	                $("#imgs").val(str);
	            }
	        });
   		}
	});
	$("#abc").click(function(){
		uploadObj.startUpload();
	});
});
$(document).ready(function(){ 
    $("#but1").css({"background":"none","display":"block","border":"none","color":"#fff"});
});
</script>
<input type="hidden" id="imgs" size="400">
<!--button id="abc" type="button" style="display:inline;float:right;margin-right:30px;height:29px;margin-left:10px">上传</button-->
<button id="but1" type="button" style="clear:both;display:block;height:5px">选择</button>
</div>