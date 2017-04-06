{ 
  "total": "${block.page.totalpage}", 
  "page": "${block.page.currentpage}", 
  "records": "${block.page.totalnum}",
  "rows" : [
 [#list block.resultList as result]
 {"cell" :[
				"${result.organ_id!''}"
				,"${result.organ_name!''}"
				,[#assign organ_type=""]
				[#if EnumService.getEnum('safe_unit_type')?exists]
				[#list EnumService.getEnum('safe_unit_type') as enum]
				[#if "${result.com_type!''}"=="${enum.enum_value!''}"][#assign organ_type="${enum.enum_name!''}"][/#if]
				[/#list]
				[/#if]
				"${organ_type!''}"
				,[#assign city_district=""]
				[#if EnumService.getEnum('xzqh')?exists]
				[#list EnumService.getEnum('xzqh') as enum]
				[#if "${result.organ_region!''}"=="${enum.enum_value!''}"][#assign city_district="${enum.enum_name!''}"][/#if]
				[/#list]
				[/#if]
				"${city_district!''}"
				,"${result.organ_linkman!''}"
				,"${result.organ_phone!''}"
				,"${result.authentication_state!''}"
				,[#assign state=""]
				[#if "${result.authentication_state!''}"=="0"][#assign state="待认证 "][/#if]
				[#if "${result.authentication_state!''}"=="1"][#assign state="通过认证"][/#if]				
				"${state!''}"
				,"${result.organ_desc!''}"
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}