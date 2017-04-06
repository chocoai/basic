<script type="text/javascript" src="${_share_file_url!''}/gis/FMapLib/theme/js/FusionCharts.js"></script>
<div id="chart1div" align="center"></div>
<script type="text/javascript">

   var chart = new FusionCharts("${_share_file_url!''}/gis/FMapLib/theme/images/DragColumn2D.swf", "DragColumnId", "825", "350", "0", "0");
   //chart.setDataURL("data/DragCol1.xml");		
   //拼接chart
   var strXML="<chart palette='2' caption='各区县测绘' subcaption='基础测绘面积统计' showvalues='0' xAxisName='区县' yAxisName='面积（单位：平方米）' restoreBtnBorderColor='A2A3A0' formBtnBorderColor='A2A3A0' showFormBtn='0' showRestoreBtn='0' chartRightMargin='30' baseFontSize='12' showAboutmenuItem='0'>";
   //拼接x轴（categories）
   var strCategory="<categories>";
   	[#list map.district as district]
   		[#if EnumService.getEnum('xzqh')?exists]
		    [#list EnumService.getEnum('xzqh') as enum]
					[#if "${district!''}" == "${enum.enum_value!''}"]
						strCategory+="<category name='${enum.enum_name!''}' />";
					[/#if]
			[/#list]
		[/#if]
	[/#list]
	strCategory+="</categories>";
	//拼接数据集
   var strDataset="";
	[#list map.areatj as areatj]
	strDataset+="<dataset id='${areatj.YEAR!''}' seriesName='${areatj.YEAR!''}年'>";
		[#list areatj.AreaList as arealist]
			strDataset+="<set id='${areatj.YEAR!''}${arealist.AREA!''}' value='${arealist.AREA!''}' allowDrag='0'/>";
		[/#list]
		strDataset+="</dataset>";
	[/#list]
	//拼接样式设置
   var strStyle="<styles><definition><style name='myCaptionFont' type='font' font='Arial' size='14' bold='1' /><style name='mySubCaptionFont' type='font' font='Arial' size='12' bold='0' /></definition><application><apply toObject='Caption' styles='myCaptionFont' /><apply toObject='SubCaption' styles='mySubCaptionFont' /></application></styles>";
   strXML+=strCategory+strDataset+strStyle+"</chart> ";
   
   chart.setDataXML(strXML);   
   chart.render("chart1div");
</script>

<!--￥{map.type!''}
[#list map.areatj as areatj]
	年：${areatj.YEAR!''}
	[#list areatj.AreaList as arealist]
		县市：${arealist.DISTRICT!''}面积：${arealist.AREA!''}<br/>
	[/#list]
[/#list]-->