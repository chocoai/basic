package com.originsys.authclient.action;

import com.originsys.eap.action.BaseAction;
import com.originsys.eap.util.RequestAction;
import com.originsys.auth.domain.UserInfo;
import com.originsys.authclient.util.ApiUtil;
import com.originsys.eap.iservice.IData;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.io.PrintWriter;

/**
 * @author Email:
 * @version 1.0 创建时间： 类说明： 列表页
 */
public class QyUserUpdate extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		// 获取值
		UserInfo userInfo = new UserInfo();
		userInfo.setMem_id(ra.getParameter("mem_id"));// String:用户id
		userInfo.setFamily_name(ra.getParameter("family_name"));// String:姓
		userInfo.setFirst_name(ra.getParameter("first_name"));// String:名
		userInfo.setMem_sex(ra.getParameter("mem_sex"));// String:性别
		// userInfo.setMem_born(Date.parse(ra.getParameter("mem_born")));//Date:生日
		if (ra.getParameter("mem_born") != null
				&& !"".equals(ra.getParameter("mem_born"))) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			userInfo.setMem_born(sdf.parse(ra.getParameter("mem_born")));// Date:生日
		}
		userInfo.setMem_mail(ra.getParameter("mem_mail"));// String:邮址
		// userInfo.setRegister_time(Date.parse(ra.getParameter("register_time")));//Date:注册时间
		if (ra.getParameter("register_time") != null
				&& !"".equals(ra.getParameter("register_time"))) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			userInfo.setRegister_time(sdf.parse(ra
					.getParameter("register_time")));// Date:注册时间
		}
		// userInfo.setLast_time(Date.parse(ra.getParameter("last_time")));//Date:最后登录时间
		if (ra.getParameter("last_time") != null
				&& !"".equals(ra.getParameter("last_time"))) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			userInfo.setLast_time(sdf.parse(ra.getParameter("last_time")));// Date:最后登录时间
		}
		userInfo.setMem_state(ra.getParameter("mem_state"));// String:用户状态
		userInfo.setMem_name(ra.getParameter("mem_name"));// String:登录名
		userInfo.setMem_integrality(ra.getParameter("mem_integrality"));// String:用户信息完整性
		userInfo.setMem_mphone(ra.getParameter("mem_mphone"));// String:手机
		userInfo.setMem_region(ra.getParameter("mem_region"));// String:居住区域
		userInfo.setMem_addr(ra.getParameter("mem_addr"));// String:地址
		userInfo.setSecure_image(ra.getParameter("secure_image"));// String:安全认证图片
		userInfo.setReg_source(ra.getParameter("reg_source"));// String:注册来源网站
		userInfo.setMem_image(ra.getParameter("mem_image"));// String:头像
		userInfo.setNote_info(ra.getParameter("note_info"));// String:备注信息
		userInfo.setID_num(ra.getParameter("ID_num"));
		
		int success = ApiUtil.getService().updateUserInfo(userInfo);
				
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print("{\"success\":" + success + "}");
	}

}
