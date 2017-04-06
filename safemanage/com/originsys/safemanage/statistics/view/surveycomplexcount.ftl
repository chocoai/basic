<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" language="javascript">
function cha(){
	$("#dic_form").attr("action","${_servlet_url!''}/safecheck.survey.complexcount");
	$("#dic_form").submit();
}
function toexcel(){
	$("#dic_form").attr("action","${_server_url!''}/exportexcel/safecheck.survey.complexcount");
	$("#dic_form").submit();
}
</script>
<style>
body,td,th {
	font-family: "微软雅黑";
	font-size: 12px;
	color: #424242;	
}
#tab2 td{
	text-align:center;
}
#tab2 th{
	text-align:center;
}
.zi {font-size: 14px;
	 font-weight:bold;}

.baida {
	font-family: "微软雅黑";
	font-size: 16px;
	color: #fff;
	font-weight:bold;
	text-decoration: none;
}
.dahei{
	font-size:15px;
	font-weight:bold;}
.lanxiao {
	font-family: "微软雅黑";
	font-size: 14px;
	color: #0053d7;
	font-weight:bold;
	text-decoration: none;
}
.hongzi{
	font-size: 14px;
	color: #c40532;
	font-weight:bold;
</style>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout:fixed;margin-top:20px;">
<tr><td width="200" style="vertical-align:top;padding-left:20px;">
	<form name="dic_form" id="dic_form" action="${_servlet_url!''}/safecheck.survey.complexcount" method="post">
		<table width="100%" border="0" cellpadding="4" cellspacing="0" style="table-layout:fixed;line-height:20px;border:1px solid #c5e2ff;background-color:#fefdfd;">
		<tr><td>
			[#assign qh=""]
			<select id="region_id" name="region_id">
				<option value="">---请选择区县---</option>
				[#list EnumService.getEnum('xzqh') as enum]
				[#if "${block.term.region_id!''}"=="${enum.enum_value!''}"][#assign qh="${enum.enum_name!''}"][/#if]
				<option value="${enum.enum_value!''}" [#if "${block.term.region_id!''}"=="${enum.enum_value!''}"]selected[/#if]>${enum.enum_name!''}</option>
				[/#list]
			</select>
		</td></tr>
		[#assign fenlei=""]
		[#if "${block.term.col_name!''}"=="sjyt#use_desgin"][#assign fenlei="设计用途"][/#if]
		[#if "${block.term.col_name!''}"=="fwjg#build_struct"][#assign fenlei="结构类型"][/#if]
		[#if "${block.term.col_name!''}"=="upon_type#upon_type"][#assign fenlei="楼盖类型"][/#if]
		[#if "${block.term.col_name!''}"=="wm_type#wm_type"][#assign fenlei="屋面类型"][/#if]
		[#if "${block.term.col_name!''}"=="fwxzh#building_properties"][#assign fenlei="房屋性质"][/#if]
		[#if "${block.term.col_name!''}"=="managetype#manage_type"][#assign fenlei="管理模式"][/#if]
		[#if "${block.term.col_name!''}"=="build_dept"][#assign fenlei="建设单位"][/#if]
		[#if "${block.term.col_name!''}"=="design_dept"][#assign fenlei="设计单位"][/#if]
		[#if "${block.term.col_name!''}"=="construct_dept"][#assign fenlei="施工单位"][/#if]
		[#if "${block.term.col_name!''}"=="building_date"][#assign fenlei="建设年份"][/#if]
		<tr><td><input type="radio" name="col_name" value="sjyt#use_desgin" [#if "${block.term.col_name!''}"=="sjyt#use_desgin"]checked[/#if]>设计用途</td></tr>
		<tr><td><input type="radio" name="col_name" value="fwjg#build_struct" [#if "${block.term.col_name!''}"=="fwjg#build_struct"]checked[/#if]>结构类型</td></tr>
		<tr><td><input type="radio" name="col_name" value="upon_type#upon_type" [#if "${block.term.col_name!''}"=="upon_type#upon_type"]checked[/#if]>楼盖类型</td></tr>
		<tr><td><input type="radio" name="col_name" value="wm_type#wm_type" [#if "${block.term.col_name!''}"=="wm_type#wm_type"]checked[/#if]>屋面类型</td></tr>
		<tr><td><input type="radio" name="col_name" value="fwxzh#building_properties" [#if "${block.term.col_name!''}"=="fwxzh#building_properties"]checked[/#if]>房屋性质</td></tr>
		<tr><td><input type="radio" name="col_name" value="managetype#manage_type" [#if "${block.term.col_name!''}"=="managetype#manage_type"]checked[/#if]>管理模式</td></tr>
		
		<tr><td><input type="radio" name="col_name" value="build_dept" [#if "${block.term.col_name!''}"=="build_dept"]checked[/#if]>建设单位</td></tr>
		<tr><td><input type="radio" name="col_name" value="design_dept" [#if "${block.term.col_name!''}"=="design_dept"]checked[/#if]>设计单位</td></tr>
		<tr><td><input type="radio" name="col_name" value="construct_dept" [#if "${block.term.col_name!''}"=="construct_dept"]checked[/#if]>施工单位</td></tr>
		<tr><td><input type="radio" name="col_name" value="building_date" [#if "${block.term.col_name!''}"=="building_date"]checked[/#if]>建设年份</td></tr>
		<tr><td>&nbsp;&nbsp;开始年份&nbsp;<input type="text" name="start_date" size="6" readonly="true" value="${block.term.start_date!''}" onClick="WdatePicker({dateFmt:'yyyy'})"></td></tr>
		<tr><td>&nbsp;&nbsp;截止年份&nbsp;<input type="text" name="end_date" size="6" readonly="true" value="${block.term.end_date!''}" onClick="WdatePicker({dateFmt:'yyyy'})"></td></tr>
		<tr><td align="center">
		<button type="button" onclick="cha();">统计</button>&nbsp;&nbsp;
		<button type="button" id="printInfo" align="right" onclick="toexcel();">导出excel</button>
		</td></tr>
	</table>
	</form>	
</td><td style="vertical-align:top;">
	[#if block.resultlist?exists]
	<table id="tab2" width="800" border="1"  bordercolor="#c5e2ff" cellpadding="0" cellspacing="0" style="border-collapse:collapse;line-height:30px;text-align:center;" align="center">
	<tr><td colspan="11" align="center" bgcolor="#519ce8" class="baida">
	<b>2014年济南市老楼危楼安全排查统计表[#if "${qh!''}"==""][#else](${qh!''})[/#if]</b>
	</td></tr>
	<tr>
		<td rowspan="2" bgcolor="#ecf6ff" align="center" class="dahei">${fenlei!''}</td>
		<td colspan="2" bgcolor="#ecf6ff" class="lanxiao">无问题房屋</td>
		<td colspan="2" bgcolor="#ecf6ff" class="lanxiao">有问题房屋</td>
		<td colspan="2" bgcolor="#ecf6ff" class="lanxiao">小计</td>
	</tr>
	<tr>
		<td bgcolor="#f9f9f9">幢</td>
		<td bgcolor="#f9f9f9">建筑面积</td>
		<td bgcolor="#f9f9f9">幢</td>
		<td bgcolor="#f9f9f9">建筑面积</td>
		<td bgcolor="#f9f9f9">幢</td>
		<td bgcolor="#f9f9f9">建筑面积</td>
	</tr>
		[#list block.resultlist as result]
		<tr>
			<td>${result.ENUM_NAME!''}</td>
			<td>${result.A1}</td>
			<td>#{result.A2;m0M2}</td>
			<td>${result.D1}</td>
			<td>#{result.D2;m0M2}</td>
			<td>${result.H1}</td>
			<td>#{result.H2;m0M2}</td>
		</tr>
		[/#list]
		<tr bgcolor="#ffeaea">
			<td class="dahei">合计</td>
			<td>${block.hj.A1}</td>
			<td>#{block.hj.A2;m0M2}</td>
			<td>${block.hj.D1}</td>
			<td>#{block.hj.D2;m0M2}</td>
			<td>${block.hj.H1}</td>
			<td>#{block.hj.H2;m0M2}</td>
		</tr>
	</table>
	[/#if]
</td></tr>
</table>