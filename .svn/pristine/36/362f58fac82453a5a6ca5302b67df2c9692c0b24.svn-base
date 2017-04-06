<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
.tdpad {padding-left:4px; background-color:#ffffff}
.td_title {text-align:right;padding-right:4px; background-color:#ffffff}
</style>

<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		
			[#list map.list as item]
			<tr>
				<td class="td12">内码</td><td class="td13">${item.invm_prj_id!''}</td>
				<td class="td12">健康内码</td><td class="td13">${item.invm_health_grade_id!''}</td>
			</tr>
			<tr>
				<td class="td12">结构建康等级</td><td class="td13">[#if "${item.structure_grade!''}"=="1"]A级[/#if][#if "${item.structure_grade!''}"=="2"]B级[/#if][#if "${item.structure_grade!''}"=="3"]C级[/#if][#if "${item.structure_grade!''}"=="4"]D级[/#if]</td>
				<td class="td12">使用健康等级</td><td class="td13">[#if "${item.used_grade!''}"=="1"]A级[/#if][#if "${item.used_grade!''}"=="2"]B级[/#if][#if "${item.used_grade!''}"=="3"]C级[/#if][#if "${item.used_grade!''}"=="4"]D级[/#if]</td>
			</tr>
			<tr>
				<td class="td12">抗震能力</td><td class="td13">[#if "${item.kz_grade!''}"=="1"]强[/#if][#if "${item.kz_grade!''}"=="2"]弱[/#if][#if "${item.kz_grade!''}"=="3"]差[/#if]</td>
				<td class="td12">防雷能力</td><td class="td13">[#if "${item.fl_grade!''}"=="1"]强[/#if][#if "${item.fl_grade!''}"=="2"]弱[/#if][#if "${item.fl_grade!''}"=="3"]差[/#if]</tr>
			<tr>
				<td class="td12">消防能力</td><td class="td13">[#if "${item.xf_grade!''}"=="1"]强[/#if][#if "${item.xf_grade!''}"=="2"]弱[/#if][#if "${item.xf_grade!''}"=="3"]差[/#if]</td>
				<td class="td12">其他防灾能力</td><td class="td13">[#if "${item.other_grade!''}"=="1"]强[/#if][#if "${item.other_grade!''}"=="2"]弱[/#if][#if "${item.other_grade!''}"=="3"]差[/#if]</td>
			</tr>
			<tr>
				<td class="td12">总健康等级</td><td class="td13">[#if "${item.all_grade!''}"=="1"]Ⅰ级（健康）[/#if][#if "${item.all_grade!''}"=="2"]Ⅱ级（亚健康）[/#if][#if "${item.all_grade!''}"=="3"]Ⅲ级（病态）[/#if][#if "${item.all_grade!''}"=="4"]Ⅳ（病危）[/#if]</td>
				<td class="td12">安全等级</td><td class="td13">[#if "${item.health_savegrade!''}"=="1"]A级[/#if][#if "${item.health_savegrade!''}"=="2"]B级[/#if][#if "${item.health_savegrade!''}"=="3"]C级[/#if][#if "${item.health_savegrade!''}"=="4"]D级[/#if]</td>
			</tr>
			<tr>
				<td class="td12">处理意见</td><td class="td13">[#if "${item.clresult!''}"=="1"]正常使用[/#if][#if "${item.clresult!''}"=="2"]常规维护[/#if][#if "${item.clresult!''}"=="3"]适当维修[/#if][#if "${item.clresult!''}"=="4"]采取措施[/#if][#if "${item.clresult!''}"=="5"]停止使用[/#if]</td>
				<td class="td12">备注</td><td class="td13">${item.health_gradetdesc!''}</td>
			</tr>
			<tr>
				<td class="td12">调查人</td><td class="td13">${item.dcr!''}</td>
				<td class="td12">调查日期</td><td class="td13">${item.dcrq!''}</td>
			</tr>
			<tr>
				<td class="td12">复核人</td><td class="td13">${item.fhr!''}</td>
				<td class="td12">完损等级</td><td class="td13">[#if "${item.lose_grade!''}"=="1"]完好房屋[/#if][#if "${item.lose_grade!''}"=="2"]基本完好[/#if][#if "${item.lose_grade!''}"=="3"]一般破损[/#if][#if "${item.lose_grade!''}"=="4"]严重破损[/#if]</td>
			</tr>
		 [#if item_has_next][/#if]
				[/#list]	
		</table>