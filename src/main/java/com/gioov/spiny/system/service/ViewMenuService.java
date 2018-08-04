package com.gioov.spiny.system.service;

import com.gioov.spiny.user.entity.ViewMenuEntity;

import java.util.List;

/**
 * @author godcheese
 * @date 2018/4/30 11:25
 */
public interface ViewMenuService {

    /**
     * 指定 userId、menuCategoryId 获取 视图菜单
     *
     * @param userId
     * @param menuCategoryId
     * @return
     */
    List<ViewMenuEntity> listAllByUserIdAndMenuCategoryId(Long userId, Long menuCategoryId);

}
