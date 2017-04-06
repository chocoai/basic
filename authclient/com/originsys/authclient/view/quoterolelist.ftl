<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/authclient.role.quotelistjson',
		datatype: "json",
		width:700,
		height:320,
	   	colNames:['角色ID','角色名称','角色描述'],
	   	colModel:[
	   		{name:'role_id',index:'role_id',sortable:false},
	   		{name:'role_name',index:'role_name',sortable:false},
	   		{name:'role_description',index:'role_description',sortable:false}
	   	],
	   	rowNum:10,
	   	autowidth: true, 
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 'role_name',
	    viewrecords: true,
	    sortorder: "asc",
	    caption:"引用角色管理"
	});
	$("#clist1").jqGrid('navGrid','#pager1',{add:false,search:false,del:false,edit:false,refreshtext:'刷新'});
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
		$("#clist1").jqGrid('setGridHeight', ss.WinH-160);
	} 
	
});
function getSelRoleId(){
	var selectedId="";
	var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
	if (id) { 
		var ret = jQuery("#clist1").jqGrid('getRowData',id);
		selectedId=ret.role_id;
		$("#role_id").val(selectedId);
		$("#role_name").val(ret.role_name);
		$("#site_id").val(ret.site_id);
	}
	return selectedId;
}

function accessMap(){
	var role_id=getSelRoleId();
	if(role_id=="")
		warn("请选择角色!");
	else{
		$("#hidform").attr("action","${_servlet_url!''}/authclient.role.roleaccess");
		$("#hidform").submit();
	}
}

function gridReload(){
	var role_name = $("#role_name1").val();
	jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI("${_servlet_url!''}/authclient.role.quotelistjson?role_name="+role_name),page:1}).trigger("reloadGrid");
}
</script>
<form id="hidform" method="post">
<input type="hidden" id="site_id" name="site_id">
<input type="hidden" id="role_id" name="role_id">
<input type="hidden" id="role_name" name="role_name">
</form>
<div style="padding:5px">
	<div class="skin_search ui-widget-content" style="padding:.2em;">
	<form name="moduleform" id="moduleform" action="${_servlet_url!''}/manager.role.list" method="post">
	<span>角色名称：<input type="text" size="15" name="role_name" id="role_name1" value=""></span>
	<button type="button" onclick="gridReload();"  class="ui-button ui-state-default ui-corner-all">查询</button>
	</form>
	</div>
	<div  id="buttons" style="text-align:right">
		[#if access.canDo(user,'manager.role.roleaccess')]
		<button type="button" onclick="accessMap()">对应权限</button>
		[/#if]
	</div>
<div id="pager1"></div>
<table id="clist1"></table>
</div>

