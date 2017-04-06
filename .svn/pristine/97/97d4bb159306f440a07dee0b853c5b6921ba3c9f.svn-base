<script src="${_share_file_url!''}/resource/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script src="${_share_file_url!''}/resource/js/jquery.tablednd.js" type="text/javascript"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script src="${_share_file_url!''}/resource/js/jquery.pop.js" type="text/javascript"></script>
<style type="text/css">
#tabs li .ui-icon-close { float: left; margin: 0.4em 0.2em 0 0; cursor: hand; }
#tabs li a { cursor: hand;}
.ui-jqgrid tr.jqgrow td { border-bottom: 1px #F1F8FF solid;border-right:0px;}
.tree-wrap,.cell-wrapperleaf{cursor:hand;}
#west-grid{margin-top:5px;background:#fff url(images/ui-bg_flat_75_ffffff_40x100.png) 50% 50% repeat-x;} 
.ui-jqgrid-bdiv{
	background-color:#E1F1FE;
}
.ui-widget-content {border:1px solid #ddd;background:#E1F1FE url(images/ui-bg_flat_75_ffffff_40x100.png) 50% 50% repeat-x;color:#444}
.ui-widget-content .ui-state-error{border:1px solid #ff5800;background:#E1F1FE url(images/ui-bg_flat_55_ffffff_40x100.png) 50% 50% repeat-x;color:#222}
#tabs .ui-widget-content {border:1px solid #ddd;background:#fff url(images/ui-bg_flat_75_ffffff_40x100.png) 50% 50% repeat-x;color:#444}
</style>
<style type="text/css">
<!--
a.zi:link {
	font-family: "宋体";
	font-size: 12px;
	color: #5c5c5c;
	text-decoration: none;
}
a.zi:visited {
	font-family: "宋体";
	font-size: 12px;
	color: #5c5c5c;
	text-decoration: none;
}
a.zi:hover {
	font-family: "宋体";
	font-size: 12px;
	color: #929292;
	text-decoration: underline;
}
.huizi {
	font-family: "宋体";
	font-size: 12px;
	color: #5c5c5c;
	text-decoration: none;
}
-->
</style>
<script type="text/javascript">
jQuery(document).ready(function(){
	var tab_counter = 1;
	var $tab_content_input = $( "#actionUrl" );
	var templateString="<li><a href='#"+"{href}'>#"+"{label}</a> <span class='ui-icon ui-icon-close'>关闭</span></li>"
	var $tabs = $( "#tabs").tabs({
			tabTemplate: templateString,
			add: function( event, ui ) {
				var tab_content = $tab_content_input.val();
				$( ui.panel ).append( tab_content );
			}
		});
	$( "#tabs span.ui-icon-close" ).live( "click", function() {
			var index = $( "li", $tabs ).index( $( this ).parent() );
			$tabs.tabs( "remove", index );
		});
	function addTab(st) {
			$("#actionUrl").val("<iframe src='"+st.url+"' frameborder='0' style='width:100%;height:100%'></iframe>");
			var tab_title = st.menu;
			var currentIndex;
			var currentId;
			$("#tabs ul li a").each(function(i){
				if($(this).text()==tab_title){
					currentIndex=i;
					currentId=$(this).attr("href");
				}
			});
			if(currentIndex==undefined){
				$tabs.tabs( "remove", 5);
				$tabs.tabs( "add", "#tabs-" + tab_counter, tab_title ,0);
				$("#tabs-"+tab_counter).css("padding","0px");	
				$("#tabs-"+tab_counter).find("iframe").css("height",document.documentElement.clientHeight - 70);
				$("#tabs").tabs("select", 0);
				tab_counter++;
			}else{
				$(currentId).find("iframe").attr("src",st.url);
				$("#tabs").tabs("select", currentIndex);
			}
		}
	$("#tabs").find("iframe").css("height",document.documentElement.clientHeight - 70);
	$(window).resize(function(){
		resetWorkset();
	});
	jQuery("#west-grid").jqGrid({
		treeGridModel: 'adjacency',
        url: "${_server_url!''}/portal/safecheck.moduletree",

        datatype: "xml",
        height: document.documentElement.clientHeight - 50,
        pager: false,
        loadui: "disable",
        colNames: ["id","菜单","url"],
        colModel: [
            {name: "id",width:1,hidden:true, key:true},
            {name: "menu", width:150, resizable: false, sortable:false},
            {name: "url",width:1,hidden:true}
        ],
        treeGrid: true,
        ExpandColumn: "menu",
        autowidth: true,
        width: 200,
        rowNum: 200,
        ExpandColClick: true,
        treeIcons: {plus:'ui-icon-triangle-1-e',minus:'ui-icon-triangle-1-s',leaf:'ui-icon-document-b'},
        onSelectRow: function(rowid) {
            var treedata = $("#west-grid").jqGrid('getRowData',rowid);
            if(treedata.url!="") {
                addTab(treedata);
            }
        }
    });
	$('#bs_center').hover(
					function() { $(this).addClass('ui-state-hover'); }, 
					function() { $(this).removeClass('ui-state-hover'); }
				).click(
					function(){
						if($("#gbox_west-grid").css("display")=="block"){
							$("#gbox_west-grid").css("display","none");
							$("#hideCon").css("width","0px");
							$(this).find("span").removeClass('ui-icon-triangle-1-s');
							$(this).find("span").addClass('ui-icon-triangle-1-e');
						}else{
							$("#gbox_west-grid").css("display","block");
							$("#hideCon").css("width","200px");
							$(this).find("span").removeClass('ui-icon-triangle-1-e');
							$(this).find("span").addClass('ui-icon-triangle-1-s');
						}
					}
				);	
	//自适应窗口边框
	var t=document.documentElement.clientWidth; 
	window.onresize = function(){ 
		if(t != document.documentElement.clientWidth){
			t = document.documentElement.clientWidth;
			doResize();
		}
	}
	function doResize() {
		var ss = getPageSize();
		$("#west-grid").jqGrid('setGridWidth', 200);
		$("#west-grid").jqGrid('setGridHeight', ss.WinH-55);
	} 	
	
	function getPageSize() {
	var winW, winH;
	if(window.innerHeight) {// all except IE
		winW = window.innerWidth;
		winH = window.innerHeight;
	} else if (document.documentElement && document.documentElement.clientHeight) {// IE 6 Strict Mode
		winW = document.documentElement.clientWidth;
		winH = document.documentElement.clientHeight;
	} else if (document.body) { // other
		winW = document.body.clientWidth;
		winH = document.body.clientHeight;
	}  // for small pages with total size less then the viewport 
		return {WinW:winW, WinH:winH};
 	}  	
 	doResize();	
 	function openpop(){
 		var url="";
 		[#if access.canDo(user,'safecheck.building.pop')]
 			url='${_servlet_url!''}/safecheck.building.pop';
 		[#elseif access.canDo(user,'safecheck.building.pop1')] 
 			url='${_servlet_url!''}/safecheck.building.pop1';
 		[/#if]
 		$.post(url,
				"",
				function(data, textStatus){
					var jdata=jQuery.parseJSON(data);
					if(jdata.success=="true"){
						var pop=new Pop("${user.family_name!''}${user.firstname!''}您好：",
						"#",jdata.message);
					}
				}
			); 		
	}
	//setInterval这个函数会根据后面定义的1000既每隔1秒执行一次前面那个函数	
	openpop();
	setInterval(openpop,5*60*1000);
});	
function resetWorkset() {
	var bodyHeight=document.documentElement.clientHeight - 64;
	$("#bodytable").css("height",bodyHeight);
	$("#accordion").css("height",bodyHeight);
	$("#tabs").find("iframe").css("height",document.documentElement.clientHeight - 70);
}
function on_submit(){
		document.siteform.submit();
	}	
function logout(){
	$("#logform").submit();
	return false;
}
</script>
	<!-- 标题区 -->
<div class="ui-widget noprint">
	<div  class="ui-widget-header">
	<form id="logform" method="post" action="${_servlet_url!''}/commonservice.login.logout">
	<input type="hidden" name="reDirectURL" value="${_server_url!''}/eap/">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td width="494" height="84" background="${_server_url!''}/eap2/images/fsbj.jpg"><img src="${_server_url!''}/eap2/images/fsleft.jpg" width="494" height="84" /></td>
	    <td height="84" background="${_server_url!''}/eap2/images/fsbj.jpg">&nbsp;</td>
	    <td height="84" width="461" background="${_server_url!''}/eap2/images/fsbj.jpg">
	        <table width="100%"   height="84" border="0" cellpadding="0" cellspacing="0" background="${_server_url!''}/eap2/images/fsright.jpg">
      			<tr>
        			<td height="69" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          				<tr>
            				<td height="60" valign="top">
            				<table width="100%" border="0" cellspacing="0" cellpadding="0">
              					<tr>
					                <td width="252">&nbsp;</td>
					                <td height="25"><span class="huizi">${user.family_name!''}${user.firstname!''}</span>
					                [#if access.canDo(user,'manager.site.manager_top')]
					                <a href="${_server_url!''}/portal/manager.site.manager_top" class="zi" target="_blank">[管理控制台]</a>
					                [/#if]
					                </td>
              					</tr>
            				</table>
    						</td>
         				 </tr>
         			 </td>
         		</tr>
        	</table>
	          <table width="100%" border="0" cellspacing="0" cellpadding="0">
	            <tr>
	              <td width="332" height="22">&nbsp;</td>
	              <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	                <tr>
	                  <td width="38" height="22"><a href="${_server_url!''}/portal/foodsafe.block" class="zi">首页</a></td>
	                  <td width="47">&nbsp;</td>
	                  <td class="zi"><a href="#" onclick="logout()" class="zi">注销</a></td>
	                </tr>
	              </table></td>
	            </tr>
	          </table></td>
	      </tr>
	    </table></td>
	  </tr>
	</table>
	</form>
	</div>
 </div>
	<!-- 工作区 -->
	<!-- 工作区 -->
	<input type="hidden" id="actionUrl">
	<table width="100%" id="bodytable" cellpadding="0" cellspacing="0">
		<tr>
			<!-- 工作区：滑动菜单 -->
			<td id="hideCon" style="width:200px;" align="top" valign="top" class="noprint">
			<table id="west-grid" width="200px" class="noprint"></table>
			</td>
 
			<!-- 工作区：折叠栏 -->
			<td style="width:10px;height:100%;"  class="ui-widget-header noprint">
				<div style="width:10px;height:40px;" id="bs_center" title="隐藏菜单" class="ui-state-default ui-corner-all noprint"><span class="ui-icon ui-icon-triangle-1-w" style="margin-left:-3px;margin-top:10px"></span></div>
			</td>
 
			<!-- 工作区：内容区 -->
			<td valign="top">
				<!--div style="width:100%;" id="tabbox" style="border:2px solid red;padding:2px;background:green"-->
						<div id="tabs">
							<ul class="noprint">
								<li><a href="#tabs-0">欢迎!</a> <span class="ui-icon ui-icon-close">关闭</span></li>
							</ul>
							<div id="tabs-0" style="padding:0px">
								<iframe src="${_server_url!''}/eap/welcome" style="width:100%;margin:0px" frameborder="0"></iframe>
							</div>
						</div>
				<!--/div-->
			</td>
		</tr>
	</table>
	<!-- 补丁 -->
	<div id="resizeFix" class="noprint"></div>
	<div id="pdialog" class="noprint"></div>
		<!-- 消息提示框  -->
	[#include "/WEB-INF/commonftl/messagebox.ftl"]
