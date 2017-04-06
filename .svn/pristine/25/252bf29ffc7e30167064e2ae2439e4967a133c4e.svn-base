<link rel="stylesheet" href="${_share_file_url!''}/gis/resource/qd/css/css.css" type="text/css" />
<link rel="stylesheet" href="${_share_file_url!''}/gis/resource/qd/css/styles.css" type="text/css" />
<link rel="stylesheet" href="${_share_file_url!''}/gis/resource/qd/css/jquery-tool.css" type="text/css" />
<link rel="stylesheet" href="${_share_file_url!''}/gis/resource/qd/css/style-detailed.css">
<style>
.td22{text-align:right;padding-right:12px;background-color:#F1F8FF;color:#2a51a4;}
.td23{padding-left:12px;background-color:#fff;color:#4D4D4D;}
.button_style{color:#333333;background:url(${_share_file_url!''}/gis/resource/qd/images/button_bj.jpg) repeat-x; border:1px #9ac8dc solid; height:28px;}
</style>
<script language="javascript">
function tog(obj){
	var show=$("#"+obj).css("display");
	if("block"==show){
		$("#"+obj).css("display","none");
		$("#"+obj+"_img").attr("src","${_share_file_url!''}/gis/resource/qd/images/down.png");
	}else{
		$("#"+obj).css("display","block");
		$("#"+obj+"_img").attr("src","${_share_file_url!''}/gis/resource/qd/images/upward.png");
	}
}
function togis(mapid){
	if(mapid==""){
		alert("无法定位！");
		return false;
	}else{
		var url = "${_server_url!''}/portal/realtygis.buildingmapidenty?building_mapid="+mapid;
        $("#newpage").attr("action",url);
		$("#newpage").submit();
	}
}
function tofcfht(){
	var url="${_server_url!''}/portal/realtygis.LayeredHouseholdFigure?building_id=${block.cehui_buildingid!''}";
	$("#newpage").attr("action",url);
	$("#newpage").submit();
}
function lpb(){
	var url="${_server_url!''}/portal/realtygis.housejson?building_id=${block.cehui_buildingid!''}&method=houseQue";
	$("#newpage").attr("action",url);
	$("#newpage").submit();
}
function docdownb(id){
	var url="${_servlet_url!''}/realtygis.buildingbasicproduct?building_id="+id;
	$("#newpage").attr("action",url);
	$("#newpage").submit();
}
function docdownp(id){
	var url="${_servlet_url!''}/realtygis.downloadproject?building_id="+id;
	$("#newpage").attr("action",url);
	$("#newpage").submit();
}
</script>
<form id="newpage" method="post" action="" target="_blank"></form> 
<div class="middle" style="overflow:hidden;">
    <div class="fcqd_search1">
    <div >
      <div id="page-wrap">
	  <div id="example-two">
	    <ul class="nav search_detailed">
		    <li class="nav-one"><a href="#featured2" class="current">房     屋</a></li>
				<li class="nav-two"><a href="#core2">业     主</a></li>
				<li class="nav-three"><a href="#jquerytuts2">开发商</a></li>
				<li class="nav-three"><a href="#jquerytuts2">中介机构</a></li>
				<li class="nav-four last"><a href="#classics2">物业公司</a></li>
		</ul>
		<div class="list-wrap">
			<ul id="featured2">
				<form id="form1" action="${_servlet_url!''}/datacenter.qdserch" method="post">
				<li class="search_button"><input type="text" name="keyword" class="search_detailed_input" value=""/>
	            </li>
	             <li class="fcqd_search_content1"><input type="submit" name="button"  class="search_content_button" value="" />
	            </li>
	            </form>
			</ul>
			
			<ul id="core2" class="hide">
				 <li class="search_button"><input type="text" name="textfield" class="search_detailed_input" value="输入关键字"/>
	            </li>
	             <li class="fcqd_search_content1"><input type="submit" name="button"  class="search_content_button" value="" />
	            </li>
			</ul>
			
			<ul id="jquerytuts2" class="hide">
				 <li class="search_button"><input type="text" name="textfield" class="search_detailed_input" value="输入关键字"/>
	            </li>
	             <li class="fcqd_search_content1"><input type="submit" name="button"  class="search_content_button" value="" />
	            </li>
			</ul>
			
			<ul id="classics2" class="hide">
				 <li class="search_button"><input type="text" name="textfield" class="search_detailed_input" value="输入关键字"/>
	            </li>
	             <li class="fcqd_search_content1"><input type="submit" name="button"  class="search_content_button" value="" />
	            </li>
			</ul>
		
		</div> <!-- END List Wrap -->	
  	</div> <!-- END Organic Tabs (Example One) -->	
	</div>
	</div>
</div>
<div class="theme">
	<ul>
    <li class="theme_big">主    题</li>
    <li class="theme_big1">安    全</li>
    <li class="theme_big1">登    记 </li>
    <li class="theme_big1">物    业</li>
    <li class="theme_big1">保    障 </li>
    <li class="theme_big1">交    易 </li>
    </ul>
</div>
[#if "${block.type!''}"=="house"]
<div class="info">
	<ul>
		<li class="info_1">
		<span class="info_button" onclick="tog('info0');"><img id="info0_img" src="${_share_file_url!''}/gis/resource/qd/images/upward.png" /></span>
		<img src="${_share_file_url!''}/gis/resource/qd/images/jbxx.png" width="16" height="20" align="absbottom" />  房屋信息
		</li>
	    <li class="info_content" style="display:block;" id="info0">
	          地址：${block.house.fw_address!''}&nbsp;&nbsp;设计用途：${block.house.design_yt!''}&nbsp;&nbsp;房屋产别：${block.house.fw_cb!''}&nbsp;&nbsp;房屋结构：${block.house.struct!''}&nbsp;&nbsp;
建筑面积：${block.house.jz_area!''}&nbsp;&nbsp;建成时间：${block.house.birth_date!''}
	    </li>
    </ul>  
</div>
[/#if]
<div class="info">
	<ul>
		<li class="info_1">
		<span class="info_button" onclick="tog('info1');"><img id="info1_img" src="${_share_file_url!''}/gis/resource/qd/images/upward.png" /></span>
		<img src="${_share_file_url!''}/gis/resource/qd/images/jbxx.png" width="16" height="20" align="absbottom" />  基本信息
		</li>
	    <li class="info_content" style="display:block;" id="info1">
	    [#assign yt="${block.building.use_design!''}"]
	    [#if EnumService.getEnum('sjyt')?exists]
	    [#list EnumService.getEnum('sjyt') as enum]
			[#if "${block.building.use_design!''}"=="${enum.enum_value!''}"]
				[#assign yt="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
		[#assign jg="${block.building.build_struct!''}"]
	    [#if EnumService.getEnum('fwjg')?exists]
	    [#list EnumService.getEnum('fwjg') as enum]
			[#if "${block.building.build_struct!''}"=="${enum.enum_value!''}"]
				[#assign jg="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
		[#assign fwcb="${block.building.real_type!''}"]
	    [#if EnumService.getEnum('fwcb')?exists]
	    [#list EnumService.getEnum('fwcb') as enum]
			[#if "${block.building.real_type!''}"=="${enum.enum_value!''}"]
				[#assign fwcb="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="table-layout:fixed;">
			<tr>
				<td class="td22" width="130">地址：</td>
				<td class="td23" colspan="3">${block.building.building_address!''}</td>
				<td class="td22" width="130">建造时间：</td>
				<td class="td23">${block.building.building_date!''}</td>
			</tr>
			<tr>
				<td class="td22">房屋产别：</td>
				<td class="td23" width="130">${fwcb!''}</td>
				<td class="td22">设计用途：</td>
				<td class="td23" width="150">${yt!''}</td>
				<td class="td22">房屋结构：</td>
				<td class="td23">${jg!''}</td>
			</tr>
			<tr>
				<td class="td22">施测单位：</td>
				<td class="td23">${block.building.unit!''}</td>
				<td class="td22">地上层数：</td>
				<td class="td23">${block.building.floorup_count!''}</td>
				<td class="td22">套数：</td>
				<td class="td23">${block.building.house_count!''}</td>
			</tr>
			<tr>
				<td class="td22">总套内建筑面积：</td>
				<td class="td23">${block.building.tn_area!''}</td>
				<td class="td22">总分摊共用面积：</td>
				<td class="td23">${block.building.ft_area!''}</td>
				<td class="td22">总建筑面积：</td>
				<td class="td23">${block.building.build_area!''}</td>
			</tr>
		</table>
	    </li>
    </ul>  
</div>
<div class="info">
	<ul>
		<li class="info_1">
		<span class="info_button" onclick="tog('info9');"><img id="info9_img" src="${_share_file_url!''}/gis/resource/qd/images/upward.png" /></span>
		<img src="${_share_file_url!''}/gis/resource/qd/images/qsbg.png" width="20" height="18" align="absbottom" />  竣工验收
		</li>
	    <li class="info_content" id="info9" style="display:block;">
	    	 <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="table-layout:fixed;">
	    	 <tr>
	    		<td class="td23">暂无数据</td>
				<td align="right" width="300px" style="background-color:#fff;">
			    <input type="button" value="设计图纸" class="button_style">
			    <input type="button" value="施工许可证" class="button_style">
			    <input type="button" value="验收报告" class="button_style">
	    		</td>
	    	 </tr>
	    	 </table>
	    </li>
    </ul>  
</div>
<div class="info">
	<ul>
		<li class="info_1">
		<span class="info_button" onclick="tog('info2');"><img id="info2_img" src="${_share_file_url!''}/gis/resource/qd/images/upward.png" /></span>
		<img src="${_share_file_url!''}/gis/resource/qd/images/chxx.png" width="20" height="18" align="absbottom" />  测绘信息
		</li>
	    <li class="info_content" id="info2" style="display:block;">
	    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="table-layout:fixed;">
	    [#list block.basiclist as basic]
	    	<tr>
	    		<td class="td22" width="80">测绘类型：</td>
				<td class="td23" width="110">基础测绘</td>
				<td class="td22" width="80">测绘时间：</td>
				<td class="td23" width="85">
				[#list "${basic.surverbasic_createdate!''}"?split(" ") as x]
				[#if x_index==0]${x}[/#if]
				[/#list]
				</td>
				<td class="td22" width="80">委托单位：</td>
				<td class="td23">${basic.entrust_unit!''}</td>				
				<td class="td23" width="170">
				<input type="button" value="报告下载" class="button_style" onclick="docdownb('${basic.building_id!''}');">
				<input type="button" value="地图定位" class="button_style" onclick="togis('${basic.building_mapid!''}');"></td>
			</tr>
	  	[/#list]	    
	    [#list block.plist as project]
	    [#assign chlx="${project.surver_type!''}"]
	    [#if EnumService.getEnum('chlx')?exists]
	    [#list EnumService.getEnum('chlx') as enum]
			[#if "${project.surver_type!''}"=="${enum.enum_value!''}"]
				[#assign chlx="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
			<tr>
				<td class="td22" width="80">测绘类型：</td>
				<td class="td23" width="110">项目测绘${chlx!''}</td>
				<td class="td22" width="80">测绘时间：</td>
				<td class="td23" width="85">
				[#list "${project.surverproject_createdate!''}"?split(" ") as x]
				[#if x_index==0]${x}[/#if]
				[/#list]
				</td>
				<td class="td22" width="80">委托单位：</td>
				<td class="td23">${project.entrust_unit!''}</td>
				<td class="td23" width="170">
				[#if "${project.surverproject_name!''}"!=""]
				<input type="button" value="报告下载" class="button_style"onclick="docdownp('${project.building_id!''}');">[/#if]</td>
			</tr>
	   	[/#list]
	    	<tr>
	    		<td class="td23" colspan="5">[#if block.basiclist?size==0&&block.plist?size==0]暂无数据[/#if]</td>
				<td class="td23" colspan="2" align="right">
			    <input type="button" value="分层分户图" class="button_style" onclick="tofcfht();">
			    <input type="button" value="楼盘表" class="button_style" onclick="lpb();">
	    		</td>
	    	</tr>
	    </table>
	    </li>
    </ul>  
</div>
<div class="info">
	<ul>
		<li class="info_1">
		<span class="info_button" onclick="tog('info3');"><img id="info3_img" src="${_share_file_url!''}/gis/resource/qd/images/upward.png" /></span>
		<img src="${_share_file_url!''}/gis/resource/qd/images/aqgl.png" width="20" height="18" align="absbottom" />  安全管理
		</li>
	    <li class="info_content" id="info3" style="display:block;">
	    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="table-layout:fixed;">
	    	[#list block.safelist as safe]
	    	<tr>
				<td class="td22" width="100">操作类型：</td>
				<td class="td23">${safe.op!''}</td>
				<td class="td22" width="50">时间：</td>
				<td class="td23" width="100">${safe.opdate!''}</td>
				<td class="td22" width="100">安全等级：</td>
				<td class="td23" width="40">
				[#if "${safe.opresult!''}"=="1"]A级[/#if]
				[#if "${safe.opresult!''}"=="2"]B级[/#if]
				[#if "${safe.opresult!''}"=="3"]C级[/#if]
				[#if "${safe.opresult!''}"=="4"]D级[/#if]
				</td>
				<!-- td class="td22" width="70">危楼类型：</td>
				<td class="td23" width="90">${safe.optype!''}</td -->
				<td class="td22" width="120">相关图片/附件：</td>
				<td class="td23">
				[#if "${safe.annex_image!''}"!=""]<a href="${safe.annex_image!''}" target="_blank">相关图片</a>[/#if]
				[#if "${safe.annex_file!''}"!=""]<a href="${safe.annex_file!''}">报告下载</a>[/#if]
				</td>
			</tr>
			[/#list]
	    </table>
	    </li>
    </ul>  
</div>
<div class="info">
	<ul>
		<li class="info_1">
		<span class="info_button" onclick="tog('info4');"><img id="info4_img" src="${_share_file_url!''}/gis/resource/qd/images/upward.png" /></span>
		<img src="${_share_file_url!''}/gis/resource/qd/images/qsbg.png" width="20" height="18" align="absbottom" />  权属登记
		</li>
	    <li class="info_content" id="info4" style="display:block;">
	    	 <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="table-layout:fixed;">
	    	 <tr>
	    		<td class="td23">暂无数据</td>
				<td align="right" width="100px" style="background-color:#fff;">
			    <input type="button" value="登记薄" class="button_style">
	    		</td>
	    	 </tr>
	    	 </table>
	    </li>
    </ul>  
</div>
<div class="info">
	<ul>
		<li class="info_1">
		<span class="info_button" onclick="tog('info5');"><img id="info5_img" src="${_share_file_url!''}/gis/resource/qd/images/upward.png" /></span>
		<img src="${_share_file_url!''}/gis/resource/qd/images/wyxx.png" width="20" height="18" align="absbottom" />  物业管理
		</li>
	    <li class="info_content" id="info5" style="display:block;">
	    暂无数据
	    </li>
    </ul>  
</div>
<div class="info">
	<ul>
		<li class="info_1">
		<span class="info_button" onclick="tog('info15');"><img id="info15_img" src="${_share_file_url!''}/gis/resource/qd/images/upward.png" /></span>
		<img src="${_share_file_url!''}/gis/resource/qd/images/wyxx.png" width="20" height="18" align="absbottom" />  住房保障
		</li>
	    <li class="info_content" id="info15" style="display:block;">
	    暂无数据
	    </li>
    </ul>  
</div>
<div class="info">
	<ul>
		<li class="info_1">
		<span class="info_button" onclick="tog('info7');"><img id="info7_img" src="${_share_file_url!''}/gis/resource/qd/images/upward.png" /></span>
		<img src="${_share_file_url!''}/gis/resource/qd/images/qsbg.png" width="20" height="18" align="absbottom" />  诚信档案
		</li>
	    <li class="info_content" id="info7" style="display:block;">
	    暂无数据
	    </li>
    </ul>  
</div>

<div class="info">
	<ul>
		<li class="info_1">
		<span class="info_button" onclick="tog('info6');"><img id="info6_img" src="${_share_file_url!''}/gis/resource/qd/images/upward.png" /></span>
		<img src="${_share_file_url!''}/gis/resource/qd/images/fjzs.png" width="20" height="18" align="absbottom" />  房价走势
		</li>
	    <li class="info_content" id="info6" style="display:block;">
	    暂无数据
	    </li>
    </ul>  
</div>
