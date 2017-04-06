package com.originsys.auth.domain;

/**
 auth:boy 2013-7-22
   描述：OTP动态令牌信息
 */
public class OTPToken {
	/**令牌号*/
	private String token_id="";
	/**密钥”*/
	private String authkey="";
	/**成功值*/
	private long currsucc=0;
	/**漂移值*/
	private int currdft=0;
	
	
	public String getToken_id() {
		return token_id;
	}
	public void setToken_id(String token_id) {
		this.token_id = token_id;
	}
	public String getAuthkey() {
		return authkey;
	}
	public void setAuthkey(String authkey) {
		this.authkey = authkey;
	}
	public long getCurrsucc() {
		return currsucc;
	}
	public void setCurrsucc(long currsucc) {
		this.currsucc = currsucc;
	}
	public int getCurrdft() {
		return currdft;
	}
	public void setCurrdft(int currdft) {
		this.currdft = currdft;
	}
	
}
