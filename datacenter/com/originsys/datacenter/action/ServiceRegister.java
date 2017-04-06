package com.originsys.datacenter.action;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.datacenter.domain.YcDatacenterServiceParams;
import com.originsys.datacenter.domain.YcDatacenterServiceRegister;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;

/**
 auth:boy 2014-3-7
   描述：服务注册
 */
public class ServiceRegister extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		YcDatacenterServiceRegister ycDatacenterServiceRegister=new YcDatacenterServiceRegister();				
		String key=UUIDshort.get();
		ycDatacenterServiceRegister.setService_id(key);//String:服务编号
		ycDatacenterServiceRegister.setService_name(ra.getParameter("service_name"));//String:服务名称
		ycDatacenterServiceRegister.setService_desc(ra.getParameter("service_desc"));//String:服务描述
		ycDatacenterServiceRegister.setService_provide(ra.getParameter("service_provide"));//String:服务提供者
		ycDatacenterServiceRegister.setIs_check(ra.getParameter("is_check"));//String:是否审核
		ycDatacenterServiceRegister.setService_version(ra.getParameter("service_version"));//String:版本
		ycDatacenterServiceRegister.setProxy_type(ra.getParameter("proxy_type"));//String:代理服务类型
		ycDatacenterServiceRegister.setService_type(ra.getParameter("service_type"));//String:服务类型
		if("1".equals(ra.getParameter("op_type")))
			ycDatacenterServiceRegister.setService_state("7");//String:服务状态,暂存
		else
			ycDatacenterServiceRegister.setService_state("0");//提交，待审核
		ycDatacenterServiceRegister.setCreate_date(new Date());//Date:服务创建时间
		ycDatacenterServiceRegister.setCreator(ra.getUser().getMem_id());//String:服务创建人
		ycDatacenterServiceRegister.setRequest_url(ra.getParameter("request_url"));//String:请求地址
		ycDatacenterServiceRegister.setExample_image(ra.getParameter("example_image"));//String:返回示例图片
		ycDatacenterServiceRegister.setIs_authorize(ra.getParameter("is_authorize"));//String:是否需要用户授权
		ycDatacenterServiceRegister.setAuthorize_mode(ra.getParameter("authorize_mode"));//String:服务申请授权方式
		String success="0";
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try{
			sc.startTransaction();
			sc.insert("datacenter.addYcDatacenterServiceRegister",ycDatacenterServiceRegister);
			String param_code[]=ra.getParameterValues("param_code");
			String param_desc[]=ra.getParameterValues("param_desc");
			String param_type[]=ra.getParameterValues("param_type");
			String required[]=ra.getParameterValues("is_required");
			String filed_type[]=ra.getParameterValues("field_type");
			if(param_code!=null){
				for(int i=0;i<param_type.length;i++){
					/**获取参数列表*/
					YcDatacenterServiceParams ycDatacenterServiceParams =new YcDatacenterServiceParams();
					String key1=UUIDshort.get();
					ycDatacenterServiceParams.setParam_id(key1);//String:参数id
					ycDatacenterServiceParams.setService_id(key);//String:服务id
					ycDatacenterServiceParams.setParam_code(param_code[i]);//String:参数名称
					ycDatacenterServiceParams.setParam_desc(param_desc[i]);//String:参数描述
					ycDatacenterServiceParams.setParam_type(param_type[i]);//String:参数类型
					/**入参设置是否必须，字段类型*/
					if("0".equals(param_type[i])){
						ycDatacenterServiceParams.setIs_required(required[i]);//String:是否必须
						ycDatacenterServiceParams.setField_type(filed_type[i]);//String:字段类型
					}
					sc.insert("datacenter.addYcDatacenterServiceParams",ycDatacenterServiceParams);
				}
			}
			sc.commitTransaction();
			success="1";
		}catch (Exception e) {
			success="0";
			throw e;
		}finally{
			sc.getCurrentConnection().rollback();
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\",\"key\":\""+key+"\"}");
	}

}
