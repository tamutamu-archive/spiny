
-- 电子邮件附件表
DROP TABLE
IF EXISTS `mail_attachment`;

CREATE TABLE `mail_attachment` (
  `id` BIGINT(20) UNSIGNED AUTO_INCREMENT COMMENT 'id',
  `email_id` BIGINT(20) NOT NULL COMMENT '电子邮件 id',
  `attachment_id` BIGINT(20) NOT NULL COMMENT '附件 id',
)
  ENGINE = INNODB
  DEFAULT CHARACTER
  SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  AUTO_INCREMENT = 1
  ROW_FORMAT = DYNAMIC
  COMMENT = '电子邮件附件表';
