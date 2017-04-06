/*
SQLyog Enterprise - MySQL GUI v6.03
Host - 5.5.13-log : Database - eap2014
*********************************************************************
Server version : 5.5.13-log
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `eap2014`;

USE `eap2014`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `yc_datacenter_resources` */

DROP TABLE IF EXISTS `yc_datacenter_resources`;

CREATE TABLE `yc_datacenter_resources` (
  `resources_id` varchar(36) NOT NULL COMMENT '资源编号',
  `resources_name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `resources_desc` varchar(200) DEFAULT NULL COMMENT '资源描述',
  `source_business_systems` varchar(50) DEFAULT NULL COMMENT '来源业务系统',
  `resources_state` char(1) DEFAULT NULL COMMENT '资源状态',
  `resources_tablename` varchar(50) DEFAULT NULL COMMENT '资源表名',
  `resources_type` char(1) DEFAULT NULL COMMENT '资源类型 扩展增加还是新表',
  `reg_date` datetime DEFAULT NULL COMMENT '注册时间',
  `reg_memid` varchar(36) DEFAULT NULL COMMENT '注册人id',
  `resources_datasource` varchar(50) DEFAULT NULL COMMENT '数据源',
  PRIMARY KEY (`resources_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源注册表';

/*Table structure for table `yc_datacenter_resources_cols` */

DROP TABLE IF EXISTS `yc_datacenter_resources_cols`;

CREATE TABLE `yc_datacenter_resources_cols` (
  `resources_id` varchar(36) DEFAULT NULL COMMENT '资源编号',
  `column_id` varchar(36) NOT NULL COMMENT '字段编号',
  `column_ename` varchar(100) DEFAULT NULL COMMENT '字段英文名称',
  `column_name` varchar(100) DEFAULT NULL COMMENT '字段中文名称',
  `column_desc` varchar(200) DEFAULT NULL COMMENT '字段描述',
  `column_type` varchar(50) DEFAULT NULL COMMENT '字段类型',
  `column_length` varchar(20) DEFAULT NULL COMMENT '字段长度',
  `is_empty` char(1) DEFAULT NULL COMMENT '是否可空',
  `column_enum` varchar(50) DEFAULT NULL COMMENT '数据字典',
  PRIMARY KEY (`column_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源字段信息';

/*Table structure for table `yc_datacenter_resources_index` */

DROP TABLE IF EXISTS `yc_datacenter_resources_index`;

CREATE TABLE `yc_datacenter_resources_index` (
  `resources_id` varchar(36) DEFAULT NULL COMMENT '资源编号',
  `index_id` varchar(36) NOT NULL COMMENT '索引编号',
  `index_type` varchar(20) DEFAULT NULL COMMENT '索引类型（rowkey）',
  `index_column` varchar(50) DEFAULT NULL COMMENT '索引对应列名',
  `index_separate` char(1) DEFAULT NULL COMMENT '分隔符',
  `index_desc` varchar(200) DEFAULT NULL COMMENT '索引描述',
  PRIMARY KEY (`index_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源索引表';

/*Table structure for table `yc_datacenter_service_params` */

DROP TABLE IF EXISTS `yc_datacenter_service_params`;

CREATE TABLE `yc_datacenter_service_params` (
  `param_id` varchar(36) NOT NULL COMMENT '参数id',
  `service_id` varchar(36) DEFAULT NULL COMMENT '服务id',
  `param_code` varchar(100) DEFAULT NULL COMMENT '参数名称',
  `param_desc` varchar(100) DEFAULT NULL COMMENT '参数描述',
  `param_type` char(1) DEFAULT NULL COMMENT '参数类型',
  `is_required` char(1) DEFAULT NULL COMMENT '是否必须',
  `field_type` varchar(20) DEFAULT NULL COMMENT '字段类型',
  PRIMARY KEY (`param_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务参数表';

/*Table structure for table `yc_datacenter_service_register` */

DROP TABLE IF EXISTS `yc_datacenter_service_register`;

CREATE TABLE `yc_datacenter_service_register` (
  `service_id` varchar(36) NOT NULL COMMENT '服务编号',
  `service_name` varchar(100) DEFAULT NULL COMMENT '服务名称',
  `service_desc` varchar(500) DEFAULT NULL COMMENT '服务描述',
  `service_provide` varchar(200) DEFAULT NULL COMMENT '服务提供者',
  `is_check` char(1) DEFAULT NULL COMMENT '是否审核',
  `service_version` varchar(20) DEFAULT NULL COMMENT '版本',
  `proxy_type` varchar(20) DEFAULT NULL COMMENT '代理服务类型',
  `service_type` char(1) DEFAULT NULL COMMENT '服务类型',
  `service_state` char(1) DEFAULT NULL COMMENT '服务状态',
  `create_date` datetime DEFAULT NULL COMMENT '服务创建时间',
  `creator` varchar(36) DEFAULT NULL COMMENT '服务创建人',
  `checkor` varchar(36) DEFAULT NULL COMMENT '审核者',
  `check_date` datetime DEFAULT NULL COMMENT '审核时间',
  `request_url` varchar(500) DEFAULT NULL COMMENT '请求地址',
  `example_image` varchar(2000) DEFAULT NULL COMMENT '返回示例图片',
  `is_authorize` char(1) DEFAULT NULL COMMENT '是否需要用户授权',
  `authorize_mode` varchar(50) DEFAULT NULL COMMENT '服务申请授权方式',
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务注册表';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
