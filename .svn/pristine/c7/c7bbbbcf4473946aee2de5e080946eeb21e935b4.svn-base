<script type="text/javascript" src="${_share_file_url!''}/gis/FMapLib/theme/js/FusionCharts.js"></script>
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
	<div id="dragLinechartdiv1" align="center" ></div>
	<div id="chart3div"></div>
	</div>
</div>

<script type="text/javascript">
	var chart = new FusionCharts("${_share_file_url!''}/gis/FMapLib/theme/images/DragLine.swf", "dragLineId", "825", "350", "0", "0");  
	//拼接chart
	var strXML="<chart palette='1' caption='全市测绘' subcaption='按设计用途测绘套数统计' showvalues='0' xAxisName='年份' yAxisName='套数' restoreBtnBorderColor='A2A3A0' formBtnBorderColor='A2A3A0' canvasPadding='20' dragBorderColor='666666' dragBorderThickness='3' baseFontSize='12' chartRightMargin='30' showAboutMenuItem='0' showFormBtn='0' showRestoreBtn='0' >";
	//拼接x轴（categories）
	var strCategory="<categories>";
	[#list map.resultlist as remap]
		[#list remap.usedesignlist as usedesigntj]
			strCategory+="<category name='${usedesigntj.YEAR!''}年' />";
		[/#list]
		[#break]
	[/#list]
	strCategory+="</categories>";
	
	//拼接实测折线
	//拼接数据集
    var strDataset="";
	[#list map.resultlist as remap]
		strDataset+="<dataset id='${remap.USEDESIGN!''}' seriesName='${remap.USEDESIGN!''}' dragBorderColor='0099FF'>";
		[#list remap.usedesignlist as usedesigntj]
			strDataset+="<set id='${usedesigntj.YEAR!''}${usedesigntj.COUNT!''}' value='${usedesigntj.COUNT!''}' allowDrag='0'/>";
		[/#list]
		strDataset+="</dataset>";
	[/#list]
	
	//拼接x轴（categories）
	//var strCategory="<categories><category name='2005' /><category name='2006' /><category name='2007' /><category name='2008' /><category name='2009' /></categories>";
	//拼接折线
	//var strDataset="<dataset id='IJ' seriesName='实测' dragBorderColor='0099FF'><set id='IJ2005' value='1' allowDrag='0'/><set id='IJ2006' value='2' allowDrag='0'/><set id='IJ2007' value='1' allowDrag='0'/><set id='IJ2008' value='3' allowDrag='0'/><set id='IJ2009' value='2' allowDrag='0'/></dataset><dataset id='LJ' seriesName='预测' showValues='0' dragBorderColor='CC9900'><set id='LJ2005' value='3' allowDrag='0'/><set id='LJ2006' value='2' allowDrag='0'/><set id='LJ2007' value='3' allowDrag='0'/><set id='LJ2008' value='4' allowDrag='0'/><set id='LJ2009' value='3' allowDrag='0'/></dataset>";
	//拼接样式设置
	var strStyle="<styles><definition><style name='myCaptionFont' type='font' font='Arial' size='14' bold='1' /> <style name='mySubCaptionFont' type='font' font='Arial' size='12' bold='0' /> </definition><application><apply toObject='Caption' styles='myCaptionFont' /> <apply toObject='SubCaption' styles='mySubCaptionFont' /></application></styles>";
	strXML+=strCategory+strDataset+strStyle;
	strXML+="</chart>";
	chart.setDataXML(strXML);
	chart.render("dragLinechartdiv1");
</script>
<script type="text/javascript">
	var chart = new FusionCharts("${_share_file_url!''}/gis/FMapLib/theme/images/DragColumn2D.swf", "dragLineId", "825", "350", "0", "0");  
	//拼接chart
	var strXML="<chart palette='1' caption='全市测绘' subcaption='按设计用途测绘套数统计' showvalues='0' xAxisName='年份' yAxisName='套数' restoreBtnBorderColor='A2A3A0' formBtnBorderColor='A2A3A0' canvasPadding='20' dragBorderColor='666666' dragBorderThickness='3' baseFontSize='12' chartRightMargin='30' showAboutMenuItem='0' showFormBtn='0' showRestoreBtn='0' >";
	//拼接x轴（categories）
	var strCategory="<categories>";
	[#list map.resultlist as remap]
		[#list remap.usedesignlist as usedesigntj]
			strCategory+="<category name='${usedesigntj.YEAR!''}年' />";
		[/#list]
		[#break]
	[/#list]
	strCategory+="</categories>";
	
	//拼接实测折线
	//拼接数据集
    var strDataset="";
	[#list map.resultlist as remap]
		strDataset+="<dataset id='${remap.USEDESIGN!''}' seriesName='${remap.USEDESIGN!''}' dragBorderColor='0099FF'>";
		[#list remap.usedesignlist as usedesigntj]
			strDataset+="<set id='${usedesigntj.YEAR!''}${usedesigntj.COUNT!''}' value='${usedesigntj.COUNT!''}' allowDrag='0'/>";
		[/#list]
		strDataset+="</dataset>";
	[/#list]
	
	//拼接x轴（categories）
	//var strCategory="<categories><category name='2005' /><category name='2006' /><category name='2007' /><category name='2008' /><category name='2009' /></categories>";
	//拼接折线
	//var strDataset="<dataset id='IJ' seriesName='实测' dragBorderColor='0099FF'><set id='IJ2005' value='1' allowDrag='0'/><set id='IJ2006' value='2' allowDrag='0'/><set id='IJ2007' value='1' allowDrag='0'/><set id='IJ2008' value='3' allowDrag='0'/><set id='IJ2009' value='2' allowDrag='0'/></dataset><dataset id='LJ' seriesName='预测' showValues='0' dragBorderColor='CC9900'><set id='LJ2005' value='3' allowDrag='0'/><set id='LJ2006' value='2' allowDrag='0'/><set id='LJ2007' value='3' allowDrag='0'/><set id='LJ2008' value='4' allowDrag='0'/><set id='LJ2009' value='3' allowDrag='0'/></dataset>";
	//拼接样式设置
	var strStyle="<styles><definition><style name='myCaptionFont' type='font' font='Arial' size='14' bold='1' /> <style name='mySubCaptionFont' type='font' font='Arial' size='12' bold='0' /> </definition><application><apply toObject='Caption' styles='myCaptionFont' /> <apply toObject='SubCaption' styles='mySubCaptionFont' /></application></styles>";
	strXML+=strCategory+strDataset+strStyle;
	strXML+="</chart>";
	chart.setDataXML(strXML);
	chart.render("chart3div");
</script>

<!--类型：${map.type!''}
[#list map.resultlist as remap]
	用途类型：${remap.USEDESIGN!''}
	[#list remap.usedesignlist as usedesigntj]
		年：${usedesigntj.YEAR!''}套数：${usedesigntj.COUNT!''}<br/>
	[/#list]
[/#list]-->