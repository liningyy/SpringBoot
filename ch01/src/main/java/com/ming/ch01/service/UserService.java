package com.ming.ch01.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author 贺春明
 * @date 2023/2/10
 */

// @Service
public class UserService {

    private final static Logger log = LoggerFactory.getLogger(UserService.class);

    public void say(){
        log.info("Hello world!");
    }
}
