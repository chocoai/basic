package com.originsys.realtygis.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.realtygis.domain.StridrgnSafe;


/**
 * 类说明：房屋普查数据更新
 * @创建时间：2014-6-10
 * @作者： 洛佳明
 */
public class BuildingSafeDateUpdate extends BaseAction implements IGet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataAndView<StridrgnSafe> execute(RequestAction ra)throws Exception {
			
		SqlMapClient sc = DataSource.getSqlMapInstance();
		StridrgnSafe stridrgnsafe =new StridrgnSafe();
		Integer buildingId=null;
		Integer checkstate=null;//房屋普查状态	   
	    String  safegrade=null;//安全普查等级
	    String  testgrade=null;//鉴定等级	    
	    String  checkgrade=null;//检查等级
	    Integer checkstate2=null;//房屋检查状态
	    Integer checkstate3=null;//房屋鉴定状态  
		
		if("".equals(ra.getParameter("building_id"))||null==ra.getParameter("building_id")){
			System.out.println("building_id为空!");			
		}
		else{	
			try{
			  buildingId = Integer.parseInt(ra.getParameter("building_id"));
			  stridrgnsafe.setBuilding_id(buildingId);
			  System.out.println(ra.getParameter("checkstate2")+"((((((((())))))))");
			if(!"".equals(ra.getParameter("checkstate"))&&null!=ra.getParameter("checkstate")){
				
				checkstate=Integer.parseInt(ra.getParameter("checkstate"));
				stridrgnsafe.setCheckstate(checkstate);
			}
            if(!"".equals(ra.getParameter("checkstate2"))&&null!=ra.getParameter("checkstate2")){
				
				checkstate2=Integer.parseInt(ra.getParameter("checkstate2"));
				stridrgnsafe.setCheckstate2(checkstate2);
			}
            if(!"".equals(ra.getParameter("checkstate3"))&&null!=ra.getParameter("checkstate3")){
				
				checkstate3=Integer.parseInt(ra.getParameter("checkstate3"));
				stridrgnsafe.setCheckstate3(checkstate3);
			}
            if(!"".equals(ra.getParameter("safegrade"))&&null!=ra.getParameter("safegrade")){
				
            	safegrade=ra.getParameter("safegrade");
				stridrgnsafe.setSafegrade(safegrade);
			}
            
            if(!"".equals(ra.getParameter("testgrade"))&&null!=ra.getParameter("testgrade")){
				
                testgrade=ra.getParameter("testgrade");
				stridrgnsafe.setTestgrade(testgrade);
			}
            
            if(!"".equals(ra.getParameter("checkgrade"))&&null!=ra.getParameter("checkgrade")){
				
               checkgrade=ra.getParameter("checkgrade");
			   stridrgnsafe.setCheckgrade(checkgrade);
			} 
			
			//新建房屋需要更新两张表的相关数据
			if(ra.getParameter("building_id").subSequence(0,1).equals("-")){
				try{
					sc.startTransaction();
					sc.update("Realtygis.updatecheckstatepoint",stridrgnsafe);
					sc.update("Realtygis.updatecheckstatepointfromregion",stridrgnsafe);
					sc.commitTransaction();
					stridrgnsafe.setIsuccessed("1");
				}catch (Exception e) {
					e.printStackTrace();
				}finally{
					sc.endTransaction();
				}
			}
		//原有房屋 需要更新两张表的相关数据
			else{				
				try{
					sc.startTransaction();
					sc.update("Realtygis.updatecheckstate",stridrgnsafe);
					sc.update("Realtygis.updatecheckstatepointfromregion",stridrgnsafe);
					sc.commitTransaction();
					stridrgnsafe.setIsuccessed("1");
				}catch (Exception e) {
					e.printStackTrace();
				}finally{
					sc.endTransaction();
				}
			}	
		
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			System.out.println("BuildingSafeDateUpdate报错！");
		}		
		
		}
		return new DataAndView<StridrgnSafe>(stridrgnsafe, "stridrgnsafe");	
	}

}