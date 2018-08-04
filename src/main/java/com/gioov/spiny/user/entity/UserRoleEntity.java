package com.gioov.spiny.user.entity;

import java.io.Serializable;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
public class UserRoleEntity implements Serializable {

    private static final long serialVersionUID = 1220108645281958623L;

    /**
     * id
     */
    private Long id;

    /**
     * 用户 id
     */
    private Long userId;

    /**
     * 角色 id
     */
    private Long roleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}
