<link href="${_share_file_url!''}/gis/resource/css/apistyle.css" rel="stylesheet" type="text/css" />
<style>
.td3{text-align:center;background-color:#E2F1FF;}
</style>
<div class="menu_left">
	<ul class="menu menu_left_ul ">
    	<li><a href="#">目录</a></li>
    	<li class="menu_li_label"><a href="#fun1">1.功能说明</a></li>
        <li class="menu_li_label"><a href="#fun2">2.调用说明</a></li>
        <li class="menu_li_label_1"><a href="#fun21">2.1请求方式</a></li>
        <li class="menu_li_label_1"><a href="#fun22">2.2请求地址</a></li>
        <li class="menu_li_label"><a href="#fun3">3.请求参数</a></li>
        <li class="menu_li_label_1"><a href="#fun31">3.1通用参数</a></li>
        <li class="menu_li_label_1"><a href="#fun32">3.2私用参数</a></li>
        <li class="menu_li_label"><a href="#fun4">4.返回参数</a></li>
        <li class="menu_li_label_1"><a href="#fun41">4.1返回参数说明</a></li>
    	<li class="menu_li_label"><a href="#fun5">5.返回示例</a></li>
    	<li class="menu_li_label"><a href="#fun6">6.申请服务</a></li>
    	<li class="menu_li_label"><a href="#fun7">7.服务创建者</a></li>
    	<li class="menu_li_label"><a href="#fun8">8.在线测试</a></li>
    </ul>
</div>
<div class="content">1：功能说明<a name="fun1" id="fun1">&nbsp;</a></div>
<div class="content_1">${block.servicereg.service_name!''}</div>
<div class="content">2：调用说明<a name="fun2" id="fun2">&nbsp;</a></div>
<div class="content_1">2.1 请求方式<a name="fun21" id="fun21">&nbsp;</a></div>
<div class="content_2">${block.servicereg.proxy_type!''}</div>
<div class="content_1">2.2 请求地址<a name="fun22" id="fun22">&nbsp;</a></div>
<div class="content_2">${block.servicereg.request_url!''}</div>
<div class="content">3：请求参数<a name="fun3" id="fun3">&nbsp;</a></div>
<div class="content_1">3.1 通用参数<a name="fun31" id="fun31">&nbsp;</a></div>
<div class="content_2">
	<table width="100%" id="inputparam" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<tr>
		<td class="td3" width="200">参数名称</td>
		<td class="td3" width="80px">是否必需</td>
		<td class="td3" width="100px">参数类型</td>
		<td class="td3">参数描述</td>
		</tr>
	</table>
</div>
<div class="content_1">3.2 私用参数<a name="fun32" id="fun32">&nbsp;</a></div>
<div class="content_2">
	<table width="100%" id="inputparam" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<tr>
		<td class="td3" width="200">参数名称</td>
		<td class="td3" width="80px">是否必需</td>
		<td class="td3" width="100px">参数类型</td>
		<td class="td3">参数描述</td>
		</tr>
		[#list block.paramlist as param]
		[#if "${param.param_type!''}"=="0"]
		<tr>
			<td class="td2">${param.param_code!''}</td>
			<td class="td2">[#if "${param.is_required!''}"=="0"]否[#else]是[/#if]</td>
			<td class="td2">${param.field_type!''}</td>
			<td class="td2">${param.param_desc!''}</td>
		</tr>
		[/#if]
		[/#list]
	</table>
</div>
<div class="content">4：返回参数<a name="fun4" id="fun4">&nbsp;</a></div>
<div class="content_1">4.1 返回参数说明<a name="fun41" id="fun41">&nbsp;</a></div>
<div class="content_2">
	<table width="100%" id="inputparam" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<tr>
			<td class="td3" width="200">返回属性名称</td>
			<td class="td3">描述</td>
		</tr>
		[#list block.paramlist as param]
		[#if "${param.param_type!''}"=="1"]
		<tr>
			<td class="td2">${param.param_code!''}</td>
			<td class="td2">${param.param_desc!''}</td>
		</tr>
		[/#if]
		[/#list]
	</table>
</div>
<div class="content">5：返回示例<a name="fun5" id="fun5">&nbsp;</a></div>
<div class="content_1">${block.servicereg.example_image!''}</div>
<div class="content">6：申请服务<a name="fun6" id="fun6">&nbsp;</a></div>
<div class="content_1">暂不开放</div>
<div class="content">7：服务创建者<a name="fun7" id="fun7">&nbsp;</a></div>
<div class="content_1">${block.servicereg.service_provide!''}</div>
<div class="content">8：在线测试<a name="fun8" id="fun8">&nbsp;</a></div>
<div class="content_1">暂不开放</div>