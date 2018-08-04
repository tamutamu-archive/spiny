/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : spiny

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 02/07/2018 14:41:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for view_page
-- ----------------------------
DROP TABLE IF EXISTS `view_page`;
CREATE TABLE `view_page`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '页面名称',
  `url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '请求地址（url）',
  `authority` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限（authority）',
  `page_category_id` bigint(20) UNSIGNED NOT NULL COMMENT '页面分类 id',
  `sort` bigint(20) NULL DEFAULT 0 COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `gmt_modified` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `gmt_created` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_authority`(`authority`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视图页面表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of view_page
-- ----------------------------
INSERT INTO `view_page` VALUES (1, '系统首页1', '/', '/', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (2, '系统首页2', '/index', '/INDEX', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (3, '系统首页2', '/system', '/SYSTEM', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (4, '系统首页3', '/system/index', '/SYSTEM/INDEX', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (5, '工作台', '/system/workbench', '/SYSTEM/WORKBENCH', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (6, '视图页面管理', '/system/view_page/page_all', '/SYSTEM/VIEW_PAGE/PAGE_ALL', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (7, '视图页面关联 API', '/system/view_page_api/page_all', '/SYSTEM/VIEW_PAGE_API/PAGE_ALL', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (8, '视图页面组件关联 API', '/system/view_page_component_api/page_all', '/SYSTEM/VIEW_PAGE_COMPONENT_API/PAGE_ALL', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');

INSERT INTO `view_page` VALUES (9, 'API 管理', '/system/api/page_all', '/SYSTEM/API/PAGE_ALL', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (10, '数据字典', '/system/dictionary/page_all', '/SYSTEM/DICTIONARY/PAGE_ALL', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (11, 'Druid Monitor', '/druid', '/DRUID', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (12, '用户管理', '/user/page_all', '/USER/PAGE_ALL', 3, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (13, '角色管理', '/user/role/page_all', '/USER/ROLE/PAGE_ALL', 3, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (14, '角色 API 权限管理', '/user/role_authority/api/page_all', '/USER/ROLE_AUTHORITY/API/PAGE_ALL', 3, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (15, '角色视图页面管理', '/user/role_authority/view_page/page_all', '/USER/ROLE_AUTHORITY/VIEW_PAGE/PAGE_ALL', 3, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (16, '用户角色管理', '/user/user_role/page_all', '/USER/USER_ROLE/PAGE_ALL', 3, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (17, '视图菜单管理', '/user/view_menu/page_all', '/USER/VIEW_MENU/PAGE_ALL', 3, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');

SET FOREIGN_KEY_CHECKS = 1;
