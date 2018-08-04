
-- 数据字典表
DROP TABLE
IF EXISTS `dictionary`;

CREATE TABLE `dictionary` (
  `id` BIGINT(20) UNSIGNED AUTO_INCREMENT COMMENT 'id',
  `key` VARCHAR(255) NOT NULL COMMENT '字典键',
  `key_name` VARCHAR(255) NOT NULL COMMENT '字典键名',
  `value_name` VARCHAR(255) NOT NULL COMMENT '字典值名',
  `value_slug` VARCHAR(255) NOT NULL COMMENT '字典值别名',
  `value` TEXT COMMENT '字典值',
  `editable` TINYINT(1) UNSIGNED DEFAULT NULL COMMENT '是否可编辑（0=不可编辑，1=可编辑，默认=1）',
  `dictionary_category_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '字典分类 id',
  `sort` BIGINT(20) UNSIGNED DEFAULT 0 COMMENT '排序',
  `remark` VARCHAR(255) DEFAULT '' COMMENT '备注',
  `gmt_modified` DATETIME DEFAULT NOW() COMMENT '更新时间',
  `gmt_created` DATETIME DEFAULT NOW() COMMENT '创建时间',
  PRIMARY KEY (`id`)
)
  ENGINE = INNODB
  DEFAULT CHARACTER
  SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  AUTO_INCREMENT = 1
  ROW_FORMAT = DYNAMIC
  COMMENT = '数据字典表';


-- 数据字典分类
INSERT INTO `dictionary_category` (`id`, `name`, `parent_id`)
VALUES (1, '系统缺省字段', NULL),
 (2, '通用缺省字段', NULL),
 (3, '网站配置', 1),
 (4, '电子邮箱配置', 1),
 (5, '视图页面组件类型', 1),
 (6, '日志级别', 1),
 (7, '信息状态', 1),
 (8, '是否可编辑', 2),
 (9, '性别', 2),
 (10, '是否验证', 2);

-- 数据字典
INSERT INTO `dictionary` (
  `key`,
  `key_name`,
  `value_name`,
  `value_slug`,
  `value`,
  `editable`,
  `dictionary_category_id`,
  `remark`
)
VALUES
  ('WEB', '网站字段', '网站名', 'NAME', 'Spiny', 1, 3),
  ('WEB', '网站字段', '页脚版权', 'FOOTER', 'Copyright &copy; 2018 Spiny.All rights reserved.', 1, 3),
  ('MAIL', '电子邮箱发信配置', '主机', 'HOST', 'smtp.exmail.qq.com', 1, 4, '腾讯企业邮箱：https://exmail.qq.com/'),
  ('MAIL', '电子邮箱发信配置', '协议', 'PROTOCOL', 'smtp', 1, 4),
  ('MAIL', '电子邮箱发信配置', '端口号', 'PORT', '25', 1, 4),
  ('MAIL', '电子邮箱发信配置', '用户名', 'USERNAME', 'no-reply@example.com', 1, 4),
  ('MAIL', '电子邮箱发信配置', '密码', 'PASSWORD', 'password', 1, 4),
  ('MAIL', '电子邮箱发信配置', '显示邮箱', 'FROM', 'no-reply@example.com', 1, 4),
  ('MAIL', '电子邮箱发信配置', '默认编码', 'DEFAULT_ENCODING', 'UTF-8', 1, 4),
  ('MAIL', '电子邮箱发信配置', '测试连接', 'TEST_CONNECTION', 'false', 1, 4),
  ('VIEW_PAGE_COMPONENT_TYPE', '视图页面组件类型', '按钮', 'BUTTON', 1, 1, 5),
  ('VIEW_PAGE_COMPONENT_TYPE', '视图页面组件类型', '搜索框', 'SEARCH', 2, 1, 5),
  ('LOG_LEVEL', '日志级别', '信息', 'INFO', 1, 1, 6),
  ('LOG_LEVEL', '日志级别', '警告', 'WARN', 2, 1, 6),
  ('LOG_LEVEL', '日志级别', '错误', 'ERROR', 3, 1, 6),
  ('SMS_STATUS', '信息状态', '等待', 'WAIT', 1, 1, 7),
  ('SMS_STATUS', '信息状态', '成功', 'SUCCESS', 2, 1, 7),
  ('SMS_STATUS', '信息状态', '失败', 'FAIL', 3, 1, 7),
  ('IS_OR_NOT', '是或否', '否', 'NOT', 0, 1, 8),
  ('IS_OR_NOT', '是或否', '是', 'IS', 1, 1, 8),
  ('GENDER', '性别', '未知', 'UNKNOWN', 0, 1, 9),
  ('GENDER', '性别', '男', 'MALE', 1, 1, 9),
  ('GENDER', '性别', '女', 'FEMALE', 2, 1, 9);
--   ('IS_VERIFIED', '是否验证', '未验证', 'IS_NOT_VERIFIED', 0, 1, 10),
--   ('IS_VERIFIED', '是否验证', '已验证', 'IS_VERIFIED', 1, 1, 10);
--
--  ('EDITABLE', '是否可编辑', '不可编辑', 'NON_EDITABLE', 0, 1, 8),
--   ('EDITABLE', '是否可编辑', '可编辑', 'EDITABLE', 1, 1, 8),
--   ('IS_VERIFIED', '是否验证', '未验证', 'IS_NOT_VERIFIED', 0, 1, 10),
--   ('IS_VERIFIED', '是否验证', '已验证', 'IS_VERIFIED', 1, 1, 10);