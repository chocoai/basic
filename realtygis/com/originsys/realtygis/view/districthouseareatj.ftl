<!--[#list map.relist as relist]
	类型：${relist.SURVERTYPE!''}<br/>
	[#list relist.typeList as typelist]
		年：${typelist.YEAR!''}<br/>
		[#list typelist.districtList as district]
			区县：${district.DISTRICT!''}----面积：${district.AREA!''}<br/>
		[/#list]
	[/#list]
[/#list]-->

<script type="text/javascript" src="${_share_file_url!''}/gis/FMapLib/theme/js/FusionCharts.js"></script>

[#list map.relist as relist]
<div id="${relist.SURVERTYPE!''}chartdiv" align="center" style="margin-bottom:10px;"></div>
<script type="text/javascript">
	var chart = new FusionCharts("${_share_file_url!''}/gis/FMapLib/theme/images/DragColumn2D.swf", "DragColumnId", "825", "350", "0", "0");
   //chart.setDataURL("data/DragCol1.xml");		
   //拼接chart
   var strXML="";
	[#if EnumService.getEnum('chtjlx')?exists]
	   [#list EnumService.getEnum('chtjlx') as enum]
				[#if "${relist.SURVERTYPE!''}" == "${enum.enum_value!''}"]
					strXML="<chart palette='2' caption='各区县测绘' subcaption='按年${enum.enum_name!''}房屋建筑面积统计' showvalues='0' xAxisName='区县' yAxisName='面积（单位：平方米）' restoreBtnBorderColor='A2A3A0' formBtnBorderColor='A2A3A0' showFormBtn='0' showRestoreBtn='0' chartRightMargin='30' baseFontSize='12' showAboutmenuItem='0'>";
				[/#if]
		[/#list]
	[/#if]
		
    //拼接x轴（categories）
   var strCategory="<categories>";
   [#list map.district as dd]
   		[#if EnumService.getEnum('xzqh')?exists]
		    [#list EnumService.getEnum('xzqh') as enum]
					[#if "${dd!''}" == "${enum.enum_value!''}"]
						strCategory+="<category name='${enum.enum_name!''}' />";
					[/#if]
			[/#list]
		[/#if]
	[/#list]
	strCategory+="</categories>";
	//拼接数据集
   var strDataset="";
	[#list relist.typeList as typelist]
	strDataset+="<dataset id='${typelist.YEAR!''}' seriesName='${typelist.YEAR!''}年'>";
		[#list typelist.districtList as dlist]
			strDataset+="<set id='${dlist.DISTRICT!''}${dlist.AREA!''}' value='${dlist.AREA!''}' allowDrag='0'/>";
		[/#list]
		strDataset+="</dataset>";
	[/#list]
	//拼接样式设置
   var strStyle="<styles><definition><style name='myCaptionFont' type='font' font='Arial' size='14' bold='1' /><style name='mySubCaptionFont' type='font' font='Arial' size='12' bold='0' /></definition><application><apply toObject='Caption' styles='myCaptionFont' /><apply toObject='SubCaption' styles='mySubCaptionFont' /></application></styles>";
   strXML+=strCategory+strDataset+strStyle+"</chart> ";
   
   chart.setDataXML(strXML);   
   chart.render("${relist.SURVERTYPE!''}chartdiv");
</script>
[/#list]