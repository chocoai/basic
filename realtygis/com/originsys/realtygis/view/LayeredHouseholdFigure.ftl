<script src="${_share_file_url!''}/gis/FMapLib/FMapLib.Include.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.treeview.js" type="text/javascript"></script>
<link href="${_share_file_url!''}/resource/css/jquery.treeview.css" type="text/css" rel="stylesheet"/>
<link href="${_share_file_url!''}/resource/js/frame/frame.css" rel="stylesheet" type="text/css" />
<style>
.tdpad {padding-left:4px; background-color:#ffffff}
</style>
<script language="javascript">
$(function() {
    $("#loadPic").click(function(){    
    initMap();    
    })
	$("#browser").treeview({
		animated:"normal",
		persist: "location",
		collapsed:true,
		unique: true
	});
	
	$(window).resize(function(){
		resetWorkset();
	});
	
	function getPageSize() {
		var winW, winH;
		if(window.innerHeight) {// all except IE
			winW = window.innerWidth;
			winH = window.innerHeight;
		} else if (document.documentElement && document.documentElement.clientHeight) {// IE 6 Strict Mode
			winW = document.documentElement.clientWidth;
			winH = document.documentElement.clientHeight;
		} else if (document.body) { // other
			winW = document.body.clientWidth;
			winH = document.body.clientHeight;
		}  // for small pages with total size less then the viewport 
			return {WinW:winW, WinH:winH};
 	} 
 	$("#div_tree_scroll").css("height",((getPageSize().WinH-20) + 'px'));
	$("#div_news_tree_scroll").css("height",((getPageSize().WinH-20) + 'px'));
	$("#pic_div").css("height",((getPageSize().WinH-90) + 'px'));
});
function resetWorkset() {
	$("#div_tree_scroll").css("height",((getPageSize().WinH-20) + 'px'));
	$("#div_news_tree_scroll").css("height",((getPageSize().WinH-20) + 'px'));
	$("#pic_div").css("height",((getPageSize().WinH-90) + 'px'));
}
function showinfo(house_id,map_id){
	$.post("${_servlet_url!''}/realtygis.housedetail?house_id="+house_id,""
			,function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					$("#td1").text(jdata.fw_dh);
					$("#td2").text(jdata.fw_address);
					$("#td3").text(jdata.unit_number);
					$("#td4").text(jdata.room_number);
					$("#td5").text(jdata.lay_num);
		});
	houseidenty(map_id);
}
//房间定位
function houseidenty(map_id){
var queryParam, queryBySQLParams, queryBySQLService;
		queryParam = new MapLib.REST.FilterParameter({
			name : building_layername||null,
			attributeFilter : "smuserid = "+map_id+" and buildingid="+${map.term.building_id}

		});
		queryBySQLParams = new MapLib.REST.QueryBySQLParameters({
			queryParams : [ queryParam ]
		});

		queryBySQLService = new MapLib.REST.QueryBySQLService(
				url, {
					eventListeners : {
						"processCompleted" : surveyCompleted,
						"processFailed" : processFailed
					}
				});
		queryBySQLService.processAsync(queryBySQLParams);

}
        /**
		 * 查询结束后渲染定位
		 */
		function surveyCompleted(queryEventArgs) {			   
			var i, j, feature, result = queryEventArgs.result;
			var style = {
				strokeColor : "#FFFF00",
				strokeWidth : 1,
				fillColor : "#FFFF00",
				fillOpacity : "0.5"
			};
			vectorLayer.removeAllFeatures();
			if (result && result.recordsets) {			
				for (i = 0; i < result.recordsets.length; i++) {
					if (result.recordsets[i].features) {
						for (j = 0; j < result.recordsets[i].features.length; j++) {
							feature = result.recordsets[i].features[j];
							feature.style = style;							
							vectorLayer.addFeatures(feature);							
						}
					}
				}
			}
			// 定位所选择的房屋
			var x = feature.geometry.getBounds().getCenterLonLat().lon;
			var y = feature.geometry.getBounds().getCenterLonLat().lat;
			var lonLat = new MapLib.LonLat(x, y);
			map.setCenter(lonLat, 2);		
		}
    /**
	 * 查询失败 公用方法
	 */
	function processFailed(e) {
		doMapAlert("map", "", e.error.errorMsg, true);
	}
	// 消息提示框
	function doMapAlert(id, tip, message, success) {
		if ($('#mapAlert').size()) {
			$('div').remove('#mapAlert');
		}
		if (tip) {
			tip += ':';
		}
		if (!success) {
			var htmlString = '<div id="mapAlert" class="alert alert-success fade in" style="background-color:yellow;position:absolute; top: 35px; left: 30%; width:30%; z-index: 2000; text-align: center; ">'
					+ '<strong>' + tip + '</strong>' + message + '</div>';
		} else {
			var htmlString = '<div id="mapAlert" class="alert alert-error fade in" style="position:absolute; top: 35px; left: 25%; width:50%; z-index: 2000;text-align: center;">'
					+ '<strong>' + tip + '</strong>' + message + '</div>';

		}
		$('#' + id).append($(htmlString));
	}
