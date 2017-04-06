<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
[#assign term=accesslist.term]
[#assign role_id=term.role_id!""/]
[#assign role_name=term.role_name!""/]
[#if "${role_name}"==""][#assign role_name=system.return_info!''][/#if]
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
	$("#component_name").attr("readonly","true")
	.click(function(){
		var str=window.showModalDialog("${_servlet_url!''}/manager.component.list.dialog","","dialogWidth:450px;dialogHeight:300px");
		if(str!=null&&str!=undefined){
			$("#component_id").val(str[0]);
			$("#component_name").val(str[1]);
		}
	});
});

function gotopage(pageValue){
	document.moduleform.page.value=pageValue;
	document.moduleform.submit();
}
function emptiedAndSubmit(obj){
	$("#block_name","#"+obj).val("");
	$("#component_name","#"+obj).val("");
	$("#component_id","#"+obj).val("");
	$("#"+obj).submit();
}

function saveAccess(){
	var num=$("input[name=block_id]:checked").length;
	if(num>0)
		$("#accessform").submit();
	else
		alert("请选择要保存的栏目或组件");
}
function delAccess(){
	var num=$("input[name=block_id]:checked").length;
	if(num>0){
		var queryString=$("#accessform").formSerialize();
			$.post("${_servlet_url!''}/authclient.role.accessdelete",queryString,
				function(data,textStatus){
				var jdata=jQuery.parseJSON(data);
		    	if(jdata.success==1){
		    		alert("删除成功");
		    		$("#moduleform").submit();
		    	}else{
		    		alert("删除失败");
		    	}
			});
		
	}else
		alert("请选择要删除的栏目或组件");
}
function addAccess(){
	var url="${_servlet_url!''}/authclient.role.accessforinsert?role_id=${role_id}&role_name=${role_name}";
	window.showModalDialog(url,"","dialogWidth:1000px;dialogHeight:600px;center:1;");
	$("#moduleform").submit();	
}
function checkModule(obj){
	$("#"+obj).attr("checked",true);
}
</script>

<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif"  BORDER=0 ALT="" align="absmiddle"/>&nbsp;${system.action.action_name}--${role_name}
	</div>
	<div class="skin_search ui-widget-content" style="padding:.2em;">
	[#assign si=term.site_id!""/]
	<form name="moduleform" id="moduleform" action="${_servlet_url!''}/authclient.role.roleaccess" method="post">
<span>栏目名称：<input type="text" size="15" name="block_name" id="block_name" value="${term.block_name!''}"></span>
<span>组件名称：<input type="text" size="15" name="component_name" id="component_name" value=${term.component_name!''}>
<input type="hidden" name="component_id" id="component_id" value="${term.component_id!''}">
<input type="hidden" id="site_id" name="site_id" value="${si}"></span>
<input type="hidden" name="role_id" value="${role_id}">
<input type="hidden" name="role_name" value="${role_name}">
<button type="submit" class="ui-button ui-state-default ui-corner-all">查询</button>
<button type="button" onclick="emptiedAndSubmit('moduleform');" class="ui-button ui-state-default ui-corner-all">清空条件</button>
<input type="hidden" name="page">
	</form>
	</div>
	<div  id="buttons" style="text-align:right">
		[#if access.canDo(user,'manager.role.accessforinsert')]
		<button type="button"  onclick="addAccess()">添加</button>[/#if]
		[#if access.canDo(user,'manager.role.accessdelete')]
		<button type="button" onclick="delAccess()">删除</button>[/#if]
		[#if access.canDo(user,'manager.role.accesssave')]
		<button type="button"  onclick="saveAccess()">保存</button>[/#if]
		<button type="button" onclick="window.history.go(-1);">返回</button>
	</div>
	<div class="ui-widget-content"  style="position: relative;padding: .2em;">
	<form id="accessform" name="accessform" method="post" action="${_servlet_url!''}/manager.role.accesssave">
	<input type="hidden" name="role_id" value="${role_id}">
	<input type="hidden" name="role_name" value="${role_name}">
	<input type="hidden" id="site_id" name="site_id" value="${si}">
			<table  width="100%">
			<col width="30"><col width="60"><col width="170"><col width="80"><col>
			  <tr class="ui-widget-header">
			    <td width="30">选择</td>
				<td>栏目号</td>
			    <td>栏目/组件名</td>
			    <td>组件类型</td>
				<td>功能权限</td>
			  </tr>
			[#assign modulelist=accesslist.modulelist]  
			[#list modulelist as module]
			  <tr>
			    <td><input type="checkbox" name="block_id" id="${module.block_id!''}${module.component_id!''}" value="${module.block_id!''}#${module.component_id!''}">
			    	<input type="hidden" name="${module.block_id!''}_${module.component_id!''}_cid" value="${module.component_id!''}">
			    </td>
			    <td >${module.block_id!''}</td>
			    <td>${module.block_name!''}</td>
				<td>${module.component_name!''}</td>
			    <td>
			    [#assign functiongrouplist=module._attach]
			    [#list functiongrouplist as functiongroup]
			    [#assign checkid="${module.block_id!''}"+"${module.component_id!''}"]
			    <input type="checkbox" name="${module.block_id!''}_${module.component_id!''}_fg"
			    onclick="checkModule('${checkid}');" value="${functiongroup.group_id!''}" 
			    [#if "${functiongroup._internal_state!''}"="1"]checked[/#if]>${functiongroup.group_name}
			    [/#list]
			    </td>
			  </tr>
			[/#list]
			</table>
			</form>
			</div>
			<div class="mainbody_page">
			[#import "/WEB-INF/commonftl/util.ftl" as my/]
			[@my.pagebar currentpage=accesslist.page.currentpage totalpage=accesslist.page.totalpage totalnum=accesslist.page.totalnum/]
	</div>
	
</div>
