package com.gioov.spiny.system.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
public class ApiEntity implements Serializable {

    private static final long serialVersionUID = 8660849906632003284L;

    /**
     * id
     */
    private Long id;

    /**
     * api 名称
     */
    private String name;

    /**
     * 请求地址（url）
     */
    private String url;

    /**
     * 权限（authority）
     */
    private String authority;

    /**
     * API 分类 id
     */
    private Long apiCategoryId;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Long getApiCategoryId() {
        return apiCategoryId;
    }

    public void setApiCategoryId(Long apiCategoryId) {
        this.apiCategoryId = apiCategoryId;
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
