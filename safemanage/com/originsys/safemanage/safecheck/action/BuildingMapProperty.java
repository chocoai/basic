package com.originsys.safemanage.safecheck.action;
import java.util.ResourceBundle;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;
/**
 auth:zhanglf 2014-6-17
   描述:获取地图服务器地址
 */
@SuppressWarnings("serial")
public class BuildingMapProperty extends BaseAction implements IGet{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataAndView execute(RequestAction ra) throws Exception {
		//读取属性文件 
		ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("safecheck");
		String map_url=rb.getString("map_url");
		
		return new DataAndView(map_url,"map_url");
	}

}
