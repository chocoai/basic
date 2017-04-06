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
		var re=new Array();
		re[0]=$(obj).val();
		re[1]=$(obj).parent().next().html();
		if(window.opener != undefined) {  
			window.opener.returnValue = re;  
        } else {  
        	window.returnValue=re;  
        }
		//window.returnValue=re;
		window.close();
	}
function gotopage(pageValue){
	document.pagemoduleform.page.value=pageValue;
	document.pagemoduleform.submit();
}
</script>
[#assign term=block.orgcom]
[#assign organcomlist=block.resultList]
<div class="skin_search ui-widget-content" style="padding:.2em;">
	<form name="pagemoduleform" id="moduleform" action="${_servlet_url!''}/auth.orgcomlistdialog" method="post">
		<input type="hidden" name="page">
		<input type="hidden" name="authentication_state" value="1">
		<input type="hidden" name="_pagenum" id="_pagenum" value="${block.page.currentpage},${block.page.totalpage}">
		<span>名称:</span><span><input type="text" size="15" name="organ_name" id="organ_name" value="${term.organ_name!''}"/></span>
		<button type="button" onclick="abc();"  class="ui-button ui-state-default ui-corner-all">查询</button>
		<button type="button" onclick="emptiedAndSubmit(this);" class="ui-button ui-state-default ui-corner-all">显示全部</button>
	</form>
</div>
<div class="ui-widget-content"  style="position: relative;padding: .2em;">
			<table  width="100%">
			<col width="50px" /><col /><col width="120px"/><col width="100px"/><col  width="100px"/><col />
			  <tr class="ui-widget-header">
			    <td width="30">选择</td>
				<td>名称</td><td>组织机构代码</td><td>行政区</td><td>联系人</td><td>行业</td>
			  </tr>
			[#list organcomlist as orgcom]
			  <tr>
			    <td><input name="pagemodule_id" type="radio" value="${orgcom.organ_id!''}" onclick="getItem(this)"></td>
			    <td>${orgcom.organ_name!''}</td>
			    <td>${orgcom.organ_code!''}</td>
			    <td>${orgcom.organ_region_name!''}</td>
			    <td>${orgcom.organ_linkman!''}</td>
			    <td>${orgcom.organ_trade!''}</td>
			  </tr>
			[/#list]
			</table>
</div>
		<div class="mainbody_page">
			[#import "/WEB-INF/commonftl/util.ftl" as my/]
			[@my.pagebar currentpage=block.page.currentpage totalpage=block.page.totalpage totalnum=block.page.totalnum/]
		</div>	
			