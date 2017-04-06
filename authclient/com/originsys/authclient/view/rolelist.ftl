<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
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
	   	url:'${_servlet_url!''}/authclient.role.listjson',
		datatype: "json",
		width:700,
		height:320,
	   	colNames:['角色ID','角色名称','站点ID','可申请','isrequest','是否审核','ischeck','前置角色','绑定用户类型','list-action','绑定企业类型','操作'],
	   	colModel:[
	   		{name:'role_id',index:'role_id',hidden:true,sortable:false},
	   		{name:'role_name',index:'role_name',sortable:false},
	   		{name:'site_id',index:'site_id',hidden:true,sortable:false},
	   		{name:'isrequestc',index:'isrequestc',sortable:false},	   
	   		{name:'isrequest',index:'isrequest',hidden:true,sortable:false},
	   		{name:'ischeckc',index:'ischeckc',sortable:false},		
	   		{name:'ischeck',index:'ischeck',hidden:true,sortable:false},
	   		{name:'pre_role_name',index:'pre_role_name',sortable:false},
	   		{name:'user_type',index:'user_type',sortable:false},
	   		{name:'list_action',index:'list_action',hidden:true},
	   		{name:'orgcom_type',index:'orgcom_type'},
	   		{name:'caozuo',index:'caozuo',sortable:false}	
	   	],
	   	rowNum:10,
	   	autowidth: true, 
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 'role_name',
	    viewrecords: true,
	    sortorder: "asc",
	    caption:"角色管理"
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
			height:180,
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

function memberMap(){
	var role_id=getSelRoleId();
	if(role_id=="")
		warn("请选择角色!");
	else{
		$("#hidform").attr("action","${_servlet_url!''}/authclient.role.memberlist");
		$("#hidform").submit();
	}
}
function usertypeList(){
	var role_id=getSelRoleId();
	if(role_id==""){
		warn("请选择角色！");
	}else{
		var id=jQuery("#clist1").jqGrid('getGridParam','selrow');
		var ret=jQuery("#clist1").jqGrid('getRowData',id);
		if(ret.user_type==""){
			warn("没有绑定用户类型！");
		}else{
			window.location=ret.list_action;
		}
	}
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

function emptiedAndSubmit(obj){
	$("#role_name1","#"+obj).val("");
	$("#site_name1","#"+obj).val("");
	$("#site_id1","#"+obj).val("");
	jQuery("#clist1").jqGrid('setGridParam',{url:"${_servlet_url!''}/authclient.role.listjson",page:1}).trigger("reloadGrid");
}
function doDel(obj){
	$.post(
		"manager.role.candelete",
		{"role_id":obj},
		function(data,textStatus){
			var jdata=jQuery.parseJSON(data);
			if(jdata.have_child=="1"){
				var rolename="";
				//alert(jdata.rolelist);
				//有子角色 列出子角色
				$.each(jdata.rolelist,function(entryIndex,entry){ 
					if(rolename=="")
						rolename=entry;
					else
						rolename=rolename+" "+entry;
				});
				warn("此角色包含以下子角色\r\n"+rolename+"\r\n请先删除或修改子角色");
			}else{
				//没有子角色，提示用户是否确认删除
				$("#delroleid").val(obj);
				$("#dialog-confirm").dialog("open");	
			}
		});	
}
function delinfo(){
		$.post("${_servlet_url!''}/authclient.role.delete?role_id="+$("#delroleid").val(),"",
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
			$("#site_id1","#moduleform").val(site_id);
			$("#site_name1").val(site_name);
		}
	}
}
function gridReload(){
	var role_name = $("#role_name1").val();
	var site_id=$("#site_id1").val();
	jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI("${_servlet_url!''}/authclient.role.listjson?role_name="+role_name+"&site_id="+site_id),page:1}).trigger("reloadGrid");
}
function doinsert(){
	var url="${_servlet_url!''}/authclient.role.fornew";
	window.showModalDialog(url,"","dialogWidth:700px;dialogHeight:500px;center:1;");
	jQuery("#clist1").trigger('reloadGrid');
} 
function doupdate(role_id){
	var url="${_servlet_url!''}//authclient.role.modify?role_id="+role_id;
	window.showModalDialog(url,"","dialogWidth:700px;dialogHeight:500px;center:1;");
	jQuery("#clist1").trigger('reloadGrid');
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
<span>所属站点：<input type="text" size="15" name="site_name" id="site_name1" value="" readonly onclick="selSite();">
<input type="hidden" id="site_id1" name="site_id" value=""></span>
<button type="button" onclick="gridReload();"  class="ui-button ui-state-default ui-corner-all">查询</button>
<button type="button" onclick="emptiedAndSubmit('moduleform');" class="ui-button ui-state-default ui-corner-all">清空条件</button>
	</form>
	</div>
	<div  id="buttons" style="text-align:right">
		[#if access.canDo(user,'manager.role.fornew')]
		<button type="button" onclick="doinsert();">添加</button>[/#if]
		[#if access.canDo(user,'manager.role.memberlist')]
		<button type="button"  onclick="memberMap()">对应用户</button>[/#if]
		<button type="button" onclick="usertypeList()">类型用户列表</button>
		[#if access.canDo(user,'manager.role.roleaccess')]
		<button type="button" onclick="accessMap()">对应权限</button>[/#if]
	</div>
<div id="pager1"></div>
<table id="clist1"></table>
</div>
<div id="dialog-confirm" title="确定要删除吗?">
	<p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>删除角色会同时删除扩展属性的定义以及用户角色的对应关系和用户的扩展属性,确认删除吗？</p>
<input type="hidden" id="delroleid">
</div>

<!--提示消息框-->
<div id="msg" class="ui-widget-content" style="padding: .2em;display:none">
<table width="100%" border="0" height="100%">
  <tr>
    <td align="center" valign="middle"></td>
  </tr>
</table>
</div>
