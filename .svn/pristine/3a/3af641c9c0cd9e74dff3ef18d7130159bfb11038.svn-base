<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<link type="text/css" rel="stylesheet" href="${_share_file_url!''}/resource/css/custom.css" />
<script language="javascript">
$(function(){
	$("#toadd").click(function(){
		var url="${_servlet_url!''}/auth.orgcomlistdialog";
		var arr=window.showModalDialog(url,"","dialogWidth:600px;dialogHeight:500px;center:1;");
		if(arr == undefined) { 
			arr = window.returnValue;  
        }
		if(arr!=undefined){
			//$("#organ_id3").val(arr[0]);
			//$("#organ_name3").val(arr[1]);
			var html="<tr class='odd' id='tr_"+arr[0]+"'>";
			html+="<td><input type='hidden' name='organ_id' value='"+arr[0]+"'>"+arr[1]+"</td>";
			html+="<td><input type='radio' name='current_organ' value='"+arr[0]+"' >设为默认</td>";
			html+="<td><button type='button' onclick=\"todel('"+arr[0]+"');\">删除</button></td></tr>";
			$("#tab1").append(html);
		}
	});
});
function todel(organ_id){
	$("#tr_"+organ_id).remove();
}
function tosave(){
	var queryString=$("#form1").formSerialize();
			$.post("${_servlet_url!''}/auth.eadmin.update",queryString,
				function(data,textStatus){
				var jdata=jQuery.parseJSON(data);
		    	if(jdata.success=="1"){
		    		alert("保存成功");
		    	}else{
		    		alert("保存失败");
		    	}
			});	
}
</script>
<div class="ui-widget ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;可管理企业列表
	</div>
</div>

<div class="ui-widget ui-widget-content">
	<form id="form1">
		<div  class="ui-widget" id="buttons" style="text-align:right">
			<button type="button" id="save" onclick="tosave();">保存</button>
		</div>
		<input type="hidden" name="mem_id" value="${block.mem_id!''}">
		<table id="tab1"  class="ui-widget-content ui-widget-table ui-corner-all" cellspacing="1">
			<tr><td colspan="3"><button type="button" id="toadd">增加可管理企业</button></td></tr>
			[#if block.organlist?exists]
			[#list block.organlist as organ]
			<tr class="odd" id="tr_${organ.ORGAN_ID!''}">
				<td>
					<input type="hidden" name="organ_id" value="${organ.ORGAN_ID!''}">${organ.ORGAN_NAME!''}
				</td>
				<td>
					<input type="radio" name="current_organ" value="${organ.ORGAN_ID!''}" [#if "${block.eadmin.current_organ!''}"=="${organ.ORGAN_ID!''}"]checked[/#if]>设为默认
				</td>
				<td><button type="button" onclick="todel('${organ.ORGAN_ID!''}');">删除</button></td>
			</tr>
			[/#list]
			[/#if]
		</table>
	</form>
</div>