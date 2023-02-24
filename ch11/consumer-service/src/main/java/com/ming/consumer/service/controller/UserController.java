package com.ming.consumer.service.controller;

import com.ming.ch11.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 贺春明
 * @date 2023/2/21
 */

@RestController
public class UserController {

    @DubboReference(interfaceClass = UserService.class, version = "1.0",check = false)
    private UserService userService;

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") String id){
        return userService.getUser(id);
    }
}
