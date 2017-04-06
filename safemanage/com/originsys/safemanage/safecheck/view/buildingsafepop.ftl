[#list block.HealthGradePc as pc]
	健康等级--普查：${pc.GRADE!''}数量：${pc.COUNT!''}<br/>
[/#list]
[#list block.HealthGradeJd as jd]
	健康等级--鉴定：${jd.GRADE!''}数量：${jd.COUNT!''}<br/>
[/#list]