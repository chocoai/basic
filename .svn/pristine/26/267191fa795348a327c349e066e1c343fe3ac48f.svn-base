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
</script>
<form action="${_servlet_url!''}/datacenter.service.list?service_type=${block.service_type!''}" method="post" name="editform" id="editform">
<input type="hidden" name="page">
</form>
<!-- 栏目标题开始 -->
	<div class="widget-title-normal">
		<div class="child">
			<span class="widget-title-text">
				[#assign type=""]
				[#if "${block.service_type!''}"=="1"][#assign type="数据资源服务"][/#if]
				[#if "${block.service_type!''}"=="2"][#assign type="云平台服务"][/#if]
				[#if "${block.service_type!''}"=="3"][#assign type="业务数据服务"][/#if]
				[#if "${block.service_type!''}"=="4"][#assign type="逻辑服务"][/#if]
				[#if "${block.service_type!''}"=="5"][#assign type="通用服务"][/#if]
				${type!''}列表
			</span>
		</div>
	</div>
	<div class="widget-content-body">
		<div class="widget-news-content middle_right"  style="min-height:300px;">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
			<tr>
				<td class="td11">序号</td>
				<td class="td11">服务名称</td>
				<td class="td11">服务描述</td>
				<td class="td11">服务提供者</td>
				<!--td class="td11">是否审核</td-->
				<td class="td11">版本</td>
				<td class="td11">操作</td>
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
				<td class="td13"><a href="${_servlet_url!''}/datacenter.api.detail?service_id=${service.service_id!''}" target="_blank">API明细</a>|申请</td>
			</tr> 
			[#else]
			<tr>
				<td class="td14">${service_index+1}</td>
				<td class="td14">${service.service_name!''}</td>
				<td class="td14">${service.service_desc!''}</td>
				<td class="td14">${service.service_provide!''}</td>
				<!--td class="td14">${service.is_check!''}</td-->
				<td class="td14">${service.service_version!''}</td>
				<td class="td14"><a href="${_servlet_url!''}/datacenter.api.detail?service_id=${service.service_id!''}" target="_blank">API明细</a>|申请</td>
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