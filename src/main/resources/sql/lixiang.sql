/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : lixiang

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 22/10/2021 22:41:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) DEFAULT NULL COMMENT '角色编码',
  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `created` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `creator` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `edited` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `editor` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted` int(5) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, 'admin', '管理员', '2021-10-22 22:14:03', NULL, '2021-10-22 22:14:03', NULL, NULL);
INSERT INTO `role` VALUES (3, 'user', '用户', '2021-10-22 22:17:02', NULL, '2021-10-22 22:17:02', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引',
  `login_name` varchar(50) NOT NULL DEFAULT '' COMMENT '登陆名',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
  `status` tinyint(1) DEFAULT '0' COMMENT '是否禁用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COMMENT='user';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (19, 'zhang', '123456', 0);
INSERT INTO `user` VALUES (20, 'zhnag', '123456789', 0);
COMMIT;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id-',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `login_name` varchar(50) DEFAULT NULL COMMENT '登录名',
  `id_card` varchar(50) DEFAULT NULL COMMENT '身份证号',
  `gender` varchar(50) DEFAULT NULL COMMENT '性别',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `created` datetime(6) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '创建时间',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建人-用户名',
  `edited` datetime(6) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '编辑时间',
  `editor` varchar(50) DEFAULT NULL COMMENT '编辑者-用户名',
  `status` smallint(3) DEFAULT '1' COMMENT '状态 0-无效',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `loginname` (`login_name`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_info
-- ----------------------------
BEGIN;
INSERT INTO `user_info` VALUES (1, 220, 'zhng', 'dfd', 'df', NULL, NULL, NULL, '2021-10-22 22:16:41.962019', NULL, '2021-10-22 22:16:41.962019', NULL, 0);
INSERT INTO `user_info` VALUES (2, 322, '343', '434', '34', NULL, NULL, NULL, '2021-10-22 22:39:54.134403', NULL, '2021-10-22 22:39:54.134403', NULL, 0);
INSERT INTO `user_info` VALUES (3, 3321, '34', '34', NULL, NULL, NULL, NULL, '2021-10-22 22:40:01.711507', NULL, '2021-10-22 22:40:01.711507', NULL, 0);
INSERT INTO `user_info` VALUES (4, 3434, '3433', NULL, NULL, NULL, NULL, NULL, '2021-10-22 22:20:31.358235', NULL, '2021-10-22 22:20:31.358235', NULL, 1);
INSERT INTO `user_info` VALUES (5, 34, '333333', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `user_info` VALUES (6, 34343, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `user_info` VALUES (7, 111111111111111, 'dfd', 'zhnag', '111111111111111', '1', '13067456623', '5656', '2021-10-22 22:25:06.439000', NULL, '2021-10-22 22:25:06.439000', NULL, 1);
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
