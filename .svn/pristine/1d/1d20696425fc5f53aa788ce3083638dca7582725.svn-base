<script type="text/javascript" src="${_share_file_url!''}/safemanage/resource/js/FusionCharts.js"></script>
<script type="text/javascript" src="${block.map_url!''}/gis/FMapLib/FMapLib.Include-1.0.4.js"></script>
<div id="mapdiv" style="position:absolute;right:30%;left:0px;width:70%;height:93%;border-color:white" visibility="visible"></div>
<div id="chart1div" align="center" style="position:absolute;right:0px;left:70%;width:30%;height:93%;"></div>
<script type="text/javascript">
//改表iframe的背景色
	$("#chart1div").parent().parent().attr("style","background-color:#FAFAFA");
   var chart = new FusionCharts("${_share_file_url!''}/safemanage/resource/images/Pie3D.swf", "DragColumnId", "100%", "400", "0", "0");
   //拼接chart
   var strXML="<chart palette='1' bgColor='FAFAFA' paletteColors='FFFF00,FF0000,CC6600,800080,0000CD,006400,008B8B' yAxisName='楼幢数' caption='2014年济南市老楼危楼安全排查' subcaption='按楼层统计' numberPrefix='楼幢数' useRoundEdges='1' bgColor='FFFFFF,FFFFFF' showBorder='0' exportEnabled='1' exportAtClient='1' exportHandler='fcBatchExporter' showAboutMenuItem='0' baseFontSize='10' plotSpacePercent=''>";
   //拼接数据集
   var strDataset="";
	[#list block.datalist as data]
		[#assign cj=""]
		[#if "${data.CENGJI!''}"=="1"][#assign cj="低层"][/#if]
		[#if "${data.CENGJI!''}"=="2"][#assign cj="多层"][/#if]
		[#if "${data.CENGJI!''}"=="3"][#assign cj="小高层"][/#if]
		[#if "${data.CENGJI!''}"=="4"][#assign cj="高层"][/#if]
		[#if "${data.CENGJI!''}"=="5"][#assign cj="其它"][/#if]
		strDataset+="<set label='${cj!''}' value='${data.COUNT}'  /> ";
	[/#list]
	//拼接样式设置
   var strStyle="<styles><definition><style name='myCaptionFont' type='font' font='Arial' size='14' bold='1' /><style name='mySubCaptionFont' type='font' font='Arial' size='12' bold='0' /></definition><application><apply toObject='Caption' styles='myCaptionFont' /><apply toObject='SubCaption' styles='mySubCaptionFont' /></application></styles>";
   strXML+=strDataset+strStyle+"</chart> "; 
   chart.setDataXML(strXML);   
   chart.render("chart1div");
var  map=new FMapLib.FMap("mapdiv");
//map.map.addControl(new MapLib.Control.PanZoomBar({
//	forceFixedZoomLevel : true
//})); 
var ids1="",ids2="",ids3="",ids4="",ids5="";
[#list block.linkdatalist as datta]
[#if "${datta.CENGJI!''}"=="1"]ids1=ids1+"${datta.SMUSERID!''}"+",";[/#if]
[#if "${datta.CENGJI!''}"=="2"]ids2=ids2+"${datta.SMUSERID!''}"+",";[/#if]
[#if "${datta.CENGJI!''}"=="3"]ids3=ids3+"${datta.SMUSERID!''}"+",";[/#if]
[#if "${datta.CENGJI!''}"=="4"]ids4=ids4+"${datta.SMUSERID!''}"+",";[/#if]
[#if "${datta.CENGJI!''}"=="5"]ids5=ids5+"${datta.SMUSERID!''}"+",";[/#if]
[/#list]
 drawColoredHouse(ids1,"#FFFF00");
 drawColoredHouse(ids2,"#FF0000");
 drawColoredHouse(ids3,"#CC6600");
 drawColoredHouse(ids4,"#800080");
 drawColoredHouse(ids5,"#0000CD");
function drawColoredHouse(ids,c){
	new FMapLib.DrawHouseCanvasById(map,ids,c);	
}
</script>