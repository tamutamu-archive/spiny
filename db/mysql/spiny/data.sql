

-- password：88888888
-- bcrypt: $2a$10$zgMZctm1fDGP.B0Zn0iLsesCujXp51stcHK/cBc783JQ7/jMU7nji


-- 初始化数据


-- 用户、用户角色和角色权限
-- 普通用户
INSERT INTO `user` (`id`, `password`, `username`, `email`, `email_is_verified`, `department_id`, `remark`, `gmt_deleted`)
VALUES (1, '$2a$10$zgMZctm1fDGP.B0Zn0iLsesCujXp51stcHK/cBc783JQ7/jMU7nji',
        'normal_user', 'godcheese@outlook.com', 1, 1, '测试备注', NULL);

INSERT INTO `role` (`id`, `name`, `value`)
VALUES (1, '普通用户', 'NORMAL_USER');
INSERT INTO `user_role` (
  `user_id`,
  `role_id`
) VALUES (1, 1);


-- 管理员
INSERT INTO `user` (`id`, `password`, `username`, `email`, `email_is_verified`, `department_id`, `remark`, `gmt_deleted`)
VALUES (2, '$2a$10$zgMZctm1fDGP.B0Zn0iLsesCujXp51stcHK/cBc783JQ7/jMU7nji',
        'admin', '1176394803@qq.com', 1, 1, '测试备注', NULL);
INSERT INTO `role` (`id`, `name`, `value`)
VALUES (2, '管理员', 'ADMIN');
INSERT INTO `user_role` (
  `user_id`,
  `role_id`
) VALUES (2, 2);

-- 系统管理员
INSERT INTO `user` (`id`, `password`, `username`, `email`, `email_is_verified`, `department_id`, `remark`, `gmt_deleted`)
VALUES (3, '$2a$10$zgMZctm1fDGP.B0Zn0iLsesCujXp51stcHK/cBc783JQ7/jMU7nji',
        'system_admin', 'godcheese@qq.com', 1, 1, '测试备注', NULL);
INSERT INTO `role` (`id`, `name`, `value`)
VALUES (3, '系统管理员', 'SYSTEM_ADMIN');
INSERT INTO `user_role` (
  `user_id`,
  `role_id`
) VALUES (3, 3);

-- 视图菜单
INSERT INTO `view_menu_category` (
  `id`,
  `name`,
  `icon`,
  `parent_id`,
  `role_id`
) VALUES (1,'系统管理', 'fa fa-cog', NULL, 3),
 (2,'系统配置', 'fa fa-cog', 1, 3),
 (3,'用户配置', 'fa fa-user', 1, 3);
INSERT INTO `view_menu` (
  `id`,
  `name`,
  `url`,
  `menu_category_id`,
  `role_id`
)
VALUES
 (1, 'API 管理', '/system/api/page_all', 2, 3),
(2, '数据字典', '/system/dictionary/page_all', 2, 3),
(3, '视图页面管理', '/system/view_page/page_all', 2, 3),
(4, 'Druid Monitor', '/druid', 2, 3),

  (5, '用户管理', '/user/page_all', 3, 3),
 (6, '角色管理', '/user/role/page_all', 3, 3);


-- 视图页面
INSERT INTO `view_page_category` (
  `id`,
  `name`,
  `parent_id`
) VALUES (1, '系统管理', NULL), (2, '系统配置', 1), (3, '用户配置', 1);



-- API
INSERT INTO `api_category` (
  `id`,
  `name`,
  `parent_id`
) VALUES (1, '系统管理', NULL),
(2, '系统配置', 1),
(3, '用户配置', 1),

 (4, 'API 分类', 2),
 (5, 'API', 2),
 (6, '数据字典分类', 2),
 (7, '数据字典', 2),
 (8, '视图页面关联 API', 2),
 (9, '视图页面分类', 2),
 (10, '视图页面', 2),
 (11, '视图页面组件', 2),
 (12, '视图页面组件关联 API', 2),

 (13, '角色关联权限', 3),
 (14, '角色', 3),
 (15, '用户', 3),
 (16, '用户关联角色', 3),
 (17, '视图菜单分类', 3),
 (18, '视图菜单', 3);

