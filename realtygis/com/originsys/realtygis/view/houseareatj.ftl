<script type="text/javascript" src="${_share_file_url!''}/gis/FMapLib/theme/js/FusionCharts.js"></script>
<div id="chart1div" align="left"></div>
<script type="text/javascript">

   var chart = new FusionCharts("${_share_file_url!''}/gis/FMapLib/theme/images/DragColumn2D.swf", "DragColumnId", "725", "450", "0", "0");
   //chart.setDataURL("data/DragCol1.xml");		
   //拼接chart
   var strXML="<chart palette='2' caption='房屋数量统计' subcaption='按房屋建筑面积分类统计房屋数量' showvalues='0' xAxisName='地址' yAxisName='数量' restoreBtnBorderColor='A2A3A0' formBtnBorderColor='A2A3A0' showFormBtn='0' showRestoreBtn='0' chartRightMargin='30' baseFontSize='12' showAboutmenuItem='0'>";
   //拼接x轴（categories）
   var strCategory="<categories>";
   //拼接数据集
   var strDatasetSmall="<dataset id='small' seriesName='小于90平方米'>";
   var strDatasetHit="<dataset id='hit' seriesName='90~144平方米'>";
   var strDatasetBig="<dataset id='big' seriesName='大于144平方米'>";
   [#list map.houseareatj as house]
   		strCategory+="<category name='${house.ADDRESS!''}' />";
   		strDatasetSmall+="<set id='${house.BUILDINGID!''}${house.SMALLHOUSECOUNT!''}' value='${house.SMALLHOUSECOUNT!''}' allowDrag='0'/>";
   		strDatasetHit+="<set id='${house.BUILDINGID!''}${house.HITHOUSECOUNT!''}' value='${house.HITHOUSECOUNT!''}' allowDrag='0'/>";
   		strDatasetBig+="<set id='${house.BUILDINGID!''}${house.BIGHOUSECOUNT!''}' value='${house.BIGHOUSECOUNT!''}' allowDrag='0'/>";
	[/#list]
	strCategory+="</categories>";
	strDatasetSmall+="</dataset>";
	strDatasetHit+="</dataset>";
	strDatasetBig+="</dataset>";
 
	//拼接样式设置
   var strStyle="<styles><definition><style name='myCaptionFont' type='font' font='Arial' size='14' bold='1' /><style name='mySubCaptionFont' type='font' font='Arial' size='12' bold='0' /></definition><application><apply toObject='Caption' styles='myCaptionFont' /><apply toObject='SubCaption' styles='mySubCaptionFont' /></application></styles>";
   strXML+=strCategory;
   [#if "${map.small!''}"=="1"]
   	strXML+=strDatasetSmall;
   [/#if]
   [#if "${map.middle!''}"=="1"]
   	strXML+=strDatasetHit;
   [/#if]
   [#if "${map.big!''}"=="1"]
   	strXML+=strDatasetBig;
   [/#if]
   strXML+=strStyle+"</chart> ";
   
   chart.setDataXML(strXML);   
   chart.render("chart1div");
</script>



<!--类型：[#if map.type?exists]${map.type!''}[/#if]
[#list map.houseareatj as house]
	地址：${house.ADDRESS!''}小于90：${house.SMALLHOUSECOUNT!''}大于90小于144：${house.HITHOUSECOUNT!''}大于144：${house.BIGHOUSECOUNT!''}<br/>
[/#list]-->