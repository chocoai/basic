<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	//表格
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/safecheck.tHdangerBuildinglistdata',
		datatype: "json",
		width:600,
		height:300,
	   	colNames:[
				"info_id"
			,"楼幢坐落"
			,"所属区域"
			,"户数"
			,"层数"
			,"联系人"
			,"联系方式"
			,"录入时间"
			,"信息状态"
			,"受理人中文名称"
			,"受理时间"
			
	   	],
	   	colModel:[
			{name:'info_id',index:'info_id',sortable:true,hidden:true}
			,{name:'building_address',index:'building_address'}
			,{name:'building_region',index:'building_region',sortable:true,width:50}
			,{name:'house_count',index:'house_count',sortable:true,width:30}
			,{name:'floor_count',index:'floor_count',sortable:true,width:30}
			,{name:'link_man',index:'link_man',sortable:true,width:60}
			,{name:'link_tel',index:'link_tel',sortable:true,width:80}
			,{name:'entry_time',index:'entry_time',sortable:true,width:50}
			,{name:'info_state',index:'info_state',sortable:true,width:50}
			,{name:'acceptor',index:'acceptor',hidden:true}
			,{name:'accept_date',index:'accept_date',sortable:true,width:50}
			
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname:'entry_time',
	    viewrecords: true,
	    sortorder: "desc",
	    rownumbers:true,
	    caption:"隐患房屋上报列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	//更新
	$("#updateInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			var url="${_servlet_url!''}/safecheck.tHdangerBuildingdetail?info_id="+ret.info_id;
			window.showModalDialog(url,"","dialogWidth:800px;dialogHeight:600px;center:1;");
			jQuery("#clist1").trigger('reloadGrid');
		}else{
			alert("请选择一条记录！");
		}
	});
	
	//模糊查询
	jQuery("#gridReload").click(function() {
		var url="${_servlet_url!''}/safecheck.tHdangerBuildinglistdata"
						+"?building_address="+$("#building_address").val()
						+"&building_region="+$("#building_region").val()
						+"&info_state="+$("#info_state").val()
						;
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2,page:1}).trigger("reloadGrid");
	});
	//日期选择:
	//$("#entry_time").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
	
	//生成鉴定任务单按钮
	$("#taskInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) {
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			var info_state=ret.info_state;
			if(info_state == '已受理'){
				var url="${_servlet_url!''}/safeauth.jdtask.insertnet?info_id="+ret.info_id;	
				$.post(url,"",function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="1"){
						alert("生成成功!!");
					}else if(jdata.success=="2"){
						alert("该记录已经生成鉴定任务单!!");
					}else{
						alert("生成失败!!");
					}
				});
			}else{
				alert("只能生成已受理的记录！");
			}
		}else{
			alert("请选择一条记录！");
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
	$("#clist1").jqGrid('setGridWidth', ss.WinW-15);
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
	$("#building_region").val("");
	$("#info_state").val("");
    jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI("${_servlet_url!''}/safecheck.tHdangerBuildinglistdata"),page:1}).trigger("reloadGrid");
}
</script>
<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
<div class="skin_search ui-widget-content" style="padding:.2em;margin-bottom:8px;">
	<form name="dic_form" id="dic_form" action="" method="post">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<tr>
			<td class="td12">楼幢坐落:</td>
			<td class="td13"><input type="text" size="30" name="building_address" id="building_address"/></td>
			<td class="td12">所属区域:</td>
			<td class="td13">
			<select id="building_region" name="building_region">
			<option value="">------请选择------</option>
			[#list EnumService.getEnum('xzqh') as enum]
			<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
			[/#list]
			</select>
			</td>
			<!-- td class="td12">联系人:</td>
			<td class="td13"><input type="text" name="link_man" id="link_man"/></td -->
			<td class="td12">信息状态:</td>
			<td class="td13">
			<select name="info_state" id="info_state">
			<option value="">------请选择------</option>
			<option value="0">待受理</option>
			<option value="1">已受理</option>
			</select>
			</td>
			<td class="td13">
			<button type="button" id="gridReload">查询</button>
			<button onclick="emptiedAndSubmit()" style="margin-left:10px;">清空查询条件</button>
			</td>
		</tr>
		</table>
	</form>
</div>
<div  id="buttons" style="text-align:right;margin-bottom:8px;">
	<button type="button" id="updateInfo" align="right">受理/详细</button>
	[#if access.canDo(user,'safeauth.jdtask.insertnet')]
	<button type="button" id="taskInfo" align="right">生成鉴定任务单</button>
	[/#if]
</div>
<div id="pager1"></div>
<table id="clist1"></table>