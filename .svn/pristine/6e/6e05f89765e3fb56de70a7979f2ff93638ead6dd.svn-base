<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
$(function(){
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/auth.app.managelistjson',
		datatype: "json",
		width:600,
		height:300,
	   	colNames:[
			"client_id","client_secret","应用名称","应用地址","应用状态","明细"		
	   	],
	   	colModel:[
			{name:'client_id',index:'client_id',hidden:true}
			,{name:'client_secret',index:'client_secret',hidden:true}
			,{name:'app_name',index:'app_name',sortable:true}
			,{name:'app_url',index:'app_url',sortable:true}
			,{name:'app_state',index:'app_state',sortable:true,width:40}
			,{name:'op',index:'op',width:40}			
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[30,50],
	   	pager: '#pager1',
	   	sortname:'reg_date',
	    viewrecords: true,
	    sortorder: "asc",
	    rownumbers:true,
	    caption:"应用列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	//模糊查询					
	jQuery("#gridReload").click(function() {
		var url="${_servlet_url!''}/auth.app.managelistjson?"
		+"app_name="+$("#app_name").val()+"&"
		+"app_state="+$("#app_state").val()
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2}).trigger('reloadGrid');
	});
	$("#tocheck").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			var url="${_servlet_url!''}/auth.app.forcheck?client_id="+ret.client_id;
			window.showModalDialog(url,"","dialogWidth:600px;dialogHeight:600px;center:1;");
			jQuery("#clist1").trigger('reloadGrid');
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
</script>
<div class="skin_search ui-widget-content" style="padding:.2em;margin-bottom:8px;">
	<form name="dic_form" id="dic_form" action="" method="post">
			<span>应用名称:</span>
			<span><input type="text" size="15" name="app_name" id="app_name"/></span>
			<span>应用状态:</span>
			<span>
			<select id="app_state" name="app_state">
				<option value=""></option>
				<option value="0">待审核</option>
				<option value="1">审核通过</option>
				<option value="2">审核驳回</option>
			</select>
			</span>
		<button type="button" id="gridReload">查询</button>&nbsp;
	</form>
</div>
<div  id="buttons" style="text-align:right;margin-bottom:8px;">
	<button type="button" id="tocheck" align="right">审核</button>
</div>
<div id="pager1"></div>
<table id="clist1"></table>
