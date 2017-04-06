package com.originsys.auth.action;

import com.ibatis.common.jdbc.exception.NestedSQLException;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.util.CacheUtil;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.auth.Service.OrgComService;
import com.originsys.auth.domain.Orgcom;
import com.originsys.auth.domain.OrgcomtypeOrgcom;
import com.originsys.eap.iservice.IData;

import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.Element;
import java.io.PrintWriter;

/**
 * @author Email:
 * @version 1.0 创建时间： 类说明： 列表页
 */
public class OrgcomUpdate extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		// 获取值
		String organ_id = ra.getParameter("organ_id");
		Orgcom orgcom = new Orgcom();
		orgcom.setOrgan_id(ra.getParameter("organ_id"));// String:组织id
		orgcom.setOrgan_name(ra.getParameter("organ_name"));// String:名称
		orgcom.setToken_id(ra.getParameter("token_id"));
		orgcom.setOrgan_region(ra.getParameter("organ_region"));// String:行政区
		orgcom.setOrgan_address(ra.getParameter("organ_address"));// String:地址
		orgcom.setOrgan_linkman(ra.getParameter("organ_linkman"));// String:联系人
		orgcom.setOrgan_phone(ra.getParameter("organ_phone"));// String:电话
		orgcom.setOrgan_postcode(ra.getParameter("organ_postcode"));// String:邮码
		orgcom.setOrgan_domainname(ra.getParameter("organ_domainname"));// String:域名｜ip
		orgcom.setOrgan_trade(ra.getParameter("organ_trade"));// String:行业
		orgcom.setCom_type(ra.getParameter("com_type"));// String:企业类型
		orgcom.setOrgan_desc(ra.getParameter("organ_desc"));// String:组织简介
		orgcom.setOrgan_type(ra.getParameter("organ_type"));// String:组织类型
		orgcom.setOrgan_staff_number(ra.getParameter("organ_staff_number"));// String:员工人数
		String organ_code1 = ra.getParameter("organ_code1");
		String organ_code2 = ra.getParameter("organ_code2");
		orgcom.setOrgan_code(organ_code1 + "-" + organ_code2);// String:组织机构代码证号
		orgcom.setOrgan_cred_type(ra.getParameter("organ_cred_type"));// String:组织证件类型
		orgcom.setOrgan_cred_code(ra.getParameter("organ_cred_code"));// String:组织证件号码
		orgcom.setAuthentication_state(ra.getParameter("authentication_state"));// String:认证状态
		orgcom.setOrgan_domainname2(ra.getParameter("organ_domainname2"));// String:
		orgcom.setOrgan_code_image(ra.getParameter("organ_code_image"));
		orgcom.setBusiness_license_image(ra
				.getParameter("business_license_image"));
		orgcom.setTax_reg_certificate(ra.getParameter("tax_reg_certificate"));
		orgcom.setUse_token(ra.getParameter("use_token"));

		OrgcomtypeOrgcom orgcomtypeOrgcom = new OrgcomtypeOrgcom();
		orgcomtypeOrgcom.setOrgan_id(ra.getParameter("organ_id"));
		orgcomtypeOrgcom.setOrgan_type_state("1");
		int success = 0;
		/** 获取ibatis执行 */
		SqlMapClient sc = DataSource.getSqlMapInstance();
		try {
			sc.startTransaction();
			sc.update("Auth.updateOrgcom", orgcom);
			/** 删除企业和类型的对应 */
			sc.delete("Auth.deleteOrgTypeByOrgId", ra.getParameter("organ_id"));
			/** 增加企业和类型的对应表 */
			String[] org_types = ra.getParameterValues("com_type");
			if (org_types != null) {				
				for (String organ_type_id : org_types) {
					orgcomtypeOrgcom.setOrgan_type_id(organ_type_id);
					try{
					sc.insert("Auth.addOrgcomtypeOrgcom", orgcomtypeOrgcom);
					}catch(NestedSQLException nse){
						continue;
					}
				}
			}
			// 清除缓存
			CacheUtil.dataCache().remove("orgcom_" + organ_id);
			orgcom = OrgComService.getInstance().getOrgcomByID(organ_id);
			// 重新放到缓存中
			CacheUtil.dataCache()
					.put(new Element("orgcom_" + organ_id, orgcom));
			CacheUtil.dataCache().put(
					new Element(orgcom.getOrgan_code(), orgcom));
			sc.commitTransaction();
			success = 1;
		
		}catch (Exception e) {
			success = 0;
			log().info(e.getMessage());
			log().info(e.getStackTrace());
			throw e;
		} finally {
			sc.getCurrentConnection().rollback();
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print("{\"success\":" + success + "}");
	}

}
