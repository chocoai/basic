<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/safecheck.auth.authmxjson',
		datatype: "json",
		width:600,
		height:300,
	   	colNames:[
			"building_id"
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
			,{name:'building_address',index:'building_address',sortable:true}
			,{name:'builiding_region',index:'builiding_region',sortable:true,width:30}
			,{name:'real_type',index:'real_type',sortable:true,width:40}
			,{name:'use_desgin',index:'use_desgin',sortable:true,width:40}
			,{name:'building_date',index:'building_date',sortable:true,width:30}
			,{name:'build_struct',index:'build_struct',sortable:true,width:40}
			,{name:'health_grade_jd',index:'health_grade_jd',sortable:true,width:55}
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
		var health_grade_jd=$('input[name="health_grade_jd"]:checked').val();
		var url="${_servlet_url!''}/safecheck.auth.authmxjson?"
		+"building_region="+building_region+"&"
		+"health_grade_jd="+health_grade_jd;
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2,page:1}).trigger('reloadGrid');
	});
	$("#excelInfo").click(function(){
		var building_region=$('input[name="building_region"]:checked').val();
		var health_grade_jd=$('input[name="health_grade_jd"]:checked').val();
		var url="${_servlet_url!''}/../exportexcel/safecheck.auth.detaillist?"
		//var url="${_servlet_url!''}/safecheck.auth.detaillist?"
		+"building_region="+building_region+"&"
		+"health_grade_jd="+health_grade_jd;
		var url2 = encodeURI(url);
		window.location=url2;	
	});	
});
//清空查询条件
function emptiedAndSubmit(){
	$("#jinan").attr("checked",true);
	$("#health_grade_jd").attr("checked",true)
    jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI("${_servlet_url!''}/safecheck.auth.authmxjson"),page:1}).trigger("reloadGrid");
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
			<td class="td12">房屋安全情况:</td>
			<td class="td13">
				<input type="radio" id="health_grade_jd" name="health_grade_jd" value="" checked>全部
			</td>	
			<td class="td13">
				<input type="radio" name="health_grade_jd" value="1">A级
				<input type="radio" name="health_grade_jd" value="2">B级
				<input type="radio" name="health_grade_jd" value="3">C级
				<input type="radio" name="health_grade_jd" value="4">D级
			</td>
		</tr>
		<tr>
			<td class="td13" colspan="3" align="right">
			<button type="button" id="gridReload" style="margin-left:20px;">查询</button>
			<button onclick="emptiedAndSubmit()" style="margin-left:10px;">清空查询条件</button>
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
