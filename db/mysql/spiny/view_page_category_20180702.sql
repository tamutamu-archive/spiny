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

 Date: 02/07/2018 14:43:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for view_page_category
-- ----------------------------
DROP TABLE IF EXISTS `view_page_category`;
CREATE TABLE `view_page_category`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类名称',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级分类 id',
  `sort` bigint(20) NULL DEFAULT 0 COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `gmt_modified` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `gmt_created` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视图页面分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of view_page_category
-- ----------------------------
INSERT INTO `view_page_category` VALUES (1, '系统管理', NULL, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page_category` VALUES (2, '系统配置', 1, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page_category` VALUES (3, '用户配置', 1, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');

SET FOREIGN_KEY_CHECKS = 1;
