<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/card.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/swfobject.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="${_share_file_url!''}/resource/css/cmxform.css" />
<script language="javascript" type="text/javascript">
$(function(){
	//日期选择:
	$("#mem_born").attr("readonly", "true").datepicker({changeMonth: true,changeYear: true, yearRange: '-100:-18',dateFormat:"yy-mm-dd"});
	//对增加的内容进行验证
	$("#addForm").validate({
		rules: {
			mem_name:{
				required:true,
				isName:true,
				remote:"${_servlet_url!''}/auth.isused"
			},
			mem_pass:{
				required:true,
				minlength: 6
			},
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
			mem_name:{
				required:"请输入用户名",
				isName:"请正确输入用户名",
				remote:"该用户名已注册"
			},
			mem_pass:{
				required:"请输入登录密码",
				minlength: "登录密码至少6位"
			},
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
			var queryString=$("#addForm").formSerialize();
			$.post($("#addForm").attr("action"),queryString,
				function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="1"){
						alert("增加成功！");
						window.close();				
					}else if(jdata.success=="2"){
						alert("操作失败，用户登录名已存在！");
						window.close();
					}else{
						alert("操作失败！");
						window.close();
					}
			});
		}
	});
	// 身份证号码验证 
	jQuery.validator.addMethod("isIdCardNo", function(value, element) { 
	  return this.optional(element) || idCardNoUtil.checkIdCardNo(value);     
	}, "请正确输入您的身份证号码"); 
	//用户登录名验证，只能是字母或是数字
	jQuery.validator.addMethod("isName", function(value, element) { 
	  var b = /^[0-9a-zA-Z]*$/g;
	  return b.test(value);  
	}, "请正确输入用户名");
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
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;用户基本信息
	</div>
	<form class="cmxform" style="margin:0" action="${_servlet_url!''}/auth.admin.userInfoadd" method="post" id="addForm">
		<input id="res" name="res" type="reset" style="display:none;" />
		<table width="100%" border="0" cellpadding="0" cellspacing="1" style="table-layout:fixed;line-height:30px;">
		<col width="100px"/><col />
		<tr>
			<td class="rightpad" style="vertical-align:top;"><font color="red">*</font>用户名</td>
			<td class="leftpad">
				<input type="text" name="mem_name" id="mem_name" value=""/>
				<br><font color="grey">用户名为系统登录用户名,请使用字符、数字等有效字符</font>
			</td>
		</tr>
		<!--tr>
			<td class="rightpad"><font color="red">*</font>登录密码</td>
			<td class="leftpad">
				<input type="text" name="mem_pass" id="mem_pass" value=""/>
			</td>
		</tr -->
		<tr>
			<td class="rightpad">姓名</td>
			<td class="leftpad">
				<input type="text" name="family_name" id="family_name" value=""/>
				<input type="hidden" name="first_name" id="first_name" value=""/>
			</td>
		</tr>
		<!--tr>
			<td class="rightpad">名</td>
			<td class="leftpad">
				<input type="text" name="first_name" id="first_name" value=""/>
			</td>
		</tr-->
		<tr>
			<td class="rightpad">性别</td>
			<td class="leftpad">
				<select name="mem_sex" id="mem_sex"/>
				[#list EnumService.getEnum('sex') as enum]
				<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
				[/#list]
				</select>
			</td>
		</tr>
		<tr>
			<td class="rightpad">身份证号</td>
			<td class="leftpad">
				<input type="text" name="ID_num" id="ID_num" value="" onblur="chengeBirthday();"/>
			</td>
		</tr>
		<!-- tr>
			<td class="rightpad">动态令牌号</td>
			<td class="leftpad">
				<input type="text" name="token_id" id="token_id" value=""/>
			</td>
		</tr -->
		<tr>
			<td class="rightpad">生日</td>
			<td class="leftpad">
				<input type="text" name="mem_born" id="mem_born" value=""/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">邮址</td>
			<td class="leftpad">
				<input type="text" name="mem_mail" id="mem_mail" value=""/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">手机</td>
			<td class="leftpad">
				<input type="text" name="mem_mphone" id="mem_mphone" value=""/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">居住区域</td>
			<td class="leftpad">
				<input type="hidden" name="mem_region" id="mem_region" value=""/>
				<input type="text" name="mem_region_name" id="mem_region_name" value="" readonly="true" onclick="addr1();"/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">地址</td>
			<td class="leftpad">
				<input type="text" name="mem_addr" id="mem_addr" value=""/>
			</td>
		</tr>
		<tr>
			<td class="rightpad">备注信息</td>
			<td class="leftpad">
				<textarea name="note_info" id="note_info" cols="30" rows="4"></textarea>
			</td>
		</tr>		
		<tr>
			<td align="center" style="background-color:#FFFFFF;" colspan="2">
				<button type="submit">提交</button>&nbsp;
				<button type="button" onClick="window.close();">返回</button>
			</td>
		</tr>
	</table>
	</form>
</div>