var map;
var programes;//存放查询条件
var screenSta = 0;// 代表为默认状态(小屏)
var MAP_VISION = "1.0.1";// 辅助判断该脚本是否引入
//layout扩展
$(document).ready(function() {
	// 使用layout布局
	$('#container').layout();
	$('#innerContainer').layout();
	outerLayout = $("#container").layout(layoutSettings_Outer);

	innerLayout = $("#innerContainer").layout(layoutSettings_Inner);

	// DEMO HELPER: prevent hyperlinks from reloading page when a 'base.href' is
	// set
	$("a").each(function() {
		var path = document.location.href;
		if (path.substr(path.length - 1) == "#")
			path = path.substr(0, path.length - 1);
		if (this.href.substr(this.href.length - 1) == "#")
			this.href = path + "#";
	});	
	//innerLayout.sizePane('south', 100);// 隐藏南部div
});
//初始化地图组件
$(function() {	
	// 初始化一张拥有简单控件的地图
	map = new FMapLib.FMap("map");// 加载地图
	if(map){
	// 实例化地图历史版本管理器
	new FMapLib.VersonManager("innerContainer", map, "ele3");
	// 实例化卫星影像图切换器
	new FMapLib.SatelliteMapSwitcher(map);
	// 地图鼠标滑轮事件监听器
	new FMapLib.MouseWheelListener("map");
	// 加载地图顶部工具条
	appendMapToolDiv(map);   
	}else{
		alert("地图初始化异常，请检查地图服务是否正常开启！");
	}
	
});
//初始化菜单
$(document).ready(function(){
	$(".widget-title-normal").bind("mouseover", function(){
		$(this).removeClass("widget-title-normal");
			$(this).addClass("widget-title-light");		
	});
		$(".widget-title-normal").bind("mouseout", function(){
		$(this).addClass("widget-title-normal");
			$(this).removeClass("widget-title-light");		
	});
	
	$(".widget-title-normal").bind("click", function(){
	   $(this).siblings("li").andSelf().removeClass("widget-title-normal");
	   $(this).siblings("li").removeClass("widget-title-active").addClass("widget-title-normal");				
	   $(this).addClass("widget-title-active");				
	});
	$(".widget-tab-ul li:first").removeClass("widget-title-normal").addClass("widget-title-active");
	$(".widget-tab-ul li").bind("click",function(){
	 var name=$(this).attr("name");	 
	 $("#"+name).css("display","block").siblings("ul").css("display","none");
	 	new FMapLib.TreeDemo(name+""); 		 	 
	});
	 new FMapLib.TreeDemo("homePage"); //初始化首页树（默认）
});

// 加载地图顶部工具条
function appendMapToolDiv(map){
	var g = document.getElementById("maptopDiv");
	g.id = "maptoolDiv";
	g.style.position = "absolute";
	g.style.width = "100%";
	g.style.height = "12%";
	g.style.top = "0px";
	g.style.right = "0px";	  
	g.style.zIndex = 1005;
	g.style.display = "block";
	map.viewPortDiv.appendChild(g);
}

var layoutSettings_Inner = {
	applyDefaultStyles : true // basic styling for testing & demo purposes
	,
	minSize : 20 // TESTING ONLY
	,
	spacing_closed : 14,
	north__spacing_closed : 8,
	south__spacing_closed : 8,
	north__togglerLength_closed : -1 // = 100% - so cannot 'slide open'
	,
	south__togglerLength_closed : -1,
	fxName : "slide" // do not confuse with "slidable" option!
	,
	fxSpeed_open : 1000,
	fxSpeed_close : 2500,
	fxSettings_open : {
		easing : "easeInQuint"
	},
	fxSettings_close : {
		easing : "easeOutQuint"
	},
	north__fxName : "none",
	south__fxName : "drop",
	south__fxSpeed_open : 500,
	south__fxSpeed_close : 1000
	// , initClosed: true
	,
	center__minWidth : 200,
	center__minHeight : 200,
	south : {
		maxSize : 700,
		spacing_closed : 0 // HIDE resizer & toggler when 'closed'
		,
		slidable : false // REFERENCE - cannot slide if spacing_closed = 0
		,
		initClosed : true
	// CALLBACK TESTING...

	}
};

