<script type="text/javascript" language="javascript">
$(function(){
	$("#outdiv").css("display","block");
	$("#tabs").tabs({cache:false});
});
</script>
<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
.tdpad {padding-left:4px; background-color:#ffffff}
.td_title {text-align:right;padding-right:4px; background-color:#ffffff}
</style>

<div id="outdiv" style="display:none">
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .1em;">
	<div class="ui-widget" id="tabs">
	<ul>
		<li><a href="#tabs-1">普查表信息</a></li>
		<!--[#if access.canDo(user,'realtygis.healthgradetab')]
		<li><a href="#tabs-2" title="tabs-2"></a></li>
		[/#if]
		[#if access.canDo(user,'realtygis.housejson')]
		<li><a href="#tabs-3" title="tabs-3"></a></li>
		[/#if]
		[#if access.canDo(user,'realtygis.buildingbasicsurver')]
		<li><a href="#tabs-4"></a></li>
		[/#if]-->
	</ul>
	[#list map.list as item]
	<div id="tabs-1">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		
			<tr>
				<td class="td12">楼幢编号图斑编号</td><td class="td13">${item.building_id!''}</td>
				<td class="td12">房屋所有人（管理单位）</td><td class="td13">${item.building_holder!''}</td>
				
			</tr>
			<tr>
				<td class="td12">房屋管理人姓名</td><td class="td13">${item.building_manager_name!''}</td>
				<td class="td12">房屋管理人办公室电话、手机</td><td class="td13">${item.building_manager_phone!''}</td>
			</tr>
			<tr>
				<td class="td12">设计施工材料</td><td class="td13">[#if "${item.building_material!''}"=="1"]齐全[/#if][#if "${item.building_material!''}"=="2"]基本齐全[/#if][#if "${item.building_material!''}"=="3"]无[/#if]</td>
				<td class="td12">管理模式</td><td class="td13">[#if "${item.manage_type!''}"=="1"]专业化企业进驻[/#if][#if "${item.manage_type!''}"=="2"]后勤式[/#if][#if "${item.manage_type!''}"=="3"]社区介入[/#if][#if "${item.manage_type!''}"=="4"]业主自治[/#if]</td>
			</tr>
			<tr>
				<td class="td12">建设单位</td><td class="td13">${item.build_dept!''}</td>
				<td class="td12">设计单位</td><td class="td13">${item.design_dept!''}</td>
			</tr>
			<tr>
				<td class="td12">房屋性质</td><td class="td13">[#if "${item.building_properties!''}"=="1"]房改住房[/#if][#if "${item.building_properties!''}"=="2"]省直管公房[/#if][#if "${item.building_properties!''}"=="3"]市直管公房[/#if][#if "${item.building_properties!''}"=="4"]企业自管[/#if][#if "${item.building_properties!''}"=="5"]其他[/#if]</td>
				<td class="td12">施工单位</td><td class="td13">${item.construct_dept!''}</td>
			</tr>
			<tr>
				<td class="td12">现场调查情况</td><td class="td13">${item.local_survey!''}</td>
				<td class="td12">房屋安全情况</td><td class="td13">[#if "${item.building_safecondition!''}"=="1"]无危险点房屋[/#if][#if "${item.building_safecondition!''}"=="2"]存在危险点房屋[/#if][#if "${item.building_safecondition!''}"=="3"]局部危险房屋[/#if][#if "${item.building_safecondition!''}"=="4"]整幢危险房屋[/#if]</td>
			</tr>
			<tr>
				<td class="td12">负责人</td><td class="td13">${item.manager_name!''}</td>
				<td class="td12">排查人</td><td class="td13">${item.survey_name!''}</td>
			</tr>
			<tr>
				<td class="td12">排查时间</td><td class="td13">${item.survey_date!''}</td>
				<td class="td12">审核人id</td><td class="td13">${item.check_userid!''}</td>
			</tr>
			<tr>
				<td class="td12">普查状态</td><td class="td13">[#if "${item.info_state!''}"=="0"]暂存[/#if][#if "${item.info_state!''}"=="1"]未审核[/#if][#if "${item.info_state!''}"=="2"] 审核驳回[/#if][#if "${item.info_state!''}"=="8"]审核通过[/#if]</td>
				<td class="td12">坐落</td><td class="td13">${item.building_address!''}</td>
			</tr>
			<tr>
				<td class="td12">建筑面积（平方米）</td><td class="td13">${item.build_area!''}</td>
				<td class="td12">层数（上）</td><td class="td13">${item.floorup_count!''}</td>
			</tr>
			<tr>
				<td class="td12">层数（下）</td><td class="td13">${item.floordown_count!''}</td>
				<td class="td12">套数</td><td class="td13">${item.house_count!''}</td>
			</tr>
			<tr>
				<td class="td12">用途</td><td class="td13">[#if "${item.use_desgin!''}"=="1000"]无[/#if][#if "${item.use_desgin!''}"=="1010"]住宅[/#if][#if "${item.use_desgin!''}"=="1020"]非住宅[/#if][#if "${item.use_desgin!''}"=="1070"]其他[/#if][#if "${item.use_desgin!''}"=="1025"]商业服务[/#if][#if "${item.use_desgin!''}"=="1050"]商住[/#if]</td>
				<td class="td12">建成年份</td><td class="td13">${item.building_date!''}</td>
			</tr>
			<tr>
				<td class="td12">结构类型</td><td class="td13">[#if "${item.build_struct!''}"=="1302"]钢混结构[/#if][#if "${item.build_struct!''}"=="1303"]钢砼[/#if][#if "${item.build_struct!''}"=="1304"]混合[/#if][#if "${item.build_struct!''}"=="1301"]钢结构[/#if][#if "${item.build_struct!''}"=="1305"]砖木[/#if][#if "${item.build_struct!''}"=="1306"]木[/#if][#if "${item.build_struct!''}"=="1309"]其他[/#if][#if "${item.build_struct!''}"=="1311"]砖混结构[/#if][#if "${item.build_struct!''}"=="1312"]砖木结构[/#if]</td>
				<td class="td12">信息填写人id</td><td class="td13">${item.report_userid!''}</td>
			</tr>
			<tr>
				<td class="td12">楼盖类型</td><td class="td13">[#if "${item.lg_type!''}"=="1"]现浇板[/#if][#if "${item.lg_type!''}"=="2"]预制板[/#if][#if "${item.lg_type!''}"=="3"]现浇、预制板混用[/#if][#if "${item.lg_type!''}"=="4"]木楼板[/#if][#if "${item.lg_type!''}"=="5"]其它[/#if]</td>
				<td class="td12">屋面类型</td><td class="td13">[#if "${item.wm_type!''}"=="1"]预制板平屋面[/#if][#if "${item.wm_type!''}"=="2"]现浇板平屋面[/#if][#if "${item.wm_type!''}"=="3"]现浇板坡屋面[/#if][#if "${item.wm_type!''}"=="4"]有檩系坡屋面[/#if][#if "${item.wm_type!''}"=="5"]其它[/#if]</td>
			</tr>
			
			<tr>
				<td class="td12">审核意见</td><td class="td13">${item.check_message!''}</td>
				<td class="td12">审核时间</td><td class="td13">${item.check_date!''}</td>
			</tr>
			<tr>
				<td class="td12">附件</td><td class="td13">${item.annex!''}</td>
				<td class="td12">图片</td><td class="td13">${item.annex_pic!''}</td>
			</tr>
			<tr>
				<td class="td12">所属区域</td><td class="td13">[#if "${item.building_region!''}"=="086370102"]历下区[/#if][#if "${item.building_region!''}"=="086370103"]市中区[/#if][#if "${item.building_region!''}"=="086370104"]槐荫区[/#if][#if "${item.building_region!''}"=="086370105"]天桥区[/#if][#if "${item.building_region!''}"=="086370112"]历城区[/#if][#if "${item.building_region!''}"=="086370114"]高新区[/#if][#if "${item.building_region!''}"=="086370113"]长清区[/#if][#if "${item.building_region!''}"=="086370181"]章丘市[/#if][#if "${item.building_region!''}"=="086370124"]平阴县[/#if][#if "${item.building_region!''}"=="086370125"]济阳县[/#if][#if "${item.building_region!''}"=="086370126"]商河县[/#if]</td>
				<td class="td12"></td><td class="td13"></td>
			</tr>
			
			
			
		</table>
	</div>
	<!--<div id="tabs-2">
		<iframe frameborder="0" src="${_servlet_url!''}/realtygis.healthgradetab?invm_prj_id=${item.invm_prj_id!''}" style="width:100%;height:450px"></iframe>
	</div>
	<div id="tabs-3">
		<iframe frameborder="0" src="" style="width:100%;height:450px"></iframe>
	</div>
	<div id="tabs-4">
		<iframe frameborder="0" src="" style="width:100%;height:450px"></iframe>
	</div>-->
	 [#if item_has_next][/#if]
	[/#list]
</div>	
</div>