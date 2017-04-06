<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.opendialog.js"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<style>
.ui-widget-header td{border-bottom:1px solid gray}
.ui-dialog-titlebar-btn { width: 19px; padding: 1px; height: 18px; }
</style>
<script type="text/javascript">
var min=${map.min!''};
var max=${map.max!''};
var buildingdate=${map.buildingdate!''};
var floormin=${map.floormin!''};
var floormax=${map.floormax!''};
var buildingdate2=${map.buildingdate2!''};
 $(function(){
 var b_addr="";
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/realtygis.buildinglistgridjson?min='+min+'&max='+max+'&building_address='+b_addr+'&buildingdate='+buildingdate+'&buildingdate2='+buildingdate2+'&floormin='+floormin+'&floormax='+floormax,
		datatype: "json",
		width:720,
		height:410,
	   	colNames:['幢号内码','所在楼盘内码', '地址','楼幢号','总户数','符合条件的户数','建成时间','楼层数','地图定位','楼盘表','分层分户图'],
	   	colModel:[
	   		{name:'building_id',index:'building_id',align:'center'},
	   		{name:'building_mapid',index:'building_mapid',align:'center'},
	   		{name:'building_address',index:'building_address', width:650},
	   		{name:'building_number',index:'building_number',align:'center'},
	   		{name:'houseCount',index:'houseCount',align:'center'},
	   		{name:'properCount',index:'properCount',align:'center'},
	   		{name:'building_date',index:'building_date',align:'center'},
	   		{name:'floor_count',index:'floor_count',align:'center'},
	   		{name:'identy',index:'identy',align:'center'},
	   		{name:'houselist',index:'houselist',align:'center'},
	   		{name:'layerhouseholdfigure',index:'layerhouseholdfigure',align:'center'}
	   	],
	   	rowNum:10,
	   	autowidth: true, 
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	 sortable:true,
	   	sortname: 'building_mapid',
	    viewrecords: true,
	    sortorder: "asc", 
	    rownumbers:true,
	    caption:"房屋查询列表",
	    onCellSelect:function(rowid,iCol,cellcontent){
	       var bid=jQuery("#clist1").getCell(rowid,'building_id');
	       if(iCol==11){
	                window.open('realtygis.LayeredHouseholdFigure?building_id='+bid,'_blank','depended=yes,width=900,height=500,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes');
	               }
	       if(iCol==6){
               window.open('realtygis.houseareagrid?id='+bid+'&min='+min+'&max='+max,'_blank','depended=yes,width=1000,height=500,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes');
	       }
	       else{
	           if(iCol==10){
	           if(bid!=""||bid!=null){
	              window.open('realtygis.housejson?building_id='+bid+'&method=houseQue','_blank','depended=yes,width=900,height=500,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes');
	             }
	           }
	            else{
	             if(iCol==9){
	              var b_ids = jQuery("#clist1").getCell(rowid,'building_mapid');
              if (b_ids != ""){ 
               //parent.document.getElementById("identy").innerHTML=b_ids; 
               FMapLib.MapIdenty(b_ids);
               showSmallFr(); 
              } else{
              alert("暂无数据！");
               }             
	             }
	            
	           }
	          
	       }
	    
	    }
	});
	//自适应窗口边框
	var t=document.documentElement.clientWidth; 
	window.onresize = function(){ 
		if(t != document.documentElement.clientWidth){
			t = document.documentElement.clientWidth;
			doResize();
		}
	}
	function doResize() {
		var ss = getPageSize();
		$("#clist1").jqGrid('setGridWidth', ss.WinW-15);
	} 	
	
});
function gridReload(){
	var building_address = $("#building_address").val();
	jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI('${_servlet_url!''}/realtygis.buildinglistgridjson?building_address='+building_address+'&min='+min+'&max='+max+'&buildingdate='+buildingdate+'&buildingdate2='+buildingdate2+'&floormin='+floormin+'&floormax='+floormax),page:1}).trigger("reloadGrid");
}
  //列表模式浏览
	function showBigFr(){
	 $('#bigScreen').hide();
	 $('#smallScreen').show();
	 if(parent.MAP_VISION){		 
	  parent.sizePane('south',700,"in");
	  parent.openPane('south',"in"); 	
	  }	
	}
	//首页模式浏览
	function showSmallFr(){
	 $('#bigScreen').show();
	 $('#smallScreen').hide();
	 if(parent.MAP_VISION){	 	
	  parent.sizePane('south',100,"in"); 	
	  parent.openPane('south',"in");
	  }	
	}  
//地图展示
	function mshow(){
	FMapLib.MapShow(min,max,floormin,floormax,buildingdate,buildingdate2);
	 showSmallFr();
	}
	//生成专题图
	function tshow(){
	//parent.document.getElementById("themeStatus").innerHTML=$("#showTheme").val();
	 FMapLib.HouseHoldsTheme(min, max);
     showSmallFr();  
	}	
 </script>
 <div style="padding:5px">
	<div class="skin_search ui-widget-content" style="padding:.2em;">	
		<form name="dic_form" id="dic_form" action="${_servlet_url!''}/realtygis.buildinglistgrid" method="post">
			<span>房屋地址名称：<input type="text" size="15" name="building_address" id="building_address"></span>
			<button type="button" onclick="gridReload();">查询</button>
		</form>
		 <span width="100" style="position:absolute;right:8px;top:8px;">
    <input type="button" align="right" id="showMap" value="地图专题"  onclick="javascript:mshow()" style="cursor: pointer; right:5px;"/>
    <input type="button" align="right" id="showTheme" value="分析报告"  onclick="javascript:tshow()" style="cursor: pointer; right:5px;"/>  
    <input type="button" align="right" id="bigScreen" value="列表模式"  onclick="javascript:showBigFr()" style="cursor: hand; right:5px;"/>
    <input type="button" align="right" id="smallScreen" value="首页模式"  onclick="javascript:showSmallFr()" style="cursor: hand; right:5px;display:none"/> 
    </span>  
    </span>  
	</div>
	<div id="pager1"></div>
	<table id="clist1" ></table>	
</div>

