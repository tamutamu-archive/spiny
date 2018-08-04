package com.gioov.spiny.user.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.common.mybatis.Pageable;
import com.gioov.spiny.user.entity.ViewMenuCategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
@Mapper
@Component("viewMenuCategoryMapper")
public interface ViewMenuCategoryMapper extends CrudMapper<ViewMenuCategoryEntity, Long> {

    /**
     * 指定角色 id ，获取所有父级菜单分类
     *
     * @param roleId
     * @return
     */
    List<ViewMenuCategoryEntity> listAllByParentIdIsNullAndRoleId(@Param("roleId") Long roleId);

    /**
     * 指定角色 id ，获取所有父级菜单分类
     *
     * @param roleId
     * @param pageable
     * @return
     */
    List<ViewMenuCategoryEntity> pageAllByParentIdIsNullAndRoleId(@Param("roleId") Long roleId, @Param("pageable") Pageable pageable);

    Integer countAllByParentIdIsNullAndRoleId(@Param("roleId") Long roleId);

    /**
     * 指定角色 id 、父级菜单分类 id ，获取 所有父级菜单分类
     *
     * @param roleId
     * @param parentId
     * @return
     */
    List<ViewMenuCategoryEntity> listAllByParentIdAndRoleId(@Param("parentId") Long parentId, @Param("roleId") Long roleId);

    /**
     * 指定角色 id 、父级菜单分类 id ，获取 所有父级菜单分类
     *
     * @param roleId
     * @param parentId
     * @return
     */
    ViewMenuCategoryEntity getOneByParentIdAndRoleId(@Param("parentId") Long parentId, @Param("roleId") Long roleId);

    List<ViewMenuCategoryEntity> searchAllByName(@Param("name") String name);
}