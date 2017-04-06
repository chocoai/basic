package com.originsys.auth.hessian;

import com.caucho.hessian.server.HessianServlet;

/**
 auth:boy 2014-6-27
   描述：用户认证的Hessian servlet 
   这样定义是因为在web.xml中可以定义多个servlet
   如果还有其他的接口需要通过Hessian调用，可以定义一个其他的类，在web.xml中指定不同的实现service
<servlet-name>authapi</servlet-name> 
	    <servlet-class>com.originsys.auth.hessian.AuthHessianServlet</servlet-class> 
	    <init-param> 
	        <param-name>service-class</param-name> 
	        <param-value>com.originsys.auth.hessian.BasicServiceImpl</param-value> 
	    </init-param> 
	  </servlet> 
	  <servlet-mapping> 
	    <servlet-name>authapi</servlet-name> 
	    <url-pattern>/authapi</url-pattern> 
	  </servlet-mapping> 
 */
public class AuthHessianServlet extends HessianServlet{

}
