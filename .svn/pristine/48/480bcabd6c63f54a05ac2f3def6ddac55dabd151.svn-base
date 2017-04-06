<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/safecheck.disasterwarnlistjson',
		datatype: "json",
		width:600,
		height:300,
	   	colNames:[
			"disaster_id"
			,"灾害简称"
			,"所属区域"
			,"灾害类型"
			,"灾害级别"
			,"灾害发生时间"
			,"预警状态"
	   	],
	   	colModel:[
			{name:'disaster_id',index:'disaster_id',sortable:true,hidden:true}
			,{name:'disaster_name',index:'disaster_name',sortable:true}
			,{name:'disaster_region',index:'disaster_region',sortable:true,width:30}
			,{name:'disaster_type',index:'disaster_type',sortable:true,width:30}
			,{name:'disaster_grade',index:'disaster_grade',sortable:true,width:40}
			,{name:'disaster_date',index:'disaster_date',sortable:true,width:30}
			,{name:'info_state',index:'info_state',sortable:true,width:30}
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 'disaster_date',
	    viewrecords: true,
	    sortorder: "desc",
	    rownumbers:true,
	    caption:"突发事件预警列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	//模糊查询					
	jQuery("#gridReload").click(function() {
		var url="${_servlet_url!''}/safecheck.disasterwarnlistjson?"
		+"disaster_name="+$("#disaster_name").val()+"&"
		+"disaster_region="+$("#disaster_region").val()+"&"
		+"disaster_type="+$("#disaster_type").val()+"&"
		+"disaster_grade="+$("#disaster_grade").val()+"&"
		+"disaster_date="+$("#disaster_date").val()+"&"
		+"info_state="+$("#info_state").val();
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
			var url="${_servlet_url!''}/safecheck.disasterwarn.forupdate?disaster_id="+ret.disaster_id;
			window.showModalDialog(url,"","dialogWidth:600px;dialogHeight:400px;center:1;");
			jQuery("#clist1").trigger('reloadGrid');
		}else{
			alert("请选择一条记录！");
		}
	});
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
			var flag=window.confirm("删除不可恢复，确认删除吗？")
			if(flag){
				$.post("${_servlet_url!''}/safecheck.disasterwarn.delete?disaster_id="+ret.disaster_id,"",function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="1"){
						jQuery("#clist1").trigger('reloadGrid');
						alert("删除成功!!");
					}else{
						jQuery("#clist1").trigger('reloadGrid');
						alert("删除失败!!");
					}
				});
			}
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
				var url="${_servlet_url!''}/safecheck.disasterwarn.forcheck?disaster_id="+ret.disaster_id;
				window.showModalDialog(url,"","dialogWidth:600px;dialogHeight:500px;center:1;");
				jQuery("#clist1").trigger('reloadGrid');
			}else{
				alert("只能审核状态为未审核的！");
			}
		}else{
			alert("请选择一条记录！");
		}
	});	
	//取消按钮
	$("#cancelInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) {
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			var flag=window.confirm("确认取消吗？")
			if(flag){
				$.post("${_servlet_url!''}/safecheck.disasterwarn.cancel?disaster_id="+ret.disaster_id,"",function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="1"){
						jQuery("#clist1").trigger('reloadGrid');
						alert("取消成功!!");
					}else{
						jQuery("#clist1").trigger('reloadGrid');
						alert("取消失败!!");
					}
				});
			}
		}else{
			alert("请选择一条记录！");
		}
	});	
	$("#excelInfo").click(function(){
		var url="${_servlet_url!''}/../exportexcel/safecheck.disasterwarn.detaillist?"
		//var url="${_servlet_url!''}/safecheck.disasterwarn.detaillist?"
		+"disaster_name="+$("#disaster_name").val()+"&"
		+"disaster_region="+$("#disaster_region").val()+"&"
		+"disaster_type="+$("#disaster_type").val()+"&"
		+"disaster_grade="+$("#disaster_grade").val()+"&"
		+"disaster_date="+$("#disaster_date").val()+"&"
		+"info_state="+$("#info_state").val();
		var url2 = encodeURI(url);
		window.location=url2;	
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
	$("#disaster_name").val("");
	$("#disaster_region").val("");
	$("#disaster_type").val("");
	$("#disaster_grade").val("");
	$("#disaster_date").val("");
	$("#info_state").val("");
    jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI("${_servlet_url!''}/safecheck.disasterwarnlistjson"),page:1}).trigger("reloadGrid");
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
		<td class="td12">灾害简称:</td>
		<td class="td13" colspan="3">
		<input type="text" size="50" name="disaster_name" id="disaster_name"/>
		</td>
		<td class="td12">所属区域:</td>
		<td class="td13">
			<select id="disaster_region" name="disaster_region">
			<option value="">------请选择------</option>
			[#list EnumService.getEnum('xzqh') as enum]
			<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
			[/#list]
			</select>
		</td>
		<td class="td12">灾害类型:</td>
		<td class="td13">
			<select id="disaster_type" name="disaster_type">
			<option value="">------请选择------</option>
			[#list EnumService.getEnum('disaster_type') as enum]
			<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
			[/#list]
			</select>
		</td>
	</tr>
	<tr>
		<td class="td12">灾害发生时间:</td>
		<td class="td13">
			<input type="text" size="15" name="disaster_date" id="disaster_date" onClick="WdatePicker()"/>
		</td>
		<td class="td12">灾害级别:</td>
		<td class="td13">
			<select name="disaster_grade" id="disaster_grade">
			<option value="">------请选择------</option>
			<option value="1">一般</option>
			<option value="2">较大</option>
			<option value="3">重大</option>
			<option value="4">特别重大</option>
			</select>
		</td>
		<td class="td12">预警状态:</td>
		<td class="td13">
			<select name="info_state" id="info_state">
				<option value="">------请选择------</option>
				<option value="0">未审核</option>
				<option value="1">审核通过</option>
				<option value="2">审核驳回</option>
				<option value="3">已取消</option>
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
	<button type="button" id="checkInfo" align="right">审核</button>
	<button type="button" id="cancelInfo" align="right">取消</button>
	<button type="button" id="excelInfo" align="right">输出Excel</button>
</div>
<div id="pager1"></div>
<table id="clist1"></table>
