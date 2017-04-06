[#macro pagebar currentpage totalpage totalnum blockid]
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
		[#if currentpage-1 == 1]
		<A href="${_share_file_url!''}/eap2/${blockid}/index.html" onclick="gotopage(${currentpage-1});" class="ui-button ui-state-default ui-corner-all">&laquo;上一页</A>
		[#else]
		<A href="${_share_file_url!''}/eap2/${blockid}/index_${currentpage-1}.html" onclick="gotopage(${currentpage-1});" class="ui-button ui-state-default ui-corner-all">&laquo;上一页</A>
		[/#if]
	[/#if]
	[#if start_page != 1&&totalpage!=0]
		<A href="${_share_file_url!''}/eap2/${blockid}/index.html" onclick="gotopage(1);" class="ui-button ui-state-default ui-corner-all">1</A>
		...
	[/#if]
	[#list start_page..end_page as Num]
		[#if Num != 1]
			[#if currentpage == Num]
				<a href="${_share_file_url!''}/eap2/${blockid}/index_${Num}.html" onclick="gotopage(${Num})" class="ui-button ui-state-highlight ui-corner-all">${Num}</a>
			[#else]
				<a href="${_share_file_url!''}/eap2/${blockid}/index_${Num}.html" onclick="gotopage(${Num})" class="ui-button ui-state-default ui-corner-all">${Num}</a>
			[/#if]
		[#else]
			[#if currentpage == Num]
				<a href="${_share_file_url!''}/eap2/${blockid}/index.html" onclick="gotopage(${Num})" class="ui-button ui-state-highlight ui-corner-all">${Num}</a>
			[#else]
				<a href="${_share_file_url!''}/eap2/${blockid}/index.html" onclick="gotopage(${Num})" class="ui-button ui-state-default ui-corner-all">${Num}</a>
			[/#if]
		[/#if]
	[/#list]
	[#if (totalpage != end_page)&&totalpage!=0]
	...
		<A href="${_share_file_url!''}/eap2/${blockid}/index_${totalpage}.html" onclick="gotopage(${totalpage});" class="ui-button ui-state-default ui-corner-all">${totalpage}</A>
	[/#if]
	[#if (totalpage != currentpage)&&totalpage!=0]
		<A href="${_share_file_url!''}/eap2/${blockid}/index_${currentpage+1}.html" onclick="gotopage(${currentpage+1});" class="ui-button ui-state-default ui-corner-all">&raquo;下一页</A>
	[/#if]
	
[/#macro]