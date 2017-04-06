<?xml version="1.0"?>
<?mso-application progid="Excel.Sheet"?>
<Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:o="urn:schemas-microsoft-com:office:office"
 xmlns:x="urn:schemas-microsoft-com:office:excel"
 xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:html="http://www.w3.org/TR/REC-html40">
 <DocumentProperties xmlns="urn:schemas-microsoft-com:office:office">
  <Created>2006-09-16T00:00:00Z</Created>
  <LastSaved>2014-06-18T02:06:20Z</LastSaved>
  <Version>14.00</Version>
 </DocumentProperties>
 <OfficeDocumentSettings xmlns="urn:schemas-microsoft-com:office:office">
  <AllowPNG/>
  <RemovePersonalInformation/>
 </OfficeDocumentSettings>
 <ExcelWorkbook xmlns="urn:schemas-microsoft-com:office:excel">
  <WindowHeight>8010</WindowHeight>
  <WindowWidth>14805</WindowWidth>
  <WindowTopX>240</WindowTopX>
  <WindowTopY>105</WindowTopY>
  <ProtectStructure>False</ProtectStructure>
  <ProtectWindows>False</ProtectWindows>
 </ExcelWorkbook>
 <Styles>
  <Style ss:ID="Default" ss:Name="Normal">
   <Alignment ss:Vertical="Bottom"/>
   <Borders/>
   <Font ss:FontName="宋体" x:CharSet="134" ss:Size="11" ss:Color="#000000"/>
   <Interior/>
   <NumberFormat/>
   <Protection/>
  </Style>
  <Style ss:ID="m121970688">
   <Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
   <Borders>
    <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
   </Borders>
  </Style>
  <Style ss:ID="s17">
   <Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
   <Borders>
    <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
   </Borders>
  </Style>
 </Styles>