//定义地图要素
//声明变量map、layer、url；
      var map, layer,  vectorLayer,
    url = FMapLib.DemoURL.fencenghu;
    // 比例尺自定义
	var scales = [1/100, 1 / 200,1 / 500,1 / 1000,1 /2000];
	var building_layername;//建筑物所在面图层名称
//初始化地图
	function initMap(){   
	 var buildingId=${map.term.building_id};
	 var a=isExsistedData(buildingId);
	 if(a){     
	 map = new MapLib.Map("pic_div", {
			controls : [
					 new MapLib.Control.Navigation({
						dragPanOptions : {
							enableKinetic : true
						}
					}) ],
			units : "m"
		});              
       layer = new MapLib.Layer.TiledDynamicRESTLayer("分层分户图",
				url, {
					transparent : true,
					cacheEnabled : true
				}, {
					scales : scales,
				//	maxResolution : "auto"
					numZoomLevels : 5					
				});
		// 初始化vectorLayer图层		
		vectorLayer = new MapLib.Layer.Vector("Vector Layer");
		
	layer.events.on({
	"layerInitialized" : function() {
				map.addLayers([layer,vectorLayer]);
				map.setBaseLayer(layer);
		//要素选择控件，该控件实现在指定的的图层上通过鼠标单击和悬浮选择矢量要素。
	   var selectFeature = new MapLib.Control.SelectFeature(vectorLayer, {
			onSelect : onFeatureSelect,
			onUnselect : onFeatureUnselect
		});
		selectFeature.repeat = true;
		map.addControl(selectFeature);
		selectFeature.activate();
		/**
		 * 在指定几何图形上方弹出信息查阅窗口
		 */
		function onFeatureSelect(feature) {
			var retValue = feature.attributes;
			var x = feature.geometry.getBounds().getCenterLonLat().lon;
			var y = feature.geometry.getBounds().getCenterLonLat().lat;
			var contentHTML = "<div style='font-size:1em; opacity: 0.8; overflow-y:hidden;';width:150px;height:40px>"
			contentHTML += "<div>数据来源：" + (retValue['CLASSID']=="0"?"超图":"超智") + "<div>";
			contentHTML += "<div>图层标签：" + retValue['DOOR_NUM'] + "<div>";					
			contentHTML += "<div>面积参考值：" + retValue['SMAREA'] + "平方米<div>";
			contentHTML += "</div>";
			// 初始化一个弹出窗口，当某个地图要素被选中时会弹出此窗口，用来显示选中地图要素的属性信息
			popup = new MapLib.Popup.FramedCloud("popwin",
					new MapLib.LonLat(x, y), null, contentHTML, null, true,
					null, true);
			feature.popup = popup;
			map.addPopup(popup);
		}
		// 图形丢失选中状态后
		function onFeatureUnselect(feature) {
			map.removePopup(feature.popup);
			feature.popup.destroy();
			feature.popup = null;
		}			
	     buildingIdenty(buildingId);//初始化当前楼幢面视图				
	  }
	});
  }else{	
	 $("#pic_div").append("<h2><span style='padding-left:50%'>暂无图形数据<span></h2>");
   }
}
	//建筑物定位
	function buildingIdenty(buildingId){	
      var queryParam, queryBySQLParams, queryBySQLService;
		queryParam = new MapLib.REST.FilterParameter({
			name : "st_grid_region@ORCL_fcch",
			attributeFilter : "BUILDINGID = "+buildingId

		});
		queryBySQLParams = new MapLib.REST.QueryBySQLParameters({
			queryParams : [ queryParam ]
		});

		queryBySQLService = new MapLib.REST.QueryBySQLService(
				url, {
					eventListeners : {
						"processCompleted" : surveyBuildingCompleted,
						"processFailed" : processFailed
					}
				});
		queryBySQLService.processAsync(queryBySQLParams);

}
        /**
		 * 查询结束后建筑物定位
		 */
		function surveyBuildingCompleted(queryEventArgs) {
			var i, j, feature, result = queryEventArgs.result;			
			if (result && result.recordsets) {
				for (i = 0; i < result.recordsets.length; i++) {
					if (result.recordsets[i].features) {
						for (j = 0; j < result.recordsets[i].features.length; j++) {
							feature = result.recordsets[i].features[j];                           
						}
					}
				}
			}
			// 定位所选择的房屋
			var x = feature.geometry.getBounds().getCenterLonLat().lon;
			var y = feature.geometry.getBounds().getCenterLonLat().lat;
			var lonLat = new MapLib.LonLat(x, y);
			map.setCenter(lonLat, 1);			
		}
