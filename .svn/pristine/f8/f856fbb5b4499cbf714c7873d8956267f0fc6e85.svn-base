<link href="${_share_file_url!''}/gis/resource/houselist/css.css" rel="stylesheet" type="text/css" />
<style>
.header {width:100px;position:relative; display:block}
.header span {
	position:absolute;
	left:-2px;
	top:-26px;
	border-color:#e2f1ff transparent transparent #f1f8ff;
	border-style:solid; 
	width:0; 
	height:0; 
	display:block;
	border-width:54px 0 0 100px
}
.count {position:absolute; left:-85px; top:-26px;font-size:12px}
.item {position:absolute; left:-35px; top:-37px;font-size:12px}
</style>
<script type="text/javascript" language="javascript">
	function clean(){
		$("#unit_number").val("");
		$("#lay_start").val("");
		$("#lay_end").val("");
	}
</script>
<div style="background-color: #f0f8fd;">
	<!--楼盘表图示颜色展示开始-->
	<table border="0" cellspacing="0" cellpadding="0" style="padding-left:10px;">
		<tr>
        <td width="140" height="30">查看楼盘表</td>
        <td width="100">
        	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td width="40" align="center" style="padding-top:3px;">
		            <table width="34" border="0" cellpadding="0" cellspacing="0" bgcolor="#9cff89" class="miaohui">
		                <tr>
		                  <td height="11"></td>
		                </tr>
		            </table>
	            </td>
	            <td height="30" >可售</td>
	          </tr>
	        </table>
        </td>
        <td width="100">
        	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td width="40" align="center" style="padding-top:3px;">
		            <table width="34" border="0" cellpadding="0" cellspacing="0" bgcolor="#fff889" class="miaohui">
		                <tr>
		                  <td height="11"></td>
		                </tr>
		            </table>
	            </td>
	            <td height="30" >可预订</td>
	          </tr>
	        </table>
        </td>
        <td width="100">
        	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td width="40" align="center" style="padding-top:3px;">
		            <table width="34" border="0" cellpadding="0" cellspacing="0" bgcolor="#ffc5a2" class="miaohui">
		                <tr>
		                  <td height="11"></td>
		                </tr>
		            </table>
	            </td>
	            <td height="30" >已售</td>
	          </tr>
	        </table>
        </td>
        <td width="100">
        	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td width="40" align="center" style="padding-top:3px;">
		            <table width="34" border="0" cellpadding="0" cellspacing="0" bgcolor="#dadada" class="miaohui">
		                <tr>
		                  <td height="11"></td>
		                </tr>
		            </table>
	            </td>
	            <td height="30" >限制销售 </td>
	          </tr>
	        </table>
        </td>
        <td>&nbsp;</td>
        </tr>
        <tr>
        <form id="sform" method="post" action="${_servlet_url!''}/realtygis.housejson?building_id=${map.term.building_id!''}&method=houseQue">
        	<td>自定义查询</td>
        	<td colspan="5">单元：
        		<select id="unit_number" name="unit_number">
		    		<option value="">请选择...</option>
		    		[#list map.all_unitlist as unit]
		    		<option value="${unit.UNIT_NUMBER!''}" [#if "${map.term.unit_number!''}"=="${unit.UNIT_NUMBER!''}"] selected[/#if]>
		    		[#if "${unit.UNIT_NUMBER!''}"=="0"]无[#else]${unit.UNIT_NUMBER!''}[/#if]单元
		    		</option>
		    		[/#list]
		    	</select>        
        	起始楼层：
        	<select id="lay_start" name="lay_start">
        	<option value="">请选择...</option>
        	[#list map.laylist as lay]
        	<option value="${lay.lay_num!''}" [#if "${map.term.lay_start!''}"=="${lay.lay_num!''}"] selected[/#if]>${lay.lay_num!''}</option>
        	[/#list]
        	</select>
        	截止楼层：
        	<select id="lay_end" name="lay_end">
        	<option value="">请选择...</option>
        	[#list map.laylist as lay]
        	<option value="${lay.lay_num!''}" [#if "${map.term.lay_end!''}"=="${lay.lay_num!''}"] selected[/#if]>${lay.lay_num!''}</option>
        	[/#list]
        	</select>
        	<button type="submit">查询</button> <button onClick="clean()">重置</button>
        	</td>
        </form>
        </tr>
	</table>
	<!--楼盘表图示颜色展示结束-->
	<!--楼盘表展示列表开始-->
	<table border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3">
		<!--table的标题单元行-->
		<tr>
			<td width="100" height="52" align="center" bgcolor="#3192d8">
			<table style="width:100px;" border="0"><tr><td class="header">
			<span><b class="count">楼层</b><b class="item">单元</b></span>
			</td></tr></table>
			</td>
			[#list map.unitlist as unit]
			[#if unit.NUM1?exists]
			[#if unit.NUM1>999]<!--因为在ie下colspan的值超过999就会去掉，所以如果大于999的分多个单元格存放-->
			[#assign x1=unit.NUM1%999]
			  <td colspan="999" align="center" bgcolor="#E7F2FF">${unit.UNIT_NUMBER!''}</td>
			  <td colspan="${x1}" align="center" bgcolor="#E7F2FF">${unit.UNIT_NUMBER!''}</td>
			[#else]
			  <td colspan="${unit.NUM1!'1'}" align="center" bgcolor="#E7F2FF">${unit.UNIT_NUMBER!''}</td>
			[/#if]
			[/#if]
			[/#list]
		</tr>
		<!--楼层循环，房屋列表显示开始-->
		[#list map.laylist as lay] 
		<!--设置值，判断现实那些楼层的数据开始-->
		[#assign layflag=""]
		[#if "${map.term.lay_start!''}"==""&&"${map.term.lay_end!''}"==""]
		[#assign layflag="true"]
		[/#if] 
		[#if "${map.term.lay_start!''}"!=""&&"${map.term.lay_end!''}"!=""]
			[#if (lay.lay_num?number gte map.term.lay_start?number)&&(lay.lay_num?number lte map.term.lay_end?number)]
			[#assign layflag="true"]
			[/#if]
		[/#if]
		[#if "${map.term.lay_start!''}"!=""&&"${map.term.lay_end!''}"==""]
			[#if lay.lay_num?number gte map.term.lay_start?number]
			[#assign layflag="true"]
			[/#if]			
		[/#if]
		[#if "${map.term.lay_start!''}"==""&&"${map.term.lay_end!''}"!=""]
			[#if lay.lay_num?number lte map.term.lay_end?number]
			[#assign layflag="true"]
			[/#if]			
		[/#if]
		<!--设置值，判断现实那些楼层的数据结束-->
		[#if layflag=="true"]
    	<tr>
        <td width="100" align="center" bgcolor="#3192d8" class="baizi">${lay.lay_num!''}</td>
			[#list map.unitlist as unit]
			 [#if unit.NUM1?exists]
		     [#assign lay_unit_num1=0]
		     [#list map.houselist as house]
		       [#if house.lay_num==lay.lay_num&&"${house.unit_number!''}"=="${unit.UNIT_NUMBER!''}"]
		       [#assign lay_unit_num1=lay_unit_num1+1]
		       <td align="center" bgcolor="#f9f9f9">
		       <table border="0" cellpadding="0" cellspacing="0" class="lvkuang">
		          <tr>
		            <td title='房号：${house.room_number!''}
单元号：${house.unit_number!''}
单元别名：${house.unit_alias!''}
房屋编号：${house.house_code!''}
房屋坐落：${house.fw_address!''}
所属层数：${house.lay_num!''}
套内建筑面积：${house.tnjz_area!''}平方米
分摊面积：${house.ft_area!''}平方米
建筑面积：[#if house.jz_area?exists]#{house.jz_area; m2M3}[/#if]平方米'>${house.room_number!''}</td>
		          </tr>
		        </table>
		        </td>
		         [/#if]           
		         [/#list]
		         [#assign cnum=unit.NUM1-lay_unit_num1]
		         [#if cnum>0]
		         [#list 1..cnum as x]
		         <td align="center" bgcolor="#f9f9f9"></td>
		         [/#list]
		         [/#if]
		         [/#if]
		         [/#list]		         
		         </tr>
		      [/#if]
		    [/#list]
		<!--楼层循环，房屋列表显示结束-->	   
	</table>	
	<!--楼盘表展示列表结束-->	 
</div>