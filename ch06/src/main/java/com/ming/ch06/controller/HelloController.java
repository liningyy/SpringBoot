package com.ming.ch06.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 贺春明
 * @date 2023/2/16
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String obj(){
        return "hello world";
    }
}
