<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
$(function(){
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/auth.rolelistjson',
		datatype: "json",
		width:600,
		height:300,
	   	colNames:["role_register_id","角色id","角色名","前置角色","站点","是否需审核","审核地址","备注"],
	   	colModel:[
			{name:'role_register_id',index:'role_register_id',sortable:true,hidden:true}
			,{name:'role_id',index:'role_id',sortable:true,width:10}
			,{name:'role_name',index:'role_name',sortable:true,width:10}
			,{name:'preposition_role',index:'preposition_role',sortable:true,width:10}
			,{name:'site_id',index:'site_id',sortable:true,width:10,hidden:true}
			,{name:'ischeck',index:'ischeck',sortable:true,width:10}
			,{name:'check_url',index:'check_url',sortable:true,width:10}
			,{name:'role_description',index:'role_description',sortable:true,width:10}			
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[30,50],
	   	pager: '#pager1',
	   	sortname:'role_register_id',
		viewrecords: true,
	    sortorder: "asc",
	    rownumbers:true,
	    caption:"角色注册表列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	//模糊查询
	jQuery("#gridReload").click(function() {
		var url="${_servlet_url!''}/auth.rolelistjson"
						+"?role_id="+$("#role_id_select").val()
						
						+"&site_id="+$("#site_id_select").val()
						
						+"&role_name="+$("#role_name_select").val()
						
						+"&role_description="+$("#role_description_select").val()
						
						+"&ischeck="+$("#ischeck_select").val()
						
						+"&preposition_role="+$("#preposition_role_select").val()
						
						+"&check_url="+$("#check_url_select").val()
						;
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2}).trigger("reloadGrid");
	});	
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
</script>
<div class="skin_search ui-widget-content" style="padding:.2em;margin-bottom:8px;">
	<form name="dic_form" id="dic_form" action="" method="post">
		<span>角色id:</span><span><input type="text" size="15" name="role_id_select" id="role_id_select"/></span>
		<span>角色名:</span><span><input type="text" size="15" name="role_name_select" id="role_name_select"/></span>
		<button type="button" id="gridReload">查询</button>&nbsp;
	</form>
</div>
<div id="pager1"></div>
<table id="clist1"></table>
