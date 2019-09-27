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
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `name` VARCHAR(50) DEFAULT NULL COMMENT '权限名称',
  `keyword` VARCHAR(50) DEFAULT NULL COMMENT '权限关键词',
  `description` VARCHAR(50) DEFAULT NULL COMMENT '权限描述',
  `status` VARCHAR(16) DEFAULT NULL COMMENT '权限状态:0-停用;1-启用',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='权限';


-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission`(id, NAME, keyword, description, STATUS) VALUES ('1', '后台管理功能', NULL, NULL,'1');


-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` VARCHAR(50) DEFAULT NULL COMMENT '角色名称',
  `keyword` VARCHAR(50) DEFAULT NULL COMMENT '角色关键词',
  `status` VARCHAR(16) DEFAULT NULL COMMENT '角色状态:0-停用;1-启用',
  `description` VARCHAR(50) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci  COMMENT='角色';


-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '后台管理员', NULL, '1',NULL);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `birthday` DATE DEFAULT NULL COMMENT '生日',
  `gender` VARCHAR(16) DEFAULT NULL COMMENT '性别:0-男;1-女',
  `password` VARCHAR(50) DEFAULT NULL COMMENT '密码',
  `remark` VARCHAR(50) DEFAULT NULL COMMENT '备注',
  `station` VARCHAR(50) DEFAULT NULL COMMENT '状态:0-停用;1-启用',
  `telephone` VARCHAR(50) DEFAULT NULL COMMENT '联系电话',
  `username` VARCHAR(50) DEFAULT NULL COMMENT '登录用户名',
  `nickname` VARCHAR(50) DEFAULT NULL COMMENT '真实姓名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户';


-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', NULL, NULL, 'e10adc3949ba59abbe56e057f20f883e',NULL,'1',NULL,'admin','admin');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `name` VARCHAR(50) DEFAULT NULL COMMENT '菜单名称',
  `page` VARCHAR(50) DEFAULT NULL COMMENT '访问路径',
  `priority` TINYINT(1) DEFAULT NULL COMMENT '优先级',
  `description` VARCHAR(50) DEFAULT NULL COMMENT '菜单描述',
  `pid` BIGINT(20) DEFAULT NULL COMMENT '父菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='菜单';


-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '商品管理', NULL, '1',NULL,NULL);

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `role_id` BIGINT(20) NOT NULL,
  `permission_id` BIGINT(20) NOT NULL,
  `created` DATETIME DEFAULT NULL,
  PRIMARY KEY  (`id`),
  KEY `fk_roleid1` (`role_id`),
  KEY `fk_permissionid` (`permission_id`),
  CONSTRAINT `fk_roleid1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_permissionid` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色-权限';

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1', '2016-08-22 11:42:44');


-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(20) NOT NULL,
  `role_id` BIGINT(20) NOT NULL,
  `created` DATETIME DEFAULT NULL,
  PRIMARY KEY  (`id`),
  KEY `fk_roleid2` (`role_id`),
  KEY `fk_userid` (`user_id`),
  CONSTRAINT `fk_roleid2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1', '2016-08-22 11:42:01');

-- ----------------------------
-- Table structure for `role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `menu_id` BIGINT(20) NOT NULL,
  `role_id` BIGINT(20) NOT NULL,
  `created` DATETIME DEFAULT NULL,
  PRIMARY KEY  (`id`),
  KEY `fk_roleid3` (`role_id`),
  KEY `fk_menuid` (`menu_id`),
  CONSTRAINT `fk_roleid3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_menuid` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1', '1', '2016-08-22 11:42:01');