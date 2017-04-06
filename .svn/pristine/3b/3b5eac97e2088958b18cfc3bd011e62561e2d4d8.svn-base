package com.originsys.safemanage.safecheck.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.EnumValue;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.service.EnumService;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuildingSurvey;
import com.yc.eap.util.UtilString;

/**
 auth:boy 2014-7-17
   描述：导入普查数据
   分区导，一个区一个区的导入，直接读取硬盘上的文件，不用上传了，因为只导入一次
   1：将xls另存成xlsx 这中格式的
   2：放到e盘的根目录下
   3：去掉不需导入的行，这里是指最后的非规则数据，例如合计等
   4：执行程序safecheck.survey.importdata
 */
public class ImportSurveyData extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		/**先把枚举放到map中，这样取的时候快点*/
		//地区枚举
		List<EnumValue> xzqhlist=EnumService.getInstance().getEnum("xzqh");
		Map<String,String> xzqh=new HashMap<String,String>();
		for(EnumValue enumvalue:xzqhlist){
			xzqh.put(enumvalue.getEnum_name(), enumvalue.getEnum_value());
		}
		String building_region=xzqh.get("市中区");//市中区
		//房屋用途枚举
		List<EnumValue> sjytlist=EnumService.getInstance().getEnum("sjyt");
		Map<String,String> sjyt=new HashMap<String,String>();
		for(EnumValue enumvalue:sjytlist){
			sjyt.put(enumvalue.getEnum_name(), enumvalue.getEnum_value());
		}
		sjyt.put("其它","1070");
		//管理现状枚举
		List<EnumValue> managetypelist=EnumService.getInstance().getEnum("managetype");
		Map<String,String> managetype=new HashMap<String,String>();
		for(EnumValue enumvalue:managetypelist){
			managetype.put(enumvalue.getEnum_name(), enumvalue.getEnum_value());
		}
		managetype.put("其它", "4");
		//结构类型枚举fwjg
		List<EnumValue> fwjglist=EnumService.getInstance().getEnum("fwjg");
		Map<String,String> fwjg=new HashMap<String,String>();
		for(EnumValue enumvalue:fwjglist){
			fwjg.put(enumvalue.getEnum_name(), enumvalue.getEnum_value());
		}
		fwjg.put("其它", "1309");
		fwjg.put("钢混", "1302");
		fwjg.put("砖混", "1311");
		fwjg.put("砖木", "1312");
		fwjg.put("钢", "1301");
		//房屋性质fwxzh
		List<EnumValue> fwxzhlist=EnumService.getInstance().getEnum("fwxzh");
		Map<String,String> fwxzh=new HashMap<String,String>();
		for(EnumValue enumvalue:fwxzhlist){
			fwxzh.put(enumvalue.getEnum_name(), enumvalue.getEnum_value());
		}
		fwxzh.put("单位自管住房","1");//追加写错的对应
		fwxzh.put("单位自管","1");//追加写错的对应
		
		String success = "0";
		
		File realfile=new File("e:/123.xlsx");
		String[][] result = getData(realfile, 5);
		int rowLength = result.length;	
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try {
			sc.startTransaction();
			for (int i = 0; i < rowLength; i++) {
				if("".equals(result[i][14])){
					/**没有图斑编号的，忽略，不导入*/
					
					continue;
				}
				TBuildingSurvey tBuildingSurvey=new TBuildingSurvey();
				String building_id=result[i][14];
				int n2=building_id.indexOf(".");
				if(n2!=-1)
					building_id=building_id.substring(0,n2);
				tBuildingSurvey.setBuilding_id(building_id);//Integer:楼幢编号-图斑编号
				tBuildingSurvey.setBuilding_holder(result[i][2]);//房屋所有人（管理单位）
				tBuildingSurvey.setInfo_state("0");//String:暂存 0   未审核1    审核驳回2     审核通过8 
				tBuildingSurvey.setBuilding_address(result[i][3]);//String:楼幢坐落
				tBuildingSurvey.setBuilding_region(building_region);//String:所属区域
				//房屋性质
				String qsh=result[i][4];
				if(qsh!=null&&!"".equals(qsh))
					qsh=fwxzh.get(qsh);
				if(qsh==null)qsh="";
				tBuildingSurvey.setBuilding_properties(qsh);
				//String:设计用途
				String yt=result[i][7];
				if(yt!=null&&!"".equals(yt))
					yt=sjyt.get(yt);
				if(yt==null)yt="";
				tBuildingSurvey.setUse_desgin(yt);
				String jg=result[i][5];
				if(jg!=null&&!"".equals(jg))
					jg=fwjg.get(jg);
				if(jg==null)jg="";
				tBuildingSurvey.setBuild_struct(jg);//String:结构类型
				tBuildingSurvey.setBuilding_newaddress(result[i][3]);//普查新地址
				//房屋安全情况
				String d4=result[i][10];//有安全隐患
				String d1=result[i][11];//没有安全隐患
				String safe=d4;
				if(safe==null||"".equals(safe))
					safe=d1;
				if(safe==null)safe="";
				if("是".equals(safe))safe="4";else safe="1";
				tBuildingSurvey.setBuilding_safecondition(safe);
				//房屋安全情况
				String jd4=result[i][12];//有安全隐患
				String jd1=result[i][13];//没有安全隐患
				String jdsafe=jd4;
				if(jdsafe==null||"".equals(jdsafe))
					jdsafe=jd1;
				if(jdsafe==null)jdsafe="";
				if("是".equals(jdsafe))jdsafe="1";else jdsafe="0";
				tBuildingSurvey.setIsauth(jdsafe);
				//Integer:户数
				String house_count=result[i][8];
				int n1=house_count.indexOf(".");
				if(n1!=-1)
					house_count=house_count.substring(0, n1);
				if(house_count!=null && !"".equals(house_count)){
					tBuildingSurvey.setHouse_count(Integer.parseInt(house_count));
				}
				//Float:建筑面积
				String area=result[i][9];
				if(area!=null && !"".equals(area)){
					tBuildingSurvey.setBuild_area(Float.parseFloat(area));
				}
				//地上层数和地下层数
				String up_count="";
				String down_count="";
				String lay1=result[i][6];
//				System.out.println("===============lay1="+lay1);
				if(lay1!=null&&!"".equals(lay1)){
					String[] lays=UtilString.split(lay1, "/");
					if(lays.length==2){
						up_count=lays[0];
						down_count=lays[1];
					}
					if(lays.length==1){
						up_count=lays[0];
					}
				}
				int n3=up_count.indexOf(".");
				if(n3!=-1)
					up_count=up_count.substring(0, n3);
				int n4=up_count.indexOf(".");
				if(n4!=-1)
					down_count=down_count.substring(0, n4);
//				System.out.println("==========up_count="+up_count+"========down_count="+down_count);
				int upnum=0;
				int downnum=0;
				try{
					upnum=Integer.parseInt(up_count);
				}catch(Exception e){
					upnum=0;
				}
				try{
					downnum=Integer.parseInt(down_count);
				}catch(Exception e){
					downnum=0;
				}
				tBuildingSurvey.setFloorup_count(upnum);//Integer:地上层数
				tBuildingSurvey.setFloordown_count(downnum);//Integer:地下层数
				
				sc.insert("Safecheck.addTBuildingSurvey", tBuildingSurvey);
			}
			sc.commitTransaction();
			success="1";
		}catch (Exception e) {
			throw e;
		}finally{
			sc.endTransaction();
		}
		
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\"}");
	}

	//读取数据
		public  String[][] getData(File file, int ignoreRows)
				throws Exception {
			List<String[]> result = new ArrayList<String[]>();
			int rowSize = 0;
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(
					file));
			Workbook wb = null;
			String fileName = file.getName();
			String hz = fileName.substring(fileName.lastIndexOf("."),
					fileName.length());

			if (hz.equals(".xls"))// 针对2003版本
			{
				wb = (Workbook) new HSSFWorkbook(new POIFSFileSystem(in));
			} else { // 针对2007版本
				wb = new XSSFWorkbook(in);
			}
			Cell cell = null;
			for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
				Sheet st = wb.getSheetAt(sheetIndex);
				// 第一行为标题，不取
				for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {
					Row row = st.getRow(rowIndex);
					if (row == null) {
						continue;
					}
					int tempRowSize = row.getLastCellNum() + 1;
					if (tempRowSize > rowSize) {
						rowSize = tempRowSize;
					}
					String[] values = new String[rowSize];
					Arrays.fill(values, "");
					boolean hasValue = false;
					for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
						String value = "";
						cell = row.getCell(columnIndex);
						if (cell != null) {
							// 注意：一定要设成这个，否则可能会出现乱码
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_FORMULA:
								value = cell.getCellFormula();
								break;
							case Cell.CELL_TYPE_STRING:
								value = cell.getStringCellValue();
								break;
							case Cell.CELL_TYPE_NUMERIC:
								value = cell.getNumericCellValue() + "";
								break;
							default:
								value = "";
							}
						}

						if (columnIndex == 0 && value.trim().equals("")) {
							break;
						}
						values[columnIndex] = rightTrim(value);
						hasValue = true;
					}
					if (hasValue) {
						result.add(values);
					}

				}

			}
			in.close();
			String[][] returnArray = new String[result.size()][rowSize];
			for (int i = 0; i < returnArray.length; i++) {
				returnArray[i] = (String[]) result.get(i);
			}
			return returnArray;

		}
		
		public static String rightTrim(String str) {
			if (str == null) {
				return "";
			}
			int length = str.length();
			for (int i = length - 1; i >= 0; i--) {
				if (str.charAt(i) != 0x20) {
					break;
				}
				length--;
			}
			return str.substring(0, length);

		}
		
		public static void main(String[] args){
//			//地上层数和地下层数
//			String up_count="";
//			String down_count="";
//			String lay1="5";
//			if(lay1!=null&&!"".equals(lay1)){
//				String[] lays=UtilString.split(lay1, "/");
//				if(lays.length==2){
//					up_count=lays[0];
//					down_count=lays[1];
//				}
//				if(lays.length==1){
//					up_count=lays[0];
//				}
//			}
//			int upnum=0;
//			int downnum=0;
//			try{
//				upnum=Integer.parseInt(up_count);
//			}catch(Exception e){
//				upnum=0;
//			}
//			try{
//				downnum=Integer.parseInt(down_count);
//			}catch(Exception e){
//				downnum=0;
//			}
//			System.out.println("=============upnum="+upnum);
//			System.out.println("=============downnum="+downnum);
//			String wq_type="4$";
//			if(wq_type!=null&&!"".equals(wq_type)){
//				wq_type=wq_type.substring(0, wq_type.indexOf("$"));
//			}else
//				wq_type="";
//			System.out.println("wq_type="+wq_type);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy/MM/dd");
			String x="2012/2/29";
			try {
				String x2=sdf.format(sdf1.parse(x));
				
				System.out.println(x2);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
}
