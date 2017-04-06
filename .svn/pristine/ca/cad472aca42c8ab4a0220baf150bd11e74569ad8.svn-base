<script type="text/javascript" src="${_share_file_url!''}/resource/js/swfobject.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/ui.upload.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	$("#outdiv").css("display","block");
	$("#tabs").tabs({cache:false});		
});
</script>
	<div class="widget-title-normal">
		<div class="child">
			<span class="widget-title-text">
				危房详细
			</span>
		</div>
	</div>
<div id="outdiv" style="display:none">
	<!--div  id="buttons" style="text-align:right">
		<button type="button" onclick="javascript:window.history.go(-1);" >返回</button>
	</div-->
	<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .1em;">
		<div class="ui-widget" id="tabs">
			<ul>
				<li><a href="#tabs-1">楼幢信息</a></li>
				<li><a href="#tabs-2">跟踪处置</a></li>
				<li><a href="#tabs-3">鉴定信息</a></li>
				<li><a href="#tabs-4">整治情况</a></li>
				<!--<li><a href="#tabs-4">维修记录</a></li>-->
			</ul>				
			<div id="tabs-1">
				<!--基本信息-->
				[#import "buildingdetail.ftl" as basemessage /]
				[@basemessage.building_info building=block.building /]		
			</div>
			<div id="tabs-2">	
				<div class="ui-widget"  style="position: relative;padding: .2em;">
				<table  class="ui-widget-content ui-widget-table ui-corner-all" cellspacing="1">
					[#list block.loglist as dlog]
					[#if dlog_index%2=0]
					 <tr>
					[#else]
					<tr class="odd">
					[/#if]
					<td>
					${dlog_index+1}:&nbsp;&nbsp;
					处置时间:${dlog.op_date?string('yyyy-MM-dd')}&nbsp;&nbsp;
					处置内容:${dlog.op_content!''}
					</td>
					</tr>
					[/#list>
				</table>
				</div>
			</div>
			<div id="tabs-3">	
				<div class="ui-widget"  style="position: relative;padding: .2em;">
				<table class="ui-widget-content ui-widget-table ui-corner-all" cellspacing="1">
					<tr class="odd"><td>鉴定地址</td><td>鉴定单位</td><td>鉴定时间</td><td>鉴定报告</td><td>相关图片</td></tr>
					[#list block.reportlist as report]
					[#if report_index%2=0]
					<tr>
					[#else]
					<tr class="odd">
					[/#if]
					<td>${report.building_address!''}</td>
					<td>${report.jd_department!''}</td>
					<td>[#if report.jd_date?exists]${report.jd_date?string('yyyy-MM-dd')}[/#if]</td>
					<td>[#if "${report.jd_report!''}"!=""]<a href="${_server_url!''}${report.jd_report!''}" target="download">报告下载</a>[/#if]</td>
					<td>[#if "${report.jd_image!''}"!=""]<a href="${report.jd_image!''}" target="_blank">查看图片</a>[/#if]</td>
					</tr>
					[/#list>
				</table>
				</div>
			</div>	
			
			<div id="tabs-4">	
				<div class="ui-widget"  style="position: relative;padding: .2em;">
				<table  class="ui-widget-content ui-widget-table ui-corner-all" cellspacing="1">
					[#list block.wfzzList as wfzz]
					[#if wfzz_index%2=0]
					 <tr>
					[#else]
					<tr class="odd">
					[/#if]
					<td>
					${wfzz_index+1}:&nbsp;&nbsp;
					整治时间:${wfzz.create_time?string('yyyy/MM/dd hh:MM:ss')}&nbsp;&nbsp;
					整治内容:${wfzz.wfzz_content!''}
					</td>
					</tr>
					[/#list>
				</table>
				</div>
			</div>
					
			
		</div>
	</div>	
</div>
<iframe id="download" name="download" height="0px" width="0px"></iframe>
