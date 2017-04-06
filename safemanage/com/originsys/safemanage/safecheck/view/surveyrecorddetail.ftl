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
		<img src="${_share_file_url!''}/gis/resource/qd/images/jbxx.png" width="16" height="20" align="absbottom" />  安全普查
		</li>
	    <li class="info_content" style="display:block;" id="info1">
		[#if block.surveyList?size>0]
	    [#list block.surveyList as survey]
	    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="table-layout:fixed;">
	    	<tr>
				<td class="td22" width="100">普查新坐落：</td>
				<td class="td23">${survey.building_newaddress!''}</td>
				<td class="td22" width="100">房屋安全情况：</td>
				[#assign health_grade_pc=""]
			    [#if "${survey.building_safecondition!''}"=="1"][#assign health_grade_pc="无问题房屋"][/#if]
			    [#if "${survey.building_safecondition!''}"=="4"][#assign health_grade_pc="有问题房屋"][/#if]			   
				<td class="td23">${health_grade_pc!''}</td>
				<td class="td22" width="100">普查日期：</td>
				<td class="td23">[#if survey.survey_date?exists]${survey.survey_date?string("yyyy-MM-dd")}[/#if]</td>
				<td class="td22" width="100">普查类型：</td>
				<td class="td23">
				[#if EnumService.getEnum('survey_type')?exists]
			      [#list EnumService.getEnum('survey_type') as enum]			     
			      [#if "${survey.survey_type!''}"=="${enum.enum_value!''}"]
			      ${survey.survey_type}
			      [/#if]
			      [/#list]
			    [/#if]
			    </td>
				<td class="td24" width="100"><a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safecheck.survey.detail?isgis=1&survey_id=${survey.survey_id!''}','','dialogWidth:1000px;dialogHeight:600px;center:1;')>查看详细</a></td>
			</tr>
	    </table>
	    [/#list]
	    [#else]
	    	<div style="font-size:14px;font-weight:bold;text-align:center;">暂无数据！</div>
	    [/#if]
	    </li>
    </ul>  
</div>
