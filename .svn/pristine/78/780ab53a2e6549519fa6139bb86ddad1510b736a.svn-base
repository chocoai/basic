<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
.tdpad {padding-left:4px; background-color:#ffffff}
.td_title {text-align:right;padding-right:4px; background-color:#ffffff}
</style>
<script type="text/javascript" >

function downLoad(param){
if(param!=null){
 //var a=window.open("${_servlet_url!''}/realtygis.buildingbasicproduct?building_id="+param,"_blank", "width=0, height=0,status=0");             
//$.ajax("${_servlet_url!''}/realtygis.buildingbasicproduct?building_id="+param);
		window.location.href="${_servlet_url!''}/realtygis.buildingbasicproduct?building_id="+param;
   }
}

</script>
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<col width="10%"><col width="40%"><col width="10%"><col width="40%">
			[#list map.list as item]
			<!--<tr>
				<td class="td12">楼幢编号</td><td class="td13">${item.building_id!''}</td>
				<td class="td12">地理表关联码</td><td class="td13">${item.building_mapid!''}</td>
				<td class="td12">项目编号</td><td class="td13">${item.surverbasic_id!''}</td>
			</tr>-->
			<tr>
				<td class="td12">项目名称</td><td class="td13">${item.surverbasic_name!''}</td>
				<td class="td12">所属城区</td><td class="td13">
				[#if EnumService.getEnum('xzqh')?exists]
				    [#list EnumService.getEnum('xzqh') as enum]
							[#if "${item.city_district!''}" == "${enum.enum_value!''}"]
								${enum.enum_name!''}
							[/#if]
					[/#list]
				[/#if]
				</td>
			</tr>
			<tr>
				<td class="td12">委托单位</td><td class="td13">${item.entrust_unit!''}</td>
				<td class="td12">联系电话</td><td class="td13">${item.linkman_tel!''}</td>
			</tr>
			<tr>
				<td class="td12">面积</td><td class="td13">${item.surverarea_value!''}</td>
				<td class="td12">测绘报告</td><td class="td13">
				[#if item.projectfile_fileblob?exists]
					<a href='#' onclick = downLoad(${item.building_id!''}) style="cursor:hand">点击下载报告</a>
				[#else]暂无报告
				[/#if]</td>
			</tr>
			<tr>
				<td class="td12">项目坐落</td><td class="td13">${item.surverbasic_address!''}</td>
				<td class="td12"></td><td class="td13"></td>
			</tr>
			<!--<tr>
				<td class="td12">图形</td><td class="td13">图形</td>
				<td class="td12">备注</td><td class="td13">${item.surverbasic_desc!''}</td>
			</tr>-->
		 [#if item_has_next][/#if]
				[/#list]	
		</table>