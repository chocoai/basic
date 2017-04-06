[#macro pagebar currentpage totalpage totalnum]
	[#if currentpage == 1]
		<button disabled>首页</button>
		<button disabled>上一页</button>
	[#else]
		<button onclick="gotopage(1);">首页</button>
		<button  onclick="gotopage(${currentpage-1});">上一页</button>
	[/#if]
	[#if (totalpage == 1) || (totalpage == currentpage)]
		<button disabled>下一页</button>
		<button disabled>末页</button>
	[#else]	
		<button  onclick="gotopage(${currentpage+1});">下一页</button>
		<button  onclick="gotopage(${totalpage});">末页</button>
	[/#if]
	&nbsp;转到<select onchange='gotopage(this.value)'>
	[#list 1..totalpage as Num]
		[#if currentpage == Num]
			<option value="${Num}" selected>${Num}</option>
		[#else]
			<option value="${Num}">${Num}</option>
		[/#if]
	[/#list]
	</select>页&nbsp;共${totalpage}页&nbsp;共${totalnum}条
[/#macro]