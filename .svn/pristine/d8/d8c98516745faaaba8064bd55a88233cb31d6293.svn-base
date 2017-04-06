<style>
.td11{text-align:center;background-color:#DAEAFE;color:#2a51a4;}
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
.td14{padding-left:12px;background-color:#E1F1FE;color:#4D4D4D;}
.table_content{
	font-size:12px;
	font-weight:no;
	padding-left:12px;
	color:#4d4d4d
}
.middle_right{
	font-family:"微软雅黑";
	font-size:12px;
	font-weight:bolder;
}
</style>
<script language="javascript">
function gotopage(pageValue){
	document.editform.page.value=pageValue;
	document.editform.submit();
}
function dochange(service_id,state){
	$.post("${_servlet_url!''}/datacenter.service.changestate?service_id="+service_id+"&service_state="+state,
			"",function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success==1){
						alert("操作成功!!");
						window.location.reload();
					}else{
						alert("操作失败!!");
					}
				});
}
function dodel(service_id){
	$.post("${_servlet_url!''}/datacenter.service.delete?service_id="+service_id,
			"",function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success==1){
						alert("删除成功!!");
						window.location.reload();
					}else{
						alert("删除失败!!");
					}
				});
}
</script>
[#global web=JspTaglibs["/WEB-INF/eap.tld"]]
<table width="100%" style="table-layout:fixed;">
<tr><td style="vertical-align:top;" width="250px">
[@web.block component_name="数据中心" site_id="eap2" params="" action_name="服务左侧菜单" action_id="datacenter.service.menu" block_name="数据中心" block_id="" component_id="datacenter" /]
</td><td style="vertical-align:top;">
<form action="${_servlet_url!''}/datacenter.service.editlist?state=${block.state!''}" method="post" name="editform" id="editform">
<input type="hidden" name="page">
</form>
<!-- 栏目标题开始 -->
	<div class="widget-title-normal">
		<div class="child">
			<span class="widget-title-text">
				[#assign type=""]
				[#if "${block.state!''}"=="0"][#assign type="审核中的服务"][/#if]
				[#if "${block.state!''}"=="1"][#assign type="驳回的服务"][/#if]
				[#if "${block.state!''}"=="2"][#assign type="下线的服务"][/#if]
				[#if "${block.state!''}"=="7"][#assign type="未提交的服务"][/#if]
				[#if "${block.state!''}"=="8"][#assign type="上线的服务"][/#if]
				${type!''}管理列表
			</span>
		</div>
	</div>
	<div class="widget-content-body">
		<div class="widget-news-content middle_right">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
			<tr>
				<td class="td11" width="40">序号</td>
				<td class="td11">服务名称</td>
				<td class="td11">服务描述</td>
				<td class="td11">服务提供者</td>
				<!--td class="td11">是否审核</td-->
				<td class="td11" width="40">版本</td>
				<td class="td11" width="140">操作</td>
			</tr> 
			[#list block.resultList as service]
			[#if service_index%2==0]
			<tr>
				<td class="td13">${service_index+1}</td>
				<td class="td13">${service.service_name!''}</td>
				<td class="td13">${service.service_desc!''}</td>
				<td class="td13">${service.service_provide!''}</td>
				<!--td class="td13">${service.is_check!''}</td-->
				<td class="td13">${service.service_version!''}</td>
				<td class="td13">
				[#if "${block.state!''}"!="1"&&"${block.state!''}"!="7"]
				<a href="${_servlet_url!''}/datacenter.api.detail?service_id=${service.service_id!''}" target="_blank">API明细</a>
				[#else]
				<a href="${_servlet_url!''}/datacenter.service.forupdate?service_id=${service.service_id!''}">修改</a>
				[/#if]
				[#if "${block.state!''}"=="8"]
				<a href="javascript:dochange('${service.service_id}','2');">|下线</a>
				[/#if]
				[#if "${block.state!''}"=="2"||"${block.state!''}"=="0"]
				<a href="javascript:dochange('${service.service_id}','8');">|上线</a>
				[/#if]
				[#if "${block.state!''}"=="0"]
				<a href="javascript:dochange('${service.service_id}','1');">|驳回</a>
				[/#if]
				[#if "${block.state!''}"=="1"||"${block.state!''}"=="7"]
				<a href="javascript:dochange('${service.service_id}','0');">|提交</a>
				<a href="javascript:dodel('${service.service_id}');">|删除</a>
				[/#if]
				</td>
			</tr> 
			[#else]
			<tr>
				<td class="td14">${service_index+1}</td>
				<td class="td14">${service.service_name!''}</td>
				<td class="td14">${service.service_desc!''}</td>
				<td class="td14">${service.service_provide!''}</td>
				<!--td class="td14">${service.is_check!''}</td-->
				<td class="td14">${service.service_version!''}</td>
				<td class="td14">
				[#if "${block.state!''}"!="1"&&"${block.state!''}"!="7"]
				<a href="${_servlet_url!''}/datacenter.api.detail?service_id=${service.service_id!''}" target="_blank">API明细</a>
				[#else]
				<a href="${_servlet_url!''}/datacenter.service.forupdate?service_id=${service.service_id!''}">修改</a>
				[/#if]
				[#if "${block.state!''}"=="8"]
				<a href="javascript:dochange('${service.service_id}','2');">|下线</a>
				[/#if]
				[#if "${block.state!''}"=="2"||"${block.state!''}"=="0"]
				<a href="javascript:dochange('${service.service_id}','8');">|上线</a>
				[/#if]
				[#if "${block.state!''}"=="0"]
				<a href="javascript:dochange('${service.service_id}','1');">|驳回</a>
				[/#if]
				[#if "${block.state!''}"=="1"||"${block.state!''}"=="7"]
				<a href="javascript:dochange('${service.service_id}','0');">|提交</a>
				<a href="javascript:dodel('${service.service_id}');">|删除</a>
				[/#if]
				</td>
			</tr> 
			[/#if]
			[/#list]
		</table>
		</div>
	</div>
	<div class="mainbody_page" style="padding-left:1em;text-align:right">
	  	[#import "/WEB-INF/commonftl/pagebar2.ftl" as my/]
		[@my.pagebar currentpage=block.page.currentpage totalpage=block.page.totalpage/]
	</div>
	<!-- 栏目内容结束 -->
	<div class="widget-bottom">
		<div class="widget-bottom-right"></div>
	</div>
</td></tr></table>