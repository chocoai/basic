<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/mbtool/showads.js"></script>
<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript">
$(function(){
		$("#start_time").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
		$("#end_time").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
	$("#dialog").dialog({
		resizable:false,
		height:200,
		width:450,
		autoOpen:false,
		modal:true,
		buttons:{
			'取消':function(){
				$(this).dialog('close');
			},
			'确定':function(){
				if(confirm("确定删除该时间段内的日志信息?")){
			       var queryString=$("#deletefrom").formSerialize();
						$.post("${_servlet_url!''}/manager.system.logdelete",
							queryString,
							function(data,textStatus){
								var jdata=jQuery.parseJSON(data);
								if(jdata.success==1){
									alert("删除成功！");
									 $("#dialog").dialog( "close" );
									jQuery("#clist1").jqGrid('setGridParam',{url:"${_servlet_url!''}/manager.system.loglistdate"}).trigger("reloadGrid");
								}else{
									alert("删除失败！");
								}
						});
			   }
			}
		}
	});
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/manager.system.loglistdate',
		datatype: "json",
		width:700,
		height:300,
	   	colNames:['ID','时间','用户名称','浏览页标题','用户IP','栏目名称','组件名','站点名称','操作模块','操作','客户浏览器','客户操作系统'],
	   	colModel:[
	   		{name:'log_id',index:'log_id',hidden:true},
	   		{name:'visit_time',index:'visit_time', width:'100px'},
	   		{name:'mem_name',index:'mem_name',width:'100px'},
	   		{name:'visitpagetitle',index:'visitpagetitle',hidden:true},
	   		{name:'user_ip',index:'user_ip',width:'80px'},
	   		{name:'block_name',index:'block_name',width:'100px',hidden:true},
	   		{name:'component_name',index:'component_name',width:'100px',hidden:true},
	   		{name:'site_name',index:'site_name',hidden:true},
	   		{name:'operate_module',index:'operate_module'},
	   		{name:'operate_type',index:'operate_type',width:'60px'},
	   		{name:'client_browser',index:'client_browser'},
	   		{name:'client_os',index:'client_os'}
	   	],
	   	rowNum:20,
	   	autowidth: true, 
	   	rowList:[20,30,40],
	   	pager: '#pager1',
	   	sortname: 'visit_time',
	    viewrecords: true,
	    sortorder: "asc",
	    caption:"监控信息"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	$("#visit_time").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
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
	//点击查看按钮查看详细信息
	$("#log_info").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var url="${_server_url!''}/portal/manager.system.logdetaildialog?log_id="+jQuery("#clist1").jqGrid('getRowData',id).log_id;
			window.showModalDialog(url,"","dialogWidth=600px;dialogHeight=500px");
		} else { alert("请选择一条记录!");}
	});
});
function emptied(obj){
	$("#visit_time").val("");
	$("#mem_name").val("");
	$("#site_name").val("");
	$("#component_name").val("");
	$("#visitpagetitle").val("");
	$("#block_name").val("");
	jQuery("#clist1").jqGrid('setGridParam',{url:"${_servlet_url!''}/manager.system.loglistdate"}).trigger("reloadGrid");
}
function gridReload(){
	var visit_time=$("#visit_time").val();
	var mem_name=$("#mem_name").val();
	var site_name=$("#site_name").val();
	var component_name=$("#component_name").val();
	var visitpagetitle=$("#visitpagetitle").val();
	var block_name=$("#block_name").val();
	var reason="${_servlet_url!''}/manager.system.loglistdate?visit_time="+visit_time+"&mem_name="+mem_name+"&site_name="+site_name+"&component_name="+component_name+"&visitpagetitle="+visitpagetitle+"&block_name="+block_name;
	jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI(reason),page:1}).trigger("reloadGrid");
}
function dodelete(){
   $("#dialog").dialog( "open" );
}
</script>
<div class="ui-widget ui-widget-content ui-corner-all" style="margin:2px;padding: .1em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;">监控中心</div>
</div>
<div style="padding:5px">
	<div class="skin_search">
		<form name="dialogform" id="dialogform" action="" style="margin:0px">
		<input type="hidden" id="site_name"  name="site_name" value=""/>
		<input type="hidden" id="block_name" name="block_name" value=""/>
			<div>
				时间:<input type="text" size="15" id="visit_time" name="visit_time" value=""/>
				用户名称:<input type="text" size="15" id="mem_name" name="mem_name" value=""/>
				组件名称:<select id="component_name" name="component_name">
						<option value="">请选择...</option>
						<option value="安全检查">安全检查</option>
						<option value="鉴定报告管理">鉴定报告管理</option>
						<option value="系统公共服务">系统公共服务</option>
					  </select>
				页面标题:<input type="text" size="15" id="visitpagetitle" name="visitpagetitle" value=""/>
				<button type="button" onclick="gridReload();">查询</button>
				<button type="button" onclick="emptied();">清空</button>
				<button type="button" id="log_info">查看详细信息</button>
			</div>		
		</form>
	</div>
	<div id="pager1"></div>
	<table id="clist1"></table>
</div>
<div id="dialog" title="时间段选择" style="display:none;height:200px;widht=470px;">
	<div class="ui-widget">
		<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
			<form name="deletefrom" id="deletefrom" action="">
				选择时间段:<input type="text" size="15" id="start_time" name="start_time" value=""/>-<input type="text" size="15" id="end_time" name="end_time" value=""/>&nbsp;&nbsp;
	       </form>
		</div>
	</div>
</div>