{ 
  "total": "${block.page.totalpage}", 
  "page": "${block.page.currentpage}", 
  "records": "${block.page.totalnum}",
  "rows" : [
 [#list block.resultList as result]
 {"cell" :[
 		[#assign yt="${result.use_desgin!''}"]
	    [#if EnumService.getEnum('sjyt')?exists]
	    [#list EnumService.getEnum('sjyt') as enum]
			[#if "${result.use_desgin!''}"=="${enum.enum_value!''}"]
				[#assign yt="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
		[#assign jg="${result.build_struct!''}"]
	    [#if EnumService.getEnum('fwjg')?exists]
	    [#list EnumService.getEnum('fwjg') as enum]
			[#if "${result.build_struct!''}"=="${enum.enum_value!''}"]
				[#assign jg="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
		[#assign fwcb="${result.real_type!''}"]
	    [#if EnumService.getEnum('fwcb')?exists]
	    [#list EnumService.getEnum('fwcb') as enum]
			[#if "${result.real_type!''}"=="${enum.enum_value!''}"]
				[#assign fwcb="${enum.enum_name!''}"]
			[/#if]
		[/#list]
	    [/#if]
				"${result.building_id!''}"
				,"${result.jdinfo_id!''}"
				,"<a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safeauth.dangerous.detail?building_id=${result.building_id!''}','','dialogWidth:1000px;dialogHeight:600px;center:1;')>${result.building_address!''}</a>"
				,"${result.building_address!''}"
				,[#assign qh=""]
				[#list EnumService.getEnum('xzqh') as enum]
				[#if "${result.builiding_region!''}"=="${enum.enum_value!''}"][#assign qh="${enum.enum_name!''}"][#break][/#if]
				[/#list]
				"${qh!''}"
				,"${result.floor_count!''}"
				,"${result.house_count!''}"
				,"${result.floorup_count!''}"
				,[#if "${result.build_area!''}"!=""]"#{result.build_area!'';m0M2}"[#else]""[/#if] 
				,"${fwcb!''}"
				,"${yt!''}"
				,"${result.building_date!''}"
				,"${jg!''}"
				,[#assign dangerous_level=""]
				[#if "${result.health_grade_jd!''}"=="1"][#assign dangerous_level="<div style='heigth:20px;width:70px;background-color:green;float:right;'> </div>A级"][/#if]
			    [#if "${result.health_grade_jd!''}"=="2"][#assign dangerous_level="<div style='heigth:20px;width:70px;background-color:yellow;float:right;'> </div>B级"][/#if]
			    [#if "${result.health_grade_jd!''}"=="3"][#assign dangerous_level="<div style='heigth:20px;width:70px;background-color:#CC6600;float:right;'> </div>C级"][/#if]
			    [#if "${result.health_grade_jd!''}"=="4"][#assign dangerous_level="<div style='heigth:20px;width:70px;background-color:red;float:right;'> </div>D级"][/#if]
				"${dangerous_level!''}"
				,[#if "${result.is_die!''}"=="0"]"消亡"[#else]"正常"[/#if]
				,"${result.wfzz_status!''}"
				,[#if "${result.notice_state!''}"=="1"]"<a href='javascript:void(0);' onclick=noticedetial('${result.building_id!''}')>已发送</a>"[#else]"未发送"[/#if]
 				,"${result.notice_state!''}"
 				,"<a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safecheck.buildingmapidenty?building_mapid=${result.building_id!''}','','dialogWidth:1000px;dialogHeight:600px;center:1;')>定位</a>"	
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}