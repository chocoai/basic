<link rel="stylesheet" type="text/css" href="${_share_file_url!''}/safemanage/resource/css/timebase.css">
<!--script type="text/javascript" src="${_share_file_url!''}/safemanage/resource/js/timebase.js"></script-->
<script type="text/javascript">
$(function(){
	$("div:first").removeClass("blue_30"); 
	$("div:first").attr("style","width:1000px;"); 
	$(".list li").hover(function(){
		$(".list li").removeClass("thiscur"); 
	  	$(this).addClass("thiscur");
	});
});
</script>
<style>
.td22{text-align:right;padding-right:12px;background-color:#F1F8FF;color:#2a51a4;}
.td23{padding-left:12px;background-color:#fff;color:#4D4D4D;}
.td24{text-align:center;background-color:#fff;color:#4D4D4D;}
.button_style{color:#333333;background:url(${_share_file_url!''}/gis/resource/qd/images/button_bj.jpg) repeat-x; border:1px #9ac8dc solid; height:28px;}
</style>
<div id="timebase">	
	<div id="content">
		<ul class="list">			
			<li >
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="icon"><img src="${_share_file_url!''}/safemanage/resource/images/timebase/ch.png" style="width:56px;height:56px;"></span>
							<span class="md">出生记录</span>
						</div>
					</div>					
					<div class="point"><b></b></div>					
					<div class="liright">
                   
<!-- --------- 主体内容开始 --------------->             
<div class="widget-title-normal">
<div class="child">
    <span class="widget-title-text">出生记录</span>
</div>
</div>
<div class="widget-content-body">
<div class="widget-news-content">
		[#assign yt="${block.building.use_design!''}"]
	    [#if EnumService.getEnum('sjyt')?exists]
	    [#list EnumService.getEnum('sjyt') as enum]
			[#if "${block.building.use_design!''}"=="${enum.enum_value!''}"]
				[#assign yt="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
		[#assign jg="${block.building.build_struct!''}"]
	    [#if EnumService.getEnum('fwjg')?exists]
	    [#list EnumService.getEnum('fwjg') as enum]
			[#if "${block.building.build_struct!''}"=="${enum.enum_value!''}"]
				[#assign jg="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
		[#assign fwcb="${block.building.real_type!''}"]
	    [#if EnumService.getEnum('fwcb')?exists]
	    [#list EnumService.getEnum('fwcb') as enum]
			[#if "${block.building.real_type!''}"=="${enum.enum_value!''}"]
				[#assign fwcb="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
		<table width="900px" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="table-layout:fixed;line-height:30px;">
			<tr>
				<td class="td22" width="130">地址：</td>
				<td class="td23" colspan="3">${block.building.building_address!''}</td>
				<td class="td22" width="130">建造时间：</td>
				<td class="td23">${block.building.building_date!''}</td>
			</tr>
			<tr>
				<td class="td22">房屋产别：</td>
				<td class="td23" width="130">${fwcb!''}</td>
				<td class="td22">设计用途：</td>
				<td class="td23" width="150">${yt!''}</td>
				<td class="td22">房屋结构：</td>
				<td class="td23">${jg!''}</td>
			</tr>
			<tr>
				<td class="td22">施测单位：</td>
				<td class="td23">${block.building.unit!''}</td>
				<td class="td22">地上层数：</td>
				<td class="td23">${block.building.floorup_count!''}</td>
				<td class="td22">套数：</td>
				<td class="td23">${block.building.house_count!''}</td>
			</tr>
			<tr>
				<td class="td22">总套内建筑面积：</td>
				<td class="td23">${block.building.tn_area!''}</td>
				<td class="td22">总分摊共用面积：</td>
				<td class="td23">${block.building.ft_area!''}</td>
				<td class="td22">总建筑面积：</td>
				<td class="td23">${block.building.build_area!''}</td>
			</tr>
		</table>
</div>
</div>
 <!-- --------- 主体内容结束 ---------------> 
 				</div>					
			</li>
[#if block.buildingsurvey?exists]
			<li>
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="icon"><img src="${_share_file_url!''}/safemanage/resource/images/timebase/ct.png" style="width:56px;height:56px;"></span>
							<span class="md">普查记录</span>
						</div>
					</div>
					
					<div class="point"><b></b></div>
					
					<div class="liright">
                    
 <!-- --------- 主体内容开始 --------------->                     
<div class="widget-title-normal">
<div class="child">
    <span class="widget-title-text">普查记录</span>
</div>
</div>
<div class="widget-content-body">
<div class="widget-news-content">
		<table width="900px" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="table-layout:fixed;line-height:30px;">
			<tr>
					<td class="td22" width="190px">坐落地址：</td>
					<td class="td23" colspan="3">${block.buildingsurvey.building_address!''}</td>
					<td class="td22">楼幢编号：</td>
					<td class="td23">${block.buildingsurvey.building_id!''}</td>
				</tr>
				<tr>
					<td class="td22">普查新坐落：</td>
					<td class="td23" colspan="3">${block.buildingsurvey.building_newaddress!''}</td>
					<td class="td22">坐落是否一致：</td>
					<td class="td23">[#if "${block.buildingsurvey.issame!''}"=="1"]是[#elseif "${block.buildingsurvey.issame!''}"=="0"]否[/#if]</td>
				</tr>
				<tr>
					<td class="td22">所属区域：</td>
					<td class="td23">
						[#list EnumService.getEnum('xzqh') as enum]
						[#if "${block.buildingsurvey.building_region!''}"=="${enum.enum_value!''}"]${enum.enum_name!''}[/#if]
						[/#list]
					</td>
					<td class="td22">用途：</td>
					<td class="td23">
						[#list EnumService.getEnum('sjyt') as enum]
						[#if "${block.buildingsurvey.use_desgin!''}"=="${enum.enum_value!''}"]${enum.enum_name!''}[/#if]
						[/#list]
					</td>
					<td class="td22">建筑面积：</td>
					<td class="td23">#{block.buildingsurvey.build_area!'';m0M2}</td>
				</tr>
				<tr>
					<td class="td22">地上层数：</td>
					<td class="td23">${block.buildingsurvey.floorup_count!''}</td>
					<td class="td22">地下层数：</td>
					<td class="td23">${block.buildingsurvey.floordown_count!''}</td>
					<td class="td22">套数：</td>
					<td class="td23">${block.buildingsurvey.house_count!''}</td>
				</tr>
				<tr>
					<td class="td22">建成年份：</td>
					<td class="td23">${block.buildingsurvey.building_date!''}</td>
					<td class="td22">房屋所有人（管理单位）：</td>
					<td class="td23">${block.buildingsurvey.building_holder!''}</td>
					<td class="td22">房屋管理人姓名：</td>
					<td class="td23">${block.buildingsurvey.building_manager_name!''}</td>
				</tr>
				<tr>
					<td class="td22">房屋管理人办公电话、手机：</td>
					<td class="td23">${block.buildingsurvey.building_manager_phone!''}</td>
					<td class="td22">设计和施工材料：</td>
					<td class="td23">[#if "${block.buildingsurvey.building_material!''}"=="1" ]齐全[#elseif "${block.buildingsurvey.building_material!''}"=="2" ]基本齐全[#elseif "${block.buildingsurvey.building_material!''}"=="3" ]无[/#if]
					</td>
					<td class="td22">管理模式：</td>
					<td class="td23">[#if "${block.buildingsurvey.manage_type!''}"=="1" ]物业管理[#elseif "${block.buildingsurvey.manage_type!''}"=="2" ]单位自管[#elseif "${block.buildingsurvey.manage_type!''}"=="3" ]无明确管理单位[#elseif "${block.buildingsurvey.manage_type!''}"=="4" ]其他[/#if]
					</td>
				</tr>
				<tr>
					<td class="td22">建设单位：</td>
					<td class="td23">${block.buildingsurvey.build_dept!''}
					</td>
					<td class="td22">设计单位：</td>
					<td class="td23">${block.buildingsurvey.design_dept!''}
					</td>
					<td class="td22">施工单位：</td>
					<td class="td23">${block.buildingsurvey.construct_dept!''}
					</td>
				</tr>
				<tr>
					<td class="td22">结构类型：</td>
					<td class="td23">
							[#list EnumService.getEnum('fwjg') as enum]
							[#if "${block.buildingsurvey.build_struct!''}"=="${enum.enum_value!''}" ]${enum.enum_name!''}[/#if]
							[/#list]
					</td>
					<td class="td22">楼盖类型：</td>
					<td class="td23">
							[#list EnumService.getEnum('upon_type') as enum]
							[#if "${block.buildingsurvey.upon_type!''}"=="${enum.enum_value!''}" ]${enum.enum_name!''}[/#if]
							[/#list]
					</td>
					<td class="td22">屋面类型：</td>
					<td class="td23">
							[#list EnumService.getEnum('wm_type') as enum]
							[#if "${block.buildingsurvey.wm_type!''}"=="${enum.enum_value!''}" ]${enum.enum_name!''}[/#if]
							[/#list]
					</td>
				</tr>
				<tr>
					<td class="td22">房屋性质：</td>
					<td class="td23">
						[#if "${block.buildingsurvey.building_properties!''}"=="1" ]单位自管房[#elseif "${block.buildingsurvey.building_properties!''}"=="2" ]直管公房[#elseif "${block.buildingsurvey.building_properties!''}"=="3" ]房改住房[#elseif "${block.buildingsurvey.building_properties!''}"=="4" ]私房[#elseif "${block.buildingsurvey.building_properties!''}"=="5" ]其他[/#if]
					</td>
					<td class="td22">房屋安全情况：</td>
					<td class="td23" colspan="3">
						[#if "${block.buildingsurvey.building_safecondition!''}"=="1"]无问题房屋[#elseif "${block.buildingsurvey.building_safecondition!''}"=="4"]有问题房屋[/#if]
					</td>
					</tr>
				<tr>
					<td class="td22">负责人：</td>
					<td class="td23">${block.buildingsurvey.manager_name!''}</td>
					<td class="td22">排查人：</td>
					<td class="td23">${block.buildingsurvey.survey_name!''}</td>
					<td class="td22">排查日期：</td>
					<td class="td23">[#if block.buildingsurvey.survey_date?exists]${block.buildingsurvey.survey_date?date}[/#if]</td>
				</tr>
				<tr>
					<td class="td22">上传附件：</td>
					<td class="td23">[#if "${block.buildingsurvey.annex!''}"!='']<button onclick="window.location.href='${block.buildingsurvey.annex!''}'" id="returnval1" name="returnval1" style="margin-left:5px;display:inline-block;">
						下载附件</button>[/#if]</td>
					<td class="td22">上传图片：</td>
					<td class="td23" colspan="3">[#if "${block.buildingsurvey.annex_pic!''}"!='']<button onclick="window.open('${block.buildingsurvey.annex_pic!''}','_blank','depended=yes,top='+(window.screen.height-30-500)/2+',left='+(window.screen.width-10-800)/2+',width=800,height=500,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes');" id="returnval" name="returnval" style="margin-left:5px;display:inline-block;">
						查看图片</button>[/#if]</td>
				</tr>
				<tr>
					<td class="td22">现场调查：</td>
					<td class="td23" colspan="5">
						主要危险情况（包括地基基础、上部承重结构及使用历史情况）<br/>
						${block.buildingsurvey.local_survey!''}
					</td>
				</tr>
		</table>
</div>
</div>
 <!-- --------- 主体内容结束 ---------------> 
				</div>
			</li>
[/#if]			
[#if block.jdList?size>0]            
			<li>
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="icon"><img src="${_share_file_url!''}/safemanage/resource/images/timebase/jd.png" style="width:56px;height:56px;"></span>
							<span class="md">鉴定记录</span>
						</div>
					</div>
					
					<div class="point"><b></b></div>
					
					<div class="liright">
                    
 <!-- --------- 主体内容开始 --------------->                     
<div class="widget-title-normal">
<div class="child">
    <span class="widget-title-text">鉴定记录</span>
</div>
</div>
<div class="widget-content-body">
<div class="widget-news-content">
 		[#list block.jdList as jd]
	    <table width="900px" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="table-layout:fixed;line-height:30px;">
	    	<tr>
				<td class="td22" width="100">鉴定人：</td>
				<td class="td23">${jd.entrust_user!''}</td>
				<td class="td22" width="100">鉴定时间：</td>
				<td class="td23">[#if jd.jd_date?exists]${jd.jd_date?string("yyyy-MM-dd")}[/#if]</td>
				<td class="td22" width="100">危险等级：</td>
				<td class="td23">[#assign dangerous_level=""]
				[#if "${jd.dangerous_level!''}"=="1"][#assign dangerous_level="<div style='heigth:20px;width:100px;background-color:green;float:right;margin-top:7px;'> </div>A级"][/#if]
			    [#if "${jd.dangerous_level!''}"=="2"][#assign dangerous_level="<div style='heigth:20px;width:100px;background-color:yellow;float:right;margin-top:7px;'> </div>B级"][/#if]
			    [#if "${jd.dangerous_level!''}"=="3"][#assign dangerous_level="<div style='heigth:20px;width:100px;background-color:#CC6600;float:right;margin-top:7px;'> </div>C级"][/#if]
			    [#if "${jd.dangerous_level!''}"=="4"][#assign dangerous_level="<div style='heigth:20px;width:100px;background-color:red;float:right;margin-top:7px;'> </div>D级"][/#if]
				${dangerous_level!''}</td>
				<td class="td24" width="100"><a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safeauth.report.detail?jdinfo_id=${jd.jdinfo_id!''}','','dialogWidth:1000px;dialogHeight:600px;center:1;')>查看详细</a></td>
			</tr>
	    </table>
	    [/#list]
</div>
</div>
 <!-- --------- 主体内容结束 ---------------> 
				</div>
			</li>
[/#if]           
[#if block.safeList?size>0]            
			<li>
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="icon"><img src="${_share_file_url!''}/safemanage/resource/images/timebase/ct.png" style="width:56px;height:56px;"></span>
							<span class="md">查体记录</span>
						</div>
					</div>
					
					<div class="point"><b></b></div>
					
					<div class="liright">
                    
 <!-- --------- 主体内容开始 --------------->                     
<div class="widget-title-normal">
<div class="child">
    <span class="widget-title-text">查体记录</span>
</div>
</div>
<div class="widget-content-body">
<div class="widget-news-content">
		[#list block.safeList as safe]
	    <table width="900px" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="table-layout:fixed;line-height:30px;">
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
</div>
</div>
 <!-- --------- 主体内容结束 ---------------> 
				</div>
			</li>
[/#if]
[#if block.accidentList?size>0]            
			<li>
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="icon"><img src="${_share_file_url!''}/safemanage/resource/images/timebase/sg.png" style="width:56px;height:56px;"></span>
							<span class="md">事故记录</span>
						</div>
					</div>
					
					<div class="point"><b></b></div>
					
					<div class="liright">
                    
 <!-- --------- 主体内容开始 --------------->                     
<div class="widget-title-normal">
<div class="child">
    <span class="widget-title-text">事故记录</span>
</div>
</div>
<div class="widget-content-body">
<div class="widget-news-content">
		[#list block.accidentList as accident]
	   <table width="900px" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="table-layout:fixed;line-height:30px;">
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
</div>
</div>
 <!-- --------- 主体内容结束 ---------------> 
				</div>
			</li>
[/#if] 
[#if block.repairList?size>0]            
			<li>
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="icon"><img src="${_share_file_url!''}/safemanage/resource/images/timebase/zx.png" style="width:56px;height:56px;"></span>
							<span class="md">维修记录</span>
						</div>
					</div>
					
					<div class="point"><b></b></div>
					
					<div class="liright">
                    
 <!-- --------- 主体内容开始 --------------->                     
<div class="widget-title-normal">
<div class="child">
    <span class="widget-title-text">维修记录</span>
</div>
</div>
<div class="widget-content-body">
<div class="widget-news-content">
		[#list block.repairList as repair]
	    <table width="900px" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="table-layout:fixed;line-height:30px;">
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
</div>
</div>
 <!-- --------- 主体内容结束 ---------------> 
				</div>
			</li>
[/#if]                     
		</ul>
	</div>
</div>
<div style="text-align:center;clear:both">
</div>