<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/safecheck.building.buildingmxjson',
		datatype: "json",
		width:600,
		height:300,
	   	colNames:[
			"building_id"
			,"检查新坐落"
			,"楼幢坐落"
			,"所属区域"
			,"房屋产别"
			,"设计用途"
			,"建成时间"
			,"房屋结构"
			,"房屋安全情况"
	   	],
	   	colModel:[
			{name:'building_id',index:'building_id',sortable:true,hidden:true}
			,{name:'check_address',index:'check_address',sortable:true}
			,{name:'building_address',index:'building_address',sortable:true}
			,{name:'builiding_region',index:'builiding_region',sortable:true,width:30}
			,{name:'real_type',index:'real_type',sortable:true,width:40}
			,{name:'use_desgin',index:'use_desgin',sortable:true,width:40}
			,{name:'building_date',index:'building_date',sortable:true,width:30}
			,{name:'build_struct',index:'build_struct',sortable:true,width:40}
			,{name:'health_grade_pc',index:'health_grade_pc',sortable:true,width:40}
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 'building_id',
	    viewrecords: true,
	    sortorder: "desc",
	    rownumbers:true,
	    caption:"明细列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	//模糊查询					
	jQuery("#gridReload").click(function() {
		var building_region=$('input[name="building_region"]:checked').val();
		var use_desgin=$('input[name="use_desgin"]:checked').val();
		var build_struct=$('input[name="build_struct"]:checked').val();
		var usefunction=$('input[name="usefunction"]:checked').val();
		var right_type=$('input[name="right_type"]:checked').val();
		var health_grade_pc=$('input[name="health_grade_pc"]:checked').val();
		var url="${_servlet_url!''}/safecheck.building.buildingmxjson?"
		+"building_region="+building_region+"&use_desgin="+use_desgin
		+"&build_struct="+build_struct+"&usefunction="+usefunction
		+"&right_type="+right_type+"&health_grade_pc="+health_grade_pc;
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2,page:1}).trigger('reloadGrid');
	});
	$("#excelInfo").click(function(){
		var building_region=$('input[name="building_region"]:checked').val();
		var use_desgin=$('input[name="use_desgin"]:checked').val();
		var build_struct=$('input[name="build_struct"]:checked').val();
		var usefunction=$('input[name="usefunction"]:checked').val();
		var right_type=$('input[name="right_type"]:checked').val();
		var health_grade_pc=$('input[name="health_grade_pc"]:checked').val();
			//var url="${_servlet_url!''}/safecheck.building.detaillist?"
		var url="${_servlet_url!''}/../exportexcel/safecheck.building.detaillist?"
		+"building_region="+building_region+"&use_desgin="+use_desgin
		+"&build_struct="+build_struct+"&usefunction="+usefunction
		+"&right_type="+right_type+"&health_grade_pc="+health_grade_pc;
		var url2 = encodeURI(url);
		window.location=url2;	
	});	
});
//清空查询条件
function emptiedAndSubmit(){
	$("#jinan").attr("checked",true);
	$("#health_grade_pc").attr("checked",true);
	$("#use_desgin").attr("checked",true);
	$("#build_struct").attr("checked",true);
	$("#usefunction").attr("checked",true);
	$("#right_type").attr("checked",true);
    jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI("${_servlet_url!''}/safecheck.building.buildingmxjson"),page:1}).trigger("reloadGrid");
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
			<td class="td12">所属区域:</td>
			<td class="td13">
				<input type="radio" id="jinan" name="building_region" value="" checked>济南市
			</td>
			<td class="td13">
				[#list EnumService.getEnum('xzqh') as enum]
					<input type="radio" id="${enum.enum_value!''}" name="building_region" value="${enum.enum_value!''}">${enum.enum_name!''}
				[/#list]
			</td>
		</tr>
		<tr>
			<td class="td12">设计用途:</td>
			<td class="td13">
				<input type="radio" id="use_desgin" name="use_desgin" value="" checked>全部
			</td>
			<td class="td13">
				[#list EnumService.getEnum('sjyt') as enum]
					<input type="radio" id="${enum.enum_value!''}" name="use_desgin" value="${enum.enum_value!''}">${enum.enum_name!''}
				[/#list]
			</td>
		</tr>
		<tr>
			<td class="td12">房屋结构:</td>
			<td class="td13">
				<input type="radio" id="build_struct" name="build_struct" value="" checked>全部
			</td>
			<td class="td13">
				[#list EnumService.getEnum('fwjg') as enum]
					<input type="radio" id="${enum.enum_value!''}" name="build_struct" value="${enum.enum_value!''}">${enum.enum_name!''}
				[/#list]
			</td>
		</tr>
		<tr>
			<td class="td12">使用功能:</td>
			<td class="td13">
				<input type="radio" id="usefunction" name="usefunction" value="" checked>全部
			</td>
			<td class="td13">
				[#list EnumService.getEnum('usefunction') as enum]
					<input type="radio" id="${enum.enum_value!''}" name="usefunction" value="${enum.enum_value!''}">${enum.enum_name!''}
				[/#list]
			</td>
		</tr>
		<tr>
			<td class="td12">产权性质:</td>
			<td class="td13">
				<input type="radio" id="right_type" name="right_type" value="" checked>全部
			</td>
			<td class="td13">
				[#list EnumService.getEnum('right_type') as enum]
					<input type="radio" id="${enum.enum_value!''}" name="right_type" value="${enum.enum_value!''}">${enum.enum_name!''}
				[/#list]
			</td>
		</tr>
		<tr>
			<td class="td12">房屋安全情况:</td>
			<td class="td13">
				<input type="radio" id="health_grade_pc" name="health_grade_pc" value="" checked>全部
			</td>	
			<td class="td13">
				<input type="radio" name="health_grade_pc" value="1">无危险点房屋
				<input type="radio" name="health_grade_pc" value="2">存在危险点房屋
				<input type="radio" name="health_grade_pc" value="3">局部危险房屋
				<input type="radio" name="health_grade_pc" value="4">整幢危险房屋
			</td>
		</tr>
		<tr>
			<td class="td13" colspan="3" align="right">
				<button type="button" id="gridReload" style="margin-left:20px;">查询</button>
				<button onclick="emptiedAndSubmit()" style="margin-left:10px;">清空查询条件</button></td>
			</td>
		</tr>
		</table>
	</form>
</div>
<div  id="buttons" style="text-align:right;margin-bottom:8px;">
	<button type="button" id="excelInfo" align="right">导出列表明细excel</button>
</div>
<div id="pager1"></div>
<table id="clist1"></table>
