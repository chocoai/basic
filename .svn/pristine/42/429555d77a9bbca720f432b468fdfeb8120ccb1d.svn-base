<!--[#list map.relist as relist]
	等级：${relist.SAFEGRADE!''}<br/>
	[#list relist.districtList as dislist]
		区县：${dislist.DISTRICT!''}-----楼幢数：${dislist.COUNT!''}<br/>
	[/#list]
[/#list]-->
<script type="text/javascript" src="${_share_file_url!''}/safemanage/resource/js/FusionCharts.js"></script>
<div id="chart1div" align="center" style="margin-top:60px;"></div>
<script type="text/javascript">
//改表iframe的背景色
	$("#chart1div").parent().parent().attr("style","background-color:#FAFAFA");
   var chart = new FusionCharts("${_share_file_url!''}/safemanage/resource/images/DragColumn2D.swf", "DragColumnId", "825", "350", "0", "0");
   //chart.setDataURL("data/DragCol1.xml");		
   //拼接chart
   var strXML="<chart palette='1' paletteColors='FFFF00,FF0000,FFA500,800080,0000CD,006400,008B8B' caption='2014年济南市老楼危楼安全排查' subcaption='按等级楼幢数统计' showvalues='0' xAxisName='区县' yAxisName='楼幢数' restoreBtnBorderColor='A2A3A0' formBtnBorderColor='A2A3A0' showFormBtn='0' showRestoreBtn='0' chartRightMargin='30' baseFontSize='12' showAboutmenuItem='0'>";
   //拼接x轴（categories）
   var strCategory="<categories>";
   	[#list map.district as district][#if district_index!=0]
   		[#if EnumService.getEnum('xzqh')?exists]
		    [#list EnumService.getEnum('xzqh') as enum]
					[#if "${district!''}" == "${enum.enum_value!''}"]
						strCategory+="<category name='${enum.enum_name!''}' />";
					[/#if]
			[/#list]
		[/#if][/#if]
	[/#list]
	strCategory+="</categories>";
	//拼接数据集
   var strDataset="";
	[#list map.relist as relist]
		[#if "${relist.SAFEGRADE!''}"=='4'][#assign safegrade='有问题房屋']
		strDataset+="<dataset id='${relist.SAFEGRADE!''}' seriesName='${safegrade!''}'>";
		[#list relist.districtList as dislist][#if dislist_index!=0]
			strDataset+="<set id='${relist.SAFEGRADE!''}${dislist.DISTRICT!''}' value='${dislist.COUNT!''}' allowDrag='0'/>";
		[/#if][/#list]
		strDataset+="</dataset>";[/#if]
	[/#list]
	strDataset+="<dataset id='total' seriesName='普查总数'>";
	[#list map.district as district][#if district_index!=0]
	   	[#assign count=0]
	   	[#list map.relist as relist]
			[#list relist.districtList as dislist]
				[#if "${district!''}" == "${dislist.DISTRICT!''}"]
					[#assign count=count+dislist.COUNT]
				[/#if]
			[/#list]
		[/#list]
		strDataset+="<set id='total${district!''}' value='${count!''}' allowDrag='0'/>";[/#if]
	[/#list]strDataset+="</dataset>";
	
	//拼接样式设置
   var strStyle="<styles><definition><style name='myCaptionFont' type='font' font='Arial' size='14' bold='1' /><style name='mySubCaptionFont' type='font' font='Arial' size='12' bold='0' /></definition><application><apply toObject='Caption' styles='myCaptionFont' /><apply toObject='SubCaption' styles='mySubCaptionFont' /></application></styles>";
   strXML+=strCategory+strDataset+strStyle+"</chart> ";
   
   chart.setDataXML(strXML);   
   chart.render("chart1div");
</script>