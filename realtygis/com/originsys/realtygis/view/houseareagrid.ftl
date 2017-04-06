<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.opendialog.js"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<style>
.ui-widget-header td{border-bottom:1px solid gray}
.ui-dialog-titlebar-btn { width: 19px; padding: 1px; height: 18px; }
</style>
<script type="text/javascript">
var min=${map.min!''};
var max=${map.max!''};
var bid=${map.bid!''};
var fw_address="";
 $(function(){
 var b_addr="";
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/realtygis.houseareagridjson?id='+bid+'&fw_address='+fw_address+'&min='+min+'&max='+max,
		datatype: "json",
		width:720,
		height:330,
	   	colNames:['房屋内码','房屋坐落', '建筑面积','分摊面积','阳台面积','使用面积','预测面积','建成时间','户式类型','所属层数','备注'],
	   	colModel:[
	   		{name:'house_id',index:'house_id',align:'center'},
	   		{name:'fw_address',index:'fw_address',align:'left', width:950},
	   		{name:'jz_area',index:'jz_area',align:'center'},
	   		{name:'ft_area',index:'ft_area',align:'center'},
	   		{name:'yt_area',index:'yt_area',align:'center'},
	   		{name:'sy_area',index:'sy_area',align:'center'},
	   		{name:'yc_area',index:'yc_area',align:'center'},
	   		{name:'birth_date',index:'birth_date',align:'center'},
	   		{name:'door_type',index:'door_type',align:'center'},
	   		{name:'lay_num',index:'lay_num',align:'center'},
	   		{name:'备注',index:'备注',align:'center'}
	   	],
	   	rowNum:10,
	   	autowidth: true, 
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	 sortable:true,
	   	sortname: 'house_id',
	    viewrecords: true,
	    sortorder: "asc", 
	    rownumbers:true,
	    caption:"符合面积条件的户查询列表"
	    
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
	} 	
	
});

function gridReload(){
	var fw_address = $("#fw_address").val();
	jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI('${_servlet_url!''}/realtygis.houseareagridjson?id='+bid+'&fw_address='+fw_address+'&min='+min+'&max='+max),page:1}).trigger("reloadGrid");
}
  

 </script>
 <div style="padding:5px">
	<div style="padding:5px">
	<div class="skin_search ui-widget-content" style="padding:.2em;">	
		<form name="dic_form" id="dic_form"  method="post">
			<span>单元房间号：<input type="text" size="15" name="fw_address" id="fw_address"></span>
			<button type="button" onclick="gridReload();">查询</button>
		</form>
	</div>
	<div id="pager1"></div>
	<table id="clist1" ></table>	
</div>

