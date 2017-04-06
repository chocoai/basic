package com.originsys.auth.Service;

import java.util.Calendar;
import java.util.Date;

import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.AccessToken;
import com.originsys.eap.util.CacheUtil;
import com.originsys.eap.util.DataSource;

/**
 auth:boy 2014-7-18
   描述：token的服务
 */
public class AccessTokenService {
	static class SingletonHolder {
		static AccessTokenService instance = new AccessTokenService();
	}

	public static AccessTokenService getInstance() {
		return SingletonHolder.instance;
	}

	static Logger logger = Logger.getLogger(AccessTokenService.class.getName());
	
	/**根据refresh_token获取Token对象*/
	public AccessToken getTokenBy(String refresh_token) throws Exception{
		AccessToken token=null;
		if (CacheUtil.dataCache().get(refresh_token)!=null){
			token=(AccessToken)CacheUtil.dataCache().get(refresh_token).getValue();
		}else{
			synchronized (this) {
				if (CacheUtil.dataCache().get(refresh_token)!=null){
					token=(AccessToken)CacheUtil.dataCache().get(refresh_token).getValue();
					return token;
				}
				SqlMapClient sc = DataSource.getSqlMapInstance();
				token=(AccessToken)sc.queryForObject("Auth.getATokenByRefreshToken", refresh_token);
				if(token!=null)
					CacheUtil.dataCache().put(new Element(refresh_token,token));
			}
		}
		return token;
	}
	
	/**根据access_token获取Token对象*/
	public AccessToken getTokenBy1(String access_token) throws Exception{
		AccessToken token=null;
		if (CacheUtil.dataCache().get(access_token)!=null){
			token=(AccessToken)CacheUtil.dataCache().get(access_token).getValue();
		}else{
			synchronized (this) {
				if (CacheUtil.dataCache().get(access_token)!=null){
					token=(AccessToken)CacheUtil.dataCache().get(access_token).getValue();
					return token;
				}
				SqlMapClient sc = DataSource.getSqlMapInstance();
				token=(AccessToken)sc.queryForObject("Auth.getATokenByAccessToken", access_token);
				if(token!=null)
					CacheUtil.dataCache().put(new Element(access_token,token));
			}
		}
		return token;
	}
	
	/**根据accesstoken获取用户编号*/
	public String getMemIdBy(String access_token) throws Exception{
		String mem_id=null;
		if (CacheUtil.dataCache().get(access_token)!=null){
			mem_id=(String)CacheUtil.dataCache().get(access_token).getValue();
		}else{
			synchronized (this) {
				if (CacheUtil.dataCache().get(access_token)!=null){
					mem_id=(String)CacheUtil.dataCache().get(access_token).getValue();
					return mem_id;
				}
				SqlMapClient sc = DataSource.getSqlMapInstance();
				mem_id=(String)sc.queryForObject("Auth.getMemidByToken", access_token);
				if(mem_id!=null)
					CacheUtil.dataCache().put(new Element(access_token,mem_id));
			}
		}
		return mem_id;
	}
	/**增加Token对象*/
	public void addToken(AccessToken token) throws Exception{
		SqlMapClient sc = DataSource.getSqlMapInstance();
		sc.insert("Auth.addAToken",token);
	}
	/**修改token对象*/
	public void updateToken(AccessToken token) throws Exception{
		SqlMapClient sc = DataSource.getSqlMapInstance();
		sc.update("Auth.updateAToken",token);		
	}
	
	/**去数据库中查询,根据client_id和mem_id查询token对象*/
	public AccessToken getTokenBy(String client_id,String mem_id) throws Exception{
		SqlMapClient sc = DataSource.getSqlMapInstance();
		AccessToken term=new AccessToken();
		term.setClient_id(client_id);
		term.setUsername(mem_id);
		AccessToken token=(AccessToken)sc.queryForObject("Auth.getATokenBy", term);
		return  token;
	}
	
	/**验证token是否过期,
	 * 最后修改时间+过期时间（天）如果大于当前时间则过期了
	 * @return false 未过期 true 过期*/
	public boolean invaildToken(AccessToken token) throws Exception{
		Date date=token.getModifiedtime();
		Calendar c = Calendar.getInstance();//获得一个日历的实例   
        c.setTime(date);//设置日历时间 
        int space=0;
        try{
    		int day=Integer.parseInt(token.getExpires());
    		space=day*24;
    	}catch(Exception e){
    		space=0;
    	}
    	c.add(Calendar.HOUR, space);
    	Date odate=c.getTime(); 
    	if(odate.after(new Date()))
    		return false;
    	else
    		return true;
	}
	
	/**验证token是否过期,
	 * 最后修改时间+过期时间（天）如果大于当前时间则过期了*/
	public boolean invaildToken(String token) throws Exception{
		AccessToken token1=this.getTokenBy1(token);
		if(token1==null)
			return false;
		Date date=token1.getModifiedtime();
		Calendar c = Calendar.getInstance();//获得一个日历的实例   
        c.setTime(date);//设置日历时间 
        int space=0;
        try{
    		int day=Integer.parseInt(token1.getExpires());
    		space=day*24;
    	}catch(Exception e){
    		space=0;
    	}
    	c.add(Calendar.HOUR, space);
    	Date odate=c.getTime(); 
    	if(odate.after(new Date()))
    		return false;
    	else
    		return true;
	}
}
