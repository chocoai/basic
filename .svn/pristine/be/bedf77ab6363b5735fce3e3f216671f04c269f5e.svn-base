<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
[#assign role_id=block.role_id]
[#assign role_name=block.role_name!""/]
[#assign organ_type=block.organ_type_id!'']
<style>
.ui-widget-header td{border-bottom:1px solid gray}
</style>
<script type="text/javascript">
$(document).ready(function() {
	$("#skin_search").find("button").each(function(){
		$(this).addClass("ui-button ui-state-default ui-corner-all").css("margin","2px").css("padding","2px");
	}).hover(
		function() {
			$(this).addClass("ui-state-hover");
		},
		function() {
			$(this).removeClass("ui-state-hover");
		}
	);
	$("#buttons").find("button").each(function(){
		$(this).addClass("ui-button ui-state-default ui-corner-all").css("margin","2px").css("padding","2px");
	}).hover(
		function() {
			$(this).addClass("ui-state-hover");
		},
		function() {
			$(this).removeClass("ui-state-hover");
		}
	);
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/authclient.role.memberlistjson?role_id=${role_id}&organ_type=${organ_type!''}',
		datatype: "json",
		width:700,
		height:320,
	   	colNames:['用户ID','姓名','登录名','注册时间','最后登录时间','用户角色状态'],
	   	colModel:[
	   		{name:'mem_id',index:'mem_id',hidden:true},
	   		{name:'user_name',index:'user_name'},
	   		{name:'mem_name',index:'mem_name'},
	   		{name:'register_time',index:'register_time'},	   
	   		{name:'last_time',index:'last_time'},
	   		{name:'user_state',index:'user_state'}
	   	],
	   	rowNum:10,
	   	autowidth: true, 
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 'user_name',
	    viewrecords: true,
	    sortorder: "asc",
	    multiselect:true,	   
	    caption:"角色对应用户管理"
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
		$("#clist1").jqGrid('setGridHeight', ss.WinH-160);
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
function doInsert(){
	var myObject = new Object();
	myObject.role_id = "${role_id}";	
	myObject.names="${block.havenames!''}";	
	var arr=window.showModalDialog("${_servlet_url!''}/authclient.user.roledialog",myObject,"dialogHeight:300px; dialogLeft:200px;");
	if(arr!=null&&arr!=undefined){
		[#if "${organ_type!''}"==""]
		var url="${_servlet_url!''}/authclient.memberrole.insert?role_id=${role_id}&mem_id="+arr+"&role_name=${role_name}";
		$.post(url,"",
			function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="1"){
						alert("用户增加成功!");
						jQuery("#clist1").trigger('reloadGrid');
						if(jdata.typeaction!="")
							window.showModalDialog("${_servlet_url!''}/"+jdata.typeaction,"","dialogWidth:500px;dialogHeight:500px");
					}else{
						alert("用户增加失败!");
					}
				});
		[/#if]
	}
}
function doDelete(){
	var selectedNum=0;
	var selectedId="";
	var id = jQuery("#clist1").jqGrid('getGridParam','selarrrow');
	if (id) {
		var ids=eval(id); 
		for(var x=0;x<id.length;x++){
			var ret = jQuery("#clist1").jqGrid('getRowData',ids[x]);
			selectedNum++;
			if(selectedId=="")
			selectedId=ret.mem_id;
			else
			selectedId+="|"+ret.mem_id;
		}
	}
	if(selectedNum>0){
		$("#mem_id").val(selectedId);
		$("#dialog-confirm").dialog("open");	
	}	
	else
		warn("请选择要删除的记录！");
}
function delinfo(){
		var queryString=$("#delform").formSerialize();
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
function changeState(obj){
	var selectedNum=0;
	var selectedId="";
	var id = jQuery("#clist1").jqGrid('getGridParam','selarrrow');
	if (id) {
		var ids=eval(id); 
		for(var x=0;x<id.length;x++){
			var ret = jQuery("#clist1").jqGrid('getRowData',ids[x]);
			selectedNum++;
			if(selectedId=="")
			selectedId=ret.mem_id;
			else
			selectedId+="|"+ret.mem_id;
		}
	}
	if(selectedNum>0){
		$("#mem_id").val(selectedId);
		$("#mem_state").val(obj);
		var queryString=$("#delform").formSerialize();
			$.post("${_servlet_url!''}/authclient.memberrole.changestate",queryString,
					function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="0"){
						alert("操作失败！");
					}else{
						alert("操作成功！");
						jQuery("#clist1").trigger("reloadGrid");
					}
			});
	}	
	else
		warn("请选择要操作的记录！");
}
function gridReload(){
	var mem_name = $("#mem_id1").val();
	var role_id=$("#role_id1").val();
	var role_name=$("#role_name1").val();
	jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI("${_servlet_url!''}/authclient.role.memberlistjson?role_id="+role_id+"&role_name="+role_name+"&mem_id="+mem_name+"&organ_type=${organ_type!''}"),page:1}).trigger("reloadGrid");
} 
</script>

<form id="delform" name="delform" method="post" action="${_servlet_url!''}/authclient.memberrole.delete">
<input type="hidden" name="role_id" id="role_id" value="${role_id}">
<input type="hidden" name="mem_id" id="mem_id" value="">
<input type="hidden" name="mem_state" id="mem_state">
<input type="hidden" name="role_name" value="${role_name}">
</form>
<div style="padding:5px">
	<div class="skin_search ui-widget-content" style="padding:.2em;">
	<form name="moduleform" id="moduleform" action="${_servlet_url!''}/authclient.role.memberlist?role_id=${role_id}" method="post">
	<input type="hidden" name="role_id" id="role_id1" value="${role_id}">
	<input type="hidden" name="role_name" id="role_name1" value="${role_name}">
	<span>姓名：<input type="text" size="15" id="mem_id1" name="mem_id" value=""></span>
	<button type="button" onclick="gridReload();"  class="ui-button ui-state-default ui-corner-all">查询</button>
	</form>
	</div>
	<div  id="buttons" style="text-align:right">
		[#if "${organ_type!''}"==""]
		[#if access.canDo(user,'manager.memberrole.insert')]
		<button type="button" onclick="doInsert()">添加</button>[/#if]
		[#if access.canDo(user,'manager.memberrole.delete')]
		<button type="button" onclick="doDelete()">删除</button>[/#if]
		[#if access.canDo(user,'manager.memberrole.changestate')]
		<button type="button"  onclick="changeState('3')">禁用</button>
		<button type="button"  onclick="changeState('1')">解除禁用</button>[/#if]
		[/#if]
		<button type="button" onclick="window.location='${_servlet_url!''}/authclient.role.list'">返回</button>
	</div>
<div id="pager1"></div>
<table id="clist1"></table>
</div>
<div id="dialog-confirm" title="确定要删除吗?">
	<p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>删除用户角色对应关系会同时删除用户的扩展属性,确定要删除选中用户的对应关系？</p>
</div>

<!--提示消息框-->
<div id="msg" class="ui-widget-content" style="padding: .2em;display:none">
<table width="100%" border="0" height="100%">
  <tr>
    <td align="center" valign="middle"></td>
  </tr>
</table>
</div>