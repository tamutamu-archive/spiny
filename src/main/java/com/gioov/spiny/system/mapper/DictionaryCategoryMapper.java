package com.gioov.spiny.system.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.common.mybatis.Pageable;
import com.gioov.spiny.system.entity.DictionaryCategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author godcheese
 * @date 2018/5/23
 */
@Mapper
@Component("dictionaryCategoryMapper")
public interface DictionaryCategoryMapper extends CrudMapper<DictionaryCategoryEntity, Long> {

    /**
     * 分页获取所有父级数据字典分类
     *
     * @param pageable
     * @return
     */
    List<DictionaryCategoryEntity> pageAllByParentIdIsNull(@Param("pageable") Pageable pageable);

    /**
     * 统计所有父级数据字典分类
     *
     * @return
     */
    Integer countAllByParentIdIsNull();

    /**
     * 指定父级数据字典分类 id ，获取所有数据字典分类
     *
     * @param parentId
     * @return
     */
    List<DictionaryCategoryEntity> listAllByParentId(@Param("parentId") Long parentId);

    /**
     * 指定父级数据字典分类 id ，获取数据字典分类
     *
     * @param parentId
     * @return
     */
    DictionaryCategoryEntity getOneByParentId(@Param("parentId") Long parentId);

}
