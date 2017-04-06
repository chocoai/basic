{ 
  "total": "${block.page.totalpage}", 
  "page": "${block.page.currentpage}", 
  "records": "${block.page.totalnum}",
  "rows" : [
 [#list block.resultList as result]
 {"cell" :[
				"${result.jdinfo_id!''}"
				,"${result.building_id!''}"
				,"<a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safeauth.report.detail?jdinfo_id=${result.jdinfo_id!''}','','dialogWidth:1000px;dialogHeight:600px;center:1;')>${result.building_address!''}</a>"
				,"${result.building_address!''}"
				,[#assign qh=""]
				[#list EnumService.getEnum('xzqh') as enum]
				[#if "${result.building_region!''}"=="${enum.enum_value!''}"][#assign qh="${enum.enum_name!''}"][#break][/#if]
				[/#list]
				"${qh!''}"
				,"${result.entrust_user!''}"
				,"${result.linkman!''}"
				,"${result.linktel!''}"
				,"${result.jdmember!''}"
				,[#if result.jd_date?exists]
						"${result.jd_date?string("yyyy-MM-dd")}"
					[#else]
						""
					[/#if]
				,[#assign dangerous_level=""]
				[#if "${result.dangerous_level!''}"=="1"][#assign dangerous_level="<div style='heigth:20px;width:70px;background-color:green;float:right;'> </div>A级"][/#if]
			    [#if "${result.dangerous_level!''}"=="2"][#assign dangerous_level="<div style='heigth:20px;width:70px;background-color:yellow;float:right;'> </div>B级"][/#if]
			    [#if "${result.dangerous_level!''}"=="3"][#assign dangerous_level="<div style='heigth:20px;width:70px;background-color:#CC6600;float:right;'> </div>C级"][/#if]
			    [#if "${result.dangerous_level!''}"=="4"][#assign dangerous_level="<div style='heigth:20px;width:70px;background-color:red;float:right;'> </div>D级"][/#if]
				"${dangerous_level!''}"
				,[#assign struct_aging=""]
				[#if "${result.struct_aging!''}"=="1"][#assign struct_aging="强"][/#if] 
				[#if "${result.struct_aging!''}"=="2"][#assign struct_aging="弱"][/#if] 
				[#if "${result.struct_aging!''}"=="3"][#assign struct_aging="差"][/#if]
				"${struct_aging!''}"
				,[#assign is_transform=""]
				[#if "${result.is_transform!''}"=="1"][#assign is_transform="是"][/#if] 
				[#if "${result.is_transform!''}"=="2"][#assign is_transform="否"][/#if] 
				"${is_transform!''}"
				,[#assign facility_aging=""]
				[#if "${result.facility_aging!''}"=="1"][#assign facility_aging="强"][/#if] 
				[#if "${result.facility_aging!''}"=="2"][#assign facility_aging="弱"][/#if] 
				[#if "${result.facility_aging!''}"=="3"][#assign facility_aging="差"][/#if]
				"${facility_aging!''}"
				,[#assign facility_aging=""]
				[#if "${result.is_kzperfect!''}"=="1"][#assign facility_aging="强"][/#if] 
				[#if "${result.is_kzperfect!''}"=="2"][#assign facility_aging="弱"][/#if] 
				[#if "${result.is_kzperfect!''}"=="3"][#assign facility_aging="差"][/#if]
				"${is_kzperfect!''}"
				,[#assign is_transform_seriousness=""]
				[#if "${result.is_transform_seriousness!''}"=="1"][#assign is_transform_seriousness="强"][/#if] 
				[#if "${result.is_transform_seriousness!''}"=="2"][#assign is_transform_seriousness="弱"][/#if] 
				[#if "${result.is_transform_seriousness!''}"=="3"][#assign is_transform_seriousness="差"][/#if]
				"${is_transform_seriousness!''}"				
				,"${result.jd_department_id!''}"				
				,"${result.info_state!''}"
				,[#assign state=""]
				[#if "${result.info_state!''}"=="0"][#assign state="暂存"][/#if] 
				[#if "${result.info_state!''}"=="1"][#assign state="待审核"][/#if] 
				[#if "${result.info_state!''}"=="2"][#assign state="审核驳回"][/#if] 
				[#if "${result.info_state!''}"=="8"][#assign state="审核通过"][/#if] 
				"${state!''}"
				,"<a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safecheck.buildingmapidenty?building_mapid=${result.building_id!''}','','dialogWidth:1000px;dialogHeight:600px;center:1;')>定位</a>"			
				,"${result.entry_mem_id!''}"
				,[#if result.entry_date?exists]
						"${result.entry_date?string("yyyy-MM-dd")}"
					[#else]
						""
					[/#if]
				
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}