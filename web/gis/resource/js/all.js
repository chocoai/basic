var map;
var programes;// 存放查询条件
var screenSta = 0;// 代表为默认状态(小屏)
var MAP_VISION = "1.0.1";// 辅助判断该脚本是否引入
var BA;
// layout扩展
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
	// innerLayout.sizePane('south', 100);// 隐藏南部div
	
	//左侧菜单高级查询功能挂接
	$("#superSear").bind("click", function() {
		//buildingMiltyQuery();
		basicMultiQuery();
	});
	//左侧菜单框选功能挂接
	$("#dropExtent").bind("click", function() {
		if($("#datatb")){
			if (parent.MAP_VISION) {
				parent.sizePane('south', 1, "in");
				parent.openPane('south', "in");
			}
		}
		mouseRightHandler();
		
		var mouseon=false;
		new FMapLib.DropExtentHouseQuery();
		$("#map").mouseover(function (e){
			$("#innerContainer").append('<div id="tooltip" style=" position:absolute; display:none"><h5>双击左键结束，单击右键取消</h5></div>');
		    $('#tooltip').css('top', e.pageY - 120 );
		    $('#tooltip').css('left', e.pageX - $("#tooltip").width()-40 );
		    $('#tooltip').show();
		}).mousemove(function (e) {
	        $('#tooltip').css('top', e.pageY - 120 );
	        $('#tooltip').css('left', e.pageX - $("#tooltip").width()-40 );
	    }).mouseout (function (e) {
	        if(mouseon==true){
	         //   $(this).attr('title',$('#tooltip div').html());
	            $('#tooltip').remove();
	            mouseon=false;
	        }
	    });
	});
	
});
// 初始化地图组件
$(function() {
	// 初始化一张拥有简单控件的地图
	map = new FMapLib.FMap("map");// 加载地图
	if (map) {
		// 实例化地图历史版本管理器
	//	new FMapLib.VersonManager("innerContainer", map, "ele3");
		new FMapLib.VersonManager(map);
		// 实例化卫星影像图切换器
		new FMapLib.SatelliteMapSwitcher(map);
		// 地图鼠标滑轮事件监听器
		new FMapLib.MouseWheelListener("map");
		// 加载地图顶部工具条
		appendMapToolDiv(map);
		// 加载地图隐藏/打开左菜单图标
		appendLMenuCtrlImg(map);
		// 加载地图隐藏/打开列表区图标
		appendLiAraCtrlImg(map);
		 BA= new FMapLib.BufferAnalysis(map);
	} else {
		alert("地图初始化异常，请检查地图服务是否正常开启！");
	}
	
});
// 初始化菜单
$(document).ready(
		function() {
			$(".widget-title-normal2").bind("mouseover", function() {
				$(this).removeClass("widget-title-normal2");
				$(this).addClass("widget-title-light2");
			});
			$(".widget-title-normal2").bind("mouseout", function() {
				$(this).addClass("widget-title-normal2");
				$(this).removeClass("widget-title-light2");
			});

			$(".widget-title-normal2").bind(
					"click",
					function() {
						$(this).siblings("li").andSelf().removeClass(
								"widget-title-normal2");
						$(this).siblings("li").removeClass(
								"widget-title-active2").addClass(
								"widget-title-normal2");
						$(this).addClass("widget-title-active2");
					});
			$(".widget-tab-ul li:first").removeClass("widget-title-normal2")
					.addClass("widget-title-active2 widget-title-normal2");
			$(".widget-tab-ul li").bind(
					"click",
					function() {
						var name = $(this).attr("name");
						$("#" + name).css("display", "block").siblings("ul")
								.css("display", "none");
				
					});
		$("#homePage").css("display", "block").siblings("ul")
		.css("display", "none");
		});
// 加载地图隐藏/打开列表区图标
function appendLiAraCtrlImg(map) {
	var g = document.createElement("div");
	g.id = "liAraCtrlDiv";
	g.style.position = "absolute";
	g.style.width = "5%";
	g.style.height = "4%";
	g.style.bottom = "0px";
	g.style.left = "550px";
	g.style.zIndex = 1008;
	map.viewPortDiv.appendChild(g);
	$("#liAraCtrlDiv")
			.append(
					"<image id='liAraCtrlImg' name='closeImage' src='/gis/resource/images/middle_1.png'/>");
	$("#liAraCtrlImg").live(
			"click",
			function() {
				if (this.name == 'openImage') {
					innerLayout.hide("south");
					$("#liAraCtrlImg").attr("src",
							"/gis/resource/images/middle_1.png");
					this.name = "closedImage";
				} else {
					innerLayout.open("south");
					innerLayout.sizePane("south", 100);
					$("#liAraCtrlImg").attr("src",
							"/gis/resource/images/middle_2.png");
					this.name = "openImage";
				}
			});
}
function resizeWin(){
	window.resizeBy(-20, -20);
	setTimeout(function(){window.resizeBy(20, 20);},50);
	setTimeout(function(){
		var center = map.getCenter();
		map.setCenter(new MapLib.LonLat(center.lon+10, center.lat+10));
		},300);
}
// 加载地图隐藏/打开左菜单图标
function appendLMenuCtrlImg(map) {
	var g = document.createElement("div");
	g.id = "lMenuCtrlDiv";
	g.style.position = "absolute";
	g.style.width = "2%";
	g.style.height = "5%";
	g.style.top = "170px";
	g.style.left = "0px";
	g.style.zIndex = 1008;
	map.viewPortDiv.appendChild(g);
	$("#lMenuCtrlDiv")
			.append(
					"<image id='lMenuCtrlImg' name='openImage' src='/gis/resource/images/left_jiantou_1.png'/>");
	$("#lMenuCtrlImg").live(
			"click",
			function() {
				if (this.name == 'openImage') {
					closePane("west");
					$("#lMenuCtrlImg").attr("src",
							"/gis/resource/images/left_jiantou_2.png");
					this.name = "closedImage";
					resizeWin();
				} else {
					openPane("west");
					$("#lMenuCtrlImg").attr("src",
							"/gis/resource/images/left_jiantou_1.png");
					this.name = "openImage";
					resizeWin();
				}
			});
}

