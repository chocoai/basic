<script src="${_share_file_url!''}/gis/FMapLib/FMapLib.Include.js" type="text/javascript"></script>
 <script type="text/javascript">
      var mapnew;//定义最新地图map对象
      var layernew;//定义mapnew的图层
       var  urlnew="";//定义最新地图地址
       var default_map;//默认地图名
      var vectorLayer2;
      // 比例尺自定义
	//var scales = [1 / 500,1/1000, 1 / 3000,1 / 10000,1 / 15000,1 / 30000,1/65000, 1 / 100000, 1 / 250000, 
	//              1 / 1400000];
	function init(){    
	$.ajax({ 
	          type : "post", 
	          url : "realtygis.versionmanagerpopup", 
	          data : "" , 
	          async : false, 
	          success : function(data){ 
	      		var jdata = jQuery.parseJSON(data);
				var len = jdata.root.length;
				for (i = 0; i < len; i++) {
					if (jdata.root[i].version_number!=null&&jdata.root[i].default_map=="1001") {
						default_map=jdata.root[i].version_number;            
					}
				}
			//定义最新地图地址
        urlnew = FMapLib.DemoURL.baseUrl+default_map;
	          } 
	          }); 
	 mapnew = new MapLib.Map("newmapdiv", {
			controls : [ // new MapLib.Control.LayerSwitcher(),
			new MapLib.Control.ScaleLine(),
			// new MapLib.Control.Zoom(),
			new MapLib.Control.MousePosition(),
				//	new MapLib.Control.OverviewMap(),
					new MapLib.Control.KeyboardDefaults(),
				//	new MapLib.Control.PanZoomBar({
				//		forceFixedZoomLevel : true
				//	}),
				 new MapLib.Control.Navigation({
						
					})
					 ],
			units : "m"
		}); 
                   
 layernew = new MapLib.Layer.TiledDynamicRESTLayer(default_map,
				urlnew, {
					transparent : true,
					cacheEnabled : true
				}, {
					scales : FMapLib.scales,
					maxResolution : "auto",
					numZoomLevels : 10
				});
	vectorLayer2 = new MapLib.Layer.Vector("Vector Layer");
	layernew.events.on({
	"layerInitialized" : function() {
				mapnew.addLayers([layernew,vectorLayer2]);
				mapnew.setBaseLayer(layernew);
			//	mapnew.setCenter(new MapLib.LonLat(48892.64, 64000.71),0);
				mapIdenty("${map.building_mapid!''}");
			}
		});
    function mapIdenty(b_ids) {
			if (b_ids == undefined || b_ids == "") {
              alert("暂无数据！");
			} else {
				var filter="SMUSERID =" + b_ids;
				var completed=surveyCompleted;
				housequeserv(filter,completed);
			}
		}

	function surveyCompleted(queryEventArgs) {
			var i, j, feature, result = queryEventArgs.result, result1 = queryEventArgs.result;
			var style = {
				strokeColor : "#FFFF00",
				strokeWidth : 1,
				fillColor : "#FFFF00",
				fillOpacity : "1"
			};
			vectorLayer2.removeAllFeatures();
			if (result && result.recordsets) {
				for (i = 0; i < result.recordsets.length; i++) {
					if (result.recordsets[i].features) {
						for (j = 0; j < result.recordsets[i].features.length; j++) {
							feature = result.recordsets[i].features[j];
							feature.style = style;
							vectorLayer2.addFeatures(feature);
                        
						}
					}
				}
			}
		//	var selectFeature2 = new MapLib.Control.SelectFeature([
		//			vectorLayer, vectorLayer2 ], {
		//		onSelect : onSurveyFeatureSelect,
		//		onUnselect : onSurveyFeatureUnselect
		//	});
		//	selectFeature2.repeat = true;
		//	map.addControl(selectFeature2);
		//	selectFeature2.activate();
			// 定位所选择的房屋
			var x = feature.geometry.getBounds().getCenterLonLat().lon;
			var y = feature.geometry.getBounds().getCenterLonLat().lat;
			var lonLat = new MapLib.LonLat(x, y);
			mapnew.setCenter(lonLat, 7);
            popwin(feature);
		}
	//房屋图层查询服务  公用方法
	function housequeserv ( attribufilter, completed ){
		var queryParam, queryBySQLParams, queryBySQLService;
		queryParam = new MapLib.REST.FilterParameter({
			name : "ST_RIDRGN@ORCL",
			// attributeFilter: "ADDRESS like '%名%士%豪%庭%1%号%'"
			attributeFilter : attribufilter

		});
		queryBySQLParams = new MapLib.REST.QueryBySQLParameters({
			queryParams : [ queryParam ]
		});

		queryBySQLService = new MapLib.REST.QueryBySQLService(
				urlnew, {
					eventListeners : {
						"processCompleted" : completed,
						"processFailed" : processFailed
					}
				});
		queryBySQLService.processAsync(queryBySQLParams);
	}
	/**
	 * 查询失败 公用方法
	 */
	function processFailed(e) {
		doMapAlert("map", "", e.error.errorMsg, true);
	}
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
	
	function popwin(feature){
	var contentHTML = t_buildingQuery(feature);
		var x = feature.geometry.getBounds().getCenterLonLat().lon;
		var y = feature.geometry.getBounds().getCenterLonLat().lat;
		// 初始化一个弹出窗口，当某个地图要素被选中时会弹出此窗口，用来显示选中地图要素的属性信息
		popup = new MapLib.Popup.FramedCloud("popwin",
				new MapLib.LonLat(x, y), new MapLib.Size(150, 100),
				contentHTML, null, true, null, true);
		popup.autoSize = false;
		feature.popup = popup;
		mapnew.addPopup(popup);
	}
	function t_buildingQuery(feature){
	var contentHTML = "";
	$
				.ajax({
					url : 'realtygis.buildingjson',
					cache : false,
					async : false,// 同步
					dataType : 'json',
					data : {
						id : (feature.attributes['ST_RIDRGN.SMUSERID']==undefined?feature.attributes['SMUSERID']:feature.attributes['ST_RIDRGN.SMUSERID'])

					},
					success : function(item, textStatus, jqXHR) {
						if (textStatus == 'success') {

					contentHTML +="<div style='font-size:.8em; opacity: 0.8; overflow-y:hidden; background:#FFFFFF';width:100%;height:100%>"
								+ "<span style='font-weight: bold; font-size: 18px;'>"+item.building_address+"</span><br><br>";
								+ "</div>";
						}
					}
				});
		return contentHTML;
	}
 }
 </script>
 <body onload="init()">        
    <!--地图显示的div-->   
   <div id="newmapdiv"  style="position: relative; float:center;  height:600px;width:100%" >         
          </div> 
  
  </body>
 