package com.originsys.auth.action;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.Service.AccessTokenService;
import com.originsys.auth.domain.AccessApp;
import com.originsys.auth.domain.AccessToken;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;

/**
 auth:boy 2014-7-18
   描述：根据code返回token或者根据refreshtoken获取token
 */
public class AccessTokenAction extends BaseAction implements IData {

	public void execute(RequestAction request, HttpServletResponse response)
			throws Exception {
		String grant_type = request.getParameter("grant_type");	
		String client_id=request.getParameter("client_id");
		String username ="";//用户mem_id
		String redirect_URI=request.getParameter("redirect_URI");
		
		response.addHeader("Content-Type", "application/json;charset=UTF-8");
		response.addHeader("Cache-Control", "no-store");
		response.addHeader("Pragma", "no-cache");
		
		SqlMapClient sc = DataSource.getSqlMapInstance();
		/**判断获取token的回调地址和应用注册时的回调地址是否一样，不一样的，则不能返回token*/
		AccessApp app=(AccessApp)sc.queryForObject("Auth.getAccessAppByCID",client_id);
		String redirect_URI1="";
		if(app!=null){
			redirect_URI1=app.getRedirect_uri();
		}
		/**不能是整体地址的比较，应该比较域名和端口就可以了
		 * 例如：http://localhost:8080/portal/authclient.login
		 * 只要判断localhost:8080这部分就可以了,下面这两句严格来说应该判断非空和-1*/
		redirect_URI=redirect_URI.substring(redirect_URI.indexOf("//")+2, redirect_URI.indexOf("/",redirect_URI.indexOf("//")+2));
		redirect_URI1=redirect_URI1.substring(redirect_URI1.indexOf("//")+2, redirect_URI1.indexOf("/",redirect_URI1.indexOf("//")+2));
		if(!redirect_URI1.equals(redirect_URI)){
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			sb.append("\"error\":");
			sb.append("\"redirect_uri_mismatch\"");
			sb.append(",\"error_code\":");
			sb.append("\"21322\"");
			sb.append(",\"error_description\":");
			sb.append("\"重定向地址不匹配\"");
			sb.append("}");
			response.getWriter().println(sb.toString());
		}
		if (grant_type.equals("authorization_code"))
		{			
			/**获取授权码，验证下授权码，如果对，生成AccessToken返回
			 * 授权码的格式
			 * String code= client_id+"_"+ra.getUser().getMem_id()+"_"+Integer.toString(r.nextInt());*/
			String code=request.getParameter("code");
			if(code==null)code="";			 
			if(code.startsWith(client_id+"_")){
				int n1=code.indexOf("_");
				int n2=code.lastIndexOf("_");
				username=code.substring(n1+1, n2);
				String access_token = UUIDshort.get();
				String refresh_token = UUIDshort.get();
				
				AccessToken at = new AccessToken();
				at.setId(UUIDshort.get());
				at.setAccess_token(access_token);
				at.setRefresh_token(refresh_token);
				at.setUsername(username);
				at.setClient_id(client_id);
				/**设置过期时间，暂时固定30天*/
				at.setExpires("30");
				at.setCreatedtime(new Date());
				at.setModifiedtime(new Date());
				/**将AccessToken对象保存到数据库中*/
				AccessTokenService.getInstance().addToken(at);
				
				StringBuilder sb = new StringBuilder();
				sb.append("{");
				sb.append("\"access_token\":");
				sb.append("\"" + access_token + "\"");
				sb.append(",\"token_type\":\"\"");			
				sb.append(",\"expires_in\":");
				sb.append(3600);			
				sb.append(",\"refresh_token\":");
				sb.append("\"" + refresh_token + "\"");
				sb.append(",\"username\":");
				sb.append("\""+ username + "\"");
				sb.append(",\"client_id\":");
				sb.append("\""+ client_id + "\"");
				sb.append("}");
				response.getWriter().println(sb.toString());		
			}else{
				StringBuilder sb = new StringBuilder();
				sb.append("{");
				sb.append("\"error\":");
				sb.append("\"invalid_client\"");
				sb.append(",\"error_code\":");
				sb.append("\"21324\"");
				sb.append(",\"error_description\":");
				sb.append("\"client_id参数无效\"");
				sb.append("}");
				response.getWriter().println(sb.toString());
			}
		}
	
		if (grant_type.equals("refresh_token"))
		{	
			/**获取参数刷新token*/
			String refresh_token = request.getParameter("refresh_token");
			/**根据refresh_token到数据库中取AccessToken对象，如果存在，则重新返回一个access_token，并修改数据的这条记录*/
			AccessToken token=AccessTokenService.getInstance().getTokenBy(refresh_token);
			if(token!=null){
				String access_token = UUIDshort.get();
				String refresh_token2 = UUIDshort.get();
				username=token.getUsername();
				token.setAccess_token(access_token);
				token.setRefresh_token(refresh_token2);
				token.setModifiedtime(new Date());
				/**保存到内存中*/
				AccessTokenService.getInstance().updateToken(token);

				StringBuilder sb = new StringBuilder();
				sb.append("{");
				sb.append("\"access_token\":");
				sb.append("\"" + access_token + "\"");
				sb.append(",\"token_type\":\"\"");			
				sb.append(",\"expires_in\":");
				sb.append(3600);			
				sb.append(",\"refresh_token\":");
				sb.append("\"" + refresh_token2 + "\"");
				sb.append(",\"username\":");
				sb.append("\""+ username + "\"");
				sb.append(",\"client_id\":");
				sb.append("\""+ client_id + "\"");
				sb.append("}");
				response.getWriter().println(sb.toString());				
			}else{
				StringBuilder sb = new StringBuilder();
				sb.append("{");
				sb.append("\"error\":");
				sb.append("\"invalid_refreshToken\"");
				sb.append(",\"error_code\":");
				sb.append("\"21325\"");
				sb.append(",\"error_description\":");
				sb.append("\"refreshToken参数无效\"");
				sb.append("}");
				response.getWriter().println(sb.toString());
			}				
		}
		
//		if (grant_type.equals("password"))
//		{
//			response.getWriter().println("暂不支持密码方式");			
//			return ;
//		}
//		
//		if (grant_type.equals("client_credentials"))
//		{	
//			response.getWriter().println("暂不支持Client Credentials方式");			
//			return ;
//		}
	}

}
