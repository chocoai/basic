<link rel="stylesheet" type="text/css" href="${_share_file_url!''}/gis/resource/css/all.css">
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.opendialog.js"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/gis/resource/jquery/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/gis/resource/jquery/js/jquery.validate.message_zh.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<style>
.ui-widget-header td{border-bottom:1px solid gray}
.ui-dialog-titlebar-btn { width: 19px; padding: 1px; height: 18px; }
.td11{text-align:center;background-color:#DAEAFE;color:#2a51a4;}
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
.td14{padding-left:12px;background-color:#E1F1FE;color:#4D4D4D;}
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
<script type="text/javascript">
 $(document).ready(function(){
 $("#superForm").validate();
 $("#surver_enddatemin").attr("readonly", "true").datepicker({changeMonth: true,changeYear: true,dateFormat:"yy-mm-dd"});
 $("#surver_enddatemax").attr("readonly", "true").datepicker({changeMonth: true,changeYear: true,dateFormat:"yy-mm-dd"});
 $( "input:submit,input:button,input:reset" ).button();
 var b_addr="";
	jQuery("#clist1").jqGrid({
	   	url:'',
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
             //  FMapLib.MapIdenty(b_ids);
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
	FMapLib.ClearAllFeatures();
	var building_datestart = $("#building_datestart").val();
	var building_dateend = $("#building_dateend").val();
	var use_desgin = $("#use_desgin").val();
	var real_type = $("#real_type").val();
	var tn_areamin = $("#tn_areamin").val();
	var tn_areamax = $("#tn_areamax").val();
	var ft_areamin = $("#ft_areamin").val();
	var ft_areamax = $("#ft_areamax").val();
	var build_areamin = $("#build_areamin").val();
	var build_areamax = $("#build_areamax").val();
	var build_struct = $("#build_struct").val();
	var building_address = $("#building_address").val();
	var floor_countmin = $("#floor_countmin").val();
	var floor_countmax = $("#floor_countmax").val();
	var entrust_unit = $("#entrust_unit").val();
	var surver_type = $("#surver_type").val();
	var surver_enddatemin = $("#surver_enddatemin").val();
	var surver_enddatemax = $("#surver_enddatemax").val();
	var graphics_code = $("#graphics_code").val();
	var city_district = $("#city_district").val();
	//查询一页列表数据
	jQuery("#clist1").jqGrid(
		'setGridParam',
		{
			url:encodeURI('${_servlet_url!''}/realtygis.buildingmultiqueryjson?building_datestart='+building_datestart+'&building_dateend='+building_dateend+'&use_desgin='+use_desgin+'&real_type='+real_type+'&tn_areamin='+tn_areamin+'&tn_areamax='+tn_areamax+'&ft_areamin='+ft_areamin+'&ft_areamax='+ft_areamax+'&build_areamin='+build_areamin+'&build_areamax='+build_areamax+'&build_struct='+build_struct+'&building_address='+building_address+'&floor_countmin='+floor_countmin+'&floor_countmax='+floor_countmax+'&entrust_unit='+entrust_unit+'&surver_type='+surver_type+'&surver_enddatemin='+surver_enddatemin+'&surver_enddatemax='+surver_enddatemax+'&graphics_code='+graphics_code+'&city_district='+city_district),
			page:1
		}).trigger("reloadGrid");
	//查询所有数据，在地图上渲染图标
	$.ajax({ 
	          type : "post", 
	          url : encodeURI('${_servlet_url!''}/realtygis.simplebuildingqueryjsonforall'),
	          data : {building_datestart : building_datestart, building_dateend : building_dateend,use_desgin : use_desgin,
	          		  real_type : real_type,tn_areamin : tn_areamin,tn_areamax : tn_areamax,ft_areamin : ft_areamin,
	          		  ft_areamax : ft_areamax,build_areamin : build_areamin,build_areamax : build_areamax,build_struct : build_struct,
	          		  building_address : building_address,floor_countmin : floor_countmin,floor_countmax : floor_countmax,
	          		  entrust_unit : entrust_unit,surver_type : surver_type,surver_enddatemin : surver_enddatemin,
	          		  surver_enddatemax : surver_enddatemax,graphics_code : graphics_code,city_district : city_district
	          		 } ,
	          ataType: "json",
	          async : true, 
	          success : function(data)
	          { 
	      		var jdata = jQuery.parseJSON(data);
				var len = jdata.root.length;
				var building_mapid = [];
				for (i = 0; i < len; i++) 
				{
					if (jdata.root[i].building_mapid!=null&&jdata.root[i].building_mapid!=-1&&jdata.root[i].building_mapid!=0) 
					{
						//暂定渲染500条数据图标
						if(i<500)
							building_mapid[i]=jdata.root[i].building_mapid;	
						else
							break;
					}
				}
				if(building_mapid.length && building_mapid.length>0)
				{
		     		FMapLib.MarkerAllShow(building_mapid);
				}
	    	}
	 });

}
  //列表模式浏览
	function showBigFr(){
	$('#zhcx').show();
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
	  $('#zhcx').hide();
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
		//获取当前页building_mapid地图marker展示
	function testJqfrid(){
	 
	var  building_mapid="";
    var obj = $("#clist1").jqGrid("getRowData");
  //  alert(obj.length);
    jQuery(obj).each(function(){
        //alert(this.building_mapid);
        if(this.building_mapid!="-1"){
        building_mapid=building_mapid+this.building_mapid+",";
        }
    });
  //  alert(building_mapid);
    if(building_mapid==""){
			alert("暂无数据！");
		}
		else{
    FMapLib.MarkerShow(building_mapid);
    showSmallFr(); 
    }
   // var ret = $("#clist1").jqGrid("getRowData", 0);   //获得第一行的数据
}
 </script>
 <div style="padding:5px">
 <div id="zhcx" >
<form id="superForm" action="realtygis.buildingmultiquery" method="get">
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#a4cff2" style="line-height:25px;">
  
  <tr>
    <td align="right" class="td12">建成时间:</td>
    <td align="left" class="td13"><input type="text"  size="13" id="building_datestart" value="" class="number" onClick="WdatePicker({dateFmt:'yyyy'})"/>至<input type="text" size="13" id="building_dateend" value="" class="number" onClick="WdatePicker({dateFmt:'yyyy'})"/></td>
    <td align="right" class="td12">设计用途:</td>
    <td align="left" class="td13"><select id="use_desgin" value=$("select option:selected").val()>
			                                                                            <option value="" selected >全部</option>
                                                                                         [#if EnumService.getEnum('sjyt')?exists]
    
				                                                                            [#list EnumService.getEnum('sjyt') as enum]
			                                                                                   <option value="${enum.enum_value!''}" >${enum.enum_name!''}</option>
				                                                                            [/#list]
				                                                                         [/#if]	                                                                        
				    </select></td>
    <td align="right" class="td12">房屋产别:</td>
    <td align="left" class="td13"><select id="real_type" value=$("select option:selected").val()>
                                                                                      <option value="" selected >全部</option>
                                                                                         [#if EnumService.getEnum('fwcb')?exists]
    
				                                                                            [#list EnumService.getEnum('fwcb') as enum]
			                                                                                   <option value="${enum.enum_value!''}" >${enum.enum_name!''}</option>
				                                                                            [/#list]
				                                                                         [/#if]
				    </select></td>      
  </tr>
  <tr>
   <td align="right" class="td12">总套内建筑面积:</td>
    <td align="left" class="td13"><input type="text"  size="13" id="tn_areamin" value="" class="number" />至<input type="text" size="13"  id="tn_areamax" value=""  class="number"/>平方米</td>
    <td align="right" class="td12">总分摊共用面积:</td>
    <td align="left" class="td13"><input type="text"  size="13" id="ft_areamin" value=""class="number" />至<input type="text"  size="13" id="ft_areamax" value="" class="number"/>平方米</td>
    <td align="right" class="td12">总建筑面积:</td>
    <td align="left" class="td13"><input type="text"  size="13" id="build_areamin" value="" class="number" />至<input type="text"  size="13" id="build_areamax" value="" class="number" />平方米</td>
  </tr>
  <tr>
    <td align="right" class="td12">结构:</td>
    <td align="left" class="td13"><select id="build_struct" value=$("select option:selected").val()>
                                                                                          <option value="" selected >全部</option>
                                                                                          [#if EnumService.getEnum('fwjg')?exists]
				                                                                            [#list EnumService.getEnum('fwjg') as enum]
			                                                                                   <option value="${enum.enum_value!''}" >${enum.enum_name!''}</option>
				                                                                            [/#list]
				                                                                         [/#if]
				    </select></td>
    <td align="right" class="td12">幢坐落:</td>
    <td align="left" class="td13"><input type="text"  id="building_address" value="" /></td>
    <td align="right" class="td12">层数:</td>
    <td align="left" class="td13"><input type="text"  size="13" id="floor_countmin" value="" class="number" />至<input type="text"  size="13" id="floor_countmax" value="" class="number" /></td>
  </tr>
  <tr>
    <td align="right" class="td12">委托单位:</td>
    <td align="left" class="td13"><input type="text"  id="entrust_unit" value=""  /></td>
    <td align="right" class="td12">测绘类型:</td>
    <td align="left" class="td13"><select id="surver_type" value=$("select option:selected").val()>
                                                                                        <option value="" selected >全部</option>
                                                                                        [#if EnumService.getEnum('chlx')?exists]
				                                                                            [#list EnumService.getEnum('chlx') as enum]
			                                                                                   <option value="${enum.enum_value!''}" >${enum.enum_name!''}</option>
				                                                                            [/#list]
				                                                                         [/#if]
				    </select></td>
    <td align="right" class="td12">测绘结束日期:</td>
    <td align="left" class="td13"><input type="text"  size="13" id="surver_enddatemin" value=""  />至<input type="text" size="13"  id="surver_enddatemax" value=""  /></td>
  </tr>
  <tr>
    <td align="right" class="td12">楼幢编号:</td>
    <td align="left" class="td13"><input type="text" size="13"  id="graphics_code" value="" class="number" /></td>
    <td align="right" class="td12">行政区划:</td>
    <td align="left" class="td13"><select id="city_district" value=$("select option:selected").val()>
                                                                                           <option value="" selected >全部</option>
                                                                                           [#if EnumService.getEnum('xzqh')?exists]
				                                                                            [#list EnumService.getEnum('xzqh') as enum]
			                                                                                   <option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
				                                                                            [/#list]
				                                                                         [/#if]
				    </select></td> 
    <td align="right" class="td12"></td>
    <td align="left" class="td13"></td>
  </tr>
  </table>
  <p align="center">  <input  type="button" onclick="gridReload();" value="查询" /> <input   type='reset' value="重置" />    </p>
</form>
</div>
	

	
	
	<div id="pager1"></div>
		 <p  width="100" align="right" style="bottom:400px;display:block;"> 
  <!--<input type="button" align="right" id="showMap" value="地图专题"  onclick="javascript:testJqfrid()" style="cursor: pointer; right:5px;"/>-->
    <!-- <input type="button" align="right" id="showTheme" value="分析报告"  onclick="javascript:tshow()" style="cursor: pointer; right:5px;"/>  -->
    <input type="button" align="right" id="bigScreen" value="列表模式"  onclick="javascript:showBigFr()" style="cursor: hand; right:5px;display:none"/>
    <input type="button" align="right" id="smallScreen" value="首页模式"  onclick="javascript:showSmallFr()" style="cursor: hand; right:5px;"/> 
     </p>   
	<table id="clist1" ></table>	
</div>

