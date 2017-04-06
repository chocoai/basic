<script src="${_share_file_url!''}/gis/FMapLib/FMapLib.Include.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet"	href="${_share_file_url!''}/gis/resource/jquery/css/layout-default-latest.css" />
<script type="text/javascript" src="${_share_file_url!''}/gis/resource/jquery/js/jquery.layout-latest.js"></script>
<link rel="stylesheet" href="${_share_file_url!''}/gis/FMapLib/theme/css/versionmap.css">
<link rel="stylesheet" type="text/css" href="${_share_file_url!''}/gis/resource/css/lrtk.css">
<!--头部菜单样式-->
<link rel="stylesheet" type="text/css" href="${_share_file_url!''}/gis/resource/css/all.css">
<script type="text/javascript" src="${_share_file_url!''}/gis/resource/js/turnPhoto.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/gis/resource/jquery/js/jquery.mousewheel.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/gis/resource/js/tourist.js"></script>
<style type="text/css">
html,body {
	background: #666;
	width: 100%;
	height: 100%;
	padding: 0;
	margin: 0;
	overflow: auto; /* when page gets too small */
}

#container {
	background: #999;
	height: 100%;
	margin: 0 auto;
	width: 100%;
	/* 		max-width:	1300px; */
	/* 		min-width:	100px; */
	_width: 1300px; /* min-width for IE6 */
}

