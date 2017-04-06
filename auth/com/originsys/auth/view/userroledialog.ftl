<link type="text/css" rel="stylesheet" href="${_share_file_url!''}/resource/css/custom.css" />
<script language="javascript">
	function abc(){
		$("#moduleform").submit();
	}
	
	function emptiedAndSubmit(obj){
		$("#organ_name").val("");
		obj.form.submit();
	}
	function getItem(obj){
		window.returnValue=obj;
		window.close();
	}
function gotopage(pageValue){
	document.pagemoduleform.page.value=pageValue;
	document.pagemoduleform.submit();
}
</script>

[#assign rolelist=block.resultList]
<form name="pagemoduleform" id="moduleform" action="${_servlet_url!''}/auth.orgcomlistdialog" method="post">
		<input type="hidden" name="page">
		<input type="hidden" name="_pagenum" id="_pagenum" value="${block.page.currentpage},${block.page.totalpage}">		
</form>

<div class="ui-widget-content"  style="position: relative;padding: .2em;">
			<table  width="100%">
			<col width="30"><col width="100px;"><col>
			  <tr class="ui-widget-header">
			    <td width="30">选择</td>
				<td>角色名称</td>
				<td>角色描述</td>
			  </tr>
			[#list rolelist as role]
			  <tr>
			    <td><input name="pagemodule_id" type="radio" value="${role.role_register_id!''}" onclick="getItem('${role.role_register_id!''}');"></td>
			    <td>${role.role_name!''}</td>
			    <td>${role.role_description!''}</td>
			  </tr>
			[/#list]
			</table>
</div>
		<div class="mainbody_page">
			[#import "/WEB-INF/commonftl/util.ftl" as my/]
			[@my.pagebar currentpage=block.page.currentpage totalpage=block.page.totalpage totalnum=block.page.totalnum/]
		</div>	
			