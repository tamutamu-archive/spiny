package com.gioov.spiny.user.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.common.mybatis.Pageable;
import com.gioov.spiny.user.entity.ViewMenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
@Mapper
@Component("viewMenuMapper")
public interface ViewMenuMapper extends CrudMapper<ViewMenuEntity, Long> {

    List<ViewMenuEntity> listAllByMenuCategoryIdAndRoleId(@Param("menuCategoryId") Long menuCategoryId, @Param("roleId") Long roleId);

    ViewMenuEntity getOneByMenuCategoryIdAndRoleId(@Param("menuCategoryId") Long menuCategoryId, @Param("roleId") Long roleId);

    /**
     * 指定分类 id 和角色 id 分页获取视图菜单
     *
     * @param menuCategoryId
     * @param roleId
     * @param pageable
     * @return
     */
    List<ViewMenuEntity> pageAllByMenuCategoryIdAndRoleId(@Param("menuCategoryId") Long menuCategoryId, @Param("roleId") Long roleId, @Param("pageable") Pageable pageable);

    Integer countAllByMenuCategoryIdAndRoleId(@Param("menuCategoryId") Long menuCategoryId, @Param("roleId") Long roleId);

    List<ViewMenuEntity> searchAllByName(@Param("name") String name);

}
