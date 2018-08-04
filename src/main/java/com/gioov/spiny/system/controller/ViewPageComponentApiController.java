package com.gioov.spiny.system.controller;

import com.gioov.spiny.common.constant.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 * @date 2018/5/22
 */
@Controller
@RequestMapping(Page.System.VIEW_PAGE_COMPONENT_API)
public class ViewPageComponentApiController {

    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('/SYSTEM/VIEW_PAGE_COMPONENT_API/PAGE_ALL')")
    @RequestMapping("/page_all")
    public String pageAll() {
        return Page.System.VIEW_PAGE_COMPONENT_API + "/page_all";
    }
}
