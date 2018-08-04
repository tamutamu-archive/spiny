package com.gioov.spiny.system.controller;

import com.gioov.spiny.common.constant.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author godcheese
 * @date 2018/5/18
 */
@Controller
@RequestMapping(Page.System.API_CATEGORY)
public class ApiCategoryController {

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/add_dialog")
    public String addDialog() {
        return Page.System.API_CATEGORY + "/add_dialog";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/edit_dialog")
    public String editDialog() {
        return Page.System.API_CATEGORY + "/edit_dialog";
    }

}
