<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/swfobject.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/ui.upload.js"></script>
<script type="text/javascript" language="javascript">
$(function(){	
	$("#notice_date").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
	//附件上传
	$("#notice_file").upload({
		width:150,
		type:"doc",
		savepath:"files/safeauth/",
		completed:function(event, json){
 			$("#notice_file").val(json.download_url);
		}
	});
	//表格
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/safeauth.dangerous.managelistjson',
		datatype: "json",
		width:600,
		height:300,
	   	colNames:[
			"building_id"
			,"jdinfo_id"
			,"楼幢坐落"
			,"楼幢地址1"
			,"所属区域"
			,"层数"
			,"户数"
			,"地上层数"
			,"建筑面积"
			,"房屋产别"
			,"设计用途"
			,"建成时间"
			,"房屋与结构"
			,"健康等级"
			,"房屋状态"		
			,"通知发送"	
			,"通知发送id"
			,"定位"
	   	],
	   	colModel:[
			{name:'building_id',index:'building_id',sortable:true,hidden:true}
			,{name:'jdinfo_id',index:'jdinfo_id',sortable:true,hidden:true}
			,{name:'building_address',index:'building_address'}
			,{name:'building_address1',index:'building_address1',hidden:true}
			,{name:'builiding_region',index:'builiding_region',sortable:true,width:50}
			,{name:'floor_count',index:'floor_count',sortable:true,width:40}
			,{name:'house_count',index:'house_count',sortable:true,width:40}
			,{name:'floorup_count',index:'floorup_count',hidden:true}
			,{name:'build_area',index:'build_area',sortable:true,width:40}
			,{name:'real_type',index:'real_type',sortable:true,width:60}
			,{name:'use_desgin',index:'use_desgin',sortable:true,width:60}
			,{name:'building_date',index:'building_date',sortable:true,width:50}
			,{name:'build_struct',index:'build_struct',sortable:true,width:60}
			,{name:'health_grade_jd',index:'health_grade_jd',sortable:true,width:70}
			,{name:'is_die',index:'is_die',sortable:true,width:50}		
			,{name:'notice_state',index:'notice_state',width:40}
			,{name:'notice_state_id',index:'notice_state_id',hidden:true}
			,{name:'dw',index:'dw',width:40}	
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname:'building_id',
	    viewrecords: true,
	    sortorder: "asc",
	    rownumbers:true,
	    caption:"危房信息列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	//更新
	$("#updateInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			window.location="${_servlet_url!''}/safemanage.tBuildingmodify?building_id="+ret.building_id;
		}else{
			alert("请选择一条记录！");
		}
	});
	//模糊查询
	jQuery("#gridReload").click(function() {
		var url="${_servlet_url!''}/safeauth.dangerous.managelistjson"
						+"?building_address="+$("#building_address").val()
						+"&real_type="+$("#real_type").val()
						+"&use_desgin="+$("#use_desgin").val()
						+"&build_struct="+$("#build_struct").val()
						+"&health_grade_jd="+$("#health_grade_jd").val()
						+"&is_die="+$("#is_die").val()
						;
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2,page:1}).trigger("reloadGrid");
	});
	//日期选择:
	//增加按钮
	$("#addInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			$("#building_id").val(ret.building_id);
			$("#op_content").val("");
			$("#dialog").dialog('open');
		}else{
			alert("请选择一条记录！");
		}		
	});
	$("#dialog").dialog({
		resizable:false,
		height:300,
		width:500,
		autoOpen:false,
		modal:true,
		buttons:{
			'取消':function(){
				$(this).dialog('close');
			},
			'确定':function(){
				$("#addForm").submit();
			}
		}
	});
	//对增加的内容进行验证
	$("#addForm").validate({
		submitHandler:function(form){
			var queryString=$("#addForm").formSerialize();
			$.post($("#addForm").attr("action"),queryString,
				function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="0"){
						alert("危房处置信息保存失败！");
						$("#dialog").dialog('close');
					}else{
						alert("危房处置信息保存成功！");
						$("#dialog").dialog('close');
					}
			});
		}
	});
	//危房通知按钮
	$("#noticeInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			if(ret.notice_state_id=="1"){
				alert("此鉴定信息已发送危房通知，不能重复操作！");
				return false;
			}else{
				$("#building_id",$("#noticeForm")).val(ret.building_id);
				$("#notice_content").val("");
				$("#notice_file").val("");
				$("#notice_title").val(ret.building_address1+"${user.organ_name!''}危房通知");
				$("#notice_date").val("");
				$("#dialog1").dialog('open');
			}
		}else{
			alert("请选择一条记录！");
		}		
	});
	$("#dialog1").dialog({
		resizable:false,
		height:380,
		width:650,
		autoOpen:false,
		modal:true,
		buttons:{
			'取消':function(){
				$(this).dialog('close');
			},
			'确定':function(){
				$("#noticeForm").submit();
			}
		}
	});
	//对增加的内容进行验证
	$("#noticeForm").validate({
		submitHandler:function(form){
			var queryString=$("#noticeForm").formSerialize();
			$.post($("#noticeForm").attr("action"),queryString,
					function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="0"){
						alert("危房通知增加失败！");
					}else{
						alert("危房通知增加成功！");
						jQuery("#clist1").trigger("reloadGrid");
						$("#dialog1").dialog('close');
					}
			});
		}
	});
	doResize();
});
//自适应窗口边框
var t=document.documentElement.clientWidth; 
window.onresize = function(){ 
	if(t != document.documentElement.clientWidth){
		t = document.documentElement.clientWidth;
		doResize();
	}
}
function doResize() {
	var ss = getPageSize();
	$("#clist1").jqGrid('setGridWidth', ss.WinW-20);
	$("#clist1").jqGrid('setGridHeight', ss.WinH-180);
}
function getPageSize() {
	var winW, winH;
	if(window.innerHeight) {// all except IE
		winW = window.innerWidth;
		winH = window.innerHeight;
	} else if (document.documentElement && document.documentElement.clientHeight) {// IE 6 Strict Mode
		winW = document.documentElement.clientWidth;
		winH = document.documentElement.clientHeight;
	} else if (document.body) { // other
		winW = document.body.clientWidth;
		winH = document.body.clientHeight;
	}  // for small pages with total size less then the viewport 
		return {WinW:winW, WinH:winH};
}
//清空查询条件
function emptiedAndSubmit(){
	$("#building_address").val("");
	$("#real_type").val("");
	$("#use_desgin").val("");
	$("#build_struct").val("");
	$("#health_grade_jd").val("");
	$("#is_die").val("");
    jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI("${_servlet_url!''}/safeauth.dangerous.managelistjson"),page:1}).trigger("reloadGrid");
}
function noticedetial(building_id){
	window.showModalDialog("${_servlet_url!''}/safeauth.notice.detail?building_id="+building_id);
}
</script>
<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
.rightpad{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.leftpad{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
<div class="skin_search ui-widget-content" style="padding:.2em;margin-bottom:8px;">
	<form name="dic_form" id="dic_form" action="" method="post">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
			<tr>
				<td class="td12">楼幢坐落:</td>
				<td class="td13" colspan="3">
					<input type="text" size="50" name="building_address" id="building_address"/></td>
				<!-- td class="td12">所属区域:</td>
				<td class="td13">
					<select id="builiding_region" name="builiding_region">
					<option value="">------请选择------</option>
					[#list EnumService.getEnum('xzqh') as enum]
					<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
					[/#list]
					</select></td-->
				<td class="td12">房屋产别:</td>
				<td class="td13">
					<select id="real_type" name="real_type">
					<option value="">------请选择------</option>
					[#list EnumService.getEnum('fwcb') as enum]
					<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
					[/#list]
					</select>
				</td>
				<td class="td12">设计用途:</td>
				<td class="td13">
					<select id="use_desgin" name="use_desgin">
					<option value="">------请选择------</option>
					[#list EnumService.getEnum('sjyt') as enum]
					<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
					[/#list]
					</select>
				</td>
			</tr>
			<tr>
				<td class="td12">房屋与结构:</td>
				<td class="td13">
					<select id="build_struct" name="build_struct">
					<option value="">------请选择------</option>
					[#if EnumService.getEnum('fwjg')?exists]
					[#list EnumService.getEnum('fwjg') as enum]
					<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
					[/#list]
					[/#if]
					</select>
				</td>
				<td class="td12">健康等级:</td>
				<td class="td13">
					<select name="health_grade_jd" id="health_grade_jd">
					<option value="">------请选择------</option>
					<option value="1">A级</option>
					<option value="2">B级</option>
					<option value="3">C级</option>
					<option value="4">D级</option>
				</td>
				<td class="td12">房屋状态:</td>
				<td class="td13">
					<select name="is_die" id="is_die">
					<option value="">------请选择------</option>
					<option value="0">消亡</option>
					<option value="1">正常</option>
					</select>
				</td>
				<td class="td13" colspan="2">
					<button type="button" id="gridReload">查询</button>
					<button onclick="emptiedAndSubmit()" style="margin-left:10px;">清空查询条件</button>
				</td>
			</tr>
		</table>
	</form>
</div>
<!--<div  id="buttons" style="text-align:right;margin-bottom:8px;">
	<button type="button" id="noticeInfo" align="right">发送危房通知</button>
	<button type="button" id="addInfo" align="right">增加危房处置</button>
</div>-->
<div id="pager1"></div>
<table id="clist1"></table>
<div id="dialog" title="危楼处置信息" style="display:none">
	<form class="cmxform" style="margin:0" action="${_servlet_url!''}/safeauth.dangerouslog.insert" method="post" id="addForm">
		<input type="hidden" name="building_id" id="building_id">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a6cef2" style="table-layout:fixed;line-height:30px;">
			<tr>
				<td width="100px" class="rightpad">处置内容:</td>
				<td class="leftpad">
				<textarea id="op_content" name="op_content" rows="8" cols="40"/></textarea>
				</td>
			</tr>
			<tr>
				<td width="100px" class="rightpad">房屋状态:</td>
				<td class="leftpad">
				<input type="radio" name="building_state" id="building_state1" checked>正常
				<input type="radio" name="building_state" id="building_state2">消亡
				</td>
			</tr>
		</table>
	</form>
</div>
<div id="dialog1" title="发送危房通知书" style="display:none">
	<form class="cmxform" style="margin:0" action="${_servlet_url!''}/safeauth.notice.add" method="post" id="noticeForm">
		<input type="hidden" name="building_id" id="building_id" value="">
		<input type="hidden" name="jdinfo_id" id="jdinfo_id" value="">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;table-layout:fixed;">
			<tr>
				<td width="100px" class="rightpad">通知标题：</td>
				<td class="leftpad" colspan="3">
				<input type="text" id="notice_title" name="notice_title" size="60">
				</td>
			</tr>
			<tr>
				<td width="100px" class="rightpad">通知内容：</td>
				<td class="leftpad" colspan="3">
				<textarea cols="60" rows="10" id="notice_content" name="notice_content"></textarea>
				</td>
			</tr>
			<tr>
				<td width="100px" class="rightpad">通知附件：</td>
				<td class="leftpad">
				<input type="text" name="notice_file" id="notice_file" value=""/>
				</td>
				<td width="100px" class="rightpad">发送时间：</td>
				<td class="leftpad">
				<input type="text" name="notice_date" id="notice_date" value=""/>
				</td>
				
			</tr>
		</table>
	</form>
</div>