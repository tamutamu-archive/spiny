package com.gioov.spiny.system.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.spiny.system.entity.ViewPageComponentApiEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author godcheese
 * @date 2018/5/22
 */
@Mapper
@Component("viewPageComponentApiMapper")
public interface ViewPageComponentApiMapper extends CrudMapper<ViewPageComponentApiEntity, Long> {

    ViewPageComponentApiEntity getOneByPageComponentIdAndApiId(@Param("pageComponentId") Long pageComponentId, @Param("apiId") Long apiId);

    int insertAllByPageComponentIdAndApiIdList(@Param("pageComponentId") Long pageComponentId, @Param("apiIdList") List<Long> apiIdList);

    int deleteAllByPageComponentIdAndApiIdList(@Param("pageComponentId") Long pageComponentId, @Param("apiIdList") List<Long> apiIdList);

    List<ViewPageComponentApiEntity> listAllByPageComponentId(@Param("pageComponentId") Long pageComponentId);

}
