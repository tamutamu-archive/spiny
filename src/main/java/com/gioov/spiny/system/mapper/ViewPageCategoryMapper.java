package com.gioov.spiny.system.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.common.mybatis.Pageable;
import com.gioov.spiny.system.entity.ViewPageCategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
@Mapper
@Component("viewPageCategoryMapper")
public interface ViewPageCategoryMapper extends CrudMapper<ViewPageCategoryEntity, Long> {

    /**
     * 分页获取所有父级分类
     *
     * @return
     */
    List<ViewPageCategoryEntity> pageAllByParentIdIsNull(@Param("pageable") Pageable pageable);

    Integer countAllByParentIdIsNull();

    List<ViewPageCategoryEntity> listAllByParentId(@Param("id") Long id);

    ViewPageCategoryEntity getOneByParentId(@Param("id") Long id);
}
