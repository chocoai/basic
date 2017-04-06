<script type="text/javascript">
function setCurrOrgan(orgid,orgname){
	var str="organ_id="+orgid+"&organ_name="+orgname;
	$.post("${_servlet_url!''}/auth.setcurorgan",str,
			function(data,textStatus){
				var jdata=jQuery.parseJSON(data);
				if(jdata.success==1){
					alert("保存成功！");
				}else{
					alert("操作失败！");
				}
		});
}
function orgcomdetail(orgid){
    window.location="${_server_url!''}/portal/auth.orgcomdetail?organ_id="+orgid;
}
function orgcommodify(orgid){
    window.location="${_server_url!''}/portal/auth.orgcommodify?organ_id="+orgid;
}
</script>
<table style="width:100%" border="0">
<tr><td width="200" valign="top">
[#global web=JspTaglibs["/WEB-INF/eap.tld"]]
[@web.block  site_id="eap2" action_id="auth.personalinfo" component_id="auth"/]
</td><td valign="top">
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;我的组织
	</div>
	<table width="100%" border="0" cellpadding="0" cellspacing="1" style="line-height:30px;table-layout:fixed;">
		<tr class="odd">
			<td align="center">名称</td>
			<td align="center">组织代码证号</td>
			<td align="center">行政区</td>
			<td align="center">联系人</td>
			<td align="center">地址</td>
			<td align="center">电话</td>
			<td align="center">组织状态</td>
			<td align="center">操作</td>
		</tr>
		[#list block as result]
		[#if result_index%2==1]
		<tr class="odd">
		[#else]
		<tr>
		[/#if]
			<td><a href="#" onclick="orgcomdetail('${result.ORGAN_ID!''}');"><font>${result.ORGAN_NAME!''}</font></a></td>
			<td>${result.ORGAN_CODE!''}</td>
			<td>${result.ORGAN_REGION_NAME!''}</td>
			<td>${result.ORGAN_LINKMAN!''}</td>
			<td>${result.ORGAN_ADDRESS!''}</td>
			<td>${result.ORGAN_PHONE!''}</td>
			<td>[#if "${result.AUTHENTICATION_STATE!''}"!="1"]未认证[#else]已认证[/#if]</td>
			<td><a href="#" onclick="orgcommodify('${result.ORGAN_ID!''}');"><font color="red"><b>修改组织信息</b></font></a></td>
			<!--<td><a href="#" onclick="setCurrOrgan('${result.ORGAN_ID!''}','${result.ORGAN_NAME!''}');"><font color="red"><b>设为当前企业</b></font></a></td>-->
		</tr>
		[/#list]
	</table>
</div>
</td></tr></table>