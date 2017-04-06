<link href="${_share_file_url!''}/resource/js/frame/frame.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.opendialog.js"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript">
 var fea="${map.fea!''}";
 $(document).ready(function(){
	//柱状图展示
	//var loadurl="realtygis.houseareatj?building_mapid="+fea;
	//$("#pic_div").load(loadurl);
	//表格数据展示
	//,'阳台面积','使用面积','预测面积','建成时间','户式类型','所属层数','备注'
	//,{name:'yt_area',index:'yt_area',align:'center',width:"70",sortable:true},
	//{name:'sy_area',index:'sy_area',align:'center',width:"70",sortable:true},
	//{name:'yc_area',index:'yc_area',align:'center',width:"70",sortable:true},
	//{name:'birth_date',index:'birth_date',align:'center',width:"70",sortable:true},
	//{name:'door_type',index:'door_type',align:'center',width:"70",sortable:true},
	//{name:'lay_num',index:'lay_num',align:'center',width:"70",sortable:true},
	//{name:'备注',index:'备注',align:'center',width:"70"}
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/realtygis.housequerygridjson?fea='+fea,
		datatype: "json",
		width:500,
		height:357,
	   	colNames:['房屋内码','房屋坐落', '建筑面积','分摊面积'],
	   	colModel:[
	   		{name:'house_id',index:'house_id',align:'center',width:"70",sortable:true},
	   		{name:'fw_address',index:'fw_address',align:'left' ,width:"260",sortable:true},
	   		{name:'jz_area',index:'jz_area',align:'center',width:"70",sortable:true},
	   		{name:'ft_area',index:'ft_area',align:'center',width:"70",sortable:true}
	   	],
	   	rowNum:10,
	   	shrinkToFit:false,
	   	autowidth: true, 
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 'house_id',
	    viewrecords: true,
	    sortorder: "asc", 
	    rownumbers:true,
	    caption:"框选楼栋内的户查询列表"
	    
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	
	/*jQuery("#gridReload").click(function() {
		//var surver_type = $("#surver_type").val();
		var small=$("#a").val();
		var middle=$("#b").val();
		var big=$("#c").val();
		alert(surver_type+"---"+small+"-----"+middle+"------"+big);
		var url="${_servlet_url!''}/realtygis.housequerygridjson?fea="+fea+"&surver_type="+surver_type+"&small="+small+"&middle="+middle+"&big="+big;
		alert("---url----"+url);
		var url2 = encodeURI(url);
		$("#clist1").jqGrid("setGridParam",{url:url2}).trigger("reloadGrid");
	});*/
	
		
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
		var cwinww=(ss.WinW-15)*0.5;
		$("#clist1").jqGrid('setGridWidth', cwinww);
	} 	
	function getPageSize() {
		var winW, winH;
		if(window.innerHeight) {// all except IE
			winW = window.innerWidth;
			winH = window.innerHeight;
		} else if (document.documentElement && document.documentElement.clientHeight) {// IE 6 Strict Mode
			winW = document.documentElement.clientWidth;
			winH = document.documentElement.clientHeight;
		} else if (document.body) { // other
			winW = document.body.clientWidth;
			winH = document.body.clientHeight;
		}  // for small pages with total size less then the viewport 
			return {WinW:winW, WinH:winH};
	}
	
});

function gridReload(){
	//var surver_type = $("#surver_type").val();
	var small=0;
	var middle=0;
	var big=0;
	if ($("#a").prop("checked")) { 
		small =1; 
	} 
	if ($("#b").prop("checked")) { 
		middle =1; 
	} 
	if ($("#c").prop("checked")) { 
		big =1; 
	} 
	
	//alert(surver_type+"---"+small+"-----"+middle+"------"+big);
	var url="${_servlet_url!''}/realtygis.housequerygridjson?fea="+fea+"&small="+small+"&middle="+middle+"&big="+big;
	//jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI(url),page:1}).trigger("reloadGrid");
	var url2 = encodeURI(url);
	//alert(jQuery("#clist1"));
	jQuery("#clist1").jqGrid('setGridParam',{url:url2}).trigger('reloadGrid');
	
	var pic_url="realtygis.houseareatj?building_mapid="+fea+"&small="+small+"&middle="+middle+"&big="+big;
	$("#pic_iframe").attr("src",pic_url);
	
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
<table class="frame_main" style="margin-top:10px;">
	<tr>
		<td width="50%">
			<table  width="100%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#a4cff2" style="line-height:25px;">
		  	  <tr>
			  	  <td align="right" class="td12">建筑面积:</td>
		          <td align="left" class="td13">
		          <input type="checkbox" id="a"  checked style="cursor:pointer;"/>小于90平方米
		          <input type="checkbox" id="b"  checked style="cursor:pointer;"/>90至144平方米
		          <input type="checkbox" id="c" checked style="cursor:pointer;"/>144平方米以上
		          </td>
		          <!--<td align="right" class="td12">测绘类型:</td>
		          <td align="left" class="td13">
			         <select id="surver_type" value=$("select option:selected").val()>
			                <option value="" selected >全部</option>
			                [#if EnumService.getEnum('chlx')?exists]
			                    [#list EnumService.getEnum('chlx') as enum]
			                       <option value="${enum.enum_value!''}" >${enum.enum_name!''}</option>
			                    [/#list]
			                 [/#if]
					 </select>
				  </td>-->
				  <td align="center" class="td13"><input  type="button" id="gridReload" value="查询" onclick="gridReload();" />  </td>
	          </tr>
			</table>
		<div style="margin-top:5px;">  
		        <div id="pager1"></div>
		        <table id="clist1" ></table>	
        	</div></td>
		<td width="50%">
		   	<iframe id="pic_iframe" src="realtygis.houseareatj?building_mapid=${map.fea!''}&small=1&middle=1&big=1" style="width:100%;min-height:475px;" frameborder="0"></iframe>
		</td>
	</tr>	
</table>