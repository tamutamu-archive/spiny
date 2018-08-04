package com.gioov.spiny.system.service;

import com.gioov.spiny.user.entity.ViewMenuCategoryEntity;

import java.util.List;

/**
 * @author godcheese
 * @date 2018/4/29 22:23
 */
public interface ViewMenuCategoryService {

    List<ViewMenuCategoryEntity> listAllParentByUserId(Long userId);

    List<ViewMenuCategoryEntity> listAllChildByParentIdAndUserId(Long parentId, Long userId);
}
