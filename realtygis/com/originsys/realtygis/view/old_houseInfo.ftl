<link rel="stylesheet" type="text/css" href="${_share_file_url!''}/gis/resource/house_list/house_list.css">
[#list map.laylist as lay]
   <div class="list01">
    <div class="list_top"><img src="images/topReapet.jpg" /></div>
    <div class="list_center">
      <div class="center_left">
        <div class="numtitle">${lay.lay_num!''}</div>
      </div>
      <div class="center_right">
        <table width="700" border="0" cellspacing="0" cellpadding="0" class="num_table">
    [#list map.houselist as house]
       [#if house.lay_num==lay.lay_num]
           [#if house_index%15==1]
                 <tr>
            <td width="67" height="35" align="center"  style=" cursor: pointer" title='房号：${house.room_number!''}
单元号：${house.unit_number!''}
单元别名：${house.unit_alias!''}
房屋编号：${house.house_code!''}
房屋坐落：${house.fw_address!''}
所属层数：${house.lay_num!''}
套内建筑面积：${house.tnjz_area!''}平方米
分摊面积：${house.ft_area!''}平方米
建筑面积：${house.jz_area!''}平方米'><a href="">${house.room_number!''}</a></td>     
           [#elseif house_index%15==0]
            <td width="67" height="35" align="center"  style=" cursor: pointer" title='房号：${house.room_number!''}
单元号：${house.unit_number!''}
单元别名：${house.unit_alias!''}
房屋编号：${house.house_code!''}
房屋坐落：${house.fw_address!''}
所属层数：${house.lay_num!''}
套内建筑面积：${house.tnjz_area!''}平方米
分摊面积：${house.ft_area!''}平方米
建筑面积：${house.jz_area!''}平方米'><a href="">${house.room_number!''}</a></td>      
       </tr>
         [#else]
          <td width="67" height="35" align="center"  style=" cursor: pointer" title='房号：${house.room_number!''}
单元号：${house.unit_number!''}
单元别名：${house.unit_alias!''}
房屋编号：${house.house_code!''}
房屋坐落：${house.fw_address!''}
所属层数：${house.lay_num!''}
套内建筑面积：${house.tnjz_area!''}平方米
分摊面积：${house.ft_area!''}平方米
建筑面积：${house.jz_area!''}平方米'><a href="">${house.room_number!''}</a></td>     
          [/#if]
       [/#if]
    [/#list]
     </table>
      </div>
      <!--中间右侧end-->
    </div>
    <div class="list_bottom"><img src="images/bottomReapet.jpg" /></div>
  </div>
[/#list]









         
