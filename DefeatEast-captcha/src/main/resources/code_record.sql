/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : code

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-07-01 13:25:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for code_record
-- ----------------------------
DROP TABLE IF EXISTS `code_record`;
CREATE TABLE `code_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `code` varchar(8) DEFAULT NULL,
  `status` int(11) DEFAULT '0' COMMENT '0成功，1失败',
  `send_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
