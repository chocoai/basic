<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	$("#reg_date").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
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
				$.post("${_servlet_url!''}/auth.orgcomdelete?organ_id="+ret.organ_id,"",function(data,textStatus){
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
	   	url:'${_servlet_url!''}/auth.orgcomlistdata',
		datatype: "json",
		width:600,
		height:300,
	   	colNames:[
				"单位ID"
			,"单位名称","组织机构代码","organ_region","所属行政区","联系人","通信地址"
			
			,
				"电话"
			,
				"邮政编码"
			,
				"域名｜ip"
			,
				"行业"
			,
				"企业类型"
			,
				"组织简介"
			,
				"组织类型"
			,
				"员工人数"
			
			,
				"组织证件类型"
			,
				"组织证件号码"
			,	"单位类型"	
			,
				"认证状态代码","认证状态"
			,
				"第二域名","注册时间"
			
	   	],
	   	colModel:[
				{name:'organ_id',index:'organ_id',sortable:true,width:10}
			,
				{name:'organ_name',index:'organ_name',sortable:true,width:10}
				,
				{name:'organ_code',index:'organ_code',sortable:true,width:10}
			,
				{name:'organ_region',index:'organ_region',sortable:true,width:10,hidden:true}
				,
				{name:'organ_region_name',index:'organ_region_name',sortable:true,width:10}
			
			,
				{name:'organ_linkman',index:'organ_linkman',sortable:true,width:10}
				,
				{name:'organ_address',index:'organ_address',sortable:true,width:10,hidde:true}
			,
				{name:'organ_phone',index:'organ_phone',sortable:true,width:10,hidde:true}
			,
				{name:'organ_postcode',index:'organ_postcode',sortable:true,width:10,hidden:true}
			,
				{name:'organ_domainname',index:'organ_domainname',sortable:true,width:10,hidden:true}
			,
				{name:'organ_trade',index:'organ_trade',sortable:true,width:10,hidden:true}
			,
				{name:'com_type',index:'com_type',sortable:true,width:10,hidden:true}
			,
				{name:'organ_desc',index:'organ_desc',sortable:true,width:10,hidden:true}
			,
				{name:'organ_type',index:'organ_type',sortable:true,width:10,hidden:true}
			,
				{name:'organ_staff_number',index:'organ_staff_number',sortable:true,width:10,hidden:true}
			
			,
				{name:'organ_cred_type',index:'organ_cred_type',sortable:true,width:10,hidden:true}
			,
				{name:'organ_cred_code',index:'organ_cred_code',sortable:true,width:10,hidden:true}
			,{name:'typelist1',index:'typelist1',width:10}
			,{name:'authentication_state',index:'authentication_state',sortable:true,width:10,hidden:true}
			,{name:'authentication_state1',index:'authentication_state1',sortable:true,width:10}
			,
				{name:'organ_domainname2',index:'organ_domainname2',sortable:true,width:10,hidden:true}
			,{name:'reg_date',index:'reg_date',sortable:true,width:10}
			
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[30,50],
	   	pager: '#pager1',
	   	sortname:'reg_date',
	    viewrecords: true,
	    sortorder: "asc",
	    rownumbers:true,
	    caption:"单位列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	//查看详细
	$("#selectInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			var url="${_servlet_url!''}/auth.orgcomdetail?organ_id="+ret.organ_id;	
			window.showModalDialog(url,"","dialogWidth:900px;dialogHeight:600px;center:1;");
		}else{
			alert("请选择一条记录！");
		}
	});
	//更新
	$("#updateInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			window.showModalDialog("${_servlet_url!''}/auth.orgcommodify?organ_id="+ret.organ_id,"","dialogWidth:900px;dialogHeight:600px;center:1;");
			jQuery("#clist1").trigger('reloadGrid');
		}else{
			alert("请选择一条记录！");
		}
	});
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
		var url="${_servlet_url!''}/auth.orgcomlistdata"
						+"?organ_name="+$("#organ_name_select").val()
						+"&organ_code="+$("#organ_code_select").val()
						+"&authentication_state="+$("#authentication_state").val()
						+"&reg_date="+$("#reg_date").val();
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2}).trigger("reloadGrid");
	});
	//增加按钮
	$("#addInfo").click(function(){
		var url="${_servlet_url!''}/auth.orgcomadd";		
		window.showModalDialog(url,"","dialogWidth:900px;dialogHeight:600px;center:1;");
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
			organ_pass:{
				required:true,
				minlength: 6
			}
		},
		messages: {
			organ_pass:{
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
function forcheck(){
	var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			window.showModalDialog("${_servlet_url!''}/auth.orgcomcheck?organ_id="+ret.organ_id,"","dialogWidth=900px;dialogHeight=600px");
			jQuery("#clist1").trigger('reloadGrid');
		}else{
			alert("请选择一条记录！");
		}
}
function reset_pass(){
	var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
	if (id) { 
		var ret = jQuery("#clist1").jqGrid('getRowData',id);
		$("#rorgan_id").val(ret.organ_id);
		$("#name1").val(ret.organ_id);
		$("#name2").val(ret.organ_name);
		$("#dialogresetPass").dialog('open');
    }
	else
		alert("请选择一条记录修改！");
}
function emptiedAndSubmit(obj){
	$("#organ_name_select").val("");
	$("#organ_code_select").val("");
	$("#authentication_state option").get(0).selected=true;
	$("#reg_date").val("");
	var url="${_servlet_url!''}/auth.orgcomlistdata";
	var url2 = encodeURI(url);
	jQuery("#clist1").jqGrid('setGridParam',{url:url2}).trigger("reloadGrid");
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
<div class="skin_search ui-widget-content" style="padding:.2em;margin-bottom:8px;">
	<form name="dic_form" id="dic_form" action="" method="post">
			<span>名称:</span><span><input type="text" size="15" name="organ_name_select" id="organ_name_select"/></span>
			<span>组织机构代码证号:</span><span><input type="text" size="15" name="organ_code_select" id="organ_code_select"/></span>
			<span>认证状态:</span>
			<span>
			<select id="authentication_state" name="authentication_state">
				<option value=""></option>
				<option value="1">通过</option>
				<option value="0">未通过</option>
			</select>
			</span>
			<span>注册时间:<input type="text" id="reg_date" readonly="true"></span>
		<button type="button" id="gridReload">查询</button>&nbsp;
		<button type="button" onclick="emptiedAndSubmit(this);" class="ui-button ui-state-default ui-corner-all">清空条件</button>&nbsp;
	</form>
</div>
<div  id="buttons" style="text-align:right;margin-bottom:8px;">
	<button type="button" id="addInfo" align="right">增加</button>
	<button type="button" id="updateInfo" align="right">修改</button>
	<button type="button" id="selectInfo" align="right">查看详细</button>
	<button type="button" align="right" onclick="forcheck();">认证</button>
	<button type="button" id="deleteInfo" align="right">删除</button>
	<!-- button type="button" onclick="reset_pass()">重置密码</button -->
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
	<form class="cmxform" style="margin:0" action="${_servlet_url!''}/auth.resetorganpass" method="post" id="resetForm">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" style="table-layout:fixed;line-height:30px;">
		<col width="100px"/><col />
		<tr>
			<td class="rightpad">单位ID</td>
			<td class="leftpad">
				<input type="hidden" name="organ_id" id="rorgan_id">
				<input type="text" id="name1" readonly="true">
			</td>
		</tr>
		<tr>
			<td class="rightpad">单位法定全称</td>
			<td class="leftpad">
			<input type="text" id="name2" readonly="true">
			</td>
		</tr>
		<tr>
			<td class="rightpad"><font color="red">*</font>新登录密码</td>
			<td class="leftpad">
				<input type="text" name="organ_pass" id="organ_pass" value=""/>
			</td>
		</tr>
		</table>
	</form>
</div>