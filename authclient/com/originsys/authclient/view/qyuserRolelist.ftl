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
				$.post("${_servlet_url!''}/authclient.qyuser.roledelete?roleid="+ret.role_id+"&mem_id=${block.mem_id!''}","",function(data,textStatus){
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
	   	url:'${_servlet_url!''}/authclient.qyuser.rolelistdata?mem_id=${block.mem_id!''}',
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
			,""
			
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
			,  {name:'role_op',index:'role_op',width:10}
			
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
});
function addRole(){
	var str=window.showModalDialog("${_servlet_url!''}/authclient.qyuser.roledialog","","dialogHeight:500px; dialogLeft:400px;");
	if(str!=null&&str!=""&&str!=undefined){
			var rolestr=str.split("#");
			var rowIds = jQuery("#clist1").jqGrid('getDataIDs');
			var flag=false;
			$.each(rowIds,function(n,value) {  
				var ret = jQuery("#clist1").jqGrid('getRowData',value);
				if(rolestr[0]==ret.role_register_id)
	            	flag=true;
            }); 
            if(flag){
            	alert("用户已有该角色！");
            	return false;
            }
			$.post("${_servlet_url!''}/authclient.qyuser.roleadd?mem_id=${block.mem_id!''}&role_reg_id="+rolestr[0]+"&role_id="+rolestr[1],"",
			function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="1"){
						if(jdata.typeaction!=""){
							window.showModalDialog(jdata.typeaction,"","dialogWidth:600px;dialogHeight:500px;center:1;");
							jQuery("#clist1").trigger('reloadGrid');
						}
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
function modifyTypeInfo(type){
	window.showModalDialog("${_servlet_url!''}/"+type+"?mem_id=${block.mem_id!''}","","dialogWidth:600px;dialogHeight:500px;center:1;");
}
</script>
<div  id="buttons" style="text-align:right;margin-bottom:8px;">
		<button type="button" id="addInfo" align="right" onclick="addRole();">增加</button>
		<button type="button" id="deleteInfo" align="right">删除</button>
		<button type="button" onclick="history.go(-1);" align="right">返回</button>
</div>
<div id="pager1"></div>
<table id="clist1"></table>

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