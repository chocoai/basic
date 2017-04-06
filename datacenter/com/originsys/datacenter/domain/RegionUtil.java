package com.originsys.datacenter.domain;

import java.util.HashMap;

/**
 auth:boy 2014-4-17
   描述：地区转换工具，测绘数据和我们系统中国家标准地区号的对应
 */
public class RegionUtil {
	static final HashMap<String,String> map
		=new HashMap<String,String>(){
			{
				put("330101", "086370102");
				put("330102", "086370103");
				put("330103", "086370104");
				put("330104", "086370105");
				put("330105", "086370112");
				put("330106", "086370114");
				put("330107", "086370113");
				put("330109", "086370124");
				put("330110", "086370125");
				put("330111", "086370126");
				put("330108", "086370181");
			}
		};
		
	public static String toBZRegioncode(String code){
		return map.get(code);
	}
	
	/**根据原来系统的地区编号，分幅分丘号，幢号按照标准编码方式获得编号
	 * 9位地区号+8位分副分丘号+4位幢号 */
	public static String getSBuilingid(String region_id,String fq,String zh){
		String newregion_id=RegionUtil.toBZRegioncode(region_id);
		String newfq=fq.replaceAll("-", "");
		int n1=newfq.length();
		int n2=8-n1;
		StringBuffer sb=new StringBuffer();
		if(n2>0){
			for(int i=0;i<n2;i++){
				sb.append("0");
			}
		}
		sb.append(newfq);
		String fq1=sb.toString();
		int m1=zh.length();
		int m2=4-m1;
		StringBuffer sb1=new StringBuffer();
		if(m2>0){
			if(n2>0){
				for(int i=0;i<n2;i++){
					sb1.append("0");
				}
			}
		}
		sb1.append(zh);
		String zh1=sb1.toString();
		String sbuliding_id=newregion_id+fq1+zh1;
		newregion_id=null;
		newfq=null;
		sb=null;
		sb1=null;
		zh1=null;
		return sbuliding_id;
	}
	
	public static void main(String[] args){
//		System.out.print(RegionUtil.toBZRegioncode("330101"));
		
		//GB/T17710 MOD11,10国家统一校验码标准,在本标准中j表示字符从右到左包括校验码字符在内的位置序号
//		String code="1101010102006050001090001";
//		String code="1101010102006050001090001";
		String code="0863701030039011300100003";
		int p=10;//当j=1是，片p=10
		int s=0;//s=p%11+当前位置上的字符值
		int n=26;//总的字符的长度=前面计算的字符位数+校验码的长度
		int aj=1000;//最终的校验码的值
		int m=n-1;//最大的字串的下标值
		for(int j=1;j<=n;j++){
			if(j==n){
				s=p%11;
				aj=s-1;
			}else{
				int x=m-(m-j+1);//计算截取字符串的位置
				int y=Integer.parseInt(code.substring(x,x+1));//获取当前下标上的字符数值
				s=p%11+y;
				int x1=s%10;
				if(x1==0)x1=10;
				p=x1*2;		
			}
		}		
		System.out.println(aj);
		
		String sbid=getSBuilingid("330102","3-901-1-3","10");
		System.out.println(sbid);
	}
}
