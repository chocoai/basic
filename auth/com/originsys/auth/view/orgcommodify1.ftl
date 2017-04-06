<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/messages_cn.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="${_share_file_url!''}/resource/css/cmxform.css" />
<script language="javascript" type="text/javascript">
$(function(){
	$("#updateForm").validate({
		[#if "${resultMap.result.authentication_state!''}"!="1"]
		rules: {
			organ_name: {
				required: true
			},
			organ_code1: {
				number:true,
				maxlength:8,
				minlength:8
			},
			organ_code2: {
				number:true,
				maxlength:1,
				minlength:1
			},
			token_id:{
				number:true,
				maxlength:13,
				minlength:13
			}
		},
		messages: {
			organ_name: {
				required: "请输入单位法定全称"
			},
			organ_code1: {
				number:"请输入8位数字",
				maxlength:"请输入8位数字",
				minlength:"请输入8位数字"
			},
			organ_code2: {
				number:"请输入1位数字",
				maxlength:"请输入1位数字",
				minlength:"请输入1位数字"
			},
			token_id:{
				number:"请输入13位数字",
				maxlength:"请输入13位数字",
				minlength:"请输入13位数字"
			}
		},
		[/#if]
	    //提交
        submitHandler:function(form){
       		var queryString=$("#updateForm").formSerialize();
			$.post($("#updateForm").attr("action"),queryString,
				function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success==1){
						alert("修改成功！");
					}else{
						alert("修改失败！");
					}
			});
       } 
	});
});