[#assign qh=""]
[#list EnumService.getEnum('xzqh') as enum]
[#if "${block.term.building_region!''}"=="${enum.enum_value!''}"][#assign qh="${enum.enum_name!''}"][/#if]
[/#list]
[#assign ctype=""]
[#if "${block.term.ctype!''}"=="jd"]
[#assign ctype="鉴定"]
[/#if]
[#if "${block.term.ctype!''}"=="pc"]
[#assign ctype="检查"]
[/#if]
[#assign num1=block.sjyt?size]
[#assign num2=block.fwjg?size]
[#assign num3=block.fwcb?size]
[#assign num=num1+num2+num3+4]
 <Worksheet ss:Name="Sheet1">
  <Table ss:ExpandedColumnCount="10" ss:ExpandedRowCount="${num}" x:FullColumns="1"
   x:FullRows="1" ss:DefaultColumnWidth="54" ss:DefaultRowHeight="13.5">
   <Column ss:AutoFitWidth="0" ss:Width="27.75"/>
   <Row ss:AutoFitHeight="0" ss:Height="20.0625">
    <Cell ss:MergeAcross="9" ss:StyleID="s17"><Data ss:Type="String">济南市${qh!''}${ctype!''}危房统计表</Data></Cell>
   </Row>
   <Row ss:AutoFitHeight="0" ss:Height="20.0625">
    <Cell ss:MergeAcross="1" ss:MergeDown="2" ss:StyleID="s17"><Data
      ss:Type="String">类别</Data></Cell>
    <Cell ss:MergeAcross="7" ss:StyleID="s17"><Data ss:Type="String">危险房屋</Data></Cell>
   </Row>
   <Row ss:AutoFitHeight="0" ss:Height="20.0625">
    <Cell ss:Index="3" ss:MergeAcross="1" ss:StyleID="s17"><Data ss:Type="String">有危险点</Data></Cell>
    <Cell ss:MergeAcross="1" ss:StyleID="s17"><Data ss:Type="String">局危</Data></Cell>
    <Cell ss:MergeAcross="1" ss:StyleID="s17"><Data ss:Type="String">全危</Data></Cell>
    <Cell ss:MergeAcross="1" ss:StyleID="s17"><Data ss:Type="String">小计</Data></Cell>
   </Row>
   <Row ss:AutoFitHeight="0" ss:Height="20.0625">
    <Cell ss:Index="3" ss:StyleID="s17"><Data ss:Type="String">幢</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">建筑面积</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">幢</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">建筑面积</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">幢</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">建筑面积</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">幢</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">建筑面积</Data></Cell>
   </Row>
   [#list block.sjyt as yt][#assign x1=block.sjyt?size][#assign x1=x1-1]
   [#if yt_index==0]
   <Row ss:AutoFitHeight="0" ss:Height="20.0625">
    <Cell ss:MergeDown="${x1}" ss:StyleID="m121970688"><Data ss:Type="String">按用途分</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">[#if (yt_index+1)==block.sjyt?size]合计[#else]${yt.ENUM_NAME!''}[/#if]</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.B1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.B2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.C1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.C2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.D1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.D2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.H1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.H2;m0M2}</Data></Cell>
   </Row>
   [#else]
   <Row ss:AutoFitHeight="0" ss:Height="20.0625">
    <Cell ss:Index="2" ss:StyleID="s17"><Data ss:Type="String">[#if (yt_index+1)==block.sjyt?size]合计[#else]${yt.ENUM_NAME!''}[/#if]</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.B1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.B2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.C1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.C2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.D1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.D2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.H1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.H2;m0M2}</Data></Cell>
   </Row>
   [/#if]
   [/#list]
   [#list block.fwjg as yt][#assign x1=block.fwjg?size][#assign x1=x1-1]
   [#if yt_index==0]
   <Row ss:AutoFitHeight="0" ss:Height="20.0625">
    <Cell ss:MergeDown="${x1}" ss:StyleID="m121970688"><Data ss:Type="String">按结构分</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">[#if (yt_index+1)==block.fwjg?size]合计[#else]${yt.ENUM_NAME!''}[/#if]</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.B1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.B2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.C1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.C2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.D1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.D2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.H1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.H2;m0M2}</Data></Cell>
   </Row>
   [#else]
   <Row ss:AutoFitHeight="0" ss:Height="20.0625">
    <Cell ss:Index="2" ss:StyleID="s17"><Data ss:Type="String">[#if (yt_index+1)==block.fwjg?size]合计[#else]${yt.ENUM_NAME!''}[/#if]</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.B1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.B2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.C1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.C2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.D1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.D2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.H1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.H2;m0M2}</Data></Cell>
   </Row>
   [/#if]
   [/#list]
   [#list block.fwcb as yt][#assign x1=block.fwcb?size][#assign x1=x1-1]
   [#if yt_index==0]
   <Row ss:AutoFitHeight="0" ss:Height="20.0625">
    <Cell ss:MergeDown="${x1}" ss:StyleID="m121970688"><Data ss:Type="String">按产别分</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">[#if (yt_index+1)==block.fwcb?size]合计[#else]${yt.ENUM_NAME!''}[/#if]</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.B1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.B2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.C1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.C2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.D1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.D2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.H1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.H2;m0M2}</Data></Cell>
   </Row>
   [#else]
   <Row ss:AutoFitHeight="0" ss:Height="20.0625">
    <Cell ss:Index="2" ss:StyleID="s17"><Data ss:Type="String">[#if (yt_index+1)==block.fwcb?size]合计[#else]${yt.ENUM_NAME!''}[/#if]</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.B1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.B2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.C1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.C2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.D1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.D2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">${yt.H1}</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">#{yt.H2;m0M2}</Data></Cell>
   </Row>
   [/#if]
   [/#list]
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <PageSetup>
    <Header x:Margin="0.3"/>
    <Footer x:Margin="0.3"/>
    <PageMargins x:Bottom="0.75" x:Left="0.7" x:Right="0.7" x:Top="0.75"/>
   </PageSetup>
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
     <ActiveRow>5</ActiveRow>
     <ActiveCol>1</ActiveCol>
    </Pane>
   </Panes>
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
</Workbook>
