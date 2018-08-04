package com.gioov.spiny.user.service;

import com.gioov.spiny.user.entity.RoleEntity;
import com.gioov.spiny.user.entity.UserRoleEntity;

import java.util.List;

/**
 * @author godcheese
 * @date 2018/4/29 22:33
 */
public interface RoleService {

    List<RoleEntity> listAllByUserRole(List<UserRoleEntity> userRoleEntityList);

}
