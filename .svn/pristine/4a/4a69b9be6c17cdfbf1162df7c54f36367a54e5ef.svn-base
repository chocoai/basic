<link rel="stylesheet" type="text/css" href="${_share_file_url!''}/gis/resource/css/all.css">
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<style>
.ui-widget-header td{border-bottom:1px solid gray}
.ui-dialog-titlebar-btn { width: 19px; padding: 1px; height: 18px; }
</style>
<script type="text/javascript">
 $(function(){
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/realtygis.mapversiongridjson',
		datatype: "json",
		width:720,
		height:380,
	   	colNames:['地图版本号','地图版本名称', '审核人','发布人','状态','默认地图','版本新增时间','地图预览'],
	   	colModel:[
	   		{name:'version_number',index:'version_number',align:'center',sortable:true},
	   		{name:'version_name',index:'version_name',align:'center',sortable:true},
	   		{name:'auditor',index:'auditor',align:'center',sortable:true},
	   		{name:'publisher',index:'auditor',align:'center',sortable:true},
	   		{name:'status',index:'status',align:'center',sortable:true},
	   		{name:'default_map',index:'default_map',align:'center',sortable:true},
	   		{name:'add_date',index:'add_date',align:'center',sortable:true},
	   		{name:'预览',index:'预览',align:'center'}
	   	],
	   	rowNum:10,
	   	autowidth: true, 
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 'version_number',
	    viewrecords: true,
	    sortorder: "desc", 
	    rownumbers:true,
	    caption:"地图版本号查询列表",
	    onCellSelect:function(rowid,iCol,cellcontent){
	       var mapname=jQuery("#clist1").getCell(rowid,'version_number');
	       if(iCol==8){
              window.open('realtygis.mapversionforview?mapname='+mapname,'_blank','depended=yes,top='+(window.screen.height-30-530)/2+',left='+(window.screen.width-10-1000)/2+',,width=1000,height=530,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes');
	      }
	    }
	});
	//新增地图版本
	$("#addInfo").click(function(){
		var url="${_servlet_url!''}/realtygis.mapversion.forinsert";
		window.showModalDialog(url,"","dialogWidth:500px;dialogHeight:400px;center:1;");
		jQuery("#clist1").trigger('reloadGrid');
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
	} 	
	 //消息提示框
	$('#msg').dialog({
		title:'提示信息',
		width: 200,
		height:150,
		autoOpen: false,
		modal: true,
		buttons: [
	    {
	        text: "确定",
	        click: function() { $(this).dialog("close"); }
	    }
	]
	});	

	//删除确认用对话框
	$("#dialog-confirm").dialog({
			resizable: false,
			height:150,
			autoOpen: false,
			modal: true,
			buttons: {
				'确定删除': function() {
					$(this).dialog('close');
					delinfo();
				},
				'取消': function() {
					$(this).dialog('close');
				}
			}
		});
	//首页模式浏览
	function showSmallFr(){
	 if(parent.MAP_VISION){	 	
		  parent.sizePane('south',3,"in"); 	
		  parent.openPane('south',"in");
	  }	
	}  
	$("#Close").bind('click',function(){
		showSmallFr();
	});
});
//弹出消息框函数
	function warn(msg){
	alert(""+msg);
		$('td',$('#msg')).text(msg);		
		$('#msg').dialog("open");	
	}
//删除记录
function doDelete(){
	var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
	
  	if (id) { 
  		var flag=window.confirm("删除不可恢复，确认删除吗？")
		if(flag){
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
		    if(ret.default_map=="是"){
		      alert("默认地图不可删除！");
		    }
		    else{
		       //delinfo();
			   $.post("${_servlet_url!''}/realtygis.mapversion.delete?version_number="+ret.version_number,"",function(data,textStatus){
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
		}
	}else{
		alert("请选择一条记录");
	}
}
//重新加载jqgrid
function gridReload(){
	jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI("${_servlet_url!''}/realtygis.mapversiongrid"),page:1}).trigger("reloadGrid");
} 
function delinfo(){
	var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
	var ret = jQuery("#clist1").jqGrid('getRowData',id);
	jQuery("#clist1").jqGrid('setGridParam',{url:encodeURI("${_servlet_url!''}/realtygis.mapversion.delete?version_number="+ret.version_number),page:1}).trigger("reloadGrid");
	jQuery("#clist1").trigger('reloadGrid');
}	
//修改更新记录
function doUpdate(){
	var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
	if (id) { 
		var ret = jQuery("#clist1").jqGrid('getRowData',id);
		//parent.versionupdate(ret.version_number);
		var url="${_servlet_url!''}/realtygis.mapversion.forupdate?version_number="+ret.version_number;
		window.showModalDialog(url,"","dialogWidth:500px;dialogHeight:400px;center:1;");
		jQuery("#clist1").trigger('reloadGrid');
	}else {
		alert("请选择一条记录");
	}
}
 </script>
 <div style="padding:5px">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="140" height="30"><h2>地图版本列表</h2></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <!--<td width="50" align="center" ><img id="Close" src="${_share_file_url!''}/gis/resource/houselist/images/close.png" width="23" height="23" /></td>-->
      </tr>
    </table>
 </table>
 <div  id="buttons" style="text-align:right">
 	[#if access.canDo(user,'realtygis.mapversion.forinsert')]
		<button type="button" id="addInfo">新增</button>
	[/#if]
	[#if access.canDo(user,'realtygis.mapversion.forupdate')]
		<button type="button"  onclick="doUpdate()">修改</button>
	[/#if]
	[#if access.canDo(user,'realtygis.mapversion.delete')]
		<button type="button" onclick="doDelete()">删除</button>
	[/#if]
	</div>
	<div id="pager1"></div>
	<table id="clist1" ></table>	
</div>
<div id="dialog-confirm" title="确定要删除吗?"style="display:none">
	<p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>删除将不可恢复,您确定吗?</p>
</div>
<!--提示消息框-->
<div id="msg" class="ui-widget-content" style="padding: .2em;display:none">
<table width="100%" border="0" height="100%">
  <tr>
    <td align="center" valign="middle"></td>
  </tr>
</table>
</div>
<div id="versionview" style="display:none;position: absolute; left: 0px; right: 0px; width: 99%; height: 88%;">

</div>
