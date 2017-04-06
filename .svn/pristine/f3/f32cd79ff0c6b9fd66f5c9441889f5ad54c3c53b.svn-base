<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	//表格
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/safeauth.jdtask.listjson',
		datatype: "json",
		width:600,
		height:270,
	   	colNames:[
			"jdtask_id"
			,"building_id"
			,"楼幢坐落新地址"
			,"楼幢坐落地址"
			,"所属区域"
			,"建成时间"
			,"经营单位"
			,"产权单位"
			,"经办人/委托人"
			,"数据来源"
			,"安全情况"
			,"任务生成日期"
			,"定位"
	   	],
	   	colModel:[
			{name:'jdtask_id',index:'jdtask_id',sortable:true,hidden:true}
			,{name:'building_id',index:'building_id',sortable:true,hidden:true}
			,{name:'building_newaddress',index:'building_newaddress',sortable:true}
			,{name:'building_address',index:'building_address',sortable:true}
			,{name:'building_region',index:'building_region',sortable:true,width:40}
			,{name:'building_date',index:'building_date',sortable:true,width:40}
			,{name:'management_unit',index:'management_unit',sortable:true,width:70}
			,{name:'owner',index:'owner',sortable:true,width:70}
			,{name:'agent',index:'agent',sortable:true,width:50}
			,{name:'data_origin',index:'data_origin',sortable:true,width:40}
			,{name:'safe_grade',index:'safe_grade',sortable:true,width:70}
			,{name:'add_time',index:'add_time',sortable:true,width:40}
			,{name:'dw',index:'dw',width:40}
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname:'add_time',
	    viewrecords: true,
	    sortorder: "desc",
	    rownumbers:true,
	    caption:"鉴定任务报告单"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	//模糊查询
	jQuery("#gridReload").click(function() {
		var url="${_servlet_url!''}/safeauth.jdtask.listjson"
				+"?building_address="+$("#building_address").val()
				+"&building_region="+$("#building_region").val()
				+"&safe_grade="+$("#safe_grade").val()
				+"&building_date="+$("#building_date").val()
				+"&agent="+$("#agent").val()
				+"&data_origin="+$("#data_origin").val();
				;
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2,page:1}).trigger("reloadGrid");
	});
	$("#updateInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) {
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			var flag=window.confirm("楼幢坐落新地址:"+ret.building_newaddress+"\n楼幢坐落地址："+ret.building_address+"\n受理之后列表中不再显示\n确认受理鉴定任务单吗？");
			if(flag){
				var url="${_servlet_url!''}/safeauth.jdtask.accept?info_id="+ret.jdtask_id;	
				$.post(url,"",function(data,textStatus){
						var jdata=jQuery.parseJSON(data);
						if(jdata.success=="1"){
							alert("受理成功!");
							jQuery("#clist1").trigger('reloadGrid');
						}else{
							alert("受理失败!");
						}
				});
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
	$("#building_region").val("");
	$("#safe_grade").val("");
	$("#building_date").val("");
	$("#agent").val("");
	$("#data_origin").val("");
    jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI("${_servlet_url!''}/safeauth.jdtask.listjson"),page:1}).trigger("reloadGrid");
}
</script>
<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
.rightpad{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.leftpad{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
.file-box input{ vertical-align:middle; margin:0; padding:0}
.file-box{ position:relative;width:440px;WHITE-SPACE:nowrap;}
.file-box .txt{ height:22px; border:1px solid #cdcdcd; width:195px;}
.file-box .btn{ background-color:#FFF; border:1px solid #CDCDCD;height:24px; width:60px;}
.file-box .file{ position:absolute; top:3px; right:180px; height:24px; filter:alpha(opacity:0);opacity: 0;width:260px }
</style>
<div class="skin_search ui-widget-content" style="padding:.2em;margin-bottom:8px;">
	<form name="dic_form" id="dic_form" action="${_servlet_url!''}/safeauth.report.listjson" method="post">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<tr>
		<td class="td12">楼幢地址:</td>
		<td class="td13" colspan="3"><input type="text" name="building_address" id="building_address"/></td>
		<td class="td12">所属区域:</td>
		<td class="td13">
			<select id="building_region" name="building_region">
			<option value="">------请选择------</option>
			[#list EnumService.getEnum('xzqh') as enum]
			<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
			[/#list]
			</select>
		</td>
		<td class="td12">安全情况:</td>
		<td class="td13">
			<select name="safe_grade" id="safe_grade">
			<option value="">------请选择------</option>
			<option value="1">A级</option>
			<option value="2">B级</option>
			<option value="3">C级</option>
			<option value="4">D级</option>
			</select>
		</td>
		</tr>
		<tr>
		<td class="td12">建成时间:</td>
		<td class="td13"><input type="text" size="14" name="building_date" id="building_date"  onClick="WdatePicker({dateFmt:'yyyy'})"/></td>
		<td class="td12">经办人/委托人:</td>
		<td class="td13"><input type="text" size="14" name="agent" id="agent"/></td>
		<td class="td12">数据来源:</td>
		<td class="td13">
			<select name="data_origin" id="data_origin">
			<option value="">------请选择------</option>
			<option value="安全检查">安全检查</option>
			<option value="安全普查">安全普查</option>
			<option value="网站上报">网站上报</option>
			</select>
		</td>
		<td class="td13" colspan="42">
		<button type="button" id="gridReload">查询</button>
		<button onclick="emptiedAndSubmit()" style="margin-left:10px;"  type="button">清空查询条件</button>
		</td>		
		</tr>
		</table>
	</form>
</div>
<div  id="buttons" style="text-align:right;margin-bottom:8px;">
	<button type="button" id="updateInfo" align="right">受理</button>
</div>
<div id="pager1"></div>
<table id="clist1"></table>