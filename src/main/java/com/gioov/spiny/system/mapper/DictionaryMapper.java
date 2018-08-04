package com.gioov.spiny.system.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.common.mybatis.Pageable;
import com.gioov.spiny.system.entity.DictionaryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author godcheese
 * @date 2018/4/23 20:44
 */
@Mapper
@Component("dictionaryMapper")
public interface DictionaryMapper extends CrudMapper<DictionaryEntity, Long> {

    /**
     * 指定父级数据字典分类 id ，获取数据字典
     *
     * @param dictionaryCategoryId
     * @return
     */
    DictionaryEntity getOneByDictionaryCategoryId(@Param("dictionaryCategoryId") Long dictionaryCategoryId);

    List<DictionaryEntity> pageAllByDictionaryCategoryId(@Param("dictionaryCategoryId") Long dictionaryCategoryId, @Param("pageable") Pageable pageable);

    int countAllByDictionaryCategoryId(@Param("dictionaryCategoryId") Long dictionaryCategoryId);

    DictionaryEntity getOneByKeyAndValueSlug(@Param("key") String key, @Param("valueSlug") String valueSlug);

    List<DictionaryEntity> listAllByKey(@Param("key") String key);

}