var layoutSettings_Outer = {
	name : "outerLayout" // NO FUNCTIONAL USE, but could be used by custom
							// code to 'identify' a layout
	// options.defaults apply to ALL PANES - but overridden by pane-specific
	// settings
	,
	defaults : {
		size : "auto",
		minSize : 50,
		paneClass : "pane" // default = 'ui-layout-pane'
		,
		resizerClass : "resizer" // default = 'ui-layout-resizer'
		,
		togglerClass : "toggler" // default = 'ui-layout-toggler'
		,
		buttonClass : "button" // default = 'ui-layout-button'
		,
		contentSelector : ".content" // inner div to auto-size so only it
										// scrolls, not the entire pane!
		,
		contentIgnoreSelector : "span" // 'paneSelector' for content to
										// 'ignore' when measuring room for
										// content
		,
		togglerLength_open : 35 // WIDTH of toggler on north/south edges -
								// HEIGHT on east/west edges
		,
		togglerLength_closed : 35 // "100%" OR -1 = full height
		,
		hideTogglerOnSlide : true // hide the toggler when pane is 'slid open'
		,
		togglerTip_open : "Close This Pane",
		togglerTip_closed : "Open This Pane",
		resizerTip : "Resize This Pane"
		// effect defaults - overridden on some panes
		,
		fxName : "slide" // none, slide, drop, scale
		,
		fxSpeed_open : 750,
		fxSpeed_close : 1500,
		fxSettings_open : {
			easing : "easeInQuint"
		},
		fxSettings_close : {
			easing : "easeOutQuint"
		}
	},
	north : {
		spacing_open : 1 // cosmetic spacing
		,
		togglerLength_open : 0 // HIDE the toggler button
		,
		togglerLength_closed : -1 // "100%" OR -1 = full width of pane
		,
		resizable : false,
		slidable : false
		// override default effect
		,
		fxName : "none"
	},
	west : {
		size : 250,
		spacing_closed : 21 // wider space when closed
		,
		togglerLength_closed : 21 // make toggler 'square' - 21x21
		,
		togglerAlign_closed : "top" // align to top of resizer
		,
		togglerLength_open : 0 // NONE - using custom togglers INSIDE west-pane
		,
		togglerTip_open : "Close West Pane",
		togglerTip_closed : "Open West Pane",
		resizerTip_open : "Resize West Pane",
		slideTrigger_open : "click" // default
		,
		initClosed : true
		// add 'bounce' option to default 'slide' effect
		,
		fxSettings_open : {
			easing : "easeOutBounce"
		}
	},
	center : {
		paneSelector : "#innerContent" // sample: use an ID to select pane
										// instead of a class
		,
		minWidth : 200,
		minHeight : 200
	}
};
/**
 * 全屏显示
 */
function fullScreen() {
	if (screenSta == 0) {
		// $("#portal").hide();
		// 隐藏外部北，南，西
		innerLayout.hide('south');
		hidePane('north');
		hidePane('west');
		screenSta = 1;// 代表全屏状态
		$("#a6").text("退出全屏");
		$("#td6").attr("width", "100");
	} else {
		// $("#portal").show();
		// 显示外部北，南，西
		innerLayout.show('south');
		innerLayout.sizePane('south', 50);
		innerLayout.open('south');
		showPane('north');
		openPane('north');
		showPane('west');
		openPane('west');
		screenSta = 0;
		$("#a6").text("全屏");
		$("#td6").attr("width", "40");
	}
}
/**
 * 测面
 */
function areaMeasure() {
	var areaToolInst = new FMapLib.AreaMeasureTool(map);
	areaToolInst.open();
}

/**
 * 清除自定义覆盖物，禁用点线面绘制功能
 */
function clearFeatures() {
	map.clearAllFeatures();
}
/**
 * 测距
 */
function distanceMeasure() {
	// lineLayer=new MapLib.Layer.Vector("LineLayer");
	var drawLineInst = new FMapLib.DistanceMeasureTool(map);
	drawLineInst.open();

}

/**
 * 房屋按照地址模糊查询
 * 
 */

function querybysql() {
	var val = document.getElementById("inputcontent").value;
	var houQueryInst = new FMapLib.HouseQueryByName(val);
	houQueryInst.open();
}
/**
 * 打印地图,IE8浏览器通过测试，IE9采用兼容性视图测试通过。
 */
function mapprint() {
	FMapLib.PrintMap("map");
}
/**
 * 周边查询功能
 */
function querySurrounding() {
	FMapLib.QuerySurrounding(map);
}
/**
 * 查询地图上所有小区
 */
