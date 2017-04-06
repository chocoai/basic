<?xml version='1.0' encoding='utf-8'?>
<rows>
<page>1</page>
<total>1</total>
<records>1</records>
	[#if access.canDo(user,'safecheck.survey.editlist')||access.canDo(user,'safecheck.survey.managelist')||access.canDo(user,'safecheck.survey.housecounthz')||access.canDo(user,'safecheck.survey.housepoicheck')]
	<row><cell>10</cell><cell>第一次普查管理</cell><cell></cell><cell>1</cell><cell>NULL</cell><cell>false</cell><cell>false</cell></row>
		<!--row><cell>1001</cell><cell>楼幢检查录入</cell><cell>${_servlet_url!''}/safecheck.building.insert?sb_id=631820</cell><cell>2</cell><cell>1</cell><cell>true</cell><cell>false</cell></row-->
		[#if access.canDo(user,'safecheck.survey.editlist')]
		<row><cell>10003</cell><cell>普查数据录入</cell><cell>${_servlet_url!''}/safecheck.survey.choosehouse</cell><cell>2</cell><cell>10</cell><cell>true</cell><cell>false</cell></row>
		<row><cell>10004</cell><cell>普查数据列表</cell><cell>${_servlet_url!''}/safecheck.survey.editlist</cell><cell>2</cell><cell>10</cell><cell>true</cell><cell>false</cell></row>
		[/#if]
		[#if access.canDo(user,'safecheck.survey.managelist')]
		<row><cell>10002</cell><cell>普查数据审核列表</cell><cell>${_servlet_url!''}/safecheck.survey.managelist</cell><cell>2</cell><cell>10</cell><cell>true</cell><cell>false</cell></row>		
		[/#if]
		[#if access.canDo(user,'safecheck.survey.housecounthz')]
		<row><cell>10001</cell><cell>统计分析</cell><cell></cell><cell>2</cell><cell>10</cell><cell>false</cell><cell>false</cell></row>
			<row><cell>100011</cell><cell>普查楼幢汇总表</cell><cell>${_servlet_url!''}/safecheck.survey.housecounthz</cell><cell>3</cell><cell>10001</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>100012</cell><cell>普查面积汇总表</cell><cell>${_servlet_url!''}/safecheck.survey.buildareahz</cell><cell>3</cell><cell>10001</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>100016</cell><cell>楼幢普查明细</cell><cell>${_servlet_url!''}/safecheck.survey.surveymx</cell><cell>3</cell><cell>10001</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>100013</cell><cell>普查楼幢统计</cell><cell>${_servlet_url!''}/safecheck.survey.housecounttj</cell><cell>3</cell><cell>10001</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>100014</cell><cell>普查面积统计</cell><cell>${_servlet_url!''}/safecheck.survey.buildareatj</cell><cell>3</cell><cell>10001</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>100015</cell><cell>普查等级统计</cell><cell>${_servlet_url!''}/safecheck.survey.safegradetj</cell><cell>3</cell><cell>10001</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>100018</cell><cell>自定义统计</cell><cell>${_servlet_url!''}/safecheck.survey.complexcount</cell><cell>3</cell><cell>10001</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>100017</cell><cell>安全等级专题图</cell><cell>${_servlet_url!''}/safecheck.survey.safegradetheme</cell><cell>3</cell><cell>10001</cell><cell>true</cell><cell>false</cell></row>
		[/#if]
		[#if access.canDo(user,'safecheck.survey.housepoicheck')]
		<row><cell>10005</cell><cell>地物查询</cell><cell>${_servlet_url!''}/safecheck.survey.housepoicheck</cell><cell>2</cell><cell>10</cell><cell>true</cell><cell>false</cell></row>
		[/#if]
	[/#if]
	[#if access.canDo(user,'safecheck.safemanager.list')||access.canDo(user,'safecheck.safecensor.list')||access.canDo(user,'safecheck.safeassessors.list')||access.canDo(user,'commonservice.department.editlist')]
	<row><cell>2</cell><cell>人员备案管理</cell><cell></cell><cell>1</cell><cell>NULL</cell><cell>false</cell><cell>false</cell></row>
		[#if access.canDo(user,'safecheck.safemanager.list')]
		<row><cell>2001</cell><cell>安全管理员管理</cell><cell>${_servlet_url!''}/safecheck.safemanager.list</cell><cell>2</cell><cell>2</cell><cell>true</cell><cell>false</cell></row>
		[/#if]
		[#if access.canDo(user,'safecheck.safecensor.list')]
		<row><cell>2002</cell><cell>安全检查员管理</cell><cell>${_servlet_url!''}/safecheck.safecensor.list</cell><cell>2</cell><cell>2</cell><cell>true</cell><cell>false</cell></row>
		[/#if]
		[#if access.canDo(user,'safecheck.safeassessors.list')]
		<row><cell>2003</cell><cell>安全鉴定员管理</cell><cell>${_servlet_url!''}/safecheck.safeassessors.list</cell><cell>2</cell><cell>2</cell><cell>true</cell><cell>false</cell></row>
		[/#if]
		[#if access.canDo(user,'commonservice.department.editlist')]
		<row><cell>2004</cell><cell>安全鉴定机构管理</cell><cell>${_servlet_url!''}/commonservice.department.editlist?com_id=1</cell><cell>2</cell><cell>2</cell><cell>true</cell><cell>false</cell></row>
		[/#if]
	[/#if]
	[#if access.canDo(user,'safecheck.building.choosehouse')||access.canDo(user,'safecheck.building.editlist')||access.canDo(user,'safecheck.building.managelist')]
	<row><cell>3</cell><cell>安全检查管理</cell><cell></cell><cell>1</cell><cell>NULL</cell><cell>false</cell><cell>false</cell></row>
		[#if access.canDo(user,'safecheck.building.choosehouse')]
		<row><cell>3003</cell><cell>楼幢检查录入</cell><cell>${_servlet_url!''}/safecheck.building.choosehouse</cell><cell>2</cell><cell>3</cell><cell>true</cell><cell>false</cell></row>
		[/#if]
		[#if access.canDo(user,'safecheck.building.editlist')]
		<row><cell>3004</cell><cell>楼幢检查列表(检查员)</cell><cell>${_servlet_url!''}/safecheck.building.editlist</cell><cell>2</cell><cell>3</cell><cell>true</cell><cell>false</cell></row>
		[/#if]
		[#if access.canDo(user,'safecheck.building.managelist')]
		<row><cell>3002</cell><cell>楼幢检查列表(管理员)</cell><cell>${_servlet_url!''}/safecheck.building.managelist</cell><cell>2</cell><cell>3</cell><cell>true</cell><cell>false</cell></row>
		[/#if]
	[/#if]
	[#if access.canDo(user,'safeauth.report.choosehouse')||access.canDo(user,'safeauth.report.list')||access.canDo(user,'safeauth.report.managelist')]
	<row><cell>5</cell><cell>安全鉴定管理</cell><cell></cell><cell>1</cell><cell>NULL</cell><cell>false</cell><cell>false</cell></row>
		[#if access.canDo(user,'safeauth.report.choosehouse')]
		<row><cell>5001</cell><cell>鉴定报告录入</cell><cell>${_servlet_url!''}/safeauth.report.choosehouse</cell><cell>2</cell><cell>5</cell><cell>true</cell><cell>false</cell></row>
		[/#if]
		[#if access.canDo(user,'safeauth.report.list')]
		<row><cell>5002</cell><cell>鉴定报告列表(检查员)</cell><cell>${_servlet_url!''}/safeauth.report.list</cell><cell>2</cell><cell>5</cell><cell>true</cell><cell>false</cell></row>
		[/#if]
		[#if access.canDo(user,'safeauth.report.managelist')]
		<row><cell>5003</cell><cell>鉴定报告列表(管理员)</cell><cell>${_servlet_url!''}/safeauth.report.managelist</cell><cell>2</cell><cell>5</cell><cell>true</cell><cell>false</cell></row>
		[/#if]
	[/#if]
	[#if access.canDo(user,'safecheck.building.poplist')]
	<row><cell>14</cell><cell>隐患房屋列表</cell><cell>${_servlet_url!''}/safecheck.building.poplist</cell><cell>1</cell><cell>NULL</cell><cell>true</cell><cell>false</cell></row>
	[/#if]
	[#if access.canDo(user,'safeauth.dangerous.list')]
	<row><cell>7</cell><cell>危房管理</cell><cell>${_servlet_url!''}/safeauth.dangerous.list</cell><cell>1</cell><cell>NULL</cell><cell>true</cell><cell>false</cell></row>
	[/#if]
	[#if access.canDo(user,'safeauth.dangerous.managelist')]
	<row><cell>17</cell><cell>危房管理(管理员)</cell><cell>${_servlet_url!''}/safeauth.dangerous.managelist</cell><cell>1</cell><cell>NULL</cell><cell>true</cell><cell>false</cell></row>
	[/#if]
	[#if access.canDo(user,'safecheck.tHdangerBuildinglist')]
	<row><cell>15</cell><cell>隐患房屋上报管理</cell><cell>${_servlet_url!''}/safecheck.tHdangerBuildinglist</cell><cell>1</cell><cell>NULL</cell><cell>true</cell><cell>false</cell></row>
	[/#if]
	<!--[#if access.canDo(user,'safecheck.tHdangerBuilding.forinsert')]
	<row><cell>16</cell><cell>隐患房屋上报</cell><cell>${_servlet_url!''}/safecheck.tHdangerBuilding.forinsert</cell><cell>1</cell><cell>NULL</cell><cell>true</cell><cell>false</cell></row>
	[/#if]-->
	[#if access.canDo(user,'safecheck.building.housecounthz')||access.canDo(user,'safecheck.auth.housecounthz')||access.canDo(user,'safecheck.auth.workloadtj')||access.canDo(user,'safecheck.safeauth.dangeroustj')]
	<row><cell>9</cell><cell>安全统计管理</cell><cell></cell><cell>1</cell><cell>NULL</cell><cell>false</cell><cell>false</cell></row>
		[#if access.canDo(user,'safecheck.building.housecounthz')]
		<row><cell>9001</cell><cell>检查统计管理</cell><cell></cell><cell>2</cell><cell>9</cell><cell>false</cell><cell>false</cell></row>
			<row><cell>900011</cell><cell>检查楼幢汇总表</cell><cell>${_servlet_url!''}/safecheck.building.housecounthz</cell><cell>3</cell><cell>9001</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>900012</cell><cell>检查面积汇总表</cell><cell>${_servlet_url!''}/safecheck.building.buildareahz</cell><cell>3</cell><cell>9001</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>900016</cell><cell>安全检查明细</cell><cell>${_servlet_url!''}/safecheck.building.buildingmx</cell><cell>3</cell><cell>9001</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>900017</cell><cell>检查综合统计</cell><cell>${_servlet_url!''}/safeauth.dangerouscount.list?ctype=pc</cell><cell>3</cell><cell>9001</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>900013</cell><cell>检查楼幢统计</cell><cell>${_servlet_url!''}/safecheck.building.housecounttj</cell><cell>3</cell><cell>9001</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>900014</cell><cell>检查面积统计</cell><cell>${_servlet_url!''}/safecheck.building.buildareatj</cell><cell>3</cell><cell>9001</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>900015</cell><cell>检查等级统计</cell><cell>${_servlet_url!''}/safecheck.building.safegradetj</cell><cell>3</cell><cell>9001</cell><cell>true</cell><cell>false</cell></row>
		[/#if]
		[#if access.canDo(user,'safecheck.auth.housecounthz')]
		<row><cell>9002</cell><cell>鉴定统计管理</cell><cell></cell><cell>2</cell><cell>9</cell><cell>false</cell><cell>false</cell></row>
			<row><cell>900021</cell><cell>鉴定楼幢汇总表</cell><cell>${_servlet_url!''}/safecheck.auth.housecounthz</cell><cell>3</cell><cell>9002</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>900022</cell><cell>鉴定面积汇总表</cell><cell>${_servlet_url!''}/safecheck.auth.buildareahz</cell><cell>3</cell><cell>9002</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>900023</cell><cell>安全鉴定明细</cell><cell>${_servlet_url!''}/safecheck.auth.authmx</cell><cell>3</cell><cell>9002</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>900027</cell><cell>鉴定综合统计</cell><cell>${_servlet_url!''}/safeauth.dangerouscount.list?ctype=jd</cell><cell>3</cell><cell>9002</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>900026</cell><cell>鉴定楼幢统计</cell><cell>${_servlet_url!''}/safecheck.auth.housecounttj</cell><cell>3</cell><cell>9002</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>900024</cell><cell>鉴定面积统计</cell><cell>${_servlet_url!''}/safecheck.auth.buildareatj</cell><cell>3</cell><cell>9002</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>900025</cell><cell>鉴定等级统计</cell><cell>${_servlet_url!''}/safecheck.auth.safegradetj</cell><cell>3</cell><cell>9002</cell><cell>true</cell><cell>false</cell></row>
		[/#if]
		[#if access.canDo(user,'safecheck.auth.workloadtj')]
		<row><cell>9003</cell><cell>工作量统计管理</cell><cell></cell><cell>2</cell><cell>9</cell><cell>false</cell><cell>false</cell></row>
			<row><cell>900031</cell><cell>鉴定工作量统计</cell><cell>${_servlet_url!''}/safecheck.auth.workloadtj</cell><cell>3</cell><cell>9003</cell><cell>true</cell><cell>false</cell></row>
			<row><cell>900032</cell><cell>检查工作量统计</cell><cell>${_servlet_url!''}/safecheck.building.workloadtj</cell><cell>3</cell><cell>9003</cell><cell>true</cell><cell>false</cell></row>
		[/#if]
		<!--[#if access.canDo(user,'safecheck.safeauth.dangeroustj')]
		<row><cell>9004</cell><cell>隐患房屋统计</cell><cell>${_servlet_url!''}/safecheck.safeauth.dangeroustj</cell><cell>2</cell><cell>9</cell><cell>true</cell><cell>false</cell></row>	
		[/#if]-->
	[/#if]
	[#if access.canDo(user,'safecheck.survey.checkgradetheme')]
	<row><cell>8</cell><cell>安全预警管理</cell><cell></cell><cell>1</cell><cell>NULL</cell><cell>false</cell><cell>false</cell></row>
	<row><cell>8001</cell><cell>安全检查专题图</cell><cell>${_servlet_url!''}/safecheck.survey.checkgradetheme</cell><cell>2</cell><cell>8</cell><cell>true</cell><cell>false</cell></row>
	<row><cell>8002</cell><cell>安全鉴定专题图</cell><cell>${_servlet_url!''}/safecheck.survey.testgradetheme</cell><cell>2</cell><cell>8</cell><cell>true</cell><cell>false</cell></row>
	[/#if]
	<!--<row><cell>11</cell><cell>安全信息发布管理</cell><cell></cell><cell>1</cell><cell>NULL</cell><cell>false</cell><cell>false</cell></row>
	<row><cell>4</cell><cell>用户设置</cell><cell></cell><cell>1</cell><cell>NULL</cell><cell>false</cell><cell>false</cell></row>
		<row><cell>4001</cell><cell>基本信息</cell><cell>${_servlet_url!''}/commonservice.login.formybasemessages</cell><cell>2</cell><cell>4</cell><cell>true</cell><cell>false</cell></row>
		<row><cell>4002</cell><cell>修改密码</cell><cell>${_servlet_url!''}/commonservice.login.forchangepassword</cell><cell>2</cell><cell>4</cell><cell>true</cell><cell>false</cell></row>
	-->
</rows>
[#-- 1是id 2是name 3url 4级别-从0开始 5父节点id 6是否是末级节点 7是否可展开 --]