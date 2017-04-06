
 <script type="text/javascript" src="${_share_file_url!''}/gis/resource/jquery/js/jquery-latest.js"></script>
    <div  style="position:absolute;top:5px; left:5px;right:5px;" >
  
    <span width="100" style="position:absolute;right:0px;">
    <input type="button" align="right" id="showMap" value="地图展示"  onclick="javascript:mshow()" style="cursor: pointer; right:5px"/></br>
    <input type="button" align="right" id="showTheme" value="专题图"  onclick="javascript:tshow()" style="cursor: pointer; right:5px"/>  
    </span>  
  
			<table class="list" width=94% border="1" cellspacing="0" cellpadding="0" >
			     <tr class="table-tr-title" >  
                   <td width=10% height="25" align="center"  style=" cursor: pointer">幢号内码</td>  
                    <td width=10% height="25" align="center"  style=" cursor: pointer">所在楼盘内码</td>  
                    <td width=30% height="25" align="center"  style=" cursor: pointer">地址</td>  
                    <td width=5% height="25" align="center"  style=" cursor: pointer">楼幢号</td>  
                    <td width=5% height="25" align="center"  style=" cursor: pointer">总户数</td>  
                    <td width=10% height="25" align="center"  style=" cursor: pointer">符合条件的户数</td>  
                    <td width=10% height="25" align="center"  style=" cursor: pointer">备注1</td>  
                    <td width=10% height="25" align="center"  style=" cursor: pointer">备注2</td>  
                    <td width=10% height="25" align="center"  style=" cursor: pointer">备注3</td>  
                    
                   
                    
                </tr>  
			
				[#list map.list as item] 
					<tr class="listrow">
					<td class="t1" width=10% height="25" align="center"  style=" cursor: pointer">${item.building_id!''}</td>		
					<td class="t2" width=10% height="25" align="center"  style=" cursor: pointer">${item.building_mapid!''}</td>							
					<td class="t3" width=30% height="25" align="left"  style=" cursor: pointer">${item.building_address!''}</td>		
					<td class="t4" width=5% height="25" align="center"  style=" cursor: pointer">${item.building_number!''}</td>		
					<td class="t5" width=5% height="25" align="center"  style=" cursor: pointer">${item.houseCount!''}</td>		
					<td class="t6" width=10% height="25" align="center"  style=" cursor: pointer">${item.properCount!''}</td>		
					<td class="t7" width=10% height="25" align="center"  style=" cursor: pointer"><a>详细信息</a></td>		
					<td class="t8" width=10% height="25" align="center"  style=" cursor: pointer"><a>地图定位</a></td>
					<td class="t9" width=10% height="25" align="center"  style=" cursor: pointer"><a>楼盘表</a></td>
					
					
				    
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
            function () { $(this).addClass('trSelected');$(this).removeClass('table-tr-content'); },
            function () { $(this).removeClass('trSelected');$(this).addClass('table-tr-content'); }
        );
        // 选择行变色
     //   $("tr", $(self)).click(function (){
        //    var trThis = this;
       //     $(self).find(".trSelected").removeClass('trSelected');
        //    if ($(trThis).get(0) == $("tr:first", $(self)).get(0)){
       //         return;
       //     }
       //     $(trThis).addClass('trSelected');
      //  });
    });
});
  //点击查看详细信息
  $(".t7").bind("click",function(){
    var b_id=$(this).parent().children("tr td:eq(0)").text();
   // alert(b_id);   
    var areamin=parent.document.getElementById("minValue").value;
	var areamax=parent.document.getElementById("maxValue").value;
	//alert(areamin);
	//alert(areamax);
   // $("#dataIframe2").attr("src","realtygis.housearealist?id="+b_id+"&min="+areamin+"&max="+areamax);
  window.open('realtygis.housearealist?id='+b_id+'&min='+areamin+'&max='+areamax,'_blank','depended=yes,width=625,height=400,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes');
  
  });
  
   //向父窗口传值，定位
   $(".t8").bind("click", function() {
   var b_ids = $(this).parent().children("tr td:eq(1)").text(); 
              if (b_ids != ""){ 
               parent.document.getElementById("identy").innerHTML=b_ids;  
              }
             if(parent.MAP_VISION){	
	         parent.sizePane('south',50); 	//定义父级窗口南窗
	 }									
		});
	//地图展示
	function mshow(){
	parent.document.getElementById("maptext").innerHTML=$("#showMap").val();
	if(parent.MAP_VISION){	
	 parent.closePane('south'); 	//关闭父级窗口南窗
	 }		
	}
	//生成专题图
	function tshow(){
	parent.document.getElementById("themeStatus").innerHTML=$("#showTheme").val(); 
	if(parent.MAP_VISION){	
	 parent.closePane('south'); 	//关闭父级窗口南窗
	 }		  
	}
	//查看楼盘表
	$(".t9").bind("click", function() {
   var b_id = $(this).parent().children("tr td:eq(0)").text(); 
     if (b_id != ""){ 
     window.open('realtygis.housejson?building_id='+b_id+'&method=houseQue','_blank','depended=yes,width=900,height=500,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes');
     }	
   });
</script>
