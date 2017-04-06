
 <script type="text/javascript" src="${_share_file_url!''}/gis/resource/jquery/js/jquery-latest.js"></script>
    <div  style="position:absolute;top:5px; left:5px;" >
			<table class="list" width="600" border="1" cellspacing="0" cellpadding="0" >
			     <tr class="table-tr-title" >  
                    <td width=10% height="25" align="center"  style=" cursor: pointer">房屋内码</td>  
                    <td width=30% height="25" align="center"  style=" cursor: pointer">房屋坐落</td>  
                    <td width=5% height="25" align="center"  style=" cursor: pointer">建筑面积</td>  
                    <td width=5% height="25" align="center"  style=" cursor: pointer">分摊面积</td>  
                    <td width=5% height="25" align="center"  style=" cursor: pointer">阳台面积</td>  
                    <td width=5% height="25" align="center"  style=" cursor: pointer">使用面积</td>  
                    <td width=5% height="25" align="center"  style=" cursor: pointer">预测面积</td>  
                    <td width=10% height="25" align="center"  style=" cursor: pointer">建成时间</td>  
                    <td width=10% height="25" align="center"  style=" cursor: pointer">户式类型</td>  
                    <td width=10% height="25" align="center"  style=" cursor: pointer">所属层数</td>  
                    <td width=5% height="25" align="center"  style=" cursor: pointer">备注</td>  
                    
                </tr>  
			
				[#list map.list as item] 
					<tr class="listrow">		
					<td width=10% height="25" align="center"  style=" cursor: pointer">${item.house_id!''}</td>
					<td width=30% height="25" align="left"  style=" cursor: pointer">${item.fw_address!''}</td>
					<td width=5% height="25" align="center"  style=" cursor: pointer">${item.jz_area!''}</td>
					<td width=5% height="25" align="center"  style=" cursor: pointer">${item.ft_area!''}</td>
					<td width=5% height="25" align="center"  style=" cursor: pointer">${item.yt_area!''}</td>
					<td width=5% height="25" align="center"  style=" cursor: pointer">${item.sy_area!''}</td>
					<td width=5% height="25" align="center"  style=" cursor: pointer">${item.yc_area!''}</td>
					<td width=10% height="25" align="center"  style=" cursor: pointer">${item.birth_date!''}</td>
					<td width=10% height="25" align="center"  style=" cursor: pointer">${item.door_type!''}</td>
					<td width=10% height="25" align="center"  style=" cursor: pointer">${item.lay_num!''}</td>
				    <td width=5% height="25" align="center"  style=" cursor: pointer"> 					 				   
					   <img src="${_share_file_url!''}/resource/icon/new.gif" />
					</td>
				 </tr>
				  [#if item_has_next][/#if]
				[/#list]
			</table>
    
     
   </div>
   
   <style type="text/css">
.table-tr-title{
    height: 26px;
    font-size: 12px;
    text-align: center;
}
.table-tr-content{
    height: 18px;
    background: #FFFFFF;
    text-align: center;
    font-size: 12px;
}
.normalEvenTD{
    background: #DFD8D8;
}
.normalOddTD{
    background: #FFFFFF;
}
.hoverTD{
    background-color: #eafcd5;
    height: 18px;
    text-align: center;
    font-size: 12px;
}
.trSelected{
    background-color: #0B61A4;
    height: 18px;
    text-align: center;
    font-size: 12px;
}
</style>
   
   <script type="text/javascript" > 
  //选中行变颜色
  $(document).ready(function(){
    ///////datagrid选中行变色与鼠标经过行变色///////////////
    var dtSelector = ".list";
    var tbList = $(dtSelector);
 
    tbList.each(function() {
        var self = this;
        $("tr:even:not(:first)", $(self)).addClass("normalEvenTD"); // 从标头行下一行开始的奇数行，行数：（1，3，5...）
        $("tr:odd", $(self)).addClass("normalOddTD"); // 从标头行下一行开始的偶数行，行数：（2，4，6...）
        // 鼠标经过的行变色
        $("tr:not(:first)", $(self)).hover(
            function () { $(this).addClass('hoverTD');$(this).removeClass('table-tr-content'); },
            function () { $(this).removeClass('hoverTD');$(this).addClass('table-tr-content'); }
        );
        // 选择行变色
        $("tr", $(self)).click(function (){
            var trThis = this;
            $(self).find(".trSelected").removeClass('trSelected');
            if ($(trThis).get(0) == $("tr:first", $(self)).get(0)){
                return;
            }
            $(trThis).addClass('trSelected');
        });
    });
});
  
  
   
	
</script>
