<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script language="javascript" type="text/javascript">			
$(function(){
	$("#mem_born").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
	$("#join_in_time").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
	$("#search").click(function(){
		$("#updateForm").submit();
	});		
	$("#dialog").dialog({
		resizable:false,
		height:350,
		width:600,
		autoOpen:false,
		modal:true,
		buttons:{
			'取消':function(){
				$(this).dialog('close');
			},
			'确定':function(){
				$("#addForm").submit();
			}
		}
	});
	//对增加的内容进行验证
	$("#addForm").validate({
		submitHandler:function(form){
			var queryString=$("#addForm").formSerialize();
			$.post($("#addForm").attr("action"),queryString,
				function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="0"){
						alert("操作失败！");
						$("#dialog").dialog('close');
					}else if(jdata.success=="1"){
						//增加成功
						alert("组织加入成功,请等待管理员审核!");
						$("#dialog").dialog('close');
					}else{
						//已经加入
						alert("已经加入该组织!");
						$("#dialog").dialog('close');
					}
			});
		}
	});
});
//增加按钮
function joinorg(obj){
	$("#organ_id").val(obj);
	$("#dialog").dialog('open');
}
</script>
<style>
.td2{text-align:right;padding-right:12px;background-color:#F1F8FF;color:#4D4D4D;}
.td3{padding-left:12px;background-color:#fff;}
</style>
<table style="width:100%" border="0">
<tr><td width="200" valign="top">
[#global web=JspTaglibs["/WEB-INF/eap.tld"]]
[@web.block  site_id="eap2" action_id="auth.personalinfo" component_id="auth"/]
</td><td valign="top">
<div class="ui-widget ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;加入组织
	</div>
</div>
<div class="ui-widget ui-widget-content" style="minHeight:300px;">
	<form class="cmxform" style="margin:0" action="${_servlet_url!''}/auth.joinorgcom" method="post" id="updateForm">
		<table width="96%" border="0" cellpadding="0" cellspacing="1" style="table-layout:fixed;" align="center">
		<tr>
		<td>
			<b>组织名称&nbsp;:</b>&nbsp;&nbsp;<input type="text" size="30" name="organ_name" id="organ_name"/>
			&nbsp;&nbsp;<button type="button" id="search">搜索</button>
			&nbsp;&nbsp;<button type="button" onclick="javascript:window.open('${_servlet_url!''}/auth.orgcomregister');">新组织注册</button>
		</td>
		</tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="1" style="table-layout:fixed;line-height:30px;">
		[#list block.resultList as orgcom]
		<tr class="odd">
			<td>${orgcom.organ_name!''}</td><td>${orgcom.organ_address!''}</td>
			<td><button type="button" onclick="joinorg('${orgcom.organ_id!''}');">加入组织</button></td>
		</tr>
		[/#list]
		</table>
	</form>
</div>
</td></tr></table>
<div id="dialog" title="加入组织" style="display:none">
	<form class="cmxform" style="margin:0" action="${_servlet_url!''}/auth.dojoinorgcom" method="post" id="addForm">
		<input type="hidden" name="organ_id" id="organ_id" value="">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
			<tr >
				<td class="td2" align="right" style="padding-right:2px">真实姓名</td>
				<td class="td3" style="padding-left:2px">
					姓：<input type="text" name="family_name" id="family_name" value="${block.userinfo.family_name!''}" size="4"/>
					名：<input type="text" name="first_name" id="first_name" value="${block.userinfo.first_name!''}" size="10"/>
				</td>
			</tr>
			<tr >
				<td class="td2" align="right" style="padding-right:2px">性别</td>
				<td class="td3" style="padding-left:2px">
					<!--<input type="text" name="mem_sex" id="mem_sex" value="${block.userinfo.mem_sex!''}" style="width:200px"/>-->
					<select name="mem_sex" id="mem_sex"/>
					<option value="">请选择</option>
					[#list EnumService.getEnum('sex') as enum]
					<option value="${enum.enum_value!''}"  [#if "${block.userinfo.mem_sex!''}"="${enum.enum_value!''}"]selected=true[/#if] >${enum.enum_name!''}</option>
					[/#list]
					</select>
				</td>
			</tr>
			<tr >
				<td class="td2" align="right" style="padding-right:2px">出生日期</td>
				<td class="td3" style="padding-left:2px">
					<input type="text" name="mem_born" id="mem_born" [#if block.userinfo.mem_born?exists]value="${block.userinfo.mem_born?string('yyyy-MM-dd')}"[#else]value=""[/#if]style="width:200px"/>
				</td>
			</tr>
			<tr>
				<td class="td2" align="right" style="padding-right:2px">入职时间</td>
				<td class="td3" style="padding-left:2px">
					<input type="text" name="join_in_time" id="join_in_time" style="width:200px"/>
				</td>
			</tr>
			<tr>
				<td class="td2" align="right" style="padding-right:2px">备注信息</td>
				<td class="td3" style="padding-left:2px">
					<textarea cols="30" rows="4" id="note" name="note"></textarea>
				</td>
			</tr>
		</table>
	</form>
</div>
