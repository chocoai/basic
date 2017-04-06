<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/messages_cn.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="${_share_file_url!''}/resource/css/cmxform.css" />
<script language="javascript" type="text/javascript">
$(function(){
	$("#join_in_time").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
	$("#addInfo").click(function(){
		var organ_code=$("#organ_code1").val()+"-"+$("#organ_code2").val();
		$.post("${_servlet_url!''}/auth.isused?organ_code="+organ_code,{random:Math.random()},
			function(data,textStatus){
				if(data=="true"){
					$("#updateForm").submit();
					/**var r = $('#updateForm').form('validate'); 
					if(r){
						$("#addInfo").attr("disabled","true");
					}*/
				}else{
					alert("组织机构代码已存在！");
				}
			});
		
	}); 
	$("#career1").hide();
	$("#enterp").hide();
	$("#orga").hide();
	$("#othe").hide();
	$("#updateForm").validate({
		rules: {
			organ_id : {
				required: true,
				isName:true,
				minlength:6,
				remote:"${_servlet_url!''}/auth.isused"
			},
			organ_name: {
				required: true
			},
			organ_code1: {
				isName:true,
				maxlength:8,
				minlength:8
			},
			organ_code2: {
				isName:true,
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
			organ_id : {
				required: "请输入单位ID",
				isName:"请正确输入单位ID",
				minlength:"单位ID至少6位",
				remote:"该单位ID已注册"
			},
			organ_name: {
				required: "请输入单位法定全称"
			},
			organ_code1: {
				isName:"请输入正确的代码证号",
				maxlength:"请输入正确的代码证号",
				minlength:"请输入正确的代码证号"
			},
			organ_code2: {
				isName:"请输入1位数字或字母",
				maxlength:"请输入1位数字",
				minlength:"请输入1位数字"
			},
			token_id:{
				number:"请输入13位数字",
				maxlength:"请输入13位数字",
				minlength:"请输入13位数字"
			}
		}
	});
	//单位ID验证，只能是字母或是数字
	jQuery.validator.addMethod("isName", function(value, element) { 
	  var b = /^[0-9a-zA-Z]*$/g;
	  return b.test(value);  
	}, "请正确输入单位ID");
});
function addr1(){
	var addr=window.showModalDialog("commonservice.region?pid=086","","dialogWidth=350px;dialogHeight=400px");
	if(addr!=undefined){
		$("#organ_region").val(addr[0]);
		$("#organ_region_name").val(addr[1]);
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
		&nbsp;单位注册
	</div>
<form class="cmxform" style="margin:0" action="${_servlet_url!''}/auth.doorgcomregister" method="post" id="updateForm">
	<!--input type="hidden" name="com.eap.token" id="com.eap.token" value="${request.getToken()!''}" /-->
	<input type="hidden" name="organ_pass" id="organ_pass" value="666666"/>
	<table width="100%" border="0" cellpadding="0" cellspacing="1" style="table-layout:fixed;line-height:30px;">
		<col width="200px"/></col />
			<tr>
					<td class="rightpad"><font color="red">*</font>单位ID</td>
					<td class="leftpad">
						<input type="text" name="organ_id" id="organ_id" value="" size="40"/>
						<font color="grey">&nbsp;单位ID为单位用户名，用户名使用字符、数字等有效字符。</font>
					</td>
			</tr>
			<!--tr>
					<td class="rightpad"><font color="red">*</font>登录密码</td>
					<td class="leftpad">
						<input type="password" name="organ_pass" id="organ_pass" value=""/>
					</td>
			</tr>
			<tr>
					<td class="rightpad"><font color="red">*</font>确认密码</td>
					<td class="leftpad">
						<input type="password" name="organ_pass2" id="organ_pass2" value=""/>
					</td>
			</tr-->
			<tr>
					<td class="rightpad"><font color="red">*</font>单位法定全称</td>
					<td class="leftpad">
						<input type="text" name="organ_name" id="organ_name" value="" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">组织机构代码</td>
					<td class="leftpad">
						<input type="text" name="organ_code1" id="organ_code1" value="" size="8" maxlength="8"/>
							- <input type="text" name="organ_code2" id="organ_code2" value="" size="1" maxlength="1"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">组织机构代码证</td>
					<td class="leftpad">
						<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="300" height="35">
							<param name="movie" value="${_share_file_url!''}/resource/jsp/fileupload.swf" />
								<param name="flashvars" value="action=${_server_url!''}/eap/manager.system.upload&fieldname=organ_code_image&oldname=&savepath=images/orgcom/&type=image&size=5242880" />
								<param name="menu" value="false" /><param name="wmode" value="transparent" />
								<embed src="${_share_file_url!''}/resource/jsp/fileupload.swf" wmode="transparent" flashvars="action=${_server_url!''}/eap/manager.system.upload&savepath=images/orgcom/&fieldname=organ_code_image&type=image&oldname=&size=5242880" menu="false" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="300" height="35">
							</embed>
						</object>
						<input type="hidden" name="organ_code_image" id="organ_code_image">
						<font color="grey">上传附件大小不能超过5M</font>
					</td>
			</tr>
			<input type="hidden" name="business_license_image" id="business_license_image">
			<input type="hidden" name="tax_reg_certificate" id="tax_reg_certificate">
			<tr>
					<td class="rightpad">营业执照</td>
					<td class="leftpad">
						<input type="hidden" name="business_license_image" id="business_license_image">
						<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="300" height="35">
							<param name="movie" value="${_share_file_url!''}/resource/jsp/fileupload.swf" />
								<param name="flashvars" value="action=${_server_url!''}/eap/manager.system.upload&fieldname=business_license_image&oldname=&savepath=images/orgcom/&type=image" />
								<param name="menu" value="false" /><param name="wmode" value="transparent" />
								<embed src="${_share_file_url!''}/resource/jsp/fileupload.swf" wmode="transparent" flashvars="action=${_server_url!''}/eap/manager.system.upload&savepath=images/orgcom/&fieldname=business_license_image&type=image&oldname=" menu="false" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="300" height="35">
							</embed>
						</object>
					</td>
			</tr>
			<tr>
					<td class="rightpad">税务登记证</td>
					<td class="leftpad">
						<input type="hidden" name="tax_reg_certificate" id="tax_reg_certificate">
						<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="300" height="35">
							<param name="movie" value="${_share_file_url!''}/resource/jsp/fileupload.swf" />
								<param name="flashvars" value="action=${_server_url!''}/eap/manager.system.upload&fieldname=tax_reg_certificate&oldname=&savepath=images/orgcom/&type=image" />
								<param name="menu" value="false" /><param name="wmode" value="transparent" />
								<embed src="${_share_file_url!''}/resource/jsp/fileupload.swf" wmode="transparent" flashvars="action=${_server_url!''}/eap/manager.system.upload&savepath=images/orgcom/&fieldname=tax_reg_certificate&type=image&oldname=" menu="false" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="300" height="35">
							</embed>
						</object>
					</td>
			</tr>
			<!-- tr>
				<td class="rightpad">使用动态令牌</td>
				<td class="leftpad">
					<input type="radio" name="use_token" id="use_token" value="1"/>使用
					<input type="radio" name="use_token" id="use_token" value="0" checked/>不使用
					<font color="grey">&nbsp;如果选择使用则登录的时候需要输入动态口令</font>
				</td>
			</tr>
			<tr>
				<td class="rightpad">动态令牌号</td>
				<td class="leftpad">
					<input type="text" name="token_id" id="token_id" value=""/>
					<font color="grey">&nbsp;请输入已购买的动态口令的令牌号，如需购买请联系主办单位</font>
				</td>
			</tr-->
			<tr>
					<td class="rightpad">所属行政区</td>
					<td class="leftpad">
						<input type="text" name="organ_region_name" id="organ_region_name" value="" onclick="addr1();" readonly="true" size="40"/>
							<input type="hidden" id="organ_region" name="organ_region" size="10">
					</td>
			</tr>
			<tr>
					<td class="rightpad">通信地址</td>
					<td class="leftpad">
						<input type="text" name="organ_address" id="organ_address" value="" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">联系人</td>
					<td class="leftpad">
						<input type="text" name="organ_linkman" id="organ_linkman" value="" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">电话</td>
					<td class="leftpad">
						<input type="text" name="organ_phone" id="organ_phone" value="" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">邮政编码</td>
					<td class="leftpad">
						<input type="text" name="organ_postcode" id="organ_postcode" value="" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">域名｜ip</td>
					<td class="leftpad">
						<input type="text" name="organ_domainname" id="organ_domainname" value="" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">行业</td>
					<td class="leftpad">
						<input type="text" name="organ_trade" id="organ_trade" value="" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">组织简介</td>
					<td class="leftpad">
						<input type="text" name="organ_desc" id="organ_desc" value="" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">组织类型</td>
					<td class="leftpad">
						<input type="text" name="organ_type" id="organ_type" value="" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">员工人数</td>
					<td class="leftpad">
						<input type="text" name="organ_staff_number" id="organ_staff_number" value="" size="40"/>
					</td>
			</tr>
			
			<tr>
					<td class="rightpad">组织证件类型</td>
					<td class="leftpad">
						<input type="text" name="organ_cred_type" id="organ_cred_type" value="" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">组织证件号码</td>
					<td class="leftpad">
						<input type="text" name="organ_cred_code" id="organ_cred_code" value="" size="40"/>
					</td>
			</tr>
			<input type="hidden" name="authentication_state" id="authentication_state" value="0"/>
			<tr>
					<td class="rightpad">第二域名</td>
					<td class="leftpad">
						<input type="text" name="organ_domainname2" id="organ_domainname2" value="" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">入职时间</td>
					<td class="leftpad">
						<input type="text" name="join_in_time" id="join_in_time" value="" size="40"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">备注</td>
					<td class="leftpad">
						<input type="text" name="note" id="note" value="" size="40"/>
					</td>
			</tr>
			<tr>
				<td class="rightpad">企业类型</td>
				<td class="leftpad">
					[#list block as orgcomtype]
					<input type="checkbox" name="com_type" value="${orgcomtype.organ_type_id!''}"/>${orgcomtype.organ_type_cname!''}
					[/#list]
				</td>				
			</tr>	
			<tr>
				<td align="center" style="background-color:#FFFFFF;" colspan="2">
					<button type="button" id="addInfo">提交</button>&nbsp;
					<button type="button" onClick="history.go(-1)">返回</button>
				</td>
			</tr>
		</table>

</form>
</div>
<script language="javascript" type="text/javascript">
	[#if session.getAttribute("regcom_error")?exists]
	[#assign error="${session.getAttribute('regcom_error')!''}"]
		[#if "${error}"=="1"]alert("此单位ID已注册！");[/#if]
		[#if "${error}"=="2"]alert("单位注册出错!");[/#if]
		[#if session.getAttribute("orgcom")?exists&&session.getAttribute("organcomparam")?exists]
			[#assign orgcom=session.getAttribute("orgcom")]
			[#assign organcomparam=session.getAttribute("organcomparam")]
			$("#organ_id").val("${orgcom.organ_id!''}");
			$("#organ_name").val("${orgcom.organ_name!''}");
			$("#token_id").val("${orgcom.token_id!''}");
			$("#organ_address").val("${orgcom.organ_address!''}");
			$("#organ_linkman").val("${orgcom.organ_linkman!''}");
			$("#organ_phone").val("${orgcom.organ_phone!''}");
			$("#organ_postcode").val("${orgcom.organ_postcode!''}");
			$("#organ_region").val("${orgcom.organ_region!''}");
			$("#organ_region_name").val("${temp_map.organ_region_name!''}");
			$("#organ_code1").val("${temp_map.organ_code1!''}");
			$("#organ_code2").val("${temp_map.organ_code2!''}");
		[/#if]
	[/#if]
</script>