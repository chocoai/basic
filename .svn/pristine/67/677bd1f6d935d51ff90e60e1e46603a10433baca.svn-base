package com.originsys.safemanage.safecheck.action;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;
/**
 auth:wangmeng 2015-1-5
   描述:获取safecheck属性文件键值对
 */
@SuppressWarnings("serial")
public class SafeCheckProperty extends BaseAction implements IGet{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataAndView execute(RequestAction ra) throws Exception {
		//读取属性文件 
		ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("safecheck");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("hbase_url", rb.getString("hbase_url"));
		map.put("map_url", rb.getString("map_url"));
		map.put("scene_url", rb.getString("scene_url"));
		map.put("auth_server_url",rb.getString("auth_server_url"));
		return new DataAndView(map,"property");
	}

}
