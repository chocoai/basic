<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/safecheck.accident.listjson',
		datatype: "json",
		width:600,
		height:300,
	   	colNames:[
			"building_id"
			,"accident_id"
			,"事故标题"
			,"事故发生时间"
			,"事故类型"
			,"上报人"
			,"事故描述"
	   	],
	   	colModel:[
			{name:'building_id',index:'building_id',sortable:true,hidden:true}
			,{name:'accident_id',index:'accident_id',sortable:true,hidden:true}
			,{name:'accident_name',index:'accident_name',sortable:true,width:100}
			,{name:'accident_date',index:'accident_date',sortable:true,width:50}
			,{name:'accident_type',index:'accident_type',sortable:true,width:50}
			,{name:'accident_reporter',index:'accident_reporter',sortable:true,width:50}
			,{name:'accident_description',index:'accident_description',sortable:true}
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 'accident_date',
	    viewrecords: true,
	    sortorder: "desc",
	    rownumbers:true,
	    caption:"楼幢事故列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	//模糊查询					
	jQuery("#gridReload").click(function() {
		var url="${_servlet_url!''}/safecheck.accident.listjson?"
		+"accident_name="+$("#accident_name").val()+"&"
		+"accident_type="+$("#accident_type").val()+"&"
		+"accident_date="+$("#accident_date").val();
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2,page:1}).trigger('reloadGrid');
	});
	doResize();
	//日期选择:
	$("#accident_date").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
	//查看按钮
	$("#selectInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			var url="${_servlet_url!''}/safecheck.accident.detail?accident_id="+ret.accident_id;
			window.showModalDialog(url,'','dialogWidth:600px;dialogHeight:450px;center:1;');
			jQuery("#clist1").trigger('reloadGrid');
		}else{
			alert("请选择一条记录！");
		}
	});
	//修改按钮
	$("#updateInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			var url="${_servlet_url!''}/safecheck.accident.forupdate?accident_id="+ret.accident_id;
			window.showModalDialog(url,'','dialogWidth:600px;dialogHeight:450px;center:1;');
			jQuery("#clist1").trigger('reloadGrid');
		}else{
			alert("请选择一条记录！");
		}
	});
	//删除按钮
	$("#deleteInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) {
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			var flag=window.confirm("删除不可恢复，确认删除吗？")
			if(flag){
				$.post("${_servlet_url!''}/safecheck.accident.delete?accident_id="+ret.accident_id,"",function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="1"){
						jQuery("#clist1").trigger('reloadGrid');
						alert("删除成功!!");
					}else{
						jQuery("#clist1").trigger('reloadGrid');
						alert("删除失败!!");
					}
				});
			}
		}else{
			alert("请选择一条记录！");
		}
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
	$("#accident_name").val("");
	$("#accident_type").val("");
	$("#accident_date").val("");
    jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI("${_servlet_url!''}/safecheck.accident.listjson"),page:1}).trigger("reloadGrid");
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
		<td class="td12">事故标题:</td>
		<td class="td13">
		<input type="text" size="20" name="accident_name" id="accident_name"/>
		</td>
		<td class="td12">事故类型:</td>
		<td class="td13">
		<input type="text" size="20" name="accident_type" id="accident_type"/>
		</td>
		<td class="td12">事故发生时间:</td>
		<td class="td13">
		<input type="text" size="20" name="accident_date" id="accident_date"/>
		</td>
		<td class="td13" colspan="2"><button type="button" id="gridReload">查询</button><button onclick="emptiedAndSubmit()" style="margin-left:10px;">清空查询条件</button></td>
		</tr>
		</table>
	</form>
</div>
<div  id="buttons" style="text-align:right;margin-bottom:8px;">
	<button type="button" id="updateInfo" align="right">修改</button>
	<button type="button" id="deleteInfo" align="right">删除</button>
	<button type="button" id="selectInfo" align="right">查看</button>
</div>
<div id="pager1"></div>
<table id="clist1"></table>
