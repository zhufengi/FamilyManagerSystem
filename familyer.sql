/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : familyer

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-05-16 17:36:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `familyties`
-- ----------------------------
DROP TABLE IF EXISTS `familyties`;
CREATE TABLE `familyties` (
  `familyTiesId` int(8) DEFAULT NULL,
  `familyTies` varchar(16) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of familyties
-- ----------------------------
INSERT INTO `familyties` VALUES ('1', '父亲');
INSERT INTO `familyties` VALUES ('2', '母亲');
INSERT INTO `familyties` VALUES ('3', '爷爷');
INSERT INTO `familyties` VALUES ('4', '奶奶');

-- ----------------------------
-- Table structure for `familyuser`
-- ----------------------------
DROP TABLE IF EXISTS `familyuser`;
CREATE TABLE `familyuser` (
  `userId` int(8) DEFAULT NULL,
  `name` varchar(12) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `age` int(4) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `work` varchar(12) DEFAULT NULL,
  `birthTime` datetime DEFAULT NULL,
  `birthAddress` varchar(10) DEFAULT NULL,
  `role` int(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of familyuser
-- ----------------------------
INSERT INTO `familyuser` VALUES ('1', 'zhangsan', '男', '35', '123', '15784322563', '公务员', '1973-03-13 16:17:23', '四川', '1');
INSERT INTO `familyuser` VALUES ('2', 'lisi', '女', '32', '12', '17898670543', '教师', '1976-06-09 16:20:07', '四川', '1');
INSERT INTO `familyuser` VALUES ('3', 'zhangda', '男', '60', '123', '7865266', '公务员', '1958-04-18 16:22:11', '四川', '2');
INSERT INTO `familyuser` VALUES ('4', 'zhaohua', 'nv', '60', '123', '7865266', '医生', '1958-04-18 16:25:01', '四川', '2');
INSERT INTO `familyuser` VALUES ('5', 'zhangxx', '男', '8', '123', null, '学生', '2010-04-18 16:26:19', '四川', '2');