function addr1(){
	var addr=window.showModalDialog("commonservice.region?pid=086","","dialogWidth=350px;dialogHeight=400px");
	if(addr!=undefined){
		$("#organ_region_name").val(addr[1]);
		$("#organ_region").val(addr[0]);
	}
}
function returnvalue(id,data){
	document.getElementById(id).value=data;
}
function viewpic(filename){
	window.open($("#"+filename).val());
}
</script>
<style>
.rightpad{text-align:right;padding-right:7px;background-color:#F2F9FF;}
.leftpad{padding-left:2px;background-color:#FFFFFF;}
</style>
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;修改单位信息
	</div>
<form class="cmxform" style="margin:0" action="${_servlet_url!''}/auth.orgcomupdate" method="post" id="updateForm">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" style="line-height:30px;table-layout:fixed;"> 
		<col  width="200px"/></col />
			<tr>
					<input type="hidden" name="organ_id" id="organ_id" value="${resultMap.result.organ_id!''}"/>
			</tr>
			<tr>
					<td class="rightpad">
					[#if "${resultMap.result.authentication_state!''}"=="1"]<font color="red">*</font>[/#if]
					单位法定全称</td>
					<td class="leftpad">
						[#if "${resultMap.result.authentication_state!''}"=="1"] 
							${resultMap.result.organ_name!''}
						[#else]	
							<input type="text" name="organ_name" id="organ_name" value="${resultMap.result.organ_name!''}" size="40"/>
						[/#if]
					</td>
			</tr>
			<tr>
				<td class="rightpad">[#if "${resultMap.result.authentication_state!''}"=="1"]<font color="red">*</font>[/#if]使用动态令牌</td>
				<td class="leftpad">
					[#if "${resultMap.result.authentication_state!''}"=="1"]
					[#if "${resultMap.result.use_token!''}"=="1"]使用[#else]不使用[/#if]
					[#else]	
					<input type="radio" name="use_token" id="use_token" value="1" [#if "${resultMap.result.use_token!''}"=="1"]checked[#else][/#if]/>使用
					<input type="radio" name="use_token" id="use_token" value="0" [#if "${resultMap.result.use_token!''}"=="1"][#else]checked[/#if]/>不使用
					<font color="grey">&nbsp;如果选择使用则登录的时候需要输入动态口令</font>
					[/#if]
				</td>
			</tr>
			<tr>
				<td class="rightpad">[#if "${resultMap.result.authentication_state!''}"=="1"]<font color="red">*</font>[/#if]动态令牌号</td>
				<td class="leftpad">
					[#if "${resultMap.result.authentication_state!''}"=="1"]
					[#if "${resultMap.result.use_token!''}"=="1"]${resultMap.result.token_id!''}[/#if]
					[#else]	
					<input type="text" name="token_id" id="token_id" value="${resultMap.result.token_id!''}"/>
					[/#if]
				</td>
			</tr>
			<tr>
					<td class="rightpad">[#if "${resultMap.result.authentication_state!''}"=="1"]<font color="red">*</font>[/#if]组织机构代码</td>
					<td class="leftpad">
						[#if "${resultMap.result.authentication_state!''}"=="1"] 
						${resultMap.organ_code1!''}-${resultMap.organ_code2!''}
						<input type="hidden" name="organ_code1" id="organ_code1" value="${resultMap.organ_code1!''}"/>
						<input type="hidden" name="organ_code2" id="organ_code2" value="${resultMap.organ_code2!''}"/>
						[#else]	
						<input type="text" name="organ_code1" id="organ_code1" value="${resultMap.organ_code1!''}" size="8" maxlength="8"/>
							- <input type="text" name="organ_code2" id="organ_code2" value="${resultMap.organ_code2!''}" size="1" maxlength="1"/>
						[/#if]
					</td>
			</tr>
			<tr>
					<td class="rightpad">[#if "${resultMap.result.authentication_state!''}"=="1"]<font color="red">*</font>[/#if]组织机构代码证</td>
					<td class="leftpad">
						[#if "${resultMap.result.authentication_state!''}"=="1"] 
						[#if "${resultMap.result.organ_code_image!''}"!=""]
						<img src="${resultMap.result.organ_code_image!''}" height="100px" width="200px;">
						<a href="#" onclick="javascript:window.open('${resultMap.result.organ_code_image!''}');">查看大图</a>
						[/#if]
						[#else]	
						<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="300" height="35">
							<param name="movie" value="${_share_file_url!''}/resource/jsp/fileupload.swf" />
								<param name="flashvars" value="action=${_server_url!''}/eap/manager.system.upload&fieldname=organ_code_image&oldname=${resultMap.result.organ_code_image!''}&savepath=images/orgcom/&type=image&size=5242880" />
								<param name="menu" value="false" /><param name="wmode" value="transparent" />
								<embed src="${_share_file_url!''}/resource/jsp/fileupload.swf" wmode="transparent" flashvars="action=${_server_url!''}/eap/manager.system.upload&savepath=images/orgcom/&fieldname=organ_code_image&type=image&oldname=${resultMap.result.organ_code_image!''}&size=5242880" menu="false" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="300" height="35">
							</embed>
						</object>
						<font color="grey">上传附件大小不能超过5M</font>						
						[/#if]
					</td>
			</tr>
			<input type="hidden" name="business_license_image" id="business_license_image" value="${resultMap.result.business_license_image!''}">
			<input type="hidden" name="tax_reg_certificate" id="tax_reg_certificate" value="${resultMap.result.tax_reg_certificate!''}">
			<tr>
					<td class="rightpad">营业执照</td>
					<td class="leftpad">
						[#if "${resultMap.result.authentication_state!''}"=="1"] 
						[#if "${resultMap.result.business_license_image!''}"!=""]
						<img src="${resultMap.result.business_license_image!''}" height="100px" width="200px;">
						<a href="#" onclick="javascript:window.open('${resultMap.result.business_license_image!''}');">查看大图</a>
						[/#if]
						[#else]	
						<input type="hidden" name="business_license_image" id="business_license_image" value="${resultMap.result.business_license_image!''}">
						<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="300" height="35">
							<param name="movie" value="${_share_file_url!''}/resource/jsp/fileupload.swf" />
								<param name="flashvars" value="action=${_server_url!''}/eap/manager.system.upload&fieldname=business_license_image&oldname=${resultMap.result.business_license_image!''}&savepath=images/orgcom/&type=image" />
								<param name="menu" value="false" /><param name="wmode" value="transparent" />
								<embed src="${_share_file_url!''}/resource/jsp/fileupload.swf" wmode="transparent" flashvars="action=${_server_url!''}/eap/manager.system.upload&savepath=images/orgcom/&fieldname=business_license_image&type=image&oldname=${resultMap.result.business_license_image!''}" menu="false" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="300" height="35">
							</embed>
						</object>
						[/#if]
					</td>
			</tr>
			<tr>
					<td class="rightpad">税务登记证</td>
					<td class="leftpad">
						[#if "${resultMap.result.authentication_state!''}"=="1"] 
						[#if "${resultMap.result.tax_reg_certificate!''}"!=""]
						<img src="${resultMap.result.tax_reg_certificate!''}" height="100px" width="200px;">
						<a href="#" onclick="javascript:window.open('${resultMap.result.tax_reg_certificate!''}');">查看大图</a>
						[/#if]
						[#else]	
						<input type="hidden" name="tax_reg_certificate" id="tax_reg_certificate" value="${resultMap.result.tax_reg_certificate!''}">
						<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="300" height="35">
							<param name="movie" value="${_share_file_url!''}/resource/jsp/fileupload.swf" />
								<param name="flashvars" value="action=${_server_url!''}/eap/manager.system.upload&fieldname=tax_reg_certificate&oldname=${resultMap.result.tax_reg_certificate!''}&savepath=images/orgcom/&type=image" />
								<param name="menu" value="false" /><param name="wmode" value="transparent" />
								<embed src="${_share_file_url!''}/resource/jsp/fileupload.swf" wmode="transparent" flashvars="action=${_server_url!''}/eap/manager.system.upload&savepath=images/orgcom/&fieldname=tax_reg_certificate&type=image&oldname=${resultMap.result.tax_reg_certificate!''}" menu="false" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="300" height="35">
							</embed>
						</object>
						[/#if]
					</td>
			</tr>
			<tr>
					<td class="rightpad">所属行政区</td>
					<td class="leftpad">
						<input type="text" name="organ_region_name" id="organ_region_name" value="${resultMap.result.organ_region_name!''}" onclick="addr1();" readonly="true" size="40"/>
						<input type="hidden" name="organ_region" id="organ_region" value="${resultMap.result.organ_region!''}"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">通信地址</td>
					<td class="leftpad">
							<input type="text" name="organ_address" id="organ_address" value="${resultMap.result.organ_address!''}" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">联系人</td>
					<td class="leftpad">
							<input type="text" name="organ_linkman" id="organ_linkman" value="${resultMap.result.organ_linkman!''}" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">电话</td>
					<td class="leftpad">
							<input type="text" name="organ_phone" id="organ_phone" value="${resultMap.result.organ_phone!''}" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">邮政编码</td>
					<td class="leftpad">
							<input type="text" name="organ_postcode" id="organ_postcode" value="${resultMap.result.organ_postcode!''}" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">域名｜ip</td>
					<td class="leftpad">
							<input type="text" name="organ_domainname" id="organ_domainname" value="${resultMap.result.organ_domainname!''}" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">行业</td>
					<td class="leftpad">
							<input type="text" name="organ_trade" id="organ_trade" value="${resultMap.result.organ_trade!''}" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">组织简介</td>
					<td class="leftpad">
							<input type="text" name="organ_desc" id="organ_desc" value="${resultMap.result.organ_desc!''}" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">组织类型</td>
					<td class="leftpad">
							<input type="text" name="organ_type" id="organ_type" value="${resultMap.result.organ_type!''}" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">员工人数</td>
					<td class="leftpad">
							<input type="text" name="organ_staff_number" id="organ_staff_number" value="${resultMap.result.organ_staff_number!''}" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">组织证件类型</td>
					<td class="leftpad">
							<input type="text" name="organ_cred_type" id="organ_cred_type" value="${resultMap.result.organ_cred_type!''}" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">组织证件号码</td>
					<td class="leftpad">
							<input type="text" name="organ_cred_code" id="organ_cred_code" value="${resultMap.result.organ_cred_code!''}" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">认证状态</td>
					<td class="leftpad">
						[#if "1"=="${result.authentication_state!''}"]"通过"[#else]"未通过"[/#if]
						<input type="hidden" name="authentication_state" id="authentication_state" value="${resultMap.result.authentication_state!''}" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">第二域名</td>
					<td class="leftpad">
							<input type="text" name="organ_domainname2" id="organ_domainname2" value="${resultMap.result.organ_domainname2!''}" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">企业类型</td>
					<td class="leftpad">
					[#list resultMap.typelist as orgcomtype]
						<input type="checkbox" name="com_type" value="${orgcomtype.organ_type_id!''}" [#if resultMap.orgtype_str?contains(",${orgcomtype.organ_type_id!''} ")]checked[/#if]/>${orgcomtype.organ_type_cname!''}
					[/#list]
					</td>
			</tr>
			<tr>
				<td align="center" style="background-color:#FFFFFF;" colspan="2">
					<button type="submit" id="updateInfo">提交</button>&nbsp;
					<button type="button" onClick="history.go(-1)">返回</button>
				</td>
			</tr>
	</table>
</form>
</div>