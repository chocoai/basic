<style type="text/css">
    #map{
        position: relative;
        height: 320px;
        border:1px solid #3473b7;
    }
    
</style>

<!--引用需要的脚本-->
<script src="${block.map_url!''}/gis/FMapLib/FMapLib.Include-1.0.4.js" type="text/javascript"></script>
<script type="text/javascript">
var map, markers, tempMarker, layer;

$(function(){
	
	//定义layer图层，TiledDynamicRESTLayer：分块动态 REST 图层
	layer = new MapLib.Layer.TiledDynamicRESTLayer(
		"fangchanL", 
		FMapLib.DemoURL.fangchanL, 
		{ transparent: false, cacheEnabled: true }, 
		{
			scales : FMapLib.scales,
			maxResolution : "auto",
			numZoomLevels : 9
		}
	);
	//为图层初始化完毕添加addLayer()事件
	layer.events.on({"layerInitialized":addLayer});
	
	//创建标记图层 
	markers = new MapLib.Layer.Markers("HouseSafeTheme",{}); 
	
	map = new MapLib.Map("map",{controls: [

                    new MapLib.Control.Zoom(),
                    new MapLib.Control.Navigation({
                        dragPanOptions: {
                            enableKinetic: true
                        }})
                        ]
                });
	
});

function addLayer() {
		map.addLayers([layer,markers]);
		map.setCenter(new MapLib.LonLat(48892.64, 51001.71), 0);
		map.zoomTo(6);	
		addMarker();
   }

//在地图上添加专题图Marker
function addMarker(){
	var c=0;
	[#list block.datalist as data]
		//标记图层上添加标记 
		//B:yellow;C:brown;D:red
		var img;
		if('${data.dangerous_level}' == 'B'){
			img = "/gis/resource/images/B_yellow.png";
		}else if('${data.dangerous_level}' == 'C'){
			img = "/gis/resource/images/B_brown.png";
		}else if('${data.dangerous_level}' == 'D'){
			img = "/gis/resource/images/B_red.png";
		}
		var lonlat = new MapLib.LonLat('${data.smx}','${data.smy}');
		var marker = createMarker(21,25,img,lonlat);		
		marker.id='${data.jdinfo_id}';
		marker.events.on({
						"mouseover" :mouseOver,
						"mouseout" :mouseOut,
						//"click":mouseClick,
						"scope" : marker
					});
		markers.addMarker(marker);
		
		if(c==0){
			map.setCenter(lonlat, 0);
			map.zoomTo(7);
		}
		c++
	[/#list]

}
//点击右侧列表时定位地图上的Marker
function itemClick(id,reLocate){
	[#list block.datalist as data]
		if('${data.jdinfo_id}' == id){
			clearTempMarker();
			var img;
			if('${data.dangerous_level}' == 'B'){
				img = "/gis/resource/images/B_yellow.png";
			}else if('${data.dangerous_level}' == 'C'){
				img = "/gis/resource/images/B_brown.png";
			}else if('${data.dangerous_level}' == 'D'){
				img = "/gis/resource/images/B_red.png";
			}
			var lonlat = new MapLib.LonLat('${data.smx}','${data.smy}');
			tempMarker = createMarker(30,35,img,lonlat);
					
			tempMarker.id='${data.jdinfo_id}';
			/*tempMarker.events.on({
						"click":mouseClick,
						"scope" : tempMarker
					});
			*/
			markers.addMarker(tempMarker);
			if(reLocate){
				map.setCenter(lonlat, 0);
				map.zoomTo(7);
			}
		}
	[/#list]	
}
function mouseOver(){
	clearTempMarker();//清除点击右侧列表时定位的marker
	zoomScale(this,1.5)
}

function mouseOut(){
	zoomScale(this,1)
}

var imgW,imgH;
//marker大小控制。 marker触发对象；time放大缩小倍数，time==1时为原始大小
function zoomScale(marker,time){
	if (marker.icon) {
		var a;
		if(time == '1'){
			a = new MapLib.Size(imgW, imgH);
		}else{
			imgW = marker.icon.size.w;
			imgH = marker.icon.size.h;
		 	a = new MapLib.Size(marker.icon.size.w * time, marker.icon.size.h * time);
		}
	 	marker.icon.setSize(a)
	}
}
//marker点击事件。弹出信息窗
function mouseClick(){
	var marker = this; 
    var lonlat = marker.getLonLat(); 
    var contentHTML = "<div style=\'font-size:.8em; opacity: 0.8; overflow-y:hidden;\'>"; 
    contentHTML += "<div>"+marker.id+"</div></div>";  
    var popup = new MapLib.Popup.FramedCloud("popwin",new MapLib.LonLat(lonlat.lon,lonlat.lat),null,contentHTML,null,true); 
    map.addPopup(popup); 
	
}

//创建Marker
function createMarker(width,height,img,lonlat){
	var size = new MapLib.Size(width,height); 
	var offset = new MapLib.Pixel(-(size.w/2), -size.h); 
	var icon = new MapLib.Icon(img,size,offset); 
	var marker = new MapLib.Marker(lonlat,icon);
	marker.setOpacity(0.8);
	return marker;
}
//清除临时marker
function clearTempMarker(){
	if(tempMarker){
		markers.removeMarker(tempMarker);
		//tempMarker.destroy();
	}
}
</script>

<div class="widget-title-normal">
		<div class="child">
			<span class="widget-title-text">
				危房信息公示
			</span>
		</div>
	</div>
<div class="widget-content-body">
		<div class="widget-news-content">
<div >
<table cellspacing="0" border="0" width="100%" cellpadding="0" style="TABLE-LAYOUT: fixed">
		  <tr>
		    <td width="60%" style="vertical-align:top;">
		      <div id="map"></div>
		    </td>
		    <td width="30%" style="vertical-align:top;">     
			<table class="" cellspacing="0" cellpadding="0" border="0" width="100%" style="TABLE-LAYOUT: fixed">
			[#assign count=0]
			[#list block.datalist as data]
			[#if count<10]
			<tr>
				<td class="widget-list-icon widget-lineheight" >		
				    <span class="widget-title-nowrap widget-padding" style="width:78%;margin-left:10px;"><a id="${data.jdinfo_id}" class ="widget-padding-left" href="javascript:void(0);" onclick="itemClick(this.id,true);">${data.building_address}</a></span>
				</td>
			</tr>
			[#assign count=count+1]
			[/#if]
			[/#list]
			</table>
		    </td>
		  </tr>
		</table>
</div>
</div>
</div>
