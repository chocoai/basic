{ 
  "total": "${block.page.totalpage}", 
  "page": "${block.page.currentpage}", 
  "records": "${block.page.totalnum}",
  "rows" : [
 [#list block.userlist as result]
 {"cell" :[
					"${result.mem_id!''}"
				,
					"${result.family_name!''}${result.first_name!''}"
				,
					"${result.mem_name!''}"
				,	"${result.secret!''}"
				,
					[#assign sex=""]
			 		  [#list EnumService.getEnum('sex') as enum]
			 		  [#if "${result.mem_sex!''}"=="${enum.enum_value!''}"][#assign sex="${enum.enum_name!''}"][#break][/#if]
			 		  [/#list]
					"${sex!''}"
				,
					[#if result.mem_born?exists]
						"${result.mem_born?string('yyyy-MM-dd')}"
					[#else]
						""
					[/#if]
				,
					"${result.mem_mail!''}"
				,
					"${result.mem_mphone!''}"
				,
					[#if result.register_time?exists]
						"${result.register_time?string('yyyy-MM-dd')}"
					[#else]
						""
					[/#if]
				,
					[#if result.last_time?exists]
						"${result.last_time?string('yyyy-MM-dd')}"
					[#else]
						""
					[/#if]
				,
					[#if "${result.mem_state!''}"=="1"]"正常"[#else]"<font color='red'>禁用</font>"[/#if]
				
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}