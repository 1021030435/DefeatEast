/*
Navicat MySQL Data Transfer

Source Server         : cnnmysql
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : usercenter

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2018-07-08 11:36:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idcard` varchar(20) DEFAULT '',
  `link` varchar(255) DEFAULT NULL,
  `link_type` int(11) DEFAULT '0' COMMENT '0-手机，1-邮箱',
  `name` varchar(30) DEFAULT '',
  `psw` varchar(32) NOT NULL DEFAULT '',
  `salt` varchar(4) DEFAULT '',
  `monify_time` timestamp NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idcard` (`idcard`),
  UNIQUE KEY `link` (`link`),
  KEY `name` (`name`),
  KEY `create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
