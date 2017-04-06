<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/card.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/swfobject.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="${_share_file_url!''}/resource/css/cmxform.css" />
<script language="javascript" type="text/javascript">
$(function(){
	//日期选择:
	$("#mem_born").attr("readonly", "true").datepicker({changeMonth: true,changeYear: true, yearRange: '-100:-18',dateFormat:"yy-mm-dd"});
	$("#updateForm").validate({
		rules: {
			mem_mphone:{
				number:true,
				maxlength:11,
				minlength:11
			},
			mem_mail:{
				email:true
			},
			ID_num:{
				isIdCardNo:true
			}
		},
		messages: {
			mem_mphone:{
				number:"请输入11位数字",
				maxlength:"请输入11位数字",
				minlength:"请输入11位数字"
			},
			mem_mail:{
				email:"邮箱格式不正确"
			},
			ID_num:{
				isIdCardNo:"请正确输入您的身份证号码"
			}	
		},
		submitHandler:function(form){
			var queryString=$("#updateForm").formSerialize();
			$.post($("#updateForm").attr("action"),queryString,
				function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success==1){
						alert("修改成功");
						//window.history.go(-1);
					}else{
						alert("修改失败！");
					}
			});
		}
	});
	// 身份证号码验证 
	jQuery.validator.addMethod("isIdCardNo", function(value, element) { 
	  return this.optional(element) || idCardNoUtil.checkIdCardNo(value);     
	}, "请正确输入您的身份证号码"); 
});
function chengeBirthday(){
	var code=$("#ID_num").val();
	if(code=="")
		return false;
	var year =  code.substring(6,10);   
    var month = code.substring(10,12);   
    var day = code.substring(12,14); 
    var born=year+"-"+month+"-"+day;
    if(born!="--")
    	$("#mem_born").val(year+"-"+month+"-"+day); 
}
function addr1(){
	var addr=window.showModalDialog("commonservice.region?pid=086","","dialogWidth=350px;dialogHeight=400px");
	if(addr!=undefined){
		$("#mem_region").val(addr[0]);
		$("#mem_region_name").val(addr[1]);
	}
}
	//当文件上传成功后，将返回id:flash对象的ID，name：新文件名,url:文件绝对路径
	function returnvalue(id,name,url){
		if(id=="imgupload")
			$("#mem_image").val(url);
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
		&nbsp;用户基本信息
	</div>
<form class="cmxform" style="margin:0" action="${_servlet_url!''}/auth.userInfoupdate" method="post" id="updateForm">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" style="table-layout:fixed;line-height:30px;">
		<col width="150px"/><col />
			<tr>
				<input type="hidden" name="mem_id" id="mem_id" value="${result.mem_id!''}"/>
			</tr>
			<tr>
				<td class="rightpad">用户名</td>
				<td class="leftpad">${result.mem_name!''}
					<input type="hidden" name="mem_name" id="mem_name" value="${result.mem_name!''}"/>
				</td>
			</tr>
			<tr>
				<td class="rightpad">姓名</td>
				<td class="leftpad">
					${result.family_name!''}
					<input type="hidden" name="first_name" id="first_name" value=""/>
					<input type="hidden" name="family_name" id="family_name" value="${result.family_name!''}"/>
				</td>
			</tr>
			<!-- tr>
				<td class="rightpad">名</td>
				<td class="leftpad">
					<input type="text" name="first_name" id="first_name" value="${result.first_name!''}" size="40"/>
				</td>
			</tr -->
			<tr>
					<td class="rightpad">身份证号</td>
					<td class="leftpad">${result.ID_num!''}
						<input type="hidden" name="ID_num" id="ID_num" value="${result.ID_num!''}"/>
					</td>
			</tr>
			<tr>
				<td class="rightpad">性别</td>
				<td class="leftpad">
					<select name="mem_sex" id="mem_sex"/>
					[#list EnumService.getEnum('sex') as enum]
					<option value="${enum.enum_value!''}" [#if "${result.mem_sex!''}"=="${enum.enum_value!''}"]selected[/#if]>${enum.enum_name!''}</option>
					[/#list]
					</select>
				</td>
			</tr>
			<tr>
				<td class="rightpad">生日</td>
				<td class="leftpad">
						[#if result.mem_born?exists]
							<input type="text" name="mem_born" id="mem_born" value="${result.mem_born?string('yyyy-MM-dd')}" size="40"/>
						[#else]
							<input type="text" name="mem_born" id="mem_born" value="" size="40"/>
						[/#if]
				</td>
			</tr>
			<tr>
				<td class="rightpad">手机</td>
				<td class="leftpad">
					<input type="text" name="mem_mphone" id="mem_mphone" value="${result.mem_mphone!''}" size="40"/>
				</td>
			</tr>
			<tr>
				<td class="rightpad">邮址</td>
				<td class="leftpad">
					<input type="text" name="mem_mail" id="mem_mail" value="${result.mem_mail!''}" size="40"/>
				</td>
			</tr>
			<tr>
				<td class="rightpad">区域属地</td>
				<td class="leftpad">
					<input type="hidden" name="mem_region" id="mem_region" value="${result.mem_region!''}"/>
					<input type="text" name="mem_region_name" id="mem_region_name" size="40" value="${result.mem_region_name!''}" readonly="true" onclick="addr1();"/>
				</td>
			</tr>
			<tr>
				<td class="rightpad">地址</td>
				<td class="leftpad">
					<input type="text" name="mem_addr" id="mem_addr" value="${result.mem_addr!''}" size="40"/>
				</td>
			</tr>
			<tr>
					<td class="rightpad">安全认证图片</td>
					<td class="leftpad">
						<input type="text" name="secure_image" id="secure_image" value="${result.secure_image!''}" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">注册来源网站</td>
					<td class="leftpad">
						<input type="text" name="reg_source" id="reg_source" value="${result.reg_source!''}" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">头像</td>
					<td class="leftpad">
					<input type="hidden" name="mem_image" id="mem_image" value="${result.mem_image!''}" size="40"/>
					<div id="imguploaddiv"></div>
					<script language="javascript" type="text/javascript">
						var so = new SWFObject('${_share_file_url!''}/resource/jsp/imgupload.swf', "imgupload", "60", "60", "9", "#FFffff");//imgupload是控件ID,如有多个ID不可重复
						so.addVariable("oldname",$("#mem_image").val());//修改时的原文件地址，可以是绝对或相对地址
						so.addVariable("savepath","images/manager/");//上传文件的路径
						so.addVariable("uploadpath","${_server_url!''}/eap/manager.system.upload?session_id=${session.id!''}");//上传请求地址so.addVariable("uploadpath","/eap/manager.system.upload");//上传请求地址
						so.write("imguploaddiv");
					</script>
					</td>
			</tr>
			<tr>
					<td class="rightpad">备注信息</td>
					<td class="leftpad">
						<textarea name="note_info" id="note_info" cols="40" rows="4">${result.note_info!''}</textarea>
					</td>
			</tr>
		<tr>
			<td align="center" style="background-color:#FFFFFF;" colspan="2">
				<button type="submit">保存</button>&nbsp;
				<button type="button" onClick="history.go(-1)">返回</button>
			</td>
		</tr>
	</table>
</form>
</div>
</td></tr></table>