<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script language="javascript">
function tosave(){
	var queryString=$("#form1").formSerialize();
			$.post("${_servlet_url!''}/auth.eadmin.update",queryString,
				function(data,textStatus){
				var jdata=jQuery.parseJSON(data);
		    	if(jdata.success=="1"){
		    		alert("保存成功");
		    	}else{
		    		alert("保存失败");
		    	}
			});	
}
</script>
<table style="width:100%" border="0">
<tr><td width="200" valign="top">
[#global web=JspTaglibs["/WEB-INF/eap.tld"]]
[@web.block  site_id="eap2" action_id="auth.personalinfo" component_id="auth"/]
</td><td valign="top">

<div class="ui-widget ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;可管理企业列表
	</div>
</div>

<div class="ui-widget ui-widget-content">
	<form id="form1">
		<div  class="ui-widget" id="buttons" style="text-align:right">
			<button type="button" id="save" onclick="tosave();">保存</button>
		</div>
		<input type="hidden" name="mem_id" value="${block.mem_id!''}">
		<table id="tab1"  class="ui-widget-content ui-widget-table ui-corner-all" cellspacing="1">
			[#if block.organlist?exists]
			[#list block.organlist as organ]
			<tr class="odd" id="tr_${organ.ORGAN_ID!''}">
				<td>
					<input type="hidden" name="organ_id" value="${organ.ORGAN_ID!''}">${organ.ORGAN_NAME!''}
				</td>
				<td>
					<input type="radio" name="current_organ" value="${organ.ORGAN_ID!''}" [#if "${block.eadmin.current_organ!''}"=="${organ.ORGAN_ID!''}"]checked[/#if]>设为默认
				</td>
			</tr>
			[/#list]
			[/#if]
		</table>
	</form>
</div>

</td></tr></table>