<script src="${block.map_url!''}/gis/FMapLib/FMapLib.Include-1.0.4.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<style type="text/css">
body{
	margin: 0;
	overflow: hidden;
	background: #fff;
}
#menu{position:absolute;border-radius:3px;list-style-type:none;border:1px solid #A0A0A0;padding:1 1 1 1px;background:#F0F0F0;}
#menu li a{font-size:14px;font-family:微软雅黑;display:block;color:#333;background:#F0F0F0;padding-left:0px;padding-right:5px;text-decoration:none;list-style-type: none;}
#menu li.active{background:#999;}
#menu li.active a{color:#fff;background:#8f8f8f;}

#common_box{width:285px;height:300px;position:fixed;_position:absolute;right:0;top:25%;border:1px solid #789;background:#fff;z-index:88}
#cli_on{width:15px;height:300px;float:left;cursor:pointer;background:#ac8932;text-align:center;line-height:300px}
</style>
<script language="javascript" type="text/javascript">
var host = document.location.toString().match(/file:\/\//)?"http://localhost:8091":'http://' + document.location.host;
var map, local, layer,drawPoint,drawLayer,popup,mulDrawPoint,renderLayerMul,selectFeature,listData=[],markerLayer,
//url=host+"/iserver/services/map-world/rest/maps/World";
url=FMapLib.DemoURL.fangchanL;
var url2=FMapLib.DemoURL.fangchan;
var houseLayer="ST_RIDRGN_safecheck@ORCL";
// 比例尺自定义
var scales = FMapLib.scales;	
var isHasSelected = false,	              
style = {
	strokeColor: "#304DBE",
	strokeWidth: 1,
	pointerEvents: "visiblePainted",
	pointRadius: 5,
	fillColor: "#304DBE",
	fillOpacity: 0.5
};
$(function(){
	$("#updateInfo").click(function(){
		if($("#project_buildingids").val()==""){
			alert("请选择楼幢");
			return false;
		}
		var queryString=$("#updateForm").formSerialize();
		$.post($("#updateForm").attr("action"),queryString,
			function(data,textStatus){
				var jdata=jQuery.parseJSON(data);
				if(jdata.success==1){
					alert("保存成功！");
					if (window.showModalDialog!=null){
						window.close();//firefox不支持			
					}else{
						top.close();//IE和FireFox都支持
					}
				}else{
					alert("保存失败！");
				}
		});
	});	
	//定义layer图层，TiledDynamicRESTLayer：分块动态 REST 图层
	layer = new MapLib.Layer.TiledDynamicRESTLayer("JNFC",url, 
		{ transparent: false, cacheEnabled: true }, 
		{
			scales : scales,
			maxResolution : "auto",
			numZoomLevels : scales.size
		}
	);
	//为图层初始化完毕添加addLayer()事件
	layer.events.on({"layerInitialized":addLayer});
	
	drawLayer = new MapLib.Layer.Vector("draw layer");//画图图层，存放绘制的点、线、面
	mulDrawPoint = new MapLib.Layer.Vector("mul feature layer");
	renderLayerMul = new MapLib.Layer.Vector("render layer mul");
	markerLayer = new MapLib.Layer.Markers("dingweitubiao");//定位图标
	//点查询
	drawPoint = new MapLib.Control.DrawFeature(drawLayer, MapLib.Handler.Point);
	drawPoint.events.on({"featureadded": drawCompleted});
	//多选
	drawPoint1 = new MapLib.Control.DrawFeature(mulDrawPoint, MapLib.Handler.Point);
	drawPoint1.events.on({"featureadded": mulSelsctCompleted});
	
	map = new MapLib.Map("map",{controls: [
                    //new MapLib.Control.LayerSwitcher(),
                    new MapLib.Control.ScaleLine(),
                    new MapLib.Control.Zoom(),
					new MapLib.Control.MousePosition(),drawPoint,drawPoint1,
                    new MapLib.Control.Navigation({
                        dragPanOptions: {
                            enableKinetic: true
                        }})
                        ]
                });
   //清除选择控件
	if(selectFeature){
		selectFeature.deactivate();
		map.removeControl(selectFeature);
	}
	//添加选择空间。
	var callbacks = { 
	    click: function(currentFeature){
	    	varObj.prototype.currentFeature = currentFeature;
			var lonlat=currentFeature.geometry.getBounds().getCenterLonLat();
			var contentHTML = 
			"<div id='content' style='width:180px;padding-top:10px;padding-bottom:5px;padding-left:15px;opacity: 0.8;overflow: hidden;'>"+
			"<div style='width:100%;height:100%;'>"+
			"<table><tr style='height:50px;'>"+
			"<td><font size='4' family='微软雅黑'>地址：</font><font size='3' family='微软雅黑'>"+currentFeature.data.ADDRESS+"</font></td>"+
			"</tr>"+
			"<tr>"+
			"<td style='text-align:center;'><button class='button' onclick='cancelSelected()'>取消选中</button>&nbsp<button class='button' onclick='closePopup()'>关闭窗口</button></td>"+
			"</tr></table>"+
			"</div>"+
			"</div>"
	
			popup = new MapLib.Popup.FramedCloud("pop",
					lonlat, null, contentHTML, null,
					true,null,true);
			currentFeature.popup = popup;
			popup.panMapIfOutOfView = true;
			popup.autoSize = true;
			map.addPopup(popup);
		}
	}; 
	varObj.prototype.currentLayer = renderLayerMul;
	selectFeature = new MapLib.Control.SelectFeature(renderLayerMul, { 
	callbacks: callbacks, 
	hover: false 
	}); 
	
});
function addLayer() {
		map.addLayers([layer,drawLayer,mulDrawPoint,renderLayerMul,markerLayer]);
		map.addControl(selectFeature); 
		
		map.setCenter(new MapLib.LonLat(48892.64, 51001.71), 0);
		map.zoomTo(5);
		
		if($('#project_buildingids').val()){
			queryByParam($('#project_buildingids').val(),'SMUSERID','smuserid',houseLayer)
			isHasSelected=true;
		}else{
			var county = ''+${block.result.city_district!''};
			county = county.substring(2);
			queryByParam(county,'CODE','code',"asdR@ORCL")
		}
		
   }
//画点
function drawpoint() {
	//先清除上次的显示结果
	//clearFeatures();
	if(popup){
		popup.destroy();
		popup=null;
	}
	drawLayer.style = style;
	drawPoint.activate();
}
//绘制图形完毕函数，并触发查询操作
function drawCompleted(drawGeometryArgs) {
	drawPoint.deactivate();
	var queryParam, queryByGeometryParameters, queryService;
	queryParam = new MapLib.REST.FilterParameter({name: houseLayer});
	queryByGeometryParameters = new MapLib.REST.QueryByGeometryParameters({
		queryParams: [queryParam],
		geometry: drawGeometryArgs.feature.geometry,
		spatialQueryMode: MapLib.REST.SpatialQueryMode.INTERSECT
	});
	queryService = new MapLib.REST.QueryByGeometryService(url2, {
		eventListeners: {
			"processCompleted": processCompleted,
			"processFailed": processFailed
		}
	});
	queryService.processAsync(queryByGeometryParameters);
}
// 处理查询结果
function processCompleted(queryEventArgs) {
	drawLayer.removeAllFeatures();
	
	var i, j, feature,result = queryEventArgs.result;
	if (result && result.recordsets) {
		for (i=0; i<result.recordsets.length; i++) {
			if (result.recordsets[i].features.length>0) {
				for (j=0; j<result.recordsets[i].features.length; j++) {
					var feature = result.recordsets[i].features[j];
					var point = feature.geometry;
					var lonlat=feature.geometry.getBounds().getCenterLonLat();
					popup = new MapLib.Popup.FramedCloud("chicken",
							lonlat, null, feature.data.ADDRESS, null,
							true,null,true);
					//currentFeature.popup = popup;
					popup.panMapIfOutOfView = true;
					popup.autoSize = true;
					map.addPopup(popup);
				}
			}else{
				alert("未查询到结果！");
			}
		}
	}
}

//多选
function duoxuan(){
	if(!$('#project_buildingids').val()){
		clearFeatures();
		clearMouseStatus();
		removeControl(map);
	}
	mulDrawPoint.style = style;
	drawPoint1.activate();
	selectFeature.activate();
	
	var d = document.getElementById('pc');
	d.disabled = false;
}

function pauseContinue(){
	var value = $('#pc').val();
	var d = document.getElementById('pc');
	if(value=='停止'){
		drawPoint1.deactivate();
		$('#pc').val("继续");
		d.innerHTML = '继续';
		d.title = '继续选取房屋';
	}else if(value=='继续'){
		drawPoint1.activate();
		$('#pc').val("停止");
		d.innerHTML = '停止';
		d.title = '停止选取房屋';
	}
	
}


function mulSelsctCompleted(drawGeometryArgs) {
	var queryParam, queryByGeometryParameters, queryService;
	queryParam = new MapLib.REST.FilterParameter({name: houseLayer});
	queryByGeometryParameters = new MapLib.REST.QueryByGeometryParameters({
		queryParams: [queryParam],
		geometry: drawGeometryArgs.feature.geometry,
		spatialQueryMode: MapLib.REST.SpatialQueryMode.INTERSECT
	});
	queryService = new MapLib.REST.QueryByGeometryService(url2, {
		eventListeners: {
			"processCompleted": mulCompleted,
			"processFailed": processFailed
		}
	});
	queryService.processAsync(queryByGeometryParameters);
}
function mulCompleted(queryEventArgs) {
	mulDrawPoint.removeAllFeatures();
	//originResult = queryEventArgs.originResult;
	var i, j, feature,result = queryEventArgs.result;
	if (result && result.recordsets) {
		for (i=0; i<result.recordsets.length; i++) {
			if (result.recordsets[i].features.length>0) {
				for (j=0; j<result.recordsets[i].features.length; j++) {
					var feature = result.recordsets[i].features[j];
					var point = feature.geometry;
					
					if(listData && listData.length){
						for(var k=0;k<listData.length;k++){
							if(listData[k].id == feature.data.SMUSERID){
								alert("已选择该对象");
								return;
							}
						}
					}
					
					feature.style = style;
					renderLayerMul.addFeatures(feature);
					
					var o=new dataObj(feature.data.SMUSERID,feature.data.ADDRESS);
					listData.push(o);
					rightList();
					var list = document.getElementById('list');
					var html = '',ids='';
					//alert(feature.data.SMUSERID+":"+feature.data.ADDRESS);
					for(var k=0;k<listData.length;k++){
						//alert(listData[k].id+"  "+listData[k].address);
						html+="<div>["+listData[k].id+"]"+listData[k].address+"</div>";
						ids += listData[k].id+',';
					}
					list.innerHTML = html;
					ids = ids.substring(0,ids.lastIndexOf(','));
					$('#project_buildingids').val(ids);
				}
			}else{
				alert("未查询到结果！");
			}
		}
	}
}
var dataObj = function(id,address){
	this.id=id;
	this.address=address;
}
//用来传递全局变量
var varObj = function varObj(){}
//取消选中
function cancelSelected(){
	removeFeature(varObj.prototype.currentLayer,varObj.prototype.currentFeature)
	closePopup()
	var feature = varObj.prototype.currentFeature;
	var list = document.getElementById('list');
	var html = '';
	var idx;
	var ids='';
	for(var k=0;k<listData.length;k++){
		if(listData[k].id == feature.data.SMUSERID){
			idx = k;
			continue;
		}
		html+="<div>["+listData[k].id+"]"+listData[k].address+"</div>";
		ids += listData[k].id+',';
	}
	list.innerHTML = html;
	ids = ids.substring(0,ids.lastIndexOf(','));
	$('#project_buildingids').val(ids);
	listData.splice(idx,1);
	
}
function removeFeature(a,b){
	a.removeFeatures(b);
	a.redraw();
}
function clearFeatures() {
	drawLayer.removeAllFeatures();
	mulDrawPoint.removeAllFeatures();
	renderLayerMul.removeAllFeatures();
	listData=[];
	closePopup();
}
function closePopup(){
	if(popup){
		popup.destroy();
		popup=null;
	}
}
function clearMouseStatus(){
	drawPoint.deactivate();
	drawPoint1.deactivate();
}
function removeControl(map){
	//清除选择控件
	if(selectFeature){
		selectFeature.deactivate();
		map.removeControl(selectFeature);
	}
}

// 处理异常，弹出
function processFailed(e) {
	alert(e.error.errorMsg);
}


//右侧列表
function rightList() {
    var combox = document.getElementById("common_box");
	if(combox.style.display=='block'){
		return;
	}
	if(combox.style.display=='none'){
		combox.style.display='block';
	}
    var cli_on = document.getElementById("cli_on");
    var flag = true, timer = null, initime = null, r_len = 0;
    cli_on.onclick = function () {
    /*如果不需要动态效果，这两句足矣
    combox.style.right = flag?'-270px':0;
    flag = !flag;
    */
    clearTimeout(initime);
    //根据状态flag执开展开收缩
    if (flag) {
    r_len = 0;
    timer = setInterval(slideright, 10);
    } else {
    r_len = -270;
    timer = setInterval(slideleft, 10);
    }
    }
    //展开
    function slideright() {
    if (r_len <= -270) {
		clearInterval(timer);
		flag = !flag;
		return false;
		} else {
		r_len -= 5;
		combox.style.right = r_len + 'px';
		}
		cli_on.innerHTML='《';
    }
    //收缩
    function slideleft() {
		if (r_len >= 0) {
		clearInterval(timer);
		flag = !flag;
		return false;
		} else {
		r_len += 5;
		combox.style.right = r_len + 'px';
		}
		
		cli_on.innerHTML='》';
    }
    //加载后3秒页面自动收缩
    //initime = setTimeout("cli_on.click()", 3000);
    }
var baseurl = "${_share_file_url!''}/safemanage/resource/images/"   

function queryByParam(para,attr,type,layer){
	var queryParam
	if(type=='address'){
		queryParam = new MapLib.REST.FilterParameter({ 
		    name: layer, 
		    attributeFilter: attr+" like '%"+para+"%'" 
		}); 
	}else if(type=='smuserid'){
		queryParam = new MapLib.REST.FilterParameter({ 
		    name: layer, 
		    attributeFilter: attr+" in ("+para+")" 
		}); 
	}else if(type=='code'){
		queryParam = new MapLib.REST.FilterParameter({ 
		    name: layer, 
		    attributeFilter: attr+" like '%"+para+"%'" 
		}); 
	}
	var queryBySQLParams = new MapLib.REST.QueryBySQLParameters({ 
	    queryParams: [queryParam] 
	}); 
	var myQueryBySQLService = new MapLib.REST.QueryBySQLService(url2, {eventListeners: { 
	    "processCompleted": queryCompleted, 
	    "processFailed": queryError 
	    } 
	}); 
	myQueryBySQLService.processAsync(queryBySQLParams); 
	
	function queryCompleted(QueryEventArgs){
		var path = FMapLib.baseurl;
		var result,recordsets,f=false,points=[],f1=false
		if(!QueryEventArgs.result) return;
		result = QueryEventArgs.result;
		if(!result.recordsets) return;
		recordsets=result.recordsets;
		if(recordsets.length){
			for(var i=0;i<recordsets.length;i++){
				if(recordsets[i].features && recordsets[i].features.length){
					var features = recordsets[i].features;
					for(var j=0;j<features.length;j++){
						var feature = features[j];
						//如果之前有选中的房屋面，则添加到图层。
						if(isHasSelected && type=='smuserid'){
							feature.style = style;
							renderLayerMul.addFeatures(feature); 
							rightList();
							var o=new dataObj(feature.data.SMUSERID,feature.data.ADDRESS);
							listData.push(o);
							rightList();
							var list = document.getElementById('list');
							var html = '',ids='';
							//alert(feature.data.SMUSERID+":"+feature.data.ADDRESS);
							for(var k=0;k<listData.length;k++){
								//alert(listData[k].id+"  "+listData[k].address);
								html+="<div>["+listData[k].id+"]"+listData[k].address+"</div>";
								ids += listData[k].id+',';
							}
							list.innerHTML = html;
						}else if(type=='code'){
							feature.style = style;
							renderLayerMul.addFeatures(feature); 
						}else{
							//alert('hhh');
							var pointx = parseFloat(feature.attributes["SMX"]),
	                        pointy = parseFloat(feature.attributes["SMY"]),	                
	                        size = new MapLib.Size(15,15),
	                        offset = new MapLib.Pixel(-(size.w/2), -size.h),
	                        icon = new MapLib.Icon(baseurl + "marker11.png", size, offset);
	                        //alert(pointx);
							var marker = new MapLib.Marker(new MapLib.LonLat(pointx, pointy),icon);
							marker.info = feature;
							marker.icon = icon;
							markerLayer.addMarker(marker);
							marker.events.on({
							"mouseover" : openInfoWin,
							"scope" : marker
							});
							marker.events.on({
								"mouseout" : returnIconall,
								"scope" : marker
							});
							
							if(points && points.length){
								points[points.length] = new MapLib.Geometry.Point(pointx,pointy);
							}else{
								points[0] = new MapLib.Geometry.Point(pointx,pointy);
							}
							
							f1=true;
						}
						
					}
					f=true;
				}else{
					alert("暂无数据！");
				}
			}
			if(f && f1){
				var feature = new MapLib.Feature.Vector();
				linearRings = new MapLib.Geometry.LinearRing(points),
				region = new MapLib.Geometry.Polygon([linearRings]);
				feature.geometry = region
				var geo = feature.geometry;
				var b = geo.getBounds();
				markerLayer.map.zoomToExtent(b);
			}else if(f){
				var bound = renderLayerMul.getDataExtent();
				renderLayerMul.map.zoomToExtent(bound);
				var lonlat = bound.getCenterLonLat();
				renderLayerMul.map.setCenter(new MapLib.LonLat(lonlat.lon, lonlat.lat));
				//if(renderLayerMul.map.getZoom()<2){
				//	renderLayerMul.map.zoomTo(4);
				//}
				if(type=='code'){
					renderLayerMul.removeAllFeatures();
				}else{
					selectFeature.activate();
				}
			}
		}
	}
	function openInfoWin(){
		if (popup) {
			markerLayer.map.removePopup(popup);
		}
	    var marker = this; 
	    var lonlat = marker.getLonLat(); 
	    popup = new MapLib.Popup.FramedCloud("popwin",new MapLib.LonLat(lonlat.lon,lonlat.lat),null,marker.info.attributes["ADDRESS"],marker.icon,false); 
	    markerLayer.map.addPopup(popup); 
	    this.setUrl(baseurl + "markerbig.png");
	}
	//恢复marker图片地址
	function returnIconall(){
		this.setUrl(baseurl + "marker11.png");
		if (popup) {
			markerLayer.map.removePopup(popup);
		}
	}
	function queryError(QueryEventArgs){//todo
		var arg = QueryEventArgs;
	}
}   
//定位房屋
function mapToPosition(){
	if($('#inputaddress').val() =='' || $('#inputaddress').val() =='请输入房屋地址'){
		alert('请输入房屋坐落！');
		return;
	}
	queryByParam($('#inputaddress').val(),'ADDRESS','address',"ST_RIDRGN_SAFE_P@ORCL")
}    

</script>

<body id="bod">
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	
	<form class="cmxform" style="margin:0" action="${_servlet_url!''}/safemanage.tBuildingProjectupdate2" method="post" id="updateForm">
		<input style="display:none;" type="text" name="project_id" id="project_id" value="${block.result.project_id!''}"/>
		<input style="display:none;" type="text" name="project_buildingids" id="project_buildingids" value="${block.result.project_buildingids!''}"/>
			<font size='4' family='微软雅黑'>项目名称：</fint><font size='3'>${block.result.project_name!''}</font>	
			<div style="float:right;font-size:13px;">
			[#if "${block.result.review_state!''}"!="2"]
			<button type="button" id="updateInfo">提交</button>
			[/#if]
			<button type="button" onClick="window.close();">返回</button>
			</div>		
	</form>
</div>
<div style='padding-left:10px;'>
	<button class="button" id="chooseHouse" style='display:none;'>选取房屋</button>
	<font size='2.6'>房屋地址:</font><input style="height:18px;width:150px" class="button" name="" id="inputaddress" placeholder="请输入房屋地址" title="请输入房屋地址"  type="text" />
	<button class="button" id="searchHouse" onclick="mapToPosition()">定位</button>&nbsp
	<button class="button" onclick="drawpoint()" style='display:none;'>查看房屋</button>
	<button id="sel" class="button" onclick="duoxuan()">选取房屋</button>
	<button id="pc" class="button" onclick="pauseContinue()" title="停止选取房屋" value="停止" disabled='true'>停止</button>
</div>
<div id="map" style="position:absolute;left:0px;right:0px;width:99.8%;height:90%;" visibility="visible"></div> 
<div id="common_box" style="display:none;">
	<div id="cli_on" style='font-size:12px;'>》</div>
	<div id="list" style="height:95%;overflow: auto;margin: 10px 0px 10px;font-size:13px;"></div>
</div>
</body> 