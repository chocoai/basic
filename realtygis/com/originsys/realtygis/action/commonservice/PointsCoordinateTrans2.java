package  com.originsys.realtygis.action.commonservice;

import com.supermap.data.CoordSysTransMethod;
import com.supermap.data.CoordSysTransParameter;
import com.supermap.data.CoordSysTranslator;
import com.supermap.data.GeoCoordSys;
import com.supermap.data.GeoCoordSysType;
import com.supermap.data.GeoSpatialRefType;
import com.supermap.data.Point2D;
import com.supermap.data.Point2Ds;
import com.supermap.data.PrjCoordSys;
import com.supermap.data.PrjCoordSysType;
import com.supermap.data.PrjParameter;
import com.supermap.data.Projection;
import com.supermap.data.ProjectionType;
import com.supermap.data.Unit;
import java.io.PrintWriter;


import javax.servlet.http.HttpServletResponse;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.RequestAction;


public class PointsCoordinateTrans2 extends BaseAction implements IData{

	private static final long serialVersionUID = 1L;

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		Point2D point2d=null;
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		double x=0.0;
		double y=0.0;
		try{		
		if(null!=ra.getParameter("x")&&!"".equals(ra.getParameter("x")))
		 x=Double.parseDouble(ra.getParameter("x").toString());
		if(null!=ra.getParameter("y")&&!"".equals(ra.getParameter("y")))
		 y=Double.parseDouble(ra.getParameter("y").toString());
		//局部单线程
	synchronized (out) {	
		//out.println("开始本地转换。。");
		point2d= new Point2D(x,y);			
		// 经纬度投影
		PrjCoordSys prjCoordSysDes = new PrjCoordSys();
		prjCoordSysDes.setCoordUnit(Unit.DEGREE);
		GeoCoordSys geoCoordSys = new GeoCoordSys();
		geoCoordSys.setType(GeoCoordSysType.GCS_WGS_1984);
		geoCoordSys.setCoordUnit(Unit.DEGREE);
		geoCoordSys.setGeoSpatialRefType(GeoSpatialRefType.SPATIALREF_EARTH_LONGITUDE_LATITUDE);
		prjCoordSysDes.setGeoCoordSys(geoCoordSys);
		prjCoordSysDes.setType(PrjCoordSysType.PCS_EARTH_LONGITUDE_LATITUDE);	
		
		Point2Ds point2Ds = new Point2Ds();
		point2Ds.add(point2d);
		System.out.println(point2Ds.getItem(0).toString());
		
		// 投影坐标系
		PrjCoordSys PrjCoordSys = new PrjCoordSys(
				PrjCoordSysType.PCS_USER_DEFINED); // 用户自定义坐标系。
		Projection projection = new Projection(ProjectionType.PRJ_GAUSS_KRUGER); // 高斯-克吕格（Gauss-Kruger）投影
		PrjCoordSys.setProjection(projection);
		PrjParameter parameter = new PrjParameter();
		parameter.setCentralMeridian(117.00000);	
		parameter.setFalseEasting(500000.00000);
		parameter.setFalseNorthing(0.00000);
		parameter.setScaleFactor(1.00000);		
		PrjCoordSys.setPrjParameter(parameter);
		
		CoordSysTransParameter coordSysTransParameter = new CoordSysTransParameter();
        //convert投影转换方法		
		boolean bTrans = CoordSysTranslator.convert(point2Ds,
		PrjCoordSys, prjCoordSysDes, coordSysTransParameter,
		CoordSysTransMethod.MTH_GEOCENTRIC_TRANSLATION);		
	    if (bTrans) {
		out.print(point2Ds.getItem(0).toString());		
		}
		else {			
		   out.print("投影转换失败");
		}
	}
	 }catch(NumberFormatException e){
		// throw new  NumberFormatException(e.getMessage());
		 out.print(e.getMessage());
	     out.print("经纬度坐标无法转换为数值型！");
	 }catch(NullPointerException e){
		 out.print(e.getMessage());
	     out.print("请检查参数是否完整！");
	 }catch(IllegalArgumentException e){
		 out.print(e.getMessage());
	 }finally{
		 out.close();
	 }
		
}
}
