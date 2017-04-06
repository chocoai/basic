<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<style>
.ui-widget-header td{border-bottom:1px solid gray}
</style>
<script type="text/javascript">
$(document).ready(function() {
	$("#skin_search button").addClass("ui-button ui-state-default ui-corner-all").css("margin","2px").css("padding","2px")
	.hover(
		function() {
			$(this).addClass("ui-state-hover");
		},
		function() {
			$(this).removeClass("ui-state-hover");
		}
	);
	$("#buttons button").addClass("ui-button ui-state-default ui-corner-all").css("margin","2px").css("padding","2px")
	.hover(
		function() {
			$(this).addClass("ui-state-hover");
		},
		function() {
			$(this).removeClass("ui-state-hover");
		}
	);
	
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/manager.user.rolelistjson?mem_id=${block.mem_id!''}',
		datatype: "json",
		width:700,
		height:300,
	   	colNames:['角色ID','角色名称', '站点ID','角色描述','状态','用户类型',''],
	   	colModel:[
	   		{name:'role_id',index:'role_id',hidden:true},
	   		{name:'role_name',index:'role_name'},
	   		{name:'site_id',index:'site_id',hidden:true},	
	   		{name:'role_description',index:'role_description'},	
	   		{name:'role_state',index:'role_state'},
	   		{name:'user_type',index:'user_type'},
	   		{name:'caozuo',index:'caozuo',sortable:false}
	   	],
	   	rowNum:10,
	   	autowidth:true,  
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 'role_id',
	    viewrecords: true,
	    sortorder: "asc",
	    caption:"[${block.user_name!''}] 的角色"
	});
	
	//设置表格高度
    var ss = getPageSize();
    $("#clist1").jqGrid('setGridHeight', ss.WinH-120);
    
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
		//$("#clist1").jqGrid('setGridWidth', ss.WinW-2);
		$("#clist1").jqGrid('setGridWidth', ss.WinW-15);
		$("#clist1").jqGrid('setGridHeight', ss.WinH-160);
	} 
	

	 	 //消息提示框
	$('#msg').dialog({
		title:'提示信息',
		width: 200,
		height:150,
		autoOpen: false,
		modal: true,
		buttons: [
	    {
	        text: "确定",
	        click: function() { $(this).dialog("close"); }
	    }
	]
	});	
	//删除确认用对话框
	$("#dialog-confirm").dialog({
			resizable: false,
			height:150,
			autoOpen: false,
			modal: true,
			buttons: {
				'确定删除': function() {
					$(this).dialog('close');
					delinfo();
				},
				'取消': function() {
					$(this).dialog('close');
				}
			}
		});
});
	//弹出消息框函数
	function warn(msg){
		$('td',$('#msg')).text(msg);
		$('#msg').dialog("open");
		
	}
