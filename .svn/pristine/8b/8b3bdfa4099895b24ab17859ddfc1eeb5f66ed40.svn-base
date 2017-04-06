<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
﻿<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/swfobject.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/ui.upload.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/nicEdit.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" language="javascript">
$(function(){	
	//照片上传
	$("#certificate").upload({
		width:60,
		height:60,
		type:"image"
	});
	//照片上传
	$("#signature").upload({
		width:60,
		height:60,
		type:"image"
	});	
	//表格
	jQuery("#clist1").jqGrid({
	   	url:'${_servlet_url!''}/safecheck.safeassessors.listjson',
		datatype: "json",
		width:600,
		height:300,
	   	colNames:[
			"mem_id"
			,"用户登录名"
			,"姓名"
			,"状态"
			,"注册时间"
			,"最后登录时间"
			,"工作年限"
			
	   	],
	   	colModel:[
			{name:'mem_id',index:'mem_id',sortable:true,hidden:true}
			,{name:'mem_name',index:'manage_scope',sortable:true,width:10}
			,{name:'fullname',index:'certificate_number',sortable:true,width:10}
			,{name:'isenable',index:'certificate_date',sortable:true,width:10}
			,{name:'register_time',index:'certificate',sortable:true,width:10}
			,{name:'last_time',index:'professional_titles',sortable:true,width:10}
			,{name:'work_years',index:'professional',sortable:true,width:10}
			
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname:'register_time',
	    viewrecords: true,
	    sortorder: "desc",
	    rownumbers:true,
	    caption:"安全鉴定员列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	//删除
	$("#deleteInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) {
			var flag=window.confirm("删除用户无法恢复，确认删除吗？");
			if(flag){
				var ret = jQuery("#clist1").jqGrid('getRowData',id);
				$.post("${_servlet_url!''}/safecheck.safeassessors.delete?mem_id="+ret.mem_id,"",
					function(data,textStatus){
						var jdata=jQuery.parseJSON(data);
						if(jdata.success=="1"){
							alert("删除成功！");
							jQuery("#clist1").trigger('reloadGrid');
						}else{
							alert("删除失败!!");
						}
					});
			}
		}else{
			alert("请选择一条记录！");
		}
	});
	//模糊查询
	jQuery("#gridReload").click(function() {
		var url="${_servlet_url!''}/safecheck.safeassessors.listjson"
						+"?mem_name="+$("#memname").val()
						+"&fullname="+$("#fullname").val()
						;
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2,page:1}).trigger("reloadGrid");
	});
	//增加按钮
	$("#addInfo").click(function(){
		$("#dialog").dialog('open');
	});
	$("#dialog").dialog({
		resizable:false,
		height:380,
		width:650,
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
			var message="";
			var familyname=$("#familyname").val();
			if(familyname==""||familyname.length>30){
				message+="姓必须输入且长度小于30个字符\n\r";
			}
			var firstname=$("#firstname").val();
			if(firstname==""||firstname.length>30){
				message+="名必须输入且长度小于30个字符\n\r";
			}
			//验证手机号
			var isPhone=/^13[0-9]{9}$|15[0-9]{9}$|18[0-9]{9}$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/i;
			if($("#mem_mphone").val()!=''&&!isPhone.test($("#mem_mphone").val())){
				message+="手机号格式不正确\n\r";
			}
			var startTime=$("#birthday").val();
			if(startTime!=""){
				var ed=new Date();
				re = /-/g;
				var sd=new Date(Date.parse(startTime.replace(re, "/")));
				if(sd>ed){
					message+="出生日期不能大于当前日期\n\r";
				}
			}
			var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			if($("#mem_mail").val()!=''&&!reg.test($("#mem_mail").val())){
				message+="邮箱格式不正确\n\r";
			}
			if($("#department_name").val()=="")
				message+="所属机构不能为空"+"\n\r";	
			var startTime1=$("#certificate_date").val();
			if(startTime1!=""){
				var ed=new Date();
				re = /-/g;
				var sd=new Date(Date.parse(startTime1.replace(re, "/")));
				if(sd>ed){
					message+="证书取得时间不能大于当前日期\n\r";
				}
			}
			var regu=/^(0|[1-9][0-9]*)$/;//验证零和非零开头的数字
			if($("#work_years").val()!=''&&!regu.test($("#work_years").val())){
				message+="工作年限填写不正确\n\r";
			}
			var username=$("#username").val();
			if(username==""){
				message="用户名不能为空"+"\n\r"+message;
				alert(message);
				return false;
			}else{
				$.post("${_servlet_url!''}/manager.site.isused?username="+username,"",
				function(data,textStatus){
					if(data!=true)
					{
						message="用户名被占用"+"\n\r"+message;
						alert(message);
					}else{
						if(message!=""){
							alert(message);
						}else{
							var queryString=$("#addForm").formSerialize();
							$.post($("#addForm").attr("action"),queryString,
								function(data,textStatus){
									var jdata=jQuery.parseJSON(data);
									if(jdata.success=="0"){
										alert("安全鉴定员增加失败！");
									}else{
										alert("安全鉴定员增加成功！");
										jQuery("#clist1").trigger("reloadGrid");
										$("#dialog").dialog('close');
									}
							});
						}
					}
				},"json");
			}
		}
	});
	//更新
	$("#updateInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			$.post("${_servlet_url!''}/safecheck.safeassessors.forupdate1?mem_id="+ret.mem_id,"",
				function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					$("#mem_id",$("#updateForm")).val(jdata.mem_id);
					$("#username",$("#updateForm")).val(jdata.mem_name);
					$("#familyname",$("#updateForm")).val(jdata.family_name);
					$("#firstname",$("#updateForm")).val(jdata.firstname);
					$("#mem_sex",$("#updateForm")).val(jdata.mem_sex);
					$("#mem_mphone",$("#updateForm")).val(jdata.mem_mphone);
					$("#birthday",$("#updateForm")).val(jdata.mem_born);
					$("#mem_mail",$("#updateForm")).val(jdata.mem_mail);
					$("#department_name",$("#updateForm")).val(jdata.department_name);
					$("#department_id",$("#updateForm")).val(jdata.department_id);
					$("#certificate1").val(jdata.certificate);
					$("#certificate_number",$("#updateForm")).val(jdata.certificate_number);
					$("#certificate_date",$("#updateForm")).val(jdata.certificate_date);
					$("#professional_titles",$("#updateForm")).val(jdata.professional_titles);
					$("#work_years",$("#updateForm")).val(jdata.work_years);
					$("#professional",$("#updateForm")).val(jdata.professional);
					$("#signature1").val(jdata.signature);
					//照片上传
					$("#certificate1").upload({
						width:60,
						height:60,
						type:"image"
					});
					//照片上传
					$("#signature1").upload({
						width:60,
						height:60,
						type:"image"
					});	
				});
			
			$("#dialogupdate").dialog('open');
		}else{
			alert("请选择一条记录！");
		}
	});
	$("#dialogupdate").dialog({
		resizable:false,
		height:380,
		width:650,
		autoOpen:false,
		modal:true,
		buttons:{
			'取消':function(){
				$(this).dialog('close');
				//window.location.reload();
			},
			'确定':function(){
				$("#updateForm").submit();
				//window.location.reload();
			}
		}
	});
	//对修改的内容进行验证
	$("#updateForm").validate({
		submitHandler:function(form){
			var message="";
			var familyname=$("#familyname",$("#updateForm")).val();
			if(familyname==""||familyname.length>30){
				message+="姓必须输入且长度小于30个字符\n\r";
			}
			var firstname=$("#firstname",$("#updateForm")).val();
			if(firstname==""||firstname.length>30){
				message+="名必须输入且长度小于30个字符\n\r";
			}
			//验证手机号
			var isPhone=/^13[0-9]{9}$|15[0-9]{9}$|18[0-9]{9}$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/i;
			if($("#mem_mphone",$("#updateForm")).val()!=''&&!isPhone.test($("#mem_mphone",$("#updateForm")).val())){
				message+="手机号格式不正确\n\r";
			}
			var startTime=$("#birthday",$("#updateForm")).val();
			if(startTime!=""){
				var ed=new Date();
				re = /-/g;
				var sd=new Date(Date.parse(startTime.replace(re, "/")));
				if(sd>ed){
					message+="出生日期不能大于当前日期\n\r";
				}
			}
			var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			if($("#mem_mail",$("#updateForm")).val()!=''&&!reg.test($("#mem_mail",$("#updateForm")).val())){
				message+="邮箱格式不正确\n\r";
			}
			if($("#department_name",$("#updateForm")).val()=="")
				message+="所属机构不能为空"+"\n\r";	
			var startTime1=$("#certificate_date",$("#updateForm")).val();
			if(startTime1!=""){
				var ed=new Date();
				re = /-/g;
				var sd=new Date(Date.parse(startTime1.replace(re, "/")));
				if(sd>ed){
					message+="证书取得时间不能大于当前日期\n\r";
				}
			}
			var regu=/^(0|[1-9][0-9]*)$/;//验证零和非零开头的数字
			if($("#work_years",$("#updateForm")).val()!=''&&!regu.test($("#work_years",$("#updateForm")).val())){
				message+="工作年限填写不正确\n\r";
			}
			if(message!=""){
				alert(message);
				return false;
			}
			var queryString=$("#updateForm").formSerialize();
			$.post($("#updateForm").attr("action"),queryString,
				function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="0"){
						alert("安全鉴定员修改失败！");
					}else{
						alert("安全鉴定员修改成功！");
						jQuery("#clist1").trigger("reloadGrid");
						$("#dialogupdate").dialog('close');
					}
			});
		}
	});
	$("#department_name",$("#addForm")).click(function(){
		 var str =window.showModalDialog("commonservice.department.dialog?com_id=1","","dialogWidth:400px;dialogHeight:500px");
		 if(str!=null&&str!=undefined){
		 	$("#department_id",$("#addForm")).val(str[0]);
		 	$("#department_name",$("#addForm")).val(str[1]);
		 }else if (str==undefined){
		 	str=window.returnValue;
		 	 if(str!=null&&str!=undefined){
			 	$("#department_id",$("#addForm")).val(str[0]);
			 	$("#department_name",$("#addForm")).val(str[1]);
			 }
		 }
	});
	$("#department_name",$("#updateForm")).click(function(){
		 var str =window.showModalDialog("commonservice.department.dialog?com_id=1","","dialogWidth:400px;dialogHeight:500px");
		 if(str!=null&&str!=undefined){
		 	$("#department_id",$("#updateForm")).val(str[0]);
		 	$("#department_name",$("#updateForm")).val(str[1]);
		 }else if (str==undefined){
		 	str=window.returnValue;
		 	 if(str!=null&&str!=undefined){
			 	$("#department_id",$("#updateForm")).val(str[0]);
			 	$("#department_name",$("#updateForm")).val(str[1]);
			 }
		 }
	});
});
function reset_pass(){
	var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
	if (id) { 
		var ret = jQuery("#clist1").jqGrid('getRowData',id);
		var url="${_servlet_url!''}/manager.user.reset_pass?mem_id="+ret.mem_id;
		$.post(url,"",
	    	function(data,textStatus){
		    	if(data.member=="1"){
		    		alert("密码重置成功");
		    	}else{
		    		alert("密码重置失败");
		    	}
	    	},"json");
    }
	else
		alert("请选择一条记录修改！");
}
function isenable_off(state){
    var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
	if (id) { 
		var ret = jQuery("#clist1").jqGrid('getRowData',id);
		var url="${_servlet_url!''}/safecheck.enableuser?mem_id="+ret.mem_id+"&state="+state;
		$.post(url,"",
	    	function(data,textStatus){
	    		var jdata=jQuery.parseJSON(data);
		    	if(jdata.success=="1"){
		    		if(state=="1")
		    			alert("用户启用成功");
		    		else
		    			alert("用户禁用成功");
		    		jQuery("#clist1").trigger("reloadGrid");
		    	}else{
		    		if(state=="1")
		    			alert("用户启用失败");
		    		else
		    			alert("用户禁用失败");
		    	}
	    	});
    }
	else
		alert("请选择一条记录修改！");
}
function gridReload1(){
	$("#fullname").val("");
	$("#memname").val("");
	var url="${_servlet_url!''}/safecheck.safeassessors.listjson";
	jQuery("#clist1").jqGrid('setGridParam',{url:url,page:1}).trigger("reloadGrid");
} 
//自适应窗口边框
var t=document.documentElement.clientWidth; 
window.onresize = function(){ 
	if(t != document.documentElement.clientWidth){
		t = document.documentElement.clientWidth;
		doResize();
	}
}
function doResize() {
	var ss = getPageSize();
	$("#clist1").jqGrid('setGridWidth', ss.WinW-15);
	$("#clist1").jqGrid('setGridHeight', ss.WinH-180);
}
function getPageSize() {
	var winW, winH;
	if(window.innerHeight) {// all except IE
		winW = window.innerWidth;
		winH = window.innerHeight;
	} else if (document.documentElement && document.documentElement.clientHeight) {// IE 6 Strict Mode
		winW = document.documentElement.clientWidth;
		winH = document.documentElement.clientHeight;
	} else if (document.body) { // other
		winW = document.body.clientWidth;
		winH = document.body.clientHeight;
	}  // for small pages with total size less then the viewport 
		return {WinW:winW, WinH:winH};
}
//当文件上传成功后，将返回id:flash对象的ID，name：新文件名,url:文件绝对路径
function returnvalue(id,name,url){
	//alert(id+"  "+name+"  "+url);
	if(id=="imguploaddiv")
		$("#certificate",$("#addForm")).val(url);
	if(id=="imguploaddiv1")
		$("#certificate",$("#updateForm")).val(url);
}
function viewpic(fieldid,newfilepath){
	window.open(document.getElementById(fieldid).value);
}
</script>
<style>
.rightpad{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.leftpad{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
<div class="skin_search ui-widget-content" style="padding:.2em;margin-bottom:8px;">
	<form name="dic_form" id="dic_form" action="" method="post">
		<span>姓名：<input type="text" size="8" id="fullname" name="fullname" value=""></span>
		<span>登录名：<input type="text" size="8" id="memname" name="memname" value=""></span>
		&nbsp;<button type="button" id="gridReload">查询</button>
		&nbsp;<button type="button" onclick="gridReload1()">清空所有条件</button>
	</form>
</div>
<div  id="buttons" style="text-align:right;margin-bottom:8px;">
		<button type="button" id="addInfo" align="right">增加</button>
		<button type="button" id="updateInfo" align="right">修改</button>
		<button type="button" id="deleteInfo" align="right">删除</button>
		<button type="button" onclick="isenable_off('1')">启用</button>
		<button type="button" onclick="isenable_off('0')">禁用</button>
		[#if access.canDo(user,'manager.user.reset_pass')]
			<button type="button" onclick="reset_pass()">重置密码</button>
		[/#if]
</div>
<div id="pager1"></div>
<table id="clist1"></table>
<div id="dialog" title="安全鉴定员增加" style="display:none">
	<form class="cmxform" style="margin:0" action="${_servlet_url!''}/safecheck.safeassessors.insert" method="post" id="addForm">
		<input type="hidden" name="role_id" value="safeassessors">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;table-layout:fixed;">
			<tr>
				<td width="100px" class="rightpad">用户名:</td>
				<td class="leftpad">
				<input type="text" id="username" name="username">
				</td>
				<td width="100px" class="rightpad">姓		名:</td>
				<td class="leftpad">
					姓：<input type="text"  size="8" id="familyname" name="familyname">
					名：<input type="text"  size="8" id="firstname" name="firstname">
				</td>
			</tr>
			<tr>
				<td class="rightpad">性		别:</td>
				<td class="leftpad">
					<input type="radio" name="mem_sex" value="男" checked>男
					<input type="radio" name="mem_sex" value="女">女
				</td>
				<td class="rightpad">手机号:</td>
				<td class="leftpad">
					<input type="text" id="mem_mphone" name="mem_mphone">
				</td>
			</tr>
			<tr>
					<td class="rightpad">出生日期:</td>
					<td class="leftpad">
						<input type="text" id="birthday" name="birthday"  onClick="WdatePicker()">
					</td>
					<td class="rightpad">邮箱:</td>
					<td class="leftpad">
						<input type="text" id="mem_mail" name="mem_mail">
					</td>
			</tr>
			<tr>
					<td class="rightpad">所属机构:</td>
					<td class="leftpad">
						<input type="text" id="department_name" name="department_name" readonly="true">	
						<input type="hidden" id="department_id" name="department_id">	
					</td>
					<td class="rightpad" rowspan="2">证书复印件</td>
					<td class="leftpad" rowspan="2">
						<input type="text" name="certificate" id="certificate" value=""/>
						<!--<input type="hidden" name="certificate" id="certificate" value=""/>
						<div id="imguploaddiv"></div>
						<script language="javascript" type="text/javascript">
							var so = new SWFObject('${_share_file_url!''}/resource/jsp/imgupload.swf', "imgupload", "60", "60", "9", "#FFffff");//imgupload是控件ID,如有多个ID不可重复
							so.addVariable("oldname",$("#certificate").val());//修改时的原文件地址，可以是绝对或相对地址
							so.addVariable("savepath","images/manager/");//上传文件的路径
							so.addVariable("uploadpath","${_server_url!''}/eap/manager.system.upload?session_id=${session.id!''}");//上传请求地址so.addVariable("uploadpath","/eap/manager.system.upload");//上传请求地址
							so.write("imguploaddiv");
						</script>	-->
					</td>
			</tr>
			<tr>
					<td class="rightpad">证书编号</td>
					<td class="leftpad">
						<input type="text" name="certificate_number" id="certificate_number"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">证书取得时间</td>
					<td class="leftpad">
						<input type="text" name="certificate_date" id="certificate_date" value=""  onClick="WdatePicker()"/>
					</td>
					<td class="rightpad">专业技术职称</td>
					<td class="leftpad">
						<input type="text" name="professional_titles" id="professional_titles" value=""/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">从事专业</td>
					<td class="leftpad">
						<input type="text" name="professional" id="professional" value=""/>
					</td>
					<td class="rightpad" rowspan="2">手写签名</td>
					<td class="leftpad" rowspan="2">
						<input type="text" name="signature" id="signature" value=""/>
						<!--<input type="hidden" name="signature" id="signature" value=""/>
						<div id="imguploaddiv3"></div>
						<script language="javascript" type="text/javascript">
							var so = new SWFObject('${_share_file_url!''}/resource/jsp/imgupload.swf', "imgupload3", "60", "60", "9", "#FFffff");//imgupload是控件ID,如有多个ID不可重复
							so.addVariable("oldname",$("#signature").val());//修改时的原文件地址，可以是绝对或相对地址
							so.addVariable("savepath","images/manager/");//上传文件的路径
							so.addVariable("uploadpath","${_server_url!''}/eap/manager.system.upload?session_id=${session.id!''}");//上传请求地址so.addVariable("uploadpath","/eap/manager.system.upload");//上传请求地址
							so.write("imguploaddiv3");
						</script>	-->
					</td>
			</tr>
			<tr>
					<td class="rightpad">工作经验年限</td>
					<td class="leftpad">
						<input type="text" name="work_years" id="work_years" value="" size="4"/>
					</td>
			</tr>
		</table>
	</form>
</div>
<div id="dialogupdate" title="安全鉴定员修改" style="display:none">
	<form class="cmxform" style="margin:0" action="${_servlet_url!''}/safecheck.safeassessors.update1" method="post" id="updateForm">
		<input type="hidden" name="role_id" value="safeassessors">
		<input type="hidden" name="mem_id" id="mem_id" value="">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;table-layout:fixed;">
			<tr>
				<td width="100px" class="rightpad">用户名:</td>
				<td class="leftpad">
				<input type="text" id="username" name="username" readonly />
				</td>
				<td width="100px" class="rightpad">姓		名:</td>
				<td class="leftpad">
					姓：<input type="text"  size="8" id="familyname" name="familyname">
					名：<input type="text"  size="8" id="firstname" name="firstname">
				</td>
			</tr>
			<tr>
				<td class="rightpad">性		别:</td>
				<td class="leftpad">
					<input type="radio" name="mem_sex" value="男" checked>男
					<input type="radio" name="mem_sex" value="女">女
				</td>
				<td class="rightpad">手机号:</td>
				<td class="leftpad">
					<input type="text" id="mem_mphone" name="mem_mphone">
				</td>
			</tr>
			<tr>
					<td class="rightpad">出生日期:</td>
					<td class="leftpad">
						<input type="text" id="birthday" name="birthday"  onClick="WdatePicker()"/>
					</td>
					<td class="rightpad">邮箱:</td>
					<td class="leftpad">
						<input type="text" id="mem_mail" name="mem_mail">
					</td>
			</tr>
			<tr>
					<td class="rightpad">所属机构:</td>
					<td class="leftpad">
						<input type="text" id="department_name" name="department_name" readonly="true">	
						<input type="hidden" id="department_id" name="department_id">	
					</td>
					<td class="rightpad" rowspan="2">证书复印件</td>
					<td class="leftpad" rowspan="2">
						<input type="text" name="certificate" id="certificate1" value=""/>
						<!--<input type="hidden" name="certificate" id="certificate" value=""/>
						<div id="imguploaddiv1"></div>
						<script language="javascript" type="text/javascript">
							var so = new SWFObject('${_share_file_url!''}/resource/jsp/imgupload.swf', "imgupload1", "60", "60", "9", "#FFffff");//imgupload是控件ID,如有多个ID不可重复
							so.addVariable("oldname",$("#certificate",$("#updateForm")).val());//修改时的原文件地址，可以是绝对或相对地址
							so.addVariable("savepath","images/manager/");//上传文件的路径
							so.addVariable("uploadpath","${_server_url!''}/eap/manager.system.upload?session_id=${session.id!''}");//上传请求地址so.addVariable("uploadpath","/eap/manager.system.upload");//上传请求地址
							so.write("imguploaddiv1");
						</script>-->	
					</td>
			</tr>
			<tr>
					<td class="rightpad">证书编号</td>
					<td class="leftpad">
						<input type="text" name="certificate_number" id="certificate_number"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">证书取得时间</td>
					<td class="leftpad">
						<input type="text" name="certificate_date" id="certificate_date"  onClick="WdatePicker()"/>
					</td>
					<td class="rightpad">专业技术职称</td>
					<td class="leftpad">
						<input type="text" name="professional_titles" id="professional_titles"/>
					</td>
			</tr>
			<tr>
					<td class="rightpad">从事专业</td>
					<td class="leftpad">
						<input type="text" name="professional" id="professional" />
					</td>
					<td class="rightpad" rowspan="2">手写签名</td>
					<td class="leftpad" rowspan="2">
						<input type="text" name="signature" id="signature1" value=""/>
						<!--<input type="hidden" name="signature" id="signature" value=""/>
						<div id="imguploaddiv4"></div>
						<script language="javascript" type="text/javascript">
							var so = new SWFObject('${_share_file_url!''}/resource/jsp/imgupload.swf', "imgupload4", "60", "60", "9", "#FFffff");//imgupload是控件ID,如有多个ID不可重复
							so.addVariable("oldname",$("#signature",$("#updateForm")).val());//修改时的原文件地址，可以是绝对或相对地址
							so.addVariable("savepath","images/manager/");//上传文件的路径
							so.addVariable("uploadpath","${_server_url!''}/eap/manager.system.upload?session_id=${session.id!''}");//上传请求地址so.addVariable("uploadpath","/eap/manager.system.upload");//上传请求地址
							so.write("imguploaddiv4");
						</script>-->	
					</td>
			</tr>
			<tr>
					<td class="rightpad">工作经验年限</td>
					<td class="leftpad">
						<input type="text" name="work_years" id="work_years" size="4"/>
					</td>
			</tr>
		</table>
	</form>
</div>