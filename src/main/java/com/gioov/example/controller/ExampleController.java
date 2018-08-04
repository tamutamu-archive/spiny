package com.gioov.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author godcheese
 */
@Controller
@RequestMapping("/example")
public class ExampleController {

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/test")
    public String pageAll() {
        return "/example/test";
    }
}
