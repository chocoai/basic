 <link rel="stylesheet" type="text/css" href="${_share_file_url!''}/gis/resource/css/all.css">
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.opendialog.js"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<style>
.middle{
	width:1000px;
	background-color:#fff;
	margin:0 auto;
	overflow:auto;
	padding-top:15px;
	margin-bottom:15px;
	}
.fcqd_image{
	padding:20px 0 30px 0;
	text-align:center;
	}
.fcqd_searcht{
	margin:0 auto;
	width:883px;
	margin-bottom:30px;}
.fcqd_search{
	margin:0 auto;
	width:883px;
	height:110px;
	background:url(${_share_file_url!''}/gis/resource/images/search_bj.png) no-repeat;
	margin-bottom:30px;}
.fcqd_top{
	margin:0 auto;
	width:917px;
	height:135px;
	background:url(${_share_file_url!''}/gis/resource/images/zytop.jpg) no-repeat;
	}
.fcqd_search_content{
	float:left;
	padding-left:65px;
	padding-top:35px;}
.search_content_input{
	width:640px;
	height:40px;
	line-height:40px;
	font-family:"微软雅黑";
	font-size:14px;
	color:#4d4d4d;
	padding-left:15px;
	background:url(${_share_file_url!''}/gis/resource/images/search_input.jpg) no-repeat;
	border:none;
	}
.search_content_button{
	width:128px;
	height:40px;
	background:url(${_share_file_url!''}/gis/resource/images/qdsearch_button.jpg) no-repeat;
	border:none;
	cursor: pointer;}
.fcqd_search_content1{
	float:left;
	padding-left:20px;
	padding-top:35px;}
</style>
<script type="text/javascript">
 $(function(){

	jQuery("#clist1").jqGrid({
	   	url:'',
		datatype: "json",
		width:500,
		height:230,
	   	colNames:['楼幢编号','所在楼盘内码', '地址','楼幢号','建成时间','楼层数'],
	   	colModel:[
	   		{name:'building_id',index:'building_id',align:'center'},
	   		{name:'building_mapid',index:'building_mapid',align:'center'},
	   		{name:'building_address',index:'building_address', width:100},
	   		{name:'building_number',index:'building_number',align:'center'},
	   		{name:'building_date',index:'building_date',align:'center'},
	   		{name:'floor_count',index:'floor_count',align:'center'},
	   	//	{name:'identy',index:'identy',align:'center'}
	   	//	{name:'houselist',index:'houselist',align:'center'},
	   	//	{name:'layerhouseholdfigure',index:'layerhouseholdfigure',align:'center'}
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
	    onSelectRow:function(rowid){
          var b_ids = jQuery("#clist1").getCell(rowid,'building_id');
              if (b_ids != ""&&b_ids!="-1"){ 
            window.open("${_server_url!''}/portal/realtygis.tabdialog?building_id="
						        + b_ids,"_blank","depended=yes,width=900,height=500,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes");
              } else{
              alert("缺少地理位置标识！");
               }        
   }
	        
	});
	//自适应窗口边框
	//var t=document.documentElement.clientWidth; 
	//window.onresize = function(){ 
	//	if(t != document.documentElement.clientWidth){
	//		t = document.documentElement.clientWidth;
	//		doResize();
	//	}
	//}
	//function doResize() {
	//	var ss = getPageSize();
	//	$("#clist1").jqGrid('setGridWidth', ss.WinW-15);
	//} 	
	
});
function gridReload(){
   //显示结果列表
    $("#searchresult").css({'display':'block'});
	var building_address = $("#inputAddress").val();
	jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI('${_server_url!''}/portal/realtygis.simplebuildingqueryjson?entrust_unit=&building_address='+building_address+'&graphics_code=&use_desgin=&real_type=&building_datestart=&building_dateend=&build_struct='),page:1}).trigger("reloadGrid");
}

 </script>
 
<div class="middle">
	<div class="fcqd_top"></div>
    <div class="fcqd_search">
    	<div >
        	<div class="fcqd_search_content"><input type="text" name="keyword" id="inputAddress" class="search_content_input" value=""/>
            </div>
            <div class="fcqd_search_content1"><input type="submit" name="button" id="searchbyaddress" class="search_content_button" onclick="javascirpt:gridReload()" value="" />
            </div>
        </div>
     
    </div>
</div> 

  <div style="padding:5px;display:none;" id="searchresult"  class="middle fcqd_searcht">
	<div id="pager1" ></div>
	<table id="clist1"></table>	
</div>