function getFeaturesBySQL1() {
	var villageFindInst = new FMapLib.VillageQueryByName();
	villageFindInst.open();

}
/**
 * 小区名称查询
 */
function villageQueryByName() {
	var village = document.getElementById("villageinput").value;
	var villageFindInst = new FMapLib.VillageQueryByName(village);
	villageFindInst.open();
}
/**
 * 按照建筑年代条件查询楼幢信息并在地图上高亮显示
 */
/*----------------------------------------------------------------------------------------------------------------------*/
function buildingQueryByPeroids() {
	var len = document.cform1.peroid.length; // 这个是获取多选框的个数
	var con = "";
	var con1 = "and to_number(to_char(builddate,'yyyy')) <2000 and rownum<105";
	var con2 = "and to_number(to_char(builddate,'yyyy')) >=2000 and to_number(to_char(builddate,'yyyy'))<2009 and rownum<125";
	var con3 = "and to_number(to_char(builddate,'yyyy')) >=2009 and to_number(to_char(builddate,'yyyy'))<2012 and rownum<125";
	var con4 = "and to_number(to_char(builddate,'yyyy')) >=2012 and rownum<125";
	for ( var i = 0; i < len; i++) {
		if (document.cform1.peroid[i].checked == true) {
			// alert("第"+(i+1)+"个值被选中"); //因为数组下标是从0开始，所以要加1
			if (i == 0) {
				con = con + con1;
				continue;
			}
			if (i == 1) {
				con = con + con2;
				continue;
			}
			if (i == 2) {
				con = con + con3;
				continue;
			}
			if (i == 3) {
				con = con + con4;
				continue;
			}
		}
	}
	new FMapLib.BuildingQueryByDate(con).open();

}
//可见视野范围内查询
function Instantiation(btn){
	//FMapLib.QueryByExtent(map,"TOTAL_AREA",1000,10000,0);
	//弹出查询条件选择框
	    var button=btn.id;
//		var htmlStr="<div id='queryconditions' align='center' style='display:none'>"+"</div>";
//		 $("#innerContainer").append(htmlStr);
//		 $("#queryconditions").load("realtygis.queryconditions");
//		 $("#queryconditions").dialog({
//			 autoOpen : false,
//				show : "blind",
//				hide : "explode",
//				modal : true,
//				buttons : {
//					"取消" : function() {
//						$(this).dialog("close");
//					},
//					"查询" : function() {
//						//$(this).dialog("close");
						programes={areamin:"",areamax:"",floormin:"",floormax:"",buildingdata:"",buildingtype:""};//定义参数存储查询条件
//					    programes.areamin=$("#areamin").val();//获得查询条件的最小建筑面积
//						programes.areamax=$("#areamax").val();//获得查询条件的最大建筑面积
//						programes.floormin=$("#floormin").val();//获得查询条件的最小楼层数
//						programes.floormax=$("#floormax").val();//获得查询条件的最大楼层数
//						programes.buildingdata=$("#buildingdata").attr("value");//获得查询条件的建成年代
//						programes.buildingtype=$("#buildingtype").attr("value");//获得查询条件的建筑类型
//						$("#queryconditions").remove();
						if(button=="extent"){AddMovennd();}
 					    if(button=="drop"){dropExtentQuery();}
//						
//					}
//				},
//				draggable : true,
//				closeOnEscape : false,
//				title : "请输入查询条件",
//				width : 400,
//				height : 310,
//				position : "center",
//				resizable : false, // 是否可以拖动尺寸大小
//				zIndex : 6
//			 
//		 });
//		 $("#queryconditions").dialog("open");
	//获得查询条件
	
}
function ExtentQuery(){	
	FMapLib.QueryByExtent(map,programes,0);	   
}
function AddMovennd(){
		ExtentQuery();
	    map.events.on({"moveend":ExtentQuery});
}
//拉框查询
function dropExtentQuery(){
	FMapLib.DropExtentQuery(programes);
}
/**
 * @author 李洪云 2013 12 27
 * 停止查询功能
 */
function ExtentQueryCancel(){
	//alert("ok");
	map.events.un({"moveend":ExtentQuery});
	map.clearAllFeatures();
 }
