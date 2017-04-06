<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script language="javascript" type="text/javascript">
function renzheng(){
	var queryString=$("#updateForm").formSerialize();
	$.post("${_servlet_url!''}/auth.doorgcomcheck",queryString,function(data,textStatus){
		var jdata=jQuery.parseJSON(data);
		if(jdata.success==1){
			alert("操作成功");
			window.close();
		}else{
			alert("操作失败!!");
			window.close();
		}
	});
}	
function orgState(state){
	if(state=="1"){
		$(".abc1").attr("checked",true);
	}else{
		$(".abc0").attr("checked",true);
	}
}
</script>
<style>
.rightpad{text-align:right;padding-right:7px;background-color:#F2F9FF;}
.leftpad{padding-left:2px;background-color:#FFFFFF;width:200px;}
</style>
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .2em;">
	<div class="ui-widget-header ui-corner-all" style="padding:4px;margin-bottom:6px">
		<img  SRC="${_share_file_url!''}/resource/images/icon.gif" WIDTH="16" HEIGHT="16" BORDER=0 ALT="" align="absmiddle"/>
		&nbsp;认证单位信息
	</div>
<form class="cmxform" style="margin:0" action="" method="post" id="updateForm">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" style="line-height:30px;table-layout:fixed;"> 
		<col  width="200px"/></col />
			<tr>
					<input type="hidden" name="organ_id" id="organ_id" value="${resultMap.result.organ_id!''}"/>
			</tr>
			<tr>
					<td><b>单位基本信息</b></td>
					<td></td>
			</tr>
			<tr>
					<td class="rightpad">单位法定全称</td>
					<td class="leftpad">
							${resultMap.result.organ_name!''}
					</td>
			</tr>
			<tr>
				<td class="rightpad">动态令牌号</td>
				<td class="leftpad">
					${resultMap.result.token_id!''}
				</td>
			</tr>
			<tr>
					<td class="rightpad">所属行政区</td>
					<td class="leftpad">
						${resultMap.result.organ_region_name!''}
					</td>
			</tr>
			<tr>
					<td class="rightpad">通信地址</td>
					<td class="leftpad">
							${resultMap.result.organ_address!''}
					</td>
			</tr>
			<tr>
					<td class="rightpad">联系人</td>
					<td class="leftpad">
							${resultMap.result.organ_linkman!''}
					</td>
			</tr>
			<tr>
					<td class="rightpad">电话</td>
					<td class="leftpad">
							${resultMap.result.organ_phone!''}
					</td>
			</tr>
			<tr>
					<td class="rightpad">邮政编码</td>
					<td class="leftpad">
						${resultMap.result.organ_postcode!''}
					</td>
			</tr>
			<tr>
					<td class="rightpad">域名｜ip</td>
					<td class="leftpad">
						${resultMap.result.organ_domainname!''}
					</td>
			</tr>
			<tr>
					<td class="rightpad">行业</td>
					<td class="leftpad">
						${resultMap.result.organ_trade!''}
					</td>
			</tr>
			<tr>
					<td class="rightpad">组织简介</td>
					<td class="leftpad">
						${resultMap.result.organ_desc!''}
					</td>
			</tr>
			<tr>
					<td class="rightpad">组织类型</td>
					<td class="leftpad">
						${resultMap.result.organ_type!''}
					</td>
			</tr>
			<tr>
					<td class="rightpad">员工人数</td>
					<td class="leftpad">
						${resultMap.result.organ_staff_number!''}
					</td>
			</tr>
			
			<tr>
					<td class="rightpad">组织证件类型</td>
					<td class="leftpad">
						${resultMap.result.organ_cred_type!''}
					</td>
			</tr>
			<tr>
					<td class="rightpad">组织证件号码</td>
					<td class="leftpad">
						${resultMap.result.organ_cred_code!''}
					</td>
			</tr>
			<tr>
					<td class="rightpad">认证状态</td>
					<td class="leftpad">
						[#if "1"=="${resultMap.result.authentication_state!''}"]通过[#else]未通过[/#if]
					</td>
			</tr>
			<tr>
					<td class="rightpad">第二域名</td>
					<td class="leftpad">
						${resultMap.result.organ_domainname2!''}
					</td>
			</tr>
			<tr>
					<td class="rightpad">组织机构代码</td>
					<td class="leftpad">
						${resultMap.organ_code1!''}-${resultMap.organ_code2!''}
					</td>
			</tr>
			<tr>
					<td class="rightpad">组织机构代码证</td>
					<td class="leftpad">
						[#if "${resultMap.result.organ_code_image!''}"!=""]
						<img src="${resultMap.result.organ_code_image!''}" height="100px" width="200px;">
						<a href="#" onclick="javascript:window.open('${resultMap.result.organ_code_image!''}');">查看大图</a>
						[/#if]
					</td>
			</tr>
			<tr>
					<td class="rightpad">营业执照</td>
					<td class="leftpad">
						[#if "${resultMap.result.business_license_image!''}"!=""]
						<img src="${resultMap.result.business_license_image!''}" height="100px" width="200px;">
						<a href="#" onclick="javascript:window.open('${resultMap.result.business_license_image!''}');">查看大图</a>
						[/#if]
					</td>
			</tr>
			<tr>
					<td class="rightpad">税务登记证</td>
					<td class="leftpad">
						[#if "${resultMap.result.tax_reg_certificate!''}"!=""]
						<img src="${resultMap.result.tax_reg_certificate!''}" height="100px" width="200px;">
						<a href="#" onclick="javascript:window.open('${resultMap.result.tax_reg_certificate!''}');">查看大图</a>
						[/#if]
					</td>
			</tr>
			<tr>
					<td><b>单位认证信息</b></td>
					<td></td>
			</tr>
			<tr>
					<td class="rightpad">单位认证</td>
					<td class="leftpad">
						<input type="radio" name="state" value="1" [#if "${resultMap.result.authentication_state!''}"=="1"]checked[/#if] onclick="orgState('1');">通过
						<input type="radio" name="state" value="0" [#if "${resultMap.result.authentication_state!''}"=="0"]checked[/#if] onclick="orgState('0');">驳回
					</td>
			</tr>
			<tr>
					<td class="rightpad" style="vertical-align:top;">单位类型认证</td>
					<td class="leftpad">
						[#if resultMap.result.orgcomtype_list?exists]
							[#list resultMap.result.orgcomtype_list as type]
								[#if "${type.organ_type_state!''}"=="1"]
								${type.organ_type_cname!''} 
								<input type="radio" class="abc1" name="${type.organ_type_id!''}" value="1" checked>通过
								<input type="radio" class="abc0" name="${type.organ_type_id!''}" value="0">驳回
								[#else]
								${type.organ_type_cname!''} 
								<input type="radio" class="abc1" name="${type.organ_type_id!''}" value="1">通过
								<input type="radio" class="abc0" name="${type.organ_type_id!''}" value="0" checked>驳回
								[/#if]
								[#if type_has_next]<br>[/#if]
							[/#list]
						[/#if]
					</td>
			</tr>
			<tr>
				<td align="center" style="background-color:#FFFFFF;" colspan="2">
					<button type="button" onclick="renzheng();">提交</button>&nbsp;
					<!-- button type="button" onClick="history.go(-1)">返回</button -->
				</td>
			</tr>
	</table>
</form>
</div>