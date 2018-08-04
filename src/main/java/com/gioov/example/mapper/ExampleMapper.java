package com.gioov.example.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.example.entity.ExampleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
@Mapper
@Component("exampleMapper")
public interface ExampleMapper extends CrudMapper<ExampleEntity, Long> {

}
