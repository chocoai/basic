[#macro pagebar currentpage totalpage]
	[#if currentpage-3<1]
	[#assign start_page=1]
	[#else]
	[#assign start_page=currentpage-3]
	[/#if]
	[#if currentpage+3>totalpage]
	[#assign end_page=totalpage]
	[#else]
	[#assign end_page=currentpage+3]
	[/#if]
	[#if totalpage=0][#assign start_page=0][/#if]
	[#if currentpage != 1&&totalpage!=0]
		<A HREF="#" onclick="gotopage(${currentpage-1});" class="ui-button ui-state-default ui-corner-all">&laquo;上一页</A>
	[/#if]
	[#if start_page != 1&&totalpage!=0]
		<A HREF="#" onclick="gotopage(1);" class="ui-button ui-state-default ui-corner-all">1</A>
		...
	[/#if]
	[#list start_page..end_page as Num]
		[#if currentpage == Num]
			<a href="#" onclick="gotopage(${Num})" class="ui-button ui-state-highlight ui-corner-all">${Num}</a>
		[#else]
			<a href="#" onclick="gotopage(${Num})" class="ui-button ui-state-default ui-corner-all">${Num}</a>
		[/#if]
	[/#list]
	[#if (totalpage != end_page)&&totalpage!=0]
	...
		<A HREF="#" onclick="gotopage(${totalpage});" class="ui-button ui-state-default ui-corner-all">${totalpage}</A>
	[/#if]
	[#if (totalpage != currentpage)&&totalpage!=0]
		<A HREF="#" onclick="gotopage(${currentpage+1});" class="ui-button ui-state-default ui-corner-all">&raquo;下一页</A>
	[/#if]
	
[/#macro]