// /////////////布局管理类,用来控制主页面东，南，西三个窗体的隐藏，显现，关闭，打开，窗体大小等属性。 2013.12.17
// wm////////////////////////////////////////////////
// 隐藏窗体
function hidePane(panename, arg) {
	if (arg)
		innerLayout.hide(panename);
	else
		outerLayout.hide(panename);
}
// 显现窗体
function showPane(panename, arg) {
	if (arg)
		innerLayout.show(panename, false);
	else
		outerLayout.show(panename, false);
}
// 重定义窗体大小
function sizePane(panename, num, arg) {
	if (arg)
		innerLayout.sizePane(panename, num);
	else
		outerLayout.sizePane(panename, num);

}
// 关闭窗体
function closePane(panename, arg) {
	if (arg)
		innerLayout.toggle(panename);
	else
		outerLayout.toggle(panename);
}
// 打开窗体
function openPane(panename, arg) {
	if (arg)
		innerLayout.open(panename);
	else
		outerLayout.open(panename);
}
//房屋综合查询
function buildingMiltyQuery(){
	 $("#innerContainer").append("<div id='buildingarea' align='center' style='display:none'>"+"</div>");
		$("#buildingarea").load("realtygis.dialog");
		$("#buildingarea").dialog({

			autoOpen : false,
			show : "blind",
			hide : "explode",
			modal : true,
			buttons : {
				"取消" : function() {
					$(this).dialog("close");
				},
				"查询" : function() {
					// var smallnum=$("#areamin").val();
					// var bignum=$("#areamax").val();
					// if($("#checkbox").attr("checked")==true){
					// FMapLib.HouseHoldsTheme(smallnum,bignum);
					// }
					$(this).dialog("close");
					$("#buildingarea").remove();
					queryByAreaRange();
					// 查询开始，打开南部div
					if (parent.MAP_VISION) {						
						parent.innerLayout.sizePane('south', 100);
						parent.innerLayout.open('south');						
					}
				}
			},
			draggable : true,
			closeOnEscape : false,
			title : "请输入查询条件",
			width : 400,
			height : 310,
			position : "center",
			resizable : false, // 是否可以拖动尺寸大小
			zIndex : 6
		// 层叠效果 当再有一个dialog才可以看出
		});
		var modalValue = $("#buildingarea").dialog("option", "modal");
		$("#buildingarea").dialog("open");
		function queryByAreaRange(){
			var params={areamin:"",areamax:"",bdate:"",bdate2:"",floormin:"",floormax:""};
		 if($("#areamin").val()){
			 params.areamin = $("#areamin").val();
             }
         else{
       	     params.areamin ="";
         }
         if($("#areamax").val()){
        	 params.areamax = $("#areamax").val();
         }
         else{
        	 params.areamax = "";
         }
			if($("#buildingdate").val()){
				params.bdate = $("#buildingdate").val();
			}
			else{
				params.bdate = "";					
			}
			if($("#buildingdate2").val()){
				params.bdate2 = $("#buildingdate2").val();
			}
			else{
				params.bdate2 = "";					
			}
			if($("#floormin").val()){
				params.floormin=$("#floormin").val();
			}
			else{
				params.floormin = "";
			}
			if($("#floormax").val()){
				params.floormax = $("#floormax").val();
			}
			else{
				params.floormax = "";
			}
		new	FMapLib.BuildingsAreaSurvey(params,"datatb");
}
}
//地图版本列表
function mapVersionList(){
	
	$("#datatb").empty();
//	$('#bigScreen').hide();
//	 $('#smallScreen').show();
	 if(parent.MAP_VISION){		 
	  parent.sizePane('south',700,"in");
	  parent.openPane('south',"in"); 	
	  }	
	$("#datatb").load("realtygis.mapversiongrid");
}
//地图版本修改
function versionupdate(mid){
	$("#datatb").empty();
	$("#datatb").load("realtygis.mapversion.forupdate?id="+mid);
}
//返回
function versionreturn (){
	$("#datatb").empty();
	$("#datatb").load("realtygis.mapversiongrid");
}
//创建地图版本
function mapVersionAdd(){
	 $("#innerContainer").append("<div id='addversionmap' align='center' style='display:none'>"+"</div>");
		$("#addversionmap").load("realtygis.addmapversion");
		$("#addversionmap").dialog({

			autoOpen : false,
			show : "blind",
			hide : "explode",
			modal : true,
			buttons : {
				"取消" : function() {
					$(this).dialog("close");
				},
				"新增" : function() {
					$(this).dialog("close");
					$("#addversionmap").remove();
					queryMapVersion();
					
				}
			},
			draggable : true,
			closeOnEscape : false,
			title : "请输入查询条件",
			width : 400,
			height : 310,
			position : "center",
			resizable : false, // 是否可以拖动尺寸大小
			zIndex : 6
		// 层叠效果 当再有一个dialog才可以看出
		});
		var modalValue = $("#addversionmap").dialog("option", "modal");
		$("#addversionmap").dialog("open");
		function queryMapVersion(){
			if($("#mapid").val()){
				//向后台发送请求，查询id是否存在，返回存在的id的个数
				$.post('realtygis.idcheck?id='+$("#mapid").val(), function(data, textStatus) {
					var jdata = jQuery.parseJSON(data);				
						if (jdata.item!=0) {
							alert("该ID已存在！");  
						}
						else{
								 id = $("#mapid").val();
								 
								 if($("#version_num").val()){
									version_num=$("#version_num").val();
									}
									else{
										version_num = "";
									}
								 if($("#auditor").val()){
									 auditor=$("#auditor").val();
									}
									else{
										auditor = "";
									}
								 if($("#publisher").val()){
									 publisher=$("#publisher").val();
									}
									else{
										publisher = "";
									}
								 if($("#status").val()){
									 status=$("#status").val();
									}
									else{
										status = "";
									}
								  $("#datatb").empty();
							     	$("#datatb").load("realtygis.mapversion.insert?id="+id+"&version_num="+version_num+"&auditor="+auditor+"&publisher="+publisher+"&status="+status);
							     // 查询开始，打开南部div
									if (parent.MAP_VISION) {						
										parent.innerLayout.sizePane('south', 700);
										parent.innerLayout.open('south');						
									}
						}					
				});
			}
	         else{
	       	     alert("ID不能为空");
	         }
	         
	      
		}
		
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 * @author 李洪云 2014 1 7
 * 全市房屋专题图
 */
function themeAll(){
	var button=$("#themeFiled").attr("value");
	var theme;
	var prames="";//定义参数存储查询条件
	//alert(button);
	if(button==0){
		prames="buildarea";
	}
	if(button==1){
		prames="builddata";
	}
	if(button==2){
		prames="buildtype";
	}
	if(button==3){
		prames="buildstructure";
	}
	if(button==4){
		prames="buildnature";
	}
	if(button==5){
		prames="builduse";
	}
	if($("#themeType").attr("value")==0){
		themetype="饼状图";
	}
	else{
		themetype="柱状图";
	}
	FMapLib.AllHouseTAtheme(prames,themetype);
}
/**
 *  @author 李洪云 2014 1 7
 * 分行政区统计专题图 
 */
function regionTheme(){
	var themeinfo={firstname:"",nextname:"",type:""};
	if($("#buildarea").attr("checked")==true){
		themeinfo.firstname="建筑面积"
	}
   if($("#buildnum").attr("checked")==true){
		themeinfo.nextname="建筑数量"
	}
   if($("#themeType").attr("value")==0){
		themeinfo.type="饼状图";
	}
	else{
		themeinfo.type="柱状图";
	}
	new FMapLib.RegionThemeGraph();
	 //map.events.on({"moveend":AddZoom});
}

/**
 *  @author 李洪云 2014 1 11
 *  可见视野范围内房屋统计专题图全部
 */
function extenttheme(){
	var button=$("#regionthemeFiled").attr("value");
	var theme;
	var prames="";//定义参数存储查询条件
	//alert(button);
	if(button==0){
		prames="buildarea";
	}
	if(button==1){
		prames="builddata";
	}
	if(button==2){
		prames="buildstructure";
	}
	if($("#regionthemeType").attr("value")==0){
		themetype="饼状图";
	}
	else{
		themetype="柱状图";
	}
	FMapLib.ThemeByExtent(prames,themetype);
}
function droptheme(){
	var button=$("#regionthemeFiled").attr("value");
	var theme;
	var prames="";//定义参数存储查询条件
	//alert(button);
	if(button==0){
		prames="buildarea";
	}
	if(button==1){
		prames="builddata";
	}
	if(button==2){
		prames="buildstructure";
	}
	if($("#regionthemeType").attr("value")==0){
		themetype="饼状图";
	}
	else{
		themetype="柱状图";
	}
	FMapLib.ThemeByDrop(prames,themetype);
}
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 *  @author 李洪云 2014 1 24
 *  前进后退功能
*/
function forward(){
	FMapLib.Forward();
}
function back(){
	FMapLib.Back();
}