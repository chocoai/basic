(function() {
	var curMenu = null, zTree_Menu = null;
		var setting = {
			view: {
				showLine: false,
				showIcon:showIconForTree,
				showTitle:true,
				//selectedMulti: false,
			dblClickExpand: false
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			//onNodeCreated: this.onNodeCreated,
			beforeExpand: beforeExpand,
			onExpand: onExpand,
			beforeClick:beforeClick,
			//beforeMouseDown:beforeMouseDown,
			onClick:onClick
		}
	};
	//首页
	var  zNodes_homePage =[		       
		{ id:1, pId:0, name:"查询",open:true},
		{ id:11, pId:1, name:"请输入项目地址"},
//		{ id:111, pId:11, name:"1949年以前"},
//		{ id:112, pId:11, name:"1949-1998年"},
//		{ id:113, pId:11, name:"1998-2009年"},
//		{ id:114, pId:11, name:"2009年之后"},		
//		{ id:12, pId:1, name:"产权性质",iconClose:"/gis/resource/images/close.gif",iconOpen:"/gis/resource/images/open.gif"},
//		{ id:121, pId:12, name:"国有房产"},
//		{ id:122, pId:12, name:"集体所有房产"},
//		{ id:123, pId:12, name:"私有房产"},
//		{ id:124, pId:12, name:"其他房产"},
//		{ id:13, pId:1, name:"房屋用途",iconClose:"/gis/resource/images/close.gif",iconOpen:"/gis/resource/images/open.gif"},
//		{ id:131, pId:13, name:"住宅"},
//		{ id:132, pId:13, name:"非住宅"},
//		{ id:133, pId:13, name:"商业服务"},
//		{ id:134, pId:13, name:"其他用途"},
//		{ id:14, pId:1, name:"房屋类型",iconClose:"/gis/resource/images/close.gif",iconOpen:"/gis/resource/images/open.gif"},
//		{ id:141, pId:14, name:"平房"},
//		{ id:142, pId:14, name:"多层"},
//		{ id:143, pId:14, name:"小高层"},
//		{ id:144, pId:14, name:"高层"},
//		{ id:15, pId:1, name:"结构类型",iconClose:"/gis/resource/images/close.gif",iconOpen:"/gis/resource/images/open.gif"},
//		{ id:151, pId:15, name:"钢结构"},
//		{ id:152, pId:15, name:"钢混结构"},
//		{ id:153, pId:15, name:"钢砼结构"},
//		{ id:154, pId:15, name:"混合结构"},
//		{ id:155, pId:15, name:"砖木结构"},	
//		{ id:156, pId:15, name:"木结构"},	
//		{ id:157, pId:15, name:"其他结构"},	
	];
	//房产测绘
	var    zNodes_analysis =[	   						
				{ id:2, pId:0, name:"查询",open:true},
				{ id:21, pId:2, name:"高级查询",iconClose:"/gis/resource/images/close.gif",iconOpen:"/gis/resource/images/open.gif"},			           
				{ id:211, pId:21, name:""},
				{ id:23, pId:2, name:"拉框查询",iconClose:"/gis/resource/images/close.gif",iconOpen:"/gis/resource/images/open.gif"},		
//				{ id:212, pId:21, name:""},
//				{ id:213, pId:21, name:"叶子节点 2-1-3"},
//				{ id:214, pId:21, name:"叶子节点 2-1-4"},
				{ id:22, pId:2, name:"单一查询",iconClose:"/gis/resource/images/close.gif",iconOpen:"/gis/resource/images/open.gif"},
				{ id:221, pId:22, name:"按建设年代查询",iconClose:"/gis/resource/images/close.gif",iconOpen:"/gis/resource/images/open.gif"},
				{ id:2211, pId:221, name:"1949年以前"},
				{ id:2212, pId:221, name:"1949-1998年"},
				{ id:2213, pId:221, name:"1998-2009年"},
				{ id:2214, pId:221, name:"2009年之后"},					
				{ id:222, pId:22, name:"按产权性质查询",iconClose:"/gis/resource/images/close.gif",iconOpen:"/gis/resource/images/open.gif"},
				{ id:2221, pId:222, name:"国有房产"},
				{ id:2222, pId:222, name:"集体所有房产"},
				{ id:2223, pId:222, name:"私有房产"},
				{ id:2224, pId:222, name:"其他房产"},
				{ id:223, pId:22, name:"按房屋用途查询",iconClose:"/gis/resource/images/close.gif",iconOpen:"/gis/resource/images/open.gif"},
				{ id:2231, pId:223, name:"住宅"},
				{ id:2232, pId:223, name:"非住宅"},
				{ id:2233, pId:223, name:"商业服务"},
				{ id:2234, pId:223, name:"其他用途"},
				{ id:224, pId:22, name:"按房屋类型查询",iconClose:"/gis/resource/images/close.gif",iconOpen:"/gis/resource/images/open.gif"},
				{ id:2241, pId:224, name:"平房"},
				{ id:2242, pId:224, name:"多层"},
				{ id:2243, pId:224, name:"小高层"},
				{ id:2244, pId:224, name:"高层"},
				{ id:225, pId:22, name:"按结构类型查询",iconClose:"/gis/resource/images/close.gif",iconOpen:"/gis/resource/images/open.gif"},
				{ id:2251, pId:225, name:"钢结构"},
				{ id:2252, pId:225, name:"钢混结构"},
				{ id:2253, pId:225, name:"钢砼结构"},
				{ id:2254, pId:225, name:"混合结构"},
				{ id:2255, pId:225, name:"砖木结构"},	
				{ id:2256, pId:225, name:"木结构"},	
				{ id:2257, pId:225, name:"其他结构"},	
				{ id:3, pId:0, name:"统计"},
				{ id:31, pId:3, name:"全市测绘统计",iconClose:"/gis/resource/images/close.gif",iconOpen:"/gis/resource/images/open.gif"},
				{ id:311, pId:31, name:"按年预实测套数统计"},
				{ id:312, pId:31, name:"按年基础测绘面积统计"},
				{ id:313, pId:31, name:"按设计用途测绘套数统计"},				
				{ id:32, pId:3, name:"区县测绘统计",iconClose:"/gis/resource/images/close.gif",iconOpen:"/gis/resource/images/open.gif"},
				{ id:321, pId:32, name:"预实测房产套数统计"},
				{ id:322, pId:32, name:"基础测绘面积统计"},
				{ id:323, pId:32, name:"按设计用途测绘套数统计"},				
			    { id:4, pId:0, name:"专题"},
          		{ id:41, pId:4, name:"全市楼房专题",iconClose:"/gis/resource/images/close.gif",iconOpen:"/gis/resource/images/open.gif"},
          		{ id:411,pId:41,name:''},
          		{ id:412,pId:41,name:''},
          		//{ id:413,pId:41,name:''},
          		{ id:42, pId:4, name:"区县专题",iconClose:"/gis/resource/images/close.gif",iconOpen:"/gis/resource/images/open.gif"},
          		{ id:421, pId:42, name:"数量"},
          		{ id:422, pId:42, name:"结构"},
          		{ id:43, pId:4, name:"视野范围内专题",iconClose:"/gis/resource/images/close.gif",iconOpen:"/gis/resource/images/open.gif"},
          		{ id:431,pId:43,name:''},
          		{ id:432,pId:43,name:''},
          		//{ id:433,pId:43,name:''},
          		{ id:44, pId:4, name:"自定义范围专题",iconClose:"/gis/resource/images/close.gif",iconOpen:"/gis/resource/images/open.gif"},
          		{ id:441,pId:44,name:''},
          		{ id:442,pId:44,name:''},
				
			];
	//房屋安全
    //房屋权属
	//小区物业
  //地图运维
  var zNodes_layersManager=[                            
       // { id:5, pId:0, name:"地图版本发布"}, 
        { id:6, pId:0, name:"地图服务列表"},
        { id:7, pId:0, name:"地图切片设置"},        
      ];
  //API参考
  var zNodes_APIManager=[
      //  { id:8, pId:0, name:"AK管理"}, 
      //  { id:9, pId:0, name:"权限管理"},
      //  { id:10, pId:0, name:"IP白名单"},
        { id:11, pId:0, name:"API在线帮助"}
      ];
//  //用户中心
//  var zNodes_usersManager=[
//        { id:12, pId:0, name:"用户审核"}, 
//        { id:13, pId:0, name:"用户列表"},
//        { id:14, pId:0, name:"角色分配"},      
//      ];  
//  //数据运维
//  var zNodes_dataManager=[
//        { id:15, pId:0, name:"数据同步"}, 
//        { id:16, pId:0, name:"数据补充"},
//        { id:17, pId:0, name:"历史数据导入"},                   
//      ];
	function onClick(e,treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj(curMenu);
		zTree.expandNode(treeNode, null, null, null, true);
	}
	/**
	 * 点击树叶节点触发查询事件
	 * @param treeId
	 * @param treeNode
	 */
	function beforeClick(treeId, treeNode) {
        if(treeNode.id == 1){
        	if(treeNode.open=="true"){
        		treeNode[2].open="fasle";
        	}
        }
		if (treeNode.id == 122 ) {
			getFeaturesBySQL1();
		}
		if (treeNode.id == 5 ) {
			//mapVersionAdd();
		}
		if (treeNode.id == 6 ) {
			mapVersionList();
		}
		if(treeNode.id==1112){
			getFeaturesBySQL2();
		}
		if(treeNode.id==111){
			//alert("开始查询。。");
			
			new FMapLib.BuildingQueryByDate("and to_number(to_char(builddate,'yyyy')) <1949 and rownum<125").open();
			//$("#tuli").css('display','block');
		}
		if(treeNode.id==112){
			//alert("开始查询。。");
			new FMapLib.BuildingQueryByDate("and to_number(to_char(builddate,'yyyy')) >=1949 and to_number(to_char(builddate,'yyyy')) <1998 and rownum<125").open();
			//$("#tuli").css('display','block');
		}			
		if(treeNode.id==113){
			//alert("开始查询。。");
			//document.getElementById("tuli").display="block";
			//$("#tuli").css('display','block');
			new FMapLib.BuildingQueryByDate("and to_number(to_char(builddate,'yyyy')) >=1998 and to_number(to_char(builddate,'yyyy')) <2009 and rownum<125").open();
			
		}
		if(treeNode.id==114){
			//alert("开始查询。。");
			new FMapLib.BuildingQueryByDate("and to_number(to_char(builddate,'yyyy')) >=2009 and rownum<125").open();
			//$("#tuli").css('display','block');
		}
//			if(treeNode.id==211){
//				new FMapLib.BuildingsFromSurvey().open();
//			}
		if(treeNode.id==21){
			//new FMapLib.BuildingsAreaSurvey();
			//buildingMiltyQuery();
			basicMultiQuery();
		}
		if(treeNode.id==23){
			new FMapLib.DropExtentHouseQuery();
		
		}
		if(treeNode.id==311){
			window.open('realtygis.cityprojectsurveytj?type=seriesline&surverStartDate=2011&surverEndDate=2014&both=true','_blank','depended=yes,top='+(window.screen.height-30-400)/2+',left='+(window.screen.width-10-875)/2+',width=875,height=400,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes');
		}
		if(treeNode.id==312){
			window.open('realtygis.citysurveyareatj?type=seriesline&surverStartDate=2011&surverEndDate=2014','_blank','depended=yes,top='+(window.screen.height-30-400)/2+',left='+(window.screen.width-10-875)/2+',width=875,height=400,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes');
		}
		if(treeNode.id==313){
			window.open('realtygis.citysurveyusedesigntj?type=seriesline&surverStartDate=2011&surverEndDate=2014','_blank','depended=yes,top='+(window.screen.height-30-400)/2+',left='+(window.screen.width-10-875)/2+',width=875,height=400,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes');
		}
		
		if(treeNode.id==321){
			window.open('realtygis.districtprojectsurveytj?type=cloumn&surverStartDate=2011&surverEndDate=2014&both=true','_blank','depended=yes,top='+(window.screen.height-30-600)/2+',left='+(window.screen.width-10-900)/2+',width=900,height=600,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes');
		}
		
		if(treeNode.id==322){
			window.open('realtygis.districtsurveyareatj?type=cloumn&surverStartDate=2011&surverEndDate=2014','_blank','depended=yes,top='+(window.screen.height-30-400)/2+',left='+(window.screen.width-10-875)/2+',width=875,height=400,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes');
		}
		
		if(treeNode.id==323){
			window.open('realtygis.districtsurveyusedesigntj?type=cloumn&surverStartDate=2011&surverEndDate=2014','_blank','depended=yes,top='+(window.screen.height-30-600)/2+',left='+(window.screen.width-10-875)/2+',width=875,height=600,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes');
		}
		
		//行政区总面积等级符号专题图
		//行政区总面积等级符号专题图
//		if(treeNode.id==411){
//			new FMapLib.GraduatedSymbol("SMAREA");
//		}
//		//建筑总面积点密度专题图
//		if(treeNode.id==412){
//			new FMapLib.DotDensity("BUILDAREA");
//		}
//		//id和建筑面积分段标签专题图
//		if(treeNode.id==413){
//			new FMapLib.ThemeLabel("BUILDAREA","SMID");
//		}
//		if(treeNode.id==414){
//			new FMapLib.ThemeRange("BUILDAREA");
//		}
//		if(treeNode.id==415){
//			new FMapLib.ThemeGraph("SMAREA","BUILDAREA");
//		}
//		if(treeNode.id==421){
//			new FMapLib.TemeRangeTA("TOTAL_AREA");
//		}
//		if(treeNode.id==422){
//			FMapLib.HouseTAthemePie();
//		}
//		if(treeNode.id==423){
//			FMapLib.HouseTAthemeColumn();
//		}
		//全部房屋专题图
		if(treeNode.id==4){
			var doc=document.getElementById("themeconditions");
			if(doc!=null){
				$("#themeconditions").remove();
			}
			 doc=document.getElementById("extentthemeconditions");
			if(doc!=null){
				$("#extentthemeconditions").remove();
			}
			 doc=document.getElementById("dropthemeconditions");
			if(doc!=null){
				$("#dropthemeconditions").remove();
			}
			var zTree = $.fn.zTree.getZTreeObj(curMenu);
			var node1 = treeNode.children[0];
			 zTree.expandNode(node1, false);
			 var node2 = treeNode.children[1];
			 zTree.expandNode(node2, false);
			 var node3 = treeNode.children[2];
			 zTree.expandNode(node3, false);
			 var node4 = treeNode.children[3];
			 zTree.expandNode(node4, false);
			//var node2 = zTree.getNodeByTId("421");

		}
		if(treeNode.id==41){
			var doc=document.getElementById("themeconditions");
			if(doc!=null){
				$("#themeconditions").remove();
			}
			else{
			var htmlstr='<div id="themeconditions" class="blk" style="position: absolute; float: left; left: 25px; top: 110px; opacity: 1; z-index: 999; width: 150px; height: 50px;">'+
			'<select id="themeFiled">'+
		    '<option value="0">建筑面积</option>'+
		    '<option value="1">建成年代</option>'+
		    '<option value="2">楼层类型</option>'+
		    '<option value="3">房屋结构</option>'+
		    '<option value="4">产权性质</option>'+
		    '<option value="5">房屋用途</option>'+
		    '</select>&nbsp&nbsp'+
		    '<select id="themeType">'+
	        '<option value="0">饼状图</option>'+
	        '<option value="1">柱状图</option>'+
	        '</select><br>'+
	        '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="button" style="width:55px;height:23px;background:url(/gis/resource/images/anniu.png) no-repeat; border:none; color:white;" value="确 定" onclick="javascript:themeAll()"/>'+
			'</div>';
			$("#westmenu").append(htmlstr);
		}
		}
		if(treeNode.id==421){
			var doc=document.getElementById("theme");
			if(doc!=null){
				$("#theme").remove();
			}
			else{
//				var html='<div id="theme" class="blk" style="position: absolute; float: left; left: 40px; top: 158px; opacity: 1; z-index: 999; width: 150px; height: 50px;">'+
//			    '<input type="checkbox"  id="buildarea"name="建筑面积"/>建筑面积<input type="checkbox" id="buildnum" name="建筑数量"/>建筑数量<br>'+
//	            '<input type="button" value="确定" onclick="javascript:regionTheme()"/>'+
//	            '</div>'
//	            $("#westmenu").append(html);
				regionTheme();
			}
		}
		if(treeNode.id==422){
			FMapLib.RegionThemePie();
		}
//		if(treeNode.id==43){
//			FMapLib.RegionThemePieSU();
//		}
		if(treeNode.id==43){
			var doc=document.getElementById("extentthemeconditions");
			if(doc!=null){
				$("#extentthemeconditions").remove();
			}
			else{
			var htmlstr='<div id="extentthemeconditions" class="blk" style="position: absolute; float: left; left: 25px; top: 166px; opacity: 1; z-index: 999; width: 150px; height: 50px;">'+
			'<select id="regionthemeFiled">'+
		    '<option value="0">建筑面积</option>'+
		    '<option value="1">建成年代</option>'+
		    '<option value="2">房屋结构</option>'+
		    '</select>'+
		    '<select id="regionthemeType">'+
	        '<option value="0">饼状图</option>'+
	        '<option value="1">柱状图</option>'+
	        '</select><br>'+
	        '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="button" style="width:55px;height:23px;background:url(/gis/resource/images/anniu.png) no-repeat; border:none; color:white;" value="确定" onclick="javascript:extenttheme()"/>'+
			'</div>';
			$("#westmenu").append(htmlstr);
		}
		}
		if(treeNode.id==44){
			var doc=document.getElementById("dropthemeconditions");
			if(doc!=null){
				$("#dropthemeconditions").remove();
			}
			else{
			var htmlstr='<div id="dropthemeconditions" class="blk" style="position: absolute; float: left; left: 25px; top: 194px; opacity: 1; z-index: 999; width: 150px; height: 50px;">'+
			'<select id="regionthemeFiled">'+
		    '<option value="0">建筑面积</option>'+
		    '<option value="1">建成年代</option>'+
		    '<option value="2">房屋结构</option>'+
		    '</select>'+
		    '<select id="regionthemeType">'+
	        '<option value="0">饼状图</option>'+
	        '<option value="1">柱状图</option>'+
	        '</select><br>'+
	        '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="button" style="width:55px;height:23px;background:url(/gis/resource/images/anniu.png) no-repeat; border:none; color:white;" value="确定" onclick="javascript:droptheme()"/>'+
			'</div>';
			$("#westmenu").append(htmlstr);
		}
		}
		if(treeNode.id==11 && treeNode.tId=="APIManager_4"){
			window.open("realtygis.apihelp");
		}
//			else{
//				$("#tuli").css('display','none');
//			}
	}
	//function beforeMouseDown(treeId, treeNode){
		//if(treeNode.id==4){
			//alert("ok");
//			if (curExpandNode ){
//				var doc=document.getElementById("themeconditions");
//				if(doc!=null){
//					$("#themeconditions").remove();
//			}
//			}
//			if(curExpandNode && curExpandNode.id==43 && newNode.id!=43){
//				var doc=document.getElementById("extentthemeconditions");
//				if(doc!=null){
//					$("#extentthemeconditions").remove();
//			}
//			}
//			if(curExpandNode && curExpandNode.id==44 && newNode.id!=44){
//				var doc=document.getElementById("dropthemeconditions");
//				if(doc!=null){
//					$("#dropthemeconditions").remove();
//			}
//			}
	/**
	 * 实现展开单一路径
	 * 李洪云 2013 12 18
	 */
	var curExpandNode = null;
	function beforeExpand(treeId, treeNode) {
		var pNode = curExpandNode ? curExpandNode.getParentNode():null;
		var treeNodeP = treeNode.parentTId ? treeNode.getParentNode():null;
		var zTree = $.fn.zTree.getZTreeObj(curMenu);
		for(var i=0, l=!treeNodeP ? 0:treeNodeP.children.length; i<l; i++ ) {
			if (treeNode !== treeNodeP.children[i]) {
				zTree.expandNode(treeNodeP.children[i], false);
			}
		}
		while (pNode) {
			if (pNode === treeNode) {
				break;
			}
			pNode = pNode.getParentNode();
		}
		if (!pNode) {
			singlePath(treeNode);
		}

	}
	function singlePath(newNode) {
		if (curExpandNode && curExpandNode.id==41 && newNode.id!=41){
			var doc=document.getElementById("themeconditions");
			if(doc!=null){
				$("#themeconditions").remove();
		}
		}
		if(curExpandNode && curExpandNode.id==43 && newNode.id!=43){
			var doc=document.getElementById("extentthemeconditions");
			if(doc!=null){
				$("#extentthemeconditions").remove();
		}
		}
		if(curExpandNode && curExpandNode.id==44 && newNode.id!=44){
			var doc=document.getElementById("dropthemeconditions");
			if(doc!=null){
				$("#dropthemeconditions").remove();
		}
		}
		if (newNode === curExpandNode) return;
		if (curExpandNode && curExpandNode.open==true) {
			var zTree = $.fn.zTree.getZTreeObj(curMenu);
			if (newNode.parentTId === curExpandNode.parentTId) {
				zTree.expandNode(curExpandNode, false);
			} else {
				var newParents = [];
				while (newNode) {
					newNode = newNode.getParentNode();
					if (newNode === curExpandNode) {
						newParents = null;
						break;
					} else if (newNode) {
						newParents.push(newNode);
					}
				}
				if (newParents!=null) {
					var oldNode = curExpandNode;
					var oldParents = [];
					while (oldNode) {
						oldNode = oldNode.getParentNode();
						if (oldNode) {
							oldParents.push(oldNode);
						}
					}
					if (newParents.length>0) {
						zTree.expandNode(oldParents[Math.abs(oldParents.length-newParents.length)-1], false);
					} else {
						zTree.expandNode(oldParents[oldParents.length-1], false);
					}
				}
			}
		}
		curExpandNode = newNode;
	}

	function onExpand(event, treeId, treeNode) {
		curExpandNode = treeNode;
	}
	function showIconForTree(treeId, treeNode) {
		return treeNode.level != 2;
	};
	var TreeDemo=FMapLib.TreeDemo=function(ul){
		curMenu=ul;
		var doc=document.getElementById("themeconditions");
		if(doc!=null){
			$("#themeconditions").remove();
		}
		 doc=document.getElementById("extentthemeconditions");
		if(doc!=null){
			$("#extentthemeconditions").remove();
		}
		 doc=document.getElementById("dropthemeconditions");
		if(doc!=null){
			$("#dropthemeconditions").remove();
		}
		if(ul=="homePage")
		    $.fn.zTree.init($("#"+curMenu), setting, zNodes_homePage);	
		if(ul=="analysis")
			//new FMapLib.TemeRangeTA("HOUSE_STAT");
		    $.fn.zTree.init($("#"+curMenu), setting, zNodes_analysis);
		if(ul=="magicTheme")
		    $.fn.zTree.init($("#"+curMenu), setting, zNodes_magicTheme);
		if(ul=="layersManager")
     	    $.fn.zTree.init($("#"+curMenu), setting, zNodes_layersManager);	
		if(ul=="APIManager")
	     	$.fn.zTree.init($("#"+curMenu), setting, zNodes_APIManager);	
		if(ul=="usersManager")
	     	$.fn.zTree.init($("#"+curMenu), setting, zNodes_usersManager);
		if(ul=="dataManager")
	     	$.fn.zTree.init($("#"+curMenu), setting, zNodes_dataManager);	
		}
})();