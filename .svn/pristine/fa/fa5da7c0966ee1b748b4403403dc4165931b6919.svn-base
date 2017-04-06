<script type="text/javascript" src="${_share_file_url!''}/resource/js/eap.dialog.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.multibox.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.pack.js"></script>
<link type="text/css" rel="stylesheet" href="${_share_file_url!''}/resource/css/custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="${_share_file_url!''}/resource/css/cmxform.css" />
<script type="text/javascript">
$(function(){
	$("#save").click(function(){
		if($("#status").val()=="禁用" && $("#default_map").val()=="1001"){
			alert("默认地图不能禁用！");
			return false;
		}
      	var queryString=$("#versionform").formSerialize();
		  $.post("realtygis.mapversion.update",queryString,
    		function(data,textStatus)
    		{	
    			var jdata=jQuery.parseJSON(data);
    			if(jdata.version=="1")
    				{
    					alert("修改成功");
    					window.close();
    				}
    			else
    				{
    					alert("修改失败!默认地图不能禁用！");
    					window.close();
    				}
    		});
	});
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
	
});
//弹出消息框函数
function warn(msg){
	$('td',$('#msg')).text(msg);
	$('#msg').dialog("open");
}
</script>
<div  style="width:100%">
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px"><img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>&nbsp;地图版本记录修改
	</div>
	<form style="margin:0" action="${_servlet_url!''}/realtygis.mapversion.insert" method="post" name="versionform" id="versionform">
	<div  id="buttons" style="text-align:right">
		<button id="save" type="button">保存</button>
	</div>
 <div class="ui-widget-content"  style="position: relative;padding: .2em;">
	<table  width="100%">
		<tr>
			<td class="detail_attname">地图版本号</td>
			<td class="detail_value">${map.version.version_number}
			<input type="hidden" size="18" name="version_number" value="${map.version.version_number}"></td>
		</tr>
		<tr>
			<td class="detail_attname">地图版本名称</td>
			<td class="detail_value"><input type="text" name="version_name" id="version_num" value="${map.version.version_name!''}"></td>
		</tr>
		<tr>
			<td class="detail_attname">审核人</td>
			<td class="detail_value"><input type="text"  size="18" name="auditor" value="${map.version.auditor!''}"></td>
		</tr>
		<tr>
			<td class="detail_attname">发布人</td>
			<td class="detail_value"><input type="text"  size="18" name="publisher" value="${map.version.publisher!''}"></td>
		</tr>
		<tr>
			<td class="detail_attname">状态</td>
			<td class="detail_value">
			<select  name="status" id="status">
				<option value="禁用" [#if "${map.version.status!''}"=="禁用"]selected[/#if]>禁用</option>
				<option value="启用" [#if "${map.version.status!''}"=="启用"]selected[/#if]>启用</option>
			</select></td>
		</tr>
		<tr>
            <td class="detail_attname">默认地图</td>
            <td class="detail_value">
            <select  name="default_map" id="default_map">
				<option value="1001" [#if "${map.version.default_map!''}"=="1001"]selected[/#if]>是</option>
				<option value="1000" [#if "${map.version.default_map!''}"=="1000"]selected[/#if]>否</option>
				</select>
            </td>
        </tr>
		<tr>
			<td class="detail_attname">备注</td>
			<td class="detail_value"><input type="text"  size="18" name="message" value="${map.version.message!''}"></td>
		</tr>
	</table>
	</form>
	</div>
</div>
<!--提示消息框-->
<div id="msg" class="ui-widget-content" style="padding: .2em;display:none">
<table width="100%" border="0" height="100%">
  <tr>
    <td align="center" valign="middle"></td>
  </tr>
</table>
</div>
