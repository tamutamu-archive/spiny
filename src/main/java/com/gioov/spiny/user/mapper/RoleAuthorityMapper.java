package com.gioov.spiny.user.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.spiny.user.entity.RoleAuthorityEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
@Mapper
@Component("roleAuthorityMapper")
public interface RoleAuthorityMapper extends CrudMapper<RoleAuthorityEntity, Long> {

    List<RoleAuthorityEntity> listAllByRoleId(@Param("roleId") Long roleId);

    RoleAuthorityEntity getOneByRoleIdAndAuthority(@Param("roleId") Long roleId, @Param("authority") String authority);

    int deleteAllByRoleIdAndAuthorityList(@Param("roleId") Long roleId, @Param("authorityList") List<String> authorityList);

    int insertAllByRoleIdAndAuthorityList(@Param("roleId") Long roleId, @Param("authorityList") List<String> authorityList);

}
