<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.pack.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/messages_cn.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<link type="text/css" rel="stylesheet" href="${_share_file_url!''}/resource/css/custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="${_share_file_url!''}/resource/css/cmxform.css" />
[#assign role=block.role]
<script type="text/javascript">
$(document).ready(function() {
	$("#roleForm").validate({
		rules: {
			role_name:{
			 required:true,
			 maxlength: 50
			 }
		},
		messages: {
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
	var arr=window.showModalDialog("${_servlet_url!''}/manager.prerole.list?role_id=${role.role_id}","","dialogWidth:500px;dialogHeight:500px");
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
	<form class="cmxform" style="margin:0" action="${_servlet_url!''}/authclient.role.update" method="post" id="roleForm">
	<div  id="buttons" style="text-align:right">
		<button type="submit">保存</button>
	</div>
	<div class="ui-widget-content"  style="position: relative;padding: .2em;">	
	<table  width="100%">
		<tr>
			<td class="detail_attname">角色名称</td>
			<td class="detail_value">
			<input type="text" id="role_name" size=15 name="role_name"  class="required" value="${role.role_name!''}">
			<input type="hidden" name="role_id" value="${role.role_id!''}">
			</td>
		</tr>
		<tr>
			<td class="detail_attname">是否可申请</td>
			<td class="detail_value">
			<input type="radio" name="isrequest" value="1" [#if "${role.isrequest!''}"=="1"] checked[/#if]>是 
			<input type="radio" name="isrequest" value="0" [#if "${role.isrequest!''}"!="1"] checked[/#if]>否
			</td>
		</tr>
		<tr>
			<td class="detail_attname">是否用户注册时可申请</td>
			<td class="detail_value">
				<input type="radio" name="is_register_request" value="1" [#if "${role.is_register_request!''}"=="1"]checked[/#if]/>是
				<input type="radio" name="is_register_request" value="0" [#if "${role.is_register_request!''}"=="0"]checked[/#if]/>否
			</td>
		</tr>
		<tr>
			<td class="detail_attname">是否审核</td>
			<td class="detail_value">
			<input type="radio" name="ischeck" value="1" [#if "${role.ischeck!''}"=="1"] checked[/#if]>是 
			<input type="radio" name="ischeck" value="0" [#if "${role.ischeck!''}"!="1"] checked[/#if]>否
			<input type="hidden" size="15" name="issys" value="${role.issys!'0'}" >
			</td>
		</tr>
		<tr>
			<td class="detail_attname">前置角色</td>
			<td class="detail_value">
			<input type="text" id="pre_role_name" size="15"  readonly="true" name="pre_role_name" value="${role.pre_role_name!''}" onclick="selPreRole();">
			<input type="hidden" id="prepositive_role" size=15 name="prepositive_role" value="${role.prepositive_role!''}">
			<button type="button" onclick="clearprerole();">清空前置角色</button>
			</td>
		</tr>
		<tr>
			<td class="detail_attname">绑定用户类型</td>
			<td class="detail_value"><input type="hidden" id="user_type" name="user_type" value="${role.user_type!''}"/>
				<input type="text" id="user_type_name" name="user_type_name" readonly="true" value="${role.list_action!''}"/>
				<button type="button" id="select">选择</button>
			</td>
		</tr>
		<tr>
			<td class="detail_attname">绑定企业类型</td>
			<td class="detail_value">
				<select name="organ_type_id" id="organ_type_id">
					<option value="" [#if "${role.organ_type_id!''}"==""]selected[/#if]>请选择</option>
					[#list block.orgcomtype_list as orgtype]
					<option value="${orgtype.organ_type_id!''}" [#if "${role.organ_type_id!''}"=="${orgtype.organ_type_id!''}"]selected[/#if]>${orgtype.organ_type_cname!''}</option>
					[/#list]
				</select>
			</td>
		</tr>
		<tr>
			<td class="detail_attname">安全加强认证方式</td>
			<td class="detail_value">
				<select name="security_auth" id="security_auth">]
					<option value="" [#if "${role.security_auth!''}"==""]selected[/#if]>请选择</option>
					<option value="dynamic_pass" [#if "${role.security_auth!''}"=="dynamic_pass"]selected[/#if]>动态口令</option>
				</select>
			</td>
		</tr>
		<tr>
			<td class="detail_attname">角色说明</td>
			<td colspan=3 class="detail_value">
			<textarea rows="4" cols="70" name="role_description">${role.role_description!''}</textarea>
			<input type="hidden" name="role_code" value="${role.role_code!''}">
			</td>
		</tr>
	</table>	
	</div>
	</form>
</div>