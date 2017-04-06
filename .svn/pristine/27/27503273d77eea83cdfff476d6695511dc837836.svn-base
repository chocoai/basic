<script src="${_share_file_url!''}/resource/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" language="javascript">
function changeshow(){
	if($("#health_type").val()=="1"){
		//检查
		$(".jc").css("display","block");
		$(".jc1").css("display","block");
		$(".jc1").attr("id","health_grade");
		$(".jd").css("display","none");	
		$(".jd1").css("display","none");	
		$(".jd1").removeAttr("id");	
	}
	if($("#health_type").val()=="2"){
		//鉴定
		$(".jd").css("display","block");
		$(".jd1").css("display","block");
		$(".jd1").attr("id","health_grade");
		$(".jc").css("display","none");	
		$(".jc1").css("display","none");	
		$(".jc1").removeAttr("id");
	}
}
$(function(){
	//表格
	var url="";
	[#if access.canDo(user,'safecheck.building.pop')]
		url='${_servlet_url!''}/safecheck.building.poplistjson?health_type=2';
	[#elseif access.canDo(user,'safecheck.building.pop1')] 
		url='${_servlet_url!''}/safecheck.building.poplistjson1?health_type=2';
	[/#if]
	jQuery("#clist1").jqGrid({
	   	url:url,
		datatype: "json",
		width:600,
		height:300,
	   	colNames:[
			"building_id"
			,"楼幢新坐落"
			,"楼幢坐落"
			,"所属区域"
			,"房屋产别"
			,"设计用途"
			,"建成时间"
			,"房屋结构"
			,"房屋安全情况"
			,"鉴定健康等级"
			,"定位"
	   	],
	   	colModel:[
			{name:'building_id',index:'building_id',sortable:true,hidden:true}
			,{name:'check_address',index:'check_address',sortable:true}
			,{name:'building_address',index:'building_address',sortable:true}
			,{name:'builiding_region',index:'builiding_region',sortable:true,width:20}
			,{name:'real_type',index:'real_type',sortable:true,width:35}
			,{name:'use_desgin',index:'use_desgin',sortable:true,width:25}
			,{name:'building_date',index:'building_date',sortable:true,width:20}
			,{name:'build_struct',index:'build_struct',sortable:true,width:25}
			,{name:'health_grade_pc',index:'health_grade_pc',sortable:true,width:40}
			,{name:'health_grade_jd',index:'health_grade_jd',sortable:true,width:50}
			,{name:'dw',index:'dw',width:40}
	   	],
	   	rowNum:10,
	   	autowidth: true,
	   	rowList:[10,20,30],
	   	pager: '#pager1',
	   	sortname: 'building_id',
	    viewrecords: true,
	    sortorder: "asc",
	    rownumbers:true,
	    caption:"隐患房屋列表"
	});
	jQuery("#clist1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false,refreshtext:'刷新'});
	
	//模糊查询					
	jQuery("#gridReload").click(function() {
		var url="";
		[#if access.canDo(user,'safecheck.building.pop')]
			url='${_servlet_url!''}/safecheck.building.poplistjson?';
		[#elseif access.canDo(user,'safecheck.building.pop1')] 
			url='${_servlet_url!''}/safecheck.building.poplistjson1?';
		[/#if]
		url+="building_address="+$("#building_address").val()+"&"
		+"builiding_region="+$("#builiding_region").val()+"&"
		+"real_type="+$("#real_type").val()+"&"
		+"use_desgin="+$("#use_desgin").val()+"&"
		+"building_date="+$("#building_date").val()+"&"
		+"build_struct="+$("#build_struct").val()+"&"
		+"health_type="+$("#health_type").val()+"&"
		+"health_grade="+$("#health_grade").val();
		var url2 = encodeURI(url);
		jQuery("#clist1").jqGrid('setGridParam',{url:url2,page:1}).trigger('reloadGrid');
	});
	//查看信息按钮
	$("#selectInfo").click(function(){
		var id = jQuery("#clist1").jqGrid('getGridParam','selrow');
		if (id) { 
			var ret = jQuery("#clist1").jqGrid('getRowData',id);
			window.location="${_servlet_url!''}/safecheck.buildingbase.detail?building_id="+ret.building_id;	
		}else{
			alert("请选择一条记录！");
		}
	});	
	changeshow();
});
//清空查询条件
function emptiedAndSubmit(){
	$("#building_address").val("");
	$("#builiding_region").val("");
	$("#real_type").val("");
	$("#use_desgin").val("");
	$("#building_date").val("");
	$("#build_struct").val("");
	$("#health_type").val("2");
	$("#health_grade").val("");
	changeshow();
	//表格
	var url="";
	[#if access.canDo(user,'safecheck.building.pop')]
		url='${_servlet_url!''}/safecheck.building.poplistjson?health_type=2';
	[#elseif access.canDo(user,'safecheck.building.pop1')] 
		url='${_servlet_url!''}/safecheck.building.poplistjson1?health_type=2';
	[/#if]
	var url2=encodeURI(url);
    jQuery("#clist1").jqGrid('setGridParam',{url:url2,page:1}).trigger("reloadGrid");
}

</script>
<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
<div class="skin_search ui-widget-content" style="padding:.2em;margin-bottom:8px;">
	<form name="dic_form" id="dic_form" action="" method="post">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<tr>
		<td class="td12">楼幢坐落:</td>
		<td class="td13" colspan="3">
		<input type="text" size="40" name="building_address" id="building_address"/>
		</td>
		<td class="td12">所属区域:</td>
		<td class="td13">
			<select id="builiding_region" name="builiding_region" [#if access.canDo(user,'safecheck.building.pop')][#if block.builiding_region?exists && "${block.builiding_region!''}"!='']disabled="true"[/#if][/#if]>
			<option value="">------请选择------</option>
			[#list EnumService.getEnum('xzqh') as enum]
			<option value="${enum.enum_value!''}" [#if access.canDo(user,'safecheck.building.pop')][#if "${block.builiding_region!''}"=="${enum.enum_value!''}"] selected="true" [/#if][/#if]>${enum.enum_name!''}</option>
			[/#list]
			</select>
		</td>
		<td class="td12">房屋产别:</td>
		<td class="td13">
			<select id="real_type" name="real_type">
			<option value="">------请选择------</option>
			[#list EnumService.getEnum('fwcb') as enum]
			<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
			[/#list]
			</select>
		</td>
		<td class="td12">设计用途:</td>
		<td class="td13">
			<select id="use_desgin" name="use_desgin">
			<option value="">------请选择------</option>
			[#list EnumService.getEnum('sjyt') as enum]
			<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
			[/#list]
			</select>
		</td>
		</tr>
		<tr>
		<td class="td12">建成时间:</td>
		<td class="td13">
		<input type="text" size="10" name="building_date" id="building_date" onClick="WdatePicker({dateFmt:'yyyy'})"/>
		</td>
		<td class="td12">房屋结构:</td>
		<td class="td13">
			<select id="build_struct" name="build_struct">
			<option value="">------请选择------</option>
			[#if EnumService.getEnum('fwjg')?exists]
			[#list EnumService.getEnum('fwjg') as enum]
			<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
			[/#list]
			[/#if]
			</select>
		</td>
		<td class="td12">查询类型:</td>
		<td class="td13">
			<select name="health_type" id="health_type" onchange="changeshow();">
			<option value="1">检查</option>
			<option value="2"  selected="true">鉴定</option>
			</select>
		</td>
		<td class="td12">
		<span class="jd">健康等级:</span>
		<span class="jc">安全情况:</span>
		</td>
		<td class="td13">
			<select name="health_grade" class="jd1">
			<option value="">------请选择------</option>
			<option value="2" [#if "${block.jdgrade!''}"=="2"] selected="true" [/#if]>B级</option>
			<option value="3" [#if "${block.jdgrade!''}"=="3"] selected="true" [/#if]>C级</option>
			<option value="4" [#if "${block.jdgrade!''}"=="4"] selected="true" [/#if]>D级</option>
			</select>
			<select name="health_grade" class="jc1">
			<option value="">------请选择------</option>
			<option value="2" [#if "${block.jdgrade!''}"=="2"] selected="true" [/#if]>存在危险点房屋</option>
			<option value="3" [#if "${block.jdgrade!''}"=="3"] selected="true" [/#if]>局部危险房屋</option>
			<option value="4" [#if "${block.jdgrade!''}"=="4"] selected="true" [/#if]>整幢危险房屋</option>
			</select>
		</td>
		<td class="td13" colspan="2"><button type="button" id="gridReload">查询</button><button onclick="emptiedAndSubmit()" style="margin-left:10px;">重置查询条件</button></td>
		</tr>
		</table>
	</form>
</div>
<!-- div  id="buttons" style="text-align:right;margin-bottom:8px;">
	<button type="button" id="selectInfo" align="right">查看</button>
</div -->
<div id="pager1"></div>
<table id="clist1"></table>			
