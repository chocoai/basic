<link rel="stylesheet" type="text/css" href="${_share_file_url!''}/gis/resource/css/all.css">
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.opendialog.js"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<style>
.ui-widget-header td{border-bottom:1px solid gray}
.ui-dialog-titlebar-btn { width: 19px; padding: 1px; height: 18px; }
</style>
<script type="text/javascript">
 $(function(){
 var houseCount=0;
 var b_area=0;
   $.ajax({ 
	          type : "post", 
	          url : 'realtygis.bufferanalysiscount?fea=${map.fea!''}', 
	          data : "" , 
	          async : true, 
	          success : function(data){ 
	          
	      		var jdata = jQuery.parseJSON(data);
			
				var len = jdata.root.length;
				for (i = 0; i < len; i++) {
					
					houseCount=jdata.root[i].HOUSECOUNT;            
					b_area= jdata.root[i].B_AREA;
				}
					if(houseCount!=""){
			//	alert(houseCount+"!!!!"+b_area);
			$("#bufferareacount").val(b_area+"平方米");
			$("#bufferhousecount").val(houseCount+"户");
	          } 
	          
	          else{
	          $("#bufferareacount").val("无结果");
			$("#bufferhousecount").val("无结果");
	          }
	          }
	          }); 
 
 var b_addr="";
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/realtygis.buildingfrommapjson?fea=${map.fea!''}',
		datatype: "json",
		width:720,
		height:260,
	   	colNames:['幢号内码','所在楼盘内码', '地址','楼幢号','建成时间','楼层数','地图定位'],
	   	colModel:[
	   		{name:'building_id',index:'building_id',align:'center',sortable:true},
	   		{name:'building_mapid',index:'building_mapid',align:'center',sortable:true},
	   		{name:'building_address',index:'building_address', width:650,sortable:true},
	   		{name:'building_number',index:'building_number',align:'center',sortable:true},
	   		{name:'building_date',index:'building_date',align:'center',sortable:true},
	   		{name:'floor_count',index:'floor_count',align:'center',sortable:true},
	   		{name:'identy',index:'identy',align:'center'}
	   		//{name:'houselist',index:'houselist',align:'center'},
	   		//{name:'layerhouseholdfigure',index:'layerhouseholdfigure',align:'center'}
	   	],
	   	rowNum:10,
	   	autowidth: true, 
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 'building_mapid',
	    viewrecords: true,
	    sortorder: "asc", 
	    rownumbers:true,
	    caption:"房屋查询列表",
	    onCellSelect:function(rowid,iCol,cellcontent){
	       var bid=jQuery("#clist1").getCell(rowid,'building_id');
	       if(iCol==9){
           		window.open('realtygis.LayeredHouseholdFigure?building_id='+bid,'_blank','depended=yes,width=900,height=500,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes');
           }
	     
           if(iCol==8){
	           if(bid!=""||bid!=null){
	              window.open('realtygis.housejson?building_id='+bid+'&method=houseQue','_blank','depended=yes,width=900,height=500,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes');
	           }
           }
	            
           if(iCol==7){
              var b_ids = jQuery("#clist1").getCell(rowid,'building_mapid');
              if (b_ids != ""&&b_ids!="-1"){ 
               //parent.document.getElementById("identy").innerHTML=b_ids; 
               FMapLib.MarkerIdenty(b_ids);
               showSmallFr(); 
              } else{
              alert("暂无数据！");
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
	jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI('${_servlet_url!''}/realtygis.buildingfrommapjson?fea=${map.fea!''}'),page:1}).trigger("reloadGrid");
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
 <style>
.ui-widget-header td{border-bottom:1px solid gray}
.ui-dialog-titlebar-btn { width: 19px; padding: 1px; height: 18px; }
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
.table_content{
	font-size:12px;
	font-weight:no;
	padding-left:12px;
	color:#4d4d4d
}
.middle_right{
	font-family:"微软雅黑";
	font-size:12px;
	font-weight:bolder;
}
</style>
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#a4cff2" style="line-height:25px;">
	<tr><td width="100%">
			<table  width="100%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#a4cff2" style="line-height:25px;">
		  	  <tr>
			  	  <td align="right" class="td12"> 缓冲区总建筑面积统计：</td>
		          <td align="left" class="td13"><input  type="text" align="left" id="bufferareacount" value=""/></td>
		          <td align="right" class="td12">缓冲区总户数统计:</td>
		          <td align="left" class="td13"><input  type="text" align="left" id="bufferhousecount" value=""/></td>
				  <td align="center" class="td13">
				  	<input type="button" align="right" id="bigScreen" value="列表模式"  onclick="javascript:showBigFr()" style="cursor: hand; right:5px;"/>
    				<input type="button" align="right" id="smallScreen" value="首页模式"  onclick="javascript:showSmallFr()" style="cursor: hand; right:5px;display:none"/> 
				  </td>
	          </tr>
			</table>
		</td>
	</tr>
	<tr><td width="100%"><div style="margin-top:5px;">  
		        <div id="pager1"></div>
		        <table id="clist1" ></table>	
        	</div>
    </td></tr>	
</table>




  <!--<div style="padding:5px">
 <div id="pager1"></div>
  
		 <p  width="100" align="right" style="bottom:400px;display:block;"> 
		 缓冲区总建筑面积统计：<input  type="text" align="left" id="bufferareacount" value=""></input>缓冲区总户数统计:<input  type="text" align="left" id="bufferhousecount" value=""></input>-->
 <!--  <input type="button" align="right" id="showMap" value="地图专题"  onclick="javascript:mshow()" style="cursor: pointer; right:5px;"/>
    <input type="button" align="right" id="showTheme" value="分析报告"  onclick="javascript:tshow()" style="cursor: pointer; right:5px;"/>  -->
   <!-- <input type="button" align="right" id="bigScreen" value="列表模式"  onclick="javascript:showBigFr()" style="cursor: hand; right:5px;"/>
    <input type="button" align="right" id="smallScreen" value="首页模式"  onclick="javascript:showSmallFr()" style="cursor: hand; right:5px;display:none"/> 
     </p>   
	<table id="clist1" ></table>	
</div>-->

