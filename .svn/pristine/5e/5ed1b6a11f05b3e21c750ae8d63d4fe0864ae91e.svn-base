[#assign term=role.term]
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
	[#if term.haveroles?exists]
		[#assign allroles=term.haveroles!'']
		$("#haveroles").val("${allroles}");
	[#else]
		var oMyObject = window.dialogArguments;	
		if(oMyObject!=null&&oMyObject!=undefined){
			var names=oMyObject.roles;
			$("#haveroles").val(names);
		}
	[/#if]
});
function gotopage(pageValue){
	document.moduleform.page.value=pageValue;
	document.moduleform.submit();
}
function emptiedAndSubmit(obj){
	$("#role_name","#"+obj).val("");
	$("#site_name","#"+obj).val("");
	$("#site_id","#"+obj).val("");
	$("#"+obj).submit();
}

function save(){
		var selectedNum=0;
		var selectedId="";
		var hpreid="";
		$("input[type=radio]").each(function(){
		if($(this).attr("checked")){
			selectedNum=selectedNum+1;
			selectedId=$(this).val();
			hpreid=$(this).nextAll(":input[name=hpreid]").val();
		}
		});
		var names=$("#haveroles").val();
		if(selectedNum==1){
			var isHave=false;
			for(i=0;i<names.split(",").length;i++){
				if(names.split(",")[i]==selectedId){
					isHave=true;
				}
			}
			if(isHave){
				alert("该用户已拥有该角色，请选择别的角色！");
				return false;
			}else{			
				if(hpreid!=null&&hpreid!=""){
					if(names.indexOf(hpreid)!=-1){
						window.returnValue=selectedId
						window.close();	
					}else{
						alert("本角色需要父角色，请先添加父角色！");
						return false;
					}
				}else{
					window.returnValue=selectedId
					window.close();
				}
			}			
		}else{		
			alert("请选择角色");
			return false;
		}
	}
	function cancel1(){
		window.close();
	}
</script>

<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif"  BORDER=0 ALT="" align="absmiddle"/>&nbsp;${system.action.action_name}

	</div>
	<div class="skin_search ui-widget-content" style="padding:.2em;">
	[#assign bn=term.role_name!""/]
	<form name="moduleform" id="moduleform" action="${_servlet_url!''}/authclient.user.rolelistdialog" method="post">
	<input type="hidden" name="mem_id" value="${term.mem_id!''}"> 
<span>角色名称：<input type="text" size="15" name="role_name" id="role_name" value="${bn}"></span></span>
<button type="button" onclick="submit();"  class="ui-button ui-state-default ui-corner-all">查询</button>
<button type="button" onclick="emptiedAndSubmit('moduleform');" class="ui-button ui-state-default ui-corner-all">清空条件</button>
<input type="hidden" name="page">
<input type="hidden" name="haveroles" id="haveroles">
	</form>
	</div>
	<div  id="buttons" style="text-align:right">
		<button type="button" onclick="save()">保存</button>
		<button type="button" onclick="cancel1()">取消</button>
	</div>
	<div class="ui-widget-content"  style="position: relative;padding: .2em;">
			<table  width="100%">
			<col width="60"><col width="160"><col width="70"><col width="70"><col>
			  <tr class="ui-widget-header">
			    <td width="30">选择</td>
				<td>角色名称</td>
			    <td>父角色</td>
			    <td>是否审核</td>
				<td>说明</td>				
			  </tr>
			[#assign rolelist=role.rolelist]
			[#list rolelist as role]
			  <tr>
			    <td><input type="radio" name="role_id" value="${role.role_id}">
			    <input type="hidden" name="hpreid" [#if "${role.prepositive_role!''}"!=" "]value="${role.prepositive_role!''}"[#else] value=""[/#if]>
			    </td>
			    <td>${role.role_name!''}</td>
			    <td>${role.pre_role_name!''}</td>
				<td>[#if "${role.ischeck!''}"="1"]是[#else]否[/#if]</td>
			    <td>${role.role_description!""}</td>			    
			  </tr>
			[/#list]
			</table></div>
			<div class="mainbody_page">
			[#import "/WEB-INF/commonftl/util.ftl" as my/]
			[@my.pagebar currentpage=role.page.currentpage totalpage=role.page.totalpage totalnum=role.page.totalnum/]
	</div>
	
</div>
