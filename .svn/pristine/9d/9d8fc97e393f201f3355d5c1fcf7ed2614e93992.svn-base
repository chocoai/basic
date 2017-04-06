
function dangerhousemarker(){
	map.clearAllFeatures();
	if(preFeature!=undefined&&preFeature.popup!=null&&preFeature.popup!=undefined){
		map.map.removePopup(preFeature.popup);
    }
	var sql= "and TESTGRADE ='4'";
	var filter="1=1 " + sql;
	var completed=AllMarkerProcessCompleted;
	housequeservpoint(filter,completed);
	
	
}
//楼栋查询结束执行渲染marker
function AllMarkerProcessCompleted(queryEventArgs){
     var i, j, result = queryEventArgs.result;
        if (result && result.recordsets) {
            for (i=0, recordsets=result.recordsets, len=recordsets.length; i<len; i++) {
            	if (recordsets[i].features) {	                	
                    for (j=0; j<recordsets[i].features.length; j++) {
                        var pointx = parseFloat(recordsets[i].features[j].attributes["SMX"]),
                            pointy = parseFloat(recordsets[i].features[j].attributes["SMY"]),	                    
                            size = new MapLib.Size(17,17),
                                 offset = new MapLib.Pixel(-(size.w/2), -size.h),
                                 icon = new MapLib.Icon("/safemanage/resource/images/动态闪动图.gif", size, offset);
                        var buffermarker = new MapLib.Marker(new MapLib.LonLat(pointx, pointy), icon);
                        buffermarker.information = recordsets[i].features[j];
                        map._markerLayer.addMarker(buffermarker);
                        buffermarker.events.on({
							"click" : bufferMarkerAlert,
							"scope" : buffermarker
						});
                     
                    }
                    
                }
            }
        }

		var bound = map._markerLayer.getDataExtent();
		if(null!=bound){
		map.map.zoomToExtent(bound,true);
		var lonlat = bound.getCenterLonLat();
		map.map.setCenter(new MapLib.LonLat(lonlat.lon, lonlat.lat));
        if(map.map.getZoom()<2){
        	map.map.zoomTo(2);
        }
		}
	
}

// 鼠标点击marker弹出信息框的函数
bufferMarkerAlert = function(){
	if(preFeature!=undefined&&preFeature.popup!=null&&preFeature.popup!=undefined){
		map.map.removePopup(preFeature.popup);
    	}
		var querymarkerlonlat = this;
		var markercontentHTML = t_buildingMarkerQuery(querymarkerlonlat);
		var querymarkerX = querymarkerlonlat.getLonLat().lon;// X坐标;
		var querymarkerY = querymarkerlonlat.getLonLat().lat;// Y坐标
		popup = new MapLib.Popup.FramedCloud("chicken", new MapLib.LonLat(
				querymarkerX, querymarkerY), new MapLib.Size(200, 150), markercontentHTML, null,
				true,null,true);
		querymarkerlonlat.popup = popup;
		popup.panMapIfOutOfView = true;
		popup.autoSize = false;
		map.map.addPopup(popup);
		preFeature = querymarkerlonlat;
	}

/**
 * 查询选定楼幢的楼幢信息  公用方法
 * @param marker 楼幢marker
 * @return String  弹出框html
 */
 t_buildingMarkerQuery=function(marker){
		var contentHTML = "";
		
		$
				.ajax({
					url : 'safecheck.survey.testbuilding',
					cache : false,
					async : false,// 同步
					dataType : 'json',
					data : {
						id : (marker.information.attributes['ST_RIDRGN_SAFE_P.SMUSERID']==undefined?marker.information.attributes['SMUSERID']:marker.information.attributes['ST_RIDRGN_SAFE_P.SMUSERID'])

					},
					success : function(item, textStatus, jqXHR) {
						if (textStatus == 'success') {
//					contentHTML +="<div style='font-size:.8em; opacity: 0.8; overflow-y:hidden; background:#FFFFFF';width:100%;height:100%>"
//								+ "<span style='font-weight: bold; font-size: 18px;'>"+item.building_address+"</span><br><br>";
//
//		         	contentHTML +="<form>"
//		         		        +"<p align='center'><input type='button' id='buildinginfo' value='详细信息'  onclick=window.open('safeauth.dangerous.detail?building_id="
//						        +item.building_id+"','_blank','depended=yes,top='+(window.screen.height-30-600)/2+',left='+(window.screen.width-10-900)/2+',width=900,height=600,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes')></p>"
//								+"</form>"
//								+ "</div>";
		         	contentHTML = "<div style='font-size:.8em; opacity: 1; line-height:30px; overflow-y:hidden;padding-bottom:1px;'>"
						+ "<span style='color:#005ebc;font-size: 18px;font-family:微软雅黑;'>房屋信息</span><br>";
					contentHTML += "<div style='font-size:1.2em;margin-left:15px'>地址：" + item.building_address	+ "</div>";
					contentHTML +="<p  style='text-align:center;'>" +
							"<input type='button' value='详细信息' " +
							"onclick=window.open('safeauth.dangerous.detail?building_id="	+ item.building_id+"','_blank','depended=yes,top='+(window.screen.height-30-500)/2+',left='+(window.screen.width-10-900)/2+',width=900,height=500,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes') " +
							"style='background:url(/gis/FMapLib/theme/images/button_bj.jpg) repeat-x; width:100px; height:35px; border:1px #cbe5ff solid; line-height:0px; font-family:微软雅黑; font-size:14px; color:#005ebc;padding-left:15px;'/>" +
							"</p>" +
							"</div>";
						}
					}
				});
		return contentHTML;
}
	//房屋点图层查询服务  公用方法
	function housequeservpoint ( attribufilter, completed ){
		var queryParam, queryBySQLParams, queryBySQLService;
		queryParam = new MapLib.REST.FilterParameter({
			name : "ST_RIDRGN_SAFE_P@ORCL",
			// attributeFilter: "ADDRESS like '%名%士%豪%庭%1%号%'"
			attributeFilter : attribufilter

		});
		queryBySQLParams = new MapLib.REST.QueryBySQLParameters({
			queryParams : [ queryParam ]
		});

		queryBySQLService = new MapLib.REST.QueryBySQLService(
				map._DemoURL.fangchan, {
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
	/**
	 * 查询结果在地图串口上方弹出事件
	 * 参数：id:地图窗口的id，tip：信息框提示语句，message：弹出的内容，sucess：是否弹出，默认填true
	 */
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
	};