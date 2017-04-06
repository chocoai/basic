[#macro extendedattribute paramList paramMap]
[#--遍历参数--]

<script>
function addr1(f,url){
	var addr=window.showModalDialog(url,"","dialogWidth:600px;dialogHeight:500px");
	$(f).prev().val(addr[0]);
	$(f).val(addr[1]);
	}
</script>
[#list paramList as parameter]
[#assign parameterValue=paramMap[parameter.id]/]
[#if parameter.isSearch]
<span>${parameter.name}:
[#if parameter.dataType=="ENUM"]
	<select name="${parameter.id}_${parameter.comparisonOperator}">
		[#list EnumService.getEnum(parameter.referTo) as state]
			<option value="${state.enum_value}" >${state.enum_name}</option>
		[/#list]
	</select>
[#elseif parameter.dataType=="BOOLEAN"]
	<input type="checkbox" name="${parameter.id}_${parameter.comparisonOperator}" value="y">
[#elseif parameter.dataType=="TABLE"]
	<input type="hidden" name="${parameter.id}_${parameter.comparisonOperator}" id="value_${parameter.id}" class="request" value="${parameterValue.value!""}"><input type="text" readonly value="" size="30" id="name_${parameter.id}"  onclick="addr1(this,'${parameterValue.attribute.dialog_url!''}');">
[#elseif parameter.dataType=="INT"]
	<input type="text" name="${parameter.id}_${parameter.comparisonOperator}" value="">
[#else]
	<input type="text" name="${parameter.id}_${parameter.comparisonOperator}" value="">
[/#if]
</span>
[/#if]
[/#list]
[/#macro]