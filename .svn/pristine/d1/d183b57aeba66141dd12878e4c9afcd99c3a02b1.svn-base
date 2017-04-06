<script type="text/javascript" language="javascript">
$(function(){
	$("#outdiv").css("display","block");
	$("#tabs").tabs({cache:false});
});
</script>
<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
.tdpad {padding-left:4px; background-color:#ffffff}
.td_title {text-align:right;padding-right:4px; background-color:#ffffff}
</style>

<div id="outdiv" style="display:none">
<div class="ui-widget ui-widget-content ui-corner-all" style="position: relative;padding: .1em;">
	<div class="ui-widget" id="tabs">
	<ul>
		<li><a href="#tabs-1">基本信息</a></li>
		[#if access.canDo(user,'realtygis.healthgradetab')]
		<li><a href="#tabs-2" title="tabs-2">健康等级</a></li>
		[/#if]
		<!--[#if access.canDo(user,'realtygis.housejson')]
		<li><a href="#tabs-3" title="tabs-3"></a></li>
		[/#if]
		[#if access.canDo(user,'realtygis.buildingbasicsurver')]
		<li><a href="#tabs-4"></a></li>
		[/#if]-->
	</ul>
	[#list map.list as item]
	<div id="tabs-1">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		
			<tr>
				<td class="td12">内码</td><td class="td13">${item.invm_prj_id!''}</td>
				<td class="td12">编号</td><td class="td13">${item.dc_number!''}</td>
				
			</tr>
			<tr>
				<td class="td12">幢号内吗</td><td class="td13">${item.zh_nm!''}</td>
				<td class="td12">所在楼盘ID</td><td class="td13">${item.build_id!''}</td>
			</tr>
			<tr>
				<td class="td12">城区</td><td class="td13">[#if "${item.cq_name!''}"=="1"]历下区[/#if][#if "${item.cq_name!''}"=="2"]市中区[/#if][#if "${item.cq_name!''}"=="3"]槐荫区[/#if][#if "${item.cq_name!''}"=="4"]天桥区[/#if][#if "${item.cq_name!''}"=="5"]历城区[/#if][#if "${item.cq_name!''}"=="6"]高新区[/#if][#if "${item.cq_name!''}"=="7"]长清区[/#if][#if "${item.cq_name!''}"=="8"]章丘市[/#if][#if "${item.cq_name!''}"=="9"]平阴县[/#if][#if "${item.cq_name!''}"=="10"]济阳县[/#if][#if "${item.cq_name!''}"=="11"]商河县[/#if]</td>
				<td class="td12">图号</td><td class="td13">${item.parcel_code!''}</td>
			</tr>
			<tr>
				<td class="td12">地号</td><td class="td13">${item.fw_dh!''}</td>
				<td class="td12">房屋名称</td><td class="td13">${item.build_name!''}</td>
			</tr>
			<tr>
				<td class="td12">产权年限</td><td class="td13">[#if "${item.build_right!''}"=="1"]50年[/#if][#if "${item.build_right!''}"=="2"]70年[/#if][#if "${item.build_right!''}"=="3"]其它[/#if]</td>
				<td class="td12">产权性质</td><td class="td13">[#if "${item.right_type!''}"=="1"]直管公房[/#if][#if "${item.right_type!''}"=="2"]自管房[/#if][#if "${item.right_type!''}"=="3"]私房[/#if][#if "${item.right_type!''}"=="4"]其它[/#if]</td>
			</tr>
			<tr>
				<td class="td12">产权单位/人</td><td class="td13">${item.owner!''}</td>
				<td class="td12">坐落</td><td class="td13">${item.address_o!''}</td>
			</tr>
			<tr>
				<td class="td12">用户名称</td><td class="td13">${item.address_n!''}</td>
				<td class="td12">建筑面积</td><td class="td13">${item.structarea!''}</td>
			</tr>
			<tr>
				<td class="td12">建筑面积</td><td class="td13">${item.jz_area!''}</td>
				<td class="td12">地上层数</td><td class="td13">${item.floor_cnt!''}</td>
			</tr>
			<tr>
				<td class="td12">地下层数</td><td class="td13">${item.floor_down!''}</td>
				<td class="td12">使用功能</td><td class="td13">[#if "${item.usage!''}"=="1"]住宅[/#if][#if "${item.usage!''}"=="2"]综合楼[/#if][#if "${item.usage!''}"=="3"]办公[/#if][#if "${item.usage!''}"=="4"]商业[/#if][#if "${item.usage!''}"=="5"]学校用房[/#if][#if "${item.usage!''}"=="6"]医院用房[/#if][#if "${item.usage!''}"=="7"]工业用房[/#if][#if "${item.usage!''}"=="8"]其它[/#if]</td>
			</tr>
			<tr>
				<td class="td12">建成年代</td><td class="td13">${item.birth_decade!''}</td>
				<td class="td12">高度(m)</td><td class="td13">${item.heigth!''}</td>
			</tr>
			<tr>
				<td class="td12">檐高(m)</td><td class="td13">${item.depth!''}</td>
				<td class="td12">平面</td><td class="td13">[#if "${item.plane_shape!''}"=="1"]规则[/#if][#if "${item.plane_shape!''}"=="2"]不规则[/#if]</td>
			</tr>
			<tr>
				<td class="td12">朝向</td><td class="td13">[#if "${item.exposure!''}"=="1"]东西[/#if][#if "${item.exposure!''}"=="2"]南北[/#if][#if "${item.exposure!''}"=="3"]其它[/#if]</td>
				<td class="td12">立面</td><td class="td13">[#if "${item.lm_shape!''}"=="1"]规则[/#if][#if "${item.lm_shape!''}"=="2"]不规则[/#if]</td>
			</tr>
			<tr>
				<td class="td12">基础类型</td><td class="td13">[#if "${item.base_type!''}"=="1"]毛石[/#if][#if "${item.base_type!''}"=="2"]砖[/#if][#if "${item.base_type!''}"=="3"]混凝土[/#if][#if "${item.base_type!''}"=="4"]钢筋混凝土[/#if][#if "${item.base_type!''}"=="5"]其它[/#if]</td>
				<td class="td12">上部结构类型</td><td class="td13">[#if "${item.upon_type!''}"=="1"]钢结构[/#if][#if "${item.upon_type!''}"=="2"]钢、钢筋混凝土结构[/#if][#if "${item.upon_type!''}"=="3"][/#if]钢筋混凝土结构[#if "${item.upon_type!''}"=="4"]混合结构[/#if][#if "${item.upon_type!''}"=="5"]砖木结构[/#if][#if "${item.upon_type!''}"=="6"]其他结构[/#if]</td>
			</tr>
			<tr>
				<td class="td12">楼盖类型</td><td class="td13">[#if "${item.lg_type!''}"=="1"]现浇板[/#if][#if "${item.lg_type!''}"=="2"]预制板[/#if][#if "${item.lg_type!''}"=="3"]现浇、预制板混用[/#if][#if "${item.lg_type!''}"=="4"]木楼板[/#if][#if "${item.lg_type!''}"=="5"]其它[/#if]</td>
				<td class="td12">屋面类型</td><td class="td13">[#if "${item.wm_type!''}"=="1"]预制板平屋面[/#if][#if "${item.wm_type!''}"=="2"]现浇板平屋面[/#if][#if "${item.wm_type!''}"=="3"]现浇板坡屋面[/#if][#if "${item.wm_type!''}"=="4"]有檩系坡屋面[/#if][#if "${item.wm_type!''}"=="5"]其它[/#if]</td>
			</tr>
			<tr>
				<td class="td12">变形缝类型</td><td class="td13">[#if "${item.bxf_type!''}"=="1"]未设置[/#if][#if "${item.bxf_type!''}"=="2"]伸缩缝[/#if][#if "${item.bxf_type!''}"=="3"]沉降缝[/#if][#if "${item.bxf_type!''}"=="4"]抗震缝[/#if]</td>
				<td class="td12">楼梯数目</td><td class="td13">[#if "${item.lt_number!''}"=="1"]一个[/#if][#if "${item.lt_number!''}"=="2"]二个[/#if][#if "${item.lt_number!''}"=="3"]三个[/#if][#if "${item.lt_number!''}"=="4"]多个[/#if]</td>
			</tr>
			<tr>
				<td class="td12">楼梯类型</td><td class="td13">[#if "${item.lt_type!''}"=="1"]木[/#if][#if "${item.lt_type!''}"=="2"]混凝土[/#if][#if "${item.lt_type!''}"=="3"]钢[/#if][#if "${item.lt_type!''}"=="4"]其它[/#if]</td>
				<td class="td12">电梯数目</td><td class="td13">[#if "${item.dt_number!''}"=="1"]一个[/#if][#if "${item.dt_number!''}"=="2"]二个[/#if][#if "${item.dt_number!''}"=="3"]三个[/#if][#if "${item.dt_number!''}"=="4"]多个[/#if]</td>
			</tr>
			<tr>
				<td class="td12">电梯、楼梯备注</td><td class="td13">${item.dt_tdesc!''}</td>
				<td class="td12">阳台类型</td><td class="td13">[#if "${item.yt_type!''}"=="1"]未设置[/#if][#if "${item.yt_type!''}"=="2"]梁式[/#if][#if "${item.yt_type!''}"=="3"]板式[/#if][#if "${item.yt_type!''}"=="4"]落地[/#if]</td>
			</tr>
			<tr>
				<td class="td12">外墙饰面</td><td class="td13">[#if "${item.wq_type!''}"=="1"]玻璃[/#if][#if "${item.wq_type!''}"=="2"]石材[/#if][#if "${item.wq_type!''}"=="3"]面砖[/#if][#if "${item.wq_type!''}"=="4"]马赛克[/#if][#if "${item.wq_type!''}"=="5"]砂浆[/#if][#if "${item.wq_type!''}"=="6"]涂料[/#if][#if "${item.wq_type!''}"=="7"]清水墙[/#if][#if "${item.wq_type!''}"=="8"]其它[/#if]</td>
				<td class="td12">装修、装饰情况</td><td class="td13">${item.zx_tdesc!''}</td>
			</tr>
			<tr>
				<td class="td12">经营管理单位</td><td class="td13">${item.management_unit!''}</td>
				<td class="td12">户数</td><td class="td13">${item.floor_num!''}</td>
			</tr>
			<tr>
				<td class="td12">层高(m)</td><td class="td13">${item.floor_height!''}</td>
				<td class="td12">是否冻结片区</td><td class="td13">[#if "${item.frozen_area!''}"=="1"]是[/#if][#if "${item.frozen_area!''}"=="2"]否[/#if]</td>
			</tr>
			<tr>
				<td class="td12">装饰装修备注</td><td class="td13">${item.struct_desc!''}</td>
				<td class="td12">基本信息备注</td><td class="td13">${item.bz_desc!''}</td>
			</tr>
			<tr>
				<td class="td12">上下部结构形式备注</td><td class="td13">${item.dere_desc!''}</td>
				<td class="td12">外廊类型</td><td class="td13">[#if "${item.wairang_type!''}"=="1"]未设置[/#if][#if "${item.wairang_type!''}"=="2"]梁式[/#if][#if "${item.wairang_type!''}"=="3"]板式[/#if][#if "${item.wairang_type!''}"=="4"]落地[/#if]</td>
			</tr>
			
			
		</table>
	</div>
	<div id="tabs-2">
		<iframe frameborder="0" src="${_servlet_url!''}/realtygis.healthgradetab?invm_prj_id=${item.invm_prj_id!''}" style="width:100%;height:450px"></iframe>
	</div>
	<!--<div id="tabs-3">
		<iframe frameborder="0" src="" style="width:100%;height:450px"></iframe>
	</div>
	<div id="tabs-4">
		<iframe frameborder="0" src="" style="width:100%;height:450px"></iframe>
	</div>-->
	 [#if item_has_next][/#if]
	[/#list]
</div>	
</div>