package com.gioov.spiny.user.service;

/**
 * @author godcheese@outlook.com
 * @date 2018/2/6 20:00
 */
public interface RolePermissionService {

    Integer insertAll(Long roleId, Long[] permissionIds);

}
