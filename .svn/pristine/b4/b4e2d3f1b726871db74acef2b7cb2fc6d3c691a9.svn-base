<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	//表格
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/safeauth.report.managelistjson',
		datatype: "json",
		width:600,
		height:270,
	   	colNames:[
				"jdinfo_id"
			,"楼幢编号"
			,"楼幢地址"
			,"所属区域"
			,"委托人或单位"
			,"联系人"
			,"联系电话"
			,"鉴定人"
			,"鉴定时间"
			,"鉴定单位"
			,"危险等级"
			,"房屋结构老化程度"
			,"是否有改造"
			,"设施老化程度"
			,"抗震结构是否完善"
			,"拆改结构是否严重"			
			,"鉴定单位"			
			,"鉴定信息状态id"
			,"信息状态"
			,"录入人"
			,"录入时间"
			,"定位"
	   	],
	   	colModel:[
			{name:'jdinfo_id',index:'jdinfo_id',sortable:true,hidden:true}
			,{name:'building_id',index:'building_id',sortable:true,hidden:true}
			,{name:'building_address',index:'building_address',sortable:true}
			,{name:'building_region',index:'building_region',sortable:true,width:40}
			,{name:'entrust_user',index:'entrust_user',sortable:true}
			,{name:'linkman',index:'linkman',sortable:true,width:50}
			,{name:'linktel',index:'linktel',sortable:true,width:50}
			,{name:'jdmember',index:'jdmember',sortable:true,width:50}
			,{name:'jd_date',index:'jd_date',sortable:true,width:40}
			,{name:'jd_department',index:'jd_department',width:70}	
			,{name:'dangerous_level',index:'dangerous_level',sortable:true,width:80}
			,{name:'struct_aging',index:'struct_aging',hidden:true}
			,{name:'is_transform',index:'is_transform',hidden:true}
			,{name:'facility_aging',index:'facility_aging',hidden:true}
			,{name:'is_kzperfect',index:'is_kzperfect',hidden:true}
			,{name:'is_transform_seriousness',index:'is_transform_seriousness',hidden:true}			
			,{name:'jd_department_id',index:'jd_department_id',hidden:true}			
			,{name:'info_state_id',index:'info_state_id',hidden:true}
			,{name:'info_state',index:'info_state',sortable:true,width:40}
			,{name:'entry_mem_id',index:'entry_mem_id',hidden:true}
			,{name:'entry_date',index:'entry_date',sortable:true,hidden:true}	
			,{name:'dw',index:'dw',width:30}		
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname:'info_state asc,jdinfo_id',
	    viewrecords: true,
	    sortorder: "asc",
	    rownumbers:true,
	    caption:"鉴定报告表列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	//查看详细
	$("#selectInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			window.location="${_servlet_url!''}/safeauth.report.detail?jdinfo_id="+ret.jdinfo_id;	
		}else{
			alert("请选择一条记录！");
		}
	});
	//审核
	$("#checkInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			var info_state=ret.info_state;
			if(info_state == '审核通过'){
				alert("已审核通过，不能再审核！");
			}else{
				var url="${_servlet_url!''}/safeauth.report.forcheck?jdinfo_id="+ret.jdinfo_id;
				window.showModalDialog(url,"","dialogWidth:1000px;dialogHeight:600px;center:1;");
				jQuery("#clist1").trigger('reloadGrid');
			}
		}else{
			alert("请选择一条记录！");
		}
	});
	//模糊查询
	jQuery("#gridReload").click(function() {
		var url="${_servlet_url!''}/safeauth.report.managelistjson"
						+"?building_address="+$("#building_address").val()
						+"&building_region="+$("#building_region").val()
						+"&entrust_user="+$("#entrust_user").val()
						+"&jd_department="+$("#jd_department").val()
						+"&dangerous_level="+$("#dangerous_level").val()
						+"&jd_date1="+$("#jd_date1").val()
						+"&jd_date2="+$("#jd_date2").val()
						+"&jdmember="+$("#jdmember").val()
						+"&info_state="+$("#info_state").val()
						;
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2,page:1}).trigger("reloadGrid");
	});
	//日期选择:
	$("#jd_date1").attr("readonly", "false").datepicker({dateFormat:"yy-mm-dd"});	
	$("#jd_date2").attr("readonly", "false").datepicker({dateFormat:"yy-mm-dd"});	
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
	$("#building_region").val("");
	$("#dangerous_level").val("");
	$("#info_state").val("");
	$("#entrust_user").val("");
	$("#jd_department").val("");
	$("#jd_date1").val("");
	$("#jd_date2").val("");
	$("#jdmember").val("");
    jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI("${_servlet_url!''}/safeauth.report.managelistjson"),page:1}).trigger("reloadGrid");
}
function noticedetial(jdinfo_id){
	window.showModalDialog("${_servlet_url!''}/safeauth.notice.detail?jdinfo_id="+jdinfo_id);
}
</script>
<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
<div class="skin_search ui-widget-content" style="padding:.2em;margin-bottom:8px;">
	<form name="dic_form" id="dic_form" action="${_servlet_url!''}/safeauth.report.listjson" method="post">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<tr>
		<td class="td12">楼幢地址:</td>
		<td class="td13"><input type="text" name="building_address" id="building_address"/></td>
		<td class="td12">所属区域:</td>
		<td class="td13">
			<select id="building_region" name="building_region">
			<option value="">------请选择------</option>
			[#list EnumService.getEnum('xzqh') as enum]
			<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
			[/#list]
			</select>
		</td>
		<td class="td12">危险等级:</td>
		<td class="td13">
			<select name="dangerous_level" id="dangerous_level">
			<option value="">------请选择------</option>
			<option value="1">A级</option>
			<option value="2">B级</option>
			<option value="3">C级</option>
			<option value="4">D级</option>
			</select>
		</td>
		<td class="td12">鉴定信息状态:</td>
		<td class="td13">
			<select name="info_state" id="info_state">
			<option value="">------请选择------</option>
			<option value="0">暂存</option>
			<option value="1">待审核</option>
			<option value="2">审核驳回</option>
			<option value="8">审核通过</option>
			</select>
		</td>		
		</tr>
		<tr>
		<td class="td12">委托人或单位:</td>
		<td class="td13"><input type="text" name="entrust_user" id="entrust_user"/></td>
		<td class="td12">鉴定单位:</td>
		<td class="td13"><input type="text" size="14" name="jd_department" id="jd_department"/></td>		
		<td class="td12">鉴定时间起自:</td>
		<td class="td13"><input type="text" size="14" name="jd_date" id="jd_date1"/></td>
		<td class="td12">鉴定时间截至:</td>
		<td class="td13"><input type="text" size="14" name="jd_date" id="jd_date2"/></td>		
		</tr>
		<tr>
		<td class="td12">鉴定人:</td>
		<td class="td13"><input type="text" size="14" name="jdmember" id="jdmember"/></td>
		<td class="td13" colspan="8" align="right">
		<button type="button" id="gridReload">查询</button>
		<button onclick="emptiedAndSubmit()" style="margin-left:10px;" type="button">清空查询条件</button>
		</td>		
		</tr>
		</table>
	</form>
</div>
<div  id="buttons" style="text-align:right;margin-bottom:8px;">
		<button type="button" id="checkInfo" align="right">审核</button>
		<!-- button type="button" id="selectInfo" align="right">查看</button -->
</div>
<div id="pager1"></div>
<table id="clist1"></table>
<div id="dialog" title="鉴定报告表列表" style="display:none">
	<form class="cmxform" style="margin:0" action="${_servlet_url!''}/safeauth1.tAppraisalReportadd" method="post" id="addForm">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a6cef2">
		</table>
	</form>
</div>