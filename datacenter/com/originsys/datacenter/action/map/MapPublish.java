package com.originsys.datacenter.action.map;

import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.originsys.datacenter.action.map.common.EasyCode;
import com.originsys.eap.action.BaseAction;

import com.originsys.eap.util.OrgContextHolder;
import com.supermap.data.Dataset;
import com.supermap.data.DatasetVector;
import com.supermap.data.Datasource;

import com.supermap.data.Maps;
import com.supermap.data.Workspace;
import com.supermap.data.WorkspaceConnectionInfo;
import com.supermap.data.WorkspaceType;
import com.supermap.data.WorkspaceVersion;
import com.supermap.mapping.Layer;
import com.supermap.mapping.Layers;
import com.supermap.mapping.Map;

/**
 * 地图历史版本发布
 * 
 * @author Administrator
 */
@SuppressWarnings("serial")
public class MapPublish extends BaseAction implements Job {
	StringBuffer logbuf = new StringBuffer();

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		/** 设置线程的局部变量 读取属性配置文件 */
		OrgContextHolder.setVendorType("eap2");
		StringBuffer logbuf = new StringBuffer();
		System.out.println(EasyCode.getCurrTime() + "空间数据同步开始");
		logbuf.append(EasyCode.getCurrTime() + "空间数据同步开始\r\n");
		logbuf.append(MapUpdate.execute());
		System.out.println(EasyCode.getCurrTime() + "地图历史版本制作开始");
		logbuf.append(EasyCode.getCurrTime() + "地图历史版本制作开始\r\n");
		logbuf.append(publish());
		System.out.println(EasyCode.getCurrTime() + "地图历史版本制作结束");
		logbuf.append(EasyCode.getCurrTime() + "地图历史版本制作结束\r\n");
		try {
			EasyCode.writeLocalLog(logbuf.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Workspace workspace = null;
	private static WorkspaceVersion wsversion = null;
	private static Map map = null;
	private static Layers layers = null;
	private static Layer layer_st = null;
	private static Datasource ds = null;
	private static Connection conn = null;
	private static Statement stem = null;
	private static String mapname = null;// 地图名称
	private static String version_name = null;// 地图版本名称
	private static StringBuffer sb = new StringBuffer();

	/**
	 * 发布地图
	 */
	public static String publish() {
		sb.append("发布地图开始========================\r\n");
		String file = EasyCode.WORKSPACE_ADDRESS;
		String datasetstr = EasyCode.DATASETNAME_HOUSE;
		WorkspaceConnectionInfo workspaceConnectionInfo = null;
		try {
			workspace = new Workspace();
			workspaceConnectionInfo = new WorkspaceConnectionInfo();
			workspaceConnectionInfo.setType(WorkspaceType.SMWU);
			workspaceConnectionInfo.setServer(file);
			workspace.open(workspaceConnectionInfo);
			wsversion = workspace.getVersion();
			if (null == workspace.getDatasources().get(0)) {
				ds = EasyCode.getTargetSource(workspace);
			} else {
				ds = workspace.getDatasources().get(0);
			}
			// 生产数据集副本
			Dataset datasetCopy = produceDataSetCopy(datasetstr);
			// 制作最新的地图版本
			if (null != datasetCopy)
				map = produceMapVersion(datasetCopy);
		} catch (Exception e) {
			sb.append(e.getMessage() + "\r\n");
			e.printStackTrace();
		} finally {
			if (null != map)
				map.close();
			workspaceConnectionInfo.dispose();
			workspace.close();
			workspace.dispose();
			// 将发布的地图信息写进数据库表
			boolean mapnameisNotNull = (null != mapname);
			boolean versionnameisNotNull = (null != version_name);
			if (mapnameisNotNull && versionnameisNotNull)
				updateTable(version_name, mapname);
		}
		return sb.toString();
	}

	/**
	 * 根据指定数据集制作地图最新版本
	 * 
	 * @param datasetCopy
	 *            最新房屋数据集副本
	 * @return
	 */
	public static Map produceMapVersion(Dataset datasetCopy) {
		Maps maps = workspace.getMaps();
		int count = maps.getCount() - 1;
		String mapxml = maps.getMapXML(count);
		int index = maps.add(mapname, mapxml, wsversion);// 制作地图版本的方法
		Map imap = new Map(workspace);
		imap.open(maps.get(index));
		imap.refresh();
		// 返回图层集合
		layers = imap.getLayers();
		layer_st = layers.get(EasyCode.DATASETNAME_HOUSE + "@"
				+ EasyCode.DATASOURCE_CONNECTION_ORCL);// 根据图层名称获取该图层
		if (null != datasetCopy) {
			sb.append("开始为图层" + layer_st.getName() + "指定数据集\r\n");
			sb.append("原数据集为:" + layer_st.getDataset().getName() + "\r\n");
			layer_st.setDataset(datasetCopy);
			sb.append("新数据集为:" + layer_st.getDataset().getName() + "\r\n");
			sb.append("结束指定数据集\r\n");
		}
		imap.refresh();
		workspace.getMaps().setMapXML(index, imap.toXML());
		workspace.save();
		return imap;
	}

	/**
	 * 生产指定数据集的副本
	 * 
	 * @param datasetstr
	 *            源数据集的名称字符串
	 */
	public static Dataset produceDataSetCopy(String datasetstr) {
		// 获取源数据集
		DatasetVector dataset = (DatasetVector) ds.getDatasets()
				.get(datasetstr);
		if (null != dataset) {
			// 获取系统时间
			Date nowdate = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmm");
			SimpleDateFormat dfmap = new SimpleDateFormat("-yyyy-MM");
			mapname = df.format(nowdate);
			version_name = "平面图" + dfmap.format(nowdate);
			String datasetCopyName = ds.getDatasets().getAvailableDatasetName(
					datasetstr + "_" + mapname);
			sb.append("开始制作历史数据集" + datasetCopyName + "\r\n");
			Dataset datasetCopy = ds.copyDataset(dataset, datasetCopyName,
					dataset.getEncodeType());
			sb.append("结束制作历史数据集" + datasetCopyName + "\r\n");
			return datasetCopy;
		} else {
			sb.append("无法获取数据集" + datasetstr + ",地图版本制作过程终止。\r\n");
			return null;
		}
	}

	/**
	 * 将发布的地图信息写进数据库表
	 * 
	 * @param version_name
	 *            版本名称
	 * @param mapname
	 *            地图名称/版本号
	 */
	private static void updateTable(String version_name, String mapname) {
		try {

			String sql = "insert into t_mapversion (auditor,publisher,status,version_name,version_number,default_map)"
					+ " values ('','','禁用','"
					+ version_name
					+ "','"
					+ mapname
					+ "',1000)";
			conn = EasyCode.getOracleConn();
			stem = conn.createStatement();// PreparedStatement?
			if (1 == stem.executeUpdate(sql)) {
				System.out.println("更新表成功！更新一条记录");
			} else {
				System.out.println("没有更新表记录！");
			}
		} catch (Exception e) {
			System.out.println("有异常！");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
