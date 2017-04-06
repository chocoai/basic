<script src="${map.map_url!''}/gis/FMapLib/FMapLib.Include-1.0.4.js" type="text/javascript"></script>
 <script type="text/javascript">
var map;
    function init(){
       map = new FMapLib.FMap("newmapdiv");		   
    }
    setTimeout( handler , 500);   
     function handler(){
      //安全管理房屋快速查询定位          			
	  new FMapLib.BuildingFastQuery(map).queryBySafeSmuserid("${map.building_mapid!''}");	 
	  }		

 </script>  
 <body onload="init()">
 <div id="newmapdiv"  style="position: relative; float:center;  height:600px;width:100%" />         
 </body>
  

 