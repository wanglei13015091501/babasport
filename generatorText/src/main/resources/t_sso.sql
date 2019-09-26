/*
Navicat MySQL Data Transfer
Source Server         : local
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : db_test
Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001
Date: 2016-08-24 17:19:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `keyword` varchar(50) DEFAULT NULL COMMENT '权限关键词',
  `description` varchar(50) DEFAULT NULL COMMENT '权限描述',
  `status` varchar(16) DEFAULT NULL COMMENT '权限状态:0-停用;1-启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='权限';


-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission`(id, name, keyword, description, status) VALUES ('1', '后台管理功能', null, null,'1');


-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `keyword` varchar(50) DEFAULT NULL COMMENT '角色关键词',
  `status` varchar(16) DEFAULT NULL COMMENT '角色状态:0-停用;1-启用',
  `description` varchar(50) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci  COMMENT='角色';


-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '后台管理员', null, '1',null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `gender` varchar(16) DEFAULT NULL COMMENT '性别:0-男;1-女',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `station` varchar(50) DEFAULT NULL COMMENT '状态:0-停用;1-启用',
  `telephone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `username` varchar(50) DEFAULT NULL COMMENT '登录用户名',
  `nickname` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户';


-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', null, null, 'e10adc3949ba59abbe56e057f20f883e',null,'1',null,'admin','admin');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `page` varchar(50) DEFAULT NULL COMMENT '访问路径',
  `priority` tinyint(1) DEFAULT NULL COMMENT '优先级',
  `description` varchar(50) DEFAULT NULL COMMENT '菜单描述',
  `pid` bigint(20) DEFAULT NULL COMMENT '父菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='菜单';


-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '商品管理', null, '1',null,null);

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` bigint(20) NOT NULL auto_increment,
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `role_permission_index` (`role_id`,`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色-权限';

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1', '2016-08-22 11:42:44');


-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL auto_increment,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `user_role_index` (`user_id`,`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1', '2016-08-22 11:42:01');

-- ----------------------------
-- Table structure for `role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` bigint(20) NOT NULL auto_increment,
  `menu_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `role_menu_index` (`menu_id`,`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1', '1', '2016-08-22 11:42:01');