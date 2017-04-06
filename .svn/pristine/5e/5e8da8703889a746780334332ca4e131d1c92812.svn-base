<link rel="stylesheet" href="${_share_file_url!''}/gis/resource/qd/css/css.css" type="text/css" />
<link rel="stylesheet" href="${_share_file_url!''}/gis/resource/qd/css/styles.css" type="text/css" />
<link rel="stylesheet" href="${_share_file_url!''}/gis/resource/qd/css/jquery-tool.css" type="text/css" />
<link rel="stylesheet" href="${_share_file_url!''}/gis/resource/qd/css/style-detailed.css">
<style>
#sstab td{
	padding-left:8px;
	background-color:#f4f9ff;
	border:1px solid #c7d2ff;
	font-color:#0081E4;
	vertical-align:top;}	
#sstab td a:visited{	
color:#0081E4;}
</style>
<script language="javascript">
function gotopage(pageValue){
	$("#page").val(pageValue);
	$("#form1").submit();
}
$(function(){
	$("#sstab td").each(function(){
		$(this).bind("mouseover",function(){
			$(this).css("background-color","#3dace3");
			$("a",$(this)).css("color","#fff");
		}).bind("mouseout",function(){
			$(this).css("background-color","#f4f9ff");
			$("a",$(this)).css("color","#0081E4");
		});
	});
});
</script>
<div class="middle">
    <div class="fcqd_search1">
    <div >
      <div id="page-wrap">
	  <div id="example-two">
	    <ul class="nav search_detailed">
		    <li class="nav-one"><a href="#featured2" class="current">房     屋</a></li>
				<li class="nav-two"><a href="#core2">业     主</a></li>
				<li class="nav-three"><a href="#jquerytuts2">开发商</a></li>
				<li class="nav-three"><a href="#jquerytuts2">中介机构</a></li>
				<li class="nav-four last"><a href="#classics2">物业公司</a></li>
		</ul>
		<div class="list-wrap">
			<ul id="featured2">
				<form id="form1" action="${_servlet_url!''}/datacenter.qdserch" method="post">
				<input type="hidden" name="page" id="page">
			    <li class="search_button"><input type="text" name="keyword" class="search_detailed_input" value="${block.keyword!''}"/>
	            </li>
	             <li class="fcqd_search_content1"><input type="submit" name="button"  class="search_content_button" value="" />
	            </li>
	            </form>
			</ul>
			
			<ul id="core2" class="hide">
				 <li class="search_button"><input type="text" name="textfield" class="search_detailed_input" value="输入关键字"/>
	            </li>
	             <li class="fcqd_search_content1"><input type="submit" name="button"  class="search_content_button" value="" />
	            </li>
			</ul>
			
			<ul id="jquerytuts2" class="hide">
				 <li class="search_button"><input type="text" name="textfield" class="search_detailed_input" value="输入关键字"/>
	            </li>
	             <li class="fcqd_search_content1"><input type="submit" name="button"  class="search_content_button" value="" />
	            </li>
			</ul>
			
			<ul id="classics2" class="hide">
				 <li class="search_button"><input type="text" name="textfield" class="search_detailed_input" value="输入关键字"/>
	            </li>
	             <li class="fcqd_search_content1"><input type="submit" name="button"  class="search_content_button" value="" />
	            </li>
			</ul>
		
		</div> <!-- END List Wrap -->	
  	</div> <!-- END Organic Tabs (Example One) -->	
	</div>
	</div>
</div>
<div class="theme">
	<ul>
    <li class="theme_big">主    题</li>
    <li class="theme_big1">安    全</li>
    <li class="theme_big1">权    属 </li>
    <li class="theme_big1">物    业</li>
    <li class="theme_big1">保    障 </li>
    </ul>
</div>
<table width="100%" id="sstab" border=0 align="center" cellpadding="0" cellspacing="15" style="table-layout:fixed;line-height:35px;">
	[#list block.relist as res]
	[#if res_index%2==0]<tr>[/#if]
	<td>
		[#if "${res.type!''}"=="house"]
		<a href="${_servlet_url!''}/datacenter.qddetail?info_type=house&info_id=${res.id!''}" target="_blank">
		[#else]
		<a href="${_servlet_url!''}/datacenter.qddetail?info_type=building&info_id=${res.id!''}" target="_blank">
		[/#if]
		${res.address!''}</a>
	 </td>
	[#if res_index%2==1]</tr>[/#if]
	[/#list]
</table>
[#-- list block.relist as res]
<div class="info">	
	<ul>
		<li class="info_1">
		[#if "${res.type!''}"=="house"]
		<a href="${_servlet_url!''}/datacenter.qddetail?info_type=house&info_id=${res.id!''}" target="_blank">
		[#else]
		<a href="${_servlet_url!''}/datacenter.qddetail?info_type=building&info_id=${res.id!''}" target="_blank">
		[/#if]
		${res.address!''}</a></li>
	    <li class="info_content">
	          地址：${res.address!''}&nbsp;&nbsp;
	    </li>
    </ul>  
</div>
[/#list --]
<div class="mainbody_page" style="padding-left:1em;text-align:right;padding-right:15px;padding-top:10px;">
	[#import "/WEB-INF/commonftl/pagebar2.ftl" as my/]
	[@my.pagebar currentpage=block.page.currentpage totalpage=block.page.totalpage/]
</div>