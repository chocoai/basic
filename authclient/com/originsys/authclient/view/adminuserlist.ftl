<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/card.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/messages_cn.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/swfobject.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="${_share_file_url!''}/resource/css/cmxform.css" />
<script type="text/javascript" language="javascript">
$(function(){
	//表格
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/authclient.admin.userlistjson',
		datatype: "json",
		width:600,
		height:300,
	   	colNames:[
				"mem_id"
			,
				"姓名"
			,
				"登录名"
			,
				"性别"
			,
				"生日"
			,
				"邮址"
			,
				"手机"
			,
				"注册时间"
			,
				"最后登录时间"
			,
				"用户状态"	
			
	   	],
	   	colModel:[
				{name:'mem_id',index:'mem_id',sortable:true,hidden:true}
			,
				{name:'family_name',index:'family_name',sortable:true,width:10}
			,
				{name:'mem_name',index:'mem_name',sortable:true,width:10}
			,
				{name:'mem_sex',index:'mem_sex',sortable:true,width:10}
			,
				{name:'mem_born',index:'mem_born',sortable:true,hidden:true}
			,
				{name:'mem_mail',index:'mem_mail',sortable:true,width:10}
			,
				{name:'mem_mphone',index:'mem_mphone',sortable:true,width:10}
			,
				{name:'register_time',index:'register_time',sortable:true,width:10}
			,
				{name:'last_time',index:'last_time',sortable:true,width:10}
			,
				{name:'mem_state',index:'mem_state',sortable:true,width:10}	
			
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 
				'mem_id'
		,
	    viewrecords: true,
	    sortorder: "asc",
	    rownumbers:true,
	    caption:"用户列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	//更新
	$("#updateInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			var url="${_servlet_url!''}/auth.userInfomodify?mem_id="+ret.mem_id;
			window.showModalDialog(url,"","dialogWidth:550px;dialogHeight:550px;center:1;");
			jQuery("#clist1").trigger('reloadGrid');
		}else{
			alert("请选择一条记录！");
		}
	});
	//模糊查询
	jQuery("#gridReload").click(function() {
		var url="${_servlet_url!''}/authclient.admin.userlistjson"
						+"?family_name="+$("#family_name_select").val()
						+"&mem_sex="+$("#mem_sex_select").val()
						+"&mem_state="+$("#mem_state_select").val()
						+"&mem_name="+$("#mem_name_select").val()
						;
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2}).trigger("reloadGrid");
	});
	//日期选择:
			$("#mem_born").attr("readonly", "true").datepicker({changeMonth: true,changeYear: true, yearRange: '-100:-18',dateFormat:"yy-mm-dd"});
			$("#mem_born_select").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
			$("#register_time").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
			$("#register_time_select").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
			$("#last_time").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
			$("#last_time_select").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
	//增加按钮
	$("#addInfo").click(function(){
		var url="${_servlet_url!''}/auth.userInfoforadd";		
		window.showModalDialog(url,"","dialogWidth:550px;dialogHeight:550px;center:1;");
		jQuery("#clist1").trigger('reloadGrid');
	});
	
	//增加按钮
	$("#dialogresetPass").dialog({
		resizable:false,
		height:300,
		width:440,
		autoOpen:false,
		modal:true,
		buttons:{
			'取消':function(){
				$(this).dialog('close');
			},
			'确定':function(){
				$("#resetForm").submit();
			}
		}
	});
	//对增加的内容进行验证
	$("#resetForm").validate({
		rules: {
			mem_pass:{
				required:true,
				minlength: 6
			}
		},
		messages: {
			mem_pass:{
				required:"请输入密码",
				minlength: "密码至少6位"
			}
		},
		submitHandler:function(form){
			var queryString=$("#resetForm").formSerialize();
			$.post($("#resetForm").attr("action"),queryString,
				function(data,textStatus){
				var jdata=jQuery.parseJSON(data);
		    	if(jdata.success==1){
		    		alert("更新成功");
		    		$("#dialogresetPass").dialog('close');
		    	}else{
		    		alert("更新失败");
		    		$("#dialogresetPass").dialog('close');
		    	}
			});
		}
	});
});
function toRoles(){
	var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
	if (id) { 
		var ret = jQuery("#clist1").jqGrid('getRowData',id);
		window.location="${_servlet_url!''}/authclient.user.rolelist?mem_id="+ret.mem_id+"&user_name="+encodeURI(ret.family_name);
	}
	else
		warn("请选择一条记录修改！");
}
function reset_pass(){
	var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
	if (id) { 
		var ret = jQuery("#clist1").jqGrid('getRowData',id);
		$("#rmem_id").val(ret.mem_id);
		$("#name1").val(ret.family_name);
		$("#name2").val(ret.mem_name);
		$("#dialogresetPass").dialog('open');
    }
	else
		alert("请选择一条记录修改！");
}
function addr1(){
	var addr=window.showModalDialog("commonservice.region?pid=086","","dialogWidth=350px;dialogHeight=400px");
	if(addr!=undefined){
		$("#mem_region").val(addr[0]);
		$("#mem_region_name").val(addr[1]);
	}
}
function emptiedAndSubmit(obj){
	$("#family_name_select").val("");
	$("#mem_name_select").val("");
	$("#mem_sex_select option").get(0).selected=true;
	$("#mem_state_select option").get(0).selected=true;
	var url="${_servlet_url!''}/authclient.admin.userlistjson";
	var url2 = encodeURI(url);
	jQuery("#clist1").jqGrid('setGridParam',{url:url2}).trigger("reloadGrid");
}
function chengeBirthday(){
	var code=$("#ID_num").val();
	if(code=="")
		return false;
	var year =  code.substring(6,10);   
    var month = code.substring(10,12);   
    var day = code.substring(12,14); 
    var born=year+"-"+month+"-"+day;
    if(born!="--")
    	$("#mem_born").val(year+"-"+month+"-"+day); 
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
<style>
.rightpad{text-align:right;padding-right:7px;background-color:#F2F9FF;}
.leftpad{padding-left:2px;background-color:#FFFFFF;}
</style>
<div class="skin_search ui-widget-content" style="padding:.2em;margin-bottom:8px;">
	<form name="dic_form" id="dic_form" action="" method="post">
				<span>姓名:</span><span><input type="text" size="15" name="family_name_select" id="family_name_select"/></span>
				<span>登录名:</span><span><input type="text" size="15" name="mem_name_select" id="mem_name_select"/></span>
				<span>性别:</span><span>
				<select name="mem_sex_select" id="mem_sex_select"/>
				<option value="">全部</option>
				[#list EnumService.getEnum('sex') as enum]
				<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
				[/#list]
				</select>
				</span>
				<span>用户状态:</span><span>
				<select name="mem_state_select" id="mem_state_select">
				<option value="">全部</option>
				<option value="1">正常</option>
				<option value="0">禁用</option>
				</select>
				</span>
		<button type="button" id="gridReload">查询</button>&nbsp;
		<button type="button" onclick="emptiedAndSubmit(this);" class="ui-button ui-state-default ui-corner-all">清空条件</button>&nbsp;
	</form>
</div>
<div  id="buttons" style="text-align:right;margin-bottom:8px;">
		<!--button type="button" id="addInfo" align="right">增加</button-->
		<!-- button type="button" id="updateInfo" align="right">修改</button -->
		<button type="button" onclick="toRoles()">对应角色</button>
		<button type="button" onclick="reset_pass();">修改密码</button>
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
<div id="dialogresetPass" title="修改用户密码" style="display:none">
	<form class="cmxform" style="margin:0" action="${_servlet_url!''}/authclient.resetpass" method="post" id="resetForm">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" style="table-layout:fixed;line-height:30px;">
		<col width="100px"/><col />
		<tr>
			<td class="rightpad">姓名</td>
			<td class="leftpad">
				<input type="hidden" name="mem_id" id="rmem_id">
				<input type="text" id="name1" readonly="true">
			</td>
		</tr>
		<tr>
			<td class="rightpad">用户名</td>
			<td class="leftpad">
			<input type="text" id="name2" readonly="true">
			</td>
		</tr>
		<tr>
			<td class="rightpad"><font color="red">*</font>新登录密码</td>
			<td class="leftpad">
				<input type="text" name="mem_pass" id="mem_pass" value=""/>
			</td>
		</tr>
		</table>
	</form>
</div>