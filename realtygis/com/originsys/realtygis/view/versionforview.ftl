<script src="${_share_file_url!''}/gis/FMapLib/FMapLib.Include.js" type="text/javascript"></script>
 <script type="text/javascript">
  //声明变量map、layer、url；
      var map, layer,  
    url = FMapLib.DemoURL.baseUrl+"${map.mapname!''}";
 // 比例尺自定义
//	var scales = [1 / 500, 1 / 3000,1 / 10000,1 / 15000,1 / 30000, 1 / 100000,1 / 150000, 1 / 250000, 
//	              1 / 1400000];
	function init(){              
	 map = new MapLib.Map("mapdiv", {
			controls : [ // new MapLib.Control.LayerSwitcher(),
			new MapLib.Control.ScaleLine(),
			// new MapLib.Control.Zoom(),
			new MapLib.Control.MousePosition(),
					new MapLib.Control.OverviewMap(),
					new MapLib.Control.KeyboardDefaults(),
					new MapLib.Control.PanZoomBar({
						forceFixedZoomLevel : true
					}), new MapLib.Control.Navigation({
						dragPanOptions : {
							enableKinetic : true
						}
					}) ],
			units : "m"
		});              
 layer = new MapLib.Layer.TiledDynamicRESTLayer("${map.mapname!''}",
				url, {
					transparent : true,
					cacheEnabled : true
				}, {
					scales : FMapLib.scales,
					maxResolution : "auto",
					numZoomLevels : 9
				});
		
	layer.events.on({
	"layerInitialized" : function() {
				map.addLayer(layer);
				map.setBaseLayer(layer);
				map.setCenter(new MapLib.LonLat(48892.64, 64000.71),0);
				//map.allOverlays = true;
			}
		});
	}
 </script>
 <body onload="init()">        
    <!--地图显示的div-->   
   <div id="mapdiv" style="position: relative; left:5px; bottom:10px; height:600px;" >         
          </div> 
  </body>
 