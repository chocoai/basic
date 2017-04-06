{ 
  "total": "${block.page.totalpage}", 
  "page": "${block.page.currentpage}", 
  "records": "${block.page.totalnum}",
  "rows" : [
 [#list block.resultList as result]
 {"cell" :[
					"${result.info_id!''}"
				,"${result.building_address!''}"
				,[#assign qh=""]
				[#list EnumService.getEnum('xzqh') as enum]
				[#if "${result.building_region!''}"=="${enum.enum_value!''}"][#assign qh="${enum.enum_name!''}"][#break][/#if]
				[/#list]
				"${qh!''}"
				,"${result.house_count!''}"
				,"${result.floor_count!''}"
				,"${result.link_man!''}"
				,"${result.link_tel!''}"
				,
					[#if result.entry_time?exists]
						"${result.entry_time?string('yyyy-MM-dd')}"
					[#else]
						""
					[/#if]
				,[#if "${result.info_state!''}"=="0"]"待受理"[#else]"已受理"[/#if]
				,"${result.acceptor!''}"
				,
					[#if result.accept_date?exists]
						"${result.accept_date?string('yyyy-MM-dd')}"
					[#else]
						""
					[/#if]
				
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}