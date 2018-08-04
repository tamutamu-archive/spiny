package com.gioov.spiny.user.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.spiny.user.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
@Mapper
@Component("userRoleMapper")
public interface UserRoleMapper extends CrudMapper<UserRoleEntity, Long> {

    List<UserRoleEntity> listAllByUserId(@Param("userId") Long userId);

    UserRoleEntity getOneByRoleId(@Param("roleId") Long roleId);

    int deleteAllByUserIdAndRoleIdList(@Param("userId") Long userId, @Param("roleIdList") List<Long> roleIdList);

    UserRoleEntity getOneByUserIdAndRoleId(@Param("userId") Long userId, @Param("roleId") Long roleId);


}
