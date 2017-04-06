[#macro extendedattribute paramList paramMap theForm]

<table  width="100%" style="table-layout:fixed;">
	[#--遍历参数--]
	[#list paramList as parameter]
	[#--parameterValue设置为参数值对象，即从paramMap中以参数ID为键取值，值是一个map：value-原始值，attributevalue-处理后的值，attribute-属性定义（AttributeDefine对象）--]
	[#assign parameterValue=paramMap[parameter.id]/]

		<tr>
			<td class="detail_attname" align="left" width="30%">${parameter.name}</td>
			<td class="detail_value">
			[#--枚举处理比较简单，显示为select标签--]
			[#if parameter.dataType=="ENUM"]
				[#if parameterValue.attributevalue?exists]
				[#list parameterValue.attributevalue as enumItem]
					[#if enumItem.selected==true] ${enumItem.enum_name} [/#if]
				[/#list]
				[/#if]
			[#--布尔值需要用复选框,且多值无意义，按单值处理--]
			[#elseif parameter.dataType=="BOOLEAN"]
				[#if parameterValue.attributevalue] 是 [#else]否 [/#if]
			[#--富媒体编辑器同样不允许用多值--]
			[#elseif parameter.dataType=="TEXT"]
			<div>${parameterValue.value!""}</div>
			[#else]
				[#--非枚举时，多值使用multibox组件，按值数量遍历放多个li标签--]
				[#if parameter.isMultivalued]

					[#if parameter.dataType=="TABLE"]
					[#----]
						[#if parameterValue.attributevalue?exists]
						[#list parameterValue.attributevalue as rowItem]
							${rowItem.display_value!""} 
						[/#list]
						[/#if]
					[#else]
						[#--不是字典表则将会是数组，每个li只一个域放值本身--]
						[#if parameterValue.attributevalue?exists]
						[#list parameterValue.attributevalue as row]
						
						[#--长文本需要用textarea--]
							[#if parameter.dataType=="LONGSTRING"]
								${parameterValue.value!""}<br>
							[#elseif parameter.dataType=="IMAGE"]
								<img src="${parameterValue.value!""}" border="0"><br>
							[#elseif parameter.dataType=="DATE"]
								${row?string("MM/dd/yyyy")}
							[#elseif parameter.dataType=="DATEISO"]
								${row?string("yyyy-MM-dd")}
							[#else]
								${row}
							[/#if]
						[/#list]
						[/#if]

					[/#if]
					
				[#--单值则根据数据类型分别处理--]
				[#else]
					[#--如果是表，则处理为两个域--]
					[#if parameter.dataType=="TABLE"]
						[#if parameterValue.value?exists]${parameterValue.attributevalue.display_value!""}[/#if]
					[#--如果是图片和文件，则使用上传组件--]
					[#elseif parameter.dataType=="IMAGE"]
					<img src="${parameterValue.value!""}" border="0">
					[#elseif parameter.dataType=="FILE"]
						<a href="${parameterValue.value!""}" >${parameterValue.value!""}</a>
					[#--如果是长文本，则使用编辑区--]
					${parameterValue.value!""}
					[#elseif parameter.dataType=="DATE"]
						[#if parameterValue.value?exists]${parameterValue.value?string("MM/dd/yyyy")}[/#if]
					[#elseif parameter.dataType=="DATEISO"]
						[#if parameterValue.value?exists]${parameterValue.value?string("yyyy-MM-dd")}[/#if]
					[#elseif parameter.dataType=="DATETIME"]
						[#if parameterValue.value?exists]${parameterValue.value?string("yyyy-MM-dd hh:mm")}[/#if]
					[#elseif parameter.dataType=="FLOAT"||parameter.dataType=="INT"||parameter.dataType=="NUMERIC"]
						[#if "${parameterValue.attributevalue!''}"!=""]${parameterValue.attributevalue?string.number}[/#if]
					[#else]
						${parameterValue.attributevalue!""}
					[/#if]
				[/#if]
			[/#if]

	</td>
		</tr>
		[/#list]
	</table>
[/#macro]