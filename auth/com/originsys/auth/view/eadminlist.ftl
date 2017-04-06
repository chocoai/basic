<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/card.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/messages_cn.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/swfobject.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="${_share_file_url!''}/resource/css/cmxform.css" />
<script type="text/javascript" language="javascript">
$(function(){
	//表格
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/auth.eadmin.listjson',
		datatype: "json",
		width:600,
		height:300,
	   	colNames:[
				"mem_id"
			,
				"姓名"
			,
				"登录名"
			,
				"性别"
			,
				"生日"
			,
				"邮址"
			,
				"手机"
			,
				"注册时间"
			,
				"最后登录时间"
			,
				"用户状态"	
			
	   	],
	   	colModel:[
				{name:'mem_id',index:'mem_id',sortable:true,hidden:true}
			,
				{name:'family_name',index:'family_name',sortable:true,width:10}
			,
				{name:'mem_name',index:'mem_name',sortable:true,width:10}
			,
				{name:'mem_sex',index:'mem_sex',sortable:true,width:10}
			,
				{name:'mem_born',index:'mem_born',sortable:true,hidden:true}
			,
				{name:'mem_mail',index:'mem_mail',sortable:true,width:10}
			,
				{name:'mem_mphone',index:'mem_mphone',sortable:true,width:10}
			,
				{name:'register_time',index:'register_time',sortable:true,width:10}
			,
				{name:'last_time',index:'last_time',sortable:true,width:10}
			,
				{name:'mem_state',index:'mem_state',sortable:true,width:10}	
			
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 
				'mem_id'
		,
	    viewrecords: true,
	    sortorder: "asc",
	    rownumbers:true,
	    caption:"用户列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	//查看详细
	$("#selectInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			var url="${_servlet_url!''}/auth.eadmin.detail?mem_id="+ret.mem_id;
			window.showModalDialog(url,"","dialogWidth:500px;dialogHeight:500px;center:1;");
			jQuery("#clist1").trigger('reloadGrid');	
		}else{
			alert("请选择一条记录！");
		}
	});
	
	//模糊查询
	jQuery("#gridReload").click(function() {
		var url="${_servlet_url!''}/auth.eadmin.listjson"
						+"?family_name="+$("#family_name_select").val()
						+"&mem_sex="+$("#mem_sex_select").val()
						+"&mem_state="+$("#mem_state_select").val()
						+"&mem_name="+$("#mem_name_select").val()
						;
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2}).trigger("reloadGrid");
	});
});

function emptiedAndSubmit(obj){
	$("#family_name_select").val("");
	$("#mem_name_select").val("");
	$("#mem_sex_select option").get(0).selected=true;
	$("#mem_state_select option").get(0).selected=true;
	var url="${_servlet_url!''}/auth.eadmin.listjson";
	var url2 = encodeURI(url);
	jQuery("#clist1").jqGrid('setGridParam',{url:url2}).trigger("reloadGrid");
}

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
</script>
<style>
.rightpad{text-align:right;padding-right:7px;background-color:#F2F9FF;}
.leftpad{padding-left:2px;background-color:#FFFFFF;}
</style>
<div class="skin_search ui-widget-content" style="padding:.2em;margin-bottom:8px;">
	<form name="dic_form" id="dic_form" action="" method="post">
				<span>姓名:</span><span><input type="text" size="15" name="family_name_select" id="family_name_select"/></span>
				<span>登录名:</span><span><input type="text" size="15" name="mem_name_select" id="mem_name_select"/></span>
				<span>性别:</span><span>
				<select name="mem_sex_select" id="mem_sex_select"/>
				<option value="">全部</option>
				[#list EnumService.getEnum('sex') as enum]
				<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
				[/#list]
				</select>
				</span>
				<span>用户状态:</span><span>
				<select name="mem_state_select" id="mem_state_select">
				<option value="">全部</option>
				<option value="1">正常</option>
				<option value="0">禁用</option>
				</select>
				</span>
		<button type="button" id="gridReload">查询</button>&nbsp;
		<button type="button" onclick="emptiedAndSubmit(this);" class="ui-button ui-state-default ui-corner-all">清空条件</button>&nbsp;
	</form>
</div>
<div  id="buttons" style="text-align:right;margin-bottom:8px;">
	<button type="button" id="selectInfo" align="right">查看</button>
</div>
<div id="pager1"></div>
<table id="clist1"></table>