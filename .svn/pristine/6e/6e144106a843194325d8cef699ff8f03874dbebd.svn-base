{
	[#-- assign yt="${block.use_design!''}"]
	    [#if EnumService.getEnum('sjyt')?exists]
	    [#list EnumService.getEnum('sjyt') as enum]
			[#if "${block.use_design!''}"=="${enum.enum_value!''}"]
				[#assign yt="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
		[#assign jg="${block.build_struct!''}"]
	    [#if EnumService.getEnum('fwjg')?exists]
	    [#list EnumService.getEnum('fwjg') as enum]
			[#if "${block.build_struct!''}"=="${enum.enum_value!''}"]
				[#assign jg="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
		[#assign fwcb="${block.real_type!''}"]
	    [#if EnumService.getEnum('fwcb')?exists]
	    [#list EnumService.getEnum('fwcb') as enum]
			[#if "${block.real_type!''}"=="${enum.enum_value!''}"]
				[#assign fwcb="${enum.enum_name!''}"]
			[/#if]
		[/#list]
	[/#if--]
	"building_id":"${block.sb_id!''}",
	"ws_zb":"${block.ws_zb!''}",
	"surverproject_id":"${block.surverproject_id!''}",
	"unit":"${block.unit!''}",
	"surver":"${block.surver!''}",
	"use_desgin":"${block.use_design!''}",
	"real_type":"${block.real_type!''}",
	"tn_area":"${block.tn_area!''}",
	"ft_area":"${block.ft_area!''}",
	"build_area":"${block.build_area!''}",
	"noft_area":"${block.noft_area!''}",
	"no_area":"${block.no_area!''}",
	"discrepant_area":"${block.discrepant_area!''}",
	"sruver_date":"${block.sruver_date!''}",
	"surver_enddate":"${block.surver_enddate!''}",
	"building_number":"${block.building_number!''}",
	"build_struct":"${block.build_struct!''}",
	"graphics_code":"${block.graphics_code!''}",
	"graphics_number":"${block.graphics_number!''}",
	"input_date":"${block.input_date!''}",
	"floorup_count":"${block.floorup_count!''}",
	"floordown_count":"${block.floordown_count!''}",
	"city_district":"${block.city_district!''}",
	"building_mapid":"${block.building_mapid!''}",
	"building_address":"${block.building_address!''}",
	"building_date":"${block.building_date!''}",
	"floor_count":"${block.floor_count!''}",
	"house_count":"${block.house_count!''}"		
}