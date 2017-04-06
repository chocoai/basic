<?xml version="1.0"?>
<?mso-application progid="Excel.Sheet"?>
<Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:o="urn:schemas-microsoft-com:office:office"
 xmlns:x="urn:schemas-microsoft-com:office:excel"
 xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:html="http://www.w3.org/TR/REC-html40">
 <DocumentProperties xmlns="urn:schemas-microsoft-com:office:office">
  <Created>1996-12-17T01:32:42Z</Created>
  <LastSaved>2014-07-24T09:36:09Z</LastSaved>
  <Version>12.00</Version>
 </DocumentProperties>
 <OfficeDocumentSettings xmlns="urn:schemas-microsoft-com:office:office">
  <RemovePersonalInformation/>
 </OfficeDocumentSettings>
 <ExcelWorkbook xmlns="urn:schemas-microsoft-com:office:excel">
  <WindowHeight>4530</WindowHeight>
  <WindowWidth>8505</WindowWidth>
  <WindowTopX>480</WindowTopX>
  <WindowTopY>120</WindowTopY>
  <ProtectStructure>False</ProtectStructure>
  <ProtectWindows>False</ProtectWindows>
 </ExcelWorkbook>
 <Styles>
  <Style ss:ID="Default" ss:Name="Normal">
   <Alignment ss:Vertical="Bottom"/>
   <Borders/>
   <Font ss:FontName="宋体" x:CharSet="134" ss:Size="12"/>
   <Interior/>
   <NumberFormat/>
   <Protection/>
  </Style>
  <Style ss:ID="s62">
   <Alignment ss:Vertical="Bottom" ss:WrapText="1"/>
  </Style>
  <Style ss:ID="s65">
   <Font ss:FontName="宋体" x:CharSet="134" ss:Size="12"/>
  </Style>
  <Style ss:ID="s66">
   <Alignment ss:Horizontal="Center" ss:Vertical="Bottom"/>
   <Borders>
    <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
   </Borders>
  </Style>
  <Style ss:ID="s67">
   <Alignment ss:Vertical="Bottom" ss:WrapText="1"/>
   <Borders>
    <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
   </Borders>
   <Font ss:FontName="宋体" x:CharSet="134" ss:Size="12"/>
  </Style>
  <Style ss:ID="s68">
   <Alignment ss:Vertical="Bottom" ss:WrapText="1"/>
   <Borders>
    <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
   </Borders>
  </Style>
  <Style ss:ID="s69">
   <Alignment ss:Horizontal="Center" ss:Vertical="Bottom" ss:WrapText="1"/>
   <Font ss:FontName="宋体" x:CharSet="134" ss:Size="12"/>
  </Style>
 </Styles>
 <Worksheet ss:Name="Sheet1">
 [#assign count=block.resultList?size]
 [#assign count=count+10]
  <Table ss:ExpandedColumnCount="7" ss:ExpandedRowCount="${count!''}" x:FullColumns="1"
   x:FullRows="1" ss:DefaultColumnWidth="54" ss:DefaultRowHeight="14.25">
   <Column ss:Index="2" ss:AutoFitWidth="0" ss:Width="100.5"/>
   <Column ss:AutoFitWidth="0" ss:Width="66.75"/>
   <Column ss:AutoFitWidth="0" ss:Width="72.75"/>
   <Column ss:AutoFitWidth="0" ss:Width="63.75"/>
   <Column ss:AutoFitWidth="0" ss:Width="84"/>
   <Column ss:AutoFitWidth="0" ss:Width="225.75"/>
   <Row>
    <Cell ss:MergeAcross="6" ss:StyleID="s69"><Data ss:Type="String">突发事件明细表</Data></Cell>
   </Row>
   <Row>
    <Cell ss:StyleID="s65"><Data ss:Type="String">导出日期：</Data></Cell>
    <Cell ss:StyleID="s65"><Data ss:Type="String">${block.current_time!''}</Data></Cell>
   </Row>
   <Row>
    <Cell ss:StyleID="s66"><Data ss:Type="String">序号</Data></Cell>
    <Cell ss:StyleID="s66"><Data ss:Type="String">灾害简称</Data></Cell>
    <Cell ss:StyleID="s66"><Data ss:Type="String">所属区域</Data></Cell>
    <Cell ss:StyleID="s66"><Data ss:Type="String">灾害类型</Data></Cell>
    <Cell ss:StyleID="s66"><Data ss:Type="String">灾害级别</Data></Cell>
    <Cell ss:StyleID="s66"><Data ss:Type="String">灾害发生时间</Data></Cell>
    <Cell ss:StyleID="s66"><Data ss:Type="String">灾害描述</Data></Cell>
   </Row>
   [#assign index=1]
	 [#list block.resultList as result]
		[#assign xzqh="${result.disaster_region!''}"]
			[#if EnumService.getEnum('xzqh')?exists]
			[#list EnumService.getEnum('xzqh') as enum]
				[#if "${result.disaster_region!''}"=="${enum.enum_value!''}"]
					[#assign xzqh="${enum.enum_name!''}"]
				[/#if]
			[/#list]
			[/#if]
			[#assign disaster_type="${result.disaster_type!''}"]
			[#if EnumService.getEnum('disaster_type')?exists]
			[#list EnumService.getEnum('disaster_type') as enum]
				[#if "${result.disaster_type!''}"=="${enum.enum_value!''}"]
					[#assign disaster_type="${enum.enum_name!''}"]
				[/#if]
			[/#list]
			[/#if]
			[#assign disaster_grade=""]
			[#if "${result.disaster_grade!''}"=="1"][#assign disaster_grade="一般"][/#if]
			[#if "${result.disaster_grade!''}"=="2"][#assign disaster_grade="较大"][/#if]
			[#if "${result.disaster_grade!''}"=="3"][#assign disaster_grade="重大"][/#if]
			[#if "${result.disaster_grade!''}"=="4"][#assign disaster_grade="特别重大"][/#if]
		<Row ss:StyleID="s62">
		<Cell ss:StyleID="s67"><Data ss:Type="String">${index}[#assign index=index+1]</Data></Cell>
		<Cell ss:StyleID="s67"><Data ss:Type="String">${result.disaster_name!''}</Data></Cell>
		<Cell ss:StyleID="s67"><Data ss:Type="String">${xzqh!''}</Data></Cell>
		<Cell ss:StyleID="s67"><Data ss:Type="String">${disaster_type!''}</Data></Cell>
		<Cell ss:StyleID="s67"><Data ss:Type="String">${disaster_grade!''}</Data></Cell>
		<Cell ss:StyleID="s67"><Data ss:Type="String">[#if result.disaster_date?exists]${result.disaster_date?date}[#else] [/#if]</Data></Cell>
		<Cell ss:StyleID="s67"><Data ss:Type="String">${result.disaster_discription!''}</Data></Cell>
	   </Row>
	[/#list]
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <Print>
    <ValidPrinterInfo/>
    <PaperSizeIndex>9</PaperSizeIndex>
    <HorizontalResolution>600</HorizontalResolution>
    <VerticalResolution>600</VerticalResolution>
   </Print>
   <Selected/>
   <Panes>
    <Pane>
     <Number>3</Number>
     <ActiveRow>15</ActiveRow>
    </Pane>
   </Panes>
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
 <Worksheet ss:Name="Sheet2">
  <Table ss:ExpandedColumnCount="1" ss:ExpandedRowCount="1" x:FullColumns="1"
   x:FullRows="1" ss:DefaultColumnWidth="54" ss:DefaultRowHeight="14.25">
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
 <Worksheet ss:Name="Sheet3">
  <Table ss:ExpandedColumnCount="1" ss:ExpandedRowCount="1" x:FullColumns="1"
   x:FullRows="1" ss:DefaultColumnWidth="54" ss:DefaultRowHeight="14.25">
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
</Workbook>
