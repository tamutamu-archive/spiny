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

 Date: 02/07/2018 15:07:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for view_page_component_api
-- ----------------------------
DROP TABLE IF EXISTS `view_page_component_api`;
CREATE TABLE `view_page_component_api`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `page_component_id` bigint(20) UNSIGNED NOT NULL COMMENT '视图页面组件 id',
  `api_id` bigint(20) UNSIGNED NOT NULL COMMENT 'API id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视图页面组件关联 API 表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of view_page_component_api
-- ----------------------------
INSERT INTO `view_page_component_api` VALUES (1, 1, 30);
INSERT INTO `view_page_component_api` VALUES (2, 2, 33);
INSERT INTO `view_page_component_api` VALUES (3, 2, 31);
INSERT INTO `view_page_component_api` VALUES (4, 3, 32);
INSERT INTO `view_page_component_api` VALUES (5, 4, 35);
INSERT INTO `view_page_component_api` VALUES (6, 5, 38);
INSERT INTO `view_page_component_api` VALUES (7, 5, 35);
INSERT INTO `view_page_component_api` VALUES (8, 6, 36);
INSERT INTO `view_page_component_api` VALUES (9, 6, 38);

SET FOREIGN_KEY_CHECKS = 1;
