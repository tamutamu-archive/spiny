package com.gioov.spiny.user.entity;

import java.io.Serializable;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
public class RoleAuthorityEntity implements Serializable {

    private static final long serialVersionUID = 5296844533968777125L;

    /**
     * id
     */
    private Long id;

    /**
     * 角色 id
     */
    private Long roleId;

    /**
     * 权限（authority）
     */
    private String authority;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
