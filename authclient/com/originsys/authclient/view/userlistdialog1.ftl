
<link type="text/css" rel="stylesheet" href="${_share_file_url!''}/resource/css/custom.css" />
<script language="javascript">
$(function(){
	[#if request.getAttribute("haveroles")?exists]
		[#assign allusers=request.getAttribute("haveusers")!'']
		$("#haveusers").val("${allusers}");
	[#else]
		var oMyObject = window.dialogArguments;	
		if(oMyObject!=null&&oMyObject!=undefined){
			var names=oMyObject.names;
			$("#haveusers").val(names);
		}
	[/#if]
});	
	function emptiedAndSubmit(obj){
		$("#family_name").val("");
		$("#firstname").val("");
		obj.form.submit();
	}
	function save(){
		var selectedNum=0;
		var selectedId="";
		$("input[type=radio]").each(function(){
			if($(this).attr("checked")){
				selectedNum++;
				selectedId=$(this).attr("value");
			}
		});
		if(selectedNum==1){
			var names=$("#haveusers").val();
			if((names.length>0)&&(names.indexOf("#"+selectedId+"#")!=-1)){
				alert("此用户已有，请选择别的用户！");
				return false;
			}else{
				window.returnValue=selectedId;
				window.close();
			}			
		}else{		
			alert("请选择");
			return false;
		}
	}
	function cancel1(){
		window.close();
	}
function gotopage(pageValue){
	document.pagemoduleform.page.value=pageValue;
	document.pagemoduleform.submit();
}
</script>
<div class="skin_search ui-widget-content" style="padding:.2em;">
	<form name="pagemoduleform" action="${_servlet_url!''}/authclient.user.roledialog" method="post">
	[#assign bn=request.getParameter("family_name")!""/]
	[#assign sn=request.getParameter("firstname")!""/]
	<span>姓：<input type="text" size="15" id="family_name" name="family_name" value="${bn}"></span>
	<span>名：<input type="text" id="firstname" name="firstname" value="${sn}"></span>
	<button type="button" onclick="submit();"  class="ui-button ui-state-default ui-corner-all">查询</button>
	<button type="button" onclick="emptiedAndSubmit(this);" class="ui-button ui-state-default ui-corner-all">显示全部</button>
	<input type="hidden" name="page">
	<input type="hidden" name="haveusers" id="haveusers" value="">
	</form>
</div>
	<div  id="buttons" style="text-align:right">
		<button type="button" onclick="save()"  class="ui-button ui-state-default ui-corner-all">保存</button>
		<button type="button" onclick="cancel1()"  class="ui-button ui-state-default ui-corner-all">取消</button>
	</div>
		<div class="ui-widget-content"  style="position: relative;padding: .2em;">
			<table  width="100%">
			<col width="50"><col><col width="100"><col width="120">
			  <tr class="ui-widget-header">
			    <td width="30">选择</td>
			    <td>姓名</td>
			    <td>注册时间</td>
			    <td>最后登录时间</td>
			  </tr>
			[#assign userlist=block.userlist]  
			[#list userlist as user]
			  <tr>
			    <td><input type="radio" name="mem_id" value="${user.mem_id!''}"></td>
			    <td>${user.family_name!''}${user.firstname!''}</td>
			    <td>[#if user.register_time?exists]${user.register_time?string("yyyy-MM-dd")}[/#if]</td>
			    <td>[#if user.last_time?exists]${user.last_time?string("yyyy-MM-dd")}[/#if]</td>
			  </tr>
			[/#list]
			</table>
			</div>
			<div class="mainbody_page">
			[#import "/WEB-INF/commonftl/util.ftl" as my/]
			[@my.pagebar currentpage=block.page.currentpage totalpage=block.page.totalpage totalnum=block.page.totalnum/]
		</div>