.pane {
	display: none; /* will appear when layout inits */
}
</style>
<script language="javascript">
function login(){
	//var flag=window.showModalDialog("${_server_url!''}/portal/commonservice.login.loginblock.dialog", "", "dialogWidth=220px;dialogHeight=150px");
	//if(flag)
	//	window.location.href="${_server_url!''}/portal/realtygis.gis";	
	$("#login_div").css("display","block");
}
$(function(){
	[#if "${session.getAttribute('error')!''}"!=""]
		$("#login_div").css("display","block");
	[/#if]
	$("#qx").click(function(){
		$("#login_div").css("display","none");
	});
	$(window).resize(function(){
		resetWorkset();
	});
	
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
 	$("#login_div").css("left",((getPageSize().WinW-450)/2 + 'px'));
});
function resetWorkset() {
	$("#login_div").css("left",((getPageSize().WinW-450)/2 + 'px'));
}
</script>
<div id="container" style="position: absolute; left: 0px; right: 0px; width: 100%; height: 100%;">	
   <div class="content ui-layout-north">
   <div id="portal" style="position: relative; padding: 0; margin: 0; height: auto; width: auto">
		<table width="100%" cellspacing="0" cellpadding="0" border="0" background="${_share_file_url!''}/gis/resource/images/top-bj.jpg">
  <tbody><tr>
    <td width="454"><img width="454" height="71" src="${_share_file_url!''}/gis/resource/images/top-left.jpg"></td>
    <td>&nbsp;</td>
    <td width="683" valign="top"><table width="100%" cellspacing="0" cellpadding="0" border="0" style="	background-image: url(${_share_file_url!''}/gis/resource/images/top-right.jpg);
	background-repeat: no-repeat; background-position:right;">
      <tbody><tr>
        <td valign="top" height="71"><table width="100%" cellspacing="0" cellpadding="0" border="0">
          <tbody><tr>
            <td height="36">&nbsp;</td>
            <td width="174" class="baizi"><table width="100%" cellspacing="0" cellpadding="0" border="0">
              <tbody><tr>
              	[#assign num=0]
              	[#if user.roleList?exists]
              	[#list user.roleList as role]
              		[#if "${role!''}"=="register"]
              			[#assign num=1]
              			[#break]
              		[/#if]
              	[/#list]
              	[/#if]
              	[#if num==1]
              	<td class="baizi">欢迎您：${user.fullname!''}！</td>
              	[#else]
                <td class="baizi">欢迎您：游客！</td>
                <td width="60" align="center">
                <button id="lg" width="100%" onclick="login();">登录</button>
                </td>
                [/#if]
              </tr>
            </tbody></table></td>
          </tr>
        </tbody></table>
          <table width="100%" cellspacing="0" cellpadding="0" border="0">
            <tbody><tr>
              <td height="9"></td>
            </tr>
          </tbody></table>          
          
          <table width="100%" cellspacing="0" cellpadding="0" border="0">
            <tbody><tr>
              <td>
<ul class="widget-tab-ul lineheight">
</ul>
 </td>
            </tr>
          </tbody></table>
          
          </td>
      </tr>
    </tbody></table></td>
  </tr>
</tbody></table>
   </div> 
   </div>
	<div class="content ui-layout-center"
			style="position: absolute; left: 0px; right: 0px; width: 100%; height: 100%;">
			<div id="innerContainer"
				style="position: absolute; left: 0px; right: 0px; width: 100%; height: 100%;">
				<div class="right_top" id="maptopDiv" style="display:none">
 						<div class="weather">济南市 多云转晴 24~34℃</div>				 
						
						<div class="map_tool" style="padding-top: 0px" >
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
								<td width="20" height="37"><img src="${_share_file_url!''}/gis/resource/images/plus.png" /></td>
									<td width="40" class="tool_title"><a
										onclick="javascript:clearFeatures()" href="#">清除</a></td>
								<td width="20" height="37"><img src="${_share_file_url!''}/gis/resource/images/cm1.png" /></td>
						        <td width="40" class="tool_title"><a id="forward" onclick="javascript:forward()" href="#">前进</a></td>
						        <td width="20" height="37"><img src="${_share_file_url!''}/gis/resource/images/bj.gif" /></td>
						         <td width="40" class="tool_title"><a id="back" onclick="javascript:back()" href="#">后退</a></td>										
									
									<td width="20" height="37"><img src="${_share_file_url!''}/gis/resource/images/cj.gif" /></td>
									<td width="40" class="tool_title"><ul id="sddm"style='width:25px'>							
        <a href="#" onmouseover="mopen('m1')" onmouseout="mclosetime()">工具</a>
		<div id="m1" onmouseover="mcancelclosetime()" onmouseout="mclosetime()">
		<a href="#"  onclick="javascript:distanceMeasure()">测距</a>
		<a href="#"  onclick="javascript:areaMeasure()">测面</a>
		<a href="#" onclick="javascript:mapprint()">打印</a>
		<a href="#" onclick="javascript:querySurrounding()">周边查询</a>
		</div>
	    </ul></td>	
	    <td width="20" height="37"><img src="${_share_file_url!''}/gis/resource/images/cj.gif" /></td>
									<td width="40" class="tool_title"><ul id="sddm">							
        <a href="#" onmouseover="mopen('m2')" onmouseout="mclosetime()">快捷查询</a>
		<div id="m2" onmouseover="mcancelclosetime()" onmouseout="mclosetime()">
		<a href="#" id="extent" onclick="javascript:Instantiation(this)">可见视野范围内查询</a>
		<a href="#" id="drop" onclick="javascript:Instantiation(this)">拉框查询</a>
		<a href="#" onclick="javascript:ExtentQueryCancel()">取消查询</a>
		</div>
	    </ul></td>	
									
									<td width="20" height="37"><img src="${_share_file_url!''}/gis/resource/images/version.gif" /></td>
									<td width="40" class="tool_title"><a id="ele3"
										class="tigger" href="#">历史</a></td>
									
									<td width="20" height="37"><img src="${_share_file_url!''}/gis/resource/images/qp.gif" /></td>
									<td id="td6" width="40" class="tool_title"><a id="a6"
										onclick="javascript:fullScreen()" href="#">全屏</a></td>
								</tr>
							</table>
						</div>
					</div>							
				<div class="content ui-layout-center" id="map"
					style="position: absolute; left: 0px; right: 0px; width: 99%; height: 88%;">
				</div>
						
		   </div>
		   
	</div>	

</div>		

<div id="login_div" style="background-color:#FAFAFA;height:300px;width:450px;display:none;position:absolute;top:100px;border:1px;border-color:#007EDB;border-style:solid;">
	<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.validate.js"></script>
	<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
	<script type="text/javascript">
	jQuery().ready(function(){	
		$("#form").validate({
			rules: {
				username:{
					required:true
				},
				password:{
					required:true
				}
				[#if map.num?exists && map.num>0]
				,validatecode:{
					required:true
				}
				[/#if]
			},
			messages: {
				username:{
					required:"请输入用户名"
				},
				password:{
					required:"请输入密码"
				}
				[#if map.num?exists && map.num>0]
				,validatecode:{
					required:"请输入验证码"
				}
				[/#if]
			},
			submitHandler:function(form){
				var queryString=$("#form").formSerialize();
				$.post($("#form").attr("action"),queryString,
					function(data,textStatus){
					var jdata=jQuery.parseJSON(data);
			    	if(jdata.success=="1"){
			    		//alert("登录成功"+jdata.newAction);
			    		window.location.href="${_server_url!''}/portal/realtygis.gis";
			    	}else{
			    		window.location.reload();
			    	}
				});
			}
		});
	});
	</script>
	<style type="text/css">
	form.cmxform label.error, label.error {
	/* remove the next line when you have trouble in IE6 with labels in list */
	color: red;
	}
	</style>
	<div class="widget-content-body">
		<div class="widget-news-content">
			<form method="post" action="${_servlet_url!''}/commonservice.login.loginget" id="form">
			<table border="0" width="100%" cellspacing="0" cellpadding="1">
				<tr style="line-height:50px;">
					<td vertical-align="middle" style="padding-left:20px;background-color:#007EDB;font-size:16px;color:#fff;font-weight:bold;">
					用户登录
					</td>
					<td align="right" vertical-align="middle" style="padding-right:20px;background-color:#007EDB;color:#fff;font-weight:bold;">
						<span id="qx">取消</span>
					</td>
				</tr>
				<tr style="line-height:30px;">
					<td colspan="2" align="center">&nbsp;
					[#assign error=session.getAttribute("error")!'']
					[#assign n=session.getAttribute("n")!'']
					<font color="red">[#if "${error}"=="-1"]用户被禁用请联系管理员[/#if]</font>
					<font color="red">[#if "${error}"=="0"]用户不存在[/#if]</font>
					<font color="red">[#if "${error}"=="1"]用户名或密码错误,还有${n}次机会[/#if]</font>
					<font color="red">[#if "${error}"=="2"]验证码错误[/#if]</font>
					<font color="red">[#if "${error}"=="3"]账号已锁定[/#if]</font>
					</td>
				</tr>
				<tr style="line-height:30px;">
					<td align="right">
					<span style="padding-left:8px;display:block;padding-right:8px;">用户名:</span>
					</td>
					<td>
					<input type="text" name="username" style="width:187px;height:28px;line-height:28px;text-indent:6px;" value="${session.getAttribute("empusername")!''}">
					</td>
				</tr>
				<tr style="line-height:10px;">
					<td colspan="2">&nbsp;</td>
				</tr>	
				<tr style="line-height:30px;">
					<td align="right">
					<span style="padding-left:8px;display:block;padding-right:8px;">密　码:</span>
					</td>
					<td>
					<input type="password" name="password" style="width:187px;height:28px;line-height:28px;text-indent:6px;" value="${session.getAttribute("emppassword")!''}">
					</td>
				</tr>
				[#if map.num?exists && map.num>0 && (session.getAttribute("m")!'')!="1"]
				<tr style="line-height:10px;">
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr style="line-height:30px;">
					<td align="right">
					<span style="padding-left:8px;display:block;padding-right:8px;">验证码:</span>
					</td>
					<td>
					<input type="text" name="validatecode" id="validatecode" style="height:28px;width:110px;line-height:28px;text-indent:6px;"/>
					<img src="${_servlet_url!''}/commonservice.login.checkcodeimg" align="absmiddle" border="1" id="ccimg" height="28px">
					<a href="javascript:void(0)" id="changeimg">看不清换一个</a>
					</td>
				</tr>
				[/#if]
				[#-- if (session.getAttribute("m")!'')=="1"]
					<font color="red">您本次登录与上次登录机器不同，请查收邮件并输入验证码</font>
					<span style="margin:2px;display:block">验证码:<input type="text" name="vcode" id="vcode" style="width:110px"/></span>
				[/#if--]
				<!--span style="margin:2px;display:block">记住我:<input type="checkbox" name="loginsave"-->
				<tr style="line-height:10px;">
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr style="line-height:30px;">
					<td>&nbsp;</td>
					<td>
					<input id="s" type="submit" style="height:30px;width:192px;line-height:20px;text-indent:6px;" value="登   录">
					</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
</div>






