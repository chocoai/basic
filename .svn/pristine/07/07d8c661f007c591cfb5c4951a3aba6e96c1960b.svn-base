{ 
  "total": "${block.page.totalpage}", 
  "page": "${block.page.currentpage}", 
  "records": "${block.page.totalnum}",
  "rows" : [
 [#list block.resultList as result]
 {"cell" :[
					"${result.project_id!''}"
				,"${result.project_name!''}"
				,"${result.project_address!''}"
				,
				[#assign city_district=""]
				[#if EnumService.getEnum('xzqh')?exists]
				[#list EnumService.getEnum('xzqh') as enum]
				[#if "${result.city_district!''}"=="${enum.enum_value!''}"][#assign city_district="${enum.enum_name!''}"][/#if]
				[/#list]
				[/#if]
				"${city_district!''}"
				,"${result.unit_name!''}"
				,"${result.project_buildingids!''}"
				,"<button type='button' onclick=doChooseBuilding('${result.project_id!''}')>维护管理区域</button>"
				,"${result.review_state!''}"
				,[#assign state=""]
				[#if "${result.review_state!''}"=="0"][#assign state="待审核"][/#if]
				[#if "${result.review_state!''}"=="1"][#assign state="审核驳回"][/#if]
				[#if "${result.review_state!''}"=="2"][#assign state="审核通过"][/#if]
				"${state!''}"
				,"${result.project_desc!''}"
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}