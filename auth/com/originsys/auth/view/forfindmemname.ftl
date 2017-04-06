<script type="text/javascript" src="${_share_file_url!''}/resource/js/card.js"></script>
<script language="javascript">
$(function(){
	$("#dofind").click(function(){
		var id_num=$("#idnum").val();
		if(id_num==""){
			alert("请输入身份证号");
			return false;
		}else{
			var flag=idCardNoUtil.checkIdCardNo(id_num);
			if(flag){
				$.post("${_servlet_url!''}/auth.findname?ID_num="+id_num,{random:Math.random()},
				function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.mem_name==""){
						alert("此身份证号未注册过！");
					}else{
						alert("此身份证号的用户登录名是："+jdata.mem_name);
					}
				});
			}else{
				alert("请输入正确的身份证号!");
				return false;
			}
		}
	});
});
</script>
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;找回登录名
	</div>
	<form style="margin:0" action="${_servlet_url!''}/auth.findname" method="post" id="loginForm">
	<div  id="buttons" style="text-align:right">
		<button type="button" id="dofind">确定</button><button type="button"  onClick="history.go(-1)">返回</button>
	</div>
	<div class="ui-widget-content"  style="position: relative;padding: .2em;">
	<table border="0" width="100%" cellspacing=0 class="mainbody_table_detail">
	<col width="110"><col>
		<tr>
			<td class="detail_attname">身份证号:</td>
			<td class="detail_value">
			<input type="text" name="idnum" id="idnum">
			</td>			
		</tr>
	</table>
	</div>
	</form>
</div>	

