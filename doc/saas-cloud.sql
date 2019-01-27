/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : saas-cloud

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-01-27 23:28:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `dept_no` varchar(18) DEFAULT NULL COMMENT '部门编号',
  `name` varchar(300) DEFAULT NULL COMMENT '部门名称',
  `pid` varchar(64) DEFAULT NULL COMMENT '父级id',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态(1:正常；9:弃用)',
  `dept_relationship_key` varchar(300) DEFAULT NULL COMMENT '为了维护更深层级关系',
  `dept_manager_id` varchar(64) DEFAULT NULL COMMENT '部门经理user_id',
  `manager_name` varchar(255) DEFAULT NULL COMMENT '部门经理名称',
  `phone` varchar(20) DEFAULT NULL COMMENT '部门经理联系电话',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('535518008227921920', '201901171757381235', '亮剑科技有限公司', '0', '1', '01', '535518934330245120', '豪哥', '13888888888', '2019-01-17 18:01:26', null);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` varchar(64) NOT NULL,
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户id',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `time` int(11) DEFAULT NULL COMMENT '响应时间',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `code` varchar(64) DEFAULT NULL COMMENT '菜单资源编码',
  `name` varchar(300) DEFAULT NULL COMMENT '菜单资源名称',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)',
  `url` varchar(100) DEFAULT NULL COMMENT '访问地址URL',
  `pid` varchar(64) DEFAULT NULL COMMENT '父级菜单名称',
  `order_num` int(11) DEFAULT '0' COMMENT '排序',
  `type` tinyint(4) DEFAULT NULL COMMENT '菜单类型(1:目录;2:菜单;3:按钮)',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态1:正常 9：禁用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('535839535800516608', 'SYS_MANAGER', '系统管理', null, null, '0', '0', '1', '1', '2019-01-18 15:28:23', null);
INSERT INTO `sys_menu` VALUES ('535843038841274368', 'SYS_MANAGER_LOG', '系统日志', null, null, '535839535800516608', '0', '2', '1', '2019-01-18 15:29:33', null);
INSERT INTO `sys_menu` VALUES ('535843250695569408', 'SYS_MANAGER_MENU', '系统菜单', null, null, '535839535800516608', '0', '2', '1', '2019-01-18 15:30:42', null);
INSERT INTO `sys_menu` VALUES ('535843732000342016', 'ORG_MANAGER', '组织管理', null, null, '0', '0', '1', '1', '2019-01-18 15:32:47', null);
INSERT INTO `sys_menu` VALUES ('535844069973164032', 'ORG_MANAGER_USER', '用户管理', null, null, '535843732000342016', '0', '2', '1', '2019-01-18 15:33:35', null);
INSERT INTO `sys_menu` VALUES ('535844270855159808', 'ORG_MANAGER_ROLE', '角色管理', null, null, '535843732000342016', '0', '2', '1', '2019-01-18 15:34:21', null);
INSERT INTO `sys_menu` VALUES ('535844448978862080', 'ORG_MANAGER_DEPT', '机构管理', null, null, '535843732000342016', '0', '2', '1', '2019-01-18 15:35:04', null);
INSERT INTO `sys_menu` VALUES ('535844676456939520', 'ORG_MANAGER_USER_BTN_GET', '查询用户', 'org:manager:user:info', '/user/info/*/*', '535844069973164032', '0', '3', '1', '2019-01-18 15:40:01', null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(300) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '状态(1:正常9:弃用)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('535855188825604096', '超级管理员', '能访问所有的菜单资源', '1', '2019-01-18 16:17:50', null);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `role_id` varchar(64) DEFAULT NULL COMMENT '角色id',
  `menu_id` varchar(64) DEFAULT NULL COMMENT '菜单资源id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('535855713130381312', '535855188825604096', '535839535800516608', '2019-01-18 16:19:51');
INSERT INTO `sys_role_menu` VALUES ('535855994467516416', '535855188825604096', '535843038841274368', '2019-01-18 16:19:51');
INSERT INTO `sys_role_menu` VALUES ('535857076237238272', '535855188825604096', '535843250695569408', '2019-01-18 16:19:51');
INSERT INTO `sys_role_menu` VALUES ('535857104729145344', '535855188825604096', '535843732000342016', '2019-01-18 16:19:51');
INSERT INTO `sys_role_menu` VALUES ('535857152510656512', '535855188825604096', '535844069973164032', '2019-01-18 16:19:51');
INSERT INTO `sys_role_menu` VALUES ('535857185129758720', '535855188825604096', '535844270855159808', '2019-01-18 16:19:51');
INSERT INTO `sys_role_menu` VALUES ('535857220491935744', '535855188825604096', '535844448978862080', '2019-01-18 16:24:13');
INSERT INTO `sys_role_menu` VALUES ('535857253576605696', '535855188825604096', '535844676456939520', '2019-01-18 16:23:02');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(64) NOT NULL COMMENT '用户id',
  `username` varchar(50) NOT NULL COMMENT '账户名称',
  `salt` varchar(20) DEFAULT NULL COMMENT '加密盐值',
  `password` varchar(200) NOT NULL COMMENT '用户密码密文',
  `dept_id` varchar(64) DEFAULT NULL COMMENT '部门id',
  `real_name` varchar(60) DEFAULT NULL COMMENT '真实名称',
  `nick_name` varchar(60) DEFAULT NULL COMMENT '昵称',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码(唯一)',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱(唯一)',
  `status` tinyint(4) DEFAULT '1' COMMENT '账户状态(1.正常 2.锁定 3.删除 4.非法)',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别(1.男 2.女)',
  `create_id` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_id` varchar(64) DEFAULT NULL COMMENT '更新人',
  `create_where` tinyint(4) DEFAULT NULL COMMENT '创建来源(1.web 2.android 3.ios )',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('539208791636312064', 'hg', 'ab42f41a9e2c48fe8c70', '1a6f6f737b57f03e0ecd7c9dfe52bc2c', '535518008227921920', 'hegao', '大佬', '13888888888', '2639990486@qq.com', '1', '1', null, null, null, '2019-01-27 22:23:13', null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(64) NOT NULL COMMENT '用户id',
  `user_id` varchar(64) DEFAULT NULL,
  `role_id` varchar(64) DEFAULT NULL COMMENT '角色id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('535855464450097152', '539208791636312064', '535855188825604096', '2019-01-18 16:18:58');
