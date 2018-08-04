package com.gioov.spiny.system.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.common.mybatis.Pageable;
import com.gioov.spiny.system.entity.ApiCategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
@Mapper
@Component("apiCategoryMapper")
public interface ApiCategoryMapper extends CrudMapper<ApiCategoryEntity, Long> {

    /**
     * 分页获取所有父级 API 分类
     *
     * @param pageable
     * @return
     */
    List<ApiCategoryEntity> pageAllByParentIdIsNull(@Param("pageable") Pageable pageable);

    /**
     * 统计所有父级 API 分类
     *
     * @return
     */
    int countAllByParentIdIsNull();

    /**
     * 指定父级 API 分类 id ，获取所有 API 分类
     *
     * @param parentId
     * @return
     */
    List<ApiCategoryEntity> listAllByParentId(@Param("parentId") Long parentId);

    /**
     * 指定 API 分类 id ，批量删除 API 分类
     *
     * @param parentId
     * @return
     */
    ApiCategoryEntity getOneByParentId(@Param("parentId") Long parentId);

}
