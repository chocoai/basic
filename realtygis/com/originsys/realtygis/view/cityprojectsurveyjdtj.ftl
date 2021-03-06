<script type="text/javascript" src="${_share_file_url!''}/gis/FMapLib/theme/js/FusionCharts.js"></script>

<!--[#list map.relist as relist]
	[#if EnumService.getEnum('chlx')?exists]
		    [#list EnumService.getEnum('chlx') as enum]
					[#if "${relist.SURVERTYPE!''}" == "${enum.enum_value!''}"]
						${enum.enum_name!''}
					[#else]
						${relist.SURVERTYPE!''}
					[/#if]
			[/#list]
		[/#if]
	[#list relist.TYPELIST as typelist]
		年：${typelist.YEAR!''}套数：${typelist.COUNT!''}<br/>
	[/#list]
[/#list]-->
<script type="text/javascript" language="javascript">
$(function(){
	$("#tabs").tabs({cache:false});
});
</script>

<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .1em;">
	<div class="ui-widget" id="tabs">
	<ul>
		<li><a href="#chart3div">柱状图</a></li>
		<li><a href="#dragLinechartdiv1">折线图</a></li>
	</ul>
	<div id="dragLinechartdiv1"></div>
	<div id="chart3div"></div>
	</div>
</div>	
      
<script type="text/javascript">
	var chart = new FusionCharts("${_share_file_url!''}/gis/FMapLib/theme/images/DragLine.swf", "dragLineId", "825", "350", "0", "0");  
	//拼接chart
	var strXML="<chart palette='1' caption='全市测绘' subcaption='按季度房屋套数统计' showvalues='0' xAxisName='年份 季度' yAxisName='套数' restoreBtnBorderColor='A2A3A0' formBtnBorderColor='A2A3A0' canvasPadding='20' dragBorderColor='666666' dragBorderThickness='3' baseFontSize='12' chartRightMargin='30' showAboutMenuItem='0' showFormBtn='0' showRestoreBtn='0' >";
	//拼接x轴（categories）
	var strCategory="<categories>";
	[#list map.relist as relist]
		[#list relist.TYPELIST as typelist]
			strCategory+="<category name='${typelist.YEARJD!''}' />";
		[/#list]
		[#break]
	[/#list]
	strCategory+="</categories>";
	//拼接折线
	var strDataset="";
	[#list map.relist as relist]
		[#if EnumService.getEnum('chtjlx')?exists]
		    [#list EnumService.getEnum('chtjlx') as enum]
				[#if "${relist.SURVERTYPE!''}" == "${enum.enum_value!''}"]
					strDataset+="<dataset id='${relist.SURVERTYPE!''}' seriesName='${enum.enum_name!''}'>";
				[/#if]
			[/#list]
		[/#if]
		
		//strDataset+="<dataset id='${relist.SURVERTYPE!''}' seriesName='${relist.SURVERTYPE!''}'>";
		[#list relist.TYPELIST as typelist]
			strDataset+="<set id='${typelist.YEARJD!''}' value='${typelist.COUNT!''}' allowDrag='0'/>";
		[/#list]
		strDataset+="</dataset>";
	[/#list]
	
	//拼接样式设置
	var strStyle="<styles><definition><style name='myCaptionFont' type='font' font='Arial' size='14' bold='1' /> <style name='mySubCaptionFont' type='font' font='Arial' size='12' bold='0' /> </definition><application><apply toObject='Caption' styles='myCaptionFont' /> <apply toObject='SubCaption' styles='mySubCaptionFont' /></application></styles>";
	strXML+=strCategory+strDataset+strStyle;
	strXML+="</chart>";
	chart.setDataXML(strXML);
	chart.render("dragLinechartdiv1");	
</script>


<script type="text/javascript">
	var chart = new FusionCharts("${_share_file_url!''}/gis/FMapLib/theme/images/DragColumn2D.swf", "DragColumnId", "825", "350", "0", "0");
    var strXML="<chart palette='1' caption='全市测绘' subcaption='按季度房屋套数统计' showvalues='0' xAxisName='年份 季度' yAxisName='套数' restoreBtnBorderColor='A2A3A0' formBtnBorderColor='A2A3A0' canvasPadding='20' dragBorderColor='666666' dragBorderThickness='3' baseFontSize='12' chartRightMargin='30' showAboutMenuItem='0' showFormBtn='0' showRestoreBtn='0' >";
	//拼接x轴（categories）
	var strCategory="<categories>";
	[#list map.relist as relist]
		[#list relist.TYPELIST as typelist]
			strCategory+="<category name='${typelist.YEARJD!''}' />";
		[/#list]
		[#break]
	[/#list]
	strCategory+="</categories>";
	//拼接折线
	var strDataset="";
	[#list map.relist as relist]
		[#if EnumService.getEnum('chtjlx')?exists]
		    [#list EnumService.getEnum('chtjlx') as enum]
				[#if "${relist.SURVERTYPE!''}" == "${enum.enum_value!''}"]
					strDataset+="<dataset id='${relist.SURVERTYPE!''}' seriesName='${enum.enum_name!''}'>";
				[/#if]
			[/#list]
		[/#if]
		
		//strDataset+="<dataset id='${relist.SURVERTYPE!''}' seriesName='${relist.SURVERTYPE!''}'>";
		[#list relist.TYPELIST as typelist]
			strDataset+="<set id='${typelist.YEARJD!''}' value='${typelist.COUNT!''}' allowDrag='0'/>";
		[/#list]
		strDataset+="</dataset>";
	[/#list]
	
	//拼接样式设置
	var strStyle="<styles><definition><style name='myCaptionFont' type='font' font='Arial' size='14' bold='1' /> <style name='mySubCaptionFont' type='font' font='Arial' size='12' bold='0' /> </definition><application><apply toObject='Caption' styles='myCaptionFont' /> <apply toObject='SubCaption' styles='mySubCaptionFont' /></application></styles>";
	strXML+=strCategory+strDataset+strStyle;
	strXML+="</chart>";
	chart.setDataXML(strXML);
	chart.render("chart3div");	
</script>