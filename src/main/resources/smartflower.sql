/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : smartflower

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-04-24 15:27:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `f_info`
-- ----------------------------
DROP TABLE IF EXISTS `f_info`;
CREATE TABLE `f_info` (
  `flowerId` varchar(20) NOT NULL COMMENT '主键',
  `flowerName` varchar(40) NOT NULL DEFAULT '' COMMENT '花卉名称',
  `flowerInfo` varchar(255) NOT NULL DEFAULT '' COMMENT '花卉介绍',
  `flowerAvatarUrl` text NOT NULL COMMENT '花卉图片url',
  PRIMARY KEY (`flowerId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_info
-- ----------------------------

-- ----------------------------
-- Table structure for `f_user`
-- ----------------------------
DROP TABLE IF EXISTS `f_user`;
CREATE TABLE `f_user` (
  `id` varchar(10) NOT NULL  COMMENT '主键,自增',
  `nickName` varchar(40) NOT NULL  COMMENT '昵称',
  `pwd` varchar(30) NOT NULL COMMENT '密码',
  `avatarUrl` varchar(255) DEFAULT NULL COMMENT '用户头像url',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_user
-- ----------------------------
