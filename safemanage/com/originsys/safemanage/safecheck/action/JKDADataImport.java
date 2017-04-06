package com.originsys.safemanage.safecheck.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.FilePath;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuilding;
import com.originsys.safemanage.domain.TBuildingSafe;
import com.originsys.safemanage.domain.TInvmBase;
import com.originsys.safemanage.domain.TInvmField;

/**
 auth:boy 2014-8-5
   描述：健康档案数据导入
   1:修改t_building表中的数据
   2:增加t_building_safe表中的数据
   3:增加地基基础T_INVM_BASE表中的数据
   4：增加现场调查场地环境T_INVM_FIELD表中的数据
   5：调用接口增加到大数据中
   6：调用接口写入到空间库中
   增加数据的同时，审核通过就可以了
 */
public class JKDADataImport extends BaseAction implements IData{
	static final HashMap<String,String> map
	=new HashMap<String,String>(){
		{
			put("1", "086370102");
			put("2", "086370103");
			put("3", "086370104");
			put("4", "086370105");
			put("5", "086370112");
			put("6", "086370114");
		}
	};
	public void execute(RequestAction arg0, HttpServletResponse response)
			throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy/MM/dd");
		String success = "0";
		
		File realfile=new File("e:/jkda.xlsx");
		String[][] result = getData(realfile, 2);
		int rowLength = result.length;	
		SqlMapClient sc=DataSource.getSqlMapInstance();
		String info_id="";
		String building_id="";
		String region="";
		try {
//			sc.startTransaction();
			/**调用api获取数据*/
			HttpClient client = new HttpClient();
			/**设置api的地址*/
			String hbase_url="http://192.168.0.9:8080/";
			PostMethod post0 = new PostMethod(hbase_url+"/portal/datacenter.buildingsafeapi");
			/**设置编码格式*/
			post0.getParams().setContentCharset("utf-8");
			NameValuePair  op= new NameValuePair("op", "12年简易楼普查");
			NameValuePair  opdate= new NameValuePair("opdate", "2012-02-09");
			NameValuePair  optype= new NameValuePair("optype", "整栋");
			NameValuePair  annex_image1= new NameValuePair("annex_image", "");
			NameValuePair  annex_file1= new NameValuePair("annex_file", "");
//			/**调用12的接口写入到空间库中*/
//			PostMethod post1 = new PostMethod(hbase_url+"/portal/realtygis.updatesafedate");
//			/**设置编码格式*/
//			post1.getParams().setContentCharset("utf-8");
			
			
			for (int i = 0; i < rowLength; i++) {
				info_id=result[i][3];
				building_id=result[i][0];
				region=map.get(result[i][4]);
				String wq_type=result[i][26];//4$6$
				if(wq_type!=null&&!"".equals(wq_type)){
					wq_type=wq_type.substring(0, wq_type.indexOf("$"));
				}else
					wq_type="";
//				/**楼幢基本信息*/
//				TBuilding tBuilding=new TBuilding();
//				tBuilding.setBuilding_id(building_id);//Integer:楼幢编号图斑编号sm_id
//				tBuilding.setBuilding_address(result[i][1]);//String:楼幢坐落
//				tBuilding.setCheck_address(result[i][8]);//检查地址
//				if(result[i][8].equals(result[i][1]))
//					tBuilding.setIs_same("1");
//				else
//					tBuilding.setIs_same("0");
//				tBuilding.setBuiliding_region(region);//String:所属区域
//				int floor_count=0;
//				
//				if(result[i][28]!=null && !"".equals(result[i][28])){
//					tBuilding.setHouse_count(Integer.parseInt(result[i][28]));//Integer:户数
//				}
//				if(result[i][10]!=null && !"".equals(result[i][10])){
//					floor_count=Integer.parseInt(result[i][10]);
//					tBuilding.setFloorup_count(Integer.parseInt(result[i][10]));//Integer:地上层数
//				}
//				if(result[i][11]!=null && !"".equals(result[i][11])){
//					floor_count=floor_count+Integer.parseInt(result[i][11]);
//					tBuilding.setFloordown_count(Integer.parseInt(result[i][11]));//Integer:地下层数
//				}
//				tBuilding.setFloor_count(floor_count);//Integer:层数
////				tBuilding.setReal_type(ra.getParameter("real_type"));//String:房屋产别
////				tBuilding.setUse_desgin(ra.getParameter("use_desgin"));//String:设计用途
//				if(result[i][13]!=null && !"".equals(result[i][13])){
//					tBuilding.setBuilding_date(Integer.parseInt(result[i][13]));//Integer:建成时间
//				}
////				tBuilding.setBuild_struct(ra.getParameter("build_struct"));//String:房屋与结构
//				tBuilding.setBuilding_mapid(Integer.parseInt(building_id));//Integer:所在楼盘内码初始化进来
//				tBuilding.setDangerous_type_pc("1");//String:危房类型-普查 整栋危楼1 局部危楼2
////				tBuilding.setHealth_grade_jd(ra.getParameter("health_grade_jd"));//String:健康等级-鉴定@1-a级&2-b级&3-c级&4-d级
////				tBuilding.setDangerous_type_jd(ra.getParameter("dangerous_type_jd"));//String:危房类型-鉴定 整栋危楼1 局部危楼2
//				tBuilding.setIs_die("1");
//				tBuilding.setBuilding_mapid(Integer.parseInt(building_id));//String:地图定位内码
////				tBuilding.setFw_type(ra.getParameter("fw_type"));//String:房屋类别1个人 2公共建筑 3保障住房
//				tBuilding.setUsefunction(result[i][12]);//String:使用功能@1-住宅&2-综合楼&3-办公&4-商业&5-学校用房&6-医院用房&7-工业用房&8-其它
//				tBuilding.setBase_type(result[i][19]);//String:基础类型@1-毛石&2-砖&3-混凝土&4-钢筋混凝土&5-其它
//				tBuilding.setUpon_type(result[i][20]);//String:楼盖类型@1-现浇板&2-预制板&3-现浇、预制板混用&4-木楼板&5-其它
//				tBuilding.setWm_type(result[i][22]);//String:屋面类型@1-预制板平屋面&2-现浇板平屋面&3-现浇板坡屋面&4-有檩系坡屋面&5-其它
//				tBuilding.setWairang_type(result[i][32]);//String:外廊类型@1-未设置&2-梁式&3-板式&4-落地
//				tBuilding.setLt_number(result[i][23]);//String:楼梯数目@1-一个&2-二个&3-三个&4-多个
//				tBuilding.setLt_type("2");//String:楼梯类型@1-木&2-混凝土&3-钢&4-其它
////				tBuilding.setDt_number(ra.getParameter("dt_number"));//String:电梯数目@1-一个&2-二个&3-三个&4-多个
//				tBuilding.setWq_type(wq_type);//String:外墙饰面@1-玻璃&2-石材&3-面砖&4-马赛克&5-砂浆&6-涂料&7-清水墙&8-其它
//				
//				tBuilding.setBuild_right(result[i][5]);//产权年限@1-50年&2-70年&3-其它
//				tBuilding.setRight_type(result[i][6]);//产权性质@1-直管公房&2-自管房&3-私房&4-其它
//				tBuilding.setOwner(result[i][7]);//产权单位
//				if(result[i][14]!=null && !"".equals(result[i][14])){
//					tBuilding.setHeigth(Float.parseFloat(result[i][14]));//高度m
//				}
//				if(result[i][15]!=null && !"".equals(result[i][15])){
//					tBuilding.setDepth(Float.parseFloat(result[i][15]));//檐高m
//				}
//				tBuilding.setPlane_shape(result[i][16]);//平面@1-规则&2-不规则
//				tBuilding.setExposure(result[i][17]);//朝向@1-东西&2-南北&3-其它
//				tBuilding.setLm_shape(result[i][18]);//立面@1-规则&2-不规则
//				tBuilding.setManagement_unit(result[i][27]);//经营管理单位
////				if(ra.getParameter("floor_height")!=null && !"".equals(ra.getParameter("floor_height"))){
////					tBuilding.setFloor_height(Float.parseFloat(ra.getParameter("floor_height")));//层高
////				}
//				tBuilding.setFrozen_area(result[i][33]);//是否冻结片区@1-是&2-否
//				tBuilding.setYt_type(result[i][25]);//String:阳台类型@1-未设置&2-梁式&3-板式&4-落地
				String grade_pc=result[i][41];
				if(grade_pc==null||"".equals(grade_pc)||"0".equals(grade_pc))
					grade_pc="1";
//				tBuilding.setHealth_grade_pc(grade_pc);
//				tBuilding.setDangerous_type_pc("1");
//				if(result[i][9]!=null && !"".equals(result[i][9])){
//					tBuilding.setBuild_area(Float.parseFloat(result[i][9]));//Float:建筑面积
//				}
//				/**楼幢普查结果信息*/
//				TBuildingSafe tBuildingSafe=new TBuildingSafe();
//				tBuildingSafe.setInfo_id(info_id);
//				tBuildingSafe.setBuilding_id(building_id);//Integer:楼幢编号-图斑编号
//				tBuildingSafe.setDt_tdesc("");//String:电梯、楼梯备注
//				tBuildingSafe.setStruct_desc(result[i][29]);//String:装饰装修备注
//				tBuildingSafe.setBz_desc(result[i][30]);//String:基本信息备注
//				tBuildingSafe.setDere_desc(result[i][31]);//String:上下部结构形式备注
//				
////				if(result[i][45]!=null && !"".equals(result[i][45])){
////					try{
//						Date check_time=sdf.parse("2012-02-09");
//						tBuildingSafe.setCheck_time(check_time);//Date:检查时间
////					}catch(Exception e){
////						e.printStackTrace();
////					}
////				}
//				tBuildingSafe.setCheck_user(result[i][44]);//String:检查人姓名可能多个
//				tBuildingSafe.setCheck_userid("test@test.com");//String:信息填写人
//				tBuildingSafe.setInfo_state("8");//String:暂存 0   未审核1    审核驳回2     审核通过8
//				tBuildingSafe.setStructure_grade(result[i][34]);//String:健康结构健康等级@1-a级&2-b级&3-c级&4-d级
//				tBuildingSafe.setUsed_grade(result[i][35]);//String:健康使用健康等级@1-a级&2-b级&3-c级&4-d级
//				tBuildingSafe.setKz_grade(result[i][36]);//String:健康抗震能力@1-强&2-弱&3-差
//				tBuildingSafe.setFl_grade(result[i][37]);//String:健康防雷能力@1-强&2-弱&3-差
//				tBuildingSafe.setXf_grade(result[i][38]);//String:健康消防能力@1-强&2-弱&3-差
//				tBuildingSafe.setOther_grade(result[i][39]);//String:健康其他防灾能力@1-强&2-弱&3-差
//				tBuildingSafe.setAll_grade(result[i][40]);//String:健康总健康等级@1-ⅰ级（健康）&2-ⅱ级（亚健康）&3-ⅲ级（病态）&4-ⅳ（病危）
//				tBuildingSafe.setHealth_savegrade(grade_pc);//String:健康安全等级@1-a级&2-b级&3-c级&4-d级
//				tBuildingSafe.setClresult(result[i][42]);//String:健康处理意见@1-正常使用&2-常规维护&3-适当维修&4-采取措施&5-停止使用
//				tBuildingSafe.setHealth_gradetdesc(result[i][43]);//String:健康备注
//				tBuildingSafe.setLose_grade(result[i][46]);//String:健康完损等级@1-完好房屋&2-基本完好&3-一般破损&4-严重破损
//				tBuildingSafe.setCheck_type("2");//String:检查类型@1普查2检查
//				tBuildingSafe.setUsefunction(result[i][12]);//String:使用功能@1-住宅&2-综合楼&3-办公&4-商业&5-学校用房&6-医院用房&7-工业用房&8-其它
//				tBuildingSafe.setWq_type(wq_type);//String:外墙饰面@1-玻璃&2-石材&3-面砖&4-马赛克&5-砂浆&6-涂料&7-清水墙&8-其它
//				tBuildingSafe.setAdd_date(sdf.parse(sdf.format(new Date())));//Date:新增时间
//				if(result[i][9]!=null && !"".equals(result[i][9])){
//					tBuildingSafe.setBuild_area(Float.parseFloat(result[i][9]));//Float:建筑面积
//				}
//				tBuildingSafe.setVerify_time(new java.util.Date());
//				tBuildingSafe.setVerify_comment("");
//				tBuildingSafe.setVerify_userid("d50b72a09d724434a2d710a7e11970b6");
//				tBuildingSafe.setBuilding_region(region);
//				
//				/**地基基础*/
//				TInvmBase tInvmBase=new TInvmBase();
//				tInvmBase.setInfo_id(info_id);
//				tInvmBase.setBuilding_id(building_id);//Integer:楼幢编号-图斑编号
//				tInvmBase.setBenormal(result[i][47]);//String:地基无异常@1-否&2-是
//				tInvmBase.setSedi_crack(result[i][48]);//String:地基沉降裂缝@1-否&2-轻微&3-一般&4-严重
//				tInvmBase.setObv_incline(result[i][49]);//String:地基明显倾斜@1-否&2-是
//				tInvmBase.setLow_water(result[i][50]);//String:地基低洼积水@1-否&2-是
//				tInvmBase.setElseitem(result[i][51]);//String:地基其他@1-否&2-轻微&3-一般&4-严重
//				tInvmBase.setB_grading(result[i][52]);//String:地基子项健康评级@1-a级&2-b级&3-c级&4-d级
////				tInvmBase.setB_secritygrading(result[i][53]);//String:地基子项安全评级@1-a级&2-b级&3-c级&4-d级
////				tInvmBase.setB_tdesc(result[i][54]);//String:地基备注
////				tInvmBase.setB_peotected_grage(result[i][55]);//String:地基子项完损等级评级@1-完好&2-基本完好&3-一般损坏&4-严重损坏
//				
//				/**现场调查场地环境*/
//				TInvmField tInvmField=new TInvmField();
//				tInvmField.setInfo_id(info_id);
//				tInvmField.setBuilding_id(building_id);//Integer:楼幢编号
//				tInvmField.setField_flat("2");
//				tInvmField.setField_earthtype("2");
//				tInvmField.setNeighbor_normal("2");
//				tInvmField.setChemic_normal("2");
//				
//				sc.update("Safecheck.updateTBuilding",tBuilding);
//				sc.insert("Safecheck.addTBuildingSafe",tBuildingSafe);
//				sc.insert("Safecheck.addTInvmBase",tInvmBase);
//				sc.insert("Safecheck.addTInvmField",tInvmField);
				
				/**写到大数据和空间表中*/
				
				/**组织传入的参数*/
				NameValuePair  bid= new NameValuePair("building_id", building_id);
				NameValuePair  opresult= new NameValuePair("opresult", grade_pc);
				NameValuePair [] pair = new NameValuePair[]{bid,op,opdate,opresult,optype,annex_image1,annex_file1};
				post0.setRequestBody(pair);
				int status = client.executeMethod(post0);
				post0.releaseConnection();
//				/**组织传入的参数*/
//				NameValuePair  checkgrade= new NameValuePair("checkgrade", grade_pc);//安全检查等级
//				NameValuePair  checkstate= new NameValuePair("checkstate2", "1");//检查的状态，是否检查
//				NameValuePair [] pair1 = new NameValuePair[]{bid,checkstate,checkgrade};
//				post1.setRequestBody(pair1);
//				int status1 = client.executeMethod(post1);
//				post1.releaseConnection();
			}
			success="1";
//			sc.commitTransaction();
		}catch(Exception e){
			throw e;
		}finally{
//			sc.endTransaction();
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
								if(value.endsWith(".0"))
									value = value.replace(".0", "");
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

}
