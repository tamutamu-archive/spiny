package com.gioov.spiny.system.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.spiny.system.entity.ViewPageApiEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author godcheese
 * @date 2018/5/22
 */
@Mapper
@Component("viewPageApiMapper")
public interface ViewPageApiMapper extends CrudMapper<ViewPageApiEntity, Long> {

    ViewPageApiEntity getOneByPageIdAndApiId(@Param("pageId") Long pageId, @Param("apiId") Long apiId);

    int insertAllByPageIdAndApiIdList(@Param("pageId") Long pageId, @Param("apiIdList") List<Long> apiIdList);

    int deleteAllByPageIdAndApiIdList(@Param("pageId") Long pageId, @Param("apiIdList") List<Long> apiIdList);

    List<ViewPageApiEntity> listAllByPageId(@Param("pageId") Long pageId);

}
