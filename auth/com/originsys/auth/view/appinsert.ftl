<!--应用注册页面-->
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/messages_cn.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/swfobject.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="${_share_file_url!''}/resource/css/cmxform.css" />
<script language="javascript" type="text/javascript">
$(function(){
	$("#updateForm").validate({
		rules: {
			app_name:{
				required:true,
				remote:"${_servlet_url!''}/auth.isused"
			},
			app_url:{
				required:true
			},
			redirect_uri: {
				required: true
			}
		},
		messages: {
			app_name:{
				required:"请输入应用名称",
				remote:"该应用名称已注册"
			},
			app_url:{
				required:"请输入应用地址"
			},
			redirect_uri: {
				required: "请输入授权处理地址"
			}
		},
		submitHandler:function(form){
			var queryString=$("#updateForm").formSerialize();
			$.post($("#updateForm").attr("action"),queryString,
				function(data,textStatus){
				var jdata=jQuery.parseJSON(data);
		    	if(jdata.success==1){
		    		alert("注册成功，请等待管理员审核！");
		    		$("#rebut").click();
		    	}else{
		    		alert("注册失败");
		    	}
			});
		}
	});
});
//当文件上传成功后，将返回id:flash对象的ID，name：新文件名,url:文件绝对路径
function returnvalue(id,name,url){
	if(id=="imgupload")
		$("#app_icon").val(url);
}
function viewpic(fieldid,newfilepath){
	window.open(document.getElementById(fieldid).value);
}
</script>	
<style>
.rightpad{text-align:right;padding-right:7px;background-color:#F2F9FF;}
.leftpad{padding-left:2px;background-color:#FFFFFF;}
</style>
<table style="width:100%" border="0">
<tr><td width="200" valign="top">
[#global web=JspTaglibs["/WEB-INF/eap.tld"]]
[@web.block  site_id="eap2" action_id="auth.personalinfo" component_id="auth"/]
</td><td valign="top">
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;应用注册
	</div>	
<form class="cmxform" style="margin:0" action="${_servlet_url!''}/auth.app.insert" method="post" id="updateForm">
	<!--input type="hidden" name="com.eap.token" id="com.eap.token" value="${request.getToken()!''}" /-->
	<table width="100%" border="0" cellpadding="0" cellspacing="1" style="table-layout:fixed;line-height:30px;">
		<tr>
			<td class="rightpad" width="30%"><font color="red">*</font>应用名称：</td>
			<td class="leftpad">
				<input type="text" name="app_name" id="app_name" value=""  style="width:300px"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad"><font color="red">*</font>应用地址：</td>
			<td class="leftpad">
				<input type="text" name="app_url" id="app_url" value=""  style="width:300px"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad"><font color="red">*</font>授权处理地址：</td>
			<td class="leftpad">
				<input type="text" name="redirect_uri" id="redirect_uri" value=""  style="width:300px"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">应用图标：</td>
			<td class="leftpad">
				<input type="hidden" name="app_icon" id="app_icon" value=""  style="width:300px"/>
				<div id="imguploaddiv"></div>
				<script language="javascript" type="text/javascript">
					var so = new SWFObject('${_share_file_url!''}/resource/jsp/imgupload.swf', "imgupload", "125", "60", "9", "#FFffff");//imgupload是控件ID,如有多个ID不可重复
					so.addVariable("oldname",$("#app_icon").val());//修改时的原文件地址，可以是绝对或相对地址
					so.addVariable("savepath","images/auth/");//上传文件的路径
					so.addVariable("uploadpath","${_server_url!''}/eap/manager.system.upload?session_id=${session.id!''}");//上传请求地址so.addVariable("uploadpath","/eap/manager.system.upload");//上传请求地址
					so.write("imguploaddiv");
				</script>	
			</td>
		</tr>
		<tr>
			<td class="rightpad">应用介绍：</td>
			<td class="leftpad">
				<textarea name="app_desc" id="app_desc" rows="5" style="width:300px"></textarea>
			</td>
		</tr>
		<tr><td colspan="2">&nbsp;</td></tr>
		<tr>
			<td></td>
			<td style="background-color:#FFFFFF;">
				<button type="submit" id="addInfo">提交</button>
				<button type="reset" id="rebut">重置</button>
			</td>
		</tr>
	</table>
</form>
</td></tr></table>