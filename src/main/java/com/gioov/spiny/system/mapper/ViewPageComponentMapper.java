package com.gioov.spiny.system.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.common.mybatis.Pageable;
import com.gioov.spiny.system.entity.ViewPageComponentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author godcheese
 * @date 2018-06-07
 */
@Mapper
@Component("viewPageComponentMapper")
public interface ViewPageComponentMapper extends CrudMapper<ViewPageComponentEntity, Long> {

    List<ViewPageComponentEntity> pageAllByPageId(@Param("pageId") Long pageId, @Param("pageable") Pageable pageable);

    int countAllByPageId(@Param("pageId") Long pageId);

    ViewPageComponentEntity getOneByAuthority(@Param("authority") String authority);

}
