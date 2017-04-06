<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" language="javascript">
$(function(){	
	//表格
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/safemanage.tBuildingUnitlistdata?review_state_select=1',
		datatype: "json",
		width:600,
		height:300,
	   	colNames:[
				"organ_id"
			,"安全管理单位名称"
			,"安全管理单位类型"
			,"所属区域"
			,"负责人"
			,"负责人电话"
			,"审核状态"
			,"审核状态"			
			,"备注"
			
	   	],
	   	colModel:[
				{name:'organ_id',index:'organ_id',sortable:true,hidden:true}
			,{name:'organ_name',index:'organ_name',sortable:true,width:20}
			,{name:'com_type',index:'com_type',sortable:true,width:10}
			,{name:'organ_region',index:'organ_linkman',sortable:true,width:10}
			,{name:'organ_linkman',index:'link_man',hidden:true}
			,{name:'organ_phone',index:'organ_phone',hidden:true}
			,{name:'authentication_state',index:'authentication_state',hidden:true}
			,{name:'authentication_state1',index:'authentication_state',sortable:true,width:10}			
			,{name:'organ_desc',index:'organ_desc',sortable:true,width:10}
		],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 'organ_id',
	    viewrecords: true,
	    sortorder: "asc",
	    rownumbers:true,
	    caption:"安全管理单位表列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	$("#selectInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
		 	var unit_id=ret.organ_id;
		    var unit_name=ret.organ_name;
		 	var str = new Array(); 
		    str[0]=unit_id;
		    str[1]=unit_name;
		 	//IE判断
			if (window.showModalDialog!=null){
				parent.window.returnValue=str;
				window.close();//firefox不支持			
			}else{
				window.opener.returnAction(str);
				top.close();//IE和FireFox都支持
			}
		}else{
			alert("请选择一条记录！");
		}
	});	
	//模糊查询
	jQuery("#gridReload").click(function() {
		var url="${_servlet_url!''}/safemanage.tBuildingUnitlistdata?review_state_select=1"						
		var queryString=$("#dic_form").formSerialize();
		var url2 = url+"&"+queryString;
		jQuery("#clist1").jqGrid('setGridParam',{url:url2}).trigger("reloadGrid");
	});
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
	$("#clist1").jqGrid('setGridHeight', ss.WinH-180);
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

</script>
<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
<div class="skin_search ui-widget-content" style="padding:.2em;margin-bottom:8px;">
	<form name="dic_form" id="dic_form" action="" method="post">
		<input type="hidden" name="review_state_select" id="review_state_select" value="2">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" style="table-layout:fixed;line-height:30px;">
			<tr>
				<td class="td12">单位名称:</td>
				<td class="td13"><input type="text" size="10" name="unit_name_select" id="unit_name_select"/></td>
			<!--	<td class="td12">单位类型:</td>
				<td class="td13">
					<select name="unit_type_select" id="unit_type_select">
						<option value="">--请选择--</option>
						[#if EnumService.getEnum('safe_unit_type')?exists]
						[#list EnumService.getEnum('safe_unit_type') as enum]
						<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
						[/#list]
						[/#if]
					</select>
				</td>-->
				<td class="td12">所属区域:</td>
				<td class="td13">
					<select name="city_district_select" id="city_district_select">
						<option value="">--请选择--</option>
						[#if EnumService.getEnum('xzqh')?exists]
						[#list EnumService.getEnum('xzqh') as enum]
						<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
						[/#list]
						[/#if]
					</select>
				</td>
				<td class="td13"><button type="button" id="gridReload">查询</button></td>
			</tr>
		</table>
	</form>
</div>
<div  id="buttons" style="text-align:right;margin-bottom:8px;">
	<button type="button" id="selectInfo" align="right">确定</button>
	<button type="button" align="right" onclick="window.close();">取消</button>
</div>
<div id="pager1"></div>
<table id="clist1"></table>