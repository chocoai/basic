<script src="${map_url!''}/gis/FMapLib/FMapLib.Include-1.0.4.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/safemanage/resource/js/markershowbysearch.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
var map,toolBar;
var preFeature;
var markerLayer2;
$(function(){
	map = new FMapLib.FMap("map");	 
	// 初始化Marker图层
  	// markerLayer2 = new MapLib.Layer.Markers("MarkersLayer");
 	// map.map.addLayer(markerLayer2);
	//模糊查询					
	jQuery("#gridReload").click(function() {
		if(map)
	 		map.clearAllFeatures();
		//此处添加查询请求方法	XX();
		dosearch();
	});
	//显示查询对话框
	jQuery("#showStyle").click(function() {		
		jQuery("#map").css("display","none");
		jQuery("#searchStyle").css("display","block");
		jQuery("#showStyle").css("display","none");	
	});
});
//清空查询条件
function emptiedAndSubmit(){
	$("#building_address").val("");
	$("#manage_type").val("");
	$("#use_desgin").val("");
	$("#building_date").val("");
	$("#build_struct").val("");
	$("#building_properties").val("");
	$("#building_safecondition").val("");   
}
function dosearch(){
	var building_holder        = $("#building_holder").val();
	var building_address       = $("#building_address").val();
	var build_areamin          = $("#build_areamin").val();
	var build_areamax          = $("#build_areamax").val();
	var building_manager_name  = $("#building_manager_name").val();
	var build_dept             = $("#build_dept").val();
	var design_dept            = $("#design_dept").val();
	var construct_dept         = $("#construct_dept").val();
	var build_struct           = $("#build_struct").val();
	var upon_type              = $("#upon_type").val();
	var wm_type                = $("#wm_type").val();
	var building_properties    = $("#building_properties").val();
	var building_datestart     = $("#building_datestart").val();
	var building_dateend       = $("#building_dateend").val();
	var building_safecondition = $("#building_safecondition").val();
	
	var allbuilding_id = '';
	$.ajax({ 
          type : "post", 
          url :encodeURI("safecheck.buildingcommonquery?building_holder="+building_holder+"&building_address="+building_address+"&build_areamin="+build_areamin+"&build_areamax="+build_areamax+"&building_manager_name="+building_manager_name+"&build_dept="+build_dept+"&design_dept="+design_dept+"&construct_dept="+construct_dept+"&build_struct="+build_struct+"&upon_type="+upon_type+"&wm_type="+wm_type+"&building_properties="+building_properties+"&building_datestart="+building_datestart+"&building_dateend="+building_dateend+"&building_safecondition="+building_safecondition), 
          data : "" , 
          async : false, 
          success : function(data){ 
      		var jdata = jQuery.parseJSON(data);
			var len = jdata.root.length;
			for (i = 0; i < len; i++) {
				if (jdata.root[i].building_id!=null&&jdata.root[i].building_id!=-1) {
					allbuilding_id=allbuilding_id+jdata.root[i].building_id+',';            
				}
			}
	     markerShow(allbuilding_id);
	     if(allbuilding_id!=""){
	     	jQuery("#map").css("display","block");
			jQuery("#showStyle").css("display","block");
			jQuery("#searchStyle").css("display","none");
	     }
	    }
   }); 
}
</script>

<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
<div id="showStyle" name="返回查询" style="cursor:pointer;display:none"><button type="button">返回查询</button></div>
<div id="map" style="position:absolute;left:0px;right:0px;width:100%;height:100%;display:none"></div> 
<div id="searchStyle" class="skin_search ui-widget-content" style="padding:.2em;margin-bottom:8px;with:100%;z-index:1;position:relative">
<form name="dic_form" id="dic_form" action="" method="post">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<tr>
			<td class="td12">楼幢坐落：</td>
			<td class="td13" colspan="3">
			<input type="text" size="50" name="building_address" id="building_address"/>
			</td>
			<td class="td12">建筑面积：</td>
			<td class="td13"><input type="text" id="build_areamin" name="build_areamin"  size="8"> 至
		                 <input type="text" id="build_areamax" name="build_areamax"  size="8">平方米
			</td>
		</tr>
		<tr>
			<td class="td12">建设单位：</td>
			<td class="td13">
				<input type="text" id="build_dept" name="build_dept" size="18">
			</td>
			<td class="td12">设计单位：</td>
			<td class="td13">
				<input type="text" id="design_dept" name="design_dept" size="18">
			</td>
			<td class="td12">施工单位：</td>
			<td class="td13">
				<input type="text" id="construct_dept" name="construct_dept" size="18">
			</td>
		</tr>
		<tr>
			<td class="td12">房屋所有人（管理单位）：</td>
			<td class="td13"><input type="text" id="building_holder" name="building_holder" size="18"></td>
			<td class="td12">房屋管理人姓名：</td>
			<td class="td13"><input type="text" id="building_manager_name" name="building_manager_name" size="18"></td>
			<td class="td12">建成时间：</td>
			<td class="td13">
			<input type="text" size="8" name="building_datestart" id="building_datestart" onClick="WdatePicker({dateFmt:'yyyy'})"/> 至
			<input type="text" size="8" name="building_dateend" id="building_dateend" onClick="WdatePicker({dateFmt:'yyyy'})"/>
			</td>
		</tr>
		<tr>
			<td class="td12">结构类型：</td>
			<td class="td13">
				<select id="build_struct" name="build_struct">
				<option value="">------请选择------</option>
				[#if EnumService.getEnum('fwjg')?exists]
				[#list EnumService.getEnum('fwjg') as enum]
				<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
				[/#list]
				[/#if]
				</select>
			</td>
			<td class="td12">屋面类型：</td>
			<td class="td13">
				<select id="wm_type" name="wm_type">
					<option value="">------请选择------</option>
					[#list EnumService.getEnum('wm_type') as enum]
					<option value="${enum.enum_value!''}" >${enum.enum_name!''}</option>
					[/#list]
				</select>
			</td>
			<td class="td12">楼盖类型：</td>
			<td class="td13">
				<select id="upon_type" name="upon_type">
					<option value="">------请选择------</option>
					[#list EnumService.getEnum('upon_type') as enum]
					<option value="${enum.enum_value!''}" >${enum.enum_name!''}</option>
					[/#list]
				</select>
			</td>
		</tr>
		<tr>
			<td class="td12">房屋性质：</td>
			<td class="td13">
				<select name="building_properties" id="building_properties">
					<option value="">------请选择------</option>
					<option value="1">房改住房</option>
					<option value="2">省直管公房</option>
					<option value="3">市直管公房</option>
					<option value="4">企业自管</option>
					<option value="5">其他</option>
				</select>
			</td>
			<td class="td12">房屋安全情况：</td>
			<td class="td13">
				<select name="building_safecondition" id="building_safecondition">
					<option value="">------请选择------</option>
					<option value="1">无问题房屋</option>
					<option value="4">有问题房屋</option>
				</select>
			</td>
			<td class="td13" colspan="2"><button type="button" id="gridReload">查询</button><button onclick="emptiedAndSubmit()" style="margin-left:10px;">清空查询条件</button></td>
		</tr>
		</table>
	</form>
</div>


