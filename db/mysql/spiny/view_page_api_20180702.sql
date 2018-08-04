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

 Date: 02/07/2018 14:43:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for view_page_api
-- ----------------------------
DROP TABLE IF EXISTS `view_page_api`;
CREATE TABLE `view_page_api`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `page_id` bigint(20) UNSIGNED NOT NULL COMMENT '视图页面 id',
  `api_id` bigint(20) UNSIGNED NOT NULL COMMENT 'API id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视图页面关联 API 表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of view_page_api
-- ----------------------------
INSERT INTO `view_page_api` VALUES (1, 1, 77);
INSERT INTO `view_page_api` VALUES (2, 1, 78);
INSERT INTO `view_page_api` VALUES (3, 1, 79);
INSERT INTO `view_page_api` VALUES (4, 2, 77);
INSERT INTO `view_page_api` VALUES (5, 2, 78);
INSERT INTO `view_page_api` VALUES (6, 2, 79);
INSERT INTO `view_page_api` VALUES (7, 3, 77);
INSERT INTO `view_page_api` VALUES (8, 3, 78);
INSERT INTO `view_page_api` VALUES (9, 3, 79);
INSERT INTO `view_page_api` VALUES (10, 4, 77);
INSERT INTO `view_page_api` VALUES (11, 4, 78);
INSERT INTO `view_page_api` VALUES (12, 4, 79);

SET FOREIGN_KEY_CHECKS = 1;
