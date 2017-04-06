<style>
.button{
    background: url('/safemanage/resouce/images/ui-bg_highlight-soft_100_f6f6f6_1x100.png') repeat-x scroll 50% 50% #F6F6F6;
    border: 1px solid #DDDDDD;
    color: #0073EA;
    font-weight: normal;
    font-family: 微软雅黑,宋体;
    font-size: 12px;
    cursor: pointer;
    display: inline-block;
    margin-right: 0.1em;
    overflow: visible;
    padding: 0;
    position: relative;
    text-align: center;
    -moz-border-radius-topleft: 2px;
     text-decoration: none;
     height:30px;
     width:80px;
 
}
.buttonhover{
  cursor: pointer;
border:1px solid #fde893;background:#fef8cf url(/safemanage/resouce/images/ui-bg_highlight-soft_25_fef8cf_1x100.png) 50% 50% repeat-x;font-weight:normal;color:#444
}
</style>
<div><button id="chooseHouse">选取房屋</button><button id="chooseHouse1">新增房屋</button>
<input class="text_style" name="" id="inputaddress" placeholder="请输入房屋地址"  type="text" /><button id="searchHouse">定位房屋</button>
</div>
<div id="map" style="position:absolute;left:0px;right:0px;width:100%;height:100%;" visibility="visible"></div> 
<!--<script src="http://192.168.0.12:8080/gis/FMapLib/FMapLib.Include-1.0.4.js" type="text/javascript"></script>-->
<script src="${map_url!''}/gis/FMapLib/FMapLib.Include-1.0.4.js" type="text/javascript"></script>
<script type="text/javascript">
var map;
$(function(){
	 map = new FMapLib.FMap("map","safecheck3");//初始化安全鉴定专题地图
	 $("#chooseHouse").click(function(){
		var CH= new FMapLib.CheckHouse(map);
		var url1="safecheck.bctrack.insert";
		var url2="safecheck.bctrack.detail";
		var url3="safecheck.bctrack.insert1";
		CH.choosehouse(map,[url1,url2,url3]);
	});
	$("#chooseHouse1").click(function(){
		var CH= new FMapLib.PointForEditOnline(map);
		var url="safecheck.bctrack.insert1";
		CH.addPoint([url]);
	});
	$("#searchHouse").click(function(){
		var address = $("#inputaddress").val();
		var BF = new FMapLib.BuildingFastQuery(map);
	    BF.queryBySafeAddress(address);
	});
});

</script>