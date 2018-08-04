package com.gioov.spiny.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
public class RoleEntity implements Serializable {

    private static final long serialVersionUID = -4329027958748356142L;

    /**
     * id
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色值
     */
    private String value;

    /**
     * 备注
     */
    private String remark;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 创建时间
     */
    private Date gmtCreated;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

}
