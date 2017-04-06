<?xml version="1.0"?>
<?mso-application progid="Excel.Sheet"?>
<Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:o="urn:schemas-microsoft-com:office:office"
 xmlns:x="urn:schemas-microsoft-com:office:excel"
 xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:html="http://www.w3.org/TR/REC-html40">
 <DocumentProperties xmlns="urn:schemas-microsoft-com:office:office">
  <Created>2006-09-16T00:00:00Z</Created>
  <LastSaved>2014-06-19T03:55:40Z</LastSaved>
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
  <Style ss:ID="m44781280">
   <Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
   <Borders>
    <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
   </Borders>
  </Style>
  <Style ss:ID="m44781400">
   <Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
   <Borders>
    <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
   </Borders>
  </Style>
  <Style ss:ID="s73">
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
[#if "${block.term.region_id!''}"=="${enum.enum_value!''}"][#assign qh="${enum.enum_name!''}"][/#if]
[/#list]
[#assign num=3]
[#if block.resultlist?exists]
[#assign num=4+block.resultlist?size]
[/#if]
[#assign fenlei="分类"]
		[#if "${block.term.col_name!''}"=="sjyt#use_desgin"][#assign fenlei="设计用途"][/#if]
		[#if "${block.term.col_name!''}"=="fwjg#build_struct"][#assign fenlei="结构类型"][/#if]
		[#if "${block.term.col_name!''}"=="upon_type#upon_type"][#assign fenlei="楼盖类型"][/#if]
		[#if "${block.term.col_name!''}"=="wm_type#wm_type"][#assign fenlei="屋面类型"][/#if]
		[#if "${block.term.col_name!''}"=="fwxzh#building_properties"][#assign fenlei="房屋性质"][/#if]
		[#if "${block.term.col_name!''}"=="managetype#manage_type"][#assign fenlei="管理模式"][/#if]
		[#if "${block.term.col_name!''}"=="build_dept"][#assign fenlei="建设单位"][/#if]
		[#if "${block.term.col_name!''}"=="design_dept"][#assign fenlei="设计单位"][/#if]
		[#if "${block.term.col_name!''}"=="construct_dept"][#assign fenlei="施工单位"][/#if]
		[#if "${block.term.col_name!''}"=="building_date"][#assign fenlei="建设年份"][/#if]
 <Worksheet ss:Name="Sheet1">
  <Table ss:ExpandedColumnCount="11" ss:ExpandedRowCount="${num}" x:FullColumns="1"
   x:FullRows="1" ss:DefaultColumnWidth="54" ss:DefaultRowHeight="13.5">
   <Column ss:AutoFitWidth="0" ss:Width="126.75"/>
   <Row ss:AutoFitHeight="0" ss:Height="20.0625">
    <Cell ss:MergeAcross="6" ss:StyleID="m44781280"><Data ss:Type="String">2014年济南市老楼危楼安全排查统计表[#if "${qh!''}"==""][#else](${qh!''})[/#if]</Data></Cell>
   </Row>
   <Row ss:AutoFitHeight="0" ss:Height="20.0625">
    <Cell ss:MergeDown="1" ss:StyleID="m44781400"><Data ss:Type="String">${fenlei!''}</Data></Cell>
    <Cell ss:MergeAcross="1" ss:StyleID="s73"><Data ss:Type="String">无问题房屋</Data></Cell>
    <Cell ss:MergeAcross="1" ss:StyleID="s73"><Data ss:Type="String">有问题房屋</Data></Cell>
    <Cell ss:MergeAcross="1" ss:StyleID="s73"><Data ss:Type="String">小计</Data></Cell>
   </Row>
   <Row ss:AutoFitHeight="0" ss:Height="20.0625">
    <Cell ss:Index="2" ss:StyleID="s73"><Data ss:Type="String">幢</Data></Cell>
    <Cell ss:StyleID="s73"><Data ss:Type="String">建筑面积</Data></Cell>
    <Cell ss:StyleID="s73"><Data ss:Type="String">幢</Data></Cell>
    <Cell ss:StyleID="s73"><Data ss:Type="String">建筑面积</Data></Cell>
    <Cell ss:StyleID="s73"><Data ss:Type="String">幢</Data></Cell>
    <Cell ss:StyleID="s73"><Data ss:Type="String">建筑面积</Data></Cell>
   </Row>
   [#if block.resultlist?exists]
   [#list block.resultlist as result]
   <Row ss:AutoFitHeight="0" ss:Height="20.0625">
    <Cell ss:StyleID="s73"><Data ss:Type="String">${result.ENUM_NAME!''}</Data></Cell>
    <Cell ss:StyleID="s73"><Data ss:Type="Number">${result.A1}</Data></Cell>
    <Cell ss:StyleID="s73"><Data ss:Type="Number">#{result.A2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s73"><Data ss:Type="Number">${result.D1}</Data></Cell>
    <Cell ss:StyleID="s73"><Data ss:Type="Number">#{result.D2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s73"><Data ss:Type="Number">${result.H1}</Data></Cell>
    <Cell ss:StyleID="s73"><Data ss:Type="Number">#{result.H2;m0M2}</Data></Cell>
   </Row>
   [/#list]
   <Row ss:AutoFitHeight="0" ss:Height="20.0625">
    <Cell ss:StyleID="s73"><Data ss:Type="String">合计</Data></Cell>
    <Cell ss:StyleID="s73"><Data ss:Type="Number">${block.hj.A1}</Data></Cell>
    <Cell ss:StyleID="s73"><Data ss:Type="Number">#{block.hj.A2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s73"><Data ss:Type="Number">${block.hj.D1}</Data></Cell>
    <Cell ss:StyleID="s73"><Data ss:Type="Number">#{block.hj.D2;m0M2}</Data></Cell>
    <Cell ss:StyleID="s73"><Data ss:Type="Number">${block.hj.H1}</Data></Cell>
    <Cell ss:StyleID="s73"><Data ss:Type="Number">#{block.hj.H2;m0M2}</Data></Cell>
   </Row>   
   [/#if]
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
     <ActiveRow>4</ActiveRow>
     <ActiveCol>1</ActiveCol>
    </Pane>
   </Panes>
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
</Workbook>
