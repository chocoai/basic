<script type="text/javascript" src="${_share_file_url!''}/gis/resource/jquery/js/jquery.validate.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/gis/resource/jquery/js/jquery.validate.message_zh.js"></script>
<script type="text/javascript">
$(document).ready(function(){  
    $("#commentForm").validate();  
    $( "input:submit,input:button,input:reset" ).button();
    if("${map.flag!''}"=="1"){
    alert("保存成功！");
    }
    
}); 
</script> 
[#list map.list as item] 
<h2 align="center">基础属性（不可修改）</h1>
<form action="" method="get">
<table width='100%' border='0' cellspacing='0'>
  <tr>
    <td align="right">幢号内码:</td>
    <td align="left"><input type="text"  id="in" name="building_id" value="${item.building_id!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
    <td align="right">项目测绘流程内码:</td>
    <td align="left"><input type="text"   name="surverproject_id" value="${item.surverproject_id!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
    <td align="right">施测单位:</td>
    <td align="left"><input type="text"  name="unit" value="${item.unit!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
  </tr>
  <tr>
    <td align="right">测绘比例:</td>
    <td align="left"><input type="text"  name="surver" value="${item.surver!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
    <td align="right">设计用途:</td>
    <td align="left"><input type="text"  name="use_desgin" value="${item.use_desgin!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
    <td align="right">房屋产别:</td>
    <td align="left"><input type="text"  name="real_type" value="${item.real_type!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
  </tr>
  <tr>
   <td align="right">总套内建筑面积:</td>
    <td align="left"><input type="text"  name="tn_area" value="${item.tn_area!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
    <td align="right">总分摊共用面积:</td>
    <td align="left"><input type="text"  name="ft_area" value="${item.ft_area!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
    <td align="right">总建筑面积:</td>
    <td align="left"><input type="text"  name="build_area" value="${item.build_area!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
  </tr>
  <tr>
    <td align="right">总不分摊面积:</td>
    <td align="left"><input type="text"  name="noft_area" value="${item.noft_area!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
    <td align="right">总不计面积:</td>
    <td align="left"><input type="text"  name="no_area" value="${item.no_area!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
    <td align="right">面积校核差值:</td>
    <td align="left"><input type="text"  name="discrepant_area" value="${item.discrepant_area!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
  </tr>
  <tr>
    <td align="right">建成时间:</td>
    <td align="left"><input type="text"  name="building_date" value="${item.building_date!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
    <td align="right">测绘日期:</td>
    <td align="left"><input type="text"  name="sruver_date" value="${item.sruver_date!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
    <td align="right">结束日期:</td>
    <td align="left"><input type="text"  name="surver_enddate" value="${item.surver_enddate!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
  </tr>
  <tr>
    <td align="right">幢号:</td>
    <td align="left"><input type="text"  name="building_number" value="${item.building_number!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
    <td align="right">幢坐落:</td>
    <td align="left"><input type="text"  name="building_address" value="${item.building_address!''}" readonly="readonly" size="30" style="background:#cccccc;" disabled="disabled"/></td>
    <td align="right">层数:</td>
    <td align="left"><input type="text"  name="floor_count" value="${item.floor_count!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
  </tr>
  <tr>
    <td align="right">结构:</td>
    <td align="left"><input type="text"  name="build_struct" value="${item.build_struct!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
    <td align="right">套数:</td>
    <td align="left"><input type="text"  name="house_count" value="${item.house_count!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
    <td align="right">幢编号:</td>
    <td align="left"><input type="text"  name="graphics_codes" value="${item.graphics_codes!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
  </tr>
  <tr>
    <td align="right">丘地号（丘号）:</td>
    <td align="left"><input type="text"  name="graphics_number" value="${item.graphics_number!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
    <td align="right">所在楼盘内码:</td>
    <td align="left"><input type="text"  name="building_mapid" value="${item.building_mapid!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
    <td align="right">入库时间:</td>
    <td align="left"><input type="text"  name="input_date" value="${item.input_date!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
  </tr>
  <tr>
    <td align="right">地上层数:</td>
    <td align="left"><input type="text"  name="floorup_count" value="${item.floorup_count!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
    <td align="right">地下层数:</td>
    <td align="left"><input type="text"  name="floordown_count" value="${item.floordown_count!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
    <td align="right">行政区划:</td>
    <td align="left"><input type="text"  name="city_district" value="${item.city_district!''}" readonly="readonly" style="background:#cccccc;" disabled="disabled"/></td>
  </tr>
  </table>
  

</form>
<h2 align="center">扩展属性（可修改）</h1>
<form id="commentForm" action="realtygis.updatebuildingproperty" method="get">
<table width='100%' border='0' cellspacing='0'>
<tr>
    <td align="right">朝向:</td>
    <td align="left"><input type="text" name="cx" value="${item.cx!''}"/></td>
    <td align="right">异议状态:</td>
    <td align="left"><input type="text" name="dissent_state" value="${item.dissent_state!''}"/></td>
    <td align="right">电梯类型:</td>
    <td align="left"><input type="text" name="dtlx" value="${item.dtlx!''}"/></td>
  </tr>
  <tr>
    <td align="right">电梯数目:</td>
    <td align="left"><input type="text" name="dtsm" value="${item.dtsm!''}"/></td>
    <td align="right">冻结状态:</td>
    <td align="left"><input type="text" name="freeze_state" value="${item.freeze_state!''}"/></td>
    <td align="right">普通状态:</td>
    <td align="left"><input type="text" name="general_state" value="${item.general_state!''}"/></td>
  </tr>
  <tr>
    <td align="right">住房保障:</td>
    <td align="left"><input type="text" name="guarantee_state" value="${item.guarantee_state!''}"/></td>
    <td align="right">建筑结构:</td>
    <td align="left"><input type="text" name="jzjg" value="${item.jzjg!''}"/></td>
    <td align="right">楼高:</td>
    <td align="left"><input type="text" name="lg" value="${item.lg!''}" class="number"/></td>
  </tr>
  <tr>
    <td align="right">楼梯类型:</td>
    <td align="left"><input type="text" name="ltlx" value="${item.ltlx!''}"/></td>
    <td align="right">楼梯数目:</td>
    <td align="left"><input type="text" name="ltsm" value="${item.ltsm!''}"/></td>
    <td align="right">已测绘状态:</td>
    <td align="left"><input type="text" name="mapping_state" value="${item.mapping_state!''}"/></td>
  </tr>
  <tr>
    <td align="right">所有权状态:</td>
    <td align="left"><input type="text" name="ownership_state" value="${item.ownership_state!''}"/></td>
    <td align="right">平改坡:</td>
    <td align="left"><input type="text" name="pgp_state" value="${item.pgp_state!''}"/></td>
    <td align="right">他项权状态:</td>
    <td align="left"><input type="text" name="pledge_state" value="${item.pledge_state!''}"/></td>
  </tr>
  <tr>
    <td align="right">查封状态:</td>
    <td align="left"><select name="sealup_state" value=$("select option:selected").val()>[#if EnumService.getEnum('cfzt')?exists]
				                                                                            [#list EnumService.getEnum('cfzt') as enum]
			                                                                                   <option value="${enum.enum_value!''}" 
			                                                                                      [#if "${item.sealup_state!''}"=="${enum.enum_value!''}"]selected[/#if]>${enum.enum_name!''}</option>
				                                                                            [/#list]
				                                                                         [/#if]
				    </select>
	</td>
   
    
  </tr>
  </table>
  <input type="text"  name="building_id" value="${item.building_id!''}" style="display:none"/>
  <input type="text"  name="method" value="update" style="display:none"/>
  <p align="center"><input   type='reset' value="重置" />    <input  type="submit" value="保存" /></p>
</form>
[#if item_has_next][/#if]
[/#list]