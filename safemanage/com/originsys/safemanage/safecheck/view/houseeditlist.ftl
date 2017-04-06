<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/safecheck.building.editlistdata',
		datatype: "json",
		width:600,
		height:300,
	   	colNames:[
				"房屋编号",
				"房屋地址",
				"检查时间",
				"检查人",
				"安全等级"
			,"总健康等级"
			,"结构健康等级"
			,"使用健康等级"
			,"信息状态"
			
	   	],
	   	colModel:[
			{name:'invm_prj_id',index:'invm_prj_id',sortable:true,hidden:true}
			,{name:'building_id',index:'building_id',sortable:true,width:150}
			,{name:'building_mapid',index:'building_mapid',sortable:true}
			,{name:'wf_type',index:'wf_type',sortable:true}
			,{name:'dt_tdesc',index:'dt_tdesc',sortable:true}
			,{name:'struct_desc',index:'struct_desc',sortable:true}
			,{name:'bz_desc',index:'bz_desc',sortable:true}
			,{name:'dere_desc',index:'dere_desc',sortable:true}
			,{name:'check_time',index:'check_time',sortable:true}		
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname:'invm_prj_id',
	    viewrecords: true,
	    sortorder: "asc",
	    rownumbers:true,
	    caption:"房屋年检列表"
	});
	$("#deleteInfo").click(function(){
		var flag=window.confirm("删除不可恢复，确认删除吗？");
	});
});
</script>
<div class="skin_search ui-widget-content" style="padding:.2em;margin-bottom:8px;">
	<form name="dic_form" id="dic_form" action="" method="post">
		<span>房屋地址:</span><span><input type="text" size="15" name="" id=""/></span>
		<span>检查时间:</span><span><input type="text" size="15" name="" id=""/></span>
		<span>信息状态:</span><span><input type="text" size="15" name="" id=""/></span>
		<span>安全等级:</span><span><select><option value="">全部</option></select></span>
		<button type="button" id="gridReload">查询</button>&nbsp;
	</form>
</div>
<div  id="buttons" style="text-align:right;margin-bottom:8px;">
	<!--button type="button" id="updateInfo" align="right">修改</button>
	<button type="button" id="deleteInfo" align="right">删除</button-->
	<button type="button" id="selectInfo" align="right">审核</button>
	<button type="button" id="selectInfo" align="right">查看</button>
</div>
<div id="pager1"></div>
<table id="clist1"></table>
<div id="dialog" title="楼幢月检结果表列表" style="display:none">
	<form class="cmxform" style="margin:0" action="${_servlet_url!''}/safemanage.tBuildingSafeadd" method="post" id="addForm">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a6cef2">
		</table>
	</form>
</div>