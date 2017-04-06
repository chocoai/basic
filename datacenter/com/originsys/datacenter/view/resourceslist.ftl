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
<form action="${_servlet_url!''}/datacenter.resources.editlist?state=${block.state!''}" method="post" name="editform" id="editform">
<input type="hidden" name="page">
</form>
<!-- 栏目标题开始 -->
	<div class="widget-title-normal">
		<div class="child">
			<span class="widget-title-text">
				资源列表
			</span>
		</div>
	</div>
	<div class="widget-content-body">
		<div class="widget-news-content middle_right" style="min-height:300px;">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
			<tr>
				<td class="td11">序号</td>
				<td class="td11">资源编号</td>
				<td class="td11">资源名称</td>
				<td class="td11">资源表名</td>
				<td class="td11">来源业务系统</td>
				<td class="td11">资源描述</td>
				<td class="td11">操作</td>
			</tr> 
			[#list block.resultList as resource]
			[#if resource_index%2==0]
			<tr>
				<td class="td13">${resource_index+1}</td>
				<td class="td13">${resource.resources_id!''}</td>
				<td class="td13">${resource.resources_name!''}</td>
				<td class="td13">${resource.resources_tablename!''}</td>
				<td class="td13">${resource.source_business_systems!''}</td>
				<td class="td13">${resource.resources_desc!''}</td>
				<td class="td13">
				<a href="${_servlet_url!''}/datacenter.resources.detail?resources_id=${resource.resources_id!''}" target="_blank">明细</a>
				</td>
			</tr> 
			[#else]
			<tr>
				<td class="td14">${resource_index+1}</td>
				<td class="td14">${resource.resources_id!''}</td>
				<td class="td14">${resource.resources_name!''}</td>
				<td class="td14">${resource.resources_tablename!''}</td>
				<td class="td14">${resource.source_business_systems!''}</td>
				<td class="td14">${resource.resources_desc!''}</td>
				<td class="td14">
				<a href="${_servlet_url!''}/datacenter.resources.detail?resources_id=${resource.resources_id!''}" target="_blank">明细</a>
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