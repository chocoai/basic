[#macro pagebar currentpage totalpage totalnum]
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
		<A HREF="#" onclick="gotopage(${currentpage-1});">&laquo;</A>
	[/#if]
	[#list start_page..end_page as Num]
		[#if currentpage == Num]
			<a href="#" onclick="gotopage(${Num})">${Num}</a>
		[#else]
			<a href="#" onclick="gotopage(${Num})">${Num}</a>
		[/#if]
	[/#list]
	
	[#if (totalpage != currentpage)&&totalpage!=0]
		<A HREF="#" onclick="gotopage(${currentpage+1});">&raquo;</A>
	[/#if]
	共${totalpage}页&nbsp;[#if totalnum?exists]共${totalnum}条[/#if]
[/#macro]