<script type="text/javascript" src="${_share_file_url!''}/resource/js/eap.dialog.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.multibox.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.pack.js"></script>
<link type="text/css" rel="stylesheet" href="${_share_file_url!''}/resource/css/custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="${_share_file_url!''}/resource/css/cmxform.css" />
<script type="text/javascript">
$(function(){
	$("#save").click(function(){
      var queryString=$("#versionform").formSerialize();
		  $.post("${_servlet_url!''}/realtygis.mapversion.insert1",queryString,
    		function(data,textStatus)
    		{	
    			var jdata=jQuery.parseJSON(data);
    			if(jdata.success==0){
    				alert("新增失败！");
    				window.close();
    			}else{
    				alert("新增成功！");
    				window.close();
    			}
    		});
	});
});	
</script>
<style>
.detail_attname{text-align:right;padding-right:12px; width:150px;}
.detail_value{padding-left:12px;}
</style>
<div  style="width:100%">
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>&nbsp;地图版本记录修改
	</div>
	<form style="margin:0" action="${_servlet_url!''}/realtygis.mapversion.insert1" method="post" name="versionform" id="versionform">
	<div  id="buttons" style="text-align:right">
		<button id="save" type="button">保存</button>
	</div>
 	<div class="ui-widget-content"  style="position: relative;padding: .2em;">
	<table  width="100%">
		<tr>
			<td class="detail_attname">地图版本号</td>
			<td class="detail_value"><input type="text" size="18" name="version_number" id="version_number"></td>
		</tr>
		<tr>
			<td class="detail_attname">地图版本名称</td>
			<td class="detail_value"><input type="text" size="18" name="version_name" id="version_num" ></td>
		</tr>
		<tr>
			<td class="detail_attname">审核人</td>
			<td class="detail_value"><input type="text"  size="18" name="auditor" ></td>
		</tr>
		<tr>
			<td class="detail_attname">发布人</td>
			<td class="detail_value"><input type="text"  size="18" name="publisher" ></td>
		</tr>
		<!--<tr>
			<td class="detail_attname">状态</td>
			<td class="detail_value">
				<input type="radio" name="status" id="status2" value="启用">启用
				<input type="radio" name="status" id="status1" value="禁用" checked>禁用
			</td>
		</tr>
		<tr>
            <td class="detail_attname">默认地图</td>
            <td class="detail_value">
				<input type="radio" name="default_map" id="default_map1" value="1001">是
				<input type="radio" name="default_map" id="default_map2" value="1000" checked>否
            </td>
        </tr>-->
		<tr>
			<td class="detail_attname">备注</td>
			<td class="detail_value"><input type="text"  size="18" name="message" id="message"></td>
		</tr> 
	</table>
	</form>
	</div>
</div>
