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
		<img src="${_share_file_url!''}/gis/resource/qd/images/jbxx.png" width="16" height="20" align="absbottom" />  日常检查
		</li>
	    <li class="info_content" style="display:block;" id="info1">
		[#if block.safeList?size>0]
	    [#list block.safeList as safe]
	    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="table-layout:fixed;">
	    	<tr>
				<td class="td22" width="100">检查新坐落：</td>
				<td class="td23">${safe.check_address!''}</td>
				<td class="td22" width="100">房屋安全情况：</td>
				[#assign health_grade_pc=""]
			    [#if "${safe.health_grade_pc!''}"=="1"][#assign health_grade_pc="无危险点房屋"][/#if]
			    [#if "${safe.health_grade_pc!''}"=="2"][#assign health_grade_pc="存在危险点房屋"][/#if]
			    [#if "${safe.health_grade_pc!''}"=="3"][#assign health_grade_pc="局部危险房屋"][/#if]
			    [#if "${safe.health_grade_pc!''}"=="4"][#assign health_grade_pc="整幢危险房屋"][/#if]
				<td class="td23">${health_grade_pc!''}</td>
				<td class="td22" width="100">检查时间：</td>
				<td class="td23">[#if safe.check_time?exists]${safe.check_time?string("yyyy-MM-dd")}[/#if]</td>
				<td class="td24" width="100"><a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safecheck.building.detail?building_id=${safe.building_id!''}&info_id=${safe.info_id!''}','','dialogWidth:1000px;dialogHeight:600px;center:1;')>查看详细</a></td>
			</tr>
	    </table>
	    [/#list]
	    [#else]
	    	<div style="font-size:14px;font-weight:bold;text-align:center;">暂无数据！</div>
	    [/#if]
	    </li>
    </ul>  
</div>
<div class="info">
	<ul>
		<li class="info_1">
		<span class="info_button" onclick="tog('info3');"><img id="info3_img" src="${_share_file_url!''}/gis/resource/qd/images/upward.png" /></span>
		<img src="${_share_file_url!''}/gis/resource/qd/images/aqgl.png" width="20" height="18" align="absbottom" />  事故记录
		</li>
	    <li class="info_content" id="info3" style="display:block;">
	    [#if block.accidentList?size>0]
	    [#list block.accidentList as accident]
	    <!--<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="table-layout:fixed;">
	    	<tr>
				<td class="td22" width="100">事故标题：</td>
				<td class="td23">${accident.accident_name!''}</td>
				<td class="td22" width="100">事故发生时间：</td>
				<td class="td23">${accident.accident_date?string("yyyy-MM-dd")}</td>
			</tr>
			<tr>
				<td class="td22" width="100">事故类型：</td>
				<td class="td23">${accident.accident_type!''}</td>
				<td class="td22" width="100">上报人：</td>
				<td class="td23">${accident.accident_reporter!''}</td>
			</tr>
			<tr>
				<td class="td22" width="100">事故描述：</td>
				<td class="td23" colspan="3">${accident.accident_description!''}</td>
			</tr>
			<tr>
				<td class="td22" width="100">备注：</td>
				<td class="td23" colspan="3">${accident.accident_note!''}</td>
			</tr>
	    </table>-->
	    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="table-layout:fixed;">
	    	<tr>
				<td class="td22" width="100">事故标题：</td>
				<td class="td23">${accident.accident_name!''}</td>
				<td class="td22" width="100">事故发生时间：</td>
				<td class="td23">[#if accident.accident_date?exists]${accident.accident_date?string("yyyy-MM-dd")}[/#if]</td>
				<td class="td22" width="100">上报人：</td>
				<td class="td23">${accident.accident_reporter!''}</td>
				<td class="td24" width="100"><a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safecheck.accident.detail?accident_id=${accident.accident_id!''}','','dialogWidth:600px;dialogHeight:400px;center:1;')>查看详细</a></td>
			</tr>
	    </table>
	    [/#list]
	    [#else]
	    	<div style="font-size:14px;font-weight:bold;text-align:center;">暂无数据！</div>
	    [/#if]
	    </li>
    </ul>  
</div>
<div class="info">
	<ul>
		<li class="info_1">
		<span class="info_button" onclick="tog('info2');"><img id="info2_img" src="${_share_file_url!''}/gis/resource/qd/images/upward.png" /></span>
		<img src="${_share_file_url!''}/gis/resource/qd/images/chxx.png" width="20" height="18" align="absbottom" />  维修记录
		</li>
	    <li class="info_content" id="info2" style="display:block;">
	    [#if block.repairList?size>0]
	   	[#list block.repairList as repair]
	    <!--<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="table-layout:fixed;">
	    	<tr>
				<td class="td22" width="100">维修内容：</td>
				<td class="td23">${repair.repair_content!''}</td>
				<td class="td22" width="100">维修费用：</td>
				<td class="td23">${repair.repair_cost!''}</td>
			</tr>
			<tr>
				<td class="td22" width="100">维修单位：</td>
				<td class="td23" >${repair.repair_organ!''}</td>
				<td class="td22" width="100">完成时间：</td>
				<td class="td23" >${repair.complete_date?string("yyyy-MM-dd")}</td>
			</tr>
			<tr>
				<td class="td22" width="100">维修负责人：</td>
				<td class="td23">${repair.repair_manager!''}</td>
				<td class="td22" width="100">负责人电话：</td>
				<td class="td23">${repair.manager_tel!''}</td>
			</tr>
			<tr>
				<td class="td22" width="100">备注：</td>
				<td class="td23" colspan="3">${repair.repair_remarks!''}</td>
			</tr>
	    </table>-->
	    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="table-layout:fixed;">
	    	<tr>
				<td class="td22" width="100">维修内容：</td>
				<td class="td23">${repair.repair_content!''}</td>
				<td class="td22" width="100">完成时间：</td>
				<td class="td23" >[#if repair.complete_date?exists]${repair.complete_date?string("yyyy-MM-dd")}[/#if]</td>
				<td class="td22" width="100">维修负责人：</td>
				<td class="td23">${repair.repair_manager!''}</td>
				<td class="td24" width="100"><a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safecheck.repair.detail?repair_id=${repair.repair_id!''}','','dialogWidth:600px;dialogHeight:400px;center:1;')>查看详细</a></td>
			</tr>
	    </table>
	    [/#list]
	    [#else]
	    	<div style="font-size:14px;font-weight:bold;text-align:center;">暂无数据！</div>
	    [/#if]
	    </li>
    </ul>  
</div>
