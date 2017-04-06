<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
$(function(){		
	//表格
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/safemanage.safecensor.listjson',
		datatype: "json",
		width:600,
		height:300,
	   	colNames:[
			"mem_id"
			,"用户登录名"
			,"姓名"
			,"注册时间"
			,"最后登录时间"
			,""
			
	   	],
	   	colModel:[
			{name:'mem_id',index:'mem_id',sortable:true,hidden:true}
			,{name:'mem_name',index:'manage_scope',sortable:true,width:10}
			,{name:'fullname',index:'certificate_number',sortable:true,width:10}
			,{name:'register_time',index:'certificate',sortable:true,width:10}
			,{name:'last_time',index:'professional_titles',sortable:true,width:10}
			,{name:'op',index:'op',width:10}
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname:'register_time',
	    viewrecords: true,
	    sortorder: "desc",
	    rownumbers:true,
	    caption:"安全检查员列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	//模糊查询
	jQuery("#gridReload").click(function() {
		var url="${_servlet_url!''}/safemanage.safecensor.listjson"
						+"?fullname="+$("#fullname").val()
						;
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2,page:1}).trigger("reloadGrid");
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
function modifyTypeInfo(mem_id){
	window.showModalDialog("${_servlet_url!''}/safemanage.safecensor.detail?mem_id="+mem_id,"","dialogWidth:600px;dialogHeight:500px;center:1;");
}
</script>
<style>
.rightpad{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.leftpad{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
<div class="skin_search ui-widget-content" style="padding:.2em;margin-bottom:8px;">
	<form name="dic_form" id="dic_form" action="" method="post">
		<span>姓名：<input type="text" size="8" id="fullname" name="fullname" value=""></span>
		&nbsp;<button type="button" id="gridReload">查询</button>
	</form>
</div>
<div id="pager1"></div>
<table id="clist1"></table>