package com.gioov.spiny.user.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.spiny.user.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
@Mapper
@Component("roleMapper")
public interface RoleMapper extends CrudMapper<RoleEntity, Long> {

    RoleEntity getOneByValue(@Param("value") String value);
}
