<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/safecheck.bctrack.managelistjson',
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
			,"房屋与结构"
			,"健康等级"
			,"危楼类型"
			,"普查状态"
			,"info_id"
			
	   	],
	   	colModel:[
			{name:'building_id',index:'building_id',sortable:true,hidden:true}
			,{name:'building_address',index:'building_address',sortable:true}
			,{name:'builiding_region',index:'builiding_region',sortable:true,width:20}
			,{name:'real_type',index:'real_type',sortable:true,width:35}
			,{name:'use_desgin',index:'use_desgin',sortable:true,width:25}
			,{name:'building_date',index:'building_date',sortable:true,width:20}
			,{name:'build_struct',index:'build_struct',sortable:true,width:25}
			,{name:'health_grade_pc',index:'health_grade_pc',sortable:true,width:40}
			,{name:'dangerous_type_pc',index:'dangerous_type_pc',sortable:true,width:20}
			,{name:'info_state',index:'info_state',sortable:true,width:20}
			,{name:'info_id',index:'info_id',sortable:true,hidden:true}
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 'building_id',
	    viewrecords: true,
	    sortorder: "asc",
	    rownumbers:true,
	    caption:"楼幢检查列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	//模糊查询					
	jQuery("#gridReload").click(function() {
		var url="${_servlet_url!''}/safecheck.bctrack.managelistjson?"
		+"building_address="+$("#building_address").val()+"&"
		+"builiding_region="+$("#builiding_region").val()+"&"
		+"real_type="+$("#real_type").val()+"&"
		+"use_desgin="+$("#use_desgin").val()+"&"
		+"building_date="+$("#building_date").val()+"&"
		+"build_struct="+$("#build_struct").val()+"&"
		+"health_grade_pc="+$("#health_grade_pc").val()+"&"
		+"dangerous_type_pc="+$("#dangerous_type_pc").val();
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2,page:1}).trigger('reloadGrid');
	});
	//修改按钮
	$("#updateInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			var info_state=ret.info_state;
			if(info_state == '审核通过'){
				alert("审核通过无法修改！");
				return;
			}
			window.location="${_servlet_url!''}/safecheck.bctrack.forupdate?building_id="+ret.building_id+"&info_id="+ret.info_id;
		}else{
			alert("请选择一条记录！");
		}
	});
	//查看信息按钮
	$("#selectInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			window.location="${_servlet_url!''}/safecheck.bctrack.detail?building_id="+ret.building_id+"&info_id="+ret.info_id;
		}else{
			alert("请选择一条记录！");
		}
	});	
	//$("#deleteInfo").click(function(){
	//	var flag=window.confirm("删除不可恢复，确认删除吗？");
	//});
	//删除按钮
	$("#deleteInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) {
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			var info_state=ret.info_state;
			if(info_state == '审核通过'){
				alert("审核通过无法删除！");
				return;
			}
			//打开对话框
			$("#delete-dialog").dialog( "open" );
		}else{
			alert("请选择一条记录！");
		}
	});
	//删除弹出框
	$("#delete-dialog").dialog({
		autoOpen: false,
      	height: 200,
      	width: 470,
      	modal: true,
        buttons: {
        	'确定': function() {
        		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
				var ret = jQuery("#clist1").jqGrid('getRowData',id);
				$.post("${_servlet_url!''}/safecheck.bctrack.delete?info_id="+ret.info_id,"",function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="1"){
						jQuery("#clist1").trigger('reloadGrid');
						$("#delete-dialog").dialog("close");
						alert("删除成功!!");
					}else{
						jQuery("#clist1").trigger('reloadGrid');
						$("#delete-dialog").dialog("close");
						alert("删除失败!!");
					}
				});
			},
			'取消': function() {
				$(this).dialog("close");
			}
		}
	});
});
//清空查询条件
function emptiedAndSubmit(){
	$("#building_address").val("");
	$("#builiding_region").val("");
	$("#real_type").val("");
	$("#use_desgin").val("");
	$("#building_date").val("");
	$("#build_struct").val("");
	$("#health_grade_pc").val("");
	$("#dangerous_type_pc").val("");
    jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI("${_servlet_url!''}/safecheck.building.editlistdata"),page:1}).trigger("reloadGrid");
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
		<td class="td12">房屋产别:</td>
		<td class="td13">
			<select id="real_type" name="real_type">
			<option value="">------请选择------</option>
			[#list EnumService.getEnum('fwcb') as enum]
			<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
			[/#list]
			</select>
		</td>
		<td class="td12">设计用途:</td>
		<td class="td13">
			<select id="use_desgin" name="use_desgin">
			<option value="">------请选择------</option>
			[#list EnumService.getEnum('sjyt') as enum]
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
		<td class="td12">房屋与结构:</td>
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
		<td class="td12">健康等级:</td>
		<td class="td13">
			<select name="health_grade_pc" id="health_grade_pc">
			<option value="">------请选择------</option>
			<option value="1">A级</option>
			<option value="2">B级</option>
			<option value="3">C级</option>
			<option value="4">D级</option>
			</select>
		</td>
		<td class="td12">危房类型:</td>
		<td class="td13">
			<select name="dangerous_type_pc" id="dangerous_type_pc">
			<option value="">------请选择------</option>
			<option value="1">整栋危楼</option>
			<option value="2">局部危楼</option>
			</select>
		</td>
		<td class="td13" colspan="2"><button type="button" id="gridReload">查询</button><button onclick="emptiedAndSubmit()" style="margin-left:10px;">清空查询条件</button></td>
		</tr>
		</table>
	</form>
</div>
<div  id="buttons" style="text-align:right;margin-bottom:8px;">
	<button type="button" id="updateInfo" align="right">修改</button>
	<button type="button" id="deleteInfo" align="right">删除</button>
	<!-- button type="button" id="selectInfo" align="right">审核</button-->
	<button type="button" id="selectInfo" align="right">查看</button>
</div>
<div id="pager1"></div>
<table id="clist1"></table>
<div id="delete-dialog" title="删除记录" style="display:none;height:200px;widht=470px;">
	<div class="ui-widget">
		<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
			<p>
			<span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span>
			<strong>确定删除该信息?</strong>
			</p>
		</div>
	</div>
</div>
<div id="dialog" title="1楼幢月检结果表列表" style="display:none">
	<form class="cmxform" style="margin:0" action="${_servlet_url!''}/safemanage.tBuildingSafeadd" method="post" id="addForm">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a6cef2">
		</table>
	</form>
</div>