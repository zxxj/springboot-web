package com.itheima.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 代表当前类为请求处理类
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("Hello World");
        return "Hello World";
    }
}
