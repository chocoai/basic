package com.originsys.datacenter.action.map;

import com.originsys.datacenter.action.map.common.EasyCode;
import com.supermap.data.CursorType;
import com.supermap.data.DatasetVector;
import com.supermap.data.Datasource;
import com.supermap.data.QueryParameter;
import com.supermap.data.Recordset;
import com.supermap.data.Workspace;

/**
 * 实现同步更新房屋图层生产数据
 * 
 * @author Administrator
 * 
 */
public class MapUpdate {
	private static StringBuffer sb = new StringBuffer();
	private static Workspace workspace = null;
	private static Recordset recordset = null;// 需要同步的记录集
	private static DatasetVector datasetVector_t = null;
	private static DatasetVector datasetVector_r = null;
	private static Datasource target = null;
	private static Datasource source = null;
	private static String datasetstr = EasyCode.DATASETNAME_HOUSE;
	private static String datasetstr0 = EasyCode.DATASETNAME_SAFE_HOUSE;

	// 执行方法
	public static String execute() {
		try {
			workspace = new Workspace();
			// 准备目标数据源
			target = EasyCode.getTargetSource(workspace);
			System.out.println("目标数据源准备完成！");
			// 准备源数据源
			source = EasyCode.getSourceSource(workspace);
			datasetVector_r = (DatasetVector) source.getDatasets().get(
					datasetstr);
			// 同步基础房屋数据(完全同步)
			datasetVector_t = (DatasetVector) target.getDatasets().get(
					datasetstr);
			datasetVector_t.getRecordset(false, CursorType.DYNAMIC).deleteAll();
			if (syn_basic_house(datasetVector_r, datasetVector_t))
				if (pointdatasetExchange(datasetVector_t,
						EasyCode.DATASETNAME_HOUSE_P))
					System.out.println("成功转换基础房屋内点数据集!");
			// 同步安全房屋数据(增量同步)
			datasetVector_t = (DatasetVector) target.getDatasets().get(
					datasetstr0);
			boolean issuc = syn_safe_house(datasetVector_r, datasetVector_t);
			if (issuc)
				// 重新生成安全房屋内点数据集
				if (pointdatasetExchange(datasetVector_t,
						EasyCode.DATASETNAME_SAFE_HOUSE_P))
					System.out.println("成功转换安全房屋内点数据集!");

		} catch (Exception e) {
			sb.append(e.getMessage() + "\r\n");
			System.out.println("" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != recordset)
				recordset.dispose();
			if (null != datasetVector_t) {
				datasetVector_t.close();
			}
			if (null != datasetVector_r) {
				datasetVector_r.close();
			}
			workspace.getDatasources().closeAll();
			workspace.close();
			workspace.dispose();
		}
		return sb.toString();
	}

	/**
	 * 同步基础房屋数据
	 * 
	 * @param dvr
	 * @param dvt
	 */
	public static boolean syn_basic_house(DatasetVector dvr, DatasetVector dvt) {
		boolean issuc = false;
		recordset = dvr.query(EasyCode.SQLFILTER_FOR_HOUSE, CursorType.DYNAMIC);
		System.out.println("源头数据数目：" + recordset.getRecordCount());
		// 开始数据处理过程
		if (dvt.append(recordset)) {
			// 整理清洗新的数据集
			if (dvt.isSpatialIndexDirty()) {
				dvt.reBuildSpatialIndex();
			}
			dvt.computeBounds();
			System.out.println("基础房屋数据同步正常结束!");
			sb.append("基础房屋数据同步正常结束!\r\n");
			issuc = true;
		} else {
			sb.append("同步ST_RIDRGN表失败,请重新执行,以保证地图版本数据的完整性！\r\n");
		}
		recordset = null;
		return issuc;
	}

	/**
	 * 同步安全房屋数据
	 * 
	 * @param dvr
	 * @param dvt
	 */
	public static boolean syn_safe_house(DatasetVector dvr, DatasetVector dvt) {
		boolean issuc = false;
		QueryParameter qpr = new QueryParameter();
		qpr.setCursorType(CursorType.STATIC);
		qpr.setHasGeometry(false);
		qpr.setResultFields(new String[] { EasyCode.SQLFILTER_SAFEHOUSE[0] });
		qpr.setAttributeFilter(EasyCode.SQLFILTER_SAFEHOUSE[1]);
		Recordset sqldata = dvt.query(qpr);
		// System.out.println("原有数据数目：" + sqldata.getRecordCount());
		if (sqldata.moveFirst()) {
			// System.out.println("选定第一条记录");
			int maxvalue = (Integer) sqldata.getFieldValue("smuserid");
			System.out.println("maxvalue:" + maxvalue);
			recordset = dvr.query(EasyCode.SQLFILTER_FOR_SAFEHOUSE + maxvalue,
					CursorType.DYNAMIC);
			System.out.println("需要同步的数据数目：" + recordset.getRecordCount());
			// 开始数据处理过程
			if (dvt.append(recordset)) {
				// 整理清洗新的数据集
				if (dvt.isSpatialIndexDirty()) {
					dvt.reBuildSpatialIndex();
				}
				dvt.computeBounds();
				System.out.println("安全房屋数据同步正常结束!");
				sb.append("安全房屋数据同步正常结束!\r\n");
				issuc = true;
			} else {
				sb.append("同步ST_RIDRGN_safecheck表失败,请重新执行,以保证地图版本数据的完整性！\r\n");
			}
			sqldata.dispose();
		} else {
			System.out.println("安全房屋同步过程异常终止！");
			sqldata.dispose();
		}
		return issuc;
	}

	/**
	 * 内点数据集处理
	 * 
	 * @param sour
	 * @param tar
	 * @return
	 */
	public static boolean pointdatasetExchange(DatasetVector src, String des) {
		boolean issuc = false;
		DatasetVector des_points = (DatasetVector) target.getDatasets()
				.get(des);
		// 增量处理安全房屋内点数据集
		if (null != recordset) {
			DatasetVector temp_points = target.innerPointToDataset(
					target.recordsetToDataset(recordset, "temp_regions"),
					"temp_points");
			boolean addsucc = des_points.append(temp_points.getRecordset(false,
					CursorType.DYNAMIC));
			if (addsucc) {
				if (des_points.isSpatialIndexDirty()) {
					des_points.reBuildSpatialIndex();
				}
				des_points.computeBounds();
				if (target.getDatasets().delete("temp_regions"))
					sb.append("成功删除临时面数据集!\r\n");
				if (target.getDatasets().delete("temp_points"))
					sb.append("成功删除临时点数据集!\r\n");
				issuc = true;
			}
		}
		// 处理基础房屋内点数据集
		else {
			System.out.println("开始处理基础房屋内点数据集！");
			DatasetVector temp_points1 = target.innerPointToDataset(src,
					"temp_points1");
			System.out.println("创建临时数据集完毕!");
			if (des_points.getRecordset(false, CursorType.DYNAMIC).deleteAll()) {
				System.out.println("开始向目标数据集复制数据！");
				if (des_points.append(temp_points1.getRecordset(false,
						CursorType.DYNAMIC))) {
					if (des_points.isSpatialIndexDirty()) {
						des_points.reBuildSpatialIndex();
					}
					des_points.computeBounds();
					if (target.getDatasets().delete("temp_points1"))
						sb.append("成功删除临时点数据集!\r\n");
					System.out.println("成功删除临时数据集!");
					issuc = true;
					System.out.println("向目标数据集复制数据完毕！");
				}
			}
		}
		return issuc;
	}

}
