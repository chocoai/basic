{ 
  "total": "${block.page.totalpage}", 
  "page": "${block.page.currentpage}", 
  "records": "${block.page.totalnum}",
  "rows" : [
 [#list block.resultList as result]
 {"cell" :[
					"${result.organ_id!''}"
				,
					"${result.organ_name!''}"
				,
					"${result.organ_code!''}"
				,
					"${result.organ_region!''}"
				,
					"${result.organ_region_name!''}"
				,
					"${result.organ_linkman!''}"
				,
					"${result.organ_address!''}"
				,
					"${result.organ_phone!''}"
				,
					"${result.organ_postcode!''}"
				,
					"${result.organ_domainname!''}"
				,
					"${result.organ_trade!''}"
				,
					"${result.com_type!''}"
				,
					"${result.organ_desc!''}"
				,
					"${result.organ_type!''}"
				,
					"${result.organ_staff_number!''}"
				,
					"${result.organ_cred_type!''}"
				,
					"${result.organ_cred_code!''}"
				,
				[#assign typelist1=""]
				[#if result.orgcomtype_list?exists]
					[#list result.orgcomtype_list as type]
					[#if "${type.organ_type_state!''}"=="1"]
					[#assign typelist1=typelist1+"${type.organ_type_cname!''}  "]
					[#else]
					[#assign typelist1=typelist1+"<font color='red'>${type.organ_type_cname!''}</font>  "]
					[/#if]
					[/#list]
				[/#if]
				"${typelist1!''}"
				,	"${result.authentication_state!''}",[#if "1"=="${result.authentication_state!''}"]"通过"[#else]"未通过"[/#if]
				,
					"${result.organ_domainname2!''}"
				,[#if result.reg_date?exists]"${result.reg_date?string("yyyy-MM-dd")}"[#else]""[/#if]
				
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}