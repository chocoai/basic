[#macro building_info building]

<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;width:150px;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
</style>
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
				<tr>
					<td class="td12">坐落地址：</td>
					<td class="td13" colspan="3">${building.building_address!''}</td>
					<td class="td12">楼幢编号：</td>
					<td class="td13">${building.building_id!''}</td>					
				</tr>
				<tr>
					<td class="td12">所属区域：</td>
					<td class="td13">
						[#assign builiding_region=""]
						[#list EnumService.getEnum('xzqh') as enum]
						[#if "${building.builiding_region!''}"=="${enum.enum_value!''}"][#assign builiding_region="${enum.enum_name!''}"][#break][/#if]
						[/#list]
						${builiding_region!''}
					</td>
					<td class="td12">所属街道：</td>
					<td class="td13">${building.belong_street!''}</td>
					<td class="td12">所属小区：</td>
					<td class="td13">${building.belong_community!''}</td>
				</tr>
				<tr>
					<td class="td12">经营管理单位：</td>
					<td class="td13">${building.management_unit!''}</td>
					<td class="td12">建筑面积：</td>
					<td class="td13">${building.build_area!''}</td>
					<td class="td12">建成时间：</td>
					<td class="td13">${building.building_date!''}</td>
				</tr>
				<tr>
					<td class="td12">户数：</td>
					<td class="td13">${building.house_count!''}</td>
					<td class="td12">地上层数：</td>
					<td class="td13">${building.floorup_count!''}</td>
					<td class="td12">地下层数：</td>
					<td class="td13">${building.floordown_count!''}</td>
				</tr>
				<tr>
					<td class="td12">设计用途：</td>
					<td class="td13">
						[#assign use_desgin=""]
						[#list EnumService.getEnum('sjyt') as enum]
						[#if "${building.use_desgin!''}"=="${enum.enum_value!''}"][#assign use_desgin="${enum.enum_name!''}"][#break][/#if]
						[/#list]
						${use_desgin!''}
					</td>
					<td class="td12">房屋产别：</td>
					<td class="td13">
						[#assign real_type=""]
						[#list EnumService.getEnum('fwcb') as enum]
						[#if "${building.real_type!''}"=="${enum.enum_value!''}"][#assign real_type="${enum.enum_name!''}"][#break][/#if]
						[/#list]
						${real_type!''}
					</td>
					<td class="td12">房屋结构：</td>
					<td class="td13">
						[#assign fwjg=""]
						[#list EnumService.getEnum('fwjg') as enum]
						[#if "${building.build_struct!''}"=="${enum.enum_value!''}" ][#assign fwjg="${enum.enum_name!''}"][#break][/#if]
						[/#list]
						${fwjg!''}
					</td>
				</tr>
				<tr>
					<td class="td12">基础类型：</td>
					<td class="td13">
					[#assign base_type=""]
						[#list EnumService.getEnum('base_type') as enum]
							[#if "${building.base_type!''}"=="${enum.enum_value!''}" ][#assign base_type="${enum.enum_name!''}"][#break][/#if]
						[/#list]
						${base_type!''}
					</td>
					<td class="td12">楼盖类型：</td>
					<td class="td13">
						[#assign upon_type=""]
						[#list EnumService.getEnum('upon_type') as enum]
							[#if "${building.upon_type!''}"=="${enum.enum_value!''}" ][#assign upon_type="${enum.enum_name!''}"][#break][/#if]
						[/#list]
						${upon_type!''}
					</td>
					<td class="td12">屋面类型：</td>
					<td class="td13">
						[#assign wm_type=""]
						[#list EnumService.getEnum('wm_type') as enum]
							[#if "${building.wm_type!''}"=="${enum.enum_value!''}" ][#assign wm_type="${enum.enum_name!''}"][#break][/#if]
						[/#list]
						${wm_type!''}
					</td>
				</tr>
				<tr>
					<td class="td12">外廊类型：</td>
					<td class="td13">
						[#assign wairang_type=""]
						[#list EnumService.getEnum('wairang') as enum]
							[#if "${building.wairang_type!''}"=="${enum.enum_value!''}" ][#assign wairang_type="${enum.enum_name!''}"][#break][/#if]
						[/#list]
						${wairang_type!''}
					</td>
					<td class="td12">使用功能：</td>
					<td class="td13">
						[#assign usefunction=""]
						[#list EnumService.getEnum('usefunction') as enum]
							[#if "${building.usefunction!''}"=="${enum.enum_value!''}" ][#assign usefunction="${enum.enum_name!''}"][#break][/#if]
						[/#list]
						${usefunction!''}
					</td>
					<td class="td12">楼梯数目：</td>
					<td class="td13">
						[#assign lt_number=""]
						[#list EnumService.getEnum('lt_number') as enum]
							[#if "${building.lt_number!''}"=="${enum.enum_value!''}" ][#assign lt_number="${enum.enum_name!''}"][#break][/#if]
						[/#list]
						${lt_number!''}
					</td>
				</tr>
				<tr>
					<td class="td12">楼梯类型：</td>
					<td class="td13">
						[#assign lt_type=""]
						[#list EnumService.getEnum('lt_type') as enum]
							[#if "${building.lt_type!''}"=="${enum.enum_value!''}" ][#assign lt_type="${enum.enum_name!''}"][#break][/#if]
						[/#list]
						${lt_type!''}
					</td>
					<td class="td12">电梯数目：</td>
					<td class="td13">
						[#assign dt_number=""]
						[#list EnumService.getEnum('dt_number') as enum]
							[#if "${building.dt_number!''}"=="${enum.enum_value!''}" ][#assign dt_number="${enum.enum_name!''}"][#break][/#if]
						[/#list]
						${dt_number!''}
					</td>
					<td class="td12">外墙饰面：</td>
					<td class="td13">
						[#assign wq_type=""]
						[#list EnumService.getEnum('wq_type') as enum]
							[#if "${building.wairang_type!''}"=="${enum.enum_value!''}" ][#assign wq_type="${enum.enum_name!''}"][#break][/#if]
						[/#list]
						${wq_type!''}
					</td>
				</tr>
				<tr>
					<td class="td12">检查结果：</td>
					<td class="td13">
					[#assign health_grade_pc=""]
					[#if "${building.health_grade_pc!''}"=="1"][#assign health_grade_pc="A级"][/#if]
				    [#if "${building.health_grade_pc!''}"=="2"][#assign health_grade_pc="B级"][/#if]
				    [#if "${building.health_grade_pc!''}"=="3"][#assign health_grade_pc="C级"][/#if]
				    [#if "${building.health_grade_pc!''}"=="4"][#assign health_grade_pc="D级"][/#if]
				    ${health_grade_pc!''}
					</td>
					<td class="td12">鉴定结果：</td>
					<td class="td13">
					[#assign health_grade_jd=""]
					[#if "${building.health_grade_jd!''}"=="1"][#assign health_grade_jd="A级"][/#if]
				    [#if "${building.health_grade_jd!''}"=="2"][#assign health_grade_jd="B级"][/#if]
				    [#if "${building.health_grade_jd!''}"=="3"][#assign health_grade_jd="C级"][/#if]
				    [#if "${building.health_grade_jd!''}"=="4"][#assign health_grade_jd="D级"][/#if]
				    ${health_grade_jd!''}
					</td>
					<td class="td12">楼幢状态：</td>
					<td class="td13">[#if "${building.is_die!''}"=="1"]正常[#else]消亡[/#if]</td>
				</tr>
				<tr>
					<td class="td12">产权年限：</td>
					<td class="td13">
					[#assign build_right=""]
					[#list EnumService.getEnum('build_right') as enum]
						[#if "${building.build_right!''}"=="${enum.enum_value!''}" ][#assign build_right="${enum.enum_name!''}"][#break][/#if]
					[/#list]
					${build_right!''}
					</td>
					<td class="td12">产权性质：</td>
					<td class="td13">
					[#assign right_type=""]
					[#list EnumService.getEnum('right_type') as enum]
						[#if "${building.right_type!''}"=="${enum.enum_value!''}" ][#assign right_type="${enum.enum_name!''}"][#break][/#if]
					[/#list]
				    ${right_type!''}
					</td>
					<td class="td12">产权单位：</td>
					<td class="td13">${building.owner!''}</td>
				</tr>	
				<tr>
					<td class="td12">高度：</td>
					<td class="td13">
					${building.heigth!''}
					</td>
					<td class="td12">檐高：</td>
					<td class="td13">
					${building.depth!''}
					</td>
					<td class="td12">层高：</td>
					<td class="td13">${building.floor_height!''}</td>
				</tr>	
				<tr>
					<td class="td12">平面：</td>
					<td class="td13">
					[#assign plane_shape=""]
					[#list EnumService.getEnum('plane_shape') as enum]
						[#if "${building.plane_shape!''}"=="${enum.enum_value!''}" ][#assign plane_shape="${enum.enum_name!''}"][#break][/#if]
					[/#list]
					${plane_shape!''}
					</td>
					<td class="td12">朝向：</td>
					<td class="td13">
					[#assign exposure=""]
					[#list EnumService.getEnum('exposure') as enum]
						[#if "${building.exposure!''}"=="${enum.enum_value!''}" ][#assign exposure="${enum.enum_name!''}"][#break][/#if]
					[/#list]
					${exposure!''}
					</td>
					<td class="td12">立面：</td>
					<td class="td13">
					[#assign lm_shape=""]
					[#list EnumService.getEnum('lm_shape') as enum]
						[#if "${building.lm_shape!''}"=="${enum.enum_value!''}" ][#assign lm_shape="${enum.enum_name!''}"][#break][/#if]
					[/#list]
					${lm_shape!''}
					</td>
				</tr>	
				<tr>
					<td class="td12">阳台类型：</td>
					<td class="td13">
					[#assign yt_type=""]
					[#list EnumService.getEnum('wairang') as enum]
						[#if "${building.yt_type!''}"=="${enum.enum_value!''}" ][#assign yt_type="${enum.enum_name!''}"][#break][/#if]
					[/#list]
					${yt_type!''}
					</td>
					<td class="td12">是否冻结片区：</td>
					<td class="td13" colspan="3">[#if "${building.frozen_area!''}"=="1"]是[#else]否[/#if]</td>
				</tr>					
			</table>
[/#macro]