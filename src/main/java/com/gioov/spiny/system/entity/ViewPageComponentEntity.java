package com.gioov.spiny.system.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
public class ViewPageComponentEntity implements Serializable {

    private static final long serialVersionUID = 2025976380871249876L;

    /**
     * id
     */
    private Long id;

    /**
     * 组件分类 id
     */
    private Long pageComponentType;

    /**
     * 组件名称
     */
    private String name;

    /**
     * 权限（authority）
     */
    private String authority;

    /**
     * 视图页面 id
     */
    private Long pageId;

    /**
     * 排序
     */
    private Long sort;

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

    public Long getPageComponentType() {
        return pageComponentType;
    }

    public void setPageComponentType(Long pageComponentType) {
        this.pageComponentType = pageComponentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
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
