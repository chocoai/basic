<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	//删除弹出框
	$("#delete-dialog").dialog({
		autoOpen: false,
      	height: 200,
      	width: 470,
      	modal: true,
        buttons: {
        	'确定': function() {
        		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
				var ret = jQuery("#clist1").jqGrid('getRowData',id);
				$.post("${_servlet_url!''}/auth.userRoledelete?roleid="+ret.role_id+"&mem_id=${block.mem_id!''}","",function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success==1){
						jQuery("#clist1").trigger('reloadGrid');
						$("#delete-dialog").dialog("close");
					}else{
						jQuery("#clist1").trigger('reloadGrid');
						$("#delete-dialog").dialog("close");
						alert("删除失败!!");
					}
				});
			},
			'取消': function() {
				$(this).dialog("close");
			}
		}
	});
	//表格
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/auth.userRolelistdata?com_id=${user.orgcom_id!''}&mem_id=${block.mem_id!''}',
		datatype: "json",
		width:600,
		height:300,
	   		colNames:[
				"role_register_id"
			,
				"角色id"
			,
				"站点"
			,
				"角色名"
			,
				"备注"
			,
				"需审核"
			,
				"前置角色"
			,
				"审核地址"
			
	   	],
	   	colModel:[
				{name:'role_register_id',index:'role_register_id',sortable:true,hidden:true}
			,
				{name:'role_id',index:'role_id',sortable:true,width:10}
			,
				{name:'site_id',index:'site_id',sortable:true,width:10,hidden:true}
			,
				{name:'role_name',index:'role_name',sortable:true,width:10}
			,
				{name:'role_description',index:'role_description',sortable:true,width:10}
			,
				{name:'ischeck',index:'ischeck',sortable:true,width:10,hidden:true}
			,
				{name:'preposition_role',index:'preposition_role',sortable:true,width:10,hidden:true}
			,
				{name:'check_url',index:'check_url',sortable:true,width:10,hidden:true}
			
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 
				'roleid'
		,
	    viewrecords: true,
	    sortorder: "asc",
	    rownumbers:true,
	    caption:"${block.user_name!''}用户角色对应列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	//删除
	$("#deleteInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) {
			//打开对话框
			$("#delete-dialog").dialog( "open" );
		}else{
			alert("请选择一条记录！");
		}
	});
	//模糊查询
	jQuery("#gridReload").click(function() {
		var url="${_servlet_url!''}/auth.userRolelistdata?com_id=${user.orgcom_id!''}&mem_id=${block.mem_id!''}"
						+"?site_id="+$("#site_id_select").val()
						
						+"&mem_id="+$("#mem_id_select").val()
						
						+"&mem_state="+$("#mem_state_select").val()
						
						+"&com_id="+$("#com_id_select").val()
						
						+"&role_register_id="+$("#role_register_id_select").val()
						;
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2}).trigger("reloadGrid");
	});
});
function addRole(){
	var str=window.showModalDialog("${_servlet_url!''}/auth.userroledialog","","dialogHeight:500px; dialogLeft:400px;");
	if(str!=null&&str!=""&&str!=undefined){
			$.post("${_servlet_url!''}/auth.userRoleadd?mem_id=${block.mem_id!''}&role_reg_id="+str,"",
			function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success==1){
						jQuery("#clist1").trigger('reloadGrid');
						alert("角色增加成功!");
					}else{
						jQuery("#clist1").trigger('reloadGrid');
						alert("角色增加失败!");
					}
				});
	}
}
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
<!-- div class="skin_search ui-widget-content" style="padding:.2em;margin-bottom:8px;">
	<form name="dic_form" id="dic_form" action="" method="post">
				<span>站点:</span><span><input type="text" size="15" name="site_id_select" id="site_id_select"/></span>
				<span>用户id:</span><span><input type="text" size="15" name="mem_id_select" id="mem_id_select"/></span>
				<span>用户状态:</span><span><input type="text" size="15" name="mem_state_select" id="mem_state_select"/></span>
				<span>该角色所属的企业:</span><span><input type="text" size="15" name="com_id_select" id="com_id_select"/></span>
				<span>角色注册id:</span><span><input type="text" size="15" name="role_register_id_select" id="role_register_id_select"/></span>
		<button type="button" id="gridReload">查询</button>&nbsp;
	</form>
</div -->
<div  id="buttons" style="text-align:right;margin-bottom:8px;">
		<button type="button" id="addInfo" align="right" onclick="addRole();">增加</button>
		<button type="button" id="deleteInfo" align="right">删除</button>
		<button type="button" onclick="history.go(-1);" align="right">返回</button>
</div>
<div id="pager1"></div>
<table id="clist1"></table>
<div id="dialog" title="增加用户角色对应列表" style="display:none">
	<form class="cmxform" style="margin:0" action="${_servlet_url!''}/auth.userRoleadd" method="post" id="addForm">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a6cef2">
					<tr id="hid1" style="display:block">
						<td class="td2" align="right" style="padding-right:2px">站点</td>
						<td class="td3" style="padding-left:2px">
							<input type="text" name="site_id" id="site_id" class="required" style="width:200px"/>
						</td>
					</tr>
					<tr id="hid1" style="display:block">
						<td class="td2" align="right" style="padding-right:2px">用户id</td>
						<td class="td3" style="padding-left:2px">
							<input type="text" name="mem_id" id="mem_id" class="required" style="width:200px"/>
						</td>
					</tr>
					<tr id="hid1" style="display:block">
						<td class="td2" align="right" style="padding-right:2px">该角色所属的企业</td>
						<td class="td3" style="padding-left:2px">
							<input type="text" name="com_id" id="com_id" class="required" style="width:200px"/>
						</td>
					</tr>
		</table>
	</form>
</div>
<div id="delete-dialog" title="删除记录" style="display:none;height:200px;widht=470px;">
	<div class="ui-widget">
		<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
			<p>
			<span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span>
			<strong>确定删除该信息?</strong>
			</p>
		</div>
	</div>
</div>