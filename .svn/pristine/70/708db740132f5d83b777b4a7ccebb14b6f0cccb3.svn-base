<link rel="stylesheet" href="${_share_file_url!''}/gis/resource/qd/css/css.css" type="text/css" />
<link rel="stylesheet" href="${_share_file_url!''}/gis/resource/qd/css/styles.css" type="text/css" />
<link rel="stylesheet" href="${_share_file_url!''}/gis/resource/qd/css/jquery-tool.css" type="text/css" />
<link rel="stylesheet" href="${_share_file_url!''}/gis/resource/qd/css/style-detailed.css">
<style>
.td22{text-align:right;padding-right:12px;background-color:#F1F8FF;color:#2a51a4;}
.td23{padding-left:12px;background-color:#fff;color:#4D4D4D;}
.td24{text-align:center;background-color:#fff;color:#4D4D4D;}
.button_style{color:#333333;background:url(${_share_file_url!''}/gis/resource/qd/images/button_bj.jpg) repeat-x; border:1px #9ac8dc solid; height:28px;}
</style>
<script language="javascript">
function tog(obj){
	var show=$("#"+obj).css("display");
	if("block"==show){
		$("#"+obj).css("display","none");
		$("#"+obj+"_img").attr("src","${_share_file_url!''}/gis/resource/qd/images/down.png");
	}else{
		$("#"+obj).css("display","block");
		$("#"+obj+"_img").attr("src","${_share_file_url!''}/gis/resource/qd/images/upward.png");
	}
}
</script>

<div class="info">
	<ul>
		<li class="info_1">
		<span class="info_button" onclick="tog('info1');"><img id="info1_img" src="${_share_file_url!''}/gis/resource/qd/images/upward.png" /></span>
		<img src="${_share_file_url!''}/gis/resource/qd/images/jbxx.png" width="16" height="20" align="absbottom" />  安全鉴定
		</li>
	    <li class="info_content" style="display:block;" id="info1">
		[#if block.safeList?size>0]
	    [#list block.safeList as safe]
	    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="table-layout:fixed;">
	    	<tr>
				<td class="td22" width="100">鉴定地址：</td>
				<td class="td23">${safe.building_address!''}</td>
				<td class="td22" width="100">鉴定人</td>
				<td class="td23">${safe.jdmember!''}</td>				
				<td class="td22" width="100">录入时间：</td>
				<td class="td23">[#if safe.entry_date?exists]${safe.entry_date?string("yyyy-MM-dd HH:mm:ss")}[/#if]</td>
				<td class="td22" width="100">信息状态：</td>
				[#assign info_state=""]
			    [#if "${safe.info_state!''}"=="0"][#assign info_state="暂存"][/#if]
			    [#if "${safe.info_state!''}"=="1"][#assign info_state="待审核"][/#if]
			    [#if "${safe.info_state!''}"=="2"][#assign info_state="审核驳回"][/#if]
			    [#if "${safe.info_state!''}"=="8"][#assign info_state="审核通过"][/#if]
				<td class="td23">${info_state!''}</td>
				<td class="td24" width="100"><a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safeauth.report.detail?building_id=${safe.building_id!''}&jdinfo_id=${safe.jdinfo_id!''}','','dialogWidth:1000px;dialogHeight:600px;center:1;')>查看详细</a></td>
			</tr>
	    </table>
	    [/#list]
	    [#else]
	    	<div style="font-size:14px;font-weight:bold;text-align:center;">暂无数据！</div>
	    [/#if]
	    </li>
    </ul>  
</div>
