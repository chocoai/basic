<!--类型：${map.type}<br/>
[#list map.surverareatj as surverarea]
	年：${surverarea.YEAR!''}面积：${surverarea.AREA!''}<br/>
[/#list]-->

<script type="text/javascript" src="${_share_file_url!''}/gis/FMapLib/theme/js/FusionCharts.js"></script>
<div id="dragLinechartdiv1" align="center"></div>
<script type="text/javascript">
	var chart = new FusionCharts("${_share_file_url!''}/gis/FMapLib/theme/images/DragLine.swf", "dragLineId", "825", "350", "0", "0");  
	//拼接chart
	var strXML="<chart palette='1' caption='全市测绘' subcaption='按年实测绘房屋建筑面积' showvalues='0' xAxisName='年份' yAxisName='面积（单位：平方米）' restoreBtnBorderColor='A2A3A0' formBtnBorderColor='A2A3A0' canvasPadding='20' dragBorderColor='666666' dragBorderThickness='3' baseFontSize='12' chartRightMargin='30' showAboutMenuItem='0' showFormBtn='0' showRestoreBtn='0' >";
	//拼接x轴（categories）
	var strCategory="<categories>";
	//拼接折线
	var strDataset="<dataset id='AREA' seriesName='房屋建筑面积'>";
	[#list map.surverareatj as surverarea]
		strCategory+="<category name='${surverarea.YEAR!''}年' />";
		strDataset+="<set id='${surverarea.YEAR!''}' value='${surverarea.AREA!''}' allowDrag='0'/>";
	[/#list]
	strCategory+="</categories>";
	strDataset+="</dataset>";
	
	//拼接样式设置
	var strStyle="<styles><definition><style name='myCaptionFont' type='font' font='Arial' size='14' bold='1' /> <style name='mySubCaptionFont' type='font' font='Arial' size='12' bold='0' /> </definition><application><apply toObject='Caption' styles='myCaptionFont' /> <apply toObject='SubCaption' styles='mySubCaptionFont' /></application></styles>";
	strXML+=strCategory+strDataset+strStyle;
	strXML+="</chart>";
	chart.setDataXML(strXML);
	chart.render("dragLinechartdiv1");
</script>