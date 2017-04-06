<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/safecheck.trackwarnlistjson',
		datatype: "json",
		width:600,
		height:300,
	   	colNames:[
			"building_id"
			,"楼幢坐落"
			,"所属区域"
			,"委托人或者单位"
			,"联系人"
			,"联系电话"
			,"鉴定人"
			,"鉴定单位"
			,"鉴定时间"
			,"危险等级"
			,"通知发送时间"
			,"逾期情况"
	   	],
	   	colModel:[
			{name:'building_id',index:'building_id',sortable:true,hidden:true}
			,{name:'building_address',index:'building_address',sortable:true}
			,{name:'building_region',index:'building_region',sortable:true,width:30}
			,{name:'entrust_user',index:'entrust_user',sortable:true,width:40}
			,{name:'linkman',index:'linkman',sortable:true,width:30}
			,{name:'linktel',index:'linktel',sortable:true,width:30}
			,{name:'jdmember',index:'jdmember',sortable:true,width:30}
			,{name:'jd_department',index:'jd_department',sortable:true,width:40}
			,{name:'jd_date',index:'jd_date',sortable:true,width:30}
			,{name:'dangerous_level',index:'dangerous_level',sortable:true,width:55}
			,{name:'notice_date',index:'notice_date',sortable:true,width:30}
			,{name:'over_grade',index:'over_grade',sortable:true,width:65}
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 'over_grade',
	    viewrecords: true,
	    sortorder: "desc",
	    rownumbers:true,
	    caption:"危房跟踪预警列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	//模糊查询					
	jQuery("#gridReload").click(function() {
		var url="${_servlet_url!''}/safecheck.trackwarnlistjson?"
		+"building_address="+$("#building_address").val()+"&"
		+"building_region="+$("#building_region").val()+"&"
		+"jdmember="+$("#jdmember").val()+"&"
		+"jd_department="+$("#jd_department").val()+"&"
		+"jd_date="+$("#jd_date").val()+"&"
		+"notice_date="+$("#notice_date").val()+"&"
		+"dangerous_level="+$("#dangerous_level").val()+"&"
		+"over_grade="+$("#over_grade").val();
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
	$("#building_region").val("");
	$("#jdmember").val("");
	$("#jd_department").val("");
	$("#jd_date").val("");
	$("#notice_date").val("");
	$("#dangerous_level").val("");
	$("#over_grade").val("");
    jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI("${_servlet_url!''}/safecheck.trackwarnlistjson"),page:1}).trigger("reloadGrid");
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
			<select id="building_region" name="building_region">
			<option value="">------请选择------</option>
			[#list EnumService.getEnum('xzqh') as enum]
			<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
			[/#list]
			</select>
		</td>
		<td class="td12">鉴定人：</td>
		<td class="td13">
			<input type="text" size="15" name="jdmember" id="jdmember"/>
		</td>
		<td class="td12">鉴定单位:</td>
		<td class="td13">
			<input type="text" size="15" name="jd_department" id="jd_department" />
		</td>
		</tr>
		<tr>
		<td class="td12">鉴定时间:</td>
		<td class="td13">
			<input type="text" size="15" name="jd_date" id="jd_date" onClick="WdatePicker()"/>
		</td>
		<td class="td12">通知发送时间:</td>
		<td class="td13">
			<input type="text" size="15" name="notice_date" id="notice_date" onClick="WdatePicker()"/>
		</td>
		<td class="td12">危房等级:</td>
		<td class="td13">
			<select name="dangerous_level" id="dangerous_level">
			<option value="">------请选择------</option>
			<option value="1">A级</option>
			<option value="2">B级</option>
			<option value="3">C级</option>
			<option value="4">D级</option>
			</select>
		</td>
		<td class="td12">逾期情况:</td>
		<td class="td13">
			<select name="over_grade" id="over_grade">
				<option value="">------请选择------</option>
				<option value="1">临近逾期</option>
				<option value="2">已逾期</option>
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
