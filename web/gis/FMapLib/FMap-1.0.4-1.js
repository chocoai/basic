(function() {
	var org;//地图服务地址
	var accessurl;//资源服务地址	
	//地图服务地址
  //  org = 'http://' + (document.location.host.split(":")[0])+":"+FMapLib.MAPSERVICE_PORT;	
      org='http://192.168.0.9:8092'//本机临时调用
    //房屋基础平台地址
    accessurl='http://' + (document.location.host.split(":")[0])+":"+FMapLib.HOUSEBASICAPP_PORT;
	FMapLib.Org=org;
	FMapLib.AccessURL=accessurl;
	//GIS服务资源地址
	var DemoURL=FMapLib.DemoURL = {	
		image:org + '/iserver/services/map-FMAP1/rest/maps/1101',	
		fangchan1 : org + '/iserver/services/data-FMAP1/rest/data',// 数据服务
		fangchan : org + '/iserver/services/map-FMAP1/rest/maps/DATASERVICE',// 简单地图(提供地图查询服务)
		fangchan_spatialanalyst:org+'/iserver/services/spatialAnalysis-FMAP1/restjsr/spatialanalyst',
		fangchanL: org + '/iserver/services/map-FMAP1/rest/maps/14121215301',// 全要素地图(对应地图切边版本)
		safecheck: org+'/iserver/services/map-FMAP2/rest/maps/安全普查',// 安全普查地图
		safecheck2: org+'/iserver/services/map-FMAP2/rest/maps/安全检查',// 安全检查地图
		safecheck3: org+'/iserver/services/map-FMAP2/rest/maps/安全鉴定',// 安全鉴定地图
		emergency: org+'/iserver/services/map-FMAP2/rest/maps/突发事件',// 突发事件地图
	    newSafehouse:org+'/iserver/services/map-FMAP2/rest/maps/新增安全房屋',// 安全管理新增房屋	
		fangchan1_New_House_P : org + '/iserver/services/data-FMAP1/rest/data/datasources/name/ORCL/datasets/name/New_House_P',// 安全新建房屋数据集
		fangchan1_ST_RIDRGN_SAFE_P:org + '/iserver/services/data-FMAP1/rest/data/datasources/name/ORCL/datasets/name/ST_RIDRGN_SAFE_P',// 安全所有房屋点数据集
		fangchan1_ST_Emer_P:org + '/iserver/services/data-FMAP1/rest/data/datasources/name/ORCL/datasets/name/ST_Emer_P',// 突发事件点数据集
		fangchan1_ST_Dangers_P:org + '/iserver/services/data-FMAP1/rest/data/datasources/name/ORCL/datasets/name/ST_Dangers_P'// 地面危险点数据集
	};	
	// 比例尺自定义
	var scales =FMapLib.scales= [1 /1000, 1 / 3000,1 / 10000,1 / 15000,1 / 30000,1/65000, 1 / 100000, 1 / 250000, 
	              1 / 1400000];	
	FMapLib.scalesnum=9;
	FMapLib.MapCenter={x:497950.057789132, y:4061622.65003076};
	//引用资源文件路径
	var resource_path=FMapLib.resource_path={
		img_flashpoint:"/safemanage/resource/images/flashpoint.gif",
		img_loadring:'/gis/resource/images/load_ring.gif',
		tab_safehouse:'ST_RIDRGN_safecheck@ORCL'			
	}
})();	