// 加载地图顶部工具条
function appendMapToolDiv(map) {
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
		handlerByModelChange();
		hidePane('north');
		hidePane('west');
		screenSta = 1;// 代表全屏状态
		//$("#a6").text("退出全屏");
		//$("#a6").html("<img src='/gis/resource/images/qp2.png' style='border:0;width:20px;height:20px;'/>");
		//$('#a6').parent().attr("title","退出全屏");
		//$("#td6").attr("width", "100");
		
		setTimeout(function(){window.resizeBy(-30, -30);},100);
		setTimeout(function(){window.resizeBy(30, 30);},250);
		setTimeout(function(){
			var center = map.getCenter();
			map.setCenter(new MapLib.LonLat(center.lon+10, center.lat+10));
			},900);
		
	} else {
		// $("#portal").show();
		// 显示外部北，南，西
		//innerLayout.show('south');
		//innerLayout.sizePane('south', 50);
		//innerLayout.open('south');
		showPane('north');
		openPane('north');
		showPane('west');
		openPane('west');
		screenSta = 0;
		//$("#a6").text("全屏");
		//$("#a6").html("<img src='/gis/resource/images/qp.gif' style='border:0;width:20px;height:20px;'/>");
		//$('#a6').parent().attr("title","全屏");
		//$("#td6").attr("width", "40");
		setTimeout(function(){window.resizeBy(-30, -30);},400);
		setTimeout(function(){window.resizeBy(30, 30);},500);
		setTimeout(function(){
			var center = map.getCenter();
			map.setCenter(new MapLib.LonLat(center.lon+10, center.lat+10));
			},900);
		
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
	new FMapLib.removeTheme();
	handlerByModelChange();
	
	clearQueryResult();
	hideRightList()
	removeElementChild(document.getElementById('list'))
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
// 可见视野范围内查询
function Instantiation(btn) {
	// FMapLib.QueryByExtent(map,"TOTAL_AREA",1000,10000,0);
	// 弹出查询条件选择框
	var button = btn.id;
	// var htmlStr="<div id='queryconditions' align='center'
	// style='display:none'>"+"</div>";
	// $("#innerContainer").append(htmlStr);
	// $("#queryconditions").load("realtygis.queryconditions");
	// $("#queryconditions").dialog({
	// autoOpen : false,
	// show : "blind",
	// hide : "explode",
	// modal : true,
	// buttons : {
	// "取消" : function() {
	// $(this).dialog("close");
	// },
	// "查询" : function() {
	// //$(this).dialog("close");
	programes = {
		areamin : "",
		areamax : "",
		floormin : "",
		floormax : "",
		buildingdata : "",
		buildingtype : ""
	};// 定义参数存储查询条件
	// programes.areamin=$("#areamin").val();//获得查询条件的最小建筑面积
	// programes.areamax=$("#areamax").val();//获得查询条件的最大建筑面积
	// programes.floormin=$("#floormin").val();//获得查询条件的最小楼层数
	// programes.floormax=$("#floormax").val();//获得查询条件的最大楼层数
	// programes.buildingdata=$("#buildingdata").attr("value");//获得查询条件的建成年代
	// programes.buildingtype=$("#buildingtype").attr("value");//获得查询条件的建筑类型
	// $("#queryconditions").remove();
	if (button == "extent") {
		AddMovennd();
	}
	if (button == "drop") {
		dropExtentQuery();
	}
	//						
	// }
	// },
	// draggable : true,
	// closeOnEscape : false,
	// title : "请输入查询条件",
	// width : 400,
	// height : 310,
	// position : "center",
	// resizable : false, // 是否可以拖动尺寸大小
	// zIndex : 6
	//			 
	// });
	// $("#queryconditions").dialog("open");
	// 获得查询条件

}
function ExtentQuery() {
	FMapLib.QueryByExtent(map, programes, 0);
}
function AddMovennd() {
	ExtentQuery();
	map.events.on({
		"moveend" : ExtentQuery
	});
}
// 拉框查询
function dropExtentQuery() {
	FMapLib.DropExtentQuery(programes);
}
/**
 * @author 李洪云 2013 12 27 停止查询功能
 */
function ExtentQueryCancel() {
	// alert("ok");
	map.events.un({
		"moveend" : ExtentQuery
	});
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
// 房屋综合查询
function buildingMiltyQuery() {
	$("#innerContainer").append(
			"<div id='buildingarea' align='center' style='display:none'>"
					+ "</div>");
	$("#buildingarea").load("realtygis.dialog");
	$("#buildingarea").dialog({

		autoOpen : false,
		show : "blind",
		hide : "explode",
		modal : true,
		buttons : {			
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
			},
			"取消" : function() {
				$(this).dialog("close");
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
	function queryByAreaRange() {
		var params = {
			areamin : "",
			areamax : "",
			bdate : "",
			bdate2 : "",
			floormin : "",
			floormax : ""
		};
		if ($("#areamin").val()) {
			params.areamin = $("#areamin").val();
		} else {
			params.areamin = "";
		}
		if ($("#areamax").val()) {
			params.areamax = $("#areamax").val();
		} else {
			params.areamax = "";
		}
		if ($("#buildingdate").val()) {
			params.bdate = $("#buildingdate").val();
		} else {
			params.bdate = "";
		}
		if ($("#buildingdate2").val()) {
			params.bdate2 = $("#buildingdate2").val();
		} else {
			params.bdate2 = "";
		}
		if ($("#floormin").val()) {
			params.floormin = $("#floormin").val();
		} else {
			params.floormin = "";
		}
		if ($("#floormax").val()) {
			params.floormax = $("#floormax").val();
		} else {
			params.floormax = "";
		}
		new FMapLib.BuildingsAreaSurvey(params, "datatb");
	}
}
//测绘综合查询
function basicMultiQuery(){
	
	$("#datatb").empty();
	if (parent.MAP_VISION) {
		parent.sizePane('south', 700, "in");
		parent.openPane('south', "in");
	}
	$("#datatb").load("realtygis.buildingmultiquery");
	
}
// 地图版本列表
function mapVersionList() {
    $("#result").empty();
	$("#datatb").empty();
	// $('#bigScreen').hide();
	// $('#smallScreen').show();
	if (parent.MAP_VISION) {
		parent.sizePane('south', 700, "in");
		parent.openPane('south', "in");
	}
	$("#datatb").load("realtygis.mapversiongrid");
	
}

// 地图版本修改
function versionupdate(version_number) {
	$("#datatb").empty();
	$("#datatb").load(
			"realtygis.mapversion.forupdate?version_number=" + version_number);
}
// 返回
function versionreturn() {
	$("#datatb").empty();
	$("#datatb").load("realtygis.mapversiongrid");
}
// 创建地图版本
function mapVersionAdd() {
	$("#innerContainer").append(
			"<div id='addversionmap' align='center' style='display:none'>"
					+ "</div>");
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
		title : "请输入地图版本信息",
		width : 400,
		height : 310,
		position : "center",
		resizable : false, // 是否可以拖动尺寸大小
		zIndex : 6
	// 层叠效果 当再有一个dialog才可以看出
	});
	var modalValue = $("#addversionmap").dialog("option", "modal");
	$("#addversionmap").dialog("open");
	function queryMapVersion() {
		if ($("#mapid").val()) {
			// 向后台发送请求，查询id是否存在，返回存在的id的个数
			$.post('realtygis.idcheck?id=' + $("#mapid").val(), function(data,
					textStatus) {
				var jdata = jQuery.parseJSON(data);
				if (jdata.item != 0) {
					alert("该ID已存在！");
				} else {
					id = $("#mapid").val();

					if ($("#version_num").val()) {
						version_num = $("#version_num").val();
					} else {
						version_num = "";
					}
					if ($("#auditor").val()) {
						auditor = $("#auditor").val();
					} else {
						auditor = "";
					}
					if ($("#publisher").val()) {
						publisher = $("#publisher").val();
					} else {
						publisher = "";
					}
					if ($("#status").val()) {
						status = $("#status").val();
					} else {
						status = "";
					}
					$("#datatb").empty();
					$("#datatb").load(
							"realtygis.mapversion.insert?id=" + id
									+ "&version_num=" + version_num
									+ "&auditor=" + auditor + "&publisher="
									+ publisher + "&status=" + status);
					// 查询开始，打开南部div
					if (parent.MAP_VISION) {
						parent.innerLayout.sizePane('south', 700);
						parent.innerLayout.open('south');
					}
				}
			});
		} else {
			alert("ID不能为空");
		}

	}

}
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 * @author 李洪云 2014 1 7 全市房屋专题图
 */
function themeAll() {
	if(map)
		map.clearAllFeatures();
	handlerByModelChange();
	var button = $("#themeFiled1").attr("value");
	var theme;
	var prames = "";// 定义参数存储查询条件
	// alert(button);
	if (button == 0) {
		prames = "buildarea";
	}
	if (button == 1) {
		prames = "builddata";
	}
	if (button == 2) {
		prames = "buildtype";
	}
	if (button == 3) {
		prames = "buildstructure";
	}
	if (button == 4) {
		prames = "buildnature";
	}
	if (button == 5) {
		prames = "builduse";
	}
	var select = document.getElementsByName("select1");
		var select1 = "";
		for(var i=0; i<select.length; i++) 
		{
			if(select[i].checked){select1=select[i].value;}
		}

	if (select1 == "0") {
		themetype = "饼状图";
	} else {
		themetype = "柱状图";
	}
	if(map){
		//map.zoomTo(3);
		map.setCenter(new MapLib.LonLat(48892.64, 51001.71),3);
	}
	//FMapLib.BuildingRangeTheme(prames)
	FMapLib.AllHouseTAtheme(prames, themetype);
}
/**
 * @author 李洪云 2014 1 7 分行政区统计专题图
 */
function regionTheme() {
	if(map)
		map.clearAllFeatures();
	handlerByModelChange();
	var themeinfo = {
		firstname : "",
		nextname : "",
		type : ""
	};
	if ($("#buildarea").attr("checked") == true) {
		themeinfo.firstname = "建筑面积"
	}
	if ($("#buildnum").attr("checked") == true) {
		themeinfo.nextname = "建筑数量"
	}
	if ($("#themeType").attr("value") == 0) {
		themeinfo.type = "饼状图";
	} else {
		themeinfo.type = "柱状图";
	}
	//new FMapLib.RegionThemeGraph();
	if(map)
		map.setCenter(new MapLib.LonLat(48892.64, 51001.71),1);  
	//new FMapLib.CountyAreaAndCount();
	FMapLib.ThemeGraph(['数量','面积'],['BUILDCOUNT','BUILDAREA']);
	// map.events.on({"moveend":AddZoom});
}

function buildingStructThemePie(){
	if(map){
		map.clearAllFeatures();
		map.setCenter(new MapLib.LonLat(48892.64, 51001.71),1);
	}
	handlerByModelChange();
	new FMapLib.RegionThemePie();
}
/**
 * @author 李洪云 2014 1 11 可见视野范围内房屋统计专题图全部
 */
function extenttheme() {
	if(map)
		map.clearAllFeatures();
	var button = $("#themeFiled3").attr("value");
	var theme;
	var prames = "";// 定义参数存储查询条件
	// alert(button);
	if (button == 0) {
		prames = "buildarea";
	}
	if (button == 1) {
		prames = "builddata";
	}
	if (button == 2) {
		prames = "buildstructure";
	}
	var select = document.getElementsByName("select3");
	var select3 = "";
	for(var i=0; i<select.length; i++) 
	{
		if(select[i].checked){select3=select[i].value;}
	}
	if (select3== "0") {
		themetype = "饼状图";
	} else {
		themetype = "柱状图";
	}
	FMapLib.ThemeByExtent(prames, themetype);
}
/**
 * 自定义范围房屋专题图
 */
function droptheme() {
	if(map)
		map.clearAllFeatures();
	mouseRightHandler();
	handlerByModelChange();
	var button = $("#themeFiled4").attr("value");
	var theme;
	var prames = "";// 定义参数存储查询条件
	// alert(button);
	if (button == 0) {
		prames = "buildarea";
	}
	if (button == 1) {
		prames = "builddata";
	}
	if (button == 2) {
		prames = "buildstructure";
	}
	var select = document.getElementsByName("select4");
	var select4 = "";
	for(var i=0; i<select.length; i++) 
	{
		if(select[i].checked){select4=select[i].value;}
	}
	if (select4 == 0) {
		themetype = "饼状图";
	} else {
		themetype = "柱状图";
	}
	FMapLib.ThemeByDrop(prames, themetype);
}
/**
 * 业务分布范围统计
 */
function bussinessDistribute(){
	if(map)
		map.clearAllFeatures();
	handlerByModelChange();
	var s = $('#bussinessstartdate').val();
	//var e = $('#bussinessenddate').val();
	var e = $('#bussinessstartdate').val();
	/*if(s.length>0 && e.length>0){
		if((e-s)>3){
			alert('时间跨度太长，请选择 3 年内时间段生成专题图！');
			return;
		}
	}*/
	if(s.length>0){
		s=s+'0000';
		e=e+'1231';
	}else{
		alert('请选择开始时间！');
		return;
	}
	/*if(e.length>0){
		e = e+'1231';
	}else{
		alert('请选择结束时间！');
		return;
	}
	if(s>e){
		alert('开始时间要小于结束时间!');
		return;
	}*/
	if(map)
		map.setCenter(new MapLib.LonLat(48892.64, 51001.71),3); 
	FMapLib.BusinessDistributeQueryBySQLService(s,e);
}
/**
 * 房屋数据来源专题图
 */
function buildingDataComing(){
	if(map)
		map.clearAllFeatures();
	if(map)
		map.setCenter(new MapLib.LonLat(48892.64, 51001.71),3); 
	handlerByModelChange();
	var selected=$("#dataSourceType").attr("value");
	FMapLib.BuildingDataComingUniqueTheme(selected);
}
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * @author zhanglf 2014年4月16日 放大缩小功能
 */
function magnify() {
	FMapLib.Magnify();
}
function shrink() {
	FMapLib.Shrink();
}
function boxmagnify() {
	FMapLib.BoxMagnify();
}
function boxshrink() {
	FMapLib.BoxShrink();
}
function roam() {
	FMapLib.Roam();
}

/**
 * @author 李洪云 2014 1 24 前进后退功能
 */
function forward() {
	FMapLib.Forward();
}
function back() {
	FMapLib.Back();
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//项目地址查询
function projectAddress(){


if(($("#inputcontent").val()=="请输入项目地址") || ($("#inputcontent").val()=="")){
alert("请输入项目地址！");
}
else{
  var  building_address= $("#inputcontent").val();
  
  $("#datatb").empty();
if (parent.MAP_VISION) {
	parent.sizePane('south', 100, "in");
	parent.openPane('south', "in");
}
$("#datatb").load(encodeURI("realtygis.simplebuildingquery?building_address="+building_address));
}

}

function mouseRightHandler(){
	/*鼠标右键插件*/ 
	(function($) { 
		$.fn.extend({ 
			//定义鼠标右键方法，接收一个函数参数 
			"rightClick":function(fn){ 
			//调用这个方法后将禁止系统的右键菜单 
			$(document).bind('contextmenu',function(e){ 
			return false; 
		}); 
		//为这个对象绑定鼠标按下事件 
		$(this).mousedown(function(e){ 
		//如果按下的是右键，则执行函数 
		if(3 == e.which){ fn(); } 
		}); 
		} 
		}); 
	})(jQuery); 
	$(document).ready(function(e){ 
		$("#map").rightClick(function(){stopDrop();}); 
	}); 
}

//缓冲分析画点方法
function drawBufferPoint(){
	mouseRightHandler();
	handlerByModelChange();
	var param=$("#analysisparam").val();
	if((param==null)||(param=="")){
		alert("请输入查询半径！");
	}else{
		BA.openpoint(param);
	}
}
//缓冲分析画线方法
function drawBufferLine(){
	mouseRightHandler();
	handlerByModelChange();
	var param=$("#analysisparam").val();
	if((param==null)||(param=="")){
		alert("请输入查询半径！");
	}else{
		BA.openline(param);
	}
}
//缓冲分析选中道路方法
function drawBufferRoad(){
	mouseRightHandler();
	handlerByModelChange();
	var param=$("#analysisparam").val();
	if((param==null)||(param=="")){
		alert("请输入查询半径！");
	}else{
		BA.openroad(param);
	}
}
//缓冲分析选中房屋方法
function drawBufferHouse(){
	mouseRightHandler();
	handlerByModelChange();
	var param=$("#analysisparam").val();
	if((param==null)||(param=="")){
		alert("请输入查询半径！");
	}else{
		BA.openhouse(param);
	}
}
//缓冲分析
//function bufferAnalysis(){
////	var BA= new FMapLib.BufferAnalysis(map);
//	var param=$("#analysisparam").val();
//	BA.analysis(param);
//}
//缓冲分析查询房屋列表
function buildingFromMap(smuserid){
	if(smuserid==""){
		
	}
	else{
		 $("#datatb").empty();
		 if (parent.MAP_VISION) {
		 	parent.sizePane('south', 100, "in");
		 	parent.openPane('south', "in");
		 }
		 smuserid = smuserid.substring(0,smuserid.lastIndexOf(","))
		 $("#datatb").load("realtygis.buildingfrommap?fea="+smuserid);
	}
}


function stopDrop(){
	
    map.stopDrop();
	  $("#map").unbind("mouseover");
	  $("#map").unbind("mousemove");
	  $("#map").unbind("mouseout");
	  $('#tooltip').remove();
//	  $("#document").bind("contextmenu");
	 
//	  $.fn.extend({ 
//		//定义鼠标右键方法，接收一个函数参数 
//		"rightClick":function(fn){ 
//	  $(document).bind('contextmenu',function(e){ 
//		  return true; 
//		  });
//		}
//		}); 
}
////////////////////////////////////////////////
//安全项目地址查询
function safetyProjectAddress(){


if(($("#safetyaddress_o").val()=="请输入坐落") || ($("#safetyaddress_o").val()=="")){

	var safety= new FMapLib.SafetyQueryByAddress();
	safety.open();
}
else{
  var  address_o= $("#safetyaddress_o").val();
  var safety= new FMapLib.SafetyQueryByAddress(address_o);
  safety.open();
}

}

///////////////////////////////////////
//健康等级查询
function safetyProjectGrade(){
	if(($("#jkdj").val()=="选择健康等级")||($("#jkdj").val()=="全部")){
		var safety= new FMapLib.SafetyQueryByGrade();
		safety.open();
	}
	else{
	  var  healthgrade= $("#jkdj").val();
	  var safety= new FMapLib.SafetyQueryByGrade(healthgrade);
	  safety.open();
	}	
}
//安全健康等级分色专题图(自定义图例)
function getHouseHGT(){
	if(map)
		map.clearAllFeatures();
	handlerByModelChange();
//	var color = new Array('AFD8F8', 'F6BD0F', '8BBA00', 'FF8E46', '008E8E','D64646');
	var color=['00FF00', '0000FF', 'FFFF00', 'FF0000'];
	var mountArray=[{"一般破损":183,"严重破损":13,"完好房屋":15,"基本完好":140}];//待修改为AJAXS请求服务端返回ＪＳＯＮ数组形式。参考sql：select count(*),t.健康完损等级 from st_ridrgn_jkda_p t group by  t.健康完损等级
	var html="<div><table id='' border='0' cellspacing='6' cellpadding='0'>"+
	"<tr><td width='15'  height='7' bgcolor='"+color[0]+"'></td>"+
	"<td width='80' height='7'>完好房屋  </td><td width='20' height='7'><a>"+mountArray[0].完好房屋+"</a></td><td width='20' height='7'>幢</td></tr>"+
	"<tr><td width='15'  height='7' bgcolor='"+color[1]+"'></td>"+
	"<td width='80' height='7'>基本完好</td><td width='20' height='7'><a>"+mountArray[0].基本完好+"</a></td><td width='20' height='7'>幢  </td></tr>"+
	"<tr><td width='15'  height='7' bgcolor='"+color[2]+"'></td>"+
	"<td width='80' height='7'>一般破损</td><td width='20' height='7'><a>"+mountArray[0].一般破损+"</a></td><td width='20' height='7'>幢  </td></tr>"+
	"<tr><td width='15'  height='7' bgcolor='"+color[3]+"'></td>"+
	"<td width='80' height='7'>严重破损</td><td width='20' height='7'><a>"+mountArray[0].严重破损+"</a></td><td width='20' height='7'>幢  </td></tr>"+
	"</table></div>"  
   new FMapLib.BuildingHealthGradeRange(); //生成健康等级专题图   
	map.initLegendDiv();//初始化地图图例图层
    map.flashLegend(html);//自定义图例内容
   //缩放级别小于3级时自动放大到3级
   if(map&&map.getZoom()<3)
	   map.zoomTo(3);   
};
////安全健康等级标签(20140516 wangmeng)
//function getHouseHGL(){
//   new FMapLib.BuildingHealthGradeLabel();
//   if(map&&map.getZoom()<3)
//	   map.zoomTo(3); 
//};
//////////////////////////////////////
//小区查询
function areasearch(){
	map.clearAllFeatures();
	new FMapLib.removeTheme();
	handlerByModelChange();
	if($("#areaname").val()=="请输入小区名称"||$("#areaname").val()==""){
		alert("请输入小区名称！");
	}
	else{
	var areaname = $("#areaname").val();
	var areaq = new FMapLib.AreaQueryByName(areaname);
	areaq.open();
	}
	
	
}
 

////////////////////////////////////
//房屋标注
function buildingMarker(){
	
	
		/*鼠标右键取消插件*/ 
		(function($) { 
		$.fn.extend({ 
		//定义鼠标右键方法，接收一个函数参数 
		"rightClick":function(fn){ 
		//调用这个方法后将禁止系统的右键菜单 
//		$(document).bind('contextmenu',function(e){ 
//		return false; 
//		}); 
		//为这个对象绑定鼠标按下事件 
		$(this).mousedown(function(e){ 
		//如果按下的是右键，则执行函数 
		if(3 == e.which){ 
		fn(); 

		} 
		}); 
		} 
		}); 

		})(jQuery); 
		$(document).ready(function(e){ 
			$("#map").rightClick(function(){stopDrop();}); 
			}); 
		//实例化点标注在线编辑类
		var PE = new FMapLib.PointForEditOnline();
		 PE._activateAddFeature();
		
}
//房屋标注查询
function queryBuildingMarker(){
	var PE = new FMapLib.PointForEditOnline();
	PE._showBuildingMarker();
	
}
/**
*功能切换时隐藏底部列表
*/
function handlerByModelChange(){
	innerLayout.hide('south');
}

/********************************************首页分类查询开始**********************************************************/
//输入框回车查询、查询按钮查询
function commonQuery(){
	map.clearAllFeatures();
	new FMapLib.removeTheme();
	handlerByModelChange();
	//queryResultLabel();
	var value = $("#inputcontent").val();
	value = value.trim();
	if(value=="请输入查询内容" || value==""){
		alert("请输入查询内容！");
		return;
	}
	
	var typeValue = facebookQuery.prototype.classify;
	var dataset = facebookQuery.prototype.dataset;
	var type = facebookQuery.prototype.type;
	var datasetName = [],attr=[];
	value=" "+value+" "//前后加空格
	while( value.indexOf( " " ) != -1 ) {
		value=value.replace(" ","%"); 
	}

	if(typeValue && value.indexOf(typeValue)>-1 && dataset){
		datasetName[0] = dataset;
		attr=['ANNONOTE'];
		value = value.replace(typeValue,'');
		//value = value.replace(/ /g,'');//去掉全部空格
		value = value.trim();//去掉字符串前后空格
		FMapLib.CommonQueryByClassify(datasetName,value,attr,type,['USERID'],queryCompleted);
	}else{
		datasetName=['ST_RIDRGN_P@ORCL','POINT_CLAZZED@ORCL'];//DLGK5_ANNOp@ORCL
		attr=['ADDRESS','ANNONOTE'];
		facebookQuery.prototype.type='';
		facebookQuery.prototype.classify='';
		if(value){
			FMapLib.CommonQueryByClassify(datasetName,value,attr,null,[null,'USERID'],queryCompleted);
		}else{
			alert("请输入查询内容！");
			return;
		}
	}
}

/*
 * 首页分类查询
 * obj 数据集名称
 */
var facebookQuery = function(obj){
	
	if(map)
		map.clearAllFeatures();
	//queryResultLabel();
	var datasetName,title=obj.title,datasetArr=[],type='';
	if(title=="教育"){
		type='4';
	}else if(title=="卫生"){
		type='5';
	}else if(title=="文化"){
		type='6';
	}else if(title=="体育"){
		type='7';
	}else if(title=="交通"){
		type='8';
	}else if(title=="旅游"){
		type='9';
	}else if(title=="工商"){
		type='10';
	}else if(title=="商务"){
		facebookQueryParams('',type,obj);
		queryCompleted(0);
		return;
	}else if(title=="民政"){
		type='12';
	}else if(title=="房管单位"){
		type='1';
	}else if(title=="政府单位"){
		type='2';
	}else if(title=="街道办"){
		type='3';
	}else if(title=="鉴定"){
		type='13';
	}else if(title=="物业"){
		type='14';
	}else if(title=="中介"){
		type='15';
	}else if(title=="购物"){
		type='16';
	}else if(title=="酒店"){
		type='18';
	}else if(title=="银行"){
		type='17';
	}else{
		facebookQueryParams('',type,obj);
		queryCompleted(0);
		return;
	}
	datasetName='POINT_CLAZZED@ORCL';
	datasetArr[0] = datasetName;
	attr=['ANNONOTE'];
	FMapLib.CommonQueryByClassify(datasetArr,null,attr,type,['USERID'],queryCompleted);
	
	facebookQueryParams(datasetName,type,obj);
}
function facebookQueryParams(p,type,obj){
	facebookQuery.prototype.dataset = p;
	facebookQuery.prototype.type = type;
	facebookQuery.prototype.classify = obj.value;
	$("#inputcontent").val(obj.value);
}
/**
 *清除首页分类查询结果，同时隐藏结果页 
 */
function clearQueryResult(){
	fanhui()
	document.getElementById('queryResult').style.display='none';
	document.getElementById('toResult').style.display='none';
	document.getElementById('queryEnd1').style.display='none'
	removAllChildren();
	if(pop){
		pop.destroy();pop=null;
	}
	
	facebookQuery.prototype.lastURL = ''
	facebookQuery.prototype.lastID = ''
	facebookQuery.prototype.lastMARKER = ''
}
/**
 *查询操作回调函数 
 */
function queryCompleted(a,queryResult){
	clearQueryResult()
	if(a == 0){
		document.getElementById('queryEnd1').style.display='block'
		if(facebookQuery.prototype.classify){
			document.getElementById('queryEnd1').innerHTML='从 [<font color="red">'+facebookQuery.prototype.classify+'</font>] 中没有查询到相关的内容';
			document.getElementById('queryEnd').innerHTML='从 [<font color="red">'+facebookQuery.prototype.classify+'</font>] 中没有查询到相关的内容';
		}else{
			document.getElementById('queryEnd1').innerHTML='从 [<font color="red">济南市</font>] 没有查询到相关的内容';
			document.getElementById('queryEnd').innerHTML='从 [<font color="red">济南市</font>] 没有查询到相关的内容';
		}
	}else{
		document.getElementById('queryEnd').style.display = 'block';
		document.getElementById('queryResult').style.display='block';
		document.getElementById('queryEnd1').style.display='none'
		document.getElementById('queryEnd1').innerHTML=''
		if(facebookQuery.prototype.classify){
			document.getElementById('queryEnd').innerHTML='从 [<font color="red">'+facebookQuery.prototype.classify+'</font>] 中查询到<font color="red">'+a+'</font>条记录';
		}else{
			document.getElementById('queryEnd').innerHTML='从 [<font color="red">济南市</font>] 查询到<font color="red">'+a+'</font>条记录';
		}
		showResult();
		createElements(queryResult);
	}
	
}
function prePage(){
	if((facebookQuery.prototype.currentPage-1) > 0){
		facebookQuery.prototype.currentPage-=1
		document.getElementById('curr').innerHTML = facebookQuery.prototype.currentPage;
		document.getElementById('nextpage').style.disable=true
		createOnePage(facebookQuery.prototype.currentPage,facebookQuery.prototype.pageSize,facebookQuery.prototype.markers)
		changeSmallPic(facebookQuery.prototype.currentPage+1,facebookQuery.prototype.pageSize,facebookQuery.prototype.markers)
	}else{
		document.getElementById('prepage').style.disable=false
	}
}
function nextPage(){
	if((facebookQuery.prototype.currentPage+1) <= facebookQuery.prototype.totalPages){
		facebookQuery.prototype.currentPage+=1
		document.getElementById('curr').innerHTML = facebookQuery.prototype.currentPage;
		document.getElementById('prepage').style.disable=true
		
		createOnePage(facebookQuery.prototype.currentPage,facebookQuery.prototype.pageSize,facebookQuery.prototype.markers)
		//还原上一页信息图表为小图标
		changeSmallPic(facebookQuery.prototype.currentPage-1,facebookQuery.prototype.pageSize,facebookQuery.prototype.markers)
		
	}else{
		document.getElementById('nextpage').style.disable=false
	}
}
function createElements(a){
	var args = a;
	facebookQuery.prototype.markers = a;
	//计算分页数据
	facebookQuery.prototype.pageSize = 10;
	var totalNum = a.length;
	facebookQuery.prototype.totalNum = totalNum;
	
	var currentPage = 1;
	facebookQuery.prototype.currentPage = currentPage;
	
	var totalPages = Math.ceil(totalNum/facebookQuery.prototype.pageSize);
	facebookQuery.prototype.totalPages = totalPages;
	
	if(totalPages < 2){
		document.getElementById('pageBtn').style.display = 'none';
	}else{
		document.getElementById('pageBtn').style.display = 'block';
	}
	
	document.getElementById('curr').innerHTML = currentPage
	document.getElementById('tot').innerHTML = totalPages
	
	if(totalPages>0){
		document.getElementById('nextpage').style.disable='true'
	}
	
	createOnePage(facebookQuery.prototype.currentPage,facebookQuery.prototype.pageSize,facebookQuery.prototype.markers)
}
//根据当前页码，创建一页信息。同时，把该页信息对应的气泡改变
function createOnePage(curr,size,a){
	removAllChildren();
	var resultContent = document.getElementById('resultContent');
	
	var startInd = (curr-1)*size;
	var endInd = curr*size-1;
	if(endInd >= facebookQuery.prototype.totalNum)
		endInd = facebookQuery.prototype.totalNum-1
	var indx=0
	for(var i=startInd;i<=endInd;i++){
		indx= indx+1;
		var marker = a[i];
		var tab = document.createElement('table')
		tab.id = marker.info.attributes['SMID'];
		tab.width='100%'
		tab.onmouseover = onmuseover;
		tab.onmouseout = onmuseout;
		tab.onclick = onclick;
		var tr = document.createElement('tr')
		var td1 = document.createElement('td')
		var img = document.createElement('img')
		img.src=marker.info.baseurl + "theme/images/nummarker/blue"+indx+".png"
		img.id='img'+marker.info.attributes['SMID'];
		img.width=22
		img.height=20
		
		var td2 = document.createElement('td')
		var div = document.createElement('div');
		//div.id=marker.info.attributes['SMID'];
		div.innerHTML = marker.info.attributes[marker.info.attr];
		//div.onmouseover = onmuseover;
		//div.onmouseout = onmuseout;
		//div.onclick = onclick;
		div.style.cursor='pointer';
		div.style.height='34px';
		div.style.width='180px';
		//div.style.background='#ffffff';
		//div.style.textAlign='left';
		//div.style.marginLeft='5px';
		div.style.paddingLeft='5px';
		//div.style.paddingRight='5px';
		div.style.paddingTop='5px';
		div.style.paddingBottom='5px';
		//resultContent.appendChild(div);
		
		
		td1.appendChild(img)
		td2.appendChild(div)
		tr.appendChild(td1);
		tr.appendChild(td2);
		tab.appendChild(tr);
		resultContent.appendChild(tab);
		
		var icon = marker.icon;
		icon.setSize(new MapLib.Size(32,30));
		icon.setUrl(marker.info.baseurl + "theme/images/nummarker/blue"+indx+".png")
	}
}
//还原上一页信息图表为小图标
function changeSmallPic(curr,size,a){
	var startInd = (curr-1)*size;
	var endInd = curr*size-1;
	if(endInd >= facebookQuery.prototype.totalNum)
		endInd = facebookQuery.prototype.totalNum-1
	
	for(var i=startInd;i<=endInd;i++){
		var marker = a[i];
		var icon = marker.icon;
		icon.setSize(new MapLib.Size(16,15));
		icon.setUrl(marker.info.baseurl + "theme/images/marker11.png")
	}
}
var pop;
function onclick(){
	var markers = facebookQuery.prototype.markers;
	if(!markers) return;
	var div = this;
	this.style.background='#DCF1F1';//#F1F0D3
	this.setAttribute('clicked','clicked');
	var id = this.id
	if(facebookQuery.prototype.lastURL && facebookQuery.prototype.lastID){
		pop.obj.style.background='#ffffff';//
		pop.obj.removeAttribute('clicked');
		
		var lastURL = facebookQuery.prototype.lastURL;
		lastURL=lastURL.replace('red','blue');
		facebookQuery.prototype.lastMARKER.setUrl(lastURL)
		var i = document.getElementById('img'+facebookQuery.prototype.lastID)
		i.src=lastURL
		//marker.map.removePopup(pop);
		pop.destroy();pop=null;
	}
	for(var i=0;i<markers.length;i++){
		var marker = markers[i]
		var icon = marker.icon;
		var url = icon.url
		if(this.id == marker.info.attributes['SMID']){
			marker.map.setCenter(new MapLib.LonLat(marker.info.attributes['SMX'], marker.info.attributes['SMY']));
			//marker.map.zoomTo(8);
			//marker.setUrl(marker.info.baseurl + "theme/images/markerbig.png");
		    var lonlat = marker.getLonLat(); 
		    pop = new MapLib.Popup.FramedCloud("popwin",new MapLib.LonLat(lonlat.lon,lonlat.lat),new MapLib.Size(200,150),
		    		marker.info.attributes[marker.info.attr],marker.icon,true,closeFunc);
		    pop.obj = div;
		    marker.map.addPopup(pop);
		   
		    facebookQuery.prototype.lastURL = url
		    facebookQuery.prototype.lastID = id
		    facebookQuery.prototype.lastMARKER = marker
		    
			function closeFunc(){
				div.removeAttribute('clicked');
				url=url.replace('red','blue');
				marker.setUrl(url)
				var i = document.getElementById('img'+id)
				i.src=url
				if(pop){
					//marker.map.removePopup(pop);
					pop.destroy();pop=null;
				}
				div.style.background='#ffffff';
				
				facebookQuery.prototype.lastURL = ''
			    facebookQuery.prototype.lastID = ''
			    facebookQuery.prototype.lastMARKER = ''
			}
			return;
		}
	}
}
function onmuseover(){
	if(this.getAttribute('clicked')) return;
	this.style.background='#DCF1F1';
	var markers = facebookQuery.prototype.markers;
	if(!markers) return;
	for(var i=0;i<markers.length;i++){
		var marker = markers[i]
		if(this.id == marker.info.attributes['SMID']){
			//var icon = marker.icon;
			//icon.setSize(new MapLib.Size(32,30));
			var icon = marker.icon;
			//icon.setSize(new MapLib.Size(32,30));
			var url = icon.url
			url=url.replace('blue','red');
			icon.setUrl(url)
			//marker.setUrl(marker.info.baseurl + "theme/images/markerbig.png");
			
			var i = document.getElementById('img'+this.id)
			//i.src=marker.info.baseurl + "theme/images/markerbig.png"
			i.src=url
			
			return;
		}
	}
}
function onmuseout(){
	if(this.getAttribute('clicked')) return;
	this.style.background='#ffffff';
	var markers = facebookQuery.prototype.markers;
	if(!markers) return;
	for(var i=0;i<markers.length;i++){
		var marker = markers[i]
		if(this.id == marker.info.attributes['SMID']){
			var icon = marker.icon;
			//icon.setSize(new MapLib.Size(32,30));
			var url = icon.url
			url=url.replace('red','blue');
			icon.setUrl(url)
			//marker.setUrl(marker.info.baseurl + "theme/images/markerbig.png");
			
			var i = document.getElementById('img'+this.id)
			//i.src=marker.info.baseurl + "theme/images/markerbig.png"
			i.src=url
			return;
		}
	}
}
//清除结果列表
function removAllChildren(){
	var div = document.getElementById('resultContent');
    while(div.hasChildNodes()) //当div下还存在子节点时 循环继续
    {
        div.removeChild(div.firstChild);
    }
    if(pop){
    	pop.destroy();pop=null;
    }
    facebookQuery.prototype.lastURL = ''
    facebookQuery.prototype.lastID = ''
    facebookQuery.prototype.lastMARKER = ''
}
//隐藏或者显示结果列表a=true显示；a=false 隐藏
function hideOrShowResultList(a){
	var div = document.getElementById('resultContent');
	if(a){
		div.style.display = 'block';
	}else
		div.style.display = 'none';
}

function queryResultLabel(){
	var label = document.getElementById('queryEnd');
	label.style.display = 'none';
}
function fanhui(){
	var fellei = document.getElementById('fenlei');
	fellei.style.display = 'block';
	var toResult = document.getElementById('toResult');
	toResult.style.display = 'block';
	var result1 = document.getElementById('result1');
	result1.style.display = 'none';
	var pageBtn = document.getElementById('pageBtn');
	pageBtn.style.display = 'none';
	var pageBtn = document.getElementById('fanhui');
	pageBtn.style.display = 'none';
	
	hideOrShowResultList(false)
}
function showResult(){
	var fellei = document.getElementById('fenlei');
	fellei.style.display = 'none';
	var toResult = document.getElementById('toResult');
	toResult.style.display = 'none';
	var result1 = document.getElementById('result1');
	result1.style.display = 'block';
	var pageBtn = document.getElementById('pageBtn');
	pageBtn.style.display = 'block';
	var fanhui = document.getElementById('fanhui');
	fanhui.style.display = 'block';
	
	hideOrShowResultList(true)
}
/********************************************首页分类查询结束**********************************************************/

/**右侧列表  开始**********************************************************/
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
/**右侧列表  结束**********************************************************/
/**周边危险点分析**/
$("#dangerousAnalyst").click(function(){
	var radius = $('#dangerouAnaRadius').val()
	if(radius==null || radius==''){
		alert('请输入查询半径!')
		return;
	}
	var select = document.getElementsByName("radioDangeroue");
	var radioDangeroue = "";
	for(var i=0; i<select.length; i++) 
	{
		if(select[i].checked){
			radioDangeroue=select[i].value;
		}
	}
	
	if(map)
		map.clearAllFeatures();
	mouseRightHandler();
	handlerByModelChange();
  	FMapLib.bufferAnalyst(radius,radioDangeroue);
})

/**危险点分布*/
$("#dangerousDist").click(function(){
	FMapLib.queryDangerousBySQL();
});

$("#surroundingAnalyst").click(function(){
	var has1=false,type=[];
	for(i=0;i<document.form1.length;i++){
		if(document.form1.elements[i].type=='checkbox'){
			if(document.form1.elements[i].checked){
				has1=true;
				 type[type.length]= document.form1.elements[i].value
			} 
		}
	}
	if(has1==false){
		alert('请至少选中一个类别')
		return;
	}
	var radius = $('#surroundingAnaRadius').val()
	if(radius==null || radius==''){
		alert('请输入查询半径!')
		return;
	}
	if(map)
		map.clearAllFeatures();
	mouseRightHandler();
	handlerByModelChange();
	FMapLib.surroundingAnalustQuery(radius,['POINT_CLAZZED@ORCL'],null,null,[type],['TYPE'],surroundingAnalystResult,['TYPE,USERID'])
})

function surroundingAnalystResult(markers,count){
	var m = markers
	var c = count
	if(c<1){
		hideRightList()
		removeElementChild(document.getElementById('list'))
		return;
	}
	rightList();
	//创建列表
	var list = document.getElementById('list');
	removeElementChild(list)
	for(var i=0;i<m.length;i++){
		var marker = m[i];
		var tab = document.createElement('table')
		tab.id = marker.info.attributes['SMID'];
		tab.width='100%'
		tab.onmouseover = onmuseover;
		tab.onmouseout = onmuseout;
		tab.onclick = onclick;
		var tr = document.createElement('tr')
		var td1 = document.createElement('td')
		var img = document.createElement('img')
		img.src=marker.icon.url
		img.id='img'+marker.info.attributes['SMID'];
		img.width=22
		img.height=20
		
		var td2 = document.createElement('td')
		var div = document.createElement('div');
		//div.id=marker.info.attributes['SMID'];
		div.innerHTML = marker.info.attributes['ANNONOTE'];
		//div.onmouseover = onmuseover;
		//div.onmouseout = onmuseout;
		//div.onclick = onclick;
		div.style.cursor='pointer';
		//div.style.height='24px';
		div.style.width='210px';
		//div.style.background='#ffffff';
		//div.style.textAlign='left';
		//div.style.marginLeft='5px';
		div.style.paddingLeft='3px';
		//div.style.paddingRight='5px';
		div.style.paddingTop='3px';
		div.style.paddingBottom='3px';
		//resultContent.appendChild(div);		
		td1.appendChild(img)
		td2.appendChild(div)
		tr.appendChild(td1);
		tr.appendChild(td2);
		tab.appendChild(tr);
		list.appendChild(tab);
	}	
	function onmuseover(){
		if(clickID && clickID == this.id) return;
		this.style.background='#DCF1F1';
		for(var i=0;i<m.length;i++){
			var marker = m[i];
			if(this.id == marker.info.attributes['SMID']){
				var icon = marker.icon;
				var url = icon.url
				url = url.replace('.png','_hover.png')
				icon.setUrl(url);
				return;
			}
		}
	}
	function onmuseout(){
		if(clickID && clickID == this.id) return;
		this.style.background='#ffffff';
		for(var i=0;i<m.length;i++){
			var marker = m[i];
			if(this.id == marker.info.attributes['SMID']){
				var icon = marker.icon;
				var url = icon.url
				url = url.replace('_hover.png','.png')
				icon.setUrl(url);
				return;
			}
		}
	}
	var clickID,lastMarker
	function onclick(){
		if(clickID){
			if(pop){
				map.removePopup(pop)
			}
			document.getElementById(clickID).style.background='#ffffff';
			var icon = lastMarker.icon;
		    var url = icon.url
		    url = url.replace('_hover.png','.png')
			icon.setUrl(url);
			clickID = null;
			lastMarker=null
		}
		for(var i=0;i<m.length;i++){
			var marker = m[i]
			if(this.id == marker.info.attributes['SMID']){
				map.setCenter(new MapLib.LonLat(marker.info.attributes['SMX'], marker.info.attributes['SMY']));
			    var lonlat = marker.getLonLat(); 
			    var contentHTML = "<div style=\'font-size:14px; opacity: 0.8; overflow-y:hidden;\'>"; 
			    contentHTML += "<div style='padding-top:5px;padding-left:10px;'>"+marker.info.attributes['ANNONOTE']+"</div></div>";
			    pop = new MapLib.Popup.FramedCloud("popwin",new MapLib.LonLat(lonlat.lon,lonlat.lat),new MapLib.Size(200,150),
			    		contentHTML,marker.icon,true,closePop);
			    marker.map.addPopup(pop);
			    var icon = marker.icon;
			    var url = icon.url
			    clickID=this.id;
			    lastMarker=marker
			    this.style.background='#DCF1F1';//#F1F0D3
				function closePop(){
					url = url.replace('_hover.png','.png')
					icon.setUrl(url);
					if(pop){
						map.removePopup(pop)
					}
					document.getElementById(clickID).style.background='#ffffff';
					clickID = null;
					lastMarker=null
				}
				return;
			}
		}
	}
}
function removeElementChild(e){
    while(e.hasChildNodes()) //当div下还存在子节点时 循环继续
    {
        e.removeChild(e.firstChild);
    }
}
function hideRightList(){
	var combox = document.getElementById("common_box");
	combox.style.display='none'
}

/**天气预报*/
$("#weatherForcast").click(function(){
	FMapLib.weatherForcast();
});
//字符串类型方法自定义
String.prototype.trim=function() {    return this.replace(/(^\s*)|(\s*$)/g,'');}