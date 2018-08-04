package com.gioov.spiny.user.mapper;

import com.gioov.spiny.user.entity.UserPasswordResetEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
@Mapper
@Component("userPasswordResetMapper")
public interface UserPasswordResetMapper {

    int insertOne(UserPasswordResetEntity userPasswordResetEntity);

    int updateOne(UserPasswordResetEntity userPasswordResetEntity);

    int deleteOne(@Param("id") Long id);

    UserPasswordResetEntity getOne(@Param("id") Long id);

    List<UserPasswordResetEntity> listAll();
}
