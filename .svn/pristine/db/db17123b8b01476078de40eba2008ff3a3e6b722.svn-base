<script language="javascript">
function returnvalue(id,data){
	var jdata=eval('(' +data+')');
	if(jdata.success=="3"){
		var str="导入成功\r\n";
		if(jdata.num>0){
			str+="因为已经存在，有"+jdata.num+"个未被导入，分别是：\r\n";
			str+=jdata.have_otp;
		}
		alert(str);
	}else if(jdata.success=="1"){
		alert("上传文件失败！");
	}else if(jdata.success=="2"){
		alert("导入文件失败！");
	}else{
		alert("操作失败！");
	}
}
</script>
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;导入动态令牌
	</div>	
	<table width="100%" border="0" cellpadding="0" cellspacing="1" style="table-layout:fixed;line-height:30px;">
		<tr><td>请选择存放动态令牌的文本文件:</td></tr>
		<tr><td><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="300" height="35">
					<param name="movie" value="${_share_file_url!''}/resource/jsp/fileupload.swf" />
					<param name="flashvars" 
					value="action=${_server_url!''}/eap/auth.importotp&savepath=&fieldname=optfile&type=*.txt&oldname=&id=&size=10m" />
					<param name="menu" value="false" />
					<param name="wmode" value="transparent" />
					<embed src="${_share_file_url!''}/resource/jsp/fileupload.swf" 
					 wmode="transparent" 
					 flashvars="action=${_server_url!''}/eap/auth.importotp&savepath=&fieldname=optfile&type=*.txt&oldname=&id=&size=10m"
					 menu="false" pluginspage="http://www.macromedia.com/go/getflashplayer"
					 type="application/x-shockwave-flash" width="300" height="35">
					</embed>
		</object>
	<tr><td><font color="grey"><b>温馨提示：</b></font></td></tr>
	<tr><td><font color="grey">文件的格式如下：</font></td></tr>
	<tr><td><font color="grey">3400000026951 ll64CAD0E12FA30EF5348BABE435BB194AE48B8825D839E1CF<br>5600000026961 ll14F0F11D3FED0C12C46A715FFEC6B579308D28DB94E28FBC</font></td></tr>
	
	</table>
</div>