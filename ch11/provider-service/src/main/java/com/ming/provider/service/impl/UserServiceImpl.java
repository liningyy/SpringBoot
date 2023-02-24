package com.ming.provider.service.impl;

import com.ming.ch11.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author 贺春明
 * @date 2023/2/21
 */


@DubboService(interfaceClass = UserService.class, version = "1.0")
public class UserServiceImpl implements UserService {

    @Override
    public String getUser(String id) {
        return id + "\tuser1";
    }
}
