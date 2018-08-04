
-- API 表
-- ----------------------------
-- Table structure for api
-- ----------------------------
DROP TABLE IF EXISTS `api`;
CREATE TABLE `api`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'API 名称',
  `url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '请求地址（url）',
  `authority` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限（authority）',
  `api_category_id` bigint(20) UNSIGNED NOT NULL COMMENT 'API 分类 id',
  `sort` bigint(20) UNSIGNED NULL DEFAULT 0 COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `gmt_modified` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `gmt_created` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_authority`(`authority`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'API 表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api
-- ----------------------------
INSERT INTO `api` VALUES (1, '分页获取所有父级 API 分类', '/api/system/api_category/page_all_parent', '/API/SYSTEM/API_CATEGORY/PAGE_ALL_PARENT', 4, 0, '', '2018-06-20 12:56:39', '2018-06-20 12:56:39');
INSERT INTO `api` VALUES (2, '指定父级 API 分类 id ，获取所有 API 分类分类', '/api/system/api_category/list_all_by_parent_id', '/API/SYSTEM/API_CATEGORY/LIST_ALL_BY_PARENT_ID', 4, 0, '', '2018-06-20 12:57:36', '2018-06-20 12:57:36');
INSERT INTO `api` VALUES (3, '新增 API 分类', '/api/system/api_category/add_one', '/API/SYSTEM/API_CATEGORY/ADD_ONE', 4, 0, '', '2018-06-20 12:58:15', '2018-06-20 12:58:15');
INSERT INTO `api` VALUES (4, '保存 API 分类', '/api/system/api_category/save_one', '/API/SYSTEM/API_CATEGORY/SAVE_ONE', 4, 0, '', '2018-06-20 12:58:43', '2018-06-20 12:58:43');
INSERT INTO `api` VALUES (5, '指定 API 分类 id ，批量删除 API 分类', '/api/system/api_category/delete_all', '/API/SYSTEM/API_CATEGORY/DELETE_ALL', 4, 0, '', '2018-06-20 12:59:32', '2018-06-20 12:59:18');
INSERT INTO `api` VALUES (6, '指定 API 分类 id ，获取 API 分类信息', '/api/system/api_category/one', '/API/SYSTEM/API_CATEGORY/ONE', 4, 0, '', '2018-06-20 13:00:35', '2018-06-20 13:00:35');
INSERT INTO `api` VALUES (7, '指定 API 分类 id ，分页获取所有 API', '/api/system/api/page_all_by_api_category_id', '/API/SYSTEM/API/PAGE_ALL_BY_API_CATEGORY_ID', 5, 0, '', '2018-06-20 13:01:16', '2018-06-20 13:01:16');
INSERT INTO `api` VALUES (8, '新增 API', '/api/system/api/add_one', '/API/SYSTEM/API/ADD_ONE', 5, 0, '', '2018-06-20 13:01:45', '2018-06-20 13:01:45');
INSERT INTO `api` VALUES (9, '保存 API', '/api/system/api/save_one', '/API/SYSTEM/API/SAVE_ONE', 5, 0, '', '2018-06-20 13:02:03', '2018-06-20 13:02:03');
INSERT INTO `api` VALUES (10, '指定 API id ，批量删除 API', '/api/system/api/delete_all', '/API/SYSTEM/API/DELETE_ALL', 5, 0, '', '2018-06-20 13:02:22', '2018-06-20 13:02:22');
INSERT INTO `api` VALUES (11, '指定 API id ， 获取 API 信息', '/api/system/api/one', '/API/SYSTEM/API/ONE', 5, 0, '', '2018-06-20 13:02:40', '2018-06-20 13:02:40');
INSERT INTO `api` VALUES (12, '分页获取所有父级数据字典分类', '/api/system/dictionary_category/page_all_parent', '/API/SYSTEM/DICTIONARY_CATEGORY/PAGE_ALL_PARENT', 6, 0, '', '2018-06-20 13:04:25', '2018-06-20 13:04:25');
INSERT INTO `api` VALUES (13, '指定父级数据字典分类 id ，获取所有数据字典分类', '/api/system/dictionary_category/list_all_by_parent_id', '/API/SYSTEM/DICTIONARY_CATEGORY/LIST_ALL_BY_PARENT_ID', 6, 0, '', '2018-06-20 13:04:43', '2018-06-20 13:04:43');
INSERT INTO `api` VALUES (14, '新增数据字典分类', '/api/system/dictionary_category/add_one', '/API/SYSTEM/DICTIONARY_CATEGORY/ADD_ONE', 6, 0, '', '2018-06-20 13:05:26', '2018-06-20 13:05:02');
INSERT INTO `api` VALUES (15, '保存数据字典分类', '/api/system/dictionary_category/save_one', '/API/SYSTEM/DICTIONARY_CATEGORY/SAVE_ONE', 6, 0, '', '2018-06-20 13:05:19', '2018-06-20 13:05:19');
INSERT INTO `api` VALUES (16, '指定数据字典分类 id ，批量删除数据字典分类', '/api/system/dictionary_category/delete_all', '/API/SYSTEM/DICTIONARY_CATEGORY/DELETE_ALL', 6, 0, '', '2018-06-20 13:05:44', '2018-06-20 13:05:44');
INSERT INTO `api` VALUES (17, '指定数据字典分类 id ，获取数据字典分类信息', '/api/system/dictionary_category/one', '/API/SYSTEM/DICTIONARY_CATEGORY/ONE', 6, 0, '', '2018-06-20 13:06:00', '2018-06-20 13:06:00');
INSERT INTO `api` VALUES (18, '指定父级数据字典分类 id ，获取所有数据字典', '/api/system/dictionary/page_all_by_dictionary_category_id', '/API/SYSTEM/DICTIONARY/PAGE_ALL_BY_DICTIONARY_CATEGORY_ID', 7, 0, '', '2018-06-20 13:06:49', '2018-06-20 13:06:49');
INSERT INTO `api` VALUES (19, '新增数据字典', '/api/system/dictionary/add_one', '/API/SYSTEM/DICTIONARY/ADD_ONE', 7, 0, '', '2018-06-20 13:07:27', '2018-06-20 13:07:27');
INSERT INTO `api` VALUES (20, '保存数据字典', '/api/system/dictionary/save_one', '/API/SYSTEM/DICTIONARY/SAVE_ONE', 7, 0, '', '2018-06-20 13:07:45', '2018-06-20 13:07:45');
INSERT INTO `api` VALUES (21, '指定数据字典 id ， 批量删除数据字典', '/api/system/dictionary/delete_all', '/API/SYSTEM/DICTIONARY/DELETE_ALL', 7, 0, '', '2018-06-20 13:08:06', '2018-06-20 13:08:06');
INSERT INTO `api` VALUES (22, '指定数据字典 id ，获取数据字典信息', '/api/system/dictionary/one', '/API/SYSTEM/DICTIONARY/ONE', 7, 0, '', '2018-06-20 13:10:51', '2018-06-20 13:08:54');
INSERT INTO `api` VALUES (23, '获取所有数据字典', '/api/system/dictionary/list_all', '/API/SYSTEM/DICTIONARY/LIST_ALL', 7, 0, '', '2018-06-20 13:11:16', '2018-06-20 13:11:16');
INSERT INTO `api` VALUES (24, '指定数据字典键 ，获取所有数据字典', '/api/system/dictionary/list_all_by_key', '/API/SYSTEM/DICTIONARY/LIST_ALL_BY_KEY', 7, 0, '', '2018-06-20 13:11:55', '2018-06-20 13:11:55');
INSERT INTO `api` VALUES (25, '是否关联 API', '/api/system/view_page_api/is_associated_by_page_id_and_api_id', '/API/SYSTEM/VIEW_PAGE_API/IS_ASSOCIATED_BY_PAGE_ID_AND_API_ID', 8, 0, '', '2018-06-20 14:25:36', '2018-06-20 14:25:36');
INSERT INTO `api` VALUES (26, '批量关联 API', '/api/system/view_page_api/associate_all_by_page_id_and_api_id_list', '/API/SYSTEM/VIEW_PAGE_API/ASSOCIATE_ALL_BY_PAGE_ID_AND_API_ID_LIST', 8, 0, '', '2018-06-20 14:26:00', '2018-06-20 14:26:00');
INSERT INTO `api` VALUES (27, '指定视图页面 id、API id ，批量撤销关联', '/api/system/view_page_api/revoke_associate_all_by_page_id_and_api_id_list', '/API/SYSTEM/VIEW_PAGE_API/REVOKE_ASSOCIATE_ALL_BY_PAGE_ID_AND_API_ID_LIST', 8, 0, '', '2018-06-20 14:26:26', '2018-06-20 14:26:26');
INSERT INTO `api` VALUES (28, '分页获取所有父级视图页面分类', '/api/system/view_page_category/page_all_parent', '/API/SYSTEM/VIEW_PAGE_CATEGORY/PAGE_ALL_PARENT', 9, 0, '', '2018-06-20 14:27:26', '2018-06-20 14:27:26');
INSERT INTO `api` VALUES (29, '指定父级视图页面分类 id ，获取所有视图页面分类', '/api/system/view_page_category/list_all_by_parent_id', '/API/SYSTEM/VIEW_PAGE_CATEGORY/LIST_ALL_BY_PARENT_ID', 9, 0, '', '2018-06-20 14:27:45', '2018-06-20 14:27:45');
INSERT INTO `api` VALUES (30, '新增视图页面分类', '/api/system/view_page_category/add_one', '/API/SYSTEM/VIEW_PAGE_CATEGORY/ADD_ONE', 9, 0, '', '2018-06-20 14:28:02', '2018-06-20 14:28:02');
INSERT INTO `api` VALUES (31, '保存视图页面分类', '/api/system/view_page_category/save_one', '/API/SYSTEM/VIEW_PAGE_CATEGORY/SAVE_ONE', 9, 0, '', '2018-06-20 14:28:17', '2018-06-20 14:28:17');
INSERT INTO `api` VALUES (32, '指定视图页面分类 id ，批量删除视图页面分类', '/api/system/view_page_category/delete_all', '/API/SYSTEM/VIEW_PAGE_CATEGORY/DELETE_ALL', 9, 0, '', '2018-06-20 14:28:36', '2018-06-20 14:28:36');
INSERT INTO `api` VALUES (33, '指定视图页面分类 id ，获取视图页面分类信息', '/api/system/view_page_category/one', '/API/SYSTEM/VIEW_PAGE_CATEGORY/ONE', 9, 0, '', '2018-06-20 14:29:04', '2018-06-20 14:29:04');
INSERT INTO `api` VALUES (34, '指定父级视图页面分类 id ，获取所有视图页面', '/api/system/view_page/page_all_by_page_category_id', '/API/SYSTEM/VIEW_PAGE/PAGE_ALL_BY_PAGE_CATEGORY_ID', 10, 0, '', '2018-06-20 14:38:43', '2018-06-20 14:38:43');
INSERT INTO `api` VALUES (35, '新增视图页面', '/api/system/view_page/add_one', '/API/SYSTEM/VIEW_PAGE/ADD_ONE', 10, 0, '', '2018-06-20 14:39:26', '2018-06-20 14:39:26');
INSERT INTO `api` VALUES (36, '保存视图页面', '/api/system/view_page/save_one', '/API/SYSTEM/VIEW_PAGE/SAVE_ONE', 10, 0, '', '2018-06-20 14:39:53', '2018-06-20 14:39:53');
INSERT INTO `api` VALUES (37, '指定视图页面 id ，批量删除视图页面', '/api/system/view_page/delete_all', '/API/SYSTEM/VIEW_PAGE/DELETE_ALL', 10, 0, '', '2018-06-20 14:40:17', '2018-06-20 14:40:17');
INSERT INTO `api` VALUES (38, '指定视图页面 id ，获取视图页面信息', '/api/system/view_page/one', '/API/SYSTEM/VIEW_PAGE/ONE', 10, 0, '', '2018-06-20 14:40:34', '2018-06-20 14:40:34');
INSERT INTO `api` VALUES (39, '分页获取所有视图页面组件', '/api/system/view_page_component/page_all_by_page_id', '/API/SYSTEM/VIEW_PAGE_COMPONENT/PAGE_ALL_BY_PAGE_ID', 11, 0, '', '2018-06-20 14:45:30', '2018-06-20 14:45:30');
INSERT INTO `api` VALUES (40, '新增视图页面组件', '/api/system/view_page_component/add_one', '/API/SYSTEM/VIEW_PAGE_COMPONENT/ADD_ONE', 11, 0, '', '2018-06-20 14:45:45', '2018-06-20 14:45:45');
INSERT INTO `api` VALUES (41, '保存视图页面组件', '/api/system/view_page_component/save_one', '/API/SYSTEM/VIEW_PAGE_COMPONENT/SAVE_ONE', 11, 0, '', '2018-06-20 14:46:03', '2018-06-20 14:46:03');
INSERT INTO `api` VALUES (42, '指定视图页面组件 id ，批量删除视图页面组件', '/api/system/view_page_component/delete_all', '/API/SYSTEM/VIEW_PAGE_COMPONENT/DELETE_ALL', 11, 0, '', '2018-06-20 14:46:22', '2018-06-20 14:46:22');
INSERT INTO `api` VALUES (43, '指定视图组件 id ，获取视图组件信息', '/api/system/view_page_component/one', '/API/SYSTEM/VIEW_PAGE_COMPONENT/ONE', 11, 0, '', '2018-06-20 14:46:40', '2018-06-20 14:46:40');
INSERT INTO `api` VALUES (44, '是否关联 API', '/api/system/view_page_component_api/is_associated_by_page_component_id_and_api_id', '/API/SYSTEM/VIEW_PAGE_COMPONENT_API/IS_ASSOCIATED_BY_PAGE_COMPONENT_ID_AND_API_ID', 12, 0, '', '2018-06-20 14:48:47', '2018-06-20 14:48:47');
INSERT INTO `api` VALUES (45, '批量关联 API', '/api/system/view_page_component_api/associate_all_by_page_component_id_and_api_id_list', '/API/SYSTEM/VIEW_PAGE_COMPONENT_API/ASSOCIATE_ALL_BY_PAGE_COMPONENT_ID_AND_API_ID_LIST', 12, 0, '', '2018-06-20 14:49:42', '2018-06-20 14:49:42');
INSERT INTO `api` VALUES (46, '指定视图页面组件 id、API id ，批量撤销关联', '/api/system/view_page_component_api/revoke_associate_all_by_page_component_id_and_api_id_list', '/API/SYSTEM/VIEW_PAGE_COMPONENT_API/REVOKE_ASSOCIATE_ALL_BY_PAGE_COMPONENT_ID_AND_API_ID_LIST', 12, 0, '', '2018-06-20 14:50:43', '2018-06-20 14:50:43');
INSERT INTO `api` VALUES (47, '指定角色 id、页面权限（authority），批量授权', '/api/user/role_authority/grant_all_by_role_id_and_page_authority_list', '/API/USER/ROLE_AUTHORITY/GRANT_ALL_BY_ROLE_ID_AND_PAGE_AUTHORITY_LIST', 13, 0, '', '2018-06-20 15:07:15', '2018-06-20 15:07:15');
INSERT INTO `api` VALUES (48, '指定角色 id、页面权限（authority），批量撤销授权', '/api/user/role_authority/revoke_all_by_role_id_and_page_authority_list', '/API/USER/ROLE_AUTHORITY/REVOKE_ALL_BY_ROLE_ID_AND_PAGE_AUTHORITY_LIST', 13, 0, '', '2018-06-20 15:07:39', '2018-06-20 15:07:39');
INSERT INTO `api` VALUES (49, '指定角色 id、页面组件权限（authority），批量授权', '/api/user/role_authority/grant_all_by_role_id_and_page_component_authority_list', '/API/USER/ROLE_AUTHORITY/GRANT_ALL_BY_ROLE_ID_AND_PAGE_COMPONENT_AUTHORITY_LIST', 13, 0, '', '2018-06-20 15:08:11', '2018-06-20 15:08:11');
INSERT INTO `api` VALUES (50, '指定角色 id、页面组件权限（authority），批量撤销授权', '/api/user/role_authority/revoke_all_by_role_id_and_page_component_authority_list', '/API/USER/ROLE_AUTHORITY/REVOKE_ALL_BY_ROLE_ID_AND_PAGE_COMPONENT_AUTHORITY_LIST', 13, 0, '', '2018-06-20 15:08:27', '2018-06-20 15:08:27');
INSERT INTO `api` VALUES (51, '指定角色权限 id ，获取角色权限信息', '/api/user/role_authority/one', '/API/USER/ROLE_AUTHORITY/ONE', 13, 0, '', '2018-06-20 15:08:44', '2018-06-20 15:08:44');
INSERT INTO `api` VALUES (52, '指定角色 id、权限（authority）判断是否已授权', '/api/user/role_authority/is_granted_by_role_id_and_authority', '/API/USER/ROLE_AUTHORITY/IS_GRANTED_BY_ROLE_ID_AND_AUTHORITY', 13, 0, '', '2018-06-20 15:10:50', '2018-06-20 15:10:50');
INSERT INTO `api` VALUES (53, '分页获取所有角色', '/api/user/role/page_all', '/API/USER/ROLE/PAGE_ALL', 14, 0, '', '2018-06-20 15:12:12', '2018-06-20 15:12:12');
INSERT INTO `api` VALUES (54, '获取所有角色', '/api/user/role/list_all', '/API/USER/ROLE/LIST_ALL', 14, 0, '', '2018-06-20 15:12:38', '2018-06-20 15:12:38');
INSERT INTO `api` VALUES (55, '新增角色', '/api/user/role/add_one', '/API/USER/ROLE/ADD_ONE', 14, 0, '', '2018-06-20 15:12:53', '2018-06-20 15:12:53');
INSERT INTO `api` VALUES (56, '保存角色', '/api/user/role/save_one', '/API/USER/ROLE/SAVE_ONE', 14, 0, '', '2018-06-20 15:13:14', '2018-06-20 15:13:14');
INSERT INTO `api` VALUES (57, '指定角色 id ，批量删除角色', '/api/user/role/delete_all', '/API/USER/ROLE/DELETE_ALL', 14, 0, '', '2018-06-20 15:13:40', '2018-06-20 15:13:40');
INSERT INTO `api` VALUES (58, '指定角色 id ，获取角色信息', '/api/user/role/one', '/API/USER/ROLE/ONE', 14, 0, '', '2018-06-20 15:13:57', '2018-06-20 15:13:57');
INSERT INTO `api` VALUES (59, '指定用户 id ，获取用户角色', '/api/user/role/list_all_by_user_id', '/API/USER/ROLE/LIST_ALL_BY_USER_ID', 14, 0, '', '2018-06-20 15:14:27', '2018-06-20 15:14:27');
INSERT INTO `api` VALUES (60, '分页获取用户', '/api/user/page_all', '/API/USER/PAGE_ALL', 15, 0, '', '2018-06-20 15:16:24', '2018-06-20 15:16:24');
INSERT INTO `api` VALUES (61, '新增用户', '/api/user/add_one', '/API/USER/ADD_ONE', 15, 0, '', '2018-06-20 15:16:40', '2018-06-20 15:16:40');
INSERT INTO `api` VALUES (62, '保存用户', '/api/user/save_one', '/API/USER/SAVE_ONE', 15, 0, '', '2018-06-20 15:16:55', '2018-06-20 15:16:55');
INSERT INTO `api` VALUES (63, '伪删除用户', '/api/user/sign_all_gmt_deleted', '/API/USER/SIGN_ALL_GMT_DELETED', 15, 0, '', '2018-06-24 21:23:49', '2018-06-24 21:23:49');
INSERT INTO `api` VALUES (64, '撤销伪删除用户', '/api/user/unsign_all_gmt_deleted', '/API/USER/UNSIGN_ALL_GMT_DELETED', 15, 0, '', '2018-06-24 21:24:07', '2018-06-24 21:24:07');
INSERT INTO `api` VALUES (65, '指定用户 id ，批量删除用户', '/api/user/delete_all', '/API/USER/DELETE_ALL', 15, 0, '', '2018-06-24 21:24:54', '2018-06-24 21:24:54');
INSERT INTO `api` VALUES (66, '指定用户 id ，获取用户信息（除密码和角色）', '/api/user/one', '/API/USER/ONE', 15, 0, '', '2018-06-24 21:25:22', '2018-06-24 21:25:22');
INSERT INTO `api` VALUES (67, '分页获取所有用户角色', '/api/user/user_role/page_all', '/API/USER/USER_ROLE/PAGE_ALL', 16, 0, '', '2018-06-24 21:26:34', '2018-06-24 21:26:34');
INSERT INTO `api` VALUES (68, '新增用户角色', '/api/user/user_role/add_one', '/API/USER/USER_ROLE/ADD_ONE', 16, 0, '', '2018-06-24 21:26:53', '2018-06-24 21:26:53');
INSERT INTO `api` VALUES (69, '指定用户角色 id ，批量删除用户角色', '/api/user/user_role/delete_all_by_user_id_and_role_id_list', '/API/USER/USER_ROLE/DELETE_ALL_BY_USER_ID_AND_ROLE_ID_LIST', 16, 0, '', '2018-06-24 21:27:42', '2018-06-24 21:27:42');
INSERT INTO `api` VALUES (70, '指定角色 id ，分页获取所有父级视图菜单分类', '/api/user/view_menu_category/page_all_parent_by_role_id', '/API/USER/VIEW_MENU_CATEGORY/PAGE_ALL_PARENT_BY_ROLE_ID', 17, 0, '', '2018-06-24 21:30:19', '2018-06-24 21:28:38');
INSERT INTO `api` VALUES (71, '指定父级视图菜单分类 id 、角色 id ，获取所有视图菜单分类', '/api/user/view_menu_category/list_all_by_parent_id_and_role_id', '/API/USER/VIEW_MENU_CATEGORY/LIST_ALL_BY_PARENT_ID_AND_ROLE_ID', 17, 0, '', '2018-06-24 21:30:36', '2018-06-24 21:29:06');
INSERT INTO `api` VALUES (72, '新增视图菜单分类', '/api/user/view_menu_category/add_one', '/API/USER/VIEW_MENU_CATEGORY/ADD_ONE', 17, 0, '', '2018-06-24 21:30:55', '2018-06-24 21:30:55');
INSERT INTO `api` VALUES (73, '保存视图菜单分类', '/api/user/view_menu_category/save_one', '/API/USER/VIEW_MENU_CATEGORY/SAVE_ONE', 17, 0, '', '2018-06-24 21:31:10', '2018-06-24 21:31:10');
INSERT INTO `api` VALUES (74, '指定视图菜单分类 id ，批量删除视图菜单分类', '/api/user/view_menu_category/delete_all', '/API/USER/VIEW_MENU_CATEGORY/DELETE_ALL', 17, 0, '', '2018-06-24 21:31:30', '2018-06-24 21:31:30');
INSERT INTO `api` VALUES (75, '指定视图菜单分类 id ，获取视图菜单分类信息', '/api/user/view_menu_category/one', '/API/USER/VIEW_MENU_CATEGORY/ONE', 17, 0, '', '2018-06-24 21:31:52', '2018-06-24 21:31:52');
INSERT INTO `api` VALUES (76, '指定角色 id ，获取所有父级视图菜单分类', '/api/user/view_menu_category/list_all_parent_by_role_id', '/API/USER/VIEW_MENU_CATEGORY/LIST_ALL_PARENT_BY_ROLE_ID', 17, 0, '', '2018-06-24 21:32:16', '2018-06-24 21:32:16');
INSERT INTO `api` VALUES (77, '指定用户 id ，获取所有父级视图菜单分类', '/api/user/view_menu_category/list_all_parent_by_user_id', '/API/USER/VIEW_MENU_CATEGORY/LIST_ALL_PARENT_BY_USER_ID', 17, 0, '首页显示顶部菜单分类', '2018-06-29 12:09:25', '2018-06-24 21:32:36');
INSERT INTO `api` VALUES (78, '指定用户 id 、父级视图菜单分类 id ，获取所有子级视图菜单分类', '/api/user/view_menu_category/list_all_child_by_parent_id_and_user_id', '/API/USER/VIEW_MENU_CATEGORY/LIST_ALL_CHILD_BY_PARENT_ID_AND_USER_ID', 17, 0, '首页显示左侧子级菜单分类', '2018-06-29 12:09:11', '2018-06-24 21:33:19');
INSERT INTO `api` VALUES (79, '指定用户 id 、父级视图菜单分类 id ，获取所有子级视图菜单分类和视图菜单', '/api/user/view_menu_category/list_all_child_view_menu_category_and_view_menu_by_parent_id_and_user_id', '/API/USER/VIEW_MENU_CATEGORY/LIST_ALL_CHILD_VIEW_MENU_CATEGORY_AND_VIEW_MENU_BY_PARENT_ID_AND_USER_ID', 17, 0, '首页显示子级菜单分类及子级菜单', '2018-06-29 12:10:22', '2018-06-24 21:34:15');
INSERT INTO `api` VALUES (80, '获取所有菜单分类', '/api/user/view_menu_category/list_all', '/API/USER/VIEW_MENU_CATEGORY/LIST_ALL', 17, 0, '', '2018-06-24 21:35:24', '2018-06-24 21:35:24');
INSERT INTO `api` VALUES (81, '指定菜单分类名，模糊搜索获取所有菜单分类', '/api/user/view_menu_category/search_all_by_name', '/API/USER/VIEW_MENU_CATEGORY/SEARCH_ALL_BY_NAME', 17, 0, '', '2018-06-24 21:35:49', '2018-06-24 21:35:49');
INSERT INTO `api` VALUES (82, '指定视图菜单分类 id 、角色 id ，分页获取所有视图菜单', '/api/user/view_menu/page_all_by_menu_category_id_and_role_id', '/API/USER/VIEW_MENU/PAGE_ALL_BY_MENU_CATEGORY_ID_AND_ROLE_ID', 18, 0, '', '2018-06-24 21:36:50', '2018-06-24 21:36:50');
INSERT INTO `api` VALUES (83, '新增视图菜单', '/api/user/view_menu/add_one', '/API/USER/VIEW_MENU/ADD_ONE', 18, 0, '', '2018-06-24 21:37:11', '2018-06-24 21:37:11');
INSERT INTO `api` VALUES (84, '保存视图菜单', '/api/user/view_menu/save_one', '/API/USER/VIEW_MENU/SAVE_ONE', 18, 0, '', '2018-06-24 21:37:29', '2018-06-24 21:37:29');
INSERT INTO `api` VALUES (85, '指定视图菜单 id ，批量删除视图菜单', '/api/user/view_menu/delete_all', '/API/USER/VIEW_MENU/DELETE_ALL', 18, 0, '', '2018-06-24 21:37:51', '2018-06-24 21:37:51');
INSERT INTO `api` VALUES (86, '指定视图菜单 id ，获取视图菜单信息', '/api/user/view_menu/one', '/API/USER/VIEW_MENU/ONE', 18, 0, '', '2018-06-24 21:38:11', '2018-06-24 21:38:11');
INSERT INTO `api` VALUES (87, '指定菜单名，模糊搜索获取所有菜单', '/api/user/view_menu/search_all_by_name', '/API/USER/VIEW_MENU/SEARCH_ALL_BY_NAME', 18, 0, '', '2018-06-24 21:38:53', '2018-06-24 21:38:53');
