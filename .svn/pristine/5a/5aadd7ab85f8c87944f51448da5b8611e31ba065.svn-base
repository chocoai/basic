<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/safecheck.usewarnlistjson',
		datatype: "json",
		width:600,
		height:300,
	   	colNames:[
			"building_id"
			,"楼幢新坐落"
			,"楼幢坐落"
			,"所属区域"
			,"建成时间"
			,"产权年限"
			,"房屋安全情况"
			,"超限情况"
	   	],
	   	colModel:[
			{name:'building_id',index:'building_id',sortable:true,hidden:true}
			,{name:'check_address',index:'check_address',sortable:true}
			,{name:'building_address',index:'building_address',sortable:true}
			,{name:'builiding_region',index:'builiding_region',sortable:true,width:30}
			,{name:'building_date',index:'building_date',sortable:true,width:30}
			,{name:'build_right',index:'build_right',sortable:true,width:30}
			,{name:'health_grade_pc',index:'health_grade_pc',sortable:true,width:40}
			,{name:'warn_grade',index:'warn_grade',sortable:true,width:70}
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 'warn_grade',
	    viewrecords: true,
	    sortorder: "desc",
	    rownumbers:true,
	    caption:"房屋使用超限情况列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	//模糊查询					
	jQuery("#gridReload").click(function() {
		var url="${_servlet_url!''}/safecheck.usewarnlistjson?"
		+"building_address="+$("#building_address").val()+"&"
		+"builiding_region="+$("#builiding_region").val()+"&"
		+"building_date="+$("#building_date").val()+"&"
		+"build_right="+$("#build_right").val()+"&"
		+"health_grade_pc="+$("#health_grade_pc").val()+"&"
		+"warn_grade="+$("#warn_grade").val();
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2,page:1}).trigger('reloadGrid');
	});
	doResize();
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
	$("#clist1").jqGrid('setGridWidth', ss.WinW-20);
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
//清空查询条件
function emptiedAndSubmit(){
	$("#building_address").val("");
	$("#builiding_region").val("");
	$("#building_date").val("");
	$("#build_right").val("");
	$("#health_grade_pc").val("");
	$("#warn_grade").val("");
    jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI("${_servlet_url!''}/safecheck.usewarnlistjson"),page:1}).trigger("reloadGrid");
}

</script>
<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
<div class="skin_search ui-widget-content" style="padding:.2em;margin-bottom:8px;">
<form name="dic_form" id="dic_form" action="" method="post">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<tr>
		<td class="td12">楼幢坐落:</td>
		<td class="td13" colspan="3">
		<input type="text" size="50" name="building_address" id="building_address"/>
		</td>
		<td class="td12">所属区域:</td>
		<td class="td13">
			<select id="builiding_region" name="builiding_region">
			<option value="">------请选择------</option>
			[#list EnumService.getEnum('xzqh') as enum]
			<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
			[/#list]
			</select>
		</td>
		<td class="td12">产权年限：</td>
		<td class="td13">
			<select name="build_right" id="build_right">
				<option value="">------请选择------</option>
				[#list EnumService.getEnum('build_right') as enum]
				<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
				[/#list]
			</select>
		</td>
		</tr>
		<tr>
		<td class="td12">建成时间:</td>
		<td class="td13">
		<input type="text" size="15" name="building_date" id="building_date" onClick="WdatePicker({dateFmt:'yyyy'})"/>
		</td>
		<td class="td12">房屋安全情况:</td>
		<td class="td13">
			<select name="health_grade_pc" id="health_grade_pc">
			<option value="">------请选择------</option>
			<option value="1">无危险点房屋</option>
			<option value="2">存在危险点房屋</option>
			<option value="3">局部危险房屋</option>
			<option value="4">整幢危险房屋</option>
			</select>
		</td>
		<td class="td12">超限情况:</td>
		<td class="td13">
			<select name="warn_grade" id="warn_grade">
				<option value="">------请选择------</option>
				<option value="1">临近超期</option>
				<option value="2">轻度超期</option>
				<option value="3">严重超期</option>
			</select>
		</td>
		<td class="td13" colspan="2"><button type="button" id="gridReload">查询</button><button onclick="emptiedAndSubmit()" style="margin-left:10px;">清空查询条件</button></td>
		</tr>
		</table>
	</form>
</div>
<!--<div  id="buttons" style="text-align:right;margin-bottom:8px;">
	<button type="button" id="updateInfo" align="right">修改</button>
	<button type="button" id="deleteInfo" align="right">删除</button>
</div>-->
<div id="pager1"></div>
<table id="clist1"></table>