function getSelRoleId(){
	var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
	if (id) { 
		var ret = jQuery("#clist1").jqGrid('getRowData',id);
		$("#role_id").val(ret.role_id);
		$("#role_name").val(ret.role_name);
		return ret.role_id;
	}else
		return "";
}
function emptiedAndSubmit(obj){
	$("#role_name","#"+obj).val("");
	$("#site_name","#"+obj).val("");
	$("#site_id","#"+obj).val("");
	$("#"+obj).submit();
}
function doDelete(){
	var role_id=getSelRoleId();
	if(role_id==""){
		warn("请选择用户角色");
		return false;
	}else{
		$("#dialog-confirm").dialog("open");	
	}	
}
function delinfo(){
			var queryString=$("#hidform").formSerialize();
			$.post("${_servlet_url!''}/authclient.memberrole.delete",queryString,
					function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="0"){
						alert("删除失败！");
					}else{
						alert("删除成功！");
						jQuery("#clist1").trigger("reloadGrid");
					}
			});
}	
function selSite(){
	var arr=window.showModalDialog("${_servlet_url!''}/manager.site.listdialog","","dialogWidth:500px;dialogHeight:500px");
	if(arr!=null&&arr!=undefined){
		if(arr.length==2){
			var site_id=arr[0];
			var site_name=arr[1];
			$("#site_id","#moduleform").val(site_id);
			$("#site_name").val(site_name);
		}
	}
}
function changeState(obj){
	var role_id=getSelRoleId();
	if(role_id==""){
		warn("请选择用户角色");
		return false;
	}else{
		$("#mem_state").val(obj);		
		var queryString=$("#hidform").formSerialize();
			$.post("${_servlet_url!''}/authclient.memberrole.changestate",queryString,
					function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="0"){
						alert("禁用/解除禁用失败！");
					}else{
						alert("禁用/解除禁用成功！");
						jQuery("#clist1").trigger("reloadGrid");
					}
			});
	}
}
function addRole(){	
	var arr=window.showModalDialog("${_servlet_url!''}/authclient.user.rolelistdialog?mem_id=${block.mem_id!''}","","dialogWidth:500px;dialogHeight:300px");
	if(arr!=null&&arr!=undefined){
		$("#role_id").val(arr);
		var queryString=$("#hidform").formSerialize();
			$.post("${_servlet_url!''}/authclient.memberrole.insert",queryString,
					function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="0"){
						alert("保存失败！");
					}else{
						alert("保存成功！");
						jQuery("#clist1").trigger("reloadGrid");
						if(jdata.typeaction!="")
							window.showModalDialog("${_servlet_url!''}/"+jdata.typeaction,"","dialogWidth:800px;dialogHeight:600px");
					}
			});
	}
}
function modifyTypeInfo(type){
	window.showModalDialog("${_servlet_url!''}/"+type+"?mem_id=${block.mem_id!''}","","dialogWidth:800px;dialogHeight:600px;center:1;");
	//window.location="${_servlet_url!''}/"+type+"?mem_id=${block.mem_id!''}";
}
</script>

<form id="hidform" method="post">
<input type="hidden" name="forward" value="manager.user.rolelist">
<input type="hidden" id="mem_state" name="mem_state">
<input type="hidden" id="role_id" name="role_id">
<input type="hidden" id="role_name" name="role_name">
<input type="hidden" name="flag" value="1">
<input type="hidden" id="mem_id" name="mem_id" value="${block.mem_id!''}">
<input type="hidden" id="user_name" name="user_name" value="${block.user_name!''}">
</form>

<div >
	<div class="skin_search ui-widget-content" style="padding:.2em;">
	<form name="moduleform" id="moduleform" action="${_servlet_url!''}/authclient.user.rolelist" method="post">
        <input type="hidden" id="mem_id" name="mem_id" value="}">
        <input type="hidden" id="user_name" name="user_name" value="}">	
        <span>角色名称：<input type="text" size="15" name="role_name" id="role_name" value=""></span>
        <!--span>所属站点：<input type="text" size="15" name="site_name" id="site_name" value="" readonly onclick="selSite();">
        <input type="hidden" id="site_id" name="site_id" value=""></span-->
        <button type="button" onclick="submit();"  class="ui-button ui-state-default ui-corner-all">查询</button>
        <button type="button" onclick="emptiedAndSubmit('moduleform');" class="ui-button ui-state-default ui-corner-all">清空条件</button>
	</form>
	</div>
	
	<div  id="buttons" style="text-align:right">
		[#if access.canDo(user,'authclient.memberrole.insert')]
		<button type="button" onclick="addRole()">添加角色</button>[/#if]
		[#if access.canDo(user,'authclient.memberrole.delete')]
		<button type="button" onclick="doDelete()">删除角色</button>[/#if]
		[#if access.canDo(user,'authclient.memberrole.changestate')]
		<button type="button" onclick="changeState('3')">禁用</button>
		<button type="button" onclick="changeState('1')">解除禁用</button>[/#if]		
		<button type="button" onclick="window.location='${_servlet_url!''}/authclient.admin.userlist'">返回</button>
	</div>
	<div id="pager1"></div>
	<table id="clist1"></table>		
</div>

<div id="dialog-confirm" title="确定要删除吗?">
	<p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>确定要删除选中用户的所选角色吗？</p>
</div>

<!--提示消息框-->
<div id="msg" class="ui-widget-content" style="padding: .2em;display:none">
<table width="100%" border="0" height="100%">
  <tr>
    <td align="center" valign="middle"></td>
  </tr>
</table>
</div>