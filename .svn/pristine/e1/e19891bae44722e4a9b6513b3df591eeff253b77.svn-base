<script type="text/javascript" src="${_share_file_url!''}/gis/FMapLib/theme/js/FusionCharts.js"></script>
   
<div id="chart3div" align="center"></div>
<script type="text/javascript">
	var myChart3 = new FusionCharts("${_share_file_url!''}/gis/FMapLib/theme/images/Pie3D.swf", "myChartId3", "650", "300", "0", "1");
	
	//拼接chart
	var strXML="<chart yAxisName='Y轴值' caption='各区县在${map.surverStartDate!''}至${map.surverEndDate!''}年完成实际测绘的房屋建筑面积及占比情况统计' numberPrefix='面积(平方米)' useRoundEdges='1' bgColor='FFFFFF,FFFFFF' showBorder='0' exportEnabled='1' exportAtClient='1' exportHandler='fcBatchExporter' showAboutMenuItem='0' baseFontSize='12' plotSpacePercent=''>";
	//拼接set
	//var setXML="<set label='艾利克斯' value='25000'  /> <set label='Mark' value='35000' /> <set label='David' value='42300' /> <set label='Graham' value='35300' /> <set label='John' value='31300' />";
	var setXML="";
	[#list map.areatj as areatj]
   		[#if EnumService.getEnum('xzqh')?exists]
		    [#list EnumService.getEnum('xzqh') as enum]
					[#if "${areatj.DISTRICT!''}" == "${enum.enum_value!''}"]
						setXML+="<set label='${enum.enum_name!''}' value='${areatj.AREA!''}'/>";
					[/#if]
			[/#list]
		[/#if]
	[/#list]
	strXML+=setXML;
	strXML+="</chart>";

	myChart3.setDataXML(strXML);
	myChart3.render("chart3div");
	
	
</script>
  