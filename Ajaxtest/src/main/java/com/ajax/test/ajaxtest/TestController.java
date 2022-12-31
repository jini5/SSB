package com.ajax.test.ajaxtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(String name){
        System.out.println(name);
        return "OK";
    }
}
