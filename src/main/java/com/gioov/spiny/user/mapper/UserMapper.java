package com.gioov.spiny.user.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.spiny.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
@Mapper
@Component("userMapper")
public interface UserMapper extends CrudMapper<UserEntity, Long> {

    /**
     * 指定 username 获取用户
     *
     * @param username
     * @return
     */
    UserEntity getOneByUsername(@Param("username") String username);


    int signGmtDeleted(@Param("idList") List<Long> idList, @Param("gmtDeleted") Date gmtDeleted);

    int unsignGmtDeleted(@Param("idList") List<Long> idList);

}
