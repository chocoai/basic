
<link href="${_share_file_url!''}/gis/resource/houselist/css.css" rel="stylesheet" type="text/css" />

<table width="100%" border="0" cellpadding="0" cellspacing="10" class="big_table">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="140" height="30">查看楼盘表</td>
        
        <td width="80"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="40" align="center" style="padding-top:3px;"><table width="34" border="0" cellpadding="0" cellspacing="0" bgcolor="#9cff89" class="miaohui">
                <tr>
                  <td height="11"></td>
                </tr>
            </table></td>
            <td height="30" >可售</td>
          </tr>
        </table></td>
        <td width="90"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="40" align="center" style="padding-top:3px;"><table width="34" border="0" cellpadding="0" cellspacing="0" bgcolor="#fff889" class="miaohui">
                <tr>
                  <td height="11"></td>
                </tr>
            </table></td>
            <td height="30" >可预订</td>
          </tr>
        </table></td>
        <td width="80"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="40" align="center" style="padding-top:3px;"><table width="34" border="0" cellpadding="0" cellspacing="0" bgcolor="#ffc5a2" class="miaohui">
                <tr>
                  <td height="11"></td>
                </tr>
            </table></td>
            <td height="30" >已售</td>
          </tr>
        </table></td>
        <td width="100"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="40" align="center" style="padding-top:3px;"><table width="34" border="0" cellpadding="0" cellspacing="0" bgcolor="#dadada" class="miaohui">
              <tr>
                <td height="11"></td>
              </tr>
            </table></td>
            <td height="30" >限制销售 </td>
          </tr>
        </table></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  
    <tr>
    <td valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3">
    
 [#list map.laylist as lay] 
     
       <tr>
       <td width="60" height="52" align="center" bgcolor="#3192d8" class="baizi">${lay.lay_num!''}</td>
     [#list map.houselist as house]
       [#if house.lay_num==lay.lay_num]
          [#if house_index==0]
       
        
        <td width="10%" align="center" bgcolor="#f9f9f9"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="lvkuang">
          <tr>
            <td title='房号：${house.room_number!''}
单元号：${house.unit_number!''}
单元别名：${house.unit_alias!''}
房屋编号：${house.house_code!''}
房屋坐落：${house.fw_address!''}
所属层数：${house.lay_num!''}
套内建筑面积：${house.tnjz_area!''}平方米
分摊面积：${house.ft_area!''}平方米
建筑面积：${house.jz_area!''}平方米'>${house.room_number!''}</td>
          </tr>
        </table></td>

        
         [#else]
         <td width="10%" align="center" bgcolor="#f9f9f9"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="lvkuang">
          <tr>
            <td title='房号：${house.room_number!''}
单元号：${house.unit_number!''}
单元别名：${house.unit_alias!''}
房屋编号：${house.house_code!''}
房屋坐落：${house.fw_address!''}
所属层数：${house.lay_num!''}
套内建筑面积：${house.tnjz_area!''}平方米
分摊面积：${house.ft_area!''}平方米
建筑面积：${house.jz_area!''}平方米'>${house.room_number!''}</td>
          </tr>
        </table></td>
         
                [/#if]
            [/#if]
         [/#list]
         </tr>
    [/#list]
        <tr>
        <td width="60" height="52" align="center" bgcolor="#3192d8">&nbsp;</td>
        </tr>
    </table></td>
  </tr>
</table>