//查询分层分户图是否入库
function isExsistedData(a){
var isEx=true;
$.ajax({ 
	          type : "post", 
	          url : "${_servlet_url!''}/realtygis.LayeredHouseholdFigureCount?building_id="+a, 
	          data : "" , 
	          async : false, 
	          success : function(data){ 
	      		var jdata = jQuery.parseJSON(data);
	      		if(jdata){	      		
					if(jdata.geoCount==0)
							isEx=false;									
				    if(!!jdata.layerNumber){				   
                    var ss = jdata.layerNumber.toString().replace(/ /g, ""); //正则表达公式去除右侧空格
                     if(ss=='0')
                        isEx=false;
                        else{
				             building_layername="ST_Region"+ss+"@ORCL_fcch"
				              url=url+ss
				       }
				 }else
				            isEx=false;					
				}
	      	 }		
	   }); 
  return isEx;    
}		
</script>

<body onload="initMap()">
<table class="frame_main">
	<tr>
		<td id="td_left" class="bg_color" style="overflow:auto;" algin="top" valign="top">
			<!-- ie6识别"_",ie7识别"*",ie9都不识别。ie6,ie7是div_tree_scroll出现滚动条,ie9td出现滚动条 -->
			<div id="div_tree_scroll" style="width:40%; *height:expression((window) && ((document.documentElement.clientHeight - 84) + 'px')); _height:expression((window) && ((document.documentElement.clientHeight - 84) + 'px')); overflow:hidden;">
			 	<div id="div_news_tree_scroll" style="width:210px; *height:expression((window) && ((document.documentElement.clientHeight - 127) + 'px')); _height:expression((window) && ((document.documentElement.clientHeight - 127) + 'px')); overflow:auto;">
					 	<!--left menu start -->
						<ul id="browser" class="treeview  filetree"  style="overflow:visible; white-space:nowrap;">
						    [#list map.laylist as lay] 
						    <li><span class="folder">第${lay.lay_num!''}层</span>
						    	<ul>
						    	[#list map.all_unitlist as unit]
						    		<li><span class="folder">${unit.UNIT_NUMBER!''}单元</span>
										<ul>
										[#list map.houselist as house]
											[#if house.lay_num==lay.lay_num&&"${house.unit_number!''}"=="${unit.UNIT_NUMBER!''}"]
											<li><a class="file" style="cursor:hand" onclick="showinfo('${house.house_id!''}','${house.map_id!''}');">${house.room_number!''}</a></li>
											[/#if]
										[/#list]
										</ul>
									</li>
								[/#list]
								</ul>
						    </li>
						    [/#list]
						</ul>
				</div>
			</div>
		</td>
		<td algin="top" valign="top">		   
		   <!--图片存放-->
		  <!-- <div><a id="loadPic" style="cursor:pointer;color:green" target="main">重新加载分层分户图</a></div>-->		  
		   <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;top:500px">
				<tr>
					<td class="tdpad">房屋地号</td>
					<td class="tdpad">房屋坐落</td>
					<td class="tdpad">单元号</td>
					<td class="tdpad">房号</td>
					<td class="tdpad">所在建筑物层数</td>
				</tr>
				<tr>
					<td class="tdpad"><span id="td1">&nbsp;</span></td>
					<td class="tdpad"><span id="td2">&nbsp;</span></td>
					<td class="tdpad"><span id="td3">&nbsp;</span></td>
					<td class="tdpad"><span id="td4">&nbsp;</span></td>
					<td class="tdpad"><span id="td5">&nbsp;</span></td>
				</tr>
			</table></br>
		 <div id="pic_div" style="position: absolute;left:20%;right: 0px; width: 100%; height: 100%;border-color:white">		   
		 </div>
		</td>
	</tr>	
</table>
</body>