<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	//表格
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/safecheck.building.managelistjson',
		datatype: "json",
		width:600,
		height:300,
	   	colNames:[
			"building_id"
			,"info_id"
			,"检查新坐落"
			,"楼幢坐落"
			,"所属区域"
			,"房屋产别"
			,"设计用途"
			,"建成时间"
			,"房屋结构"
			,"房屋安全情况"
			,"危楼类型"
			,"检查时间"
			,"检查状态"
			,"定位"
	   	],
	   	colModel:[
			{name:'building_id',index:'building_id',sortable:true,hidden:true}
			,{name:'info_id',index:'info_id',sortable:true,hidden:true}
			,{name:'check_address',index:'check_address',sortable:true}
			,{name:'building_address',index:'building_address',sortable:true}
			,{name:'builiding_region',index:'builiding_region',sortable:true,width:30}
			,{name:'real_type',index:'real_type',sortable:true,hidden:true}
			,{name:'use_desgin',index:'use_desgin',sortable:true,hidden:true}
			,{name:'building_date',index:'building_date',sortable:true,width:30}
			,{name:'build_struct',index:'build_struct',sortable:true,hidden:true}
			,{name:'health_grade_pc',index:'health_grade_pc',sortable:true,width:50}
			,{name:'dangerous_type_pc',index:'dangerous_type_pc',hidden:true}
			,{name:'check_time',index:'check_time',sortable:true,width:40}
			,{name:'info_state',index:'info_state',sortable:true,width:40}
			,{name:'dw',index:'dw',width:30}
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 'check_time',
	    viewrecords: true,
	    sortorder: "desc",
	    rownumbers:true,
	    caption:"楼幢检查管理列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	
	//模糊查询					
	jQuery("#gridReload").click(function() {
		var url="${_servlet_url!''}/safecheck.building.managelistjson?"
		+"building_address="+$("#building_address").val()+"&"
		//+"builiding_region="+$("#builiding_region").val()+"&"
		+"real_type="+$("#real_type").val()+"&"
		+"use_desgin="+$("#use_desgin").val()+"&"
		+"building_date="+$("#building_date").val()+"&"
		+"build_struct="+$("#build_struct").val()+"&"
		+"health_grade_pc="+$("#health_grade_pc").val()+"&"
		+"info_state="+$("#info_state").val()+"&"
		;
		//+"dangerous_type_pc="+$("#dangerous_type_pc").val();
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2,page:1}).trigger('reloadGrid');
	});
	//查看信息按钮
	$("#selectInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			window.location="${_servlet_url!''}/safecheck.building.detail?building_id="+ret.building_id+"&info_id="+ret.info_id+"&op=detail";	
		}else{
			alert("请选择一条记录！");
		}
	});	
	//审核按钮
	$("#checkInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		
		if (id) {
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			var info_state=ret.info_state;
			if(info_state == '未审核'){
				var url="${_servlet_url!''}/safecheck.building.detail?building_id="+ret.building_id+"&info_id="+ret.info_id+"&op=check";	
				window.showModalDialog(url,"","dialogWidth:1000px;dialogHeight:600px;center:1;");
				jQuery("#clist1").trigger('reloadGrid');
			}else{
				alert("只能审核状态为未审核的！");
			}
		}else{
			alert("请选择一条记录！");
		}
	});	
	//生成鉴定任务单按钮
	$("#taskInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) {
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			var info_state=ret.info_state;
			if(info_state == '审核通过'){
				var url="${_servlet_url!''}/safeauth.jdtask.insert?building_id="+ret.building_id+"&info_id="+ret.info_id+"&op=check";	
				$.post(url,"",function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="1"){
						alert("生成成功!!");
					}else if(jdata.success=="2"){
						alert("该记录已经生成鉴定任务单!!");
					}else{
						alert("生成失败!!");
					}
				});
			}else{
				alert("只能生成审核通过的记录！");
			}
		}else{
			alert("请选择一条记录！");
		}
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
	//$("#builiding_region").val("");
	$("#real_type").val("");
	$("#use_desgin").val("");
	$("#building_date").val("");
	$("#build_struct").val("");
	$("#health_grade_pc").val("");
	$("#dangerous_type_pc").val("");
	$("#info_state").val("");
    jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI("${_servlet_url!''}/safecheck.building.managelistjson"),page:1}).trigger("reloadGrid");
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
		<!--<td class="td12">所属区域:</td>
		<td class="td13">
			<select id="builiding_region" name="builiding_region">
			<option value="">------请选择------</option>
			[#list EnumService.getEnum('xzqh') as enum]
			<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
			[/#list]
			</select>
		</td>-->
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
		<td class="td12">房屋结构:</td>
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
		<!--td class="td12">危房类型:</td>
		<td class="td13">
			<select name="dangerous_type_pc" id="dangerous_type_pc">
			<option value="">------请选择------</option>
			<option value="1">整栋危楼</option>
			<option value="2">局部危楼</option>
			</select>
		</td-->
		<td class="td12">检查状态:</td>
		<td class="td13">
			<select name="info_state" id="info_state">
				<option value="">------请选择------</option>
				<option value="0">暂存</option>
				<option value="1">未审核</option>
				<option value="2">审核驳回</option>
				<option value="8">审核通过</option>
			</select>
		</td>
		<td class="td13" colspan="4"><button type="button" id="gridReload">查询</button><button onclick="emptiedAndSubmit()" style="margin-left:10px;">清空查询条件</button></td>
		</tr>
		</table>
	</form>
</div>
<div  id="buttons" style="text-align:right;margin-bottom:8px;">
	<button type="button" id="checkInfo" align="right">审核</button>
	[#if access.canDo(user,'safeauth.jdtask.insert')]
	<button type="button" id="taskInfo" align="right">生成鉴定任务单</button>
	[/#if]
	<!--button type="button" id="selectInfo" align="right">查看</button-->
</div>
<div id="pager1"></div>
<table id="clist1"></table>			
