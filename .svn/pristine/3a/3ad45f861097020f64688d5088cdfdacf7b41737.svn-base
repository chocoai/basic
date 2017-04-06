[#macro extendedattribute paramList paramMap theForm]
<script type="text/javascript" language="javascript">
function extendedinit(){
	$("#${theForm}").validate({
	rules: {
			[#assign aa=0]
			[#list paramList as parameter]			
			[#if parameter.dataType=="URL" && !parameter.isMultivalued]
			[#assign aa=aa+1]
			[#if aa>1],[/#if]
			${parameter.id}: {
				url:true							
			}
			[/#if]
			[#if parameter.dataType=="EMAIL" && !parameter.isMultivalued]
			[#assign aa=aa+1]
			[#if aa>1],[/#if]
			${parameter.id}: {
				email:true							
			}
			[/#if]
			[#if parameter.dataType=="PHONE" && !parameter.isMultivalued]
			[#assign aa=aa+1]
			[#if aa>1],[/#if]
			${parameter.id}: {
				digits:true,
				minlength:7,
				maxlength:12						
			}
			[/#if]	
			[#if parameter.dataType=="INT" && !parameter.isMultivalued]
			[#assign aa=aa+1]
			[#if aa>1],[/#if]
			${parameter.id}: {
				digits:true						
			}
			[/#if]	
			[#if (parameter.dataType=="FLOAT"||parameter.dataType=="NUMERIC"||parameter.dataType=="CURRENCY") && !parameter.isMultivalued]
			[#assign aa=aa+1]
			[#if aa>1],[/#if]
			${parameter.id}: {
				number:true							
			}
			[/#if]	
			[#if parameter.dataType=="CREDITCARD" && !parameter.isMultivalued]
			[#assign aa=aa+1]
			[#if aa>1],[/#if]
			${parameter.id}: {
				creditcard:true											
			}
			[/#if]	
			[/#list] 
		}
	});
[#--遍历参数--]
[#list paramList as parameter]
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
	$("#${parameter.id}").multiselect();
[#elseif parameter.isMultivalued && parameter.dataType!="BOOLEAN"]
	[#if parameter.dataType=="TEXT"]
	$("textarea[name='${parameter.id}']").each(function(){
		new nicEditor().panelInstance($(this).attr("id"));
	});
	[#else]
	$("#addParam_${parameter.id}").multibox({
	[#if parameter.dataType=="TABLE"]
		width:290,
		sortable:true,
		template:'<input type="hidden" value="" name="${parameter.id}" class="unique"><input type="text" size="30">',
		addClick:function(){
			[#if parameter.dialog_url?exists]
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
		template:'<textarea name="${parameter.id}" value="" rows="4" cols="50" class="required"/>',
		add:function(event,ui){
			ui.css("height","90px");
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
	[#elseif parameter.dataType=="STRING"]
		width:260,
		sortable:true,
		template:'<input type="text" value="" size="20" name="${parameter.id}" class="required">'
	[#elseif parameter.dataType=="INT"]
		width:260,
		sortable:true,
		template:'<input type="text" value="" size="20" name="${parameter.id}" class="digits">'
	[#elseif parameter.dataType=="FLOAT" || parameter.dataType=="NUMERIC"]
		width:260,
		sortable:true,
		template:'<input type="text" value="" size="20" name="${parameter.id}" class="number">'
	[#else]
		width:260,
		sortable:true,
		template:'<input type="text" value="" size="20" name="${parameter.id}">'
	[/#if]
	});
	[/#if]
[#else]
	[#if parameter.dataType=="TABLE"]
	$("#button_${parameter.id}").click(function(){
		[#if parameter.dialog_url?exists&&"${parameter.dialog_url!''}"!=""]
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
	//new nicEditor().panelInstance('text_${parameter.id}');
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
[/#list]
}
function addtext(e,name){
	var e   =   window.event||e;  
	var obj=e.srcElement || e.target;
	$(obj).parent().append('<textarea name="'+name+'" rows="6" cols="80" /><button type="button">删除</button>');
	alert($(obj).parent().find("textarea").length);
	var newId=name+"_"+$(obj).parent().find("textarea").length;
	alert($(obj).parent().find("textarea").attr("name"));
	$(obj).parent().find("textarea:last").attr("id",newId);
	new nicEditor().panelInstance(newId);
}
function viewpic(id){
	window.open(document.getElementById(id).value);
}

function returnvalue(id,data){
	if(id.indexOf("file_")!= -1){
		var num1=data.indexOf("#");
		var file_id=data.substring(0,num1);	
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

<table  width="100%">
	[#--遍历参数--]
	[#list paramList as parameter]
	[#--parameterValue设置为参数值对象，即从paramMap中以参数ID为键取值，值是一个map：value-原始值，attributeValue-处理后的值，attribute-属性定义（AttributeDefine对象）--]
	[#assign parameterValue=paramMap[parameter.id]/]

		<tr>
			<td class="detail_attname">${parameter.name}</td>
			<td>
			[#--枚举处理比较简单，显示为select标签--]
			[#if parameter.dataType=="ENUM"]
				<select name="${parameter.id}" id="${parameter.id}" [#if parameter.isMultivalued] multiple size=3 style="width:400px" [/#if] class="${parameter.dataType}">
				[#if parameterValue.attributevalue?exists]
				[#list parameterValue.attributevalue as enumItem]
				<option value="${enumItem.enum_value}" [#if enumItem.selected==true] selected="true" [/#if]>${enumItem.enum_name}</option>
				[/#list]
				[/#if]
				</select>
			[#--布尔值需要用复选框,且多值无意义，按单值处理--]
			[#elseif parameter.dataType=="BOOLEAN"]
				<input type="checkbox" name="${parameter.id}" [#if parameterValue.attributevalue] checked="true" [/#if] value="y">
			[#else]
				[#--非枚举时，多值使用multibox组件，按值数量遍历放多个li标签--]
				[#if parameter.isMultivalued]
					[#--多媒体编辑器不使用multibox组件--]
					[#if parameter.dataType=="TEXT"]
						<div>
						<button type="button" onclick="addtext(event,'${parameter.id}')">增加</button>
						[#list parameterValue.attributevalue as rowItem]
							<textarea name="${parameter.id}" id="${parameter.id}_${rowItem_index}">${rowItem.display_value!""}</textarea><button type="button">删除</button>
						[/#list]
						</div>
					[#else]
					<ul id="addParam_${parameter.id}">
					[#if parameter.dataType=="TABLE"]
					[#--如果是字典表类型，每个li两个域，分别放主键和显示字段--]
						[#list parameterValue.attributevalue as rowItem]
							<li><input type="hidden" size="20" name="${parameter.id}" value="${rowItem.value!""}"><input type="text" size="20" readonly value="${rowItem.display_value!""}"></li>
						[/#list]
					[#else]
						[#--不是字典表则将会是数组，每个li只一个域放值本身--]
						[#if parameterValue.attributevalue?exists]
						[#list parameterValue.attributevalue as row]
						
						[#--长文本需要用textarea--]
						[#if parameter.dataType=="LONGSTRING"]
							<li><textarea name="${parameter.id}"  rows="4" cols="50" class="required">${parameterValue.value!""}</textarea></li>
						[#--text文本需要用textarea--]
						[#elseif parameter.dataType=="TEXT"]
							<li><textarea name="${parameter.id}" rows="6" cols="80">${parameterValue.value!""}</textarea></li>
						[#--上传域--]
						[#elseif parameter.dataType=="IMAGE"]
						
						[#elseif parameter.dataType=="DATE"]
							<li><input type="text" size="20"  name="${parameter.id}" value="${row?string("MM/dd/yyyy")}"></li>
						[#elseif parameter.dataType=="DATEISO"]
							<li><input type="text" size="20"  name="${parameter.id}" value="${row?string("yyyy-MM-dd")}"></li>
						[#elseif parameter.dataType=="DATETIME"]
							<li><input type="text" size="20"  name="${parameter.id}" value="${row?datetime}"></li>	
						[#elseif parameter.dataType=="FLOAT"||parameter.dataType=="NUMERIC"]
							<li><input type="text" id="${parameter.id}" name="${parameter.id}" size="30" value="[#if "${parameterValue.attributevalue!''}"!=""]${parameterValue.attributevalue?string.number}[/#if]" class="number"></li>
						[#elseif parameter.dataType=="INT"]
							<li><input type="text" id="${parameter.id}" name="${parameter.id}" size="30" value="[#if "${parameterValue.attributevalue!''}"!=""]${parameterValue.attributevalue?string.number}[/#if]" class="digits"></li>
						[#elseif parameter.dataType=="STRING"]
							<li><input type="text" name="${parameter.id}" size="30" value="${parameterValue.value!""}" class="required"></li>
						[#else]
							<li><input type="text" size="20" readonly name="${parameter.id}" value="${row}"></li>
						[/#if]
						[/#list]
						[/#if]

					[/#if]
					</ul>
					[/#if]
				[#--单值则根据数据类型分别处理--]
				[#else]
					[#--如果是表，则处理为两个域--]
					[#if parameter.dataType=="TABLE"]
						<input type="hidden" name="${parameter.id}" id="value_${parameter.id}" class="request" value="${parameterValue.value!""}"><input type="test" readonly  size="30" id="name_${parameter.id}" value="${parameterValue.value!""}">
						<span class="ui-button" style="text-align:left;">
						<input type="button" id="button_${parameter.id}" value="浏览"></span>
					[#--如果是图片和文件，则使用上传组件--]
					[#elseif parameter.dataType=="IMAGE"]
					[#if "${parameterValue.value!''}"!="null"][#assign imagevalue=parameterValue.value!""][#else][#assign imagevalue=""][/#if]
						<input type="hidden" name="${parameter.id}" id="images_${parameter.id}" value="${imagevalue!""}" size="30"/>
						<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="300" height="35"><param name="movie" value="/resource/jsp/fileupload.swf" />
						<param name="flashvars" value="action=/eap/manager.system.upload&savepath=images/&fieldname=images_${parameter.id}&type=image&oldname=${imagevalue!""}" /><param name="menu" value="false" /><param name="wmode" value="transparent" />
						<embed src="/resource/jsp/fileupload.swf" wmode="transparent" flashvars="action=/eap/manager.system.upload&savepath=files/&fieldname=images_${parameter.id}&type=image&oldname=${imagevalue!""}" menu="false" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="300" height="35"></embed></object>
					[#elseif parameter.dataType=="FILE"]
					[#if "${parameterValue.value!''}"!="null"][#assign filevalue=parameterValue.value!""][#else][#assign filevalue=""][/#if]
						<input type="hidden" name="${parameter.id}" id="file_${parameter.id}" value="${filevalue!""}" size="30"/>
						<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="300" height="35"><param name="movie" value="/resource/jsp/fileupload.swf" />
						<param name="flashvars" value="action=/eap/commonservice.upload&savepath=images/&fieldname=file_${parameter.id}&type=all&oldname=${filevalue!""}&id=0" /><param name="menu" value="false" /><param name="wmode" value="transparent" />
						<embed src="/resource/jsp/fileupload.swf" wmode="transparent" flashvars="action=/eap/manager.system.upload&savepath=files/&fieldname=file_${parameter.id}&type=all&oldname=${filevalue!""}&id=0" menu="false" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="300" height="35"></embed></object>
					[#--如果是长文本，则使用编辑区--]
					[#elseif parameter.dataType=="LONGSTRING"]
						<textarea name="${parameter.id}" rows="4" cols="50">${parameterValue.value!""}</textarea>
					[#--如果是多媒体文本，则使用在线编辑器--]
					[#elseif parameter.dataType=="TEXT"]
						<textarea name="${parameter.id}" id="text_${parameter.id}" rows="6" cols="80">${parameterValue.value!""}</textarea>
					[#elseif parameter.dataType=="DATE"]
						<input type="text" name="${parameter.id}"  class="${parameter.dataType}" id="datepicker_${parameter.id}" size="30" value="${parameterValue.value!""}"/>
					[#elseif parameter.dataType=="DATEISO"]
						<input type="text" name="${parameter.id}"  class="${parameter.dataType}" id="datepicker_${parameter.id}" size="30" value="${parameterValue.value!""}"/>
					[#elseif parameter.dataType=="DATETIME"]
						<input type="text" name="${parameter.id}"  class="${parameter.dataType}" id="datepicker_${parameter.id}" size="30" value="${parameterValue.value!""}"/>
					[#elseif parameter.dataType=="FLOAT"||parameter.dataType=="INT"||parameter.dataType=="NUMERIC"]
						<input type="text" id="${parameter.id}" name="${parameter.id}" size="30" value="[#if "${parameterValue.attributevalue!''}"!=""]${parameterValue.attributevalue?string.number}[/#if]" class="number">
					[#elseif parameter.dataType=="STRING"]
						<input type="text" id="${parameter.id}" name="${parameter.id}" size="30" value="${parameterValue.attributevalue!''}" class="required">
					[#else]
						<input type="text" name="${parameter.id}" size="30" value="${parameterValue.value!""}" class="${parameter.dataType}">
					[/#if]
				[/#if]
			[/#if]
			${parameter.description!""}

	</td>
		</tr>
		[/#list]
	</table>
[/#macro]