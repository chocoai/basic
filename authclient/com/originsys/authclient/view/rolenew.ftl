 <script src="${_share_file_url!''}/resource/js/jquery.validate.js" type="text/javascript"></script> 
 <script src="${_share_file_url!''}/resource/js/jquery.metadata.js" type="text/javascript"></script>
 <script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.message_zh.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/messages_cn.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<link type="text/css" rel="stylesheet" href="${_share_file_url!''}/resource/css/custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="${_share_file_url!''}/resource/css/cmxform.css" />

<script type="text/javascript">
$(document).ready(function() {
	$("#roleForm").validate({
		rules: {
			role_id: {
				required: true,
				minlength: 2,
				maxlength: 36,
				noCChar:true,
				remote: "${_servlet_url!''}/manager.role.isused"
			},
			role_name:{
			 required:true,
			 maxlength: 50
			 }
		},
		messages: {
			role_id: {
				required: "请输入角色ID",
				minlength: "角色ID最至少2个 字符",
				maxlength:"角色ID最长36个字符",
				noCChar:"角色ID不能含有汉字",
				remote:jQuery.format("{0} 已经被使用")
			},
			role_name: {
				required:"请输入角色名称",
				maxlength:"角色名称最长50个字符"
			}
		},
		submitHandler:function(form){
			var queryString=$("#roleForm").formSerialize();
			$.post($("#roleForm").attr("action"),queryString,
				function(data,textStatus){
				var jdata=jQuery.parseJSON(data);
		    	if(jdata.success=="1"){
		    		alert("保存成功");
		    		window.close();
		    	}else{
		    		alert("保存失败");
		    	}
			});
		}
	});
	jQuery.validator.addMethod("noCChar", 
		function(value){ 
			if(value=="")return true;				
			if(/.*[\u4e00-\u9fa5]+.*$/.test(value)){
				return false;
			}else{
				return true;
			}
		},"角色ID不能含有汉字"
	); 
	$("#select").click(function(){
		var types=window.showModalDialog("${_servlet_url!''}/manager.usertype.list","","dialogWidth:550px;dialogHeight:500px");
		if(null!=types){
			var type=types.split(",");
			if(type.length>0){
				$("#user_type").val(type[0]);
				$("#user_type_name").val(type[1]);
			}
		}
	});
});
function selPreRole(){
	var arr=window.showModalDialog("${_servlet_url!''}/manager.prerole.list","","dialogWidth:500px;dialogHeight:500px");
	if(arr!=null&&arr!=undefined){
		if(arr.length==2){
				var role_id=arr[0];
				var role_name=arr[1];
				$("#prepositive_role").val(role_id);
				$("#pre_role_name").val(role_name);
		}
	}
}
function clearprerole(){
	$("#prepositive_role").val("");
	$("#pre_role_name").val("");
}
</script>
<div class="${system.skin}" style="width:100%">

<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px"><img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>&nbsp;新建角色
	</div>
	<form class="cmxform" style="margin:0" action="${_servlet_url!''}/authclient.role.insert" method="post" id="roleForm">
	<input type="hidden" name="role_code" value="">
	<div  id="buttons" style="text-align:right">
		<button type="submit">保存</button>
	</div>
	<div class="ui-widget-content"  style="position: relative;padding: .2em;">	
	<table  width="100%">
		<tr>
			<td class="detail_attname">角色ID</td>
			<td class="detail_value"><input type="text" id="role_id" size=15 name="role_id"  class="required"></td>
		</tr>
		<tr>
			<td class="detail_attname">角色名称</td>
			<td class="detail_value"><input type="text" id="role_name" size=15 name="role_name"  class="required"></td>
		</tr>
		<tr>
			<td class="detail_attname">是否可申请</td>
			<td class="detail_value">
			<input type="radio" name="isrequest" value="1" checked>是 
			<input type="radio" name="isrequest" value="0">否
			</td>
		</tr>
		<tr>
			<td class="detail_attname">是否用户注册时可申请</td>
			<td class="detail_value">
				<input type="radio" name="is_register_request" value="1" checked/>是
				<input type="radio" name="is_register_request" value="0"/>否
			</td>
		</tr>
		<tr>
			<td class="detail_attname">是否审核</td>
			<td class="detail_value">
			<input type="radio" name="ischeck" value="1">是 
			<input type="radio" name="ischeck" checked value="0">否
			<input type="hidden" size="15" name="issys" value="0" >
			</td>
		</tr>
		<tr>
			<td class="detail_attname">前置角色</td>
			<td class="detail_value">
			<input type="text" id="pre_role_name" size="15" readonly="true" name="pre_role_name" onclick="selPreRole();">
			<input type="hidden" id="prepositive_role" size=15 name="prepositive_role">
			<button type="button" onclick="clearprerole();">清空前置角色</button>
			</td>
		</tr>
		<tr>
			<td class="detail_attname">绑定用户类型</td>
			<td class="detail_value"><input type="hidden" id="user_type" name="user_type"/>
				<input type="text" id="user_type_name" name="user_type_name" readonly="true"/>
				<button type="button" id="select">选择</button>
			</td>
		</tr>
		<tr>
			<td class="detail_attname">绑定企业类型</td>
			<td class="detail_value">
				<select name="organ_type_id" id="organ_type_id">
					<option value="">请选择</option>
					[#list block.orgcomtype_list as orgtype]
					<option value="${orgtype.organ_type_id!''}">${orgtype.organ_type_cname!''}</option>
					[/#list]
				</select>
			</td>
		</tr>
		<tr>
			<td class="detail_attname">安全加强认证方式</td>
			<td class="detail_value">
				<select name="security_auth" id="security_auth">]
					<option value="">请选择</option>
					<option value="dynamic_pass">动态口令</option>
				</select>
			</td>
		</tr>
		<tr>
			<td class="detail_attname">角色说明</td>
			<td colspan=3 class="detail_value"><textarea rows="4" cols="70" name="role_description"></textarea></td>
		</tr>
	</table>	
	</div>
	</form>
</div>