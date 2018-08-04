package com.gioov.spiny.system.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.spiny.system.entity.EmailEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
@Mapper
@Component("emailMapper")
public interface EmailMapper extends CrudMapper<EmailEntity, Long> {

}
