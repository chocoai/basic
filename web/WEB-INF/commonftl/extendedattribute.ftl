[#macro extendedattribute paramList paramMap theForm]
<script type="text/javascript" src="../resource/js/jquery-ui-1.8.5.custom.min.js"></script>
<script type="text/javascript" src="../resource/js/ui.multiselect.js"></script>
<script type="text/javascript" src="../resource/js/jquery.multibox.js"></script>
<script type="text/javascript" src="../resource/js/i18n/ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="../resource/js/jquery-calendar.js"></script>
<link rel="stylesheet" type="text/css" href="../resource/css/jquery-calendar1.css" />
<script src="../resource/js/jquery.validate.js" type="text/javascript"></script> 
<script src="../resource/js/jquery.metadata.js" type="text/javascript"></script>
<script type="text/javascript" src="../resource/js/messages_cn.js"></script>
<script type="text/javascript" src="../resource/js/nicEdit.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="../resource/css/cmxform.css" />
<script type="text/javascript" language="javascript">
[#--规则为:布尔、富文本只有单值，--]
$(function() {
	$("#${theForm}").validate(
	{
		rules: {
			[#assign aa=0]
			[#list paramList as parameter]
			[#if parameter.isEdit && parameter.isView]
			[#if (parameter.dataType=="STRING"||parameter.dataType=="TEXT"||parameter.dataType=="LONGSTRING"
			||parameter.dataType=="FILE"||parameter.dataType=="IMAGE"||parameter.dataType=="ENUM"||parameter.dataType=="DATEISO"
			||parameter.dataType=="TABLE"||parameter.dataType=="DATE"||parameter.dataType=="DATETIME")&& !parameter.isMultivalued]
			[#if parameter.isRequired]
			[#assign aa=aa+1]
			[#if aa>1],[/#if]
			${parameter.id}: {				
				required: true					
			}			
			[/#if]
			[/#if]				
			[#if parameter.dataType=="URL" && !parameter.isMultivalued]
			[#assign aa=aa+1]
			[#if aa>1],[/#if]
			${parameter.id}: {
				url:true
				[#if parameter.isRequired]
				,required: true
				[/#if]							
			}
			[/#if]
			[#if parameter.dataType=="EMAIL" && !parameter.isMultivalued]
			[#assign aa=aa+1]
			[#if aa>1],[/#if]
			${parameter.id}: {
				email:true
				[#if parameter.isRequired]
				,required: true
				[/#if]							
			}
			[/#if]
			[#if parameter.dataType=="PHONE" && !parameter.isMultivalued]
			[#assign aa=aa+1]
			[#if aa>1],[/#if]
			${parameter.id}: {
				digits:true,
				minlength:7,
				maxlength:12
				[#if parameter.isRequired]
				,required: true
				[/#if]							
			}
			[/#if]	
			[#if parameter.dataType=="INT" && !parameter.isMultivalued]
			[#assign aa=aa+1]
			[#if aa>1],[/#if]
			${parameter.id}: {
				digits:true
				[#if parameter.isRequired]
				,required: true
				[/#if]							
			}
			[/#if]	
			[#if (parameter.dataType=="FLOAT"||parameter.dataType=="NUMERIC"||parameter.dataType=="CURRENCY") && !parameter.isMultivalued]
			[#assign aa=aa+1]
			[#if aa>1],[/#if]
			${parameter.id}: {
				number:true
				[#if parameter.isRequired]
				,required: true
				[/#if]							
			}
			[/#if]	
			[#if parameter.dataType=="CREDITCARD" && !parameter.isMultivalued]
			[#assign aa=aa+1]
			[#if aa>1],[/#if]
			${parameter.id}: {
				creditcard:true
				[#if parameter.isRequired]
				,required: true
				[/#if]							
			}
			[/#if]	
			[/#if]
			[/#list] 
		}		
	});
[#--遍历参数--]
[#list paramList as parameter]
[#if parameter.isEdit && parameter.isView]
[#if (parameter.dataType=="DATE" ||parameter.dataType=="DATEISO") && parameter.isMultivalued ]

	$("input[name='${parameter.id}']").each(function(){
		$(this).datepicker({
			changeMonth: true,
			changeYear: true,
			dateFormat:"mm/dd/yy"
		});
	});
[/#if]

[#--parameterValue设置为参数值对象--]
[#if parameter.dataType=="ENUM" && parameter.isMultivalued]
	$("#${parameter.id}").multiselect({width:500});
[#elseif parameter.isMultivalued && parameter.dataType!="BOOLEAN"]
	$("#addParam_${parameter.id}").multibox({
	[#if parameter.dataType=="TABLE"]
		width:290,
		sortable:true,
		template:'<input type="hidden" value="" name="${parameter.id}" class="unique"><input type="text" size="30">',
		addClick:function(){
			[#if parameter.dialog_url?exists&&parameter.dialog_url!=""&&parameter.dialog_url!=" "]
			var returnvalue=window.showModalDialog("${parameter.dialog_url}", "", "dialogWidth=450px;dialogHeight=300px");
			[#else]
			var returnvalue=window.showModalDialog("manager.system.dialog?refer=${parameter.referTo}", "", "dialogWidth=450px;dialogHeight=300px");
			[/#if]
			if(returnvalue!=null){
				$("#addParam_${parameter.id}").multibox("addValue",returnvalue);
			}
		}
	[#elseif parameter.dataType=="LONGSTRING"]
		width:400,
		sortable:true,
		template:'<textarea name="${parameter.id}" value="" rows="4" cols="50"/>',
		add:function(event,ui){
			ui.css("height","90px");
		},
		load:function(event,ui){
			ui.find("li").css("height","90px");
		}
	[#elseif parameter.dataType=="DATEISO"]
		width:220,
		sortable:true,
		template:'<input type="text" value="" name="${parameter.id}" class="dateISO">',
		add:function(event,ui){
			ui.find("input").datepicker({
				changeMonth: true,
				changeYear: true,
				dateFormat:"yy-mm-dd"
			});
		}
	[#elseif parameter.dataType=="DATE"]
		width:220,
		sortable:true,
		template:'<input type="text" value="" name="${parameter.id}" class="date">',
		add:function(event,ui){
			ui.find("input").datepicker({
				changeMonth: true,
				changeYear: true,
				dateFormat:"mm/dd/yy"
			});
		}
	[#else]
		width:260,
		sortable:true,
		template:'<input type="text" value="" size="20" name="${parameter.id}" class="[#if parameter.dataType=="INT"]digits[#elseif parameter.dataType=="FLOAT"]number[/#if]">'
	[/#if]
	});
	
[#else]
	[#if parameter.dataType=="TABLE"]
	$("#button_${parameter.id}").click(function(){
		[#if parameter.dialog_url?exists&&"${parameter.dialog_url!''}"!=""&&"${parameter.dialog_url!''}"!=" "]
		var returnvalue=window.showModalDialog("${parameter.dialog_url}", "", "dialogWidth=450px;dialogHeight=500px");
		[#else]
		var returnvalue=window.showModalDialog("manager.system.dialog?refer=${parameter.referTo}", "", "dialogWidth=450px;dialogHeight=600px");
		[/#if]
		if(returnvalue!=null){
			$("#value_${parameter.id}").attr("value",returnvalue[0]);
			$("#name_${parameter.id}").attr("value",returnvalue[1]);
		}
	});
	[#elseif parameter.dataType=="TEXT"]
	new nicEditor().panelInstance('text_${parameter.id}',{hasPanel : true});
	[#elseif parameter.dataType=="DATEISO"]
	$('#datepicker_${parameter.id}').datepicker({
		changeMonth: true,
		changeYear: true,
		dateFormat:"yy-mm-dd"
	});
	[#elseif parameter.dataType=="DATE"]
	$('#datepicker_${parameter.id}').datepicker({
		changeMonth: true,
		changeYear: true,
		dateFormat:"mm/dd/yy"
	});
	[#elseif parameter.dataType=="DATETIME"]
	$('#datepicker_${parameter.id}').calendar();
	[/#if]
[/#if]
[/#if]
[/#list]
});

function viewpic(id){
	window.open(document.getElementById(id).value);
}

function returnvalue(id,data){
	if(id.indexOf("file_")!= -1){
		var dataObj=eval("("+data+")");
		var file_id=dataObj.save_name;
		if(file_id!=""){	
			var aa="commonservice.download?file_id="+file_id+"&path=files/";
			document.getElementById(id).value=aa;
		}else{
			document.getElementById(id).value="";
		}
	}else{
		document.getElementById(id).value=data;
	}
}
</script>

<table  width="100%" style="table-layout:fixed;">
	<col width=20%><col>
	[#--遍历参数--]
	[#list paramList as parameter]
	
	[#--parameterValue设置为参数值对象，即从paramMap中以参数ID为键取值，值是一个map：value-原始值，attributevalue-处理后的值，attribute-属性定义（AttributeDefine对象）--]
	[#assign parameterValue=paramMap[parameter.id]/]

		<tr>
			<td class="detail_attname">${parameter.name}</td>
			<td>
			[#--枚举处理比较简单，显示为select标签--]
			[#if parameter.dataType=="ENUM"]
			[#if parameter.isEdit]
				<select name="${parameter.id}" id="${parameter.id}" [#if parameter.isMultivalued] multiple size=3 style="width:400px" [/#if] class="${parameter.dataType}">
				[#if parameterValue.attributevalue?exists]
				[#list parameterValue.attributevalue as enumItem]
				<option value="${enumItem.enum_value}" [#if enumItem.selected==true] selected="true" [/#if]>${enumItem.enum_name}</option>
				[/#list]
				[/#if]
				</select>
			[#else]
			[#if parameterValue.attributevalue?exists]
				[#list parameterValue.attributevalue as enumItem]
				[#if enumItem.selected==true]${enumItem.enum_name}(${enumItem.enum_value})[/#if]
				[/#list]
			[/#if]
			[/#if]
			[#--布尔值需要用复选框,且多值无意义，按单值处理--]
			[#elseif parameter.dataType=="BOOLEAN"]
			[#if parameter.isEdit]
				<input type="radio" name="${parameter.id}" [#if parameterValue.attributevalue] checked [/#if] value="y">是
				<input type="radio" name="${parameter.id}" [#if !parameterValue.attributevalue] checked [/#if] value="n">否
			[#else][#if parameterValue.attributevalue]是[#else]否[/#if]
			[/#if]
			[#--富媒体值多值无意义，都按单值处理--]
			[#elseif parameter.dataType=="TEXT"]
			[#if parameter.isEdit]
				<textarea name="${parameter.id}" id="text_${parameter.id}"  rows="6" cols="80">${parameterValue.value!""}</textarea>
			[#else]${parameterValue.value!""}
			[/#if]
			[#else]
				[#--非枚举时，多值使用multibox组件，按值数量遍历放多个li标签--]
				[#if parameter.isMultivalued]
					
					<ul id="addParam_${parameter.id}">
					[#if parameter.dataType=="TABLE"]
					[#--如果是字典表类型，每个li两个域，分别放主键和显示字段--]
						[#if parameterValue.attributevalue?exists]
						[#list parameterValue.attributevalue as rowItem]
						[#if parameter.isEdit]
							<li><input type="hidden" size="20" name="${parameter.id}" id="${parameter.id}" value="${rowItem.value!""}"><input type="text" size="30" readonly value="${rowItem.display_value!""}"></li>
						[#else]
							<li>${rowItem.display_value!""}</li>
						[/#if]
						[/#list]
						[/#if]
					[#else]
						[#--不是字典表则将会是数组，每个li只一个域放值本身--]
						[#if parameterValue.attributevalue?exists]
						[#list parameterValue.attributevalue as row]
						
						[#--长文本需要用textarea--]
						[#if parameter.dataType=="LONGSTRING"]
						[#if parameter.isEdit]
							<li><textarea name="${parameter.id}"  rows="4" cols="50" id="${parameter.id}" >${row!""}</textarea></li>
						[#else]
							<li>${row!""}</li>
						[/#if]
						[#--上传域--]
						[#elseif parameter.dataType=="IMAGE"]
						
						[#elseif parameter.dataType=="DATE"]
						[#if parameter.isEdit]
							<li><input type="text" size="20"  name="${parameter.id}" id="${parameter.id}" value="${row?string("MM/dd/yyyy")}"></li>
						[#else]
							<li>${row?string("MM/dd/yyyy")}</li>
						[/#if]
						[#elseif parameter.dataType=="DATEISO"]
						[#if parameter.isEdit]
							<li><input type="text" size="20"  name="${parameter.id}" id="${parameter.id}" value="${row?string("yyyy-MM-dd")}"></li>
						[#else]
							<li>${row?string("yyyy-MM-dd")}</li>
						[/#if]
						[#else]
						[#if parameter.isEdit]
							<li><input type="text" size="20" class="${parameter.dataType}" name="${parameter.id}"  id="${parameter.id}" value="${row}"></li>
						[#else]
							<li>${row}</li>
						[/#if]
						[/#if]
						[/#list]
						[/#if]

					[/#if]
					</ul>

				[#--单值则根据数据类型分别处理--]
				[#else]
					[#--如果是表，则处理为两个域--]
					[#if parameter.dataType=="TABLE"]
					[#if parameter.isEdit]
						<input type="hidden" name="${parameter.id}" id="value_${parameter.id}" class="request" value="${parameterValue.value!""}">
						<input type="test" readonly value="[#if parameterValue.attributevalue?exists]${parameterValue.attributevalue.display_value!""}[/#if]" size="30" id="name_${parameter.id}">
						<!--span class="ui-button" style="text-align:left;"-->
						<input type="button" id="button_${parameter.id}" value="浏览"><!--/span-->
					[#else]
						[#if parameterValue.attributevalue?exists]${parameterValue.attributevalue.display_value!""}[/#if]
					[/#if]
					[#--如果是图片和文件，则使用上传组件--]
					[#elseif parameter.dataType=="IMAGE"]
					[#if parameter.isEdit]	
					[#if "${parameterValue.value!''}"!="null"][#assign imagevalue=parameterValue.value!""][#else][#assign imagevalue=""][/#if]
						<input type="hidden" name="${parameter.id}" id="images_${parameter.id}" value="${imagevalue!""}" size="30"/>					
						<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="300" height="35"><param name="movie" value="/resource/jsp/fileupload.swf" />
						<param name="flashvars" value="action=/eap/manager.system.upload&savepath=images/&fieldname=images_${parameter.id}&type=image&oldname=${imagevalue!""}" /><param name="menu" value="false" /><param name="wmode" value="transparent" />
						<embed src="/resource/jsp/fileupload.swf" wmode="transparent" flashvars="action=/eap/manager.system.upload&savepath=images/&fieldname=images_${parameter.id}&type=image&oldname=${imagevalue!""}" menu="false" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="300" height="35"></embed></object>					
					[#else]
						<img src="${imagevalue!""}" border="0"/>
					[/#if]
					[#elseif parameter.dataType=="FILE"]
					[#if parameter.isEdit]
					[#if "${parameterValue.value!''}"!="null"][#assign filevalue=parameterValue.value!""][#else][#assign filevalue=""][/#if]
						<input type="hidden" name="${parameter.id}" id="file_${parameter.id}" value="${filevalue!""}" size="30"/>				
						<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" 
						codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="300" height="35">
						<param name="movie" value="/resource/jsp/fileupload.swf" />
						<param name="flashvars" 
						value="action=/eap/commonservice.upload&savepath=files/&fieldname=file_${parameter.id}&id=0&type=all&oldname=${filevalue!""}" />
						<param name="menu" value="false" />
						<param name="wmode" value="transparent" />
						<embed src="/resource/jsp/fileupload.swf" wmode="transparent" 
						flashvars="action=/eap/commonservice.upload&savepath=files/&fieldname=file_${parameter.id}&id=0&type=all&oldname=${filevalue!""}" 
						menu="false" pluginspage="http://www.macromedia.com/go/getflashplayer"
						 type="application/x-shockwave-flash" width="300" height="35"></embed>
						 </object>	
					[#else]
						<a href="${filevalue!""}">${filevalue!""}</a>
					[/#if]				
					[#--如果是长文本，则使用编辑区--]
					[#elseif parameter.dataType=="LONGSTRING"]
					[#if parameter.isEdit]
						<textarea name="${parameter.id}" value="" rows="4" cols="50">${parameterValue.value!""}</textarea>
					[#else]
						${parameterValue.value!""}
					[/#if]
					[#--如果是多媒体文本，则使用在线编辑器--]
					[#elseif parameter.dataType=="TEXT"]
					[#if parameter.isEdit]
						<textarea name="${parameter.id}" id="text_${parameter.id}"  rows="6" cols="80">${parameterValue.value!""}</textarea>
					[#else]
						${parameterValue.value!""}
					[/#if]
					[#elseif parameter.dataType=="DATE"]
					[#if parameter.isEdit]
						<input type="text" name="${parameter.id}"  class="date" id="datepicker_${parameter.id}" size="30" value="[#if parameterValue.value?exists]${parameterValue.value?string("MM/dd/yyyy")}[/#if]"/>
					[#else]
						[#if parameterValue.value?exists]${parameterValue.value?string("MM/dd/yyyy")}[/#if]
					[/#if]
					[#elseif parameter.dataType=="DATEISO"]
					[#if parameter.isEdit]
						<input type="text" name="${parameter.id}"  class="dateISO" id="datepicker_${parameter.id}" size="30" value="[#if parameterValue.value?exists]${parameterValue.value?string("yyyy-MM-dd")}[/#if]"/>
					[#else]
						[#if parameterValue.value?exists]${parameterValue.value?string("yyyy-MM-dd")}[/#if]
					[/#if]
					[#elseif parameter.dataType=="DATETIME"]
					[#if parameter.isEdit]
						<input type="text" name="${parameter.id}"  class="date" id="datepicker_${parameter.id}" size="30" value="[#if parameterValue.value?exists]${parameterValue.value?string("yyyy-MM-dd hh:mm")}[/#if]"/>
					[#else]
						[#if parameterValue.value?exists]${parameterValue.value?string("yyyy-MM-dd hh:mm")}[/#if]
					[/#if]
					[#elseif parameter.dataType=="FLOAT"||parameter.dataType=="INT"||parameter.dataType=="NUMERIC"]
					[#if parameter.isEdit]
						<input type="text" id="${parameter.id}" name="${parameter.id}" size="30" value="[#if "${parameterValue.attributevalue!''}"!=""]${parameterValue.attributevalue?string.number}[/#if]" class="number">
					[#else]
						[#if "${parameterValue.attributevalue!''}"!=""]${parameterValue.attributevalue?string.number}[/#if]
					[/#if]
					[#elseif parameter.dataType=="STRING"]
					[#if parameter.isEdit]
						<input type="text" id="${parameter.id}" name="${parameter.id}" size="30" value="${parameterValue.attributevalue!''}">
					[#else]
						${parameterValue.attributevalue!''}
					[/#if]
					[#else]
					[#if parameter.isEdit]
						<input type="text" id="${parameter.id}" name="${parameter.id}" size="30" value="${parameterValue.attributevalue!''}" class="${parameter.dataType}">
					[#else]
						${parameterValue.attributevalue!''}
					[/#if]
					[/#if]
				[/#if]
			[/#if]
			[#if parameter.isRequired]&nbsp;<font color="red">必填</font>&nbsp;[/#if]
			${parameter.description!""}
			

	</td>
		</tr>
		
		[/#list]
	</table>
[/#macro]