<script type="text/javascript" src="${_share_file_url!''}/resource/js/LodopFuncs.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	$("#detailForm :input").attr({disabled:"true"});
	$("#outdiv").css("display","block");
});
	var LODOP; //声明为全局变量 
	function prn1_print() {		
		CreateOneFormPage();
		LODOP.PRINT();	
	};
	function prn1_preview() {	
		CreateOneFormPage();	
		LODOP.PREVIEW();	
	};	
	function CreateOneFormPage(){
		LODOP=getLodop();  
		LODOP.PRINT_INIT("济南市老楼危楼安全排查表");
		LODOP.SET_PRINT_STYLE("FontSize",24);
		//LODOP.SET_PRINT_STYLE("Bold",1);
		LODOP.SET_PRINT_STYLE("FontFamily","宋体");
		LODOP.ADD_PRINT_TEXT(100,210,420,39,"济南市老楼危楼安全排查表");
		var strBodyStyle="<style>table td{font-size:14px;font-family:'宋体'; }</style>";
		var strFormHtml=strBodyStyle+"<body>"+document.getElementById("detailForm").innerHTML+"</body>";
		LODOP.ADD_PRINT_HTM(148,20,470,1000,strFormHtml);
	};
</script>
<style>
.tdpad {padding-left:4px;}
</style>
<div class="widget-title-normal">
	<div class="child">
		<span class="widget-title-text">
			楼幢普查信息
		</span>
	</div>
