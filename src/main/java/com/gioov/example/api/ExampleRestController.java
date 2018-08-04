package com.gioov.example.api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author godcheese
 * @date 2018/4/26 9:40
 */
@RestController
@RequestMapping("/api/example")
public class ExampleRestController {

    @RequestMapping("/test")
    public String test() {
        return "Example api test.";
    }
}
