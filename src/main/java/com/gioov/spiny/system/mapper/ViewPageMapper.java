package com.gioov.spiny.system.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.common.mybatis.Pageable;
import com.gioov.spiny.system.entity.ViewPageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
@Mapper
@Component("viewPageMapper")
public interface ViewPageMapper extends CrudMapper<ViewPageEntity, Long> {

    /**
     * 指定视图页面分类 id 获取视图页面分页
     *
     * @param pageCategoryId
     * @return
     */
    List<ViewPageEntity> pageAllByPageCategoryId(@Param("pageCategoryId") Long pageCategoryId, @Param("pageable") Pageable pageable);

    Integer countAllByPageCategoryId(@Param("pageCategoryId") Long pageCategoryId);

    ViewPageEntity getOneByAuthority(@Param("authority") String authority);

    /**
     * 指定视图页面分类 id 获取视图页面
     *
     * @param pageCategoryId
     * @return
     */
    List<ViewPageEntity> listAllByPageCategoryId(@Param("pageCategoryId") Long pageCategoryId);

    /**
     * 指定视图页面分类 id 获取视图页面
     *
     * @param pageCategoryId
     * @return
     */
    ViewPageEntity getOneByPageCategoryId(@Param("pageCategoryId") Long pageCategoryId);
}