</div>
<div id="outdiv" style="display:none">
	<div  id="buttons" style="text-align:right">
		<button type="button" onclick="prn1_preview();" >打印预览</button>
		<button type="button" onclick="prn1_print();" >打印</button>
		[#-- if "${block.isgis!''}"!="1"]
			<button type="button" onclick="javascript:window.history.go(-1);" >返回</button>		
		[/#if--]
	</div>
<form id="detailForm" method="post">
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .1em;">
	<div class="ui-widget" id="tabs">
		<table width="730"align="center" style="table-layout:fixed;line-height:30px;border-collapse:collapse"  border="1px" bordercolor="#000000" cellspacing="0px">
			<tr>
				<td width="25" rowspan="11" align="center">房屋基本情况</td>
				<td align="center" width="100">房屋坐落</td>
				<td colspan="5" class="tdpad">${block.buildingsurvey.building_address!''}</td>
				<td align="center" width="100">用途</td>
				<td width="60" class="tdpad">
				[#assign yt=""]
				[#list EnumService.getEnum('sjyt') as enum]
				[#if "${block.buildingsurvey.use_desgin!''}"=="${enum.enum_value!''}"][#assign yt="${enum.enum_name!''}"][/#if]
				[/#list]${yt!''}
				</td>				
			</tr>
			<tr>
				<td align="center" width="100">普查新坐落</td>
				<td colspan="5" class="tdpad">${block.buildingsurvey.building_newaddress!''}</td>
				<td align="center">是否一致</td>
				<td width="100" class="tdpad">&nbsp;[#if "${block.buildingsurvey.issame!''}"=="1"]是[#elseif "${block.buildingsurvey.issame!''}"=="0"]否[/#if]
				</td>				
			</tr>
			<tr>
				<td align="center">建筑面积（㎡）</td>
				<td width="100" class="tdpad">
				[#if "${block.buildingsurvey.build_area!''}"!=""]#{block.buildingsurvey.build_area!'';m0M2}[/#if]
				</td>
				<td align="center">层数<br>（地上/地下）</td>
				<td width="100" class="tdpad">${block.buildingsurvey.floorup_count!''}/${block.buildingsurvey.floordown_count!''}</td>
				<td align="center" width="100">套数</td>
				<td width="100" class="tdpad">${block.buildingsurvey.house_count!''}</td>
				<td align="center">建设年份</td>
				<td class="tdpad">${block.buildingsurvey.building_date!''}</td>
			</tr>
			<tr>
				<td align="center">房屋所有人<br>（管理单位）</td>
				<td colspan="7" class="tdpad">${block.buildingsurvey.building_holder!''}</td>
			</tr>
			<tr>
				<td align="center">房屋管理人<br>姓名</td>
				<td class="tdpad">${block.buildingsurvey.building_manager_name!''}</td>
				<td align="center" colspan="3">房屋管理人<br>办公电话、手机</td>
				<td colspan="3" class="tdpad">${block.buildingsurvey.building_manager_phone!''}</td>
			</tr>
			<tr>
				<td align="center">设计和施工<br>资料</td>
				<td colspan="7">
				<input type="checkbox" [#if "${block.buildingsurvey.building_material!''}"=="1" ]checked[/#if]>齐全
				<input type="checkbox" [#if "${block.buildingsurvey.building_material!''}"=="2" ]checked[/#if]>基本齐全
				<input type="checkbox" [#if "${block.buildingsurvey.building_material!''}"=="3" ]checked[/#if]>无
				</td>
			</tr>
			<tr>
				<td align="center">管理模式</td>
				<td colspan="7">
				<input type="checkbox" [#if "${block.buildingsurvey.manage_type!''}"=="1" ]checked[/#if]>物业管理
				<input type="checkbox" [#if "${block.buildingsurvey.manage_type!''}"=="2" ]checked[/#if]>单位自管
				<input type="checkbox" [#if "${block.buildingsurvey.manage_type!''}"=="3" ]checked[/#if]>无明确管理单位
				<input type="checkbox" [#if "${block.buildingsurvey.manage_type!''}"=="4" ]checked[/#if]>其他
				</td>
			</tr>
			<tr>
				<td align="center">建设单位</td>
				<td colspan="7">
				<table cellpadding="0" border="0" width="100%" cellspacing="0" style="table-layout:fixed;line-height:30px;">
				<tr><td style="border-right:1px solid #000;" class="tdpad">${block.buildingsurvey.build_dept!''}</td>
				<td align="center" style="border-right:1px solid #000;">设计单位</td>
				<td style="border-right:1px solid #000;" class="tdpad">${block.buildingsurvey.design_dept!''}</td>
				<td align="center" style="border-right:1px solid #000;">施工单位</td>
				<td class="tdpad">${block.buildingsurvey.construct_dept!''}</td>
				</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td align="center">结构类型</td>
				<td colspan="7">
				<input type="checkbox" [#if "${block.buildingsurvey.build_struct!''}"=="1302" ]checked[/#if]>钢混结构
				<input type="checkbox" [#if "${block.buildingsurvey.build_struct!''}"=="1311" ]checked[/#if]>砖混结构
				<input type="checkbox" [#if "${block.buildingsurvey.build_struct!''}"=="1312" ]checked[/#if]>砖木结构
				<input type="checkbox" [#if "${block.buildingsurvey.build_struct!''}"=="1301" ]checked[/#if]>钢结构
				<input type="checkbox" [#if "${block.buildingsurvey.build_struct!''}"=="1309" ]checked[/#if]>其他
				</td>
			</tr>
			<tr>
				<td align="center">楼盖类型</td>
				<td colspan="7">
				[#list EnumService.getEnum('upon_type') as enum]
				<input type="checkbox" [#if "${block.buildingsurvey.upon_type!''}"=="${enum.enum_value!''}" ]checked[/#if]>${enum.enum_name!''}
				[/#list]
				</td>
			</tr>
			<tr>
				<td align="center">屋面类型</td>
				<td colspan="7">
				[#list EnumService.getEnum('wm_type') as enum]
				<input type="checkbox" [#if "${block.buildingsurvey.wm_type!''}"=="${enum.enum_value!''}" ]checked[/#if]>${enum.enum_name!''}
				[/#list]
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">房屋性质</td>
				<td colspan="7">
				<input type="checkbox" [#if "${block.buildingsurvey.building_properties!''}"=="1" ]checked[/#if]>单位自管房
				<input type="checkbox" [#if "${block.buildingsurvey.building_properties!''}"=="2" ]checked[/#if]>直管公房
				<input type="checkbox" [#if "${block.buildingsurvey.building_properties!''}"=="3" ]checked[/#if]>房改住房
				<input type="checkbox" [#if "${block.buildingsurvey.building_properties!''}"=="4" ]checked[/#if]>私房
				<input type="checkbox" [#if "${block.buildingsurvey.building_properties!''}"=="5" ]checked[/#if]>其他
				</td>
			</tr>
			<tr>
				<td align="center" colspan="9">现场调查</td>
			</tr>
			<tr>
				<td align="center" colspan="2">主要危险情况（包括地基基础、上部承重结构及使用历史情况）</td>
				<td colspan="7" class="tdpad">${block.buildingsurvey.local_survey!''}</td>
			</tr>
			<tr>
				<td align="center" colspan="9">房屋安全情况</td>
			</tr>
			<tr>
				<td colspan="9">
				 <table cellpadding="0" border="0" width="100%" cellspacing="0" style="table-layout:fixed;line-height:30px;">
				 	<tr>
				 	<td align="center" width="120" style="border-right:1px solid #000;">无问题房屋</td>
					<td style="border-right:1px solid #000;" class="tdpad" colspan="3">[#if "${block.buildingsurvey.building_safecondition!''}"=="1"]是[/#if]</td>
					<!--<td align="center" width="120" style="border-right:1px solid #000;">存有危险点房屋</td>
					<td style="border-right:1px solid #000;" class="tdpad">[#if "${block.buildingsurvey.building_safecondition!''}"=="2"]是[/#if]</td>
					<td align="center" width="120" style="border-right:1px solid #000;">局部危险房屋</td>
					<td style="border-right:1px solid #000;" class="tdpad">[#if "${block.buildingsurvey.building_safecondition!''}"=="3"]是[/#if]</td>-->
					<td align="center" width="120" style="border-right:1px solid #000;">有问题房屋</td>
					<td class="tdpad" colspan="3">[#if "${block.buildingsurvey.building_safecondition!''}"=="4"]是[/#if]</td>
				 	</tr>
				 </table>
				</td>				
			</tr>
		</table>
		<table width="700" align="center" style="table-layout:fixed;line-height:30px;margin-top:10px;"  border="0" cellspacing="0px">	
		<tr><td>负责人（签字）：${block.buildingsurvey.manager_name!''}</td>
		<td>排查人(签字)：${block.buildingsurvey.survey_name!''}</td>
		<td>排查时间：[#if block.buildingsurvey.survey_date?exists]${block.buildingsurvey.survey_date?date}[/#if]</td></tr>
		</table>		
	</div>
</div>	
</form>
</div>