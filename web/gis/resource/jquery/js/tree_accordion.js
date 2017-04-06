function initLeftmenu() {	
	jQuery_1_4_2(function($){		
		$("#m1").html("<h2 class='l1'><a>·一级菜单</a></h2>"
        +"<div class='slist'>"
     +"<h4 class='l2'><a onclick='javascript:getFeaturesBySQL1()' href='#'>小区查询</a></h4>"       
     +"<h2 class='l2'><a href='javascript:function()'>房屋查询</a></h2>"  
    + "<h2 class='l2'><a href='javascript:function()'>GIS专题</a></h2></div>"        
   +"<h1 class='l1'><a>·一级菜单</a></h1>"
    +"<div class='slist'>"
     +"<h2 class='l2'><a href='javascript:function()'>二级菜单</a></h2>"
     +"<h2 class='l2'><a href='javascript:function()'>二级菜单</a></h2>"
     +"<h2 class='l2'><a href='javascript:function()'>二级菜单</a></h2></div>"        
   +"<h1 class='l1'><a>·一级菜单</a></h1>"
   +"<div class='slist'>"
    +" <h2 class='l2'><a href='javascript:function()'>二级菜单</a></h2>"
    +"<h2 class='l2'><a href='javascript:function()'>二级菜单</a></h2>"
    +" <h2 class='l2'><a href='javascript:function()'>二级菜单</a></h2> </div>");		
	
	$("#m2").html("<h2 class='l1'><a>·一级菜单</a></h2>"
	        +"<div class='slist'>"
	     +"<h4 class='l2'><a onclick='javascript:function()' href='#'>二级菜单</a></h4>"       
	     +"<h2 class='l2'><a href='javascript:function()'>二级菜单</a></h2>"  
	    + "<h2 class='l2'><a href='javascript:function()'>二级菜单</a></h2></div>"        
	   +"<h1 class='l1'><a>·一级菜单</a></h1>"
	    +"<div class='slist'>"
	     +"<h2 class='l2'><a href='javascript:function()'>二级菜单</a></h2>"
	     +"<h2 class='l2'><a href='javascript:function()'>二级菜单</a></h2>"
	     +"<h2 class='l2'><a href='javascript:function()'>二级菜单</a></h2></div>"        
	   +"<h1 class='l1'><a>·一级菜单</a></h1>"
	   +"<div class='slist'>"
	    +" <h2 class='l2'><a href='javascript:function()'>二级菜单</a></h2>"
	    +"<h2 class='l2'><a href='javascript:function()'>二级菜单</a></h2>"
	    +" <h2 class='l2'><a href='javascript:function()'>二级菜单</a></h2> </div>");		
		});
	// 树状菜单效果
	jQuery_1_4_2(function($){
	$(".l1").toggle(function(){
	$(".slist").animate({height: 'toggle', opacity: 'hide'}, "slow");
	
	},function(){
	$(".slist").animate({height: 'toggle', opacity: 'hide'}, "slow");
	$(this).next(".slist").animate({height: 'toggle', opacity: 'toggle'}, "slow");
	});
	$(".l2").toggle(function(){
	$(this).next(".sslist").animate({height: 'toggle', opacity: 'toggle'}, "slow");
	},function(){
	$(this).next(".sslist").animate({height: 'toggle', opacity: 'toggle'}, "slow");
	});
	$(".l2").click(function(){
	$(".l3").removeClass("currentl3");
	$(".l2").removeClass("currentl2");
	$(this).addClass("currentl2");
	});
	$(".l3").click(function(){
	$(".l3").removeClass("currentl3");
	$(this).addClass("currentl3");
	});
	$(".close").toggle(function(){
	$(".slist").animate({height: 'toggle', opacity: 'hide'}, "fast");
	$(".sslist").animate({height: 'toggle', opacity: 'hide'}, "fast");
	},function(){
	$(".slist").animate({height: 'toggle', opacity: 'show'}, "fast");
	$(".sslist").animate({height: 'toggle', opacity: 'show'}, "fast");
	});
	});	
}
