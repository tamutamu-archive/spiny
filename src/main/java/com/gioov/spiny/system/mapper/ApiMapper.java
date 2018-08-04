package com.gioov.spiny.system.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.common.mybatis.Pageable;
import com.gioov.spiny.system.entity.ApiEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
@Mapper
@Component("apiMapper")
public interface ApiMapper extends CrudMapper<ApiEntity, Long> {

    /**
     * 指定 API 分类 id ，获取 API
     *
     * @param apiCategoryId
     * @return
     */
    ApiEntity getOneByApiCategoryId(@Param("apiCategoryId") Long apiCategoryId);

    /**
     * 指定 API 分类 id ，分页获取所有 API
     *
     * @param apiCategoryId
     * @param pageable
     * @return
     */
    List<ApiEntity> pageAllByApiCategoryId(@Param("apiCategoryId") Long apiCategoryId, @Param("pageable") Pageable pageable);

    /**
     * 指定 API 分类 id ，统计所有 API
     *
     * @param apiCategoryId
     * @return
     */
    int countAllByApiCategoryId(@Param("apiCategoryId") Long apiCategoryId);


    ApiEntity getOneByAuthority(@Param("authority") String authority);

}
